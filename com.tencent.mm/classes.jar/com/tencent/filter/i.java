package com.tencent.filter;

import android.graphics.Bitmap;
import java.util.Map;

public final class i
  extends BaseFilter
{
  Bitmap aVn = null;
  private int type = 0;
  
  public i()
  {
    super(GLSLRender.bcE);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    if (this.aVn == null)
    {
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
      return;
    }
    addParam(new m.k("inputImageTexture2", this.aVn, 33986, false));
    float f2;
    if (this.type == 0)
    {
      this.glsl_programID = GLSLRender.bdD;
      f1 = (float)Math.floor(paramFloat2 / this.aVn.getHeight() + 0.999999D);
      f2 = (float)Math.floor(paramFloat1 / this.aVn.getWidth() + 0.999999D);
      addParam(new m.f("height_scale", f1));
      addParam(new m.f("width_scale", f2));
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
      return;
    }
    this.glsl_vertextshaderID = GLSLRender.bfu;
    this.glsl_programID = GLSLRender.bdC;
    float f1 = this.aVn.getHeight() / this.aVn.getWidth();
    if (this.type == 1)
    {
      this.glsl_vertextshaderID = GLSLRender.bfv;
      if (paramFloat2 > paramFloat1 * f1)
      {
        f1 = (paramFloat2 - f1 * paramFloat1) / 2.0F / paramFloat2;
        f2 = 0.0F;
      }
    }
    for (;;)
    {
      addParam(new m.f("height_offset", f1));
      addParam(new m.f("width_offset", f2));
      break;
      f2 = (paramFloat1 - paramFloat2 / f1) / 2.0F / paramFloat1;
      f1 = 0.0F;
      continue;
      if (this.type == 2)
      {
        this.glsl_vertextshaderID = GLSLRender.bfw;
        if (paramFloat2 < paramFloat1 * f1)
        {
          f1 = (paramFloat1 * f1 - paramFloat2) / 2.0F / (f1 * paramFloat1);
          f2 = 0.0F;
        }
        else
        {
          f2 = (paramFloat2 / f1 - paramFloat1) / 2.0F / (paramFloat2 / f1);
          f1 = 0.0F;
        }
      }
      else
      {
        f1 = 0.0F;
        f2 = 0.0F;
      }
    }
  }
  
  public final void ClearGLSL()
  {
    if (this.aVn != null)
    {
      this.aVn.recycle();
      this.aVn = null;
    }
    super.ClearGLSL();
  }
  
  public final void setParameterDic(Map<String, Object> paramMap)
  {
    if (paramMap.containsKey("image")) {
      this.aVn = ((Bitmap)paramMap.get("image"));
    }
    if (paramMap.containsKey("effectIndex")) {
      this.type = ((Integer)paramMap.get("effectIndex")).intValue();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.filter.i
 * JD-Core Version:    0.7.0.1
 */