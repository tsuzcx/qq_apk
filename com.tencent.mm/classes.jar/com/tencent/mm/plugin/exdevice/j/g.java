package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.c.c;
import com.tencent.mm.plugin.exdevice.c.i;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.ad;

public final class g
  extends ae
{
  private c qgU;
  private a qgV;
  
  public g(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    AppMethodBeat.i(23804);
    this.qgU = new i(paramArrayOfByte, paramInt, paramLong);
    AppMethodBeat.o(23804);
  }
  
  public final boolean a(m paramm, d paramd)
  {
    AppMethodBeat.i(23805);
    if (!u.clU().uH(this.qgU.nTx))
    {
      ad.w("MicroMsg.exdevice.MMPushManufacturerSvrSendDataLogic", "Service push data to device before it do auth, device id = %d", new Object[] { Long.valueOf(this.qgU.nTx) });
      AppMethodBeat.o(23805);
      return true;
    }
    this.qgV = new a(this.qgU, paramd);
    boolean bool = this.qgV.b(paramm);
    AppMethodBeat.o(23805);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.g
 * JD-Core Version:    0.7.0.1
 */