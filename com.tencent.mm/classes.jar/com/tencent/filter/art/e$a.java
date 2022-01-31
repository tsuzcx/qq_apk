package com.tencent.filter.art;

import android.opengl.GLES20;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.QImage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.g;

public final class e$a
  extends BaseFilter
{
  int paramTEXTRUEID = 0;
  
  public e$a()
  {
    super(GLSLRender.buR);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(86303);
    this.paramTEXTRUEID = g.dXe();
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
    AppMethodBeat.o(86303);
  }
  
  public final void ClearGLSL()
  {
    AppMethodBeat.i(86306);
    g.Tn(this.paramTEXTRUEID);
    super.ClearGLSL();
    AppMethodBeat.o(86306);
  }
  
  public final void beforeRender(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = 0;
    AppMethodBeat.i(86304);
    Object localObject = g.aK(paramInt1, paramInt2, paramInt3);
    int[] arrayOfInt = ((QImage)localObject).nativeGetArrayHistogram();
    ((QImage)localObject).Dispose();
    paramInt3 = 0;
    paramInt1 = 0;
    paramInt2 = 0;
    while (paramInt3 < 256)
    {
      paramInt1 += arrayOfInt[paramInt3];
      paramInt2 += arrayOfInt[paramInt3] * paramInt3;
      paramInt3 += 1;
    }
    int i = paramInt2 / paramInt1;
    int m = (int)(paramInt1 * 0.001F);
    int k = (int)(paramInt1 * 0.99F);
    paramInt3 = 0;
    paramInt2 = 0;
    if (paramInt2 < 256)
    {
      paramInt3 += arrayOfInt[paramInt2];
      if (paramInt3 <= m) {}
    }
    for (paramInt1 = paramInt2;; paramInt1 = 0)
    {
      paramInt2 += 1;
      label115:
      if (paramInt2 < 256)
      {
        paramInt3 += arrayOfInt[paramInt2];
        if (paramInt3 <= k) {}
      }
      for (;;)
      {
        float f1 = (i - paramInt1) / (paramInt2 - paramInt1);
        float f2 = (float)(Math.log(0.5D) / Math.log(f1));
        if (f2 < 0.1D) {}
        for (f1 = 0.1F;; f1 = f2)
        {
          if (f2 > 10.0D) {
            f1 = 10.0F;
          }
          localObject = new float[256];
          paramInt3 = 0;
          for (;;)
          {
            if (paramInt3 < paramInt1)
            {
              localObject[paramInt3] = 0.0F;
              paramInt3 += 1;
              continue;
              paramInt2 += 1;
              break;
              paramInt2 += 1;
              break label115;
            }
          }
          paramInt3 = paramInt1;
          for (;;)
          {
            i = paramInt2;
            if (paramInt3 >= paramInt2) {
              break;
            }
            localObject[paramInt3] = ((float)Math.pow((paramInt3 - paramInt1) / (paramInt2 - paramInt1), f1));
            paramInt3 += 1;
          }
          while (i < 256)
          {
            localObject[i] = 1.0F;
            i += 1;
          }
          arrayOfInt = new int[256];
          paramInt1 = j;
          while (paramInt1 < 256)
          {
            arrayOfInt[paramInt1] = ((int)(localObject[paramInt1] * 255.0F));
            paramInt1 += 1;
          }
          GLES20.glActiveTexture(33984);
          GLSLRender.nativeTextCure(arrayOfInt, this.paramTEXTRUEID);
          AppMethodBeat.o(86304);
          return;
        }
        paramInt2 = 255;
      }
    }
  }
  
  public final boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(86305);
    setTextureParam(this.paramTEXTRUEID, 1);
    boolean bool = super.renderTexture(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(86305);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.filter.art.e.a
 * JD-Core Version:    0.7.0.1
 */