package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.k;
import com.tencent.filter.m.f;
import com.tencent.filter.m.g;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cb
  extends BaseFilter
{
  public cb()
  {
    super(GLSLRender.btg);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(86535);
    Object localObject = new k();
    ((k)localObject).a(0.0F, -19.0F, 8.0F, 354.0F, 20.0F, 52.0F, 77.0F);
    setNextFilter((BaseFilter)localObject, null);
    BaseFilter localBaseFilter = new BaseFilter(GLSLRender.buj);
    localBaseFilter.addParam(new m.o("inputImageTexture2", "sh/richblue_curve.png", 33986));
    ((BaseFilter)localObject).setNextFilter(localBaseFilter, null);
    localObject = new BaseFilter(GLSLRender.bum);
    ((BaseFilter)localObject).addParam(new m.g("shadowsShift", new float[] { -0.172549F, -0.03921569F, 0.1647059F }));
    ((BaseFilter)localObject).addParam(new m.g("midtonesShift", new float[] { 0.02352941F, -0.007843138F, 0.07843138F }));
    ((BaseFilter)localObject).addParam(new m.g("highlightsShift", new float[] { 0.03137255F, 0.0F, 0.0F }));
    localBaseFilter.setNextFilter((BaseFilter)localObject, null);
    localBaseFilter = new BaseFilter(GLSLRender.btt);
    localBaseFilter.addParam(new m.f("contrast", 0.97F));
    localBaseFilter.addParam(new m.f("saturation", 1.0F));
    localBaseFilter.addParam(new m.f("brightness", 1.0F));
    ((BaseFilter)localObject).setNextFilter(localBaseFilter, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
    AppMethodBeat.o(86535);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.filter.a.cb
 * JD-Core Version:    0.7.0.1
 */