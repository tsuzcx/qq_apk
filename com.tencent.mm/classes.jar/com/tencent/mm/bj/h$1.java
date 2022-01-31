package com.tencent.mm.bj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import java.nio.ByteBuffer;

final class h$1
  implements c.a
{
  h$1(h paramh) {}
  
  public final void a(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2)
  {
    AppMethodBeat.i(50944);
    MP4MuxerJNI.writeH264DataLock(paramInt1, paramByteBuffer, paramInt2);
    AppMethodBeat.o(50944);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.bj.h.1
 * JD-Core Version:    0.7.0.1
 */