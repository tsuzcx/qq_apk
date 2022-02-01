package com.tencent.mm.plugin.ipcall.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kj;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;

public final class b
{
  private static c uVU;
  
  static
  {
    AppMethodBeat.i(25337);
    uVU = new c() {};
    AppMethodBeat.o(25337);
  }
  
  public static void init()
  {
    AppMethodBeat.i(25334);
    a.IvT.c(uVU);
    AppMethodBeat.o(25334);
  }
  
  public static void release()
  {
    AppMethodBeat.i(25335);
    a.IvT.d(uVU);
    AppMethodBeat.o(25335);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.b
 * JD-Core Version:    0.7.0.1
 */