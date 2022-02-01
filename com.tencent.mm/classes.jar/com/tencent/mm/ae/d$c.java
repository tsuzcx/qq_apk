package com.tencent.mm.ae;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/kt/CommonKt$afterLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "libktcomm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d$c
  implements View.OnLayoutChangeListener
{
  d$c(View paramView, a<ah> parama) {}
  
  private static final void E(a parama)
  {
    AppMethodBeat.i(233409);
    s.u(parama, "$call");
    parama.invoke();
    AppMethodBeat.o(233409);
  }
  
  public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    AppMethodBeat.i(233421);
    this.mHC.post(new d.c..ExternalSyntheticLambda0(this.mHy));
    this.mHC.removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
    AppMethodBeat.o(233421);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ae.d.c
 * JD-Core Version:    0.7.0.1
 */