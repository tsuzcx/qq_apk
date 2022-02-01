package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.awr;
import com.tencent.mm.protocal.protobuf.awu;
import com.tencent.mm.protocal.protobuf.awv;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.bmq;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLikeFriend;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeResponse;", "action", "Lcom/tencent/mm/protocal/protobuf/FriendLikeFinderObject;", "likeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FriendLikeFinderObject;Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getAction", "()Lcom/tencent/mm/protocal/protobuf/FriendLikeFinderObject;", "likeId", "", "getLikeInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLikeRequest;", "initCommReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class v
  extends c<awv>
{
  private static long xaH;
  public static final a xbi;
  private final String TAG;
  private long xaG;
  private awu xba;
  private final bmq xbg;
  private final awr xbh;
  
  static
  {
    AppMethodBeat.i(285517);
    xbi = new a((byte)0);
    AppMethodBeat.o(285517);
  }
  
  public v(bmq parambmq, awr paramawr, bid parambid)
  {
    super(parambid);
    AppMethodBeat.i(285516);
    this.xbg = parambmq;
    this.xbh = paramawr;
    this.TAG = "Finder.CgiFinderLikeFriend";
    this.xaG = cm.bfD();
    long l;
    if (this.xaG < xaH)
    {
      l = xaH;
      xaH = 1L + l;
      this.xaG = l;
    }
    xaH = this.xaG;
    this.xba = new awu();
    this.xba.xbk = this.xbg.feedId;
    this.xba.objectNonceId = this.xbg.objectNonceId;
    this.xba.xaG = this.xaG;
    this.xba.commentId = this.xbh.xaG;
    this.xba.username = z.bdh();
    this.xba.scene = this.xbg.scene;
    this.xba.SJv = this.xbh.fGe;
    parambmq = this.xba;
    if (this.xbh.likeFlag == 1)
    {
      i = 5;
      parambmq.opType = i;
      parambmq = this.xba;
      paramawr = ao.xcj;
      parambmq.yjp = ao.a(parambid);
      parambmq = this.xba;
      paramawr = n.zWF;
      l = this.xbg.feedId;
      if (parambid == null) {
        break label523;
      }
    }
    label523:
    for (int i = parambid.xkX;; i = 0)
    {
      parambmq.sessionBuffer = n.N(l, i);
      Log.i(this.TAG, "likeId:" + this.xaG + " objectId:" + this.xba.xbk + " commentId：" + this.xba.commentId + " opType:" + this.xba.opType + " likeId:" + this.xba.xaG + " username:" + this.xba.username + " action:" + this.xbh.likeFlag);
      parambmq = new d.a();
      parambmq.c((a)this.xba);
      paramawr = new awv();
      paramawr.setBaseResponse(new jh());
      paramawr.getBaseResponse().Tef = new eaf();
      parambmq.d((a)paramawr);
      parambmq.TW("/cgi-bin/micromsg-bin/finderlike");
      parambmq.vD(3710);
      c(parambmq.bgN());
      Log.i(this.TAG, "likeId:" + this.xaG + " CgiFinderLikeComment init " + this.xba.xbk + ' ');
      AppMethodBeat.o(285516);
      return;
      i = 6;
      break;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLikeFriend$Companion;", "", "()V", "GlobalLikeFeedId", "", "getGlobalLikeFeedId", "()J", "setGlobalLikeFeedId", "(J)V", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.v
 * JD-Core Version:    0.7.0.1
 */