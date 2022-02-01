package com.tencent.mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.i.a.e;
import com.tencent.mm.protocal.protobuf.ary;
import java.util.Map;

public final class b
{
  public ary ipW;
  
  public b()
  {
    AppMethodBeat.i(164139);
    this.ipW = new ary();
    AppMethodBeat.o(164139);
  }
  
  public final String aLC()
  {
    AppMethodBeat.i(164140);
    String str = e.b(this.ipW);
    AppMethodBeat.o(164140);
    return str;
  }
  
  public final void j(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(164141);
    this.ipW = e.w(paramString, paramMap);
    AppMethodBeat.o(164141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsns.b
 * JD-Core Version:    0.7.0.1
 */