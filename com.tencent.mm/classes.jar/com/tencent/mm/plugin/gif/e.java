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
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

public final class e
  extends b
{
  private final Rect Aq = new Rect();
  private ah jge = new ah(Looper.getMainLooper());
  public int jiU = 0;
  private float lhM = 1.0F;
  private float lhN = 1.0F;
  private boolean lhO;
  private long lhX = 0L;
  private final Runnable lif = new e.2(this);
  private final Runnable lig = new e.1(this);
  private volatile boolean lim = false;
  private int lin;
  private int lio;
  private int[] lip;
  private Bitmap liq = null;
  private boolean lir = false;
  public boolean lis = true;
  private String lit;
  public int liu = 0;
  private k liv;
  private Context mContext;
  private int mHeight;
  public boolean mIsPlaying = true;
  private final Paint mPaint = new Paint(6);
  private Resources mResources;
  private int mWidth;
  
  public e(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, int paramInt, int[] paramArrayOfInt, String paramString)
  {
    this.mContext = paramContext;
    this.mResources = this.mContext.getResources();
    this.lir = false;
    this.mIsPlaying = paramBoolean1;
    this.lis = paramBoolean2;
    this.lit = paramString;
    this.lio = paramInt;
    this.lip = paramArrayOfInt;
    if (!paramBoolean1)
    {
      this.liq = sp(Fj(paramString));
      this.mWidth = this.liq.getWidth();
      this.mHeight = this.liq.getHeight();
      if (this.lip.length != 3) {
        break label244;
      }
    }
    label244:
    for (this.lin = 300;; this.lin = 100)
    {
      this.liu = 0;
      return;
      this.liq = sp(this.lip[0]);
      break;
    }
  }
  
  private int Fj(String paramString)
  {
    paramString = paramString.split("\\.")[0];
    return this.mResources.getIdentifier(paramString, "drawable", this.mContext.getPackageName());
  }
  
  private void i(Runnable paramRunnable, long paramLong)
  {
    this.lhX = (SystemClock.uptimeMillis() + paramLong);
    if (this.jge != null) {
      this.jge.postDelayed(paramRunnable, paramLong);
    }
  }
  
  private Bitmap sp(int paramInt)
  {
    return BitmapFactory.decodeResource(this.mResources, paramInt);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    if (this.lhO)
    {
      this.Aq.set(getBounds());
      this.lhM = (this.Aq.width() / this.mWidth);
      this.lhN = (this.Aq.height() / this.mHeight);
      this.lhO = false;
    }
    if (this.mPaint.getShader() == null)
    {
      paramCanvas.scale(this.lhM, this.lhN);
      if (this.lir)
      {
        this.liq = sp(this.lio);
        if ((this.liq != null) && (!this.liq.isRecycled())) {
          paramCanvas.drawBitmap(this.liq, 0.0F, 0.0F, this.mPaint);
        }
      }
      do
      {
        return;
        if (this.mIsPlaying) {
          break;
        }
        this.liq = sp(Fj(this.lit));
      } while ((this.liq == null) || (this.liq.isRecycled()));
      paramCanvas.drawBitmap(this.liq, 0.0F, 0.0F, this.mPaint);
      return;
      this.liq = sp(this.lip[this.jiU]);
      if ((this.liq != null) && (!this.liq.isRecycled())) {
        paramCanvas.drawBitmap(this.liq, 0.0F, 0.0F, this.mPaint);
      }
      this.jiU += 1;
      if (this.liu < 3)
      {
        if (this.jiU >= this.lip.length)
        {
          this.jiU = 0;
          if (this.lis) {
            break label296;
          }
        }
        label296:
        for (this.liu = 0;; this.liu += 1)
        {
          i(this.lig, this.lin);
          return;
        }
      }
      this.mIsPlaying = false;
      i(this.lig, this.lin);
      i(this.lif, 0L);
      return;
    }
    y.i("MicroMsg.GIF.MMGIFGameDrawable", "shader is not null.");
    paramCanvas.drawRect(this.Aq, this.mPaint);
  }
  
  protected final void finalize()
  {
    this.liv = null;
    super.finalize();
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
    return this.lim;
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.lhO = true;
  }
  
  public final void pause() {}
  
  public final void recycle() {}
  
  public final void reset() {}
  
  public final void resume() {}
  
  public final void setAlpha(int paramInt)
  {
    this.mPaint.setAlpha(paramInt);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mPaint.setColorFilter(paramColorFilter);
  }
  
  public final void start()
  {
    this.lim = true;
    this.jge.post(this.lig);
  }
  
  public final void stop()
  {
    this.lim = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.e
 * JD-Core Version:    0.7.0.1
 */