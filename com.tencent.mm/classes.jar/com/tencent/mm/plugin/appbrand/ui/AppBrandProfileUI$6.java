package com.tencent.mm.plugin.appbrand.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.config.ae;

final class AppBrandProfileUI$6
  implements View.OnClickListener
{
  AppBrandProfileUI$6(AppBrandProfileUI paramAppBrandProfileUI, ae paramae) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(48710);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    AppBrandProfileUI.a(this.qXA, this.qXD.fET, this.qXD.fET, new String[] { this.qXD.fET });
    a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(48710);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.6
 * JD-Core Version:    0.7.0.1
 */