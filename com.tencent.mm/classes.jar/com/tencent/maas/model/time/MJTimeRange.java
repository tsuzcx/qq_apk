package com.tencent.maas.model.time;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class MJTimeRange
  implements Cloneable
{
  public static final MJTimeRange InvalidTimeRange;
  public static final MJTimeRange PositiveInfiniteTimeRange;
  public static final MJTimeRange ZeroTimeRange;
  private final MJTime duration;
  private final MJTime startTime;
  
  static
  {
    AppMethodBeat.i(216788);
    MJTime localMJTime = MJTime.ZeroTime;
    ZeroTimeRange = new MJTimeRange(localMJTime, localMJTime);
    localMJTime = MJTime.InvalidTime;
    InvalidTimeRange = new MJTimeRange(localMJTime, localMJTime);
    PositiveInfiniteTimeRange = new MJTimeRange(MJTime.ZeroTime, MJTime.PositiveInfinityTime);
    AppMethodBeat.o(216788);
  }
  
  public MJTimeRange(MJTime paramMJTime1, MJTime paramMJTime2)
  {
    this.startTime = paramMJTime1;
    this.duration = paramMJTime2;
  }
  
  public static MJTimeRange fromSecondsStartTimeDuration(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(216775);
    MJTimeRange localMJTimeRange = new MJTimeRange(MJTime.fromSeconds(paramDouble1), MJTime.fromSeconds(paramDouble2));
    AppMethodBeat.o(216775);
    return localMJTimeRange;
  }
  
  public static MJTimeRange fromSecondsStartTimeEndTime(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(216778);
    MJTimeRange localMJTimeRange = new MJTimeRange(MJTime.fromSeconds(paramDouble1), MJTime.fromSeconds(paramDouble2 - paramDouble1));
    AppMethodBeat.o(216778);
    return localMJTimeRange;
  }
  
  public static MJTimeRange fromStartEnd(MJTime paramMJTime1, MJTime paramMJTime2)
  {
    AppMethodBeat.i(216769);
    paramMJTime1 = new MJTimeRange(paramMJTime1, paramMJTime2.sub(paramMJTime1));
    AppMethodBeat.o(216769);
    return paramMJTime1;
  }
  
  public MJTimeRange calcIntersection(MJTimeRange paramMJTimeRange)
  {
    AppMethodBeat.i(216802);
    if ((!isValid()) || (!paramMJTimeRange.isValid()))
    {
      paramMJTimeRange = MJTime.InvalidTime;
      paramMJTimeRange = new MJTimeRange(paramMJTimeRange, paramMJTimeRange);
      AppMethodBeat.o(216802);
      return paramMJTimeRange;
    }
    MJTime localMJTime2 = this.startTime;
    MJTime localMJTime3 = getEndTime();
    MJTime localMJTime4 = paramMJTimeRange.startTime;
    MJTime localMJTime5 = paramMJTimeRange.getEndTime();
    if (localMJTime2.smallThan(localMJTime4)) {}
    MJTime localMJTime1;
    for (paramMJTimeRange = localMJTime4;; paramMJTimeRange = localMJTime2)
    {
      localMJTime1 = localMJTime5;
      if (localMJTime3.smallThan(localMJTime5)) {
        localMJTime1 = localMJTime3;
      }
      if (!localMJTime1.smallThan(paramMJTimeRange)) {
        break label163;
      }
      if ((!localMJTime4.bigThan(localMJTime3)) && (!localMJTime4.equalsTo(localMJTime3))) {
        break;
      }
      paramMJTimeRange = new MJTimeRange(localMJTime3, MJTime.ZeroTime);
      AppMethodBeat.o(216802);
      return paramMJTimeRange;
    }
    paramMJTimeRange = new MJTimeRange(localMJTime2, MJTime.ZeroTime);
    AppMethodBeat.o(216802);
    return paramMJTimeRange;
    label163:
    paramMJTimeRange = new MJTimeRange(paramMJTimeRange, localMJTime1.sub(paramMJTimeRange));
    AppMethodBeat.o(216802);
    return paramMJTimeRange;
  }
  
  public MJTimeRange calcMergedTimeRangeWith(MJTimeRange paramMJTimeRange)
  {
    AppMethodBeat.i(216805);
    if (!isValid())
    {
      AppMethodBeat.o(216805);
      return paramMJTimeRange;
    }
    if (!paramMJTimeRange.isValid())
    {
      AppMethodBeat.o(216805);
      return this;
    }
    if (paramMJTimeRange.getStartTime().smallThan(this.startTime)) {
      paramMJTimeRange.getStartTime();
    }
    if (paramMJTimeRange.getEndTime().bigThan(getEndTime())) {}
    for (paramMJTimeRange = paramMJTimeRange.getEndTime();; paramMJTimeRange = getEndTime())
    {
      paramMJTimeRange = fromStartEnd(this.startTime, paramMJTimeRange);
      AppMethodBeat.o(216805);
      return paramMJTimeRange;
    }
  }
  
  public boolean containsTime(MJTime paramMJTime)
  {
    AppMethodBeat.i(216810);
    if ((!isValid()) || (!paramMJTime.isValid()))
    {
      AppMethodBeat.o(216810);
      return false;
    }
    if (((paramMJTime.bigThan(this.startTime)) || (paramMJTime.equalsTo(this.startTime))) && (paramMJTime.smallThan(getEndTime())))
    {
      AppMethodBeat.o(216810);
      return true;
    }
    AppMethodBeat.o(216810);
    return false;
  }
  
  public boolean containsTimeRange(MJTimeRange paramMJTimeRange)
  {
    AppMethodBeat.i(216813);
    if (((paramMJTimeRange.getStartTime().bigThan(getStartTime())) || (paramMJTimeRange.getStartTime().equalsTo(getStartTime()))) && (paramMJTimeRange.getStartTime().smallThan(getEndTime())) && (paramMJTimeRange.getEndTime().bigThan(getStartTime())) && ((paramMJTimeRange.getEndTime().smallThan(getEndTime())) || (paramMJTimeRange.getEndTime().equalsTo(getEndTime()))))
    {
      AppMethodBeat.o(216813);
      return true;
    }
    AppMethodBeat.o(216813);
    return false;
  }
  
  public MJTime getDuration()
  {
    return this.duration;
  }
  
  public long getDurationFlicks()
  {
    AppMethodBeat.i(216819);
    long l = this.duration.getFlicks();
    AppMethodBeat.o(216819);
    return l;
  }
  
  public MJTime getEndTime()
  {
    AppMethodBeat.i(216796);
    MJTime localMJTime = this.startTime.add(this.duration);
    AppMethodBeat.o(216796);
    return localMJTime;
  }
  
  public long getStartFlicks()
  {
    AppMethodBeat.i(216816);
    long l = this.startTime.getFlicks();
    AppMethodBeat.o(216816);
    return l;
  }
  
  public MJTime getStartTime()
  {
    return this.startTime;
  }
  
  public boolean isValid()
  {
    AppMethodBeat.i(216799);
    if ((this.startTime.isNumeric()) && (this.duration.isValid()) && (!this.duration.isNegative()))
    {
      AppMethodBeat.o(216799);
      return true;
    }
    AppMethodBeat.o(216799);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.model.time.MJTimeRange
 * JD-Core Version:    0.7.0.1
 */