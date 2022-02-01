package com.facebook.yoga;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum YogaMeasureMode
{
  private final int mIntValue;
  
  static
  {
    AppMethodBeat.i(18099);
    UNDEFINED = new YogaMeasureMode("UNDEFINED", 0, 0);
    EXACTLY = new YogaMeasureMode("EXACTLY", 1, 1);
    AT_MOST = new YogaMeasureMode("AT_MOST", 2, 2);
    $VALUES = new YogaMeasureMode[] { UNDEFINED, EXACTLY, AT_MOST };
    AppMethodBeat.o(18099);
  }
  
  private YogaMeasureMode(int paramInt)
  {
    this.mIntValue = paramInt;
  }
  
  public static YogaMeasureMode fromInt(int paramInt)
  {
    AppMethodBeat.i(18098);
    switch (paramInt)
    {
    default: 
      localObject = new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(18098);
      throw ((Throwable)localObject);
    case 0: 
      localObject = UNDEFINED;
      AppMethodBeat.o(18098);
      return localObject;
    case 1: 
      localObject = EXACTLY;
      AppMethodBeat.o(18098);
      return localObject;
    }
    Object localObject = AT_MOST;
    AppMethodBeat.o(18098);
    return localObject;
  }
  
  public final int intValue()
  {
    return this.mIntValue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.yoga.YogaMeasureMode
 * JD-Core Version:    0.7.0.1
 */