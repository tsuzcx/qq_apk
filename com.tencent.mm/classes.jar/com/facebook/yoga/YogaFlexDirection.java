package com.facebook.yoga;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum YogaFlexDirection
{
  private final int mIntValue;
  
  static
  {
    AppMethodBeat.i(144064);
    COLUMN = new YogaFlexDirection("COLUMN", 0, 0);
    COLUMN_REVERSE = new YogaFlexDirection("COLUMN_REVERSE", 1, 1);
    ROW = new YogaFlexDirection("ROW", 2, 2);
    ROW_REVERSE = new YogaFlexDirection("ROW_REVERSE", 3, 3);
    $VALUES = new YogaFlexDirection[] { COLUMN, COLUMN_REVERSE, ROW, ROW_REVERSE };
    AppMethodBeat.o(144064);
  }
  
  private YogaFlexDirection(int paramInt)
  {
    this.mIntValue = paramInt;
  }
  
  public static YogaFlexDirection fromInt(int paramInt)
  {
    AppMethodBeat.i(144063);
    switch (paramInt)
    {
    default: 
      localObject = new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(144063);
      throw ((Throwable)localObject);
    case 0: 
      localObject = COLUMN;
      AppMethodBeat.o(144063);
      return localObject;
    case 1: 
      localObject = COLUMN_REVERSE;
      AppMethodBeat.o(144063);
      return localObject;
    case 2: 
      localObject = ROW;
      AppMethodBeat.o(144063);
      return localObject;
    }
    Object localObject = ROW_REVERSE;
    AppMethodBeat.o(144063);
    return localObject;
  }
  
  public final int intValue()
  {
    return this.mIntValue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.yoga.YogaFlexDirection
 * JD-Core Version:    0.7.0.1
 */