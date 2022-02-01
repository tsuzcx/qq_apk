package com.tencent.mm.plugin.appbrand.jsapi.o.a;

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
    AppMethodBeat.i(329457);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/jsapi/map/mapsdk/DefaultTencentMapView$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if ((this.scY) && (this.sda != null)) {
      this.sda.aaD(this.val$data);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/map/mapsdk/DefaultTencentMapView$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(329457);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.a.a.10
 * JD-Core Version:    0.7.0.1
 */