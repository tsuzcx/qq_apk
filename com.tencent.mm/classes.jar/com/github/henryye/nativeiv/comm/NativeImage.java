package com.github.henryye.nativeiv.comm;

import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.support.annotation.Keep;
import com.github.henryye.nativeiv.b.a;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.magicbrush.a.d.f;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class NativeImage
  implements IBitmap<NativeBitmapStruct>
{
  private NativeBitmapStruct asD = null;
  private long asp = -1L;
  
  public final void a(InputStream paramInputStream, Bitmap.Config paramConfig)
  {
    try
    {
      long l = SystemClock.elapsedRealtime();
      if (paramInputStream == null)
      {
        d.f.w("Ni.NativeImage", "hy: non stream, mark as request clear", new Object[0]);
        recycle();
      }
      paramInputStream = a.c(paramInputStream);
      int i;
      if ((paramConfig != null) && (paramConfig != Bitmap.Config.ARGB_8888) && (paramConfig != Bitmap.Config.ARGB_4444) && (paramConfig != Bitmap.Config.RGB_565))
      {
        Bitmap.Config localConfig = Bitmap.Config.ALPHA_8;
        if (paramConfig == localConfig) {
          i = 2;
        }
      }
      for (;;)
      {
        if (paramInputStream != null) {
          try
          {
            paramConfig = NativeImageJni.decodeNative(paramInputStream, i);
            if (paramConfig != null) {
              this.asD = paramConfig.convertToCommonStruct();
            }
            for (;;)
            {
              paramInputStream.clear();
              this.asp = (SystemClock.elapsedRealtime() - l);
              return;
              i = Build.VERSION.SDK_INT;
              i = 4;
              break;
              d.f.e("Ni.NativeImage", "hy: decode failed!!", new Object[0]);
            }
            paramInputStream = finally;
          }
          finally
          {
            this.asp = (SystemClock.elapsedRealtime() - l);
          }
        }
      }
      d.f.w("Ni.NativeImage", "hy: decode error!", new Object[0]);
    }
    finally {}
    recycle();
    throw new IOException("decode error!");
  }
  
  @Keep
  public BitmapType getType()
  {
    return BitmapType.Native;
  }
  
  public final long ko()
  {
    return this.asp;
  }
  
  @Keep
  public NativeBitmapStruct provide()
  {
    return this.asD;
  }
  
  @Keep
  public void recycle()
  {
    try
    {
      d.f.v("Ni.NativeImage", "hy: recycling %d", new Object[] { Integer.valueOf(hashCode()) });
      if ((this.asD != null) && (this.asD.ptr != -1L))
      {
        NativeImageJni.recycleNative(this.asD.ptr);
        this.asD = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.github.henryye.nativeiv.comm.NativeImage
 * JD-Core Version:    0.7.0.1
 */