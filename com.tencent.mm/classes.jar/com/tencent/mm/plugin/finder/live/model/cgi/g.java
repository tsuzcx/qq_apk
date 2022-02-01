package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.asp;
import com.tencent.mm.protocal.protobuf.asq;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderGetLiveInfo;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveInfoResp;", "liveId", "", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderGetLiveInfo$CallBack;", "(JLcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderGetLiveInfo$CallBack;)V", "TAG", "", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderGetLiveInfo$CallBack;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveInfoReq;", "initReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class g
  extends k<asq>
{
  private final String TAG;
  private asp ukG;
  private final a ukH;
  
  public g(long paramLong, a parama)
  {
    super((byte)0);
    AppMethodBeat.i(246310);
    this.ukH = parama;
    this.TAG = "Finder.CgiFinderGetLiveInfo";
    this.ukG = new asp();
    this.ukG.liveId = paramLong;
    Log.i(this.TAG, "get live info liveId:".concat(String.valueOf(paramLong)));
    parama = new d.a();
    parama.c((a)this.ukG);
    asq localasq = new asq();
    localasq.setBaseResponse(new BaseResponse());
    localasq.getBaseResponse().ErrMsg = new dqi();
    parama.d((a)localasq);
    parama.MB("/cgi-bin/micromsg-bin/findergetliveinfo");
    parama.sG(3861);
    c(parama.aXF());
    AppMethodBeat.o(246310);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderGetLiveInfo$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveInfoResp;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, asq paramasq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.g
 * JD-Core Version:    0.7.0.1
 */