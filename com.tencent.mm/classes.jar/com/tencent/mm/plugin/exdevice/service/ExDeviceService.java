package com.tencent.mm.plugin.exdevice.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.IBinder;
import android.os.Process;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.sdk.platformtools.ae;

public class ExDeviceService
  extends Service
{
  private h.a jyV = null;
  
  private static boolean aMc()
  {
    PackageManager localPackageManager = ae.getContext().getPackageManager();
    try
    {
      localPackageManager.getPackageInfo("com.google.android.wearable.app.cn", 1);
      localPackageManager.getPackageInfo("com.google.android.wearable.app", 1);
      bool = true;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        boolean bool = false;
      }
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.exdevice.ExDeviceService", "isInstallWearApp %b", new Object[] { Boolean.valueOf(bool) });
    return bool;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.exdevice.ExDeviceService", "ExDeviceService onBind");
    if (this.jyV == null) {
      this.jyV = new y();
    }
    return this.jyV;
  }
  
  public void onCreate()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.exdevice.ExDeviceService", "ExDeviceService onCreate");
    super.onCreate();
  }
  
  public void onDestroy()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.exdevice.ExDeviceService", "ExDeviceService onDestroy");
    Java2CExDevice.closeBluetoothAccessoryLib();
    super.onDestroy();
    if (!aMc())
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.exdevice.ExDeviceService", "kill exdevice process now");
      Process.killProcess(Process.myPid());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.ExDeviceService
 * JD-Core Version:    0.7.0.1
 */