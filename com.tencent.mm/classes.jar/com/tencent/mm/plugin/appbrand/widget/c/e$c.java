package com.tencent.mm.plugin.appbrand.widget.c;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.t;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class e$c
  implements View.OnClickListener
{
  e$c(t paramt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(274732);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/appbrand/widget/halfscreen/HalfScreenManger$trySetupHalfScreenCapsuleBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    this.oRb.close();
    a.a(this, "com/tencent/mm/plugin/appbrand/widget/halfscreen/HalfScreenManger$trySetupHalfScreenCapsuleBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(274732);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.c.e.c
 * JD-Core Version:    0.7.0.1
 */