package com.tencent.mm.plugin.exdevice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.du;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.c;
import com.tencent.mm.plugin.exdevice.model.d;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;

public final class e
  extends q.a
{
  private static e lIy;
  
  static
  {
    AppMethodBeat.i(19580);
    lIy = new e();
    AppMethodBeat.o(19580);
  }
  
  public static e bqq()
  {
    return lIy;
  }
  
  public final void a(double paramDouble1, int paramInt1, int paramInt2, byte[] paramArrayOfByte, double paramDouble2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(19579);
    ab.d("MicroMsg.exdevice.ExdeviceIBeaconManager", "onRangdingCallback, distance = %f, major = %d, minor = %d, uuid = %s, rssi = %f,aMac = %s,txPower = %d", new Object[] { Double.valueOf(paramDouble1), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), b.aO(paramArrayOfByte), Double.valueOf(paramDouble2), paramString, Integer.valueOf(paramInt3) });
    du localdu = new du();
    String str = b.aO(paramArrayOfByte);
    paramArrayOfByte = str;
    if (str.length() >= 32) {
      paramArrayOfByte = str.substring(0, 8) + "-" + str.substring(8, 12) + "-" + str.substring(12, 16) + "-" + str.substring(16, 20) + "-" + str.substring(20);
    }
    localdu.crB.crz = paramArrayOfByte;
    localdu.crB.crE = paramDouble1;
    localdu.crB.crC = paramInt1;
    localdu.crB.crD = paramInt2;
    localdu.crB.crF = paramDouble2;
    localdu.crB.crG = paramString;
    localdu.crB.crH = paramInt3;
    a.ymk.l(localdu);
    AppMethodBeat.o(19579);
  }
  
  public final boolean aG(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(19578);
    ab.i("MicroMsg.exdevice.ExdeviceIBeaconManager", "ranging, uuid = %s, op = %s", new Object[] { paramString, String.valueOf(paramBoolean) });
    if (paramString == null)
    {
      ab.e("MicroMsg.exdevice.ExdeviceIBeaconManager", "uuid is null");
      AppMethodBeat.o(19578);
      return false;
    }
    if (u.bqA().lCQ == null)
    {
      ab.e("MicroMsg.exdevice.ExdeviceIBeaconManager", "MMExDeviceCore.getTaskQueue().getDispatcher() is null !!!now retry invoke doTaskAfterServiceStarted!");
      ad.bqf().Q(new e.1(this, paramString, paramBoolean));
      AppMethodBeat.o(19578);
      return false;
    }
    paramBoolean = u.bqA().lCQ.a(paramString, paramBoolean, this);
    AppMethodBeat.o(19578);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.e
 * JD-Core Version:    0.7.0.1
 */