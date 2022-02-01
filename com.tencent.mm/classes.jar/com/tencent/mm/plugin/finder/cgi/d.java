package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.protocal.protobuf.ane;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderFavFeed;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderFavResp;", "action", "Lcom/tencent/mm/plugin/finder/upload/action/FavAction;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/upload/action/FavAction;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getAction", "()Lcom/tencent/mm/plugin/finder/upload/action/FavAction;", "likeId", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderFavReq;", "initCommReqResp", "", "onCgiBack", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class d
  extends w<ane>
{
  private static long rPV;
  public static final a rPW;
  private final String TAG;
  private and rPS;
  private long rPT;
  private final com.tencent.mm.plugin.finder.upload.action.b rPU;
  
  static
  {
    AppMethodBeat.i(201443);
    rPW = new a((byte)0);
    AppMethodBeat.o(201443);
  }
  
  public d(com.tencent.mm.plugin.finder.upload.action.b paramb, arn paramarn)
  {
    super(paramarn);
    AppMethodBeat.i(201442);
    this.rPU = paramb;
    this.TAG = "Finder.CgiFinderFavFeed";
    this.rPT = ch.aDb();
    long l;
    if (this.rPT < rPV)
    {
      l = rPV;
      rPV = 1L + l;
      this.rPT = l;
    }
    rPV = this.rPT;
    this.rPS = new and();
    paramb = this.rPS;
    Object localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
    if (com.tencent.mm.plugin.finder.storage.b.cHv())
    {
      l = 0L;
      paramb.rRn = l;
      this.rPS.objectNonceId = this.rPU.objectNonceId;
      this.rPS.rAG = this.rPT;
      this.rPS.sbR = com.tencent.mm.model.v.aAK();
      paramb = this.rPS;
      if (!this.rPU.sUZ) {
        break label519;
      }
      i = 1;
      label158:
      paramb.dGO = i;
      paramb = this.rPS;
      localObject = v.rRb;
      paramb.GEg = v.a(paramarn);
      paramb = this.rPS;
      localObject = i.syT;
      l = this.rPU.duw;
      if (paramarn == null) {
        break label524;
      }
    }
    label519:
    label524:
    for (int i = paramarn.sch;; i = 0)
    {
      paramb.sessionBuffer = i.I(l, i);
      ae.i(this.TAG, "likeId:" + this.rPT + " objectId:" + this.rPS.rRn + " opType:" + this.rPS.dGO + " likeId:" + this.rPS.rAG + " username:" + this.rPS.sbR + " action:" + this.rPU.sUZ);
      paramb = new b.a();
      paramb.c((a)this.rPS);
      paramarn = new ane();
      paramarn.setBaseResponse(new BaseResponse());
      paramarn.getBaseResponse().ErrMsg = new cxn();
      paramb.d((a)paramarn);
      paramb.DN("/cgi-bin/micromsg-bin/finderfav");
      paramb.oS(3715);
      c(paramb.aDS());
      ae.i(this.TAG, "likeId:" + this.rPT + " CgiFinderLikeComment init " + this.rPS.rRn + " and userName " + this.rPU.sUY.getUserName() + " nickname " + this.rPU.sUY.getNickName() + " totalCount:" + this.rPU.sUY.getLikeCount());
      AppMethodBeat.o(201442);
      return;
      l = this.rPU.duw;
      break;
      i = 2;
      break label158;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderFavFeed$Companion;", "", "()V", "GlobalLikeFeedId", "", "getGlobalLikeFeedId", "()J", "setGlobalLikeFeedId", "(J)V", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.d
 * JD-Core Version:    0.7.0.1
 */