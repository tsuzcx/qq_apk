package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.report.b;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.ajo;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.dzd;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.protocal.protobuf.dzz;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLikeFriend;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeResponse;", "action", "Lcom/tencent/mm/protocal/protobuf/FriendLikeFinderObject;", "likeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FriendLikeFinderObject;Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getAction", "()Lcom/tencent/mm/protocal/protobuf/FriendLikeFinderObject;", "likeId", "", "getLikeInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLikeRequest;", "initCommReqResp", "", "onCgiBack", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class aj
  extends an<ajo>
{
  public static final a KJt;
  private static long qow;
  private final dzz KJr;
  private final dzd KJs;
  private final String TAG;
  private ajn qoq;
  private long qou;
  
  static
  {
    AppMethodBeat.i(197259);
    KJt = new a((byte)0);
    AppMethodBeat.o(197259);
  }
  
  public aj(dzz paramdzz, dzd paramdzd, dzp paramdzp)
  {
    super(paramdzp);
    AppMethodBeat.i(197258);
    this.KJr = paramdzz;
    this.KJs = paramdzd;
    this.TAG = "Finder.CgiFinderLikeFriend";
    this.qou = ce.asR();
    long l;
    if (this.qou < qow)
    {
      l = qow;
      qow = 1L + l;
      this.qou = l;
    }
    qow = this.qou;
    this.qoq = new ajn();
    this.qoq.objectId = this.KJr.feedId;
    this.qoq.objectNonceId = this.KJr.objectNonceId;
    this.qoq.qou = this.qou;
    this.qoq.commentId = this.KJs.qou;
    this.qoq.username = u.aqO();
    this.qoq.scene = this.KJr.scene;
    this.qoq.LxG = this.KJs.hKD;
    paramdzz = this.qoq;
    if (this.KJs.likeFlag == 1)
    {
      i = 5;
      paramdzz.opType = i;
      paramdzz = this.qoq;
      paramdzd = am.KJy;
      paramdzz.Dkw = am.a(paramdzp);
      paramdzz = this.qoq;
      paramdzd = b.qFq;
      l = this.KJr.feedId;
      if (paramdzp == null) {
        break label523;
      }
    }
    label523:
    for (int i = paramdzp.qqE;; i = 0)
    {
      paramdzz.sessionBuffer = b.am(l, i);
      ad.i(this.TAG, "likeId:" + this.qou + " objectId:" + this.qoq.objectId + " commentId：" + this.qoq.commentId + " opType:" + this.qoq.opType + " likeId:" + this.qoq.qou + " username:" + this.qoq.username + " action:" + this.KJs.likeFlag);
      paramdzz = new b.a();
      paramdzz.c((a)this.qoq);
      paramdzd = new ajo();
      paramdzd.setBaseResponse(new BaseResponse());
      paramdzd.getBaseResponse().ErrMsg = new cmf();
      paramdzz.d((a)paramdzd);
      paramdzz.wg("/cgi-bin/micromsg-bin/finderlike");
      paramdzz.nB(3710);
      c(paramdzz.atI());
      ad.i(this.TAG, "likeId:" + this.qou + " CgiFinderLikeComment init " + this.qoq.objectId + ' ');
      AppMethodBeat.o(197258);
      return;
      i = 6;
      break;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLikeFriend$Companion;", "", "()V", "GlobalLikeFeedId", "", "getGlobalLikeFeedId", "()J", "setGlobalLikeFeedId", "(J)V", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.aj
 * JD-Core Version:    0.7.0.1
 */