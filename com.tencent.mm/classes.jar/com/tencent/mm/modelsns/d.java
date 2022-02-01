package com.tencent.mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.a.q;
import com.tencent.mm.protocal.protobuf.bmr;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/modelsns/SnsFinderShareLive;", "Lcom/tencent/mm/modelsns/SnsTimeLineObjectPiece;", "()V", "shareLive", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;", "getShareLive", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;", "setShareLive", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;)V", "makeContent", "", "parseContent", "", "tagPrefix", "values", "", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements k
{
  public bmr oUb;
  
  public d()
  {
    AppMethodBeat.i(233230);
    this.oUb = new bmr();
    AppMethodBeat.o(233230);
  }
  
  public final void a(bmr parambmr)
  {
    AppMethodBeat.i(233234);
    s.u(parambmr, "<set-?>");
    this.oUb = parambmr;
    AppMethodBeat.o(233234);
  }
  
  public final String bMC()
  {
    AppMethodBeat.i(233237);
    String str = q.c(this.oUb);
    s.s(str, "makeContent(shareLive)");
    AppMethodBeat.o(233237);
    return str;
  }
  
  public final void i(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(233244);
    paramString = q.z(paramString, paramMap);
    s.s(paramString, "parseFinderLive(tagPrefix, values)");
    this.oUb = paramString;
    AppMethodBeat.o(233244);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelsns.d
 * JD-Core Version:    0.7.0.1
 */