package com.tencent.mm.plugin.finder.viewmodel;

import android.arch.lifecycle.ViewModelProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.component.UIComponentPlugin;
import com.tencent.mm.ui.component.a;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderVideoStateCacheVM;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "()V", "cache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderVideoStateCacheVM$Cache;", "clear", "", "getVideoState", "mediaId", "", "store", "progress", "", "timestamp", "Cache", "Companion", "plugin-finder_release"})
public final class FinderVideoStateCacheVM
  extends UIComponentPlugin<PluginFinder>
{
  public static final FinderVideoStateCacheVM.b sdf;
  public FinderVideoStateCacheVM.a sde;
  
  static
  {
    AppMethodBeat.i(204471);
    sdf = new FinderVideoStateCacheVM.b((byte)0);
    AppMethodBeat.o(204471);
  }
  
  public final FinderVideoStateCacheVM.a aeQ(String paramString)
  {
    AppMethodBeat.i(204470);
    k.h(paramString, "mediaId");
    Object localObject = a.IrY;
    if (!FinderHomeTabStateVM.a((FinderHomeTabStateVM)a.bg(PluginFinder.class).get(FinderHomeTabStateVM.class)))
    {
      localObject = this.sde;
      if (localObject != null) {}
      for (localObject = ((FinderVideoStateCacheVM.a)localObject).mediaId; k.g(localObject, paramString); localObject = null)
      {
        paramString = this.sde;
        AppMethodBeat.o(204470);
        return paramString;
      }
    }
    AppMethodBeat.o(204470);
    return null;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(204469);
    ac.i("Finder.VideoStateCacheVM", "[clear]");
    this.sde = null;
    AppMethodBeat.o(204469);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.FinderVideoStateCacheVM
 * JD-Core Version:    0.7.0.1
 */