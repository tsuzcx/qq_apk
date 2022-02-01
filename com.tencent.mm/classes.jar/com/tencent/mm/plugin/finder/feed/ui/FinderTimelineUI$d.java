package com.tencent.mm.plugin.finder.feed.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
final class FinderTimelineUI$d
  implements View.OnLongClickListener
{
  public static final d sqC;
  
  static
  {
    AppMethodBeat.i(203367);
    sqC = new d();
    AppMethodBeat.o(203367);
  }
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(203366);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI$addAllMenu$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
    a.a(true, this, "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI$addAllMenu$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(203366);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI.d
 * JD-Core Version:    0.7.0.1
 */