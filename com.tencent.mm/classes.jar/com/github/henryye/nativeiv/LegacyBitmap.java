package com.github.henryye.nativeiv;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.os.SystemClock;
import com.github.henryye.nativeiv.a.b;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.github.henryye.nativeiv.bitmap.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public class LegacyBitmap
  implements IBitmap<Bitmap>
{
  private Bitmap cEc = null;
  private long lastDecodeUsing = -1L;
  
  protected Bitmap a(InputStream paramInputStream, ImageDecodeConfig paramImageDecodeConfig, c paramc)
  {
    AppMethodBeat.i(208235);
    paramc = new BitmapFactory.Options();
    paramc.inPreferredConfig = paramImageDecodeConfig.mConfig;
    paramc.inPremultiplied = paramImageDecodeConfig.mPremultiplyAlpha;
    paramInputStream = BitmapFactory.decodeStream(paramInputStream, null, paramc);
    if ((paramInputStream != null) && (paramInputStream.getConfig() != Bitmap.Config.ARGB_8888))
    {
      b.w("Ni.LegacyBitmap", "hy: config not argb-8888", new Object[0]);
      paramImageDecodeConfig = Bitmap.createBitmap(paramInputStream.getWidth(), paramInputStream.getHeight(), Bitmap.Config.ARGB_8888);
      new Canvas(paramImageDecodeConfig).drawBitmap(paramInputStream, 0.0F, 0.0F, null);
      paramInputStream.recycle();
      paramInputStream = paramImageDecodeConfig;
    }
    for (;;)
    {
      AppMethodBeat.o(208235);
      return paramInputStream;
    }
  }
  
  public void decodeInputStream(InputStream paramInputStream, ImageDecodeConfig paramImageDecodeConfig, c paramc)
  {
    AppMethodBeat.i(127349);
    long l = SystemClock.elapsedRealtime();
    this.cEc = a(paramInputStream, paramImageDecodeConfig, paramc);
    this.lastDecodeUsing = (SystemClock.elapsedRealtime() - l);
    AppMethodBeat.o(127349);
  }
  
  public long getDecodeTime()
  {
    return this.lastDecodeUsing;
  }
  
  public BitmapType getType()
  {
    return BitmapType.Legacy;
  }
  
  public Bitmap provide()
  {
    return this.cEc;
  }
  
  public void recycle()
  {
    AppMethodBeat.i(127350);
    if (this.cEc != null) {
      this.cEc.recycle();
    }
    AppMethodBeat.o(127350);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.github.henryye.nativeiv.LegacyBitmap
 * JD-Core Version:    0.7.0.1
 */