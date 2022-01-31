package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.k;
import com.tencent.filter.m.f;
import com.tencent.filter.m.o;

public final class ab
  extends BaseFilter
{
  public ab()
  {
    super(GLSLRender.bcE);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    Object localObject = new k();
    ((k)localObject).a(0.0F, -50.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F);
    setNextFilter((BaseFilter)localObject, null);
    BaseFilter localBaseFilter = new BaseFilter(GLSLRender.bdG);
    localBaseFilter.addParam(new m.o("inputImageTexture2", "sh/glarefashion_curve.png", 33986));
    ((BaseFilter)localObject).setNextFilter(localBaseFilter, null);
    localObject = new BaseFilter(GLSLRender.bfj);
    ((BaseFilter)localObject).addParam(new m.o("inputImageTexture2", "sh/glarefashion_screen.png", 33986));
    ((BaseFilter)localObject).addParam(new m.f("transparency", 0.3F));
    localBaseFilter.setNextFilter((BaseFilter)localObject, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.filter.a.ab
 * JD-Core Version:    0.7.0.1
 */