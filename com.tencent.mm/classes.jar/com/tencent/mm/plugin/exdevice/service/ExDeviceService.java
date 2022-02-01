package com.tencent.mm.plugin.exdevice.service;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.IBinder;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.k;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.service.MMService;

@k
public class ExDeviceService
  extends MMService
{
  private h.a oZf = null;
  
  private static boolean bZX()
  {
    AppMethodBeat.i(23637);
    PackageManager localPackageManager = aj.getContext().getPackageManager();
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
    ad.i("MicroMsg.exdevice.ExDeviceService", "isInstallWearApp %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(23637);
    return bool;
  }
  
  public final IBinder TF()
  {
    AppMethodBeat.i(23638);
    ad.i("MicroMsg.exdevice.ExDeviceService", "ExDeviceService onBind");
    if (this.oZf == null) {
      this.oZf = new y();
    }
    h.a locala = this.oZf;
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
    ad.i("MicroMsg.exdevice.ExDeviceService", "ExDeviceService onCreate");
    super.onCreate();
    AppMethodBeat.o(23635);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(23636);
    ad.i("MicroMsg.exdevice.ExDeviceService", "ExDeviceService onDestroy");
    Java2CExDevice.closeBluetoothAccessoryLib();
    super.onDestroy();
    if (!bZX())
    {
      ad.i("MicroMsg.exdevice.ExDeviceService", "kill exdevice process now");
      Process.killProcess(Process.myPid());
    }
    AppMethodBeat.o(23636);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.ExDeviceService
 * JD-Core Version:    0.7.0.1
 */