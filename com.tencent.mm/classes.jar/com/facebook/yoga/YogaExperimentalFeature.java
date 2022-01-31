package com.facebook.yoga;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum YogaExperimentalFeature
{
  private final int mIntValue;
  
  static
  {
    AppMethodBeat.i(144060);
    WEB_FLEX_BASIS = new YogaExperimentalFeature("WEB_FLEX_BASIS", 0, 0);
    $VALUES = new YogaExperimentalFeature[] { WEB_FLEX_BASIS };
    AppMethodBeat.o(144060);
  }
  
  private YogaExperimentalFeature(int paramInt)
  {
    this.mIntValue = paramInt;
  }
  
  public static YogaExperimentalFeature fromInt(int paramInt)
  {
    AppMethodBeat.i(144059);
    switch (paramInt)
    {
    default: 
      localObject = new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(144059);
      throw ((Throwable)localObject);
    }
    Object localObject = WEB_FLEX_BASIS;
    AppMethodBeat.o(144059);
    return localObject;
  }
  
  public final int intValue()
  {
    return this.mIntValue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.yoga.YogaExperimentalFeature
 * JD-Core Version:    0.7.0.1
 */