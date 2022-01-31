package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class MMSightEditUI$1
  implements Runnable
{
  MMSightEditUI$1(MMSightEditUI paramMMSightEditUI, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(54959);
    ab.i("MicroMsg.MMSightEditUI", "connect cost %sms", new Object[] { Long.valueOf(bo.av(this.ngG)) });
    if (CaptureMMProxy.getInstance() != null) {
      ac.ll(CaptureMMProxy.getInstance().getDeviceInfoConfig());
    }
    MMSightEditUI.a(this.oKK);
    AppMethodBeat.o(54959);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.MMSightEditUI.1
 * JD-Core Version:    0.7.0.1
 */