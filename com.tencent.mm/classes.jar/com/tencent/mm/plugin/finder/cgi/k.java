package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.protocal.protobuf.aph;
import com.tencent.mm.protocal.protobuf.api;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.aug;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLikeFriend;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeResponse;", "action", "Lcom/tencent/mm/protocal/protobuf/FriendLikeFinderObject;", "likeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FriendLikeFinderObject;Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getAction", "()Lcom/tencent/mm/protocal/protobuf/FriendLikeFinderObject;", "likeId", "", "getLikeInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLikeRequest;", "initCommReqResp", "", "onCgiBack", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class k
  extends w<api>
{
  private static long rPV;
  public static final a rQp;
  private final String TAG;
  private long rPT;
  private aph rQh;
  private final aug rQn;
  private final apg rQo;
  
  static
  {
    AppMethodBeat.i(201456);
    rQp = new a((byte)0);
    AppMethodBeat.o(201456);
  }
  
  public k(aug paramaug, apg paramapg, arn paramarn)
  {
    super(paramarn);
    AppMethodBeat.i(201455);
    this.rQn = paramaug;
    this.rQo = paramapg;
    this.TAG = "Finder.CgiFinderLikeFriend";
    this.rPT = ch.aDb();
    long l;
    if (this.rPT < rPV)
    {
      l = rPV;
      rPV = 1L + l;
      this.rPT = l;
    }
    rPV = this.rPT;
    this.rQh = new aph();
    this.rQh.rRn = this.rQn.duw;
    this.rQh.objectNonceId = this.rQn.objectNonceId;
    this.rQh.rPT = this.rPT;
    this.rQh.commentId = this.rQo.rPT;
    this.rQh.username = com.tencent.mm.model.v.aAK();
    this.rQh.scene = this.rQn.scene;
    this.rQh.GGw = this.rQo.dvq;
    paramaug = this.rQh;
    if (this.rQo.likeFlag == 1)
    {
      i = 5;
      paramaug.opType = i;
      paramaug = this.rQh;
      paramapg = v.rRb;
      paramaug.GDR = v.a(paramarn);
      paramaug = this.rQh;
      paramapg = i.syT;
      l = this.rQn.duw;
      if (paramarn == null) {
        break label523;
      }
    }
    label523:
    for (int i = paramarn.sch;; i = 0)
    {
      paramaug.sessionBuffer = i.I(l, i);
      ae.i(this.TAG, "likeId:" + this.rPT + " objectId:" + this.rQh.rRn + " commentId：" + this.rQh.commentId + " opType:" + this.rQh.opType + " likeId:" + this.rQh.rPT + " username:" + this.rQh.username + " action:" + this.rQo.likeFlag);
      paramaug = new b.a();
      paramaug.c((a)this.rQh);
      paramapg = new api();
      paramapg.setBaseResponse(new BaseResponse());
      paramapg.getBaseResponse().ErrMsg = new cxn();
      paramaug.d((a)paramapg);
      paramaug.DN("/cgi-bin/micromsg-bin/finderlike");
      paramaug.oS(3710);
      c(paramaug.aDS());
      ae.i(this.TAG, "likeId:" + this.rPT + " CgiFinderLikeComment init " + this.rQh.rRn + ' ');
      AppMethodBeat.o(201455);
      return;
      i = 6;
      break;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLikeFriend$Companion;", "", "()V", "GlobalLikeFeedId", "", "getGlobalLikeFeedId", "()J", "setGlobalLikeFeedId", "(J)V", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.k
 * JD-Core Version:    0.7.0.1
 */