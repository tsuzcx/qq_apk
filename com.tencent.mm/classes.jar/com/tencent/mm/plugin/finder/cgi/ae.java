package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.bco;
import com.tencent.mm.protocal.protobuf.bcr;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.cak;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLikeFriend;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeResponse;", "action", "Lcom/tencent/mm/protocal/protobuf/FriendLikeFinderObject;", "likeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FriendLikeFinderObject;Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getAction", "()Lcom/tencent/mm/protocal/protobuf/FriendLikeFinderObject;", "likeId", "", "getLikeInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLikeRequest;", "initCommReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ae
  extends c<bcs>
{
  private static long AyQ;
  public static final a AzI;
  private long AyP;
  private bcr AzE;
  private final cak AzJ;
  private final bco AzK;
  private final String TAG;
  
  static
  {
    AppMethodBeat.i(336262);
    AzI = new a((byte)0);
    AppMethodBeat.o(336262);
  }
  
  public ae(cak paramcak, bco parambco, bui parambui)
  {
    super(parambui);
    AppMethodBeat.i(336257);
    this.AzJ = paramcak;
    this.AzK = parambco;
    this.TAG = "Finder.CgiFinderLikeFriend";
    this.AyP = cn.bDv();
    long l;
    if (this.AyP < AyQ)
    {
      l = AyQ;
      AyQ = 1L + l;
      this.AyP = l;
    }
    AyQ = this.AyP;
    this.AzE = new bcr();
    this.AzE.hKN = this.AzJ.feedId;
    this.AzE.objectNonceId = this.AzJ.objectNonceId;
    this.AzE.AyP = this.AyP;
    this.AzE.commentId = this.AzK.AyP;
    this.AzE.username = com.tencent.mm.model.z.bAW();
    this.AzE.scene = this.AzJ.scene;
    this.AzE.ZNF = this.AzK.hLv;
    paramcak = this.AzE;
    if (this.AzK.likeFlag == 1)
    {
      i = 5;
      paramcak.opType = i;
      paramcak = this.AzE;
      parambco = bi.ABn;
      paramcak.CJv = bi.a(parambui);
      paramcak = this.AzE;
      parambco = com.tencent.mm.plugin.finder.report.z.FrZ;
      l = this.AzJ.feedId;
      if (parambui != null) {
        break label520;
      }
    }
    label520:
    for (int i = 0;; i = parambui.AJo)
    {
      paramcak.sessionBuffer = com.tencent.mm.plugin.finder.report.z.p(l, i);
      Log.i(this.TAG, "likeId:" + this.AyP + " objectId:" + this.AzE.hKN + " commentId：" + this.AzE.commentId + " opType:" + this.AzE.opType + " likeId:" + this.AzE.AyP + " username:" + this.AzE.username + " action:" + this.AzK.likeFlag);
      paramcak = new c.a();
      paramcak.otE = ((a)this.AzE);
      parambco = new bcs();
      parambco.setBaseResponse(new kd());
      parambco.getBaseResponse().akjO = new etl();
      paramcak.otF = ((a)parambco);
      paramcak.uri = "/cgi-bin/micromsg-bin/finderlike";
      paramcak.funcId = 3710;
      c(paramcak.bEF());
      Log.i(this.TAG, "likeId:" + this.AyP + " CgiFinderLikeComment init " + this.AzE.hKN + ' ');
      AppMethodBeat.o(336257);
      return;
      i = 6;
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLikeFriend$Companion;", "", "()V", "GlobalLikeFeedId", "", "getGlobalLikeFeedId", "()J", "setGlobalLikeFeedId", "(J)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ae
 * JD-Core Version:    0.7.0.1
 */