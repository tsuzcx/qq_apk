package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
final class AppBrandRecommendUILogic$g
  implements View.OnLongClickListener
{
  public static final g mNM;
  
  static
  {
    AppMethodBeat.i(51365);
    mNM = new g();
    AppMethodBeat.o(51365);
  }
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(189642);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$initHeaderTagView$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
    a.a(true, this, "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$initHeaderTagView$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(189642);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.AppBrandRecommendUILogic.g
 * JD-Core Version:    0.7.0.1
 */