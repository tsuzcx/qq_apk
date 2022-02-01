package com.facebook.yoga;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum YogaDimension
{
  private final int mIntValue;
  
  static
  {
    AppMethodBeat.i(18067);
    WIDTH = new YogaDimension("WIDTH", 0, 0);
    HEIGHT = new YogaDimension("HEIGHT", 1, 1);
    $VALUES = new YogaDimension[] { WIDTH, HEIGHT };
    AppMethodBeat.o(18067);
  }
  
  private YogaDimension(int paramInt)
  {
    this.mIntValue = paramInt;
  }
  
  public static YogaDimension fromInt(int paramInt)
  {
    AppMethodBeat.i(18066);
    switch (paramInt)
    {
    default: 
      localObject = new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(18066);
      throw ((Throwable)localObject);
    case 0: 
      localObject = WIDTH;
      AppMethodBeat.o(18066);
      return localObject;
    }
    Object localObject = HEIGHT;
    AppMethodBeat.o(18066);
    return localObject;
  }
  
  public final int intValue()
  {
    return this.mIntValue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.facebook.yoga.YogaDimension
 * JD-Core Version:    0.7.0.1
 */