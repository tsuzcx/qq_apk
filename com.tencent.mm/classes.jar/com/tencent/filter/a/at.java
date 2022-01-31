package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.f;
import com.tencent.filter.m.g;
import com.tencent.filter.m.i;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class at
  extends BaseFilter
{
  public at()
  {
    super(GLSLRender.btg);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(86501);
    BaseFilter localBaseFilter2 = new BaseFilter(GLSLRender.buj);
    localBaseFilter2.addParam(new m.o("inputImageTexture2", "sh/lantuise.png", 33986));
    setNextFilter(localBaseFilter2, null);
    BaseFilter localBaseFilter1 = new BaseFilter(GLSLRender.bvl);
    localBaseFilter1.addParam(new m.f("inputH", 1.0F));
    localBaseFilter1.addParam(new m.f("inputS", 1.0F));
    localBaseFilter1.addParam(new m.f("inputV", 1.0914F));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    localBaseFilter2 = new BaseFilter(GLSLRender.bum);
    localBaseFilter2.addParam(new m.g("shadowsShift", new float[] { 0.0F, 0.0F, 0.06494118F }));
    localBaseFilter2.addParam(new m.g("midtonesShift", new float[] { 0.0F, 0.0F, 0.0F }));
    localBaseFilter2.addParam(new m.g("highlightsShift", new float[] { -0.1515294F, 0.0F, 0.08293334F }));
    localBaseFilter2.addParam(new m.i("preserveLuminosity", 1));
    localBaseFilter1.setNextFilter(localBaseFilter2, null);
    localBaseFilter1 = new BaseFilter(GLSLRender.buk);
    localBaseFilter1.addParam(new m.f("scaleC", -0.144F));
    localBaseFilter1.addParam(new m.f("scaleT", 0.0F));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    localBaseFilter2 = new BaseFilter(GLSLRender.bul);
    localBaseFilter2.addParam(new m.g("color2", new float[] { 0.5490196F, 0.654902F, 0.6980392F, 1.0F }));
    localBaseFilter2.addParam(new m.f("transparency", 0.15F));
    localBaseFilter1.setNextFilter(localBaseFilter2, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
    AppMethodBeat.o(86501);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.filter.a.at
 * JD-Core Version:    0.7.0.1
 */