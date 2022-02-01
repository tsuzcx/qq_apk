package com.tencent.mm.plugin.finder.feed.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class FinderProfileTimeLineUI$c
  implements View.OnClickListener
{
  public static final c soD;
  
  static
  {
    AppMethodBeat.i(203290);
    soD = new c();
    AppMethodBeat.o(203290);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(203289);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI$refreshProfile$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI$refreshProfile$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(203289);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI.c
 * JD-Core Version:    0.7.0.1
 */