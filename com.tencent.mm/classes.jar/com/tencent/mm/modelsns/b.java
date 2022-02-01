package com.tencent.mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.i.a.e;
import com.tencent.mm.protocal.protobuf.arj;
import java.util.Map;

public final class b
{
  public arj inc;
  
  public b()
  {
    AppMethodBeat.i(164139);
    this.inc = new arj();
    AppMethodBeat.o(164139);
  }
  
  public final String aLf()
  {
    AppMethodBeat.i(164140);
    String str = e.b(this.inc);
    AppMethodBeat.o(164140);
    return str;
  }
  
  public final void i(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(164141);
    this.inc = e.v(paramString, paramMap);
    AppMethodBeat.o(164141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsns.b
 * JD-Core Version:    0.7.0.1
 */