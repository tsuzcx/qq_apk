package com.tencent.mm.plugin.finder.cgi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.g.a.hv;
import com.tencent.mm.g.a.hv.a;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.an;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aoh;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.apj;
import com.tencent.mm.protocal.protobuf.apk;
import com.tencent.mm.protocal.protobuf.azt;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneReplyFinderComment;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "unsentComment", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "localObj", "getLocalObj", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderCommentRequest;", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderCommentRequest;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class cw
  extends ax
  implements m
{
  private static final String TAG = "Finder.NetSceneReplyFinderComment";
  public static final a twO;
  private i callback;
  private d rr;
  private final apj twM;
  private final an twN;
  
  static
  {
    AppMethodBeat.i(165295);
    twO = new a((byte)0);
    TAG = "Finder.NetSceneReplyFinderComment";
    AppMethodBeat.o(165295);
  }
  
  public cw(an paraman, bbn parambbn)
  {
    super(parambbn);
    AppMethodBeat.i(242568);
    this.twM = new apj();
    this.twN = paraman;
    paraman = new d.a();
    paraman.c((com.tencent.mm.bw.a)this.twM);
    Object localObject = new apk();
    ((apk)localObject).setBaseResponse(new BaseResponse());
    paraman.d((com.tencent.mm.bw.a)localObject);
    paraman.sH(30000);
    paraman.MB("/cgi-bin/micromsg-bin/findercomment");
    paraman.sG(getType());
    paraman = paraman.aXF();
    p.g(paraman, "builder.buildInstance()");
    this.rr = paraman;
    this.twM.username = z.aUg();
    paraman = this.twM;
    localObject = c.vCb;
    long l;
    int i;
    if (c.drg())
    {
      l = 0L;
      paraman.hFK = l;
      this.twM.objectNonceId = this.twN.getObjectNonceId();
      this.twM.LBr = this.twN.dyf();
      this.twM.content = this.twN.getContent();
      this.twM.replyCommentId = this.twN.dyb().replyCommentId;
      this.twM.clientId = this.twN.dyg();
      this.twM.scene = this.twN.field_scene;
      this.twM.tuf = this.twN.field_actionInfo.tuf;
      this.twM.opType = 0;
      paraman = this.twM;
      localObject = am.tuw;
      paraman.uli = am.a(parambbn);
      paraman = this.twM;
      parambbn = k.vfA;
      l = this.twN.field_feedId;
      parambbn = this.twM.uli;
      if (parambbn == null) {
        break label461;
      }
      i = parambbn.scene;
      label319:
      paraman.sessionBuffer = k.G(l, i);
      this.twM.tCE = this.twN.field_actionInfo.LAo;
      parambbn = TAG;
      localObject = new StringBuilder("CgiReplyFinderComment init, localId:").append(this.twN.field_localCommentId).append(", clientId:").append(this.twN.dyg()).append(", feedId:").append(this.twN.field_feedId).append(" commentScene:");
      paraman = this.twM.uli;
      if (paraman == null) {
        break label466;
      }
    }
    label461:
    label466:
    for (paraman = Integer.valueOf(paraman.scene);; paraman = null)
    {
      Log.i(parambbn, paraman);
      AppMethodBeat.o(242568);
      return;
      l = this.twN.field_feedId;
      break;
      i = 0;
      break label319;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(242567);
    Log.i(TAG, "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    long l1;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1279L, 15L, 1L, false);
      params = this.rr.aYK();
      if (params == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderCommentResponse");
        AppMethodBeat.o(242567);
        throw paramString;
      }
      params = (apk)params;
      this.twN.FC(cl.aWy() / 1000L);
      Object localObject = this.twN;
      l1 = params.LBs;
      ((an)localObject).dyb().commentId = l1;
      localObject = params.LBt;
      if (!Util.isNullOrNil((List)localObject))
      {
        params = com.tencent.mm.plugin.finder.storage.data.e.vFX;
        params = e.a.Fy(this.twN.field_feedId);
        if (params != null)
        {
          Log.i(TAG, "add CommentCount on " + params.getFeedObject().hashCode() + ", " + params.getId() + ", " + params.getCommentCount());
          params.getCommentList().clear();
          params.getCommentList().addAll((Collection)localObject);
          localObject = new hv();
          ((hv)localObject).dMr.feedId = params.field_id;
          hv.a locala = ((hv)localObject).dMr;
          azt localazt = new azt();
          localazt.commentList = params.getCommentList();
          locala.dMs = localazt;
          EventCenter.instance.publish((IEvent)localObject);
          Log.i(TAG, "update expose commentList, add");
          localObject = com.tencent.mm.plugin.finder.storage.data.e.vFX;
          e.a.n(params);
          localObject = new hn();
          ((hn)localObject).dLW.id = params.field_id;
          ((hn)localObject).dLW.type = 2;
          EventCenter.instance.publish((IEvent)localObject);
        }
      }
    }
    for (this.twN.field_state = 2;; this.twN.field_state = 1)
    {
      params = com.tencent.mm.plugin.finder.spam.a.vwk;
      com.tencent.mm.plugin.finder.spam.a.v(paramInt2, paramInt3, paramString);
      params = com.tencent.mm.plugin.finder.spam.a.vwk;
      com.tencent.mm.plugin.finder.spam.a.w(paramInt2, paramInt3, MMApplicationContext.getContext().getString(2131759597));
      params = com.tencent.mm.plugin.finder.spam.a.vwk;
      com.tencent.mm.plugin.finder.spam.a.x(paramInt2, paramInt3, MMApplicationContext.getContext().getString(2131759596));
      ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFinderActionStorage();
      l1 = this.twN.field_feedId;
      long l2 = this.twN.dyb().commentId;
      long l3 = this.twN.field_localCommentId;
      params = com.tencent.mm.plugin.finder.storage.a.vwq;
      com.tencent.mm.plugin.finder.storage.a.a(l1, l2, l3, com.tencent.mm.plugin.finder.storage.a.dqj(), this.twN);
      if (this.callback != null)
      {
        params = this.callback;
        if (params == null) {
          p.hyc();
        }
        params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      }
      AppMethodBeat.o(242567);
      return;
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1279L, 16L, 1L, false);
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneReplyFinderComment$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.cw
 * JD-Core Version:    0.7.0.1
 */