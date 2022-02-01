package com.tencent.mm.plugin.finder.cgi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.ha;
import com.tencent.mm.g.a.hf;
import com.tencent.mm.g.a.hf.a;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.d.a;
import com.tencent.mm.plugin.finder.storage.t;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.air;
import com.tencent.mm.protocal.protobuf.aiu;
import com.tencent.mm.protocal.protobuf.ajc;
import com.tencent.mm.protocal.protobuf.ajd;
import com.tencent.mm.protocal.protobuf.amp;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import d.l;
import d.v;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneReplyFinderComment;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "unsentComment", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "localObj", "getLocalObj", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderCommentRequest;", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderCommentRequest;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class az
  extends w
  implements com.tencent.mm.network.k
{
  private static final String TAG = "Finder.NetSceneReplyFinderComment";
  public static final az.a qYV;
  private com.tencent.mm.ak.g callback;
  private final ajc qYT;
  private final t qYU;
  private com.tencent.mm.ak.b rr;
  
  static
  {
    AppMethodBeat.i(165295);
    qYV = new az.a((byte)0);
    TAG = "Finder.NetSceneReplyFinderComment";
    AppMethodBeat.o(165295);
  }
  
  public az(t paramt, anm paramanm)
  {
    super(paramanm);
    AppMethodBeat.i(201219);
    this.qYT = new ajc();
    this.qYU = paramt;
    paramt = new b.a();
    paramt.c((com.tencent.mm.bw.a)this.qYT);
    Object localObject = new ajd();
    ((ajd)localObject).setBaseResponse(new BaseResponse());
    paramt.d((com.tencent.mm.bw.a)localObject);
    paramt.oq(30000);
    paramt.Am("/cgi-bin/micromsg-bin/findercomment");
    paramt.op(getType());
    paramt = paramt.aAz();
    d.g.b.k.g(paramt, "builder.buildInstance()");
    this.rr = paramt;
    this.qYT.username = u.axE();
    paramt = this.qYT;
    localObject = com.tencent.mm.plugin.finder.storage.b.rCU;
    if (com.tencent.mm.plugin.finder.storage.b.cyx()) {}
    for (long l = 0L;; l = this.qYU.field_feedId)
    {
      paramt.qXP = l;
      this.qYT.objectNonceId = this.qYU.getObjectNonceId();
      this.qYT.EDK = this.qYU.cAQ();
      this.qYT.content = this.qYU.getContent();
      this.qYT.replyCommentId = this.qYU.field_actionInfo.EDq.replyCommentId;
      this.qYT.clientId = this.qYU.cAR();
      this.qYT.scene = this.qYU.field_scene;
      this.qYT.qXu = this.qYU.field_actionInfo.qXu;
      this.qYT.opType = 0;
      paramt = this.qYT;
      localObject = q.qXH;
      paramt.EDL = q.a(paramanm);
      paramt = this.qYT;
      paramanm = com.tencent.mm.plugin.finder.report.d.rxr;
      paramt.sessionBuffer = com.tencent.mm.plugin.finder.report.d.G(this.qYU.field_feedId, this.qYT.EDL.scene);
      ac.i(TAG, "CgiReplyFinderComment init, localId:" + this.qYU.field_localCommentId + ", clientId:" + this.qYU.cAR() + ", feedId:" + this.qYU.field_feedId + " commentScene:" + this.qYT.EDL.scene);
      AppMethodBeat.o(201219);
      return;
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(165292);
    this.callback = paramg;
    int i = dispatch(parame, (com.tencent.mm.network.q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(165292);
    return i;
  }
  
  public final int getType()
  {
    return 3906;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(165293);
    ac.i(TAG, "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    long l1;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(1279L, 15L, 1L, false);
      paramq = this.rr.aBD();
      if (paramq == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderCommentResponse");
        AppMethodBeat.o(165293);
        throw paramString;
      }
      paramq = (ajd)paramq;
      this.qYU.uR(ce.azH() / 1000L);
      paramArrayOfByte = this.qYU;
      l1 = paramq.EDM;
      paramArrayOfByte.field_actionInfo.EDq.commentId = l1;
      paramArrayOfByte = paramq.EDO;
      if (!bs.gY((List)paramArrayOfByte))
      {
        paramq = com.tencent.mm.plugin.finder.storage.data.d.rEF;
        paramq = d.a.uS(this.qYU.field_feedId);
        if (paramq != null)
        {
          ac.i(TAG, "add CommentCount on " + paramq.getFeedObject().hashCode() + ", " + paramq.getId() + ", " + paramq.getCommentCount());
          paramq.getCommentList().clear();
          paramq.getCommentList().addAll((Collection)paramArrayOfByte);
          paramArrayOfByte = new hf();
          paramArrayOfByte.dik.dig = paramq.field_id;
          hf.a locala = paramArrayOfByte.dik;
          amp localamp = new amp();
          localamp.commentList = paramq.getCommentList();
          locala.dil = localamp;
          com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)paramArrayOfByte);
          ac.i(TAG, "update expose commentList, add");
          paramArrayOfByte = com.tencent.mm.plugin.finder.storage.data.d.rEF;
          d.a.f(paramq);
          paramArrayOfByte = new ha();
          paramArrayOfByte.dhX.id = paramq.field_id;
          paramArrayOfByte.dhX.type = 2;
          com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)paramArrayOfByte);
        }
      }
    }
    for (this.qYU.field_state = 2;; this.qYU.field_state = 1)
    {
      paramq = com.tencent.mm.plugin.finder.spam.a.rBD;
      com.tencent.mm.plugin.finder.spam.a.x(paramInt2, paramInt3, paramString);
      paramq = com.tencent.mm.plugin.finder.spam.a.rBD;
      com.tencent.mm.plugin.finder.spam.a.y(paramInt2, paramInt3, ai.getContext().getString(2131759164));
      paramq = com.tencent.mm.plugin.finder.spam.a.rBD;
      com.tencent.mm.plugin.finder.spam.a.z(paramInt2, paramInt3, ai.getContext().getString(2131759163));
      ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderActionStorage();
      l1 = this.qYU.field_feedId;
      long l2 = this.qYU.field_actionInfo.EDq.commentId;
      long l3 = this.qYU.field_localCommentId;
      paramq = com.tencent.mm.plugin.finder.storage.a.rBJ;
      com.tencent.mm.plugin.finder.storage.a.a(l1, l2, l3, com.tencent.mm.plugin.finder.storage.a.cxW(), this.qYU);
      if (this.callback != null)
      {
        paramq = this.callback;
        if (paramq == null) {
          d.g.b.k.fOy();
        }
        paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      }
      AppMethodBeat.o(165293);
      return;
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(1279L, 16L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.az
 * JD-Core Version:    0.7.0.1
 */