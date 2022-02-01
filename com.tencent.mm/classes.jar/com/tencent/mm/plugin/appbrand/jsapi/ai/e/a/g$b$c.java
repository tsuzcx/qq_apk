package com.tencent.mm.plugin.appbrand.jsapi.ai.e.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class g$b$c
  implements View.OnClickListener
{
  g$b$c(g.b paramb, int paramInt1, int paramInt2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(139690);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter$bindDeviceViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    int i;
    if (g.c(this.pMX.pMR) != null)
    {
      if (((Collection)this.pMX.pMR.pMO.pNN).isEmpty()) {
        break label164;
      }
      i = 1;
      if ((i == 0) || (this.pMZ > this.pMX.pMR.pMO.pNN.size())) {
        break label169;
      }
      paramView = g.c(this.pMX.pMR);
      if (paramView == null) {
        p.iCn();
      }
      paramView.invoke(g.b.a(this.pMX, this.pMZ).pMy, Integer.valueOf(this.jEN));
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter$bindDeviceViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(139690);
      return;
      label164:
      i = 0;
      break;
      label169:
      paramView = g.c(this.pMX.pMR);
      if (paramView == null) {
        p.iCn();
      }
      paramView.invoke(g.b.a(this.pMX, this.pMZ).pMy, Integer.valueOf(this.jEN));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ai.e.a.g.b.c
 * JD-Core Version:    0.7.0.1
 */