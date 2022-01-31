package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

final class d$8
  implements am.a
{
  d$8(d paramd, long paramLong, String paramString, int paramInt) {}
  
  public final boolean tC()
  {
    int i = u.aMm().dS(this.jtM);
    y.i("MicroMsg.exdevice.ExdeviceConnectManager", "now it is time to check the sync connect state, brand name = %s, deviceid = %d, bluetooth version = %d, connect state = %d", new Object[] { this.jtL, Long.valueOf(this.jtM), Integer.valueOf(this.jtN), Integer.valueOf(i) });
    d.dH(this.jtM);
    d.c(this.jtE).remove(Long.valueOf(this.jtM));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.d.8
 * JD-Core Version:    0.7.0.1
 */