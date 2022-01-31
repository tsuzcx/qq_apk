package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vx;
import com.tencent.mm.g.a.vx.a;
import com.tencent.mm.sdk.platformtools.ab;

final class af$1$1
  implements i.a
{
  af$1$1(af.1 param1, vx paramvx) {}
  
  public final void hd(boolean paramBoolean)
  {
    AppMethodBeat.i(19406);
    if (!paramBoolean)
    {
      ab.e("MicroMsg.WearHardDeviceLogic", "GetBoundDeviceLogic Fail, deviceId=%s|deviceType=%s", new Object[] { this.lGu.cNm.bYu, this.lGu.cNm.cqJ });
      af.aF(this.lGu.cNm.bYu, false);
      AppMethodBeat.o(19406);
      return;
    }
    af.aF(this.lGu.cNm.bYu, true);
    AppMethodBeat.o(19406);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.af.1.1
 * JD-Core Version:    0.7.0.1
 */