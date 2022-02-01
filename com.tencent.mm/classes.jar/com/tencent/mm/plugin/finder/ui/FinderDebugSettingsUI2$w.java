package com.tencent.mm.plugin.finder.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$25", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
public final class FinderDebugSettingsUI2$w
  implements View.OnClickListener
{
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(203134);
    ((PluginFinder)g.ad(PluginFinder.class)).resetConfig();
    AppMethodBeat.o(203134);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderDebugSettingsUI2.w
 * JD-Core Version:    0.7.0.1
 */