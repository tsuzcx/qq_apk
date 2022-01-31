package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;
import java.util.HashMap;

final class d$9
  implements ap.a
{
  d$9(d paramd, long paramLong, String paramString, int paramInt) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(19107);
    int i = u.bqz().jk(this.lDk);
    ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "now it is time to notify ui show the connect time out tips, brand name = %s, deviceid = %d, bluetooth version = %d, connect state = %d", new Object[] { this.lDj, Long.valueOf(this.lDk), Integer.valueOf(this.lDm), Integer.valueOf(i) });
    if (i != 2)
    {
      ad.bqj();
      e.cd(this.lDj, 2);
    }
    d.c(this.lDd).remove(Long.valueOf(this.lDk));
    AppMethodBeat.o(19107);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.d.9
 * JD-Core Version:    0.7.0.1
 */