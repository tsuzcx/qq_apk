package com.tencent.mm.aa.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.b.b;
import java.util.HashMap;
import java.util.Map;

public final class d
{
  final Map<String, b> hpo;
  
  public d()
  {
    AppMethodBeat.i(144807);
    this.hpo = new HashMap();
    AppMethodBeat.o(144807);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(144808);
    this.hpo.put(paramb.name, paramb);
    AppMethodBeat.o(144808);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aa.c.d
 * JD-Core Version:    0.7.0.1
 */