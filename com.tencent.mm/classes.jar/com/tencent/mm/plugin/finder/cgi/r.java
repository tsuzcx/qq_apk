package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aul;
import com.tencent.mm.protocal.protobuf.auo;
import com.tencent.mm.protocal.protobuf.aup;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bfp;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLikeFriend;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeResponse;", "action", "Lcom/tencent/mm/protocal/protobuf/FriendLikeFinderObject;", "likeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FriendLikeFinderObject;Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getAction", "()Lcom/tencent/mm/protocal/protobuf/FriendLikeFinderObject;", "likeId", "", "getLikeInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLikeRequest;", "initCommReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class r
  extends an<aup>
{
  private static long tsS;
  public static final a ttr;
  private final String TAG;
  private long tsR;
  private auo ttj;
  private final bfp ttp;
  private final aul ttq;
  
  static
  {
    AppMethodBeat.i(242239);
    ttr = new a((byte)0);
    AppMethodBeat.o(242239);
  }
  
  public r(bfp parambfp, aul paramaul, bbn parambbn)
  {
    super(parambbn);
    AppMethodBeat.i(242238);
    this.ttp = parambfp;
    this.ttq = paramaul;
    this.TAG = "Finder.CgiFinderLikeFriend";
    this.tsR = cl.aWz();
    long l;
    if (this.tsR < tsS)
    {
      l = tsS;
      tsS = 1L + l;
      this.tsR = l;
    }
    tsS = this.tsR;
    this.ttj = new auo();
    this.ttj.hFK = this.ttp.feedId;
    this.ttj.objectNonceId = this.ttp.objectNonceId;
    this.ttj.tsR = this.tsR;
    this.ttj.commentId = this.ttq.tsR;
    this.ttj.username = z.aUg();
    this.ttj.scene = this.ttp.scene;
    this.ttj.LFu = this.ttq.dMW;
    parambfp = this.ttj;
    if (this.ttq.likeFlag == 1)
    {
      i = 5;
      parambfp.opType = i;
      parambfp = this.ttj;
      paramaul = am.tuw;
      parambfp.uli = am.a(parambbn);
      parambfp = this.ttj;
      paramaul = k.vfA;
      l = this.ttp.feedId;
      if (parambbn == null) {
        break label523;
      }
    }
    label523:
    for (int i = parambbn.tCE;; i = 0)
    {
      parambfp.sessionBuffer = k.G(l, i);
      Log.i(this.TAG, "likeId:" + this.tsR + " objectId:" + this.ttj.hFK + " commentId：" + this.ttj.commentId + " opType:" + this.ttj.opType + " likeId:" + this.ttj.tsR + " username:" + this.ttj.username + " action:" + this.ttq.likeFlag);
      parambfp = new d.a();
      parambfp.c((a)this.ttj);
      paramaul = new aup();
      paramaul.setBaseResponse(new BaseResponse());
      paramaul.getBaseResponse().ErrMsg = new dqi();
      parambfp.d((a)paramaul);
      parambfp.MB("/cgi-bin/micromsg-bin/finderlike");
      parambfp.sG(3710);
      c(parambfp.aXF());
      Log.i(this.TAG, "likeId:" + this.tsR + " CgiFinderLikeComment init " + this.ttj.hFK + ' ');
      AppMethodBeat.o(242238);
      return;
      i = 6;
      break;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLikeFriend$Companion;", "", "()V", "GlobalLikeFeedId", "", "getGlobalLikeFeedId", "()J", "setGlobalLikeFeedId", "(J)V", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.r
 * JD-Core Version:    0.7.0.1
 */