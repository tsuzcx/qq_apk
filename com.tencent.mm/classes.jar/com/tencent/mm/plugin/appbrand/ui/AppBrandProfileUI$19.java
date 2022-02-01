package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.config.ae;
import com.tencent.mm.plugin.appbrand.z;
import com.tencent.mm.sdk.platformtools.Util;

final class AppBrandProfileUI$19
  implements View.OnClickListener
{
  AppBrandProfileUI$19(AppBrandProfileUI paramAppBrandProfileUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(48724);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if ((AppBrandProfileUI.b(this.qXA) != null) && (!Util.isNullOrNil(AppBrandProfileUI.b(this.qXA).appId)))
    {
      c.b(this.qXA, "webview", ".ui.tools.WebViewUI", new Intent().putExtra("rawUrl", z.abZ(AppBrandProfileUI.b(this.qXA).appId)).putExtra("forceHideShare", true));
      AppBrandProfileUI.a(this.qXA, 16, 1);
    }
    a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(48724);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.19
 * JD-Core Version:    0.7.0.1
 */