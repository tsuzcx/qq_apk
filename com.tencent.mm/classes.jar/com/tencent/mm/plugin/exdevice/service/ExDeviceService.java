package com.tencent.mm.plugin.exdevice.service;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.IBinder;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.k;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.service.MMService;

@k
public class ExDeviceService
  extends MMService
{
  private h.a pCq = null;
  
  private static boolean chg()
  {
    AppMethodBeat.i(23637);
    PackageManager localPackageManager = ai.getContext().getPackageManager();
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
    ac.i("MicroMsg.exdevice.ExDeviceService", "isInstallWearApp %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(23637);
    return bool;
  }
  
  public final IBinder Uz()
  {
    AppMethodBeat.i(23638);
    ac.i("MicroMsg.exdevice.ExDeviceService", "ExDeviceService onBind");
    if (this.pCq == null) {
      this.pCq = new y();
    }
    h.a locala = this.pCq;
    AppMethodBeat.o(23638);
    return locala;
  }
  
  public final String getTag()
  {
    return "MicroMsg.exdevice.ExDeviceService";
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(23635);
    ac.i("MicroMsg.exdevice.ExDeviceService", "ExDeviceService onCreate");
    super.onCreate();
    AppMethodBeat.o(23635);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(23636);
    ac.i("MicroMsg.exdevice.ExDeviceService", "ExDeviceService onDestroy");
    Java2CExDevice.closeBluetoothAccessoryLib();
    super.onDestroy();
    if (!chg())
    {
      ac.i("MicroMsg.exdevice.ExDeviceService", "kill exdevice process now");
      Process.killProcess(Process.myPid());
    }
    AppMethodBeat.o(23636);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.ExDeviceService
 * JD-Core Version:    0.7.0.1
 */