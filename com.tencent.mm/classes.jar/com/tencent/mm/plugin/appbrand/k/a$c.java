package com.tencent.mm.plugin.appbrand.k;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class a$c
  implements a
{
  public final String DI(String paramString)
  {
    return "__APP__";
  }
  
  public final void a(String paramString, boolean paramBoolean, a.b paramb)
  {
    AppMethodBeat.i(87004);
    a(paramString, paramBoolean, paramb, null);
    AppMethodBeat.o(87004);
  }
  
  public void a(String paramString, boolean paramBoolean, a.b paramb, a.a parama)
  {
    AppMethodBeat.i(87003);
    if (paramb != null) {
      paramb.a(a.d.irN);
    }
    AppMethodBeat.o(87003);
  }
  
  public final boolean aIe()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.k.a.c
 * JD-Core Version:    0.7.0.1
 */