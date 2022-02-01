package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalAuthorizePesenterViewUtilsKt$doOnPreDraw$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "plugin-appbrand-integration_release"})
public final class c$a
  implements ViewTreeObserver.OnPreDrawListener
{
  public c$a(View paramView, c paramc) {}
  
  public final boolean onPreDraw()
  {
    AppMethodBeat.i(280615);
    this.qco.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
    Object localObject2 = c.g(this.qcy).getParent();
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof ViewGroup)) {
      localObject1 = null;
    }
    localObject1 = (ViewGroup)localObject1;
    if (localObject1 == null) {}
    for (;;)
    {
      AppMethodBeat.o(280615);
      return true;
      if (((ViewGroup)localObject1).getMeasuredHeight() > c.g(this.qcy).getMeasuredHeight())
      {
        localObject2 = c.g(this.qcy).getLayoutParams();
        if (localObject2 != null) {
          ((ViewGroup.LayoutParams)localObject2).height = ((ViewGroup)localObject1).getMeasuredHeight();
        }
        c.g(this.qcy).requestLayout();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a.c.a
 * JD-Core Version:    0.7.0.1
 */