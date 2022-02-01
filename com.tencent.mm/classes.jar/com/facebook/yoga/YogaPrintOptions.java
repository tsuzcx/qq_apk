package com.facebook.yoga;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum YogaPrintOptions
{
  private final int mIntValue;
  
  static
  {
    AppMethodBeat.i(18207);
    LAYOUT = new YogaPrintOptions("LAYOUT", 0, 1);
    STYLE = new YogaPrintOptions("STYLE", 1, 2);
    CHILDREN = new YogaPrintOptions("CHILDREN", 2, 4);
    $VALUES = new YogaPrintOptions[] { LAYOUT, STYLE, CHILDREN };
    AppMethodBeat.o(18207);
  }
  
  private YogaPrintOptions(int paramInt)
  {
    this.mIntValue = paramInt;
  }
  
  public static YogaPrintOptions fromInt(int paramInt)
  {
    AppMethodBeat.i(18206);
    switch (paramInt)
    {
    case 3: 
    default: 
      localObject = new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(18206);
      throw ((Throwable)localObject);
    case 1: 
      localObject = LAYOUT;
      AppMethodBeat.o(18206);
      return localObject;
    case 2: 
      localObject = STYLE;
      AppMethodBeat.o(18206);
      return localObject;
    }
    Object localObject = CHILDREN;
    AppMethodBeat.o(18206);
    return localObject;
  }
  
  public final int intValue()
  {
    return this.mIntValue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.facebook.yoga.YogaPrintOptions
 * JD-Core Version:    0.7.0.1
 */