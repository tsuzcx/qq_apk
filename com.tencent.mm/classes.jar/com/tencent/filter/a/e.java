package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.g;
import com.tencent.filter.m.o;

public final class e
  extends BaseFilter
{
  public e()
  {
    super(GLSLRender.bcE);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    BaseFilter localBaseFilter2 = new BaseFilter(GLSLRender.bdK);
    localBaseFilter2.addParam(new m.g("channelparam", new float[] { 0.4F, 0.4F, 0.2F }));
    localBaseFilter2.addParam(new m.g("mixparam", new float[] { 1.0F, 1.0F, 1.0F }));
    setNextFilter(localBaseFilter2, null);
    BaseFilter localBaseFilter1 = new BaseFilter(GLSLRender.bdG);
    localBaseFilter1.addParam(new m.o("inputImageTexture2", "sh/blackwhite.png", 33986));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    localBaseFilter2 = new BaseFilter(GLSLRender.beJ);
    localBaseFilter2.addParam(new m.o("inputImageTexture2", "sh/blackwhite2levelmask.png", 33986));
    localBaseFilter2.addParam(new m.g("levelMinimum", new float[] { 0.0F, 0.0F, 0.0F }));
    localBaseFilter2.addParam(new m.g("levelMiddle", new float[] { 0.2F, 0.2F, 0.2F }));
    localBaseFilter2.addParam(new m.g("levelMaximum", new float[] { 1.0F, 1.0F, 1.0F }));
    localBaseFilter2.addParam(new m.g("minOutput", new float[] { 0.0F, 0.0F, 0.0F }));
    localBaseFilter2.addParam(new m.g("maxOutput", new float[] { 1.0F, 1.0F, 1.0F }));
    localBaseFilter1.setNextFilter(localBaseFilter2, null);
    localBaseFilter1 = new BaseFilter(GLSLRender.bdN);
    localBaseFilter1.addParam(new m.o("inputImageTexture2", "sh/blackwhite2overlay.png", 33986));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.filter.a.e
 * JD-Core Version:    0.7.0.1
 */