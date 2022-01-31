package com.tencent.mm.plugin.exdevice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.i.e;
import com.tencent.mm.plugin.exdevice.i.f;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.model.c;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.ab;

final class a$a
  implements Runnable
{
  private long jRn = -1L;
  private int lCr = -1;
  private int lCs;
  private byte[] lCt = null;
  private int mCmdId = -1;
  
  public a$a(int paramInt1, long paramLong, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    this.jRn = paramLong;
    this.lCr = paramInt2;
    this.mCmdId = paramInt3;
    this.lCt = paramArrayOfByte;
    this.lCs = paramInt1;
  }
  
  public final void bpt()
  {
    AppMethodBeat.i(19035);
    if ((this.jRn == -1L) || (this.lCr == -1) || (this.mCmdId == -1))
    {
      ab.e("MicroMsg.RequestProcessThread", "invalid arguments, do nothing");
      AppMethodBeat.o(19035);
      return;
    }
    switch (this.mCmdId)
    {
    default: 
      ab.e("MicroMsg.RequestProcessThread", "unknown cmdId = %d, do nothing", new Object[] { Integer.valueOf(this.mCmdId) });
      AppMethodBeat.o(19035);
      return;
    case 10001: 
      localObject = new e(this.lCs, this.jRn, this.lCr, this.mCmdId, this.lCt);
      u.bqA().a((ae)localObject);
      AppMethodBeat.o(19035);
      return;
    case 10002: 
      k.bpz().b(this.lCs, this.jRn, this.lCr, this.mCmdId, this.lCt);
      AppMethodBeat.o(19035);
      return;
    }
    Object localObject = new f(this.lCs, this.jRn, this.lCr, this.mCmdId, this.lCt);
    u.bqA().a((ae)localObject);
    AppMethodBeat.o(19035);
  }
  
  public final void run()
  {
    AppMethodBeat.i(19036);
    bpt();
    AppMethodBeat.o(19036);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.b.a.a
 * JD-Core Version:    0.7.0.1
 */