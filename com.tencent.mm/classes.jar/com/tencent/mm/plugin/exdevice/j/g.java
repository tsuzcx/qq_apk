package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.c.c;
import com.tencent.mm.plugin.exdevice.c.i;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;

public final class g
  extends com.tencent.mm.plugin.exdevice.model.ae
{
  private a qnA;
  private c qnz;
  
  public g(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    AppMethodBeat.i(23804);
    this.qnz = new i(paramArrayOfByte, paramInt, paramLong);
    AppMethodBeat.o(23804);
  }
  
  public final boolean a(m paramm, d paramd)
  {
    AppMethodBeat.i(23805);
    if (!u.cnk().uY(this.qnz.nZd))
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.exdevice.MMPushManufacturerSvrSendDataLogic", "Service push data to device before it do auth, device id = %d", new Object[] { Long.valueOf(this.qnz.nZd) });
      AppMethodBeat.o(23805);
      return true;
    }
    this.qnA = new a(this.qnz, paramd);
    boolean bool = this.qnA.b(paramm);
    AppMethodBeat.o(23805);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.g
 * JD-Core Version:    0.7.0.1
 */