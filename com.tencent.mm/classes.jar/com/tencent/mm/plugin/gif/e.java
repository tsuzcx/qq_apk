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
  private volatile boolean DnD;
  private int DnE;
  private int DnF;
  private int[] DnG;
  private Bitmap DnH;
  private boolean DnI;
  boolean DnJ;
  private String DnK;
  int DnL;
  private j DnM;
  private float Dnb;
  private float Dnc;
  private boolean Dnd;
  private long Dno;
  private final Runnable Dnw;
  private final Runnable Dnx;
  private final Rect KV;
  private MMHandler cyl;
  boolean jxX;
  private Context mContext;
  private int mHeight;
  private final Paint mPaint;
  private Resources mResources;
  private int mWidth;
  int uPV;
  
  public e(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, int paramInt, int[] paramArrayOfInt, String paramString)
  {
    AppMethodBeat.i(104644);
    this.DnD = false;
    this.uPV = 0;
    this.DnH = null;
    this.DnI = false;
    this.jxX = true;
    this.DnJ = true;
    this.DnL = 0;
    this.Dnb = 1.0F;
    this.Dnc = 1.0F;
    this.KV = new Rect();
    this.mPaint = new Paint(6);
    this.cyl = new MMHandler(Looper.getMainLooper());
    this.Dno = 0L;
    this.Dnx = new Runnable()
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
    this.Dnw = new Runnable()
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
    this.DnI = false;
    this.jxX = paramBoolean1;
    this.DnJ = paramBoolean2;
    this.DnK = paramString;
    this.DnF = paramInt;
    this.DnG = paramArrayOfInt;
    if (!paramBoolean1)
    {
      this.DnH = Ug(aKS(paramString));
      if (this.DnH == null) {
        break label261;
      }
      this.mWidth = this.DnH.getWidth();
      this.mHeight = this.DnH.getHeight();
      label217:
      if (this.DnG.length != 3) {
        break label274;
      }
    }
    label261:
    label274:
    for (this.DnE = 300;; this.DnE = 100)
    {
      this.DnL = 0;
      AppMethodBeat.o(104644);
      return;
      this.DnH = Ug(this.DnG[0]);
      break;
      this.mWidth = 1;
      this.mHeight = 1;
      break label217;
    }
  }
  
  private Bitmap Ug(int paramInt)
  {
    AppMethodBeat.i(104651);
    Bitmap localBitmap = BitmapFactory.decodeResource(this.mResources, paramInt);
    AppMethodBeat.o(104651);
    return localBitmap;
  }
  
  private int aKS(String paramString)
  {
    AppMethodBeat.i(104652);
    String str = paramString.split("\\.")[0];
    int i = this.mResources.getIdentifier(str, "drawable", this.mContext.getPackageName());
    Log.d("MicroMsg.GIF.MMGIFGameDrawable", "getResouceIdByName %s, %s, %s", new Object[] { paramString, this.mContext.getPackageName(), Integer.valueOf(i) });
    AppMethodBeat.o(104652);
    return i;
  }
  
  private void k(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(104646);
    this.Dno = (SystemClock.uptimeMillis() + paramLong);
    if (this.cyl != null) {
      this.cyl.postDelayed(paramRunnable, paramLong);
    }
    AppMethodBeat.o(104646);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(104645);
    if (this.Dnd)
    {
      this.KV.set(getBounds());
      this.Dnb = (this.KV.width() / this.mWidth);
      this.Dnc = (this.KV.height() / this.mHeight);
      this.Dnd = false;
    }
    if (this.mPaint.getShader() == null)
    {
      paramCanvas.scale(this.Dnb, this.Dnc);
      if (this.DnI)
      {
        this.DnH = Ug(this.DnF);
        if ((this.DnH != null) && (!this.DnH.isRecycled()))
        {
          paramCanvas.drawBitmap(this.DnH, 0.0F, 0.0F, this.mPaint);
          AppMethodBeat.o(104645);
        }
      }
      else if (!this.jxX)
      {
        this.DnH = Ug(aKS(this.DnK));
        if ((this.DnH != null) && (!this.DnH.isRecycled()))
        {
          paramCanvas.drawBitmap(this.DnH, 0.0F, 0.0F, this.mPaint);
          AppMethodBeat.o(104645);
        }
      }
      else
      {
        this.DnH = Ug(this.DnG[this.uPV]);
        if ((this.DnH != null) && (!this.DnH.isRecycled())) {
          paramCanvas.drawBitmap(this.DnH, 0.0F, 0.0F, this.mPaint);
        }
        this.uPV += 1;
        if (this.DnL < 3)
        {
          if (this.uPV >= this.DnG.length)
          {
            this.uPV = 0;
            if (this.DnJ) {
              break label316;
            }
          }
          label316:
          for (this.DnL = 0;; this.DnL += 1)
          {
            k(this.Dnx, this.DnE);
            AppMethodBeat.o(104645);
            return;
          }
        }
        this.jxX = false;
        k(this.Dnx, this.DnE);
        k(this.Dnw, 0L);
        AppMethodBeat.o(104645);
      }
    }
    else
    {
      Log.i("MicroMsg.GIF.MMGIFGameDrawable", "shader is not null.");
      paramCanvas.drawRect(this.KV, this.mPaint);
    }
    AppMethodBeat.o(104645);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(104653);
    this.DnM = null;
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
    return this.DnD;
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    AppMethodBeat.i(104649);
    super.onBoundsChange(paramRect);
    this.Dnd = true;
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
    this.DnD = true;
    this.cyl.post(this.Dnx);
    AppMethodBeat.o(104650);
  }
  
  public final void stop()
  {
    this.DnD = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.e
 * JD-Core Version:    0.7.0.1
 */