package com.tencent.mm.plugin.appbrand.ui.recommend;

import a.l;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.protocal.protobuf.bsi;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$1$5"})
final class a$n
  implements View.OnClickListener
{
  a$n(a.c paramc, a parama, bsi parambsi, WxaAttributes paramWxaAttributes, int paramInt, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(135164);
    if (this.iWg.iFL == 4)
    {
      paramView = this.iVT;
      localObject1 = this.iWf.aku;
      a.f.b.j.p(localObject1, "baseViewHolder.itemView");
      localObject1 = ((View)localObject1).getContext();
      a.f.b.j.p(localObject1, "baseViewHolder.itemView.context");
      paramView.a((Context)localObject1, this.iWh, this.iWg, this.iWi, false);
      AppMethodBeat.o(135164);
      return;
    }
    Object localObject1 = this.iWg.iFJ;
    paramView = (View)localObject1;
    Object localObject2;
    if (this.iWg.iFK != null)
    {
      localObject2 = this.iWg.iFK;
      a.f.b.j.p(localObject2, "itemData.page_param");
      paramView = (View)localObject1;
      if (!a.l.m.ap((CharSequence)localObject2)) {
        paramView = (String)localObject1 + "?" + this.iWg.iFK;
      }
    }
    localObject1 = new AppBrandStatObject();
    ((AppBrandStatObject)localObject1).scene = 1118;
    ((AppBrandStatObject)localObject1).cJb = 14;
    if (!TextUtils.isEmpty((CharSequence)this.iWg.iFI)) {
      ((AppBrandStatObject)localObject1).cmF = (this.iWg.iFH + ":" + this.iWg.iFI.toString());
    }
    for (((AppBrandStatObject)localObject1).cJc = (this.iWg.iFH + ":" + this.iWg.iFI.toString());; ((AppBrandStatObject)localObject1).cJc = this.iWg.iFH)
    {
      ((AppBrandStatObject)localObject1).iFY = a.a(this.iWh, this.iWg, this.iWi);
      if (this.iWh != null)
      {
        localObject2 = this.iWh;
        if (localObject2 != null)
        {
          localObject2 = ((WxaAttributes)localObject2).ayE();
          if (localObject2 != null)
          {
            int i = ((WxaAttributes.WxaVersionInfo)localObject2).bDc;
            ((com.tencent.mm.plugin.appbrand.service.j)g.E(com.tencent.mm.plugin.appbrand.service.j.class)).a(this.faP, this.iWg.xFL, this.iWh.field_appId, 0, i, paramView, (AppBrandStatObject)localObject1);
          }
        }
      }
      this.iVT.iVP.h(this.iWg, Integer.valueOf(this.iWi));
      AppMethodBeat.o(135164);
      return;
      ((AppBrandStatObject)localObject1).cmF = this.iWg.iFH;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.a.n
 * JD-Core Version:    0.7.0.1
 */