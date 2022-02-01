package com.tencent.mm.plugin.finder.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.view.d;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class FinderPostUI$o
  implements View.OnClickListener
{
  FinderPostUI$o(d paramd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(204690);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/finder/ui/FinderPostUI$initView$7$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    this.sqD.bqD();
    a.a(this, "com/tencent/mm/plugin/finder/ui/FinderPostUI$initView$7$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(204690);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderPostUI.o
 * JD-Core Version:    0.7.0.1
 */