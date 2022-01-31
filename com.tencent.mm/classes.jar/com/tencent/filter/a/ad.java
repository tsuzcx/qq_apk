package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.f;
import com.tencent.filter.m.o;

public final class ad
  extends BaseFilter
{
  public ad()
  {
    super(GLSLRender.bcE);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    BaseFilter localBaseFilter2 = new BaseFilter(GLSLRender.bdG);
    localBaseFilter2.addParam(new m.o("inputImageTexture2", "sh/purpleyellow_nuan_curve.png", 33986));
    setNextFilter(localBaseFilter2, null);
    BaseFilter localBaseFilter1 = new BaseFilter(GLSLRender.bfk);
    if (this.needFlipBlend) {}
    for (int i = 1;; i = 0)
    {
      localBaseFilter1.addParam(new m.o("inputImageTexture2", "sh/gradient_purpleyellow_rgb.png", i, (byte)0));
      localBaseFilter1.addParam(new m.f("ralpha", 0.6F));
      localBaseFilter1.addParam(new m.f("galpha", 0.6F));
      localBaseFilter1.addParam(new m.f("balpha", 0.6F));
      localBaseFilter2.setNextFilter(localBaseFilter1, null);
      localBaseFilter2 = new BaseFilter(GLSLRender.bdG);
      localBaseFilter2.addParam(new m.o("inputImageTexture2", "sh/purpleyellow_anticmos_curve.png", 33986));
      localBaseFilter1.setNextFilter(localBaseFilter2, null);
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.filter.a.ad
 * JD-Core Version:    0.7.0.1
 */