package com.tencent.mm.plugin.appbrand.ui.recommend;

import a.f.b.j;
import a.l;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithFooterViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$BaseRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "footer", "Landroid/view/ViewGroup;", "getFooter", "()Landroid/view/ViewGroup;", "footerAppName", "Landroid/widget/TextView;", "getFooterAppName", "()Landroid/widget/TextView;", "footerIcon", "Landroid/widget/ImageView;", "getFooterIcon", "()Landroid/widget/ImageView;", "plugin-appbrand-integration_release"})
public class a$j
  extends a.c
{
  final ImageView iWb;
  final TextView iWc;
  final ViewGroup iWd;
  
  public a$j(View paramView)
  {
    super(paramView, localObject);
    AppMethodBeat.i(135159);
    paramView = localObject.findViewById(2131821364);
    j.p(paramView, "itemView.findViewById(R.…nd_recommend_footer_icon)");
    this.iWb = ((ImageView)paramView);
    paramView = localObject.findViewById(2131821358);
    j.p(paramView, "itemView.findViewById(R.…ecommend_footer_app_name)");
    this.iWc = ((TextView)paramView);
    paramView = localObject.findViewById(2131821363);
    j.p(paramView, "itemView.findViewById(R.…p_brand_recommend_footer)");
    this.iWd = ((ViewGroup)paramView);
    AppMethodBeat.o(135159);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.a.j
 * JD-Core Version:    0.7.0.1
 */