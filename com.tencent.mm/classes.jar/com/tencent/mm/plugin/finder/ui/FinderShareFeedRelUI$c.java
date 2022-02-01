package com.tencent.mm.plugin.finder.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class FinderShareFeedRelUI$c
  implements View.OnClickListener
{
  public static final c AwD;
  
  static
  {
    AppMethodBeat.i(291967);
    AwD = new c();
    AppMethodBeat.o(291967);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(291966);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$checkPopupTipsInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    a.a(this, "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$checkPopupTipsInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(291966);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI.c
 * JD-Core Version:    0.7.0.1
 */