package com.tencent.mm.plugin.finder.cgi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.b;
import com.tencent.mm.f.a.hu;
import com.tencent.mm.f.a.ig;
import com.tencent.mm.f.a.ig.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.am;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.apk;
import com.tencent.mm.protocal.protobuf.aqe;
import com.tencent.mm.protocal.protobuf.aqx;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.bfw;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.fgr;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneReplyFinderComment;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "unsentComment", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "localObj", "getLocalObj", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderCommentRequest;", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderCommentRequest;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class db
  extends com.tencent.mm.plugin.findersdk.b.g
{
  private static final String TAG = "Finder.NetSceneReplyFinderComment";
  public static final a xeB;
  private i callback;
  private com.tencent.mm.an.d rr;
  private final am xeA;
  private final aqx xez;
  
  static
  {
    AppMethodBeat.i(165295);
    xeB = new a((byte)0);
    TAG = "Finder.NetSceneReplyFinderComment";
    AppMethodBeat.o(165295);
  }
  
  public db(am paramam, bid parambid)
  {
    super(parambid);
    AppMethodBeat.i(274453);
    this.xez = new aqx();
    this.xeA = paramam;
    paramam = new d.a();
    paramam.c((com.tencent.mm.cd.a)this.xez);
    Object localObject = new aqy();
    ((aqy)localObject).setBaseResponse(new jh());
    paramam.d((com.tencent.mm.cd.a)localObject);
    paramam.vE(30000);
    paramam.TW("/cgi-bin/micromsg-bin/findercomment");
    paramam.vD(getType());
    paramam = paramam.bgN();
    p.j(paramam, "builder.buildInstance()");
    this.rr = paramam;
    this.xez.username = z.bdh();
    paramam = this.xez;
    localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
    long l;
    int i;
    if (com.tencent.mm.plugin.finder.storage.d.dSu())
    {
      l = 0L;
      paramam.xbk = l;
      this.xez.objectNonceId = this.xeA.getObjectNonceId();
      this.xez.SEa = this.xeA.dZc();
      this.xez.content = this.xeA.getContent();
      this.xez.replyCommentId = this.xeA.dYY().replyCommentId;
      this.xez.clientId = this.xeA.dZd();
      this.xez.scene = this.xeA.field_scene;
      this.xez.xbP = this.xeA.field_actionInfo.xbP;
      this.xez.opType = 0;
      paramam = this.xez;
      localObject = ao.xcj;
      paramam.yjp = ao.a(parambid);
      paramam = this.xez;
      parambid = n.zWF;
      l = this.xeA.field_feedId;
      parambid = this.xez.yjp;
      if (parambid == null) {
        break label599;
      }
      i = parambid.scene;
      label322:
      paramam.sessionBuffer = n.N(l, i);
      this.xez.xkX = this.xeA.field_actionInfo.SCP;
      paramam = ao.xcj;
      paramam = this.xez.yjp;
      parambid = this.xez.yjp;
      i = j;
      if (parambid != null) {
        i = parambid.scene;
      }
      ao.a(paramam, j.listOf(new o(Integer.valueOf(i), Long.valueOf(this.xez.xbk))));
      if (this.xez.opType == 0)
      {
        paramam = new fgr();
        paramam.UGO = new eae().dc(com.tencent.mm.plugin.normsg.a.d.GxJ.fjn());
        parambid = this.xez.yjp;
        if (parambid != null) {
          parambid.SDs = new b(paramam.toByteArray());
        }
        paramam = com.tencent.mm.plugin.secinforeport.a.d.Jcm;
        com.tencent.mm.plugin.secinforeport.a.d.asyncReportFinderSecurityInfoThroughCgi(540999689);
      }
      parambid = TAG;
      localObject = new StringBuilder("CgiReplyFinderComment init, localId:").append(this.xeA.field_localCommentId).append(", clientId:").append(this.xeA.dZd()).append(", feedId:").append(this.xeA.field_feedId).append(" commentScene:");
      paramam = this.xez.yjp;
      if (paramam == null) {
        break label604;
      }
    }
    label599:
    label604:
    for (paramam = Integer.valueOf(paramam.scene);; paramam = null)
    {
      Log.i(parambid, paramam);
      AppMethodBeat.o(274453);
      return;
      l = this.xeA.field_feedId;
      break;
      i = 0;
      break label322;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(274452);
    Log.i(TAG, "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    long l1;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      f.Iyx.idkeyStat(1279L, 15L, 1L, false);
      params = this.rr.bhY();
      if (params == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderCommentResponse");
        AppMethodBeat.o(274452);
        throw paramString;
      }
      params = (aqy)params;
      this.xeA.ML(cm.bfC() / 1000L);
      Object localObject = this.xeA;
      l1 = params.SEb;
      ((am)localObject).dYY().commentId = l1;
      localObject = params.SEc;
      if (!Util.isNullOrNil((List)localObject))
      {
        params = e.AmW;
        params = e.a.MH(this.xeA.field_feedId);
        if (params != null)
        {
          Log.i(TAG, "add CommentCount on " + params.getFeedObject().hashCode() + ", " + params.getId() + ", " + params.getCommentCount());
          params.getCommentList().clear();
          params.getCommentList().addAll((Collection)localObject);
          localObject = new ig();
          ((ig)localObject).fFp.feedId = params.field_id;
          ig.a locala = ((ig)localObject).fFp;
          bfw localbfw = new bfw();
          localbfw.commentList = params.getCommentList();
          locala.fFq = localbfw;
          EventCenter.instance.publish((IEvent)localObject);
          Log.i(TAG, "update expose commentList, add");
          localObject = e.AmW;
          e.a.o(params);
          localObject = new hu();
          ((hu)localObject).fEL.id = params.field_id;
          ((hu)localObject).fEL.type = 2;
          EventCenter.instance.publish((IEvent)localObject);
        }
      }
    }
    for (this.xeA.field_state = 2;; this.xeA.field_state = 1)
    {
      params = com.tencent.mm.plugin.findersdk.c.a.Bwg;
      com.tencent.mm.plugin.findersdk.c.a.x(paramInt2, paramInt3, paramString);
      params = com.tencent.mm.plugin.findersdk.c.a.Bwg;
      com.tencent.mm.plugin.findersdk.c.a.y(paramInt2, paramInt3, MMApplicationContext.getContext().getString(b.j.finder_comment_failed_of_blacklist));
      params = com.tencent.mm.plugin.findersdk.c.a.Bwg;
      com.tencent.mm.plugin.findersdk.c.a.z(paramInt2, paramInt3, MMApplicationContext.getContext().getString(b.j.finder_comment_failed_not_realname));
      ((PluginFinder)h.ag(PluginFinder.class)).getFinderActionStorage();
      l1 = this.xeA.field_feedId;
      long l2 = this.xeA.dYY().commentId;
      long l3 = this.xeA.field_localCommentId;
      params = com.tencent.mm.plugin.finder.storage.a.AdP;
      com.tencent.mm.plugin.finder.storage.a.a(l1, l2, l3, com.tencent.mm.plugin.finder.storage.a.dRu(), this.xeA);
      if (this.callback != null)
      {
        params = this.callback;
        if (params == null) {
          p.iCn();
        }
        params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      }
      AppMethodBeat.o(274452);
      return;
      f.Iyx.idkeyStat(1279L, 16L, 1L, false);
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(165292);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(165292);
    return i;
  }
  
  public final int getType()
  {
    return 3906;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneReplyFinderComment$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.db
 * JD-Core Version:    0.7.0.1
 */