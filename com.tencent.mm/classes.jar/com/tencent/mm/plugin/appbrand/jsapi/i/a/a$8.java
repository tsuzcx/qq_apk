package com.tencent.mm.plugin.appbrand.jsapi.i.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;

final class a$8
  implements View.OnClickListener
{
  a$8(a parama, boolean paramBoolean, b.n paramn, String paramString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(146467);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/map/mapsdk/DefaultTencentMapView$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if ((this.kQR) && (this.kQT != null)) {
      this.kQT.PH(this.val$data);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/map/mapsdk/DefaultTencentMapView$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(146467);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.a.a.8
 * JD-Core Version:    0.7.0.1
 */