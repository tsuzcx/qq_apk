package com.tencent.mm.plugin.ai.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.GregorianCalendar;

public final class a
{
  public static int AU(long paramLong)
  {
    AppMethodBeat.i(238897);
    GregorianCalendar localGregorianCalendar = new GregorianCalendar();
    localGregorianCalendar.setTimeInMillis(paramLong);
    int i = localGregorianCalendar.get(11);
    AppMethodBeat.o(238897);
    return i;
  }
  
  public static int AV(long paramLong)
  {
    int i = 7;
    AppMethodBeat.i(238898);
    GregorianCalendar localGregorianCalendar = new GregorianCalendar();
    localGregorianCalendar.setTimeInMillis(paramLong);
    int j = localGregorianCalendar.get(7);
    if (j - 1 <= 0) {}
    for (;;)
    {
      AppMethodBeat.o(238898);
      return i;
      i = j - 1;
    }
  }
  
  public static float a(float paramFloat, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(238900);
    if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length <= 0))
    {
      paramArrayOfFloat = new RuntimeException("calc bucket but bucket is null.");
      AppMethodBeat.o(238900);
      throw paramArrayOfFloat;
    }
    int i = 0;
    while ((i < paramArrayOfFloat.length) && (paramFloat > paramArrayOfFloat[i])) {
      i += 1;
    }
    paramFloat = i * 1.0F / (paramArrayOfFloat.length + 1);
    AppMethodBeat.o(238900);
    return paramFloat;
  }
  
  public static float f(int paramInt, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(238899);
    if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length <= 0))
    {
      paramArrayOfFloat = new RuntimeException("calc bucket but bucket is null.");
      AppMethodBeat.o(238899);
      throw paramArrayOfFloat;
    }
    int i = 0;
    while ((i < paramArrayOfFloat.length) && (paramInt > paramArrayOfFloat[i])) {
      i += 1;
    }
    float f = i * 1.0F / (paramArrayOfFloat.length + 1);
    AppMethodBeat.o(238899);
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.c.a
 * JD-Core Version:    0.7.0.1
 */