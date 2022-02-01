package com.tencent.mm.plugin.finder.feed.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class FinderProfileUI$j
  implements View.OnClickListener
{
  FinderProfileUI$j(FinderProfileUI paramFinderProfileUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(166161);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$initActionBarView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    FinderProfileUI.k(this.spK);
    a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$initActionBarView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(166161);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI.j
 * JD-Core Version:    0.7.0.1
 */