package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.plugin.finder.upload.action.f;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.alk;
import com.tencent.mm.protocal.protobuf.aou;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLikeFeed;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeResponse;", "action", "Lcom/tencent/mm/plugin/finder/upload/action/LikeAction;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/upload/action/LikeAction;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getAction", "()Lcom/tencent/mm/plugin/finder/upload/action/LikeAction;", "likeId", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLikeRequest;", "initCommReqResp", "", "onCgiBack", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class j
  extends w<aov>
{
  private static long rHK;
  public static final a rIb;
  private final String TAG;
  private long rHI;
  private aou rHW;
  private final f rIa;
  
  static
  {
    AppMethodBeat.i(165171);
    rIb = new a((byte)0);
    AppMethodBeat.o(165171);
  }
  
  public j(f paramf, aqy paramaqy)
  {
    super(paramaqy);
    AppMethodBeat.i(201031);
    this.rIa = paramf;
    this.TAG = "Finder.CgiFinderLikeFeed";
    this.rHI = cf.aCL();
    long l;
    if (this.rHI < rHK)
    {
      l = rHK;
      rHK = 1L + l;
      this.rHI = l;
    }
    rHK = this.rHI;
    this.rHW = new aou();
    paramf = this.rHW;
    Object localObject = b.sxa;
    if (b.cFy())
    {
      l = 0L;
      paramf.rIZ = l;
      this.rHW.objectNonceId = this.rIa.objectNonceId;
      this.rHW.rHI = this.rHI;
      this.rHW.username = u.aAu();
      this.rHW.scene = this.rIa.scene;
      paramf = this.rHW;
      if (!this.rIa.sKc) {
        break label565;
      }
      i = 3;
      label172:
      paramf.opType = i;
      paramf = this.rHW;
      if (!this.rIa.sKd) {
        break label570;
      }
    }
    label565:
    label570:
    for (int i = 1;; i = 0)
    {
      paramf.Gnr = i;
      paramf = this.rHW;
      localObject = v.rIR;
      paramf.Glv = v.a(paramaqy);
      paramf = this.rHW;
      paramaqy = h.soM;
      paramf.sessionBuffer = h.I(this.rIa.dtq, this.rHW.Glv.scene);
      ad.i(this.TAG, "likeId:" + this.rHI + " objectId:" + this.rHW.rIZ + " opType:" + this.rHW.opType + " likeId:" + this.rHW.rHI + " username:" + this.rHW.username + " action:" + this.rIa.sKc + ", private:" + this.rIa.sKd);
      paramf = new b.a();
      paramf.c((a)this.rHW);
      paramaqy = new aov();
      paramaqy.setBaseResponse(new BaseResponse());
      paramaqy.getBaseResponse().ErrMsg = new cwt();
      paramf.d((a)paramaqy);
      paramf.Dl("/cgi-bin/micromsg-bin/finderlike");
      paramf.oP(3710);
      c(paramf.aDC());
      ad.i(this.TAG, "likeId:" + this.rHI + " CgiFinderLikeComment init " + this.rHW.rIZ + " and userName " + this.rIa.sJL.getUserName() + " nickname " + this.rIa.sJL.getNickName() + " totalCount:" + this.rIa.sJL.getLikeCount());
      AppMethodBeat.o(201031);
      return;
      l = this.rIa.dtq;
      break;
      i = 4;
      break label172;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLikeFeed$Companion;", "", "()V", "GlobalLikeFeedId", "", "getGlobalLikeFeedId", "()J", "setGlobalLikeFeedId", "(J)V", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.j
 * JD-Core Version:    0.7.0.1
 */