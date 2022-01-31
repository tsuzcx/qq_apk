package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.plugin.exdevice.b.c;
import com.tencent.mm.plugin.exdevice.b.i;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.y;

public final class g
  extends ae
{
  private c jzU;
  private a jzV;
  
  public g(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    this.jzU = new i(paramArrayOfByte, paramInt, paramLong);
  }
  
  public final boolean a(m paramm, d paramd)
  {
    if (!u.aMm().dX(this.jzU.hXu))
    {
      y.w("MicroMsg.exdevice.MMPushManufacturerSvrSendDataLogic", "Service push data to device before it do auth, device id = %d", new Object[] { Long.valueOf(this.jzU.hXu) });
      return true;
    }
    this.jzV = new a(this.jzU, paramd);
    return this.jzV.b(paramm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.i.g
 * JD-Core Version:    0.7.0.1
 */