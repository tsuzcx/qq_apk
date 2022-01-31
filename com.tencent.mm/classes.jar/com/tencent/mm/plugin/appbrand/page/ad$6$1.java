package com.tencent.mm.plugin.appbrand.page;

import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class ad$6$1
  implements WebChromeClient.CustomViewCallback
{
  ad$6$1(ad.6 param6, WebChromeClient.CustomViewCallback paramCustomViewCallback) {}
  
  public final void onCustomViewHidden()
  {
    AppMethodBeat.i(143511);
    if (this.iyu.iys.hasEnteredFullscreen())
    {
      ab.i("MicroMsg.AppBrandWebView", "WebChromeClient leaveFullscreen");
      this.iyu.iys.leaveFullscreen();
    }
    if (this.iyt != null) {
      this.iyt.onCustomViewHidden();
    }
    AppMethodBeat.o(143511);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ad.6.1
 * JD-Core Version:    0.7.0.1
 */