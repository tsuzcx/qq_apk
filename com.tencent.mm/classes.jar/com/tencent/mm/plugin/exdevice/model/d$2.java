package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.exdevice.service.c.a;
import com.tencent.mm.plugin.exdevice.service.j;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.y;

final class d$2
  extends c.a
{
  d$2(d paramd, j paramj)
  {
    super(0);
  }
  
  public final void onServiceConnected()
  {
    if (!u.aMn().jtr.a(this.jtF)) {
      y.e("MicroMsg.exdevice.ExdeviceConnectManager", "scan failed!!!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.d.2
 * JD-Core Version:    0.7.0.1
 */