package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.FilterAlgorithm;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.QImage;
import com.tencent.filter.m.f;
import com.tencent.view.f;

public final class k
  extends BaseFilter
{
  int aVo = 0;
  float bfJ = 1.0F;
  
  public k(float paramFloat)
  {
    super(GLSLRender.beO);
    this.bfJ = paramFloat;
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    this.aVo = f.cRo();
    addParam(new m.f("edge", 0.5F));
    addParam(new m.f("vmin", 0.0F));
    addParam(new m.f("vmax", 1.0F));
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public final void ClearGLSL()
  {
    f.Ku(this.aVo);
    super.ClearGLSL();
  }
  
  public final void beforeRender(int paramInt1, int paramInt2, int paramInt3)
  {
    QImage localQImage1 = f.ay(paramInt1, paramInt2, paramInt3);
    QImage localQImage2 = localQImage1.InplaceBlur8bitQImage(1, (int)(80.0F * this.bfJ));
    float[] arrayOfFloat = FilterAlgorithm.nativeGetMaxAndMin(localQImage2);
    localQImage1.Dispose();
    addParam(new m.f("edge", (arrayOfFloat[0] + arrayOfFloat[1]) / 510.0F));
    addParam(new m.f("vmin", arrayOfFloat[0] / 255.0F));
    addParam(new m.f("vmax", arrayOfFloat[1] / 255.0F));
    GLSLRender.nativeTextImage(localQImage2, this.aVo);
    localQImage2.Dispose();
  }
  
  public final boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    return super.renderTexture(this.aVo, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.filter.a.k
 * JD-Core Version:    0.7.0.1
 */