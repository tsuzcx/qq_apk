package com.tencent.mm.plugin.finder.live.plugin;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class az$e
  implements View.OnClickListener
{
  az$e(kotlin.g.a.b paramb, az.b paramb1) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(277412);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftPanelPlugin$createBottomSheetItem$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    this.yqD.invoke(this.yqE);
    a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftPanelPlugin$createBottomSheetItem$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(277412);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.az.e
 * JD-Core Version:    0.7.0.1
 */