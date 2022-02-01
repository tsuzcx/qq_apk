package com.tencent.mm.plugin.finder.live.viewmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.api.LiveConfig.a;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.protocal.protobuf.awt;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "liveConfig", "Lcom/tencent/mm/live/api/LiveConfig;", "(Lcom/tencent/mm/live/api/LiveConfig;)V", "objectId", "", "liveId", "anchorUserName", "", "nonceId", "coverUrl", "sessionBuffer", "(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "liveRoomData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "getLiveRoomData", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "setLiveRoomData", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;)V", "noticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "getNoticeInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "setNoticeInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;)V", "staticConfig", "getStaticConfig", "()Lcom/tencent/mm/live/api/LiveConfig;", "setStaticConfig", "compare", "", "obj", "info", "toString", "plugin-finder_release"})
public final class c
  implements i
{
  public LiveConfig uCr;
  public g uCs;
  public awt ufj;
  
  public c(long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(247877);
    this.uCs = new g();
    paramString1 = new LiveConfig.a().qo(LiveConfig.hvU).zt(paramLong2).Gd(paramString2).zu(paramLong1).Gg(paramString1).Gf(paramString3).Gl(paramString4).aBR();
    p.g(paramString1, "builder.toWhere(LiveConf…fer)\n            .build()");
    this.uCr = paramString1;
    AppMethodBeat.o(247877);
  }
  
  public c(LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(247876);
    this.uCs = new g();
    this.uCr = paramLiveConfig;
    AppMethodBeat.o(247876);
  }
  
  public final int a(i parami)
  {
    AppMethodBeat.i(247874);
    p.h(parami, "obj");
    if (((parami instanceof c)) && (((c)parami).uCr.getLiveId() == this.uCr.getLiveId()))
    {
      AppMethodBeat.o(247874);
      return 0;
    }
    AppMethodBeat.o(247874);
    return -1;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(247875);
    try
    {
      String str1 = hashCode() + "_config:" + this.uCr.info() + " FinderLiveRoomData: " + this.uCs.info();
      AppMethodBeat.o(247875);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.c
 * JD-Core Version:    0.7.0.1
 */