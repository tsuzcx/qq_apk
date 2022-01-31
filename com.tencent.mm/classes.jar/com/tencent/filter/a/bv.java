package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.f;
import com.tencent.filter.m.o;

public final class bv
  extends BaseFilter
{
  int bcy = 0;
  
  public bv()
  {
    super(GLSLRender.bcE);
  }
  
  public bv(byte paramByte)
  {
    super(GLSLRender.bcE);
    this.bcy = 1;
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    this.glsl_programID = GLSLRender.bcE;
    BaseFilter localBaseFilter1;
    BaseFilter localBaseFilter2;
    if (this.bcy == 0)
    {
      localBaseFilter1 = new BaseFilter(GLSLRender.bdG);
      localBaseFilter1.addParam(new m.o("inputImageTexture2", "sh/shishang_sh_curve.png", 33986));
      setNextFilter(localBaseFilter1, null);
      localBaseFilter2 = new BaseFilter(GLSLRender.bdN);
      localBaseFilter2.addParam(new m.o("inputImageTexture2", "sh/shishang_sh_blend.jpg", 33986));
      localBaseFilter1.setNextFilter(localBaseFilter2, null);
    }
    for (;;)
    {
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
      return;
      localBaseFilter1 = new BaseFilter(GLSLRender.bdO);
      localBaseFilter1.addParam(new m.o("inputImageTexture2", "sh/fugu_sh_blend.jpg", 33986));
      setNextFilter(localBaseFilter1, null);
      localBaseFilter2 = new BaseFilter(GLSLRender.bcH);
      localBaseFilter2.addParam(new m.f("filterAdjustParam", 0.3F));
      localBaseFilter1.setNextFilter(localBaseFilter2, new int[] { this.srcTextureIndex });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.filter.a.bv
 * JD-Core Version:    0.7.0.1
 */