package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.l;
import com.tencent.filter.m.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class r
  extends BaseFilter
{
  float param = 1.0F;
  
  public r()
  {
    super(GLSLRender.btg);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(86458);
    if (paramBoolean)
    {
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
      AppMethodBeat.o(86458);
      return;
    }
    Object localObject2 = new BaseFilter(GLSLRender.btg);
    float f = Math.min(paramFloat2, paramFloat1);
    ((BaseFilter)localObject2).scaleFact = Math.min(200.0F / f, 1.0F);
    setNextFilter((BaseFilter)localObject2, null);
    int i = getTheFilterIndex((BaseFilter)localObject2);
    Object localObject1 = new l();
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, new int[] { i - 1 + (this.srcTextureIndex + 1) });
    localObject2 = new BaseFilter(GLSLRender.btt);
    ((BaseFilter)localObject2).addParam(new m.f("contrast", 0.96F));
    ((BaseFilter)localObject2).addParam(new m.f("saturation", 0.766F));
    ((BaseFilter)localObject2).addParam(new m.f("brightness", 1.0F));
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
    localObject1 = new BaseFilter(GLSLRender.btI);
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    localObject2 = new BaseFilter(GLSLRender.bvT, GLSLRender.btN);
    ((BaseFilter)localObject2).addParam(new m.f("sharpness", 0.377F));
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
    localObject1 = new BaseFilter(GLSLRender.btg);
    ((BaseFilter)localObject1).scaleFact = Math.min(400.0F / f, 1.0F);
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    i = getTheFilterIndex((BaseFilter)localObject1);
    localObject2 = new k(((BaseFilter)localObject1).scaleFact);
    ((BaseFilter)localObject2).addParam(new m.f("strength", 50.0F));
    ((BaseFilter)localObject2).addParam(new m.f("highlight", 24.4F));
    ((BaseFilter)localObject2).addParam(new m.f("shadow", 26.700001F));
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, new int[] { i - 1 + (this.srcTextureIndex + 1) });
    ((BaseFilter)localObject2).setNextFilter(new BaseFilter(GLSLRender.btJ), null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
    AppMethodBeat.o(86458);
  }
  
  public final void setAdjustParam(float paramFloat)
  {
    this.param = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.filter.a.r
 * JD-Core Version:    0.7.0.1
 */