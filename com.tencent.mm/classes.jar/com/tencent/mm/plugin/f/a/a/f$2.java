package com.tencent.mm.plugin.f.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;

final class f$2
  implements am.a
{
  f$2(f paramf) {}
  
  public final boolean tC()
  {
    if (f.f(this.hTz).size() > 0)
    {
      y.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer now start");
      if (!f.g(this.hTz).booleanValue()) {
        break label115;
      }
      y.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer restart bleScan ok");
    }
    for (;;)
    {
      f.en(ae.getContext().getSharedPreferences("com.tencent.mm_exdevice_ibeacon_isNewScanning", 4).getBoolean("isNewScanning", false));
      if (!f.access$700())
      {
        if (!f.h(this.hTz).crl()) {
          f.h(this.hTz).stopTimer();
        }
        if (!f.i(this.hTz).crl()) {
          f.i(this.hTz).stopTimer();
        }
      }
      return false;
      label115:
      y.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer restart bleScan fail");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.a.f.2
 * JD-Core Version:    0.7.0.1
 */