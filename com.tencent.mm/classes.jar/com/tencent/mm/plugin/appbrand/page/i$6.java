package com.tencent.mm.plugin.appbrand.page;

import android.content.Intent;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.plugin.appbrand.report.h;
import com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI;
import com.tencent.mm.sdk.platformtools.bt;

final class i$6
  implements Runnable
{
  i$6(i parami, com.tencent.luggage.sdk.b.a.c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(175026);
    Object localObject = this.liR.En().Fb().username;
    if (bt.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(175026);
      return;
    }
    localObject = new Intent(this.liR.getContext(), AppBrandAuthorizeUI.class).putExtra("key_username", (String)localObject);
    ((Intent)localObject).putExtra("key_app_authorize_profile", true);
    d.b(this.liR.getContext(), "appbrand", ".ui.AppBrandAuthorizeUI", (Intent)localObject);
    h.a(this.liR.getAppId(), this.liR.kuf, 34, "", bt.aQJ(), 1, 0);
    AppMethodBeat.o(175026);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.i.6
 * JD-Core Version:    0.7.0.1
 */