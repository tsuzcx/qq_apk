package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.xweb.xwalk.b;

final class AppBrandXWebDownloadProxyUI$a
  implements b
{
  boolean iPZ = false;
  
  private AppBrandXWebDownloadProxyUI$a(AppBrandXWebDownloadProxyUI paramAppBrandXWebDownloadProxyUI) {}
  
  public final boolean aMw()
  {
    AppMethodBeat.i(133178);
    this.iPZ = true;
    al.d(new AppBrandXWebDownloadProxyUI.a.1(this));
    AppMethodBeat.o(133178);
    return true;
  }
  
  public final void aMx()
  {
    AppMethodBeat.i(133180);
    AppBrandXWebDownloadProxyUI.c(this.iPX);
    com.tencent.xweb.ab.a(AppBrandXWebDownloadProxyUI.d(this.iPX));
    Intent localIntent = new Intent();
    this.iPX.setResult(0, localIntent);
    this.iPX.finish();
    AppMethodBeat.o(133180);
  }
  
  public final void aMy()
  {
    AppMethodBeat.i(133181);
    AppBrandXWebDownloadProxyUI.c(this.iPX);
    com.tencent.xweb.ab.a(AppBrandXWebDownloadProxyUI.d(this.iPX));
    Intent localIntent = new Intent();
    this.iPX.setResult(0, localIntent);
    this.iPX.finish();
    AppMethodBeat.o(133181);
  }
  
  public final void aMz()
  {
    AppMethodBeat.i(133182);
    AppBrandXWebDownloadProxyUI.c(this.iPX);
    com.tencent.xweb.ab.a(AppBrandXWebDownloadProxyUI.d(this.iPX));
    Intent localIntent = new Intent();
    this.iPX.setResult(-1, localIntent);
    this.iPX.finish();
    AppMethodBeat.o(133182);
  }
  
  public final void pD(int paramInt)
  {
    AppMethodBeat.i(133179);
    if (!this.iPZ)
    {
      AppMethodBeat.o(133179);
      return;
    }
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrandXWebDownloadProxyUI", "onDownloadProgress, percent = %d", new Object[] { Integer.valueOf(paramInt) });
    if (this.iPX.tipDialog != null) {
      al.d(new AppBrandXWebDownloadProxyUI.a.2(this, paramInt));
    }
    AppMethodBeat.o(133179);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandXWebDownloadProxyUI.a
 * JD-Core Version:    0.7.0.1
 */