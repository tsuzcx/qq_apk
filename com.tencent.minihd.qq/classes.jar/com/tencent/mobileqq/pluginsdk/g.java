package com.tencent.mobileqq.pluginsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class g
  extends BroadcastReceiver
{
  g(PluginProxyActivity paramPluginProxyActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((PluginProxyActivity.mGestureLockEnable) && (this.a.mStopFlag == 0) && (this.a.getGestureLock(this.a, PluginProxyActivity.a()))) {
      this.a.startUnlockActivity();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.g
 * JD-Core Version:    0.7.0.1
 */