package com.tencent.mm.plugin.finder.nearby.live.square;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.extension.reddot.p;
import com.tencent.mm.plugin.finder.nearby.d;
import com.tencent.mm.protocal.protobuf.btw;
import com.tencent.mm.protocal.protobuf.btx;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/square/FinderLiveSquareConfig;", "", "()V", "TAG", "", "getTargetCommentScene", "", "commentScene", "tabId", "getTargetLiveTabId", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a ELB;
  
  static
  {
    AppMethodBeat.i(341205);
    ELB = new a();
    AppMethodBeat.o(341205);
  }
  
  public static int hW(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(341190);
    Object localObject = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().Su("FinderLiveEntrance");
    if ((localObject != null) && (((p)localObject).avK("FinderLiveEntrance") != null) && (((p)localObject).field_ctrInfo.type == 16))
    {
      localObject = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().avs("NearbyLiveTab");
      if (localObject == null) {
        paramInt2 = 0;
      }
    }
    for (;;)
    {
      int i = paramInt2;
      if (paramInt2 == 0)
      {
        localObject = d.EFs;
        i = d.getExitLiveTabId(paramInt1);
        Log.i("FinderLiveSquareConfig", "getTargetLiveTabId use last cache targetTabId=" + i + " commentScene=" + paramInt1);
      }
      paramInt1 = i;
      if (i == 0)
      {
        Log.i("FinderLiveSquareConfig", s.X("getTargetLiveTabId use default targetTabId=", Integer.valueOf(88890)));
        paramInt1 = 88890;
      }
      AppMethodBeat.o(341190);
      return paramInt1;
      paramInt2 = ((btx)localObject).aabK;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.square.a
 * JD-Core Version:    0.7.0.1
 */