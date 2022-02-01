package com.tencent.mm.live.core.b;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/render/LiveScreenRenderProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "(IIII)V", "animationCost", "animationScale", "", "animationStartTime", "", "drawHeightStart", "drawWidthStart", "isScale", "", "originalDrawHeight", "originalDrawWidth", "beforeRender", "", "endScaleAnimation", "time", "initMatrixTemp", "reset", "startScaleAnimation", "scale", "updateDrawViewSize", "width", "height", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends com.tencent.mm.media.j.b.e
{
  private boolean mVA;
  private int mVt;
  private int mVu;
  private long mVv;
  private int mVw;
  private float mVx;
  private int mVy;
  private int mVz;
  
  public e(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, 1, 2);
  }
  
  public final void bgB()
  {
    AppMethodBeat.i(247692);
    float f1;
    if (System.currentTimeMillis() - this.mVv <= this.mVw)
    {
      if (!this.mVA) {
        break label221;
      }
      f1 = (float)(System.currentTimeMillis() - this.mVv) * (1.0F - this.mVx) / this.mVw;
      tZ((int)(this.mVt * (1.0F - f1)));
      ua((int)((1.0F - f1) * this.mVu));
    }
    for (;;)
    {
      this.mVy = ((this.mVt - getDrawWidth()) / 2);
      this.mVz = ((this.mVu - getDrawHeight()) / 2);
      Matrix.setIdentityM(bpY(), 0);
      Matrix.setRotateM(bpY(), 0, this.nDr, 0.0F, 0.0F, -1.0F);
      if (bpZ()) {
        Matrix.scaleM(bpY(), 0, -1.0F, 1.0F, 1.0F);
      }
      if (getScaleType() == 5) {
        am(getDrawWidth() / getDrawHeight(), bpT() / bpU());
      }
      bqd();
      bqe();
      GLES20.glViewport(this.mVy, this.mVz, getDrawWidth(), getDrawHeight());
      AppMethodBeat.o(247692);
      return;
      label221:
      f1 = (float)(System.currentTimeMillis() - this.mVv) * (1.0F - this.mVx) / this.mVw;
      tZ((int)(this.mVt * (this.mVx + f1)));
      float f2 = this.mVu;
      ua((int)((f1 + this.mVx) * f2));
      if (getDrawWidth() > this.mVt) {
        tZ(this.mVt);
      }
      if (getDrawHeight() > this.mVu) {
        tZ(this.mVu);
      }
    }
  }
  
  public final void ek(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(247699);
    super.ek(paramInt1, paramInt2);
    this.mVt = paramInt1;
    this.mVu = paramInt2;
    AppMethodBeat.o(247699);
  }
  
  public final void reset()
  {
    this.mVz = 0;
    this.mVy = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.live.core.b.e
 * JD-Core Version:    0.7.0.1
 */