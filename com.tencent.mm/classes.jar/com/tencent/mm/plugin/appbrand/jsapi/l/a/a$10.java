package com.tencent.mm.plugin.appbrand.jsapi.l.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;

final class a$10
  implements View.OnClickListener
{
  a$10(a parama, boolean paramBoolean, b.n paramn, String paramString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(187178);
    b localb = new b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/jsapi/map/mapsdk/DefaultTencentMapView$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if ((this.oXy) && (this.oXA != null)) {
      this.oXA.ahG(this.val$data);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/map/mapsdk/DefaultTencentMapView$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(187178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.a.a.10
 * JD-Core Version:    0.7.0.1
 */