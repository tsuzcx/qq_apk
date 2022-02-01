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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;

public final class e
  extends b
{
  private final Rect Ko;
  private aq gNm;
  private Context mContext;
  private int mHeight;
  boolean mIsPlaying;
  private final Paint mPaint;
  private Resources mResources;
  private int mWidth;
  int pVK;
  private float uLA;
  private float uLB;
  private boolean uLC;
  private long uLN;
  private final Runnable uLV;
  private final Runnable uLW;
  private volatile boolean uMc;
  private int uMd;
  private int uMe;
  private int[] uMf;
  private Bitmap uMg;
  private boolean uMh;
  boolean uMi;
  private String uMj;
  int uMk;
  private k uMl;
  
  public e(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, int paramInt, int[] paramArrayOfInt, String paramString)
  {
    AppMethodBeat.i(104644);
    this.uMc = false;
    this.pVK = 0;
    this.uMg = null;
    this.uMh = false;
    this.mIsPlaying = true;
    this.uMi = true;
    this.uMk = 0;
    this.uLA = 1.0F;
    this.uLB = 1.0F;
    this.Ko = new Rect();
    this.mPaint = new Paint(6);
    this.gNm = new aq(Looper.getMainLooper());
    this.uLN = 0L;
    this.uLW = new Runnable()
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
    this.uLV = new Runnable()
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
    this.uMh = false;
    this.mIsPlaying = paramBoolean1;
    this.uMi = paramBoolean2;
    this.uMj = paramString;
    this.uMe = paramInt;
    this.uMf = paramArrayOfInt;
    if (!paramBoolean1)
    {
      this.uMg = IF(anL(paramString));
      this.mWidth = this.uMg.getWidth();
      this.mHeight = this.uMg.getHeight();
      if (this.uMf.length != 3) {
        break label254;
      }
    }
    label254:
    for (this.uMd = 300;; this.uMd = 100)
    {
      this.uMk = 0;
      AppMethodBeat.o(104644);
      return;
      this.uMg = IF(this.uMf[0]);
      break;
    }
  }
  
  private Bitmap IF(int paramInt)
  {
    AppMethodBeat.i(104651);
    Bitmap localBitmap = BitmapFactory.decodeResource(this.mResources, paramInt);
    AppMethodBeat.o(104651);
    return localBitmap;
  }
  
  private int anL(String paramString)
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
    this.uLN = (SystemClock.uptimeMillis() + paramLong);
    if (this.gNm != null) {
      this.gNm.postDelayed(paramRunnable, paramLong);
    }
    AppMethodBeat.o(104646);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(104645);
    if (this.uLC)
    {
      this.Ko.set(getBounds());
      this.uLA = (this.Ko.width() / this.mWidth);
      this.uLB = (this.Ko.height() / this.mHeight);
      this.uLC = false;
    }
    if (this.mPaint.getShader() == null)
    {
      paramCanvas.scale(this.uLA, this.uLB);
      if (this.uMh)
      {
        this.uMg = IF(this.uMe);
        if ((this.uMg != null) && (!this.uMg.isRecycled()))
        {
          paramCanvas.drawBitmap(this.uMg, 0.0F, 0.0F, this.mPaint);
          AppMethodBeat.o(104645);
        }
      }
      else if (!this.mIsPlaying)
      {
        this.uMg = IF(anL(this.uMj));
        if ((this.uMg != null) && (!this.uMg.isRecycled()))
        {
          paramCanvas.drawBitmap(this.uMg, 0.0F, 0.0F, this.mPaint);
          AppMethodBeat.o(104645);
        }
      }
      else
      {
        this.uMg = IF(this.uMf[this.pVK]);
        if ((this.uMg != null) && (!this.uMg.isRecycled())) {
          paramCanvas.drawBitmap(this.uMg, 0.0F, 0.0F, this.mPaint);
        }
        this.pVK += 1;
        if (this.uMk < 3)
        {
          if (this.pVK >= this.uMf.length)
          {
            this.pVK = 0;
            if (this.uMi) {
              break label316;
            }
          }
          label316:
          for (this.uMk = 0;; this.uMk += 1)
          {
            m(this.uLW, this.uMd);
            AppMethodBeat.o(104645);
            return;
          }
        }
        this.mIsPlaying = false;
        m(this.uLW, this.uMd);
        m(this.uLV, 0L);
        AppMethodBeat.o(104645);
      }
    }
    else
    {
      ae.i("MicroMsg.GIF.MMGIFGameDrawable", "shader is not null.");
      paramCanvas.drawRect(this.Ko, this.mPaint);
    }
    AppMethodBeat.o(104645);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(104653);
    this.uMl = null;
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
    return this.uMc;
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    AppMethodBeat.i(104649);
    super.onBoundsChange(paramRect);
    this.uLC = true;
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
    this.uMc = true;
    this.gNm.post(this.uLW);
    AppMethodBeat.o(104650);
  }
  
  public final void stop()
  {
    this.uMc = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.e
 * JD-Core Version:    0.7.0.1
 */