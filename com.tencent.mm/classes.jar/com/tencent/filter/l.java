package com.tencent.filter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.g;

public final class l
  extends BaseFilter
{
  float bwi = 0.001F;
  float bwj = 0.999F;
  
  public l()
  {
    super(GLSLRender.btM);
  }
  
  public l(float paramFloat1, float paramFloat2)
  {
    super(GLSLRender.btM);
    this.bwi = paramFloat1;
    this.bwj = paramFloat2;
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(86380);
    addParam(new m.f("l_threshold", 0.1F));
    addParam(new m.f("h_threshold", 0.1F));
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
    AppMethodBeat.o(86380);
  }
  
  public final void beforeRender(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(86381);
    QImage localQImage = g.aK(paramInt1, paramInt2, paramInt3);
    int[] arrayOfInt = localQImage.nativeGetArrayHistogram();
    localQImage.Dispose();
    paramInt1 = 0;
    paramInt2 = 0;
    while (paramInt2 < 256)
    {
      paramInt1 += arrayOfInt[paramInt2];
      paramInt2 += 1;
    }
    float f1 = this.bwi;
    float f2 = this.bwj;
    paramInt3 = (int)(f1 * paramInt1);
    int j = (int)(paramInt1 * f2);
    paramInt2 = 0;
    paramInt1 = 0;
    if (paramInt1 < 256)
    {
      paramInt2 += arrayOfInt[paramInt1];
      if (paramInt2 >= paramInt3)
      {
        int i = paramInt1 + 1;
        paramInt3 = paramInt1;
        paramInt1 = i;
      }
    }
    for (;;)
    {
      label110:
      if (paramInt1 < 256)
      {
        paramInt2 = arrayOfInt[paramInt1] + paramInt2;
        if (paramInt2 < j) {}
      }
      for (;;)
      {
        addParam(new m.f("l_threshold", (float)(paramInt3 / 255.0D)));
        addParam(new m.f("h_threshold", (float)(paramInt1 / 255.0D)));
        AppMethodBeat.o(86381);
        return;
        paramInt1 += 1;
        break;
        paramInt1 += 1;
        break label110;
        paramInt1 = 0;
      }
      paramInt3 = 0;
    }
  }
  
  public final boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(86382);
    boolean bool = super.renderTexture(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(86382);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.filter.l
 * JD-Core Version:    0.7.0.1
 */