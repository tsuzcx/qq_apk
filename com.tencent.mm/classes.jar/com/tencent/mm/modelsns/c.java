package com.tencent.mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.i.a.e;
import com.tencent.mm.protocal.protobuf.ark;
import java.util.Map;

public final class c
{
  public ark ind;
  
  public c()
  {
    AppMethodBeat.i(164142);
    this.ind = new ark();
    AppMethodBeat.o(164142);
  }
  
  public final String aLf()
  {
    AppMethodBeat.i(164143);
    String str = e.a(this.ind);
    AppMethodBeat.o(164143);
    return str;
  }
  
  public final void i(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(164144);
    this.ind = e.w(paramString, paramMap);
    AppMethodBeat.o(164144);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsns.c
 * JD-Core Version:    0.7.0.1
 */