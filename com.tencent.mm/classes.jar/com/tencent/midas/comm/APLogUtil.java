package com.tencent.midas.comm;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogDataReporter;
import com.tencent.midas.comm.log.util.APLogDataReporter.Reporter;
import com.tencent.midas.data.APPluginReportManager;

public class APLogUtil
{
  private static boolean HAS_INIT_LOG_IN_NEW_PROCESS = false;
  public static boolean IS_IN_NEW_PROCESS = false;
  
  public static void flushIfNewProcess()
  {
    AppMethodBeat.i(217183);
    if ((IS_IN_NEW_PROCESS) && (APLog.getLogInfo() != null) && (!APLog.getLogInfo().isAutoFlush())) {
      APLog.flush();
    }
    AppMethodBeat.o(217183);
  }
  
  public static void initAPLogIfNewProcess(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    AppMethodBeat.i(217168);
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
            AppMethodBeat.i(217187);
            APPluginReportManager.getInstance().insertData(paramAnonymousString1, paramAnonymousString2, "", paramAnonymousString3);
            AppMethodBeat.o(217187);
          }
        });
        localAPLogInfo.setContext(paramContext);
        localAPLogInfo.setLogEnable(paramBoolean2);
        localAPLogInfo.setAutoFlush(true);
        localAPLogInfo.setLogTag("TencentPay");
        localAPLogInfo.setLogCallbackClassName(paramString);
        APLog.init(localAPLogInfo);
        HAS_INIT_LOG_IN_NEW_PROCESS = true;
        AppMethodBeat.o(217168);
        return;
      }
      finally
      {
        APLog.e("APLogUtil init", paramContext.toString());
      }
    }
    AppMethodBeat.o(217168);
  }
  
  public static void initAPLogInPlugin(Context paramContext, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(217177);
    try
    {
      APLogInfo localAPLogInfo = new APLogInfo();
      APLogDataReporter.getInstance().setReporter(new APLogDataReporter.Reporter()
      {
        public final void report(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
        {
          AppMethodBeat.i(217172);
          APPluginReportManager.getInstance().insertData(paramAnonymousString1, paramAnonymousString2, "", paramAnonymousString3);
          AppMethodBeat.o(217172);
        }
      });
      localAPLogInfo.setContext(paramContext);
      localAPLogInfo.setLogEnable(paramBoolean);
      localAPLogInfo.setAutoFlush(true);
      localAPLogInfo.setLogTag("TencentPay");
      localAPLogInfo.setLogCallbackClassName(paramString);
      APLog.init(localAPLogInfo);
      AppMethodBeat.o(217177);
      return;
    }
    finally
    {
      APLog.e("APLogUtil init", paramContext.toString());
      AppMethodBeat.o(217177);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.midas.comm.APLogUtil
 * JD-Core Version:    0.7.0.1
 */