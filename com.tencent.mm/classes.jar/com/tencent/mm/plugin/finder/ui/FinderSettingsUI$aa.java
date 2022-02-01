package com.tencent.mm.plugin.finder.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$initView$35", "Lcom/tencent/mm/plugin/finder/ui/IAutoValue;", "setValue", "", "value", "", "plugin-finder_release"})
public final class FinderSettingsUI$aa
  implements j
{
  public final boolean fVE()
  {
    AppMethodBeat.i(199426);
    e locale = g.afB();
    k.g(locale, "MMKernel.storage()");
    boolean bool = locale.afk().getBoolean(ae.a.LBz, false);
    AppMethodBeat.o(199426);
    return bool;
  }
  
  public final void yJ(boolean paramBoolean)
  {
    AppMethodBeat.i(199427);
    Object localObject = g.afB();
    k.g(localObject, "MMKernel.storage()");
    ((e)localObject).afk().set(ae.a.LBz, Boolean.valueOf(paramBoolean));
    localObject = b.qJA;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      b.ahx(i);
      AppMethodBeat.o(199427);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSettingsUI.aa
 * JD-Core Version:    0.7.0.1
 */