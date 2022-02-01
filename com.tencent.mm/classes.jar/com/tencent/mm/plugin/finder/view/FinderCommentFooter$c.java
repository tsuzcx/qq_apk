package com.tencent.mm.plugin.finder.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class FinderCommentFooter$c
  implements View.OnClickListener
{
  FinderCommentFooter$c(d.g.a.b paramb, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(178472);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/finder/view/FinderCommentFooter$initSelectItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    this.tez.invoke(Integer.valueOf(this.teA));
    a.a(this, "com/tencent/mm/plugin/finder/view/FinderCommentFooter$initSelectItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(178472);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderCommentFooter.c
 * JD-Core Version:    0.7.0.1
 */