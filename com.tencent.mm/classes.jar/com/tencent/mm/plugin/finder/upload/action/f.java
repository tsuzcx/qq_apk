package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.k;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.vending.c.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/upload/action/FollowAction;", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "finderUser", "", "opType", "", "feedId", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isPrivate", "", "(Ljava/lang/String;IJLcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Z)V", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getFeedId", "()J", "getFinderUser", "()Ljava/lang/String;", "()Z", "getOpType", "()I", "doFollow", "", "callback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask$ICallback;", "doSomething", "toString", "uniqueId", "plugin-finder_release"})
public final class f
  extends e
{
  public final String dNc;
  public final long feedId;
  public final int opType;
  public final bbn ttO;
  final boolean vUk;
  
  public f(String paramString, int paramInt, long paramLong, bbn parambbn, boolean paramBoolean)
  {
    super(null);
    AppMethodBeat.i(253200);
    this.dNc = paramString;
    this.opType = paramInt;
    this.feedId = paramLong;
    this.ttO = parambbn;
    this.vUk = paramBoolean;
    AppMethodBeat.o(253200);
  }
  
  public final void a(final k.b paramb)
  {
    AppMethodBeat.i(253199);
    p.h(paramb, "callback");
    super.a(paramb);
    new k(this).aYI().g((a)new a(this, paramb));
    AppMethodBeat.o(253199);
  }
  
  public final String auK()
  {
    AppMethodBeat.i(253198);
    String str = "id_" + this.dNc + '_' + this.opType;
    AppMethodBeat.o(253198);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(253197);
    String str = "action_" + this.dNc + '_' + this.opType + '_' + this.vUi;
    AppMethodBeat.o(253197);
    return str;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderFollowResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class a<_Ret, _Var>
    implements a<_Ret, _Var>
  {
    a(f paramf, k.b paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.f
 * JD-Core Version:    0.7.0.1
 */