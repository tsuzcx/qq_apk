package com.tencent.mm.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.i;
import java.util.HashMap;
import java.util.Stack;

public final class c
{
  private static c lvP;
  private Stack<i> dJz;
  HashMap<String, Stack<i>> map;
  
  static
  {
    AppMethodBeat.i(9210);
    lvP = new c();
    AppMethodBeat.o(9210);
  }
  
  private c()
  {
    AppMethodBeat.i(9207);
    this.map = new HashMap();
    this.dJz = new Stack();
    AppMethodBeat.o(9207);
  }
  
  public static c aLA()
  {
    return lvP;
  }
  
  public final void CM(String paramString)
  {
    AppMethodBeat.i(232031);
    if (this.map.containsKey(paramString))
    {
      this.dJz = ((Stack)this.map.get(paramString));
      AppMethodBeat.o(232031);
      return;
    }
    this.map.put(paramString, new Stack());
    AppMethodBeat.o(232031);
  }
  
  public final i aLB()
  {
    AppMethodBeat.i(9209);
    if (this.dJz.empty())
    {
      locali = i.hdN;
      AppMethodBeat.o(9209);
      return locali;
    }
    i locali = (i)this.dJz.pop();
    AppMethodBeat.o(9209);
    return locali;
  }
  
  public final void b(i parami)
  {
    AppMethodBeat.i(9208);
    this.dJz.push(parami);
    AppMethodBeat.o(9208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.cache.c
 * JD-Core Version:    0.7.0.1
 */