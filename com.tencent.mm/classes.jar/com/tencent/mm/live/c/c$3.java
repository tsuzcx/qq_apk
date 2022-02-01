package com.tencent.mm.live.c;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class c$3
  implements View.OnClickListener
{
  public static final 3 hOs;
  
  static
  {
    AppMethodBeat.i(207878);
    hOs = new 3();
    AppMethodBeat.o(207878);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(207877);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/live/plugin/LiveAfterPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    a.a(this, "com/tencent/mm/live/plugin/LiveAfterPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(207877);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.c.c.3
 * JD-Core Version:    0.7.0.1
 */