package com.tencent.mm.plugin.downloader_app.detail;

import android.os.Bundle;
import android.view.View;
import com.tencent.luggage.e.a.a;
import com.tencent.luggage.e.g;
import com.tencent.luggage.e.k;
import com.tencent.luggage.e.n;
import com.tencent.luggage.e.n.a;
import com.tencent.luggage.j.h;
import com.tencent.mm.plugin.game.luggage.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMWebView;

public final class c
  extends n
{
  private MMWebView dYF;
  boolean iRx = false;
  private n.a iRy = new c.3(this);
  
  public c(g paramg, k paramk, Bundle paramBundle)
  {
    super(paramg, paramk, paramBundle);
    if (paramk != null) {
      this.iRx = true;
    }
    y.i("MicroMsg.DownloadDetailWebPage", "preload = %b", new Object[] { Boolean.valueOf(this.iRx) });
    a(this.iRy);
    this.biT.biJ = a.biZ;
    f.a(this);
    this.biT.a(new c.1(this));
  }
  
  private void zU(String paramString)
  {
    this.biT.a(new c.2(this, paramString));
  }
  
  public final void c(String paramString, Bundle paramBundle)
  {
    if (!this.iRx) {
      this.biT.loadUrl(paramString);
    }
  }
  
  protected final void onDestroy()
  {
    y.i("MicroMsg.DownloadDetailWebPage", "onDestroy");
    zU("onDestroy");
    f.b(this);
  }
  
  protected final View pW()
  {
    this.dYF = ((MMWebView)this.biT.qp());
    return super.pW();
  }
  
  protected final void pY()
  {
    y.i("MicroMsg.DownloadDetailWebPage", "onForeground");
    zU("onResume");
    this.dYF.onResume();
  }
  
  protected final void qa()
  {
    y.i("MicroMsg.DownloadDetailWebPage", "onBackground");
    zU("onPause");
    this.dYF.onPause();
  }
  
  protected final String qq()
  {
    return h.k(ae.getContext(), "luggage_game_adapter.js");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.detail.c
 * JD-Core Version:    0.7.0.1
 */