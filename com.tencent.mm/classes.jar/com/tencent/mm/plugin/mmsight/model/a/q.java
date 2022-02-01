package com.tencent.mm.plugin.mmsight.model.a;

import android.media.MediaCodec.BufferInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;

public final class q
  extends r
{
  protected int bufId = -1;
  
  public q(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, boolean paramBoolean)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramBoolean);
  }
  
  protected final boolean boY()
  {
    return false;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(89585);
    super.clear();
    SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
    AppMethodBeat.o(89585);
  }
  
  protected final void i(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(89584);
    if ((this.bufId >= 0) && (paramByteBuffer != null) && (paramBufferInfo != null) && (paramBufferInfo.size == paramByteBuffer.limit() - paramByteBuffer.position()))
    {
      long l = Util.currentTicks();
      SightVideoJNI.writeH264DataLock(this.bufId, paramByteBuffer, paramBufferInfo.size, paramBufferInfo.presentationTimeUs);
      Log.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "writeH264Data used %sms, size: %s %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(paramBufferInfo.size), Integer.valueOf(paramByteBuffer.capacity()) });
    }
    AppMethodBeat.o(89584);
  }
  
  public final int jJ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89583);
    this.bufId = paramInt1;
    paramInt1 = super.jJ(paramInt1, paramInt2);
    AppMethodBeat.o(89583);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.q
 * JD-Core Version:    0.7.0.1
 */