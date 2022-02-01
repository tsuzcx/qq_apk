package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.auq;
import com.tencent.mm.protocal.protobuf.aur;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderGetLiveInfo;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveInfoResp;", "liveId", "", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderGetLiveInfo$CallBack;", "(JLcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderGetLiveInfo$CallBack;)V", "TAG", "", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderGetLiveInfo$CallBack;", "setCallback", "(Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderGetLiveInfo$CallBack;)V", "request", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveInfoReq;", "initReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class k
  extends n<aur>
{
  private final String TAG;
  private auq yjd;
  private a yje;
  
  public k(long paramLong, a parama)
  {
    AppMethodBeat.i(281750);
    this.yje = parama;
    this.TAG = "Finder.CgiFinderGetLiveInfo";
    this.yjd = new auq();
    this.yjd.liveId = paramLong;
    this.yjd.RLN = z.bdh();
    Log.i(this.TAG, "get live info liveId:".concat(String.valueOf(paramLong)));
    parama = new d.a();
    parama.c((a)this.yjd);
    aur localaur = new aur();
    localaur.setBaseResponse(new jh());
    localaur.getBaseResponse().Tef = new eaf();
    parama.d((a)localaur);
    parama.TW("/cgi-bin/micromsg-bin/findergetliveinfo");
    parama.vD(3861);
    c(parama.bgN());
    AppMethodBeat.o(281750);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderGetLiveInfo$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveInfoResp;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, aur paramaur);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.k
 * JD-Core Version:    0.7.0.1
 */