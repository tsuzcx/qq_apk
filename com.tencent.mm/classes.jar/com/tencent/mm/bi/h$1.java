package com.tencent.mm.bi;

import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import java.nio.ByteBuffer;

final class h$1
  implements c.a
{
  h$1(h paramh) {}
  
  public final void a(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2)
  {
    MP4MuxerJNI.writeH264Data(paramInt1, paramByteBuffer, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.bi.h.1
 * JD-Core Version:    0.7.0.1
 */