package com.facebook.yoga;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum YogaLogLevel
{
  private final int mIntValue;
  
  static
  {
    AppMethodBeat.i(144072);
    ERROR = new YogaLogLevel("ERROR", 0, 0);
    WARN = new YogaLogLevel("WARN", 1, 1);
    INFO = new YogaLogLevel("INFO", 2, 2);
    DEBUG = new YogaLogLevel("DEBUG", 3, 3);
    VERBOSE = new YogaLogLevel("VERBOSE", 4, 4);
    FATAL = new YogaLogLevel("FATAL", 5, 5);
    $VALUES = new YogaLogLevel[] { ERROR, WARN, INFO, DEBUG, VERBOSE, FATAL };
    AppMethodBeat.o(144072);
  }
  
  private YogaLogLevel(int paramInt)
  {
    this.mIntValue = paramInt;
  }
  
  public static YogaLogLevel fromInt(int paramInt)
  {
    AppMethodBeat.i(144071);
    switch (paramInt)
    {
    default: 
      localObject = new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(144071);
      throw ((Throwable)localObject);
    case 0: 
      localObject = ERROR;
      AppMethodBeat.o(144071);
      return localObject;
    case 1: 
      localObject = WARN;
      AppMethodBeat.o(144071);
      return localObject;
    case 2: 
      localObject = INFO;
      AppMethodBeat.o(144071);
      return localObject;
    case 3: 
      localObject = DEBUG;
      AppMethodBeat.o(144071);
      return localObject;
    case 4: 
      localObject = VERBOSE;
      AppMethodBeat.o(144071);
      return localObject;
    }
    Object localObject = FATAL;
    AppMethodBeat.o(144071);
    return localObject;
  }
  
  public final int intValue()
  {
    return this.mIntValue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.facebook.yoga.YogaLogLevel
 * JD-Core Version:    0.7.0.1
 */