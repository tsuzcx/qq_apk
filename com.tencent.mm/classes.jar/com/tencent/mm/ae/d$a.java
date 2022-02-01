package com.tencent.mm.ae;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"com/tencent/mm/kt/CommonKt$afterDelayLayout$layoutListener$1", "Landroid/view/View$OnLayoutChangeListener;", "callRunnable", "Lkotlin/Function0;", "", "getCallRunnable", "()Lkotlin/jvm/functions/Function0;", "onLayoutChange", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "libktcomm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d$a
  implements View.OnLayoutChangeListener
{
  private final a<ah> mHx;
  
  public d$a(a<ah> parama, View paramView)
  {
    AppMethodBeat.i(233411);
    this.mHx = ((a)new a(this.mHy, this.mHz, this));
    AppMethodBeat.o(233411);
  }
  
  private static final void E(a parama)
  {
    AppMethodBeat.i(233416);
    s.u(parama, "$tmp0");
    parama.invoke();
    AppMethodBeat.o(233416);
  }
  
  private static final void F(a parama)
  {
    AppMethodBeat.i(233422);
    s.u(parama, "$tmp0");
    parama.invoke();
    AppMethodBeat.o(233422);
  }
  
  private static final void G(a parama)
  {
    AppMethodBeat.i(233428);
    s.u(parama, "$tmp0");
    parama.invoke();
    AppMethodBeat.o(233428);
  }
  
  public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    AppMethodBeat.i(233444);
    if (paramView == null)
    {
      this.mHz.removeCallbacks(new d.a..ExternalSyntheticLambda0(this.mHx));
      this.mHz.removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
      AppMethodBeat.o(233444);
      return;
    }
    this.mHz.removeCallbacks(new d.a..ExternalSyntheticLambda2(this.mHx));
    this.mHz.postDelayed(new d.a..ExternalSyntheticLambda1(this.mHx), 100L);
    AppMethodBeat.o(233444);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<ah>
  {
    a(a<ah> parama, View paramView, d.a parama1)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ae.d.a
 * JD-Core Version:    0.7.0.1
 */