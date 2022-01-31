package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.k;
import com.tencent.filter.m.g;
import com.tencent.filter.m.o;

public final class br
  extends BaseFilter
{
  public br()
  {
    super(GLSLRender.bcE);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    Object localObject2 = new k();
    ((k)localObject2).a(0.0F, 13.0F, 0.0F, 340.0F, 352.0F, 10.0F, 20.0F);
    setNextFilter((BaseFilter)localObject2, null);
    Object localObject1 = new k();
    ((k)localObject1).a(0.0F, -18.0F, 15.0F, 352.0F, 15.0F, 45.0F, 70.0F);
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    localObject2 = new BaseFilter(GLSLRender.bdG);
    ((BaseFilter)localObject2).addParam(new m.o("inputImageTexture2", "sh/richred_curve.png", 33986));
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
    localObject1 = new BaseFilter(GLSLRender.bdJ);
    ((BaseFilter)localObject1).addParam(new m.g("shadowsShift", new float[] { 0.0F, 0.007843138F, 0.007843138F }));
    ((BaseFilter)localObject1).addParam(new m.g("midtonesShift", new float[] { -0.02352941F, 0.01176471F, 0.04313726F }));
    ((BaseFilter)localObject1).addParam(new m.g("highlightsShift", new float[] { -0.007843138F, 0.0F, 0.0F }));
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.filter.a.br
 * JD-Core Version:    0.7.0.1
 */