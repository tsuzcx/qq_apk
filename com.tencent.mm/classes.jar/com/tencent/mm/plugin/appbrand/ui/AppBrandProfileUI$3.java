package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.n.d;

final class AppBrandProfileUI$3
  implements n.d
{
  AppBrandProfileUI$3(AppBrandProfileUI paramAppBrandProfileUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(133027);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(133027);
      return;
      paramMenuItem = new Intent(this.iOj, AppBrandAuthorizeUI.class).putExtra("key_username", AppBrandProfileUI.d(this.iOj));
      d.b(this.iOj, "appbrand", ".ui.AppBrandAuthorizeUI", paramMenuItem);
      AppBrandProfileUI.a(this.iOj, 10, 1);
      AppMethodBeat.o(133027);
      return;
      boolean bool1 = ((af)com.tencent.mm.kernel.g.E(af.class)).aC(AppBrandProfileUI.d(this.iOj), 0);
      boolean bool2 = com.tencent.mm.plugin.appbrand.ui.collection.g.a(bool1, this.iOj, AppBrandProfileUI.d(this.iOj), 0);
      if (bool1)
      {
        paramInt = 12;
        if (!bool2) {
          break label178;
        }
      }
      label178:
      for (int i = 1;; i = 2)
      {
        AppBrandProfileUI.a(this.iOj, paramInt, i);
        AppMethodBeat.o(133027);
        return;
        paramInt = 11;
        break;
      }
      if ((AppBrandProfileUI.e(this.iOj) != null) && (!bo.isNullOrNil(AppBrandProfileUI.e(this.iOj).appId)))
      {
        d.b(this.iOj, "webview", ".ui.tools.WebViewUI", new Intent().putExtra("rawUrl", com.tencent.mm.plugin.appbrand.v.yf(AppBrandProfileUI.e(this.iOj).appId)).putExtra("forceHideShare", true));
        AppBrandProfileUI.a(this.iOj, 16, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.3
 * JD-Core Version:    0.7.0.1
 */