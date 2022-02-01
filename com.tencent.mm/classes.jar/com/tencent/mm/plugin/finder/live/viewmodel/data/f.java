package com.tencent.mm.plugin.finder.live.viewmodel.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.api.LiveConfig.a;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.live.model.context.a;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.finder.utils.bj;
import com.tencent.mm.plugin.findersdk.f.b;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bcb;
import com.tencent.mm.protocal.protobuf.bgr;
import com.tencent.mm.protocal.protobuf.bkk;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "liveConfig", "Lcom/tencent/mm/live/api/LiveConfig;", "(Lcom/tencent/mm/live/api/LiveConfig;)V", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "objectId", "", "liveId", "anchorUserName", "", "nonceId", "coverUrl", "streamUrl", "audienMode", "", "sessionBuffer", "nickname", "anchorStatus", "liveSdkInfo", "", "vrLiveType", "eventInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveEventInfo;", "(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;J[BILcom/tencent/mm/protocal/protobuf/FinderLiveEventInfo;)V", "haveExposed", "", "getHaveExposed", "()Z", "setHaveExposed", "(Z)V", "inHistory", "getInHistory", "setInHistory", "joinLiveTabTipsInfo", "Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveTabTipsInfo;", "getJoinLiveTabTipsInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveTabTipsInfo;", "setJoinLiveTabTipsInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveTabTipsInfo;)V", "liveRoomData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "getLiveRoomData", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "setLiveRoomData", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "noticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "getNoticeInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "setNoticeInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;)V", "staticConfig", "getStaticConfig", "()Lcom/tencent/mm/live/api/LiveConfig;", "setStaticConfig", "compare", "obj", "info", "simpleLiveInfo", "toString", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  implements k
{
  public bkk BvE;
  public a BxG;
  public LiveConfig Ebr;
  public bcb Ebs;
  public boolean Ebt;
  public boolean Ebu;
  
  public f(long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String paramString5, String paramString6, long paramLong3, byte[] paramArrayOfByte, int paramInt2, bgr parambgr)
  {
    AppMethodBeat.i(356582);
    this.BxG = new a("from LiveData");
    LiveConfig.a locala = new LiveConfig.a();
    bj localbj = bj.GlQ;
    locala.mIy = LiveConfig.mIt;
    locala.liveId = paramLong2;
    locala.nonceId = paramString2;
    locala.mIH = paramLong1;
    locala.mIE = paramString4;
    locala.mIF = paramInt1;
    locala.mIC = paramString1;
    locala.thumbUrl = paramString3;
    locala.sessionBuffer = paramString5;
    locala.mJd = paramString6;
    locala.mIV = paramLong3;
    locala.mIW = paramArrayOfByte;
    locala.mIX = paramInt2;
    s.s(locala, "builder.toWhere(LiveConf…setVrLiveType(vrLiveType)");
    paramString1 = bj.a(locala, "constructor", parambgr).bcd();
    s.s(paramString1, "builder.toWhere(LiveConf…nfo)\n            .build()");
    this.Ebr = paramString1;
    paramString1 = b.HeJ;
    b.iz("FinderLiveData", "init FinderLiveData2  nick:" + paramString6 + ' ' + this.Ebr.info());
    AppMethodBeat.o(356582);
  }
  
  public f(LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(356563);
    this.BxG = new a("from LiveData");
    this.Ebr = paramLiveConfig;
    AppMethodBeat.o(356563);
  }
  
  public f(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(356572);
    this.BxG = new a("from LiveData");
    aw localaw = aw.Gjk;
    this.Ebr = aw.a(paramFinderObject, 0, false, 6);
    AppMethodBeat.o(356572);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(356592);
    s.u(paramk, "obj");
    if (((paramk instanceof f)) && ((((f)paramk).Ebr.liveId == this.Ebr.liveId) || (((f)paramk).Ebr.mIH == this.Ebr.mIH)))
    {
      aw localaw = aw.Gjk;
      if (aw.bgV()) {
        Log.i("Finder.Loader", "compare feed obj:" + paramk + " is same with this:" + this);
      }
      AppMethodBeat.o(356592);
      return 0;
    }
    AppMethodBeat.o(356592);
    return -1;
  }
  
  public final String exV()
  {
    AppMethodBeat.i(356607);
    String str = "nickName:" + this.Ebr.mIU + ",havePlay:" + this.Ebt + ",liveId:" + this.Ebr.liveId + ",objectId:" + this.Ebr.mIH + "!\n";
    AppMethodBeat.o(356607);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(356601);
    try
    {
      String str1 = hashCode() + "_config(haveExposed:" + this.Ebt + "): " + this.Ebr.info() + " LiveBuContext: " + ((e)this.BxG.business(e.class)).info();
      AppMethodBeat.o(356601);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.f
 * JD-Core Version:    0.7.0.1
 */