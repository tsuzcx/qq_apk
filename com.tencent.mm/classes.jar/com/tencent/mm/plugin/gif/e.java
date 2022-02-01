package com.tencent.mm.plugin.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;

public final class e
  extends b
{
  private final Rect Hy;
  private Context mContext;
  private int mHeight;
  boolean mIsPlaying;
  private final Paint mPaint;
  private Resources mResources;
  private int mWidth;
  private ap oFl;
  int oIf;
  private long spF;
  private final Runnable spN;
  private final Runnable spO;
  private volatile boolean spU;
  private int spV;
  private int spW;
  private int[] spX;
  private Bitmap spY;
  private boolean spZ;
  private float sps;
  private float spt;
  private boolean spu;
  boolean sqa;
  private String sqb;
  int sqc;
  private k sqd;
  
  public e(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, int paramInt, int[] paramArrayOfInt, String paramString)
  {
    AppMethodBeat.i(104644);
    this.spU = false;
    this.oIf = 0;
    this.spY = null;
    this.spZ = false;
    this.mIsPlaying = true;
    this.sqa = true;
    this.sqc = 0;
    this.sps = 1.0F;
    this.spt = 1.0F;
    this.Hy = new Rect();
    this.mPaint = new Paint(6);
    this.oFl = new ap(Looper.getMainLooper());
    this.spF = 0L;
    this.spO = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104642);
        if (SystemClock.uptimeMillis() >= e.a(e.this)) {
          e.this.invalidateSelf();
        }
        AppMethodBeat.o(104642);
      }
    };
    this.spN = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104643);
        if (e.b(e.this) != null) {
          e.b(e.this);
        }
        AppMethodBeat.o(104643);
      }
    };
    this.mContext = paramContext;
    this.mResources = this.mContext.getResources();
    this.spZ = false;
    this.mIsPlaying = paramBoolean1;
    this.sqa = paramBoolean2;
    this.sqb = paramString;
    this.spW = paramInt;
    this.spX = paramArrayOfInt;
    if (!paramBoolean1)
    {
      this.spY = EP(adf(paramString));
      this.mWidth = this.spY.getWidth();
      this.mHeight = this.spY.getHeight();
      if (this.spX.length != 3) {
        break label254;
      }
    }
    label254:
    for (this.spV = 300;; this.spV = 100)
    {
      this.sqc = 0;
      AppMethodBeat.o(104644);
      return;
      this.spY = EP(this.spX[0]);
      break;
    }
  }
  
  private Bitmap EP(int paramInt)
  {
    AppMethodBeat.i(104651);
    Bitmap localBitmap = BitmapFactory.decodeResource(this.mResources, paramInt);
    AppMethodBeat.o(104651);
    return localBitmap;
  }
  
  private int adf(String paramString)
  {
    AppMethodBeat.i(104652);
    paramString = paramString.split("\\.")[0];
    int i = this.mResources.getIdentifier(paramString, "drawable", this.mContext.getPackageName());
    AppMethodBeat.o(104652);
    return i;
  }
  
  private void l(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(104646);
    this.spF = (SystemClock.uptimeMillis() + paramLong);
    if (this.oFl != null) {
      this.oFl.postDelayed(paramRunnable, paramLong);
    }
    AppMethodBeat.o(104646);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(104645);
    if (this.spu)
    {
      this.Hy.set(getBounds());
      this.sps = (this.Hy.width() / this.mWidth);
      this.spt = (this.Hy.height() / this.mHeight);
      this.spu = false;
    }
    if (this.mPaint.getShader() == null)
    {
      paramCanvas.scale(this.sps, this.spt);
      if (this.spZ)
      {
        this.spY = EP(this.spW);
        if ((this.spY != null) && (!this.spY.isRecycled()))
        {
          paramCanvas.drawBitmap(this.spY, 0.0F, 0.0F, this.mPaint);
          AppMethodBeat.o(104645);
        }
      }
      else if (!this.mIsPlaying)
      {
        this.spY = EP(adf(this.sqb));
        if ((this.spY != null) && (!this.spY.isRecycled()))
        {
          paramCanvas.drawBitmap(this.spY, 0.0F, 0.0F, this.mPaint);
          AppMethodBeat.o(104645);
        }
      }
      else
      {
        this.spY = EP(this.spX[this.oIf]);
        if ((this.spY != null) && (!this.spY.isRecycled())) {
          paramCanvas.drawBitmap(this.spY, 0.0F, 0.0F, this.mPaint);
        }
        this.oIf += 1;
        if (this.sqc < 3)
        {
          if (this.oIf >= this.spX.length)
          {
            this.oIf = 0;
            if (this.sqa) {
              break label316;
            }
          }
          label316:
          for (this.sqc = 0;; this.sqc += 1)
          {
            l(this.spO, this.spV);
            AppMethodBeat.o(104645);
            return;
          }
        }
        this.mIsPlaying = false;
        l(this.spO, this.spV);
        l(this.spN, 0L);
        AppMethodBeat.o(104645);
      }
    }
    else
    {
      ad.i("MicroMsg.GIF.MMGIFGameDrawable", "shader is not null.");
      paramCanvas.drawRect(this.Hy, this.mPaint);
    }
    AppMethodBeat.o(104645);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(104653);
    this.sqd = null;
    super.finalize();
    AppMethodBeat.o(104653);
  }
  
  public final int getIntrinsicHeight()
  {
    return this.mHeight;
  }
  
  public final int getIntrinsicWidth()
  {
    return this.mWidth;
  }
  
  public final int getOpacity()
  {
    return -2;
  }
  
  public final boolean isRunning()
  {
    return this.spU;
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    AppMethodBeat.i(104649);
    super.onBoundsChange(paramRect);
    this.spu = true;
    AppMethodBeat.o(104649);
  }
  
  public final void pause() {}
  
  public final void recycle() {}
  
  public final void reset() {}
  
  public final void resume() {}
  
  public final void setAlpha(int paramInt)
  {
    AppMethodBeat.i(104647);
    this.mPaint.setAlpha(paramInt);
    AppMethodBeat.o(104647);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(104648);
    this.mPaint.setColorFilter(paramColorFilter);
    AppMethodBeat.o(104648);
  }
  
  public final void start()
  {
    AppMethodBeat.i(104650);
    this.spU = true;
    this.oFl.post(this.spO);
    AppMethodBeat.o(104650);
  }
  
  public final void stop()
  {
    this.spU = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.e
 * JD-Core Version:    0.7.0.1
 */