package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.c.d.c;
import com.tencent.mm.sdk.platformtools.ab;

final class AppBrandOnlineVideoProxy$OnlineVideoProxy$1
  implements d.c
{
  AppBrandOnlineVideoProxy$OnlineVideoProxy$1(AppBrandOnlineVideoProxy.OnlineVideoProxy paramOnlineVideoProxy) {}
  
  public final void ad(String paramString, int paramInt)
  {
    AppMethodBeat.i(131504);
    ab.i("MicroMsg.AppBrandOnlineVideoProxy", "on finish [%s %d]", new Object[] { paramString, Integer.valueOf(paramInt) });
    this.ica.ibW = paramInt;
    this.ica.ibU = 13;
    g.auP().zF(this.ica.fVf);
    AppBrandOnlineVideoProxy.OnlineVideoProxy.d(this.ica);
    AppMethodBeat.o(131504);
  }
  
  public final void cW(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(131501);
    this.ica.ibW = paramInt1;
    this.ica.ibX = paramInt2;
    this.ica.ibU = 10;
    AppBrandOnlineVideoProxy.OnlineVideoProxy.a(this.ica);
    AppMethodBeat.o(131501);
  }
  
  public final void cX(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(131502);
    this.ica.ibW = paramInt1;
    this.ica.ibX = paramInt2;
    this.ica.ibU = 11;
    AppBrandOnlineVideoProxy.OnlineVideoProxy.b(this.ica);
    AppMethodBeat.o(131502);
  }
  
  public final void cY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(131503);
    this.ica.ibW = paramInt1;
    this.ica.ibX = paramInt2;
    this.ica.ibU = 12;
    AppBrandOnlineVideoProxy.OnlineVideoProxy.c(this.ica);
    AppMethodBeat.o(131503);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandOnlineVideoProxy.OnlineVideoProxy.1
 * JD-Core Version:    0.7.0.1
 */