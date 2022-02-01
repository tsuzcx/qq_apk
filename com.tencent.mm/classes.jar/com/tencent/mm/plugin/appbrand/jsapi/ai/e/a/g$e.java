package com.tencent.mm.plugin.appbrand.jsapi.ai.e.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.g.a.m;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class g$e
  implements View.OnClickListener
{
  g$e(g paramg) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(139700);
    b localb = new b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    paramView = g.d(this.pMR);
    if (paramView != null) {
      paramView.invoke();
    }
    paramView = g.c(this.pMR);
    if (paramView != null) {
      paramView.invoke(null, Integer.valueOf(0));
    }
    this.pMR.bYF();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(139700);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ai.e.a.g.e
 * JD-Core Version:    0.7.0.1
 */