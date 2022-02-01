package com.tencent.mm.plugin.appbrand.page.capsulebar;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.luggage.wxa.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/page/capsulebar/WAGameCapsuleBarStyleApplier;", "", "()V", "TAG", "", "dimenPX", "", "Landroid/view/View;", "resId", "setupCapsuleMarginsForGame", "", "luggage-wxa-game-ext_release"})
public final class k
{
  public static final k qxF;
  
  static
  {
    AppMethodBeat.i(247542);
    qxF = new k();
    AppMethodBeat.o(247542);
  }
  
  private static int Q(View paramView, int paramInt)
  {
    AppMethodBeat.i(247541);
    paramInt = paramView.getResources().getDimensionPixelSize(paramInt);
    AppMethodBeat.o(247541);
    return paramInt;
  }
  
  public static final void cZ(View paramView)
  {
    AppMethodBeat.i(247540);
    p.k(paramView, "$this$setupCapsuleMarginsForGame");
    Object localObject1 = new StringBuilder("setupCapsuleMarginsForGame, this:").append(paramView.getClass().getSimpleName()).append(", context:").append(paramView.getContext().getClass().getSimpleName()).append(", density:");
    Object localObject2 = paramView.getResources();
    p.j(localObject2, "this.resources");
    Log.i("Luggage.WAGameCapsuleBarStyleApplier", ((Resources)localObject2).getDisplayMetrics().density);
    if ((paramView instanceof d)) {}
    for (localObject1 = ((d)paramView).getCapsuleContentAreaView();; localObject1 = paramView)
    {
      p.j(localObject1, "v");
      ViewGroup.LayoutParams localLayoutParams = ((View)localObject1).getLayoutParams();
      localObject2 = localLayoutParams;
      if (!(localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
        localObject2 = null;
      }
      localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
      if (localObject2 == null) {
        break label205;
      }
      ((ViewGroup.MarginLayoutParams)localObject2).topMargin = Q(paramView, a.b.app_brand_game_capsule_extra_margin_top);
      ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = (Q(paramView, a.b.app_brand_actionbar_capsule_view_right_margin_default) + Q(paramView, a.b.app_brand_game_capsule_extra_margin_right));
      ((View)localObject1).requestLayout();
      AppMethodBeat.o(247540);
      return;
      if (!(paramView instanceof AppBrandCapsuleBarPlaceHolderView)) {
        break;
      }
    }
    paramView = (Throwable)new IllegalStateException("Unrecognized View class".toString());
    AppMethodBeat.o(247540);
    throw paramView;
    label205:
    AppMethodBeat.o(247540);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.k
 * JD-Core Version:    0.7.0.1
 */