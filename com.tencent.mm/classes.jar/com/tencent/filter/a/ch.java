package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.o;

public final class ch
  extends BaseFilter
{
  public ch()
  {
    super(GLSLRender.bcE);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    x localx = new x();
    localx.addParam(new m.o("inputImageTexture2", "sh/rixi2_lf.png", 33986));
    setNextFilter(localx, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.filter.a.ch
 * JD-Core Version:    0.7.0.1
 */