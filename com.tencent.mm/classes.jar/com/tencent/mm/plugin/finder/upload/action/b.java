package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cw.f;
import com.tencent.mm.plugin.finder.cgi.d;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.vending.c.a;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/upload/action/FavAction;", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "finderObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedId", "", "objectNonceId", "", "fav", "", "scene", "", "uicallback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isLongVideo", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;JLjava/lang/String;ZILcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Z)V", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getFav", "()Z", "getFeedId", "()J", "getFinderObject", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectNonceId", "()Ljava/lang/String;", "getScene", "()I", "doFavFeed", "", "callback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask$ICallback;", "doFavLongVideo", "doSomething", "toString", "uniqueId", "plugin-finder_release"})
public final class b
  extends e
{
  public final FinderItem ABv;
  public final boolean ABw;
  public final long feedId;
  private final boolean isLongVideo;
  public final String objectNonceId;
  private final int scene;
  private final bid xbu;
  
  public b(FinderItem paramFinderItem, long paramLong, String paramString, boolean paramBoolean, int paramInt, bid parambid)
  {
    super(null);
    AppMethodBeat.i(269773);
    this.ABv = paramFinderItem;
    this.feedId = paramLong;
    this.objectNonceId = paramString;
    this.ABw = paramBoolean;
    this.scene = 2;
    this.xbu = parambid;
    this.isLongVideo = false;
    AppMethodBeat.o(269773);
  }
  
  public final void a(final m.b paramb)
  {
    AppMethodBeat.i(269772);
    p.k(paramb, "callback");
    super.a(paramb);
    if (this.isLongVideo)
    {
      new d(this, this.xbu).bhW().g((a)new b(this, paramb));
      AppMethodBeat.o(269772);
      return;
    }
    new com.tencent.mm.plugin.finder.cgi.l(this, this.xbu).bhW().g((a)new a(this, paramb));
    AppMethodBeat.o(269772);
  }
  
  public final String aBG()
  {
    AppMethodBeat.i(269771);
    String str = "id_" + this.feedId + '_' + this.ABw;
    AppMethodBeat.o(269771);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(269770);
    String str = "action_" + this.feedId + '_' + this.ABw + '_' + this.scene + '_' + this.ABL;
    AppMethodBeat.o(269770);
    return str;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderFavResp;", "kotlin.jvm.PlatformType", "call"})
  static final class a<_Ret, _Var>
    implements a<_Ret, _Var>
  {
    a(b paramb, m.b paramb1) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/MegaVideoFavResp;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret, _Var>
    implements a<_Ret, _Var>
  {
    b(b paramb, m.b paramb1) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.b
 * JD-Core Version:    0.7.0.1
 */