package com.tencent.mm.plugin.exdevice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.j.e;
import com.tencent.mm.plugin.exdevice.j.f;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.model.c;
import com.tencent.mm.plugin.exdevice.service.i.a;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends i.a
{
  private static a rxt = null;
  
  public static a cKe()
  {
    AppMethodBeat.i(23145);
    if (rxt == null)
    {
      locala = new a();
      rxt = locala;
      AppMethodBeat.o(23145);
      return locala;
    }
    a locala = rxt;
    AppMethodBeat.o(23145);
    return locala;
  }
  
  public final void a(int paramInt1, long paramLong, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23146);
    if (paramArrayOfByte == null)
    {
      i = -1;
      Log.i("MicroMsg.exdevice.DeviceRequestManager", "------onDeviceRequest------ errorCode = %d, deviceId = %d, seq = %d, cmdId = %d, datalength = %d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(i) });
      if (paramInt1 != 0) {
        break label110;
      }
    }
    String str;
    label110:
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.exdevice.h.a.q(paramLong, i);
      str = b.bw(paramArrayOfByte);
      if (str != null) {
        break label116;
      }
      Log.e("MicroMsg.exdevice.DeviceRequestManager", "dataIn is null!!! Just leave without process data");
      AppMethodBeat.o(23146);
      return;
      i = paramArrayOfByte.length;
      break;
    }
    label116:
    Log.d("MicroMsg.exdevice.DeviceRequestManager", "data dump = %s", new Object[] { str });
    new a(paramInt1, paramLong, paramInt2, paramInt3, paramArrayOfByte).cKf();
    AppMethodBeat.o(23146);
  }
  
  static final class a
    implements Runnable
  {
    private int mCmdId = -1;
    private long pkb = -1L;
    private int rxu = -1;
    private int rxv;
    private byte[] rxw = null;
    
    public a(int paramInt1, long paramLong, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
    {
      this.pkb = paramLong;
      this.rxu = paramInt2;
      this.mCmdId = paramInt3;
      this.rxw = paramArrayOfByte;
      this.rxv = paramInt1;
    }
    
    public final void cKf()
    {
      AppMethodBeat.i(23143);
      if ((this.pkb == -1L) || (this.rxu == -1) || (this.mCmdId == -1))
      {
        Log.e("MicroMsg.RequestProcessThread", "invalid arguments, do nothing");
        AppMethodBeat.o(23143);
        return;
      }
      switch (this.mCmdId)
      {
      default: 
        Log.e("MicroMsg.RequestProcessThread", "unknown cmdId = %d, do nothing", new Object[] { Integer.valueOf(this.mCmdId) });
        AppMethodBeat.o(23143);
        return;
      case 10001: 
        localObject = new e(this.rxv, this.pkb, this.rxu, this.mCmdId, this.rxw);
        u.cLy().a((ae)localObject);
        AppMethodBeat.o(23143);
        return;
      case 10002: 
        k.cKl().b(this.rxv, this.pkb, this.rxu, this.mCmdId, this.rxw);
        AppMethodBeat.o(23143);
        return;
      }
      Object localObject = new f(this.rxv, this.pkb, this.rxu, this.mCmdId, this.rxw);
      u.cLy().a((ae)localObject);
      AppMethodBeat.o(23143);
    }
    
    public final void run()
    {
      AppMethodBeat.i(23144);
      cKf();
      AppMethodBeat.o(23144);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.c.a
 * JD-Core Version:    0.7.0.1
 */