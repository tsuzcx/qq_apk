package com.tencent.mm.gpu.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ai;

public final class a
{
  public static final String gae;
  public static final String gaf;
  public static final String gag;
  public static final String gah;
  
  static
  {
    AppMethodBeat.i(209394);
    gae = ai.getPackageName();
    gaf = ai.getPackageName() + ":appbrand";
    gag = ai.getPackageName() + ":tools";
    gah = ai.getPackageName() + ":toolsmp";
    AppMethodBeat.o(209394);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.gpu.b.a
 * JD-Core Version:    0.7.0.1
 */