package com.tencent.mm.plugin.finder.ui;

import android.arch.lifecycle.ViewModelProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.component.a;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$initView$30", "Lcom/tencent/mm/plugin/finder/ui/IClickEvent;", "onClick", "", "plugin-finder_release"})
public final class FinderSettingsUI$w
  implements k
{
  public final void onClick()
  {
    AppMethodBeat.i(199422);
    Object localObject = a.LCX;
    a.bE(PluginFinder.class).get(FinderHomeTabStateVM.class);
    localObject = g.afB();
    d.g.b.k.g(localObject, "MMKernel.storage()");
    ((e)localObject).afk().set(FinderHomeTabStateVM.ahR(3), Integer.valueOf(0));
    localObject = g.afB();
    d.g.b.k.g(localObject, "MMKernel.storage()");
    ((e)localObject).afk().set(FinderHomeTabStateVM.ahR(1), Integer.valueOf(0));
    localObject = g.afB();
    d.g.b.k.g(localObject, "MMKernel.storage()");
    ((e)localObject).afk().set(FinderHomeTabStateVM.ahR(4), Integer.valueOf(0));
    localObject = g.afB();
    d.g.b.k.g(localObject, "MMKernel.storage()");
    ((e)localObject).afk().set(FinderHomeTabStateVM.ahR(2), Integer.valueOf(0));
    localObject = g.afB();
    d.g.b.k.g(localObject, "MMKernel.storage()");
    ((e)localObject).afk().set(ae.a.LAQ, Integer.valueOf(0));
    localObject = g.afB();
    d.g.b.k.g(localObject, "MMKernel.storage()");
    ((e)localObject).afk().set(ae.a.LBH, Boolean.FALSE);
    AppMethodBeat.o(199422);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSettingsUI.w
 * JD-Core Version:    0.7.0.1
 */