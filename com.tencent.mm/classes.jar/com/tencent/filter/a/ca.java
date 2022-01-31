package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.f;
import com.tencent.filter.m.g;
import com.tencent.filter.m.i;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ca
  extends BaseFilter
{
  public ca()
  {
    super(GLSLRender.btg);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(86534);
    BaseFilter localBaseFilter2 = new BaseFilter(GLSLRender.buj);
    localBaseFilter2.addParam(new m.o("inputImageTexture2", "sh/quanminyingdi_curve.png", 33986));
    setNextFilter(localBaseFilter2, null);
    BaseFilter localBaseFilter1 = new BaseFilter(GLSLRender.bvl);
    localBaseFilter1.addParam(new m.f("inputH", 1.0F));
    localBaseFilter1.addParam(new m.f("inputS", 0.9F));
    localBaseFilter1.addParam(new m.f("inputV", 1.0F));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    localBaseFilter2 = new BaseFilter(GLSLRender.bum);
    localBaseFilter2.addParam(new m.g("shadowsShift", new float[] { -0.01960784F, 0.03921569F, 0.02352941F }));
    localBaseFilter2.addParam(new m.g("midtonesShift", new float[] { 0.0F, 0.0F, 0.0F }));
    localBaseFilter2.addParam(new m.g("highlightsShift", new float[] { 0.0F, 0.0F, 0.0F }));
    localBaseFilter2.addParam(new m.i("preserveLuminosity", 1));
    localBaseFilter1.setNextFilter(localBaseFilter2, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
    AppMethodBeat.o(86534);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.filter.a.ca
 * JD-Core Version:    0.7.0.1
 */