package com.tencent.midas.api;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.data.APPluginReportManager;
import com.tencent.midas.plugin.APPluginUtils;

final class APMidasPayAPI$1
  extends ResultReceiver
{
  APMidasPayAPI$1(Handler paramHandler, ResultReceiver paramResultReceiver)
  {
    super(paramHandler);
  }
  
  protected final void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(192891);
    APLog.i("APMidasPayAPI", "launchAbility.onReceiveResult() resultCode=" + paramInt + ", resultData=" + paramBundle);
    if (this.val$resultReceiver != null)
    {
      this.val$resultReceiver.send(paramInt, paramBundle);
      APPluginReportManager.getInstance().dataReport("launchAbility");
      APPluginUtils.release();
      APLog.closeLog();
    }
    AppMethodBeat.o(192891);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.midas.api.APMidasPayAPI.1
 * JD-Core Version:    0.7.0.1
 */