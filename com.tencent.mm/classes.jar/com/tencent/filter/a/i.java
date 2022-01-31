package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.g;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
  extends BaseFilter
{
  public i()
  {
    super(GLSLRender.btg);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(86442);
    BaseFilter localBaseFilter1 = new BaseFilter(GLSLRender.bun);
    localBaseFilter1.addParam(new m.g("channelparam", new float[] { 0.4F, 0.4F, 0.2F }));
    localBaseFilter1.addParam(new m.g("mixparam", new float[] { 1.0F, 1.0F, 1.0F }));
    setNextFilter(localBaseFilter1, null);
    BaseFilter localBaseFilter2 = new BaseFilter(GLSLRender.buj);
    localBaseFilter2.addParam(new m.o("inputImageTexture2", "sh/blackwhitezipai_curve.png", 33986));
    localBaseFilter1.setNextFilter(localBaseFilter2, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
    AppMethodBeat.o(86442);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.filter.a.i
 * JD-Core Version:    0.7.0.1
 */