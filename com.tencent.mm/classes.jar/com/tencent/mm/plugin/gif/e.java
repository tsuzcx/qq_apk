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
  private float JgL;
  private float JgM;
  private boolean JgN;
  private long JgY;
  private final Runnable Jhg;
  private final Runnable Jhh;
  private volatile boolean Jhn;
  private int Jho;
  private int Jhp;
  private int[] Jhq;
  private Bitmap Jhr;
  private boolean Jhs;
  boolean Jht;
  private String Jhu;
  private j Jhv;
  private final Rect bre;
  int crG;
  private MMHandler eqE;
  private Context mContext;
  private int mHeight;
  private final Paint mPaint;
  private Resources mResources;
  private int mWidth;
  boolean qRV;
  int xYG;
  
  public e(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, int paramInt, int[] paramArrayOfInt, String paramString)
  {
    AppMethodBeat.i(104644);
    this.Jhn = false;
    this.xYG = 0;
    this.Jhr = null;
    this.Jhs = false;
    this.qRV = true;
    this.Jht = true;
    this.crG = 0;
    this.JgL = 1.0F;
    this.JgM = 1.0F;
    this.bre = new Rect();
    this.mPaint = new Paint(6);
    this.eqE = new MMHandler(Looper.getMainLooper());
    this.JgY = 0L;
    this.Jhh = new Runnable()
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
    this.Jhg = new Runnable()
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
    this.Jhs = false;
    this.qRV = paramBoolean1;
    this.Jht = paramBoolean2;
    this.Jhu = paramString;
    this.Jhp = paramInt;
    this.Jhq = paramArrayOfInt;
    if (!paramBoolean1)
    {
      this.Jhr = Yd(aHJ(paramString));
      if (this.Jhr == null) {
        break label261;
      }
      this.mWidth = this.Jhr.getWidth();
      this.mHeight = this.Jhr.getHeight();
      label217:
      if (this.Jhq.length != 3) {
        break label274;
      }
    }
    label261:
    label274:
    for (this.Jho = 300;; this.Jho = 100)
    {
      this.crG = 0;
      AppMethodBeat.o(104644);
      return;
      this.Jhr = Yd(this.Jhq[0]);
      break;
      this.mWidth = 1;
      this.mHeight = 1;
      break label217;
    }
  }
  
  private Bitmap Yd(int paramInt)
  {
    AppMethodBeat.i(104651);
    Bitmap localBitmap = BitmapFactory.decodeResource(this.mResources, paramInt);
    AppMethodBeat.o(104651);
    return localBitmap;
  }
  
  private int aHJ(String paramString)
  {
    AppMethodBeat.i(104652);
    String str = paramString.split("\\.")[0];
    int i = this.mResources.getIdentifier(str, "drawable", this.mContext.getPackageName());
    Log.d("MicroMsg.GIF.MMGIFGameDrawable", "getResouceIdByName %s, %s, %s", new Object[] { paramString, this.mContext.getPackageName(), Integer.valueOf(i) });
    AppMethodBeat.o(104652);
    return i;
  }
  
  private void l(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(104646);
    this.JgY = (SystemClock.uptimeMillis() + paramLong);
    if (this.eqE != null) {
      this.eqE.postDelayed(paramRunnable, paramLong);
    }
    AppMethodBeat.o(104646);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(104645);
    if (this.JgN)
    {
      this.bre.set(getBounds());
      this.JgL = (this.bre.width() / this.mWidth);
      this.JgM = (this.bre.height() / this.mHeight);
      this.JgN = false;
    }
    if (this.mPaint.getShader() == null)
    {
      paramCanvas.scale(this.JgL, this.JgM);
      if (this.Jhs)
      {
        this.Jhr = Yd(this.Jhp);
        if ((this.Jhr != null) && (!this.Jhr.isRecycled()))
        {
          paramCanvas.drawBitmap(this.Jhr, 0.0F, 0.0F, this.mPaint);
          AppMethodBeat.o(104645);
        }
      }
      else if (!this.qRV)
      {
        this.Jhr = Yd(aHJ(this.Jhu));
        if ((this.Jhr != null) && (!this.Jhr.isRecycled()))
        {
          paramCanvas.drawBitmap(this.Jhr, 0.0F, 0.0F, this.mPaint);
          AppMethodBeat.o(104645);
        }
      }
      else
      {
        this.Jhr = Yd(this.Jhq[this.xYG]);
        if ((this.Jhr != null) && (!this.Jhr.isRecycled())) {
          paramCanvas.drawBitmap(this.Jhr, 0.0F, 0.0F, this.mPaint);
        }
        this.xYG += 1;
        if (this.crG < 3)
        {
          if (this.xYG >= this.Jhq.length)
          {
            this.xYG = 0;
            if (this.Jht) {
              break label316;
            }
          }
          label316:
          for (this.crG = 0;; this.crG += 1)
          {
            l(this.Jhh, this.Jho);
            AppMethodBeat.o(104645);
            return;
          }
        }
        this.qRV = false;
        l(this.Jhh, this.Jho);
        l(this.Jhg, 0L);
        AppMethodBeat.o(104645);
      }
    }
    else
    {
      Log.i("MicroMsg.GIF.MMGIFGameDrawable", "shader is not null.");
      paramCanvas.drawRect(this.bre, this.mPaint);
    }
    AppMethodBeat.o(104645);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(104653);
    this.Jhv = null;
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
    return this.Jhn;
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    AppMethodBeat.i(104649);
    super.onBoundsChange(paramRect);
    this.JgN = true;
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
    this.Jhn = true;
    this.eqE.post(this.Jhh);
    AppMethodBeat.o(104650);
  }
  
  public final void stop()
  {
    this.Jhn = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.e
 * JD-Core Version:    0.7.0.1
 */