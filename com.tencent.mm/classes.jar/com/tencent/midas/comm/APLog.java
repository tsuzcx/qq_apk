package com.tencent.midas.comm;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.APLogFileInfo;
import com.tencent.midas.comm.log.internal.APCallbackLogger;
import com.tencent.midas.comm.log.internal.APLogger;
import com.tencent.midas.comm.log.util.APLogFileUtil;

public class APLog
{
  private static boolean hasLogCallback;
  private static APLogInfo logInfo;
  private static APLogger logger;
  private static boolean shouldPrintLog;
  private static boolean shouldWriteLog;
  
  static
  {
    AppMethodBeat.i(217358);
    logger = null;
    logInfo = new APLogInfo();
    shouldWriteLog = false;
    shouldPrintLog = true;
    hasLogCallback = false;
    AppMethodBeat.o(217358);
  }
  
  public static void closeLog()
  {
    AppMethodBeat.i(217335);
    flush();
    AppMethodBeat.o(217335);
  }
  
  private static String composeLogMsg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(217351);
    paramString1 = paramString1 + " | " + Thread.currentThread().getName() + " | " + paramString2 + "\r\n";
    AppMethodBeat.o(217351);
    return paramString1;
  }
  
  public static void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(217216);
    paramString1 = composeLogMsg(paramString1, paramString2);
    if (hasLogCallback)
    {
      APCallbackLogger.log(2, logInfo.getLogTag(), paramString1);
      AppMethodBeat.o(217216);
      return;
    }
    if (shouldPrintLog) {
      APLogger.log(2, logInfo.getLogTag(), paramString1);
    }
    writeLog(paramString1);
    AppMethodBeat.o(217216);
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(217226);
    d(paramString1, String.format(paramString2, paramVarArgs));
    AppMethodBeat.o(217226);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(217268);
    paramString1 = composeLogMsg(paramString1, paramString2);
    if (hasLogCallback)
    {
      APCallbackLogger.log(5, logInfo.getLogTag(), paramString1);
      AppMethodBeat.o(217268);
      return;
    }
    if (shouldPrintLog) {
      APLogger.log(5, logInfo.getLogTag(), paramString1);
    }
    writeLog(paramString1);
    AppMethodBeat.o(217268);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(217278);
    e(paramString1, String.format(paramString2, paramVarArgs));
    AppMethodBeat.o(217278);
  }
  
  public static void flush()
  {
    AppMethodBeat.i(217344);
    try
    {
      if (logger != null) {
        logger.flush();
      }
      AppMethodBeat.o(217344);
      return;
    }
    finally
    {
      new StringBuilder("flush log error: ").append(localObject.toString());
      AppMethodBeat.o(217344);
    }
  }
  
  public static APLogInfo getLogInfo()
  {
    return logInfo;
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(217201);
    paramString1 = composeLogMsg(paramString1, paramString2);
    if (hasLogCallback)
    {
      APCallbackLogger.log(3, logInfo.getLogTag(), paramString1);
      AppMethodBeat.o(217201);
      return;
    }
    if (shouldPrintLog) {
      APLogger.log(3, logInfo.getLogTag(), paramString1);
    }
    writeLog(paramString1);
    AppMethodBeat.o(217201);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(217209);
    i(paramString1, String.format(paramString2, paramVarArgs));
    AppMethodBeat.o(217209);
  }
  
  public static void init(APLogInfo paramAPLogInfo)
  {
    AppMethodBeat.i(217186);
    if (paramAPLogInfo == null)
    {
      AppMethodBeat.o(217186);
      return;
    }
    try
    {
      logInfo = paramAPLogInfo;
      if (!TextUtils.isEmpty(paramAPLogInfo.getLogCallbackClassName()))
      {
        if (APCallbackLogger.init(paramAPLogInfo.getLogCallbackClassName()))
        {
          hasLogCallback = true;
          AppMethodBeat.o(217186);
        }
      }
      else
      {
        hasLogCallback = false;
        APCallbackLogger.release();
      }
      logInfo.init();
      APLogFileInfo.create();
      APLogFileUtil.readLogKeepConf(logInfo.getContext());
      shouldPrintLog = logInfo.shouldPrintLog();
      if (APLogFileUtil.initLogDir(APLogFileInfo.dirName))
      {
        shouldWriteLog = logInfo.isWriteLog();
        if (logger == null) {
          logger = APLogger.open();
        }
      }
      AppMethodBeat.o(217186);
      return;
    }
    finally
    {
      new StringBuilder("Log init failed: ").append(paramAPLogInfo.toString());
      AppMethodBeat.o(217186);
    }
  }
  
  public static void s(String paramString1, String paramString2)
  {
    AppMethodBeat.i(217304);
    writeLog(composeLogMsg(paramString1, paramString2));
    AppMethodBeat.o(217304);
  }
  
  public static void s(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(217314);
    s(paramString1, String.format(paramString2, paramVarArgs));
    AppMethodBeat.o(217314);
  }
  
  public static void s(boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(217290);
    paramString1 = composeLogMsg(paramString1, paramString2);
    if (hasLogCallback)
    {
      APCallbackLogger.log(6, logInfo.getLogTag(), paramString1);
      AppMethodBeat.o(217290);
      return;
    }
    if ((shouldPrintLog) && (!paramBoolean)) {
      APLogger.log(6, logInfo.getLogTag(), paramString1);
    }
    writeLog(paramString1);
    AppMethodBeat.o(217290);
  }
  
  public static void s(boolean paramBoolean, String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(217296);
    s(paramBoolean, paramString1, String.format(paramString2, paramVarArgs));
    AppMethodBeat.o(217296);
  }
  
  public static void v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(217235);
    paramString1 = composeLogMsg(paramString1, paramString2);
    if (hasLogCallback)
    {
      APCallbackLogger.log(1, logInfo.getLogTag(), paramString1);
      AppMethodBeat.o(217235);
      return;
    }
    if (shouldPrintLog) {
      APLogger.log(1, logInfo.getLogTag(), paramString1);
    }
    writeLog(paramString1);
    AppMethodBeat.o(217235);
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(217244);
    v(paramString1, String.format(paramString2, paramVarArgs));
    AppMethodBeat.o(217244);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(217254);
    paramString1 = composeLogMsg(paramString1, paramString2);
    if (hasLogCallback)
    {
      APCallbackLogger.log(4, logInfo.getLogTag(), paramString1);
      AppMethodBeat.o(217254);
      return;
    }
    if (shouldPrintLog) {
      APLogger.log(4, logInfo.getLogTag(), paramString1);
    }
    writeLog(paramString1);
    AppMethodBeat.o(217254);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(217261);
    w(paramString1, String.format(paramString2, paramVarArgs));
    AppMethodBeat.o(217261);
  }
  
  private static void write(String paramString)
  {
    AppMethodBeat.i(217326);
    try
    {
      if (logger != null) {
        logger.write(paramString);
      }
      AppMethodBeat.o(217326);
      return;
    }
    finally
    {
      new StringBuilder("Log write error: ").append(paramString.toString());
      AppMethodBeat.o(217326);
    }
  }
  
  private static void writeLog(String paramString)
  {
    AppMethodBeat.i(217321);
    if (shouldWriteLog) {
      write(paramString);
    }
    AppMethodBeat.o(217321);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.midas.comm.APLog
 * JD-Core Version:    0.7.0.1
 */