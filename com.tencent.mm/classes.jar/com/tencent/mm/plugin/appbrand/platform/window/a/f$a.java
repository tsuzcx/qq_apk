package com.tencent.mm.plugin.appbrand.platform.window.a;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.a;
import kotlin.g.b.z.d;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/platform/window/activity/ActivityWindowOrientationHandlerProxyImplKt$ensureGlobalLayoutAtRepeatCount$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "luggage-wxa-app_release"})
public final class f$a
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  f$a(View paramView, z.d paramd, a parama) {}
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(176484);
    z.d locald = this.nEO;
    locald.SYE += 1;
    if (locald.SYE < this.nEP)
    {
      AppMethodBeat.o(176484);
      return;
    }
    this.nEN.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
    this.ihE.invoke();
    AppMethodBeat.o(176484);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.a.f.a
 * JD-Core Version:    0.7.0.1
 */