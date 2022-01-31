package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.g;
import com.tencent.filter.m.i;
import com.tencent.filter.m.o;

public final class ai
  extends BaseFilter
{
  public ai()
  {
    super(GLSLRender.bcE);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    BaseFilter localBaseFilter1 = new BaseFilter(GLSLRender.bdJ);
    localBaseFilter1.addParam(new m.g("shadowsShift", new float[] { -0.0588235F, 0.03529412F, -0.02352941F }));
    localBaseFilter1.addParam(new m.g("midtonesShift", new float[] { 0.0F, 0.0F, 0.0F }));
    localBaseFilter1.addParam(new m.g("highlightsShift", new float[] { 0.07450981F, 0.0F, -0.01568628F }));
    localBaseFilter1.addParam(new m.i("preserveLuminosity", 1));
    setNextFilter(localBaseFilter1, null);
    BaseFilter localBaseFilter2 = new BaseFilter(GLSLRender.beG);
    localBaseFilter2.addParam(new m.o("inputImageTexture2", "sh/jiaopian.png", 33986));
    localBaseFilter2.addParam(new m.g("channelvec", new float[] { 0.0F, 1.0F, 0.0F }));
    localBaseFilter1.setNextFilter(localBaseFilter2, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.filter.a.ai
 * JD-Core Version:    0.7.0.1
 */