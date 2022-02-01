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
  private Bitmap aPC = null;
  private long lastDecodeUsing = -1L;
  
  public void decodeInputStream(InputStream paramInputStream, ImageDecodeConfig paramImageDecodeConfig, c paramc)
  {
    AppMethodBeat.i(127349);
    long l = SystemClock.elapsedRealtime();
    paramc = new BitmapFactory.Options();
    paramc.inPreferredConfig = paramImageDecodeConfig.mConfig;
    paramc.inPremultiplied = paramImageDecodeConfig.mPremultiplyAlpha;
    this.aPC = BitmapFactory.decodeStream(paramInputStream, null, paramc);
    if ((this.aPC != null) && (this.aPC.getConfig() != Bitmap.Config.ARGB_8888))
    {
      b.w("Ni.LegacyBitmap", "hy: config not argb-8888", new Object[0]);
      paramInputStream = Bitmap.createBitmap(this.aPC.getWidth(), this.aPC.getHeight(), Bitmap.Config.ARGB_8888);
      new Canvas(paramInputStream).drawBitmap(this.aPC, 0.0F, 0.0F, null);
      this.aPC.recycle();
      this.aPC = paramInputStream;
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
    return this.aPC;
  }
  
  @Keep
  public void recycle()
  {
    AppMethodBeat.i(127350);
    if (this.aPC != null) {
      this.aPC.recycle();
    }
    AppMethodBeat.o(127350);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.github.henryye.nativeiv.LegacyBitmap
 * JD-Core Version:    0.7.0.1
 */