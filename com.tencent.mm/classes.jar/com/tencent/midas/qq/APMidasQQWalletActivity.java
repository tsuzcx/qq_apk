package com.tencent.midas.qq;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.control.APMidasPayHelper;
import com.tencent.midas.plugin.APPluginInterfaceManager;
import com.tencent.mm.hellhoundlib.activities.HellActivity;

public class APMidasQQWalletActivity
  extends HellActivity
{
  private static final String TAG = "APMidasQQWalletActivity";
  
  private void handleIntent(Intent paramIntent)
  {
    AppMethodBeat.i(192798);
    APLog.d("APMidasQQWalletActivity", "handleIntent get called!");
    try
    {
      APPluginInterfaceManager.initPluginInterface(this, APMidasPayHelper.MIDAS_PLUGIN_NAME, APMidasPayHelper.PKG_DISTRIBUTE, APMidasPayHelper.MED_DISTRIBUTE_HANDLE_QQ_WALLET_INTENT, new Object[] { this, paramIntent });
      AppMethodBeat.o(192798);
      return;
    }
    catch (Exception paramIntent)
    {
      APLog.e("APMidasQQWalletActivity", "handleIntent got exception = " + paramIntent.toString());
      AppMethodBeat.o(192798);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(192797);
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
        finish();
        AppMethodBeat.o(192797);
        return;
      }
      catch (Throwable paramBundle)
      {
        finish();
        AppMethodBeat.o(192797);
      }
      paramBundle = paramBundle;
      finish();
      AppMethodBeat.o(192797);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.midas.qq.APMidasQQWalletActivity
 * JD-Core Version:    0.7.0.1
 */