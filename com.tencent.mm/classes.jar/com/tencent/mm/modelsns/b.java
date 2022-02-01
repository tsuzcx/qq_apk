package com.tencent.mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.i.a.d;
import com.tencent.mm.protocal.protobuf.ald;
import java.util.Map;

public final class b
{
  public ald htg;
  
  public b()
  {
    AppMethodBeat.i(164139);
    this.htg = new ald();
    AppMethodBeat.o(164139);
  }
  
  public final String aBe()
  {
    AppMethodBeat.i(164140);
    String str = d.a(this.htg);
    AppMethodBeat.o(164140);
    return str;
  }
  
  public final void h(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(164141);
    this.htg = d.s(paramString, paramMap);
    AppMethodBeat.o(164141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelsns.b
 * JD-Core Version:    0.7.0.1
 */