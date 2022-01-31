package com.tencent.mm.plugin.appbrand.collector;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class f
{
  private static final AtomicInteger hgC;
  private static final AtomicLong hgD;
  private static boolean hgE;
  
  static
  {
    AppMethodBeat.i(57044);
    hgC = new AtomicInteger();
    hgD = new AtomicLong();
    AppMethodBeat.o(57044);
  }
  
  public static boolean ayl()
  {
    return hgE;
  }
  
  public static String aym()
  {
    float f2 = 0.0F;
    AppMethodBeat.i(57043);
    int i = hgC.get();
    long l1 = hgD.get();
    Object localObject = new StringBuilder();
    StringBuilder localStringBuilder = ((StringBuilder)localObject).append("fps : ");
    int j = hgC.get();
    long l2 = hgD.get();
    if ((!hgE) || (l2 <= 0L))
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
      AppMethodBeat.o(57043);
      return localObject;
      f1 = j * 1000.0F / (float)l2;
      break;
    }
  }
  
  public static void dP(boolean paramBoolean)
  {
    hgE = paramBoolean;
  }
  
  public static void reset()
  {
    AppMethodBeat.i(57042);
    hgC.set(0);
    hgD.set(0L);
    AppMethodBeat.o(57042);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.collector.f
 * JD-Core Version:    0.7.0.1
 */