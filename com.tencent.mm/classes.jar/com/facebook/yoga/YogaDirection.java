package com.facebook.yoga;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum YogaDirection
{
  private final int mIntValue;
  
  static
  {
    AppMethodBeat.i(18071);
    INHERIT = new YogaDirection("INHERIT", 0, 0);
    LTR = new YogaDirection("LTR", 1, 1);
    RTL = new YogaDirection("RTL", 2, 2);
    $VALUES = new YogaDirection[] { INHERIT, LTR, RTL };
    AppMethodBeat.o(18071);
  }
  
  private YogaDirection(int paramInt)
  {
    this.mIntValue = paramInt;
  }
  
  public static YogaDirection fromInt(int paramInt)
  {
    AppMethodBeat.i(18070);
    switch (paramInt)
    {
    default: 
      localObject = new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(18070);
      throw ((Throwable)localObject);
    case 0: 
      localObject = INHERIT;
      AppMethodBeat.o(18070);
      return localObject;
    case 1: 
      localObject = LTR;
      AppMethodBeat.o(18070);
      return localObject;
    }
    Object localObject = RTL;
    AppMethodBeat.o(18070);
    return localObject;
  }
  
  public final int intValue()
  {
    return this.mIntValue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.yoga.YogaDirection
 * JD-Core Version:    0.7.0.1
 */