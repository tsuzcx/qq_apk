package com.tencent.mm.plugin.api.recordView;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.f;
import java.nio.ByteBuffer;

final class f$6
  implements i.a
{
  f$6(f paramf, MMSightRecordView.f paramf1, ByteBuffer paramByteBuffer) {}
  
  public final void bBI()
  {
    AppMethodBeat.i(89225);
    if (this.nrU != null) {
      this.nrU.bRK();
    }
    AppMethodBeat.o(89225);
  }
  
  public final ByteBuffer getBuffer()
  {
    return this.nrV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.f.6
 * JD-Core Version:    0.7.0.1
 */