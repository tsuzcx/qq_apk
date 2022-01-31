package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.QImage;
import com.tencent.filter.m.f;
import com.tencent.view.f;

public final class af
  extends BaseFilter
{
  float bfF = 0.001F;
  float bfG = 0.999F;
  
  public af()
  {
    super(GLSLRender.bdR);
  }
  
  public af(float paramFloat)
  {
    super(GLSLRender.bdR);
    this.bfF = (0.0F + paramFloat * 0.05F);
    this.bfG = (1.0F - paramFloat * 0.05F);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    addParam(new m.f("l_threshold_r", 0.1F));
    addParam(new m.f("h_threshold_r", 0.1F));
    addParam(new m.f("l_threshold_g", 0.1F));
    addParam(new m.f("h_threshold_g", 0.1F));
    addParam(new m.f("l_threshold_b", 0.1F));
    addParam(new m.f("h_threshold_b", 0.1F));
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public final void beforeRender(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = f.ay(paramInt1, paramInt2, paramInt3);
    int[] arrayOfInt1 = ((QImage)localObject).nativeGetArrayHistogramChannels();
    ((QImage)localObject).Dispose();
    localObject = new int[3];
    int[] arrayOfInt2 = new int[3];
    paramInt3 = 0;
    int k;
    int m;
    int i;
    if (paramInt3 < 3)
    {
      k = paramInt3 * 256;
      paramInt1 = 0;
      paramInt2 = 0;
      while (paramInt2 < 256)
      {
        paramInt1 += arrayOfInt1[(k + paramInt2)];
        paramInt2 += 1;
      }
      float f1 = this.bfF;
      float f2 = this.bfG;
      int j = (int)(f1 * paramInt1);
      m = (int)(paramInt1 * f2);
      paramInt2 = 0;
      i = 0;
      paramInt1 = 0;
      label107:
      if (paramInt1 >= 256) {
        break label334;
      }
      paramInt2 += arrayOfInt1[(k + paramInt1)];
      if (paramInt2 >= j)
      {
        j = paramInt1 + 1;
        i = paramInt1;
        paramInt1 = j;
      }
    }
    label141:
    label334:
    for (;;)
    {
      if (paramInt1 < 256)
      {
        paramInt2 = arrayOfInt1[(k + paramInt1)] + paramInt2;
        if (paramInt2 < m) {}
      }
      for (;;)
      {
        localObject[paramInt3] = i;
        arrayOfInt2[paramInt3] = paramInt1;
        paramInt3 += 1;
        break;
        paramInt1 += 1;
        break label107;
        paramInt1 += 1;
        break label141;
        addParam(new m.f("l_threshold_r", localObject[0] / 255.0F));
        addParam(new m.f("h_threshold_r", arrayOfInt2[0] / 255.0F));
        addParam(new m.f("l_threshold_g", localObject[1] / 255.0F));
        addParam(new m.f("h_threshold_g", arrayOfInt2[1] / 255.0F));
        addParam(new m.f("l_threshold_b", localObject[2] / 255.0F));
        addParam(new m.f("h_threshold_b", arrayOfInt2[2] / 255.0F));
        return;
        paramInt1 = 0;
      }
    }
  }
  
  public final boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    return super.renderTexture(paramInt1, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.filter.a.af
 * JD-Core Version:    0.7.0.1
 */