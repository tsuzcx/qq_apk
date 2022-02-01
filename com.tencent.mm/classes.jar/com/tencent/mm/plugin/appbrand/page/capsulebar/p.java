package com.tencent.mm.plugin.appbrand.page.capsulebar;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.luggage.wxa.a.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/capsulebar/WAGameCapsuleBarStyleApplier;", "", "()V", "TAG", "", "dimenPX", "", "Landroid/view/View;", "resId", "setupCapsuleContainerMarginForGame", "", "setupCapsuleMarginsForGame", "luggage-wxa-game-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
{
  public static final p tCJ;
  
  static
  {
    AppMethodBeat.i(325270);
    tCJ = new p();
    AppMethodBeat.o(325270);
  }
  
  private static int W(View paramView, int paramInt)
  {
    AppMethodBeat.i(325266);
    paramInt = paramView.getResources().getDimensionPixelSize(paramInt);
    AppMethodBeat.o(325266);
    return paramInt;
  }
  
  public static final void dG(View paramView)
  {
    AppMethodBeat.i(325253);
    s.u(paramView, "<this>");
    Log.i("Luggage.WAGameCapsuleBarStyleApplier", "setupCapsuleMarginsForGame, this:" + paramView.getClass().getSimpleName() + ", context:" + paramView.getContext().getClass().getSimpleName() + ", density:" + paramView.getResources().getDisplayMetrics().density);
    View localView;
    if ((paramView instanceof d))
    {
      localView = ((d)paramView).getCapsuleContentAreaView();
      localObject = localView.getLayoutParams();
      if (!(localObject instanceof ViewGroup.MarginLayoutParams)) {
        break label174;
      }
    }
    label174:
    for (Object localObject = (ViewGroup.MarginLayoutParams)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        ((ViewGroup.MarginLayoutParams)localObject).rightMargin = (W(paramView, a.c.app_brand_actionbar_capsule_view_right_margin_default) + W(paramView, a.c.app_brand_game_capsule_extra_margin_right));
        localView.requestLayout();
      }
      AppMethodBeat.o(325253);
      return;
      if ((paramView instanceof AppBrandCapsuleBarPlaceHolderView))
      {
        localView = paramView;
        break;
      }
      paramView = (Throwable)new IllegalStateException("Unrecognized View class".toString());
      AppMethodBeat.o(325253);
      throw paramView;
    }
  }
  
  public static final void dH(View paramView)
  {
    AppMethodBeat.i(325262);
    s.u(paramView, "<this>");
    Object localObject = paramView.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams)) {}
    for (localObject = (ViewGroup.MarginLayoutParams)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        ((ViewGroup.MarginLayoutParams)localObject).topMargin = W(paramView, a.c.app_brand_game_capsule_extra_margin_top);
        paramView.requestLayout();
      }
      AppMethodBeat.o(325262);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.p
 * JD-Core Version:    0.7.0.1
 */