package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class RecentAppBrandViewContainer$2
  implements View.OnClickListener
{
  RecentAppBrandViewContainer$2(RecentAppBrandViewContainer paramRecentAppBrandViewContainer) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(49702);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/appbrand/widget/desktop/RecentAppBrandViewContainer$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (RecentAppBrandViewContainer.b(this.opx) != null) {
      RecentAppBrandViewContainer.b(this.opx).onClick(paramView);
    }
    a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/RecentAppBrandViewContainer$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(49702);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.RecentAppBrandViewContainer.2
 * JD-Core Version:    0.7.0.1
 */