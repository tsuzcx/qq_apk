package com.tencent.mm.plugin.finder.nearby.preload.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.viewmodel.b;
import com.tencent.mm.plugin.finder.viewmodel.b.a;
import com.tencent.mm.plugin.finder.viewmodel.b.c;
import com.tencent.mm.plugin.finder.viewmodel.b.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/preload/cache/PreloadCacheManager;", "", "()V", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "getFirstPageCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$Cache;", "memoryCacheFlag", "", "getPreloadSquareTabsCache", "Lcom/tencent/mm/plugin/findersdk/cgi/PreloadResponse;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "", "getPreloadTimeStampCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$LastPreloadTimeStampCache;", "resetFirstPage", "", "storeFirstPage", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "storePreloadSquareTabsCache", "response", "storePreloadTimeStampCache", "lastFindPrefetchTimeStampMs", "", "lastRedDotPrefetchTimeStampMs", "lastTabPagesPrefetchTimeStampMs", "Companion", "plugin-finder-nearby_release"})
public final class a
{
  public static final a zIx;
  public final b tlCache;
  
  static
  {
    AppMethodBeat.i(200178);
    zIx = new a((byte)0);
    AppMethodBeat.o(200178);
  }
  
  public a()
  {
    AppMethodBeat.i(200176);
    Object localObject = g.Xox;
    localObject = g.bD(PluginFinder.class).i(b.class);
    p.j(localObject, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.tlCache = ((b)localObject);
    AppMethodBeat.o(200176);
  }
  
  public static void OA(int paramInt)
  {
    AppMethodBeat.i(200172);
    Object localObject = g.Xox;
    localObject = ((b)g.bD(PluginFinder.class).i(b.class)).RI(paramInt);
    ((b.a)localObject).a(b.e.BgO);
    ((b.a)localObject).BgA = 0L;
    Log.i("PreloadCacheManager", "resetFirstPage memoryCacheFlag:".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(200172);
  }
  
  public static b.a Oz(int paramInt)
  {
    AppMethodBeat.i(200169);
    Object localObject = g.Xox;
    localObject = ((b)g.bD(PluginFinder.class).i(b.class)).RI(paramInt);
    AppMethodBeat.o(200169);
    return localObject;
  }
  
  public final b.c OB(int paramInt)
  {
    AppMethodBeat.i(200175);
    b.c localc = this.tlCache.OB(paramInt);
    AppMethodBeat.o(200175);
    return localc;
  }
  
  public final void a(int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(200174);
    Log.i("PreloadCacheManager", "storePreloadTimeStampCache lastFindPrefetchTimeStampMs:" + paramLong1 + ' ' + "lastRedDotPrefetchTimeStampMs:" + paramLong2 + ' ' + "lastTabPagesPrefetchTimeStampMs:" + paramLong3);
    b.c localc = this.tlCache.OB(paramInt);
    if (paramLong1 != 0L) {
      localc.BgD = paramLong1;
    }
    if (paramLong2 != 0L) {
      localc.BgE = paramLong2;
    }
    if (paramLong3 != 0L) {
      localc.BgF = paramLong3;
    }
    AppMethodBeat.o(200174);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/preload/cache/PreloadCacheManager$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.preload.cache.a
 * JD-Core Version:    0.7.0.1
 */