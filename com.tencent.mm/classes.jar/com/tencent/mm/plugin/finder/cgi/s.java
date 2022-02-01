package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.aow;
import com.tencent.mm.protocal.protobuf.aox;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.storage.aj;
import d.g.b.q;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/CgiGetHotRelatedList;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListResp;", "feedId", "", "nonceId", "", "relatedEntranceInfo", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedEntranceInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JLjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedEntranceInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getFeedId", "()J", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class s
  extends com.tencent.mm.ak.a<aox>
{
  private static final boolean cFS;
  public static final a rQX;
  final long duw;
  private final String rPZ;
  private final aov rQW;
  
  static
  {
    boolean bool = false;
    AppMethodBeat.i(201500);
    rQX = new a((byte)0);
    if ((j.IS_FLAVOR_PURPLE) || (j.IS_FLAVOR_RED) || (com.tencent.mm.sdk.a.b.fnF())) {
      bool = true;
    }
    cFS = bool;
    AppMethodBeat.o(201500);
  }
  
  public s(long paramLong, String paramString, aov paramaov, arn paramarn)
  {
    AppMethodBeat.i(201499);
    this.duw = paramLong;
    this.rPZ = paramString;
    this.rQW = paramaov;
    paramString = g.ajR();
    d.g.b.p.g(paramString, "MMKernel.storage()");
    paramString = paramString.ajA();
    paramaov = com.tencent.mm.plugin.finder.utils.p.sXz;
    paramString = paramString.get(com.tencent.mm.plugin.finder.utils.p.Gr(4), "");
    if (paramString == null)
    {
      paramString = new d.v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(201499);
      throw paramString;
    }
    paramaov = com.tencent.mm.bw.b.cm(bu.aSx((String)paramString));
    b.a locala = new b.a();
    locala.oS(3688);
    paramString = new aow();
    paramString.rRn = this.duw;
    paramString.objectNonceId = this.rPZ;
    v localv = v.rRb;
    paramString.GEg = v.a(paramarn);
    paramString.scene = 4;
    paramString.dvm = 4;
    paramString.rSO = paramaov;
    paramString.GGi = this.rQW;
    locala.c((com.tencent.mm.bw.a)paramString);
    locala.d((com.tencent.mm.bw.a)new aox());
    locala.DN("/cgi-bin/micromsg-bin/findergetrelatedlist");
    c(locala.aDS());
    paramaov = new StringBuilder("feedId=").append(c.rp(this.duw)).append(" objectNonceId=").append(this.rPZ).append(" streamLastBuffer=").append(paramaov).append(" related_entrance_info=");
    if (paramString.GGi == null) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("CgiGetHotRelatedList", bool);
      AppMethodBeat.o(201499);
      return;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/CgiGetHotRelatedList$Companion;", "", "()V", "TAG", "", "isDebug", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<z>
  {
    b(s params)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.s
 * JD-Core Version:    0.7.0.1
 */