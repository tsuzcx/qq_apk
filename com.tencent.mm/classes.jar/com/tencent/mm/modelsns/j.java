package com.tencent.mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.a.cq;
import com.tencent.mm.protocal.protobuf.dtj;
import java.util.Map;

public final class j
  implements k
{
  public dtj oUg;
  
  public j()
  {
    AppMethodBeat.i(233246);
    this.oUg = new dtj();
    AppMethodBeat.o(233246);
  }
  
  public final String bMC()
  {
    AppMethodBeat.i(233250);
    String str = cq.a(this.oUg);
    AppMethodBeat.o(233250);
    return str;
  }
  
  public final void i(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(233252);
    this.oUg = cq.J(paramString, paramMap);
    AppMethodBeat.o(233252);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelsns.j
 * JD-Core Version:    0.7.0.1
 */