package com.tencent.mm.plugin.finder.cgi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.gy;
import com.tencent.mm.g.a.hd;
import com.tencent.mm.g.a.hd.a;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.u;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ahs;
import com.tencent.mm.protocal.protobuf.aht;
import com.tencent.mm.protocal.protobuf.ahx;
import com.tencent.mm.protocal.protobuf.ahy;
import com.tencent.mm.protocal.protobuf.ake;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import d.l;
import d.v;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneReplyFinderComment;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "unsentComment", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "localObj", "getLocalObj", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderCommentRequest;", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderCommentRequest;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class ag
  extends ap
  implements com.tencent.mm.network.k
{
  private static final String TAG = "Finder.NetSceneReplyFinderComment";
  public static final a qpP;
  private com.tencent.mm.al.g callback;
  private final ahx qpN;
  private final com.tencent.mm.plugin.finder.storage.k qpO;
  private com.tencent.mm.al.b rr;
  
  static
  {
    AppMethodBeat.i(165295);
    qpP = new a((byte)0);
    TAG = "Finder.NetSceneReplyFinderComment";
    AppMethodBeat.o(165295);
  }
  
  public ag(com.tencent.mm.plugin.finder.storage.k paramk, dzp paramdzp)
  {
    super(paramdzp);
    AppMethodBeat.i(197341);
    this.qpN = new ahx();
    this.qpO = paramk;
    paramk = new com.tencent.mm.al.b.a();
    paramk.c((com.tencent.mm.bx.a)this.qpN);
    Object localObject = new ahy();
    ((ahy)localObject).setBaseResponse(new BaseResponse());
    paramk.d((com.tencent.mm.bx.a)localObject);
    paramk.nC(30000);
    paramk.wg("/cgi-bin/micromsg-bin/findercomment");
    paramk.nB(getType());
    paramk = paramk.atI();
    d.g.b.k.g(paramk, "builder.buildInstance()");
    this.rr = paramk;
    this.qpN.username = u.aqO();
    paramk = this.qpN;
    localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
    if (com.tencent.mm.plugin.finder.storage.b.cpa()) {}
    for (long l = 0L;; l = this.qpO.field_feedId)
    {
      paramk.objectId = l;
      this.qpN.objectNonceId = this.qpO.getObjectNonceId();
      this.qpN.Dkv = this.qpO.cqx();
      this.qpN.content = this.qpO.getContent();
      this.qpN.replyCommentId = this.qpO.field_actionInfo.Dkk.replyCommentId;
      this.qpN.clientId = this.qpO.cqy();
      this.qpN.scene = this.qpO.field_scene;
      this.qpN.qoB = this.qpO.field_actionInfo.qoB;
      this.qpN.opType = 0;
      paramk = this.qpN;
      localObject = am.KJy;
      paramk.Dkw = am.a(paramdzp);
      paramk = this.qpN;
      paramdzp = com.tencent.mm.plugin.finder.report.b.qFq;
      paramk.sessionBuffer = com.tencent.mm.plugin.finder.report.b.am(this.qpO.field_feedId, this.qpN.Dkw.scene);
      ad.i(TAG, "CgiReplyFinderComment init, localId:" + this.qpO.field_localCommentId + ", clientId:" + this.qpO.cqy() + ", feedId:" + this.qpO.field_feedId + " commentScene:" + this.qpN.Dkw.scene);
      AppMethodBeat.o(197341);
      return;
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(165292);
    this.callback = paramg;
    int i = dispatch(parame, (q)this.rr, (com.tencent.mm.network.k)this);
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
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(1279L, 15L, 1L, false);
      paramq = this.rr.auM();
      if (paramq == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderCommentResponse");
        AppMethodBeat.o(165293);
        throw paramString;
      }
      paramq = (ahy)paramq;
      this.qpO.qB(ce.asQ() / 1000L);
      paramArrayOfByte = this.qpO;
      l1 = paramq.Dkx;
      paramArrayOfByte.field_actionInfo.Dkk.commentId = l1;
      paramArrayOfByte = paramq.Dkz;
      if (!bt.gL((List)paramArrayOfByte))
      {
        paramq = com.tencent.mm.plugin.finder.storage.data.b.qKl;
        paramq = com.tencent.mm.plugin.finder.storage.data.b.a.qC(this.qpO.field_feedId);
        if (paramq != null)
        {
          ad.i(TAG, "add CommentCount on " + paramq.getFeedObject().hashCode() + ", " + paramq.getId() + ", " + paramq.getCommentCount());
          paramq.getCommentList().clear();
          paramq.getCommentList().addAll((Collection)paramArrayOfByte);
          paramArrayOfByte = new hd();
          paramArrayOfByte.dkK.feedId = paramq.field_id;
          hd.a locala = paramArrayOfByte.dkK;
          ake localake = new ake();
          localake.commentList = paramq.getCommentList();
          locala.dkL = localake;
          com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)paramArrayOfByte);
          ad.i(TAG, "update expose commentList, add");
          paramArrayOfByte = com.tencent.mm.plugin.finder.storage.data.b.qKl;
          com.tencent.mm.plugin.finder.storage.data.b.a.e(paramq);
          paramArrayOfByte = new gy();
          paramArrayOfByte.dkz.id = paramq.field_id;
          paramArrayOfByte.dkz.type = 2;
          com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)paramArrayOfByte);
        }
      }
    }
    for (this.qpO.field_state = 2;; this.qpO.field_state = 1)
    {
      paramq = com.tencent.mm.plugin.finder.spam.a.qIC;
      com.tencent.mm.plugin.finder.spam.a.y(paramInt2, paramInt3, paramString);
      paramq = com.tencent.mm.plugin.finder.spam.a.qIC;
      com.tencent.mm.plugin.finder.spam.a.z(paramInt2, paramInt3, aj.getContext().getString(2131759164));
      paramq = com.tencent.mm.plugin.finder.spam.a.qIC;
      com.tencent.mm.plugin.finder.spam.a.A(paramInt2, paramInt3, aj.getContext().getString(2131759163));
      ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderActionStorage();
      l1 = this.qpO.field_feedId;
      long l2 = this.qpO.field_actionInfo.Dkk.commentId;
      long l3 = this.qpO.field_localCommentId;
      paramq = com.tencent.mm.plugin.finder.storage.a.qII;
      com.tencent.mm.plugin.finder.storage.a.a(l1, l2, l3, com.tencent.mm.plugin.finder.storage.a.coz(), this.qpO);
      if (this.callback != null)
      {
        paramq = this.callback;
        if (paramq == null) {
          d.g.b.k.fvU();
        }
        paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      }
      AppMethodBeat.o(165293);
      return;
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(1279L, 16L, 1L, false);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneReplyFinderComment$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ag
 * JD-Core Version:    0.7.0.1
 */