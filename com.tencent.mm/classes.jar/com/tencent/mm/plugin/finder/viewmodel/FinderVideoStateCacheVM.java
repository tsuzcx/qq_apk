package com.tencent.mm.plugin.finder.viewmodel;

import android.arch.lifecycle.ViewModelProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponentPlugin;
import com.tencent.mm.ui.component.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderVideoStateCacheVM;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "()V", "cache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderVideoStateCacheVM$Cache;", "clear", "", "getVideoState", "mediaId", "", "tabType", "", "store", "progress", "timestamp", "Cache", "Companion", "plugin-finder_release"})
public final class FinderVideoStateCacheVM
  extends UIComponentPlugin<PluginFinder>
{
  public static final b wva;
  private a wuZ;
  
  static
  {
    AppMethodBeat.i(255405);
    wva = new b((byte)0);
    AppMethodBeat.o(255405);
  }
  
  public final void ah(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(255402);
    p.h(paramString, "mediaId");
    Log.i("Finder.VideoStateCacheVM", "[store] mediaId=" + paramString + " progress=" + paramInt1 + " timestamp=" + paramInt2);
    paramString = new a(paramString);
    paramString.progress = paramInt1;
    paramString.wvb = paramInt2;
    this.wuZ = paramString;
    AppMethodBeat.o(255402);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(255403);
    Log.i("Finder.VideoStateCacheVM", "[clear]");
    this.wuZ = null;
    AppMethodBeat.o(255403);
  }
  
  public final a dR(String paramString, int paramInt)
  {
    AppMethodBeat.i(255404);
    p.h(paramString, "mediaId");
    Object localObject = a.PRN;
    if (!((FinderHomeTabStateVM)a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)).JN(paramInt))
    {
      localObject = this.wuZ;
      if (localObject != null) {}
      for (localObject = ((a)localObject).mediaId; p.j(localObject, paramString); localObject = null)
      {
        paramString = this.wuZ;
        AppMethodBeat.o(255404);
        return paramString;
      }
    }
    AppMethodBeat.o(255404);
    return null;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderVideoStateCacheVM$Cache;", "", "mediaId", "", "(Ljava/lang/String;)V", "getMediaId", "()Ljava/lang/String;", "progress", "", "getProgress", "()I", "setProgress", "(I)V", "timestamp", "", "getTimestamp", "()D", "setTimestamp", "(D)V", "component1", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"})
  public static final class a
  {
    final String mediaId;
    public int progress;
    double wvb;
    
    public a(String paramString)
    {
      AppMethodBeat.i(255398);
      this.mediaId = paramString;
      AppMethodBeat.o(255398);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(255401);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if (!p.j(this.mediaId, paramObject.mediaId)) {}
        }
      }
      else
      {
        AppMethodBeat.o(255401);
        return true;
      }
      AppMethodBeat.o(255401);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(255400);
      String str = this.mediaId;
      if (str != null)
      {
        int i = str.hashCode();
        AppMethodBeat.o(255400);
        return i;
      }
      AppMethodBeat.o(255400);
      return 0;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(255399);
      String str = "Cache(mediaId=" + this.mediaId + ")";
      AppMethodBeat.o(255399);
      return str;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderVideoStateCacheVM$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.FinderVideoStateCacheVM
 * JD-Core Version:    0.7.0.1
 */