var WeixinSharedBuffer = (function(global) {
    if (typeof global.WeixinSharedBuffer !== 'undefined') {
        return global.WeixinSharedBuffer
    }
    var ret = {};
    ret.new = global.setSharedNativeBuffer;
    ret.get = global.getSharedNativeBuffer;
    ret.Lock = global.lockSharedNativeBuffer;
    ret.Unlock = global.unlockSharedNativeBuffer;
    return ret;
})(this);