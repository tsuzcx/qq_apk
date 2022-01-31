package com.tencent.filter.art;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.f;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class a
  extends BaseFilter
{
  int bwD;
  String bwE;
  float bwF;
  float bwG;
  float bwH;
  float bwI;
  float intensity;
  
  public a(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(86282);
    this.bwE = null;
    this.bwE = null;
    this.bwD = paramInt;
    this.bwF = 0.3F;
    this.intensity = 0.5F;
    this.bwG = 0.0F;
    this.bwH = 0.12F;
    this.bwI = 0.02F;
    if ((this.bwE != null) || (this.bwD != GLSLRender.btg))
    {
      addParam(new m.o("inputImageTexture2", this.bwE, 33986));
      addParam(new m.f("inputH", 0.0F));
      addParam(new m.f("inputS", 0.12F));
      addParam(new m.f("inputV", 0.02F));
    }
    AppMethodBeat.o(86282);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(86283);
    if (IsFilterInvalute())
    {
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
      AppMethodBeat.o(86283);
      return;
    }
    if (paramBoolean) {
      if ((this.bwE != null) || (this.bwD != GLSLRender.btg))
      {
        this.glsl_programID = this.bwD;
        addParam(new m.o("inputImageTexture2", this.bwE, 33986));
        addParam(new m.f("inputH", this.bwG));
        addParam(new m.f("inputS", this.bwH));
        addParam(new m.f("inputV", this.bwI));
      }
    }
    for (;;)
    {
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
      AppMethodBeat.o(86283);
      return;
      this.glsl_programID = GLSLRender.btg;
      BaseFilter localBaseFilter2 = new BaseFilter(GLSLRender.bux);
      localBaseFilter2.addParam(new m.f("blurSize", this.bwF));
      setNextFilter(localBaseFilter2, null);
      BaseFilter localBaseFilter1 = new BaseFilter(GLSLRender.buy);
      localBaseFilter1.addParam(new m.f("blurSize", this.bwF));
      localBaseFilter1.addParam(new m.f("intensity", this.intensity * 3.5F));
      localBaseFilter2.setNextFilter(localBaseFilter1, new int[] { this.srcTextureIndex + 1 });
      if ((this.bwE != null) || (this.bwD != GLSLRender.btg))
      {
        localBaseFilter2 = new BaseFilter(this.bwD);
        localBaseFilter2.addParam(new m.o("inputImageTexture2", this.bwE, 33986));
        localBaseFilter2.addParam(new m.f("inputH", this.bwG));
        localBaseFilter2.addParam(new m.f("inputS", this.bwH));
        localBaseFilter2.addParam(new m.f("inputV", this.bwI));
        localBaseFilter1.setNextFilter(localBaseFilter2, null);
      }
    }
  }
  
  public final void setParameterDic(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(86281);
    if (paramMap.containsKey("intensity")) {
      this.intensity = ((Float)paramMap.get("intensity")).floatValue();
    }
    if ((getmNextFilter() != null) && (getmNextFilter().getmNextFilter() != null)) {
      getmNextFilter().getmNextFilter().addParam(new m.f("intensity", this.intensity * 3.5F));
    }
    AppMethodBeat.o(86281);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.filter.art.a
 * JD-Core Version:    0.7.0.1
 */