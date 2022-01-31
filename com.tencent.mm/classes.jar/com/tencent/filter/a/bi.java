package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.f;
import com.tencent.filter.m.g;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bi
  extends BaseFilter
{
  public bi()
  {
    super(GLSLRender.btg);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(86516);
    BaseFilter localBaseFilter2 = new BaseFilter(GLSLRender.btt);
    localBaseFilter2.addParam(new m.f("contrast", 1.0F));
    localBaseFilter2.addParam(new m.f("saturation", 0.5F));
    localBaseFilter2.addParam(new m.f("brightness", 1.0F));
    setNextFilter(localBaseFilter2, null);
    BaseFilter localBaseFilter1 = new BaseFilter(GLSLRender.buj);
    localBaseFilter1.addParam(new m.o("inputImageTexture2", "sh/heibai4_Curve.png", 33986));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    localBaseFilter2 = new BaseFilter(GLSLRender.buo);
    localBaseFilter2.addParam(new m.g("color2", new float[] { 0.8470588F, 0.8F, 0.7450981F, 1.0F }));
    localBaseFilter2.addParam(new m.f("transparency", 1.0F));
    localBaseFilter1.setNextFilter(localBaseFilter2, null);
    localBaseFilter1 = new BaseFilter(GLSLRender.bul);
    localBaseFilter1.addParam(new m.g("color2", new float[] { 0.09019608F, 0.0666667F, 0.0666667F, 1.0F }));
    localBaseFilter1.addParam(new m.f("transparency", 1.0F));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    localBaseFilter2 = new BaseFilter(GLSLRender.bvu);
    localBaseFilter2.addParam(new m.o("inputImageTexture2", "sh/heibai4_blend.png", 33986));
    localBaseFilter2.addParam(new m.f("transparency", 0.8F));
    localBaseFilter1.setNextFilter(localBaseFilter2, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
    AppMethodBeat.o(86516);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.filter.a.bi
 * JD-Core Version:    0.7.0.1
 */