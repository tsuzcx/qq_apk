package com.github.henryye.nativeiv.api;

import android.graphics.Bitmap;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.github.henryye.nativeiv.a.c.a;
import com.github.henryye.nativeiv.a.c.b;
import com.github.henryye.nativeiv.b.b;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface IImageDecodeService
{
  public abstract void addDecodeEventListener(b paramb);
  
  public abstract void addImageStreamFetcher(b paramb, boolean paramBoolean);
  
  public abstract String encodeToBase64(Bitmap paramBitmap, int paramInt, float paramFloat);
  
  public abstract byte[] encodeToBuffer(Bitmap paramBitmap, int paramInt, float paramFloat);
  
  public abstract void forceSetUseType(BitmapType paramBitmapType);
  
  public abstract Bitmap getBitmap(int paramInt1, int paramInt2);
  
  public abstract void init();
  
  public abstract void loadBitmapAsync(Object paramObject, ImageDecodeConfig paramImageDecodeConfig);
  
  public abstract void loadBitmapAsync(String paramString);
  
  public abstract void loadBitmapAsync(String paramString, ImageDecodeConfig paramImageDecodeConfig);
  
  public abstract IBitmap loadBitmapSync(Object paramObject, ImageDecodeConfig paramImageDecodeConfig);
  
  public abstract IBitmap loadBitmapSync(String paramString);
  
  public abstract IBitmap loadBitmapSync(String paramString, ImageDecodeConfig paramImageDecodeConfig);
  
  public abstract void release();
  
  public abstract void releaseBitmap(Bitmap paramBitmap);
  
  public abstract void removeDecodeEventListener(b paramb);
  
  public abstract void removeImageStreamFetcher(b paramb, boolean paramBoolean);
  
  public abstract void setBitmapDecodeSlave(a parama);
  
  public abstract void setIdKeyReportDelegate(c.a parama);
  
  public abstract void setKvReportDelegate(c.b paramb);
  
  public abstract void setMaxDecodeDimension(int paramInt1, int paramInt2);
  
  public abstract void setNetworkTimeout(int paramInt1, int paramInt2);
  
  public static abstract interface a
  {
    public abstract IBitmap a(String paramString, Object paramObject, b paramb, ImageDecodeConfig paramImageDecodeConfig);
    
    public abstract void a(IImageDecodeService.b paramb);
    
    public abstract void bX(int paramInt1, int paramInt2);
    
    public abstract void destroy();
    
    public abstract void forceSetUseType(BitmapType paramBitmapType);
    
    public abstract boolean isDestroyed();
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
        cEk = new a("OK", 0);
        cEl = new a("NOT_EXIST", 1);
        cEm = new a("PRE_DECODE_ERROR", 2);
        cEn = new a("DECODE_ERROR", 3);
        cEo = new a("UNSUPPORTED_IMG_FORMAT", 4);
        cEp = new a("HUGE_SIZE", 5);
        cEq = new a("IO_ERROR", 6);
        cEr = new a("OUT_OF_MEMORY", 7);
        cEs = new a("LEGACY_MODE", 8);
        cEt = new a("TIME_COST_HUGE", 9);
        cEu = new a("NATIVE_DECODE_ERROR", 10);
        cEv = new a("THROW_EXCEPTION", 11);
        cEw = new a[] { cEk, cEl, cEm, cEn, cEo, cEp, cEq, cEr, cEs, cEt, cEu, cEv };
        AppMethodBeat.o(127358);
      }
      
      private a() {}
    }
  }
  
  public static abstract interface c
  {
    public abstract void bd(Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.github.henryye.nativeiv.api.IImageDecodeService
 * JD-Core Version:    0.7.0.1
 */