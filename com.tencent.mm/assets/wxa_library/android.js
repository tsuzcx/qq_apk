
var WeixinJSCoreAndroid = (function(global) {
    if (typeof global.WeixinJSCoreAndroid !== 'undefined') {
        return global.WeixinJSCoreAndroid
    }

    var WeixinJSCore = global.WeixinJSCore;

    if (!WeixinJSCore) {
        console.error('No WeixinJSCore in this env!');
        return undefined;
    }

    if (global.openInvokeHandlerJsBinding && NativeGlobal && NativeGlobal.invokeHandler) {
        WeixinJSCore.invokeHandler = NativeGlobal.invokeHandler;
    } else if (global.workerInvokeJsApi) {
        WeixinJSCore.invokeHandler = global.workerInvokeJsApi;
    }

    var ret = {};
    ret.invokeCallbackHandler = function(callbackId, data) {
        if (typeof WeixinJSBridge !== 'undefined') {
            if (typeof data === 'string') {
                data = JSON.parse(data)
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
if (typeof WeixinWorker !== 'undefined') {
    var createWorker = WeixinWorker.create;
    var createWithParams = WeixinWorker.createWithParams;
    if (createWorker && createWithParams) {
        WeixinWorker.create = function(path, params) {
            if (!params) {
                return createWorker(path);
            } else {
                return createWithParams(path, JSON.stringify(params));
            }
        }
    }
};