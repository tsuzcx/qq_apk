package com.tencent.mm.plugin.appbrand.jsapi.u;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.xweb.b;

final class e$4
  implements MenuItem.OnMenuItemClickListener
{
  e$4(e parame, String paramString) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(17031);
    try
    {
      bool = e.i(this.ihi).isSDCardAvailable();
    }
    catch (Exception paramMenuItem)
    {
      try
      {
        for (;;)
        {
          u.a(e.g(this.ihi), this.ihm, b.dYg().getCookie(this.ihm), bool);
          AppMethodBeat.o(17031);
          return true;
          paramMenuItem = paramMenuItem;
          ab.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onMenuItemClick fail, ex = " + paramMenuItem.getMessage());
          boolean bool = false;
        }
      }
      catch (Exception paramMenuItem)
      {
        for (;;)
        {
          ab.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "save to sdcard failed : %s", new Object[] { paramMenuItem.getMessage() });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.e.4
 * JD-Core Version:    0.7.0.1
 */