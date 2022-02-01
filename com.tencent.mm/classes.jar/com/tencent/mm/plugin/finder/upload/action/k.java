package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cw.f;
import com.tencent.mm.plugin.finder.cgi.aj;
import com.tencent.mm.plugin.finder.cgi.u;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.vending.c.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/upload/action/LikeAction;", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "finderObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedId", "", "objectNonceId", "", "like", "", "isPrivate", "scene", "", "uicallback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isLongVideo", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;JLjava/lang/String;ZZILcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Z)V", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getFeedId", "()J", "getFinderObject", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "()Z", "getLike", "getObjectNonceId", "()Ljava/lang/String;", "getScene", "()I", "doLikeFeed", "", "callback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask$ICallback;", "doLikeLongVideo", "doSomething", "toString", "uniqueId", "plugin-finder_release"})
public final class k
  extends e
{
  public final boolean ABX;
  public final FinderItem ABv;
  public final boolean ACe;
  public final long feedId;
  private final boolean isLongVideo;
  public final String objectNonceId;
  public final int scene;
  private final bid xbu;
  
  public k(FinderItem paramFinderItem, long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt, bid parambid)
  {
    super(null);
    AppMethodBeat.i(281823);
    this.ABv = paramFinderItem;
    this.feedId = paramLong;
    this.objectNonceId = paramString;
    this.ACe = paramBoolean1;
    this.ABX = paramBoolean2;
    this.scene = paramInt;
    this.xbu = parambid;
    this.isLongVideo = false;
    AppMethodBeat.o(281823);
  }
  
  public final void a(final m.b paramb)
  {
    AppMethodBeat.i(167807);
    p.k(paramb, "callback");
    super.a(paramb);
    if (this.isLongVideo)
    {
      new aj(this, this.xbu).bhW().g((a)new b(this, paramb));
      AppMethodBeat.o(167807);
      return;
    }
    new u(this, this.xbu).bhW().g((a)new a(this, paramb));
    AppMethodBeat.o(167807);
  }
  
  public final String aBG()
  {
    AppMethodBeat.i(167806);
    String str = "id_" + this.feedId + '_' + this.ACe;
    AppMethodBeat.o(167806);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(167805);
    String str = "action_" + this.feedId + '_' + this.ACe + '_' + this.scene + '_' + this.ABL;
    AppMethodBeat.o(167805);
    return str;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class a<_Ret, _Var>
    implements a<_Ret, _Var>
  {
    a(k paramk, m.b paramb) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/MegaVideoLikeResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret, _Var>
    implements a<_Ret, _Var>
  {
    b(k paramk, m.b paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.k
 * JD-Core Version:    0.7.0.1
 */