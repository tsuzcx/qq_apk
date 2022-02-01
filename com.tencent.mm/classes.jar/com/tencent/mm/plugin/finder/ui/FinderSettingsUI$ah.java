package com.tencent.mm.plugin.finder.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore.a;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$initView$7", "Lcom/tencent/mm/plugin/finder/ui/IAutoValue;", "setValue", "", "value", "", "plugin-finder_release"})
public final class FinderSettingsUI$ah
  implements j
{
  public final boolean fVE()
  {
    AppMethodBeat.i(199436);
    MediaPreloadCore.a locala = MediaPreloadCore.KTA;
    boolean bool = MediaPreloadCore.fTP();
    AppMethodBeat.o(199436);
    return bool;
  }
  
  public final void yJ(boolean paramBoolean)
  {
    AppMethodBeat.i(199437);
    Object localObject = g.afB();
    k.g(localObject, "MMKernel.storage()");
    ((e)localObject).afk().set(ae.a.Fxh, Boolean.valueOf(paramBoolean));
    localObject = MediaPreloadCore.KTA;
    MediaPreloadCore.yD(paramBoolean);
    AppMethodBeat.o(199437);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSettingsUI.ah
 * JD-Core Version:    0.7.0.1
 */