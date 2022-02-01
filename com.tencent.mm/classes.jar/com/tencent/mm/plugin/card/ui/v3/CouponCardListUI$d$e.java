package com.tencent.mm.plugin.card.ui.v3;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.span.i;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$onBindViewHolder$span$1", "Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickListener;", "onClick", "", "widget", "Landroid/view/View;", "hrefInfo", "Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;", "plugin-card_release"})
public final class CouponCardListUI$d$e
  extends i
{
  public final void a(View paramView, u paramu)
  {
    AppMethodBeat.i(192755);
    paramu = this.nHj.nHi;
    if (paramu == null) {
      k.aPZ("headerClickListener");
    }
    paramu.onClick(paramView);
    AppMethodBeat.o(192755);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v3.CouponCardListUI.d.e
 * JD-Core Version:    0.7.0.1
 */