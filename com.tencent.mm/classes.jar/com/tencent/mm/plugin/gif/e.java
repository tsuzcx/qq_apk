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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class e
  extends b
{
  private final Rect Ky;
  private MMHandler czp;
  boolean gNC;
  private Context mContext;
  private int mHeight;
  private final Paint mPaint;
  private Resources mResources;
  private int mWidth;
  int rmJ;
  private float ydU;
  private float ydV;
  private boolean ydW;
  private Bitmap yeA;
  private boolean yeB;
  boolean yeC;
  private String yeD;
  int yeE;
  private k yeF;
  private long yeh;
  private final Runnable yep;
  private final Runnable yeq;
  private volatile boolean yew;
  private int yex;
  private int yey;
  private int[] yez;
  
  public e(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, int paramInt, int[] paramArrayOfInt, String paramString)
  {
    AppMethodBeat.i(104644);
    this.yew = false;
    this.rmJ = 0;
    this.yeA = null;
    this.yeB = false;
    this.gNC = true;
    this.yeC = true;
    this.yeE = 0;
    this.ydU = 1.0F;
    this.ydV = 1.0F;
    this.Ky = new Rect();
    this.mPaint = new Paint(6);
    this.czp = new MMHandler(Looper.getMainLooper());
    this.yeh = 0L;
    this.yeq = new Runnable()
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
    this.yep = new Runnable()
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
    this.yeB = false;
    this.gNC = paramBoolean1;
    this.yeC = paramBoolean2;
    this.yeD = paramString;
    this.yey = paramInt;
    this.yez = paramArrayOfInt;
    if (!paramBoolean1)
    {
      this.yeA = OG(aBe(paramString));
      this.mWidth = this.yeA.getWidth();
      this.mHeight = this.yeA.getHeight();
      if (this.yez.length != 3) {
        break label254;
      }
    }
    label254:
    for (this.yex = 300;; this.yex = 100)
    {
      this.yeE = 0;
      AppMethodBeat.o(104644);
      return;
      this.yeA = OG(this.yez[0]);
      break;
    }
  }
  
  private Bitmap OG(int paramInt)
  {
    AppMethodBeat.i(104651);
    Bitmap localBitmap = BitmapFactory.decodeResource(this.mResources, paramInt);
    AppMethodBeat.o(104651);
    return localBitmap;
  }
  
  private int aBe(String paramString)
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
    this.yeh = (SystemClock.uptimeMillis() + paramLong);
    if (this.czp != null) {
      this.czp.postDelayed(paramRunnable, paramLong);
    }
    AppMethodBeat.o(104646);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(104645);
    if (this.ydW)
    {
      this.Ky.set(getBounds());
      this.ydU = (this.Ky.width() / this.mWidth);
      this.ydV = (this.Ky.height() / this.mHeight);
      this.ydW = false;
    }
    if (this.mPaint.getShader() == null)
    {
      paramCanvas.scale(this.ydU, this.ydV);
      if (this.yeB)
      {
        this.yeA = OG(this.yey);
        if ((this.yeA != null) && (!this.yeA.isRecycled()))
        {
          paramCanvas.drawBitmap(this.yeA, 0.0F, 0.0F, this.mPaint);
          AppMethodBeat.o(104645);
        }
      }
      else if (!this.gNC)
      {
        this.yeA = OG(aBe(this.yeD));
        if ((this.yeA != null) && (!this.yeA.isRecycled()))
        {
          paramCanvas.drawBitmap(this.yeA, 0.0F, 0.0F, this.mPaint);
          AppMethodBeat.o(104645);
        }
      }
      else
      {
        this.yeA = OG(this.yez[this.rmJ]);
        if ((this.yeA != null) && (!this.yeA.isRecycled())) {
          paramCanvas.drawBitmap(this.yeA, 0.0F, 0.0F, this.mPaint);
        }
        this.rmJ += 1;
        if (this.yeE < 3)
        {
          if (this.rmJ >= this.yez.length)
          {
            this.rmJ = 0;
            if (this.yeC) {
              break label316;
            }
          }
          label316:
          for (this.yeE = 0;; this.yeE += 1)
          {
            l(this.yeq, this.yex);
            AppMethodBeat.o(104645);
            return;
          }
        }
        this.gNC = false;
        l(this.yeq, this.yex);
        l(this.yep, 0L);
        AppMethodBeat.o(104645);
      }
    }
    else
    {
      Log.i("MicroMsg.GIF.MMGIFGameDrawable", "shader is not null.");
      paramCanvas.drawRect(this.Ky, this.mPaint);
    }
    AppMethodBeat.o(104645);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(104653);
    this.yeF = null;
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
    return this.yew;
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    AppMethodBeat.i(104649);
    super.onBoundsChange(paramRect);
    this.ydW = true;
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
    this.yew = true;
    this.czp.post(this.yeq);
    AppMethodBeat.o(104650);
  }
  
  public final void stop()
  {
    this.yew = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.e
 * JD-Core Version:    0.7.0.1
 */