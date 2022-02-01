package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/widget/dialog/RequestDialogRotationHelper$onPreDrawOnce$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "luggage-wechat-full-sdk_release"})
public final class m$b
  implements ViewTreeObserver.OnPreDrawListener
{
  m$b(View paramView, a parama) {}
  
  public final boolean onPreDraw()
  {
    AppMethodBeat.i(169661);
    ViewTreeObserver localViewTreeObserver = this.msU.getViewTreeObserver();
    p.j(localViewTreeObserver, "this@onPreDrawOnce.viewTreeObserver");
    if (localViewTreeObserver.isAlive()) {
      this.msU.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
    }
    this.$block.invoke();
    AppMethodBeat.o(169661);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.m.b
 * JD-Core Version:    0.7.0.1
 */