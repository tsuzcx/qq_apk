package com.tencent.mm.plugin.appbrand.jsapi.ac.e.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import d.g.a.m;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class g$e
  implements View.OnClickListener
{
  g$e(g paramg) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(139700);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    paramView = g.d(this.lzS);
    if (paramView != null) {
      paramView.invoke();
    }
    paramView = g.c(this.lzS);
    if (paramView != null) {
      paramView.p(null, Integer.valueOf(0));
    }
    this.lzS.bpT();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(139700);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ac.e.a.g.e
 * JD-Core Version:    0.7.0.1
 */