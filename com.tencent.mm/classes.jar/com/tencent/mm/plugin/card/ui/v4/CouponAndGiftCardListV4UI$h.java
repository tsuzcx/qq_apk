package com.tencent.mm.plugin.card.ui.v4;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.b;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemLongClick"})
final class CouponAndGiftCardListV4UI$h
  implements MRecyclerView.b
{
  CouponAndGiftCardListV4UI$h(CouponAndGiftCardListV4UI paramCouponAndGiftCardListV4UI) {}
  
  public final boolean V(View paramView, int paramInt)
  {
    AppMethodBeat.i(244449);
    CouponAndGiftCardListV4UI localCouponAndGiftCardListV4UI = this.tES;
    p.j(paramView, "view");
    boolean bool = CouponAndGiftCardListV4UI.a(localCouponAndGiftCardListV4UI, paramInt, paramView);
    AppMethodBeat.o(244449);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v4.CouponAndGiftCardListV4UI.h
 * JD-Core Version:    0.7.0.1
 */