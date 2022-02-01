package com.tencent.mm.live.core.b;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.a;
import com.tencent.mm.media.j.b.e;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/render/LiveScreenRenderProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "(IIII)V", "animationCost", "animationScale", "", "animationStartTime", "", "drawHeightStart", "drawWidthStart", "isScale", "", "originalDrawHeight", "originalDrawWidth", "beforeRender", "", "endScaleAnimation", "time", "initMatrixTemp", "reset", "startScaleAnimation", "scale", "updateDrawViewSize", "width", "height", "plugin-core_release"})
public final class f
  extends e
{
  private long krA;
  private int krB;
  private float krC;
  private int krD;
  private int krE;
  private boolean krF;
  private int kry;
  private int krz;
  
  public f(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, 1, 2);
  }
  
  public final void aMR()
  {
    AppMethodBeat.i(198456);
    float f1;
    if (System.currentTimeMillis() - this.krA <= this.krB)
    {
      if (!this.krF) {
        break label221;
      }
      f1 = (float)(System.currentTimeMillis() - this.krA) * (1.0F - this.krC) / this.krB;
      ub((int)(this.kry * (1.0F - f1)));
      uc((int)((1.0F - f1) * this.krz));
    }
    for (;;)
    {
      this.krD = ((this.kry - getDrawWidth()) / 2);
      this.krE = ((this.krz - getDrawHeight()) / 2);
      Matrix.setIdentityM(aVo(), 0);
      Matrix.setRotateM(aVo(), 0, aVp(), 0.0F, 0.0F, -1.0F);
      if (this.kYh) {
        Matrix.scaleM(aVo(), 0, -1.0F, 1.0F, 1.0F);
      }
      if (getScaleType() == 5) {
        G(getDrawWidth() / getDrawHeight(), aVx() / aVy());
      }
      aVt();
      aVu();
      GLES20.glViewport(this.krD, this.krE, getDrawWidth(), getDrawHeight());
      AppMethodBeat.o(198456);
      return;
      label221:
      f1 = (float)(System.currentTimeMillis() - this.krA) * (1.0F - this.krC) / this.krB;
      ub((int)(this.kry * (this.krC + f1)));
      float f2 = this.krz;
      uc((int)((f1 + this.krC) * f2));
      if (getDrawWidth() > this.kry) {
        ub(this.kry);
      }
      if (getDrawHeight() > this.krz) {
        ub(this.krz);
      }
    }
  }
  
  public final void du(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(198459);
    super.du(paramInt1, paramInt2);
    this.kry = paramInt1;
    this.krz = paramInt2;
    AppMethodBeat.o(198459);
  }
  
  public final void reset()
  {
    this.krE = 0;
    this.krD = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.b.f
 * JD-Core Version:    0.7.0.1
 */