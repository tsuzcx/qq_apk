package com.facebook.yoga;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum YogaPositionType
{
  private final int mIntValue;
  
  static
  {
    AppMethodBeat.i(18203);
    RELATIVE = new YogaPositionType("RELATIVE", 0, 0);
    ABSOLUTE = new YogaPositionType("ABSOLUTE", 1, 1);
    $VALUES = new YogaPositionType[] { RELATIVE, ABSOLUTE };
    AppMethodBeat.o(18203);
  }
  
  private YogaPositionType(int paramInt)
  {
    this.mIntValue = paramInt;
  }
  
  public static YogaPositionType fromInt(int paramInt)
  {
    AppMethodBeat.i(18202);
    switch (paramInt)
    {
    default: 
      localObject = new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(18202);
      throw ((Throwable)localObject);
    case 0: 
      localObject = RELATIVE;
      AppMethodBeat.o(18202);
      return localObject;
    }
    Object localObject = ABSOLUTE;
    AppMethodBeat.o(18202);
    return localObject;
  }
  
  public final int intValue()
  {
    return this.mIntValue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.yoga.YogaPositionType
 * JD-Core Version:    0.7.0.1
 */