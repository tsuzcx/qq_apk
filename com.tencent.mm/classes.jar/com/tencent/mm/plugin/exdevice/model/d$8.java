package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;
import java.util.HashMap;

final class d$8
  implements ap.a
{
  d$8(d paramd, long paramLong, String paramString, int paramInt) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(19106);
    int i = u.bqz().jk(this.lDk);
    ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "now it is time to check the sync connect state, brand name = %s, deviceid = %d, bluetooth version = %d, connect state = %d", new Object[] { this.lDj, Long.valueOf(this.lDk), Integer.valueOf(this.lDm), Integer.valueOf(i) });
    d.iZ(this.lDk);
    d.b(this.lDd).remove(Long.valueOf(this.lDk));
    AppMethodBeat.o(19106);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.d.8
 * JD-Core Version:    0.7.0.1
 */