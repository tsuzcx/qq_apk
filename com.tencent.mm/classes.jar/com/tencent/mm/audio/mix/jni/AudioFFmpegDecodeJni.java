package com.tencent.mm.audio.mix.jni;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.decode.IDecodeCallback;

public class AudioFFmpegDecodeJni
{
  protected long hsT = 0L;
  protected long hsU = 0L;
  
  static
  {
    AppMethodBeat.i(136832);
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG("FFmpeg");
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/audio/mix/jni/AudioFFmpegDecodeJni", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    System.loadLibrary((String)locala.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/audio/mix/jni/AudioFFmpegDecodeJni", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    AppMethodBeat.o(136832);
  }
  
  public static native int decode(int paramInt1, int paramInt2, int paramInt3, String paramString, IDecodeCallback paramIDecodeCallback);
  
  public native int clearResample(String paramString, Object paramObject);
  
  public native int initResample(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Object paramObject);
  
  public native int resamplePcm(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte1, int paramInt3, byte[] paramArrayOfByte2, int paramInt4, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.audio.mix.jni.AudioFFmpegDecodeJni
 * JD-Core Version:    0.7.0.1
 */