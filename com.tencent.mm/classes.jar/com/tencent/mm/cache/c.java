package com.tencent.mm.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.h;
import java.util.HashMap;
import java.util.Stack;

public final class c
{
  private static c iTJ;
  private Stack<h> bPH;
  HashMap<String, Stack<h>> map;
  
  static
  {
    AppMethodBeat.i(9210);
    iTJ = new c();
    AppMethodBeat.o(9210);
  }
  
  private c()
  {
    AppMethodBeat.i(9207);
    this.map = new HashMap();
    this.bPH = new Stack();
    AppMethodBeat.o(9207);
  }
  
  public static c arE()
  {
    return iTJ;
  }
  
  public final void Kg(String paramString)
  {
    AppMethodBeat.i(259790);
    if (this.map.containsKey(paramString))
    {
      this.bPH = ((Stack)this.map.get(paramString));
      AppMethodBeat.o(259790);
      return;
    }
    this.map.put(paramString, new Stack());
    AppMethodBeat.o(259790);
  }
  
  public final h arF()
  {
    AppMethodBeat.i(9209);
    if (this.bPH.empty())
    {
      localh = h.fam;
      AppMethodBeat.o(9209);
      return localh;
    }
    h localh = (h)this.bPH.pop();
    AppMethodBeat.o(9209);
    return localh;
  }
  
  public final void b(h paramh)
  {
    AppMethodBeat.i(9208);
    this.bPH.push(paramh);
    AppMethodBeat.o(9208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.cache.c
 * JD-Core Version:    0.7.0.1
 */