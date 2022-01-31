package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.platformtools.ab;

final class AppBrandProfileUI$20
  implements View.OnClickListener
{
  AppBrandProfileUI$20(AppBrandProfileUI paramAppBrandProfileUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(133044);
    if (AppBrandProfileUI.c(this.iOj) == null)
    {
      ab.e("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "wxaExposedParams is null");
      AppMethodBeat.o(133044);
      return;
    }
    Intent localIntent = new Intent();
    String str = v.a(AppBrandProfileUI.c(this.iOj));
    ab.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "feedbackUrl:%s, wxaExposedParams:%s", new Object[] { str, AppBrandProfileUI.c(this.iOj).toString() });
    localIntent.putExtra("title", paramView.getContext().getString(2131296802));
    localIntent.putExtra("rawUrl", str);
    localIntent.putExtra("forceHideShare", true);
    d.b(this.iOj, "webview", ".ui.tools.WebViewUI", localIntent);
    AppBrandProfileUI.a(this.iOj, 20, 1);
    AppMethodBeat.o(133044);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.20
 * JD-Core Version:    0.7.0.1
 */