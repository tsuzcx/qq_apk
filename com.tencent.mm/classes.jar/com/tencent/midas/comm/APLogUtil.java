package com.tencent.midas.comm;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogDataReporter;
import com.tencent.midas.comm.log.util.APLogDataReporter.Reporter;
import com.tencent.midas.data.APPluginReportManager;

public class APLogUtil
{
  private static boolean HAS_INIT_LOG_IN_NEW_PROCESS = false;
  public static boolean IS_IN_NEW_PROCESS = true;
  
  public static void flushIfNewProcess()
  {
    AppMethodBeat.i(253572);
    if ((IS_IN_NEW_PROCESS) && (APLog.getLogInfo() != null) && (!APLog.getLogInfo().isAutoFlush())) {
      APLog.flush();
    }
    AppMethodBeat.o(253572);
  }
  
  public static void initAPLogIfNewProcess(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    AppMethodBeat.i(253567);
    if ((paramBoolean1) && (!HAS_INIT_LOG_IN_NEW_PROCESS))
    {
      IS_IN_NEW_PROCESS = true;
      try
      {
        APLogInfo localAPLogInfo = new APLogInfo();
        APLogDataReporter.getInstance().setReporter(new APLogDataReporter.Reporter()
        {
          public final void report(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
          {
            AppMethodBeat.i(253586);
            APPluginReportManager.getInstance().insertData(paramAnonymousString1, paramAnonymousString2, "", paramAnonymousString3);
            AppMethodBeat.o(253586);
          }
        });
        localAPLogInfo.setContext(paramContext);
        localAPLogInfo.setLogEnable(paramBoolean2);
        localAPLogInfo.setAutoFlush(true);
        localAPLogInfo.setLogTag("TencentPay");
        localAPLogInfo.setLogCallbackClassName(paramString);
        APLog.init(localAPLogInfo);
        HAS_INIT_LOG_IN_NEW_PROCESS = true;
        AppMethodBeat.o(253567);
        return;
      }
      catch (Throwable paramContext)
      {
        APLog.e("APLogUtil init", paramContext.toString());
      }
    }
    AppMethodBeat.o(253567);
  }
  
  public static void initAPLogInPlugin(Context paramContext, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(253570);
    try
    {
      APLogInfo localAPLogInfo = new APLogInfo();
      APLogDataReporter.getInstance().setReporter(new APLogDataReporter.Reporter()
      {
        public final void report(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
        {
          AppMethodBeat.i(253566);
          APPluginReportManager.getInstance().insertData(paramAnonymousString1, paramAnonymousString2, "", paramAnonymousString3);
          AppMethodBeat.o(253566);
        }
      });
      localAPLogInfo.setContext(paramContext);
      localAPLogInfo.setLogEnable(paramBoolean);
      localAPLogInfo.setAutoFlush(true);
      localAPLogInfo.setLogTag("TencentPay");
      localAPLogInfo.setLogCallbackClassName(paramString);
      APLog.init(localAPLogInfo);
      AppMethodBeat.o(253570);
      return;
    }
    catch (Throwable paramContext)
    {
      APLog.e("APLogUtil init", paramContext.toString());
      AppMethodBeat.o(253570);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.midas.comm.APLogUtil
 * JD-Core Version:    0.7.0.1
 */