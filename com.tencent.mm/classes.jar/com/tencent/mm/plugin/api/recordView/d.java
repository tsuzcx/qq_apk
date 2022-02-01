package com.tencent.mm.plugin.api.recordView;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

final class d
{
  static float[] hoI;
  static final float[] hoJ;
  static final Object lock;
  int dGc;
  int gLM;
  int gLN;
  int gLO;
  FloatBuffer gLl;
  FloatBuffer gLm;
  volatile boolean hju;
  int hoE;
  ByteBuffer hoF;
  int hou;
  ByteBuffer hoy;
  volatile boolean juJ;
  boolean jur;
  int jus;
  int jut;
  int juu;
  int juv;
  int juw;
  float[] jux;
  float[] juz;
  private int surfaceHeight;
  private int surfaceWidth;
  
  static
  {
    AppMethodBeat.i(89218);
    hoI = new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
    hoJ = new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
    lock = new Object();
    AppMethodBeat.o(89218);
  }
  
  public d()
  {
    AppMethodBeat.i(89216);
    this.surfaceWidth = 0;
    this.surfaceHeight = 0;
    this.jur = false;
    this.jus = 0;
    this.jut = 0;
    this.dGc = 0;
    this.juu = -1;
    this.juv = -1;
    this.gLM = -1;
    this.jux = new float[16];
    this.juz = hoI;
    this.hju = false;
    this.juJ = false;
    this.hju = false;
    AppMethodBeat.o(89216);
  }
  
  public final void dB(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89217);
    ad.i("MicroMsg.MMSightRecordTextureViewRenderer", "onSurfaceChanged, surfaceWidth: %s, height: %s this %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), this });
    if ((paramInt1 != this.surfaceWidth) || (paramInt2 != this.surfaceHeight))
    {
      ad.i("MicroMsg.MMSightRecordTextureViewRenderer", "onSurfaceChanged change viewpoint");
      GLES20.glViewport(0, 0, paramInt1, paramInt2);
      this.surfaceWidth = paramInt1;
      this.surfaceHeight = paramInt2;
    }
    AppMethodBeat.o(89217);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.d
 * JD-Core Version:    0.7.0.1
 */