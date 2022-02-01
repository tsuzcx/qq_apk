package com.tencent.mm.live.core.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.b.a;
import com.tencent.mm.media.i.b.e;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/core/render/LiveScreenRenderProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "(IIII)V", "animationCost", "animationScale", "", "animationStartTime", "", "drawHeightStart", "drawWidthStart", "isScale", "", "originalDrawHeight", "originalDrawWidth", "beforeRender", "", "endScaleAnimation", "time", "reset", "startScaleAnimation", "scale", "updateDrawViewSize", "width", "height", "plugin-core_release"})
public final class d
  extends e
{
  private int grn;
  private int gro;
  private long grp;
  private int grq;
  private float grr;
  public int grs;
  public int grt;
  private boolean gru;
  
  public d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, 1, 1);
  }
  
  public final void ajE()
  {
    AppMethodBeat.i(209295);
    float f1;
    if (System.currentTimeMillis() - this.grp <= this.grq)
    {
      if (!this.gru) {
        break label139;
      }
      f1 = (float)(System.currentTimeMillis() - this.grp) * (1.0F - this.grr) / this.grq;
      this.grV = ((int)(this.grn * (1.0F - f1)));
      this.grW = ((int)((1.0F - f1) * this.gro));
    }
    for (;;)
    {
      this.grs = ((this.grn - this.grV) / 2);
      this.grt = ((this.gro - this.grW) / 2);
      super.ajE();
      GLES20.glViewport(this.grs, this.grt, this.grV, this.grW);
      AppMethodBeat.o(209295);
      return;
      label139:
      f1 = (float)(System.currentTimeMillis() - this.grp) * (1.0F - this.grr) / this.grq;
      this.grV = ((int)(this.grn * (this.grr + f1)));
      float f2 = this.gro;
      this.grW = ((int)((f1 + this.grr) * f2));
      if (this.grV > this.grn) {
        this.grV = this.grn;
      }
      if (this.grW > this.gro) {
        this.grV = this.gro;
      }
    }
  }
  
  public final void cR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(209296);
    super.cR(paramInt1, paramInt2);
    this.grn = paramInt1;
    this.gro = paramInt2;
    AppMethodBeat.o(209296);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.live.core.b.d
 * JD-Core Version:    0.7.0.1
 */