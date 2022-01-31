package com.tencent.mm.plugin.appbrand.ui.recommend;

import a.f.b.j;
import a.l;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$GoodsAppRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithFooterViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "discountPrice", "Landroid/widget/TextView;", "getDiscountPrice", "()Landroid/widget/TextView;", "goodsName", "getGoodsName", "originPrice", "getOriginPrice", "plugin-appbrand-integration_release"})
public final class a$f
  extends a.j
{
  final TextView iVY;
  final TextView iVZ;
  final TextView iWa;
  
  public a$f(View paramView)
  {
    super(paramView, localObject);
    AppMethodBeat.i(135155);
    paramView = localObject.findViewById(2131821366);
    j.p(paramView, "itemView.findViewById(R.…and_recommend_goods_name)");
    this.iVY = ((TextView)paramView);
    paramView = localObject.findViewById(2131821367);
    j.p(paramView, "itemView.findViewById(R.…recommend_discount_price)");
    this.iVZ = ((TextView)paramView);
    paramView = localObject.findViewById(2131821368);
    j.p(paramView, "itemView.findViewById(R.…d_recommend_origin_price)");
    this.iWa = ((TextView)paramView);
    AppMethodBeat.o(135155);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.a.f
 * JD-Core Version:    0.7.0.1
 */