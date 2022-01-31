package com.tencent.mm.plugin.appbrand.jsapi.t;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.b;

final class e$4
  implements MenuItem.OnMenuItemClickListener
{
  e$4(e parame, String paramString) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    try
    {
      bool = e.h(this.gGA).isSDCardAvailable();
    }
    catch (Exception paramMenuItem)
    {
      for (;;)
      {
        try
        {
          s.a(e.f(this.gGA), this.gGE, b.cSe().getCookie(this.gGE), bool);
          return true;
        }
        catch (Exception paramMenuItem)
        {
          boolean bool;
          y.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "save to sdcard failed : %s", new Object[] { paramMenuItem.getMessage() });
        }
        paramMenuItem = paramMenuItem;
        y.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onMenuItemClick fail, ex = " + paramMenuItem.getMessage());
        bool = false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.e.4
 * JD-Core Version:    0.7.0.1
 */