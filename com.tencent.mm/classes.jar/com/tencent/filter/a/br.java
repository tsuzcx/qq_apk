package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.f;
import com.tencent.filter.m.g;
import com.tencent.filter.m.i;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class br
  extends BaseFilter
{
  public br()
  {
    super(GLSLRender.btg);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(86525);
    BaseFilter localBaseFilter2 = new BaseFilter(GLSLRender.bvs);
    localBaseFilter2.addParam(new m.g("color2", new float[] { 0.9764706F, 0.8901961F, 0.1098039F, 1.0F }));
    localBaseFilter2.addParam(new m.f("transparency", 0.12F));
    setNextFilter(localBaseFilter2, null);
    BaseFilter localBaseFilter1 = new BaseFilter(GLSLRender.bum);
    localBaseFilter1.addParam(new m.g("shadowsShift", new float[] { 0.0F, 0.0588235F, 0.0F }));
    localBaseFilter1.addParam(new m.g("midtonesShift", new float[] { 0.0F, 0.0F, 0.0F }));
    localBaseFilter1.addParam(new m.g("highlightsShift", new float[] { -0.01568628F, 0.03529412F, 0.0F }));
    localBaseFilter1.addParam(new m.i("preserveLuminosity", 1));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    localBaseFilter2 = new BaseFilter(GLSLRender.buj);
    localBaseFilter2.addParam(new m.o("inputImageTexture2", "sh/qingcong_curve.png", 33986));
    localBaseFilter1.setNextFilter(localBaseFilter2, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
    AppMethodBeat.o(86525);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.filter.a.br
 * JD-Core Version:    0.7.0.1
 */