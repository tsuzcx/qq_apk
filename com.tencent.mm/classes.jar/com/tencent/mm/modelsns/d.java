package com.tencent.mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bcp;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/modelsns/SnsFinderShareLive;", "Lcom/tencent/mm/modelsns/SnsTimeLineObjectPiece;", "()V", "shareLive", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;", "getShareLive", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;", "setShareLive", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;)V", "makeContent", "", "parseContent", "", "tagPrefix", "values", "", "plugin-sns_release"})
public final class d
  implements k
{
  public bcp mbh;
  
  public d()
  {
    AppMethodBeat.i(269480);
    this.mbh = new bcp();
    AppMethodBeat.o(269480);
  }
  
  public final void a(bcp parambcp)
  {
    AppMethodBeat.i(269474);
    p.k(parambcp, "<set-?>");
    this.mbh = parambcp;
    AppMethodBeat.o(269474);
  }
  
  public final String boV()
  {
    AppMethodBeat.i(269476);
    String str = com.tencent.mm.plugin.findersdk.a.k.c(this.mbh);
    p.j(str, "FinderShareParser.makeContent(shareLive)");
    AppMethodBeat.o(269476);
    return str;
  }
  
  public final void i(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(269478);
    paramString = com.tencent.mm.plugin.findersdk.a.k.u(paramString, paramMap);
    p.j(paramString, "FinderShareParser.parseF…erLive(tagPrefix, values)");
    this.mbh = paramString;
    AppMethodBeat.o(269478);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsns.d
 * JD-Core Version:    0.7.0.1
 */