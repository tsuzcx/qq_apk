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
import com.tencent.mm.vfs.y;

public final class h
  extends b
{
  private boolean JgH;
  public int[] JgK;
  private float JgL;
  private float JgM;
  private boolean JgN;
  private Bitmap JgP;
  private int JgR;
  private int JgS;
  private long JgT;
  private long JgU;
  private long JgV;
  private long JgW;
  private long JgX;
  private long JgY;
  private final Object JhA;
  private int[] JhB;
  private Bitmap[] JhC;
  private int JhD;
  public int JhE;
  private boolean JhF;
  public Runnable JhG;
  public int JhH;
  private boolean Jhe;
  private final Runnable Jhh;
  private final Runnable Jhi;
  private final Runnable Jhj;
  private final Runnable Jhl;
  private volatile long Jhz;
  private final Rect bre;
  private MMHandler eqE;
  private int loopCount;
  private int lyw;
  private float mDensity;
  private int mHeight;
  public boolean mIsRunning;
  private final Paint mPaint;
  private int mWidth;
  
  public h(String paramString)
  {
    this(y.bi(paramString, 0, (int)y.bEl(paramString)));
    AppMethodBeat.i(104664);
    AppMethodBeat.o(104664);
  }
  
  public h(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(104666);
    this.mIsRunning = false;
    this.JgH = false;
    this.JhA = new Object();
    this.JgK = new int[4];
    this.JhB = new int[4];
    this.JgL = 1.0F;
    this.JgM = 1.0F;
    this.bre = new Rect();
    this.mPaint = new Paint(6);
    this.JhC = new Bitmap[2];
    this.JhD = 0;
    this.JgR = 0;
    this.JhE = 0;
    this.JgS = -1;
    this.JgT = 0L;
    this.JgU = 0L;
    this.JgV = 0L;
    this.JgW = 0L;
    this.JgY = 0L;
    this.JhF = false;
    this.eqE = new MMHandler(Looper.getMainLooper());
    this.Jhe = true;
    this.Jhh = new Runnable()
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
    this.Jhi = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104660);
        h.a(h.this, h.e(h.this), h.f(h.this));
        AppMethodBeat.o(104660);
      }
    };
    this.Jhj = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104661);
        h.g(h.this);
        synchronized (h.h(h.this))
        {
          MMWXGFJNI.nativeRewindBuffer(h.i(h.this));
          h.a(h.this, h.e(h.this), 0L);
          AppMethodBeat.o(104661);
          return;
        }
      }
    };
    this.JhH = -1;
    this.loopCount = 0;
    this.Jhl = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104662);
        for (;;)
        {
          synchronized (h.h(h.this))
          {
            if (h.j(h.this))
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
            if (h.i(h.this) == 0L)
            {
              Log.i("MicroMsg.GIF.MMWXGFDrawable", "Cpan This WXGF JNIHandle is null.");
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(401L, 18L, 1L, false);
              AppMethodBeat.o(104662);
              return;
            }
            h.a(h.this, true);
            l = System.currentTimeMillis();
            i = (h.k(h.this) + 1) % h.l(h.this).length;
            Object localObject3 = h.l(h.this)[i];
            Object localObject1 = localObject3;
            if (localObject3 == null)
            {
              localObject1 = Bitmap.createBitmap(h.m(h.this), h.n(h.this), Bitmap.Config.ARGB_8888);
              h.l(h.this)[i] = localObject1;
            }
            i = MMWXGFJNI.nativeDecodeBufferFrame(h.i(h.this), null, 0, (Bitmap)localObject1, h.o(h.this));
            if (i == -904)
            {
              Log.i("MicroMsg.GIF.MMWXGFDrawable", "nativeDecodeBufferFrame failed. func is null.");
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(401L, 8L, 1L, false);
              AppMethodBeat.o(104662);
              return;
            }
            if (i == -909)
            {
              Log.i("MicroMsg.GIF.MMWXGFDrawable", "nativeDecodeBufferFrame failed. frame is null.");
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(401L, 11L, 1L, false);
              h.p(h.this);
              if ((h.b(h.this) >= h.q(h.this) - 1) || (i == 1))
              {
                h.g(h.this);
                i = MMWXGFJNI.nativeRewindBuffer(h.i(h.this));
                if (i != 0)
                {
                  if (i == -905) {
                    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(711L, 9L, 1L, false);
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
            if (h.r(h.this) != 0L)
            {
              h.c(h.this, h.r(h.this) - h.s(h.this) - h.t(h.this));
              if (h.f(h.this) < 0L)
              {
                Log.d("MicroMsg.GIF.MMWXGFDrawable", "%s Render time:%d InvalidateUseTime:%d NextRealInvalidateTime:%d mNextFrameDuration:%d mCurrentFrameIndex:%d", new Object[] { this, Long.valueOf(h.s(h.this)), Long.valueOf(h.t(h.this)), Long.valueOf(h.f(h.this)), Long.valueOf(h.r(h.this)), Integer.valueOf(h.b(h.this)) });
                if (h.f(h.this) < -100L)
                {
                  com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(401L, 16L, 1L, false);
                  com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(401L, 17L, Math.abs(h.f(h.this)), false);
                  if ((!WXHardCoderJNI.hcGifEnable) && (!WXHardCoderJNI.hcGifFrameEnable)) {
                    break label795;
                  }
                  bool = true;
                  WXHardCoderJNI.stopPerformance(bool, h.u(h.this));
                  localObject1 = h.this;
                  bool = WXHardCoderJNI.hcGifFrameEnable;
                  int j = WXHardCoderJNI.hcGifFrameDelay;
                  int k = WXHardCoderJNI.hcGifFrameCPU;
                  int m = WXHardCoderJNI.hcGifFrameIO;
                  if (!WXHardCoderJNI.hcGifFrameThr) {
                    break label801;
                  }
                  i = Process.myTid();
                  h.a((h)localObject1, WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcGifFrameTimeout, 602, WXHardCoderJNI.hcGifFrameAction, "MicroMsg.GIF.MMWXGFDrawable"));
                }
              }
            }
            localObject1 = h.this;
            localObject3 = h.e(h.this);
            if (h.f(h.this) <= 0L) {
              break label806;
            }
            l = h.f(h.this);
            h.a((h)localObject1, (Runnable)localObject3, l);
            if (h.o(h.this)[0] <= 0) {
              break label812;
            }
            i = h.o(h.this)[0];
            h.d(h.this, i);
            h.a(h.this, false);
            AppMethodBeat.o(104662);
            return;
          }
          label795:
          boolean bool = false;
          continue;
          label801:
          int i = 0;
          continue;
          label806:
          long l = 0L;
          continue;
          label812:
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
      this.lyw = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, "MicroMsg.GIF.MMWXGFDrawable");
      this.Jhz = MMWXGFJNI.nativeInitWxAMDecoder();
      if ((this.Jhz != 0L) && (this.Jhz != -901L)) {
        break;
      }
      Log.w("MicroMsg.GIF.MMWXGFDrawable", "Cpan init wxam decoder failed. mWXGFJNIHandle:%d", new Object[] { Long.valueOf(this.Jhz) });
      if (this.Jhz == -901L) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(711L, 5L, 1L, false);
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(711L, 4L, 1L, false);
      paramArrayOfByte = new MMGIFException(201);
      AppMethodBeat.o(104666);
      throw paramArrayOfByte;
    }
    i = MMWXGFJNI.nativeDecodeBufferHeader(this.Jhz, paramArrayOfByte, paramArrayOfByte.length);
    if (i != 0)
    {
      Log.w("MicroMsg.GIF.MMWXGFDrawable", "Cpan WXGF decode buffer header failed. result:%d", new Object[] { Integer.valueOf(i) });
      if (i == -904) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(711L, 8L, 1L, false);
      }
      for (;;)
      {
        paramArrayOfByte = new MMGIFException(i);
        AppMethodBeat.o(104666);
        throw paramArrayOfByte;
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(711L, 3L, 1L, false);
      }
    }
    i = MMWXGFJNI.nativeGetOption(this.Jhz, paramArrayOfByte, paramArrayOfByte.length, this.JgK);
    if (i != 0)
    {
      Log.w("MicroMsg.GIF.MMWXGFDrawable", "Cpan WXGF get option failed. result:%d", new Object[] { Integer.valueOf(i) });
      if (i == -903) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(711L, 7L, 1L, false);
      }
      for (;;)
      {
        paramArrayOfByte = new MMGIFException(i);
        AppMethodBeat.o(104666);
        throw paramArrayOfByte;
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(711L, 3L, 1L, false);
      }
    }
    this.JgR = this.JgK[0];
    this.mWidth = this.JgK[1];
    this.mHeight = this.JgK[2];
    this.JhE = this.JgK[3];
    if (this.JhE <= 0) {
      this.JhE = 1;
    }
    if ((this.mWidth == 0) || (this.mHeight == 0))
    {
      i = com.tencent.mm.cd.a.br(MMApplicationContext.getContext(), a.e.emoji_view_image_size);
      this.mHeight = i;
      this.mWidth = i;
    }
    AppMethodBeat.o(104666);
  }
  
  public h(byte[] paramArrayOfByte, String paramString)
  {
    this(paramArrayOfByte);
    AppMethodBeat.i(104665);
    paramArrayOfByte = com.tencent.mm.emoji.b.a.b.mgs;
    if (com.tencent.mm.emoji.b.a.b.Eo(paramString) != null)
    {
      paramArrayOfByte = com.tencent.mm.emoji.b.a.b.mgs;
      this.JgP = com.tencent.mm.emoji.b.a.b.Eo(paramString);
    }
    AppMethodBeat.o(104665);
  }
  
  private void l(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(104663);
    this.JgY = (SystemClock.uptimeMillis() + paramLong);
    if (this.eqE != null) {
      this.eqE.postAtTime(paramRunnable, this.JgY);
    }
    AppMethodBeat.o(104663);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    int j = 1;
    AppMethodBeat.i(104671);
    if (this.JgN)
    {
      this.bre.set(getBounds());
      this.JgL = (this.bre.width() / this.mWidth);
      this.JgM = (this.bre.height() / this.mHeight);
      this.JgN = false;
    }
    if (this.mPaint.getShader() == null)
    {
      if (this.JgW == 0L) {
        this.JgW = System.currentTimeMillis();
      }
      if (this.Jhe) {
        this.JhD = ((this.JhD + 1) % this.JhC.length);
      }
      Bitmap localBitmap2 = this.JhC[this.JhD];
      Bitmap localBitmap1 = localBitmap2;
      if (localBitmap2 == null)
      {
        localBitmap1 = this.JhC[((this.JhD + 1) % this.JhC.length)];
        Log.i("MicroMsg.GIF.MMWXGFDrawable", "use last decode bitmap %s  hash:[%s]", new Object[] { localBitmap1, Integer.valueOf(hashCode()) });
      }
      if ((localBitmap1 != null) && (!localBitmap1.isRecycled()) && (!this.JgH))
      {
        paramCanvas.scale(this.JgL, this.JgM);
        paramCanvas.drawBitmap(localBitmap1, 0.0F, 0.0F, this.mPaint);
      }
      for (;;)
      {
        this.JgX = (System.currentTimeMillis() - this.JgW);
        if (this.Jhe)
        {
          int i = j;
          if (this.JhH > 0)
          {
            i = j;
            if (this.JgS == -1)
            {
              this.loopCount += 1;
              i = j;
              if (this.loopCount >= this.JhH)
              {
                this.mIsRunning = false;
                l(this.JhG, this.JgU);
                i = 0;
              }
            }
          }
          if (i != 0) {
            com.tencent.mm.at.a.g(this.Jhl, 0L);
          }
          this.Jhe = false;
        }
        AppMethodBeat.o(104671);
        return;
        if (this.JgP != null)
        {
          paramCanvas.scale(this.bre.width() / this.JgP.getWidth(), this.bre.height() / this.JgP.getHeight());
          paramCanvas.drawBitmap(this.JgP, 0.0F, 0.0F, this.mPaint);
        }
        else
        {
          Log.e("MicroMsg.GIF.MMWXGFDrawable", "Cpan draw bitmap failed. Bitmap buffer is null or recycle %s", new Object[] { Integer.valueOf(hashCode()) });
        }
      }
    }
    paramCanvas.drawRect(this.bre, this.mPaint);
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
    finally
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
      this.mDensity = (com.tencent.mm.cd.a.getDensity(MMApplicationContext.getContext()) / 2.0F);
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
    this.JgN = true;
    AppMethodBeat.o(104670);
  }
  
  public final void pause()
  {
    this.mIsRunning = false;
  }
  
  public final void preDraw()
  {
    AppMethodBeat.i(260586);
    com.tencent.mm.at.a.g(this.Jhl, 0L);
    AppMethodBeat.o(260586);
  }
  
  /* Error */
  public final void recycle()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 473
    //   5: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 213
    //   10: ldc_w 475
    //   13: iconst_1
    //   14: anewarray 97	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: aload_0
    //   20: getfield 227	com/tencent/mm/plugin/gif/h:Jhz	J
    //   23: invokestatic 237	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   26: aastore
    //   27: invokestatic 478	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   30: aload_0
    //   31: getfield 100	com/tencent/mm/plugin/gif/h:JhA	Ljava/lang/Object;
    //   34: astore 4
    //   36: aload 4
    //   38: monitorenter
    //   39: aload_0
    //   40: iconst_1
    //   41: putfield 95	com/tencent/mm/plugin/gif/h:JgH	Z
    //   44: aload_0
    //   45: iconst_0
    //   46: putfield 93	com/tencent/mm/plugin/gif/h:mIsRunning	Z
    //   49: aload_0
    //   50: getfield 227	com/tencent/mm/plugin/gif/h:Jhz	J
    //   53: lstore_2
    //   54: aload_0
    //   55: lconst_0
    //   56: putfield 227	com/tencent/mm/plugin/gif/h:Jhz	J
    //   59: aload_0
    //   60: getfield 156	com/tencent/mm/plugin/gif/h:eqE	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   63: aload_0
    //   64: getfield 163	com/tencent/mm/plugin/gif/h:Jhh	Ljava/lang/Runnable;
    //   67: invokevirtual 482	com/tencent/mm/sdk/platformtools/MMHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   70: lload_2
    //   71: invokestatic 486	com/tencent/mm/plugin/gif/MMWXGFJNI:nativeUninit	(J)I
    //   74: istore_1
    //   75: iload_1
    //   76: sipush -906
    //   79: if_icmpne +17 -> 96
    //   82: getstatic 249	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   85: ldc2_w 487
    //   88: ldc2_w 489
    //   91: lconst_1
    //   92: iconst_0
    //   93: invokevirtual 257	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   96: ldc 213
    //   98: ldc_w 492
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
    //   122: getfield 143	com/tencent/mm/plugin/gif/h:JhF	Z
    //   125: invokestatic 497	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   128: aastore
    //   129: invokestatic 499	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   132: aload_0
    //   133: aconst_null
    //   134: putfield 123	com/tencent/mm/plugin/gif/h:JhC	[Landroid/graphics/Bitmap;
    //   137: aload_0
    //   138: aconst_null
    //   139: putfield 417	com/tencent/mm/plugin/gif/h:JhG	Ljava/lang/Runnable;
    //   142: aload 4
    //   144: monitorexit
    //   145: ldc_w 473
    //   148: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   151: aload_0
    //   152: monitorexit
    //   153: return
    //   154: astore 5
    //   156: aload 4
    //   158: monitorexit
    //   159: ldc_w 473
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
    com.tencent.mm.at.a.g(this.Jhj, 0L);
    AppMethodBeat.o(104678);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(104677);
    if (!this.JgH)
    {
      this.mIsRunning = true;
      l(this.Jhh, 0L);
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
    com.tencent.mm.at.a.g(this.Jhi, 0L);
    AppMethodBeat.o(104674);
  }
  
  public final void stop()
  {
    boolean bool2 = true;
    AppMethodBeat.i(104675);
    this.mIsRunning = false;
    if (this.lyw != 0)
    {
      Log.i("MicroMsg.GIF.MMWXGFDrawable", "summerhardcoder stopPerformance startPerformance:%x ", new Object[] { Integer.valueOf(this.lyw) });
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
      WXHardCoderJNI.stopPerformance(bool1, this.lyw);
      this.lyw = 0;
      AppMethodBeat.o(104675);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.h
 * JD-Core Version:    0.7.0.1
 */