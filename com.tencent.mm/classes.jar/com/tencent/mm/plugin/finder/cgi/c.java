package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.report.d;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aju;
import com.tencent.mm.protocal.protobuf.ajv;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderFavFeed;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderFavResp;", "action", "Lcom/tencent/mm/plugin/finder/upload/action/FavAction;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/upload/action/FavAction;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getAction", "()Lcom/tencent/mm/plugin/finder/upload/action/FavAction;", "likeId", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderFavReq;", "initCommReqResp", "", "onCgiBack", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class c
  extends r<ajv>
{
  private static long qWM;
  public static final c.a qWN;
  private final String TAG;
  private aju qWJ;
  private long qWK;
  private final com.tencent.mm.plugin.finder.upload.action.b qWL;
  
  static
  {
    AppMethodBeat.i(201102);
    qWN = new c.a((byte)0);
    AppMethodBeat.o(201102);
  }
  
  public c(com.tencent.mm.plugin.finder.upload.action.b paramb, anm paramanm)
  {
    super(paramanm);
    AppMethodBeat.i(201101);
    this.qWL = paramb;
    this.TAG = "Finder.CgiFinderFavFeed";
    this.qWK = ce.azI();
    long l;
    if (this.qWK < qWM)
    {
      l = qWM;
      qWM = 1L + l;
      this.qWK = l;
    }
    qWM = this.qWK;
    this.qWJ = new aju();
    paramb = this.qWJ;
    Object localObject = com.tencent.mm.plugin.finder.storage.b.rCU;
    if (com.tencent.mm.plugin.finder.storage.b.cyx())
    {
      l = 0L;
      paramb.qXP = l;
      this.qWJ.objectNonceId = this.qWL.objectNonceId;
      this.qWJ.qIs = this.qWK;
      this.qWJ.rfC = u.axE();
      paramb = this.qWJ;
      if (!this.qWL.rNH) {
        break label519;
      }
      i = 1;
      label158:
      paramb.dtJ = i;
      paramb = this.qWJ;
      localObject = q.qXH;
      paramb.EDu = q.a(paramanm);
      paramb = this.qWJ;
      localObject = d.rxr;
      l = this.qWL.dig;
      if (paramanm == null) {
        break label524;
      }
    }
    label519:
    label524:
    for (int i = paramanm.rfR;; i = 0)
    {
      paramb.sessionBuffer = d.G(l, i);
      ac.i(this.TAG, "likeId:" + this.qWK + " objectId:" + this.qWJ.qXP + " opType:" + this.qWJ.dtJ + " likeId:" + this.qWJ.qIs + " username:" + this.qWJ.rfC + " action:" + this.qWL.rNH);
      paramb = new b.a();
      paramb.c((a)this.qWJ);
      paramanm = new ajv();
      paramanm.setBaseResponse(new BaseResponse());
      paramanm.getBaseResponse().ErrMsg = new crm();
      paramb.d((a)paramanm);
      paramb.Am("/cgi-bin/micromsg-bin/finderfav");
      paramb.op(3715);
      c(paramb.aAz());
      ac.i(this.TAG, "likeId:" + this.qWK + " CgiFinderLikeComment init " + this.qWJ.qXP + " and userName " + this.qWL.rNG.getUserName() + " nickname " + this.qWL.rNG.getNickName() + " totalCount:" + this.qWL.rNG.getLikeCount());
      AppMethodBeat.o(201101);
      return;
      l = this.qWL.dig;
      break;
      i = 2;
      break label158;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.c
 * JD-Core Version:    0.7.0.1
 */