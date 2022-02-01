package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.f;
import com.tencent.mm.plugin.finder.storage.ab;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.arn;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/upload/action/LikeCommentAction;", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "feedId", "", "objectNonceId", "", "comment", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "like", "", "scene", "", "uicallback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isPoster", "(JLjava/lang/String;Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;ZILcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Z)V", "getComment", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getFeedId", "()J", "()Z", "getLike", "getObjectNonceId", "()Ljava/lang/String;", "getScene", "()I", "doSomething", "", "callback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask$ICallback;", "toString", "uniqueId", "plugin-finder_release"})
public final class i
  extends e
{
  public final long duw;
  public final String objectNonceId;
  private final arn rQw;
  public final ab sVA;
  final boolean sVB;
  public final boolean sVp;
  public final int scene;
  
  public i(long paramLong, String paramString, ab paramab, boolean paramBoolean1, int paramInt, arn paramarn, boolean paramBoolean2)
  {
    AppMethodBeat.i(205005);
    this.duw = paramLong;
    this.objectNonceId = paramString;
    this.sVA = paramab;
    this.sVp = paramBoolean1;
    this.scene = paramInt;
    this.rQw = paramarn;
    this.sVB = paramBoolean2;
    AppMethodBeat.o(205005);
  }
  
  public final void a(final h.b paramb)
  {
    AppMethodBeat.i(167834);
    p.h(paramb, "callback");
    super.a(paramb);
    new com.tencent.mm.plugin.finder.cgi.i(this, this.rQw).aET().g((com.tencent.mm.vending.c.a)new a(this, paramb));
    AppMethodBeat.o(167834);
  }
  
  public final String aeW()
  {
    AppMethodBeat.i(167832);
    String str = "id_" + this.duw + '_' + this.sVA.cLl().commentId + '_' + this.sVp + '_' + this.scene + '_' + this.sVn;
    AppMethodBeat.o(167832);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(167833);
    String str = "action_" + this.duw + '_' + this.sVA.cLl().commentId + '_' + this.sVp + '_' + this.scene;
    AppMethodBeat.o(167833);
    return str;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class a<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    a(i parami, h.b paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.i
 * JD-Core Version:    0.7.0.1
 */