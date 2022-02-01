package com.tencent.mm.plugin.appbrand.jsapi.video.progressbar;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static int c(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(211398);
    int i = m(paramInt2, paramFloat1 / paramFloat2) + paramInt1;
    if (i < 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      AppMethodBeat.o(211398);
      return paramInt1;
      paramInt1 = paramInt2;
      if (i <= paramInt2) {
        paramInt1 = i;
      }
    }
  }
  
  private static int m(int paramInt, float paramFloat)
  {
    int i = paramInt;
    if (paramInt > 180)
    {
      if (paramInt > 600) {
        break label26;
      }
      i = 180;
    }
    for (;;)
    {
      return (int)(i * paramFloat);
      label26:
      if (paramInt <= 1800) {
        i = 300;
      } else {
        i = 600;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.a
 * JD-Core Version:    0.7.0.1
 */