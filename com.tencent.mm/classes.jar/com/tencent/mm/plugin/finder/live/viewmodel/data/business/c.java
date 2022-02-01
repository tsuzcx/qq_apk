package com.tencent.mm.plugin.finder.live.viewmodel.data.business;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.model.g;
import com.tencent.mm.plugin.findersdk.f.b;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.crw;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveCoreSlice;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/IBusiness;", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "liveContext", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "TAG", "", "finderDescObject", "Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;", "getFinderDescObject", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;", "setFinderDescObject", "(Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;)V", "liveCookies", "", "getLiveCookies", "()[B", "setLiveCookies", "([B)V", "value", "Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;", "liveInfo", "getLiveInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;", "setLiveInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;)V", "Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "liveRoomModel", "getLiveRoomModel", "()Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "setLiveRoomModel", "(Lcom/tencent/mm/live/core/core/model/LiveRoomModel;)V", "liveSdkInfo", "Lcom/tencent/mm/protocal/protobuf/LiveSdkInfo;", "getLiveSdkInfo", "()Lcom/tencent/mm/protocal/protobuf/LiveSdkInfo;", "setLiveSdkInfo", "(Lcom/tencent/mm/protocal/protobuf/LiveSdkInfo;)V", "nicknameOption", "getNicknameOption", "()Ljava/lang/String;", "setNicknameOption", "(Ljava/lang/String;)V", "nonceId", "getNonceId", "setNonceId", "objectId", "", "getObjectId", "()J", "setObjectId", "(J)V", "sessionBuffer", "getSessionBuffer", "setSessionBuffer", "fillMiniInfo", "", "json", "Lorg/json/JSONObject;", "info", "onCleared", "plugin-finder-base_release"})
public final class c
  extends a<com.tencent.mm.plugin.finder.live.model.context.a>
{
  private final String TAG;
  public String kiv;
  public byte[] kvN;
  public crw kvP;
  public g kvS;
  public bac liveInfo;
  public String nonceId;
  public String sessionBuffer;
  public long xbk;
  public FinderObjectDesc zgW;
  
  public c(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(262195);
    this.TAG = ("LiveCoreSlice@" + hashCode());
    this.kvP = new crw();
    this.liveInfo = new bac();
    this.nonceId = "";
    this.sessionBuffer = "";
    this.kiv = "";
    AppMethodBeat.o(262195);
  }
  
  public final void a(crw paramcrw)
  {
    AppMethodBeat.i(262187);
    p.k(paramcrw, "<set-?>");
    this.kvP = paramcrw;
    AppMethodBeat.o(262187);
  }
  
  public final void b(g paramg)
  {
    AppMethodBeat.i(262189);
    this.kvS = paramg;
    b localb = b.Bxg;
    b.hA(this.TAG, "set liveRoomModel ".concat(String.valueOf(paramg)));
    AppMethodBeat.o(262189);
  }
  
  public final String info()
  {
    AppMethodBeat.i(262193);
    String str = "objectId:" + this.xbk + " nicknameOption:" + this.kiv + " liveInfo:" + this.liveInfo.liveId + ' ' + this.liveInfo.BpL;
    AppMethodBeat.o(262193);
    return str;
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(262192);
    super.onCleared();
    this.xbk = 0L;
    setLiveInfo(new bac());
    this.kvP = new crw();
    this.kvN = null;
    b(null);
    this.zgW = null;
    this.nonceId = "";
    this.sessionBuffer = "";
    this.kiv = "";
    AppMethodBeat.o(262192);
  }
  
  public final void setLiveInfo(bac parambac)
  {
    AppMethodBeat.i(262188);
    p.k(parambac, "value");
    Log.i(this.TAG, "write liveInfo to:[liveId:" + parambac.liveId + ", liveStatus:" + parambac.liveStatus + ']');
    this.liveInfo = parambac;
    AppMethodBeat.o(262188);
  }
  
  public final void setNonceId(String paramString)
  {
    AppMethodBeat.i(262190);
    p.k(paramString, "<set-?>");
    this.nonceId = paramString;
    AppMethodBeat.o(262190);
  }
  
  public final void setSessionBuffer(String paramString)
  {
    AppMethodBeat.i(262191);
    p.k(paramString, "<set-?>");
    this.sessionBuffer = paramString;
    AppMethodBeat.o(262191);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.business.c
 * JD-Core Version:    0.7.0.1
 */