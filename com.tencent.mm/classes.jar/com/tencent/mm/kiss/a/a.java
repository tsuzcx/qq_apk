package com.tencent.mm.kiss.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap;

public final class a
{
  private static a gfX;
  public ap mHandler;
  
  static
  {
    AppMethodBeat.i(140995);
    gfX = new a();
    AppMethodBeat.o(140995);
  }
  
  private a()
  {
    AppMethodBeat.i(140994);
    this.mHandler = new ap("InflateThread");
    AppMethodBeat.o(140994);
  }
  
  public static a agz()
  {
    return gfX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.kiss.a.a
 * JD-Core Version:    0.7.0.1
 */