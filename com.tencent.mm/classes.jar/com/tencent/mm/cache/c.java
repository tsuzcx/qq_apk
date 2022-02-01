package com.tencent.mm.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.h;
import java.util.HashMap;
import java.util.Stack;

public final class c
{
  private static c gpB;
  private Stack<h> bNI;
  HashMap<String, Stack<h>> map;
  
  static
  {
    AppMethodBeat.i(9210);
    gpB = new c();
    AppMethodBeat.o(9210);
  }
  
  private c()
  {
    AppMethodBeat.i(9207);
    this.map = new HashMap();
    this.bNI = new Stack();
    AppMethodBeat.o(9207);
  }
  
  public static c alF()
  {
    return gpB;
  }
  
  public final void Dp(String paramString)
  {
    AppMethodBeat.i(204749);
    if (this.map.containsKey(paramString))
    {
      this.bNI = ((Stack)this.map.get(paramString));
      AppMethodBeat.o(204749);
      return;
    }
    this.map.put(paramString, new Stack());
    AppMethodBeat.o(204749);
  }
  
  public final h alG()
  {
    AppMethodBeat.i(9209);
    if (this.bNI.empty())
    {
      localh = h.diG;
      AppMethodBeat.o(9209);
      return localh;
    }
    h localh = (h)this.bNI.pop();
    AppMethodBeat.o(9209);
    return localh;
  }
  
  public final void b(h paramh)
  {
    AppMethodBeat.i(9208);
    this.bNI.push(paramh);
    AppMethodBeat.o(9208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.cache.c
 * JD-Core Version:    0.7.0.1
 */