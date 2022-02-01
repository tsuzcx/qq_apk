package com.tencent.mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bjg;
import java.util.Map;

public final class g
  implements k
{
  public bjg mbf;
  
  public g()
  {
    AppMethodBeat.i(164142);
    this.mbf = new bjg();
    AppMethodBeat.o(164142);
  }
  
  public final String boV()
  {
    AppMethodBeat.i(164143);
    String str = com.tencent.mm.plugin.findersdk.a.k.b(this.mbf);
    AppMethodBeat.o(164143);
    return str;
  }
  
  public final void i(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(164144);
    this.mbf = com.tencent.mm.plugin.findersdk.a.k.y(paramString, paramMap);
    AppMethodBeat.o(164144);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsns.g
 * JD-Core Version:    0.7.0.1
 */