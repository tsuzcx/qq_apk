package com.tencent.mm.plugin.appbrand.ui.recommend;

import a.f.b.j;
import a.l;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$AppRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$BaseRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "appName", "Landroid/widget/TextView;", "getAppName", "()Landroid/widget/TextView;", "contentDesc", "getContentDesc", "plugin-appbrand-integration_release"})
public final class a$a
  extends a.c
{
  final TextView iVR;
  final TextView iVS;
  
  public a$a(View paramView)
  {
    super(paramView, localObject);
    AppMethodBeat.i(135151);
    paramView = localObject.findViewById(2131821360);
    j.p(paramView, "itemView.findViewById(R.…d_recommend_content_desc)");
    this.iVR = ((TextView)paramView);
    paramView = localObject.findViewById(2131821358);
    j.p(paramView, "itemView.findViewById(R.…ecommend_footer_app_name)");
    this.iVS = ((TextView)paramView);
    AppMethodBeat.o(135151);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.a.a
 * JD-Core Version:    0.7.0.1
 */