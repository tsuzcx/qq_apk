package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.k;
import com.tencent.filter.m.f;
import com.tencent.filter.m.g;
import com.tencent.filter.m.o;

public final class av
  extends BaseFilter
{
  public av()
  {
    super(GLSLRender.bcE);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    Object localObject2 = new k();
    ((k)localObject2).a(-3.0F, 40.0F, 10.0F, 316.0F, 348.0F, 10.0F, 45.0F);
    setNextFilter((BaseFilter)localObject2, null);
    Object localObject1 = new k();
    ((k)localObject1).a(0.0F, 5.0F, 25.0F, 0.0F, 32.0F, 52.0F, 82.0F);
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    localObject2 = new BaseFilter(GLSLRender.bdG);
    ((BaseFilter)localObject2).addParam(new m.o("inputImageTexture2", "sh/milkblue_curve.png", 33986));
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
    localObject1 = new BaseFilter(GLSLRender.bdP);
    ((BaseFilter)localObject1).addParam(new m.g("color2", new float[] { 0.7294118F, 0.8901961F, 0.9960784F, 1.0F }));
    ((BaseFilter)localObject1).addParam(new m.f("transparency", 0.1F));
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.filter.a.av
 * JD-Core Version:    0.7.0.1
 */