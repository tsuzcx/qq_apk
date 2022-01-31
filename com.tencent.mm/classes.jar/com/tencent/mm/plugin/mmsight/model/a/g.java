package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import java.nio.ByteBuffer;

@TargetApi(16)
public final class g
  extends h
{
  private int eIz = -1;
  
  public g(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public final int au(int paramInt, String paramString)
  {
    this.eIz = paramInt;
    return super.au(paramInt, paramString);
  }
  
  protected final boolean bjz()
  {
    return true;
  }
  
  protected final void e(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    if ((this.eIz >= 0) && (paramByteBuffer != null) && (paramBufferInfo != null) && (!this.miW)) {
      SightVideoJNI.writeAACDataLock(this.eIz, paramByteBuffer, paramBufferInfo.size);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.g
 * JD-Core Version:    0.7.0.1
 */