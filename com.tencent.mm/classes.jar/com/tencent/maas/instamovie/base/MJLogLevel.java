package com.tencent.maas.instamovie.base;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum MJLogLevel
{
  private final int value;
  
  static
  {
    AppMethodBeat.i(216950);
    ISSUE = new MJLogLevel("ISSUE", 0, 0);
    FATAL = new MJLogLevel("FATAL", 1, 1);
    ERROR = new MJLogLevel("ERROR", 2, 2);
    WARN = new MJLogLevel("WARN", 3, 3);
    INFO = new MJLogLevel("INFO", 4, 4);
    DEBUG = new MJLogLevel("DEBUG", 5, 5);
    $VALUES = new MJLogLevel[] { ISSUE, FATAL, ERROR, WARN, INFO, DEBUG };
    AppMethodBeat.o(216950);
  }
  
  private MJLogLevel(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static MJLogLevel fromInt(int paramInt)
  {
    AppMethodBeat.i(216945);
    Object localObject = values();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      MJLogLevel localMJLogLevel = localObject[i];
      if (localMJLogLevel.getValue() == paramInt)
      {
        AppMethodBeat.o(216945);
        return localMJLogLevel;
      }
      i += 1;
    }
    localObject = DEBUG;
    AppMethodBeat.o(216945);
    return localObject;
  }
  
  public final int getValue()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.maas.instamovie.base.MJLogLevel
 * JD-Core Version:    0.7.0.1
 */