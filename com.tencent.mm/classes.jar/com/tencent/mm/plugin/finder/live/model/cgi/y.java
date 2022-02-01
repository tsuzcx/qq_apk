package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.ast;
import com.tencent.mm.protocal.protobuf.asu;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderOnlineMember;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveOnlineMemberResp;", "finderBaseRequest", "Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "liveId", "", "finderUsername", "", "objectId", "scene", "", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderOnlineMember$CallBack;", "(Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;JLjava/lang/String;JILcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderOnlineMember$CallBack;)V", "TAG", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderOnlineMember$CallBack;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveOnlineMemberReq;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class y
  extends k<asu>
{
  private final String TAG;
  private ast ulu;
  private final a ulv;
  
  public y(aov paramaov, long paramLong1, String paramString, long paramLong2, a parama)
  {
    super((byte)0);
    AppMethodBeat.i(246348);
    this.ulv = parama;
    this.TAG = "Finder.CgiFinderOnlineMember";
    this.ulu = new ast();
    this.ulu.LAI = paramaov;
    this.ulu.liveId = paramLong1;
    this.ulu.finderUsername = paramString;
    this.ulu.hFK = paramLong2;
    this.ulu.scene = 2;
    paramaov = new d.a();
    paramaov.c((a)this.ulu);
    paramString = new asu();
    paramString.setBaseResponse(new BaseResponse());
    paramString.getBaseResponse().ErrMsg = new dqi();
    paramaov.d((a)paramString);
    paramaov.MB("/cgi-bin/micromsg-bin/findergetliveonlinemember");
    paramaov.sG(3603);
    c(paramaov.aXF());
    Log.i(this.TAG, "[initReqResp] liveId =" + this.ulu.liveId + " finderUsername=" + this.ulu.finderUsername + " scene=" + this.ulu.scene);
    AppMethodBeat.o(246348);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderOnlineMember$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveOnlineMemberResp;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, asu paramasu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.y
 * JD-Core Version:    0.7.0.1
 */