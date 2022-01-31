package com.tencent.mm.app;

import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.al.c;

final class AppBrandProfile$1
  implements al.c
{
  AppBrandProfile$1(AppBrandProfile paramAppBrandProfile) {}
  
  public final void c(String paramString, Throwable paramThrowable)
  {
    h.nFQ.a(365L, 3L, 1L, false);
    KVCommCrossProcessReceiver.bwU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.AppBrandProfile.1
 * JD-Core Version:    0.7.0.1
 */