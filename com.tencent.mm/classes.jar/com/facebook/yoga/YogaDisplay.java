package com.facebook.yoga;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum YogaDisplay
{
  private final int mIntValue;
  
  static
  {
    AppMethodBeat.i(144052);
    FLEX = new YogaDisplay("FLEX", 0, 0);
    NONE = new YogaDisplay("NONE", 1, 1);
    $VALUES = new YogaDisplay[] { FLEX, NONE };
    AppMethodBeat.o(144052);
  }
  
  private YogaDisplay(int paramInt)
  {
    this.mIntValue = paramInt;
  }
  
  public static YogaDisplay fromInt(int paramInt)
  {
    AppMethodBeat.i(144051);
    switch (paramInt)
    {
    default: 
      localObject = new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(144051);
      throw ((Throwable)localObject);
    case 0: 
      localObject = FLEX;
      AppMethodBeat.o(144051);
      return localObject;
    }
    Object localObject = NONE;
    AppMethodBeat.o(144051);
    return localObject;
  }
  
  public final int intValue()
  {
    return this.mIntValue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.facebook.yoga.YogaDisplay
 * JD-Core Version:    0.7.0.1
 */