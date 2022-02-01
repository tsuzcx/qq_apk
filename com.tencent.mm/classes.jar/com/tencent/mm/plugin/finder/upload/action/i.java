package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.f;
import com.tencent.mm.plugin.finder.storage.ab;
import com.tencent.mm.protocal.protobuf.aqy;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/upload/action/LikeCommentAction;", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "feedId", "", "objectNonceId", "", "comment", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "like", "", "scene", "", "uicallback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isPoster", "(JLjava/lang/String;Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;ZILcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Z)V", "getComment", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getFeedId", "()J", "()Z", "getLike", "getObjectNonceId", "()Ljava/lang/String;", "getScene", "()I", "doSomething", "", "callback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask$ICallback;", "toString", "uniqueId", "plugin-finder_release"})
public final class i
  extends e
{
  public final long dtq;
  public final String objectNonceId;
  private final aqy rIl;
  public final boolean sKc;
  public final ab sKn;
  final boolean sKo;
  public final int scene;
  
  public i(long paramLong, String paramString, ab paramab, boolean paramBoolean1, int paramInt, aqy paramaqy, boolean paramBoolean2)
  {
    AppMethodBeat.i(204387);
    this.dtq = paramLong;
    this.objectNonceId = paramString;
    this.sKn = paramab;
    this.sKc = paramBoolean1;
    this.scene = paramInt;
    this.rIl = paramaqy;
    this.sKo = paramBoolean2;
    AppMethodBeat.o(204387);
  }
  
  public final void a(final h.b paramb)
  {
    AppMethodBeat.i(167834);
    p.h(paramb, "callback");
    super.a(paramb);
    new com.tencent.mm.plugin.finder.cgi.i(this, this.rIl).aED().g((com.tencent.mm.vending.c.a)new a(this, paramb));
    AppMethodBeat.o(167834);
  }
  
  public final String aeK()
  {
    AppMethodBeat.i(167832);
    String str = "id_" + this.dtq + '_' + this.sKn.cIG() + '_' + this.sKc + '_' + this.scene + '_' + this.sKa;
    AppMethodBeat.o(167832);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(167833);
    String str = "action_" + this.dtq + '_' + this.sKn.cIG() + '_' + this.sKc + '_' + this.scene;
    AppMethodBeat.o(167833);
    return str;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeResponse;", "kotlin.jvm.PlatformType", "call"})
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