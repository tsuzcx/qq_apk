package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.f;
import com.tencent.mm.plugin.finder.cgi.c;
import com.tencent.mm.plugin.finder.cgi.h;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.vending.c.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/upload/action/FavAction;", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "finderObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedId", "", "objectNonceId", "", "fav", "", "scene", "", "uicallback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isLongVideo", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;JLjava/lang/String;ZILcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Z)V", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getFav", "()Z", "getFeedId", "()J", "getFinderObject", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectNonceId", "()Ljava/lang/String;", "getScene", "()I", "doFavFeed", "", "callback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask$ICallback;", "doFavLongVideo", "doSomething", "toString", "uniqueId", "plugin-finder_release"})
public final class b
  extends e
{
  public final long feedId;
  private final boolean isLongVideo;
  public final String objectNonceId;
  private final int scene;
  private final bbn ttO;
  public final FinderItem vTS;
  public final boolean vTT;
  
  public b(FinderItem paramFinderItem, long paramLong, String paramString, boolean paramBoolean, int paramInt, bbn parambbn)
  {
    super(null);
    AppMethodBeat.i(253178);
    this.vTS = paramFinderItem;
    this.feedId = paramLong;
    this.objectNonceId = paramString;
    this.vTT = paramBoolean;
    this.scene = 2;
    this.ttO = parambbn;
    this.isLongVideo = false;
    AppMethodBeat.o(253178);
  }
  
  public final void a(final k.b paramb)
  {
    AppMethodBeat.i(253177);
    p.h(paramb, "callback");
    super.a(paramb);
    if (this.isLongVideo)
    {
      new c(this, this.ttO).aYI().g((a)new b(this, paramb));
      AppMethodBeat.o(253177);
      return;
    }
    new h(this, this.ttO).aYI().g((a)new a(this, paramb));
    AppMethodBeat.o(253177);
  }
  
  public final String auK()
  {
    AppMethodBeat.i(253176);
    String str = "id_" + this.feedId + '_' + this.vTT;
    AppMethodBeat.o(253176);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(253175);
    String str = "action_" + this.feedId + '_' + this.vTT + '_' + this.scene + '_' + this.vUi;
    AppMethodBeat.o(253175);
    return str;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderFavResp;", "kotlin.jvm.PlatformType", "call"})
  static final class a<_Ret, _Var>
    implements a<_Ret, _Var>
  {
    a(b paramb, k.b paramb1) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/MegaVideoFavResp;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret, _Var>
    implements a<_Ret, _Var>
  {
    b(b paramb, k.b paramb1) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.b
 * JD-Core Version:    0.7.0.1
 */