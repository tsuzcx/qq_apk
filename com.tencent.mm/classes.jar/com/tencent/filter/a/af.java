package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.k;
import com.tencent.filter.m.f;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class af
  extends BaseFilter
{
  public af()
  {
    super(GLSLRender.btg);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(86483);
    Object localObject = new k();
    ((k)localObject).a(0.0F, -10.0F, 25.0F, 339.0F, 9.0F, 39.0F, 69.0F);
    setNextFilter((BaseFilter)localObject, null);
    BaseFilter localBaseFilter = new BaseFilter(GLSLRender.buj);
    localBaseFilter.addParam(new m.o("inputImageTexture2", "sh/andy_gradient_curve.png", 33986));
    ((BaseFilter)localObject).setNextFilter(localBaseFilter, null);
    localObject = new BaseFilter(GLSLRender.buj);
    ((BaseFilter)localObject).addParam(new m.o("inputImageTexture2", "sh/andy_curve.png", 33986));
    localBaseFilter.setNextFilter((BaseFilter)localObject, null);
    localBaseFilter = new BaseFilter(GLSLRender.but);
    localBaseFilter.addParam(new m.f("exposure", 0.305F));
    ((BaseFilter)localObject).setNextFilter(localBaseFilter, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
    AppMethodBeat.o(86483);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.filter.a.af
 * JD-Core Version:    0.7.0.1
 */