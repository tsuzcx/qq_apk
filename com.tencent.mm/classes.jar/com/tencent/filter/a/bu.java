package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.f;
import com.tencent.filter.m.g;
import com.tencent.filter.m.i;
import com.tencent.filter.m.o;

public final class bu
  extends BaseFilter
{
  public bu()
  {
    super(GLSLRender.bcE);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    BaseFilter localBaseFilter2 = new BaseFilter(GLSLRender.bdG);
    localBaseFilter2.addParam(new m.o("inputImageTexture2", "sh/senlin_curve.png", 33986));
    setNextFilter(localBaseFilter2, null);
    BaseFilter localBaseFilter1 = new BaseFilter(GLSLRender.bdJ);
    localBaseFilter1.addParam(new m.g("shadowsShift", new float[] { -0.2862745F, 0.0F, 0.0F }));
    localBaseFilter1.addParam(new m.g("midtonesShift", new float[] { 0.0F, 0.0F, 0.0F }));
    localBaseFilter1.addParam(new m.g("highlightsShift", new float[] { 0.04705882F, 0.0F, 0.0F }));
    localBaseFilter1.addParam(new m.i("preserveLuminosity", 1));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    localBaseFilter2 = new BaseFilter(GLSLRender.beR);
    localBaseFilter2.addParam(new m.o("inputImageTexture2", "sh/senlin_blend.png", 33986));
    localBaseFilter2.addParam(new m.f("transparency", 0.8F));
    localBaseFilter1.setNextFilter(localBaseFilter2, null);
    localBaseFilter1 = new BaseFilter(GLSLRender.beQ);
    localBaseFilter1.addParam(new m.g("color2", new float[] { 0.01176471F, 0.3215686F, 0.3098039F, 1.0F }));
    localBaseFilter1.addParam(new m.f("transparency", 1.0F));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.filter.a.bu
 * JD-Core Version:    0.7.0.1
 */