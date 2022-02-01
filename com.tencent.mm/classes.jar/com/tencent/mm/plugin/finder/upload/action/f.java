package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.j;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.vending.c.a;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/upload/action/LikeAction;", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "finderObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedId", "", "objectNonceId", "", "like", "", "isPrivate", "scene", "", "uicallback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;JLjava/lang/String;ZZILcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getFeedId", "()J", "getFinderObject", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "()Z", "getLike", "getObjectNonceId", "()Ljava/lang/String;", "getScene", "()I", "doSomething", "", "callback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask$ICallback;", "toString", "uniqueId", "plugin-finder_release"})
public final class f
  extends e
{
  public final long dtq;
  public final String objectNonceId;
  private final aqy rIl;
  public final FinderItem sJL;
  public final boolean sKc;
  public final boolean sKd;
  public final int scene;
  
  public f(FinderItem paramFinderItem, long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt, aqy paramaqy)
  {
    AppMethodBeat.i(204372);
    this.sJL = paramFinderItem;
    this.dtq = paramLong;
    this.objectNonceId = paramString;
    this.sKc = paramBoolean1;
    this.sKd = paramBoolean2;
    this.scene = paramInt;
    this.rIl = paramaqy;
    AppMethodBeat.o(204372);
  }
  
  public final void a(final h.b paramb)
  {
    AppMethodBeat.i(167807);
    p.h(paramb, "callback");
    super.a(paramb);
    new j(this, this.rIl).aED().g((a)new a(this, paramb));
    AppMethodBeat.o(167807);
  }
  
  public final String aeK()
  {
    AppMethodBeat.i(167806);
    String str = "id_" + this.dtq + '_' + this.sKc;
    AppMethodBeat.o(167806);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(167805);
    String str = "action_" + this.dtq + '_' + this.sKc + '_' + this.scene + '_' + this.sKa;
    AppMethodBeat.o(167805);
    return str;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class a<_Ret, _Var>
    implements a<_Ret, _Var>
  {
    a(f paramf, h.b paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.f
 * JD-Core Version:    0.7.0.1
 */