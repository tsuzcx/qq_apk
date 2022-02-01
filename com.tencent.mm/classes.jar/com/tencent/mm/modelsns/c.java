package com.tencent.mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.a.q;
import com.tencent.mm.protocal.protobuf.bvh;
import java.util.Map;

public final class c
  implements k
{
  public bvh oUa;
  
  public c()
  {
    AppMethodBeat.i(233232);
    this.oUa = new bvh();
    AppMethodBeat.o(233232);
  }
  
  public final String bMC()
  {
    AppMethodBeat.i(233239);
    String str = q.a(this.oUa);
    AppMethodBeat.o(233239);
    return str;
  }
  
  public final void i(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(233248);
    this.oUa = q.H(paramString, paramMap);
    AppMethodBeat.o(233248);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelsns.c
 * JD-Core Version:    0.7.0.1
 */