package com.tencent.mm.plugin.appbrand.jsapi.t;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.b;

final class e$5
  implements MenuItem.OnMenuItemClickListener
{
  e$5(e parame, String paramString) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    try
    {
      boolean bool = e.h(this.gGA).isSDCardAvailable();
      paramMenuItem = this.gGE.replaceAll("tp=webp", "");
      s.a(e.f(this.gGA), paramMenuItem, b.cSe().getCookie(paramMenuItem), bool, new e.5.1(this));
      return true;
    }
    catch (Exception paramMenuItem)
    {
      for (;;)
      {
        y.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onMenuItemClick fail, ex = " + paramMenuItem.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.e.5
 * JD-Core Version:    0.7.0.1
 */