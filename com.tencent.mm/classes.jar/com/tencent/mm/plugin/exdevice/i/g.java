package com.tencent.mm.plugin.exdevice.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.b.c;
import com.tencent.mm.plugin.exdevice.b.i;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.ab;

public final class g
  extends ae
{
  private c lJt;
  private a lJu;
  
  public g(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    AppMethodBeat.i(19736);
    this.lJt = new i(paramArrayOfByte, paramInt, paramLong);
    AppMethodBeat.o(19736);
  }
  
  public final boolean a(m paramm, d paramd)
  {
    AppMethodBeat.i(19737);
    if (!u.bqz().jp(this.lJt.jRn))
    {
      ab.w("MicroMsg.exdevice.MMPushManufacturerSvrSendDataLogic", "Service push data to device before it do auth, device id = %d", new Object[] { Long.valueOf(this.lJt.jRn) });
      AppMethodBeat.o(19737);
      return true;
    }
    this.lJu = new a(this.lJt, paramd);
    boolean bool = this.lJu.b(paramm);
    AppMethodBeat.o(19737);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.i.g
 * JD-Core Version:    0.7.0.1
 */