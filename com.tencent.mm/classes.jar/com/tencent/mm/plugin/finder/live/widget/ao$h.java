package com.tencent.mm.plugin.finder.live.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.view.e;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class ao$h
  implements View.OnClickListener
{
  ao$h(e parame) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(278407);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamWidget$resetBottomSheet$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    this.wZH.bYF();
    a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamWidget$resetBottomSheet$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(278407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.ao.h
 * JD-Core Version:    0.7.0.1
 */