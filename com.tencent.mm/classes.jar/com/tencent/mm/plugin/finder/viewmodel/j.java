package com.tencent.mm.plugin.finder.viewmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.component.i;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderVideoStateCacheVM;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "()V", "cache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderVideoStateCacheVM$Cache;", "cacheMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "clearProgress", "", "clearSeekState", "getVideoProgress", "mediaId", "tabType", "", "getVideoState", "progressKey", "store", "progress", "timestamp", "speedRatio", "", "storeProgress", "Cache", "Companion", "plugin-finder_release"})
public final class j
  extends i<PluginFinder>
{
  public static final b Bhz;
  private a Bhx;
  public HashMap<String, a> Bhy;
  
  static
  {
    AppMethodBeat.i(289247);
    Bhz = new b((byte)0);
    AppMethodBeat.o(289247);
  }
  
  public j()
  {
    AppMethodBeat.i(289246);
    this.Bhy = new HashMap();
    AppMethodBeat.o(289246);
  }
  
  public static String eo(String paramString, int paramInt)
  {
    AppMethodBeat.i(289245);
    paramString = paramString + '_' + paramInt;
    AppMethodBeat.o(289245);
    return paramString;
  }
  
  public final void a(String paramString, int paramInt1, int paramInt2, float paramFloat)
  {
    AppMethodBeat.i(289242);
    p.k(paramString, "mediaId");
    Log.i("Finder.VideoStateCacheVM", "[store] mediaId=" + paramString + " progress=" + paramInt1 + " timestamp=" + paramInt2);
    paramString = new a(paramString);
    paramString.progress = paramInt1;
    paramString.BhA = paramInt2;
    paramString.BhB = paramFloat;
    this.Bhx = paramString;
    AppMethodBeat.o(289242);
  }
  
  public final void ekf()
  {
    AppMethodBeat.i(289243);
    Log.i("Finder.VideoStateCacheVM", "[clearSeekState]");
    this.Bhx = null;
    AppMethodBeat.o(289243);
  }
  
  public final a en(String paramString, int paramInt)
  {
    AppMethodBeat.i(289244);
    p.k(paramString, "mediaId");
    Object localObject = g.Xox;
    if (!((b)g.bD(PluginFinder.class).i(b.class)).OO(paramInt))
    {
      localObject = this.Bhx;
      if (localObject != null) {}
      for (localObject = ((a)localObject).mediaId; p.h(localObject, paramString); localObject = null)
      {
        paramString = this.Bhx;
        AppMethodBeat.o(289244);
        return paramString;
      }
    }
    AppMethodBeat.o(289244);
    return null;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderVideoStateCacheVM$Cache;", "", "mediaId", "", "(Ljava/lang/String;)V", "getMediaId", "()Ljava/lang/String;", "progress", "", "getProgress", "()I", "setProgress", "(I)V", "speedRatio", "", "getSpeedRatio", "()F", "setSpeedRatio", "(F)V", "timestamp", "", "getTimestamp", "()D", "setTimestamp", "(D)V", "component1", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"})
  public static final class a
  {
    public double BhA;
    public float BhB;
    final String mediaId;
    public int progress;
    
    public a(String paramString)
    {
      AppMethodBeat.i(268665);
      this.mediaId = paramString;
      this.BhB = 1.0F;
      AppMethodBeat.o(268665);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(268672);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if (!p.h(this.mediaId, paramObject.mediaId)) {}
        }
      }
      else
      {
        AppMethodBeat.o(268672);
        return true;
      }
      AppMethodBeat.o(268672);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(268669);
      String str = this.mediaId;
      if (str != null)
      {
        int i = str.hashCode();
        AppMethodBeat.o(268669);
        return i;
      }
      AppMethodBeat.o(268669);
      return 0;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(268668);
      String str = "Cache(mediaId=" + this.mediaId + ")";
      AppMethodBeat.o(268668);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderVideoStateCacheVM$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.j
 * JD-Core Version:    0.7.0.1
 */