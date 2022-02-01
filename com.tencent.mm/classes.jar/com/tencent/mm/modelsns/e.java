package com.tencent.mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.a.q;
import com.tencent.mm.protocal.protobuf.bvl;
import java.util.Map;

public final class e
  implements k
{
  public bvl oUc;
  
  public e()
  {
    AppMethodBeat.i(164139);
    this.oUc = new bvl();
    AppMethodBeat.o(164139);
  }
  
  public final String bMC()
  {
    AppMethodBeat.i(164140);
    String str = q.d(this.oUc);
    AppMethodBeat.o(164140);
    return str;
  }
  
  public final void i(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(164141);
    this.oUc = q.C(paramString, paramMap);
    AppMethodBeat.o(164141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelsns.e
 * JD-Core Version:    0.7.0.1
 */