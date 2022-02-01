package com.tencent.midas.wx;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.control.APMidasPayHelper;
import com.tencent.midas.plugin.APPluginInterfaceManager;
import com.tencent.mm.hellhoundlib.activities.HellActivity;

public class APMidasWXPayActivity
  extends HellActivity
{
  private static final String TAG = "APMidasWXPayActivity";
  
  private void handleIntent(Intent paramIntent)
  {
    AppMethodBeat.i(216975);
    APLog.d("APMidasWXPayActivity", "handleIntent get called!");
    try
    {
      APPluginInterfaceManager.initPluginInterface(this, APMidasPayHelper.MIDAS_PLUGIN_NAME, APMidasPayHelper.PKG_DISTRIBUTE, APMidasPayHelper.MED_DISTRIBUTE_HANDLE_WX_INTENT, new Object[] { this, paramIntent });
      AppMethodBeat.o(216975);
      return;
    }
    catch (Exception paramIntent)
    {
      APLog.e("APMidasWXPayActivity", "handleIntent got exception = " + paramIntent.toString());
      AppMethodBeat.o(216975);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(216981);
    super.onCreate(paramBundle);
    try
    {
      getIntent().getStringExtra("wxpay");
      return;
    }
    catch (Exception paramBundle)
    {
      try
      {
        requestWindowFeature(1);
        handleIntent(getIntent());
        return;
      }
      finally
      {
        finish();
        AppMethodBeat.o(216981);
      }
      paramBundle = paramBundle;
      finish();
      AppMethodBeat.o(216981);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.midas.wx.APMidasWXPayActivity
 * JD-Core Version:    0.7.0.1
 */