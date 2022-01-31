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
import com.github.henryye.nativeiv.bitmap.c;
import com.tencent.magicbrush.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

class LegacyBitmap
  implements IBitmap<Bitmap>
{
  private Bitmap auC = null;
  private long lastDecodeUsing = -1L;
  
  public void decodeInputStream(InputStream paramInputStream, Bitmap.Config paramConfig, c paramc)
  {
    AppMethodBeat.i(115750);
    long l = SystemClock.elapsedRealtime();
    paramc = new BitmapFactory.Options();
    paramc.inPreferredConfig = paramConfig;
    this.auC = BitmapFactory.decodeStream(paramInputStream, null, paramc);
    if ((this.auC != null) && (this.auC.getConfig() != Bitmap.Config.ARGB_8888))
    {
      c.c.w("Ni.LegacyBitmap", "hy: config not argb-8888", new Object[0]);
      paramInputStream = Bitmap.createBitmap(this.auC.getWidth(), this.auC.getHeight(), Bitmap.Config.ARGB_8888);
      new Canvas(paramInputStream).drawBitmap(this.auC, 0.0F, 0.0F, null);
      this.auC.recycle();
      this.auC = paramInputStream;
    }
    this.lastDecodeUsing = (SystemClock.elapsedRealtime() - l);
    AppMethodBeat.o(115750);
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
    return this.auC;
  }
  
  @Keep
  public void recycle()
  {
    AppMethodBeat.i(115751);
    if (this.auC != null) {
      this.auC.recycle();
    }
    AppMethodBeat.o(115751);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.github.henryye.nativeiv.LegacyBitmap
 * JD-Core Version:    0.7.0.1
 */