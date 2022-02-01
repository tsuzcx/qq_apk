package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/widget/dialog/RequestDialogRotationHelper$onPreDrawOnce$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t$b
  implements ViewTreeObserver.OnPreDrawListener
{
  t$b(View paramView, a<ah> parama) {}
  
  public final boolean onPreDraw()
  {
    AppMethodBeat.i(169661);
    if (this.plb.getViewTreeObserver().isAlive()) {
      this.plb.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
    }
    this.$block.invoke();
    AppMethodBeat.o(169661);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.t.b
 * JD-Core Version:    0.7.0.1
 */