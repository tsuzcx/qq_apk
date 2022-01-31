package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.k;
import com.tencent.filter.m.o;

public final class an
  extends BaseFilter
{
  public an()
  {
    super(GLSLRender.bcE);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    Object localObject = new k();
    ((k)localObject).a(4.0F, 9.0F, -2.0F, 309.0F, 334.0F, 6.0F, 32.0F);
    setNextFilter((BaseFilter)localObject, null);
    k localk = new k();
    ((k)localk).a(0.0F, -17.0F, 4.0F, 338.0F, 16.0F, 61.0F, 93.0F);
    ((BaseFilter)localObject).setNextFilter(localk, null);
    localObject = new BaseFilter(GLSLRender.bdG);
    ((BaseFilter)localObject).addParam(new m.o("inputImageTexture2", "sh/lightred_curve.png", 33986));
    localk.setNextFilter((BaseFilter)localObject, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.filter.a.an
 * JD-Core Version:    0.7.0.1
 */