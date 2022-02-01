package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.ac;
import com.tencent.mm.plugin.appbrand.config.al;
import com.tencent.mm.sdk.platformtools.Util;

final class AppBrandProfileUI$22
  implements View.OnClickListener
{
  AppBrandProfileUI$22(AppBrandProfileUI paramAppBrandProfileUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(322266);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if ((AppBrandProfileUI.d(this.udA) != null) && (!Util.isNullOrNil(AppBrandProfileUI.d(this.udA).appId)))
    {
      c.b(this.udA, "webview", ".ui.tools.WebViewUI", new Intent().putExtra("rawUrl", ac.UB(AppBrandProfileUI.d(this.udA).appId)).putExtra("forceHideShare", true));
      AppBrandProfileUI.a(this.udA, 16, 1);
    }
    a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(322266);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.22
 * JD-Core Version:    0.7.0.1
 */