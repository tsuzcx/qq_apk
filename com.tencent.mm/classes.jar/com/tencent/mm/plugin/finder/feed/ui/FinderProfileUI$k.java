package com.tencent.mm.plugin.finder.feed.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class FinderProfileUI$k
  implements View.OnClickListener
{
  FinderProfileUI$k(FinderProfileUI paramFinderProfileUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(166166);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$initActionBarView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    paramView = com.tencent.mm.plugin.finder.spam.a.sEK;
    if (com.tencent.mm.plugin.finder.spam.a.ajm("post"))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$initActionBarView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(166166);
      return;
    }
    FinderProfileUI.l(this.spK);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$initActionBarView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(166166);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI.k
 * JD-Core Version:    0.7.0.1
 */