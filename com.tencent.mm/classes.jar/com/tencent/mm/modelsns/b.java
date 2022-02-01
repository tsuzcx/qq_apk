package com.tencent.mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.i.a.e;
import com.tencent.mm.protocal.protobuf.anx;
import java.util.Map;

public final class b
{
  public anx hTI;
  
  public b()
  {
    AppMethodBeat.i(164139);
    this.hTI = new anx();
    AppMethodBeat.o(164139);
  }
  
  public final String aHU()
  {
    AppMethodBeat.i(164140);
    String str = e.b(this.hTI);
    AppMethodBeat.o(164140);
    return str;
  }
  
  public final void h(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(164141);
    this.hTI = e.t(paramString, paramMap);
    AppMethodBeat.o(164141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsns.b
 * JD-Core Version:    0.7.0.1
 */