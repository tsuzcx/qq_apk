package com.tencent.mm.live.c;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class c$3
  implements View.OnClickListener
{
  public static final 3 gVy;
  
  static
  {
    AppMethodBeat.i(215916);
    gVy = new 3();
    AppMethodBeat.o(215916);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(215915);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/live/plugin/LiveAfterPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    a.a(this, "com/tencent/mm/live/plugin/LiveAfterPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(215915);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.c.c.3
 * JD-Core Version:    0.7.0.1
 */