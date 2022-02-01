package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.c.c;
import com.tencent.mm.plugin.exdevice.c.i;
import com.tencent.mm.plugin.exdevice.model.ai;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.Log;

public final class g
  extends ai
{
  private c ywo;
  private a ywp;
  
  public g(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    AppMethodBeat.i(23804);
    this.ywo = new i(paramArrayOfByte, paramInt, paramLong);
    AppMethodBeat.o(23804);
  }
  
  public final boolean a(m paramm, d paramd)
  {
    AppMethodBeat.i(23805);
    if (!u.dGD().lG(this.ywo.vyj))
    {
      Log.w("MicroMsg.exdevice.MMPushManufacturerSvrSendDataLogic", "Service push data to device before it do auth, device id = %d", new Object[] { Long.valueOf(this.ywo.vyj) });
      AppMethodBeat.o(23805);
      return true;
    }
    this.ywp = new a(this.ywo, paramd);
    boolean bool = this.ywp.b(paramm);
    AppMethodBeat.o(23805);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.g
 * JD-Core Version:    0.7.0.1
 */