package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.exdevice.service.c.a;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.y;

final class d$12
  extends c.a
{
  d$12(d paramd, int paramInt1, int paramInt2)
  {
    super(paramInt1);
  }
  
  public final void onServiceConnected()
  {
    if (!u.aMn().jtr.b(this.jtO, d.f(this.jtE))) {
      y.e("MicroMsg.exdevice.ExdeviceConnectManager", "scan failed!!!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.d.12
 * JD-Core Version:    0.7.0.1
 */