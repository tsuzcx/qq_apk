package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;

public final class ah
  extends BaseFilter
{
  public float p = 1.0F;
  
  public ah()
  {
    super(GLSLRender.bcE);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    int i = getTheFilterIndex(this);
    BaseFilter localBaseFilter = new BaseFilter(GLSLRender.bcE);
    localBaseFilter.scaleFact = Math.min(100.0F / Math.min(paramFloat2, paramFloat1), 1.0F);
    setNextFilter(localBaseFilter, null);
    localBaseFilter.setNextFilter(new af(this.p), new int[] { i + (this.srcTextureIndex + 1) });
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.filter.a.ah
 * JD-Core Version:    0.7.0.1
 */