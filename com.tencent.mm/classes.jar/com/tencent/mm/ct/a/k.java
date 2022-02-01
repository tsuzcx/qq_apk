package com.tencent.mm.ct.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
{
  public static final float[] YGn = { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  public static final float[] YHx = { 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F };
  public static final float[] YHy = { 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F };
  public static final float[] YHz = { 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F };
  
  public static float[] a(i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(188218);
    switch (1.YHA[parami.ordinal()])
    {
    default: 
      parami = YGn;
      if (paramBoolean)
      {
        float[] arrayOfFloat = new float[8];
        arrayOfFloat[0] = parami[0];
        arrayOfFloat[1] = de(parami[1]);
        arrayOfFloat[2] = parami[2];
        arrayOfFloat[3] = de(parami[3]);
        arrayOfFloat[4] = parami[4];
        arrayOfFloat[5] = de(parami[5]);
        arrayOfFloat[6] = parami[6];
        arrayOfFloat[7] = de(parami[7]);
        parami = arrayOfFloat;
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(188218);
      return parami;
      parami = YHx;
      break;
      parami = YHy;
      break;
      parami = YHz;
      break;
    }
  }
  
  private static float de(float paramFloat)
  {
    float f = 0.0F;
    if (paramFloat == 0.0F) {
      f = 1.0F;
    }
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ct.a.k
 * JD-Core Version:    0.7.0.1
 */