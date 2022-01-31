package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.k;
import com.tencent.filter.m.f;
import com.tencent.filter.m.g;
import com.tencent.filter.m.o;

public final class ap
  extends BaseFilter
{
  public ap()
  {
    super(GLSLRender.bcE);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    Object localObject2 = new BaseFilter(GLSLRender.bdL);
    ((BaseFilter)localObject2).addParam(new m.g("color2", new float[] { 0.388235F, 0.9490196F, 0.9960784F, 1.0F }));
    ((BaseFilter)localObject2).addParam(new m.f("transparency", 0.18F));
    setNextFilter((BaseFilter)localObject2, null);
    Object localObject1 = new BaseFilter(GLSLRender.bdJ);
    ((BaseFilter)localObject1).addParam(new m.g("shadowsShift", new float[] { -0.03921569F, -0.04705882F, 0.03137255F }));
    ((BaseFilter)localObject1).addParam(new m.g("midtonesShift", new float[] { -0.0627451F, -0.007843138F, 0.03137255F }));
    ((BaseFilter)localObject1).addParam(new m.g("highlightsShift", new float[] { 0.0F, -0.03921569F, 0.03137255F }));
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    localObject2 = new BaseFilter(GLSLRender.bdG);
    ((BaseFilter)localObject2).addParam(new m.o("inputImageTexture2", "sh/lolly_curve.png", 33986));
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
    localObject1 = new k();
    ((k)localObject1).a(7.0F, 30.0F, 0.0F, 306.0F, 336.0F, 6.0F, 36.0F);
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    localObject2 = new k();
    ((k)localObject2).a(-14.0F, 24.0F, 0.0F, 169.0F, 180.0F, 229.0F, 259.0F);
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
    localObject1 = new k();
    ((k)localObject1).a(0.0F, 30.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F);
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.filter.a.ap
 * JD-Core Version:    0.7.0.1
 */