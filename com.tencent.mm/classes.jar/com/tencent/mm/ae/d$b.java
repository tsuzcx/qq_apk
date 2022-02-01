package com.tencent.mm.ae;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnLayoutChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/kt/CommonKt$afterDelayLayout$stateListener$1", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", "p0", "Landroid/view/View;", "onViewDetachedFromWindow", "libktcomm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d$b
  implements View.OnAttachStateChangeListener
{
  public d$b(d.a parama, View paramView) {}
  
  public final void onViewAttachedToWindow(View paramView) {}
  
  public final void onViewDetachedFromWindow(View paramView)
  {
    AppMethodBeat.i(233417);
    this.mHB.onLayoutChange(null, 0, 0, 0, 0, 0, 0, 0, 0);
    this.mHz.removeOnLayoutChangeListener((View.OnLayoutChangeListener)this.mHB);
    AppMethodBeat.o(233417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ae.d.b
 * JD-Core Version:    0.7.0.1
 */