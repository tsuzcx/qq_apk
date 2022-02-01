package com.tencent.mm.plugin.exdevice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ee;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.plugin.exdevice.model.c;
import com.tencent.mm.plugin.exdevice.model.d;
import com.tencent.mm.sdk.b.a;

public final class e
  extends q.a
{
  private static e qfZ;
  
  static
  {
    AppMethodBeat.i(23648);
    qfZ = new e();
    AppMethodBeat.o(23648);
  }
  
  public static e clL()
  {
    return qfZ;
  }
  
  public final void a(double paramDouble1, int paramInt1, int paramInt2, byte[] paramArrayOfByte, double paramDouble2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(23647);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.exdevice.ExdeviceIBeaconManager", "onRangdingCallback, distance = %f, major = %d, minor = %d, uuid = %s, rssi = %f,aMac = %s,txPower = %d", new Object[] { Double.valueOf(paramDouble1), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), b.bg(paramArrayOfByte), Double.valueOf(paramDouble2), paramString, Integer.valueOf(paramInt3) });
    ee localee = new ee();
    String str = b.bg(paramArrayOfByte);
    paramArrayOfByte = str;
    if (str.length() >= 32) {
      paramArrayOfByte = str.substring(0, 8) + "-" + str.substring(8, 12) + "-" + str.substring(12, 16) + "-" + str.substring(16, 20) + "-" + str.substring(20);
    }
    localee.dpo.dpm = paramArrayOfByte;
    localee.dpo.dpr = paramDouble1;
    localee.dpo.dpp = paramInt1;
    localee.dpo.dpq = paramInt2;
    localee.dpo.dps = paramDouble2;
    localee.dpo.dpt = paramString;
    localee.dpo.dpu = paramInt3;
    a.IbL.l(localee);
    AppMethodBeat.o(23647);
  }
  
  public final boolean aR(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(23646);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceIBeaconManager", "ranging, uuid = %s, op = %s", new Object[] { paramString, String.valueOf(paramBoolean) });
    if (paramString == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceIBeaconManager", "uuid is null");
      AppMethodBeat.o(23646);
      return false;
    }
    if (u.clV().qas == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceIBeaconManager", "MMExDeviceCore.getTaskQueue().getDispatcher() is null !!!now retry invoke doTaskAfterServiceStarted!");
      com.tencent.mm.plugin.exdevice.model.ad.clA().ai(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(23645);
          if (u.clV().qas != null) {
            u.clV().qas.a(paramString, paramBoolean, e.this);
          }
          AppMethodBeat.o(23645);
        }
      });
      AppMethodBeat.o(23646);
      return false;
    }
    paramBoolean = u.clV().qas.a(paramString, paramBoolean, this);
    AppMethodBeat.o(23646);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.e
 * JD-Core Version:    0.7.0.1
 */