package com.tencent.mm.plugin.exdevice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ef;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.c;
import com.tencent.mm.plugin.exdevice.model.d;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;

public final class e
  extends q.a
{
  private static e qmE;
  
  static
  {
    AppMethodBeat.i(23648);
    qmE = new e();
    AppMethodBeat.o(23648);
  }
  
  public static e cnb()
  {
    return qmE;
  }
  
  public final void a(double paramDouble1, int paramInt1, int paramInt2, byte[] paramArrayOfByte, double paramDouble2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(23647);
    ae.d("MicroMsg.exdevice.ExdeviceIBeaconManager", "onRangdingCallback, distance = %f, major = %d, minor = %d, uuid = %s, rssi = %f,aMac = %s,txPower = %d", new Object[] { Double.valueOf(paramDouble1), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), b.bf(paramArrayOfByte), Double.valueOf(paramDouble2), paramString, Integer.valueOf(paramInt3) });
    ef localef = new ef();
    String str = b.bf(paramArrayOfByte);
    paramArrayOfByte = str;
    if (str.length() >= 32) {
      paramArrayOfByte = str.substring(0, 8) + "-" + str.substring(8, 12) + "-" + str.substring(12, 16) + "-" + str.substring(16, 20) + "-" + str.substring(20);
    }
    localef.dqt.dqr = paramArrayOfByte;
    localef.dqt.dqw = paramDouble1;
    localef.dqt.dqu = paramInt1;
    localef.dqt.dqv = paramInt2;
    localef.dqt.dqx = paramDouble2;
    localef.dqt.dqy = paramString;
    localef.dqt.dqz = paramInt3;
    a.IvT.l(localef);
    AppMethodBeat.o(23647);
  }
  
  public final boolean aT(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(23646);
    ae.i("MicroMsg.exdevice.ExdeviceIBeaconManager", "ranging, uuid = %s, op = %s", new Object[] { paramString, String.valueOf(paramBoolean) });
    if (paramString == null)
    {
      ae.e("MicroMsg.exdevice.ExdeviceIBeaconManager", "uuid is null");
      AppMethodBeat.o(23646);
      return false;
    }
    if (u.cnl().qgX == null)
    {
      ae.e("MicroMsg.exdevice.ExdeviceIBeaconManager", "MMExDeviceCore.getTaskQueue().getDispatcher() is null !!!now retry invoke doTaskAfterServiceStarted!");
      ad.cmQ().ag(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(23645);
          if (u.cnl().qgX != null) {
            u.cnl().qgX.a(paramString, paramBoolean, e.this);
          }
          AppMethodBeat.o(23645);
        }
      });
      AppMethodBeat.o(23646);
      return false;
    }
    paramBoolean = u.cnl().qgX.a(paramString, paramBoolean, this);
    AppMethodBeat.o(23646);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.e
 * JD-Core Version:    0.7.0.1
 */