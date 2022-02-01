package com.github.henryye.nativeiv.api;

import android.graphics.Bitmap;
import android.support.annotation.Keep;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.github.henryye.nativeiv.a.c.a;
import com.github.henryye.nativeiv.a.c.b;
import com.github.henryye.nativeiv.b.b;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface IImageDecodeService
{
  @Keep
  public abstract void addDecodeEventListener(b paramb);
  
  @Keep
  public abstract void addImageStreamFetcher(b paramb, boolean paramBoolean);
  
  @Keep
  public abstract String encodeToBase64(Bitmap paramBitmap, int paramInt, float paramFloat);
  
  @Keep
  public abstract byte[] encodeToBuffer(Bitmap paramBitmap, int paramInt, float paramFloat);
  
  @Keep
  public abstract void forceSetUseType(BitmapType paramBitmapType);
  
  @Keep
  public abstract Bitmap getBitmap(int paramInt1, int paramInt2);
  
  @Keep
  public abstract void init();
  
  @Keep
  public abstract void loadBitmapAsync(Object paramObject, ImageDecodeConfig paramImageDecodeConfig);
  
  @Keep
  public abstract void loadBitmapAsync(String paramString);
  
  @Keep
  public abstract void loadBitmapAsync(String paramString, ImageDecodeConfig paramImageDecodeConfig);
  
  @Keep
  public abstract IBitmap loadBitmapSync(Object paramObject, ImageDecodeConfig paramImageDecodeConfig);
  
  @Keep
  public abstract IBitmap loadBitmapSync(String paramString);
  
  @Keep
  public abstract IBitmap loadBitmapSync(String paramString, ImageDecodeConfig paramImageDecodeConfig);
  
  @Keep
  public abstract void release();
  
  @Keep
  public abstract void releaseBitmap(Bitmap paramBitmap);
  
  @Keep
  public abstract void removeDecodeEventListener(b paramb);
  
  @Keep
  public abstract void removeImageStreamFetcher(b paramb, boolean paramBoolean);
  
  @Keep
  public abstract void setBitmapDecodeSlave(a parama);
  
  @Keep
  public abstract void setIdKeyReportDelegate(c.a parama);
  
  @Keep
  public abstract void setKvReportDelegate(c.b paramb);
  
  @Keep
  public abstract void setMaxDecodeDimension(int paramInt1, int paramInt2);
  
  @Keep
  public abstract void setNetworkTimeout(int paramInt1, int paramInt2);
  
  public static abstract interface a
  {
    public abstract IBitmap a(String paramString, Object paramObject, b paramb, ImageDecodeConfig paramImageDecodeConfig);
    
    public abstract void a(IImageDecodeService.b paramb);
    
    public abstract void ba(int paramInt1, int paramInt2);
    
    public abstract void destroy();
    
    public abstract void forceSetUseType(BitmapType paramBitmapType);
  }
  
  public static abstract interface b
  {
    public abstract void a(String paramString, a parama, a parama1);
    
    public abstract void a(String paramString, Object paramObject, IImageDecodeService.c paramc, ImageDecodeConfig paramImageDecodeConfig);
    
    public static enum a
    {
      static
      {
        AppMethodBeat.i(127358);
        aPK = new a("OK", 0);
        aPL = new a("NOT_EXIST", 1);
        aPM = new a("PRE_DECODE_ERROR", 2);
        aPN = new a("DECODE_ERROR", 3);
        aPO = new a("UNSUPPORTED_IMG_FORMAT", 4);
        aPP = new a("HUGE_SIZE", 5);
        aPQ = new a("IO_ERROR", 6);
        aPR = new a("OUT_OF_MEMORY", 7);
        aPS = new a("LEGACY_MODE", 8);
        aPT = new a("TIME_COST_HUGE", 9);
        aPU = new a("NATIVE_DECODE_ERROR", 10);
        aPV = new a[] { aPK, aPL, aPM, aPN, aPO, aPP, aPQ, aPR, aPS, aPT, aPU };
        AppMethodBeat.o(127358);
      }
      
      private a() {}
    }
  }
  
  public static abstract interface c
  {
    public abstract void Z(Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.github.henryye.nativeiv.api.IImageDecodeService
 * JD-Core Version:    0.7.0.1
 */