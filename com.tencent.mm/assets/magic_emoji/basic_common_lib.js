; var WeixinJSCore = {
};

NativeGlobal.findElementById = undefined;
requestAnimationFrame = NativeGlobal.requestAnimationFrame;
cancelAnimationFrame = NativeGlobal.cancelAnimationFrame;
NativeGlobal.BindingObject = NativeGlobal.Watcher;
WeixinJSCore.invokeHandler = NativeGlobal.invokeHandler;

NativeGlobal.Canvas = function () {
  return new NativeGlobal.AutoScreenCanvas();
}

// NativeGlobal.Image = function() {
//     return new NativeGlobal.Image();
// }

// let onbindingobjectdestruct;
// let EventHandler = NativeGlobal.EventHandler;
// Object.defineProperty(NativeGlobal.EventHandler, 'onbindingobjectdestruct', {
//     get: () => { return onbindingobjectdestruct },
//     set: (l) => {
//         if (!!onbindingobjectdestruct) {
//             EventHandler.removeEventListener('watcherdestruct', onbindingobjectdestruct);
//         }
//         if (!!l) {
//             EventHandler.addEventListener('watcherdestruct', l);
//             onbindingobjectdestruct = l;
//         }
//     }
// });

// timer related



let performanceNow = NativeGlobal.performanceNow;
NativeGlobal.performanceNow = function () {
  // return performanceNow() / 1000;
  return performanceNow();
};

GameGlobal = this;
window = this;
GameGlobal.__needInjectWeAppAdapter = true;

// require/define

var f = function (global) {
  var MODULE_STATUS_UNLOAD = 1;
  var MODULE_STATUS_LOADED = 2;

  // "modId" : { status: MODULE_STATUS_UNLOAD | MODULE_STATUS_LOADED, factory: func | object, exports: module.exports }
  var MODULES = {};
  var notCacheScripts = {};

  var backupGlobalFlags = function () {
    return {
      __wxRoute: global.__wxRoute,
      __wxAppCurrentFile__: global.__wxAppCurrentFile__,
      __wxRouteBegin: global.__wxRouteBegin,
    };
  }
  var restoreGlobalFlags = function (globalFlags) {
    global.__wxRoute = globalFlags.__wxRoute
    global.__wxAppCurrentFile__ = globalFlags.__wxAppCurrentFile__
    global.__wxRouteBegin = globalFlags.__wxRouteBegin
  };

  //modId 为绝对路径
  //factory = function(require, module) 模块暴漏接口可以通过module.exports 或者 return
  define = function (modId, factory) {
    MODULES[modId] = {
      status: MODULE_STATUS_UNLOAD,
      factory: factory
    };
  };

  var getModDir = function (modId) {
    var match = modId.match(/(.*)\/([^/]+)?$/);
    return !match || !match[1] ? './' : match[1];
  }

  var getSubPackageConfig = function (dir) {
    if (!dir) {
      return undefined;
    }

    if (__wxConfig.subPackages) {
      for (var i = 0, len = __wxConfig.subPackages.length; i < len; i++) {
        if (dir.indexOf(__wxConfig.subPackages[i].root) === 0) {
          return __wxConfig.subPackages[i];
        }
      }
    }

    return undefined;
  }

  var splitPath = function (path) {
    var realPath = [],
      paths = path.split('/');

    for (var i = 0, len = paths.length; i < len; ++i) {
      // 转换目录路径
      var pathItem = paths[i];
      if (pathItem == '' || pathItem == '.') {
        continue;
      }
      if (pathItem == '..') {
        if (realPath.length == 0) {
          realPath = null;
          break;
        }
        realPath.pop();
      } else if (i + 1 < len && paths[i + 1] == '..') {
        i++;
      } else {
        realPath.push(pathItem);
      }
    }

    return realPath;
  }

  var checkNodeModulesFile = function (dirPath) {
    var requirePath = splitPath(dirPath + '/index.js').join('/');
    if (MODULES[requirePath]) return requirePath;

    requirePath = splitPath(dirPath).join('/');
    if (!/\.js$/.test(requirePath)) requirePath += '.js';
    if (MODULES[requirePath]) return requirePath;

    return '';
  }

  var checkNodeModules = function (modId, modDir, requireId) {
    var id = modId;
    if (!/\.js$/.test(id)) id += '.js';

    // 包内文件
    if (typeof id === 'string' && MODULES[id]) return id;

    // 从 node_modules 里检查
    var realDirpath = splitPath(modDir);
    if (!realDirpath) throw new Error('can\'t find module : ' + requireId);

    var modRelativePath = modId.substring(realDirpath.join('/').length),
      requirePath;

    while (realDirpath.length) {
      // 非根目录
      var dirPath = realDirpath.join('/') + '/miniprogram_npm' + modRelativePath;

      requirePath = checkNodeModulesFile(dirPath);
      if (requirePath) break;

      realDirpath.pop();
    }

    if (!requirePath) {
      // 根目录
      modRelativePath = modRelativePath[0] === '/' ? modRelativePath : '/' + modRelativePath;
      var dirPath = 'miniprogram_npm' + modRelativePath;

      requirePath = checkNodeModulesFile(dirPath);
    }

    return requirePath ? requirePath : modId;
  }

  var _require = function (modId) {
    var modDir = getModDir(modId);
    return function (requireId) {
      // modId
      if (typeof requireId !== 'string') {
        throw new Error('require args must be a string');
      }

      var realFilepath = splitPath(modDir + '/' + requireId);
      if (requireId === '/__wx__/private-api') realFilepath = splitPath(requireId);
      if (!realFilepath) throw new Error('can\'t find module : ' + requireId);

      try {
        var id = realFilepath.join('/');
        id = checkNodeModules(id, modDir, requireId);

        // 功能页后续分包加载，functional-pages（功能页函数）文件夹放入分包，文件夹内外
        // 不能互相 require。功能页改分包前先检查，如果有错误 require 报错并上报，功能
        // 页切分包之后去掉
        var inFunctionalPage = function (id) {
          return splitPath(id)[0] === 'functional-pages';
        };
        if (inFunctionalPage(id) !== inFunctionalPage(modId)) {
          Reporter.thirdErrorReport({
            error: new Error('should not require across "functional-pages" folder'),
            extend: 'at require("' + requireId + '") in ' + modId
          });
        };
        // 功能页 require 检查 end

        // 在这里判断是否允许 require
        if (__wxConfig.platform === 'devtools' && __wxConfig.subPackages) {
          var distConfig = getSubPackageConfig(id);
          var srcConfig = getSubPackageConfig(modId);

          // 需 require 的模块在分包中，且与本文件不是同一个分包，或者本文件在主包，被 require 的文件在分包中
          if (distConfig &&
            distConfig !== srcConfig) {
            throw new Error('should not require ' + requireId + ' in ' + modId + ' because they are in diffrent subPackages');
          }
        }
        return require(id);
      } catch (e) {
        // throw new Error("Error, realFilepath = " + realFilepath.join("/") + ", modId = " + modId + ", requireId = " + requireId)
        /*
        console.error("Error, modId = " + modId + ", requireId = " + requireId)
        console.error(e)
        */
        throw e;
      }
    }
  }

  // modId 为绝对路径
  require = function (modId, cache) {
    if (typeof cache === 'undefined') {
      cache = true;
    }

    if (typeof modId !== 'string') {
      throw new Error('require args must be a string');
    }
    var mod = MODULES[modId];
    if (!mod) {
      // 尝试 require 根目录的 npm 包
      var rootModId = modId.indexOf('/') === -1 ? modId + '/index.js' : modId;
      rootModId = 'miniprogram_npm/' + rootModId;
      if (!/\.js$/.test(rootModId)) rootModId += '.js';
      mod = MODULES[rootModId];
    }
    if (!modId.endsWith('.js')) modId += '.js';
    if (!mod) {
      // 尝试是否未加载的自定义组件 js
      var compFile = '/' + modId.substr(0, modId.length - 3) + '.appservice.js';
      var globalFlags = backupGlobalFlags();
      __subContextEngine__.loadJsFiles([compFile]);
      restoreGlobalFlags(globalFlags);
      mod = MODULES[modId];
    }
    if (!mod) {
      throw new Error('module "' + modId + '" is not defined');
    }

    var module = { exports: {} }; // module.exports
    var factory = mod.factory;

    if (!cache || notCacheScripts[modId]) {
      delete mod.exports;
      mod.status = MODULE_STATUS_UNLOAD;
      notCacheScripts[modId] = true;

      factory && factory(_require(modId), module, module.exports);
      return module.exports;
    }

    if (mod.status === MODULE_STATUS_UNLOAD) {
      mod.exports = module.exports;
      mod.status = MODULE_STATUS_LOADED;

      var ret = undefined;
      try {
        factory && (ret = factory(_require(modId), module, module.exports));
      } catch (e) {
        mod.status = MODULE_STATUS_UNLOAD;
        throw e;
      }

      mod.exports = module.exports !== undefined ? module.exports : ret;
    }

    // else if (mod.status == MODULE_STATUS_LOADED)
    return mod.exports;
  }

  requireOnce = function (modId) {
    return require(modId, false);
  }

  global.__modules__ = MODULES;// 用于上报
}

f(this);


var requireMiniProgramFile = require;
var defineMiniProgramFile = define;


this.require = require;
this.define = define;


// WeixinJSBridge

(function (global) {
  if (global.WeixinJSBridge) return;

  // devtools 跳过
  if (global.navigator && global.navigator.userAgent) {
    var userAgent = global.navigator.userAgent;
    if (userAgent.indexOf('appservice') > -1 || userAgent.indexOf('wechatdevtools') > -1) {
      return;
    }
  }

  var isWebView = global.hasOwnProperty('document');
  var isIosWebView = false;

  var invokeCallbacks = {};
  var invokeCallbackId = 0;

  var onCallbacks = {};

  var customEventPrefix = 'custom_event_';
  var subscribeCallbacks = {};

  if (isWebView) {
    var userAgent = global.navigator.userAgent;
    var isAndroidWebView = userAgent.indexOf('Android') != -1;
    isIosWebView = !isAndroidWebView;
  }

  var _invokeHandler = function (event, paramsString, callbackId) {
    if (isIosWebView) {
      global.webkit.messageHandlers.invokeHandler.postMessage({
        event: event,
        paramsString: paramsString,
        callbackId: callbackId,
      });
      return "";
    } else {
      var result = WeixinJSCore.invokeHandler(event, paramsString, callbackId);
      if (typeof result === 'string' && result !== '') {
        // sync functions
        try {
          result = JSON.parse(result);
        } catch (e) {
          result = {};
        }
      }
      return result;
    }
  }

  var invoke = function (event, params, callback = null) {
    var paramsString = JSON.stringify(WeixinNativeBuffer.pack(params) || {});
    var callbackId = ++invokeCallbackId;
    if (typeof callback === 'function') {
      // console.log('hy: async jsapi ' + callbackId + event);
      invokeCallbacks[callbackId] = callback;
    }
    return _invokeHandler(event, paramsString, callbackId);
  }

  var invokeCallbackHandler = function (callbackId, result) {
    result = WeixinNativeBuffer.unpack(result);
    var callback = invokeCallbacks[callbackId];
    if (typeof callback == 'function') {
      // console.log('hy: invoke callback handler: true');
      try {
        callback(result);
      } catch (e) {
        console.warn('hy: callback invoke handler failed!' + e.stack)
      }
      // console.log('hy: invoke callback handler: true 1')
    }
    delete invokeCallbacks[callbackId];
  }

  var on = function (event, callback) {
    console.log('hy: test rigister on ', event)
    onCallbacks[event] = callback;
  }

  var subscribe = function (event, callback) {
    subscribeCallbacks[customEventPrefix + event] = callback;
  }

  var subscribeHandler = function (event, result, webviewId, ext) {
    console.log('hy: on subscribe event: ', event, JSON.stringify(result))
    result = WeixinNativeBuffer.unpack(result)

    var callback;
    if (event.indexOf(customEventPrefix) != -1) {
      callback = subscribeCallbacks[event];
    } else {
      callback = onCallbacks[event];
    }
    if (typeof callback == 'function') {
      callback(result, webviewId, ext);
    }
  }

  const invokeSync = (apiName, args) => {
    let ret
    let errMsg

    if (!args) {
      args = {}
    }
    WeixinJSBridge.invoke(apiName, args, res => {
      if (res && res.errMsg) {
        const isFail = res.errMsg.indexOf(`${apiName}:fail`) === 0

        if (isFail) {
          errMsg = res.errMsg
        } else {
          ret = res
        }
      }
    })

    if (errMsg) {
      throw new Error(errMsg)
    }

    if (ret) {
      return ret
    }
  }

  const invokeAsync = (apiName, args, callback) => {
    if (!args) {
      args = {}
    }

    var cb = function (res) {
      if (callback) {
        if (res && res.errMsg) {
          const isFail = res.errMsg.indexOf(`${apiName}:fail`) === 0

          if (isFail) {
            callback.fail(res.errMsg)
          } else {
            callback.success(res)
          }
        } else {
          // ???
          callback.fail(res)
        }
      }
    }

    WeixinJSBridge.invoke(apiName, args, cb);
  }

  global.WeixinJSBridge = {
    invoke: invoke,
    invokeCallbackHandler: invokeCallbackHandler,
    on: on,
    subscribe: subscribe,
    subscribeHandler: subscribeHandler,
  };

  global.invokeSync = invokeSync;
  global.invokeAsync = invokeAsync;

  global.console = {
    log: (...args) => {
      var msgObj = {
        level: 'info',
        content: args.toString()
      }
      invoke('systemLog', msgObj)
    },
    warn: (...args) => {
      var msgObj = {
        level: 'warn',
        content: args.toString()
      }
      invoke('systemLog', msgObj)
    },
    error: (...args) => {
      var msgObj = {
        level: 'error',
        content: args.toString()
      }
      invoke('systemLog', msgObj)
    },
  };

})(this);

// native buffer
/* eslint-disable */
var NativeBuffer = (function (global) {

  // iOS 下注入 WeixinNativeBuffer，Android 下注入 getNativeBufferId，setNativeBuffer，getNativeBuffer；
  var _WeixinNativeBuffer = global.WeixinNativeBuffer
  var _getNativeBufferId = global.getNativeBufferId
  var _setNativeBuffer = global.setNativeBuffer
  var _getNativeBuffer = global.getNativeBuffer

  var config = __wxConfig || {}
  var support = false

  // Windows 和 Android 支持的一样
  if (config.platform === 'android' || config.platform === 'windows') {
    support = (typeof _getNativeBufferId === 'function' &&
      typeof _setNativeBuffer === 'function' &&
      typeof _getNativeBuffer === 'function' && config.nativeBufferEnabled)
  } else if (config.platform === 'ios' || config.platform === 'mac') {
    support = _WeixinNativeBuffer != null
  }

  var __new = function (buffer) {
    /**
     * 游戏独立 Context 的情况下，__proto__ 不是当前域的 prototype，
     * 客户端会识别失败，这里强制 hack 下
     */
    var oldProto = buffer.__proto__
    buffer.__proto__ = ArrayBuffer.prototype

    var bufferId = -1

    if (_WeixinNativeBuffer) {
      // iOS
      bufferId = _WeixinNativeBuffer.new(buffer)
    } else if (typeof _getNativeBufferId === 'function' && typeof _setNativeBuffer === 'function') {
      // Android
      bufferId = _getNativeBufferId()
      _setNativeBuffer(bufferId, buffer)
    }

    buffer.__proto__ = oldProto
    return bufferId
  }

  var __get = function (bufferId) {
    if (_WeixinNativeBuffer) {
      return _WeixinNativeBuffer.get(bufferId)
    }
    if (typeof _getNativeBuffer === 'function') {
      return _getNativeBuffer(bufferId)
    }
  }

  // only for iOS, 开启兼容传输方案开关
  var useCompatibleMode = function (enable) {
    if (_WeixinNativeBuffer) {
      _WeixinNativeBuffer.useCompatibleMode(enable)
    }
  }

  var _new = function (buffer) {
    var ret = {}
    if (support) {
      ret.id = __new(buffer)
    } else {
      ret.base64 = arrayBufferToBase64(buffer)
    }
    return ret
  }

  var _get = function (bufferObj) {
    if (bufferObj == null) {
      return
    }
    if (support && typeof bufferObj.id !== 'undefined') {
      return __get(bufferObj.id)
    } else if (typeof bufferObj.base64 !== 'undefined') {
      return base64ToArrayBuffer(bufferObj.base64)
    }
  }

  // src: https://github.com/davidchambers/Base64.js/blob/master/base64.js
  var chars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/='
  var btoa = btoa || function (input) {
    var str = String(input)
    var output = ''
    for (
      var block, charCode, idx = 0, map = chars;
      str.charAt(idx | 0) || (map = '=', idx % 1);
      output += map.charAt(63 & block >> 8 - idx % 1 * 8)
    ) {
      charCode = str.charCodeAt(idx += 3 / 4)
      if (charCode > 0xFF) {
        throw new Error('"btoa" failed')
      }
      block = block << 8 | charCode
    }
    return output
  }

  var atob = atob || function (input) {
    var str = String(input).replace(/=+$/, '')
    var output = ''
    if (str.length % 4 === 1) {
      throw new Error('"atob" failed')
    }
    for (
      var bc = 0, bs, buffer, idx = 0;
      buffer = str.charAt(idx++);
      ~buffer && (bs = bc % 4 ? bs * 64 + buffer : buffer, bc++ % 4) ?
        output += String.fromCharCode(255 & bs >> (-2 * bc & 6)) : 0
    ) {
      buffer = chars.indexOf(buffer)
    }
    return output
  }

  var arrayBufferToBase64 = function (buffer) {
    var binaryString = ''
    var bytes = new Uint8Array(buffer)
    var len = bytes.byteLength
    for (var i = 0; i < len; i++) {
      binaryString += String.fromCharCode(bytes[i])
    }
    return btoa(binaryString)
  }

  var base64ToArrayBuffer = function (base64) {
    var binaryString = atob(base64)
    var len = binaryString.length
    var bytes = new Uint8Array(len)
    for (var i = 0; i < len; i++) {
      bytes[i] = binaryString.charCodeAt(i)
    }
    return bytes.buffer
  }

  var pack = function (params) {
    if (params == null) {
      return params
    }
    var nativeBuffers = []

    for (var key in params) {
      var value = params[key]
      if (typeof value !== 'undefined' && _getDataType(value) === 'ArrayBuffer' && typeof value.byteLength !== 'undefined') {
        var buffer = _new(value)
        buffer.key = key
        nativeBuffers.push(buffer)
      }
    }

    if (nativeBuffers.length > 0) {
      for (var i = 0; i < nativeBuffers.length; i++) {
        var buffer = nativeBuffers[i]
        delete params[buffer.key]
      }
      params.__nativeBuffers__ = nativeBuffers
    }

    return params
  }

  var unpack = function (params) {
    if (params == null || params.__nativeBuffers__ == null) {
      return params
    }

    var nativeBuffers = params.__nativeBuffers__
    delete params.__nativeBuffers__

    for (var i = 0; i < nativeBuffers.length; i++) {
      var buffer = nativeBuffers[i]
      if (buffer == null) continue;

      var arrayBuffer = _get(buffer)
      if (typeof arrayBuffer !== 'undefined' && _getDataType(arrayBuffer) === 'ArrayBuffer') {
        params[buffer.key] = arrayBuffer
      }
    }

    return params
  }

  var _getDataType = function (data) {
    return Object.prototype.toString.call(data).split(' ')[1].split(']')[0]
  }

  delete global.WeixinNativeBuffer
  delete global.getNativeBufferId
  delete global.setNativeBuffer
  delete global.getNativeBuffer

  return {
    new: _new,
    get: _get,
    useCompatibleMode: useCompatibleMode,
    pack: pack,
    unpack: unpack
  }
})(this);

var WeixinNativeBuffer = NativeBuffer
NativeBuffer = null

// native buffer done

// WebAssembly

var WebAssembly_Global = function () {
  return this;
}();

var wasm = {};

if (typeof NativeGlobal.WebAssembly !== 'undefined') {
  wasm = NativeGlobal.WebAssembly;
} else if (typeof WebAssembly_Global.WebAssembly !== 'undefined') {
  wasm = WebAssembly_Global.WebAssembly;
}

var WebAssembly = {
  Table: wasm.Table,
  Memory: wasm.Memory,
  Global: wasm.Global,
  Instance: wasm.Instance,
  instantiate: function instantiate(file, imports) {
    if (typeof file !== 'string') {
      return Promise.reject(new Error('WebAssembly.instantiate: first argument must be a string'));
    } else if (/^(wxfile|https?):/.test(file)) {
      return Promise.reject(new Error('WebAssembly.instantiate: not support wxfile: or http: path'));
    } else if (!/\.wasm(\.br)?$/.test(file)) {
      return Promise.reject(new Error('WebAssembly.instantiate: only support file type .wasm or .wasm.br'));
    }
    return wasm.instantiate(file, imports);
  }
};
WebAssembly_Global.WXWebAssembly = WebAssembly;
var _WebAssembly = wasm;

// Web Assembly done


var wx = {};