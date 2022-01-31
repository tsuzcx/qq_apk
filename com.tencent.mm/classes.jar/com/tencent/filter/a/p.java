package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.l;
import com.tencent.filter.m.f;

public final class p
  extends BaseFilter
{
  float aVe = 1.0F;
  
  public p()
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
    Object localObject2 = new BaseFilter(GLSLRender.bcE);
    float f = Math.min(paramFloat2, paramFloat1);
    ((BaseFilter)localObject2).scaleFact = Math.min(200.0F / f, 1.0F);
    setNextFilter((BaseFilter)localObject2, null);
    int i = getTheFilterIndex((BaseFilter)localObject2);
    Object localObject1 = new l();
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, new int[] { i - 1 + (this.srcTextureIndex + 1) });
    localObject2 = new BaseFilter(GLSLRender.bcR);
    ((BaseFilter)localObject2).addParam(new m.f("contrast", 0.96F));
    ((BaseFilter)localObject2).addParam(new m.f("saturation", 0.766F));
    ((BaseFilter)localObject2).addParam(new m.f("brightness", 1.0F));
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
    localObject1 = new BaseFilter(GLSLRender.bdg);
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    localObject2 = new BaseFilter(GLSLRender.bfq, GLSLRender.bdl);
    ((BaseFilter)localObject2).addParam(new m.f("sharpness", 0.377F));
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
    localObject1 = new BaseFilter(GLSLRender.bcE);
    ((BaseFilter)localObject1).scaleFact = Math.min(400.0F / f, 1.0F);
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    i = getTheFilterIndex((BaseFilter)localObject1);
    localObject2 = new k(((BaseFilter)localObject1).scaleFact);
    ((BaseFilter)localObject2).addParam(new m.f("strength", 50.0F));
    ((BaseFilter)localObject2).addParam(new m.f("highlight", 24.4F));
    ((BaseFilter)localObject2).addParam(new m.f("shadow", 26.700001F));
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, new int[] { i - 1 + (this.srcTextureIndex + 1) });
    ((BaseFilter)localObject2).setNextFilter(new BaseFilter(GLSLRender.bdh), null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public final void setAdjustParam(float paramFloat)
  {
    this.aVe = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.filter.a.p
 * JD-Core Version:    0.7.0.1
 */