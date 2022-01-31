package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.k;
import com.tencent.filter.m.g;
import com.tencent.filter.m.i;
import com.tencent.filter.m.o;

public final class cb
  extends BaseFilter
{
  public cb()
  {
    super(GLSLRender.bcE);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    Object localObject2 = new k();
    ((k)localObject2).a(0.0F, 27.0F, 0.0F, 316.0F, 340.0F, 0.0F, 24.0F);
    setNextFilter((BaseFilter)localObject2, null);
    Object localObject1 = new k();
    ((k)localObject1).a(-5.0F, 20.0F, 5.0F, 358.0F, 28.0F, 46.0F, 74.0F);
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    localObject2 = new k();
    ((k)localObject2).a(20.0F, 0.0F, 0.0F, 68.0F, 90.0F, 124.0F, 140.0F);
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
    localObject1 = new BaseFilter(GLSLRender.bdJ);
    ((BaseFilter)localObject1).addParam(new m.g("shadowsShift", new float[] { 0.0588235F, 0.03921569F, 0.0F }));
    ((BaseFilter)localObject1).addParam(new m.g("midtonesShift", new float[] { 0.0F, 0.03921569F, 0.0F }));
    ((BaseFilter)localObject1).addParam(new m.g("highlightsShift", new float[] { -0.01960784F, 0.03921569F, 0.01960784F }));
    ((BaseFilter)localObject1).addParam(new m.i("preserveLuminosity", 1));
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    localObject2 = new BaseFilter(GLSLRender.bdG);
    ((BaseFilter)localObject2).addParam(new m.o("inputImageTexture2", "sh/thursday_curve.png", 33986));
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.filter.a.cb
 * JD-Core Version:    0.7.0.1
 */