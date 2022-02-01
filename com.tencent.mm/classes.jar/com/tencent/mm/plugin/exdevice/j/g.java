package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.c.c;
import com.tencent.mm.plugin.exdevice.c.i;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.ac;

public final class g
  extends ae
{
  private c pDp;
  private a pDq;
  
  public g(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    AppMethodBeat.i(23804);
    this.pDp = new i(paramArrayOfByte, paramInt, paramLong);
    AppMethodBeat.o(23804);
  }
  
  public final boolean a(m paramm, d paramd)
  {
    AppMethodBeat.i(23805);
    if (!u.chq().sJ(this.pDp.nsB))
    {
      ac.w("MicroMsg.exdevice.MMPushManufacturerSvrSendDataLogic", "Service push data to device before it do auth, device id = %d", new Object[] { Long.valueOf(this.pDp.nsB) });
      AppMethodBeat.o(23805);
      return true;
    }
    this.pDq = new a(this.pDp, paramd);
    boolean bool = this.pDq.b(paramm);
    AppMethodBeat.o(23805);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.g
 * JD-Core Version:    0.7.0.1
 */