package com.tencent.mm.plugin.finder.live.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class ao$k
  implements View.OnClickListener
{
  public static final k zsi;
  
  static
  {
    AppMethodBeat.i(269925);
    zsi = new k();
    AppMethodBeat.o(269925);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(269924);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamWidget$showBottomSheet$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamWidget$showBottomSheet$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(269924);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.ao.k
 * JD-Core Version:    0.7.0.1
 */