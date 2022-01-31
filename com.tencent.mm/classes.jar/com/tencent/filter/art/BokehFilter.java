package com.tencent.filter.art;

import android.graphics.Bitmap;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.QImage;
import com.tencent.filter.m.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public class BokehFilter
  extends BaseFilter
{
  public static Bitmap[] bwJ = { null, null, null, null, null, null };
  Bitmap bwK;
  float bwL;
  int bwM;
  float bwN;
  float bwO;
  float bwP;
  int radius;
  
  public BokehFilter()
  {
    super(GLSLRender.btH);
    AppMethodBeat.i(86288);
    this.bwK = null;
    this.bwL = 400.0F;
    this.bwM = 1;
    this.bwN = 0.5F;
    this.radius = 8;
    this.bwO = ((float)(1.0D / Math.exp(0.0D)));
    this.bwP = 0.0F;
    AppMethodBeat.o(86288);
  }
  
  public static native int nativeBokehProcess(QImage paramQImage1, QImage paramQImage2, int paramInt, float paramFloat1, float paramFloat2);
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(86291);
    this.glsl_programID = GLSLRender.btg;
    this.scaleFact = (Math.min(960.0F / Math.max(paramFloat1, paramFloat2), 1.0F) * this.bwN);
    BokehFilter.a locala = new BokehFilter.a(this.radius, this.bwO, this.bwP, this.bwM, 1);
    locala.setScaleFact(this.scaleFact);
    setNextFilter(locala, null);
    locala.setNextFilter(new BaseFilter(GLSLRender.btg), null);
    BaseFilter localBaseFilter = new BaseFilter(GLSLRender.btS);
    if (this.bwK != null) {
      localBaseFilter.addParam(new m.k("inputImageTexture3", this.bwK, 33987, false));
    }
    locala.setNextFilter(localBaseFilter, new int[] { -1 });
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
    AppMethodBeat.o(86291);
  }
  
  public void ClearGLSL()
  {
    AppMethodBeat.i(86289);
    super.ClearGLSL();
    this.bwK = null;
    AppMethodBeat.o(86289);
  }
  
  public void setParameterDic(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(86290);
    float f;
    if (paramMap.containsKey("inputradius"))
    {
      f = ((Float)paramMap.get("input_radius")).floatValue();
      this.bwN = (1.0F - f);
      this.radius = 5;
      if ((this.bwN >= 0.8D) || (this.bwN <= 0.4F)) {
        break label229;
      }
      this.radius = 8;
    }
    for (;;)
    {
      if (paramMap.containsKey("maxwidth")) {
        this.bwL = ((Float)paramMap.get("maxwidth")).floatValue();
      }
      if (paramMap.containsKey("maskbmp")) {
        this.bwK = ((Bitmap)paramMap.get("maskbmp"));
      }
      if (paramMap.containsKey("bokehType")) {
        this.bwM = (((Integer)paramMap.get("bokehType")).intValue() % 6);
      }
      if (paramMap.containsKey("lumi_threshold")) {
        this.bwP = ((Float)paramMap.get("lumi_threshold")).floatValue();
      }
      if (paramMap.containsKey("lumi_weight")) {
        this.bwO = ((float)(1.0D / Math.exp(((Float)paramMap.get("lumi_weight")).floatValue())));
      }
      AppMethodBeat.o(86290);
      return;
      label229:
      if (this.bwN <= 0.4F)
      {
        this.bwN = 0.4F;
        this.radius = ((int)(f * 6.0F + 8.0F));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.filter.art.BokehFilter
 * JD-Core Version:    0.7.0.1
 */