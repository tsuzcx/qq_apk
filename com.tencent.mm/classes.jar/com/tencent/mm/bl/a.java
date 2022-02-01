package com.tencent.mm.bl;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static float AO(long paramLong)
  {
    float f1 = 1.0F;
    AppMethodBeat.i(20676);
    float f2 = (float)paramLong / 1000.0F;
    if (f2 < 1.0F) {}
    for (;;)
    {
      f1 = Math.round(f1);
      AppMethodBeat.o(20676);
      return f1;
      f1 = f2;
    }
  }
  
  public static CharSequence J(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(20677);
    if (paramInt <= 0)
    {
      paramContext = paramContext.getString(2131759321, new Object[] { Integer.valueOf(0), Integer.valueOf(0) });
      AppMethodBeat.o(20677);
      return paramContext;
    }
    paramContext = paramContext.getString(2131759321, new Object[] { Integer.valueOf(paramInt / 60), Integer.valueOf(paramInt % 60) });
    AppMethodBeat.o(20677);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.bl.a
 * JD-Core Version:    0.7.0.1
 */