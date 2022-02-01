package com.tencent.mm.plugin.finder.nearby.live.square;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.f;
import com.tencent.mm.plugin.finder.nearby.d;
import com.tencent.mm.protocal.protobuf.bhw;
import com.tencent.mm.protocal.protobuf.bhx;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/square/FinderLiveSquareConfig;", "", "()V", "TAG", "", "getTargetCommentScene", "", "commentScene", "getTargetLiveTabId", "plugin-finder-nearby_release"})
public final class a
{
  public static final a zGd;
  
  static
  {
    AppMethodBeat.i(200651);
    zGd = new a();
    AppMethodBeat.o(200651);
  }
  
  public static int getTargetLiveTabId()
  {
    int j = 0;
    AppMethodBeat.i(200648);
    Object localObject = h.ag(PluginFinder.class);
    p.j(localObject, "MMKernel.plugin(PluginFinder::class.java)");
    localObject = ((PluginFinder)localObject).getRedDotManager().aBf("FinderLiveEntrance");
    int i;
    if (localObject != null)
    {
      i = j;
      if (((com.tencent.mm.plugin.finder.extension.reddot.l)localObject).aBy("FinderLiveEntrance") != null)
      {
        i = j;
        if (((com.tencent.mm.plugin.finder.extension.reddot.l)localObject).field_ctrInfo.type == 16)
        {
          localObject = h.ag(PluginFinder.class);
          p.j(localObject, "MMKernel.plugin(PluginFinder::class.java)");
          localObject = ((PluginFinder)localObject).getRedDotManager().aBi("NearbyLiveTab");
          if (localObject == null) {
            break label148;
          }
          i = ((bhx)localObject).SSv;
        }
      }
    }
    for (j = i;; j = 0)
    {
      i = j;
      if (j == 0)
      {
        localObject = d.zCK;
        i = d.getExitLiveTabId();
        Log.i("FinderLiveSquareConfig", "getTargetLiveTabId use last cache targetTabId=".concat(String.valueOf(i)));
      }
      j = i;
      if (i == 0)
      {
        j = 88890;
        Log.i("FinderLiveSquareConfig", "getTargetLiveTabId use default targetTabId=88890");
      }
      AppMethodBeat.o(200648);
      return j;
      label148:
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.square.a
 * JD-Core Version:    0.7.0.1
 */