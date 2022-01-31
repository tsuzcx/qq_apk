package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.QImage;
import com.tencent.filter.m.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.g;

public final class al
  extends BaseFilter
{
  float bwi;
  float bwj;
  
  public al()
  {
    super(GLSLRender.buu);
    this.bwi = 0.001F;
    this.bwj = 0.999F;
  }
  
  public al(float paramFloat)
  {
    super(GLSLRender.buu);
    AppMethodBeat.i(86490);
    this.bwi = 0.001F;
    this.bwj = 0.999F;
    this.bwi = (0.0F + paramFloat * 0.05F);
    this.bwj = (1.0F - paramFloat * 0.05F);
    AppMethodBeat.o(86490);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(86491);
    addParam(new m.f("l_threshold_r", 0.1F));
    addParam(new m.f("h_threshold_r", 0.1F));
    addParam(new m.f("l_threshold_g", 0.1F));
    addParam(new m.f("h_threshold_g", 0.1F));
    addParam(new m.f("l_threshold_b", 0.1F));
    addParam(new m.f("h_threshold_b", 0.1F));
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
    AppMethodBeat.o(86491);
  }
  
  public final void beforeRender(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(86492);
    Object localObject = g.aK(paramInt1, paramInt2, paramInt3);
    int[] arrayOfInt1 = ((QImage)localObject).nativeGetArrayHistogramChannels();
    ((QImage)localObject).Dispose();
    localObject = new int[3];
    int[] arrayOfInt2 = new int[3];
    paramInt3 = 0;
    int k;
    int m;
    int i;
    if (paramInt3 < 3)
    {
      k = paramInt3 * 256;
      paramInt1 = 0;
      paramInt2 = 0;
      while (paramInt2 < 256)
      {
        paramInt1 += arrayOfInt1[(k + paramInt2)];
        paramInt2 += 1;
      }
      float f1 = this.bwi;
      float f2 = this.bwj;
      int j = (int)(f1 * paramInt1);
      m = (int)(paramInt1 * f2);
      paramInt2 = 0;
      i = 0;
      paramInt1 = 0;
      label112:
      if (paramInt1 >= 256) {
        break label344;
      }
      paramInt2 += arrayOfInt1[(k + paramInt1)];
      if (paramInt2 >= j)
      {
        j = paramInt1 + 1;
        i = paramInt1;
        paramInt1 = j;
      }
    }
    label146:
    label344:
    for (;;)
    {
      if (paramInt1 < 256)
      {
        paramInt2 = arrayOfInt1[(k + paramInt1)] + paramInt2;
        if (paramInt2 < m) {}
      }
      for (;;)
      {
        localObject[paramInt3] = i;
        arrayOfInt2[paramInt3] = paramInt1;
        paramInt3 += 1;
        break;
        paramInt1 += 1;
        break label112;
        paramInt1 += 1;
        break label146;
        addParam(new m.f("l_threshold_r", localObject[0] / 255.0F));
        addParam(new m.f("h_threshold_r", arrayOfInt2[0] / 255.0F));
        addParam(new m.f("l_threshold_g", localObject[1] / 255.0F));
        addParam(new m.f("h_threshold_g", arrayOfInt2[1] / 255.0F));
        addParam(new m.f("l_threshold_b", localObject[2] / 255.0F));
        addParam(new m.f("h_threshold_b", arrayOfInt2[2] / 255.0F));
        AppMethodBeat.o(86492);
        return;
        paramInt1 = 0;
      }
    }
  }
  
  public final boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(86493);
    boolean bool = super.renderTexture(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(86493);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.filter.a.al
 * JD-Core Version:    0.7.0.1
 */