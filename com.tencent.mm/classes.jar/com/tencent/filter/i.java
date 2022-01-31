package com.tencent.filter;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class i
  extends BaseFilter
{
  Bitmap blW = null;
  private int type = 0;
  
  public i()
  {
    super(GLSLRender.btg);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(86370);
    if (this.blW == null)
    {
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
      AppMethodBeat.o(86370);
      return;
    }
    addParam(new m.k("inputImageTexture2", this.blW, 33986, false));
    float f2;
    if (this.type == 0)
    {
      this.glsl_programID = GLSLRender.bug;
      f1 = (float)Math.floor(paramFloat2 / this.blW.getHeight() + 0.999999D);
      f2 = (float)Math.floor(paramFloat1 / this.blW.getWidth() + 0.999999D);
      addParam(new m.f("height_scale", f1));
      addParam(new m.f("width_scale", f2));
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
      AppMethodBeat.o(86370);
      return;
    }
    this.glsl_vertextshaderID = GLSLRender.bvX;
    this.glsl_programID = GLSLRender.bue;
    float f1 = this.blW.getHeight() / this.blW.getWidth();
    if (this.type == 1)
    {
      this.glsl_vertextshaderID = GLSLRender.bvY;
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
        this.glsl_vertextshaderID = GLSLRender.bvZ;
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
    AppMethodBeat.i(86371);
    if (this.blW != null)
    {
      this.blW.recycle();
      this.blW = null;
    }
    super.ClearGLSL();
    AppMethodBeat.o(86371);
  }
  
  public final void setParameterDic(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(86369);
    if (paramMap.containsKey("image")) {
      this.blW = ((Bitmap)paramMap.get("image"));
    }
    if (paramMap.containsKey("effectIndex")) {
      this.type = ((Integer)paramMap.get("effectIndex")).intValue();
    }
    AppMethodBeat.o(86369);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.filter.i
 * JD-Core Version:    0.7.0.1
 */