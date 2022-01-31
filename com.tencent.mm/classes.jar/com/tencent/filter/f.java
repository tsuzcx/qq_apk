package com.tencent.filter;

import java.util.Map;

public final class f
  extends BaseFilter
{
  float scaleFact = 1.0F;
  
  public f()
  {
    super(GLSLRender.bcE);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    this.glsl_programID = GLSLRender.bcE;
    BaseFilter localBaseFilter = new BaseFilter(GLSLRender.bcE);
    localBaseFilter.scaleFact = this.scaleFact;
    setNextFilter(localBaseFilter, null);
    localBaseFilter.setNextFilter(new BaseFilter(GLSLRender.bcE), null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public final void setParameterDic(Map<String, Object> paramMap)
  {
    if (paramMap.containsKey("scalefact")) {
      this.scaleFact = ((Float)paramMap.get("scalefact")).floatValue();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.filter.f
 * JD-Core Version:    0.7.0.1
 */