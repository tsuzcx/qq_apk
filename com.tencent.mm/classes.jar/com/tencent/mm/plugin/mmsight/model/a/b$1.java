package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class b$1
  implements Runnable
{
  b$1(b paramb, b.a parama) {}
  
  public final void run()
  {
    b localb = this.miy;
    y.i("MicroMsg.FrameBufProcessor", "process srcWidth %d srcHeight %d targetWidth %d targetHeight %d bufIndex: %d", new Object[] { Integer.valueOf(localb.eJm), Integer.valueOf(localb.eJn), Integer.valueOf(localb.eIB), Integer.valueOf(localb.eIC), Integer.valueOf(localb.mis) });
    if ((localb.eID == 21) || (localb.eID == 2130706688)) {
      SightVideoJNI.NV21ToYUV420XXAndScaleRotate(localb.mip, localb.miq, localb.eJm, localb.eJn, localb.eIB, localb.eIC, 1, localb.rotate, localb.miu, localb.miw, localb.miv);
    }
    for (;;)
    {
      y.v("MicroMsg.FrameBufProcessor", "process used %sms %d %d bufIndex %d", new Object[] { Long.valueOf(bk.cp(localb.mit)), Integer.valueOf(localb.mip.length), Integer.valueOf(localb.miq.length), Integer.valueOf(localb.mis) });
      this.mix.a(this.miy);
      j.mji.z(this.miy.mip);
      return;
      if (localb.eID == 19) {
        SightVideoJNI.NV21ToYUV420XXAndScaleRotate(localb.mip, localb.miq, localb.eJm, localb.eJn, localb.eIB, localb.eIC, 2, localb.rotate, localb.miu, localb.miw, localb.miv);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.b.1
 * JD-Core Version:    0.7.0.1
 */