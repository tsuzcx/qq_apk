package com.tencent.filter.art;

import android.graphics.Bitmap;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.QImage;
import com.tencent.filter.m.f;
import com.tencent.filter.m.i;
import com.tencent.filter.m.o;
import com.tencent.view.b;
import com.tencent.view.f;

public final class BokehFilter$a
  extends BaseFilter
{
  int aVo = -2000;
  int bgk = 1;
  float bgm = (float)(1.0D / Math.exp(0.0D));
  float bgn = 0.0F;
  int bgo = 1;
  int radius = 8;
  
  public BokehFilter$a(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3)
  {
    super(GLSLRender.bcE);
    this.radius = paramInt1;
    this.bgm = paramFloat1;
    this.bgn = paramFloat2;
    this.bgk = paramInt2;
    this.bgo = paramInt3;
    if (this.bgo > 0)
    {
      addParam(new m.o("inputImageTexture2", ea(this.bgk), 33986));
      addParam(new m.f("lumi_threshold", this.bgn));
      addParam(new m.f("lumi_weight", this.bgm));
      if (this.bgo == 1)
      {
        this.glsl_programID = GLSLRender.bdf;
        addParam(new m.i("r", this.radius));
        return;
      }
      this.glsl_programID = GLSLRender.bdr;
      return;
    }
    this.aVo = f.cRo();
  }
  
  private static String ea(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "bokeh/shape1.jpg";
    case 1: 
      return "bokeh/circle.jpg";
    case 2: 
      return "bokeh/shape2.jpg";
    }
    return "bokeh/heart.jpg";
  }
  
  public final void ClearGLSL()
  {
    if (this.aVo != -2000)
    {
      f.Ku(this.aVo);
      this.aVo = -2000;
    }
    super.ClearGLSL();
  }
  
  public final void beforeRender(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.bgo == 0)
    {
      Bitmap localBitmap = b.pe(ea(this.bgk));
      QImage localQImage1 = f.ay(paramInt1, paramInt2, paramInt3);
      QImage localQImage2 = QImage.BindBitmap(localBitmap);
      BokehFilter.nativeBokehProcess(localQImage1, localQImage2, this.radius, this.bgm, this.bgn);
      localQImage2.UnBindBitmap(localBitmap);
      localBitmap.recycle();
      GLSLRender.nativeTextImage(localQImage1, this.aVo);
      localQImage1.Dispose();
    }
  }
  
  public final boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.aVo != -2000) {
      return super.renderTexture(this.aVo, paramInt2, paramInt3);
    }
    return super.renderTexture(paramInt1, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.filter.art.BokehFilter.a
 * JD-Core Version:    0.7.0.1
 */