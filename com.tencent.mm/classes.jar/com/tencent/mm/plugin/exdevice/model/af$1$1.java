package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.h.a.ub;
import com.tencent.mm.h.a.ub.a;
import com.tencent.mm.sdk.platformtools.y;

final class af$1$1
  implements i.a
{
  af$1$1(af.1 param1, ub paramub) {}
  
  public final void fB(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      y.e("MicroMsg.WearHardDeviceLogic", "GetBoundDeviceLogic Fail, deviceId=%s|deviceType=%s", new Object[] { this.jwV.cez.bwK, this.jwV.cez.bJp });
      af.au(this.jwV.cez.bwK, false);
      return;
    }
    af.au(this.jwV.cez.bwK, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.af.1.1
 * JD-Core Version:    0.7.0.1
 */