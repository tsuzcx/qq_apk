package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.f;
import com.tencent.filter.m.g;
import com.tencent.filter.m.o;

public final class ag
  extends BaseFilter
{
  public ag()
  {
    super(GLSLRender.bcE);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    BaseFilter localBaseFilter2 = new BaseFilter(GLSLRender.bdK);
    localBaseFilter2.addParam(new m.g("channelparam", new float[] { 0.4F, 0.4F, 0.2F }));
    localBaseFilter2.addParam(new m.g("mixparam", new float[] { 1.0F, 1.0F, 1.0F }));
    setNextFilter(localBaseFilter2, null);
    BaseFilter localBaseFilter1 = new BaseFilter(GLSLRender.bdL);
    localBaseFilter1.addParam(new m.g("color2", new float[] { 0.9647059F, 0.9647059F, 0.882353F, 1.0F }));
    localBaseFilter1.addParam(new m.f("transparency", 1.0F));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    localBaseFilter2 = new BaseFilter(GLSLRender.bdI);
    localBaseFilter2.addParam(new m.g("color2", new float[] { 0.1019608F, 0.07058824F, 0.0627451F, 1.0F }));
    localBaseFilter2.addParam(new m.f("transparency", 1.0F));
    localBaseFilter1.setNextFilter(localBaseFilter2, null);
    localBaseFilter1 = new BaseFilter(GLSLRender.bdG);
    localBaseFilter1.addParam(new m.o("inputImageTexture2", "sh/huaijiu.png", 33986));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.filter.a.ag
 * JD-Core Version:    0.7.0.1
 */