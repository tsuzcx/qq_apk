package com.tencent.mm.kiss.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ao;

public final class a
{
  private static a gkD;
  public ao mHandler;
  
  static
  {
    AppMethodBeat.i(140995);
    gkD = new a();
    AppMethodBeat.o(140995);
  }
  
  private a()
  {
    AppMethodBeat.i(140994);
    this.mHandler = new ao("InflateThread");
    AppMethodBeat.o(140994);
  }
  
  public static a ahQ()
  {
    return gkD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.kiss.a.a
 * JD-Core Version:    0.7.0.1
 */