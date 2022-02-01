package com.tencent.mm.plugin.finder.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class FinderShareFeedRelUI$m
  implements View.OnClickListener
{
  public static final m vPM;
  
  static
  {
    AppMethodBeat.i(252717);
    vPM = new m();
    AppMethodBeat.o(252717);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(252716);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    a.a(this, "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(252716);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI.m
 * JD-Core Version:    0.7.0.1
 */