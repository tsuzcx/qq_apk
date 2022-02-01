package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.f;
import com.tencent.mm.plugin.finder.cgi.g;
import com.tencent.mm.plugin.finder.storage.t;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.vending.c.a;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/upload/action/LikeCommentAction;", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "feedId", "", "objectNonceId", "", "comment", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "like", "", "scene", "", "uicallback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isPoster", "(JLjava/lang/String;Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;ZILcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Z)V", "getComment", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getFeedId", "()J", "()Z", "getLike", "getObjectNonceId", "()Ljava/lang/String;", "getScene", "()I", "doSomething", "", "callback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask$ICallback;", "toString", "uniqueId", "plugin-finder_release"})
public final class i
  extends e
{
  private final anm contextObj;
  public final long dig;
  public final String objectNonceId;
  public final boolean rNX;
  public final t rOg;
  final boolean rOh;
  public final int scene;
  
  public i(long paramLong, String paramString, t paramt, boolean paramBoolean1, int paramInt, anm paramanm, boolean paramBoolean2)
  {
    AppMethodBeat.i(203544);
    this.dig = paramLong;
    this.objectNonceId = paramString;
    this.rOg = paramt;
    this.rNX = paramBoolean1;
    this.scene = paramInt;
    this.contextObj = paramanm;
    this.rOh = paramBoolean2;
    AppMethodBeat.o(203544);
  }
  
  public final void a(h.b paramb)
  {
    AppMethodBeat.i(167834);
    k.h(paramb, "callback");
    super.a(paramb);
    new g(this, this.contextObj).aBB().g((a)new i.a(this, paramb));
    AppMethodBeat.o(167834);
  }
  
  public final String acg()
  {
    AppMethodBeat.i(167832);
    String str = "id_" + this.dig + '_' + this.rOg.cAK() + '_' + this.rNX + '_' + this.scene + '_' + this.rNV;
    AppMethodBeat.o(167832);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(167833);
    String str = "action_" + this.dig + '_' + this.rOg.cAK() + '_' + this.rNX + '_' + this.scene;
    AppMethodBeat.o(167833);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.i
 * JD-Core Version:    0.7.0.1
 */