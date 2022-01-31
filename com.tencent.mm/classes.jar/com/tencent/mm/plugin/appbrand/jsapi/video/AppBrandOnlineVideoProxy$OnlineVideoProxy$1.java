package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.c.d.c;
import com.tencent.mm.sdk.platformtools.y;

final class AppBrandOnlineVideoProxy$OnlineVideoProxy$1
  implements d.c
{
  AppBrandOnlineVideoProxy$OnlineVideoProxy$1(AppBrandOnlineVideoProxy.OnlineVideoProxy paramOnlineVideoProxy) {}
  
  public final void V(String paramString, int paramInt)
  {
    y.i("MicroMsg.AppBrandOnlineVideoProxy", "on finish [%s %d]", new Object[] { paramString, Integer.valueOf(paramInt) });
    this.gCY.gCU = paramInt;
    this.gCY.gCS = 13;
    e.abe().rP(this.gCY.eFo);
    AppBrandOnlineVideoProxy.OnlineVideoProxy.d(this.gCY);
  }
  
  public final void bL(int paramInt1, int paramInt2)
  {
    this.gCY.gCU = paramInt1;
    this.gCY.gCV = paramInt2;
    this.gCY.gCS = 10;
    AppBrandOnlineVideoProxy.OnlineVideoProxy.a(this.gCY);
  }
  
  public final void bM(int paramInt1, int paramInt2)
  {
    this.gCY.gCU = paramInt1;
    this.gCY.gCV = paramInt2;
    this.gCY.gCS = 11;
    AppBrandOnlineVideoProxy.OnlineVideoProxy.b(this.gCY);
  }
  
  public final void bN(int paramInt1, int paramInt2)
  {
    this.gCY.gCU = paramInt1;
    this.gCY.gCV = paramInt2;
    this.gCY.gCS = 12;
    AppBrandOnlineVideoProxy.OnlineVideoProxy.c(this.gCY);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandOnlineVideoProxy.OnlineVideoProxy.1
 * JD-Core Version:    0.7.0.1
 */