package com.tencent.mm.plugin.exdevice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.eb;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.c;
import com.tencent.mm.plugin.exdevice.model.d;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;

public final class e
  extends q.a
{
  private static e pCu;
  
  static
  {
    AppMethodBeat.i(23648);
    pCu = new e();
    AppMethodBeat.o(23648);
  }
  
  public static e chh()
  {
    return pCu;
  }
  
  public final void a(double paramDouble1, int paramInt1, int paramInt2, byte[] paramArrayOfByte, double paramDouble2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(23647);
    ac.d("MicroMsg.exdevice.ExdeviceIBeaconManager", "onRangdingCallback, distance = %f, major = %d, minor = %d, uuid = %s, rssi = %f,aMac = %s,txPower = %d", new Object[] { Double.valueOf(paramDouble1), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), b.bd(paramArrayOfByte), Double.valueOf(paramDouble2), paramString, Integer.valueOf(paramInt3) });
    eb localeb = new eb();
    String str = b.bd(paramArrayOfByte);
    paramArrayOfByte = str;
    if (str.length() >= 32) {
      paramArrayOfByte = str.substring(0, 8) + "-" + str.substring(8, 12) + "-" + str.substring(12, 16) + "-" + str.substring(16, 20) + "-" + str.substring(20);
    }
    localeb.ddS.ddQ = paramArrayOfByte;
    localeb.ddS.ddV = paramDouble1;
    localeb.ddS.ddT = paramInt1;
    localeb.ddS.ddU = paramInt2;
    localeb.ddS.ddW = paramDouble2;
    localeb.ddS.ddX = paramString;
    localeb.ddS.ddY = paramInt3;
    a.GpY.l(localeb);
    AppMethodBeat.o(23647);
  }
  
  public final boolean aP(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(23646);
    ac.i("MicroMsg.exdevice.ExdeviceIBeaconManager", "ranging, uuid = %s, op = %s", new Object[] { paramString, String.valueOf(paramBoolean) });
    if (paramString == null)
    {
      ac.e("MicroMsg.exdevice.ExdeviceIBeaconManager", "uuid is null");
      AppMethodBeat.o(23646);
      return false;
    }
    if (u.chr().pwN == null)
    {
      ac.e("MicroMsg.exdevice.ExdeviceIBeaconManager", "MMExDeviceCore.getTaskQueue().getDispatcher() is null !!!now retry invoke doTaskAfterServiceStarted!");
      ad.cgW().aj(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(23645);
          if (u.chr().pwN != null) {
            u.chr().pwN.a(paramString, paramBoolean, e.this);
          }
          AppMethodBeat.o(23645);
        }
      });
      AppMethodBeat.o(23646);
      return false;
    }
    paramBoolean = u.chr().pwN.a(paramString, paramBoolean, this);
    AppMethodBeat.o(23646);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.e
 * JD-Core Version:    0.7.0.1
 */