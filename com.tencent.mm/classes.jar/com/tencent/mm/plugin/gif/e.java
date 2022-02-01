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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;

public final class e
  extends b
{
  private final Rect Iw;
  private ao gqT;
  private Context mContext;
  private int mHeight;
  boolean mIsPlaying;
  private final Paint mPaint;
  private Resources mResources;
  private int mWidth;
  int plF;
  private final Runnable txG;
  private final Runnable txH;
  private volatile boolean txN;
  private int txO;
  private int txP;
  private int[] txQ;
  private Bitmap txR;
  private boolean txS;
  boolean txT;
  private String txU;
  int txV;
  private k txW;
  private float txl;
  private float txm;
  private boolean txn;
  private long txy;
  
  public e(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, int paramInt, int[] paramArrayOfInt, String paramString)
  {
    AppMethodBeat.i(104644);
    this.txN = false;
    this.plF = 0;
    this.txR = null;
    this.txS = false;
    this.mIsPlaying = true;
    this.txT = true;
    this.txV = 0;
    this.txl = 1.0F;
    this.txm = 1.0F;
    this.Iw = new Rect();
    this.mPaint = new Paint(6);
    this.gqT = new ao(Looper.getMainLooper());
    this.txy = 0L;
    this.txH = new Runnable()
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
    this.txG = new Runnable()
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
    this.txS = false;
    this.mIsPlaying = paramBoolean1;
    this.txT = paramBoolean2;
    this.txU = paramString;
    this.txP = paramInt;
    this.txQ = paramArrayOfInt;
    if (!paramBoolean1)
    {
      this.txR = GL(ahX(paramString));
      this.mWidth = this.txR.getWidth();
      this.mHeight = this.txR.getHeight();
      if (this.txQ.length != 3) {
        break label254;
      }
    }
    label254:
    for (this.txO = 300;; this.txO = 100)
    {
      this.txV = 0;
      AppMethodBeat.o(104644);
      return;
      this.txR = GL(this.txQ[0]);
      break;
    }
  }
  
  private Bitmap GL(int paramInt)
  {
    AppMethodBeat.i(104651);
    Bitmap localBitmap = BitmapFactory.decodeResource(this.mResources, paramInt);
    AppMethodBeat.o(104651);
    return localBitmap;
  }
  
  private int ahX(String paramString)
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
    this.txy = (SystemClock.uptimeMillis() + paramLong);
    if (this.gqT != null) {
      this.gqT.postDelayed(paramRunnable, paramLong);
    }
    AppMethodBeat.o(104646);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(104645);
    if (this.txn)
    {
      this.Iw.set(getBounds());
      this.txl = (this.Iw.width() / this.mWidth);
      this.txm = (this.Iw.height() / this.mHeight);
      this.txn = false;
    }
    if (this.mPaint.getShader() == null)
    {
      paramCanvas.scale(this.txl, this.txm);
      if (this.txS)
      {
        this.txR = GL(this.txP);
        if ((this.txR != null) && (!this.txR.isRecycled()))
        {
          paramCanvas.drawBitmap(this.txR, 0.0F, 0.0F, this.mPaint);
          AppMethodBeat.o(104645);
        }
      }
      else if (!this.mIsPlaying)
      {
        this.txR = GL(ahX(this.txU));
        if ((this.txR != null) && (!this.txR.isRecycled()))
        {
          paramCanvas.drawBitmap(this.txR, 0.0F, 0.0F, this.mPaint);
          AppMethodBeat.o(104645);
        }
      }
      else
      {
        this.txR = GL(this.txQ[this.plF]);
        if ((this.txR != null) && (!this.txR.isRecycled())) {
          paramCanvas.drawBitmap(this.txR, 0.0F, 0.0F, this.mPaint);
        }
        this.plF += 1;
        if (this.txV < 3)
        {
          if (this.plF >= this.txQ.length)
          {
            this.plF = 0;
            if (this.txT) {
              break label316;
            }
          }
          label316:
          for (this.txV = 0;; this.txV += 1)
          {
            l(this.txH, this.txO);
            AppMethodBeat.o(104645);
            return;
          }
        }
        this.mIsPlaying = false;
        l(this.txH, this.txO);
        l(this.txG, 0L);
        AppMethodBeat.o(104645);
      }
    }
    else
    {
      ac.i("MicroMsg.GIF.MMGIFGameDrawable", "shader is not null.");
      paramCanvas.drawRect(this.Iw, this.mPaint);
    }
    AppMethodBeat.o(104645);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(104653);
    this.txW = null;
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
    return this.txN;
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    AppMethodBeat.i(104649);
    super.onBoundsChange(paramRect);
    this.txn = true;
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
    this.txN = true;
    this.gqT.post(this.txH);
    AppMethodBeat.o(104650);
  }
  
  public final void stop()
  {
    this.txN = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.e
 * JD-Core Version:    0.7.0.1
 */