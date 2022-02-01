package com.tencent.mm.live.c;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class z$4
  implements View.OnClickListener
{
  public static final 4 gYf;
  
  static
  {
    AppMethodBeat.i(216086);
    gYf = new 4();
    AppMethodBeat.o(216086);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(216085);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/live/plugin/LiveInputPlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    a.a(this, "com/tencent/mm/live/plugin/LiveInputPlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(216085);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.c.z.4
 * JD-Core Version:    0.7.0.1
 */