package com.tencent.mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.i.a.d;
import com.tencent.mm.protocal.protobuf.ale;
import java.util.Map;

public final class c
{
  public ale hth;
  
  public c()
  {
    AppMethodBeat.i(164142);
    this.hth = new ale();
    AppMethodBeat.o(164142);
  }
  
  public final String aBe()
  {
    AppMethodBeat.i(164143);
    String str = d.a(this.hth);
    AppMethodBeat.o(164143);
    return str;
  }
  
  public final void h(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(164144);
    this.hth = d.t(paramString, paramMap);
    AppMethodBeat.o(164144);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelsns.c
 * JD-Core Version:    0.7.0.1
 */