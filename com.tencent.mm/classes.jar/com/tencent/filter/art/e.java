package com.tencent.filter.art;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
  extends BaseFilter
{
  private BaseFilter bxi = null;
  float strenth = 0.5F;
  
  public e()
  {
    super(GLSLRender.btg);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(86308);
    this.glsl_programID = GLSLRender.btg;
    BaseFilter localBaseFilter = new BaseFilter(GLSLRender.btg);
    localBaseFilter.scaleFact = Math.min(100.0F / Math.min(paramFloat2, paramFloat1), 1.0F);
    setNextFilter(localBaseFilter, null);
    this.bxi = new e.a();
    this.bxi.addParam(new m.f("param", this.strenth));
    if (this.strenth >= 0.5F) {
      this.bxi.addParam(new m.f("scale", 2.0F));
    }
    for (;;)
    {
      localBaseFilter.setNextFilter(this.bxi, new int[] { this.srcTextureIndex + 1 });
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
      AppMethodBeat.o(86308);
      return;
      this.bxi.addParam(new m.f("scale", 1.0F));
    }
  }
  
  public final void ClearGLSL()
  {
    AppMethodBeat.i(86309);
    this.bxi = null;
    super.ClearGLSL();
    AppMethodBeat.o(86309);
  }
  
  public final boolean isAdjustFilter()
  {
    return true;
  }
  
  public final void setAdjustParam(float paramFloat)
  {
    AppMethodBeat.i(86307);
    this.strenth = paramFloat;
    if (this.bxi != null) {
      this.bxi.addParam(new m.f("param", this.strenth));
    }
    AppMethodBeat.o(86307);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.filter.art.e
 * JD-Core Version:    0.7.0.1
 */