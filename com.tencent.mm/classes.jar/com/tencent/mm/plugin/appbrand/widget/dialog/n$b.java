package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/widget/dialog/RequestDialogRotationHelper$onPreDrawOnce$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "luggage-wechat-full-sdk_release"})
public final class n$b
  implements ViewTreeObserver.OnPreDrawListener
{
  n$b(View paramView, a parama) {}
  
  public final boolean onPreDraw()
  {
    AppMethodBeat.i(169661);
    ViewTreeObserver localViewTreeObserver = this.iGF.getViewTreeObserver();
    p.g(localViewTreeObserver, "this@onPreDrawOnce.viewTreeObserver");
    if (localViewTreeObserver.isAlive()) {
      this.iGF.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
    }
    this.gIz.invoke();
    AppMethodBeat.o(169661);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.n.b
 * JD-Core Version:    0.7.0.1
 */