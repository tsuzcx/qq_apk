package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.g.f;
import com.google.android.exoplayer2.h.s.e;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
{
  public static boolean a(f paramf, int paramInt, Exception paramException)
  {
    AppMethodBeat.i(92579);
    if (f(paramException))
    {
      boolean bool = paramf.fg(paramInt);
      int i = ((s.e)paramException).responseCode;
      if (bool) {
        new StringBuilder("Blacklisted: duration=60000, responseCode=").append(i).append(", format=").append(paramf.fe(paramInt));
      }
      for (;;)
      {
        AppMethodBeat.o(92579);
        return bool;
        new StringBuilder("Blacklisting failed (cannot blacklist last enabled track): responseCode=").append(i).append(", format=").append(paramf.fe(paramInt));
      }
    }
    AppMethodBeat.o(92579);
    return false;
  }
  
  public static boolean f(Exception paramException)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramException instanceof s.e))
    {
      int i = ((s.e)paramException).responseCode;
      if (i != 404)
      {
        bool1 = bool2;
        if (i != 410) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.a.h
 * JD-Core Version:    0.7.0.1
 */