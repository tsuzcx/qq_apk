package com.tencent.mm.kiss.layout;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class a
{
  private static a mGd;
  public MMHandler mHandler;
  
  static
  {
    AppMethodBeat.i(140995);
    mGd = new a();
    AppMethodBeat.o(140995);
  }
  
  private a()
  {
    AppMethodBeat.i(140994);
    this.mHandler = new MMHandler("InflateThread");
    AppMethodBeat.o(140994);
  }
  
  public static a bbF()
  {
    return mGd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.kiss.layout.a
 * JD-Core Version:    0.7.0.1
 */