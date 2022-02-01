package com.tencent.midas.comm;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.APLogFileInfo;
import com.tencent.midas.comm.log.internal.APLogger;
import com.tencent.midas.comm.log.util.APLogDataReporter;
import com.tencent.midas.comm.log.util.APLogFileUtil;

public class APLog
{
  @SuppressLint({"StaticFieldLeak"})
  private static APLogInfo logInfo;
  private static APLogger logger;
  private static boolean shouldPrintLog;
  private static boolean shouldWriteLog;
  
  static
  {
    AppMethodBeat.i(193390);
    logger = null;
    logInfo = new APLogInfo();
    shouldWriteLog = false;
    shouldPrintLog = true;
    AppMethodBeat.o(193390);
  }
  
  public static void closeLog()
  {
    AppMethodBeat.i(193387);
    flush();
    AppMethodBeat.o(193387);
  }
  
  private static String composeLogMsg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(193389);
    paramString1 = paramString1 + " | " + Thread.currentThread().getName() + " | " + paramString2 + "\r\n";
    AppMethodBeat.o(193389);
    return paramString1;
  }
  
  public static void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(193373);
    paramString1 = composeLogMsg(paramString1, paramString2);
    if (shouldPrintLog) {
      APLogger.log(2, logInfo.getLogTag(), paramString1);
    }
    writeLog(paramString1);
    AppMethodBeat.o(193373);
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(193374);
    d(paramString1, String.format(paramString2, paramVarArgs));
    AppMethodBeat.o(193374);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(193379);
    paramString1 = composeLogMsg(paramString1, paramString2);
    if (shouldPrintLog) {
      APLogger.log(5, logInfo.getLogTag(), paramString1);
    }
    writeLog(paramString1);
    AppMethodBeat.o(193379);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(193380);
    e(paramString1, String.format(paramString2, paramVarArgs));
    AppMethodBeat.o(193380);
  }
  
  public static void flush()
  {
    AppMethodBeat.i(193388);
    try
    {
      if (logger != null) {
        logger.flush();
      }
      AppMethodBeat.o(193388);
      return;
    }
    catch (Throwable localThrowable)
    {
      new StringBuilder("flush log error: ").append(localThrowable.toString());
      AppMethodBeat.o(193388);
    }
  }
  
  public static APLogInfo getLogInfo()
  {
    return logInfo;
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(193371);
    paramString1 = composeLogMsg(paramString1, paramString2);
    if (shouldPrintLog) {
      APLogger.log(3, logInfo.getLogTag(), paramString1);
    }
    writeLog(paramString1);
    AppMethodBeat.o(193371);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(193372);
    i(paramString1, String.format(paramString2, paramVarArgs));
    AppMethodBeat.o(193372);
  }
  
  public static void init(APLogInfo paramAPLogInfo)
  {
    AppMethodBeat.i(193370);
    if (paramAPLogInfo == null)
    {
      AppMethodBeat.o(193370);
      return;
    }
    try
    {
      APLogDataReporter.getInstance().report("init", "sdk.log.init", "");
      logInfo = paramAPLogInfo;
      paramAPLogInfo.init();
      APLogFileInfo.create();
      APLogFileUtil.readLogKeepConf(logInfo.getContext());
      shouldPrintLog = logInfo.shouldPrintLog();
      if (APLogFileUtil.initLogDir(APLogFileInfo.dirName))
      {
        shouldWriteLog = logInfo.isWriteLog();
        logger = APLogger.open();
      }
      AppMethodBeat.o(193370);
      return;
    }
    catch (Throwable paramAPLogInfo)
    {
      APLogDataReporter.getInstance().report("init", "sdk.log.error.init", paramAPLogInfo.getClass().getName() + paramAPLogInfo.getMessage());
      new StringBuilder("Log init failed: ").append(paramAPLogInfo.toString());
      AppMethodBeat.o(193370);
    }
  }
  
  public static void s(String paramString1, String paramString2)
  {
    AppMethodBeat.i(193383);
    writeLog(composeLogMsg(paramString1, paramString2));
    AppMethodBeat.o(193383);
  }
  
  public static void s(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(193384);
    s(paramString1, String.format(paramString2, paramVarArgs));
    AppMethodBeat.o(193384);
  }
  
  public static void s(boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(193381);
    paramString1 = composeLogMsg(paramString1, paramString2);
    if ((shouldPrintLog) && (!paramBoolean)) {
      APLogger.log(6, logInfo.getLogTag(), paramString1);
    }
    writeLog(paramString1);
    AppMethodBeat.o(193381);
  }
  
  public static void s(boolean paramBoolean, String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(193382);
    s(paramBoolean, paramString1, String.format(paramString2, paramVarArgs));
    AppMethodBeat.o(193382);
  }
  
  public static void v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(193375);
    paramString1 = composeLogMsg(paramString1, paramString2);
    if (shouldPrintLog) {
      APLogger.log(1, logInfo.getLogTag(), paramString1);
    }
    writeLog(paramString1);
    AppMethodBeat.o(193375);
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(193376);
    v(paramString1, String.format(paramString2, paramVarArgs));
    AppMethodBeat.o(193376);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(193377);
    paramString1 = composeLogMsg(paramString1, paramString2);
    if (shouldPrintLog) {
      APLogger.log(4, logInfo.getLogTag(), paramString1);
    }
    writeLog(paramString1);
    AppMethodBeat.o(193377);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(193378);
    w(paramString1, String.format(paramString2, paramVarArgs));
    AppMethodBeat.o(193378);
  }
  
  private static void write(String paramString)
  {
    AppMethodBeat.i(193386);
    try
    {
      if (logger != null) {
        logger.write(paramString);
      }
      AppMethodBeat.o(193386);
      return;
    }
    catch (Throwable paramString)
    {
      new StringBuilder("Log write error: ").append(paramString.toString());
      AppMethodBeat.o(193386);
    }
  }
  
  private static void writeLog(String paramString)
  {
    AppMethodBeat.i(193385);
    if (shouldWriteLog) {
      write(paramString);
    }
    AppMethodBeat.o(193385);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.midas.comm.APLog
 * JD-Core Version:    0.7.0.1
 */