package com.facebook.yoga;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum YogaWrap
{
  private final int mIntValue;
  
  static
  {
    AppMethodBeat.i(18222);
    NO_WRAP = new YogaWrap("NO_WRAP", 0, 0);
    WRAP = new YogaWrap("WRAP", 1, 1);
    WRAP_REVERSE = new YogaWrap("WRAP_REVERSE", 2, 2);
    $VALUES = new YogaWrap[] { NO_WRAP, WRAP, WRAP_REVERSE };
    AppMethodBeat.o(18222);
  }
  
  private YogaWrap(int paramInt)
  {
    this.mIntValue = paramInt;
  }
  
  public static YogaWrap fromInt(int paramInt)
  {
    AppMethodBeat.i(18221);
    switch (paramInt)
    {
    default: 
      localObject = new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(18221);
      throw ((Throwable)localObject);
    case 0: 
      localObject = NO_WRAP;
      AppMethodBeat.o(18221);
      return localObject;
    case 1: 
      localObject = WRAP;
      AppMethodBeat.o(18221);
      return localObject;
    }
    Object localObject = WRAP_REVERSE;
    AppMethodBeat.o(18221);
    return localObject;
  }
  
  public final int intValue()
  {
    return this.mIntValue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.facebook.yoga.YogaWrap
 * JD-Core Version:    0.7.0.1
 */