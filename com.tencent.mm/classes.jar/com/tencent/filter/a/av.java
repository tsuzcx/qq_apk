package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.k;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class av
  extends BaseFilter
{
  public av()
  {
    super(GLSLRender.btg);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(86503);
    Object localObject = new k();
    ((k)localObject).a(4.0F, 9.0F, -2.0F, 309.0F, 334.0F, 6.0F, 32.0F);
    setNextFilter((BaseFilter)localObject, null);
    k localk = new k();
    ((k)localk).a(0.0F, -17.0F, 4.0F, 338.0F, 16.0F, 61.0F, 93.0F);
    ((BaseFilter)localObject).setNextFilter(localk, null);
    localObject = new BaseFilter(GLSLRender.buj);
    ((BaseFilter)localObject).addParam(new m.o("inputImageTexture2", "sh/lightred_curve.png", 33986));
    localk.setNextFilter((BaseFilter)localObject, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
    AppMethodBeat.o(86503);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.filter.a.av
 * JD-Core Version:    0.7.0.1
 */