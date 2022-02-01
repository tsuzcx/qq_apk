package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.upload.action.b;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.cnq;
import com.tencent.mm.protocal.protobuf.cnr;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiFavMegaVideo;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/MegaVideoFavResp;", "action", "Lcom/tencent/mm/plugin/finder/upload/action/FavAction;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/upload/action/FavAction;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getAction", "()Lcom/tencent/mm/plugin/finder/upload/action/FavAction;", "favId", "", "request", "Lcom/tencent/mm/protocal/protobuf/MegaVideoFavReq;", "initCommReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class c
  extends an<cnr>
{
  private static long tsJ;
  public static final a tsK;
  private long tal;
  private cnq tsH;
  private final b tsI;
  
  static
  {
    AppMethodBeat.i(242202);
    tsK = new a((byte)0);
    AppMethodBeat.o(242202);
  }
  
  public c(b paramb, bbn parambbn)
  {
    super(parambbn);
    AppMethodBeat.i(242201);
    this.tsI = paramb;
    this.tal = cl.aWz();
    if (this.tal < tsJ)
    {
      l = tsJ;
      tsJ = 1L + l;
      this.tal = l;
    }
    tsJ = this.tal;
    this.tsH = new cnq();
    paramb = this.tsH;
    ap localap = ap.tuF;
    paramb.MtV = ap.b(parambbn);
    paramb = this.tsH;
    int i;
    if (this.tsI.vTT)
    {
      i = 1;
      paramb.dYx = i;
      this.tsH.tal = this.tal;
      paramb = this.tsH;
      parambbn = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (!com.tencent.mm.plugin.finder.storage.c.drg()) {
        break label425;
      }
    }
    label425:
    for (long l = 0L;; l = this.tsI.feedId)
    {
      paramb.twG = l;
      this.tsH.LOd = this.tsI.objectNonceId;
      Log.i("CgiFavMegaVideo", "favId:" + this.tal + " opType:" + this.tsH.dYx + " likeId:" + this.tsH.tal + " action:" + this.tsI.vTT);
      paramb = new d.a();
      paramb.c((a)this.tsH);
      parambbn = new cnr();
      parambbn.setBaseResponse(new BaseResponse());
      parambbn.getBaseResponse().ErrMsg = new dqi();
      paramb.d((a)parambbn);
      paramb.MB("/cgi-bin/micromsg-bin/megavideofav");
      paramb.sG(6655);
      c(paramb.aXF());
      Log.i("CgiFavMegaVideo", "favId:" + this.tal + " CgiFavMegaVideo init " + this.tsH.twG + " and userName " + this.tsI.vTS.getUserName() + " nickname " + this.tsI.vTS.getNickName() + " totalCount:" + this.tsI.vTS.getFavCount());
      AppMethodBeat.o(242201);
      return;
      i = 2;
      break;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiFavMegaVideo$Companion;", "", "()V", "GlobalFavFeedId", "", "getGlobalFavFeedId", "()J", "setGlobalFavFeedId", "(J)V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.c
 * JD-Core Version:    0.7.0.1
 */