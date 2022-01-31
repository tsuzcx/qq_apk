package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.i.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class AppBrandProcessShareMessageProxyUI$3
  implements i.b
{
  AppBrandProcessShareMessageProxyUI$3(AppBrandProcessShareMessageProxyUI paramAppBrandProcessShareMessageProxyUI, AppBrandProcessShareMessageProxyUI.c paramc) {}
  
  public final void kP(int paramInt)
  {
    AppMethodBeat.i(133011);
    ab.i("MicroMsg.AppBrandProcessShareMessageProxyUI", "onLoadImageResult, result:%d", new Object[] { Integer.valueOf(paramInt) });
    AppBrandProcessShareMessageProxyUI.c localc = this.iNj;
    localc.iNl = true;
    if (localc.lw())
    {
      al.ae(localc.hGy);
      localc.aMj();
    }
    AppMethodBeat.o(133011);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProcessShareMessageProxyUI.3
 * JD-Core Version:    0.7.0.1
 */