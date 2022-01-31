package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.k;
import com.tencent.filter.m.f;
import com.tencent.filter.m.g;
import com.tencent.filter.m.o;

public final class aw
  extends BaseFilter
{
  public aw()
  {
    super(GLSLRender.bcE);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    Object localObject2 = new k();
    ((k)localObject2).a(3.0F, 40.0F, 3.0F, 329.0F, 352.0F, 10.0F, 35.0F);
    setNextFilter((BaseFilter)localObject2, null);
    Object localObject1 = new k();
    ((k)localObject1).a(-5.0F, 5.0F, 10.0F, 6.0F, 32.0F, 52.0F, 82.0F);
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    localObject2 = new BaseFilter(GLSLRender.bdG);
    ((BaseFilter)localObject2).addParam(new m.o("inputImageTexture2", "sh/milkcoffee_curve.png", 33986));
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
    localObject1 = new BaseFilter(GLSLRender.bfi);
    ((BaseFilter)localObject1).addParam(new m.g("color2", new float[] { 0.7294118F, 0.5372549F, 0.5058824F, 1.0F }));
    ((BaseFilter)localObject1).addParam(new m.f("transparency", 0.1F));
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    localObject2 = new BaseFilter(GLSLRender.bdJ);
    ((BaseFilter)localObject2).addParam(new m.g("shadowsShift", new float[] { 0.0F, 0.0F, -0.02352941F }));
    ((BaseFilter)localObject2).addParam(new m.g("midtonesShift", new float[] { 0.0F, 0.0F, -0.02352941F }));
    ((BaseFilter)localObject2).addParam(new m.g("highlightsShift", new float[] { -0.007843138F, 0.0F, 0.0F }));
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.filter.a.aw
 * JD-Core Version:    0.7.0.1
 */