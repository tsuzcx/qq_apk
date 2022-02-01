package com.tencent.midas.proxyactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.plugin.APPluginProxyActivity;

public class APMidasPayProxyActivity
  extends APPluginProxyActivity
{
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(192800);
    APLog.i("APMidasPayProxyActivity", "onActivityResult requestCode:" + paramInt1 + " resultCode:" + paramInt2);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(192800);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(192799);
    super.onCreate(paramBundle);
    AppMethodBeat.o(192799);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.midas.proxyactivity.APMidasPayProxyActivity
 * JD-Core Version:    0.7.0.1
 */