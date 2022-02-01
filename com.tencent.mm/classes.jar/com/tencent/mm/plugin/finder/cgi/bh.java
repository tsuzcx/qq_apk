package com.tencent.mm.plugin.finder.cgi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.he;
import com.tencent.mm.g.a.hk;
import com.tencent.mm.g.a.hk.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.u;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.ab;
import com.tencent.mm.plugin.finder.storage.data.d;
import com.tencent.mm.plugin.finder.storage.data.d.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.alh;
import com.tencent.mm.protocal.protobuf.alk;
import com.tencent.mm.protocal.protobuf.als;
import com.tencent.mm.protocal.protobuf.alt;
import com.tencent.mm.protocal.protobuf.aqa;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneReplyFinderComment;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "unsentComment", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "localObj", "getLocalObj", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderCommentRequest;", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderCommentRequest;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class bh
  extends ac
  implements k
{
  private static final String TAG = "Finder.NetSceneReplyFinderComment";
  public static final a rKm;
  private f callback;
  private final als rKk;
  private final ab rKl;
  private com.tencent.mm.al.b rr;
  
  static
  {
    AppMethodBeat.i(165295);
    rKm = new a((byte)0);
    TAG = "Finder.NetSceneReplyFinderComment";
    AppMethodBeat.o(165295);
  }
  
  public bh(ab paramab, aqy paramaqy)
  {
    super(paramaqy);
    AppMethodBeat.i(201173);
    this.rKk = new als();
    this.rKl = paramab;
    paramab = new b.a();
    paramab.c((com.tencent.mm.bx.a)this.rKk);
    Object localObject = new alt();
    ((alt)localObject).setBaseResponse(new BaseResponse());
    paramab.d((com.tencent.mm.bx.a)localObject);
    paramab.oQ(30000);
    paramab.Dl("/cgi-bin/micromsg-bin/findercomment");
    paramab.oP(getType());
    paramab = paramab.aDC();
    p.g(paramab, "builder.buildInstance()");
    this.rr = paramab;
    this.rKk.username = u.aAu();
    paramab = this.rKk;
    localObject = com.tencent.mm.plugin.finder.storage.b.sxa;
    if (com.tencent.mm.plugin.finder.storage.b.cFy()) {}
    for (long l = 0L;; l = this.rKl.field_feedId)
    {
      paramab.rIZ = l;
      this.rKk.objectNonceId = this.rKl.getObjectNonceId();
      this.rKk.Glu = this.rKl.cIM();
      this.rKk.content = this.rKl.getContent();
      this.rKk.replyCommentId = this.rKl.field_actionInfo.Gla.replyCommentId;
      this.rKk.clientId = this.rKl.cIN();
      this.rKk.scene = this.rKl.field_scene;
      this.rKk.rID = this.rKl.field_actionInfo.rID;
      this.rKk.opType = 0;
      paramab = this.rKk;
      localObject = v.rIR;
      paramab.Glv = v.a(paramaqy);
      paramab = this.rKk;
      paramaqy = h.soM;
      paramab.sessionBuffer = h.I(this.rKl.field_feedId, this.rKk.Glv.scene);
      this.rKk.rTD = this.rKl.field_actionInfo.Oer;
      ad.i(TAG, "CgiReplyFinderComment init, localId:" + this.rKl.field_localCommentId + ", clientId:" + this.rKl.cIN() + ", feedId:" + this.rKl.field_feedId + " commentScene:" + this.rKk.Glv.scene);
      AppMethodBeat.o(201173);
      return;
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
    ad.i(TAG, "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    long l1;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(1279L, 15L, 1L, false);
      paramq = this.rr.aEF();
      if (paramq == null)
      {
        paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderCommentResponse");
        AppMethodBeat.o(165293);
        throw paramString;
      }
      paramq = (alt)paramq;
      this.rKl.wS(cf.aCK() / 1000L);
      paramArrayOfByte = this.rKl;
      l1 = paramq.Glw;
      paramArrayOfByte.field_actionInfo.Gla.commentId = l1;
      paramArrayOfByte = paramq.Gly;
      if (!bt.hj((List)paramArrayOfByte))
      {
        paramq = d.szI;
        paramq = d.a.wT(this.rKl.field_feedId);
        if (paramq != null)
        {
          ad.i(TAG, "add CommentCount on " + paramq.getFeedObject().hashCode() + ", " + paramq.getId() + ", " + paramq.getCommentCount());
          paramq.getCommentList().clear();
          paramq.getCommentList().addAll((Collection)paramArrayOfByte);
          paramArrayOfByte = new hk();
          paramArrayOfByte.dtQ.dtq = paramq.field_id;
          hk.a locala = paramArrayOfByte.dtQ;
          aqa localaqa = new aqa();
          localaqa.commentList = paramq.getCommentList();
          locala.dtR = localaqa;
          com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)paramArrayOfByte);
          ad.i(TAG, "update expose commentList, add");
          paramArrayOfByte = d.szI;
          d.a.f(paramq);
          paramArrayOfByte = new he();
          paramArrayOfByte.dtz.id = paramq.field_id;
          paramArrayOfByte.dtz.type = 2;
          com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)paramArrayOfByte);
        }
      }
    }
    for (this.rKl.field_state = 2;; this.rKl.field_state = 1)
    {
      paramq = com.tencent.mm.plugin.finder.spam.a.suA;
      com.tencent.mm.plugin.finder.spam.a.y(paramInt2, paramInt3, paramString);
      paramq = com.tencent.mm.plugin.finder.spam.a.suA;
      com.tencent.mm.plugin.finder.spam.a.z(paramInt2, paramInt3, aj.getContext().getString(2131759164));
      paramq = com.tencent.mm.plugin.finder.spam.a.suA;
      com.tencent.mm.plugin.finder.spam.a.A(paramInt2, paramInt3, aj.getContext().getString(2131759163));
      ((PluginFinder)g.ad(PluginFinder.class)).getFinderActionStorage();
      l1 = this.rKl.field_feedId;
      long l2 = this.rKl.field_actionInfo.Gla.commentId;
      long l3 = this.rKl.field_localCommentId;
      paramq = com.tencent.mm.plugin.finder.storage.a.suG;
      com.tencent.mm.plugin.finder.storage.a.a(l1, l2, l3, com.tencent.mm.plugin.finder.storage.a.cEV(), this.rKl);
      if (this.callback != null)
      {
        paramq = this.callback;
        if (paramq == null) {
          p.gfZ();
        }
        paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      }
      AppMethodBeat.o(165293);
      return;
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(1279L, 16L, 1L, false);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneReplyFinderComment$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bh
 * JD-Core Version:    0.7.0.1
 */