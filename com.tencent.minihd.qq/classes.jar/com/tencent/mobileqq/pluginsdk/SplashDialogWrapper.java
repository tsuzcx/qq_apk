package com.tencent.mobileqq.pluginsdk;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;

public final class SplashDialogWrapper
{
  private Dialog a;
  private Context b;
  private Handler c = new a(this);
  private BroadcastReceiver d = null;
  private int e;
  private String f;
  private String g;
  private boolean h;
  
  public SplashDialogWrapper(Context paramContext, Dialog paramDialog, String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    this.b = paramContext;
    this.a = paramDialog;
    this.g = paramString2;
    this.f = paramString1;
    this.h = paramBoolean;
    this.e = paramInt;
  }
  
  public void dismiss()
  {
    if (this.d != null) {}
    try
    {
      this.b.unregisterReceiver(this.d);
      if (DebugHelper.sDebug) {
        DebugHelper.log("plugin_tag", "SplashDialogWrapper.dismiss unregisterReceiver");
      }
      this.d = null;
      this.c.removeMessages(0);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        try
        {
          this.a.dismiss();
          return;
        }
        catch (Exception localException) {}
        localIllegalArgumentException = localIllegalArgumentException;
        localIllegalArgumentException.printStackTrace();
      }
    }
  }
  
  public void show()
  {
    this.c.sendEmptyMessageDelayed(0, this.e);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("action_launch_completed");
    this.d = new b(this.f, this.g);
    if (DebugHelper.sDebug) {
      DebugHelper.log("plugin_tag", "SplashDialogWrapper.show registerReceiver");
    }
    this.b.registerReceiver(this.d, localIntentFilter);
    try
    {
      this.a.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  public static class LaunchCompletedIntent
    extends Intent
  {
    public static final String ACTION_LAUNCH_COMPLETED = "action_launch_completed";
    public static final String PARAM_PLUGIN_APK = "plugin_apk";
    public static final String PARAM_PLUGIN_NAME = "plugin_name";
  }
  
  private static class a
    extends Handler
  {
    public static final int a = 0;
    private SplashDialogWrapper b = null;
    
    public a(SplashDialogWrapper paramSplashDialogWrapper)
    {
      this.b = paramSplashDialogWrapper;
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        return;
      }
      this.b.dismiss();
    }
  }
  
  private class b
    extends BroadcastReceiver
  {
    private String b;
    private String c;
    
    public b(String paramString1, String paramString2)
    {
      this.b = paramString1;
      this.c = paramString2;
    }
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      paramContext = paramIntent.getStringExtra("plugin_apk");
      paramIntent = paramIntent.getStringExtra("plugin_name");
      if (DebugHelper.sDebug) {
        DebugHelper.log("plugin_tag", "LaunchCompletedObserver.onReceive: " + paramContext + ", " + paramIntent + ", " + SplashDialogWrapper.a(SplashDialogWrapper.this));
      }
      if ((this.c.equalsIgnoreCase(paramContext)) && ((SplashDialogWrapper.a(SplashDialogWrapper.this)) || (paramIntent != null))) {
        SplashDialogWrapper.this.dismiss();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.SplashDialogWrapper
 * JD-Core Version:    0.7.0.1
 */