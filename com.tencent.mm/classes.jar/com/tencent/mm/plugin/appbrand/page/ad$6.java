package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.xweb.p;

final class ad$6
  extends p
{
  ad$6(ad paramad) {}
  
  public final boolean a(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    AppMethodBeat.i(143512);
    ab.w("MicroMsg.AppBrandWebView", "WebChromeClient onEnterFullscreen");
    if (this.iys.isXWalkKernel())
    {
      if (ad.b(this.iys) != null) {
        ad.b(this.iys).ivi = new ad.6.1(this, paramCustomViewCallback);
      }
      AppMethodBeat.o(143512);
      return true;
    }
    boolean bool = super.a(paramView, paramCustomViewCallback);
    AppMethodBeat.o(143512);
    return bool;
  }
  
  public final boolean aJH()
  {
    AppMethodBeat.i(143513);
    ab.w("MicroMsg.AppBrandWebView", "WebChromeClient onExitFullscreen");
    if (this.iys.isXWalkKernel())
    {
      AppMethodBeat.o(143513);
      return true;
    }
    boolean bool = super.aJH();
    AppMethodBeat.o(143513);
    return bool;
  }
  
  public final void onHideCustomView()
  {
    AppMethodBeat.i(132453);
    try
    {
      if (ad.b(this.iys) != null) {
        ad.b(this.iys).aIJ();
      }
      AppMethodBeat.o(132453);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.AppBrandWebView", "onHideCustomView error " + localException.getMessage());
      AppMethodBeat.o(132453);
    }
  }
  
  public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    AppMethodBeat.i(132452);
    try
    {
      if (ad.b(this.iys) != null)
      {
        ad.b(this.iys).J(paramView, 90);
        ad.b(this.iys).ivi = paramCustomViewCallback;
      }
      AppMethodBeat.o(132452);
      return;
    }
    catch (Exception paramView)
    {
      ab.e("MicroMsg.AppBrandWebView", "onShowCustomView error " + paramView.getMessage());
      AppMethodBeat.o(132452);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ad.6
 * JD-Core Version:    0.7.0.1
 */