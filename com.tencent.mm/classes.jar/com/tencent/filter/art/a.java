package com.tencent.filter.art;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.f;
import com.tencent.filter.m.o;
import java.util.Map;

public final class a
  extends BaseFilter
{
  int bgb;
  String bgc = null;
  float bgd;
  float bge;
  float bgf;
  float bgg;
  float intensity;
  
  public a(int paramInt)
  {
    super(paramInt);
    this.bgb = paramInt;
    this.bgd = 0.3F;
    this.intensity = 0.5F;
    this.bge = 0.0F;
    this.bgf = 0.12F;
    this.bgg = 0.02F;
    if ((this.bgc != null) || (this.bgb != GLSLRender.bcE))
    {
      addParam(new m.o("inputImageTexture2", this.bgc, 33986));
      addParam(new m.f("inputH", 0.0F));
      addParam(new m.f("inputS", 0.12F));
      addParam(new m.f("inputV", 0.02F));
    }
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    if (IsFilterInvalute())
    {
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
      return;
    }
    if (paramBoolean) {
      if ((this.bgc != null) || (this.bgb != GLSLRender.bcE))
      {
        this.glsl_programID = this.bgb;
        addParam(new m.o("inputImageTexture2", this.bgc, 33986));
        addParam(new m.f("inputH", this.bge));
        addParam(new m.f("inputS", this.bgf));
        addParam(new m.f("inputV", this.bgg));
      }
    }
    for (;;)
    {
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
      return;
      this.glsl_programID = GLSLRender.bcE;
      BaseFilter localBaseFilter2 = new BaseFilter(GLSLRender.bdU);
      localBaseFilter2.addParam(new m.f("blurSize", this.bgd));
      setNextFilter(localBaseFilter2, null);
      BaseFilter localBaseFilter1 = new BaseFilter(GLSLRender.bdV);
      localBaseFilter1.addParam(new m.f("blurSize", this.bgd));
      localBaseFilter1.addParam(new m.f("intensity", this.intensity * 3.5F));
      localBaseFilter2.setNextFilter(localBaseFilter1, new int[] { this.srcTextureIndex + 1 });
      if ((this.bgc != null) || (this.bgb != GLSLRender.bcE))
      {
        localBaseFilter2 = new BaseFilter(this.bgb);
        localBaseFilter2.addParam(new m.o("inputImageTexture2", this.bgc, 33986));
        localBaseFilter2.addParam(new m.f("inputH", this.bge));
        localBaseFilter2.addParam(new m.f("inputS", this.bgf));
        localBaseFilter2.addParam(new m.f("inputV", this.bgg));
        localBaseFilter1.setNextFilter(localBaseFilter2, null);
      }
    }
  }
  
  public final void setParameterDic(Map<String, Object> paramMap)
  {
    if (paramMap.containsKey("intensity")) {
      this.intensity = ((Float)paramMap.get("intensity")).floatValue();
    }
    if ((getmNextFilter() != null) && (getmNextFilter().getmNextFilter() != null)) {
      getmNextFilter().getmNextFilter().addParam(new m.f("intensity", this.intensity * 3.5F));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.filter.art.a
 * JD-Core Version:    0.7.0.1
 */