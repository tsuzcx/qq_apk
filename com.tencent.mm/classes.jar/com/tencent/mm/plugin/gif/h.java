package com.tencent.mm.plugin.gif;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.vfs.e;

public final class h
  extends b
{
  private final Rect Bc;
  private Bitmap[] bitmaps;
  private int eez;
  private ak loX;
  private float mDensity;
  private int mHeight;
  private boolean mIsRunning;
  private final Paint mPaint;
  private int mWidth;
  private final Runnable nFB;
  private final Runnable nFC;
  private final Runnable nFD;
  private final Runnable nFF;
  private volatile long nFU;
  private int[] nFV;
  private int nFW;
  private boolean nFX;
  private boolean nFe;
  private int[] nFh;
  private float nFi;
  private float nFj;
  private boolean nFk;
  private int nFm;
  private int nFn;
  private long nFo;
  private long nFp;
  private long nFq;
  private long nFr;
  private long nFs;
  private long nFt;
  private boolean nFz;
  
  public h(String paramString)
  {
    this(e.i(paramString, 0, (int)e.avI(paramString)));
    AppMethodBeat.i(62430);
    AppMethodBeat.o(62430);
  }
  
  public h(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62431);
    this.mIsRunning = false;
    this.nFe = false;
    this.nFh = new int[4];
    this.nFV = new int[4];
    this.nFi = 1.0F;
    this.nFj = 1.0F;
    this.Bc = new Rect();
    this.mPaint = new Paint(6);
    this.nFW = 0;
    this.nFm = 0;
    this.nFn = -1;
    this.nFo = 0L;
    this.nFp = 0L;
    this.nFq = 0L;
    this.nFr = 0L;
    this.nFt = 0L;
    this.nFX = false;
    this.loX = new ak(Looper.getMainLooper());
    this.nFz = true;
    this.nFB = new h.1(this);
    this.nFC = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(62426);
        h.a(h.this, h.e(h.this), h.f(h.this));
        AppMethodBeat.o(62426);
      }
    };
    this.nFD = new h.3(this);
    this.nFF = new h.4(this);
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = new NullPointerException("bytes is null.");
      AppMethodBeat.o(62431);
      throw paramArrayOfByte;
    }
    boolean bool = WXHardCoderJNI.hcGifEnable;
    int j = WXHardCoderJNI.hcGifDelay;
    int k = WXHardCoderJNI.hcGifCPU;
    int m = WXHardCoderJNI.hcGifIO;
    if (WXHardCoderJNI.hcGifThr) {}
    for (int i = Process.myTid();; i = 0)
    {
      this.eez = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, "MicroMsg.GIF.MMWXGFDrawable");
      this.nFU = MMWXGFJNI.nativeInitWxAMDecoder();
      if ((this.nFU != 0L) && (this.nFU != -901L)) {
        break;
      }
      ab.w("MicroMsg.GIF.MMWXGFDrawable", "Cpan init wxam decoder failed. mWXGFJNIHandle:%d", new Object[] { Long.valueOf(this.nFU) });
      if (this.nFU == -901L) {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(711L, 5L, 1L, false);
      }
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(711L, 4L, 1L, false);
      paramArrayOfByte = new MMGIFException(201);
      AppMethodBeat.o(62431);
      throw paramArrayOfByte;
    }
    i = MMWXGFJNI.nativeDecodeBufferHeader(this.nFU, paramArrayOfByte, paramArrayOfByte.length);
    if (i != 0)
    {
      ab.w("MicroMsg.GIF.MMWXGFDrawable", "Cpan WXGF decode buffer header failed. result:%d", new Object[] { Integer.valueOf(i) });
      if (i == -904) {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(711L, 8L, 1L, false);
      }
      for (;;)
      {
        paramArrayOfByte = new MMGIFException(i);
        AppMethodBeat.o(62431);
        throw paramArrayOfByte;
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(711L, 3L, 1L, false);
      }
    }
    i = MMWXGFJNI.nativeGetOption(this.nFU, paramArrayOfByte, paramArrayOfByte.length, this.nFh);
    if (i != 0)
    {
      ab.w("MicroMsg.GIF.MMWXGFDrawable", "Cpan WXGF get option failed. result:%d", new Object[] { Integer.valueOf(i) });
      if (i == -903) {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(711L, 7L, 1L, false);
      }
      for (;;)
      {
        paramArrayOfByte = new MMGIFException(i);
        AppMethodBeat.o(62431);
        throw paramArrayOfByte;
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(711L, 3L, 1L, false);
      }
    }
    this.nFm = this.nFh[0];
    this.mWidth = this.nFh[1];
    this.mHeight = this.nFh[2];
    if ((this.mWidth == 0) || (this.mHeight == 0))
    {
      i = com.tencent.mm.cb.a.ao(ah.getContext(), 2131428398);
      this.mHeight = i;
      this.mWidth = i;
    }
    this.bitmaps = new Bitmap[2];
    AppMethodBeat.o(62431);
  }
  
  private void m(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(62429);
    this.nFt = (SystemClock.uptimeMillis() + paramLong);
    if (this.loX != null) {
      this.loX.postAtTime(paramRunnable, this.nFt);
    }
    AppMethodBeat.o(62429);
  }
  
  public final int bHL()
  {
    return this.nFh[1];
  }
  
  public final int bHM()
  {
    return this.nFh[2];
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(62436);
    if (this.nFk)
    {
      this.Bc.set(getBounds());
      this.nFi = (this.Bc.width() / this.mWidth);
      this.nFj = (this.Bc.height() / this.mHeight);
      this.nFk = false;
    }
    if (this.mPaint.getShader() == null)
    {
      if (this.nFr == 0L) {
        this.nFr = System.currentTimeMillis();
      }
      paramCanvas.scale(this.nFi, this.nFj);
      if (this.nFz) {
        this.nFW = ((this.nFW + 1) % this.bitmaps.length);
      }
      Bitmap localBitmap = this.bitmaps[this.nFW];
      if ((localBitmap != null) && (!localBitmap.isRecycled()) && (!this.nFe)) {
        paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, this.mPaint);
      }
      for (;;)
      {
        this.nFs = (System.currentTimeMillis() - this.nFr);
        if (this.nFz)
        {
          com.tencent.mm.as.a.i(this.nFF, 0L);
          this.nFz = false;
        }
        AppMethodBeat.o(62436);
        return;
        ab.e("MicroMsg.GIF.MMWXGFDrawable", "Cpan draw bitmap failed. Bitmap buffer is null or recycle");
      }
    }
    paramCanvas.drawRect(this.Bc, this.mPaint);
    AppMethodBeat.o(62436);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(62441);
    try
    {
      recycle();
      AppMethodBeat.o(62441);
      return;
    }
    catch (Throwable localThrowable)
    {
      ab.printErrStackTrace("MicroMsg.GIF.MMWXGFDrawable", localThrowable, "", new Object[0]);
      super.finalize();
      AppMethodBeat.o(62441);
    }
  }
  
  public final float getEmojiDensityScale()
  {
    AppMethodBeat.i(62432);
    if (this.mDensity == 0.0F)
    {
      this.mDensity = (com.tencent.mm.cb.a.getDensity(ah.getContext()) / 2.0F);
      if (this.mDensity >= 1.0F) {
        break label54;
      }
      this.mDensity = 1.0F;
    }
    for (;;)
    {
      float f = this.mDensity;
      AppMethodBeat.o(62432);
      return f;
      label54:
      if (this.mDensity > 2.0F) {
        this.mDensity = 2.0F;
      }
    }
  }
  
  public final int getIntrinsicHeight()
  {
    AppMethodBeat.i(62434);
    int i = (int)(this.mHeight * getEmojiDensityScale());
    AppMethodBeat.o(62434);
    return i;
  }
  
  public final int getIntrinsicWidth()
  {
    AppMethodBeat.i(62433);
    int i = (int)(this.mWidth * getEmojiDensityScale());
    AppMethodBeat.o(62433);
    return i;
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
    AppMethodBeat.i(62435);
    super.onBoundsChange(paramRect);
    this.nFk = true;
    AppMethodBeat.o(62435);
  }
  
  public final void pause()
  {
    this.mIsRunning = false;
  }
  
  public final void recycle()
  {
    try
    {
      AppMethodBeat.i(62444);
      ab.v("MicroMsg.GIF.MMWXGFDrawable", "Cpan recycle decode handle:%d", new Object[] { Long.valueOf(this.nFU) });
      this.nFe = true;
      this.mIsRunning = false;
      long l = this.nFU;
      this.nFU = 0L;
      this.loX.removeCallbacks(this.nFB);
      int i = MMWXGFJNI.nativeUninit(l);
      if (i == -906) {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(401L, 10L, 1L, false);
      }
      ab.d("MicroMsg.GIF.MMWXGFDrawable", "nativeUninit result:%d mWXGFJNIHandle:%s mIsRender:%b", new Object[] { Integer.valueOf(i), Long.valueOf(l), Boolean.valueOf(this.nFX) });
      this.bitmaps = null;
      AppMethodBeat.o(62444);
      return;
    }
    finally {}
  }
  
  public final void reset()
  {
    AppMethodBeat.i(62443);
    this.mIsRunning = true;
    com.tencent.mm.as.a.i(this.nFD, 0L);
    AppMethodBeat.o(62443);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(62442);
    if (!this.nFe)
    {
      this.mIsRunning = true;
      m(this.nFB, 0L);
    }
    AppMethodBeat.o(62442);
  }
  
  public final void setAlpha(int paramInt)
  {
    AppMethodBeat.i(62437);
    this.mPaint.setAlpha(paramInt);
    AppMethodBeat.o(62437);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(62438);
    this.mPaint.setColorFilter(paramColorFilter);
    AppMethodBeat.o(62438);
  }
  
  public final void start()
  {
    AppMethodBeat.i(62439);
    this.mIsRunning = true;
    com.tencent.mm.as.a.i(this.nFC, 0L);
    AppMethodBeat.o(62439);
  }
  
  public final void stop()
  {
    boolean bool2 = true;
    AppMethodBeat.i(62440);
    this.mIsRunning = false;
    if (this.eez != 0)
    {
      ab.i("MicroMsg.GIF.MMWXGFDrawable", "summerhardcoder stopPerformance startPerformance:%x ", new Object[] { Integer.valueOf(this.eez) });
      bool1 = bool2;
      if (!WXHardCoderJNI.hcGifEnable) {
        if (!WXHardCoderJNI.hcGifFrameEnable) {
          break label79;
        }
      }
    }
    label79:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      WXHardCoderJNI.stopPerformance(bool1, this.eez);
      this.eez = 0;
      AppMethodBeat.o(62440);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.h
 * JD-Core Version:    0.7.0.1
 */