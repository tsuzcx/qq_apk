package com.tencent.mm.plugin.api.recordView;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

final class d
{
  static float[] gwe;
  static final float[] gwf;
  static final Object lock;
  int dwp;
  volatile boolean gqu;
  FloatBuffer guS;
  FloatBuffer guT;
  int gvL;
  int gvM;
  int gvN;
  int gvW;
  int gvX;
  ByteBuffer gvZ;
  ByteBuffer gwa;
  boolean iBh;
  int iBi;
  int iBj;
  int iBk;
  int iBl;
  int iBm;
  float[] iBn;
  float[] iBp;
  volatile boolean iBz;
  private int surfaceHeight;
  private int surfaceWidth;
  
  static
  {
    AppMethodBeat.i(89218);
    gwe = new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
    gwf = new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
    lock = new Object();
    AppMethodBeat.o(89218);
  }
  
  public d()
  {
    AppMethodBeat.i(89216);
    this.surfaceWidth = 0;
    this.surfaceHeight = 0;
    this.iBh = false;
    this.iBi = 0;
    this.iBj = 0;
    this.dwp = 0;
    this.iBk = -1;
    this.iBl = -1;
    this.gvL = -1;
    this.iBn = new float[16];
    this.iBp = gwe;
    this.gqu = false;
    this.iBz = false;
    this.gqu = false;
    AppMethodBeat.o(89216);
  }
  
  public final void dz(int paramInt1, int paramInt2)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.d
 * JD-Core Version:    0.7.0.1
 */