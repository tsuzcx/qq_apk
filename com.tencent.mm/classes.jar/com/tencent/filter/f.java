package com.tencent.filter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class f
  extends BaseFilter
{
  float scaleFact = 1.0F;
  
  public f()
  {
    super(GLSLRender.btg);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(86357);
    this.glsl_programID = GLSLRender.btg;
    BaseFilter localBaseFilter = new BaseFilter(GLSLRender.btg);
    localBaseFilter.scaleFact = this.scaleFact;
    setNextFilter(localBaseFilter, null);
    localBaseFilter.setNextFilter(new BaseFilter(GLSLRender.btg), null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
    AppMethodBeat.o(86357);
  }
  
  public final void setParameterDic(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(86356);
    if (paramMap.containsKey("scalefact")) {
      this.scaleFact = ((Float)paramMap.get("scalefact")).floatValue();
    }
    AppMethodBeat.o(86356);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.filter.f
 * JD-Core Version:    0.7.0.1
 */