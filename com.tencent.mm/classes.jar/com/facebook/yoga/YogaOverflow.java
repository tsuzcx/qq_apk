package com.facebook.yoga;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum YogaOverflow
{
  private final int mIntValue;
  
  static
  {
    AppMethodBeat.i(144176);
    VISIBLE = new YogaOverflow("VISIBLE", 0, 0);
    HIDDEN = new YogaOverflow("HIDDEN", 1, 1);
    SCROLL = new YogaOverflow("SCROLL", 2, 2);
    $VALUES = new YogaOverflow[] { VISIBLE, HIDDEN, SCROLL };
    AppMethodBeat.o(144176);
  }
  
  private YogaOverflow(int paramInt)
  {
    this.mIntValue = paramInt;
  }
  
  public static YogaOverflow fromInt(int paramInt)
  {
    AppMethodBeat.i(144175);
    switch (paramInt)
    {
    default: 
      localObject = new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(144175);
      throw ((Throwable)localObject);
    case 0: 
      localObject = VISIBLE;
      AppMethodBeat.o(144175);
      return localObject;
    case 1: 
      localObject = HIDDEN;
      AppMethodBeat.o(144175);
      return localObject;
    }
    Object localObject = SCROLL;
    AppMethodBeat.o(144175);
    return localObject;
  }
  
  public final int intValue()
  {
    return this.mIntValue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.facebook.yoga.YogaOverflow
 * JD-Core Version:    0.7.0.1
 */