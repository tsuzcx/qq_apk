package com.facebook.yoga;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum YogaNodeType
{
  private final int mIntValue;
  
  static
  {
    AppMethodBeat.i(18195);
    DEFAULT = new YogaNodeType("DEFAULT", 0, 0);
    TEXT = new YogaNodeType("TEXT", 1, 1);
    $VALUES = new YogaNodeType[] { DEFAULT, TEXT };
    AppMethodBeat.o(18195);
  }
  
  private YogaNodeType(int paramInt)
  {
    this.mIntValue = paramInt;
  }
  
  public static YogaNodeType fromInt(int paramInt)
  {
    AppMethodBeat.i(18194);
    switch (paramInt)
    {
    default: 
      localObject = new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(18194);
      throw ((Throwable)localObject);
    case 0: 
      localObject = DEFAULT;
      AppMethodBeat.o(18194);
      return localObject;
    }
    Object localObject = TEXT;
    AppMethodBeat.o(18194);
    return localObject;
  }
  
  public final int intValue()
  {
    return this.mIntValue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.facebook.yoga.YogaNodeType
 * JD-Core Version:    0.7.0.1
 */