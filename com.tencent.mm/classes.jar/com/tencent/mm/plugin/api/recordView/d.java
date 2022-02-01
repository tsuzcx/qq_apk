package com.tencent.mm.plugin.api.recordView;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

final class d
{
  static float[] gWC;
  static final float[] gWD;
  static final Object lock;
  int duc;
  volatile boolean gRc;
  int gWo;
  ByteBuffer gWs;
  int gWy;
  ByteBuffer gWz;
  FloatBuffer grD;
  FloatBuffer grE;
  int gse;
  int gsf;
  int gsg;
  volatile boolean jbA;
  boolean jbi;
  int jbj;
  int jbk;
  int jbl;
  int jbm;
  int jbn;
  float[] jbo;
  float[] jbq;
  private int surfaceHeight;
  private int surfaceWidth;
  
  static
  {
    AppMethodBeat.i(89218);
    gWC = new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
    gWD = new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
    lock = new Object();
    AppMethodBeat.o(89218);
  }
  
  public d()
  {
    AppMethodBeat.i(89216);
    this.surfaceWidth = 0;
    this.surfaceHeight = 0;
    this.jbi = false;
    this.jbj = 0;
    this.jbk = 0;
    this.duc = 0;
    this.jbl = -1;
    this.jbm = -1;
    this.gse = -1;
    this.jbo = new float[16];
    this.jbq = gWC;
    this.gRc = false;
    this.jbA = false;
    this.gRc = false;
    AppMethodBeat.o(89216);
  }
  
  public final void dz(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89217);
    ac.i("MicroMsg.MMSightRecordTextureViewRenderer", "onSurfaceChanged, surfaceWidth: %s, height: %s this %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), this });
    if ((paramInt1 != this.surfaceWidth) || (paramInt2 != this.surfaceHeight))
    {
      ac.i("MicroMsg.MMSightRecordTextureViewRenderer", "onSurfaceChanged change viewpoint");
      GLES20.glViewport(0, 0, paramInt1, paramInt2);
      this.surfaceWidth = paramInt1;
      this.surfaceHeight = paramInt2;
    }
    AppMethodBeat.o(89217);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.d
 * JD-Core Version:    0.7.0.1
 */