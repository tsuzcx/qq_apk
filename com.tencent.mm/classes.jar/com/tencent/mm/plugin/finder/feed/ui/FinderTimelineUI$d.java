package com.tencent.mm.plugin.finder.feed.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
final class FinderTimelineUI$d
  implements View.OnLongClickListener
{
  public static final d shH;
  
  static
  {
    AppMethodBeat.i(202888);
    shH = new d();
    AppMethodBeat.o(202888);
  }
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(202887);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI$addAllMenu$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
    a.a(true, this, "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI$addAllMenu$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(202887);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI.d
 * JD-Core Version:    0.7.0.1
 */