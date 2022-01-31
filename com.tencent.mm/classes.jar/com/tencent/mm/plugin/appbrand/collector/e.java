package com.tencent.mm.plugin.appbrand.collector;

import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class e
{
  public static StringBuilder a(TimePoint paramTimePoint)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramTimePoint == null)
    {
      y.i("MicroMsg.CostTimeUtil", "print failed, headPoint is null.");
      return localStringBuilder;
    }
    localStringBuilder.append(0).append(". ").append(paramTimePoint.name).append(" : ");
    localStringBuilder.append(paramTimePoint.fNx);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramTimePoint.fNw.get());
    localStringBuilder.append(", ");
    localStringBuilder.append(paramTimePoint.fNx.get() - paramTimePoint.fNx.get());
    int i = 0;
    TimePoint localTimePoint;
    for (Object localObject = paramTimePoint; ((TimePoint)localObject).fNy.get() != null; localObject = localTimePoint)
    {
      localTimePoint = (TimePoint)((TimePoint)localObject).fNy.get();
      localStringBuilder.append("\n");
      localStringBuilder.append(i + 1).append(". ").append(localTimePoint.name).append(" : ");
      localStringBuilder.append((localTimePoint.fNx.get() - ((TimePoint)localObject).fNx.get()) / 1000000.0D);
      i += 1;
    }
    localStringBuilder.append("\n");
    localStringBuilder.append("total cost : ").append((((TimePoint)localObject).fNx.get() - paramTimePoint.fNx.get()) / 1000000.0D);
    return localStringBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.collector.e
 * JD-Core Version:    0.7.0.1
 */