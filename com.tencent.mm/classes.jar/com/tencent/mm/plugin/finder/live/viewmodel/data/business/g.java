package com.tencent.mm.plugin.finder.live.viewmodel.data.business;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.live.core.core.e.b;
import com.tencent.mm.plugin.finder.live.model.context.a;
import com.tencent.mm.plugin.finder.live.util.h;
import com.tencent.mm.plugin.finder.live.util.t;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveDebugSlice;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/IBusiness;", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "liveContext", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "lastOnlineCount", "", "getLastOnlineCount", "()I", "setLastOnlineCount", "(I)V", "qosInfo", "Lcom/tencent/mm/live/core/core/model/LiveQosInfo;", "getQosInfo", "()Lcom/tencent/mm/live/core/core/model/LiveQosInfo;", "setQosInfo", "(Lcom/tencent/mm/live/core/core/model/LiveQosInfo;)V", "value", "", "showStatistics", "getShowStatistics", "()Z", "setShowStatistics", "(Z)V", "debugStatisticsInfo", "", "onCleared", "", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends c<a>
{
  public static final a Efb;
  private static boolean hBY;
  public com.tencent.mm.live.core.core.model.e Efc;
  public int Efd;
  
  static
  {
    AppMethodBeat.i(356710);
    Efb = new a((byte)0);
    AppMethodBeat.o(356710);
  }
  
  public g(a parama)
  {
    super(parama);
    AppMethodBeat.i(356688);
    AppMethodBeat.o(356688);
  }
  
  public static boolean eyO()
  {
    return hBY;
  }
  
  public static void sm(boolean paramBoolean)
  {
    hBY = paramBoolean;
  }
  
  public final String eyP()
  {
    Object localObject3 = null;
    AppMethodBeat.i(356722);
    if (this.Efc == null)
    {
      AppMethodBeat.o(356722);
      return "last qosInfo is null";
    }
    Object localObject1 = this.Efc;
    if (localObject1 != null)
    {
      i = ((com.tencent.mm.live.core.core.model.e)localObject1).mode;
      localObject1 = e.b.mKf;
      if (i == e.b.bcu())
      {
        i = 1;
        if (i == 0) {
          break label99;
        }
        localObject1 = t.DJz;
        t.b(this.Efc);
        label65:
        localObject1 = t.DJz;
        localObject1 = t.euz();
        if (localObject1 != null) {
          break label113;
        }
      }
    }
    label99:
    label113:
    for (localObject1 = null;; localObject1 = ((h)localObject1).euq())
    {
      if (!Util.isNullOrNil((String)localObject1)) {
        break label121;
      }
      AppMethodBeat.o(356722);
      return "";
      i = 0;
      break;
      localObject1 = t.DJz;
      t.a(this.Efc);
      break label65;
    }
    label121:
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "";
    }
    localObject2 = new StringBuilder((String)localObject2);
    StringBuilder localStringBuilder = new StringBuilder("liveId:");
    localObject1 = this.Efc;
    if (localObject1 == null)
    {
      localObject1 = localObject3;
      ((StringBuilder)localObject2).append(localObject1 + '\n');
      ((StringBuilder)localObject2).append("objectId:" + d.hF(((f)business(f.class)).hKN) + '\n');
      localObject1 = ((StringBuilder)localObject2).toString();
      localObject2 = this.Efc;
      if (localObject2 == null) {
        break label307;
      }
      i = ((com.tencent.mm.live.core.core.model.e)localObject2).mode;
      localObject2 = e.b.mKf;
      if (i != e.b.bcu()) {
        break label307;
      }
    }
    label307:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label312;
      }
      localObject1 = "Mode CDN\n" + ((e)business(e.class)).eyy() + localObject1;
      AppMethodBeat.o(356722);
      return localObject1;
      localObject1 = Long.valueOf(((com.tencent.mm.live.core.core.model.e)localObject1).mMJ);
      break;
    }
    label312:
    localObject1 = "Mode Trtc\n" + ((e)business(e.class)).eyy() + localObject1;
    AppMethodBeat.o(356722);
    return localObject1;
  }
  
  public final void onCleared()
  {
    this.Efc = null;
    this.Efd = 0;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveDebugSlice$Companion;", "", "()V", "isShow", "", "()Z", "setShow", "(Z)V", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.business.g
 * JD-Core Version:    0.7.0.1
 */