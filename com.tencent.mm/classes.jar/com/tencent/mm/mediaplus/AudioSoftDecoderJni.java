package com.tencent.mm.mediaplus;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/mediaplus/AudioSoftDecoderJni;", "", "()V", "Companion", "mediaplus_release"}, k=1, mv={1, 1, 15})
public final class AudioSoftDecoderJni
{
  private static final int nNe = 0;
  public static final AudioSoftDecoderJni.a nNf;
  
  static
  {
    AppMethodBeat.i(231394);
    nNf = new AudioSoftDecoderJni.a((byte)0);
    AppMethodBeat.o(231394);
  }
  
  public static final native int nDecodeSample(long paramLong, ByteBuffer paramByteBuffer, int paramInt);
  
  public static final native void nDestroy(long paramLong);
  
  public static final native int nFlush(long paramLong);
  
  public static final native int nGetErrCode(long paramLong);
  
  public static final native byte[] nGetOutputBuffer(long paramLong);
  
  public static final native int nGetOutputBufferSize(long paramLong);
  
  public static final native long nInit(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.mediaplus.AudioSoftDecoderJni
 * JD-Core Version:    0.7.0.1
 */