package com.tencent.mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.a.q;
import com.tencent.mm.protocal.protobuf.doc;
import java.util.Map;

public final class h
  implements k
{
  public doc oUe;
  
  public h()
  {
    AppMethodBeat.i(233238);
    this.oUe = new doc();
    AppMethodBeat.o(233238);
  }
  
  public final String bMC()
  {
    AppMethodBeat.i(233243);
    String str = q.b(this.oUe);
    AppMethodBeat.o(233243);
    return str;
  }
  
  public final void i(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(233249);
    this.oUe = q.E(paramString, paramMap);
    AppMethodBeat.o(233249);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelsns.h
 * JD-Core Version:    0.7.0.1
 */