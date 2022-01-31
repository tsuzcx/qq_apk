package com.tencent.mm.plugin.appbrand.ui.recommend;

import a.f.b.j;
import a.l;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$VideoRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithContentDescViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "videoIcon", "Landroid/widget/ImageView;", "getVideoIcon", "()Landroid/widget/ImageView;", "plugin-appbrand-integration_release"})
public final class a$h
  extends a.i
{
  final ImageView iJO;
  
  public a$h(View paramView)
  {
    super(paramView, localObject);
    AppMethodBeat.i(135157);
    paramView = localObject.findViewById(2131821362);
    j.p(paramView, "itemView.findViewById(R.…rand_recommend_play_icon)");
    this.iJO = ((ImageView)paramView);
    AppMethodBeat.o(135157);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.a.h
 * JD-Core Version:    0.7.0.1
 */