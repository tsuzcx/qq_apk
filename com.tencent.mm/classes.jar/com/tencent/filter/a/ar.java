package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.k;
import com.tencent.filter.m.g;
import com.tencent.filter.m.o;

public final class ar
  extends BaseFilter
{
  public ar()
  {
    super(GLSLRender.bcE);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    Object localObject2 = new BaseFilter(GLSLRender.bdG);
    ((BaseFilter)localObject2).addParam(new m.o("inputImageTexture2", "sh/medsea_curve.png", 33986));
    setNextFilter((BaseFilter)localObject2, null);
    Object localObject1 = new k();
    ((k)localObject1).a(-3.0F, 21.0F, 6.0F, 299.0F, 329.0F, 359.0F, 29.0F);
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    localObject2 = new k();
    ((k)localObject2).a(-6.0F, 1.0F, 8.0F, -1.0F, 0.0F, 0.0F, 0.0F);
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
    localObject1 = new BaseFilter(GLSLRender.bdJ);
    ((BaseFilter)localObject1).addParam(new m.g("shadowsShift", new float[] { 0.09803922F, 0.09019608F, 0.0666667F }));
    ((BaseFilter)localObject1).addParam(new m.g("midtonesShift", new float[] { 0.07058824F, 0.0F, 0.0F }));
    ((BaseFilter)localObject1).addParam(new m.g("highlightsShift", new float[] { 0.0F, 0.0F, 0.0F }));
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.filter.a.ar
 * JD-Core Version:    0.7.0.1
 */