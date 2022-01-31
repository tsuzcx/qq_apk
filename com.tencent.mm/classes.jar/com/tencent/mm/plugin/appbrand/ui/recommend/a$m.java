package com.tencent.mm.plugin.appbrand.ui.recommend;

import a.f.a.m;
import a.l;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.protocal.protobuf.bsi;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$1$4"})
final class a$m
  implements View.OnClickListener
{
  a$m(a parama, bsi parambsi, WxaAttributes paramWxaAttributes, int paramInt, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(135163);
    paramView = new Intent((Context)this.iVT.activity, AppBrandRecommendVideoUI.class);
    paramView.putExtra("1", this.iWg.xFM);
    this.iVT.activity.startActivity(paramView);
    this.iVT.iVP.h(this.iWg, Integer.valueOf(this.iWi));
    AppMethodBeat.o(135163);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.a.m
 * JD-Core Version:    0.7.0.1
 */