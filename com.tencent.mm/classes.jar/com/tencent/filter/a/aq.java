package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.k;
import com.tencent.filter.m.f;
import com.tencent.filter.m.g;
import com.tencent.filter.m.o;

public final class aq
  extends BaseFilter
{
  public aq()
  {
    super(GLSLRender.bcE);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    Object localObject2 = new BaseFilter(GLSLRender.bdP);
    ((BaseFilter)localObject2).addParam(new m.g("color2", new float[] { 0.9333333F, 0.6705883F, 0.8941177F, 1.0F }));
    ((BaseFilter)localObject2).addParam(new m.f("transparency", 0.3F));
    setNextFilter((BaseFilter)localObject2, null);
    Object localObject1 = new BaseFilter(GLSLRender.bfc);
    ((BaseFilter)localObject1).addParam(new m.g("color2", new float[] { 0.8941177F, 0.6352941F, 0.2235294F, 1.0F }));
    ((BaseFilter)localObject1).addParam(new m.f("transparency", 0.1F));
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    localObject2 = new k();
    ((k)localObject2).a(0.0F, 5.0F, 1.0F, 310.0F, 340.0F, 10.0F, 40.0F);
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
    localObject1 = new k();
    ((k)localObject1).a(0.0F, -22.0F, 15.0F, 355.0F, 18.0F, 58.0F, 79.0F);
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    localObject2 = new BaseFilter(GLSLRender.bdJ);
    ((BaseFilter)localObject2).addParam(new m.g("shadowsShift", new float[] { -0.02745098F, -0.05490196F, 0.0F }));
    ((BaseFilter)localObject2).addParam(new m.g("midtonesShift", new float[] { 0.0F, 0.0F, 0.0F }));
    ((BaseFilter)localObject2).addParam(new m.g("highlightsShift", new float[] { 0.0F, -0.04705882F, -0.04705882F }));
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
    localObject1 = new BaseFilter(GLSLRender.bdG);
    ((BaseFilter)localObject1).addParam(new m.o("inputImageTexture2", "sh/maplered_curve.png", 33986));
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.filter.a.aq
 * JD-Core Version:    0.7.0.1
 */