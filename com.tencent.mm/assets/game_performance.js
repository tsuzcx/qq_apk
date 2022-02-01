(function(){
    var PERF_TAG = "WXGAMEPERF:";
    //console.log("WXGAMEPERF: " + new Date().getTime())
    var memoryInfo = window.performance.memory;
    console.log(PERF_TAG + JSON.stringify(window.performance.toJSON()));
    console.log(PERF_TAG + "jsHeapSizeLimit=" + memoryInfo.jsHeapSizeLimit
    + "\ntotalJSHeapSize=" + memoryInfo.totalJSHeapSize
    + "\nusedJSHeapSize=" + memoryInfo.usedJSHeapSize);
    var entries = window.performance.getEntries();
    for (var i = 0; i < entries.length; ++i) {
        console.log(PERF_TAG + JSON.stringify(entries[i]));
    }
    console.log(PERF_TAG + "length=", entries.length);
    //console.log("WXGAMEPERF: " + JSON.stringify(entries));
    //console.log("WXGAMEPERF: " + new Date().getTime())
    return true;
})()