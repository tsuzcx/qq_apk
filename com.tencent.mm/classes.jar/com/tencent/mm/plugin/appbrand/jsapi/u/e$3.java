package com.tencent.mm.plugin.appbrand.jsapi.u;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.xweb.b;

final class e$3
  implements MenuItem.OnMenuItemClickListener
{
  e$3(e parame, String paramString) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(17030);
    try
    {
      boolean bool = e.i(this.ihi).isSDCardAvailable();
      u.a(e.g(this.ihi), this.ihm, b.dYg().getCookie(this.ihm), bool, new e.3.1(this));
      AppMethodBeat.o(17030);
      return true;
    }
    catch (Exception paramMenuItem)
    {
      for (;;)
      {
        ab.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onMenuItemClick fail, ex = " + paramMenuItem.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.e.3
 * JD-Core Version:    0.7.0.1
 */