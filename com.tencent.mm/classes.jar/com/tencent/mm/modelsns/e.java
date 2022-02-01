package com.tencent.mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bje;
import java.util.Map;

public final class e
  implements k
{
  public bje mbi;
  
  public e()
  {
    AppMethodBeat.i(164139);
    this.mbi = new bje();
    AppMethodBeat.o(164139);
  }
  
  public final String boV()
  {
    AppMethodBeat.i(164140);
    String str = com.tencent.mm.plugin.findersdk.a.k.b(this.mbi);
    AppMethodBeat.o(164140);
    return str;
  }
  
  public final void i(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(164141);
    this.mbi = com.tencent.mm.plugin.findersdk.a.k.w(paramString, paramMap);
    AppMethodBeat.o(164141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsns.e
 * JD-Core Version:    0.7.0.1
 */