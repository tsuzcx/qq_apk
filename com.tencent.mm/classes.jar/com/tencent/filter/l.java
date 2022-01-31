package com.tencent.filter;

import com.tencent.view.f;

public final class l
  extends BaseFilter
{
  float bfF = 0.001F;
  float bfG = 0.999F;
  
  public l()
  {
    super(GLSLRender.bdk);
  }
  
  public l(float paramFloat1, float paramFloat2)
  {
    super(GLSLRender.bdk);
    this.bfF = paramFloat1;
    this.bfG = paramFloat2;
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    addParam(new m.f("l_threshold", 0.1F));
    addParam(new m.f("h_threshold", 0.1F));
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public final void beforeRender(int paramInt1, int paramInt2, int paramInt3)
  {
    QImage localQImage = f.ay(paramInt1, paramInt2, paramInt3);
    int[] arrayOfInt = localQImage.nativeGetArrayHistogram();
    localQImage.Dispose();
    paramInt1 = 0;
    paramInt2 = 0;
    while (paramInt2 < 256)
    {
      paramInt1 += arrayOfInt[paramInt2];
      paramInt2 += 1;
    }
    float f1 = this.bfF;
    float f2 = this.bfG;
    paramInt3 = (int)(f1 * paramInt1);
    int j = (int)(paramInt1 * f2);
    paramInt2 = 0;
    paramInt1 = 0;
    if (paramInt1 < 256)
    {
      paramInt2 += arrayOfInt[paramInt1];
      if (paramInt2 >= paramInt3)
      {
        int i = paramInt1 + 1;
        paramInt3 = paramInt1;
        paramInt1 = i;
      }
    }
    for (;;)
    {
      label105:
      if (paramInt1 < 256)
      {
        paramInt2 = arrayOfInt[paramInt1] + paramInt2;
        if (paramInt2 < j) {}
      }
      for (;;)
      {
        addParam(new m.f("l_threshold", (float)(paramInt3 / 255.0D)));
        addParam(new m.f("h_threshold", (float)(paramInt1 / 255.0D)));
        return;
        paramInt1 += 1;
        break;
        paramInt1 += 1;
        break label105;
        paramInt1 = 0;
      }
      paramInt3 = 0;
    }
  }
  
  public final boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    return super.renderTexture(paramInt1, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.filter.l
 * JD-Core Version:    0.7.0.1
 */