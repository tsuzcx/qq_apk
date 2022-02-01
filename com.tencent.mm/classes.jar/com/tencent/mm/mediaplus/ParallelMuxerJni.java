package com.tencent.mm.mediaplus;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.c;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/mediaplus/ParallelMuxerJni;", "Lcom/tencent/mm/MediaPlusBaseJni;", "()V", "nPtr", "", "addAudioPtsArray", "", "ptsArray", "", "addVideoDtsArray", "dtsArray", "fps", "", "addVideoPtsArray", "addVideoSoftPtsArray", "size", "create", "", "mux", "h264Files", "", "", "aacPath", "outputPath", "frameCount", "suggestFps", "mute", "([Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JFZ)I", "nAddAudioPtsArray", "nAddVideoDtsArray", "nAddVideoPtsArray", "nAddVideoSoftPtsArray", "nCreate", "nMux", "(J[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JFZ)I", "nRelease", "release", "Companion", "mediaplus_release"}, k=1, mv={1, 1, 15})
public final class ParallelMuxerJni
  extends c
{
  public static final ParallelMuxerJni.a nNh;
  public long nNg = -1L;
  
  static
  {
    AppMethodBeat.i(231415);
    nNh = new ParallelMuxerJni.a((byte)0);
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG("mediaplus");
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/mediaplus/ParallelMuxerJni", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    System.loadLibrary((String)locala.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/mediaplus/ParallelMuxerJni", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    AppMethodBeat.o(231415);
  }
  
  private final native int nAddAudioPtsArray(long paramLong, long[] paramArrayOfLong);
  
  private final native int nAddVideoDtsArray(long paramLong, long[] paramArrayOfLong, float paramFloat);
  
  private final native long nCreate();
  
  private final native int nMux(long paramLong1, String[] paramArrayOfString, String paramString1, String paramString2, long paramLong2, float paramFloat, boolean paramBoolean);
  
  private final native int nRelease(long paramLong);
  
  public final int a(String[] paramArrayOfString, String paramString1, String paramString2, long paramLong, float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(231436);
    s.t(paramArrayOfString, "h264Files");
    s.t(paramString1, "aacPath");
    s.t(paramString2, "outputPath");
    int i = nMux(this.nNg, paramArrayOfString, paramString1, paramString2, paramLong, paramFloat, paramBoolean);
    AppMethodBeat.o(231436);
    return i;
  }
  
  public final int addAudioPtsArray(long[] paramArrayOfLong)
  {
    AppMethodBeat.i(231432);
    s.t(paramArrayOfLong, "ptsArray");
    int i = nAddAudioPtsArray(this.nNg, paramArrayOfLong);
    AppMethodBeat.o(231432);
    return i;
  }
  
  public final int addVideoDtsArray(long[] paramArrayOfLong, float paramFloat)
  {
    AppMethodBeat.i(231429);
    s.t(paramArrayOfLong, "dtsArray");
    int i = nAddVideoDtsArray(this.nNg, paramArrayOfLong, paramFloat);
    AppMethodBeat.o(231429);
    return i;
  }
  
  public final boolean bvD()
  {
    AppMethodBeat.i(231424);
    this.nNg = nCreate();
    if (this.nNg >= 0L)
    {
      AppMethodBeat.o(231424);
      return true;
    }
    AppMethodBeat.o(231424);
    return false;
  }
  
  public final native int nAddVideoPtsArray(long paramLong, long[] paramArrayOfLong, float paramFloat);
  
  public final native int nAddVideoSoftPtsArray(long paramLong, long[] paramArrayOfLong, int paramInt, float paramFloat);
  
  public final int release()
  {
    AppMethodBeat.i(231438);
    int i = nRelease(this.nNg);
    AppMethodBeat.o(231438);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.mediaplus.ParallelMuxerJni
 * JD-Core Version:    0.7.0.1
 */