package com.tencent.filter.art;

import android.graphics.Bitmap;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.QImage;
import com.tencent.filter.m.k;
import java.util.Map;

public class BokehFilter
  extends BaseFilter
{
  public static Bitmap[] bgh = { null, null, null, null, null, null };
  Bitmap bgi = null;
  float bgj = 400.0F;
  int bgk = 1;
  float bgl = 0.5F;
  float bgm = (float)(1.0D / Math.exp(0.0D));
  float bgn = 0.0F;
  int radius = 8;
  
  public BokehFilter()
  {
    super(GLSLRender.bdf);
  }
  
  public static native int nativeBokehProcess(QImage paramQImage1, QImage paramQImage2, int paramInt, float paramFloat1, float paramFloat2);
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    this.glsl_programID = GLSLRender.bcE;
    this.scaleFact = (Math.min(960.0F / Math.max(paramFloat1, paramFloat2), 1.0F) * this.bgl);
    BokehFilter.a locala = new BokehFilter.a(this.radius, this.bgm, this.bgn, this.bgk, 1);
    locala.setScaleFact(this.scaleFact);
    setNextFilter(locala, null);
    locala.setNextFilter(new BaseFilter(GLSLRender.bcE), null);
    BaseFilter localBaseFilter = new BaseFilter(GLSLRender.bdq);
    if (this.bgi != null) {
      localBaseFilter.addParam(new m.k("inputImageTexture3", this.bgi, 33987, false));
    }
    locala.setNextFilter(localBaseFilter, new int[] { -1 });
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public void ClearGLSL()
  {
    super.ClearGLSL();
    this.bgi = null;
  }
  
  public void setParameterDic(Map<String, Object> paramMap)
  {
    float f;
    if (paramMap.containsKey("inputradius"))
    {
      f = ((Float)paramMap.get("input_radius")).floatValue();
      this.bgl = (1.0F - f);
      this.radius = 5;
      if ((this.bgl >= 0.8D) || (this.bgl <= 0.4F)) {
        break label219;
      }
      this.radius = 8;
    }
    for (;;)
    {
      if (paramMap.containsKey("maxwidth")) {
        this.bgj = ((Float)paramMap.get("maxwidth")).floatValue();
      }
      if (paramMap.containsKey("maskbmp")) {
        this.bgi = ((Bitmap)paramMap.get("maskbmp"));
      }
      if (paramMap.containsKey("bokehType")) {
        this.bgk = (((Integer)paramMap.get("bokehType")).intValue() % 6);
      }
      if (paramMap.containsKey("lumi_threshold")) {
        this.bgn = ((Float)paramMap.get("lumi_threshold")).floatValue();
      }
      if (paramMap.containsKey("lumi_weight")) {
        this.bgm = ((float)(1.0D / Math.exp(((Float)paramMap.get("lumi_weight")).floatValue())));
      }
      return;
      label219:
      if (this.bgl <= 0.4F)
      {
        this.bgl = 0.4F;
        this.radius = ((int)(f * 6.0F + 8.0F));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.filter.art.BokehFilter
 * JD-Core Version:    0.7.0.1
 */