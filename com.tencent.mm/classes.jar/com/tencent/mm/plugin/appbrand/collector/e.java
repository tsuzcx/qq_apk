package com.tencent.mm.plugin.appbrand.collector;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class e
{
  public static StringBuilder a(TimePoint paramTimePoint)
  {
    AppMethodBeat.i(146106);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramTimePoint == null)
    {
      ae.i("MicroMsg.CostTimeUtil", "print failed, headPoint is null.");
      AppMethodBeat.o(146106);
      return localStringBuilder;
    }
    localStringBuilder.append(0).append(". ").append(paramTimePoint.name).append(" : ");
    localStringBuilder.append(paramTimePoint.jYr);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramTimePoint.jYq.get());
    localStringBuilder.append(", ");
    localStringBuilder.append(paramTimePoint.jYr.get() - paramTimePoint.jYr.get());
    int i = 0;
    TimePoint localTimePoint;
    for (Object localObject = paramTimePoint; ((TimePoint)localObject).jYs.get() != null; localObject = localTimePoint)
    {
      localTimePoint = (TimePoint)((TimePoint)localObject).jYs.get();
      localStringBuilder.append("\n");
      localStringBuilder.append(i + 1).append(". ").append(localTimePoint.name).append(" : ");
      localStringBuilder.append((localTimePoint.jYr.get() - ((TimePoint)localObject).jYr.get()) / 1000000.0D);
      i += 1;
    }
    localStringBuilder.append("\n");
    localStringBuilder.append("total cost : ").append((((TimePoint)localObject).jYr.get() - paramTimePoint.jYr.get()) / 1000000.0D);
    AppMethodBeat.o(146106);
    return localStringBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.collector.e
 * JD-Core Version:    0.7.0.1
 */