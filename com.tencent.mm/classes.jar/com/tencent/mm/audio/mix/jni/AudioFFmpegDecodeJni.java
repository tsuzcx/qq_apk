package com.tencent.mm.audio.mix.jni;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.d.l;

public class AudioFFmpegDecodeJni
{
  protected long cVc = 0L;
  protected long cVd = 0L;
  
  static
  {
    AppMethodBeat.i(136832);
    System.loadLibrary("FFmpeg");
    AppMethodBeat.o(136832);
  }
  
  public static native int decode(int paramInt1, int paramInt2, int paramInt3, String paramString, l paraml);
  
  public native int clearResample(String paramString, Object paramObject);
  
  public native int initResample(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Object paramObject);
  
  public native int resamplePcm(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte1, int paramInt3, byte[] paramArrayOfByte2, int paramInt4, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.audio.mix.jni.AudioFFmpegDecodeJni
 * JD-Core Version:    0.7.0.1
 */