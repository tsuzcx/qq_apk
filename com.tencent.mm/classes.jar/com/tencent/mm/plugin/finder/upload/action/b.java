package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.f;
import com.tencent.mm.plugin.finder.cgi.d;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.vending.c.a;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/upload/action/FavAction;", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "finderObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedId", "", "objectNonceId", "", "fav", "", "scene", "", "uicallback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;JLjava/lang/String;ZILcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getFav", "()Z", "getFeedId", "()J", "getFinderObject", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectNonceId", "()Ljava/lang/String;", "getScene", "()I", "doSomething", "", "callback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask$ICallback;", "toString", "uniqueId", "plugin-finder_release"})
public final class b
  extends e
{
  public final long dtq;
  public final String objectNonceId;
  private final aqy rIl;
  public final FinderItem sJL;
  public final boolean sJM;
  private final int scene;
  
  public b(FinderItem paramFinderItem, long paramLong, String paramString, boolean paramBoolean, aqy paramaqy)
  {
    AppMethodBeat.i(204355);
    this.sJL = paramFinderItem;
    this.dtq = paramLong;
    this.objectNonceId = paramString;
    this.sJM = paramBoolean;
    this.scene = 2;
    this.rIl = paramaqy;
    AppMethodBeat.o(204355);
  }
  
  public final void a(final h.b paramb)
  {
    AppMethodBeat.i(204354);
    p.h(paramb, "callback");
    super.a(paramb);
    new d(this, this.rIl).aED().g((a)new a(this, paramb));
    AppMethodBeat.o(204354);
  }
  
  public final String aeK()
  {
    AppMethodBeat.i(204353);
    String str = "id_" + this.dtq + '_' + this.sJM;
    AppMethodBeat.o(204353);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(204352);
    String str = "action_" + this.dtq + '_' + this.sJM + '_' + this.scene + '_' + this.sKa;
    AppMethodBeat.o(204352);
    return str;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderFavResp;", "kotlin.jvm.PlatformType", "call"})
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