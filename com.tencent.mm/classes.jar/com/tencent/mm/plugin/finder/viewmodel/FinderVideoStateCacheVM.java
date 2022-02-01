package com.tencent.mm.plugin.finder.viewmodel;

import android.arch.lifecycle.ViewModelProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.component.UIComponentPlugin;
import com.tencent.mm.ui.component.a;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderVideoStateCacheVM;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "()V", "cache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderVideoStateCacheVM$Cache;", "clear", "", "getVideoState", "mediaId", "", "store", "progress", "", "timestamp", "Cache", "Companion", "plugin-finder_release"})
public final class FinderVideoStateCacheVM
  extends UIComponentPlugin<PluginFinder>
{
  public static final b tlu;
  public a tlt;
  
  static
  {
    AppMethodBeat.i(206099);
    tlu = new b((byte)0);
    AppMethodBeat.o(206099);
  }
  
  public final a akk(String paramString)
  {
    AppMethodBeat.i(206098);
    p.h(paramString, "mediaId");
    Object localObject = a.KEX;
    if (!FinderHomeTabStateVM.a((FinderHomeTabStateVM)a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)))
    {
      localObject = this.tlt;
      if (localObject != null) {}
      for (localObject = ((a)localObject).mediaId; p.i(localObject, paramString); localObject = null)
      {
        paramString = this.tlt;
        AppMethodBeat.o(206098);
        return paramString;
      }
    }
    AppMethodBeat.o(206098);
    return null;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(206097);
    ae.i("Finder.VideoStateCacheVM", "[clear]");
    this.tlt = null;
    AppMethodBeat.o(206097);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderVideoStateCacheVM$Cache;", "", "mediaId", "", "(Ljava/lang/String;)V", "getMediaId", "()Ljava/lang/String;", "progress", "", "getProgress", "()I", "setProgress", "(I)V", "timestamp", "", "getTimestamp", "()D", "setTimestamp", "(D)V", "component1", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"})
  public static final class a
  {
    final String mediaId;
    public int progress;
    public double tlv;
    
    public a(String paramString)
    {
      AppMethodBeat.i(206093);
      this.mediaId = paramString;
      AppMethodBeat.o(206093);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(206096);
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
        AppMethodBeat.o(206096);
        return true;
      }
      AppMethodBeat.o(206096);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(206095);
      String str = this.mediaId;
      if (str != null)
      {
        int i = str.hashCode();
        AppMethodBeat.o(206095);
        return i;
      }
      AppMethodBeat.o(206095);
      return 0;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(206094);
      String str = "Cache(mediaId=" + this.mediaId + ")";
      AppMethodBeat.o(206094);
      return str;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderVideoStateCacheVM$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.FinderVideoStateCacheVM
 * JD-Core Version:    0.7.0.1
 */