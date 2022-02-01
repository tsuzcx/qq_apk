package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.protocal.protobuf.dko;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$1$6"})
final class a$o
  implements View.OnLongClickListener
{
  a$o(a parama, dko paramdko, WxaAttributes paramWxaAttributes, int paramInt, Context paramContext) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(51331);
    b localb = new b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$$inlined$let$lambda$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
    ClipboardHelper.setText((Context)this.oeK.activity, (CharSequence)"", (CharSequence)(this.oeX.nHd.toString() + "," + this.oeX.MOA + "," + this.oeX.gTT));
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$$inlined$let$lambda$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(51331);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.a.o
 * JD-Core Version:    0.7.0.1
 */