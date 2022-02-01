package com.tencent.mm.cm.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
{
  public static final float[] Rft = { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  public static final float[] RgD = { 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F };
  public static final float[] RgE = { 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F };
  public static final float[] RgF = { 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F };
  
  public static float[] a(j paramj, boolean paramBoolean)
  {
    AppMethodBeat.i(190284);
    switch (1.RgG[paramj.ordinal()])
    {
    default: 
      paramj = Rft;
      if (paramBoolean)
      {
        float[] arrayOfFloat = new float[8];
        arrayOfFloat[0] = paramj[0];
        arrayOfFloat[1] = cJ(paramj[1]);
        arrayOfFloat[2] = paramj[2];
        arrayOfFloat[3] = cJ(paramj[3]);
        arrayOfFloat[4] = paramj[4];
        arrayOfFloat[5] = cJ(paramj[5]);
        arrayOfFloat[6] = paramj[6];
        arrayOfFloat[7] = cJ(paramj[7]);
        paramj = arrayOfFloat;
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(190284);
      return paramj;
      paramj = RgD;
      break;
      paramj = RgE;
      break;
      paramj = RgF;
      break;
    }
  }
  
  private static float cJ(float paramFloat)
  {
    float f = 0.0F;
    if (paramFloat == 0.0F) {
      f = 1.0F;
    }
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.cm.a.l
 * JD-Core Version:    0.7.0.1
 */