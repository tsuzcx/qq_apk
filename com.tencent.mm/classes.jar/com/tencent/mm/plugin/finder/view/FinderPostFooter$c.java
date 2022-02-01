package com.tencent.mm.plugin.finder.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
public final class FinderPostFooter$c
  implements View.OnClickListener
{
  public FinderPostFooter$c(FinderPostFooter.b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(205801);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/finder/view/FinderPostFooter$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    this.tgA.cMI();
    a.a(this, "com/tencent/mm/plugin/finder/view/FinderPostFooter$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(205801);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderPostFooter.c
 * JD-Core Version:    0.7.0.1
 */