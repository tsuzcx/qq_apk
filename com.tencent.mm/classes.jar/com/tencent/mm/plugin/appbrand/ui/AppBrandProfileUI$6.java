package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.sdk.platformtools.ab;
import java.net.URISyntaxException;

final class AppBrandProfileUI$6
  implements View.OnClickListener
{
  AppBrandProfileUI$6(AppBrandProfileUI paramAppBrandProfileUI, com.tencent.mm.plugin.appbrand.config.v paramv) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(133031);
    try
    {
      paramView = com.tencent.mm.plugin.appbrand.v.bs(this.iOl.hiy, "appid=" + AppBrandProfileUI.c(this.iOj).appId);
      paramView = new Intent().putExtra("rawUrl", paramView).putExtra("forceHideShare", true);
      d.b(this.iOj, "webview", ".ui.tools.WebViewUI", paramView);
      AppBrandProfileUI.a(this.iOj, 21, 1);
      AppMethodBeat.o(133031);
      return;
    }
    catch (URISyntaxException paramView)
    {
      ab.printErrStackTrace("MicroMsg.AppBrand.Profile.AppBrandProfileUI", paramView, "URISyntaxException with originalRedirectUrl %s", new Object[] { this.iOl.hiy });
      AppMethodBeat.o(133031);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.6
 * JD-Core Version:    0.7.0.1
 */