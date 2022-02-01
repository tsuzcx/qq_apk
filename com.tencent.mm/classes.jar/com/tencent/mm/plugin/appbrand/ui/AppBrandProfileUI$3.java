package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.plugin.appbrand.ui.collection.h;
import com.tencent.mm.ui.base.n.e;

final class AppBrandProfileUI$3
  implements n.e
{
  AppBrandProfileUI$3(AppBrandProfileUI paramAppBrandProfileUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(48706);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(48706);
      return;
      paramMenuItem = new Intent(this.mJd, AppBrandAuthorizeUI.class).putExtra("key_username", AppBrandProfileUI.d(this.mJd));
      paramMenuItem.putExtra("key_app_authorize_profile", true);
      d.b(this.mJd, "appbrand", ".ui.AppBrandAuthorizeUI", paramMenuItem);
      AppBrandProfileUI.a(this.mJd, 10, 1);
      AppMethodBeat.o(48706);
      return;
      boolean bool1 = ((ah)g.ab(ah.class)).ba(AppBrandProfileUI.d(this.mJd), 0);
      boolean bool2 = h.a(bool1, this.mJd, AppBrandProfileUI.d(this.mJd), 0);
      if (bool1)
      {
        paramInt = 12;
        if (!bool2) {
          break label182;
        }
      }
      label182:
      for (int i = 1;; i = 2)
      {
        AppBrandProfileUI.a(this.mJd, paramInt, i);
        AppMethodBeat.o(48706);
        return;
        paramInt = 11;
        break;
      }
      AppBrandProfileUI.e(this.mJd);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.3
 * JD-Core Version:    0.7.0.1
 */