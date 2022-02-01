package com.tencent.mm.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.g;
import java.util.HashMap;
import java.util.Stack;

public final class c
{
  private static c fKn;
  HashMap<String, Stack<g>> cEm;
  private Stack<g> fKm;
  
  static
  {
    AppMethodBeat.i(9210);
    fKn = new c();
    AppMethodBeat.o(9210);
  }
  
  private c()
  {
    AppMethodBeat.i(9207);
    this.cEm = new HashMap();
    this.fKm = new Stack();
    AppMethodBeat.o(9207);
  }
  
  public static c XS()
  {
    return fKn;
  }
  
  public final g XT()
  {
    AppMethodBeat.i(9209);
    if (this.fKm.empty())
    {
      localg = g.cSm;
      AppMethodBeat.o(9209);
      return localg;
    }
    g localg = (g)this.fKm.pop();
    AppMethodBeat.o(9209);
    return localg;
  }
  
  public final void b(g paramg)
  {
    AppMethodBeat.i(9208);
    this.fKm.push(paramg);
    AppMethodBeat.o(9208);
  }
  
  public final void uZ(String paramString)
  {
    AppMethodBeat.i(195425);
    if (this.cEm.containsKey(paramString))
    {
      this.fKm = ((Stack)this.cEm.get(paramString));
      AppMethodBeat.o(195425);
      return;
    }
    this.cEm.put(paramString, new Stack());
    AppMethodBeat.o(195425);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.cache.c
 * JD-Core Version:    0.7.0.1
 */