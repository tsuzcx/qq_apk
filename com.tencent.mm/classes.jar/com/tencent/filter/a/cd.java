package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.k;
import com.tencent.filter.m.g;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cd
  extends BaseFilter
{
  public cd()
  {
    super(GLSLRender.btg);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(86537);
    Object localObject2 = new k();
    ((k)localObject2).a(7.0F, 16.0F, 9.0F, 332.0F, 347.0F, 11.0F, 29.0F);
    setNextFilter((BaseFilter)localObject2, null);
    Object localObject1 = new k();
    ((k)localObject1).a(0.0F, -6.0F, 5.0F, 359.0F, 17.0F, 49.0F, 72.0F);
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    localObject2 = new BaseFilter(GLSLRender.buj);
    ((BaseFilter)localObject2).addParam(new m.o("inputImageTexture2", "sh/richyellow_curve.png", 33986));
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
    localObject1 = new BaseFilter(GLSLRender.bum);
    ((BaseFilter)localObject1).addParam(new m.g("shadowsShift", new float[] { 0.01176471F, 0.0F, -0.01176471F }));
    ((BaseFilter)localObject1).addParam(new m.g("midtonesShift", new float[] { -0.02745098F, 0.0F, 0.02745098F }));
    ((BaseFilter)localObject1).addParam(new m.g("highlightsShift", new float[] { 0.02352941F, 0.01176471F, -0.02745098F }));
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
    AppMethodBeat.o(86537);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.filter.a.cd
 * JD-Core Version:    0.7.0.1
 */