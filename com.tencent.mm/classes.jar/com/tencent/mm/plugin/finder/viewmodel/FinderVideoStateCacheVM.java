package com.tencent.mm.plugin.finder.viewmodel;

import android.arch.lifecycle.ViewModelProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.component.UIComponentPlugin;
import com.tencent.mm.ui.component.a;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderVideoStateCacheVM;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "()V", "cache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderVideoStateCacheVM$Cache;", "clear", "", "getVideoState", "mediaId", "", "store", "progress", "", "timestamp", "Cache", "Companion", "plugin-finder_release"})
public final class FinderVideoStateCacheVM
  extends UIComponentPlugin<PluginFinder>
{
  public static final b LhC;
  public a LhB;
  
  static
  {
    AppMethodBeat.i(200346);
    LhC = new b((byte)0);
    AppMethodBeat.o(200346);
  }
  
  public final a aVJ(String paramString)
  {
    AppMethodBeat.i(200345);
    k.h(paramString, "mediaId");
    Object localObject = a.LCX;
    if (!FinderHomeTabStateVM.a((FinderHomeTabStateVM)a.bE(PluginFinder.class).get(FinderHomeTabStateVM.class)))
    {
      localObject = this.LhB;
      if (localObject != null) {}
      for (localObject = ((a)localObject).mediaId; k.g(localObject, paramString); localObject = null)
      {
        paramString = this.LhB;
        AppMethodBeat.o(200345);
        return paramString;
      }
    }
    AppMethodBeat.o(200345);
    return null;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(200344);
    ad.i("Finder.VideoStateCacheVM", "[clear]");
    this.LhB = null;
    AppMethodBeat.o(200344);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderVideoStateCacheVM$Cache;", "", "mediaId", "", "(Ljava/lang/String;)V", "getMediaId", "()Ljava/lang/String;", "progress", "", "getProgress", "()I", "setProgress", "(I)V", "timestamp", "", "getTimestamp", "()D", "setTimestamp", "(D)V", "component1", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"})
  public static final class a
  {
    public double LhD;
    final String mediaId;
    public int progress;
    
    public a(String paramString)
    {
      AppMethodBeat.i(200340);
      this.mediaId = paramString;
      AppMethodBeat.o(200340);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(200343);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if (!k.g(this.mediaId, paramObject.mediaId)) {}
        }
      }
      else
      {
        AppMethodBeat.o(200343);
        return true;
      }
      AppMethodBeat.o(200343);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(200342);
      String str = this.mediaId;
      if (str != null)
      {
        int i = str.hashCode();
        AppMethodBeat.o(200342);
        return i;
      }
      AppMethodBeat.o(200342);
      return 0;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(200341);
      String str = "Cache(mediaId=" + this.mediaId + ")";
      AppMethodBeat.o(200341);
      return str;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderVideoStateCacheVM$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.FinderVideoStateCacheVM
 * JD-Core Version:    0.7.0.1
 */