package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.upload.action.b;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.cwh;
import com.tencent.mm.protocal.protobuf.cwi;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiFavMegaVideo;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/MegaVideoFavResp;", "action", "Lcom/tencent/mm/plugin/finder/upload/action/FavAction;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/upload/action/FavAction;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getAction", "()Lcom/tencent/mm/plugin/finder/upload/action/FavAction;", "favId", "", "request", "Lcom/tencent/mm/protocal/protobuf/MegaVideoFavReq;", "initCommReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class d
  extends c<cwi>
{
  private static long xar;
  public static final a xas;
  private long wGo;
  private cwh xap;
  private final b xaq;
  
  static
  {
    AppMethodBeat.i(287695);
    xas = new a((byte)0);
    AppMethodBeat.o(287695);
  }
  
  public d(b paramb, bid parambid)
  {
    super(parambid);
    AppMethodBeat.i(287694);
    this.xaq = paramb;
    this.wGo = cm.bfD();
    if (this.wGo < xar)
    {
      l = xar;
      xar = 1L + l;
      this.wGo = l;
    }
    xar = this.wGo;
    this.xap = new cwh();
    paramb = this.xap;
    as localas = as.xco;
    paramb.TFa = as.b(parambid);
    paramb = this.xap;
    int i;
    if (this.xaq.ABw)
    {
      i = 1;
      paramb.fSo = i;
      this.xap.wGo = this.wGo;
      paramb = this.xap;
      parambid = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (!com.tencent.mm.plugin.finder.storage.d.dSu()) {
        break label425;
      }
    }
    label425:
    for (long l = 0L;; l = this.xaq.feedId)
    {
      paramb.HLs = l;
      this.xap.SWw = this.xaq.objectNonceId;
      Log.i("CgiFavMegaVideo", "favId:" + this.wGo + " opType:" + this.xap.fSo + " likeId:" + this.xap.wGo + " action:" + this.xaq.ABw);
      paramb = new com.tencent.mm.an.d.a();
      paramb.c((a)this.xap);
      parambid = new cwi();
      parambid.setBaseResponse(new jh());
      parambid.getBaseResponse().Tef = new eaf();
      paramb.d((a)parambid);
      paramb.TW("/cgi-bin/micromsg-bin/megavideofav");
      paramb.vD(6655);
      c(paramb.bgN());
      Log.i("CgiFavMegaVideo", "favId:" + this.wGo + " CgiFavMegaVideo init " + this.xap.HLs + " and userName " + this.xaq.ABv.getUserName() + " nickname " + this.xaq.ABv.getNickName() + " totalCount:" + this.xaq.ABv.getFavCount());
      AppMethodBeat.o(287694);
      return;
      i = 2;
      break;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiFavMegaVideo$Companion;", "", "()V", "GlobalFavFeedId", "", "getGlobalFavFeedId", "()J", "setGlobalFavFeedId", "(J)V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.d
 * JD-Core Version:    0.7.0.1
 */