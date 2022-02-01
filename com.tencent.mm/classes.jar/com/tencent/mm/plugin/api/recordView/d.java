package com.tencent.mm.plugin.api.recordView;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

final class d
{
  static float[] ilm;
  static final float[] iln;
  static final Object lock;
  int dYT;
  FloatBuffer hDT;
  FloatBuffer hDU;
  int hEy;
  int hEz;
  volatile boolean ife;
  int ikE;
  ByteBuffer ikI;
  int ikO;
  ByteBuffer ikP;
  boolean kxV;
  int kxW;
  int kxX;
  int kxY;
  int kxZ;
  int kya;
  float[] kyb;
  float[] kyd;
  volatile boolean kyn;
  int programId;
  private int surfaceHeight;
  private int surfaceWidth;
  
  static
  {
    AppMethodBeat.i(89218);
    ilm = new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
    iln = new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
    lock = new Object();
    AppMethodBeat.o(89218);
  }
  
  public d()
  {
    AppMethodBeat.i(89216);
    this.surfaceWidth = 0;
    this.surfaceHeight = 0;
    this.kxV = false;
    this.kxW = 0;
    this.kxX = 0;
    this.dYT = 0;
    this.kxY = -1;
    this.kxZ = -1;
    this.programId = -1;
    this.kyb = new float[16];
    this.kyd = ilm;
    this.ife = false;
    this.kyn = false;
    this.ife = false;
    AppMethodBeat.o(89216);
  }
  
  public final void dL(int paramInt1, int paramInt2)
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