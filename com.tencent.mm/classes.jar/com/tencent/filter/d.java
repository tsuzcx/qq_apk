package com.tencent.filter;

import java.util.Map;

public final class d
  extends BaseFilter
{
  int bcy = 0;
  
  public d()
  {
    super(GLSLRender.bcE);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    this.glsl_programID = GLSLRender.bcE;
    BaseFilter localBaseFilter = new BaseFilter(GLSLRender.bdO);
    Object localObject = "sh/";
    switch (this.bcy)
    {
    default: 
      localBaseFilter.addParam(new m.o("inputImageTexture2", (String)localObject, 33986));
      setNextFilter(localBaseFilter, null);
      localObject = new BaseFilter(GLSLRender.bcH);
      if (this.bcy == 2) {
        ((BaseFilter)localObject).addParam(new m.f("filterAdjustParam", 0.6F));
      }
      break;
    }
    for (;;)
    {
      localBaseFilter.setNextFilter((BaseFilter)localObject, new int[] { this.srcTextureIndex });
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
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
    if (paramMap.containsKey("effectIndex")) {
      this.bcy = ((Integer)paramMap.get("effectIndex")).intValue();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.filter.d
 * JD-Core Version:    0.7.0.1
 */