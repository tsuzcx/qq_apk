package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.protocal.protobuf.aqe;
import com.tencent.mm.protocal.protobuf.auw;
import com.tencent.mm.protocal.protobuf.aux;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderOnlineMember;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveOnlineMemberResp;", "finderBaseRequest", "Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "liveId", "", "finderUsername", "", "objectId", "scene", "", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderOnlineMember$CallBack;", "(Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;JLjava/lang/String;JILcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderOnlineMember$CallBack;)V", "TAG", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderOnlineMember$CallBack;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveOnlineMemberReq;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class ao
  extends n<aux>
{
  private final String TAG;
  private auw ykm;
  private final a ykn;
  
  public ao(aqe paramaqe, long paramLong1, String paramString, long paramLong2, a parama)
  {
    AppMethodBeat.i(286535);
    this.ykn = parama;
    this.TAG = "Finder.CgiFinderOnlineMember";
    this.ykm = new auw();
    this.ykm.SDi = paramaqe;
    this.ykm.liveId = paramLong1;
    this.ykm.finderUsername = paramString;
    this.ykm.xbk = paramLong2;
    this.ykm.scene = 2;
    paramaqe = new d.a();
    paramaqe.c((a)this.ykm);
    paramString = new aux();
    paramString.setBaseResponse(new jh());
    paramString.getBaseResponse().Tef = new eaf();
    paramaqe.d((a)paramString);
    paramaqe.TW("/cgi-bin/micromsg-bin/findergetliveonlinemember");
    paramaqe.vD(3603);
    c(paramaqe.bgN());
    Log.i(this.TAG, "[initReqResp] liveId =" + this.ykm.liveId + " finderUsername=" + this.ykm.finderUsername + " scene=" + this.ykm.scene);
    AppMethodBeat.o(286535);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderOnlineMember$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveOnlineMemberResp;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, aux paramaux);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.ao
 * JD-Core Version:    0.7.0.1
 */