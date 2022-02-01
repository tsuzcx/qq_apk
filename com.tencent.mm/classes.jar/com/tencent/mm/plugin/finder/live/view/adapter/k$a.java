package com.tencent.mm.plugin.finder.live.view.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveGiftGridAdapter$FinderLiveGiftItemHolder;", "", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "giftName", "Landroid/widget/TextView;", "getGiftName", "()Landroid/widget/TextView;", "giftPriceGroup", "getGiftPriceGroup", "()Landroid/view/View;", "giftPriceIcon", "Landroid/widget/ImageView;", "getGiftPriceIcon", "()Landroid/widget/ImageView;", "giftPriceTv", "getGiftPriceTv", "giftThumb", "getGiftThumb", "getItemView", "plugin-finder_release"})
public final class k$a
{
  final View amk;
  final ImageView yXF;
  final TextView yXG;
  final View yXH;
  private final ImageView yXI;
  final TextView yXJ;
  
  public k$a(View paramView)
  {
    AppMethodBeat.i(228501);
    this.amk = paramView;
    paramView = this.amk.findViewById(b.f.finder_live_gift_thumb);
    p.j(paramView, "itemView.findViewById(R.id.finder_live_gift_thumb)");
    this.yXF = ((ImageView)paramView);
    paramView = this.amk.findViewById(b.f.finder_live_gift_name);
    p.j(paramView, "itemView.findViewById(R.id.finder_live_gift_name)");
    this.yXG = ((TextView)paramView);
    paramView = this.amk.findViewById(b.f.finder_live_gift_price_group);
    p.j(paramView, "itemView.findViewById(R.…er_live_gift_price_group)");
    this.yXH = paramView;
    paramView = this.amk.findViewById(b.f.finder_live_gift_price_icon);
    p.j(paramView, "itemView.findViewById(R.…der_live_gift_price_icon)");
    this.yXI = ((ImageView)paramView);
    paramView = this.amk.findViewById(b.f.finder_live_gift_price_tv);
    p.j(paramView, "itemView.findViewById(R.…inder_live_gift_price_tv)");
    this.yXJ = ((TextView)paramView);
    this.yXG.setTextSize(1, 12.0F);
    this.yXJ.setTextSize(1, 12.0F);
    AppMethodBeat.o(228501);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.k.a
 * JD-Core Version:    0.7.0.1
 */