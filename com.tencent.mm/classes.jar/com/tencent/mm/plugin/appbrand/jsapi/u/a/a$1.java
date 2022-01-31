package com.tencent.mm.plugin.appbrand.jsapi.u.a;

import com.tencent.mm.sdk.platformtools.y;

final class a$1
  implements Runnable
{
  a$1(a parama, boolean paramBoolean, int paramInt) {}
  
  public final void run()
  {
    y.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoErrorHandler", "retry play video, error count:%d, isPlaying:%b, position:%d", new Object[] { Integer.valueOf(this.gHw.gHq), Boolean.valueOf(this.gHu), Integer.valueOf(this.gHv) });
    this.gHw.wuF.un();
    this.gHw.wuF.gHG = this.gHu;
    this.gHw.wuF.seek(this.gHv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.a.a.1
 * JD-Core Version:    0.7.0.1
 */