package com.tencent.mm.plugin.finder.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
final class FinderPostPickerUI$d
  implements View.OnLongClickListener
{
  public static final d AtH;
  
  static
  {
    AppMethodBeat.i(167487);
    AtH = new d();
    AppMethodBeat.o(167487);
  }
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(251632);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/finder/ui/FinderPostPickerUI$initView$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
    a.a(true, this, "com/tencent/mm/plugin/finder/ui/FinderPostPickerUI$initView$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(251632);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderPostPickerUI.d
 * JD-Core Version:    0.7.0.1
 */