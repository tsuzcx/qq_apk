package com.tencent.mm.plugin.appbrand.collector;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class f
{
  private static final AtomicInteger jUV;
  private static final AtomicLong jUW;
  private static boolean jUX;
  
  static
  {
    AppMethodBeat.i(146109);
    jUV = new AtomicInteger();
    jUW = new AtomicLong();
    AppMethodBeat.o(146109);
  }
  
  public static boolean bdD()
  {
    return jUX;
  }
  
  public static String bdE()
  {
    float f2 = 0.0F;
    AppMethodBeat.i(146108);
    int i = jUV.get();
    long l1 = jUW.get();
    Object localObject = new StringBuilder();
    StringBuilder localStringBuilder = ((StringBuilder)localObject).append("fps : ");
    int j = jUV.get();
    long l2 = jUW.get();
    if ((!jUX) || (l2 <= 0L))
    {
      f1 = 0.0F;
      localStringBuilder.append(f1);
      ((StringBuilder)localObject).append("\ncount : ").append(i);
      localStringBuilder = ((StringBuilder)localObject).append("\naverage cost : ");
      if (i > 0) {
        break label139;
      }
    }
    label139:
    for (float f1 = f2;; f1 = 1.0F * (float)l1 / i)
    {
      localStringBuilder.append(f1);
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(146108);
      return localObject;
      f1 = j * 1000.0F / (float)l2;
      break;
    }
  }
  
  public static void fY(boolean paramBoolean)
  {
    jUX = paramBoolean;
  }
  
  public static void reset()
  {
    AppMethodBeat.i(146107);
    jUV.set(0);
    jUW.set(0L);
    AppMethodBeat.o(146107);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.collector.f
 * JD-Core Version:    0.7.0.1
 */