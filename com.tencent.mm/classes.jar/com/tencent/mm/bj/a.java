package com.tencent.mm.bj;

import android.content.Context;
import com.tencent.mm.R.l;

public final class a
{
  public static float ck(long paramLong)
  {
    float f1 = 1.0F;
    float f2 = (float)paramLong / 1000.0F;
    if (f2 < 1.0F) {}
    for (;;)
    {
      return Math.round(f1);
      f1 = f2;
    }
  }
  
  public static CharSequence x(Context paramContext, int paramInt)
  {
    if (paramInt <= 0) {
      return paramContext.getString(R.l.favorite_second_format, new Object[] { Integer.valueOf(0), Integer.valueOf(0) });
    }
    int i = paramInt / 60;
    return paramContext.getString(R.l.favorite_second_format, new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt % 60) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.bj.a
 * JD-Core Version:    0.7.0.1
 */