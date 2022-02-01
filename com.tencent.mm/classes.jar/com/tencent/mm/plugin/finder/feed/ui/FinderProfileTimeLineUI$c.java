package com.tencent.mm.plugin.finder.feed.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class FinderProfileTimeLineUI$c
  implements View.OnClickListener
{
  public static final c sfK;
  
  static
  {
    AppMethodBeat.i(202811);
    sfK = new c();
    AppMethodBeat.o(202811);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(202810);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI$refreshProfile$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI$refreshProfile$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(202810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI.c
 * JD-Core Version:    0.7.0.1
 */