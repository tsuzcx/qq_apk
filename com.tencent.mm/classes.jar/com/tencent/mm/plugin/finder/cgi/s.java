package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.al.b.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.aoj;
import com.tencent.mm.protocal.protobuf.aok;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.storage.ai;
import d.g.b.q;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/CgiGetHotRelatedList;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListResp;", "feedId", "", "nonceId", "", "relatedEntranceInfo", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedEntranceInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JLjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedEntranceInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getFeedId", "()J", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class s
  extends com.tencent.mm.al.a<aok>
{
  private static final boolean cFj;
  public static final a rIN;
  final long dtq;
  private final String rHO;
  private final aoi rIM;
  
  static
  {
    boolean bool = false;
    AppMethodBeat.i(201082);
    rIN = new a((byte)0);
    if ((i.IS_FLAVOR_PURPLE) || (i.IS_FLAVOR_RED) || (com.tencent.mm.sdk.a.b.fjN())) {
      bool = true;
    }
    cFj = bool;
    AppMethodBeat.o(201082);
  }
  
  public s(long paramLong, String paramString, aoi paramaoi, aqy paramaqy)
  {
    AppMethodBeat.i(201081);
    this.dtq = paramLong;
    this.rHO = paramString;
    this.rIM = paramaoi;
    paramString = g.ajC();
    d.g.b.p.g(paramString, "MMKernel.storage()");
    paramString = paramString.ajl();
    paramaoi = com.tencent.mm.plugin.finder.utils.p.sMo;
    paramString = paramString.get(com.tencent.mm.plugin.finder.utils.p.FS(4), "");
    if (paramString == null)
    {
      paramString = new d.v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(201081);
      throw paramString;
    }
    paramaoi = com.tencent.mm.bx.b.cj(bt.aRa((String)paramString));
    b.a locala = new b.a();
    locala.oP(3688);
    paramString = new aoj();
    paramString.rIZ = this.dtq;
    paramString.objectNonceId = this.rHO;
    v localv = v.rIR;
    paramString.Gle = v.a(paramaqy);
    paramString.scene = 4;
    paramString.duh = 4;
    paramString.rKC = paramaoi;
    paramString.Gnc = this.rIM;
    locala.c((com.tencent.mm.bx.a)paramString);
    locala.d((com.tencent.mm.bx.a)new aok());
    locala.Dl("/cgi-bin/micromsg-bin/findergetrelatedlist");
    c(locala.aDC());
    paramaoi = new StringBuilder("feedId=").append(c.rc(this.dtq)).append(" objectNonceId=").append(this.rHO).append(" streamLastBuffer=").append(paramaoi).append(" related_entrance_info=");
    if (paramString.Gnc == null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("CgiGetHotRelatedList", bool);
      AppMethodBeat.o(201081);
      return;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/CgiGetHotRelatedList$Companion;", "", "()V", "TAG", "", "isDebug", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
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