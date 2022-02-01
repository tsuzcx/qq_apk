package com.tencent.mm.plugin.finder.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$initView$31", "Lcom/tencent/mm/plugin/finder/ui/IClickEvent;", "onClick", "", "plugin-finder_release"})
public final class FinderSettingsUI$x
  implements j
{
  public final void onClick()
  {
    AppMethodBeat.i(203396);
    ((PluginFinder)g.ad(PluginFinder.class)).closeFinderEntryForDebug();
    AppMethodBeat.o(203396);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSettingsUI.x
 * JD-Core Version:    0.7.0.1
 */