package com.tencent.mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.i.a.e;
import com.tencent.mm.protocal.protobuf.arz;
import java.util.Map;

public final class c
{
  public arz ipX;
  
  public c()
  {
    AppMethodBeat.i(164142);
    this.ipX = new arz();
    AppMethodBeat.o(164142);
  }
  
  public final String aLC()
  {
    AppMethodBeat.i(164143);
    String str = e.a(this.ipX);
    AppMethodBeat.o(164143);
    return str;
  }
  
  public final void j(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(164144);
    this.ipX = e.x(paramString, paramMap);
    AppMethodBeat.o(164144);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsns.c
 * JD-Core Version:    0.7.0.1
 */