package com.facebook.yoga;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum YogaJustify
{
  private final int mIntValue;
  
  static
  {
    AppMethodBeat.i(18091);
    FLEX_START = new YogaJustify("FLEX_START", 0, 0);
    CENTER = new YogaJustify("CENTER", 1, 1);
    FLEX_END = new YogaJustify("FLEX_END", 2, 2);
    SPACE_BETWEEN = new YogaJustify("SPACE_BETWEEN", 3, 3);
    SPACE_AROUND = new YogaJustify("SPACE_AROUND", 4, 4);
    SPACE_EVENLY = new YogaJustify("SPACE_EVENLY", 5, 5);
    $VALUES = new YogaJustify[] { FLEX_START, CENTER, FLEX_END, SPACE_BETWEEN, SPACE_AROUND, SPACE_EVENLY };
    AppMethodBeat.o(18091);
  }
  
  private YogaJustify(int paramInt)
  {
    this.mIntValue = paramInt;
  }
  
  public static YogaJustify fromInt(int paramInt)
  {
    AppMethodBeat.i(18090);
    switch (paramInt)
    {
    default: 
      localObject = new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(18090);
      throw ((Throwable)localObject);
    case 0: 
      localObject = FLEX_START;
      AppMethodBeat.o(18090);
      return localObject;
    case 1: 
      localObject = CENTER;
      AppMethodBeat.o(18090);
      return localObject;
    case 2: 
      localObject = FLEX_END;
      AppMethodBeat.o(18090);
      return localObject;
    case 3: 
      localObject = SPACE_BETWEEN;
      AppMethodBeat.o(18090);
      return localObject;
    case 4: 
      localObject = SPACE_AROUND;
      AppMethodBeat.o(18090);
      return localObject;
    }
    Object localObject = SPACE_EVENLY;
    AppMethodBeat.o(18090);
    return localObject;
  }
  
  public final int intValue()
  {
    return this.mIntValue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.yoga.YogaJustify
 * JD-Core Version:    0.7.0.1
 */