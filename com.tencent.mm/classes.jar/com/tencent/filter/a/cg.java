package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.f;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cg
  extends BaseFilter
{
  int bta = 0;
  
  public cg()
  {
    super(GLSLRender.btg);
  }
  
  public cg(byte paramByte)
  {
    super(GLSLRender.btg);
    this.bta = 1;
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(86540);
    this.glsl_programID = GLSLRender.btg;
    BaseFilter localBaseFilter1;
    BaseFilter localBaseFilter2;
    if (this.bta == 0)
    {
      localBaseFilter1 = new BaseFilter(GLSLRender.buj);
      localBaseFilter1.addParam(new m.o("inputImageTexture2", "sh/shishang_sh_curve.png", 33986));
      setNextFilter(localBaseFilter1, null);
      localBaseFilter2 = new BaseFilter(GLSLRender.buq);
      localBaseFilter2.addParam(new m.o("inputImageTexture2", "sh/shishang_sh_blend.jpg", 33986));
      localBaseFilter1.setNextFilter(localBaseFilter2, null);
    }
    for (;;)
    {
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
      AppMethodBeat.o(86540);
      return;
      localBaseFilter1 = new BaseFilter(GLSLRender.bur);
      localBaseFilter1.addParam(new m.o("inputImageTexture2", "sh/fugu_sh_blend.jpg", 33986));
      setNextFilter(localBaseFilter1, null);
      localBaseFilter2 = new BaseFilter(GLSLRender.btj);
      localBaseFilter2.addParam(new m.f("filterAdjustParam", 0.3F));
      localBaseFilter1.setNextFilter(localBaseFilter2, new int[] { this.srcTextureIndex });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.filter.a.cg
 * JD-Core Version:    0.7.0.1
 */