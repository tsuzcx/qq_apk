package com.tencent.mm.plugin.finder.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class FinderSelfUI$y
  implements View.OnClickListener
{
  FinderSelfUI$y(FinderSelfUI paramFinderSelfUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(204764);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/finder/ui/FinderSelfUI$normalOrAbNomalUi$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    FinderSelfUI.b(this.sRH);
    a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSelfUI$normalOrAbNomalUi$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(204764);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSelfUI.y
 * JD-Core Version:    0.7.0.1
 */