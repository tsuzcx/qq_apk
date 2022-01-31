package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;

public final class d$a
  extends BaseFilter
{
  int apf;
  int apg;
  boolean bgP;
  public boolean bgQ = true;
  float radius = 0.5F;
  
  public d$a(boolean paramBoolean)
  {
    super(GLSLRender.bcE);
    this.bgP = paramBoolean;
  }
  
  private void pI()
  {
    float f = Math.round(this.radius * 10.0F / 720.0F * this.apf);
    int i;
    if (f >= 1.0F)
    {
      i = (int)Math.floor(Math.sqrt(-2.0D * Math.pow(f, 2.0D) * Math.log(0.00390625D * Math.sqrt(6.283185307179586D * Math.pow(f, 2.0D)))));
      i += i % 2;
    }
    for (;;)
    {
      updateFragmentShader(ae.b(i, f, this.bgP, this.bgP));
      clearGLSLSelf();
      ApplyGLSLFilter();
      this.bgQ = false;
      return;
      i = 0;
    }
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    this.apf = ((int)paramFloat1);
    this.apg = ((int)paramFloat2);
    pI();
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public final void W(float paramFloat)
  {
    this.radius = paramFloat;
    this.bgQ = true;
  }
  
  public final void beforeRender(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.bgQ) || (this.apf != paramInt2) || (this.apg != paramInt3)) {}
    for (boolean bool = true;; bool = false)
    {
      this.bgQ = bool;
      if (this.bgQ)
      {
        this.apf = paramInt2;
        this.apg = paramInt3;
        pI();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.filter.a.d.a
 * JD-Core Version:    0.7.0.1
 */