package com.tencent.mm.plugin.finder.cgi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.hf;
import com.tencent.mm.g.a.hl;
import com.tencent.mm.g.a.hl.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ch;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.ab;
import com.tencent.mm.plugin.finder.storage.data.d;
import com.tencent.mm.plugin.finder.storage.data.d.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.alr;
import com.tencent.mm.protocal.protobuf.alw;
import com.tencent.mm.protocal.protobuf.ame;
import com.tencent.mm.protocal.protobuf.amf;
import com.tencent.mm.protocal.protobuf.aqn;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneReplyFinderComment;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "unsentComment", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "localObj", "getLocalObj", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderCommentRequest;", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderCommentRequest;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class bi
  extends ad
  implements k
{
  private static final String TAG = "Finder.NetSceneReplyFinderComment";
  public static final a rSy;
  private f callback;
  private final ame rSw;
  private final ab rSx;
  private com.tencent.mm.ak.b rr;
  
  static
  {
    AppMethodBeat.i(165295);
    rSy = new a((byte)0);
    TAG = "Finder.NetSceneReplyFinderComment";
    AppMethodBeat.o(165295);
  }
  
  public bi(ab paramab, arn paramarn)
  {
    super(paramarn);
    AppMethodBeat.i(201595);
    this.rSw = new ame();
    this.rSx = paramab;
    paramab = new b.a();
    paramab.c((com.tencent.mm.bw.a)this.rSw);
    Object localObject = new amf();
    ((amf)localObject).setBaseResponse(new BaseResponse());
    paramab.d((com.tencent.mm.bw.a)localObject);
    paramab.oT(30000);
    paramab.DN("/cgi-bin/micromsg-bin/findercomment");
    paramab.oS(getType());
    paramab = paramab.aDS();
    p.g(paramab, "builder.buildInstance()");
    this.rr = paramab;
    this.rSw.username = com.tencent.mm.model.v.aAK();
    paramab = this.rSw;
    localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
    long l;
    int i;
    if (com.tencent.mm.plugin.finder.storage.b.cHv())
    {
      l = 0L;
      paramab.rRn = l;
      this.rSw.objectNonceId = this.rSx.getObjectNonceId();
      this.rSw.GEx = this.rSx.cLp();
      this.rSw.content = this.rSx.getContent();
      this.rSw.replyCommentId = this.rSx.cLl().replyCommentId;
      this.rSw.clientId = this.rSx.cLq();
      this.rSw.scene = this.rSx.field_scene;
      this.rSw.rQN = this.rSx.field_actionInfo.rQN;
      this.rSw.opType = 0;
      paramab = this.rSw;
      localObject = v.rRb;
      paramab.GDR = v.a(paramarn);
      paramab = this.rSw;
      paramarn = i.syT;
      l = this.rSx.field_feedId;
      paramarn = this.rSw.GDR;
      if (paramarn == null) {
        break label461;
      }
      i = paramarn.scene;
      label319:
      paramab.sessionBuffer = i.I(l, i);
      this.rSw.sch = this.rSx.field_actionInfo.GDO;
      paramarn = TAG;
      localObject = new StringBuilder("CgiReplyFinderComment init, localId:").append(this.rSx.field_localCommentId).append(", clientId:").append(this.rSx.cLq()).append(", feedId:").append(this.rSx.field_feedId).append(" commentScene:");
      paramab = this.rSw.GDR;
      if (paramab == null) {
        break label466;
      }
    }
    label461:
    label466:
    for (paramab = Integer.valueOf(paramab.scene);; paramab = null)
    {
      ae.i(paramarn, paramab);
      AppMethodBeat.o(201595);
      return;
      l = this.rSx.field_feedId;
      break;
      i = 0;
      break label319;
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(165292);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(165292);
    return i;
  }
  
  public final int getType()
  {
    return 3906;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(165293);
    ae.i(TAG, "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    long l1;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(1279L, 15L, 1L, false);
      paramq = this.rr.aEV();
      if (paramq == null)
      {
        paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderCommentResponse");
        AppMethodBeat.o(165293);
        throw paramString;
      }
      paramq = (amf)paramq;
      this.rSx.xj(ch.aDa() / 1000L);
      paramArrayOfByte = this.rSx;
      l1 = paramq.GEy;
      paramArrayOfByte.cLl().commentId = l1;
      paramArrayOfByte = paramq.GEA;
      if (!bu.ht((List)paramArrayOfByte))
      {
        paramq = d.sKD;
        paramq = d.a.xk(this.rSx.field_feedId);
        if (paramq != null)
        {
          ae.i(TAG, "add CommentCount on " + paramq.getFeedObject().hashCode() + ", " + paramq.getId() + ", " + paramq.getCommentCount());
          paramq.getCommentList().clear();
          paramq.getCommentList().addAll((Collection)paramArrayOfByte);
          paramArrayOfByte = new hl();
          paramArrayOfByte.duV.duw = paramq.field_id;
          hl.a locala = paramArrayOfByte.duV;
          aqn localaqn = new aqn();
          localaqn.commentList = paramq.getCommentList();
          locala.duW = localaqn;
          com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)paramArrayOfByte);
          ae.i(TAG, "update expose commentList, add");
          paramArrayOfByte = d.sKD;
          d.a.f(paramq);
          paramArrayOfByte = new hf();
          paramArrayOfByte.duE.id = paramq.field_id;
          paramArrayOfByte.duE.type = 2;
          com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)paramArrayOfByte);
        }
      }
    }
    for (this.rSx.field_state = 2;; this.rSx.field_state = 1)
    {
      paramq = com.tencent.mm.plugin.finder.spam.a.sEK;
      com.tencent.mm.plugin.finder.spam.a.y(paramInt2, paramInt3, paramString);
      paramq = com.tencent.mm.plugin.finder.spam.a.sEK;
      com.tencent.mm.plugin.finder.spam.a.z(paramInt2, paramInt3, ak.getContext().getString(2131759164));
      paramq = com.tencent.mm.plugin.finder.spam.a.sEK;
      com.tencent.mm.plugin.finder.spam.a.A(paramInt2, paramInt3, ak.getContext().getString(2131759163));
      ((PluginFinder)g.ad(PluginFinder.class)).getFinderActionStorage();
      l1 = this.rSx.field_feedId;
      long l2 = this.rSx.cLl().commentId;
      long l3 = this.rSx.field_localCommentId;
      paramq = com.tencent.mm.plugin.finder.storage.a.sEQ;
      com.tencent.mm.plugin.finder.storage.a.a(l1, l2, l3, com.tencent.mm.plugin.finder.storage.a.cGR(), this.rSx);
      if (this.callback != null)
      {
        paramq = this.callback;
        if (paramq == null) {
          p.gkB();
        }
        paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      }
      AppMethodBeat.o(165293);
      return;
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(1279L, 16L, 1L, false);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneReplyFinderComment$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bi
 * JD-Core Version:    0.7.0.1
 */