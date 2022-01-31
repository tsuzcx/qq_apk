package com.tencent.mm.plugin.api.recordView;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

final class d
{
  static float[] eZq;
  static final float[] eZr;
  static final Object lock;
  volatile boolean eUY;
  int eYZ;
  FloatBuffer eYu;
  FloatBuffer eYv;
  int eZa;
  int eZb;
  int eZe;
  int eZf;
  int eZj;
  int eZk;
  ByteBuffer eZm;
  ByteBuffer eZn;
  private int fbH;
  private int fbI;
  int gNA;
  int gNB;
  int gNC;
  float[] gND;
  float[] gNF;
  volatile boolean gNN;
  boolean gNz;
  int rotate;
  
  static
  {
    AppMethodBeat.i(76336);
    eZq = new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
    eZr = new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
    lock = new Object();
    AppMethodBeat.o(76336);
  }
  
  public d()
  {
    AppMethodBeat.i(76334);
    this.fbH = 0;
    this.fbI = 0;
    this.gNz = false;
    this.gNA = 0;
    this.gNB = 0;
    this.rotate = 0;
    this.eZe = -1;
    this.eZf = -1;
    this.eYZ = -1;
    this.gND = new float[16];
    this.gNF = eZq;
    this.eUY = false;
    this.gNN = false;
    this.eUY = false;
    AppMethodBeat.o(76334);
  }
  
  public final void cR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(76335);
    ab.i("MicroMsg.MMSightRecordTextureViewRenderer", "onSurfaceChanged, surfaceWidth: %s, height: %s this %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), this });
    if ((paramInt1 != this.fbH) || (paramInt2 != this.fbI))
    {
      ab.i("MicroMsg.MMSightRecordTextureViewRenderer", "onSurfaceChanged change viewpoint");
      GLES20.glViewport(0, 0, paramInt1, paramInt2);
      this.fbH = paramInt1;
      this.fbI = paramInt2;
    }
    AppMethodBeat.o(76335);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.d
 * JD-Core Version:    0.7.0.1
 */