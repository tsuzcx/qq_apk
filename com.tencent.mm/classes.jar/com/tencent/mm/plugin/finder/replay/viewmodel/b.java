package com.tencent.mm.plugin.finder.replay.viewmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.replay.model.g;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;
import com.tencent.mm.ui.component.n;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/viewmodel/LiveReplayCacheSlice;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/findersdk/api/IPluginFinder;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "cacheReplayInfo", "Lcom/tencent/mm/sdk/platformtools/LruCache;", "", "Lcom/tencent/mm/plugin/finder/replay/model/TmpReplayData;", "getCacheReplayInfo", "()Lcom/tencent/mm/sdk/platformtools/LruCache;", "getCacheOffset", "", "liveId", "(J)Ljava/lang/Integer;", "onCleared", "", "saveCacheInfo", "offset", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends n<cn>
{
  public final LruCache<Long, g> FmJ;
  private final String TAG;
  
  public b()
  {
    AppMethodBeat.i(332717);
    this.TAG = "LiveReplayCacheSlice";
    this.FmJ = new LruCache(50);
    AppMethodBeat.o(332717);
  }
  
  public final void X(long paramLong, int paramInt)
  {
    AppMethodBeat.i(332727);
    if (paramLong == 0L)
    {
      AppMethodBeat.o(332727);
      return;
    }
    Log.i(this.TAG, "cache offset:" + paramInt + " for liveId:" + paramLong);
    Object localObject = (g)this.FmJ.get(Long.valueOf(paramLong));
    if (localObject == null) {}
    for (localObject = null;; localObject = ah.aiuX)
    {
      if (localObject == null)
      {
        localObject = this.FmJ;
        g localg = new g();
        localg.offset = paramInt;
        ah localah = ah.aiuX;
        ((LruCache)localObject).put(Long.valueOf(paramLong), localg);
      }
      AppMethodBeat.o(332727);
      return;
      ((g)localObject).offset = paramInt;
    }
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(332732);
    super.onCleared();
    AppMethodBeat.o(332732);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.replay.viewmodel.b
 * JD-Core Version:    0.7.0.1
 */