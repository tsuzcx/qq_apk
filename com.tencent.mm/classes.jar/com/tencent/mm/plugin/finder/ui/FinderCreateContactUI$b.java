package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.ui.tools.q;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class FinderCreateContactUI$b
  implements View.OnClickListener
{
  FinderCreateContactUI$b(FinderCreateContactUI paramFinderCreateContactUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(167160);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$initContentView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    q.o((Activity)this.sMR, FinderCreateContactUI.a(this.sMR));
    a.a(this, "com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$initContentView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(167160);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderCreateContactUI.b
 * JD-Core Version:    0.7.0.1
 */