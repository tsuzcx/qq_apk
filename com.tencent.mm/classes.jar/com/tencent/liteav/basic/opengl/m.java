package com.tencent.liteav.basic.opengl;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class m
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
  
  public static float[] a(l paraml, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(236605);
    float[] arrayOfFloat;
    switch (1.a[paraml.ordinal()])
    {
    default: 
      paraml = (float[])a.clone();
      if (paramBoolean1)
      {
        arrayOfFloat = new float[8];
        arrayOfFloat[0] = a(paraml[0]);
        arrayOfFloat[1] = paraml[1];
        arrayOfFloat[2] = a(paraml[2]);
        arrayOfFloat[3] = paraml[3];
        arrayOfFloat[4] = a(paraml[4]);
        arrayOfFloat[5] = paraml[5];
        arrayOfFloat[6] = a(paraml[6]);
        arrayOfFloat[7] = paraml[7];
        paraml = arrayOfFloat;
      }
      break;
    }
    for (;;)
    {
      if (paramBoolean2)
      {
        arrayOfFloat = new float[8];
        arrayOfFloat[0] = paraml[0];
        arrayOfFloat[1] = a(paraml[1]);
        arrayOfFloat[2] = paraml[2];
        arrayOfFloat[3] = a(paraml[3]);
        arrayOfFloat[4] = paraml[4];
        arrayOfFloat[5] = a(paraml[5]);
        arrayOfFloat[6] = paraml[6];
        arrayOfFloat[7] = a(paraml[7]);
        paraml = arrayOfFloat;
      }
      for (;;)
      {
        AppMethodBeat.o(236605);
        return paraml;
        paraml = (float[])b.clone();
        break;
        paraml = (float[])c.clone();
        break;
        paraml = (float[])d.clone();
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.opengl.m
 * JD-Core Version:    0.7.0.1
 */