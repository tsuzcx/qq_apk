package com.tencent.filter;

import com.tencent.view.f;

public final class j$a
  extends BaseFilter
{
  int aVo = 0;
  float bfC = 25.0F;
  float bfJ = 1.0F;
  
  public j$a(float paramFloat)
  {
    super(GLSLRender.bdi);
    this.bfJ = paramFloat;
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    this.aVo = f.cRo();
    addParam(new m.f("strength", this.bfC));
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public final void ClearGLSL()
  {
    f.Ku(this.aVo);
    super.ClearGLSL();
  }
  
  public final void U(float paramFloat)
  {
    this.bfC = paramFloat;
    addParam(new m.f("strength", this.bfC));
  }
  
  public final void beforeRender(int paramInt1, int paramInt2, int paramInt3)
  {
    QImage localQImage1 = f.ay(paramInt1, paramInt2, paramInt3);
    QImage localQImage2 = localQImage1.InplaceBlur8bitQImage(1, (int)(80.0F * this.bfJ));
    localQImage1.Dispose();
    GLSLRender.nativeTextImage(localQImage2, this.aVo);
    localQImage2.Dispose();
  }
  
  public final boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    setTextureParam(this.aVo, 1);
    return super.renderTexture(paramInt1, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.filter.j.a
 * JD-Core Version:    0.7.0.1
 */