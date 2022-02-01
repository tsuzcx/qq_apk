package com.tencent.mm.plugin.finder.viewmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.component.n;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderVideoStateCacheVM;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "()V", "cache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderVideoStateCacheVM$Cache;", "cacheMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "clearProgress", "", "clearSeekState", "getVideoProgress", "mediaId", "tabType", "", "getVideoState", "progressKey", "store", "progress", "timestamp", "speedRatio", "", "storeProgress", "Cache", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends n<PluginFinder>
{
  public static final b GLy;
  public HashMap<String, a> GLA;
  private a GLz;
  
  static
  {
    AppMethodBeat.i(337169);
    GLy = new b((byte)0);
    AppMethodBeat.o(337169);
  }
  
  public l()
  {
    AppMethodBeat.i(337156);
    this.GLA = new HashMap();
    AppMethodBeat.o(337156);
  }
  
  public static String fc(String paramString, int paramInt)
  {
    AppMethodBeat.i(337162);
    paramString = paramString + '_' + paramInt;
    AppMethodBeat.o(337162);
    return paramString;
  }
  
  public final void a(String paramString, int paramInt1, int paramInt2, float paramFloat)
  {
    AppMethodBeat.i(337181);
    s.u(paramString, "mediaId");
    Log.i("Finder.VideoStateCacheVM", "[store] mediaId=" + paramString + " progress=" + paramInt1 + " timestamp=" + paramInt2);
    paramString = new a(paramString);
    paramString.progress = paramInt1;
    paramString.GLB = paramInt2;
    paramString.GLC = paramFloat;
    ah localah = ah.aiuX;
    this.GLz = paramString;
    AppMethodBeat.o(337181);
  }
  
  public final void a(String paramString, int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    AppMethodBeat.i(337190);
    s.u(paramString, "mediaId");
    Log.i("Finder.VideoStateCacheVM", "[storeProgress] mediaId=" + paramString + " tabType=" + paramInt1 + " progress=" + paramInt2 + " timestamp=" + paramInt3);
    Map localMap = (Map)this.GLA;
    String str = fc(paramString, paramInt1);
    paramString = new a(paramString);
    paramString.progress = paramInt2;
    paramString.GLB = paramInt3;
    paramString.GLC = paramFloat;
    localMap.put(str, paramString);
    AppMethodBeat.o(337190);
  }
  
  public final a fb(String paramString, int paramInt)
  {
    AppMethodBeat.i(337211);
    s.u(paramString, "mediaId");
    Object localObject = k.aeZF;
    if (!((d)k.cn(PluginFinder.class).q(d.class)).Rp(paramInt))
    {
      localObject = this.GLz;
      if (localObject == null) {}
      for (localObject = null; s.p(localObject, paramString); localObject = ((a)localObject).mediaId)
      {
        paramString = this.GLz;
        AppMethodBeat.o(337211);
        return paramString;
      }
    }
    AppMethodBeat.o(337211);
    return null;
  }
  
  public final void fmP()
  {
    AppMethodBeat.i(337199);
    Log.i("Finder.VideoStateCacheVM", "[clearSeekState]");
    this.GLz = null;
    AppMethodBeat.o(337199);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderVideoStateCacheVM$Cache;", "", "mediaId", "", "(Ljava/lang/String;)V", "getMediaId", "()Ljava/lang/String;", "progress", "", "getProgress", "()I", "setProgress", "(I)V", "speedRatio", "", "getSpeedRatio", "()F", "setSpeedRatio", "(F)V", "timestamp", "", "getTimestamp", "()D", "setTimestamp", "(D)V", "component1", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public double GLB;
    public float GLC;
    final String mediaId;
    public int progress;
    
    public a(String paramString)
    {
      AppMethodBeat.i(337106);
      this.mediaId = paramString;
      this.GLC = 1.0F;
      AppMethodBeat.o(337106);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(337141);
      if (this == paramObject)
      {
        AppMethodBeat.o(337141);
        return true;
      }
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(337141);
        return false;
      }
      paramObject = (a)paramObject;
      if (!s.p(this.mediaId, paramObject.mediaId))
      {
        AppMethodBeat.o(337141);
        return false;
      }
      AppMethodBeat.o(337141);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(337127);
      int i = this.mediaId.hashCode();
      AppMethodBeat.o(337127);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(337117);
      String str = "Cache(mediaId=" + this.mediaId + ')';
      AppMethodBeat.o(337117);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderVideoStateCacheVM$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.l
 * JD-Core Version:    0.7.0.1
 */