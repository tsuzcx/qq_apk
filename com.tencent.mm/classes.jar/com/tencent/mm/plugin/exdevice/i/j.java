package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.plugin.exdevice.b.c;
import com.tencent.mm.plugin.exdevice.b.h;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.y;

public final class j
  extends ae
{
  private a jzY;
  private h jzZ;
  
  public j(int paramInt1, int paramInt2, long paramLong)
  {
    this.jzZ = new h(paramInt1, paramInt2, paramLong);
  }
  
  public final boolean a(m paramm, d paramd)
  {
    if (!u.aMm().dX(this.jzZ.hXu))
    {
      y.w("MicroMsg.exdevice.MMSwitchViewPushTaskExcuter", "push switchview event to device before it do auth, device id = %d", new Object[] { Long.valueOf(this.jzZ.hXu) });
      return true;
    }
    this.jzY = new b(this.jzZ, paramd);
    return this.jzY.b(paramm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.i.j
 * JD-Core Version:    0.7.0.1
 */