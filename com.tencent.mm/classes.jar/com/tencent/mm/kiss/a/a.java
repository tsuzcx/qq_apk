package com.tencent.mm.kiss.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class a
{
  private static a kfF;
  public MMHandler mHandler;
  
  static
  {
    AppMethodBeat.i(140995);
    kfF = new a();
    AppMethodBeat.o(140995);
  }
  
  private a()
  {
    AppMethodBeat.i(140994);
    this.mHandler = new MMHandler("InflateThread");
    AppMethodBeat.o(140994);
  }
  
  public static a aIJ()
  {
    return kfF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.kiss.a.a
 * JD-Core Version:    0.7.0.1
 */