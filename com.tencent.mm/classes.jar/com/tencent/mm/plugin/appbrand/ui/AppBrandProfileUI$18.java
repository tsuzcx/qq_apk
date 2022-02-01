package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.config.ab;
import com.tencent.mm.plugin.appbrand.u;
import com.tencent.mm.sdk.platformtools.bt;

final class AppBrandProfileUI$18
  implements View.OnClickListener
{
  AppBrandProfileUI$18(AppBrandProfileUI paramAppBrandProfileUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(48724);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if ((AppBrandProfileUI.b(this.mDY) != null) && (!bt.isNullOrNil(AppBrandProfileUI.b(this.mDY).appId)))
    {
      d.b(this.mDY, "webview", ".ui.tools.WebViewUI", new Intent().putExtra("rawUrl", u.KI(AppBrandProfileUI.b(this.mDY).appId)).putExtra("forceHideShare", true));
      AppBrandProfileUI.a(this.mDY, 16, 1);
    }
    a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(48724);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.18
 * JD-Core Version:    0.7.0.1
 */