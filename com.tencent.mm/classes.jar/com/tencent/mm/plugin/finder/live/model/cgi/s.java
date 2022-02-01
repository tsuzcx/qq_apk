package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.protocal.protobuf.aqe;
import com.tencent.mm.protocal.protobuf.aus;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCandidate;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveMicCandidateListResponse;", "finderBaseRequest", "Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "finderUsername", "", "lastBuffer", "", "liveCookies", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCandidate$CallBack;", "(Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;Ljava/lang/String;[B[BLcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCandidate$CallBack;)V", "TAG", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCandidate$CallBack;", "getFinderBaseRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveMicCandidateListRequest;", "initReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class s
  extends n<aut>
{
  private final String TAG;
  private aus yjo;
  private final aqe yjp;
  private final a yjq;
  
  public s(aqe paramaqe, String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, a parama)
  {
    AppMethodBeat.i(273354);
    this.yjp = paramaqe;
    this.yjq = parama;
    this.TAG = "Finder.CgiFinderLiveCandidate";
    this.yjo = new aus();
    this.yjo.RLM = this.yjp;
    this.yjo.RLN = paramString;
    this.yjo.SDI = b.cU(paramArrayOfByte1);
    this.yjo.RLO = b.cU(paramArrayOfByte2);
    paramaqe = new d.a();
    paramaqe.c((a)this.yjo);
    paramString = new aut();
    paramString.setBaseResponse(new jh());
    paramString.getBaseResponse().Tef = new eaf();
    paramaqe.d((a)paramString);
    paramaqe.TW("/cgi-bin/micromsg-bin/findergetlivemiccandidatelist");
    paramaqe.vD(6845);
    c(paramaqe.bgN());
    AppMethodBeat.o(273354);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCandidate$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveMicCandidateListResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(aut paramaut);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.s
 * JD-Core Version:    0.7.0.1
 */