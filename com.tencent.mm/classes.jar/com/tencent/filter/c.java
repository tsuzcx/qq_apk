package com.tencent.filter;

import com.tencent.view.f;

public class c
  extends BaseFilter
{
  public c()
  {
    super(GLSLRender.bcE);
    this.mIsGPU = false;
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    this.mIsPreviewFilter = paramBoolean;
    if (paramBoolean) {
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
    }
  }
  
  public void RenderProcess(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, double paramDouble, h paramh)
  {
    if (this.mIsPreviewFilter) {
      super.RenderProcess(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramDouble, paramh);
    }
    QImage localQImage;
    do
    {
      return;
      paramh = f.ay(paramInt1, paramInt2, paramInt3);
      localQImage = ApplyFilter(paramh);
      GLSLRender.nativeTextImage(localQImage, paramInt6);
      paramh.Dispose();
    } while (paramh == localQImage);
    localQImage.Dispose();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.filter.c
 * JD-Core Version:    0.7.0.1
 */