package com.tencent.mm.plugin.eggspring.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class d$1
  implements View.OnClickListener
{
  d$1(d paramd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(194646);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/eggspring/ui/VideoController$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    paramView = this.qWr;
    if (!d.b(this.qWr)) {}
    for (boolean bool = true;; bool = false)
    {
      d.a(paramView, bool);
      a.a(this, "com/tencent/mm/plugin/eggspring/ui/VideoController$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(194646);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.ui.d.1
 * JD-Core Version:    0.7.0.1
 */