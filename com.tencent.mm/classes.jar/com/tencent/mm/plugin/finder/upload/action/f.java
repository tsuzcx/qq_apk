package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.d;
import com.tencent.mm.protocal.protobuf.dzp;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/upload/action/LikeCommentAction;", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "feedId", "", "objectNonceId", "", "comment", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "like", "", "scene", "", "uicallback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isPoster", "(JLjava/lang/String;Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;ZILcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Z)V", "getComment", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getFeedId", "()J", "()Z", "getLike", "getObjectNonceId", "()Ljava/lang/String;", "getScene", "()I", "doSomething", "", "callback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask$ICallback;", "toString", "uniqueId", "plugin-finder_release"})
public final class f
  extends b
{
  final boolean Las;
  private final dzp contextObj;
  public final long feedId;
  public final String objectNonceId;
  public final boolean qRK;
  public final com.tencent.mm.plugin.finder.storage.k qRY;
  public final int scene;
  
  public f(long paramLong, String paramString, com.tencent.mm.plugin.finder.storage.k paramk, boolean paramBoolean1, int paramInt, dzp paramdzp, boolean paramBoolean2)
  {
    AppMethodBeat.i(199568);
    this.feedId = paramLong;
    this.objectNonceId = paramString;
    this.qRY = paramk;
    this.qRK = paramBoolean1;
    this.scene = paramInt;
    this.contextObj = paramdzp;
    this.Las = paramBoolean2;
    AppMethodBeat.o(199568);
  }
  
  public final void a(final e.b paramb)
  {
    AppMethodBeat.i(167834);
    d.g.b.k.h(paramb, "callback");
    super.a(paramb);
    new d(this, this.contextObj).auK().g((com.tencent.mm.vending.c.a)new a(this, paramb));
    AppMethodBeat.o(167834);
  }
  
  public final String abi()
  {
    AppMethodBeat.i(167832);
    String str = "id_" + this.feedId + '_' + this.qRY.cqr() + '_' + this.qRK + '_' + this.scene + '_' + this.qRH;
    AppMethodBeat.o(167832);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(167833);
    String str = "action_" + this.feedId + '_' + this.qRY.cqr() + '_' + this.qRK + '_' + this.scene;
    AppMethodBeat.o(167833);
    return str;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class a<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    a(f paramf, e.b paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.f
 * JD-Core Version:    0.7.0.1
 */