package com.tencent.midas.control;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.plugin.APPluginInterfaceManager;

class APMidasPayHelper$5
  extends ResultReceiver
{
  APMidasPayHelper$5(APMidasPayHelper paramAPMidasPayHelper, Handler paramHandler, Context paramContext, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(192949);
    if (paramInt == 0) {
      try
      {
        this.this$0.retobj = APPluginInterfaceManager.initPluginInterface(this.val$context, APMidasPayHelper.MIDAS_PLUGIN_NAME, APMidasPayHelper.PKG_DISTRIBUTE, APMidasPayHelper.MED_DISTRIBUTE_RECEIVE, new Object[] { this.val$context, this.val$bundle, this.val$resultReceiver }, new Class[] { Context.class, Bundle.class, ResultReceiver.class });
        AppMethodBeat.o(192949);
        return;
      }
      catch (Exception paramBundle)
      {
        APLog.e("APMidasPayHelper", "sendMidas() e = " + paramBundle.toString());
        AppMethodBeat.o(192949);
        return;
      }
    }
    if (this.val$resultReceiver != null)
    {
      String str = this.val$bundle.getString("__midas_ability_baseReq__postBack");
      Bundle localBundle = new Bundle();
      localBundle.putString("midas_callback_ability_postBack", str);
      localBundle.putInt("midas_callback_ability_code", -1999);
      localBundle.putString("midas_callback_ability_msg", "MidasPlugin load failure");
      localBundle.putBundle("midas_callback_ability_data", paramBundle);
      this.val$resultReceiver.send(-1, localBundle);
    }
    AppMethodBeat.o(192949);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.midas.control.APMidasPayHelper.5
 * JD-Core Version:    0.7.0.1
 */