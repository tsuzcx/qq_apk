package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aot;
import com.tencent.mm.protocal.protobuf.aou;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.atq;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLikeFriend;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeResponse;", "action", "Lcom/tencent/mm/protocal/protobuf/FriendLikeFinderObject;", "likeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FriendLikeFinderObject;Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getAction", "()Lcom/tencent/mm/protocal/protobuf/FriendLikeFinderObject;", "likeId", "", "getLikeInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLikeRequest;", "initCommReqResp", "", "onCgiBack", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class k
  extends w<aov>
{
  private static long rHK;
  public static final a rIe;
  private final String TAG;
  private long rHI;
  private aou rHW;
  private final atq rIc;
  private final aot rId;
  
  static
  {
    AppMethodBeat.i(201034);
    rIe = new a((byte)0);
    AppMethodBeat.o(201034);
  }
  
  public k(atq paramatq, aot paramaot, aqy paramaqy)
  {
    super(paramaqy);
    AppMethodBeat.i(201033);
    this.rIc = paramatq;
    this.rId = paramaot;
    this.TAG = "Finder.CgiFinderLikeFriend";
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
    this.rHW.rIZ = this.rIc.dtq;
    this.rHW.objectNonceId = this.rIc.objectNonceId;
    this.rHW.rHI = this.rHI;
    this.rHW.commentId = this.rId.rHI;
    this.rHW.username = u.aAu();
    this.rHW.scene = this.rIc.scene;
    this.rHW.Gnq = this.rId.dul;
    paramatq = this.rHW;
    if (this.rId.likeFlag == 1)
    {
      i = 5;
      paramatq.opType = i;
      paramatq = this.rHW;
      paramaot = v.rIR;
      paramatq.Glv = v.a(paramaqy);
      paramatq = this.rHW;
      paramaot = h.soM;
      l = this.rIc.dtq;
      if (paramaqy == null) {
        break label523;
      }
    }
    label523:
    for (int i = paramaqy.rTD;; i = 0)
    {
      paramatq.sessionBuffer = h.I(l, i);
      ad.i(this.TAG, "likeId:" + this.rHI + " objectId:" + this.rHW.rIZ + " commentId：" + this.rHW.commentId + " opType:" + this.rHW.opType + " likeId:" + this.rHW.rHI + " username:" + this.rHW.username + " action:" + this.rId.likeFlag);
      paramatq = new b.a();
      paramatq.c((a)this.rHW);
      paramaot = new aov();
      paramaot.setBaseResponse(new BaseResponse());
      paramaot.getBaseResponse().ErrMsg = new cwt();
      paramatq.d((a)paramaot);
      paramatq.Dl("/cgi-bin/micromsg-bin/finderlike");
      paramatq.oP(3710);
      c(paramatq.aDC());
      ad.i(this.TAG, "likeId:" + this.rHI + " CgiFinderLikeComment init " + this.rHW.rIZ + ' ');
      AppMethodBeat.o(201033);
      return;
      i = 6;
      break;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLikeFriend$Companion;", "", "()V", "GlobalLikeFeedId", "", "getGlobalLikeFeedId", "()J", "setGlobalLikeFeedId", "(J)V", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.k
 * JD-Core Version:    0.7.0.1
 */