package com.tencent.mm.audio.mix.jni;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class SilkResampleJni
{
  static
  {
    AppMethodBeat.i(136833);
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG("wechataudiosilk");
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/audio/mix/jni/SilkResampleJni", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    System.loadLibrary((String)locala.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/audio/mix/jni/SilkResampleJni", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    AppMethodBeat.o(136833);
  }
  
  public static native int clearResample(String paramString);
  
  public static native int clearResampleAll();
  
  public static native int initResample(String paramString, int paramInt1, int paramInt2);
  
  public static native int resamplePcm(String paramString, int paramInt1, int paramInt2, short[] paramArrayOfShort1, int paramInt3, short[] paramArrayOfShort2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.audio.mix.jni.SilkResampleJni
 * JD-Core Version:    0.7.0.1
 */