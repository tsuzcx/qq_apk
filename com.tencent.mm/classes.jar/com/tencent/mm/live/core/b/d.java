package com.tencent.mm.live.core.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.a;
import com.tencent.mm.media.j.b.e;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/core/render/LiveScreenRenderProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "(IIII)V", "animationCost", "animationScale", "", "animationStartTime", "", "drawHeightStart", "drawWidthStart", "isScale", "", "originalDrawHeight", "originalDrawWidth", "beforeRender", "", "endScaleAnimation", "time", "reset", "startScaleAnimation", "scale", "updateDrawViewSize", "width", "height", "plugin-core_release"})
public final class d
  extends e
{
  private int gNG;
  private int gNH;
  private long gNI;
  private int gNJ;
  private float gNK;
  public int gNL;
  public int gNM;
  private boolean gNN;
  
  public d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, 1, 1);
  }
  
  public final void amF()
  {
    AppMethodBeat.i(196965);
    float f1;
    if (System.currentTimeMillis() - this.gNI <= this.gNJ)
    {
      if (!this.gNN) {
        break label139;
      }
      f1 = (float)(System.currentTimeMillis() - this.gNI) * (1.0F - this.gNK) / this.gNJ;
      this.gOm = ((int)(this.gNG * (1.0F - f1)));
      this.gOn = ((int)((1.0F - f1) * this.gNH));
    }
    for (;;)
    {
      this.gNL = ((this.gNG - this.gOm) / 2);
      this.gNM = ((this.gNH - this.gOn) / 2);
      super.amF();
      GLES20.glViewport(this.gNL, this.gNM, this.gOm, this.gOn);
      AppMethodBeat.o(196965);
      return;
      label139:
      f1 = (float)(System.currentTimeMillis() - this.gNI) * (1.0F - this.gNK) / this.gNJ;
      this.gOm = ((int)(this.gNG * (this.gNK + f1)));
      float f2 = this.gNH;
      this.gOn = ((int)((f1 + this.gNK) * f2));
      if (this.gOm > this.gNG) {
        this.gOm = this.gNG;
      }
      if (this.gOn > this.gNH) {
        this.gOm = this.gNH;
      }
    }
  }
  
  public final void cT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(196966);
    super.cT(paramInt1, paramInt2);
    this.gNG = paramInt1;
    this.gNH = paramInt2;
    AppMethodBeat.o(196966);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.core.b.d
 * JD-Core Version:    0.7.0.1
 */