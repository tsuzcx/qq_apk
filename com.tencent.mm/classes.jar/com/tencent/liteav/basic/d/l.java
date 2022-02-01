package com.tencent.liteav.basic.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class l
{
  public static final float[] a = { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  public static final float[] b = { 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F };
  public static final float[] c = { 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F };
  public static final float[] d = { 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F };
  public static final float[] e = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  
  private static float a(float paramFloat)
  {
    float f = 0.0F;
    if (paramFloat == 0.0F) {
      f = 1.0F;
    }
    return f;
  }
  
  public static float[] a(k paramk, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(187328);
    float[] arrayOfFloat;
    switch (1.a[paramk.ordinal()])
    {
    default: 
      paramk = (float[])a.clone();
      if (paramBoolean1)
      {
        arrayOfFloat = new float[8];
        arrayOfFloat[0] = a(paramk[0]);
        arrayOfFloat[1] = paramk[1];
        arrayOfFloat[2] = a(paramk[2]);
        arrayOfFloat[3] = paramk[3];
        arrayOfFloat[4] = a(paramk[4]);
        arrayOfFloat[5] = paramk[5];
        arrayOfFloat[6] = a(paramk[6]);
        arrayOfFloat[7] = paramk[7];
        paramk = arrayOfFloat;
      }
      break;
    }
    for (;;)
    {
      if (paramBoolean2)
      {
        arrayOfFloat = new float[8];
        arrayOfFloat[0] = paramk[0];
        arrayOfFloat[1] = a(paramk[1]);
        arrayOfFloat[2] = paramk[2];
        arrayOfFloat[3] = a(paramk[3]);
        arrayOfFloat[4] = paramk[4];
        arrayOfFloat[5] = a(paramk[5]);
        arrayOfFloat[6] = paramk[6];
        arrayOfFloat[7] = a(paramk[7]);
        paramk = arrayOfFloat;
      }
      for (;;)
      {
        AppMethodBeat.o(187328);
        return paramk;
        paramk = (float[])b.clone();
        break;
        paramk = (float[])c.clone();
        break;
        paramk = (float[])d.clone();
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.d.l
 * JD-Core Version:    0.7.0.1
 */