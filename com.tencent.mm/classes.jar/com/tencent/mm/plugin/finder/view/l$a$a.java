package com.tencent.mm.plugin.finder.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class l$a$a
  implements View.OnClickListener
{
  l$a$a(d paramd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(205886);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/finder/view/FinderWxProfileHelper$Companion$showWxProfileDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    this.thO.bqD();
    a.a(this, "com/tencent/mm/plugin/finder/view/FinderWxProfileHelper$Companion$showWxProfileDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(205886);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.l.a.a
 * JD-Core Version:    0.7.0.1
 */