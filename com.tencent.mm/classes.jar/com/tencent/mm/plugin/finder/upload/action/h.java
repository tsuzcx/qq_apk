package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cw.f;
import com.tencent.mm.plugin.finder.cgi.o;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.vending.c.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/upload/action/FollowAction;", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "finderUser", "", "opType", "", "feedId", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isPrivate", "", "enterType", "(Ljava/lang/String;IJLcom/tencent/mm/protocal/protobuf/FinderReportContextObj;ZI)V", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getEnterType", "()I", "getFeedId", "()J", "getFinderUser", "()Ljava/lang/String;", "()Z", "getOpType", "doFollow", "", "callback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask$ICallback;", "doSomething", "toString", "uniqueId", "plugin-finder_release"})
public final class h
  extends e
{
  final boolean ABX;
  public final String fGm;
  public final long feedId;
  public final int opType;
  public final int xbJ;
  public final bid xbu;
  
  public h(String paramString, int paramInt1, long paramLong, bid parambid, boolean paramBoolean, int paramInt2)
  {
    super(null);
    AppMethodBeat.i(266045);
    this.fGm = paramString;
    this.opType = paramInt1;
    this.feedId = paramLong;
    this.xbu = parambid;
    this.ABX = paramBoolean;
    this.xbJ = paramInt2;
    AppMethodBeat.o(266045);
  }
  
  public final void a(final m.b paramb)
  {
    AppMethodBeat.i(266044);
    p.k(paramb, "callback");
    super.a(paramb);
    new o(this).bhW().g((a)new a(this, paramb));
    AppMethodBeat.o(266044);
  }
  
  public final String aBG()
  {
    AppMethodBeat.i(266043);
    String str = "id_" + this.fGm + '_' + this.opType;
    AppMethodBeat.o(266043);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(266042);
    String str = "action_" + this.fGm + '_' + this.opType + '_' + this.ABL;
    AppMethodBeat.o(266042);
    return str;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderFollowResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class a<_Ret, _Var>
    implements a<_Ret, _Var>
  {
    a(h paramh, m.b paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.h
 * JD-Core Version:    0.7.0.1
 */