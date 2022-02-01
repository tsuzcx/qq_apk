package com.tencent.maas.model.time;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class MJTime
  implements Cloneable
{
  private static final int FlicksPerMillisecond = 1411200;
  public static final int FlicksPerSecond = 1411200000;
  public static final MJTime InvalidTime;
  private static final int[][] LUTOfCompareResultsByType;
  public static final MJTime NegativeInfinityTime;
  public static final MJTime PositiveInfinityTime;
  public static final MJTime ZeroTime;
  private final long flicks;
  private final MJTimeType type;
  
  static
  {
    AppMethodBeat.i(216811);
    ZeroTime = new MJTime(0L);
    InvalidTime = new MJTime();
    PositiveInfinityTime = new MJTime(MJTimeType.POSITIVEINFINITY);
    NegativeInfinityTime = new MJTime(MJTimeType.NEGATIVEINFINITY);
    int[] arrayOfInt1 = { 1, -1, 0, 1 };
    int[] arrayOfInt2 = { -1, -1, -1, 0 };
    LUTOfCompareResultsByType = new int[][] { { 2, -1, -1, 1 }, { 1, 0, 1, 1 }, arrayOfInt1, arrayOfInt2 };
    AppMethodBeat.o(216811);
  }
  
  public MJTime()
  {
    this(0L, MJTimeType.INVALID);
  }
  
  public MJTime(long paramLong)
  {
    this(paramLong, MJTimeType.NUMERIC);
  }
  
  public MJTime(long paramLong, MJTimeType paramMJTimeType)
  {
    this.flicks = paramLong;
    this.type = paramMJTimeType;
  }
  
  public MJTime(MJTimeType paramMJTimeType)
  {
    this(0L, paramMJTimeType);
  }
  
  public static MJTime fromMicroseconds(long paramLong)
  {
    AppMethodBeat.i(216781);
    MJTime localMJTime = fromTimeValueAndScale(paramLong, 1000000);
    AppMethodBeat.o(216781);
    return localMJTime;
  }
  
  public static MJTime fromMilliseconds(long paramLong)
  {
    AppMethodBeat.i(216776);
    MJTime localMJTime = fromTimeValueAndScale(paramLong, 1000);
    AppMethodBeat.o(216776);
    return localMJTime;
  }
  
  public static MJTime fromNanoseconds(long paramLong)
  {
    AppMethodBeat.i(216787);
    MJTime localMJTime = fromTimeValueAndScale(paramLong, 1000000000);
    AppMethodBeat.o(216787);
    return localMJTime;
  }
  
  public static MJTime fromSeconds(double paramDouble)
  {
    AppMethodBeat.i(216771);
    if (Double.valueOf(paramDouble).isNaN())
    {
      localMJTime = InvalidTime;
      AppMethodBeat.o(216771);
      return localMJTime;
    }
    if (!Double.valueOf(paramDouble).isInfinite())
    {
      localMJTime = new MJTime(Math.round(1411200000.0D * paramDouble));
      AppMethodBeat.o(216771);
      return localMJTime;
    }
    if (paramDouble > 0.0D)
    {
      localMJTime = PositiveInfinityTime;
      AppMethodBeat.o(216771);
      return localMJTime;
    }
    MJTime localMJTime = NegativeInfinityTime;
    AppMethodBeat.o(216771);
    return localMJTime;
  }
  
  public static MJTime fromTimeValueAndScale(long paramLong, int paramInt)
  {
    AppMethodBeat.i(216790);
    long l2 = paramLong / paramInt;
    long l3 = paramLong % paramInt * 1411200000L;
    long l1 = l3 / paramInt;
    paramLong = l1;
    if (l3 % paramInt * 2L >= paramInt) {
      paramLong = l1 + 1L;
    }
    MJTime localMJTime = new MJTime(paramLong + l2 * 1411200000L);
    AppMethodBeat.o(216790);
    return localMJTime;
  }
  
  public static MJTime max(MJTime paramMJTime1, MJTime paramMJTime2)
  {
    AppMethodBeat.i(216806);
    if (paramMJTime1.bigThan(paramMJTime2))
    {
      AppMethodBeat.o(216806);
      return paramMJTime1;
    }
    AppMethodBeat.o(216806);
    return paramMJTime2;
  }
  
  public static MJTime min(MJTime paramMJTime1, MJTime paramMJTime2)
  {
    AppMethodBeat.i(216803);
    if (paramMJTime1.smallThan(paramMJTime2))
    {
      AppMethodBeat.o(216803);
      return paramMJTime1;
    }
    AppMethodBeat.o(216803);
    return paramMJTime2;
  }
  
  public MJTime add(MJTime paramMJTime)
  {
    AppMethodBeat.i(216820);
    switch (1.$SwitchMap$com$tencent$maas$model$time$MJTime$MJTimeType[this.type.ordinal()])
    {
    }
    for (;;)
    {
      paramMJTime = InvalidTime;
      AppMethodBeat.o(216820);
      return paramMJTime;
      switch (1.$SwitchMap$com$tencent$maas$model$time$MJTime$MJTimeType[paramMJTime.type.ordinal()])
      {
      default: 
        paramMJTime = InvalidTime;
        AppMethodBeat.o(216820);
        return paramMJTime;
      case 1: 
        paramMJTime = new MJTime(this.flicks + paramMJTime.flicks);
        AppMethodBeat.o(216820);
        return paramMJTime;
      case 2: 
        paramMJTime = InvalidTime;
        AppMethodBeat.o(216820);
        return paramMJTime;
      case 3: 
        paramMJTime = PositiveInfinityTime;
        AppMethodBeat.o(216820);
        return paramMJTime;
      }
      paramMJTime = NegativeInfinityTime;
      AppMethodBeat.o(216820);
      return paramMJTime;
      switch (1.$SwitchMap$com$tencent$maas$model$time$MJTime$MJTimeType[paramMJTime.type.ordinal()])
      {
      default: 
        switch (1.$SwitchMap$com$tencent$maas$model$time$MJTime$MJTimeType[paramMJTime.type.ordinal()])
        {
        }
        break;
      }
    }
    paramMJTime = NegativeInfinityTime;
    AppMethodBeat.o(216820);
    return paramMJTime;
    paramMJTime = PositiveInfinityTime;
    AppMethodBeat.o(216820);
    return paramMJTime;
    paramMJTime = InvalidTime;
    AppMethodBeat.o(216820);
    return paramMJTime;
    paramMJTime = InvalidTime;
    AppMethodBeat.o(216820);
    return paramMJTime;
  }
  
  public boolean bigThan(MJTime paramMJTime)
  {
    AppMethodBeat.i(216873);
    if (compare(paramMJTime) > 0)
    {
      AppMethodBeat.o(216873);
      return true;
    }
    AppMethodBeat.o(216873);
    return false;
  }
  
  public int compare(MJTime paramMJTime)
  {
    AppMethodBeat.i(216866);
    int i = LUTOfCompareResultsByType[this.type.getValue()][paramMJTime.type.getValue()];
    if (i == 2)
    {
      i = Long.compare(this.flicks, paramMJTime.flicks);
      AppMethodBeat.o(216866);
      return i;
    }
    AppMethodBeat.o(216866);
    return i;
  }
  
  public MJTime divide(double paramDouble)
  {
    AppMethodBeat.i(216844);
    if (Double.isNaN(paramDouble))
    {
      localMJTime = InvalidTime;
      AppMethodBeat.o(216844);
      return localMJTime;
    }
    if (MJTime..ExternalSyntheticBackport0.m(paramDouble)) {
      if (paramDouble == 0.0D)
      {
        localMJTime = InvalidTime;
        AppMethodBeat.o(216844);
        return localMJTime;
      }
    }
    switch (1.$SwitchMap$com$tencent$maas$model$time$MJTime$MJTimeType[this.type.ordinal()])
    {
    default: 
      switch (1.$SwitchMap$com$tencent$maas$model$time$MJTime$MJTimeType[this.type.ordinal()])
      {
      default: 
        localMJTime = InvalidTime;
        AppMethodBeat.o(216844);
        return localMJTime;
      }
    case 1: 
      localMJTime = new MJTime(Math.round(this.flicks / paramDouble));
      AppMethodBeat.o(216844);
      return localMJTime;
    case 2: 
      localMJTime = InvalidTime;
      AppMethodBeat.o(216844);
      return localMJTime;
    case 3: 
      if (paramDouble > 0.0D)
      {
        localMJTime = PositiveInfinityTime;
        AppMethodBeat.o(216844);
        return localMJTime;
      }
      localMJTime = NegativeInfinityTime;
      AppMethodBeat.o(216844);
      return localMJTime;
    }
    if (paramDouble > 0.0D)
    {
      localMJTime = NegativeInfinityTime;
      AppMethodBeat.o(216844);
      return localMJTime;
    }
    MJTime localMJTime = PositiveInfinityTime;
    AppMethodBeat.o(216844);
    return localMJTime;
    localMJTime = ZeroTime;
    AppMethodBeat.o(216844);
    return localMJTime;
    localMJTime = InvalidTime;
    AppMethodBeat.o(216844);
    return localMJTime;
    localMJTime = InvalidTime;
    AppMethodBeat.o(216844);
    return localMJTime;
    localMJTime = InvalidTime;
    AppMethodBeat.o(216844);
    return localMJTime;
  }
  
  public MJTime divide(long paramLong)
  {
    AppMethodBeat.i(216849);
    if (paramLong == 0L)
    {
      localMJTime = InvalidTime;
      AppMethodBeat.o(216849);
      return localMJTime;
    }
    switch (1.$SwitchMap$com$tencent$maas$model$time$MJTime$MJTimeType[this.type.ordinal()])
    {
    default: 
      localMJTime = InvalidTime;
      AppMethodBeat.o(216849);
      return localMJTime;
    case 1: 
      localMJTime = new MJTime(this.flicks / paramLong);
      AppMethodBeat.o(216849);
      return localMJTime;
    case 2: 
      localMJTime = InvalidTime;
      AppMethodBeat.o(216849);
      return localMJTime;
    case 3: 
      if (paramLong > 0L)
      {
        localMJTime = PositiveInfinityTime;
        AppMethodBeat.o(216849);
        return localMJTime;
      }
      localMJTime = NegativeInfinityTime;
      AppMethodBeat.o(216849);
      return localMJTime;
    }
    if (paramLong > 0L)
    {
      localMJTime = NegativeInfinityTime;
      AppMethodBeat.o(216849);
      return localMJTime;
    }
    MJTime localMJTime = PositiveInfinityTime;
    AppMethodBeat.o(216849);
    return localMJTime;
  }
  
  public boolean equalsTo(MJTime paramMJTime)
  {
    AppMethodBeat.i(216888);
    if (compare(paramMJTime) == 0)
    {
      AppMethodBeat.o(216888);
      return true;
    }
    AppMethodBeat.o(216888);
    return false;
  }
  
  public long getFlicks()
  {
    return this.flicks;
  }
  
  public MJTimeType getType()
  {
    return this.type;
  }
  
  public boolean isNegative()
  {
    AppMethodBeat.i(216906);
    if (((isNumeric()) && (this.flicks < 0L)) || (this.type == MJTimeType.NEGATIVEINFINITY))
    {
      AppMethodBeat.o(216906);
      return true;
    }
    AppMethodBeat.o(216906);
    return false;
  }
  
  public boolean isNegativeInfinity()
  {
    return this.type == MJTimeType.NEGATIVEINFINITY;
  }
  
  public boolean isNumeric()
  {
    return this.type == MJTimeType.NUMERIC;
  }
  
  public boolean isPositive()
  {
    AppMethodBeat.i(216903);
    if (((isNumeric()) && (this.flicks > 0L)) || (this.type == MJTimeType.POSITIVEINFINITY))
    {
      AppMethodBeat.o(216903);
      return true;
    }
    AppMethodBeat.o(216903);
    return false;
  }
  
  public boolean isPositiveInfinity()
  {
    return this.type == MJTimeType.POSITIVEINFINITY;
  }
  
  public boolean isValid()
  {
    return this.type != MJTimeType.INVALID;
  }
  
  public MJTime multi(double paramDouble)
  {
    AppMethodBeat.i(216832);
    if (Double.isNaN(paramDouble))
    {
      localMJTime = InvalidTime;
      AppMethodBeat.o(216832);
      return localMJTime;
    }
    if (MJTime..ExternalSyntheticBackport0.m(paramDouble)) {}
    switch (1.$SwitchMap$com$tencent$maas$model$time$MJTime$MJTimeType[this.type.ordinal()])
    {
    default: 
      if (paramDouble > 0.0D) {
        switch (1.$SwitchMap$com$tencent$maas$model$time$MJTime$MJTimeType[this.type.ordinal()])
        {
        }
      }
      break;
    }
    for (;;)
    {
      localMJTime = InvalidTime;
      AppMethodBeat.o(216832);
      return localMJTime;
      localMJTime = new MJTime(Math.round(this.flicks * paramDouble));
      AppMethodBeat.o(216832);
      return localMJTime;
      localMJTime = InvalidTime;
      AppMethodBeat.o(216832);
      return localMJTime;
      localMJTime = PositiveInfinityTime;
      AppMethodBeat.o(216832);
      return localMJTime;
      localMJTime = NegativeInfinityTime;
      AppMethodBeat.o(216832);
      return localMJTime;
      localMJTime = PositiveInfinityTime;
      AppMethodBeat.o(216832);
      return localMJTime;
      localMJTime = InvalidTime;
      AppMethodBeat.o(216832);
      return localMJTime;
      localMJTime = PositiveInfinityTime;
      AppMethodBeat.o(216832);
      return localMJTime;
      localMJTime = NegativeInfinityTime;
      AppMethodBeat.o(216832);
      return localMJTime;
      switch (1.$SwitchMap$com$tencent$maas$model$time$MJTime$MJTimeType[this.type.ordinal()])
      {
      }
    }
    MJTime localMJTime = NegativeInfinityTime;
    AppMethodBeat.o(216832);
    return localMJTime;
    localMJTime = InvalidTime;
    AppMethodBeat.o(216832);
    return localMJTime;
    localMJTime = NegativeInfinityTime;
    AppMethodBeat.o(216832);
    return localMJTime;
    localMJTime = PositiveInfinityTime;
    AppMethodBeat.o(216832);
    return localMJTime;
  }
  
  public MJTime multi(long paramLong)
  {
    AppMethodBeat.i(216838);
    switch (1.$SwitchMap$com$tencent$maas$model$time$MJTime$MJTimeType[this.type.ordinal()])
    {
    default: 
      localMJTime = InvalidTime;
      AppMethodBeat.o(216838);
      return localMJTime;
    case 1: 
      localMJTime = new MJTime(this.flicks * paramLong);
      AppMethodBeat.o(216838);
      return localMJTime;
    case 2: 
      localMJTime = InvalidTime;
      AppMethodBeat.o(216838);
      return localMJTime;
    case 3: 
      if (paramLong > 0L)
      {
        localMJTime = PositiveInfinityTime;
        AppMethodBeat.o(216838);
        return localMJTime;
      }
      if (paramLong == 0L)
      {
        localMJTime = InvalidTime;
        AppMethodBeat.o(216838);
        return localMJTime;
      }
      localMJTime = NegativeInfinityTime;
      AppMethodBeat.o(216838);
      return localMJTime;
    }
    if (paramLong > 0L)
    {
      localMJTime = NegativeInfinityTime;
      AppMethodBeat.o(216838);
      return localMJTime;
    }
    if (paramLong == 0L)
    {
      localMJTime = InvalidTime;
      AppMethodBeat.o(216838);
      return localMJTime;
    }
    MJTime localMJTime = PositiveInfinityTime;
    AppMethodBeat.o(216838);
    return localMJTime;
  }
  
  public boolean smallThan(MJTime paramMJTime)
  {
    AppMethodBeat.i(216881);
    if (compare(paramMJTime) < 0)
    {
      AppMethodBeat.o(216881);
      return true;
    }
    AppMethodBeat.o(216881);
    return false;
  }
  
  public MJTime sub(MJTime paramMJTime)
  {
    AppMethodBeat.i(216825);
    switch (1.$SwitchMap$com$tencent$maas$model$time$MJTime$MJTimeType[this.type.ordinal()])
    {
    }
    for (;;)
    {
      paramMJTime = InvalidTime;
      AppMethodBeat.o(216825);
      return paramMJTime;
      switch (1.$SwitchMap$com$tencent$maas$model$time$MJTime$MJTimeType[paramMJTime.type.ordinal()])
      {
      default: 
        paramMJTime = InvalidTime;
        AppMethodBeat.o(216825);
        return paramMJTime;
      case 1: 
        paramMJTime = new MJTime(this.flicks - paramMJTime.flicks);
        AppMethodBeat.o(216825);
        return paramMJTime;
      case 2: 
        paramMJTime = InvalidTime;
        AppMethodBeat.o(216825);
        return paramMJTime;
      case 3: 
        paramMJTime = NegativeInfinityTime;
        AppMethodBeat.o(216825);
        return paramMJTime;
      }
      paramMJTime = PositiveInfinityTime;
      AppMethodBeat.o(216825);
      return paramMJTime;
      switch (1.$SwitchMap$com$tencent$maas$model$time$MJTime$MJTimeType[paramMJTime.type.ordinal()])
      {
      default: 
        switch (1.$SwitchMap$com$tencent$maas$model$time$MJTime$MJTimeType[paramMJTime.type.ordinal()])
        {
        }
        break;
      }
    }
    paramMJTime = NegativeInfinityTime;
    AppMethodBeat.o(216825);
    return paramMJTime;
    paramMJTime = PositiveInfinityTime;
    AppMethodBeat.o(216825);
    return paramMJTime;
    paramMJTime = InvalidTime;
    AppMethodBeat.o(216825);
    return paramMJTime;
    paramMJTime = InvalidTime;
    AppMethodBeat.o(216825);
    return paramMJTime;
  }
  
  public double toMilliseconds()
  {
    AppMethodBeat.i(216859);
    switch (1.$SwitchMap$com$tencent$maas$model$time$MJTime$MJTimeType[this.type.ordinal()])
    {
    default: 
      AppMethodBeat.o(216859);
      return (0.0D / 0.0D);
    case 1: 
      double d1 = this.flicks / 1411200L;
      double d2 = this.flicks % 1411200L / 1411200.0D;
      AppMethodBeat.o(216859);
      return d1 + d2;
    case 2: 
      AppMethodBeat.o(216859);
      return (0.0D / 0.0D);
    case 3: 
      AppMethodBeat.o(216859);
      return (1.0D / 0.0D);
    }
    AppMethodBeat.o(216859);
    return (-1.0D / 0.0D);
  }
  
  public double toSeconds()
  {
    AppMethodBeat.i(216853);
    switch (1.$SwitchMap$com$tencent$maas$model$time$MJTime$MJTimeType[this.type.ordinal()])
    {
    default: 
      AppMethodBeat.o(216853);
      return (0.0D / 0.0D);
    case 1: 
      double d1 = this.flicks / 1411200000L;
      double d2 = this.flicks % 1411200000L / 1411200000.0D;
      AppMethodBeat.o(216853);
      return d1 + d2;
    case 2: 
      AppMethodBeat.o(216853);
      return (0.0D / 0.0D);
    case 3: 
      AppMethodBeat.o(216853);
      return (1.0D / 0.0D);
    }
    AppMethodBeat.o(216853);
    return (-1.0D / 0.0D);
  }
  
  public long toUs()
  {
    AppMethodBeat.i(216863);
    long l = (toSeconds() * 1000000.0D);
    AppMethodBeat.o(216863);
    return l;
  }
  
  static enum MJTimeType
  {
    private final int value;
    
    static
    {
      AppMethodBeat.i(216793);
      NUMERIC = new MJTimeType("NUMERIC", 0, 0);
      INVALID = new MJTimeType("INVALID", 1, 1);
      POSITIVEINFINITY = new MJTimeType("POSITIVEINFINITY", 2, 2);
      NEGATIVEINFINITY = new MJTimeType("NEGATIVEINFINITY", 3, 3);
      $VALUES = new MJTimeType[] { NUMERIC, INVALID, POSITIVEINFINITY, NEGATIVEINFINITY };
      AppMethodBeat.o(216793);
    }
    
    private MJTimeType(int paramInt)
    {
      this.value = paramInt;
    }
    
    public final int getValue()
    {
      return this.value;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.model.time.MJTime
 * JD-Core Version:    0.7.0.1
 */