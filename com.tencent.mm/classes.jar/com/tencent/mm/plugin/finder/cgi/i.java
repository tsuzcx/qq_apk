package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.storage.ab;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.alh;
import com.tencent.mm.protocal.protobuf.alk;
import com.tencent.mm.protocal.protobuf.aou;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLikeComment;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeResponse;", "action", "Lcom/tencent/mm/plugin/finder/upload/action/LikeCommentAction;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/upload/action/LikeCommentAction;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getAction", "()Lcom/tencent/mm/plugin/finder/upload/action/LikeCommentAction;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLikeRequest;", "initCommReqResp", "", "onCgiBack", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class i
  extends w<aov>
{
  private static long rHY;
  public static final a rHZ;
  private final String TAG;
  private aou rHW;
  private final com.tencent.mm.plugin.finder.upload.action.i rHX;
  
  static
  {
    AppMethodBeat.i(165168);
    rHZ = new a((byte)0);
    AppMethodBeat.o(165168);
  }
  
  public i(com.tencent.mm.plugin.finder.upload.action.i parami, aqy paramaqy)
  {
    super(paramaqy);
    AppMethodBeat.i(201030);
    this.rHX = parami;
    this.TAG = "Finder.CgiFinderLikeComment";
    long l2 = cf.aCL();
    long l1 = l2;
    if (l2 < rHY)
    {
      l1 = rHY;
      rHY = 1L + l1;
    }
    rHY = l1;
    this.rHW = new aou();
    parami = this.rHW;
    Object localObject = b.sxa;
    if (b.cFy())
    {
      l2 = 0L;
      parami.rIZ = l2;
      this.rHW.objectNonceId = this.rHX.objectNonceId;
      this.rHW.commentId = this.rHX.sKn.field_actionInfo.Gla.commentId;
      this.rHW.rHI = l1;
      if (this.rHX.scene == 1) {
        this.rHW.username = u.aAu();
      }
      parami = this.rHW;
      localObject = v.rIR;
      parami.Glv = v.a(paramaqy);
      this.rHW.scene = this.rHX.scene;
      parami = this.rHW;
      if (!this.rHX.sKc) {
        break label412;
      }
    }
    label412:
    for (int i = 1;; i = 2)
    {
      parami.opType = i;
      parami = this.rHW;
      paramaqy = h.soM;
      parami.sessionBuffer = h.I(this.rHX.dtq, this.rHW.Glv.scene);
      parami = new b.a();
      parami.c((a)this.rHW);
      paramaqy = new aov();
      paramaqy.setBaseResponse(new BaseResponse());
      paramaqy.getBaseResponse().ErrMsg = new cwt();
      parami.d((a)paramaqy);
      parami.Dl("/cgi-bin/micromsg-bin/finderlike");
      parami.oP(3710);
      c(parami.aDC());
      ad.i(this.TAG, "CgiFinderLikeComment init " + this.rHW.rIZ + " and userName " + this.rHW.username + " comment:" + this.rHX.sKn);
      AppMethodBeat.o(201030);
      return;
      l2 = this.rHX.dtq;
      break;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLikeComment$Companion;", "", "()V", "GlobalLikeCommentId", "", "getGlobalLikeCommentId", "()J", "setGlobalLikeCommentId", "(J)V", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.i
 * JD-Core Version:    0.7.0.1
 */