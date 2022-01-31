package com.tencent.mm.plugin.appbrand.collector;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class f
{
  private static final AtomicInteger fNs = new AtomicInteger();
  private static final AtomicLong fNt = new AtomicLong();
  private static boolean fNu;
  
  public static boolean adT()
  {
    return fNu;
  }
  
  public static String adU()
  {
    float f2 = 0.0F;
    int i = fNs.get();
    long l1 = fNt.get();
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("fps : ");
    int j = fNs.get();
    long l2 = fNt.get();
    if ((!fNu) || (l2 <= 0L))
    {
      f1 = 0.0F;
      localStringBuilder2.append(f1);
      localStringBuilder1.append("\ncount : ").append(i);
      localStringBuilder2 = localStringBuilder1.append("\naverage cost : ");
      if (i > 0) {
        break label125;
      }
    }
    label125:
    for (float f1 = f2;; f1 = 1.0F * (float)l1 / i)
    {
      localStringBuilder2.append(f1);
      return localStringBuilder1.toString();
      f1 = j * 1000.0F / (float)l2;
      break;
    }
  }
  
  public static void cL(boolean paramBoolean)
  {
    fNu = paramBoolean;
  }
  
  public static void reset()
  {
    fNs.set(0);
    fNt.set(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.collector.f
 * JD-Core Version:    0.7.0.1
 */