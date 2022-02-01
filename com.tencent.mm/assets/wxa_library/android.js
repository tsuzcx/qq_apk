;if (this.setTimeout && this.clearTimeout && this.setInterval && this.clearInterval && this.NativeGlobal) {
    this.NativeGlobal.setTimeout = this.setTimeout;
    this.NativeGlobal.clearTimeout = this.clearTimeout;
    this.NativeGlobal.setInterval = this.setInterval;
    this.NativeGlobal.clearInterval = this.clearInterval;
};

var WeixinJSCore = (function(global) {
    var _WeixinJSCore = global.WeixinJSCore
    if (!_WeixinJSCore) {
        return undefined;
    }

    var __invokeHandler__ = _WeixinJSCore.invokeHandler
    var __invokeHandler2__ = _WeixinJSCore.invokeHandler2
    if (global.NativeGlobal && global.NativeGlobal.invokeHandler) {
        __invokeHandler2__ = global.NativeGlobal.invokeHandler
    } else if (global.workerInvokeJsApi) {
        __invokeHandler2__ = global.workerInvokeJsApi
    }

    var ret = {};
    ret.publishHandler = function(event, data, dst) {
        _WeixinJSCore.publishHandler(event, data, dst)
    }

    ret.invokeHandler = function(api, args, callbackId, privateArgs) {
        if (__invokeHandler2__) {
            privateArgs = privateArgs || ""
            if (typeof privateArgs !== 'string') {
                privateArgs = JSON.stringify(privateArgs)
            }
            return __invokeHandler2__(api, args, callbackId, privateArgs)
        } else {
            return __invokeHandler__(api, args, callbackId)
        }
    }
    if (global.workerInvokeJsApi) {
        global.workerInvokeJsApi = ret.invokeHandler
    }

    return ret
})(this);

var WeixinJSCoreAndroid = (function(global) {
    if (typeof global.WeixinJSCoreAndroid !== 'undefined') {
        return global.WeixinJSCoreAndroid
    }

    var ret = {};
    ret.invokeCallbackHandler = function(callbackId, data) {
        if (typeof WeixinJSBridge !== 'undefined') {
            if (typeof data === 'string') {
                try {
                    data = JSON.parse(data)
                } catch (e) {
                    console.e('hy: fail not compatible data' + data)
                }
            }
//            console.log('invokeCallbackHandler ' + JSON.stringify(data))
            WeixinJSBridge.invokeCallbackHandler(callbackId, data);
        } else {
            console.error('WeixinJSCoreAndroid::invokeCallbackHandler, WeixinJSBridge==undefined, callbackId==' + callbackId)
        }
    };
    ret.subscribeHandler = function(event, data, src, ext) {
        if ('__native_custom_event__wxConfig_inject' === event) {
            data = JSON.parse(data)
//            global.__wxIndexPage = data.__wxIndexPage
//            delete data.__wxIndexPage
            if (typeof global.__wxConfig === 'undefined') {
                global.__wxConfig = {}
            }
            if (global.NativeGlobal !== undefined) {
                global.NativeGlobal.hasInitializedWxConfig = true;
            }
            Object.assign(global.__wxConfig, data)
            return
        }

        if (typeof WeixinJSBridge !== 'undefined') {
//            console.log('subscribeHandler event:' + (typeof event) + ":" + event + ", data:" + (typeof data) + ":" + data + ", src:" + (typeof src) + ":" + src + ", ext:" + (typeof ext) + ":" + ext)

            if (typeof data === 'string' && data.length > 0) {
                try {
                    data = JSON.parse(data)
                } catch(e) {}
            }
            if (typeof src === 'string') {
                src = Number(src)
            }
            if (typeof ext === 'string') {
                ext = JSON.parse(ext)
            }
//            if (event === 'onError') {
//                console.error('subscribeHandler onError ' + data)
//            }
//            console.log('subscribeHandler impl event:' + (typeof event) + ":" + event + ", data:" + (typeof data) + ":" + data + ", src:" + (typeof src) + ":" + src + ", ext:" + (typeof ext) + ":" + ext)
            WeixinJSBridge.subscribeHandler(event, data, src, ext);
        } else {
            console.error('WeixinJSCoreAndroid::subscribeHandler, WeixinJSBridge==undefined, event==' + event)
        }
    };

    return ret;
})(this);

// 直接注入的JsApi不支持多态，需要手动处理
if (typeof this.WeixinWorker !== 'undefined') {
    var createWorker = this.WeixinWorker.create;
    var createWithParams = this.WeixinWorker.createWithParams;
    if (createWorker && createWithParams) {
        this.WeixinWorker.create = function(path, params) {
            if (!params) {
                return createWorker(path);
            } else {
                return createWithParams(path, JSON.stringify(params));
            }
        }
    }
};