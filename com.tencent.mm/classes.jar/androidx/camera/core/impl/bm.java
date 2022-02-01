package androidx.camera.core.impl;

import androidx.camera.core.a.g;
import androidx.camera.core.ay;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bm
  implements g, al, bk<ay>
{
  public static final ac.a<Integer> NR;
  public static final ac.a<Integer> NS;
  public static final ac.a<Integer> NT;
  public static final ac.a<Integer> NU;
  public static final ac.a<Integer> NV;
  public static final ac.a<Integer> NW;
  public static final ac.a<Integer> NX;
  private final av Hd;
  
  static
  {
    AppMethodBeat.i(198817);
    NR = ac.a.a("camerax.core.videoCapture.recordingFrameRate", Integer.TYPE, null);
    NS = ac.a.a("camerax.core.videoCapture.bitRate", Integer.TYPE, null);
    NT = ac.a.a("camerax.core.videoCapture.intraFrameInterval", Integer.TYPE, null);
    NU = ac.a.a("camerax.core.videoCapture.audioBitRate", Integer.TYPE, null);
    NV = ac.a.a("camerax.core.videoCapture.audioSampleRate", Integer.TYPE, null);
    NW = ac.a.a("camerax.core.videoCapture.audioChannelCount", Integer.TYPE, null);
    NX = ac.a.a("camerax.core.videoCapture.audioMinBufferSize", Integer.TYPE, null);
    AppMethodBeat.o(198817);
  }
  
  public bm(av paramav)
  {
    this.Hd = paramav;
  }
  
  public final ac hx()
  {
    return this.Hd;
  }
  
  public final int ki()
  {
    return 34;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.impl.bm
 * JD-Core Version:    0.7.0.1
 */