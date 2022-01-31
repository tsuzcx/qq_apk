package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.k;
import com.tencent.filter.m.f;
import com.tencent.filter.m.g;
import com.tencent.filter.m.o;

public final class bq
  extends BaseFilter
{
  public bq()
  {
    super(GLSLRender.bcE);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    Object localObject = new k();
    ((k)localObject).a(0.0F, -19.0F, 8.0F, 354.0F, 20.0F, 52.0F, 77.0F);
    setNextFilter((BaseFilter)localObject, null);
    BaseFilter localBaseFilter = new BaseFilter(GLSLRender.bdG);
    localBaseFilter.addParam(new m.o("inputImageTexture2", "sh/richblue_curve.png", 33986));
    ((BaseFilter)localObject).setNextFilter(localBaseFilter, null);
    localObject = new BaseFilter(GLSLRender.bdJ);
    ((BaseFilter)localObject).addParam(new m.g("shadowsShift", new float[] { -0.172549F, -0.03921569F, 0.1647059F }));
    ((BaseFilter)localObject).addParam(new m.g("midtonesShift", new float[] { 0.02352941F, -0.007843138F, 0.07843138F }));
    ((BaseFilter)localObject).addParam(new m.g("highlightsShift", new float[] { 0.03137255F, 0.0F, 0.0F }));
    localBaseFilter.setNextFilter((BaseFilter)localObject, null);
    localBaseFilter = new BaseFilter(GLSLRender.bcR);
    localBaseFilter.addParam(new m.f("contrast", 0.97F));
    localBaseFilter.addParam(new m.f("saturation", 1.0F));
    localBaseFilter.addParam(new m.f("brightness", 1.0F));
    ((BaseFilter)localObject).setNextFilter(localBaseFilter, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.filter.a.bq
 * JD-Core Version:    0.7.0.1
 */