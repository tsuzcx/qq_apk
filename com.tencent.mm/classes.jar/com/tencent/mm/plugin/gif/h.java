package com.tencent.mm.plugin.gif;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.vfs.o;

public final class h
  extends b
{
  private final Rect Ko;
  private int fMX;
  private aq gNm;
  private float mDensity;
  private int mHeight;
  private boolean mIsRunning;
  private final Paint mPaint;
  private int mWidth;
  private float uLA;
  private float uLB;
  private boolean uLC;
  private Bitmap uLE;
  private int uLG;
  private int uLH;
  private long uLI;
  private long uLJ;
  private long uLK;
  private long uLL;
  private long uLM;
  private long uLN;
  private boolean uLT;
  private final Runnable uLW;
  private final Runnable uLX;
  private final Runnable uLY;
  private boolean uLw;
  private int[] uLz;
  private final Runnable uMa;
  private volatile long uMp;
  private int[] uMq;
  private Bitmap[] uMr;
  private int uMs;
  private boolean uMt;
  
  public h(String paramString)
  {
    this(o.bb(paramString, 0, (int)o.aZR(paramString)));
    AppMethodBeat.i(104664);
    AppMethodBeat.o(104664);
  }
  
  public h(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(104666);
    this.mIsRunning = false;
    this.uLw = false;
    this.uLz = new int[4];
    this.uMq = new int[4];
    this.uLA = 1.0F;
    this.uLB = 1.0F;
    this.Ko = new Rect();
    this.mPaint = new Paint(6);
    this.uMs = 0;
    this.uLG = 0;
    this.uLH = -1;
    this.uLI = 0L;
    this.uLJ = 0L;
    this.uLK = 0L;
    this.uLL = 0L;
    this.uLN = 0L;
    this.uMt = false;
    this.gNm = new aq(Looper.getMainLooper());
    this.uLT = true;
    this.uLW = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104659);
        if ((!h.a(h.this)) && ((h.this.isRunning()) || (h.b(h.this) == 0)) && (SystemClock.uptimeMillis() >= h.c(h.this)))
        {
          h.a(h.this, System.currentTimeMillis());
          h.d(h.this);
          h.this.invalidateSelf();
        }
        AppMethodBeat.o(104659);
      }
    };
    this.uLX = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104660);
        h.a(h.this, h.e(h.this), h.f(h.this));
        AppMethodBeat.o(104660);
      }
    };
    this.uLY = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104661);
        h.a(h.this, -1);
        MMWXGFJNI.nativeRewindBuffer(h.g(h.this));
        h.a(h.this, h.e(h.this), 0L);
        AppMethodBeat.o(104661);
      }
    };
    this.uMa = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104662);
        if (h.h(h.this))
        {
          ae.d("MicroMsg.GIF.MMWXGFDrawable", "Cpan Render Task is Running.");
          AppMethodBeat.o(104662);
          return;
        }
        if (h.a(h.this))
        {
          ae.i("MicroMsg.GIF.MMWXGFDrawable", "Cpan This WXGF had been recycle.");
          AppMethodBeat.o(104662);
          return;
        }
        if (h.g(h.this) == 0L)
        {
          ae.i("MicroMsg.GIF.MMWXGFDrawable", "Cpan This WXGF JNIHandle is null.");
          g.yxI.idkeyStat(401L, 18L, 1L, false);
          AppMethodBeat.o(104662);
          return;
        }
        h.a(h.this, true);
        long l = System.currentTimeMillis();
        int i = (h.i(h.this) + 1) % h.j(h.this).length;
        Object localObject2 = h.j(h.this)[i];
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = Bitmap.createBitmap(h.k(h.this), h.l(h.this), Bitmap.Config.ARGB_8888);
          h.j(h.this)[i] = localObject1;
        }
        i = MMWXGFJNI.nativeDecodeBufferFrame(h.g(h.this), null, 0, (Bitmap)localObject1, h.m(h.this));
        if (i == -904)
        {
          ae.i("MicroMsg.GIF.MMWXGFDrawable", "nativeDecodeBufferFrame failed. func is null.");
          g.yxI.idkeyStat(401L, 8L, 1L, false);
          AppMethodBeat.o(104662);
          return;
        }
        if (i == -909)
        {
          ae.i("MicroMsg.GIF.MMWXGFDrawable", "nativeDecodeBufferFrame failed. frame is null.");
          g.yxI.idkeyStat(401L, 11L, 1L, false);
        }
        while (i != -1)
        {
          h.a(h.this, h.b(h.this) + 1);
          if ((h.b(h.this) < h.n(h.this) - 1) && (i != 1)) {
            break;
          }
          h.a(h.this, -1);
          i = MMWXGFJNI.nativeRewindBuffer(h.g(h.this));
          if (i == 0) {
            break;
          }
          if (i == -905) {
            g.yxI.idkeyStat(711L, 9L, 1L, false);
          }
          ae.w("MicroMsg.GIF.MMWXGFDrawable", "Cpan Rewind buffer failed.");
          AppMethodBeat.o(104662);
          return;
        }
        ae.i("MicroMsg.GIF.MMWXGFDrawable", "nativeDecodeBufferFrame failed.");
        AppMethodBeat.o(104662);
        return;
        h.b(h.this, System.currentTimeMillis() - l);
        boolean bool;
        if (h.o(h.this) != 0L)
        {
          h.c(h.this, h.o(h.this) - h.p(h.this) - h.q(h.this));
          if (h.f(h.this) < 0L)
          {
            ae.d("MicroMsg.GIF.MMWXGFDrawable", "Render time:%d InvalidateUseTime:%d NextRealInvalidateTime:%d mNextFrameDuration:%d mCurrentFrameIndex:%d", new Object[] { Long.valueOf(h.p(h.this)), Long.valueOf(h.q(h.this)), Long.valueOf(h.f(h.this)), Long.valueOf(h.o(h.this)), Integer.valueOf(h.b(h.this)) });
            if (h.f(h.this) < -100L)
            {
              g.yxI.idkeyStat(401L, 16L, 1L, false);
              g.yxI.idkeyStat(401L, 17L, Math.abs(h.f(h.this)), false);
              if ((!WXHardCoderJNI.hcGifEnable) && (!WXHardCoderJNI.hcGifFrameEnable)) {
                break label754;
              }
              bool = true;
              WXHardCoderJNI.stopPerformance(bool, h.r(h.this));
              localObject1 = h.this;
              bool = WXHardCoderJNI.hcGifFrameEnable;
              int j = WXHardCoderJNI.hcGifFrameDelay;
              int k = WXHardCoderJNI.hcGifFrameCPU;
              int m = WXHardCoderJNI.hcGifFrameIO;
              if (!WXHardCoderJNI.hcGifFrameThr) {
                break label760;
              }
              i = Process.myTid();
              label635:
              h.b((h)localObject1, WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcGifFrameTimeout, 602, WXHardCoderJNI.hcGifFrameAction, "MicroMsg.GIF.MMWXGFDrawable"));
            }
          }
        }
        localObject1 = h.this;
        localObject2 = h.e(h.this);
        if (h.f(h.this) > 0L)
        {
          l = h.f(h.this);
          label698:
          h.a((h)localObject1, (Runnable)localObject2, l);
          if (h.m(h.this)[0] <= 0) {
            break label771;
          }
        }
        label771:
        for (i = h.m(h.this)[0];; i = 100)
        {
          h.d(h.this, i);
          h.a(h.this, false);
          AppMethodBeat.o(104662);
          return;
          label754:
          bool = false;
          break;
          label760:
          i = 0;
          break label635;
          l = 0L;
          break label698;
        }
      }
    };
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = new NullPointerException("bytes is null.");
      AppMethodBeat.o(104666);
      throw paramArrayOfByte;
    }
    boolean bool = WXHardCoderJNI.hcGifEnable;
    int j = WXHardCoderJNI.hcGifDelay;
    int k = WXHardCoderJNI.hcGifCPU;
    int m = WXHardCoderJNI.hcGifIO;
    if (WXHardCoderJNI.hcGifThr) {}
    for (int i = Process.myTid();; i = 0)
    {
      this.fMX = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, "MicroMsg.GIF.MMWXGFDrawable");
      this.uMp = MMWXGFJNI.nativeInitWxAMDecoder();
      if ((this.uMp != 0L) && (this.uMp != -901L)) {
        break;
      }
      ae.w("MicroMsg.GIF.MMWXGFDrawable", "Cpan init wxam decoder failed. mWXGFJNIHandle:%d", new Object[] { Long.valueOf(this.uMp) });
      if (this.uMp == -901L) {
        g.yxI.idkeyStat(711L, 5L, 1L, false);
      }
      g.yxI.idkeyStat(711L, 4L, 1L, false);
      paramArrayOfByte = new MMGIFException(201);
      AppMethodBeat.o(104666);
      throw paramArrayOfByte;
    }
    i = MMWXGFJNI.nativeDecodeBufferHeader(this.uMp, paramArrayOfByte, paramArrayOfByte.length);
    if (i != 0)
    {
      ae.w("MicroMsg.GIF.MMWXGFDrawable", "Cpan WXGF decode buffer header failed. result:%d", new Object[] { Integer.valueOf(i) });
      if (i == -904) {
        g.yxI.idkeyStat(711L, 8L, 1L, false);
      }
      for (;;)
      {
        paramArrayOfByte = new MMGIFException(i);
        AppMethodBeat.o(104666);
        throw paramArrayOfByte;
        g.yxI.idkeyStat(711L, 3L, 1L, false);
      }
    }
    i = MMWXGFJNI.nativeGetOption(this.uMp, paramArrayOfByte, paramArrayOfByte.length, this.uLz);
    if (i != 0)
    {
      ae.w("MicroMsg.GIF.MMWXGFDrawable", "Cpan WXGF get option failed. result:%d", new Object[] { Integer.valueOf(i) });
      if (i == -903) {
        g.yxI.idkeyStat(711L, 7L, 1L, false);
      }
      for (;;)
      {
        paramArrayOfByte = new MMGIFException(i);
        AppMethodBeat.o(104666);
        throw paramArrayOfByte;
        g.yxI.idkeyStat(711L, 3L, 1L, false);
      }
    }
    this.uLG = this.uLz[0];
    this.mWidth = this.uLz[1];
    this.mHeight = this.uLz[2];
    if ((this.mWidth == 0) || (this.mHeight == 0))
    {
      i = com.tencent.mm.cb.a.ax(ak.getContext(), 2131166264);
      this.mHeight = i;
      this.mWidth = i;
    }
    this.uMr = new Bitmap[2];
    AppMethodBeat.o(104666);
  }
  
  public h(byte[] paramArrayOfByte, String paramString)
  {
    this(paramArrayOfByte);
    AppMethodBeat.i(104665);
    paramArrayOfByte = com.tencent.mm.emoji.loader.a.b.gla;
    if (com.tencent.mm.emoji.loader.a.b.wA(paramString) != null)
    {
      paramArrayOfByte = com.tencent.mm.emoji.loader.a.b.gla;
      this.uLE = com.tencent.mm.emoji.loader.a.b.wA(paramString);
    }
    AppMethodBeat.o(104665);
  }
  
  private void m(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(104663);
    this.uLN = (SystemClock.uptimeMillis() + paramLong);
    if (this.gNm != null) {
      this.gNm.postAtTime(paramRunnable, this.uLN);
    }
    AppMethodBeat.o(104663);
  }
  
  public final int ddP()
  {
    return this.uLz[1];
  }
  
  public final int ddQ()
  {
    return this.uLz[2];
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(104671);
    if (this.uLC)
    {
      this.Ko.set(getBounds());
      this.uLA = (this.Ko.width() / this.mWidth);
      this.uLB = (this.Ko.height() / this.mHeight);
      this.uLC = false;
    }
    if (this.mPaint.getShader() == null)
    {
      if (this.uLL == 0L) {
        this.uLL = System.currentTimeMillis();
      }
      if (this.uLT) {
        this.uMs = ((this.uMs + 1) % this.uMr.length);
      }
      Bitmap localBitmap2 = this.uMr[this.uMs];
      Bitmap localBitmap1 = localBitmap2;
      if (localBitmap2 == null)
      {
        localBitmap1 = this.uMr[((this.uMs + 1) % this.uMr.length)];
        ae.i("MicroMsg.GIF.MMWXGFDrawable", "use last decode bitmap %s  hash:[%s]", new Object[] { localBitmap1, Integer.valueOf(hashCode()) });
      }
      if ((localBitmap1 != null) && (!localBitmap1.isRecycled()) && (!this.uLw))
      {
        paramCanvas.scale(this.uLA, this.uLB);
        paramCanvas.drawBitmap(localBitmap1, 0.0F, 0.0F, this.mPaint);
      }
      for (;;)
      {
        this.uLM = (System.currentTimeMillis() - this.uLL);
        if (this.uLT)
        {
          com.tencent.mm.au.a.h(this.uMa, 0L);
          this.uLT = false;
        }
        AppMethodBeat.o(104671);
        return;
        if (this.uLE != null)
        {
          paramCanvas.scale(this.Ko.width() / this.uLE.getWidth(), this.Ko.width() / this.uLE.getHeight());
          paramCanvas.drawBitmap(this.uLE, 0.0F, 0.0F, this.mPaint);
        }
        else
        {
          ae.e("MicroMsg.GIF.MMWXGFDrawable", "Cpan draw bitmap failed. Bitmap buffer is null or recycle %s", new Object[] { Integer.valueOf(hashCode()) });
        }
      }
    }
    paramCanvas.drawRect(this.Ko, this.mPaint);
    AppMethodBeat.o(104671);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(104676);
    try
    {
      recycle();
      AppMethodBeat.o(104676);
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.printErrStackTrace("MicroMsg.GIF.MMWXGFDrawable", localThrowable, "", new Object[0]);
      super.finalize();
      AppMethodBeat.o(104676);
    }
  }
  
  public final float getEmojiDensityScale()
  {
    AppMethodBeat.i(104667);
    if (this.mDensity == 0.0F)
    {
      this.mDensity = (com.tencent.mm.cb.a.getDensity(ak.getContext()) / 2.0F);
      if (this.mDensity >= 1.0F) {
        break label54;
      }
      this.mDensity = 1.0F;
    }
    for (;;)
    {
      float f = this.mDensity;
      AppMethodBeat.o(104667);
      return f;
      label54:
      if (this.mDensity > 2.0F) {
        this.mDensity = 2.0F;
      }
    }
  }
  
  public final int getIntrinsicHeight()
  {
    AppMethodBeat.i(104669);
    int i = (int)(this.mHeight * getEmojiDensityScale());
    AppMethodBeat.o(104669);
    return i;
  }
  
  public final int getIntrinsicWidth()
  {
    AppMethodBeat.i(104668);
    int i = (int)(this.mWidth * getEmojiDensityScale());
    AppMethodBeat.o(104668);
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
    AppMethodBeat.i(104670);
    super.onBoundsChange(paramRect);
    this.uLC = true;
    AppMethodBeat.o(104670);
  }
  
  public final void pause()
  {
    this.mIsRunning = false;
  }
  
  public final void recycle()
  {
    try
    {
      AppMethodBeat.i(104679);
      ae.v("MicroMsg.GIF.MMWXGFDrawable", "Cpan recycle decode handle:%d", new Object[] { Long.valueOf(this.uMp) });
      this.uLw = true;
      this.mIsRunning = false;
      long l = this.uMp;
      this.uMp = 0L;
      this.gNm.removeCallbacks(this.uLW);
      int i = MMWXGFJNI.nativeUninit(l);
      if (i == -906) {
        g.yxI.idkeyStat(401L, 10L, 1L, false);
      }
      ae.d("MicroMsg.GIF.MMWXGFDrawable", "nativeUninit result:%d mWXGFJNIHandle:%s mIsRender:%b", new Object[] { Integer.valueOf(i), Long.valueOf(l), Boolean.valueOf(this.uMt) });
      this.uMr = null;
      AppMethodBeat.o(104679);
      return;
    }
    finally {}
  }
  
  public final void reset()
  {
    AppMethodBeat.i(104678);
    this.mIsRunning = true;
    com.tencent.mm.au.a.h(this.uLY, 0L);
    AppMethodBeat.o(104678);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(104677);
    if (!this.uLw)
    {
      this.mIsRunning = true;
      m(this.uLW, 0L);
    }
    AppMethodBeat.o(104677);
  }
  
  public final void setAlpha(int paramInt)
  {
    AppMethodBeat.i(104672);
    this.mPaint.setAlpha(paramInt);
    AppMethodBeat.o(104672);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(104673);
    this.mPaint.setColorFilter(paramColorFilter);
    AppMethodBeat.o(104673);
  }
  
  public final void start()
  {
    AppMethodBeat.i(104674);
    this.mIsRunning = true;
    com.tencent.mm.au.a.h(this.uLX, 0L);
    AppMethodBeat.o(104674);
  }
  
  public final void stop()
  {
    boolean bool2 = true;
    AppMethodBeat.i(104675);
    this.mIsRunning = false;
    if (this.fMX != 0)
    {
      ae.i("MicroMsg.GIF.MMWXGFDrawable", "summerhardcoder stopPerformance startPerformance:%x ", new Object[] { Integer.valueOf(this.fMX) });
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
      WXHardCoderJNI.stopPerformance(bool1, this.fMX);
      this.fMX = 0;
      AppMethodBeat.o(104675);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.h
 * JD-Core Version:    0.7.0.1
 */