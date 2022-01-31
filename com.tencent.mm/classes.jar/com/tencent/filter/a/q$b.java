package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.f;
import com.tencent.filter.m.o;

public final class q$b
  extends BaseFilter
{
  int bgZ = 0;
  private final String[] bhb = { "error.file", "yijian_ziran", "yijian_hongrun", "yijian_baixi", "yijian_tianmei", "yijian_menghuan", "yijian_yangguang", "yijian_rounen" };
  private final float[] bhc = { 1.0F, 1.0F, 0.95F, 0.9F };
  int quality = 2;
  
  public q$b(q paramq, int paramInt1, int paramInt2)
  {
    super(GLSLRender.bex);
    this.bgZ = paramInt1;
    this.quality = paramInt2;
    new StringBuilder("value = ").append(this.bgZ);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    new StringBuilder("value = ").append(this.bgZ);
    String str = "yijian/" + this.bhb[this.bgZ] + "_" + this.quality + ".jpg";
    float f2 = this.bhc[this.quality];
    float f1 = f2;
    if (this.bgZ == 5)
    {
      if (this.quality == 1) {
        f1 = 0.912F;
      }
    }
    else
    {
      f2 = f1;
      if (this.bgZ == 4)
      {
        if (this.quality != 3) {
          break label262;
        }
        f2 = 1.1F;
      }
    }
    for (;;)
    {
      this.glsl_programID = GLSLRender.bex;
      addParam(new m.o("inputImageTexture2", str, 33986));
      addParam(new m.f("quality", f2));
      addParam(new m.f("add_red", 0.0F));
      addParam(new m.f("red_m", 0.0F));
      addParam(new m.f("green_m", 0.0F));
      addParam(new m.f("blue_m", 0.0F));
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
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
      label262:
      f2 = f1;
      if (this.quality == 2) {
        f2 = 1.0F;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.filter.a.q.b
 * JD-Core Version:    0.7.0.1
 */