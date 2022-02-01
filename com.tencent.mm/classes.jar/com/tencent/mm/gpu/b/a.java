package com.tencent.mm.gpu.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a
{
  public static final String mvg;
  public static final String mvh;
  public static final String mvi;
  public static final String mvj;
  
  static
  {
    AppMethodBeat.i(231749);
    mvg = MMApplicationContext.getPackageName();
    mvh = MMApplicationContext.getPackageName() + ":appbrand";
    mvi = MMApplicationContext.getPackageName() + ":tools";
    mvj = MMApplicationContext.getPackageName() + ":toolsmp";
    AppMethodBeat.o(231749);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.gpu.b.a
 * JD-Core Version:    0.7.0.1
 */