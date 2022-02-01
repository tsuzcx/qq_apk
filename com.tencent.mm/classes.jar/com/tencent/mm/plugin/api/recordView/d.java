package com.tencent.mm.plugin.api.recordView;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

final class d
{
  static final Object lock;
  static float[] nFt;
  static final float[] nFu;
  int hYK;
  FloatBuffer mVU;
  FloatBuffer mVV;
  int mWv;
  int mWw;
  int nEF;
  ByteBuffer nEJ;
  int nEP;
  ByteBuffer nEQ;
  volatile boolean nzB;
  int programId;
  boolean qpC;
  int qpD;
  int qpE;
  int qpF;
  int qpG;
  int qpH;
  float[] qpI;
  float[] qpK;
  volatile boolean qpU;
  private int surfaceHeight;
  private int surfaceWidth;
  
  static
  {
    AppMethodBeat.i(89218);
    nFt = new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
    nFu = new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
    lock = new Object();
    AppMethodBeat.o(89218);
  }
  
  public d()
  {
    AppMethodBeat.i(89216);
    this.surfaceWidth = 0;
    this.surfaceHeight = 0;
    this.qpC = false;
    this.qpD = 0;
    this.qpE = 0;
    this.hYK = 0;
    this.qpF = -1;
    this.qpG = -1;
    this.programId = -1;
    this.qpI = new float[16];
    this.qpK = nFt;
    this.nzB = false;
    this.qpU = false;
    this.nzB = false;
    AppMethodBeat.o(89216);
  }
  
  public final void fd(int paramInt1, int paramInt2)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.d
 * JD-Core Version:    0.7.0.1
 */