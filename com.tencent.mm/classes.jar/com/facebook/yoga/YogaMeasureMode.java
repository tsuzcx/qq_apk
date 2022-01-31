package com.facebook.yoga;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum YogaMeasureMode
{
  private final int mIntValue;
  
  static
  {
    AppMethodBeat.i(144076);
    UNDEFINED = new YogaMeasureMode("UNDEFINED", 0, 0);
    EXACTLY = new YogaMeasureMode("EXACTLY", 1, 1);
    AT_MOST = new YogaMeasureMode("AT_MOST", 2, 2);
    $VALUES = new YogaMeasureMode[] { UNDEFINED, EXACTLY, AT_MOST };
    AppMethodBeat.o(144076);
  }
  
  private YogaMeasureMode(int paramInt)
  {
    this.mIntValue = paramInt;
  }
  
  public static YogaMeasureMode fromInt(int paramInt)
  {
    AppMethodBeat.i(144075);
    switch (paramInt)
    {
    default: 
      localObject = new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(144075);
      throw ((Throwable)localObject);
    case 0: 
      localObject = UNDEFINED;
      AppMethodBeat.o(144075);
      return localObject;
    case 1: 
      localObject = EXACTLY;
      AppMethodBeat.o(144075);
      return localObject;
    }
    Object localObject = AT_MOST;
    AppMethodBeat.o(144075);
    return localObject;
  }
  
  public final int intValue()
  {
    return this.mIntValue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.yoga.YogaMeasureMode
 * JD-Core Version:    0.7.0.1
 */