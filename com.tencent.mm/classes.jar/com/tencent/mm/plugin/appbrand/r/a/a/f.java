package com.tencent.mm.plugin.appbrand.r.a.a;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.g.b.v.d;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"ensureGlobalLayoutAtRepeatCount", "", "Landroid/view/View;", "repeat", "", "callback", "Lkotlin/Function0;", "luggage-wxa-app_release"})
public final class f
{
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/appbrand/platform/window/activity/ActivityWindowOrientationHandlerProxyImplKt$ensureGlobalLayoutAtRepeatCount$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "luggage-wxa-app_release"})
  public static final class a
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    a(View paramView, v.d paramd, a parama) {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(176484);
      v.d locald = this.lPp;
      locald.KUO += 1;
      if (locald.KUO < this.lPq)
      {
        AppMethodBeat.o(176484);
        return;
      }
      this.lPo.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      this.gTu.invoke();
      AppMethodBeat.o(176484);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.a.a.f
 * JD-Core Version:    0.7.0.1
 */