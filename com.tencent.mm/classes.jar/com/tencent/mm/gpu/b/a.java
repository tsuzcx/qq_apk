package com.tencent.mm.gpu.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a
{
  public static final String hiY;
  public static final String hiZ;
  public static final String hja;
  public static final String hjb;
  
  static
  {
    AppMethodBeat.i(186151);
    hiY = MMApplicationContext.getPackageName();
    hiZ = MMApplicationContext.getPackageName() + ":appbrand";
    hja = MMApplicationContext.getPackageName() + ":tools";
    hjb = MMApplicationContext.getPackageName() + ":toolsmp";
    AppMethodBeat.o(186151);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.gpu.b.a
 * JD-Core Version:    0.7.0.1
 */