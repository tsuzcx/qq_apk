package com.tencent.mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.i.a.l;
import com.tencent.mm.protocal.protobuf.bcl;
import java.util.Map;

public final class f
  implements j
{
  public bcl jld;
  
  public f()
  {
    AppMethodBeat.i(164142);
    this.jld = new bcl();
    AppMethodBeat.o(164142);
  }
  
  public final String bfF()
  {
    AppMethodBeat.i(164143);
    String str = l.b(this.jld);
    AppMethodBeat.o(164143);
    return str;
  }
  
  public final void j(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(164144);
    this.jld = l.z(paramString, paramMap);
    AppMethodBeat.o(164144);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsns.f
 * JD-Core Version:    0.7.0.1
 */