package com.tencent.mobileqq.pluginsdk;

import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;

public class PluginManagerClient
{
  RemotePluginManager a;
  
  public PluginManagerClient(RemotePluginManager paramRemotePluginManager)
  {
    this.a = paramRemotePluginManager;
  }
  
  public void cancelInstall(String paramString)
  {
    try
    {
      this.a.cancelInstall(paramString);
      return;
    }
    catch (RemoteException paramString) {}
  }
  
  public void destory()
  {
    this.a = null;
  }
  
  public void installPlugin(String paramString)
  {
    try
    {
      this.a.installPlugin(paramString, null);
      return;
    }
    catch (RemoteException paramString) {}
  }
  
  public void installPlugin(String paramString, OnPluginInstallListener paramOnPluginInstallListener)
  {
    try
    {
      this.a.installPlugin(paramString, paramOnPluginInstallListener);
      return;
    }
    catch (RemoteException paramString) {}
  }
  
  public boolean isPluginInstalled(String paramString)
  {
    try
    {
      boolean bool = this.a.isPlugininstalled(paramString);
      return bool;
    }
    catch (RemoteException paramString) {}
    return false;
  }
  
  public boolean isReady()
  {
    try
    {
      boolean bool = this.a.isReady();
      return bool;
    }
    catch (RemoteException localRemoteException) {}
    return false;
  }
  
  public PluginBaseInfo queryPlugin(String paramString)
  {
    try
    {
      paramString = this.a.queryPlugin(paramString);
      return paramString;
    }
    catch (RemoteException paramString) {}
    return null;
  }
  
  public boolean useful()
  {
    bool2 = false;
    bool1 = bool2;
    if (this.a != null) {}
    try
    {
      IBinder localIBinder = this.a.asBinder();
      bool1 = bool2;
      if (localIBinder != null)
      {
        bool1 = bool2;
        if (localIBinder.isBinderAlive())
        {
          boolean bool3 = localIBinder.pingBinder();
          bool1 = bool2;
          if (bool3) {
            bool1 = true;
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        bool1 = bool2;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("plugin_tag", 2, " useful: " + bool1);
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginManagerClient
 * JD-Core Version:    0.7.0.1
 */