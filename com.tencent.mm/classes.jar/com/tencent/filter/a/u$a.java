package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.FilterAlgorithm;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.QImage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.g;

public final class u$a
  extends BaseFilter
{
  private float bwF;
  float bwm;
  private int paramTEXTRUEID;
  
  public u$a(u paramu, int paramInt, float paramFloat)
  {
    super(GLSLRender.btj);
    AppMethodBeat.i(86462);
    this.bwF = 0.0F;
    this.paramTEXTRUEID = 0;
    this.bwm = 1.0F;
    this.bwm = paramFloat;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.bwF *= 2.0F;
      AppMethodBeat.o(86462);
      return;
      this.bwF = 0.62F;
      continue;
      this.bwF = 0.67F;
      continue;
      this.bwF = 1.0F;
    }
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(86463);
    this.paramTEXTRUEID = g.dXe();
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
    AppMethodBeat.o(86463);
  }
  
  public final void ClearGLSL()
  {
    AppMethodBeat.i(86466);
    g.Tn(this.paramTEXTRUEID);
    super.ClearGLSL();
    AppMethodBeat.o(86466);
  }
  
  public final void beforeRender(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(86464);
    QImage localQImage = g.aK(paramInt1, paramInt2, paramInt3);
    FilterAlgorithm.nativeFastBlur(localQImage, this.bwF * this.bwm);
    GLSLRender.nativeTextImage(localQImage, this.paramTEXTRUEID);
    localQImage.Dispose();
    AppMethodBeat.o(86464);
  }
  
  public final boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(86465);
    boolean bool = super.renderTexture(this.paramTEXTRUEID, paramInt2, paramInt3);
    AppMethodBeat.o(86465);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.filter.a.u.a
 * JD-Core Version:    0.7.0.1
 */