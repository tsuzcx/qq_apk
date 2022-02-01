package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.utils.n;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.protocal.protobuf.ale;
import com.tencent.mm.protocal.protobuf.alf;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.storage.ae;
import d.g.b.k;
import d.v;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/CgiGetHotRelatedList;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListResp;", "feedId", "", "nonceId", "", "relatedEntranceInfo", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedEntranceInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JLjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedEntranceInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getFeedId", "()J", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class o
  extends com.tencent.mm.ak.a<alf>
{
  private static final boolean cuo;
  public static final a qXE;
  final long dig;
  private final String qXC;
  private final ald qXD;
  
  static
  {
    boolean bool = false;
    AppMethodBeat.i(201147);
    qXE = new a((byte)0);
    if ((h.IS_FLAVOR_PURPLE) || (h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.a.b.eUk())) {
      bool = true;
    }
    cuo = bool;
    AppMethodBeat.o(201147);
  }
  
  public o(long paramLong, String paramString, ald paramald, anm paramanm)
  {
    AppMethodBeat.i(201146);
    this.dig = paramLong;
    this.qXC = paramString;
    this.qXD = paramald;
    paramString = g.agR();
    k.g(paramString, "MMKernel.storage()");
    paramString = paramString.agA();
    paramald = n.rPN;
    paramString = paramString.get(n.EI(4), "");
    if (paramString == null)
    {
      paramString = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(201146);
      throw paramString;
    }
    paramald = com.tencent.mm.bw.b.cc(bs.aLu((String)paramString));
    b.a locala = new b.a();
    locala.op(3688);
    paramString = new ale();
    paramString.qXP = this.dig;
    paramString.objectNonceId = this.qXC;
    q localq = q.qXH;
    paramString.EDu = q.a(paramanm);
    paramString.scene = 4;
    paramString.diw = 4;
    paramString.qZd = paramald;
    paramString.EEX = this.qXD;
    locala.c((com.tencent.mm.bw.a)paramString);
    locala.d((com.tencent.mm.bw.a)new alf());
    locala.Am("/cgi-bin/micromsg-bin/findergetrelatedlist");
    c(locala.aAz());
    paramald = new StringBuilder("feedId=").append(c.pb(this.dig)).append(" objectNonceId=").append(this.qXC).append(" streamLastBuffer=").append(paramald).append(" related_entrance_info=");
    if (paramString.EEX == null) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("CgiGetHotRelatedList", bool);
      AppMethodBeat.o(201146);
      return;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/CgiGetHotRelatedList$Companion;", "", "()V", "TAG", "", "isDebug", "", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(o paramo)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.o
 * JD-Core Version:    0.7.0.1
 */