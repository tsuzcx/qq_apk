package com.tencent.mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.i.a.l;
import com.tencent.mm.protocal.protobuf.col;
import java.util.Map;

public final class g
  implements j
{
  public col jlh;
  
  public g()
  {
    AppMethodBeat.i(192727);
    this.jlh = new col();
    AppMethodBeat.o(192727);
  }
  
  public final String bfF()
  {
    AppMethodBeat.i(192728);
    String str = l.a(this.jlh);
    AppMethodBeat.o(192728);
    return str;
  }
  
  public final void j(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(192729);
    this.jlh = l.y(paramString, paramMap);
    AppMethodBeat.o(192729);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsns.g
 * JD-Core Version:    0.7.0.1
 */