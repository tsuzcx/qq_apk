package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.f;
import com.tencent.mm.plugin.finder.cgi.e;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.vending.c.a;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/upload/action/LikeAction;", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "finderObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedId", "", "objectNonceId", "", "like", "", "scene", "", "uicallback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;JLjava/lang/String;ZILcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getFeedId", "()J", "getFinderObject", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getLike", "()Z", "getObjectNonceId", "()Ljava/lang/String;", "getScene", "()I", "doSomething", "", "callback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask$ICallback;", "toString", "uniqueId", "plugin-finder_release"})
public final class c
  extends b
{
  private final dzp contextObj;
  public final long feedId;
  public final String objectNonceId;
  public final FinderItem qRJ;
  public final boolean qRK;
  public final int scene;
  
  public c(FinderItem paramFinderItem, long paramLong, String paramString, boolean paramBoolean, dzp paramdzp)
  {
    AppMethodBeat.i(199557);
    this.qRJ = paramFinderItem;
    this.feedId = paramLong;
    this.objectNonceId = paramString;
    this.qRK = paramBoolean;
    this.scene = 2;
    this.contextObj = paramdzp;
    AppMethodBeat.o(199557);
  }
  
  public final void a(final e.b paramb)
  {
    AppMethodBeat.i(167807);
    k.h(paramb, "callback");
    super.a(paramb);
    new e(this, this.contextObj).auK().g((a)new a(this, paramb));
    AppMethodBeat.o(167807);
  }
  
  public final String abi()
  {
    AppMethodBeat.i(167806);
    String str = "id_" + this.feedId + '_' + this.qRK;
    AppMethodBeat.o(167806);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(167805);
    String str = "action_" + this.feedId + '_' + this.qRK + '_' + this.scene + '_' + this.qRH;
    AppMethodBeat.o(167805);
    return str;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class a<_Ret, _Var>
    implements a<_Ret, _Var>
  {
    a(c paramc, e.b paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.c
 * JD-Core Version:    0.7.0.1
 */