package com.tencent.mm.plugin.finder.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.b;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$20", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
public final class FinderDebugSettingsUI2$r
  implements View.OnClickListener
{
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(203129);
    paramView = b.rCU;
    if (b.czV() > 1)
    {
      paramView = b.rCU;
      b.Ed(1);
      AppMethodBeat.o(203129);
      return;
    }
    paramView = b.rCU;
    b.Ed(2);
    AppMethodBeat.o(203129);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderDebugSettingsUI2.r
 * JD-Core Version:    0.7.0.1
 */