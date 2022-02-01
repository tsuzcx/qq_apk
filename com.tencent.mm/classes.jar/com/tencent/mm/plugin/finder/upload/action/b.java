package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.f;
import com.tencent.mm.plugin.finder.cgi.d;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.vending.c.a;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/upload/action/FavAction;", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "finderObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedId", "", "objectNonceId", "", "fav", "", "scene", "", "uicallback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;JLjava/lang/String;ZILcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getFav", "()Z", "getFeedId", "()J", "getFinderObject", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectNonceId", "()Ljava/lang/String;", "getScene", "()I", "doSomething", "", "callback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask$ICallback;", "toString", "uniqueId", "plugin-finder_release"})
public final class b
  extends e
{
  public final long duw;
  public final String objectNonceId;
  private final arn rQw;
  public final FinderItem sUY;
  public final boolean sUZ;
  private final int scene;
  
  public b(FinderItem paramFinderItem, long paramLong, String paramString, boolean paramBoolean, arn paramarn)
  {
    AppMethodBeat.i(204973);
    this.sUY = paramFinderItem;
    this.duw = paramLong;
    this.objectNonceId = paramString;
    this.sUZ = paramBoolean;
    this.scene = 2;
    this.rQw = paramarn;
    AppMethodBeat.o(204973);
  }
  
  public final void a(final h.b paramb)
  {
    AppMethodBeat.i(204972);
    p.h(paramb, "callback");
    super.a(paramb);
    new d(this, this.rQw).aET().g((a)new a(this, paramb));
    AppMethodBeat.o(204972);
  }
  
  public final String aeW()
  {
    AppMethodBeat.i(204971);
    String str = "id_" + this.duw + '_' + this.sUZ;
    AppMethodBeat.o(204971);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(204970);
    String str = "action_" + this.duw + '_' + this.sUZ + '_' + this.scene + '_' + this.sVn;
    AppMethodBeat.o(204970);
    return str;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderFavResp;", "kotlin.jvm.PlatformType", "call"})
  static final class a<_Ret, _Var>
    implements a<_Ret, _Var>
  {
    a(b paramb, h.b paramb1) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.b
 * JD-Core Version:    0.7.0.1
 */