package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import java.nio.ByteBuffer;

@TargetApi(16)
public final class g
  extends h
{
  private int eRm = -1;
  
  public g(int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2, paramInt3);
  }
  
  protected final boolean Xp()
  {
    return true;
  }
  
  protected final void g(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(76572);
    if ((this.eRm >= 0) && (paramByteBuffer != null) && (paramBufferInfo != null) && (!this.oJd)) {
      SightVideoJNI.writeAACDataLock(this.eRm, paramByteBuffer, paramBufferInfo.size);
    }
    AppMethodBeat.o(76572);
  }
  
  public final int t(int paramInt, String paramString)
  {
    AppMethodBeat.i(76571);
    this.eRm = paramInt;
    paramInt = super.t(paramInt, paramString);
    AppMethodBeat.o(76571);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.g
 * JD-Core Version:    0.7.0.1
 */