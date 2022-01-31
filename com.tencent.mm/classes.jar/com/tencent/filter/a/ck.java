package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ck
  extends BaseFilter
{
  private BaseFilter bxk;
  
  public ck()
  {
    super(GLSLRender.btg);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(86543);
    this.bxk = new ab();
    this.bxk.addParam(new m.o("inputImageTexture2", "sh/tangguomeigui_lf.png", 33986));
    setNextFilter(this.bxk, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
    AppMethodBeat.o(86543);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.filter.a.ck
 * JD-Core Version:    0.7.0.1
 */