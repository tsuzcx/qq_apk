package com.tencent.mm.plugin.finder.feed.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class FinderSelfFeedLikeListUI$e
  implements View.OnClickListener
{
  FinderSelfFeedLikeListUI$e(FinderSelfFeedLikeListUI paramFinderSelfFeedLikeListUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(203342);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    FinderSelfFeedLikeListUI.b(this.sqq);
    a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(203342);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderSelfFeedLikeListUI.e
 * JD-Core Version:    0.7.0.1
 */