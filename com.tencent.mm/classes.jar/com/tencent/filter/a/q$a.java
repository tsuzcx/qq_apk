package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.FilterAlgorithm;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.QImage;
import com.tencent.view.f;

public final class q$a
  extends BaseFilter
{
  private int aVo = 0;
  float bfJ = 1.0F;
  private float bgd = 0.0F;
  
  public q$a(q paramq, int paramInt, float paramFloat)
  {
    super(GLSLRender.bcH);
    this.bfJ = paramFloat;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.bgd *= 2.0F;
      return;
      this.bgd = 0.62F;
      continue;
      this.bgd = 0.67F;
      continue;
      this.bgd = 1.0F;
    }
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
    FilterAlgorithm.nativeFastBlur(localQImage, this.bgd * this.bfJ);
    GLSLRender.nativeTextImage(localQImage, this.aVo);
    localQImage.Dispose();
  }
  
  public final boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    return super.renderTexture(this.aVo, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.filter.a.q.a
 * JD-Core Version:    0.7.0.1
 */