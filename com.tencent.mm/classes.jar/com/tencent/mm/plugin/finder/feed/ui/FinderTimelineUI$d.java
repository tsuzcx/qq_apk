package com.tencent.mm.plugin.finder.feed.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
final class FinderTimelineUI$d
  implements View.OnLongClickListener
{
  public static final d udn;
  
  static
  {
    AppMethodBeat.i(245568);
    udn = new d();
    AppMethodBeat.o(245568);
  }
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(245567);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI$addAllMenu$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
    a.a(true, this, "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI$addAllMenu$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(245567);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI.d
 * JD-Core Version:    0.7.0.1
 */