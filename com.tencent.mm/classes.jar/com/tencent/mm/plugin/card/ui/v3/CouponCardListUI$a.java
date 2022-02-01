package com.tencent.mm.plugin.card.ui.v3;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.j;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CardSpan;", "Lcom/tencent/mm/pluginsdk/ui/span/PressableClickSpan;", "linkColor", "", "bgColor", "listener", "Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickListener;", "(Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI;IILcom/tencent/mm/pluginsdk/ui/span/MMSpanClickListener;)V", "onClick", "", "widget", "Landroid/view/View;", "plugin-card_release"})
public final class CouponCardListUI$a
  extends com.tencent.mm.pluginsdk.ui.span.p
{
  public CouponCardListUI$a(int paramInt1, int paramInt2, j paramj)
  {
    super(paramInt2, paramj);
    AppMethodBeat.i(201487);
    this.mClickListener = localObject;
    AppMethodBeat.o(201487);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(201486);
    kotlin.g.b.p.h(paramView, "widget");
    if (this.mClickListener != null) {
      this.mClickListener.a(paramView, null);
    }
    AppMethodBeat.o(201486);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v3.CouponCardListUI.a
 * JD-Core Version:    0.7.0.1
 */