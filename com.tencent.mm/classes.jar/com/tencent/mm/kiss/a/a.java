package com.tencent.mm.kiss.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aq;

public final class a
{
  private static a gGU;
  public aq mHandler;
  
  static
  {
    AppMethodBeat.i(140995);
    gGU = new a();
    AppMethodBeat.o(140995);
  }
  
  private a()
  {
    AppMethodBeat.i(140994);
    this.mHandler = new aq("InflateThread");
    AppMethodBeat.o(140994);
  }
  
  public static a akQ()
  {
    return gGU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.kiss.a.a
 * JD-Core Version:    0.7.0.1
 */