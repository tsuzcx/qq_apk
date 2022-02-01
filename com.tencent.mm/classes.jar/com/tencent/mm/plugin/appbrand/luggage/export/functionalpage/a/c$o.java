package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a;

import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalAuthorizePesenterViewUtilsKt$doOnPreDraw$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "plugin-appbrand-integration_release"})
public final class c$o
  implements ViewTreeObserver.OnPreDrawListener
{
  public c$o(View paramView) {}
  
  public final boolean onPreDraw()
  {
    AppMethodBeat.i(189505);
    this.lPR.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
    View localView = this.lPR;
    localView.setTranslationY(localView.getMeasuredHeight());
    localView.animate().setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator()).translationY(0.0F).setDuration(300L).start();
    AppMethodBeat.o(189505);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a.c.o
 * JD-Core Version:    0.7.0.1
 */