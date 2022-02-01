package com.facebook.yoga;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum YogaUnit
{
  private final int mIntValue;
  
  static
  {
    AppMethodBeat.i(18211);
    UNDEFINED = new YogaUnit("UNDEFINED", 0, 0);
    POINT = new YogaUnit("POINT", 1, 1);
    PERCENT = new YogaUnit("PERCENT", 2, 2);
    AUTO = new YogaUnit("AUTO", 3, 3);
    $VALUES = new YogaUnit[] { UNDEFINED, POINT, PERCENT, AUTO };
    AppMethodBeat.o(18211);
  }
  
  private YogaUnit(int paramInt)
  {
    this.mIntValue = paramInt;
  }
  
  public static YogaUnit fromInt(int paramInt)
  {
    AppMethodBeat.i(18210);
    switch (paramInt)
    {
    default: 
      localObject = new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(18210);
      throw ((Throwable)localObject);
    case 0: 
      localObject = UNDEFINED;
      AppMethodBeat.o(18210);
      return localObject;
    case 1: 
      localObject = POINT;
      AppMethodBeat.o(18210);
      return localObject;
    case 2: 
      localObject = PERCENT;
      AppMethodBeat.o(18210);
      return localObject;
    }
    Object localObject = AUTO;
    AppMethodBeat.o(18210);
    return localObject;
  }
  
  public final int intValue()
  {
    return this.mIntValue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.facebook.yoga.YogaUnit
 * JD-Core Version:    0.7.0.1
 */