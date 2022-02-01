package com.tencent.mm.plugin.exdevice.service;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.IBinder;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.kernel.k;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.service.MMService;

@k
public class ExDeviceService
  extends MMService
{
  private h.a qmA = null;
  
  private static boolean cna()
  {
    AppMethodBeat.i(23637);
    PackageManager localPackageManager = ak.getContext().getPackageManager();
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
    ae.i("MicroMsg.exdevice.ExDeviceService", "isInstallWearApp %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(23637);
    return bool;
  }
  
  public final IBinder WY()
  {
    AppMethodBeat.i(23638);
    ae.i("MicroMsg.exdevice.ExDeviceService", "ExDeviceService onBind");
    if (this.qmA == null) {
      this.qmA = new y();
    }
    h.a locala = this.qmA;
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
    ae.i("MicroMsg.exdevice.ExDeviceService", "ExDeviceService onCreate");
    super.onCreate();
    AppMethodBeat.o(23635);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(23636);
    ae.i("MicroMsg.exdevice.ExDeviceService", "ExDeviceService onDestroy");
    Java2CExDevice.closeBluetoothAccessoryLib();
    super.onDestroy();
    if (!cna())
    {
      ae.i("MicroMsg.exdevice.ExDeviceService", "kill exdevice process now");
      com.tencent.mm.hellhoundlib.b.a locala = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahE(), "com/tencent/mm/plugin/exdevice/service/ExDeviceService", "killProcess", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      Process.killProcess(((Integer)locala.mt(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/exdevice/service/ExDeviceService", "killProcess", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    }
    AppMethodBeat.o(23636);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.ExDeviceService
 * JD-Core Version:    0.7.0.1
 */