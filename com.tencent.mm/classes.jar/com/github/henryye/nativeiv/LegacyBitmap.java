package com.github.henryye.nativeiv;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.support.annotation.Keep;
import com.github.henryye.nativeiv.a.b;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.github.henryye.nativeiv.bitmap.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public class LegacyBitmap
  implements IBitmap<Bitmap>
{
  private Bitmap aQs = null;
  private long lastDecodeUsing = -1L;
  
  public void decodeInputStream(InputStream paramInputStream, ImageDecodeConfig paramImageDecodeConfig, c paramc)
  {
    AppMethodBeat.i(127349);
    long l = SystemClock.elapsedRealtime();
    paramc = new BitmapFactory.Options();
    paramc.inPreferredConfig = paramImageDecodeConfig.mConfig;
    paramc.inPremultiplied = paramImageDecodeConfig.mPremultiplyAlpha;
    this.aQs = BitmapFactory.decodeStream(paramInputStream, null, paramc);
    if ((this.aQs != null) && (this.aQs.getConfig() != Bitmap.Config.ARGB_8888))
    {
      b.w("Ni.LegacyBitmap", "hy: config not argb-8888", new Object[0]);
      paramInputStream = Bitmap.createBitmap(this.aQs.getWidth(), this.aQs.getHeight(), Bitmap.Config.ARGB_8888);
      new Canvas(paramInputStream).drawBitmap(this.aQs, 0.0F, 0.0F, null);
      this.aQs.recycle();
      this.aQs = paramInputStream;
    }
    this.lastDecodeUsing = (SystemClock.elapsedRealtime() - l);
    AppMethodBeat.o(127349);
  }
  
  public long getDecodeTime()
  {
    return this.lastDecodeUsing;
  }
  
  @Keep
  public BitmapType getType()
  {
    return BitmapType.Legacy;
  }
  
  @Keep
  public Bitmap provide()
  {
    return this.aQs;
  }
  
  @Keep
  public void recycle()
  {
    AppMethodBeat.i(127350);
    if (this.aQs != null) {
      this.aQs.recycle();
    }
    AppMethodBeat.o(127350);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.github.henryye.nativeiv.LegacyBitmap
 * JD-Core Version:    0.7.0.1
 */