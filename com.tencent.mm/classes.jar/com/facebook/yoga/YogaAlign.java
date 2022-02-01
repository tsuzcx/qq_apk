package com.facebook.yoga;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum YogaAlign
{
  private final int mIntValue;
  
  static
  {
    AppMethodBeat.i(18053);
    AUTO = new YogaAlign("AUTO", 0, 0);
    FLEX_START = new YogaAlign("FLEX_START", 1, 1);
    CENTER = new YogaAlign("CENTER", 2, 2);
    FLEX_END = new YogaAlign("FLEX_END", 3, 3);
    STRETCH = new YogaAlign("STRETCH", 4, 4);
    BASELINE = new YogaAlign("BASELINE", 5, 5);
    SPACE_BETWEEN = new YogaAlign("SPACE_BETWEEN", 6, 6);
    SPACE_AROUND = new YogaAlign("SPACE_AROUND", 7, 7);
    $VALUES = new YogaAlign[] { AUTO, FLEX_START, CENTER, FLEX_END, STRETCH, BASELINE, SPACE_BETWEEN, SPACE_AROUND };
    AppMethodBeat.o(18053);
  }
  
  private YogaAlign(int paramInt)
  {
    this.mIntValue = paramInt;
  }
  
  public static YogaAlign fromInt(int paramInt)
  {
    AppMethodBeat.i(18052);
    switch (paramInt)
    {
    default: 
      localObject = new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(18052);
      throw ((Throwable)localObject);
    case 0: 
      localObject = AUTO;
      AppMethodBeat.o(18052);
      return localObject;
    case 1: 
      localObject = FLEX_START;
      AppMethodBeat.o(18052);
      return localObject;
    case 2: 
      localObject = CENTER;
      AppMethodBeat.o(18052);
      return localObject;
    case 3: 
      localObject = FLEX_END;
      AppMethodBeat.o(18052);
      return localObject;
    case 4: 
      localObject = STRETCH;
      AppMethodBeat.o(18052);
      return localObject;
    case 5: 
      localObject = BASELINE;
      AppMethodBeat.o(18052);
      return localObject;
    case 6: 
      localObject = SPACE_BETWEEN;
      AppMethodBeat.o(18052);
      return localObject;
    }
    Object localObject = SPACE_AROUND;
    AppMethodBeat.o(18052);
    return localObject;
  }
  
  public final int intValue()
  {
    return this.mIntValue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.facebook.yoga.YogaAlign
 * JD-Core Version:    0.7.0.1
 */