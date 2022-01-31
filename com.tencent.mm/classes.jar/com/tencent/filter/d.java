package com.tencent.filter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class d
  extends BaseFilter
{
  int bta = 0;
  
  public d()
  {
    super(GLSLRender.btg);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(86350);
    this.glsl_programID = GLSLRender.btg;
    BaseFilter localBaseFilter = new BaseFilter(GLSLRender.bur);
    Object localObject = "sh/";
    switch (this.bta)
    {
    default: 
      localBaseFilter.addParam(new m.o("inputImageTexture2", (String)localObject, 33986));
      setNextFilter(localBaseFilter, null);
      localObject = new BaseFilter(GLSLRender.btj);
      if (this.bta == 2) {
        ((BaseFilter)localObject).addParam(new m.f("filterAdjustParam", 0.6F));
      }
      break;
    }
    for (;;)
    {
      localBaseFilter.setNextFilter((BaseFilter)localObject, new int[] { this.srcTextureIndex });
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
      AppMethodBeat.o(86350);
      return;
      localObject = "sh/" + "blue_sh_blend.jpg";
      break;
      localObject = "sh/" + "yellow_sh_blend.jpg";
      break;
      localObject = "sh/" + "red_sh_blend.jpg";
      break;
      localObject = "sh/" + "purple_sh_blend.jpg";
      break;
      localObject = "sh/" + "green_sh_blend.jpg";
      break;
      ((BaseFilter)localObject).addParam(new m.f("filterAdjustParam", 0.5F));
    }
  }
  
  public final void setParameterDic(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(86349);
    if (paramMap.containsKey("effectIndex")) {
      this.bta = ((Integer)paramMap.get("effectIndex")).intValue();
    }
    AppMethodBeat.o(86349);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.filter.d
 * JD-Core Version:    0.7.0.1
 */