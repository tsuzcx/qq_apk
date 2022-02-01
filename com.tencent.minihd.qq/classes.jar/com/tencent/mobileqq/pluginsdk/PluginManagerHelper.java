package com.tencent.mobileqq.pluginsdk;

import android.content.Context;
import android.content.ServiceConnection;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class PluginManagerHelper
{
  private static PluginManagerClient a;
  private static WeakReference b;
  private static ServiceConnection c = new e();
  
  public static void destory(Context paramContext)
  {
    PluginRemoteProcessor.get().cancel(c);
  }
  
  public static void getPluginInterface(Context paramContext, OnPluginManagerLoadedListener paramOnPluginManagerLoadedListener)
  {
    if (QLog.isColorLevel()) {
      QLog.i("plugin_tag", 2, "PluginManagerHelper.getPluginInterface");
    }
    if ((a == null) || (!a.useful()))
    {
      b = new WeakReference(paramOnPluginManagerLoadedListener);
      PluginRemoteProcessor.get().process(paramContext, c, 1);
      return;
    }
    paramOnPluginManagerLoadedListener.onPluginManagerLoaded(a);
  }
  
  public static abstract interface OnPluginManagerLoadedListener
  {
    public abstract void onPluginManagerLoaded(PluginManagerClient paramPluginManagerClient);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginManagerHelper
 * JD-Core Version:    0.7.0.1
 */