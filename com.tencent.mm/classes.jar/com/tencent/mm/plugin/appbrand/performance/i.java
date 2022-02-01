package com.tencent.mm.plugin.appbrand.performance;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.report.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class i
  implements g
{
  final String mAppId;
  
  public i(ah paramah)
  {
    AppMethodBeat.i(175049);
    this.mAppId = paramah.getAppId();
    AppMethodBeat.o(175049);
  }
  
  @JavascriptInterface
  public final void notifyLongTask(final long paramLong)
  {
    AppMethodBeat.i(175050);
    com.tencent.e.h.ZvG.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(175048);
        long l = paramLong;
        String str = i.this.mAppId;
        int i;
        if (l <= 60L) {
          i = 1;
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.IzE.el(1246, i);
          com.tencent.mm.plugin.report.service.h.IzE.el(1246, 0);
          str = String.format("%d,%s", new Object[] { Long.valueOf(l), str });
          a.qIj.a(18794, new Object[] { str });
          Log.v("MicroMsg.PageLongTaskReporterWC", "doReport %s", new Object[] { str });
          AppMethodBeat.o(175048);
          return;
          if ((l > 60L) && (l <= 80L)) {
            i = 2;
          } else if ((l > 80L) && (l <= 100L)) {
            i = 3;
          } else if ((l > 100L) && (l <= 300L)) {
            i = 4;
          } else if ((l > 300L) && (l <= 600L)) {
            i = 5;
          } else if ((l > 600L) && (l <= 1000L)) {
            i = 6;
          } else {
            i = 7;
          }
        }
      }
    }, "PageLongTaskReporter");
    AppMethodBeat.o(175050);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.performance.i
 * JD-Core Version:    0.7.0.1
 */