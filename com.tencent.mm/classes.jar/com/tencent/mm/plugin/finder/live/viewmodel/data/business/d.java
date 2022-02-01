package com.tencent.mm.plugin.finder.live.viewmodel.data.business;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.e.b;
import com.tencent.mm.plugin.finder.live.util.h;
import com.tencent.mm.plugin.finder.live.util.q;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveDebugSlice;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/IBusiness;", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "liveContext", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "lastOnlineCount", "", "getLastOnlineCount", "()I", "setLastOnlineCount", "(I)V", "qosInfo", "Lcom/tencent/mm/live/core/core/model/LiveQosInfo;", "getQosInfo", "()Lcom/tencent/mm/live/core/core/model/LiveQosInfo;", "setQosInfo", "(Lcom/tencent/mm/live/core/core/model/LiveQosInfo;)V", "showStatistics", "", "getShowStatistics", "()Z", "setShowStatistics", "(Z)V", "debugStatisticsInfo", "", "onCleared", "", "plugin-finder-base_release"})
public final class d
  extends a<com.tencent.mm.plugin.finder.live.model.context.a>
{
  public boolean zgX;
  public com.tencent.mm.live.core.core.model.d zgY;
  public int zgZ;
  
  public d(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(259683);
    AppMethodBeat.o(259683);
  }
  
  public final String dHa()
  {
    Object localObject3 = null;
    AppMethodBeat.i(259682);
    if (this.zgY == null)
    {
      AppMethodBeat.o(259682);
      return "last qosInfo is null";
    }
    Object localObject1 = this.zgY;
    int i;
    if (localObject1 != null)
    {
      i = ((com.tencent.mm.live.core.core.model.d)localObject1).mode;
      localObject1 = e.b.kjz;
      if (i == e.b.aJK())
      {
        localObject1 = q.yQR;
        q.b(this.zgY);
        localObject1 = q.yQR;
        localObject1 = q.dEx();
        if (localObject1 == null) {
          break label105;
        }
      }
    }
    label105:
    for (localObject1 = ((h)localObject1).dEq();; localObject1 = null)
    {
      if (!Util.isNullOrNil((String)localObject1)) {
        break label110;
      }
      AppMethodBeat.o(259682);
      return "";
      localObject1 = q.yQR;
      q.a(this.zgY);
      break;
    }
    label110:
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "";
    }
    localObject2 = new StringBuilder((String)localObject2);
    StringBuilder localStringBuilder = new StringBuilder("liveId:");
    com.tencent.mm.live.core.core.model.d locald = this.zgY;
    localObject1 = localObject3;
    if (locald != null) {
      localObject1 = Long.valueOf(locald.klE);
    }
    ((StringBuilder)localObject2).append(localObject1 + '\n');
    ((StringBuilder)localObject2).append("objectId:" + com.tencent.mm.ae.d.Fw(((c)business(c.class)).xbk) + '\n');
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = this.zgY;
    if (localObject2 != null)
    {
      i = ((com.tencent.mm.live.core.core.model.d)localObject2).mode;
      localObject2 = e.b.kjz;
      if (i == e.b.aJK())
      {
        localObject2 = "Mode CDN\n" + ((b)business(b.class)).dGL() + (String)localObject1;
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label338;
        }
        AppMethodBeat.o(259682);
        return "";
      }
    }
    localObject2 = "Mode Trtc\n" + ((b)business(b.class)).dGL() + (String)localObject1;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    label338:
    AppMethodBeat.o(259682);
    return localObject1;
  }
  
  public final void onCleared()
  {
    this.zgX = false;
    this.zgY = null;
    this.zgZ = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.business.d
 * JD-Core Version:    0.7.0.1
 */