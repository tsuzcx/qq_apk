package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.k;
import com.tencent.filter.m.f;
import com.tencent.filter.m.g;
import com.tencent.filter.m.o;

public final class bz
  extends BaseFilter
{
  public bz()
  {
    super(GLSLRender.bcE);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    Object localObject = new k();
    ((k)localObject).a(0.0F, -20.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F);
    setNextFilter((BaseFilter)localObject, null);
    BaseFilter localBaseFilter = new BaseFilter(GLSLRender.bdI);
    localBaseFilter.addParam(new m.g("color2", new float[] { 0.09019608F, 0.0666667F, 0.0666667F, 1.0F }));
    localBaseFilter.addParam(new m.f("transparency", 0.5F));
    ((BaseFilter)localObject).setNextFilter(localBaseFilter, null);
    localObject = new BaseFilter(GLSLRender.bdG);
    ((BaseFilter)localObject).addParam(new m.o("inputImageTexture2", "sh/teamilk_curve2.png", 33986));
    localBaseFilter.setNextFilter((BaseFilter)localObject, null);
    localBaseFilter = new BaseFilter(GLSLRender.bdL);
    localBaseFilter.addParam(new m.g("color2", new float[] { 0.9411765F, 0.9176471F, 0.854902F, 1.0F }));
    localBaseFilter.addParam(new m.f("transparency", 1.0F));
    ((BaseFilter)localObject).setNextFilter(localBaseFilter, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.filter.a.bz
 * JD-Core Version:    0.7.0.1
 */