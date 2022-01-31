package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d;

final class n$4
  implements f.a
{
  n$4(n paramn) {}
  
  public final void bRn()
  {
    AppMethodBeat.i(76632);
    d.post(new n.6(this.oJA), "MMSightMediaCodecMP4MuxRecorder_stop");
    AppMethodBeat.o(76632);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.n.4
 * JD-Core Version:    0.7.0.1
 */