package com.facebook.yoga;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum YogaDimension
{
  private final int mIntValue;
  
  static
  {
    AppMethodBeat.i(144044);
    WIDTH = new YogaDimension("WIDTH", 0, 0);
    HEIGHT = new YogaDimension("HEIGHT", 1, 1);
    $VALUES = new YogaDimension[] { WIDTH, HEIGHT };
    AppMethodBeat.o(144044);
  }
  
  private YogaDimension(int paramInt)
  {
    this.mIntValue = paramInt;
  }
  
  public static YogaDimension fromInt(int paramInt)
  {
    AppMethodBeat.i(144043);
    switch (paramInt)
    {
    default: 
      localObject = new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(144043);
      throw ((Throwable)localObject);
    case 0: 
      localObject = WIDTH;
      AppMethodBeat.o(144043);
      return localObject;
    }
    Object localObject = HEIGHT;
    AppMethodBeat.o(144043);
    return localObject;
  }
  
  public final int intValue()
  {
    return this.mIntValue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.facebook.yoga.YogaDimension
 * JD-Core Version:    0.7.0.1
 */