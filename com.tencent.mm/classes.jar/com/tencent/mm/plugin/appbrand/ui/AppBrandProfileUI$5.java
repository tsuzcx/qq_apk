package com.tencent.mm.plugin.appbrand.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.config.ab;

final class AppBrandProfileUI$5
  implements View.OnClickListener
{
  AppBrandProfileUI$5(AppBrandProfileUI paramAppBrandProfileUI, ab paramab) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(48709);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    AppBrandProfileUI.a(this.mJd, this.mJf.duL, this.mJf.duL, new String[] { this.mJf.duL });
    a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(48709);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.5
 * JD-Core Version:    0.7.0.1
 */