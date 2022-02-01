package com.tencent.mm.plugin.finder.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.b;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$initView$25", "Lcom/tencent/mm/plugin/finder/ui/IAutoValue;", "setValue", "", "value", "", "plugin-finder_release"})
public final class FinderSettingsUI$q
  implements i
{
  public final boolean cCl()
  {
    AppMethodBeat.i(203387);
    b localb = b.rCU;
    boolean bool1 = b.cyu();
    localb = b.rCU;
    boolean bool2 = b.cyu();
    AppMethodBeat.o(203387);
    return bool1 | bool2;
  }
  
  public final void lM(boolean paramBoolean)
  {
    AppMethodBeat.i(203388);
    b localb = b.rCU;
    b.lH(paramBoolean);
    localb = b.rCU;
    b.lH(paramBoolean);
    AppMethodBeat.o(203388);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSettingsUI.q
 * JD-Core Version:    0.7.0.1
 */