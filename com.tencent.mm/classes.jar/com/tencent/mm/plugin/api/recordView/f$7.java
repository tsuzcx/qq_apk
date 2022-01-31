package com.tencent.mm.plugin.api.recordView;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.f;
import java.nio.ByteBuffer;

final class f$7
  implements i.a
{
  f$7(f paramf, MMSightRecordView.f paramf1, ByteBuffer paramByteBuffer) {}
  
  public final void asU()
  {
    AppMethodBeat.i(138316);
    if (this.gOs != null) {
      this.gOs.aCP();
    }
    AppMethodBeat.o(138316);
  }
  
  public final ByteBuffer getBuffer()
  {
    return this.gOt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.f.7
 * JD-Core Version:    0.7.0.1
 */