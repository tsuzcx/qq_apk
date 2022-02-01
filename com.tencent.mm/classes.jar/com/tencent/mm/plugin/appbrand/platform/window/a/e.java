package com.tencent.mm.plugin.appbrand.platform.window.a;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.ah.d;

@Metadata(d1={""}, d2={"ensureGlobalLayoutAtRepeatCount", "", "Landroid/view/View;", "repeat", "", "callback", "Lkotlin/Function0;", "luggage-wxa-app_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class e
{
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/platform/window/activity/ActivityWindowOrientationHandlerProxyImplKt$ensureGlobalLayoutAtRepeatCount$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    a(ah.d paramd, View paramView, a<ah> parama) {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(176484);
      this.tLH.aixb += 1;
      if (this.tLH.aixb < this.tLI)
      {
        AppMethodBeat.o(176484);
        return;
      }
      this.tLJ.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      this.nBK.invoke();
      AppMethodBeat.o(176484);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.a.e
 * JD-Core Version:    0.7.0.1
 */