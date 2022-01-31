package com.tencent.mm.bk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static CharSequence C(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(16634);
    if (paramInt <= 0)
    {
      paramContext = paramContext.getString(2131299821, new Object[] { Integer.valueOf(0), Integer.valueOf(0) });
      AppMethodBeat.o(16634);
      return paramContext;
    }
    paramContext = paramContext.getString(2131299821, new Object[] { Integer.valueOf(paramInt / 60), Integer.valueOf(paramInt % 60) });
    AppMethodBeat.o(16634);
    return paramContext;
  }
  
  public static float hi(long paramLong)
  {
    float f1 = 1.0F;
    AppMethodBeat.i(16633);
    float f2 = (float)paramLong / 1000.0F;
    if (f2 < 1.0F) {}
    for (;;)
    {
      f1 = Math.round(f1);
      AppMethodBeat.o(16633);
      return f1;
      f1 = f2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.bk.a
 * JD-Core Version:    0.7.0.1
 */