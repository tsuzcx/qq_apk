package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.f.e;

final class h$1
  implements Runnable
{
  h$1(h paramh, c paramc, String paramString, h.a parama) {}
  
  public final void run()
  {
    e.post(new h.1.1(this), "stopScanServices");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.h.1
 * JD-Core Version:    0.7.0.1
 */