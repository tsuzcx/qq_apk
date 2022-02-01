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
    AppMethodBeat.i(193427);
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
        AppMethodBeat.o(193427);
        return;
      }
      AppMethodBeat.o(193427);
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
    AppMethodBeat.i(193424);
    APLogger localAPLogger = new APLogger();
    localAPLogger.openAppender();
    AppMethodBeat.o(193424);
    return localAPLogger;
  }
  
  private void openAppender()
  {
    AppMethodBeat.i(193423);
    this.appender = APLogAppender.open();
    AppMethodBeat.o(193423);
  }
  
  public void flush()
  {
    AppMethodBeat.i(193425);
    try
    {
      if (this.appender != null) {
        this.appender.flushAndWrite();
      }
      AppMethodBeat.o(193425);
      return;
    }
    catch (Throwable localThrowable)
    {
      String.format(Locale.CHINA, "flush log error: %s\n, stackTrace: %s", new Object[] { localThrowable.toString(), localThrowable.getStackTrace()[3] });
      AppMethodBeat.o(193425);
    }
  }
  
  public void write(String paramString)
  {
    AppMethodBeat.i(193426);
    this.appender.append(paramString);
    AppMethodBeat.o(193426);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.midas.comm.log.internal.APLogger
 * JD-Core Version:    0.7.0.1
 */