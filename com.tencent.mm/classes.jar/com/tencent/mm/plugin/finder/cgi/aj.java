package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.upload.action.k;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.cwn;
import com.tencent.mm.protocal.protobuf.cwo;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiLikeMegaVideo;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/MegaVideoLikeResponse;", "action", "Lcom/tencent/mm/plugin/finder/upload/action/LikeAction;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/upload/action/LikeAction;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getAction", "()Lcom/tencent/mm/plugin/finder/upload/action/LikeAction;", "likeId", "", "request", "Lcom/tencent/mm/protocal/protobuf/MegaVideoLikeRequest;", "initCommReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class aj
  extends c<cwo>
{
  private static long xaH;
  public static final a xcc;
  private long xaG;
  private final k xbe;
  private cwn xcb;
  
  static
  {
    AppMethodBeat.i(228939);
    xcc = new a((byte)0);
    AppMethodBeat.o(228939);
  }
  
  public aj(k paramk, bid parambid)
  {
    super(parambid);
    AppMethodBeat.i(228938);
    this.xbe = paramk;
    this.xaG = cm.bfD();
    if (this.xaG < xaH)
    {
      l = xaH;
      xaH = 1L + l;
      this.xaG = l;
    }
    xaH = this.xaG;
    this.xcb = new cwn();
    paramk = this.xcb;
    as localas = as.xco;
    paramk.TFa = as.b(parambid);
    paramk = this.xcb;
    int i;
    if (this.xbe.ACe)
    {
      i = 1;
      paramk.opType = i;
      this.xcb.xaG = this.xaG;
      paramk = this.xcb;
      parambid = d.AjH;
      if (!d.dSu()) {
        break label425;
      }
    }
    label425:
    for (long l = 0L;; l = this.xbe.feedId)
    {
      paramk.HLs = l;
      this.xcb.SWw = this.xbe.objectNonceId;
      Log.i("CgiLikeMegaVideo", "likeId:" + this.xaG + " opType:" + this.xcb.opType + " likeId:" + this.xcb.xaG + " action:" + this.xbe.ACe);
      paramk = new d.a();
      paramk.c((a)this.xcb);
      parambid = new cwo();
      parambid.setBaseResponse(new jh());
      parambid.getBaseResponse().Tef = new eaf();
      paramk.d((a)parambid);
      paramk.TW("/cgi-bin/micromsg-bin/megavideolike");
      paramk.vD(5232);
      c(paramk.bgN());
      Log.i("CgiLikeMegaVideo", "likeId:" + this.xaG + " CgiLikeMegaVideo init " + this.xcb.HLs + " and userName " + this.xbe.ABv.getUserName() + " nickname " + this.xbe.ABv.getNickName() + " totalCount:" + this.xbe.ABv.getLikeCount());
      AppMethodBeat.o(228938);
      return;
      i = 2;
      break;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiLikeMegaVideo$Companion;", "", "()V", "GlobalLikeFeedId", "", "getGlobalLikeFeedId", "()J", "setGlobalLikeFeedId", "(J)V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.aj
 * JD-Core Version:    0.7.0.1
 */