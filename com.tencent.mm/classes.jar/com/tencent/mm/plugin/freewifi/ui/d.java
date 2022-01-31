package com.tencent.mm.plugin.freewifi.ui;

import android.os.Looper;
import com.tencent.mm.modelgeo.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

public final class d
{
  public static void wn()
  {
    try
    {
      c localc = c.aVa();
      d.1 local1 = new d.1();
      if (!localc.isRunning)
      {
        localc.isRunning = true;
        localc.krY = com.tencent.mm.modelgeo.c.Ob();
        if (localc.krY == null)
        {
          y.e(c.TAG, "doGeoLocation fail, iGetLocation is null");
          return;
        }
        if (localc.krZ == null) {
          localc.krZ = new c.1(localc, local1);
        }
        if (localc.ksa == null) {
          localc.ksa = new ah(Looper.myLooper());
        }
        localc.ksa.postDelayed(new c.2(localc), 20000L);
        localc.krY.a(localc.krZ);
        return;
      }
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.FreeWifi.FreeWifiLocationReporter", "report location error. " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.d
 * JD-Core Version:    0.7.0.1
 */