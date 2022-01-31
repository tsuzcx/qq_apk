package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.f;

public final class a
  extends BaseFilter
{
  public a()
  {
    super(GLSLRender.bcE);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    if (paramBoolean)
    {
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
      return;
    }
    BaseFilter localBaseFilter = new BaseFilter(GLSLRender.bfB, GLSLRender.beM);
    localBaseFilter.addParam(new m.f("sharpness", 0.2F));
    localBaseFilter.addParam(new m.f("inputH", 1.0F));
    localBaseFilter.addParam(new m.f("inputS", 1.2F));
    localBaseFilter.addParam(new m.f("inputV", 1.0F));
    localBaseFilter.addParam(new m.f("imageWidthFactor", 1.0F / paramFloat1));
    localBaseFilter.addParam(new m.f("imageHeightFactor", 1.0F / paramFloat2));
    setNextFilter(localBaseFilter, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.filter.a.a
 * JD-Core Version:    0.7.0.1
 */