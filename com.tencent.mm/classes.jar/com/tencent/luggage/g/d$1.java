package com.tencent.luggage.g;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$1
  implements d.a
{
  private Handler handler;
  
  d$1()
  {
    AppMethodBeat.i(90875);
    this.handler = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(90875);
  }
  
  public final int getLogLevel()
  {
    AppMethodBeat.i(90881);
    int i = d.access$000();
    AppMethodBeat.o(90881);
    return i;
  }
  
  public final void logD(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString4)
  {
    AppMethodBeat.i(90878);
    d.access$000();
    AppMethodBeat.o(90878);
  }
  
  public final void logE(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString4)
  {
    AppMethodBeat.i(90880);
    d.access$000();
    AppMethodBeat.o(90880);
  }
  
  public final void logI(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString4)
  {
    AppMethodBeat.i(90877);
    d.access$000();
    AppMethodBeat.o(90877);
  }
  
  public final void logV(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString4)
  {
    AppMethodBeat.i(90876);
    d.access$000();
    AppMethodBeat.o(90876);
  }
  
  public final void logW(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString4)
  {
    AppMethodBeat.i(90879);
    d.access$000();
    AppMethodBeat.o(90879);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.g.d.1
 * JD-Core Version:    0.7.0.1
 */