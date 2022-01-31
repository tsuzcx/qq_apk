package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class b$1
  implements Runnable
{
  b$1(b paramb, b.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(76569);
    b localb = this.oIE;
    ab.i("MicroMsg.FrameBufProcessor", "process srcWidth %d srcHeight %d targetWidth %d targetHeight %d bufIndex: %d", new Object[] { Integer.valueOf(localb.fYR), Integer.valueOf(localb.fYS), Integer.valueOf(localb.eRu), Integer.valueOf(localb.eRv), Integer.valueOf(localb.oIz) });
    if ((localb.eRx == 21) || (localb.eRx == 2130706688)) {
      SightVideoJNI.NV21ToYUV420XXAndScaleRotate(localb.oIw, localb.oIx, localb.fYR, localb.fYS, localb.eRu, localb.eRv, 1, localb.rotate, localb.oIB, localb.oIC, localb.jdF);
    }
    for (;;)
    {
      ab.v("MicroMsg.FrameBufProcessor", "process used %sms %d %d bufIndex %d", new Object[] { Long.valueOf(bo.av(localb.oIA)), Integer.valueOf(localb.oIw.length), Integer.valueOf(localb.oIx.length), Integer.valueOf(localb.oIz) });
      this.oID.a(this.oIE);
      j.oJp.O(this.oIE.oIw);
      AppMethodBeat.o(76569);
      return;
      if (localb.eRx == 19) {
        SightVideoJNI.NV21ToYUV420XXAndScaleRotate(localb.oIw, localb.oIx, localb.fYR, localb.fYS, localb.eRu, localb.eRv, 2, localb.rotate, localb.oIB, localb.oIC, localb.jdF);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.b.1
 * JD-Core Version:    0.7.0.1
 */