package com.microrapid.lensFlare;

import android.graphics.Bitmap;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.QImage;
import com.tencent.filter.h;
import com.tencent.filter.m.f;
import com.tencent.filter.m.i;
import com.tencent.util.g;

public class LensFlareHandle
{
  final long aVf = nativeLensFlare();
  private boolean aVg = false;
  int aVh = 0;
  int aVi = 2;
  boolean hasInit = false;
  private float strength = 0.5F;
  
  static void aM(String paramString)
  {
    g.g("test", paramString);
  }
  
  private native void nativeDispose(long paramLong);
  
  private native void nativeInitLightSource(long paramLong, QImage paramQImage);
  
  private native long nativeLensFlare();
  
  private native void nativeQImageCopy(QImage paramQImage1, QImage paramQImage2);
  
  private native void nativeUpdateStrength(long paramLong, float paramFloat);
  
  final void a(QImage paramQImage)
  {
    nativeInitLightSource(this.aVf, paramQImage);
  }
  
  final void a(QImage paramQImage, float paramFloat1, float paramFloat2)
  {
    float f1 = 0.1F;
    float f2 = this.strength * 0.8F;
    if (f2 < 0.1F) {}
    for (;;)
    {
      BaseFilter localBaseFilter = new BaseFilter(GLSLRender.bfA, GLSLRender.beA);
      localBaseFilter.addParam(new m.i("uSamples", 32));
      localBaseFilter.addParam(new m.f("uDispersal", 0.3F));
      localBaseFilter.addParam(new m.f("uHaloWidth", f1));
      localBaseFilter.addParam(new m.f("uDistortion", 2.0F));
      localBaseFilter.addParam(new m.f("px", paramFloat1));
      localBaseFilter.addParam(new m.f("py", paramFloat2));
      localBaseFilter.ApplyGLSLFilter(false, paramQImage.getWidth(), paramQImage.getHeight());
      h localh = new h();
      localBaseFilter.RendProcessImage(paramQImage, localh);
      localBaseFilter.ClearGLSL();
      localh.clear();
      return;
      if (f2 > 1.0F) {
        f1 = 1.0F;
      } else {
        f1 = f2;
      }
    }
  }
  
  public final void dispose()
  {
    if (this.aVg)
    {
      nativeDispose(this.aVf);
      this.hasInit = false;
      this.aVg = false;
    }
  }
  
  protected void finalize()
  {
    dispose();
    super.finalize();
  }
  
  native int nativeAttachLightSourceCrossGPUOne(long paramLong, QImage paramQImage, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4, float[] paramArrayOfFloat5, float[] paramArrayOfFloat6, float[] paramArrayOfFloat7, float[] paramArrayOfFloat8, float[] paramArrayOfFloat9, float[] paramArrayOfFloat10, float[] paramArrayOfFloat11);
  
  native void nativeBlurImage(long paramLong, QImage paramQImage);
  
  native QImage nativeGetPatternImage(long paramLong);
  
  native void nativeGrayProcess(Bitmap paramBitmap);
  
  native boolean nativeIsLightSourceExisted(long paramLong, QImage paramQImage);
  
  native void nativeLightSourceCrossImgSingle(long paramLong, QImage paramQImage);
  
  native boolean nativeLightSourceCrossImgTotalCPU(long paramLong, QImage paramQImage);
  
  native QImage nativePostProcessForBg(long paramLong, QImage paramQImage);
  
  native QImage nativePreProcessLensImgNoLightSource(long paramLong, QImage paramQImage, float[] paramArrayOfFloat);
  
  native QImage nativePreProcessLensImgWithLightSource(long paramLong, QImage paramQImage, float[] paramArrayOfFloat);
  
  native void nativeRefineLabelmapEx(long paramLong);
  
  native void nativeUpdateCrossNumStrength(long paramLong, float paramFloat);
  
  native void nativeUpdateCrossSizeStrength(long paramLong, float paramFloat);
  
  native void nativeUpdateOpType(long paramLong, int paramInt);
  
  native void nativeUpdatePatternImage(long paramLong, QImage paramQImage);
  
  final void oW()
  {
    if (!this.aVg) {
      throw new RuntimeException("use bad addr");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.microrapid.lensFlare.LensFlareHandle
 * JD-Core Version:    0.7.0.1
 */