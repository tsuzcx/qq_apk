package com.tencent.mm.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.e;
import java.util.HashMap;
import java.util.Stack;

public final class c
{
  private static c ecv;
  public HashMap<String, Stack<e>> bSA;
  public Stack<e> ecu;
  
  static
  {
    AppMethodBeat.i(146037);
    ecv = new c();
    AppMethodBeat.o(146037);
  }
  
  private c()
  {
    AppMethodBeat.i(146034);
    this.bSA = new HashMap();
    this.ecu = new Stack();
    AppMethodBeat.o(146034);
  }
  
  public static c Jg()
  {
    return ecv;
  }
  
  public final e Jh()
  {
    AppMethodBeat.i(146036);
    if (this.ecu.empty())
    {
      locale = e.bVV;
      AppMethodBeat.o(146036);
      return locale;
    }
    e locale = (e)this.ecu.pop();
    AppMethodBeat.o(146036);
    return locale;
  }
  
  public final void b(e parame)
  {
    AppMethodBeat.i(146035);
    this.ecu.push(parame);
    AppMethodBeat.o(146035);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.cache.c
 * JD-Core Version:    0.7.0.1
 */