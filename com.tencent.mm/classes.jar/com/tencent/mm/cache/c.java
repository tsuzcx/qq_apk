package com.tencent.mm.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.g;
import java.util.HashMap;
import java.util.Stack;

public final class c
{
  private static c fqc;
  HashMap<String, Stack<g>> csJ;
  private Stack<g> fqb;
  
  static
  {
    AppMethodBeat.i(9210);
    fqc = new c();
    AppMethodBeat.o(9210);
  }
  
  private c()
  {
    AppMethodBeat.i(9207);
    this.csJ = new HashMap();
    this.fqb = new Stack();
    AppMethodBeat.o(9207);
  }
  
  public static c Vr()
  {
    return fqc;
  }
  
  public final g Vs()
  {
    AppMethodBeat.i(9209);
    if (this.fqb.empty())
    {
      localg = g.cGy;
      AppMethodBeat.o(9209);
      return localg;
    }
    g localg = (g)this.fqb.pop();
    AppMethodBeat.o(9209);
    return localg;
  }
  
  public final void b(g paramg)
  {
    AppMethodBeat.i(9208);
    this.fqb.push(paramg);
    AppMethodBeat.o(9208);
  }
  
  public final void rR(String paramString)
  {
    AppMethodBeat.i(199928);
    if (this.csJ.containsKey(paramString))
    {
      this.fqb = ((Stack)this.csJ.get(paramString));
      AppMethodBeat.o(199928);
      return;
    }
    this.csJ.put(paramString, new Stack());
    AppMethodBeat.o(199928);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.cache.c
 * JD-Core Version:    0.7.0.1
 */