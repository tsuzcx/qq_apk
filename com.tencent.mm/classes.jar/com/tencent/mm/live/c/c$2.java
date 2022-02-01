package com.tencent.mm.live.c;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class c$2
  implements View.OnClickListener
{
  public static final 2 kCN;
  
  static
  {
    AppMethodBeat.i(190587);
    kCN = new 2();
    AppMethodBeat.o(190587);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(190583);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/live/plugin/LiveAfterPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    a.a(this, "com/tencent/mm/live/plugin/LiveAfterPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(190583);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.c.c.2
 * JD-Core Version:    0.7.0.1
 */