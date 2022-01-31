package com.tencent.filter.art;

import android.graphics.Bitmap;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.QImage;
import com.tencent.filter.m.f;
import com.tencent.filter.m.i;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.b;
import com.tencent.view.g;

public final class BokehFilter$a
  extends BaseFilter
{
  int bwM;
  float bwO;
  float bwP;
  int bwQ;
  int paramTEXTRUEID;
  int radius;
  
  public BokehFilter$a(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3)
  {
    super(GLSLRender.btg);
    AppMethodBeat.i(86284);
    this.radius = 8;
    this.bwO = ((float)(1.0D / Math.exp(0.0D)));
    this.bwP = 0.0F;
    this.paramTEXTRUEID = -2000;
    this.bwM = 1;
    this.bwQ = 1;
    this.radius = paramInt1;
    this.bwO = paramFloat1;
    this.bwP = paramFloat2;
    this.bwM = paramInt2;
    this.bwQ = paramInt3;
    if (this.bwQ > 0)
    {
      addParam(new m.o("inputImageTexture2", fo(this.bwM), 33986));
      addParam(new m.f("lumi_threshold", this.bwP));
      addParam(new m.f("lumi_weight", this.bwO));
      if (this.bwQ == 1)
      {
        this.glsl_programID = GLSLRender.btH;
        addParam(new m.i("r", this.radius));
        AppMethodBeat.o(86284);
        return;
      }
      this.glsl_programID = GLSLRender.btT;
      AppMethodBeat.o(86284);
      return;
    }
    this.paramTEXTRUEID = g.dXe();
    AppMethodBeat.o(86284);
  }
  
  private static String fo(int paramInt)
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
    AppMethodBeat.i(86287);
    if (this.paramTEXTRUEID != -2000)
    {
      g.Tn(this.paramTEXTRUEID);
      this.paramTEXTRUEID = -2000;
    }
    super.ClearGLSL();
    AppMethodBeat.o(86287);
  }
  
  public final void beforeRender(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(86285);
    if (this.bwQ == 0)
    {
      Bitmap localBitmap = b.wv(fo(this.bwM));
      QImage localQImage1 = g.aK(paramInt1, paramInt2, paramInt3);
      QImage localQImage2 = QImage.BindBitmap(localBitmap);
      BokehFilter.nativeBokehProcess(localQImage1, localQImage2, this.radius, this.bwO, this.bwP);
      localQImage2.UnBindBitmap(localBitmap);
      localBitmap.recycle();
      GLSLRender.nativeTextImage(localQImage1, this.paramTEXTRUEID);
      localQImage1.Dispose();
    }
    AppMethodBeat.o(86285);
  }
  
  public final boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(86286);
    if (this.paramTEXTRUEID != -2000)
    {
      bool = super.renderTexture(this.paramTEXTRUEID, paramInt2, paramInt3);
      AppMethodBeat.o(86286);
      return bool;
    }
    boolean bool = super.renderTexture(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(86286);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.filter.art.BokehFilter.a
 * JD-Core Version:    0.7.0.1
 */