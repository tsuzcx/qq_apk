package com.facebook.yoga;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum LayoutPassReason
{
  private final int mIntValue;
  
  static
  {
    AppMethodBeat.i(208215);
    INITIAL = new LayoutPassReason("INITIAL", 0, 0);
    ABS_LAYOUT = new LayoutPassReason("ABS_LAYOUT", 1, 1);
    STRETCH = new LayoutPassReason("STRETCH", 2, 2);
    MULTILINE_STRETCH = new LayoutPassReason("MULTILINE_STRETCH", 3, 3);
    FLEX_LAYOUT = new LayoutPassReason("FLEX_LAYOUT", 4, 4);
    MEASURE = new LayoutPassReason("MEASURE", 5, 5);
    ABS_MEASURE = new LayoutPassReason("ABS_MEASURE", 6, 6);
    FLEX_MEASURE = new LayoutPassReason("FLEX_MEASURE", 7, 7);
    $VALUES = new LayoutPassReason[] { INITIAL, ABS_LAYOUT, STRETCH, MULTILINE_STRETCH, FLEX_LAYOUT, MEASURE, ABS_MEASURE, FLEX_MEASURE };
    AppMethodBeat.o(208215);
  }
  
  private LayoutPassReason(int paramInt)
  {
    this.mIntValue = paramInt;
  }
  
  public static LayoutPassReason fromInt(int paramInt)
  {
    AppMethodBeat.i(208214);
    switch (paramInt)
    {
    default: 
      localObject = new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(208214);
      throw ((Throwable)localObject);
    case 0: 
      localObject = INITIAL;
      AppMethodBeat.o(208214);
      return localObject;
    case 1: 
      localObject = ABS_LAYOUT;
      AppMethodBeat.o(208214);
      return localObject;
    case 2: 
      localObject = STRETCH;
      AppMethodBeat.o(208214);
      return localObject;
    case 3: 
      localObject = MULTILINE_STRETCH;
      AppMethodBeat.o(208214);
      return localObject;
    case 4: 
      localObject = FLEX_LAYOUT;
      AppMethodBeat.o(208214);
      return localObject;
    case 5: 
      localObject = MEASURE;
      AppMethodBeat.o(208214);
      return localObject;
    case 6: 
      localObject = ABS_MEASURE;
      AppMethodBeat.o(208214);
      return localObject;
    }
    Object localObject = FLEX_MEASURE;
    AppMethodBeat.o(208214);
    return localObject;
  }
  
  public final int intValue()
  {
    return this.mIntValue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.facebook.yoga.LayoutPassReason
 * JD-Core Version:    0.7.0.1
 */