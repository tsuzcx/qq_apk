package com.tencent.mm.plugin.appbrand.collector;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
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
      ad.i("MicroMsg.CostTimeUtil", "print failed, headPoint is null.");
      AppMethodBeat.o(146106);
      return localStringBuilder;
    }
    localStringBuilder.append(0).append(". ").append(paramTimePoint.name).append(" : ");
    localStringBuilder.append(paramTimePoint.jaS);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramTimePoint.jaR.get());
    localStringBuilder.append(", ");
    localStringBuilder.append(paramTimePoint.jaS.get() - paramTimePoint.jaS.get());
    int i = 0;
    TimePoint localTimePoint;
    for (Object localObject = paramTimePoint; ((TimePoint)localObject).jaT.get() != null; localObject = localTimePoint)
    {
      localTimePoint = (TimePoint)((TimePoint)localObject).jaT.get();
      localStringBuilder.append("\n");
      localStringBuilder.append(i + 1).append(". ").append(localTimePoint.name).append(" : ");
      localStringBuilder.append((localTimePoint.jaS.get() - ((TimePoint)localObject).jaS.get()) / 1000000.0D);
      i += 1;
    }
    localStringBuilder.append("\n");
    localStringBuilder.append("total cost : ").append((((TimePoint)localObject).jaS.get() - paramTimePoint.jaS.get()) / 1000000.0D);
    AppMethodBeat.o(146106);
    return localStringBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.collector.e
 * JD-Core Version:    0.7.0.1
 */