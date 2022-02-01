package com.tencent.mm.live.c;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class t$1
  implements View.OnClickListener
{
  public static final 1 kED;
  
  static
  {
    AppMethodBeat.i(200157);
    kED = new 1();
    AppMethodBeat.o(200157);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(200154);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/live/plugin/LiveFaceVerifyPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    a.a(this, "com/tencent/mm/live/plugin/LiveFaceVerifyPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(200154);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.c.t.1
 * JD-Core Version:    0.7.0.1
 */