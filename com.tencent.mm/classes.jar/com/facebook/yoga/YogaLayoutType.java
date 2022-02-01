package com.facebook.yoga;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum YogaLayoutType
{
  private final int mIntValue;
  
  static
  {
    AppMethodBeat.i(192956);
    LAYOUT = new YogaLayoutType("LAYOUT", 0, 0);
    MEASURE = new YogaLayoutType("MEASURE", 1, 1);
    CACHED_LAYOUT = new YogaLayoutType("CACHED_LAYOUT", 2, 2);
    CACHED_MEASURE = new YogaLayoutType("CACHED_MEASURE", 3, 3);
    $VALUES = new YogaLayoutType[] { LAYOUT, MEASURE, CACHED_LAYOUT, CACHED_MEASURE };
    AppMethodBeat.o(192956);
  }
  
  private YogaLayoutType(int paramInt)
  {
    this.mIntValue = paramInt;
  }
  
  public static YogaLayoutType fromInt(int paramInt)
  {
    AppMethodBeat.i(192955);
    switch (paramInt)
    {
    default: 
      localObject = new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(192955);
      throw ((Throwable)localObject);
    case 0: 
      localObject = LAYOUT;
      AppMethodBeat.o(192955);
      return localObject;
    case 1: 
      localObject = MEASURE;
      AppMethodBeat.o(192955);
      return localObject;
    case 2: 
      localObject = CACHED_LAYOUT;
      AppMethodBeat.o(192955);
      return localObject;
    }
    Object localObject = CACHED_MEASURE;
    AppMethodBeat.o(192955);
    return localObject;
  }
  
  public final int intValue()
  {
    return this.mIntValue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.facebook.yoga.YogaLayoutType
 * JD-Core Version:    0.7.0.1
 */