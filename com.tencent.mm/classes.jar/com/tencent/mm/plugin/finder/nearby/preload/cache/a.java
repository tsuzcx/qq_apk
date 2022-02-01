package com.tencent.mm.plugin.finder.nearby.preload.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.viewmodel.n;
import com.tencent.mm.plugin.finder.viewmodel.n.a;
import com.tencent.mm.plugin.finder.viewmodel.n.c;
import com.tencent.mm.plugin.finder.viewmodel.n.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/preload/cache/PreloadCacheManager;", "", "()V", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/NearbyLivePreloadCacheVM;", "getFirstPageCache", "Lcom/tencent/mm/plugin/finder/viewmodel/NearbyLivePreloadCacheVM$Cache;", "memoryCacheFlag", "", "getPreloadSquareTabsCache", "Lcom/tencent/mm/plugin/findersdk/cgi/PreloadResponse;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "", "getPreloadTimeStampCache", "Lcom/tencent/mm/plugin/finder/viewmodel/NearbyLivePreloadCacheVM$LastPreloadTimeStampCache;", "resetFirstPage", "", "storeFirstPage", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "storePreloadSquareTabsCache", "response", "storePreloadTimeStampCache", "lastFindPrefetchTimeStampMs", "", "lastRedDotPrefetchTimeStampMs", "lastTabPagesPrefetchTimeStampMs", "Companion", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a EPP;
  public final n tlCache;
  
  static
  {
    AppMethodBeat.i(340045);
    EPP = new a((byte)0);
    AppMethodBeat.o(340045);
  }
  
  public a()
  {
    AppMethodBeat.i(340024);
    Object localObject = k.aeZF;
    localObject = k.cn(PluginFinder.class).q(n.class);
    s.s(localObject, "UICProvider.of(PluginFin…eloadCacheVM::class.java)");
    this.tlCache = ((n)localObject);
    AppMethodBeat.o(340024);
  }
  
  public static n.a QW(int paramInt)
  {
    AppMethodBeat.i(340030);
    Object localObject = k.aeZF;
    localObject = ((n)k.cn(PluginFinder.class).q(n.class)).Vb(paramInt);
    AppMethodBeat.o(340030);
    return localObject;
  }
  
  public static void QX(int paramInt)
  {
    AppMethodBeat.i(340039);
    Object localObject = k.aeZF;
    localObject = ((n)k.cn(PluginFinder.class).q(n.class)).Vb(paramInt);
    ((n.a)localObject).a(n.d.GLM);
    ((n.a)localObject).GKz = 0L;
    ((n.a)localObject).GLG = 0;
    Log.i("PreloadCacheManager", s.X("resetFirstPage memoryCacheFlag:", Integer.valueOf(paramInt)));
    AppMethodBeat.o(340039);
  }
  
  public final n.c QY(int paramInt)
  {
    AppMethodBeat.i(340057);
    n.c localc = this.tlCache.QY(paramInt);
    AppMethodBeat.o(340057);
    return localc;
  }
  
  public final void a(int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(340053);
    Log.i("PreloadCacheManager", "storePreloadTimeStampCache lastFindPrefetchTimeStampMs:" + paramLong1 + " lastRedDotPrefetchTimeStampMs:" + paramLong2 + " lastTabPagesPrefetchTimeStampMs:" + paramLong3);
    n.c localc = this.tlCache.QY(paramInt);
    if (paramLong1 != 0L) {
      localc.GLI = paramLong1;
    }
    if (paramLong2 != 0L) {
      localc.GLJ = paramLong2;
    }
    if (paramLong3 != 0L) {
      localc.GLK = paramLong3;
    }
    AppMethodBeat.o(340053);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/preload/cache/PreloadCacheManager$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.preload.cache.a
 * JD-Core Version:    0.7.0.1
 */