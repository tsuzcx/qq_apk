package com.tencent.mm.gpu.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a
{
  public static final String jUS;
  public static final String jUT;
  public static final String jUU;
  public static final String jUV;
  
  static
  {
    AppMethodBeat.i(210716);
    jUS = MMApplicationContext.getPackageName();
    jUT = MMApplicationContext.getPackageName() + ":appbrand";
    jUU = MMApplicationContext.getPackageName() + ":tools";
    jUV = MMApplicationContext.getPackageName() + ":toolsmp";
    AppMethodBeat.o(210716);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.gpu.b.a
 * JD-Core Version:    0.7.0.1
 */