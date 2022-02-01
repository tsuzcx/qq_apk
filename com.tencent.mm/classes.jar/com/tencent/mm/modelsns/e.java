package com.tencent.mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.i.a.l;
import com.tencent.mm.protocal.protobuf.bcj;
import java.util.Map;

public final class e
  implements j
{
  public bcj jlg;
  
  public e()
  {
    AppMethodBeat.i(164139);
    this.jlg = new bcj();
    AppMethodBeat.o(164139);
  }
  
  public final String bfF()
  {
    AppMethodBeat.i(164140);
    String str = l.b(this.jlg);
    AppMethodBeat.o(164140);
    return str;
  }
  
  public final void j(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(164141);
    this.jlg = l.x(paramString, paramMap);
    AppMethodBeat.o(164141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsns.e
 * JD-Core Version:    0.7.0.1
 */