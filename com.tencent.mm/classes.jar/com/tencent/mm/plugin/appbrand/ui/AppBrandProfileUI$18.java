package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.config.ab;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.platformtools.bu;

final class AppBrandProfileUI$18
  implements View.OnClickListener
{
  AppBrandProfileUI$18(AppBrandProfileUI paramAppBrandProfileUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(48724);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if ((AppBrandProfileUI.b(this.mJd) != null) && (!bu.isNullOrNil(AppBrandProfileUI.b(this.mJd).appId)))
    {
      d.b(this.mJd, "webview", ".ui.tools.WebViewUI", new Intent().putExtra("rawUrl", v.Li(AppBrandProfileUI.b(this.mJd).appId)).putExtra("forceHideShare", true));
      AppBrandProfileUI.a(this.mJd, 16, 1);
    }
    a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(48724);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.18
 * JD-Core Version:    0.7.0.1
 */