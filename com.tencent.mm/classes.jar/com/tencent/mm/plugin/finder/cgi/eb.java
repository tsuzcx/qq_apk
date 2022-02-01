package com.tencent.mm.plugin.finder.cgi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.autogen.a.if;
import com.tencent.mm.autogen.a.it;
import com.tencent.mm.autogen.a.it.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.model.cn;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.au;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.atd;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.avd;
import com.tencent.mm.protocal.protobuf.ave;
import com.tencent.mm.protocal.protobuf.brh;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.gdd;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneReplyFinderComment;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "unsentComment", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "localObj", "getLocalObj", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderCommentRequest;", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderCommentRequest;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class eb
  extends com.tencent.mm.plugin.findersdk.b.h
{
  public static final a ADK;
  private static final String TAG;
  private final avd ADL;
  private final au ADM;
  private com.tencent.mm.am.h callback;
  private c rr;
  
  static
  {
    AppMethodBeat.i(165295);
    ADK = new a((byte)0);
    TAG = "Finder.NetSceneReplyFinderComment";
    AppMethodBeat.o(165295);
  }
  
  public eb(au paramau, bui parambui)
  {
    super(parambui);
    AppMethodBeat.i(336772);
    this.ADL = new avd();
    this.ADM = paramau;
    paramau = new c.a();
    paramau.otE = ((com.tencent.mm.bx.a)this.ADL);
    Object localObject = new ave();
    ((ave)localObject).setBaseResponse(new kd());
    paramau.otF = ((com.tencent.mm.bx.a)localObject);
    paramau.timeout = 30000;
    paramau.uri = "/cgi-bin/micromsg-bin/findercomment";
    paramau.funcId = getType();
    paramau = paramau.bEF();
    kotlin.g.b.s.s(paramau, "builder.buildInstance()");
    this.rr = paramau;
    this.ADL.username = com.tencent.mm.model.z.bAW();
    paramau = this.ADL;
    localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
    long l;
    int i;
    if (com.tencent.mm.plugin.finder.storage.d.eQI())
    {
      l = 0L;
      paramau.hKN = l;
      this.ADL.objectNonceId = this.ADM.getObjectNonceId();
      this.ADL.ZFu = this.ADM.eZL();
      this.ADL.content = this.ADM.getContent();
      this.ADL.replyCommentId = this.ADM.eZI().replyCommentId;
      this.ADL.clientId = this.ADM.eZM();
      this.ADL.scene = this.ADM.field_scene;
      this.ADL.ABa = this.ADM.field_actionInfo.ABa;
      this.ADL.opType = 0;
      paramau = this.ADL;
      localObject = bi.ABn;
      paramau.CJv = bi.a(parambui);
      paramau = this.ADL;
      localObject = com.tencent.mm.plugin.finder.report.z.FrZ;
      l = this.ADM.field_feedId;
      localObject = this.ADL.CJv;
      if (localObject != null) {
        break label641;
      }
      i = 0;
      label322:
      paramau.sessionBuffer = com.tencent.mm.plugin.finder.report.z.p(l, i);
      this.ADL.AJo = this.ADM.field_actionInfo.ZDH;
      this.ADL.ZDI = this.ADM.field_actionInfo.ZDI;
      this.ADL.ZFv = this.ADM.FME;
      Log.i(TAG, kotlin.g.b.s.X("commentPastedList = ", this.ADL.ZFv));
      paramau = bi.ABn;
      paramau = this.ADL.CJv;
      localObject = this.ADL.CJv;
      if (localObject != null) {
        break label650;
      }
      i = j;
      label428:
      bi.a(paramau, kotlin.a.p.listOf(new r(Integer.valueOf(i), Long.valueOf(this.ADL.hKN))), parambui);
      if (this.ADL.opType == 0)
      {
        paramau = new gdd();
        paramau.acaX = new gol().df(com.tencent.mm.plugin.normsg.a.d.MtP.gtE());
        parambui = this.ADL.CJv;
        if (parambui != null) {
          parambui.ZEq = new b(paramau.toByteArray());
        }
        paramau = com.tencent.mm.plugin.secinforeport.a.d.Pmb;
        com.tencent.mm.plugin.secinforeport.a.d.asyncReportFinderSecurityInfoThroughCgi(540999689);
      }
      parambui = TAG;
      localObject = new StringBuilder("CgiReplyFinderComment init, localId:").append(this.ADM.field_localCommentId).append(", clientId:").append(this.ADM.eZM()).append(", feedId:").append(this.ADM.field_feedId).append(" commentScene:");
      paramau = this.ADL.CJv;
      if (paramau != null) {
        break label659;
      }
    }
    label641:
    label650:
    label659:
    for (paramau = null;; paramau = Integer.valueOf(paramau.scene))
    {
      Log.i(parambui, paramau);
      AppMethodBeat.o(336772);
      return;
      l = this.ADM.field_feedId;
      break;
      i = ((atz)localObject).scene;
      break label322;
      i = ((atz)localObject).scene;
      break label428;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(336803);
    Log.i(TAG, "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    long l1;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      f.Ozc.idkeyStat(1279L, 15L, 1L, false);
      params = c.c.b(this.rr.otC);
      if (params == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderCommentResponse");
        AppMethodBeat.o(336803);
        throw paramString;
      }
      params = (ave)params;
      this.ADM.qg(cn.bDu() / 1000L);
      Object localObject = this.ADM;
      l1 = params.ZFw;
      ((au)localObject).eZI().commentId = l1;
      localObject = this.ADM.FME;
      if (localObject != null) {
        ((LinkedList)localObject).clear();
      }
      localObject = params.ZFx;
      if (!Util.isNullOrNil((List)localObject))
      {
        params = e.FMN;
        params = e.a.jn(this.ADM.field_feedId);
        if (params != null)
        {
          Log.i(TAG, "add CommentCount on " + params.getFeedObject().hashCode() + ", " + params.getId() + ", " + params.getCommentCount());
          params.getCommentList().clear();
          params.getCommentList().addAll((Collection)localObject);
          localObject = new it();
          ((it)localObject).hKk.feedId = params.field_id;
          it.a locala = ((it)localObject).hKk;
          brh localbrh = new brh();
          localbrh.commentList = params.getCommentList();
          ah localah = ah.aiuX;
          locala.hKl = localbrh;
          ((it)localObject).publish();
          Log.i(TAG, "update expose commentList, add");
          localObject = e.FMN;
          e.a.s(params);
          localObject = new if();
          ((if)localObject).hJB.id = params.field_id;
          ((if)localObject).hJB.type = 2;
          ((if)localObject).publish();
        }
      }
    }
    for (this.ADM.field_state = 2;; this.ADM.field_state = 1)
    {
      params = com.tencent.mm.plugin.findersdk.d.a.Hdr;
      com.tencent.mm.plugin.findersdk.d.a.B(paramInt2, paramInt3, paramString);
      params = com.tencent.mm.plugin.findersdk.d.a.Hdr;
      com.tencent.mm.plugin.findersdk.d.a.C(paramInt2, paramInt3, MMApplicationContext.getContext().getString(e.h.finder_comment_failed_of_blacklist));
      params = com.tencent.mm.plugin.findersdk.d.a.Hdr;
      com.tencent.mm.plugin.findersdk.d.a.D(paramInt2, paramInt3, MMApplicationContext.getContext().getString(e.h.finder_comment_failed_not_realname));
      ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getFinderActionStorage();
      l1 = this.ADM.field_feedId;
      long l2 = this.ADM.eZI().commentId;
      long l3 = this.ADM.field_localCommentId;
      params = com.tencent.mm.plugin.finder.storage.a.FAm;
      com.tencent.mm.plugin.finder.storage.a.a(l1, l2, l3, com.tencent.mm.plugin.finder.storage.a.ePH(), this.ADM);
      if (this.callback != null)
      {
        params = this.callback;
        kotlin.g.b.s.checkNotNull(params);
        params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.am.p)this);
      }
      AppMethodBeat.o(336803);
      return;
      f.Ozc.idkeyStat(1279L, 16L, 1L, false);
    }
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(165292);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(165292);
    return i;
  }
  
  public final int getType()
  {
    return 3906;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneReplyFinderComment$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.eb
 * JD-Core Version:    0.7.0.1
 */