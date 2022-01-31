package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.b;
import com.tencent.filter.k;
import com.tencent.filter.m.g;
import com.tencent.filter.m.o;

public final class cc
  extends BaseFilter
{
  public cc()
  {
    super(GLSLRender.bcE);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    Object localObject = new b(GLSLRender.bcE, 0);
    ((BaseFilter)localObject).setEffectIndex(2);
    ((BaseFilter)localObject).setSrcFilterIndex(this.srcTextureIndex + 1);
    ((BaseFilter)localObject).ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
    setNextFilter((BaseFilter)localObject, null);
    BaseFilter localBaseFilter = ((BaseFilter)localObject).getLastFilter();
    localObject = new BaseFilter(GLSLRender.bdG);
    ((BaseFilter)localObject).addParam(new m.o("inputImageTexture2", "sh/tianmeizipai_curve.png", 33986));
    localBaseFilter.setNextFilter((BaseFilter)localObject, null);
    localBaseFilter = new BaseFilter(GLSLRender.bdJ);
    localBaseFilter.addParam(new m.g("shadowsShift", new float[] { 0.0F, 0.0F, 0.0F }));
    localBaseFilter.addParam(new m.g("midtonesShift", new float[] { 0.0F, 0.0F, 0.0F }));
    localBaseFilter.addParam(new m.g("highlightsShift", new float[] { 0.03137255F, 0.0F, 0.0F }));
    ((BaseFilter)localObject).setNextFilter(localBaseFilter, null);
    localObject = new k();
    ((k)localObject).a(0.0F, 3.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F);
    localBaseFilter.setNextFilter((BaseFilter)localObject, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.filter.a.cc
 * JD-Core Version:    0.7.0.1
 */