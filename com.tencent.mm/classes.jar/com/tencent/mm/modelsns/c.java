package com.tencent.mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.i.a.l;
import com.tencent.mm.protocal.protobuf.bcf;
import java.util.Map;

public final class c
  implements j
{
  public bcf jle;
  
  public c()
  {
    AppMethodBeat.i(192724);
    this.jle = new bcf();
    AppMethodBeat.o(192724);
  }
  
  public final String bfF()
  {
    AppMethodBeat.i(192725);
    String str = l.a(this.jle);
    AppMethodBeat.o(192725);
    return str;
  }
  
  public final void j(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(192726);
    this.jle = l.A(paramString, paramMap);
    AppMethodBeat.o(192726);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsns.c
 * JD-Core Version:    0.7.0.1
 */