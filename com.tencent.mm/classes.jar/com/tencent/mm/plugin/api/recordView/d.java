package com.tencent.mm.plugin.api.recordView;

import android.opengl.GLES20;
import com.tencent.mm.sdk.platformtools.y;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

final class d
{
  static float[] fvS = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  static final float[] fvU = { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  static final Object lock = new Object();
  boolean brU = false;
  private int fvV = 0;
  private int fvW = 0;
  int fvY = 0;
  int fvZ = 0;
  volatile boolean fwL = false;
  volatile boolean fwM = false;
  ByteBuffer fwa;
  ByteBuffer fwb;
  int fwc = -1;
  int fwd = -1;
  int fwe = -1;
  int fwf;
  int fwg;
  int fwh;
  int fwi;
  int fwj;
  FloatBuffer fwk;
  FloatBuffer fwl;
  float[] fwm = new float[16];
  float[] fwo = fvS;
  int rotate = 0;
  
  public final void bH(int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.MMSightRecordTextureViewRenderer", "onSurfaceChanged, surfaceWidth: %s, height: %s this %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), this });
    if ((paramInt1 != this.fvV) || (paramInt2 != this.fvW))
    {
      y.i("MicroMsg.MMSightRecordTextureViewRenderer", "onSurfaceChanged change viewpoint");
      GLES20.glViewport(0, 0, paramInt1, paramInt2);
      this.fvV = paramInt1;
      this.fvW = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.d
 * JD-Core Version:    0.7.0.1
 */