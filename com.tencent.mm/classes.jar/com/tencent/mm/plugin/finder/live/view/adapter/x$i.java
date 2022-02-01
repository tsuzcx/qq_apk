package com.tencent.mm.plugin.finder.live.view.adapter;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
final class x$i
  implements View.OnLongClickListener
{
  public static final i yZR;
  
  static
  {
    AppMethodBeat.i(277414);
    yZR = new i();
    AppMethodBeat.o(277414);
  }
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(277413);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$setAdOnClickListener$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
    a.a(true, this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$setAdOnClickListener$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(277413);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.x.i
 * JD-Core Version:    0.7.0.1
 */