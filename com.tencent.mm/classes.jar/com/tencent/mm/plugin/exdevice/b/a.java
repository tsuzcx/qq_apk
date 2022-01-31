package com.tencent.mm.plugin.exdevice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.service.i.a;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
  extends i.a
{
  private static a lCq = null;
  
  public static a bps()
  {
    AppMethodBeat.i(19037);
    if (lCq == null)
    {
      locala = new a();
      lCq = locala;
      AppMethodBeat.o(19037);
      return locala;
    }
    a locala = lCq;
    AppMethodBeat.o(19037);
    return locala;
  }
  
  public final void a(int paramInt1, long paramLong, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(19038);
    if (paramArrayOfByte == null)
    {
      i = -1;
      ab.i("MicroMsg.exdevice.DeviceRequestManager", "------onDeviceRequest------ errorCode = %d, deviceId = %d, seq = %d, cmdId = %d, datalength = %d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(i) });
      if (paramInt1 != 0) {
        break label110;
      }
    }
    String str;
    label110:
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.exdevice.g.a.p(paramLong, i);
      str = b.aO(paramArrayOfByte);
      if (str != null) {
        break label116;
      }
      ab.e("MicroMsg.exdevice.DeviceRequestManager", "dataIn is null!!! Just leave without process data");
      AppMethodBeat.o(19038);
      return;
      i = paramArrayOfByte.length;
      break;
    }
    label116:
    ab.d("MicroMsg.exdevice.DeviceRequestManager", "data dump = %s", new Object[] { str });
    new a.a(paramInt1, paramLong, paramInt2, paramInt3, paramArrayOfByte).bpt();
    AppMethodBeat.o(19038);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.b.a
 * JD-Core Version:    0.7.0.1
 */