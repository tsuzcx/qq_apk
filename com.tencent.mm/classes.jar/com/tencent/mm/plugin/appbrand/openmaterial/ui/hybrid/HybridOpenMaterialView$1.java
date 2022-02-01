package com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

final class HybridOpenMaterialView$1
  implements View.OnClickListener
{
  HybridOpenMaterialView$1(HybridOpenMaterialView paramHybridOpenMaterialView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(323737);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/HybridOpenMaterialView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "init, touch outside");
    if (HybridOpenMaterialView.a(this.ttd)) {
      this.ttd.hide();
    }
    a.a(this, "com/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/HybridOpenMaterialView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(323737);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.HybridOpenMaterialView.1
 * JD-Core Version:    0.7.0.1
 */