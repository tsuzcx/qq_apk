package com.tencent.mm.plugin.finder.nearby.live.square.find;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class FinderLiveFindPageUI$b
  implements View.OnClickListener
{
  FinderLiveFindPageUI$b(FinderLiveFindPageUI paramFinderLiveFindPageUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(201809);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/finder/nearby/live/square/find/FinderLiveFindPageUI$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    this.zGv.onBackPressed();
    a.a(this, "com/tencent/mm/plugin/finder/nearby/live/square/find/FinderLiveFindPageUI$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(201809);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.square.find.FinderLiveFindPageUI.b
 * JD-Core Version:    0.7.0.1
 */