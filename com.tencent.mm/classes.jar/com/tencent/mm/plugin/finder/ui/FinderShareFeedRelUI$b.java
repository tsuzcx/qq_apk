package com.tencent.mm.plugin.finder.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class FinderShareFeedRelUI$b
  implements View.OnClickListener
{
  public static final b vPH;
  
  static
  {
    AppMethodBeat.i(252705);
    vPH = new b();
    AppMethodBeat.o(252705);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(252704);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$checkPopupTipsInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    a.a(this, "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$checkPopupTipsInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(252704);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI.b
 * JD-Core Version:    0.7.0.1
 */