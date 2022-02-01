package com.tencent.mm.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.g;
import java.util.HashMap;
import java.util.Stack;

public final class c
{
  private static c fmH;
  HashMap<String, Stack<g>> cvB;
  private Stack<g> fmG;
  
  static
  {
    AppMethodBeat.i(9210);
    fmH = new c();
    AppMethodBeat.o(9210);
  }
  
  private c()
  {
    AppMethodBeat.i(9207);
    this.cvB = new HashMap();
    this.fmG = new Stack();
    AppMethodBeat.o(9207);
  }
  
  public static c Uw()
  {
    return fmH;
  }
  
  public final g Ux()
  {
    AppMethodBeat.i(9209);
    if (this.fmG.empty())
    {
      localg = g.cJr;
      AppMethodBeat.o(9209);
      return localg;
    }
    g localg = (g)this.fmG.pop();
    AppMethodBeat.o(9209);
    return localg;
  }
  
  public final void aTT(String paramString)
  {
    AppMethodBeat.i(205056);
    if (this.cvB.containsKey(paramString))
    {
      this.fmG = ((Stack)this.cvB.get(paramString));
      AppMethodBeat.o(205056);
      return;
    }
    this.cvB.put(paramString, new Stack());
    AppMethodBeat.o(205056);
  }
  
  public final void b(g paramg)
  {
    AppMethodBeat.i(9208);
    this.fmG.push(paramg);
    AppMethodBeat.o(9208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.cache.c
 * JD-Core Version:    0.7.0.1
 */