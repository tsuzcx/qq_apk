package com.tencent.midas.comm;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.APLogFileInfo;
import com.tencent.midas.comm.log.internal.APCallbackLogger;
import com.tencent.midas.comm.log.internal.APLogger;
import com.tencent.midas.comm.log.util.APLogFileUtil;

public class APLog
{
  private static boolean hasLogCallback;
  @SuppressLint({"StaticFieldLeak"})
  private static APLogInfo logInfo;
  private static APLogger logger;
  private static boolean shouldPrintLog;
  private static boolean shouldWriteLog;
  
  static
  {
    AppMethodBeat.i(253927);
    logger = null;
    logInfo = new APLogInfo();
    shouldWriteLog = false;
    shouldPrintLog = true;
    hasLogCallback = false;
    AppMethodBeat.o(253927);
  }
  
  public static void closeLog()
  {
    AppMethodBeat.i(253923);
    flush();
    AppMethodBeat.o(253923);
  }
  
  private static String composeLogMsg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(253925);
    paramString1 = paramString1 + " | " + Thread.currentThread().getName() + " | " + paramString2 + "\r\n";
    AppMethodBeat.o(253925);
    return paramString1;
  }
  
  public static void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(253903);
    paramString1 = composeLogMsg(paramString1, paramString2);
    if (hasLogCallback)
    {
      APCallbackLogger.log(2, logInfo.getLogTag(), paramString1);
      AppMethodBeat.o(253903);
      return;
    }
    if (shouldPrintLog) {
      APLogger.log(2, logInfo.getLogTag(), paramString1);
    }
    writeLog(paramString1);
    AppMethodBeat.o(253903);
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(253904);
    d(paramString1, String.format(paramString2, paramVarArgs));
    AppMethodBeat.o(253904);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(253911);
    paramString1 = composeLogMsg(paramString1, paramString2);
    if (hasLogCallback)
    {
      APCallbackLogger.log(5, logInfo.getLogTag(), paramString1);
      AppMethodBeat.o(253911);
      return;
    }
    if (shouldPrintLog) {
      APLogger.log(5, logInfo.getLogTag(), paramString1);
    }
    writeLog(paramString1);
    AppMethodBeat.o(253911);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(253914);
    e(paramString1, String.format(paramString2, paramVarArgs));
    AppMethodBeat.o(253914);
  }
  
  public static void flush()
  {
    AppMethodBeat.i(253924);
    try
    {
      if (logger != null) {
        logger.flush();
      }
      AppMethodBeat.o(253924);
      return;
    }
    catch (Throwable localThrowable)
    {
      new StringBuilder("flush log error: ").append(localThrowable.toString());
      AppMethodBeat.o(253924);
    }
  }
  
  public static APLogInfo getLogInfo()
  {
    return logInfo;
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(253901);
    paramString1 = composeLogMsg(paramString1, paramString2);
    if (hasLogCallback)
    {
      APCallbackLogger.log(3, logInfo.getLogTag(), paramString1);
      AppMethodBeat.o(253901);
      return;
    }
    if (shouldPrintLog) {
      APLogger.log(3, logInfo.getLogTag(), paramString1);
    }
    writeLog(paramString1);
    AppMethodBeat.o(253901);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(253902);
    i(paramString1, String.format(paramString2, paramVarArgs));
    AppMethodBeat.o(253902);
  }
  
  public static void init(APLogInfo paramAPLogInfo)
  {
    AppMethodBeat.i(253899);
    if (paramAPLogInfo == null)
    {
      AppMethodBeat.o(253899);
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
          AppMethodBeat.o(253899);
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
      AppMethodBeat.o(253899);
      return;
    }
    catch (Throwable paramAPLogInfo)
    {
      new StringBuilder("Log init failed: ").append(paramAPLogInfo.toString());
      AppMethodBeat.o(253899);
    }
  }
  
  public static void s(String paramString1, String paramString2)
  {
    AppMethodBeat.i(253919);
    writeLog(composeLogMsg(paramString1, paramString2));
    AppMethodBeat.o(253919);
  }
  
  public static void s(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(253920);
    s(paramString1, String.format(paramString2, paramVarArgs));
    AppMethodBeat.o(253920);
  }
  
  public static void s(boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(253916);
    paramString1 = composeLogMsg(paramString1, paramString2);
    if (hasLogCallback)
    {
      APCallbackLogger.log(6, logInfo.getLogTag(), paramString1);
      AppMethodBeat.o(253916);
      return;
    }
    if ((shouldPrintLog) && (!paramBoolean)) {
      APLogger.log(6, logInfo.getLogTag(), paramString1);
    }
    writeLog(paramString1);
    AppMethodBeat.o(253916);
  }
  
  public static void s(boolean paramBoolean, String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(253917);
    s(paramBoolean, paramString1, String.format(paramString2, paramVarArgs));
    AppMethodBeat.o(253917);
  }
  
  public static void v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(253905);
    paramString1 = composeLogMsg(paramString1, paramString2);
    if (hasLogCallback)
    {
      APCallbackLogger.log(1, logInfo.getLogTag(), paramString1);
      AppMethodBeat.o(253905);
      return;
    }
    if (shouldPrintLog) {
      APLogger.log(1, logInfo.getLogTag(), paramString1);
    }
    writeLog(paramString1);
    AppMethodBeat.o(253905);
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(253906);
    v(paramString1, String.format(paramString2, paramVarArgs));
    AppMethodBeat.o(253906);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(253908);
    paramString1 = composeLogMsg(paramString1, paramString2);
    if (hasLogCallback)
    {
      APCallbackLogger.log(4, logInfo.getLogTag(), paramString1);
      AppMethodBeat.o(253908);
      return;
    }
    if (shouldPrintLog) {
      APLogger.log(4, logInfo.getLogTag(), paramString1);
    }
    writeLog(paramString1);
    AppMethodBeat.o(253908);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(253910);
    w(paramString1, String.format(paramString2, paramVarArgs));
    AppMethodBeat.o(253910);
  }
  
  private static void write(String paramString)
  {
    AppMethodBeat.i(253922);
    try
    {
      if (logger != null) {
        logger.write(paramString);
      }
      AppMethodBeat.o(253922);
      return;
    }
    catch (Throwable paramString)
    {
      new StringBuilder("Log write error: ").append(paramString.toString());
      AppMethodBeat.o(253922);
    }
  }
  
  private static void writeLog(String paramString)
  {
    AppMethodBeat.i(253921);
    if (shouldWriteLog) {
      write(paramString);
    }
    AppMethodBeat.o(253921);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.midas.comm.APLog
 * JD-Core Version:    0.7.0.1
 */