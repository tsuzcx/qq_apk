package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.upload.action.k;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.dns;
import com.tencent.mm.protocal.protobuf.dnt;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiLikeMegaVideo;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/MegaVideoLikeResponse;", "action", "Lcom/tencent/mm/plugin/finder/upload/action/LikeAction;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/upload/action/LikeAction;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getAction", "()Lcom/tencent/mm/plugin/finder/upload/action/LikeAction;", "likeId", "", "request", "Lcom/tencent/mm/protocal/protobuf/MegaVideoLikeRequest;", "initCommReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bc
  extends c<dnt>
{
  public static final a ABd;
  private static long AyQ;
  private dns ABe;
  private long AyP;
  private final k AzH;
  
  static
  {
    AppMethodBeat.i(336180);
    ABd = new a((byte)0);
    AppMethodBeat.o(336180);
  }
  
  public bc(k paramk, bui parambui)
  {
    super(parambui);
    AppMethodBeat.i(336172);
    this.AzH = paramk;
    this.AyP = cn.bDv();
    if (this.AyP < AyQ)
    {
      l = AyQ;
      AyQ = 1L + l;
      this.AyP = l;
    }
    AyQ = this.AyP;
    this.ABe = new dns();
    paramk = this.ABe;
    bn localbn = bn.ABz;
    paramk.aaUG = bn.b(parambui);
    paramk = this.ABe;
    int i;
    if (this.AzH.GaB)
    {
      i = 1;
      paramk.opType = i;
      this.ABe.AyP = this.AyP;
      paramk = this.ABe;
      parambui = d.FAy;
      if (!d.eQI()) {
        break label425;
      }
    }
    label425:
    for (long l = 0L;; l = this.AzH.feedId)
    {
      paramk.NIs = l;
      this.ABe.aahV = this.AzH.objectNonceId;
      Log.i("CgiLikeMegaVideo", "likeId:" + this.AyP + " opType:" + this.ABe.opType + " likeId:" + this.ABe.AyP + " action:" + this.AzH.GaB);
      paramk = new c.a();
      paramk.otE = ((a)this.ABe);
      parambui = new dnt();
      parambui.setBaseResponse(new kd());
      parambui.getBaseResponse().akjO = new etl();
      paramk.otF = ((a)parambui);
      paramk.uri = "/cgi-bin/micromsg-bin/megavideolike";
      paramk.funcId = 5232;
      c(paramk.bEF());
      Log.i("CgiLikeMegaVideo", "likeId:" + this.AyP + " CgiLikeMegaVideo init " + this.ABe.NIs + " and userName " + this.AzH.GcF.getUserName() + " nickname " + this.AzH.GcF.getNickName() + " totalCount:" + this.AzH.GcF.getLikeCount());
      AppMethodBeat.o(336172);
      return;
      i = 2;
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiLikeMegaVideo$Companion;", "", "()V", "GlobalLikeFeedId", "", "getGlobalLikeFeedId", "()J", "setGlobalLikeFeedId", "(J)V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bc
 * JD-Core Version:    0.7.0.1
 */