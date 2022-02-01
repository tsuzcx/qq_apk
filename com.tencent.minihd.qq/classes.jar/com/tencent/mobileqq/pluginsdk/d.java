package com.tencent.mobileqq.pluginsdk;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

final class d
  implements ServiceConnection
{
  private void a()
  {
    if (PluginInterfaceHelper.a() != null)
    {
      PluginInterfaceHelper.a().clear();
      PluginInterfaceHelper.a(null);
    }
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (QLog.isColorLevel()) {
      QLog.i("plugin_tag", 2, "onServiceConnected");
    }
    if (PluginInterfaceHelper.a() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("plugin_tag", 2, "return WeakReference<OnPluginInterfaceReadyListener> is null");
      }
      a();
      return;
    }
    paramComponentName = (PluginInterfaceHelper.OnPluginInterfaceLoadedListener)PluginInterfaceHelper.a().get();
    if (paramComponentName == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("plugin_tag", 2, "return OnPluginInterfaceReadyListener is null");
      }
      a();
      return;
    }
    if ((paramIBinder != null) && (paramIBinder.isBinderAlive()) && (paramIBinder.pingBinder()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("plugin_tag", 2, "binder alive");
      }
      PluginInterfaceHelper.a(new PluginInterface(paramIBinder));
      paramComponentName.onPluginInterfaceLoaded(PluginInterfaceHelper.b());
    }
    for (;;)
    {
      a();
      return;
      if (QLog.isColorLevel()) {
        QLog.i("plugin_tag", 2, "binder not alive");
      }
      paramComponentName.onPluginInterfaceLoaded(null);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (QLog.isColorLevel()) {
      QLog.i("plugin_tag", 2, "onServiceDisconnected");
    }
    paramComponentName = PluginInterfaceHelper.b();
    if (paramComponentName != null) {
      paramComponentName.destory();
    }
    PluginInterfaceHelper.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.d
 * JD-Core Version:    0.7.0.1
 */