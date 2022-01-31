package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.k;
import com.tencent.filter.m.f;
import com.tencent.filter.m.g;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bf
  extends BaseFilter
{
  public bf()
  {
    super(GLSLRender.btg);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(86513);
    Object localObject2 = new k();
    ((k)localObject2).a(0.0F, -4.0F, 4.0F, 0.0F, 28.0F, 48.0F, 72.0F);
    setNextFilter((BaseFilter)localObject2, null);
    Object localObject1 = new k();
    ((k)localObject1).a(-5.039946F, 24.0F, 0.0F, 329.0F, 330.0F, 8.0F, 26.0F);
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    localObject2 = new BaseFilter(GLSLRender.buj);
    ((BaseFilter)localObject2).addParam(new m.o("inputImageTexture2", "sh/milkgreen_curve.png", 33986));
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
    localObject1 = new BaseFilter(GLSLRender.bvL);
    ((BaseFilter)localObject1).addParam(new m.g("color2", new float[] { 0.7215686F, 0.8784314F, 0.772549F, 1.0F }));
    ((BaseFilter)localObject1).addParam(new m.f("transparency", 0.1F));
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
    AppMethodBeat.o(86513);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.filter.a.bf
 * JD-Core Version:    0.7.0.1
 */