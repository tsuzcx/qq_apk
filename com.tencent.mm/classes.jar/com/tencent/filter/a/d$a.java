package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d$a
  extends BaseFilter
{
  int arA;
  int arz;
  boolean bxq;
  public boolean bxr = true;
  float radius = 0.5F;
  
  public d$a(boolean paramBoolean)
  {
    super(GLSLRender.btg);
    this.bxq = paramBoolean;
  }
  
  private void tO()
  {
    AppMethodBeat.i(86431);
    float f = Math.round(this.radius * 10.0F / 720.0F * this.arz);
    int i;
    if (f >= 1.0F)
    {
      i = (int)Math.floor(Math.sqrt(-2.0D * Math.pow(f, 2.0D) * Math.log(0.00390625D * Math.sqrt(6.283185307179586D * Math.pow(f, 2.0D)))));
      i += i % 2;
    }
    for (;;)
    {
      updateFragmentShader(aj.b(i, f, this.bxq, this.bxq));
      clearGLSLSelf();
      ApplyGLSLFilter();
      this.bxr = false;
      AppMethodBeat.o(86431);
      return;
      i = 0;
    }
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(86432);
    this.arz = ((int)paramFloat1);
    this.arA = ((int)paramFloat2);
    tO();
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
    AppMethodBeat.o(86432);
  }
  
  public final void W(float paramFloat)
  {
    this.radius = paramFloat;
    this.bxr = true;
  }
  
  public final void beforeRender(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(86433);
    if ((this.bxr) || (this.arz != paramInt2) || (this.arA != paramInt3)) {}
    for (boolean bool = true;; bool = false)
    {
      this.bxr = bool;
      if (this.bxr)
      {
        this.arz = paramInt2;
        this.arA = paramInt3;
        tO();
      }
      AppMethodBeat.o(86433);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.filter.a.d.a
 * JD-Core Version:    0.7.0.1
 */