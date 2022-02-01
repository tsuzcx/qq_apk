package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.f;
import com.tencent.mm.plugin.finder.storage.an;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.bbn;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/upload/action/LikeCommentAction;", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "feedId", "", "objectNonceId", "", "comment", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "like", "", "scene", "", "uicallback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isPoster", "(JLjava/lang/String;Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;ZILcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Z)V", "getComment", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getFeedId", "()J", "()Z", "getLike", "getObjectNonceId", "()Ljava/lang/String;", "getScene", "()I", "doSomething", "", "callback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask$ICallback;", "toString", "uniqueId", "plugin-finder_release"})
public final class l
  extends e
{
  public final long feedId;
  public final String objectNonceId;
  public final int scene;
  private final bbn ttO;
  public final an vUB;
  final boolean vUC;
  public final boolean vUr;
  
  public l(long paramLong, String paramString, an paraman, boolean paramBoolean1, int paramInt, bbn parambbn, boolean paramBoolean2)
  {
    super(null);
    AppMethodBeat.i(253234);
    this.feedId = paramLong;
    this.objectNonceId = paramString;
    this.vUB = paraman;
    this.vUr = paramBoolean1;
    this.scene = paramInt;
    this.ttO = parambbn;
    this.vUC = paramBoolean2;
    AppMethodBeat.o(253234);
  }
  
  public final void a(final k.b paramb)
  {
    AppMethodBeat.i(167834);
    kotlin.g.b.p.h(paramb, "callback");
    super.a(paramb);
    new com.tencent.mm.plugin.finder.cgi.p(this, this.ttO).aYI().g((com.tencent.mm.vending.c.a)new a(this, paramb));
    AppMethodBeat.o(167834);
  }
  
  public final String auK()
  {
    AppMethodBeat.i(167832);
    String str = "id_" + this.feedId + '_' + this.vUB.dyb().commentId + '_' + this.vUr + '_' + this.scene + '_' + this.vUi;
    AppMethodBeat.o(167832);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(167833);
    String str = "action_" + this.feedId + '_' + this.vUB.dyb().commentId + '_' + this.vUr + '_' + this.scene;
    AppMethodBeat.o(167833);
    return str;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class a<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    a(l paraml, k.b paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.l
 * JD-Core Version:    0.7.0.1
 */