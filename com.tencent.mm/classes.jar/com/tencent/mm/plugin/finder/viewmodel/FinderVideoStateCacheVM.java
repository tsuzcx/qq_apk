package com.tencent.mm.plugin.finder.viewmodel;

import android.arch.lifecycle.ViewModelProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.component.UIComponentPlugin;
import com.tencent.mm.ui.component.a;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderVideoStateCacheVM;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "()V", "cache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderVideoStateCacheVM$Cache;", "clear", "", "getVideoState", "mediaId", "", "store", "progress", "", "timestamp", "Cache", "Companion", "plugin-finder_release"})
public final class FinderVideoStateCacheVM
  extends UIComponentPlugin<PluginFinder>
{
  public static final b taG;
  public a taF;
  
  static
  {
    AppMethodBeat.i(205489);
    taG = new b((byte)0);
    AppMethodBeat.o(205489);
  }
  
  public final a ajn(String paramString)
  {
    AppMethodBeat.i(205488);
    p.h(paramString, "mediaId");
    Object localObject = a.KiD;
    if (!FinderHomeTabStateVM.a((FinderHomeTabStateVM)a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)))
    {
      localObject = this.taF;
      if (localObject != null) {}
      for (localObject = ((a)localObject).mediaId; p.i(localObject, paramString); localObject = null)
      {
        paramString = this.taF;
        AppMethodBeat.o(205488);
        return paramString;
      }
    }
    AppMethodBeat.o(205488);
    return null;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(205487);
    ad.i("Finder.VideoStateCacheVM", "[clear]");
    this.taF = null;
    AppMethodBeat.o(205487);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderVideoStateCacheVM$Cache;", "", "mediaId", "", "(Ljava/lang/String;)V", "getMediaId", "()Ljava/lang/String;", "progress", "", "getProgress", "()I", "setProgress", "(I)V", "timestamp", "", "getTimestamp", "()D", "setTimestamp", "(D)V", "component1", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"})
  public static final class a
  {
    final String mediaId;
    public int progress;
    public double taH;
    
    public a(String paramString)
    {
      AppMethodBeat.i(205483);
      this.mediaId = paramString;
      AppMethodBeat.o(205483);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(205486);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if (!p.i(this.mediaId, paramObject.mediaId)) {}
        }
      }
      else
      {
        AppMethodBeat.o(205486);
        return true;
      }
      AppMethodBeat.o(205486);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(205485);
      String str = this.mediaId;
      if (str != null)
      {
        int i = str.hashCode();
        AppMethodBeat.o(205485);
        return i;
      }
      AppMethodBeat.o(205485);
      return 0;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(205484);
      String str = "Cache(mediaId=" + this.mediaId + ")";
      AppMethodBeat.o(205484);
      return str;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderVideoStateCacheVM$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.FinderVideoStateCacheVM
 * JD-Core Version:    0.7.0.1
 */