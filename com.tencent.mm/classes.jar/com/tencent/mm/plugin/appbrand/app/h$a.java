package com.tencent.mm.plugin.appbrand.app;

import com.tencent.luggage.g.d.a;
import com.tencent.mars.xlog.Xlog;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class h$a
  implements d.a
{
  private final Xlog gTK;
  
  private h$a()
  {
    AppMethodBeat.i(129304);
    this.gTK = new Xlog();
    AppMethodBeat.o(129304);
  }
  
  public final int getLogLevel()
  {
    AppMethodBeat.i(129310);
    int i = this.gTK.getLogLevel();
    AppMethodBeat.o(129310);
    return i;
  }
  
  public final void logD(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString4)
  {
    AppMethodBeat.i(129307);
    this.gTK.logD(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramLong1, paramLong2, paramString4);
    AppMethodBeat.o(129307);
  }
  
  public final void logE(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString4)
  {
    AppMethodBeat.i(129309);
    this.gTK.logE(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramLong1, paramLong2, paramString4);
    AppMethodBeat.o(129309);
  }
  
  public final void logI(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString4)
  {
    AppMethodBeat.i(129306);
    this.gTK.logI(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramLong1, paramLong2, paramString4);
    AppMethodBeat.o(129306);
  }
  
  public final void logV(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString4)
  {
    AppMethodBeat.i(129305);
    this.gTK.logV(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramLong1, paramLong2, paramString4);
    AppMethodBeat.o(129305);
  }
  
  public final void logW(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString4)
  {
    AppMethodBeat.i(129308);
    this.gTK.logW(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramLong1, paramLong2, paramString4);
    AppMethodBeat.o(129308);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.h.a
 * JD-Core Version:    0.7.0.1
 */