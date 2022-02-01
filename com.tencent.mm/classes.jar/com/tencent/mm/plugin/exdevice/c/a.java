package com.tencent.mm.plugin.exdevice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.j.e;
import com.tencent.mm.plugin.exdevice.j.f;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.model.c;
import com.tencent.mm.plugin.exdevice.service.i.a;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.ac;

public final class a
  extends i.a
{
  private static a pwn = null;
  
  public static a cgi()
  {
    AppMethodBeat.i(23145);
    if (pwn == null)
    {
      locala = new a();
      pwn = locala;
      AppMethodBeat.o(23145);
      return locala;
    }
    a locala = pwn;
    AppMethodBeat.o(23145);
    return locala;
  }
  
  public final void a(int paramInt1, long paramLong, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23146);
    if (paramArrayOfByte == null)
    {
      i = -1;
      ac.i("MicroMsg.exdevice.DeviceRequestManager", "------onDeviceRequest------ errorCode = %d, deviceId = %d, seq = %d, cmdId = %d, datalength = %d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(i) });
      if (paramInt1 != 0) {
        break label110;
      }
    }
    String str;
    label110:
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.exdevice.h.a.t(paramLong, i);
      str = b.bd(paramArrayOfByte);
      if (str != null) {
        break label116;
      }
      ac.e("MicroMsg.exdevice.DeviceRequestManager", "dataIn is null!!! Just leave without process data");
      AppMethodBeat.o(23146);
      return;
      i = paramArrayOfByte.length;
      break;
    }
    label116:
    ac.d("MicroMsg.exdevice.DeviceRequestManager", "data dump = %s", new Object[] { str });
    new a(paramInt1, paramLong, paramInt2, paramInt3, paramArrayOfByte).cgj();
    AppMethodBeat.o(23146);
  }
  
  static final class a
    implements Runnable
  {
    private int mCmdId = -1;
    private long nsB = -1L;
    private int pwo = -1;
    private int pwp;
    private byte[] pwq = null;
    
    public a(int paramInt1, long paramLong, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
    {
      this.nsB = paramLong;
      this.pwo = paramInt2;
      this.mCmdId = paramInt3;
      this.pwq = paramArrayOfByte;
      this.pwp = paramInt1;
    }
    
    public final void cgj()
    {
      AppMethodBeat.i(23143);
      if ((this.nsB == -1L) || (this.pwo == -1) || (this.mCmdId == -1))
      {
        ac.e("MicroMsg.RequestProcessThread", "invalid arguments, do nothing");
        AppMethodBeat.o(23143);
        return;
      }
      switch (this.mCmdId)
      {
      default: 
        ac.e("MicroMsg.RequestProcessThread", "unknown cmdId = %d, do nothing", new Object[] { Integer.valueOf(this.mCmdId) });
        AppMethodBeat.o(23143);
        return;
      case 10001: 
        localObject = new e(this.pwp, this.nsB, this.pwo, this.mCmdId, this.pwq);
        u.chr().a((ae)localObject);
        AppMethodBeat.o(23143);
        return;
      case 10002: 
        k.cgp().b(this.pwp, this.nsB, this.pwo, this.mCmdId, this.pwq);
        AppMethodBeat.o(23143);
        return;
      }
      Object localObject = new f(this.pwp, this.nsB, this.pwo, this.mCmdId, this.pwq);
      u.chr().a((ae)localObject);
      AppMethodBeat.o(23143);
    }
    
    public final void run()
    {
      AppMethodBeat.i(23144);
      cgj();
      AppMethodBeat.o(23144);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.c.a
 * JD-Core Version:    0.7.0.1
 */