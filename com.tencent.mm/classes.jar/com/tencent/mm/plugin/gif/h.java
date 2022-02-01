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
import com.tencent.mm.plugin.m.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.vfs.u;

public final class h
  extends b
{
  private boolean DmX;
  private final Runnable DnB;
  private volatile long DnQ;
  private final Object DnR;
  private int[] DnS;
  private Bitmap[] DnT;
  private int DnU;
  private int DnV;
  private boolean DnW;
  private Runnable DnX;
  private int DnY;
  private int[] Dna;
  private float Dnb;
  private float Dnc;
  private boolean Dnd;
  private Bitmap Dnf;
  private int Dnh;
  private int Dni;
  private long Dnj;
  private long Dnk;
  private long Dnl;
  private long Dnm;
  private long Dnn;
  private long Dno;
  private boolean Dnu;
  private final Runnable Dnx;
  private final Runnable Dny;
  private final Runnable Dnz;
  private final Rect KV;
  private MMHandler cyl;
  private int iWt;
  private int loopCount;
  private float mDensity;
  private int mHeight;
  private boolean mIsRunning;
  private final Paint mPaint;
  private int mWidth;
  
  public h(String paramString)
  {
    this(u.aY(paramString, 0, (int)u.bBQ(paramString)));
    AppMethodBeat.i(104664);
    AppMethodBeat.o(104664);
  }
  
  public h(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(104666);
    this.mIsRunning = false;
    this.DmX = false;
    this.DnR = new Object();
    this.Dna = new int[4];
    this.DnS = new int[4];
    this.Dnb = 1.0F;
    this.Dnc = 1.0F;
    this.KV = new Rect();
    this.mPaint = new Paint(6);
    this.DnT = new Bitmap[2];
    this.DnU = 0;
    this.Dnh = 0;
    this.DnV = 0;
    this.Dni = -1;
    this.Dnj = 0L;
    this.Dnk = 0L;
    this.Dnl = 0L;
    this.Dnm = 0L;
    this.Dno = 0L;
    this.DnW = false;
    this.cyl = new MMHandler(Looper.getMainLooper());
    this.Dnu = true;
    this.Dnx = new Runnable()
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
    this.Dny = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104660);
        h.a(h.this, h.e(h.this), h.f(h.this));
        AppMethodBeat.o(104660);
      }
    };
    this.Dnz = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104661);
        h.a(h.this, -1);
        synchronized (h.g(h.this))
        {
          MMWXGFJNI.nativeRewindBuffer(h.h(h.this));
          h.a(h.this, h.e(h.this), 0L);
          AppMethodBeat.o(104661);
          return;
        }
      }
    };
    this.DnY = -1;
    this.loopCount = 0;
    this.DnB = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104662);
        for (;;)
        {
          synchronized (h.g(h.this))
          {
            if (h.i(h.this))
            {
              Log.d("MicroMsg.GIF.MMWXGFDrawable", "Cpan Render Task is Running.");
              AppMethodBeat.o(104662);
              return;
            }
            if (h.a(h.this))
            {
              Log.i("MicroMsg.GIF.MMWXGFDrawable", "Cpan This WXGF had been recycle.");
              AppMethodBeat.o(104662);
              return;
            }
            if (h.h(h.this) == 0L)
            {
              Log.i("MicroMsg.GIF.MMWXGFDrawable", "Cpan This WXGF JNIHandle is null.");
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(401L, 18L, 1L, false);
              AppMethodBeat.o(104662);
              return;
            }
            h.a(h.this, true);
            l = System.currentTimeMillis();
            i = (h.j(h.this) + 1) % h.k(h.this).length;
            Object localObject3 = h.k(h.this)[i];
            Object localObject1 = localObject3;
            if (localObject3 == null)
            {
              localObject1 = Bitmap.createBitmap(h.l(h.this), h.m(h.this), Bitmap.Config.ARGB_8888);
              h.k(h.this)[i] = localObject1;
            }
            i = MMWXGFJNI.nativeDecodeBufferFrame(h.h(h.this), null, 0, (Bitmap)localObject1, h.n(h.this));
            if (i == -904)
            {
              Log.i("MicroMsg.GIF.MMWXGFDrawable", "nativeDecodeBufferFrame failed. func is null.");
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(401L, 8L, 1L, false);
              AppMethodBeat.o(104662);
              return;
            }
            if (i == -909)
            {
              Log.i("MicroMsg.GIF.MMWXGFDrawable", "nativeDecodeBufferFrame failed. frame is null.");
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(401L, 11L, 1L, false);
              h.a(h.this, h.b(h.this) + 1);
              if ((h.b(h.this) >= h.o(h.this) - 1) || (i == 1))
              {
                h.a(h.this, -1);
                i = MMWXGFJNI.nativeRewindBuffer(h.h(h.this));
                if (i != 0)
                {
                  if (i == -905) {
                    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(711L, 9L, 1L, false);
                  }
                  Log.w("MicroMsg.GIF.MMWXGFDrawable", "Cpan Rewind buffer failed.");
                  AppMethodBeat.o(104662);
                }
              }
            }
            else
            {
              if (i != -1) {
                continue;
              }
              Log.i("MicroMsg.GIF.MMWXGFDrawable", "nativeDecodeBufferFrame failed.");
              AppMethodBeat.o(104662);
              return;
            }
            h.b(h.this, System.currentTimeMillis() - l);
            if (h.p(h.this) != 0L)
            {
              h.c(h.this, h.p(h.this) - h.q(h.this) - h.r(h.this));
              if (h.f(h.this) < 0L)
              {
                Log.d("MicroMsg.GIF.MMWXGFDrawable", "%s Render time:%d InvalidateUseTime:%d NextRealInvalidateTime:%d mNextFrameDuration:%d mCurrentFrameIndex:%d", new Object[] { this, Long.valueOf(h.q(h.this)), Long.valueOf(h.r(h.this)), Long.valueOf(h.f(h.this)), Long.valueOf(h.p(h.this)), Integer.valueOf(h.b(h.this)) });
                if (h.f(h.this) < -100L)
                {
                  com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(401L, 16L, 1L, false);
                  com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(401L, 17L, Math.abs(h.f(h.this)), false);
                  if ((!WXHardCoderJNI.hcGifEnable) && (!WXHardCoderJNI.hcGifFrameEnable)) {
                    break label805;
                  }
                  bool = true;
                  WXHardCoderJNI.stopPerformance(bool, h.s(h.this));
                  localObject1 = h.this;
                  bool = WXHardCoderJNI.hcGifFrameEnable;
                  int j = WXHardCoderJNI.hcGifFrameDelay;
                  int k = WXHardCoderJNI.hcGifFrameCPU;
                  int m = WXHardCoderJNI.hcGifFrameIO;
                  if (!WXHardCoderJNI.hcGifFrameThr) {
                    break label811;
                  }
                  i = Process.myTid();
                  h.b((h)localObject1, WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcGifFrameTimeout, 602, WXHardCoderJNI.hcGifFrameAction, "MicroMsg.GIF.MMWXGFDrawable"));
                }
              }
            }
            localObject1 = h.this;
            localObject3 = h.e(h.this);
            if (h.f(h.this) <= 0L) {
              break label816;
            }
            l = h.f(h.this);
            h.a((h)localObject1, (Runnable)localObject3, l);
            if (h.n(h.this)[0] <= 0) {
              break label822;
            }
            i = h.n(h.this)[0];
            h.d(h.this, i);
            h.a(h.this, false);
            AppMethodBeat.o(104662);
            return;
          }
          label805:
          boolean bool = false;
          continue;
          label811:
          int i = 0;
          continue;
          label816:
          long l = 0L;
          continue;
          label822:
          i = 100;
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
      this.iWt = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, "MicroMsg.GIF.MMWXGFDrawable");
      this.DnQ = MMWXGFJNI.nativeInitWxAMDecoder();
      if ((this.DnQ != 0L) && (this.DnQ != -901L)) {
        break;
      }
      Log.w("MicroMsg.GIF.MMWXGFDrawable", "Cpan init wxam decoder failed. mWXGFJNIHandle:%d", new Object[] { Long.valueOf(this.DnQ) });
      if (this.DnQ == -901L) {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(711L, 5L, 1L, false);
      }
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(711L, 4L, 1L, false);
      paramArrayOfByte = new MMGIFException(201);
      AppMethodBeat.o(104666);
      throw paramArrayOfByte;
    }
    i = MMWXGFJNI.nativeDecodeBufferHeader(this.DnQ, paramArrayOfByte, paramArrayOfByte.length);
    if (i != 0)
    {
      Log.w("MicroMsg.GIF.MMWXGFDrawable", "Cpan WXGF decode buffer header failed. result:%d", new Object[] { Integer.valueOf(i) });
      if (i == -904) {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(711L, 8L, 1L, false);
      }
      for (;;)
      {
        paramArrayOfByte = new MMGIFException(i);
        AppMethodBeat.o(104666);
        throw paramArrayOfByte;
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(711L, 3L, 1L, false);
      }
    }
    i = MMWXGFJNI.nativeGetOption(this.DnQ, paramArrayOfByte, paramArrayOfByte.length, this.Dna);
    if (i != 0)
    {
      Log.w("MicroMsg.GIF.MMWXGFDrawable", "Cpan WXGF get option failed. result:%d", new Object[] { Integer.valueOf(i) });
      if (i == -903) {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(711L, 7L, 1L, false);
      }
      for (;;)
      {
        paramArrayOfByte = new MMGIFException(i);
        AppMethodBeat.o(104666);
        throw paramArrayOfByte;
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(711L, 3L, 1L, false);
      }
    }
    this.Dnh = this.Dna[0];
    this.mWidth = this.Dna[1];
    this.mHeight = this.Dna[2];
    this.DnV = this.Dna[3];
    if (this.DnV <= 0) {
      this.DnV = 1;
    }
    if ((this.mWidth == 0) || (this.mHeight == 0))
    {
      i = com.tencent.mm.ci.a.aY(MMApplicationContext.getContext(), a.e.emoji_view_image_size);
      this.mHeight = i;
      this.mWidth = i;
    }
    AppMethodBeat.o(104666);
  }
  
  public h(byte[] paramArrayOfByte, String paramString)
  {
    this(paramArrayOfByte);
    AppMethodBeat.i(104665);
    paramArrayOfByte = com.tencent.mm.emoji.loader.a.b.jGQ;
    if (com.tencent.mm.emoji.loader.a.b.LI(paramString) != null)
    {
      paramArrayOfByte = com.tencent.mm.emoji.loader.a.b.jGQ;
      this.Dnf = com.tencent.mm.emoji.loader.a.b.LI(paramString);
    }
    AppMethodBeat.o(104665);
  }
  
  private void k(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(104663);
    this.Dno = (SystemClock.uptimeMillis() + paramLong);
    if (this.cyl != null) {
      this.cyl.postAtTime(paramRunnable, this.Dno);
    }
    AppMethodBeat.o(104663);
  }
  
  public final void Uh(int paramInt)
  {
    this.DnY = paramInt;
  }
  
  public final void az(Runnable paramRunnable)
  {
    this.DnX = paramRunnable;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    int j = 1;
    AppMethodBeat.i(104671);
    if (this.Dnd)
    {
      this.KV.set(getBounds());
      this.Dnb = (this.KV.width() / this.mWidth);
      this.Dnc = (this.KV.height() / this.mHeight);
      this.Dnd = false;
    }
    if (this.mPaint.getShader() == null)
    {
      if (this.Dnm == 0L) {
        this.Dnm = System.currentTimeMillis();
      }
      if (this.Dnu) {
        this.DnU = ((this.DnU + 1) % this.DnT.length);
      }
      Bitmap localBitmap2 = this.DnT[this.DnU];
      Bitmap localBitmap1 = localBitmap2;
      if (localBitmap2 == null)
      {
        localBitmap1 = this.DnT[((this.DnU + 1) % this.DnT.length)];
        Log.i("MicroMsg.GIF.MMWXGFDrawable", "use last decode bitmap %s  hash:[%s]", new Object[] { localBitmap1, Integer.valueOf(hashCode()) });
      }
      if ((localBitmap1 != null) && (!localBitmap1.isRecycled()) && (!this.DmX))
      {
        paramCanvas.scale(this.Dnb, this.Dnc);
        paramCanvas.drawBitmap(localBitmap1, 0.0F, 0.0F, this.mPaint);
      }
      for (;;)
      {
        this.Dnn = (System.currentTimeMillis() - this.Dnm);
        if (this.Dnu)
        {
          int i = j;
          if (this.DnY > 0)
          {
            i = j;
            if (this.Dni == -1)
            {
              this.loopCount += 1;
              i = j;
              if (this.loopCount >= this.DnY)
              {
                this.mIsRunning = false;
                k(this.DnX, this.Dnk);
                i = 0;
              }
            }
          }
          if (i != 0) {
            com.tencent.mm.ax.a.f(this.DnB, 0L);
          }
          this.Dnu = false;
        }
        AppMethodBeat.o(104671);
        return;
        if (this.Dnf != null)
        {
          paramCanvas.scale(this.KV.width() / this.Dnf.getWidth(), this.KV.height() / this.Dnf.getHeight());
          paramCanvas.drawBitmap(this.Dnf, 0.0F, 0.0F, this.mPaint);
        }
        else
        {
          Log.e("MicroMsg.GIF.MMWXGFDrawable", "Cpan draw bitmap failed. Bitmap buffer is null or recycle %s", new Object[] { Integer.valueOf(hashCode()) });
        }
      }
    }
    paramCanvas.drawRect(this.KV, this.mPaint);
    AppMethodBeat.o(104671);
  }
  
  public final int eAW()
  {
    return this.Dna[1];
  }
  
  public final int eAX()
  {
    return this.Dna[2];
  }
  
  public final int eAY()
  {
    return this.DnV;
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
      Log.printErrStackTrace("MicroMsg.GIF.MMWXGFDrawable", localThrowable, "", new Object[0]);
      super.finalize();
      AppMethodBeat.o(104676);
    }
  }
  
  public final float getEmojiDensityScale()
  {
    AppMethodBeat.i(104667);
    if (this.mDensity == 0.0F)
    {
      this.mDensity = (com.tencent.mm.ci.a.getDensity(MMApplicationContext.getContext()) / 2.0F);
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
    this.Dnd = true;
    AppMethodBeat.o(104670);
  }
  
  public final void pI()
  {
    AppMethodBeat.i(223856);
    com.tencent.mm.ax.a.f(this.DnB, 0L);
    AppMethodBeat.o(223856);
  }
  
  public final void pause()
  {
    this.mIsRunning = false;
  }
  
  /* Error */
  public final void recycle()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 478
    //   5: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 213
    //   10: ldc_w 480
    //   13: iconst_1
    //   14: anewarray 97	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: aload_0
    //   20: getfield 227	com/tencent/mm/plugin/gif/h:DnQ	J
    //   23: invokestatic 237	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   26: aastore
    //   27: invokestatic 483	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   30: aload_0
    //   31: getfield 100	com/tencent/mm/plugin/gif/h:DnR	Ljava/lang/Object;
    //   34: astore 4
    //   36: aload 4
    //   38: monitorenter
    //   39: aload_0
    //   40: iconst_1
    //   41: putfield 95	com/tencent/mm/plugin/gif/h:DmX	Z
    //   44: aload_0
    //   45: iconst_0
    //   46: putfield 93	com/tencent/mm/plugin/gif/h:mIsRunning	Z
    //   49: aload_0
    //   50: getfield 227	com/tencent/mm/plugin/gif/h:DnQ	J
    //   53: lstore_2
    //   54: aload_0
    //   55: lconst_0
    //   56: putfield 227	com/tencent/mm/plugin/gif/h:DnQ	J
    //   59: aload_0
    //   60: getfield 156	com/tencent/mm/plugin/gif/h:cyl	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   63: aload_0
    //   64: getfield 163	com/tencent/mm/plugin/gif/h:Dnx	Ljava/lang/Runnable;
    //   67: invokevirtual 486	com/tencent/mm/sdk/platformtools/MMHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   70: lload_2
    //   71: invokestatic 490	com/tencent/mm/plugin/gif/MMWXGFJNI:nativeUninit	(J)I
    //   74: istore_1
    //   75: iload_1
    //   76: sipush -906
    //   79: if_icmpne +17 -> 96
    //   82: getstatic 249	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   85: ldc2_w 491
    //   88: ldc2_w 493
    //   91: lconst_1
    //   92: iconst_0
    //   93: invokevirtual 257	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   96: ldc 213
    //   98: ldc_w 496
    //   101: iconst_3
    //   102: anewarray 97	java/lang/Object
    //   105: dup
    //   106: iconst_0
    //   107: iload_1
    //   108: invokestatic 273	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   111: aastore
    //   112: dup
    //   113: iconst_1
    //   114: lload_2
    //   115: invokestatic 237	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   118: aastore
    //   119: dup
    //   120: iconst_2
    //   121: aload_0
    //   122: getfield 143	com/tencent/mm/plugin/gif/h:DnW	Z
    //   125: invokestatic 501	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   128: aastore
    //   129: invokestatic 503	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   132: aload_0
    //   133: aconst_null
    //   134: putfield 123	com/tencent/mm/plugin/gif/h:DnT	[Landroid/graphics/Bitmap;
    //   137: aload_0
    //   138: aconst_null
    //   139: putfield 368	com/tencent/mm/plugin/gif/h:DnX	Ljava/lang/Runnable;
    //   142: aload 4
    //   144: monitorexit
    //   145: ldc_w 478
    //   148: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   151: aload_0
    //   152: monitorexit
    //   153: return
    //   154: astore 5
    //   156: aload 4
    //   158: monitorexit
    //   159: ldc_w 478
    //   162: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   165: aload 5
    //   167: athrow
    //   168: astore 4
    //   170: aload_0
    //   171: monitorexit
    //   172: aload 4
    //   174: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	h
    //   74	34	1	i	int
    //   53	62	2	l	long
    //   168	5	4	localObject2	Object
    //   154	12	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   39	75	154	finally
    //   82	96	154	finally
    //   96	145	154	finally
    //   2	39	168	finally
    //   145	151	168	finally
    //   156	168	168	finally
  }
  
  public final void reset()
  {
    AppMethodBeat.i(104678);
    this.mIsRunning = true;
    com.tencent.mm.ax.a.f(this.Dnz, 0L);
    AppMethodBeat.o(104678);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(104677);
    if (!this.DmX)
    {
      this.mIsRunning = true;
      k(this.Dnx, 0L);
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
    com.tencent.mm.ax.a.f(this.Dny, 0L);
    AppMethodBeat.o(104674);
  }
  
  public final void stop()
  {
    boolean bool2 = true;
    AppMethodBeat.i(104675);
    this.mIsRunning = false;
    if (this.iWt != 0)
    {
      Log.i("MicroMsg.GIF.MMWXGFDrawable", "summerhardcoder stopPerformance startPerformance:%x ", new Object[] { Integer.valueOf(this.iWt) });
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
      WXHardCoderJNI.stopPerformance(bool1, this.iWt);
      this.iWt = 0;
      AppMethodBeat.o(104675);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.h
 * JD-Core Version:    0.7.0.1
 */