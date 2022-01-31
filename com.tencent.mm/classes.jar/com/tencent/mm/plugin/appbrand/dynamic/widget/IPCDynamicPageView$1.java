package com.tencent.mm.plugin.appbrand.dynamic.widget;

import com.tencent.mm.plugin.appbrand.canvas.widget.a;
import com.tencent.mm.plugin.report.service.h;

final class IPCDynamicPageView$1
  implements Runnable
{
  IPCDynamicPageView$1(IPCDynamicPageView paramIPCDynamicPageView) {}
  
  public final void run()
  {
    int i = 1;
    long l;
    if (!IPCDynamicPageView.a(this.fXO))
    {
      IPCDynamicPageView.a(this.fXO, true);
      IPCDynamicPageView.b(this.fXO);
      l = System.currentTimeMillis() - IPCDynamicPageView.c(this.fXO);
      if (l > 1000L) {
        break label111;
      }
      i = 0;
    }
    for (;;)
    {
      h.nFQ.a(645L, i, 1L, false);
      h.nFQ.a(645L, 11L, 1L, false);
      this.fXO.kM(2107);
      IPCDynamicPageView.a(this.fXO, System.currentTimeMillis());
      IPCDynamicPageView.d(this.fXO).adB();
      return;
      label111:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView.1
 * JD-Core Version:    0.7.0.1
 */