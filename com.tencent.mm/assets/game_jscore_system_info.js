var SystemInfo = (function(){

    if (typeof global.SystemInfo !== 'undefined') {
        return global.SystemInfo;
    }

    var ret = {};

    ret.windowWidth = %s;

    ret.windowHeight = %s;

    ret.screenWidth = %s;

    ret.screenHeight = %s;

    ret.devicePixelRatio = %s;

    ret.networkType = '%s';

    ret.brand = '%s';

    ret.mode = '%s';

    ret.clientVersion = '%s';

    ret.system = '%s';

    ret.language = '%s';

    ret.isDarkMode = %b;

    return ret;

})()