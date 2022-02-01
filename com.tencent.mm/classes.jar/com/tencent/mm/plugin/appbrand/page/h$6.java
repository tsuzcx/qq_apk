package com.tencent.mm.plugin.appbrand.page;

import android.content.Intent;
import com.tencent.luggage.sdk.b.a.c;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI;
import com.tencent.mm.sdk.platformtools.bu;

final class h$6
  implements Runnable
{
  h$6(h paramh, c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(175026);
    Object localObject = this.lmD.Eq().Fg().username;
    if (bu.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(175026);
      return;
    }
    localObject = new Intent(this.lmD.getContext(), AppBrandAuthorizeUI.class).putExtra("key_username", (String)localObject);
    ((Intent)localObject).putExtra("key_app_authorize_profile", true);
    com.tencent.mm.br.d.b(this.lmD.getContext(), "appbrand", ".ui.AppBrandAuthorizeUI", (Intent)localObject);
    com.tencent.mm.plugin.appbrand.report.h.a(this.lmD.getAppId(), this.lmD.kxv, 34, "", bu.aRi(), 1, 0);
    AppMethodBeat.o(175026);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.h.6
 * JD-Core Version:    0.7.0.1
 */