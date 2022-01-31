package com.tencent.filter.art;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.f;

public final class e
  extends BaseFilter
{
  float bgG = 0.5F;
  private BaseFilter bgH = null;
  
  public e()
  {
    super(GLSLRender.bcE);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    this.glsl_programID = GLSLRender.bcE;
    BaseFilter localBaseFilter = new BaseFilter(GLSLRender.bcE);
    localBaseFilter.scaleFact = Math.min(100.0F / Math.min(paramFloat2, paramFloat1), 1.0F);
    setNextFilter(localBaseFilter, null);
    this.bgH = new e.a();
    this.bgH.addParam(new m.f("param", this.bgG));
    if (this.bgG >= 0.5F) {
      this.bgH.addParam(new m.f("scale", 2.0F));
    }
    for (;;)
    {
      localBaseFilter.setNextFilter(this.bgH, new int[] { this.srcTextureIndex + 1 });
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
      return;
      this.bgH.addParam(new m.f("scale", 1.0F));
    }
  }
  
  public final void ClearGLSL()
  {
    this.bgH = null;
    super.ClearGLSL();
  }
  
  public final boolean isAdjustFilter()
  {
    return true;
  }
  
  public final void setAdjustParam(float paramFloat)
  {
    this.bgG = paramFloat;
    if (this.bgH != null) {
      this.bgH.addParam(new m.f("param", this.bgG));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.filter.art.e
 * JD-Core Version:    0.7.0.1
 */