package com.tencent.mm.plugin.finder.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class FinderCommentFooter$n
  implements View.OnClickListener
{
  public static final n wlp;
  
  static
  {
    AppMethodBeat.i(254753);
    wlp = new n();
    AppMethodBeat.o(254753);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(254752);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/finder/view/FinderCommentFooter$refreshSwitchSceneView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    a.a(this, "com/tencent/mm/plugin/finder/view/FinderCommentFooter$refreshSwitchSceneView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(254752);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderCommentFooter.n
 * JD-Core Version:    0.7.0.1
 */