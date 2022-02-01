package com.tencent.mm.plugin.finder.live.viewmodel.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.api.LiveConfig.a;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.live.model.context.a;
import com.tencent.mm.protocal.protobuf.bbh;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "liveConfig", "Lcom/tencent/mm/live/api/LiveConfig;", "(Lcom/tencent/mm/live/api/LiveConfig;)V", "objectId", "", "liveId", "anchorUserName", "", "nonceId", "coverUrl", "streamUrl", "audienMode", "", "sessionBuffer", "nickname", "anchorStatus", "(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;J)V", "bindPosition", "getBindPosition", "()I", "setBindPosition", "(I)V", "liveRoomData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "getLiveRoomData", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "setLiveRoomData", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "noticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "getNoticeInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "setNoticeInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;)V", "staticConfig", "getStaticConfig", "()Lcom/tencent/mm/live/api/LiveConfig;", "setStaticConfig", "compare", "obj", "info", "toString", "plugin-finder-base_release"})
public final class f
  implements k
{
  public bbh xUD;
  public a xWR;
  public LiveConfig zey;
  public int zez;
  
  public f(long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, long paramLong3)
  {
    AppMethodBeat.i(261843);
    this.xWR = new a("from LiveData");
    this.zez = -1;
    paramString1 = new LiveConfig.a().sP(LiveConfig.khX).Fx(paramLong2).Nf(paramString2).Fy(paramLong1).Nj(paramString4).sQ(paramInt).Ni(paramString1).Nh(paramString3).No(paramString5).Nr(paramString6).Fz(paramLong3).aJw();
    p.j(paramString1, "builder.toWhere(LiveConf…tus)\n            .build()");
    this.zey = paramString1;
    paramString1 = com.tencent.mm.plugin.findersdk.f.b.Bxg;
    com.tencent.mm.plugin.findersdk.f.b.hA("FinderLiveData", "init FinderLiveData2  nick:" + paramString6 + ' ' + this.zey.info());
    AppMethodBeat.o(261843);
  }
  
  public f(LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(261839);
    this.xWR = new a("from LiveData");
    this.zez = -1;
    this.zey = paramLiveConfig;
    AppMethodBeat.o(261839);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(261836);
    p.k(paramk, "obj");
    if (((paramk instanceof f)) && (((f)paramk).zey.getLiveId() == this.zey.getLiveId()))
    {
      AppMethodBeat.o(261836);
      return 0;
    }
    AppMethodBeat.o(261836);
    return -1;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(261838);
    try
    {
      String str1 = hashCode() + "_config: " + this.zey.info() + " LiveBuContext: " + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xWR.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).info();
      AppMethodBeat.o(261838);
      return str1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str2 = localException.toString();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.f
 * JD-Core Version:    0.7.0.1
 */