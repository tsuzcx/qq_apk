package com.tencent.midas.comm.log.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;

public class APLogger
{
  public static final int LOG_LEVEL_DEBUG = 2;
  public static final int LOG_LEVEL_ERROR = 5;
  public static final int LOG_LEVEL_INFO = 3;
  public static final int LOG_LEVEL_SILENT = 6;
  public static final int LOG_LEVEL_VERBOSE = 1;
  public static final int LOG_LEVEL_WARN = 4;
  private APLogAppender appender = null;
  
  public static void log(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(254005);
    int j;
    for (int i = 0;; i = j)
    {
      try
      {
        if (i < paramString2.length()) {
          if (paramString2.length() <= i + 3600) {
            paramString2.substring(i);
          } else {
            paramString2.substring(i, i + 3600);
          }
        }
      }
      catch (Throwable paramString1)
      {
        String.format(Locale.CHINA, "print log error: <%s>%s", new Object[] { paramString1.getClass().getName(), paramString1.getMessage() });
        AppMethodBeat.o(254005);
        return;
      }
      AppMethodBeat.o(254005);
      return;
      j = i + 3600;
      i = j;
      switch (paramInt)
      {
      }
    }
  }
  
  public static APLogger open()
  {
    AppMethodBeat.i(254002);
    APLogger localAPLogger = new APLogger();
    localAPLogger.openAppender();
    AppMethodBeat.o(254002);
    return localAPLogger;
  }
  
  private void openAppender()
  {
    AppMethodBeat.i(254001);
    this.appender = APLogAppender.open();
    AppMethodBeat.o(254001);
  }
  
  public void flush()
  {
    AppMethodBeat.i(254003);
    try
    {
      if (this.appender != null) {
        this.appender.flushAndWrite();
      }
      AppMethodBeat.o(254003);
      return;
    }
    catch (Throwable localThrowable)
    {
      String.format(Locale.CHINA, "flush log error: %s\n, stackTrace: %s", new Object[] { localThrowable.toString(), localThrowable.getStackTrace()[3] });
      AppMethodBeat.o(254003);
    }
  }
  
  public void write(String paramString)
  {
    AppMethodBeat.i(254004);
    this.appender.append(paramString);
    AppMethodBeat.o(254004);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.midas.comm.log.internal.APLogger
 * JD-Core Version:    0.7.0.1
 */