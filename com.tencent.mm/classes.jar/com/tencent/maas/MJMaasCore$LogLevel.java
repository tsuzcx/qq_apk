package com.tencent.maas;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum MJMaasCore$LogLevel
{
  static
  {
    AppMethodBeat.i(216767);
    ISSUE = new LogLevel("ISSUE", 0);
    FATAL = new LogLevel("FATAL", 1);
    ERROR = new LogLevel("ERROR", 2);
    WARN = new LogLevel("WARN", 3);
    INFO = new LogLevel("INFO", 4);
    DEBUG = new LogLevel("DEBUG", 5);
    $VALUES = new LogLevel[] { ISSUE, FATAL, ERROR, WARN, INFO, DEBUG };
    AppMethodBeat.o(216767);
  }
  
  private MJMaasCore$LogLevel() {}
  
  public final int getValue()
  {
    AppMethodBeat.i(216774);
    switch (MJMaasCore.1.$SwitchMap$com$tencent$maas$MJMaasCore$LogLevel[ordinal()])
    {
    default: 
      AppMethodBeat.o(216774);
      return 5;
    case 1: 
      AppMethodBeat.o(216774);
      return 0;
    case 2: 
      AppMethodBeat.o(216774);
      return 1;
    case 3: 
      AppMethodBeat.o(216774);
      return 2;
    case 4: 
      AppMethodBeat.o(216774);
      return 3;
    case 5: 
      AppMethodBeat.o(216774);
      return 4;
    }
    AppMethodBeat.o(216774);
    return 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.maas.MJMaasCore.LogLevel
 * JD-Core Version:    0.7.0.1
 */