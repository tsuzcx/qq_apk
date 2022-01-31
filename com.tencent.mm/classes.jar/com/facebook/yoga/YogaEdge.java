package com.facebook.yoga;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum YogaEdge
{
  private final int mIntValue;
  
  static
  {
    AppMethodBeat.i(144056);
    LEFT = new YogaEdge("LEFT", 0, 0);
    TOP = new YogaEdge("TOP", 1, 1);
    RIGHT = new YogaEdge("RIGHT", 2, 2);
    BOTTOM = new YogaEdge("BOTTOM", 3, 3);
    START = new YogaEdge("START", 4, 4);
    END = new YogaEdge("END", 5, 5);
    HORIZONTAL = new YogaEdge("HORIZONTAL", 6, 6);
    VERTICAL = new YogaEdge("VERTICAL", 7, 7);
    ALL = new YogaEdge("ALL", 8, 8);
    $VALUES = new YogaEdge[] { LEFT, TOP, RIGHT, BOTTOM, START, END, HORIZONTAL, VERTICAL, ALL };
    AppMethodBeat.o(144056);
  }
  
  private YogaEdge(int paramInt)
  {
    this.mIntValue = paramInt;
  }
  
  public static YogaEdge fromInt(int paramInt)
  {
    AppMethodBeat.i(144055);
    switch (paramInt)
    {
    default: 
      localObject = new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(144055);
      throw ((Throwable)localObject);
    case 0: 
      localObject = LEFT;
      AppMethodBeat.o(144055);
      return localObject;
    case 1: 
      localObject = TOP;
      AppMethodBeat.o(144055);
      return localObject;
    case 2: 
      localObject = RIGHT;
      AppMethodBeat.o(144055);
      return localObject;
    case 3: 
      localObject = BOTTOM;
      AppMethodBeat.o(144055);
      return localObject;
    case 4: 
      localObject = START;
      AppMethodBeat.o(144055);
      return localObject;
    case 5: 
      localObject = END;
      AppMethodBeat.o(144055);
      return localObject;
    case 6: 
      localObject = HORIZONTAL;
      AppMethodBeat.o(144055);
      return localObject;
    case 7: 
      localObject = VERTICAL;
      AppMethodBeat.o(144055);
      return localObject;
    }
    Object localObject = ALL;
    AppMethodBeat.o(144055);
    return localObject;
  }
  
  public final int intValue()
  {
    return this.mIntValue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.yoga.YogaEdge
 * JD-Core Version:    0.7.0.1
 */