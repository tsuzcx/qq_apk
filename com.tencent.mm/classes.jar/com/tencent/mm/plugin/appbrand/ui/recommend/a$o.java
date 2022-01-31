package com.tencent.mm.plugin.appbrand.ui.recommend;

import a.l;
import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.protocal.protobuf.bsi;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$1$6"})
final class a$o
  implements View.OnLongClickListener
{
  a$o(a parama, bsi parambsi, WxaAttributes paramWxaAttributes, int paramInt, Context paramContext) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(135165);
    com.tencent.mm.pluginsdk.f.a.b((CharSequence)"", (CharSequence)(this.iWg.iFH.toString() + "," + this.iWg.xFR + "," + this.iWg.xFL));
    AppMethodBeat.o(135165);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.a.o
 * JD-Core Version:    0.7.0.1
 */