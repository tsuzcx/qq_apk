package com.tencent.mm.plugin.exdevice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.fa;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.plugin.exdevice.model.ah;
import com.tencent.mm.plugin.exdevice.model.d;
import com.tencent.mm.plugin.exdevice.model.f;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
  extends q.a
{
  private static e yvi;
  
  static
  {
    AppMethodBeat.i(23648);
    yvi = new e();
    AppMethodBeat.o(23648);
  }
  
  public static e dGj()
  {
    return yvi;
  }
  
  public final void a(double paramDouble1, int paramInt1, int paramInt2, byte[] paramArrayOfByte, double paramDouble2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(23647);
    Log.d("MicroMsg.exdevice.ExdeviceIBeaconManager", "onRangdingCallback, distance = %f, major = %d, minor = %d, uuid = %s, rssi = %f,aMac = %s,txPower = %d", new Object[] { Double.valueOf(paramDouble1), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), b.bK(paramArrayOfByte), Double.valueOf(paramDouble2), paramString, Integer.valueOf(paramInt3) });
    fa localfa = new fa();
    String str = b.bK(paramArrayOfByte);
    paramArrayOfByte = str;
    if (str.length() >= 32) {
      paramArrayOfByte = str.substring(0, 8) + "-" + str.substring(8, 12) + "-" + str.substring(12, 16) + "-" + str.substring(16, 20) + "-" + str.substring(20);
    }
    localfa.hFk.hFi = paramArrayOfByte;
    localfa.hFk.hFn = paramDouble1;
    localfa.hFk.hFl = paramInt1;
    localfa.hFk.hFm = paramInt2;
    localfa.hFk.hFo = paramDouble2;
    localfa.hFk.hFp = paramString;
    localfa.hFk.hFq = paramInt3;
    localfa.publish();
    AppMethodBeat.o(23647);
  }
  
  public final boolean bk(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(23646);
    Log.i("MicroMsg.exdevice.ExdeviceIBeaconManager", "ranging, uuid = %s, op = %s", new Object[] { paramString, String.valueOf(paramBoolean) });
    if (paramString == null)
    {
      Log.e("MicroMsg.exdevice.ExdeviceIBeaconManager", "uuid is null");
      AppMethodBeat.o(23646);
      return false;
    }
    if (u.dGE().yps == null)
    {
      Log.e("MicroMsg.exdevice.ExdeviceIBeaconManager", "MMExDeviceCore.getTaskQueue().getDispatcher() is null !!!now retry invoke doTaskAfterServiceStarted!");
      ah.dFY().az(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(23645);
          if (u.dGE().yps != null) {
            u.dGE().yps.a(paramString, paramBoolean, e.this);
          }
          AppMethodBeat.o(23645);
        }
      });
      AppMethodBeat.o(23646);
      return false;
    }
    paramBoolean = u.dGE().yps.a(paramString, paramBoolean, this);
    AppMethodBeat.o(23646);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.e
 * JD-Core Version:    0.7.0.1
 */