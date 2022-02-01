package com.tencent.mm.plugin.appbrand.s.a.a;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.g.b.v.c;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"ensureGlobalLayoutAtRepeatCount", "", "Landroid/view/View;", "repeat", "", "callback", "Lkotlin/Function0;", "luggage-wxa-app_release"})
public final class f
{
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/appbrand/platform/window/activity/ActivityWindowOrientationHandlerProxyImplKt$ensureGlobalLayoutAtRepeatCount$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "luggage-wxa-app_release"})
  public static final class a
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    a(View paramView, v.c paramc, a parama) {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(176484);
      v.c localc = this.lno;
      localc.Jhu += 1;
      if (localc.Jhu < this.lnp)
      {
        AppMethodBeat.o(176484);
        return;
      }
      this.lnn.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      this.jQC.invoke();
      AppMethodBeat.o(176484);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.a.a.f
 * JD-Core Version:    0.7.0.1
 */