package com.tencent.filter.art;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends BaseFilter
{
  int type;
  
  public b(int paramInt)
  {
    super(GLSLRender.btg);
    this.type = paramInt;
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(86292);
    ClearGLSL();
    if (paramBoolean)
    {
      this.glsl_programID = GLSLRender.btg;
      setNextFilter(null, null);
    }
    for (;;)
    {
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
      AppMethodBeat.o(86292);
      return;
      this.glsl_programID = GLSLRender.buH;
      BaseFilter localBaseFilter2 = new BaseFilter(GLSLRender.buG);
      setNextFilter(localBaseFilter2, null);
      BaseFilter localBaseFilter1 = new BaseFilter(GLSLRender.buI);
      localBaseFilter2.setNextFilter(localBaseFilter1, null);
      localBaseFilter2 = new BaseFilter(GLSLRender.buB);
      localBaseFilter2.addParam(new m.f("threshold", 0.0F));
      localBaseFilter1.setNextFilter(localBaseFilter2, null);
      localBaseFilter1 = new BaseFilter(GLSLRender.buL);
      localBaseFilter2.setNextFilter(localBaseFilter1, null);
      localBaseFilter2 = new BaseFilter(GLSLRender.buC);
      localBaseFilter2.addParam(new m.f("inv_2sigma2", 127.00195F));
      localBaseFilter2.addParam(new m.f("inv_sigma_root_2pi", 0.0008F));
      localBaseFilter1.setNextFilter(localBaseFilter2, new int[] { 2 });
      localBaseFilter1 = new BaseFilter(GLSLRender.buF);
      localBaseFilter1.addParam(new m.f("par", 0.15F));
      localBaseFilter2.setNextFilter(localBaseFilter1, new int[] { 4 });
      localBaseFilter2 = new BaseFilter(GLSLRender.buE);
      localBaseFilter2.addParam(new m.f("par", 0.35F));
      localBaseFilter2.addParam(new m.f("par_b", 0.2F));
      localBaseFilter1.setNextFilter(localBaseFilter2, new int[] { 4, 5 });
      localBaseFilter1 = new BaseFilter(GLSLRender.buD);
      localBaseFilter1.addParam(new m.f("inv_2sigma", 12.0F));
      localBaseFilter2.setNextFilter(localBaseFilter1, new int[] { 4 });
      if (this.type == 1)
      {
        localBaseFilter2 = new BaseFilter(GLSLRender.buA);
        localBaseFilter2.addParam(new m.f("inv_2sigma2", 144.5F));
        localBaseFilter2.addParam(new m.f("inv_sigma_root_2pi", 0.02F));
        localBaseFilter1.setNextFilter(localBaseFilter2, new int[] { 5, 4 });
        localBaseFilter1 = new BaseFilter(GLSLRender.buz);
        localBaseFilter1.addParam(new m.f("inv_2sigma2", 144.5F));
        localBaseFilter1.addParam(new m.f("inv_sigma_root_2pi", 0.02F));
        localBaseFilter2.setNextFilter(localBaseFilter1, new int[] { 4 });
        localBaseFilter1.setNextFilter(new BaseFilter(GLSLRender.buJ), new int[] { 8 });
      }
      else if (this.type == 2)
      {
        localBaseFilter2 = new BaseFilter(GLSLRender.buA);
        localBaseFilter2.addParam(new m.f("inv_2sigma2", 144.5F));
        localBaseFilter2.addParam(new m.f("inv_sigma_root_2pi", 0.02F));
        localBaseFilter1.setNextFilter(localBaseFilter2, new int[] { 5, 4 });
        localBaseFilter1 = new BaseFilter(GLSLRender.buz);
        localBaseFilter1.addParam(new m.f("inv_2sigma2", 144.5F));
        localBaseFilter1.addParam(new m.f("inv_sigma_root_2pi", 0.02F));
        localBaseFilter2.setNextFilter(localBaseFilter1, new int[] { 4 });
        localBaseFilter1.setNextFilter(new BaseFilter(GLSLRender.buK), new int[] { 8 });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.filter.art.b
 * JD-Core Version:    0.7.0.1
 */