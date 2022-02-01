package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.f;
import com.tencent.mm.plugin.finder.cgi.aj;
import com.tencent.mm.plugin.finder.cgi.q;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.vending.c.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/upload/action/LikeAction;", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "finderObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedId", "", "objectNonceId", "", "like", "", "isPrivate", "scene", "", "uicallback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isLongVideo", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;JLjava/lang/String;ZZILcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Z)V", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getFeedId", "()J", "getFinderObject", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "()Z", "getLike", "getObjectNonceId", "()Ljava/lang/String;", "getScene", "()I", "doLikeFeed", "", "callback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask$ICallback;", "doLikeLongVideo", "doSomething", "toString", "uniqueId", "plugin-finder_release"})
public final class i
  extends e
{
  public final long feedId;
  private final boolean isLongVideo;
  public final String objectNonceId;
  public final int scene;
  private final bbn ttO;
  public final FinderItem vTS;
  public final boolean vUk;
  public final boolean vUr;
  
  public i(FinderItem paramFinderItem, long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt, bbn parambbn)
  {
    super(null);
    AppMethodBeat.i(253218);
    this.vTS = paramFinderItem;
    this.feedId = paramLong;
    this.objectNonceId = paramString;
    this.vUr = paramBoolean1;
    this.vUk = paramBoolean2;
    this.scene = paramInt;
    this.ttO = parambbn;
    this.isLongVideo = false;
    AppMethodBeat.o(253218);
  }
  
  public final void a(final k.b paramb)
  {
    AppMethodBeat.i(167807);
    p.h(paramb, "callback");
    super.a(paramb);
    if (this.isLongVideo)
    {
      new aj(this, this.ttO).aYI().g((a)new b(this, paramb));
      AppMethodBeat.o(167807);
      return;
    }
    new q(this, this.ttO).aYI().g((a)new a(this, paramb));
    AppMethodBeat.o(167807);
  }
  
  public final String auK()
  {
    AppMethodBeat.i(167806);
    String str = "id_" + this.feedId + '_' + this.vUr;
    AppMethodBeat.o(167806);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(167805);
    String str = "action_" + this.feedId + '_' + this.vUr + '_' + this.scene + '_' + this.vUi;
    AppMethodBeat.o(167805);
    return str;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class a<_Ret, _Var>
    implements a<_Ret, _Var>
  {
    a(i parami, k.b paramb) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/MegaVideoLikeResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret, _Var>
    implements a<_Ret, _Var>
  {
    b(i parami, k.b paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.i
 * JD-Core Version:    0.7.0.1
 */