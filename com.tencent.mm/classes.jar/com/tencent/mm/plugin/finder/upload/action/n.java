package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cw.f;
import com.tencent.mm.plugin.finder.cgi.t;
import com.tencent.mm.plugin.finder.storage.am;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.bid;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/upload/action/LikeCommentAction;", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "feedId", "", "objectNonceId", "", "comment", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "like", "", "scene", "", "uicallback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isPoster", "(JLjava/lang/String;Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;ZILcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Z)V", "getComment", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getFeedId", "()J", "()Z", "getLike", "getObjectNonceId", "()Ljava/lang/String;", "getScene", "()I", "doSomething", "", "callback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask$ICallback;", "toString", "uniqueId", "plugin-finder_release"})
public final class n
  extends e
{
  public final boolean ACe;
  public final am ACo;
  final boolean ACp;
  public final long feedId;
  public final String objectNonceId;
  public final int scene;
  private final bid xbu;
  
  public n(long paramLong, String paramString, am paramam, boolean paramBoolean1, int paramInt, bid parambid, boolean paramBoolean2)
  {
    super(null);
    AppMethodBeat.i(280153);
    this.feedId = paramLong;
    this.objectNonceId = paramString;
    this.ACo = paramam;
    this.ACe = paramBoolean1;
    this.scene = paramInt;
    this.xbu = parambid;
    this.ACp = paramBoolean2;
    AppMethodBeat.o(280153);
  }
  
  public final void a(final m.b paramb)
  {
    AppMethodBeat.i(167834);
    p.k(paramb, "callback");
    super.a(paramb);
    new t(this, this.xbu).bhW().g((com.tencent.mm.vending.c.a)new a(this, paramb));
    AppMethodBeat.o(167834);
  }
  
  public final String aBG()
  {
    AppMethodBeat.i(167832);
    String str = "id_" + this.feedId + '_' + this.ACo.dYY().commentId + '_' + this.ACe + '_' + this.scene + '_' + this.ABL;
    AppMethodBeat.o(167832);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(167833);
    String str = "action_" + this.feedId + '_' + this.ACo.dYY().commentId + '_' + this.ACe + '_' + this.scene;
    AppMethodBeat.o(167833);
    return str;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class a<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    a(n paramn, m.b paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.n
 * JD-Core Version:    0.7.0.1
 */