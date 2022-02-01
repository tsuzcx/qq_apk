;if (this.NativeGlobal && this.NativeGlobal.initModule) {
    var that = this;
    
    class LazyLoadModel {
        parent = null;
        name = "";
        suppressConfigReadyWarning = false;

        constructor(parent, name, suppressConfigReadyWarning = false) {
            this.parent = parent;
            this.name = name;
            this.suppressConfigReadyWarning = suppressConfigReadyWarning;
        }

        provideDelegateStr () {
            return this.name + '_';
        }
    };
    var consoleError = (msg) => {
        if (that.NativeGlobal && that.NativeGlobal.log) {
            NativeGlobal.log({level: 3, logs: [msg]});
        }
    }
    var lazyLoadModels = [];
    lazyLoadModels.push(new LazyLoadModel(that.NativeGlobal, 'OffscreenCanvas'));
    lazyLoadModels.push(new LazyLoadModel(that.NativeGlobal, 'Image'));
    lazyLoadModels.push(new LazyLoadModel(that.NativeGlobal, 'MediaToolKit'));
    lazyLoadModels.push(new LazyLoadModel(that.NativeGlobal, 'CpuProfiler'));
    lazyLoadModels.push(new LazyLoadModel(that.NativeGlobal, 'HeapProfiler'));
    lazyLoadModels.push(new LazyLoadModel(that.NativeGlobal, 'Box2D'));
    lazyLoadModels.push(new LazyLoadModel(that.NativeGlobal, 'Phys3D'));
    lazyLoadModels.push(new LazyLoadModel(that.NativeGlobal, 'Profiler'));

    for (const model of lazyLoadModels) {
        if (!model.parent[model.name]) {
            Object.defineProperty(model.parent, model.name, {
                get: function() {
                    if (model.isTriggeredInit) {
                        return model[model.provideDelegateStr()];
                    }
                    // Generate warning when calling lazy-load too early (before wxConfigReady event published). In most cases it's a bug.
                    if (!that.NativeGlobal.globalSuppressLazyLoadConfigReadyWarning && !that.NativeGlobal.hasInitializedWxConfig && !model.suppressConfigReadyWarning) {
                        consoleError('Calling lazy load model ' + model.name + ' too early! It may slow down start up and cost more memory usage.');
                    }
                    that.NativeGlobal.initModule(model.name);
                    model.isTriggeredInit = true;
                    return model[model.provideDelegateStr()];
                },

                set: function(value) {
                    model[model.provideDelegateStr()] = value;
                }
            });
        }
    }
};