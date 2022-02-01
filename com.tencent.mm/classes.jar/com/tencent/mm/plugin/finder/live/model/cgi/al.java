package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.c;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bbd;
import com.tencent.mm.protocal.protobuf.bdc;
import com.tencent.mm.protocal.protobuf.bdd;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveTopComment;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTopCommentResponse;", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;)V", "TAG", "", "getLiveData", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "setLiveData", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "getMsg", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "setMsg", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;)V", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTopCommentRequest;", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class al
  extends n<bdd>
{
  private final String TAG;
  private com.tencent.mm.plugin.finder.live.model.context.a xYp;
  private bbd yig;
  private bdc yki;
  
  public al(com.tencent.mm.plugin.finder.live.model.context.a parama, bbd parambbd)
  {
    AppMethodBeat.i(269140);
    this.xYp = parama;
    this.yig = parambbd;
    this.TAG = "Finder.CgiFinderLiveTopComment";
    this.yki = new bdc();
    parama = this.yki;
    parambbd = ao.xcj;
    parama.SDi = ao.dnO();
    this.yki.liveId = ((c)this.xYp.business(c.class)).liveInfo.liveId;
    this.yki.xbk = ((c)this.xYp.business(c.class)).xbk;
    this.yki.ilo = (this.yig.ilo + '_' + cm.bfF() + '_' + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).yeE);
    this.yki.xak = com.tencent.mm.cd.b.cU(((c)this.xYp.business(c.class)).kvN);
    this.yki.seq = this.yig.seq;
    this.yki.fSo = 0;
    this.yki.SKW = d.Nb(((c)this.xYp.business(c.class)).nonceId);
    this.yki.finderUsername = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig;
    this.yki.jDI = ((c)this.xYp.business(c.class)).nonceId;
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgg.add(this.yki.ilo);
    parama = new d.a();
    parama.c((com.tencent.mm.cd.a)this.yki);
    parambbd = new bdd();
    parambbd.setBaseResponse(new jh());
    parama.d((com.tencent.mm.cd.a)parambbd);
    parama.TW("/cgi-bin/micromsg-bin/finderlivetopcomment");
    parama.vD(6295);
    c(parama.bgN());
    Log.i(this.TAG, "CgiFinderLiveTopComment init " + this.yki.liveId + ',' + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig + ',' + this.yig.content);
    AppMethodBeat.o(269140);
  }
  
  public final com.tencent.mm.plugin.findersdk.b.a.b dnF()
  {
    return com.tencent.mm.plugin.findersdk.b.a.b.BvU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.al
 * JD-Core Version:    0.7.0.1
 */