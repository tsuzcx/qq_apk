package com.tencent.mm.plugin.appbrand.ui.recommend;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.protocal.protobuf.bsi;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$1$1"})
final class a$l
  implements View.OnClickListener
{
  a$l(a.c paramc, a parama, bsi parambsi, WxaAttributes paramWxaAttributes, int paramInt, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(135162);
    paramView = this.iVT;
    Object localObject = this.iWf.aku;
    j.p(localObject, "baseViewHolder.itemView");
    localObject = ((View)localObject).getContext();
    j.p(localObject, "baseViewHolder.itemView.context");
    paramView.a((Context)localObject, this.iWh, this.iWg, this.iWi, true);
    AppMethodBeat.o(135162);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.a.l
 * JD-Core Version:    0.7.0.1
 */