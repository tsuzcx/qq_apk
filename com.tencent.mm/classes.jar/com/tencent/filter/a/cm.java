package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.g;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cm
  extends BaseFilter
{
  public cm()
  {
    super(GLSLRender.btg);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(86545);
    BaseFilter localBaseFilter2 = new BaseFilter(GLSLRender.bvC);
    localBaseFilter2.addParam(new m.g("levelMinimum", new float[] { 0.0F, 0.0F, 0.0F }));
    localBaseFilter2.addParam(new m.g("levelMiddle", new float[] { 0.04F, 1.0F, 1.0F }));
    localBaseFilter2.addParam(new m.g("levelMaximum", new float[] { 1.0F, 1.0F, 1.0F }));
    localBaseFilter2.addParam(new m.g("minOutput", new float[] { 0.0F, 0.0F, 0.0F }));
    localBaseFilter2.addParam(new m.g("maxOutput", new float[] { 1.0F, 1.0F, 1.0F }));
    setNextFilter(localBaseFilter2, null);
    BaseFilter localBaseFilter1 = new BaseFilter(GLSLRender.bvD);
    localBaseFilter2.setNextFilter(localBaseFilter1, new int[] { this.srcTextureIndex + 1 });
    localBaseFilter2 = new BaseFilter(GLSLRender.bvC);
    localBaseFilter2.addParam(new m.g("levelMinimum", new float[] { 0.0F, 0.0F, 0.0F }));
    localBaseFilter2.addParam(new m.g("levelMiddle", new float[] { 1.0F, 0.02F, 1.0F }));
    localBaseFilter2.addParam(new m.g("levelMaximum", new float[] { 1.0F, 1.0F, 1.0F }));
    localBaseFilter2.addParam(new m.g("minOutput", new float[] { 0.0F, 0.0F, 0.0F }));
    localBaseFilter2.addParam(new m.g("maxOutput", new float[] { 1.0F, 1.0F, 1.0F }));
    localBaseFilter1.setNextFilter(localBaseFilter2, null);
    localBaseFilter1 = new BaseFilter(GLSLRender.bvE);
    localBaseFilter2.setNextFilter(localBaseFilter1, new int[] { this.srcTextureIndex + 2 });
    localBaseFilter2 = new BaseFilter(GLSLRender.buj);
    localBaseFilter2.addParam(new m.o("inputImageTexture2", "sh/3d_curve.png", 33986));
    localBaseFilter1.setNextFilter(localBaseFilter2, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
    AppMethodBeat.o(86545);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.filter.a.cm
 * JD-Core Version:    0.7.0.1
 */