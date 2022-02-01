package com.tencent.mm.plugin.api.recordView;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

final class d
{
  static float[] laj;
  static final float[] lak;
  static final Object lock;
  int fSM;
  volatile boolean kTS;
  ByteBuffer kZC;
  int kZI;
  ByteBuffer kZJ;
  int kZy;
  int ksD;
  int ksE;
  FloatBuffer ksa;
  FloatBuffer ksb;
  boolean nqV;
  int nqW;
  int nqX;
  int nqY;
  int nqZ;
  int nra;
  float[] nrb;
  float[] nrd;
  volatile boolean nrn;
  int programId;
  private int surfaceHeight;
  private int surfaceWidth;
  
  static
  {
    AppMethodBeat.i(89218);
    laj = new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
    lak = new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
    lock = new Object();
    AppMethodBeat.o(89218);
  }
  
  public d()
  {
    AppMethodBeat.i(89216);
    this.surfaceWidth = 0;
    this.surfaceHeight = 0;
    this.nqV = false;
    this.nqW = 0;
    this.nqX = 0;
    this.fSM = 0;
    this.nqY = -1;
    this.nqZ = -1;
    this.programId = -1;
    this.nrb = new float[16];
    this.nrd = laj;
    this.kTS = false;
    this.nrn = false;
    this.kTS = false;
    AppMethodBeat.o(89216);
  }
  
  public final void ej(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89217);
    Log.i("MicroMsg.MMSightRecordTextureViewRenderer", "onSurfaceChanged, surfaceWidth: %s, height: %s this %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), this });
    if ((paramInt1 != this.surfaceWidth) || (paramInt2 != this.surfaceHeight))
    {
      Log.i("MicroMsg.MMSightRecordTextureViewRenderer", "onSurfaceChanged change viewpoint");
      GLES20.glViewport(0, 0, paramInt1, paramInt2);
      this.surfaceWidth = paramInt1;
      this.surfaceHeight = paramInt2;
    }
    AppMethodBeat.o(89217);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.d
 * JD-Core Version:    0.7.0.1
 */