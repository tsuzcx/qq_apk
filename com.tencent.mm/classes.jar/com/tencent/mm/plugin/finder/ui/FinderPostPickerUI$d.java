package com.tencent.mm.plugin.finder.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
final class FinderPostPickerUI$d
  implements View.OnLongClickListener
{
  public static final d sPG;
  
  static
  {
    AppMethodBeat.i(167487);
    sPG = new d();
    AppMethodBeat.o(167487);
  }
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(204677);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/finder/ui/FinderPostPickerUI$initView$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
    a.a(true, this, "com/tencent/mm/plugin/finder/ui/FinderPostPickerUI$initView$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(204677);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderPostPickerUI.d
 * JD-Core Version:    0.7.0.1
 */