package com.tencent.mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.a.q;
import com.tencent.mm.protocal.protobuf.bvn;
import java.util.Map;

public final class g
  implements k
{
  public bvn oTZ;
  
  public g()
  {
    AppMethodBeat.i(164142);
    this.oTZ = new bvn();
    AppMethodBeat.o(164142);
  }
  
  public final String bMC()
  {
    AppMethodBeat.i(164143);
    String str = q.a(this.oTZ);
    AppMethodBeat.o(164143);
    return str;
  }
  
  public final void i(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(164144);
    this.oTZ = q.F(paramString, paramMap);
    AppMethodBeat.o(164144);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelsns.g
 * JD-Core Version:    0.7.0.1
 */