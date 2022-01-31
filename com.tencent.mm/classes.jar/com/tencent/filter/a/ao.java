package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.k;
import com.tencent.filter.m.f;
import com.tencent.filter.m.o;

public final class ao
  extends BaseFilter
{
  public ao()
  {
    super(GLSLRender.bcE);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    Object localObject2 = new k();
    ((k)localObject2).a(0.0F, 10.0F, 0.0F, 329.0F, 349.0F, 13.0F, 32.0F);
    setNextFilter((BaseFilter)localObject2, null);
    Object localObject1 = new k();
    ((k)localObject1).a(0.0F, -10.0F, -4.0F, 2.0F, 18.0F, 49.0F, 72.0F);
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    localObject2 = new BaseFilter(GLSLRender.bdG);
    ((BaseFilter)localObject2).addParam(new m.o("inputImageTexture2", "sh/lightwhite_curve.png", 33986));
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
    localObject1 = new BaseFilter(GLSLRender.bcR);
    ((BaseFilter)localObject1).addParam(new m.f("contrast", 1.05F));
    ((BaseFilter)localObject1).addParam(new m.f("saturation", 1.0F));
    ((BaseFilter)localObject1).addParam(new m.f("brightness", 1.0F));
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.filter.a.ao
 * JD-Core Version:    0.7.0.1
 */