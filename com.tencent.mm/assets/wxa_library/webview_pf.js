if (typeof PageLongTaskReporter !== 'undefined') {
    (function observeLongTask() {
        let localReporter = PageLongTaskReporter;

        const observer = new PerformanceObserver(function(list) {
            for (const entry of list.getEntries()) {
                localReporter.notifyLongTask.call(localReporter, entry.duration);
                break;
            }
        });

        observer.observe({entryTypes: ['longtask']});
    })();

    delete PageLongTaskReporter;
}



