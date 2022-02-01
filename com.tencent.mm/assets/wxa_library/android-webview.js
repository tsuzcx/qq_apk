var WeixinJSCore = (function(global) {
    var _WeixinJSCore = global.WeixinJSCore
    var ret = {};
    ret.publishHandler = function(event, data, dst) {
        _WeixinJSCore.publishHandler(event, data, dst)
    }
    ret.invokeHandler = function(api, args, callbackId, privateArgs) {
        if (!privateArgs || typeof privateArgs === 'undefined') {
            return _WeixinJSCore.invokeHandler(api, args, callbackId)
        } else {
            if (typeof privateArgs !== 'string') {
                privateArgs = JSON.stringify(privateArgs)
            }
            return _WeixinJSCore.invokeHandler2(api, args, callbackId, privateArgs)
        }
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
            WeixinJSBridge.invokeCallbackHandler(callbackId, data);
        } else {
            console.error('WeixinJSCoreAndroid::invokeCallbackHandler, WeixinJSBridge==undefined, callbackId==' + callbackId)
        }
    };
    ret.subscribeHandler = function(event, data, src, ext) {
        if (typeof WeixinJSBridge !== 'undefined') {
            WeixinJSBridge.subscribeHandler(event, data, src, ext);
        } else {
            console.error('WeixinJSCoreAndroid::subscribeHandler, WeixinJSBridge==undefined, event==' + event)
        }
    };

    return ret;
})(this);