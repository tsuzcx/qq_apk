package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.nio.ByteBuffer;

@TargetApi(16)
public final class q
  extends r
{
  protected int gmW = -1;
  
  public q(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, boolean paramBoolean)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramBoolean);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(89585);
    super.clear();
    SightVideoJNI.releaseBigSightDataBufferLock(this.gmW);
    AppMethodBeat.o(89585);
  }
  
  public final int gb(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89583);
    this.gmW = paramInt1;
    paramInt1 = super.gb(paramInt1, paramInt2);
    AppMethodBeat.o(89583);
    return paramInt1;
  }
  
  protected final void i(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(89584);
    if ((this.gmW >= 0) && (paramByteBuffer != null) && (paramBufferInfo != null) && (paramBufferInfo.size == paramByteBuffer.limit() - paramByteBuffer.position()))
    {
      long l = bt.GC();
      SightVideoJNI.writeH264DataLock(this.gmW, paramByteBuffer, paramBufferInfo.size, paramBufferInfo.presentationTimeUs);
      ad.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "writeH264Data used %sms, size: %s %s", new Object[] { Long.valueOf(bt.aS(l)), Integer.valueOf(paramBufferInfo.size), Integer.valueOf(paramByteBuffer.capacity()) });
    }
    AppMethodBeat.o(89584);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.q
 * JD-Core Version:    0.7.0.1
 */