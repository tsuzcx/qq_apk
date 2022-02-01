package com.tencent.mm.plugin.finder.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class FinderLikedFeedUI$a
  implements View.OnClickListener
{
  FinderLikedFeedUI$a(FinderLikedFeedUI paramFinderLikedFeedUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(289608);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/finder/ui/FinderLikedFeedUI$fixActionBarStatus$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    this.ArC.onBackPressed();
    a.a(this, "com/tencent/mm/plugin/finder/ui/FinderLikedFeedUI$fixActionBarStatus$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(289608);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI.a
 * JD-Core Version:    0.7.0.1
 */