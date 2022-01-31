package com.tencent.mm.plugin.gif;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.plugin.l.a.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;

public final class h
  extends b
{
  private final Rect Aq = new Rect();
  private int dmY;
  private ah jge = new ah();
  private boolean lhI = false;
  private int[] lhL = new int[4];
  private float lhM = 1.0F;
  private float lhN = 1.0F;
  private boolean lhO;
  private int lhQ = 0;
  private int lhR = -1;
  private long lhS = 0L;
  private long lhT = 0L;
  private long lhU = 0L;
  private long lhV = 0L;
  private long lhW;
  private long lhX = 0L;
  private int[] liA = new int[4];
  private Bitmap liB;
  private boolean liC = false;
  private boolean lie = true;
  private final Runnable lig = new h.1(this);
  private final Runnable lih = new Runnable()
  {
    public final void run()
    {
      h.a(h.this, h.e(h.this), h.f(h.this));
    }
  };
  private final Runnable lii = new h.3(this);
  private final Runnable lik = new h.4(this);
  private volatile long liz;
  private float mDensity;
  private int mHeight;
  private boolean mIsRunning = false;
  private final Paint mPaint = new Paint(6);
  private int mWidth;
  
  public h(String paramString)
  {
    this(e.c(paramString, 0, (int)e.aeQ(paramString)));
  }
  
  public h(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      throw new NullPointerException("bytes is null.");
    }
    boolean bool = WXHardCoderJNI.hcGifEnable;
    int j = WXHardCoderJNI.hcGifDelay;
    int k = WXHardCoderJNI.hcGifCPU;
    int m = WXHardCoderJNI.hcGifIO;
    if (WXHardCoderJNI.hcGifThr) {}
    for (int i = Process.myTid();; i = 0)
    {
      this.dmY = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, "MicroMsg.GIF.MMWXGFDrawable");
      this.liz = MMWXGFJNI.nativeInitWxAMDecoder();
      if ((this.liz != 0L) && (this.liz != -901L)) {
        break;
      }
      y.w("MicroMsg.GIF.MMWXGFDrawable", "Cpan init wxam decoder failed. mWXGFJNIHandle:%d", new Object[] { Long.valueOf(this.liz) });
      if (this.liz == -901L) {
        com.tencent.mm.plugin.report.service.h.nFQ.a(711L, 5L, 1L, false);
      }
      com.tencent.mm.plugin.report.service.h.nFQ.a(711L, 4L, 1L, false);
      throw new MMGIFException(201);
    }
    i = MMWXGFJNI.nativeDecodeBufferHeader(this.liz, paramArrayOfByte, paramArrayOfByte.length);
    if (i != 0)
    {
      y.w("MicroMsg.GIF.MMWXGFDrawable", "Cpan WXGF decode buffer header failed. result:%d", new Object[] { Integer.valueOf(i) });
      if (i == -904) {
        com.tencent.mm.plugin.report.service.h.nFQ.a(711L, 8L, 1L, false);
      }
      for (;;)
      {
        throw new MMGIFException(i);
        com.tencent.mm.plugin.report.service.h.nFQ.a(711L, 3L, 1L, false);
      }
    }
    i = MMWXGFJNI.nativeGetOption(this.liz, paramArrayOfByte, paramArrayOfByte.length, this.lhL);
    if (i != 0)
    {
      y.w("MicroMsg.GIF.MMWXGFDrawable", "Cpan WXGF get option failed. result:%d", new Object[] { Integer.valueOf(i) });
      if (i == -903) {
        com.tencent.mm.plugin.report.service.h.nFQ.a(711L, 7L, 1L, false);
      }
      for (;;)
      {
        throw new MMGIFException(i);
        com.tencent.mm.plugin.report.service.h.nFQ.a(711L, 3L, 1L, false);
      }
    }
    this.lhQ = this.lhL[0];
    this.mWidth = this.lhL[1];
    this.mHeight = this.lhL[2];
    if ((this.mWidth == 0) || (this.mHeight == 0))
    {
      i = com.tencent.mm.cb.a.aa(ae.getContext(), a.c.emoji_view_image_size);
      this.mHeight = i;
      this.mWidth = i;
    }
    this.liB = Bitmap.createBitmap(this.mWidth, this.mHeight, Bitmap.Config.ARGB_8888);
  }
  
  private void i(Runnable paramRunnable, long paramLong)
  {
    this.lhX = (SystemClock.uptimeMillis() + paramLong);
    if (this.jge != null) {
      this.jge.postAtTime(paramRunnable, this.lhX);
    }
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
      if (this.lhV == 0L) {
        this.lhV = System.currentTimeMillis();
      }
      paramCanvas.scale(this.lhM, this.lhN);
      if ((this.liB != null) && (!this.liB.isRecycled()) && (!this.lhI)) {
        paramCanvas.drawBitmap(this.liB, 0.0F, 0.0F, this.mPaint);
      }
      for (;;)
      {
        this.lhW = (System.currentTimeMillis() - this.lhV);
        if (this.lie)
        {
          com.tencent.mm.ar.a.f(this.lik, 0L);
          this.lie = false;
        }
        return;
        y.e("MicroMsg.GIF.MMWXGFDrawable", "Cpan draw bitmap failed. Bitmap buffer is null or recycle");
      }
    }
    paramCanvas.drawRect(this.Aq, this.mPaint);
  }
  
  protected final void finalize()
  {
    try
    {
      recycle();
      return;
    }
    catch (Throwable localThrowable)
    {
      y.printErrStackTrace("MicroMsg.GIF.MMWXGFDrawable", localThrowable, "", new Object[0]);
      super.finalize();
    }
  }
  
  public final float getEmojiDensityScale()
  {
    if (this.mDensity == 0.0F)
    {
      this.mDensity = (com.tencent.mm.cb.a.getDensity(ae.getContext()) / 2.0F);
      if (this.mDensity >= 1.0F) {
        break label40;
      }
      this.mDensity = 1.0F;
    }
    for (;;)
    {
      return this.mDensity;
      label40:
      if (this.mDensity > 2.0F) {
        this.mDensity = 2.0F;
      }
    }
  }
  
  public final int getIntrinsicHeight()
  {
    return (int)(this.mHeight * getEmojiDensityScale());
  }
  
  public final int getIntrinsicWidth()
  {
    return (int)(this.mWidth * getEmojiDensityScale());
  }
  
  public final int getOpacity()
  {
    return -2;
  }
  
  public final boolean isRunning()
  {
    return this.mIsRunning;
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.lhO = true;
  }
  
  public final void pause()
  {
    this.mIsRunning = false;
  }
  
  public final void recycle()
  {
    try
    {
      y.v("MicroMsg.GIF.MMWXGFDrawable", "Cpan recycle decode handle:%d", new Object[] { Long.valueOf(this.liz) });
      this.lhI = true;
      this.mIsRunning = false;
      long l = this.liz;
      this.liz = 0L;
      this.jge.removeCallbacks(this.lig);
      int i = MMWXGFJNI.nativeUninit(l);
      if (i == -906) {
        com.tencent.mm.plugin.report.service.h.nFQ.a(401L, 10L, 1L, false);
      }
      y.d("MicroMsg.GIF.MMWXGFDrawable", "nativeUninit result:%d mWXGFJNIHandle:%s mIsRender:%b", new Object[] { Integer.valueOf(i), Long.valueOf(l), Boolean.valueOf(this.liC) });
      if ((l != 0L) && (i == 0) && (this.liB != null)) {
        this.liB.isRecycled();
      }
      this.liB = null;
      return;
    }
    finally {}
  }
  
  public final void reset()
  {
    this.mIsRunning = true;
    com.tencent.mm.ar.a.f(this.lii, 0L);
  }
  
  public final void resume()
  {
    if (!this.lhI)
    {
      this.mIsRunning = true;
      i(this.lig, 0L);
    }
  }
  
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
    this.mIsRunning = true;
    com.tencent.mm.ar.a.f(this.lih, 0L);
  }
  
  public final void stop()
  {
    boolean bool2 = true;
    this.mIsRunning = false;
    if (this.dmY != 0)
    {
      y.i("MicroMsg.GIF.MMWXGFDrawable", "summerhardcoder stopPerformace startPerformance:%x ", new Object[] { Integer.valueOf(this.dmY) });
      bool1 = bool2;
      if (!WXHardCoderJNI.hcGifEnable) {
        if (!WXHardCoderJNI.hcGifFrameEnable) {
          break label67;
        }
      }
    }
    label67:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      WXHardCoderJNI.stopPerformace(bool1, this.dmY);
      this.dmY = 0;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.h
 * JD-Core Version:    0.7.0.1
 */