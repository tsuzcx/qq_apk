package com.tencent.mm.plugin.exdevice.service;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.IBinder;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.k;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.service.MMService;

@k
public class ExDeviceService
  extends MMService
{
  private h.a lIu = null;
  
  private static boolean bqp()
  {
    AppMethodBeat.i(19569);
    PackageManager localPackageManager = ah.getContext().getPackageManager();
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
    ab.i("MicroMsg.exdevice.ExDeviceService", "isInstallWearApp %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(19569);
    return bool;
  }
  
  public final IBinder It()
  {
    AppMethodBeat.i(19570);
    ab.i("MicroMsg.exdevice.ExDeviceService", "ExDeviceService onBind");
    if (this.lIu == null) {
      this.lIu = new y();
    }
    h.a locala = this.lIu;
    AppMethodBeat.o(19570);
    return locala;
  }
  
  public final String getTag()
  {
    return "MicroMsg.exdevice.ExDeviceService";
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(19567);
    ab.i("MicroMsg.exdevice.ExDeviceService", "ExDeviceService onCreate");
    super.onCreate();
    AppMethodBeat.o(19567);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(19568);
    ab.i("MicroMsg.exdevice.ExDeviceService", "ExDeviceService onDestroy");
    Java2CExDevice.closeBluetoothAccessoryLib();
    super.onDestroy();
    if (!bqp())
    {
      ab.i("MicroMsg.exdevice.ExDeviceService", "kill exdevice process now");
      Process.killProcess(Process.myPid());
    }
    AppMethodBeat.o(19568);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.ExDeviceService
 * JD-Core Version:    0.7.0.1
 */