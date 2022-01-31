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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

public final class e
  extends b
{
  private final Rect Bc;
  private ak loX;
  int lrL;
  private Context mContext;
  private int mHeight;
  boolean mIsPlaying;
  private final Paint mPaint;
  private Resources mResources;
  private int mWidth;
  private final Runnable nFA;
  private final Runnable nFB;
  private volatile boolean nFH;
  private int nFI;
  private int nFJ;
  private int[] nFK;
  private Bitmap nFL;
  private boolean nFM;
  boolean nFN;
  private String nFO;
  int nFP;
  private k nFQ;
  private float nFi;
  private float nFj;
  private boolean nFk;
  private long nFt;
  
  public e(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, int paramInt, int[] paramArrayOfInt, String paramString)
  {
    AppMethodBeat.i(62410);
    this.nFH = false;
    this.lrL = 0;
    this.nFL = null;
    this.nFM = false;
    this.mIsPlaying = true;
    this.nFN = true;
    this.nFP = 0;
    this.nFi = 1.0F;
    this.nFj = 1.0F;
    this.Bc = new Rect();
    this.mPaint = new Paint(6);
    this.loX = new ak(Looper.getMainLooper());
    this.nFt = 0L;
    this.nFB = new e.1(this);
    this.nFA = new e.2(this);
    this.mContext = paramContext;
    this.mResources = this.mContext.getResources();
    this.nFM = false;
    this.mIsPlaying = paramBoolean1;
    this.nFN = paramBoolean2;
    this.nFO = paramString;
    this.nFJ = paramInt;
    this.nFK = paramArrayOfInt;
    if (!paramBoolean1)
    {
      this.nFL = xp(QH(paramString));
      this.mWidth = this.nFL.getWidth();
      this.mHeight = this.nFL.getHeight();
      if (this.nFK.length != 3) {
        break label254;
      }
    }
    label254:
    for (this.nFI = 300;; this.nFI = 100)
    {
      this.nFP = 0;
      AppMethodBeat.o(62410);
      return;
      this.nFL = xp(this.nFK[0]);
      break;
    }
  }
  
  private int QH(String paramString)
  {
    AppMethodBeat.i(62418);
    paramString = paramString.split("\\.")[0];
    int i = this.mResources.getIdentifier(paramString, "drawable", this.mContext.getPackageName());
    AppMethodBeat.o(62418);
    return i;
  }
  
  private void m(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(62412);
    this.nFt = (SystemClock.uptimeMillis() + paramLong);
    if (this.loX != null) {
      this.loX.postDelayed(paramRunnable, paramLong);
    }
    AppMethodBeat.o(62412);
  }
  
  private Bitmap xp(int paramInt)
  {
    AppMethodBeat.i(62417);
    Bitmap localBitmap = BitmapFactory.decodeResource(this.mResources, paramInt);
    AppMethodBeat.o(62417);
    return localBitmap;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(62411);
    if (this.nFk)
    {
      this.Bc.set(getBounds());
      this.nFi = (this.Bc.width() / this.mWidth);
      this.nFj = (this.Bc.height() / this.mHeight);
      this.nFk = false;
    }
    if (this.mPaint.getShader() == null)
    {
      paramCanvas.scale(this.nFi, this.nFj);
      if (this.nFM)
      {
        this.nFL = xp(this.nFJ);
        if ((this.nFL != null) && (!this.nFL.isRecycled()))
        {
          paramCanvas.drawBitmap(this.nFL, 0.0F, 0.0F, this.mPaint);
          AppMethodBeat.o(62411);
        }
      }
      else if (!this.mIsPlaying)
      {
        this.nFL = xp(QH(this.nFO));
        if ((this.nFL != null) && (!this.nFL.isRecycled()))
        {
          paramCanvas.drawBitmap(this.nFL, 0.0F, 0.0F, this.mPaint);
          AppMethodBeat.o(62411);
        }
      }
      else
      {
        this.nFL = xp(this.nFK[this.lrL]);
        if ((this.nFL != null) && (!this.nFL.isRecycled())) {
          paramCanvas.drawBitmap(this.nFL, 0.0F, 0.0F, this.mPaint);
        }
        this.lrL += 1;
        if (this.nFP < 3)
        {
          if (this.lrL >= this.nFK.length)
          {
            this.lrL = 0;
            if (this.nFN) {
              break label316;
            }
          }
          label316:
          for (this.nFP = 0;; this.nFP += 1)
          {
            m(this.nFB, this.nFI);
            AppMethodBeat.o(62411);
            return;
          }
        }
        this.mIsPlaying = false;
        m(this.nFB, this.nFI);
        m(this.nFA, 0L);
        AppMethodBeat.o(62411);
      }
    }
    else
    {
      ab.i("MicroMsg.GIF.MMGIFGameDrawable", "shader is not null.");
      paramCanvas.drawRect(this.Bc, this.mPaint);
    }
    AppMethodBeat.o(62411);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(62419);
    this.nFQ = null;
    super.finalize();
    AppMethodBeat.o(62419);
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
    return this.nFH;
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    AppMethodBeat.i(62415);
    super.onBoundsChange(paramRect);
    this.nFk = true;
    AppMethodBeat.o(62415);
  }
  
  public final void pause() {}
  
  public final void recycle() {}
  
  public final void reset() {}
  
  public final void resume() {}
  
  public final void setAlpha(int paramInt)
  {
    AppMethodBeat.i(62413);
    this.mPaint.setAlpha(paramInt);
    AppMethodBeat.o(62413);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(62414);
    this.mPaint.setColorFilter(paramColorFilter);
    AppMethodBeat.o(62414);
  }
  
  public final void start()
  {
    AppMethodBeat.i(62416);
    this.nFH = true;
    this.loX.post(this.nFB);
    AppMethodBeat.o(62416);
  }
  
  public final void stop()
  {
    this.nFH = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.e
 * JD-Core Version:    0.7.0.1
 */