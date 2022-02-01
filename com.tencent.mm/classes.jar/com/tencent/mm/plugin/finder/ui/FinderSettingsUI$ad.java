package com.tencent.mm.plugin.finder.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$initView$38", "Lcom/tencent/mm/plugin/finder/ui/IAutoValue;", "setValue", "", "value", "", "plugin-finder_release"})
public final class FinderSettingsUI$ad
  implements i
{
  public final boolean cCl()
  {
    AppMethodBeat.i(203402);
    e locale = g.agR();
    k.g(locale, "MMKernel.storage()");
    boolean bool = locale.agA().getBoolean(ah.a.GVX, false);
    AppMethodBeat.o(203402);
    return bool;
  }
  
  public final void lM(boolean paramBoolean)
  {
    AppMethodBeat.i(203403);
    Object localObject = g.agR();
    k.g(localObject, "MMKernel.storage()");
    ((e)localObject).agA().set(ah.a.GVX, Boolean.valueOf(paramBoolean));
    localObject = b.rCU;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      b.Ef(i);
      AppMethodBeat.o(203403);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSettingsUI.ad
 * JD-Core Version:    0.7.0.1
 */