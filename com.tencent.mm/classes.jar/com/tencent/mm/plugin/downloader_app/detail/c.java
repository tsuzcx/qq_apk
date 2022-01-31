package com.tencent.mm.plugin.downloader_app.detail;

import android.os.Bundle;
import android.view.View;
import com.tencent.luggage.d.a.a;
import com.tencent.luggage.d.g;
import com.tencent.luggage.d.k;
import com.tencent.luggage.d.n;
import com.tencent.luggage.d.n.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.widget.MMWebView;

public final class c
  extends n
{
  private MMWebView foJ;
  boolean lag;
  private n.a lah;
  
  public c(g paramg, k paramk, Bundle paramBundle)
  {
    super(paramg, paramk, paramBundle);
    AppMethodBeat.i(136046);
    this.lag = false;
    this.lah = new c.2(this);
    if (paramk != null) {
      this.lag = true;
    }
    ab.i("MicroMsg.DownloadDetailWebPage", "preload = %b", new Object[] { Boolean.valueOf(this.lag) });
    a(this.lah);
    this.bzs.bzh = a.bzy;
    com.tencent.mm.plugin.webview.luggage.i.b(this);
    AppMethodBeat.o(136046);
  }
  
  private void JR(String paramString)
  {
    AppMethodBeat.i(136053);
    this.bzs.a(new c.1(this, paramString));
    AppMethodBeat.o(136053);
  }
  
  public final void g(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(136051);
    if (!this.lag) {
      this.bzs.loadUrl(paramString);
    }
    AppMethodBeat.o(136051);
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(136049);
    ab.i("MicroMsg.DownloadDetailWebPage", "onBackground");
    JR("onPause");
    this.foJ.onPause();
    AppMethodBeat.o(136049);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(136050);
    ab.i("MicroMsg.DownloadDetailWebPage", "onDestroy");
    JR("onDestroy");
    com.tencent.mm.plugin.webview.luggage.i.c(this);
    AppMethodBeat.o(136050);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(136048);
    ab.i("MicroMsg.DownloadDetailWebPage", "onForeground");
    JR("onResume");
    this.foJ.onResume();
    AppMethodBeat.o(136048);
  }
  
  public final View tZ()
  {
    AppMethodBeat.i(136047);
    this.foJ = ((MMWebView)this.bzs.uv());
    View localView = super.tZ();
    AppMethodBeat.o(136047);
    return localView;
  }
  
  public final String ux()
  {
    AppMethodBeat.i(136052);
    String str = com.tencent.luggage.g.i.p(ah.getContext(), "luggage_mm_adapter.js");
    AppMethodBeat.o(136052);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.detail.c
 * JD-Core Version:    0.7.0.1
 */