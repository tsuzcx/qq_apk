package com.github.henryye.nativeiv;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.support.annotation.Keep;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.tencent.magicbrush.a.d.f;
import java.io.InputStream;

class LegacyBitmap
  implements IBitmap<Bitmap>
{
  private Bitmap aso = null;
  private long asp = -1L;
  
  public final void a(InputStream paramInputStream, Bitmap.Config paramConfig)
  {
    long l = SystemClock.elapsedRealtime();
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = paramConfig;
    this.aso = BitmapFactory.decodeStream(paramInputStream, null, localOptions);
    if (this.aso.getConfig() != Bitmap.Config.ARGB_8888)
    {
      d.f.w("Ni.LegacyBitmap", "hy: config not argb-8888", new Object[0]);
      paramInputStream = Bitmap.createBitmap(this.aso.getWidth(), this.aso.getHeight(), Bitmap.Config.ARGB_8888);
      new Canvas(paramInputStream).drawBitmap(this.aso, 0.0F, 0.0F, null);
      this.aso.recycle();
      this.aso = paramInputStream;
    }
    this.asp = (SystemClock.elapsedRealtime() - l);
  }
  
  @Keep
  public BitmapType getType()
  {
    return BitmapType.Legacy;
  }
  
  public final long ko()
  {
    return this.asp;
  }
  
  @Keep
  public Bitmap provide()
  {
    return this.aso;
  }
  
  @Keep
  public void recycle()
  {
    if (this.aso != null) {
      this.aso.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.github.henryye.nativeiv.LegacyBitmap
 * JD-Core Version:    0.7.0.1
 */