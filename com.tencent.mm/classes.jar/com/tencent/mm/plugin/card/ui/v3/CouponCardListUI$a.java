package com.tencent.mm.plugin.card.ui.v3;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.i;
import com.tencent.mm.pluginsdk.ui.span.o;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CardSpan;", "Lcom/tencent/mm/pluginsdk/ui/span/PressableClickSpan;", "linkColor", "", "bgColor", "listener", "Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickListener;", "(Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI;IILcom/tencent/mm/pluginsdk/ui/span/MMSpanClickListener;)V", "onClick", "", "widget", "Landroid/view/View;", "plugin-card_release"})
public final class CouponCardListUI$a
  extends o
{
  public CouponCardListUI$a(int paramInt1, int paramInt2, i parami)
  {
    super(paramInt2, parami);
    AppMethodBeat.i(192747);
    this.mClickListener = localObject;
    AppMethodBeat.o(192747);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(192746);
    k.h(paramView, "widget");
    if (this.mClickListener != null) {
      this.mClickListener.a(paramView, null);
    }
    AppMethodBeat.o(192746);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v3.CouponCardListUI.a
 * JD-Core Version:    0.7.0.1
 */