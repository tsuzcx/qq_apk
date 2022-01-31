package com.microrapid.opencv;

import android.graphics.Bitmap;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.QImage;
import com.tencent.view.f;
import java.util.Map;

public final class a
  extends BaseFilter
{
  int aVk = 0;
  int aVl = 0;
  int aVm = 0;
  Bitmap aVn = null;
  int aVo = 0;
  float alpha = 1.0F;
  int color = 0;
  int radius = 0;
  int type = 0;
  int width = 0;
  
  public a()
  {
    super(GLSLRender.bcE);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    this.aVo = f.cRo();
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public final void ClearGLSL()
  {
    if (this.aVn != null)
    {
      this.aVn.recycle();
      this.aVn = null;
    }
    f.Ku(this.aVo);
    super.ClearGLSL();
  }
  
  public final void beforeRender(int paramInt1, int paramInt2, int paramInt3)
  {
    Bitmap localBitmap = f.ax(paramInt1, paramInt2, paramInt3);
    if (localBitmap == null) {
      return;
    }
    QImage localQImage = QImage.BindBitmap(localBitmap);
    switch (this.type)
    {
    }
    for (;;)
    {
      GLSLRender.nativeTextImage(localQImage, this.aVo);
      localQImage.UnBindBitmap(localBitmap);
      localQImage.Dispose();
      return;
      OpencvAlgorithm.nativeGlowFilterGlow(localQImage, this.color, this.radius, this.alpha);
      continue;
      OpencvAlgorithm.nativeGlowFilterPolyFit(localQImage, this.aVn, this.width, this.alpha);
      continue;
      OpencvAlgorithm.nativeGlowFilterDropShadow(localQImage, this.aVk, this.aVl, this.aVm, this.alpha);
    }
  }
  
  public final boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    return super.renderTexture(this.aVo, paramInt2, paramInt3);
  }
  
  public final void setParameterDic(Map<String, Object> paramMap)
  {
    if (paramMap.containsKey("pstbitmap")) {
      this.aVn = ((Bitmap)paramMap.get("pstbitmap"));
    }
    if (paramMap.containsKey("effectIndex")) {
      this.type = ((Integer)paramMap.get("effectIndex")).intValue();
    }
    if (paramMap.containsKey("color")) {
      this.color = ((Integer)paramMap.get("color")).intValue();
    }
    if (paramMap.containsKey("radius")) {
      this.radius = ((Integer)paramMap.get("radius")).intValue();
    }
    if (paramMap.containsKey("width")) {
      this.width = ((Integer)paramMap.get("width")).intValue();
    }
    if (paramMap.containsKey("alpha")) {
      this.alpha = ((Float)paramMap.get("alpha")).floatValue();
    }
    if (paramMap.containsKey("xOffset")) {
      this.aVk = ((Integer)paramMap.get("xOffset")).intValue();
    }
    if (paramMap.containsKey("yOffset")) {
      this.aVl = ((Integer)paramMap.get("yOffset")).intValue();
    }
    if (paramMap.containsKey("grayVal")) {
      this.aVm = ((Integer)paramMap.get("grayVal")).intValue();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.microrapid.opencv.a
 * JD-Core Version:    0.7.0.1
 */