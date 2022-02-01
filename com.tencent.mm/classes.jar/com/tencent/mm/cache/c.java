package com.tencent.mm.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.g;
import java.util.HashMap;
import java.util.Stack;

public final class c
{
  private static c fIj;
  HashMap<String, Stack<g>> cDF;
  private Stack<g> fIi;
  
  static
  {
    AppMethodBeat.i(9210);
    fIj = new c();
    AppMethodBeat.o(9210);
  }
  
  private c()
  {
    AppMethodBeat.i(9207);
    this.cDF = new HashMap();
    this.fIi = new Stack();
    AppMethodBeat.o(9207);
  }
  
  public static c XI()
  {
    return fIj;
  }
  
  public final g XJ()
  {
    AppMethodBeat.i(9209);
    if (this.fIi.empty())
    {
      localg = g.cRC;
      AppMethodBeat.o(9209);
      return localg;
    }
    g localg = (g)this.fIi.pop();
    AppMethodBeat.o(9209);
    return localg;
  }
  
  public final void b(g paramg)
  {
    AppMethodBeat.i(9208);
    this.fIi.push(paramg);
    AppMethodBeat.o(9208);
  }
  
  public final void uE(String paramString)
  {
    AppMethodBeat.i(221099);
    if (this.cDF.containsKey(paramString))
    {
      this.fIi = ((Stack)this.cDF.get(paramString));
      AppMethodBeat.o(221099);
      return;
    }
    this.cDF.put(paramString, new Stack());
    AppMethodBeat.o(221099);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.cache.c
 * JD-Core Version:    0.7.0.1
 */