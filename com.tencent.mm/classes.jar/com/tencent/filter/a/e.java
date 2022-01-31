package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.g;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
  extends BaseFilter
{
  public e()
  {
    super(GLSLRender.btg);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(86438);
    BaseFilter localBaseFilter2 = new BaseFilter(GLSLRender.bun);
    localBaseFilter2.addParam(new m.g("channelparam", new float[] { 0.4F, 0.4F, 0.2F }));
    localBaseFilter2.addParam(new m.g("mixparam", new float[] { 1.0F, 1.0F, 1.0F }));
    setNextFilter(localBaseFilter2, null);
    BaseFilter localBaseFilter1 = new BaseFilter(GLSLRender.buj);
    localBaseFilter1.addParam(new m.o("inputImageTexture2", "sh/blackwhite.png", 33986));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    localBaseFilter2 = new BaseFilter(GLSLRender.bvm);
    localBaseFilter2.addParam(new m.o("inputImageTexture2", "sh/blackwhite2levelmask.png", 33986));
    localBaseFilter2.addParam(new m.g("levelMinimum", new float[] { 0.0F, 0.0F, 0.0F }));
    localBaseFilter2.addParam(new m.g("levelMiddle", new float[] { 0.2F, 0.2F, 0.2F }));
    localBaseFilter2.addParam(new m.g("levelMaximum", new float[] { 1.0F, 1.0F, 1.0F }));
    localBaseFilter2.addParam(new m.g("minOutput", new float[] { 0.0F, 0.0F, 0.0F }));
    localBaseFilter2.addParam(new m.g("maxOutput", new float[] { 1.0F, 1.0F, 1.0F }));
    localBaseFilter1.setNextFilter(localBaseFilter2, null);
    localBaseFilter1 = new BaseFilter(GLSLRender.buq);
    localBaseFilter1.addParam(new m.o("inputImageTexture2", "sh/blackwhite2overlay.png", 33986));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
    AppMethodBeat.o(86438);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.filter.a.e
 * JD-Core Version:    0.7.0.1
 */