package com.tencent.mm.plugin.appbrand.platform.window.a;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.a;
import kotlin.g.b.aa.d;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"ensureGlobalLayoutAtRepeatCount", "", "Landroid/view/View;", "repeat", "", "callback", "Lkotlin/Function0;", "luggage-wxa-app_release"})
public final class f
{
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/platform/window/activity/ActivityWindowOrientationHandlerProxyImplKt$ensureGlobalLayoutAtRepeatCount$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "luggage-wxa-app_release"})
  public static final class a
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    a(View paramView, aa.d paramd, a parama) {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(176484);
      aa.d locald = this.qGZ;
      locald.aaBA += 1;
      if (locald.aaBA < this.qHa)
      {
        AppMethodBeat.o(176484);
        return;
      }
      this.qGY.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      this.kWs.invoke();
      AppMethodBeat.o(176484);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.a.f
 * JD-Core Version:    0.7.0.1
 */