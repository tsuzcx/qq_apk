package com.tencent.mm.plugin.f.a.a;

import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;

final class f$3
  implements am.a
{
  f$3(f paramf) {}
  
  public final boolean tC()
  {
    if (f.f(this.hTz).size() > 0)
    {
      y.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer now stop");
      f.j(this.hTz);
      if (f.i(this.hTz).crl()) {
        f.i(this.hTz).S(2000L, 2000L);
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.a.f.3
 * JD-Core Version:    0.7.0.1
 */