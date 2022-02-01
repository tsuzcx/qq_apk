package com.tencent.mm.plugin.finder.live.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.live.b.l.k;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.protocal.protobuf.axe;
import com.tencent.mm.protocal.protobuf.aya;
import com.tencent.mm.protocal.protobuf.aza;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bgx;
import com.tencent.mm.protocal.protobuf.bgy;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.a.j;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderPostLiveAppMsg;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderPostLiveAppMsgResponse;", "appMsg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "roomData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "callBack", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "errType", "errCode", "", "errMsg", "resp", "", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Lkotlin/jvm/functions/Function4;)V", "TAG", "getCallBack", "()Lkotlin/jvm/functions/Function4;", "setCallBack", "(Lkotlin/jvm/functions/Function4;)V", "request", "Lcom/tencent/mm/protocal/protobuf/FinderPostLiveAppMsgRequest;", "initReqResp", "onCgiEnd", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class n
  extends com.tencent.mm.plugin.findersdk.b.c<bgy>
{
  public static final a xYm;
  private final String TAG;
  private bgx xYk;
  private r<? super Integer, ? super Integer, ? super String, ? super bgy, x> xYl;
  
  static
  {
    AppMethodBeat.i(264718);
    xYm = new a((byte)0);
    AppMethodBeat.o(264718);
  }
  
  public n(axe paramaxe, com.tencent.mm.plugin.finder.live.model.context.a parama, bid parambid, r<? super Integer, ? super Integer, ? super String, ? super bgy, x> paramr)
  {
    super(parambid);
    AppMethodBeat.i(264717);
    this.xYl = paramr;
    this.TAG = "Finder.CgiFinderPostLiveAppMsg";
    this.xYk = new bgx();
    this.xYk.RLO = com.tencent.mm.cd.b.cU(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).kvN);
    this.xYk.yet = paramaxe;
    this.xYk.klE = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId;
    this.xYk.object_id = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).xbk;
    this.xYk.object_nonce_id = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).nonceId;
    paramaxe = this.xYk;
    paramr = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    int i;
    if (com.tencent.mm.plugin.finder.live.utils.a.dEy())
    {
      paramr = l.k.kuV;
      i = l.k.aNV();
      paramaxe.scene = i;
      this.xYk.RLN = z.bdh();
      paramaxe = this.xYk;
      paramr = ao.xcj;
      paramaxe.SDi = ao.dnO();
      paramaxe = ao.xcj;
      paramaxe = this.xYk.SDi;
      if (parambid == null) {
        break label424;
      }
      i = parambid.fGo;
      label224:
      ao.a(paramaxe, j.listOf(new o(Integer.valueOf(i), Long.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).xbk))));
      paramaxe = new d.a();
      paramaxe.c((com.tencent.mm.cd.a)this.xYk);
      parama = new bgy();
      parama.setBaseResponse(new jh());
      parama.getBaseResponse().Tef = new eaf();
      paramaxe.d((com.tencent.mm.cd.a)parama);
      paramaxe.TW("/cgi-bin/micromsg-bin/finderpostliveappmsg");
      paramaxe.vD(6888);
      c(paramaxe.bgN());
      parama = this.TAG;
      parambid = new StringBuilder("CgiFinderPostLiveAppMsg init ").append(this.xYk.klE).append(",msgType ");
      paramaxe = this.xYk.yet;
      if (paramaxe == null) {
        break label430;
      }
    }
    label424:
    label430:
    for (paramaxe = Integer.valueOf(paramaxe.msg_type);; paramaxe = null)
    {
      Log.i(parama, paramaxe);
      AppMethodBeat.o(264717);
      return;
      paramr = l.k.kuV;
      i = l.k.aNW();
      break;
      i = 0;
      break label224;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderPostLiveAppMsg$Companion;", "", "()V", "genComplaintMsg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "genReplyCommentMsg", "atUser", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "replyContent", "", "getHighlightCheerMsg", "getTickleMsg", "tickleUser", "plugin-finder_release"})
  public static final class a
  {
    public static axe a(aza paramaza, String paramString)
    {
      AppMethodBeat.i(279475);
      p.k(paramaza, "atUser");
      p.k(paramString, "replyContent");
      axe localaxe = new axe();
      localaxe.SJC = paramaza;
      paramaza = new aya();
      paramaza.content = paramString;
      localaxe.SJE = com.tencent.mm.cd.b.cU(paramaza.toByteArray());
      localaxe.msg_type = 20002;
      localaxe.SJs = (z.bcZ() + System.currentTimeMillis());
      AppMethodBeat.o(279475);
      return localaxe;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.cgi.n
 * JD-Core Version:    0.7.0.1
 */