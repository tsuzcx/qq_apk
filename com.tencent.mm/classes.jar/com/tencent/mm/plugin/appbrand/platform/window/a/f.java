package com.tencent.mm.plugin.appbrand.platform.window.a;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.g.b.y.d;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"ensureGlobalLayoutAtRepeatCount", "", "Landroid/view/View;", "repeat", "", "callback", "Lkotlin/Function0;", "luggage-wxa-app_release"})
public final class f
{
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/platform/window/activity/ActivityWindowOrientationHandlerProxyImplKt$ensureGlobalLayoutAtRepeatCount$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "luggage-wxa-app_release"})
  public static final class a
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    a(View paramView, y.d paramd, a parama) {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(176484);
      y.d locald = this.muf;
      locald.NiW += 1;
      if (locald.NiW < this.mug)
      {
        AppMethodBeat.o(176484);
        return;
      }
      this.mue.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      this.hok.invoke();
      AppMethodBeat.o(176484);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.a.f
 * JD-Core Version:    0.7.0.1
 */