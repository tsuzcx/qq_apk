package com.tencent.mm.plugin.exdevice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.j.e;
import com.tencent.mm.plugin.exdevice.j.f;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.plugin.exdevice.model.af;
import com.tencent.mm.plugin.exdevice.model.c;
import com.tencent.mm.plugin.exdevice.service.i.a;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends i.a
{
  private static a vcZ = null;
  
  public static a cYO()
  {
    AppMethodBeat.i(23145);
    if (vcZ == null)
    {
      locala = new a();
      vcZ = locala;
      AppMethodBeat.o(23145);
      return locala;
    }
    a locala = vcZ;
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
      com.tencent.mm.plugin.exdevice.h.a.s(paramLong, i);
      str = b.bK(paramArrayOfByte);
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
    new a(paramInt1, paramLong, paramInt2, paramInt3, paramArrayOfByte).cYP();
    AppMethodBeat.o(23146);
  }
  
  static final class a
    implements Runnable
  {
    private int mCmdId = -1;
    private long smk = -1L;
    private int vda = -1;
    private int vdb;
    private byte[] vdc = null;
    
    public a(int paramInt1, long paramLong, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
    {
      this.smk = paramLong;
      this.vda = paramInt2;
      this.mCmdId = paramInt3;
      this.vdc = paramArrayOfByte;
      this.vdb = paramInt1;
    }
    
    public final void cYP()
    {
      AppMethodBeat.i(23143);
      if ((this.smk == -1L) || (this.vda == -1) || (this.mCmdId == -1))
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
        localObject = new e(this.vdb, this.smk, this.vda, this.mCmdId, this.vdc);
        u.dal().a((af)localObject);
        AppMethodBeat.o(23143);
        return;
      case 10002: 
        k.cYV().b(this.vdb, this.smk, this.vda, this.mCmdId, this.vdc);
        AppMethodBeat.o(23143);
        return;
      }
      Object localObject = new f(this.vdb, this.smk, this.vda, this.mCmdId, this.vdc);
      u.dal().a((af)localObject);
      AppMethodBeat.o(23143);
    }
    
    public final void run()
    {
      AppMethodBeat.i(23144);
      cYP();
      AppMethodBeat.o(23144);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.c.a
 * JD-Core Version:    0.7.0.1
 */