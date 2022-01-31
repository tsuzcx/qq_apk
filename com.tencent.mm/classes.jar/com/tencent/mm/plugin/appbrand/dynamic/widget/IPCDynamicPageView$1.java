package com.tencent.mm.plugin.appbrand.dynamic.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.widget.a;
import com.tencent.mm.plugin.report.service.h;

final class IPCDynamicPageView$1
  implements Runnable
{
  IPCDynamicPageView$1(IPCDynamicPageView paramIPCDynamicPageView) {}
  
  public final void run()
  {
    int i = 1;
    AppMethodBeat.i(11037);
    long l;
    if (!IPCDynamicPageView.a(this.hro))
    {
      IPCDynamicPageView.a(this.hro, true);
      IPCDynamicPageView.b(this.hro);
      l = System.currentTimeMillis() - IPCDynamicPageView.c(this.hro);
      if (l > 1000L) {
        break label123;
      }
      i = 0;
    }
    for (;;)
    {
      h.qsU.idkeyStat(645L, i, 1L, false);
      h.qsU.idkeyStat(645L, 11L, 1L, false);
      this.hro.nK(2107);
      IPCDynamicPageView.a(this.hro, System.currentTimeMillis());
      IPCDynamicPageView.d(this.hro).axT();
      AppMethodBeat.o(11037);
      return;
      label123:
      if (l > 2000L) {
        if (l <= 3000L) {
          i = 2;
        } else if (l <= 4000L) {
          i = 3;
        } else if (l <= 5000L) {
          i = 4;
        } else if (l <= 6000L) {
          i = 5;
        } else if (l <= 7000L) {
          i = 6;
        } else if (l <= 8000L) {
          i = 7;
        } else if (l <= 9000L) {
          i = 8;
        } else if (l <= 10000L) {
          i = 9;
        } else {
          i = 10;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView.1
 * JD-Core Version:    0.7.0.1
 */