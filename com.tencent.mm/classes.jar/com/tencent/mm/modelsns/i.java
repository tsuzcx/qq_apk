package com.tencent.mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.i.a.ak;
import com.tencent.mm.protocal.protobuf.css;
import java.util.Map;

public final class i
  implements j
{
  public css jlj;
  
  public i()
  {
    AppMethodBeat.i(192735);
    this.jlj = new css();
    AppMethodBeat.o(192735);
  }
  
  public final String bfF()
  {
    AppMethodBeat.i(192736);
    String str = ak.a(this.jlj);
    AppMethodBeat.o(192736);
    return str;
  }
  
  public final void j(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(192737);
    this.jlj = ak.C(paramString, paramMap);
    AppMethodBeat.o(192737);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsns.i
 * JD-Core Version:    0.7.0.1
 */