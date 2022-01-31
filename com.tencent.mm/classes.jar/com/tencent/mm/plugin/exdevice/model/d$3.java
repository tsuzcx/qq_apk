package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.exdevice.service.c.a;
import com.tencent.mm.plugin.exdevice.service.k;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.y;

final class d$3
  extends c.a
{
  d$3(d paramd, long paramLong, k paramk)
  {
    super(0);
  }
  
  public final void onServiceConnected()
  {
    if (!u.aMn().jtr.a(this.hUK, this.jtG)) {
      y.e("MicroMsg.exdevice.ExdeviceConnectManager", "connect failed!!!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.d.3
 * JD-Core Version:    0.7.0.1
 */