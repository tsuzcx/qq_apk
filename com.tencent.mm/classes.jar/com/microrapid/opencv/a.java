package com.microrapid.opencv;

import android.graphics.Bitmap;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.QImage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.g;
import java.util.Map;

public final class a
  extends BaseFilter
{
  float alpha = 1.0F;
  int blT = 0;
  int blU = 0;
  int blV = 0;
  Bitmap blW = null;
  int color = 0;
  int paramTEXTRUEID = 0;
  int radius = 0;
  int type = 0;
  int width = 0;
  
  public a()
  {
    super(GLSLRender.btg);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(86262);
    this.paramTEXTRUEID = g.dXe();
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
    AppMethodBeat.o(86262);
  }
  
  public final void ClearGLSL()
  {
    AppMethodBeat.i(86261);
    if (this.blW != null)
    {
      this.blW.recycle();
      this.blW = null;
    }
    g.Tn(this.paramTEXTRUEID);
    super.ClearGLSL();
    AppMethodBeat.o(86261);
  }
  
  public final void beforeRender(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(86263);
    Bitmap localBitmap = g.aJ(paramInt1, paramInt2, paramInt3);
    if (localBitmap == null)
    {
      AppMethodBeat.o(86263);
      return;
    }
    QImage localQImage = QImage.BindBitmap(localBitmap);
    switch (this.type)
    {
    }
    for (;;)
    {
      GLSLRender.nativeTextImage(localQImage, this.paramTEXTRUEID);
      localQImage.UnBindBitmap(localBitmap);
      localQImage.Dispose();
      AppMethodBeat.o(86263);
      return;
      OpencvAlgorithm.nativeGlowFilterGlow(localQImage, this.color, this.radius, this.alpha);
      continue;
      OpencvAlgorithm.nativeGlowFilterPolyFit(localQImage, this.blW, this.width, this.alpha);
      continue;
      OpencvAlgorithm.nativeGlowFilterDropShadow(localQImage, this.blT, this.blU, this.blV, this.alpha);
    }
  }
  
  public final boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(86264);
    boolean bool = super.renderTexture(this.paramTEXTRUEID, paramInt2, paramInt3);
    AppMethodBeat.o(86264);
    return bool;
  }
  
  public final void setParameterDic(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(86260);
    if (paramMap.containsKey("pstbitmap")) {
      this.blW = ((Bitmap)paramMap.get("pstbitmap"));
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
      this.blT = ((Integer)paramMap.get("xOffset")).intValue();
    }
    if (paramMap.containsKey("yOffset")) {
      this.blU = ((Integer)paramMap.get("yOffset")).intValue();
    }
    if (paramMap.containsKey("grayVal")) {
      this.blV = ((Integer)paramMap.get("grayVal")).intValue();
    }
    AppMethodBeat.o(86260);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.microrapid.opencv.a
 * JD-Core Version:    0.7.0.1
 */