package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class MMSightEditUI$1
  implements Runnable
{
  MMSightEditUI$1(MMSightEditUI paramMMSightEditUI, long paramLong) {}
  
  public final void run()
  {
    y.i("MicroMsg.MMSightEditUI", "connect cost %sms", new Object[] { Long.valueOf(bk.cp(this.kKd)) });
    if (CaptureMMProxy.getInstance() != null) {
      q.fa(CaptureMMProxy.getInstance().getDeviceInfoConfig());
    }
    MMSightEditUI.a(this.mlC);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.MMSightEditUI.1
 * JD-Core Version:    0.7.0.1
 */