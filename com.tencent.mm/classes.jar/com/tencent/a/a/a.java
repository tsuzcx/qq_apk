package com.tencent.a.a;

import com.microrapid.opencv.OpencvAlgorithm;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.QImage;
import com.tencent.view.f;

public final class a
  extends BaseFilter
{
  int aVo = 0;
  float strength = 5.0F;
  
  public a()
  {
    super(GLSLRender.bcE);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    this.aVo = f.cRo();
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public final void ClearGLSL()
  {
    f.Ku(this.aVo);
    super.ClearGLSL();
  }
  
  public final void beforeRender(int paramInt1, int paramInt2, int paramInt3)
  {
    QImage localQImage = f.ay(paramInt1, paramInt2, paramInt3);
    OpencvAlgorithm.nativeDetailEnhanceFilter(localQImage, this.strength);
    GLSLRender.nativeTextImage(localQImage, this.aVo);
    localQImage.Dispose();
  }
  
  public final boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    return super.renderTexture(this.aVo, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.a.a.a
 * JD-Core Version:    0.7.0.1
 */