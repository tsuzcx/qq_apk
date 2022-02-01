package com.facebook.yoga;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum YogaDisplay
{
  private final int mIntValue;
  
  static
  {
    AppMethodBeat.i(18075);
    FLEX = new YogaDisplay("FLEX", 0, 0);
    NONE = new YogaDisplay("NONE", 1, 1);
    $VALUES = new YogaDisplay[] { FLEX, NONE };
    AppMethodBeat.o(18075);
  }
  
  private YogaDisplay(int paramInt)
  {
    this.mIntValue = paramInt;
  }
  
  public static YogaDisplay fromInt(int paramInt)
  {
    AppMethodBeat.i(18074);
    switch (paramInt)
    {
    default: 
      localObject = new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(18074);
      throw ((Throwable)localObject);
    case 0: 
      localObject = FLEX;
      AppMethodBeat.o(18074);
      return localObject;
    }
    Object localObject = NONE;
    AppMethodBeat.o(18074);
    return localObject;
  }
  
  public final int intValue()
  {
    return this.mIntValue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.facebook.yoga.YogaDisplay
 * JD-Core Version:    0.7.0.1
 */