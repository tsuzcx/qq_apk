package com.tencent.mm.plugin.finder.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class l$a$h
  implements View.OnClickListener
{
  public static final h tic;
  
  static
  {
    AppMethodBeat.i(205897);
    tic = new h();
    AppMethodBeat.o(205897);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(205896);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/finder/view/FinderWxProfileHelper$Companion$updateWxProfile$1$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    a.a(this, "com/tencent/mm/plugin/finder/view/FinderWxProfileHelper$Companion$updateWxProfile$1$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(205896);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.l.a.h
 * JD-Core Version:    0.7.0.1
 */