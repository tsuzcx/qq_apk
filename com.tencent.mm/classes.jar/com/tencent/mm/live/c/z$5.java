package com.tencent.mm.live.c;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.MMActivity;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class z$5
  implements View.OnClickListener
{
  z$5(z paramz) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(216087);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/live/plugin/LiveInputPlugin$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    z.m(this.gYc);
    paramView = z.d(this.gYc);
    if (paramView == null)
    {
      paramView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(216087);
      throw paramView;
    }
    ((MMActivity)paramView).hideVKB();
    z.n(this.gYc);
    a.a(this, "com/tencent/mm/live/plugin/LiveInputPlugin$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(216087);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.c.z.5
 * JD-Core Version:    0.7.0.1
 */