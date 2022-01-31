package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.f;
import com.tencent.filter.m.g;
import com.tencent.filter.m.i;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bu
  extends BaseFilter
{
  public bu()
  {
    super(GLSLRender.btg);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(86528);
    BaseFilter localBaseFilter2 = new BaseFilter(GLSLRender.buj);
    localBaseFilter2.addParam(new m.o("inputImageTexture2", "sh/wenyifan_curve.png", 33986));
    setNextFilter(localBaseFilter2, null);
    BaseFilter localBaseFilter1 = new BaseFilter(GLSLRender.bvs);
    localBaseFilter1.addParam(new m.g("color2", new float[] { 0.9764706F, 0.2980392F, 0.2980392F, 1.0F }));
    localBaseFilter1.addParam(new m.f("transparency", 0.17F));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    localBaseFilter2 = new BaseFilter(GLSLRender.bum);
    localBaseFilter2.addParam(new m.g("shadowsShift", new float[] { -0.05098039F, 0.0F, 0.0F }));
    localBaseFilter2.addParam(new m.g("midtonesShift", new float[] { 0.0F, 0.0F, 0.0F }));
    localBaseFilter2.addParam(new m.g("highlightsShift", new float[] { -0.04705882F, -0.03921569F, 0.0F }));
    localBaseFilter2.addParam(new m.i("preserveLuminosity", 1));
    localBaseFilter1.setNextFilter(localBaseFilter2, null);
    localBaseFilter1 = new BaseFilter(GLSLRender.buo);
    localBaseFilter1.addParam(new m.g("color2", new float[] { 0.7882353F, 0.9019608F, 0.8862745F, 1.0F }));
    localBaseFilter1.addParam(new m.f("transparency", 1.0F));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    localBaseFilter2 = new BaseFilter(GLSLRender.btt);
    localBaseFilter2.addParam(new m.f("contrast", 1.0F));
    localBaseFilter2.addParam(new m.f("saturation", 1.1F));
    localBaseFilter2.addParam(new m.f("brightness", 1.0F));
    localBaseFilter1.setNextFilter(localBaseFilter2, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
    AppMethodBeat.o(86528);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.filter.a.bu
 * JD-Core Version:    0.7.0.1
 */