NativeGlobal.puppetDelegate = (function (global) {
    let ret = {};
    let NativeGlobal = global.NativeGlobal;
    ret.getNativeBufferId = global.getNativeBufferId;
    ret.setNativeBuffer = global.setNativeBuffer;
    // image delegate
    ret.decodeImage = (array, onLoadCallback, premultiply) => {
        let imageExtends = new NativeGlobal.ImagePuppetExtend();
        let nativeBufferId = ret.getNativeBufferId();
        ret.setNativeBuffer(nativeBufferId, array);
        if (premultiply !== undefined) {
            imageExtends.premultiplyAlpha = premultiply;
        } else {
            imageExtends.premultiplyAlpha = false;
        }
        imageExtends.setSrcFromNativeBuffer(nativeBufferId);
        
        imageExtends.onload = () => {
            let dataBuffer = imageExtends.extractBuffer();
            onLoadCallback(dataBuffer, imageExtends.width, imageExtends.height);
            imageExtends = null;
        };
        imageExtends.onerror = () => {
            onLoadCallback(undefined, undefined, undefined);
        };
    };
    ret.loadTTFFont = (ttfArray, filePath) => {
        // Android will ignore ttf array
        if (!filePath) {
            return null;
        }
        return NativeGlobal.loadFont(filePath);
    }
    return ret;
})(this);