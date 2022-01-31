package com.tencent.filter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.g;

public class c
  extends BaseFilter
{
  public c()
  {
    super(GLSLRender.btg);
    this.mIsGPU = false;
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(86351);
    this.mIsPreviewFilter = paramBoolean;
    if (paramBoolean) {
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(86351);
  }
  
  public void RenderProcess(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, double paramDouble, h paramh)
  {
    AppMethodBeat.i(86352);
    if (this.mIsPreviewFilter)
    {
      super.RenderProcess(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramDouble, paramh);
      AppMethodBeat.o(86352);
      return;
    }
    paramh = g.aK(paramInt1, paramInt2, paramInt3);
    QImage localQImage = ApplyFilter(paramh);
    GLSLRender.nativeTextImage(localQImage, paramInt6);
    paramh.Dispose();
    if (paramh != localQImage) {
      localQImage.Dispose();
    }
    AppMethodBeat.o(86352);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.filter.c
 * JD-Core Version:    0.7.0.1
 */