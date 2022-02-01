package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
final class AppBrandRecommendUILogic$g
  implements View.OnLongClickListener
{
  public static final g ofT;
  
  static
  {
    AppMethodBeat.i(51365);
    ofT = new g();
    AppMethodBeat.o(51365);
  }
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(229570);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$initHeaderTagView$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
    a.a(true, this, "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$initHeaderTagView$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(229570);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.AppBrandRecommendUILogic.g
 * JD-Core Version:    0.7.0.1
 */