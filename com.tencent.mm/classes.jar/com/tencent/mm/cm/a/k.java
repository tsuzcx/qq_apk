package com.tencent.mm.cm.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
{
  public static final float[] Qfk = { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  public static final float[] agDc = { 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F };
  public static final float[] agDd = { 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F };
  public static final float[] agDe = { 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F };
  
  public static float[] a(i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(231108);
    switch (1.agDf[parami.ordinal()])
    {
    default: 
      parami = Qfk;
      if (paramBoolean)
      {
        float[] arrayOfFloat = new float[8];
        arrayOfFloat[0] = parami[0];
        arrayOfFloat[1] = et(parami[1]);
        arrayOfFloat[2] = parami[2];
        arrayOfFloat[3] = et(parami[3]);
        arrayOfFloat[4] = parami[4];
        arrayOfFloat[5] = et(parami[5]);
        arrayOfFloat[6] = parami[6];
        arrayOfFloat[7] = et(parami[7]);
        parami = arrayOfFloat;
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(231108);
      return parami;
      parami = agDc;
      break;
      parami = agDd;
      break;
      parami = agDe;
      break;
    }
  }
  
  private static float et(float paramFloat)
  {
    float f = 0.0F;
    if (paramFloat == 0.0F) {
      f = 1.0F;
    }
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.cm.a.k
 * JD-Core Version:    0.7.0.1
 */