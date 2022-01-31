package com.tencent.mm.plugin.ipcall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;

public final class b
{
  private static c nLS;
  
  static
  {
    AppMethodBeat.i(21715);
    nLS = new b.1();
    AppMethodBeat.o(21715);
  }
  
  public static void init()
  {
    AppMethodBeat.i(21712);
    a.ymk.c(nLS);
    AppMethodBeat.o(21712);
  }
  
  public static void release()
  {
    AppMethodBeat.i(21713);
    a.ymk.d(nLS);
    AppMethodBeat.o(21713);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.b
 * JD-Core Version:    0.7.0.1
 */