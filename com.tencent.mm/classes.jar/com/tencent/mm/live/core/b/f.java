package com.tencent.mm.live.core.b;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.a;
import com.tencent.mm.media.j.b.e;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/core/render/LiveScreenRenderProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "(IIII)V", "animationCost", "animationScale", "", "animationStartTime", "", "drawHeightStart", "drawWidthStart", "isScale", "", "originalDrawHeight", "originalDrawWidth", "beforeRender", "", "endScaleAnimation", "time", "initMatrixTemp", "reset", "startScaleAnimation", "scale", "updateDrawViewSize", "width", "height", "plugin-core_release"})
public final class f
  extends e
{
  private int hDF;
  private int hDG;
  private long hDH;
  private int hDI;
  private float hDJ;
  public int hDK;
  public int hDL;
  private boolean hDM;
  
  public f(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, 1, 1);
  }
  
  public final void aEB()
  {
    AppMethodBeat.i(196650);
    float f1;
    if (System.currentTimeMillis() - this.hDH <= this.hDI)
    {
      if (!this.hDM) {
        break label221;
      }
      f1 = (float)(System.currentTimeMillis() - this.hDH) * (1.0F - this.hDJ) / this.hDI;
      this.hEp = ((int)(this.hDF * (1.0F - f1)));
      this.hEq = ((int)((1.0F - f1) * this.hDG));
    }
    for (;;)
    {
      this.hDK = ((this.hDF - this.hEp) / 2);
      this.hDL = ((this.hDG - this.hEq) / 2);
      Matrix.setIdentityM(this.ijG, 0);
      Matrix.setRotateM(this.ijG, 0, this.ijt, 0.0F, 0.0F, -1.0F);
      if (this.iju) {
        Matrix.scaleM(this.ijG, 0, -1.0F, 1.0F, 1.0F);
      }
      if (this.scaleType == 5) {
        E(this.hEp / this.hEq, this.hDn / this.hDo);
      }
      aMS();
      aMT();
      GLES20.glViewport(this.hDK, this.hDL, this.hEp, this.hEq);
      AppMethodBeat.o(196650);
      return;
      label221:
      f1 = (float)(System.currentTimeMillis() - this.hDH) * (1.0F - this.hDJ) / this.hDI;
      this.hEp = ((int)(this.hDF * (this.hDJ + f1)));
      float f2 = this.hDG;
      this.hEq = ((int)((f1 + this.hDJ) * f2));
      if (this.hEp > this.hDF) {
        this.hEp = this.hDF;
      }
      if (this.hEq > this.hDG) {
        this.hEp = this.hDG;
      }
    }
  }
  
  public final void cY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(196651);
    super.cY(paramInt1, paramInt2);
    this.hDF = paramInt1;
    this.hDG = paramInt2;
    AppMethodBeat.o(196651);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.b.f
 * JD-Core Version:    0.7.0.1
 */