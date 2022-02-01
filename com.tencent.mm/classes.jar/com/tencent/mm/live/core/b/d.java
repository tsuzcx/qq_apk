package com.tencent.mm.live.core.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.a;
import com.tencent.mm.media.j.b.e;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/core/render/LiveScreenRenderProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "(IIII)V", "animationCost", "animationScale", "", "animationStartTime", "", "drawHeightStart", "drawWidthStart", "isScale", "", "originalDrawHeight", "originalDrawWidth", "beforeRender", "", "endScaleAnimation", "time", "reset", "startScaleAnimation", "scale", "updateDrawViewSize", "width", "height", "plugin-core_release"})
public final class d
  extends e
{
  private int gKX;
  private int gKY;
  private long gKZ;
  private int gLa;
  private float gLb;
  public int gLc;
  public int gLd;
  private boolean gLe;
  
  public d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, 1, 1);
  }
  
  public final void amq()
  {
    AppMethodBeat.i(216953);
    float f1;
    if (System.currentTimeMillis() - this.gKZ <= this.gLa)
    {
      if (!this.gLe) {
        break label139;
      }
      f1 = (float)(System.currentTimeMillis() - this.gKZ) * (1.0F - this.gLb) / this.gLa;
      this.gLD = ((int)(this.gKX * (1.0F - f1)));
      this.gLE = ((int)((1.0F - f1) * this.gKY));
    }
    for (;;)
    {
      this.gLc = ((this.gKX - this.gLD) / 2);
      this.gLd = ((this.gKY - this.gLE) / 2);
      super.amq();
      GLES20.glViewport(this.gLc, this.gLd, this.gLD, this.gLE);
      AppMethodBeat.o(216953);
      return;
      label139:
      f1 = (float)(System.currentTimeMillis() - this.gKZ) * (1.0F - this.gLb) / this.gLa;
      this.gLD = ((int)(this.gKX * (this.gLb + f1)));
      float f2 = this.gKY;
      this.gLE = ((int)((f1 + this.gLb) * f2));
      if (this.gLD > this.gKX) {
        this.gLD = this.gKX;
      }
      if (this.gLE > this.gKY) {
        this.gLD = this.gKY;
      }
    }
  }
  
  public final void cT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(216954);
    super.cT(paramInt1, paramInt2);
    this.gKX = paramInt1;
    this.gKY = paramInt2;
    AppMethodBeat.o(216954);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.core.b.d
 * JD-Core Version:    0.7.0.1
 */