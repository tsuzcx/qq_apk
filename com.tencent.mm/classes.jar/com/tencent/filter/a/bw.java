package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.o;

public final class bw
  extends BaseFilter
{
  private BaseFilter bgJ;
  
  public bw()
  {
    super(GLSLRender.bcE);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    this.bgJ = new x();
    this.bgJ.addParam(new m.o("inputImageTexture2", "sh/shuilian_lf.png", 33986));
    setNextFilter(this.bgJ, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.filter.a.bw
 * JD-Core Version:    0.7.0.1
 */