package com.tencent.mm.live.c;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class c$2
  implements View.OnClickListener
{
  public static final 2 gSO;
  
  static
  {
    AppMethodBeat.i(212294);
    gSO = new 2();
    AppMethodBeat.o(212294);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(212293);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/live/plugin/LiveAfterPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    a.a(this, "com/tencent/mm/live/plugin/LiveAfterPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(212293);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.c.c.2
 * JD-Core Version:    0.7.0.1
 */