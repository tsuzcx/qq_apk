package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.upload.action.b;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.dnm;
import com.tencent.mm.protocal.protobuf.dnn;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFavMegaVideo;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/MegaVideoFavResp;", "action", "Lcom/tencent/mm/plugin/finder/upload/action/FavAction;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/upload/action/FavAction;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getAction", "()Lcom/tencent/mm/plugin/finder/upload/action/FavAction;", "favId", "", "request", "Lcom/tencent/mm/protocal/protobuf/MegaVideoFavReq;", "initCommReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends c<dnn>
{
  public static final a Ayt;
  private static long Ayw;
  private long Acx;
  private final b Ayu;
  private dnm Ayv;
  
  static
  {
    AppMethodBeat.i(336294);
    Ayt = new a((byte)0);
    AppMethodBeat.o(336294);
  }
  
  public e(b paramb, bui parambui)
  {
    super(parambui);
    AppMethodBeat.i(336287);
    this.Ayu = paramb;
    this.Acx = cn.bDv();
    if (this.Acx < Ayw)
    {
      l = Ayw;
      Ayw = 1L + l;
      this.Acx = l;
    }
    Ayw = this.Acx;
    this.Ayv = new dnm();
    paramb = this.Ayv;
    bn localbn = bn.ABz;
    paramb.aaUG = bn.b(parambui);
    paramb = this.Ayv;
    int i;
    if (this.Ayu.GcG)
    {
      i = 1;
      paramb.hYl = i;
      this.Ayv.Acx = this.Acx;
      paramb = this.Ayv;
      parambui = d.FAy;
      if (!d.eQI()) {
        break label425;
      }
    }
    label425:
    for (long l = 0L;; l = this.Ayu.feedId)
    {
      paramb.NIs = l;
      this.Ayv.aahV = this.Ayu.objectNonceId;
      Log.i("CgiFavMegaVideo", "favId:" + this.Acx + " opType:" + this.Ayv.hYl + " likeId:" + this.Ayv.Acx + " action:" + this.Ayu.GcG);
      paramb = new c.a();
      paramb.otE = ((a)this.Ayv);
      parambui = new dnn();
      parambui.setBaseResponse(new kd());
      parambui.getBaseResponse().akjO = new etl();
      paramb.otF = ((a)parambui);
      paramb.uri = "/cgi-bin/micromsg-bin/megavideofav";
      paramb.funcId = 6655;
      c(paramb.bEF());
      Log.i("CgiFavMegaVideo", "favId:" + this.Acx + " CgiFavMegaVideo init " + this.Ayv.NIs + " and userName " + this.Ayu.GcF.getUserName() + " nickname " + this.Ayu.GcF.getNickName() + " totalCount:" + this.Ayu.GcF.getFavCount());
      AppMethodBeat.o(336287);
      return;
      i = 2;
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFavMegaVideo$Companion;", "", "()V", "GlobalFavFeedId", "", "getGlobalFavFeedId", "()J", "setGlobalFavFeedId", "(J)V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.e
 * JD-Core Version:    0.7.0.1
 */