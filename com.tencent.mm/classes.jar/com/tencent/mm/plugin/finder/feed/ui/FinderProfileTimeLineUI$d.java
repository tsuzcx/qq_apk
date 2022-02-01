package com.tencent.mm.plugin.finder.feed.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class FinderProfileTimeLineUI$d
  implements View.OnClickListener
{
  public static final d soE;
  
  static
  {
    AppMethodBeat.i(203292);
    soE = new d();
    AppMethodBeat.o(203292);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(203291);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI$refreshProfile$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI$refreshProfile$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(203291);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI.d
 * JD-Core Version:    0.7.0.1
 */