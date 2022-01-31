package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.nio.ByteBuffer;

@TargetApi(16)
public final class q
  extends r
{
  protected int eIz = -1;
  
  public q(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, boolean paramBoolean)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramBoolean);
  }
  
  public final void clear()
  {
    super.clear();
    SightVideoJNI.releaseBigSightDataBufferLock(this.eIz);
  }
  
  public final int dg(int paramInt1, int paramInt2)
  {
    this.eIz = paramInt1;
    return super.dg(paramInt1, paramInt2);
  }
  
  protected final void e(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    if ((this.eIz >= 0) && (paramByteBuffer != null) && (paramBufferInfo != null) && (paramBufferInfo.size == paramByteBuffer.limit() - paramByteBuffer.position()))
    {
      long l = bk.UZ();
      SightVideoJNI.writeH264DataLock(this.eIz, paramByteBuffer, paramBufferInfo.size);
      y.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "writeH264Data used %sms, size: %s %s", new Object[] { Long.valueOf(bk.cp(l)), Integer.valueOf(paramBufferInfo.size), Integer.valueOf(paramByteBuffer.capacity()) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.q
 * JD-Core Version:    0.7.0.1
 */