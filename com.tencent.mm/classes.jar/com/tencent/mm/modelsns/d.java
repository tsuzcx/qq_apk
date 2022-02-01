package com.tencent.mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.axf;
import java.util.Map;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/modelsns/SnsFinderShareLive;", "Lcom/tencent/mm/modelsns/SnsTimeLineObjectPiece;", "()V", "shareLive", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;", "getShareLive", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;", "setShareLive", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;)V", "makeContent", "", "parseContent", "", "tagPrefix", "values", "", "plugin-sns_release"})
public final class d
  implements j
{
  public axf jlf;
  
  public d()
  {
    AppMethodBeat.i(201801);
    this.jlf = new axf();
    AppMethodBeat.o(201801);
  }
  
  public final void a(axf paramaxf)
  {
    AppMethodBeat.i(201798);
    p.h(paramaxf, "<set-?>");
    this.jlf = paramaxf;
    AppMethodBeat.o(201798);
  }
  
  public final String bfF()
  {
    AppMethodBeat.i(201799);
    String str = com.tencent.mm.plugin.i.a.l.c(this.jlf);
    p.g(str, "FinderShareParser.makeContent(shareLive)");
    AppMethodBeat.o(201799);
    return str;
  }
  
  public final void j(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(201800);
    paramString = com.tencent.mm.plugin.i.a.l.v(paramString, paramMap);
    p.g(paramString, "FinderShareParser.parseF…erLive(tagPrefix, values)");
    this.jlf = paramString;
    AppMethodBeat.o(201800);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsns.d
 * JD-Core Version:    0.7.0.1
 */