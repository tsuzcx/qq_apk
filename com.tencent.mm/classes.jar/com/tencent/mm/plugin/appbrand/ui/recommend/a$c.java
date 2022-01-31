package com.tencent.mm.plugin.appbrand.ui.recommend;

import a.f.b.j;
import a.l;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$BaseRecommendViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "content", "Landroid/view/ViewGroup;", "getContent", "()Landroid/view/ViewGroup;", "contentIcon", "Landroid/widget/ImageView;", "getContentIcon", "()Landroid/widget/ImageView;", "recommendReasonTv", "Landroid/widget/TextView;", "getRecommendReasonTv", "()Landroid/widget/TextView;", "plugin-appbrand-integration_release"})
public class a$c
  extends RecyclerView.v
{
  final ImageView iVV;
  final TextView iVW;
  final ViewGroup iVX;
  
  public a$c(View paramView)
  {
    super(localObject);
    AppMethodBeat.i(135153);
    paramView = localObject.findViewById(2131821359);
    j.p(paramView, "itemView.findViewById(R.…d_recommend_content_icon)");
    this.iVV = ((ImageView)paramView);
    paramView = localObject.findViewById(2131821369);
    j.p(paramView, "itemView.findViewById(R.…p_brand_recommend_reason)");
    this.iVW = ((TextView)paramView);
    paramView = localObject.findViewById(2131821357);
    j.p(paramView, "itemView.findViewById(R.…_brand_recommend_content)");
    this.iVX = ((ViewGroup)paramView);
    AppMethodBeat.o(135153);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.a.c
 * JD-Core Version:    0.7.0.1
 */