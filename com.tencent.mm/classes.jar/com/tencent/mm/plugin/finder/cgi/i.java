package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.report.d;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.alo;
import com.tencent.mm.protocal.protobuf.alp;
import com.tencent.mm.protocal.protobuf.alq;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.apw;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLikeFriend;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeResponse;", "action", "Lcom/tencent/mm/protocal/protobuf/FriendLikeFinderObject;", "likeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FriendLikeFinderObject;Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getAction", "()Lcom/tencent/mm/protocal/protobuf/FriendLikeFinderObject;", "likeId", "", "getLikeInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLikeRequest;", "initCommReqResp", "", "onCgiBack", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class i
  extends r<alq>
{
  private static long qWM;
  public static final a qXd;
  private final String TAG;
  private long qWK;
  private alp qWV;
  private final apw qXb;
  private final alo qXc;
  
  static
  {
    AppMethodBeat.i(201112);
    qXd = new a((byte)0);
    AppMethodBeat.o(201112);
  }
  
  public i(apw paramapw, alo paramalo, anm paramanm)
  {
    super(paramanm);
    AppMethodBeat.i(201111);
    this.qXb = paramapw;
    this.qXc = paramalo;
    this.TAG = "Finder.CgiFinderLikeFriend";
    this.qWK = ce.azI();
    long l;
    if (this.qWK < qWM)
    {
      l = qWM;
      qWM = 1L + l;
      this.qWK = l;
    }
    qWM = this.qWK;
    this.qWV = new alp();
    this.qWV.qXP = this.qXb.dig;
    this.qWV.objectNonceId = this.qXb.objectNonceId;
    this.qWV.qWK = this.qWK;
    this.qWV.commentId = this.qXc.qWK;
    this.qWV.username = u.axE();
    this.qWV.scene = this.qXb.scene;
    this.qWV.EFj = this.qXc.diA;
    paramapw = this.qWV;
    if (this.qXc.likeFlag == 1)
    {
      i = 5;
      paramapw.opType = i;
      paramapw = this.qWV;
      paramalo = q.qXH;
      paramapw.EDL = q.a(paramanm);
      paramapw = this.qWV;
      paramalo = d.rxr;
      l = this.qXb.dig;
      if (paramanm == null) {
        break label523;
      }
    }
    label523:
    for (int i = paramanm.rfR;; i = 0)
    {
      paramapw.sessionBuffer = d.G(l, i);
      ac.i(this.TAG, "likeId:" + this.qWK + " objectId:" + this.qWV.qXP + " commentId：" + this.qWV.commentId + " opType:" + this.qWV.opType + " likeId:" + this.qWV.qWK + " username:" + this.qWV.username + " action:" + this.qXc.likeFlag);
      paramapw = new b.a();
      paramapw.c((a)this.qWV);
      paramalo = new alq();
      paramalo.setBaseResponse(new BaseResponse());
      paramalo.getBaseResponse().ErrMsg = new crm();
      paramapw.d((a)paramalo);
      paramapw.Am("/cgi-bin/micromsg-bin/finderlike");
      paramapw.op(3710);
      c(paramapw.aAz());
      ac.i(this.TAG, "likeId:" + this.qWK + " CgiFinderLikeComment init " + this.qWV.qXP + ' ');
      AppMethodBeat.o(201111);
      return;
      i = 6;
      break;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLikeFriend$Companion;", "", "()V", "GlobalLikeFeedId", "", "getGlobalLikeFeedId", "()J", "setGlobalLikeFeedId", "(J)V", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.i
 * JD-Core Version:    0.7.0.1
 */