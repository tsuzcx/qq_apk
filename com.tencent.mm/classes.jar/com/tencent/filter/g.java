package com.tencent.filter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class g
  extends BaseFilter
{
  private int type = 0;
  
  public g()
  {
    super(GLSLRender.btg);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(86363);
    double d = paramFloat1 / paramFloat2;
    this.glsl_programID = GLSLRender.btu;
    addParam(new m.o("inputImageTexture3", "flares/flares_curve.png", 33987));
    switch (this.type)
    {
    default: 
      addParam(new m.o("inputImageTexture2", "flares/flares_light_leak_3.jpg", d));
      addParam(new m.i("flag", 1));
    }
    for (;;)
    {
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
      AppMethodBeat.o(86363);
      return;
      addParam(new m.o("inputImageTexture2", "flares/flares_bokeh_basic_1.jpg", d));
      addParam(new m.i("flag", 0));
      continue;
      addParam(new m.o("inputImageTexture2", "flares/flares_bokeh_basic_2.jpg", d));
      addParam(new m.i("flag", 0));
      continue;
      addParam(new m.o("inputImageTexture2", "flares/flares_bokeh_basic_3.jpg", d));
      addParam(new m.i("flag", 0));
      continue;
      addParam(new m.o("inputImageTexture2", "flares/flares_bokeh_heart_1.jpg", d));
      addParam(new m.i("flag", 0));
      continue;
      addParam(new m.o("inputImageTexture2", "flares/flares_bokeh_heart_2.jpg", d));
      addParam(new m.i("flag", 0));
      continue;
      addParam(new m.o("inputImageTexture2", "flares/flares_lens_flares_1.jpg", d));
      addParam(new m.i("flag", 0));
      continue;
      addParam(new m.o("inputImageTexture2", "flares/flares_lens_flares_2.jpg", d));
      addParam(new m.i("flag", 0));
      continue;
      addParam(new m.o("inputImageTexture2", "flares/flares_lens_flares_3.jpg", d));
      addParam(new m.i("flag", 0));
      continue;
      addParam(new m.o("inputImageTexture2", "flares/flares_light_leak_1.jpg", d));
      addParam(new m.i("flag", 1));
      continue;
      addParam(new m.o("inputImageTexture2", "flares/flares_light_leak_2.jpg", d));
      addParam(new m.i("flag", 1));
    }
  }
  
  public final void setParameterDic(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(86362);
    if (paramMap.containsKey("effectIndex")) {
      this.type = ((Integer)paramMap.get("effectIndex")).intValue();
    }
    AppMethodBeat.o(86362);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.filter.g
 * JD-Core Version:    0.7.0.1
 */