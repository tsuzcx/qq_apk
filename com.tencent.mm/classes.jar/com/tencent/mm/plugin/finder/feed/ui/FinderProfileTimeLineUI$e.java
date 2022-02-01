package com.tencent.mm.plugin.finder.feed.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class FinderProfileTimeLineUI$e
  implements View.OnClickListener
{
  public static final e ucz;
  
  static
  {
    AppMethodBeat.i(245481);
    ucz = new e();
    AppMethodBeat.o(245481);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(245480);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI$refreshProfile$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI$refreshProfile$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(245480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI.e
 * JD-Core Version:    0.7.0.1
 */