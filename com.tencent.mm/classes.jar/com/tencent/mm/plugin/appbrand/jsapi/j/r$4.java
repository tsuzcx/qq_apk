package com.tencent.mm.plugin.appbrand.jsapi.j;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.widget.a.e;

final class r$4
  implements View.OnClickListener
{
  r$4(r paramr, e parame) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(269010);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/appbrand/jsapi/lbs/JsApiOpenMapApp$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    this.jaP.bYF();
    a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/lbs/JsApiOpenMapApp$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(269010);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.r.4
 * JD-Core Version:    0.7.0.1
 */