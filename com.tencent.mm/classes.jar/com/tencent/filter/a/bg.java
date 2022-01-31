package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.f;
import com.tencent.filter.m.g;
import com.tencent.filter.m.i;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bg
  extends BaseFilter
{
  public bg()
  {
    super(GLSLRender.btg);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(86514);
    BaseFilter localBaseFilter2 = new BaseFilter(GLSLRender.bum);
    localBaseFilter2.addParam(new m.g("shadowsShift", new float[] { -0.05381961F, 0.02061177F, 0.0F }));
    localBaseFilter2.addParam(new m.g("midtonesShift", new float[] { -0.07059216F, 0.02703529F, 0.01960784F }));
    localBaseFilter2.addParam(new m.g("highlightsShift", new float[] { 0.0627451F, -0.09411765F, 0.0F }));
    localBaseFilter2.addParam(new m.i("preserveLuminosity", 1));
    setNextFilter(localBaseFilter2, null);
    BaseFilter localBaseFilter1 = new BaseFilter(GLSLRender.bup);
    localBaseFilter1.addParam(new m.f("inputH", 1.0F));
    localBaseFilter1.addParam(new m.f("inputS", 1.0F));
    localBaseFilter1.addParam(new m.f("inputV", 1.146F));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    localBaseFilter2 = new BaseFilter(GLSLRender.buj);
    localBaseFilter2.addParam(new m.o("inputImageTexture2", "sh/molv_curve1.png", 33986));
    localBaseFilter1.setNextFilter(localBaseFilter2, null);
    localBaseFilter1 = new BaseFilter(GLSLRender.bvk);
    localBaseFilter1.addParam(new m.o("inputImageTexture2", "sh/molv_curve2.png", 33986));
    localBaseFilter1.addParam(new m.o("inputImageTexture3", "sh/molv_curve2mask.png", 33987));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
    AppMethodBeat.o(86514);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.filter.a.bg
 * JD-Core Version:    0.7.0.1
 */