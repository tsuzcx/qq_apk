package com.tencent.mm.plugin.api.recordView;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

final class d
{
  static float[] hrw;
  static final float[] hrx;
  static final Object lock;
  int dHi;
  FloatBuffer gNU;
  FloatBuffer gNV;
  int gOv;
  int gOw;
  int gOx;
  volatile boolean hmi;
  int hri;
  ByteBuffer hrm;
  int hrs;
  ByteBuffer hrt;
  volatile boolean jxE;
  boolean jxm;
  int jxn;
  int jxo;
  int jxp;
  int jxq;
  int jxr;
  float[] jxs;
  float[] jxu;
  private int surfaceHeight;
  private int surfaceWidth;
  
  static
  {
    AppMethodBeat.i(89218);
    hrw = new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
    hrx = new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
    lock = new Object();
    AppMethodBeat.o(89218);
  }
  
  public d()
  {
    AppMethodBeat.i(89216);
    this.surfaceWidth = 0;
    this.surfaceHeight = 0;
    this.jxm = false;
    this.jxn = 0;
    this.jxo = 0;
    this.dHi = 0;
    this.jxp = -1;
    this.jxq = -1;
    this.gOv = -1;
    this.jxs = new float[16];
    this.jxu = hrw;
    this.hmi = false;
    this.jxE = false;
    this.hmi = false;
    AppMethodBeat.o(89216);
  }
  
  public final void dB(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89217);
    ae.i("MicroMsg.MMSightRecordTextureViewRenderer", "onSurfaceChanged, surfaceWidth: %s, height: %s this %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), this });
    if ((paramInt1 != this.surfaceWidth) || (paramInt2 != this.surfaceHeight))
    {
      ae.i("MicroMsg.MMSightRecordTextureViewRenderer", "onSurfaceChanged change viewpoint");
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