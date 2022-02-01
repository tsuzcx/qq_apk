package com.tencent.mm.plugin.appbrand.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class AppBrandProfileUI$15
  implements View.OnClickListener
{
  AppBrandProfileUI$15(AppBrandProfileUI paramAppBrandProfileUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(48721);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    AppBrandProfileUI.r(this.mJd);
    a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(48721);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.15
 * JD-Core Version:    0.7.0.1
 */