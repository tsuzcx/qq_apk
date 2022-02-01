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
    AppMethodBeat.i(227224);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/HybridOpenMaterialView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "init, touch outside");
    if (HybridOpenMaterialView.a(this.nmO)) {
      this.nmO.hide();
    }
    a.a(this, "com/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/HybridOpenMaterialView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(227224);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.HybridOpenMaterialView.1
 * JD-Core Version:    0.7.0.1
 */