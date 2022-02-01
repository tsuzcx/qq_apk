package com.tencent.mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bja;
import java.util.Map;

public final class c
  implements k
{
  public bja mbg;
  
  public c()
  {
    AppMethodBeat.i(261666);
    this.mbg = new bja();
    AppMethodBeat.o(261666);
  }
  
  public final String boV()
  {
    AppMethodBeat.i(261668);
    String str = com.tencent.mm.plugin.findersdk.a.k.a(this.mbg);
    AppMethodBeat.o(261668);
    return str;
  }
  
  public final void i(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(261670);
    this.mbg = com.tencent.mm.plugin.findersdk.a.k.A(paramString, paramMap);
    AppMethodBeat.o(261670);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsns.c
 * JD-Core Version:    0.7.0.1
 */