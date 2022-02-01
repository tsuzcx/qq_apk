package com.tencent.mm.live.core.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.b.a;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/core/render/LiveScreenRenderProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "(IIII)V", "animationCost", "animationScale", "", "animationStartTime", "", "drawHeightStart", "drawWidthStart", "isScale", "", "originalDrawHeight", "originalDrawWidth", "beforeRender", "", "endScaleAnimation", "time", "reset", "startScaleAnimation", "scale", "updateDrawViewSize", "width", "height", "plugin-core_release"})
public final class d
  extends com.tencent.mm.media.i.b.d
{
  private boolean HEo;
  private int qQN;
  private int qRE;
  private long qSC;
  private int qSH;
  private float qSI;
  public int qSJ;
  public int qSK;
  
  public d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, 1, 1);
  }
  
  public final void akt()
  {
    AppMethodBeat.i(205759);
    float f1;
    if (System.currentTimeMillis() - this.qSC <= this.qSH)
    {
      if (!this.HEo) {
        break label139;
      }
      f1 = (float)(System.currentTimeMillis() - this.qSC) * (1.0F - this.qSI) / this.qSH;
      this.guK = ((int)(this.qQN * (1.0F - f1)));
      this.guL = ((int)((1.0F - f1) * this.qRE));
    }
    for (;;)
    {
      this.qSJ = ((this.qQN - this.guK) / 2);
      this.qSK = ((this.qRE - this.guL) / 2);
      super.akt();
      GLES20.glViewport(this.qSJ, this.qSK, this.guK, this.guL);
      AppMethodBeat.o(205759);
      return;
      label139:
      f1 = (float)(System.currentTimeMillis() - this.qSC) * (1.0F - this.qSI) / this.qSH;
      this.guK = ((int)(this.qQN * (this.qSI + f1)));
      float f2 = this.qRE;
      this.guL = ((int)((f1 + this.qSI) * f2));
      if (this.guK > this.qQN) {
        this.guK = this.qQN;
      }
      if (this.guL > this.qRE) {
        this.guK = this.qRE;
      }
    }
  }
  
  public final void cT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205760);
    super.cT(paramInt1, paramInt2);
    this.qQN = paramInt1;
    this.qRE = paramInt2;
    AppMethodBeat.o(205760);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.b.d
 * JD-Core Version:    0.7.0.1
 */