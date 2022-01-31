package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

final class d$9
  implements am.a
{
  d$9(d paramd, long paramLong, String paramString, int paramInt) {}
  
  public final boolean tC()
  {
    int i = u.aMm().dS(this.jtM);
    y.i("MicroMsg.exdevice.ExdeviceConnectManager", "now it is time to notify ui show the connect time out tips, brand name = %s, deviceid = %d, bluetooth version = %d, connect state = %d", new Object[] { this.jtL, Long.valueOf(this.jtM), Integer.valueOf(this.jtN), Integer.valueOf(i) });
    if (i != 2)
    {
      ad.aLW();
      e.by(this.jtL, 2);
    }
    d.d(this.jtE).remove(Long.valueOf(this.jtM));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.d.9
 * JD-Core Version:    0.7.0.1
 */