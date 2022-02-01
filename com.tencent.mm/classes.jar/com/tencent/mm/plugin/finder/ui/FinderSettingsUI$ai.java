package com.tencent.mm.plugin.finder.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$initView$42", "Lcom/tencent/mm/plugin/finder/ui/IClickEvent;", "onClick", "", "plugin-finder_release"})
public final class FinderSettingsUI$ai
  implements j
{
  public final void onClick()
  {
    AppMethodBeat.i(203409);
    e locale = g.agR();
    k.g(locale, "MMKernel.storage()");
    locale.agA().set(ah.a.GVS, Boolean.FALSE);
    AppMethodBeat.o(203409);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSettingsUI.ai
 * JD-Core Version:    0.7.0.1
 */