package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.azm;
import com.tencent.mm.protocal.protobuf.azn;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCandidate;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveMicCandidateListResponse;", "finderBaseRequest", "Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "finderUsername", "", "lastBuffer", "", "liveCookies", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCandidate$CallBack;", "(Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;Ljava/lang/String;[B[BLcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCandidate$CallBack;)V", "TAG", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCandidate$CallBack;", "getFinderBaseRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveMicCandidateListRequest;", "initReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class u
  extends o<azn>
{
  private final atz CJv;
  private final a CJw;
  private azm CJx;
  private final String TAG;
  
  public u(atz paramatz, String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, a parama)
  {
    AppMethodBeat.i(360265);
    this.CJv = paramatz;
    this.CJw = parama;
    this.TAG = "Finder.CgiFinderLiveCandidate";
    this.CJx = new azm();
    this.CJx.YIY = this.CJv;
    this.CJx.YIZ = paramString;
    this.CJx.ZEQ = b.cX(paramArrayOfByte1);
    this.CJx.YJa = b.cX(paramArrayOfByte2);
    paramatz = new c.a();
    paramatz.otE = ((a)this.CJx);
    paramString = new azn();
    paramString.setBaseResponse(new kd());
    paramString.getBaseResponse().akjO = new etl();
    paramatz.otF = ((a)paramString);
    paramatz.uri = "/cgi-bin/micromsg-bin/findergetlivemiccandidatelist";
    paramatz.funcId = 6845;
    c(paramatz.bEF());
    AppMethodBeat.o(360265);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCandidate$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveMicCandidateListResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(azn paramazn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.u
 * JD-Core Version:    0.7.0.1
 */