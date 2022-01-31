package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.b;
import com.tencent.mm.plugin.mmsight.model.f;
import com.tencent.mm.sdk.platformtools.ab;

final class n$1
  implements f
{
  n$1(n paramn) {}
  
  public final boolean N(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(76629);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      ab.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preview callback data is null");
      AppMethodBeat.o(76629);
      return false;
    }
    if ((this.oJA.fcm.oJP == d.c.oIG) || (this.oJA.fcm.oJP == d.c.oIH))
    {
      if (this.oJA.fcm.oJP == d.c.oIH)
      {
        this.oJA.fcm.oJP = d.c.oII;
        ab.v("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "forward one more frame");
      }
      this.oJA.fct.kH(1L);
      if (this.oJA.fcf != null) {
        this.oJA.fcf.bRk();
      }
      this.oJA.ba(paramArrayOfByte);
      AppMethodBeat.o(76629);
      return true;
    }
    AppMethodBeat.o(76629);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.n.1
 * JD-Core Version:    0.7.0.1
 */