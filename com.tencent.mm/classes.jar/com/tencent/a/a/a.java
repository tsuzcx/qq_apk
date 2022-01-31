package com.tencent.a.a;

import com.microrapid.opencv.OpencvAlgorithm;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.QImage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.g;

public final class a
  extends BaseFilter
{
  int paramTEXTRUEID = 0;
  float strength = 5.0F;
  
  public a()
  {
    super(GLSLRender.btg);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(86269);
    this.paramTEXTRUEID = g.dXe();
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
    AppMethodBeat.o(86269);
  }
  
  public final void ClearGLSL()
  {
    AppMethodBeat.i(86272);
    g.Tn(this.paramTEXTRUEID);
    super.ClearGLSL();
    AppMethodBeat.o(86272);
  }
  
  public final void beforeRender(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(86270);
    QImage localQImage = g.aK(paramInt1, paramInt2, paramInt3);
    OpencvAlgorithm.nativeDetailEnhanceFilter(localQImage, this.strength);
    GLSLRender.nativeTextImage(localQImage, this.paramTEXTRUEID);
    localQImage.Dispose();
    AppMethodBeat.o(86270);
  }
  
  public final boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(86271);
    boolean bool = super.renderTexture(this.paramTEXTRUEID, paramInt2, paramInt3);
    AppMethodBeat.o(86271);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.a.a.a
 * JD-Core Version:    0.7.0.1
 */