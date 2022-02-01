package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.f;
import com.tencent.mm.plugin.finder.cgi.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.vending.c.a;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/upload/action/FavAction;", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "finderObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedId", "", "objectNonceId", "", "fav", "", "scene", "", "uicallback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;JLjava/lang/String;ZILcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getFav", "()Z", "getFeedId", "()J", "getFinderObject", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectNonceId", "()Ljava/lang/String;", "getScene", "()I", "doSomething", "", "callback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask$ICallback;", "toString", "uniqueId", "plugin-finder_release"})
public final class b
  extends e
{
  private final anm contextObj;
  public final long dig;
  public final String objectNonceId;
  public final FinderItem rNG;
  public final boolean rNH;
  private final int scene;
  
  public b(FinderItem paramFinderItem, long paramLong, String paramString, boolean paramBoolean, anm paramanm)
  {
    AppMethodBeat.i(203516);
    this.rNG = paramFinderItem;
    this.dig = paramLong;
    this.objectNonceId = paramString;
    this.rNH = paramBoolean;
    this.scene = 2;
    this.contextObj = paramanm;
    AppMethodBeat.o(203516);
  }
  
  public final void a(final h.b paramb)
  {
    AppMethodBeat.i(203515);
    k.h(paramb, "callback");
    super.a(paramb);
    new c(this, this.contextObj).aBB().g((a)new a(this, paramb));
    AppMethodBeat.o(203515);
  }
  
  public final String acg()
  {
    AppMethodBeat.i(203514);
    String str = "id_" + this.dig + '_' + this.rNH;
    AppMethodBeat.o(203514);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(203513);
    String str = "action_" + this.dig + '_' + this.rNH + '_' + this.scene + '_' + this.rNV;
    AppMethodBeat.o(203513);
    return str;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderFavResp;", "kotlin.jvm.PlatformType", "call"})
  static final class a<_Ret, _Var>
    implements a<_Ret, _Var>
  {
    a(b paramb, h.b paramb1) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.b
 * JD-Core Version:    0.7.0.1
 */