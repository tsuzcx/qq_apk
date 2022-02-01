package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.amr;
import com.tencent.mm.protocal.protobuf.ams;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderFavFeed;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderFavResp;", "action", "Lcom/tencent/mm/plugin/finder/upload/action/FavAction;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/upload/action/FavAction;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getAction", "()Lcom/tencent/mm/plugin/finder/upload/action/FavAction;", "likeId", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderFavReq;", "initCommReqResp", "", "onCgiBack", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class d
  extends w<ams>
{
  private static long rHK;
  public static final a rHL;
  private final String TAG;
  private amr rHH;
  private long rHI;
  private final com.tencent.mm.plugin.finder.upload.action.b rHJ;
  
  static
  {
    AppMethodBeat.i(201021);
    rHL = new a((byte)0);
    AppMethodBeat.o(201021);
  }
  
  public d(com.tencent.mm.plugin.finder.upload.action.b paramb, aqy paramaqy)
  {
    super(paramaqy);
    AppMethodBeat.i(201020);
    this.rHJ = paramb;
    this.TAG = "Finder.CgiFinderFavFeed";
    this.rHI = cf.aCL();
    long l;
    if (this.rHI < rHK)
    {
      l = rHK;
      rHK = 1L + l;
      this.rHI = l;
    }
    rHK = this.rHI;
    this.rHH = new amr();
    paramb = this.rHH;
    Object localObject = com.tencent.mm.plugin.finder.storage.b.sxa;
    if (com.tencent.mm.plugin.finder.storage.b.cFy())
    {
      l = 0L;
      paramb.rIZ = l;
      this.rHH.objectNonceId = this.rHJ.objectNonceId;
      this.rHH.rst = this.rHI;
      this.rHH.rTn = u.aAu();
      paramb = this.rHH;
      if (!this.rHJ.sJM) {
        break label519;
      }
      i = 1;
      label158:
      paramb.dFJ = i;
      paramb = this.rHH;
      localObject = v.rIR;
      paramb.Gle = v.a(paramaqy);
      paramb = this.rHH;
      localObject = h.soM;
      l = this.rHJ.dtq;
      if (paramaqy == null) {
        break label524;
      }
    }
    label519:
    label524:
    for (int i = paramaqy.rTD;; i = 0)
    {
      paramb.sessionBuffer = h.I(l, i);
      ad.i(this.TAG, "likeId:" + this.rHI + " objectId:" + this.rHH.rIZ + " opType:" + this.rHH.dFJ + " likeId:" + this.rHH.rst + " username:" + this.rHH.rTn + " action:" + this.rHJ.sJM);
      paramb = new b.a();
      paramb.c((a)this.rHH);
      paramaqy = new ams();
      paramaqy.setBaseResponse(new BaseResponse());
      paramaqy.getBaseResponse().ErrMsg = new cwt();
      paramb.d((a)paramaqy);
      paramb.Dl("/cgi-bin/micromsg-bin/finderfav");
      paramb.oP(3715);
      c(paramb.aDC());
      ad.i(this.TAG, "likeId:" + this.rHI + " CgiFinderLikeComment init " + this.rHH.rIZ + " and userName " + this.rHJ.sJL.getUserName() + " nickname " + this.rHJ.sJL.getNickName() + " totalCount:" + this.rHJ.sJL.getLikeCount());
      AppMethodBeat.o(201020);
      return;
      l = this.rHJ.dtq;
      break;
      i = 2;
      break label158;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderFavFeed$Companion;", "", "()V", "GlobalLikeFeedId", "", "getGlobalLikeFeedId", "()J", "setGlobalLikeFeedId", "(J)V", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.d
 * JD-Core Version:    0.7.0.1
 */