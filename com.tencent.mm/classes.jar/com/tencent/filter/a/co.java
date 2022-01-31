package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.k;
import com.tencent.filter.m.f;
import com.tencent.filter.m.g;
import com.tencent.filter.m.o;

public final class co
  extends BaseFilter
{
  public co()
  {
    super(GLSLRender.bcE);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    Object localObject2 = new BaseFilter(GLSLRender.bdG);
    ((BaseFilter)localObject2).addParam(new m.o("inputImageTexture2", "sh/young_curve.png", 33986));
    setNextFilter((BaseFilter)localObject2, null);
    Object localObject1 = new BaseFilter(GLSLRender.bdJ);
    ((BaseFilter)localObject1).addParam(new m.g("shadowsShift", new float[] { 0.07058824F, 0.0F, 0.0F }));
    ((BaseFilter)localObject1).addParam(new m.g("midtonesShift", new float[] { 0.1176471F, -0.02352941F, 0.05098039F }));
    ((BaseFilter)localObject1).addParam(new m.g("highlightsShift", new float[] { -0.003921569F, 0.0F, 0.01960784F }));
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    localObject2 = new k();
    ((k)localObject2).a(0.0F, 10.0F, 22.0F, 335.0F, 5.0F, 35.0F, 65.0F);
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
    localObject1 = new k();
    ((k)localObject1).a(-6.0F, 2.0F, 10.0F, -1.0F, 0.0F, 0.0F, 0.0F);
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    localObject2 = new BaseFilter(GLSLRender.bcR);
    ((BaseFilter)localObject2).addParam(new m.f("contrast", 1.05F));
    ((BaseFilter)localObject2).addParam(new m.f("saturation", 1.0F));
    ((BaseFilter)localObject2).addParam(new m.f("brightness", 1.0F));
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.filter.a.co
 * JD-Core Version:    0.7.0.1
 */