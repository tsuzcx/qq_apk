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
  private final Rect Ko;
  private ap gKD;
  private Context mContext;
  private int mHeight;
  boolean mIsPlaying;
  private final Paint mPaint;
  private Resources mResources;
  private int mWidth;
  int pPf;
  private int[] uAA;
  private Bitmap uAB;
  private boolean uAC;
  boolean uAD;
  private String uAE;
  int uAF;
  private k uAG;
  private long uAi;
  private final Runnable uAq;
  private final Runnable uAr;
  private volatile boolean uAx;
  private int uAy;
  private int uAz;
  private float uzV;
  private float uzW;
  private boolean uzX;
  
  public e(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, int paramInt, int[] paramArrayOfInt, String paramString)
  {
    AppMethodBeat.i(104644);
    this.uAx = false;
    this.pPf = 0;
    this.uAB = null;
    this.uAC = false;
    this.mIsPlaying = true;
    this.uAD = true;
    this.uAF = 0;
    this.uzV = 1.0F;
    this.uzW = 1.0F;
    this.Ko = new Rect();
    this.mPaint = new Paint(6);
    this.gKD = new ap(Looper.getMainLooper());
    this.uAi = 0L;
    this.uAr = new Runnable()
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
    this.uAq = new Runnable()
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
    this.uAC = false;
    this.mIsPlaying = paramBoolean1;
    this.uAD = paramBoolean2;
    this.uAE = paramString;
    this.uAz = paramInt;
    this.uAA = paramArrayOfInt;
    if (!paramBoolean1)
    {
      this.uAB = Ih(amK(paramString));
      this.mWidth = this.uAB.getWidth();
      this.mHeight = this.uAB.getHeight();
      if (this.uAA.length != 3) {
        break label254;
      }
    }
    label254:
    for (this.uAy = 300;; this.uAy = 100)
    {
      this.uAF = 0;
      AppMethodBeat.o(104644);
      return;
      this.uAB = Ih(this.uAA[0]);
      break;
    }
  }
  
  private Bitmap Ih(int paramInt)
  {
    AppMethodBeat.i(104651);
    Bitmap localBitmap = BitmapFactory.decodeResource(this.mResources, paramInt);
    AppMethodBeat.o(104651);
    return localBitmap;
  }
  
  private int amK(String paramString)
  {
    AppMethodBeat.i(104652);
    paramString = paramString.split("\\.")[0];
    int i = this.mResources.getIdentifier(paramString, "drawable", this.mContext.getPackageName());
    AppMethodBeat.o(104652);
    return i;
  }
  
  private void m(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(104646);
    this.uAi = (SystemClock.uptimeMillis() + paramLong);
    if (this.gKD != null) {
      this.gKD.postDelayed(paramRunnable, paramLong);
    }
    AppMethodBeat.o(104646);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(104645);
    if (this.uzX)
    {
      this.Ko.set(getBounds());
      this.uzV = (this.Ko.width() / this.mWidth);
      this.uzW = (this.Ko.height() / this.mHeight);
      this.uzX = false;
    }
    if (this.mPaint.getShader() == null)
    {
      paramCanvas.scale(this.uzV, this.uzW);
      if (this.uAC)
      {
        this.uAB = Ih(this.uAz);
        if ((this.uAB != null) && (!this.uAB.isRecycled()))
        {
          paramCanvas.drawBitmap(this.uAB, 0.0F, 0.0F, this.mPaint);
          AppMethodBeat.o(104645);
        }
      }
      else if (!this.mIsPlaying)
      {
        this.uAB = Ih(amK(this.uAE));
        if ((this.uAB != null) && (!this.uAB.isRecycled()))
        {
          paramCanvas.drawBitmap(this.uAB, 0.0F, 0.0F, this.mPaint);
          AppMethodBeat.o(104645);
        }
      }
      else
      {
        this.uAB = Ih(this.uAA[this.pPf]);
        if ((this.uAB != null) && (!this.uAB.isRecycled())) {
          paramCanvas.drawBitmap(this.uAB, 0.0F, 0.0F, this.mPaint);
        }
        this.pPf += 1;
        if (this.uAF < 3)
        {
          if (this.pPf >= this.uAA.length)
          {
            this.pPf = 0;
            if (this.uAD) {
              break label316;
            }
          }
          label316:
          for (this.uAF = 0;; this.uAF += 1)
          {
            m(this.uAr, this.uAy);
            AppMethodBeat.o(104645);
            return;
          }
        }
        this.mIsPlaying = false;
        m(this.uAr, this.uAy);
        m(this.uAq, 0L);
        AppMethodBeat.o(104645);
      }
    }
    else
    {
      ad.i("MicroMsg.GIF.MMGIFGameDrawable", "shader is not null.");
      paramCanvas.drawRect(this.Ko, this.mPaint);
    }
    AppMethodBeat.o(104645);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(104653);
    this.uAG = null;
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
    return this.uAx;
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    AppMethodBeat.i(104649);
    super.onBoundsChange(paramRect);
    this.uzX = true;
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
    this.uAx = true;
    this.gKD.post(this.uAr);
    AppMethodBeat.o(104650);
  }
  
  public final void stop()
  {
    this.uAx = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.e
 * JD-Core Version:    0.7.0.1
 */