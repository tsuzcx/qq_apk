package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.f;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class u$b
  extends BaseFilter
{
  private final String[] bxA;
  private final float[] bxB;
  int bxy;
  int quality;
  
  public u$b(u paramu, int paramInt1, int paramInt2)
  {
    super(GLSLRender.bva);
    AppMethodBeat.i(86467);
    this.bxA = new String[] { "error.file", "yijian_ziran", "yijian_hongrun", "yijian_baixi", "yijian_tianmei", "yijian_menghuan", "yijian_yangguang", "yijian_rounen" };
    this.bxB = new float[] { 1.0F, 1.0F, 0.95F, 0.9F };
    this.quality = 2;
    this.bxy = 0;
    this.bxy = paramInt1;
    this.quality = paramInt2;
    new StringBuilder("value = ").append(this.bxy);
    AppMethodBeat.o(86467);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(86468);
    new StringBuilder("value = ").append(this.bxy);
    String str = "yijian/" + this.bxA[this.bxy] + "_" + this.quality + ".jpg";
    float f2 = this.bxB[this.quality];
    float f1 = f2;
    if (this.bxy == 5)
    {
      if (this.quality == 1) {
        f1 = 0.912F;
      }
    }
    else
    {
      f2 = f1;
      if (this.bxy == 4)
      {
        if (this.quality != 3) {
          break label272;
        }
        f2 = 1.1F;
      }
    }
    for (;;)
    {
      this.glsl_programID = GLSLRender.bva;
      addParam(new m.o("inputImageTexture2", str, 33986));
      addParam(new m.f("quality", f2));
      addParam(new m.f("add_red", 0.0F));
      addParam(new m.f("red_m", 0.0F));
      addParam(new m.f("green_m", 0.0F));
      addParam(new m.f("blue_m", 0.0F));
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
      AppMethodBeat.o(86468);
      return;
      if (this.quality == 2)
      {
        f1 = 0.95F;
        break;
      }
      f1 = f2;
      if (this.quality != 3) {
        break;
      }
      f1 = 0.88F;
      break;
      label272:
      f2 = f1;
      if (this.quality == 2) {
        f2 = 1.0F;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.filter.a.u.b
 * JD-Core Version:    0.7.0.1
 */