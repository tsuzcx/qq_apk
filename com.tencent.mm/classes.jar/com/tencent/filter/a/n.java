package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.g;
import com.tencent.filter.m.i;
import com.tencent.filter.m.o;

public final class n
  extends BaseFilter
{
  private BaseFilter bgJ = null;
  private int bgY = 0;
  
  public n()
  {
    super(GLSLRender.bcE);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    this.bgJ = new BaseFilter(GLSLRender.beJ);
    this.bgJ.addParam(new m.o("inputImageTexture2", "sh/darkcornermask_s.png", 33986));
    this.bgJ.addParam(new m.o("inputImageTexture3", "sh/darkcornermask_l.png", 33987));
    this.bgJ.addParam(new m.g("levelMinimum", new float[] { 0.0F, 0.0F, 0.0F }));
    this.bgJ.addParam(new m.g("levelMiddle", new float[] { 0.3F, 0.3F, 0.3F }));
    this.bgJ.addParam(new m.g("levelMaximum", new float[] { 1.0F, 1.0F, 1.0F }));
    this.bgJ.addParam(new m.g("minOutput", new float[] { 0.0F, 0.0F, 0.0F }));
    this.bgJ.addParam(new m.g("maxOutput", new float[] { 1.0F, 1.0F, 1.0F }));
    this.bgJ.addParam(new m.i("maskType", this.bgY));
    setNextFilter(this.bgJ, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.filter.a.n
 * JD-Core Version:    0.7.0.1
 */