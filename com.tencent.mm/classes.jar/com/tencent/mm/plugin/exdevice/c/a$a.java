package com.tencent.mm.plugin.exdevice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.j.e;
import com.tencent.mm.plugin.exdevice.j.f;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.model.c;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.ad;

final class a$a
  implements Runnable
{
  private int mCmdId = -1;
  private long nTx = -1L;
  private int pZT = -1;
  private int pZU;
  private byte[] pZV = null;
  
  public a$a(int paramInt1, long paramLong, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    this.nTx = paramLong;
    this.pZT = paramInt2;
    this.mCmdId = paramInt3;
    this.pZV = paramArrayOfByte;
    this.pZU = paramInt1;
  }
  
  public final void ckN()
  {
    AppMethodBeat.i(23143);
    if ((this.nTx == -1L) || (this.pZT == -1) || (this.mCmdId == -1))
    {
      ad.e("MicroMsg.RequestProcessThread", "invalid arguments, do nothing");
      AppMethodBeat.o(23143);
      return;
    }
    switch (this.mCmdId)
    {
    default: 
      ad.e("MicroMsg.RequestProcessThread", "unknown cmdId = %d, do nothing", new Object[] { Integer.valueOf(this.mCmdId) });
      AppMethodBeat.o(23143);
      return;
    case 10001: 
      localObject = new e(this.pZU, this.nTx, this.pZT, this.mCmdId, this.pZV);
      u.clV().a((ae)localObject);
      AppMethodBeat.o(23143);
      return;
    case 10002: 
      k.ckT().b(this.pZU, this.nTx, this.pZT, this.mCmdId, this.pZV);
      AppMethodBeat.o(23143);
      return;
    }
    Object localObject = new f(this.pZU, this.nTx, this.pZT, this.mCmdId, this.pZV);
    u.clV().a((ae)localObject);
    AppMethodBeat.o(23143);
  }
  
  public final void run()
  {
    AppMethodBeat.i(23144);
    ckN();
    AppMethodBeat.o(23144);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.c.a.a
 * JD-Core Version:    0.7.0.1
 */