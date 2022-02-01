package com.tencent.mm.plugin.finder.uniComments.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.model.cn;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.finder.uniComments.model.a.a;
import com.tencent.mm.plugin.finder.uniComments.model.a.c;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.atd;
import com.tencent.mm.protocal.protobuf.bya;
import com.tencent.mm.protocal.protobuf.byb;
import com.tencent.mm.protocal.protobuf.kd;
import java.util.LinkedList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/uniComments/cgi/NetSceneUniToComment;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "unsentComment", "Lcom/tencent/mm/plugin/finder/uniComments/storge/LocalUniCommentObject;", "uniEntityItem", "Lcom/tencent/mm/plugin/finder/uniComments/model/UniEntityItem;", "(Lcom/tencent/mm/plugin/finder/uniComments/storge/LocalUniCommentObject;Lcom/tencent/mm/plugin/finder/uniComments/model/UniEntityItem;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "localObj", "getLocalObj", "()Lcom/tencent/mm/plugin/finder/uniComments/storge/LocalUniCommentObject;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderUniCommentRequest;", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderUniCommentRequest;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getUniEntityItem", "()Lcom/tencent/mm/plugin/finder/uniComments/model/UniEntityItem;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends p
  implements m
{
  public static final a GaG;
  private static final String TAG;
  private final bya GaH;
  private final com.tencent.mm.plugin.finder.uniComments.storge.b GaI;
  private final com.tencent.mm.plugin.finder.uniComments.model.b Gah;
  private h callback;
  private com.tencent.mm.am.c rr;
  
  static
  {
    AppMethodBeat.i(341586);
    GaG = new a((byte)0);
    TAG = "MicroMsg.MusicUni.NetSceneReplyFinderComment";
    AppMethodBeat.o(341586);
  }
  
  public e(com.tencent.mm.plugin.finder.uniComments.storge.b paramb, com.tencent.mm.plugin.finder.uniComments.model.b paramb1)
  {
    AppMethodBeat.i(341578);
    this.Gah = paramb1;
    this.GaH = new bya();
    this.GaI = paramb;
    paramb1 = new com.tencent.mm.am.c.a();
    paramb1.otE = ((com.tencent.mm.bx.a)this.GaH);
    Object localObject = new byb();
    ((byb)localObject).BaseResponse = new kd();
    paramb1.otF = ((com.tencent.mm.bx.a)localObject);
    paramb1.timeout = 30000;
    paramb1.uri = "/cgi-bin/micromsg-bin/finderunicomment";
    paramb1.funcId = getType();
    paramb1 = paramb1.bEF();
    kotlin.g.b.s.s(paramb1, "builder.buildInstance()");
    this.rr = paramb1;
    this.GaH.xlJ = this.Gah.xlJ;
    this.GaH.GaE = this.Gah.GaE;
    localObject = this.GaH;
    paramb1 = this.Gah.Gbe;
    if (paramb1 == null)
    {
      paramb1 = null;
      ((bya)localObject).aagU = paramb1;
      paramb1 = this.GaH;
      localObject = bi.ABn;
      paramb1.aagN = bi.dVu();
      paramb1 = this.GaH;
      localObject = a.a.GaQ;
      paramb1.aagR = a.a.fdC();
      paramb1 = this.GaH;
      if (paramb.field_scene != 1) {
        break label312;
      }
      localObject = a.c.GaW;
    }
    for (int i = a.c.fdH();; i = a.c.fdG())
    {
      paramb1.aagS = i;
      this.GaH.aagO = paramb.getContent();
      long l1 = paramb.field_actionInfo.ABa;
      long l2 = paramb.eZI().replyCommentId;
      this.GaH.aagP = l1;
      this.GaH.aagQ = l2;
      AppMethodBeat.o(341578);
      return;
      aw localaw = aw.Gjk;
      paramb1 = aw.j((com.tencent.mm.bx.a)paramb1);
      break;
      label312:
      localObject = a.c.GaW;
    }
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(341596);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(341596);
    return i;
  }
  
  public final int getType()
  {
    return 6964;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(341604);
    long l1;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = c.c.b(this.rr.otC);
      if (params == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUniCommentResponse");
        AppMethodBeat.o(341604);
        throw paramString;
      }
      params = (byb)params;
      this.GaI.qg(cn.bDu() / 1000L);
      paramArrayOfByte = this.GaI;
      l1 = params.ZFw;
      paramArrayOfByte.eZI().commentId = l1;
      params = this.GaI.FME;
      if (params != null) {
        params.clear();
      }
    }
    for (this.GaI.field_state = 2;; this.GaI.field_state = 1)
    {
      params = com.tencent.mm.plugin.finder.uniComments.storge.c.Gbn;
      com.tencent.mm.plugin.finder.uniComments.storge.c.a.fdQ();
      l1 = this.GaI.field_feedId;
      long l2 = this.GaI.eZI().commentId;
      long l3 = this.GaI.field_localCommentId;
      params = com.tencent.mm.plugin.finder.storage.a.FAm;
      com.tencent.mm.plugin.finder.uniComments.storge.c.a(l1, l2, l3, com.tencent.mm.plugin.finder.storage.a.ePH(), this.GaI);
      if (this.callback != null)
      {
        params = this.callback;
        kotlin.g.b.s.checkNotNull(params);
        params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
      }
      AppMethodBeat.o(341604);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/uniComments/cgi/NetSceneUniToComment$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.uniComments.cgi.e
 * JD-Core Version:    0.7.0.1
 */