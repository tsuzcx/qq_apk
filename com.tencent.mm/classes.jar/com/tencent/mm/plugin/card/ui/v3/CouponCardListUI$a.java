package com.tencent.mm.plugin.card.ui.v3;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.n;
import com.tencent.mm.pluginsdk.ui.span.t;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CardSpan;", "Lcom/tencent/mm/pluginsdk/ui/span/PressableClickSpan;", "linkColor", "", "bgColor", "listener", "Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickListener;", "(Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI;IILcom/tencent/mm/pluginsdk/ui/span/MMSpanClickListener;)V", "onClick", "", "widget", "Landroid/view/View;", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class CouponCardListUI$a
  extends t
{
  public CouponCardListUI$a(int paramInt1, int paramInt2, n paramn)
  {
    super(paramInt2, paramn);
    AppMethodBeat.i(293887);
    this.mClickListener = localObject;
    AppMethodBeat.o(293887);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(293892);
    s.u(paramView, "widget");
    if (this.mClickListener != null) {
      this.mClickListener.a(paramView, null);
    }
    AppMethodBeat.o(293892);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v3.CouponCardListUI.a
 * JD-Core Version:    0.7.0.1
 */