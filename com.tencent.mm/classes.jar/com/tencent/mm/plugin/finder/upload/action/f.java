package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.h;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.vending.c.a;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/upload/action/LikeAction;", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "finderObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedId", "", "objectNonceId", "", "like", "", "scene", "", "uicallback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;JLjava/lang/String;ZILcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getFeedId", "()J", "getFinderObject", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getLike", "()Z", "getObjectNonceId", "()Ljava/lang/String;", "getScene", "()I", "doSomething", "", "callback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask$ICallback;", "toString", "uniqueId", "plugin-finder_release"})
public final class f
  extends e
{
  private final anm contextObj;
  public final long dig;
  public final String objectNonceId;
  public final FinderItem rNG;
  public final boolean rNX;
  public final int scene;
  
  public f(FinderItem paramFinderItem, long paramLong, String paramString, boolean paramBoolean, anm paramanm)
  {
    AppMethodBeat.i(203533);
    this.rNG = paramFinderItem;
    this.dig = paramLong;
    this.objectNonceId = paramString;
    this.rNX = paramBoolean;
    this.scene = 2;
    this.contextObj = paramanm;
    AppMethodBeat.o(203533);
  }
  
  public final void a(h.b paramb)
  {
    AppMethodBeat.i(167807);
    k.h(paramb, "callback");
    super.a(paramb);
    new h(this, this.contextObj).aBB().g((a)new f.a(this, paramb));
    AppMethodBeat.o(167807);
  }
  
  public final String acg()
  {
    AppMethodBeat.i(167806);
    String str = "id_" + this.dig + '_' + this.rNX;
    AppMethodBeat.o(167806);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(167805);
    String str = "action_" + this.dig + '_' + this.rNX + '_' + this.scene + '_' + this.rNV;
    AppMethodBeat.o(167805);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.f
 * JD-Core Version:    0.7.0.1
 */