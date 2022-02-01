package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.azu;
import com.tencent.mm.protocal.protobuf.azv;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderOnlineMember;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveOnlineMemberResp;", "finderBaseRequest", "Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "liveId", "", "finderUsername", "", "objectId", "scene", "", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderOnlineMember$CallBack;", "(Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;JLjava/lang/String;JILcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderOnlineMember$CallBack;)V", "TAG", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderOnlineMember$CallBack;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveOnlineMemberReq;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class az
  extends o<azv>
{
  private final a CKM;
  private azu CKN;
  private final String TAG;
  
  public az(atz paramatz, long paramLong1, String paramString, long paramLong2)
  {
    AppMethodBeat.i(360221);
    this.CKM = null;
    this.TAG = "Finder.CgiFinderOnlineMember";
    this.CKN = new azu();
    this.CKN.ZEc = paramatz;
    this.CKN.liveId = paramLong1;
    this.CKN.finderUsername = paramString;
    this.CKN.hKN = paramLong2;
    this.CKN.scene = 2;
    paramatz = new c.a();
    paramatz.otE = ((a)this.CKN);
    paramString = new azv();
    paramString.setBaseResponse(new kd());
    paramString.getBaseResponse().akjO = new etl();
    paramatz.otF = ((a)paramString);
    paramatz.uri = "/cgi-bin/micromsg-bin/findergetliveonlinemember";
    paramatz.funcId = 3603;
    c(paramatz.bEF());
    Log.i(this.TAG, "[initReqResp] liveId =" + this.CKN.liveId + " finderUsername=" + this.CKN.finderUsername + " scene=" + this.CKN.scene);
    AppMethodBeat.o(360221);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderOnlineMember$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveOnlineMemberResp;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.az
 * JD-Core Version:    0.7.0.1
 */