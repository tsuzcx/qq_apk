;if (this.NativeGlobal && this.NativeGlobal.initModule) {
    var that = this;
    // OffscreenCanvas
    if (!that.NativeGlobal.OffscreenCanvas) {
        Object.defineProperty(this.NativeGlobal, 'OffscreenCanvas', {
            get: function() {
                if (this.hasInitedOffscreenCanvas) {
                    return that.NativeGlobal.OffscreenCanvas_;
                }
                const ret = that.NativeGlobal.initModule('OffscreenCanvas');
                if (ret) {
                    this.hasInitedOffscreenCanvas = true;
                    return that.NativeGlobal.OffscreenCanvas_;
                } else {
                    return undefined;
                }
                
            }
        });
    }

    // Image
    if (!that.NativeGlobal.Image) {
        Object.defineProperty(this.NativeGlobal, 'Image', {
            get: function() {
                if (this.hasInitedImage) {
                    return that.NativeGlobal.Image_;
                }
                const ret = that.NativeGlobal.initModule('Image');
                if (ret) {
                    this.hasInitedImage = true;
                    return that.NativeGlobal.Image_;
                } else {
                    return undefined;
                }
                
            }
        });
    }

    // MediaSdk
    if (!that.NativeGlobal.MediaToolKit) {
        Object.defineProperty(this.NativeGlobal, 'MediaToolKit', {
            get: function() {
                if (this.hasInitedMediaToolKit) {
                    return that.NativeGlobal.MediaToolKit_;
                }
                const ret = that.NativeGlobal.initModule('MediaToolKit');
                if (ret) {
                    this.hasInitedMediaToolKit = true;
                    return that.NativeGlobal.MediaToolKit_;
                } else {
                    return undefined;
                }
                
            }
        });
    }
    // CPU Profiler
    if (!that.NativeGlobal.CpuProfiler) {
        Object.defineProperty(this.NativeGlobal, 'CpuProfiler', {
            get: function() {
                if (this.hasInitedCpuProfiler) {
                    return that.NativeGlobal.CpuProfiler_;
                }
                const ret = that.NativeGlobal.initModule('CpuProfiler');
                if (ret) {
                    this.hasInitedCpuProfiler = true;
                    return that.NativeGlobal.CpuProfiler_;
                } else {
                    return undefined;
                }
                
            }
        });
    }

    // Heap Profiler
    if (!that.NativeGlobal.HeapProfiler) {
        Object.defineProperty(this.NativeGlobal, 'HeapProfiler', {
            get: function() {
                if (this.hasInitedHeapProfiler) {
                    return that.NativeGlobal.HeapProfiler_;
                }
                const ret = that.NativeGlobal.initModule('HeapProfiler');
                if (ret) {
                    this.hasInitedHeapProfiler = true;
                    return that.NativeGlobal.HeapProfiler_;
                } else {
                    return undefined;
                }
                
            }
        });
    }

    // box2d
    if (!that.NativeGlobal.Box2D) {
        Object.defineProperty(this.NativeGlobal, 'Box2D', {
            get: function() {
                if (this.hasInitedBox2D) {
                    return that.NativeGlobal.Box2D_;
                }
                const ret = that.NativeGlobal.initModule('Box2D');
                if (ret) {
                    this.hasInitedBox2D = true;
                    return that.NativeGlobal.Box2D_;
                } else {
                    return undefined;
                }
                
            }
        });
    }

    // Heap Profiler
    if (!that.NativeGlobal.Phys3D) {
        Object.defineProperty(this.NativeGlobal, 'Phys3D', {
            get: function() {
                if (this.hasInitedPhys3D) {
                    return that.NativeGlobal.Phys3D_;
                }
                const ret = that.NativeGlobal.initModule('Phys3D');
                if (ret) {
                    this.hasInitedPhys3D = true;
                    return that.NativeGlobal.Phys3D_;
                } else {
                    return undefined;
                }
                
            }
        });
    }
};