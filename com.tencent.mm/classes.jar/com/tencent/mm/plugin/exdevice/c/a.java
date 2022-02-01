package com.tencent.mm.plugin.exdevice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.plugin.exdevice.service.i.a;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  extends i.a
{
  private static a pZS = null;
  
  public static a ckM()
  {
    AppMethodBeat.i(23145);
    if (pZS == null)
    {
      locala = new a();
      pZS = locala;
      AppMethodBeat.o(23145);
      return locala;
    }
    a locala = pZS;
    AppMethodBeat.o(23145);
    return locala;
  }
  
  public final void a(int paramInt1, long paramLong, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23146);
    if (paramArrayOfByte == null)
    {
      i = -1;
      ad.i("MicroMsg.exdevice.DeviceRequestManager", "------onDeviceRequest------ errorCode = %d, deviceId = %d, seq = %d, cmdId = %d, datalength = %d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(i) });
      if (paramInt1 != 0) {
        break label110;
      }
    }
    String str;
    label110:
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.exdevice.h.a.t(paramLong, i);
      str = b.bg(paramArrayOfByte);
      if (str != null) {
        break label116;
      }
      ad.e("MicroMsg.exdevice.DeviceRequestManager", "dataIn is null!!! Just leave without process data");
      AppMethodBeat.o(23146);
      return;
      i = paramArrayOfByte.length;
      break;
    }
    label116:
    ad.d("MicroMsg.exdevice.DeviceRequestManager", "data dump = %s", new Object[] { str });
    new a.a(paramInt1, paramLong, paramInt2, paramInt3, paramArrayOfByte).ckN();
    AppMethodBeat.o(23146);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.c.a
 * JD-Core Version:    0.7.0.1
 */