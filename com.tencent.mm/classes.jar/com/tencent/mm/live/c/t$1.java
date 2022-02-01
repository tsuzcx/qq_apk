package com.tencent.mm.live.c;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class t$1
  implements View.OnClickListener
{
  public static final 1 gXl;
  
  static
  {
    AppMethodBeat.i(216038);
    gXl = new 1();
    AppMethodBeat.o(216038);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(216037);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/live/plugin/LiveFaceVerifyPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    a.a(this, "com/tencent/mm/live/plugin/LiveFaceVerifyPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(216037);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.c.t.1
 * JD-Core Version:    0.7.0.1
 */