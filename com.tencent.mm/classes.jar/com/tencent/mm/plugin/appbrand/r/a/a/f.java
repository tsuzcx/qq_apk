package com.tencent.mm.plugin.appbrand.r.a.a;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.g.b.y.d;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"ensureGlobalLayoutAtRepeatCount", "", "Landroid/view/View;", "repeat", "", "callback", "Lkotlin/Function0;", "luggage-wxa-app_release"})
public final class f
{
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/platform/window/activity/ActivityWindowOrientationHandlerProxyImplKt$ensureGlobalLayoutAtRepeatCount$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "luggage-wxa-app_release"})
  public static final class a
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    a(View paramView, y.d paramd, a parama) {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(176484);
      y.d locald = this.mpe;
      locald.MLT += 1;
      if (locald.MLT < this.mpf)
      {
        AppMethodBeat.o(176484);
        return;
      }
      this.mpd.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      this.hlv.invoke();
      AppMethodBeat.o(176484);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.a.a.f
 * JD-Core Version:    0.7.0.1
 */