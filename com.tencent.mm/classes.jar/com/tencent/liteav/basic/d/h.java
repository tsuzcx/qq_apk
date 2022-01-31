package com.tencent.liteav.basic.d;

public class h
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
  
  public static float[] a(g paramg, boolean paramBoolean1, boolean paramBoolean2)
  {
    switch (h.1.a[paramg.ordinal()])
    {
    default: 
      paramg = (float[])a.clone();
      if (paramBoolean1)
      {
        float[] arrayOfFloat = new float[8];
        arrayOfFloat[0] = a(paramg[0]);
        arrayOfFloat[1] = paramg[1];
        arrayOfFloat[2] = a(paramg[2]);
        arrayOfFloat[3] = paramg[3];
        arrayOfFloat[4] = a(paramg[4]);
        arrayOfFloat[5] = paramg[5];
        arrayOfFloat[6] = a(paramg[6]);
        arrayOfFloat[7] = paramg[7];
        paramg = arrayOfFloat;
      }
      break;
    }
    for (;;)
    {
      if (paramBoolean2)
      {
        return new float[] { paramg[0], a(paramg[1]), paramg[2], a(paramg[3]), paramg[4], a(paramg[5]), paramg[6], a(paramg[7]) };
        paramg = (float[])b.clone();
        break;
        paramg = (float[])c.clone();
        break;
        paramg = (float[])d.clone();
        break;
      }
      return paramg;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.liteav.basic.d.h
 * JD-Core Version:    0.7.0.1
 */