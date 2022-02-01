(function (global) {
    if (global) {
        global.evfx = {}
    }

    wx.getSystemInfoSync = function () {
        return invokeSync("getSystemInfoSync", {})
    }

    wx.getSystemInfo = function (obj) {
        const cb = {
            success: function (res) {
                if (obj && obj.success) {
                    obj.success(res)
                }
            },
            fail: function (errMsg) {
                if (obj && obj.fail) {
                    obj.fail(errMsg)
                }
            }
        }
        return invokeAsync("getSystemInfo", {}, cb)
    }

    var hasScreenCanvas = false;
    var screenCanvas = new NativeGlobal.Canvas();

    wx.createCanvas = function () {
        if (!hasScreenCanvas) {
            hasScreenCanvas = true
            return screenCanvas
        } else {
            return new NativeGlobal.Canvas()
        }
    }

    wx.createImage = function () {
        return new NativeGlobal.Image()
    }

    wx.createInnerAudioContext = function () {
        return {
            onCanplay: function () {

            },
            onPlay: function () {

            },
            onPause: function () {

            },
            onEnded: function () {

            },
            onError: function () {

            },
            play: function () {

            },
            seek: function () {

            },
        }
    }

    wx.onTouchStart = function () {

    }

    wx.onTouchMove = function () {

    }

    wx.onTouchEnd = function () {

    }

    wx.onTouchCancel = function () {

    }

    wx.request = function () {

    }

    wx.connectSocket = function () {

    }

    wx.getStorageInfoSync = function () {
        return {
            keys: []
        }
    }

    wx.getStorageSync = function () {

    }

    wx.setStorageSync = function () {

    }

    wx.removeStorageSync = function () {

    }

    wx.clearStorageSync = function () {

    }

    wx.cloud = {
        init: function () {

        },
        database: function () {

        },
        callFunction: function () {

        }
    }

    wx.env = {
        USER_DATA_PATH: "wxfile://usr",
        CLIENT_VERSION: global.__wxConfig.clientVersion,
        COMMONLIB_VERSION: "1.0.0"
    }

    wx.getFileSystemManager = function () {
        return {
            readFile: function (args = {}) {
                console.log("readFile!! path: " + args.filePath + "       encoding: " + args.encoding);

                var arg = {
                    filePath: args.filePath,
                    encoding: args.encoding,
                    position: args.position,
                    length: args.length
                }
                var cb = function (result) {
                    console.log(result)
                    if (result.__nativeBuffers__) {
                        var ab = WeixinNativeBuffer.get(result.__nativeBuffers__[0].id)
                        args.success({
                            data: ab
                        });
                    } else {
                        args.success({
                            data: result.data
                        });
                    }
                }

                WeixinJSBridge.invoke("readFile", arg, cb);
            },
            readdir: function (args) {
                var arg = {
                    dirPath: args.dirPath
                };
                var cbs = {
                    success: args.success,
                    fail: args.fail,
                    complete: args.complete
                }

                console.log("call readdir");
                WeixinJSBridge.invoke("readdir", arg, args.success)
            },
            getFileInfo: function () {

            },
            copyFile: function () {

            },
            unlink: function () {

            },
            writeFile: function () {

            },
            mkdir: function () {

            },
            readFileSync: function (filePath, encoding, position, length) {
                var arg = {
                    filePath: filePath,
                    encoding: encoding,
                    position: position,
                    length: length
                };

                const ret = invokeSync("readFileSync", arg);
                if (ret && ret.data) {
                    console.log(["readFileSync: ", arg, ret.data]);
                    return ret.data;
                }
            },
            accessSync: function (path) {
                var arg = {
                    path: path
                };
                return invokeSync("accessSync", arg);
            },
            statSync: function (path, recursive = false) {
                var arg = {
                    path: path,
                    recursive: recursive
                };
                let errMsg;
                let stats;

                console.log("call statSync");
                WeixinJSBridge.invoke("statSync", arg, res => {
                    if (res && res.errMsg) {
                        const name = 'statSync'
                        const isFail = res.errMsg.indexOf(`${name}:fail`) === 0

                        if (isFail) {
                            errMsg = res.errMsg;
                        } else {
                            filterStatRes(res, path)
                            stats = res.stats
                        }
                    }
                });
                if (errMsg) {
                    console.error(errMsg)
                    throw new Error(errMsg)
                } else {
                    return stats
                }
            },
            saveFile: function (args) {
                var arg = {
                    tempFilePath: args.tempFilePath,
                    filePath: args.filePath
                };
                var cbs = {
                    success: args.success,
                    fail: args.fail,
                    complete: args.complete
                }

                console.log("call saveFile");
                WeixinJSBridge.invoke("saveFile", arg, args.success)
            },
            readdirSync: function (dirPath) {
                var arg = {
                    dirPath: dirPath,
                };
                let files
                let errMsg

                console.log("call readdirSync");
                WeixinJSBridge.invoke("readdirSync", arg, res => {
                    if (res && res.files) {
                        files = res.files
                    } else {
                        errMsg = res.errMsg;
                    }
                });

                if (errMsg) {
                    console.error(errMsg)
                    throw new Error(errMsg)
                } else {
                    return files
                }
            },
            unlinkSync: function (filePath) {
                var arg = {
                    filePath: filePath,
                };

                let errMsg
                console.log("call unlinkSync");
                WeixinJSBridge.invoke('unlinkSync', arg, res => {
                    if (res && res.errMsg) {
                        const name = 'unlinkSync'
                        const isFail = res.errMsg.indexOf(`${name}:fail`) === 0

                        if (isFail) {
                            errMsg = res.errMsg
                        }
                    }
                })

                if (errMsg) {
                    console.error(errMsg)
                    throw new Error(errMsg)
                }
            },
            mkdirSync: function (dirPath, recursive = false) {
                var arg = {
                    dirPath: dirPath,
                    recursive: recursive
                };

                let errMsg
                console.log("call mkdirSync");
                WeixinJSBridge.invoke('mkdirSync', arg, res => {
                    if (res && res.errMsg) {
                        // const isSuccess = res.errMsg.indexOf(`${name}:ok`) === 0
                        const name = 'mkdirSync'
                        const isFail = res.errMsg.indexOf(`${name}:fail`) === 0

                        if (isFail) {
                            errMsg = res.errMsg
                        }
                    }
                })

                if (errMsg) {
                    console.error(errMsg)
                    throw new Error(errMsg)
                }
            },
            unzip: function (args) {
                var arg = {
                    zipFilePath: args.zipFilePath,
                    targetPath: args.targetPath
                };
                var cbs = {
                    success: args.success,
                    fail: args.fail,
                    complete: args.complete
                }

                console.log("call unzip");
                WeixinJSBridge.invoke("unzip", arg, args.success)
            }
        }
    }

    wx.downloadFile = function () {

    }

    wx.postMessage = function () {

    }

    wx.getNetworkType = function () {
        return {
            "networkType": "wifi"
        }
    }

    wx.createVideo = function () {
        return {
            destroy: function () {

            },

        }
    }

    wx.performance = function () {
        return {
            now: function () {
                return global.performance.now()
            }
        }
    }

    wx.getABTestConfig = function (args) {
        return invokeSync("getABTestConfig", args)
    }

    wx.kvReport = function (params) {
        const cb = {
            success: function (res) {
                if (params && params.success) {
                    params.success(res)
                }
            },
            fail: function (errMsg) {
                if (params && params.fail) {
                    params.fail(errMsg)
                }
            }
        }
        invokeAsync("kvReport", params, cb)
    }

    wx.reportIDKey = function (params) {
        const cb = {
            success: function (res) {
                if (params && params.success) {
                    params.success(res)
                }
            },
            fail: function (errMsg) {
                if (params && params.fail) {
                    params.fail(errMsg)
                }
            }
        }
        invokeAsync("reportIDKey", params, cb)
    }

    wx.gc = function() {
        if (NativeGlobal && NativeGlobal.gc && typeof(NativeGlobal.gc) === 'function') {
            NativeGlobal.gc()
        }
    }

    wx.magicEmoji = {
        onMagicEmojiSent: function (callback) {
            if (callback && typeof callback === "function") {
                WeixinJSBridge.on("MagicEmojiSent", function (result) {
                    callback(result, result.msgMeta);
                })
            }
        },
        onUnityEvent: function (callback) {
            if (callback && typeof callback === "function") {
                WeixinJSBridge.on("UnityEvent", function (result) {
                    callback(result);
                })
            }
        },
        shakeVisibleBubblesAndAvatars: function (params = {}) {
            const cb = {
                success: function (res) {
                    if (params && params.success) {
                        params.success(res)
                    }
                },
                fail: function (errMsg) {
                    if (params && params.fail) {
                        params.fail(errMsg)
                    }
                }
            }
            invokeAsync("shakeVisibleBubblesAndAvatars", params, cb)
        },
        getMsgMeta: function (msgId, needFrame) {
            const arg = {
                msgId: msgId,
                needFrame: needFrame,
            }

            return invokeSync("getMsgMeta", arg)
        },

        impact: function (params = {}) {
            const cb = {
                success: function (res) {
                    if (params && params.success) {
                        params.success(res)
                    }
                },
                fail: function (errMsg) {
                    if (params && params.fail) {
                        params.fail(errMsg)
                    }
                }
            }
            invokeAsync("impact", params, cb)
        },

        getVisibleMsgMetas: function(needFrame) {
            const arg = {
                needFrame: needFrame
            }
            return invokeSync("getVisibleMsgMetas", arg)
        }
    }

})(window);
