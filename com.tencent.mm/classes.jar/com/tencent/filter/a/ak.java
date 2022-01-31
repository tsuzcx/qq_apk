package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.f;
import com.tencent.filter.m.g;
import com.tencent.filter.m.i;
import com.tencent.filter.m.o;

public final class ak
  extends BaseFilter
{
  public ak()
  {
    super(GLSLRender.bcE);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    BaseFilter localBaseFilter2 = new BaseFilter(GLSLRender.bdH);
    localBaseFilter2.addParam(new m.f("scaleC", -0.549F));
    localBaseFilter2.addParam(new m.f("scaleT", 0.0F));
    setNextFilter(localBaseFilter2, null);
    BaseFilter localBaseFilter1 = new BaseFilter(GLSLRender.bdP);
    localBaseFilter1.addParam(new m.g("color2", new float[] { 0.5921569F, 0.764706F, 0.839216F, 1.0F }));
    localBaseFilter1.addParam(new m.f("transparency", 0.58F));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    localBaseFilter2 = new BaseFilter(GLSLRender.beH);
    localBaseFilter2.addParam(new m.o("inputImageTexture2", "sh/lan_curve1.png", 33986));
    localBaseFilter2.addParam(new m.o("inputImageTexture3", "sh/lan_curve1mask.png", 33987));
    localBaseFilter1.setNextFilter(localBaseFilter2, null);
    localBaseFilter1 = new BaseFilter(GLSLRender.bdG);
    localBaseFilter1.addParam(new m.o("inputImageTexture2", "sh/lan_curve2.png", 33986));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    localBaseFilter2 = new BaseFilter(GLSLRender.bdJ);
    localBaseFilter2.addParam(new m.g("shadowsShift", new float[] { -0.01960784F, 0.0F, 0.01960784F }));
    localBaseFilter2.addParam(new m.g("midtonesShift", new float[] { 0.0F, 0.0F, 0.0F }));
    localBaseFilter2.addParam(new m.g("highlightsShift", new float[] { 0.0F, 0.0F, 0.0F }));
    localBaseFilter2.addParam(new m.i("preserveLuminosity", 1));
    localBaseFilter1.setNextFilter(localBaseFilter2, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.filter.a.ak
 * JD-Core Version:    0.7.0.1
 */