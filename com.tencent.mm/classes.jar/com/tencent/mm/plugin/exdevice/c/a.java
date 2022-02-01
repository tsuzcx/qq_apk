package com.tencent.mm.plugin.exdevice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.j.e;
import com.tencent.mm.plugin.exdevice.j.f;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.plugin.exdevice.model.c;
import com.tencent.mm.plugin.exdevice.service.i.a;
import com.tencent.mm.plugin.exdevice.service.u;

public final class a
  extends i.a
{
  private static a qgx = null;
  
  public static a cmc()
  {
    AppMethodBeat.i(23145);
    if (qgx == null)
    {
      locala = new a();
      qgx = locala;
      AppMethodBeat.o(23145);
      return locala;
    }
    a locala = qgx;
    AppMethodBeat.o(23145);
    return locala;
  }
  
  public final void a(int paramInt1, long paramLong, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23146);
    if (paramArrayOfByte == null)
    {
      i = -1;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.DeviceRequestManager", "------onDeviceRequest------ errorCode = %d, deviceId = %d, seq = %d, cmdId = %d, datalength = %d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(i) });
      if (paramInt1 != 0) {
        break label110;
      }
    }
    String str;
    label110:
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.exdevice.h.a.t(paramLong, i);
      str = b.bf(paramArrayOfByte);
      if (str != null) {
        break label116;
      }
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.exdevice.DeviceRequestManager", "dataIn is null!!! Just leave without process data");
      AppMethodBeat.o(23146);
      return;
      i = paramArrayOfByte.length;
      break;
    }
    label116:
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.exdevice.DeviceRequestManager", "data dump = %s", new Object[] { str });
    new a(paramInt1, paramLong, paramInt2, paramInt3, paramArrayOfByte).cmd();
    AppMethodBeat.o(23146);
  }
  
  static final class a
    implements Runnable
  {
    private int mCmdId = -1;
    private long nZd = -1L;
    private byte[] qgA = null;
    private int qgy = -1;
    private int qgz;
    
    public a(int paramInt1, long paramLong, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
    {
      this.nZd = paramLong;
      this.qgy = paramInt2;
      this.mCmdId = paramInt3;
      this.qgA = paramArrayOfByte;
      this.qgz = paramInt1;
    }
    
    public final void cmd()
    {
      AppMethodBeat.i(23143);
      if ((this.nZd == -1L) || (this.qgy == -1) || (this.mCmdId == -1))
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.RequestProcessThread", "invalid arguments, do nothing");
        AppMethodBeat.o(23143);
        return;
      }
      switch (this.mCmdId)
      {
      default: 
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.RequestProcessThread", "unknown cmdId = %d, do nothing", new Object[] { Integer.valueOf(this.mCmdId) });
        AppMethodBeat.o(23143);
        return;
      case 10001: 
        localObject = new e(this.qgz, this.nZd, this.qgy, this.mCmdId, this.qgA);
        u.cnl().a((com.tencent.mm.plugin.exdevice.model.ae)localObject);
        AppMethodBeat.o(23143);
        return;
      case 10002: 
        k.cmj().b(this.qgz, this.nZd, this.qgy, this.mCmdId, this.qgA);
        AppMethodBeat.o(23143);
        return;
      }
      Object localObject = new f(this.qgz, this.nZd, this.qgy, this.mCmdId, this.qgA);
      u.cnl().a((com.tencent.mm.plugin.exdevice.model.ae)localObject);
      AppMethodBeat.o(23143);
    }
    
    public final void run()
    {
      AppMethodBeat.i(23144);
      cmd();
      AppMethodBeat.o(23144);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.c.a
 * JD-Core Version:    0.7.0.1
 */