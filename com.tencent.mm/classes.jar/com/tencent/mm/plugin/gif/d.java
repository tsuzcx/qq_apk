package com.tencent.mm.plugin.gif;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.q;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import java.io.InputStream;

public final class d
  extends b
{
  private final Rect Iw;
  private int fsu;
  private ao gqT;
  private float mDensity;
  private boolean mIsRunning;
  private final Paint mPaint;
  private boolean txA;
  int txB;
  private int txC;
  k txD;
  private boolean txE;
  private boolean txF;
  private final Runnable txG;
  private final Runnable txH;
  private final Runnable txI;
  private final Runnable txJ;
  private final Runnable txK;
  private final Runnable txL;
  private boolean txh;
  private volatile long txi;
  private AssetFileDescriptor txj;
  private final int[] txk;
  private float txl;
  private float txm;
  private boolean txn;
  private int[] txo;
  private Bitmap txp;
  private boolean txq;
  private int txr;
  private int txs;
  private long txt;
  private long txu;
  private long txv;
  private long txw;
  private long txx;
  private long txy;
  private int txz;
  
  public d(Resources paramResources, int paramInt)
  {
    this(paramResources.openRawResource(paramInt));
    AppMethodBeat.i(104620);
    AppMethodBeat.o(104620);
  }
  
  public d(InputStream paramInputStream)
  {
    AppMethodBeat.i(104623);
    this.mIsRunning = true;
    this.txh = false;
    this.txj = null;
    this.txk = new int[6];
    this.txl = 1.0F;
    this.txm = 1.0F;
    this.Iw = new Rect();
    this.mPaint = new Paint(6);
    this.txq = false;
    this.txr = 0;
    this.txs = -1;
    this.txt = 0L;
    this.txu = 0L;
    this.txv = 0L;
    this.txw = 0L;
    this.txy = 0L;
    this.txA = false;
    this.txB = 0;
    this.txC = 0;
    this.gqT = new ao(Looper.getMainLooper());
    this.txE = true;
    this.txF = false;
    this.txG = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104613);
        if (d.a(d.this) != null) {
          d.a(d.this);
        }
        AppMethodBeat.o(104613);
      }
    };
    this.txH = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104614);
        if (((d.this.isRunning()) || (d.b(d.this) == 0)) && (SystemClock.uptimeMillis() >= d.c(d.this)))
        {
          d.a(d.this, System.currentTimeMillis());
          d.d(d.this);
          d.this.invalidateSelf();
          if (d.a(d.this) != null) {
            d.a(d.this).invalidate();
          }
        }
        AppMethodBeat.o(104614);
      }
    };
    this.txI = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104615);
        MMGIFJNI.restoreRemainder(d.e(d.this));
        d.a(d.this, d.f(d.this), d.g(d.this));
        AppMethodBeat.o(104615);
      }
    };
    this.txJ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104616);
        MMGIFJNI.reset(d.e(d.this));
        d.a(d.this, -1);
        d.a(d.this, d.f(d.this), 0L);
        AppMethodBeat.o(104616);
      }
    };
    this.txK = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104617);
        MMGIFJNI.saveRemainder(d.e(d.this));
        AppMethodBeat.o(104617);
      }
    };
    this.txL = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104618);
        if (d.h(d.this))
        {
          ac.i("MicroMsg.GIF.MMGIFDrawable", "This gif had been recycle.");
          AppMethodBeat.o(104618);
          return;
        }
        long l = System.currentTimeMillis();
        if (d.b(d.this) + 1 > d.i(d.this) - 1) {
          d.a(d.this, -1);
        }
        d.a(d.this, d.b(d.this) + 1);
        boolean bool = MMGIFJNI.drawFramePixels(d.e(d.this), d.j(d.this), d.k(d.this));
        d.l(d.this);
        if (bool) {
          d.m(d.this);
        }
        d.b(d.this, System.currentTimeMillis() - l);
        int i;
        if (d.n(d.this) != 0L)
        {
          d.c(d.this, d.n(d.this) - d.o(d.this) - d.p(d.this));
          if (d.g(d.this) < 0L)
          {
            ac.d("MicroMsg.GIF.MMGIFDrawable", "Render time:%d InvalidateUseTime:%d NextRealInvalidateTime:%d mNextFrameDuration:%d mCurrentFrameIndex:%d", new Object[] { Long.valueOf(d.o(d.this)), Long.valueOf(d.p(d.this)), Long.valueOf(d.g(d.this)), Long.valueOf(d.n(d.this)), Integer.valueOf(d.k(d.this)[5]) });
            h.wUl.idkeyStat(401L, 0L, 1L, false);
            h.wUl.idkeyStat(401L, 1L, Math.abs(d.g(d.this)), false);
            if (d.g(d.this) < -100L)
            {
              if ((!WXHardCoderJNI.hcGifEnable) && (!WXHardCoderJNI.hcGifFrameEnable)) {
                break label485;
              }
              bool = true;
              WXHardCoderJNI.stopPerformance(bool, d.q(d.this));
              locald = d.this;
              bool = WXHardCoderJNI.hcGifFrameEnable;
              int j = WXHardCoderJNI.hcGifFrameDelay;
              int k = WXHardCoderJNI.hcGifFrameCPU;
              int m = WXHardCoderJNI.hcGifFrameIO;
              if (!WXHardCoderJNI.hcGifFrameThr) {
                break label491;
              }
              i = Process.myTid();
              label383:
              d.b(locald, WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcGifFrameTimeout, 602, WXHardCoderJNI.hcGifFrameAction, "MicroMsg.GIF.MMGIFDrawable"));
            }
          }
        }
        d locald = d.this;
        Runnable localRunnable = d.f(d.this);
        if (d.g(d.this) > 0L) {}
        for (l = d.g(d.this);; l = 0L)
        {
          d.a(locald, localRunnable, l);
          if (d.k(d.this)[2] != 1) {
            break label502;
          }
          d.d(d.this, 5000L);
          AppMethodBeat.o(104618);
          return;
          label485:
          bool = false;
          break;
          label491:
          i = 0;
          break label383;
        }
        label502:
        d.d(d.this, d.k(d.this)[4]);
        AppMethodBeat.o(104618);
      }
    };
    if (paramInputStream == null)
    {
      paramInputStream = new NullPointerException("input stream is null.");
      AppMethodBeat.o(104623);
      throw paramInputStream;
    }
    boolean bool = WXHardCoderJNI.hcGifEnable;
    int j = WXHardCoderJNI.hcGifDelay;
    int k = WXHardCoderJNI.hcGifCPU;
    int m = WXHardCoderJNI.hcGifIO;
    if (WXHardCoderJNI.hcGifThr) {
      i = Process.myTid();
    }
    this.fsu = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, "MicroMsg.GIF.MMGIFDrawable");
    this.txi = MMGIFJNI.openByInputStrem(paramInputStream, this.txk);
    init();
    AppMethodBeat.o(104623);
  }
  
  public d(String paramString)
  {
    AppMethodBeat.i(104622);
    this.mIsRunning = true;
    this.txh = false;
    this.txj = null;
    this.txk = new int[6];
    this.txl = 1.0F;
    this.txm = 1.0F;
    this.Iw = new Rect();
    this.mPaint = new Paint(6);
    this.txq = false;
    this.txr = 0;
    this.txs = -1;
    this.txt = 0L;
    this.txu = 0L;
    this.txv = 0L;
    this.txw = 0L;
    this.txy = 0L;
    this.txA = false;
    this.txB = 0;
    this.txC = 0;
    this.gqT = new ao(Looper.getMainLooper());
    this.txE = true;
    this.txF = false;
    this.txG = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104613);
        if (d.a(d.this) != null) {
          d.a(d.this);
        }
        AppMethodBeat.o(104613);
      }
    };
    this.txH = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104614);
        if (((d.this.isRunning()) || (d.b(d.this) == 0)) && (SystemClock.uptimeMillis() >= d.c(d.this)))
        {
          d.a(d.this, System.currentTimeMillis());
          d.d(d.this);
          d.this.invalidateSelf();
          if (d.a(d.this) != null) {
            d.a(d.this).invalidate();
          }
        }
        AppMethodBeat.o(104614);
      }
    };
    this.txI = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104615);
        MMGIFJNI.restoreRemainder(d.e(d.this));
        d.a(d.this, d.f(d.this), d.g(d.this));
        AppMethodBeat.o(104615);
      }
    };
    this.txJ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104616);
        MMGIFJNI.reset(d.e(d.this));
        d.a(d.this, -1);
        d.a(d.this, d.f(d.this), 0L);
        AppMethodBeat.o(104616);
      }
    };
    this.txK = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104617);
        MMGIFJNI.saveRemainder(d.e(d.this));
        AppMethodBeat.o(104617);
      }
    };
    this.txL = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104618);
        if (d.h(d.this))
        {
          ac.i("MicroMsg.GIF.MMGIFDrawable", "This gif had been recycle.");
          AppMethodBeat.o(104618);
          return;
        }
        long l = System.currentTimeMillis();
        if (d.b(d.this) + 1 > d.i(d.this) - 1) {
          d.a(d.this, -1);
        }
        d.a(d.this, d.b(d.this) + 1);
        boolean bool = MMGIFJNI.drawFramePixels(d.e(d.this), d.j(d.this), d.k(d.this));
        d.l(d.this);
        if (bool) {
          d.m(d.this);
        }
        d.b(d.this, System.currentTimeMillis() - l);
        int i;
        if (d.n(d.this) != 0L)
        {
          d.c(d.this, d.n(d.this) - d.o(d.this) - d.p(d.this));
          if (d.g(d.this) < 0L)
          {
            ac.d("MicroMsg.GIF.MMGIFDrawable", "Render time:%d InvalidateUseTime:%d NextRealInvalidateTime:%d mNextFrameDuration:%d mCurrentFrameIndex:%d", new Object[] { Long.valueOf(d.o(d.this)), Long.valueOf(d.p(d.this)), Long.valueOf(d.g(d.this)), Long.valueOf(d.n(d.this)), Integer.valueOf(d.k(d.this)[5]) });
            h.wUl.idkeyStat(401L, 0L, 1L, false);
            h.wUl.idkeyStat(401L, 1L, Math.abs(d.g(d.this)), false);
            if (d.g(d.this) < -100L)
            {
              if ((!WXHardCoderJNI.hcGifEnable) && (!WXHardCoderJNI.hcGifFrameEnable)) {
                break label485;
              }
              bool = true;
              WXHardCoderJNI.stopPerformance(bool, d.q(d.this));
              locald = d.this;
              bool = WXHardCoderJNI.hcGifFrameEnable;
              int j = WXHardCoderJNI.hcGifFrameDelay;
              int k = WXHardCoderJNI.hcGifFrameCPU;
              int m = WXHardCoderJNI.hcGifFrameIO;
              if (!WXHardCoderJNI.hcGifFrameThr) {
                break label491;
              }
              i = Process.myTid();
              label383:
              d.b(locald, WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcGifFrameTimeout, 602, WXHardCoderJNI.hcGifFrameAction, "MicroMsg.GIF.MMGIFDrawable"));
            }
          }
        }
        d locald = d.this;
        Runnable localRunnable = d.f(d.this);
        if (d.g(d.this) > 0L) {}
        for (l = d.g(d.this);; l = 0L)
        {
          d.a(locald, localRunnable, l);
          if (d.k(d.this)[2] != 1) {
            break label502;
          }
          d.d(d.this, 5000L);
          AppMethodBeat.o(104618);
          return;
          label485:
          bool = false;
          break;
          label491:
          i = 0;
          break label383;
        }
        label502:
        d.d(d.this, d.k(d.this)[4]);
        AppMethodBeat.o(104618);
      }
    };
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new NullPointerException("file path is null.");
      AppMethodBeat.o(104622);
      throw paramString;
    }
    boolean bool = WXHardCoderJNI.hcGifEnable;
    int j = WXHardCoderJNI.hcGifDelay;
    int k = WXHardCoderJNI.hcGifCPU;
    int m = WXHardCoderJNI.hcGifIO;
    if (WXHardCoderJNI.hcGifThr) {}
    for (int i = Process.myTid();; i = 0)
    {
      this.fsu = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, "MicroMsg.GIF.MMGIFDrawable");
      this.txi = MMGIFJNI.openByFilePath(q.k(paramString, false), this.txk);
      init();
      AppMethodBeat.o(104622);
      return;
    }
  }
  
  public d(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(104621);
    this.mIsRunning = true;
    this.txh = false;
    this.txj = null;
    this.txk = new int[6];
    this.txl = 1.0F;
    this.txm = 1.0F;
    this.Iw = new Rect();
    this.mPaint = new Paint(6);
    this.txq = false;
    this.txr = 0;
    this.txs = -1;
    this.txt = 0L;
    this.txu = 0L;
    this.txv = 0L;
    this.txw = 0L;
    this.txy = 0L;
    this.txA = false;
    this.txB = 0;
    this.txC = 0;
    this.gqT = new ao(Looper.getMainLooper());
    this.txE = true;
    this.txF = false;
    this.txG = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104613);
        if (d.a(d.this) != null) {
          d.a(d.this);
        }
        AppMethodBeat.o(104613);
      }
    };
    this.txH = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104614);
        if (((d.this.isRunning()) || (d.b(d.this) == 0)) && (SystemClock.uptimeMillis() >= d.c(d.this)))
        {
          d.a(d.this, System.currentTimeMillis());
          d.d(d.this);
          d.this.invalidateSelf();
          if (d.a(d.this) != null) {
            d.a(d.this).invalidate();
          }
        }
        AppMethodBeat.o(104614);
      }
    };
    this.txI = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104615);
        MMGIFJNI.restoreRemainder(d.e(d.this));
        d.a(d.this, d.f(d.this), d.g(d.this));
        AppMethodBeat.o(104615);
      }
    };
    this.txJ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104616);
        MMGIFJNI.reset(d.e(d.this));
        d.a(d.this, -1);
        d.a(d.this, d.f(d.this), 0L);
        AppMethodBeat.o(104616);
      }
    };
    this.txK = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104617);
        MMGIFJNI.saveRemainder(d.e(d.this));
        AppMethodBeat.o(104617);
      }
    };
    this.txL = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104618);
        if (d.h(d.this))
        {
          ac.i("MicroMsg.GIF.MMGIFDrawable", "This gif had been recycle.");
          AppMethodBeat.o(104618);
          return;
        }
        long l = System.currentTimeMillis();
        if (d.b(d.this) + 1 > d.i(d.this) - 1) {
          d.a(d.this, -1);
        }
        d.a(d.this, d.b(d.this) + 1);
        boolean bool = MMGIFJNI.drawFramePixels(d.e(d.this), d.j(d.this), d.k(d.this));
        d.l(d.this);
        if (bool) {
          d.m(d.this);
        }
        d.b(d.this, System.currentTimeMillis() - l);
        int i;
        if (d.n(d.this) != 0L)
        {
          d.c(d.this, d.n(d.this) - d.o(d.this) - d.p(d.this));
          if (d.g(d.this) < 0L)
          {
            ac.d("MicroMsg.GIF.MMGIFDrawable", "Render time:%d InvalidateUseTime:%d NextRealInvalidateTime:%d mNextFrameDuration:%d mCurrentFrameIndex:%d", new Object[] { Long.valueOf(d.o(d.this)), Long.valueOf(d.p(d.this)), Long.valueOf(d.g(d.this)), Long.valueOf(d.n(d.this)), Integer.valueOf(d.k(d.this)[5]) });
            h.wUl.idkeyStat(401L, 0L, 1L, false);
            h.wUl.idkeyStat(401L, 1L, Math.abs(d.g(d.this)), false);
            if (d.g(d.this) < -100L)
            {
              if ((!WXHardCoderJNI.hcGifEnable) && (!WXHardCoderJNI.hcGifFrameEnable)) {
                break label485;
              }
              bool = true;
              WXHardCoderJNI.stopPerformance(bool, d.q(d.this));
              locald = d.this;
              bool = WXHardCoderJNI.hcGifFrameEnable;
              int j = WXHardCoderJNI.hcGifFrameDelay;
              int k = WXHardCoderJNI.hcGifFrameCPU;
              int m = WXHardCoderJNI.hcGifFrameIO;
              if (!WXHardCoderJNI.hcGifFrameThr) {
                break label491;
              }
              i = Process.myTid();
              label383:
              d.b(locald, WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcGifFrameTimeout, 602, WXHardCoderJNI.hcGifFrameAction, "MicroMsg.GIF.MMGIFDrawable"));
            }
          }
        }
        d locald = d.this;
        Runnable localRunnable = d.f(d.this);
        if (d.g(d.this) > 0L) {}
        for (l = d.g(d.this);; l = 0L)
        {
          d.a(locald, localRunnable, l);
          if (d.k(d.this)[2] != 1) {
            break label502;
          }
          d.d(d.this, 5000L);
          AppMethodBeat.o(104618);
          return;
          label485:
          bool = false;
          break;
          label491:
          i = 0;
          break label383;
        }
        label502:
        d.d(d.this, d.k(d.this)[4]);
        AppMethodBeat.o(104618);
      }
    };
    this.txF = paramBoolean;
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new NullPointerException("file path is null.");
      AppMethodBeat.o(104621);
      throw paramString;
    }
    paramBoolean = WXHardCoderJNI.hcGifEnable;
    int j = WXHardCoderJNI.hcGifDelay;
    int k = WXHardCoderJNI.hcGifCPU;
    int m = WXHardCoderJNI.hcGifIO;
    if (WXHardCoderJNI.hcGifThr) {
      i = Process.myTid();
    }
    this.fsu = WXHardCoderJNI.startPerformance(paramBoolean, j, k, m, i, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, "MicroMsg.GIF.MMGIFDrawable");
    this.txi = MMGIFJNI.openByFilePath(paramString, this.txk);
    init();
    AppMethodBeat.o(104621);
  }
  
  public d(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(104625);
    this.mIsRunning = true;
    this.txh = false;
    this.txj = null;
    this.txk = new int[6];
    this.txl = 1.0F;
    this.txm = 1.0F;
    this.Iw = new Rect();
    this.mPaint = new Paint(6);
    this.txq = false;
    this.txr = 0;
    this.txs = -1;
    this.txt = 0L;
    this.txu = 0L;
    this.txv = 0L;
    this.txw = 0L;
    this.txy = 0L;
    this.txA = false;
    this.txB = 0;
    this.txC = 0;
    this.gqT = new ao(Looper.getMainLooper());
    this.txE = true;
    this.txF = false;
    this.txG = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104613);
        if (d.a(d.this) != null) {
          d.a(d.this);
        }
        AppMethodBeat.o(104613);
      }
    };
    this.txH = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104614);
        if (((d.this.isRunning()) || (d.b(d.this) == 0)) && (SystemClock.uptimeMillis() >= d.c(d.this)))
        {
          d.a(d.this, System.currentTimeMillis());
          d.d(d.this);
          d.this.invalidateSelf();
          if (d.a(d.this) != null) {
            d.a(d.this).invalidate();
          }
        }
        AppMethodBeat.o(104614);
      }
    };
    this.txI = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104615);
        MMGIFJNI.restoreRemainder(d.e(d.this));
        d.a(d.this, d.f(d.this), d.g(d.this));
        AppMethodBeat.o(104615);
      }
    };
    this.txJ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104616);
        MMGIFJNI.reset(d.e(d.this));
        d.a(d.this, -1);
        d.a(d.this, d.f(d.this), 0L);
        AppMethodBeat.o(104616);
      }
    };
    this.txK = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104617);
        MMGIFJNI.saveRemainder(d.e(d.this));
        AppMethodBeat.o(104617);
      }
    };
    this.txL = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104618);
        if (d.h(d.this))
        {
          ac.i("MicroMsg.GIF.MMGIFDrawable", "This gif had been recycle.");
          AppMethodBeat.o(104618);
          return;
        }
        long l = System.currentTimeMillis();
        if (d.b(d.this) + 1 > d.i(d.this) - 1) {
          d.a(d.this, -1);
        }
        d.a(d.this, d.b(d.this) + 1);
        boolean bool = MMGIFJNI.drawFramePixels(d.e(d.this), d.j(d.this), d.k(d.this));
        d.l(d.this);
        if (bool) {
          d.m(d.this);
        }
        d.b(d.this, System.currentTimeMillis() - l);
        int i;
        if (d.n(d.this) != 0L)
        {
          d.c(d.this, d.n(d.this) - d.o(d.this) - d.p(d.this));
          if (d.g(d.this) < 0L)
          {
            ac.d("MicroMsg.GIF.MMGIFDrawable", "Render time:%d InvalidateUseTime:%d NextRealInvalidateTime:%d mNextFrameDuration:%d mCurrentFrameIndex:%d", new Object[] { Long.valueOf(d.o(d.this)), Long.valueOf(d.p(d.this)), Long.valueOf(d.g(d.this)), Long.valueOf(d.n(d.this)), Integer.valueOf(d.k(d.this)[5]) });
            h.wUl.idkeyStat(401L, 0L, 1L, false);
            h.wUl.idkeyStat(401L, 1L, Math.abs(d.g(d.this)), false);
            if (d.g(d.this) < -100L)
            {
              if ((!WXHardCoderJNI.hcGifEnable) && (!WXHardCoderJNI.hcGifFrameEnable)) {
                break label485;
              }
              bool = true;
              WXHardCoderJNI.stopPerformance(bool, d.q(d.this));
              locald = d.this;
              bool = WXHardCoderJNI.hcGifFrameEnable;
              int j = WXHardCoderJNI.hcGifFrameDelay;
              int k = WXHardCoderJNI.hcGifFrameCPU;
              int m = WXHardCoderJNI.hcGifFrameIO;
              if (!WXHardCoderJNI.hcGifFrameThr) {
                break label491;
              }
              i = Process.myTid();
              label383:
              d.b(locald, WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcGifFrameTimeout, 602, WXHardCoderJNI.hcGifFrameAction, "MicroMsg.GIF.MMGIFDrawable"));
            }
          }
        }
        d locald = d.this;
        Runnable localRunnable = d.f(d.this);
        if (d.g(d.this) > 0L) {}
        for (l = d.g(d.this);; l = 0L)
        {
          d.a(locald, localRunnable, l);
          if (d.k(d.this)[2] != 1) {
            break label502;
          }
          d.d(d.this, 5000L);
          AppMethodBeat.o(104618);
          return;
          label485:
          bool = false;
          break;
          label491:
          i = 0;
          break label383;
        }
        label502:
        d.d(d.this, d.k(d.this)[4]);
        AppMethodBeat.o(104618);
      }
    };
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = new NullPointerException("bytes is null.");
      AppMethodBeat.o(104625);
      throw paramArrayOfByte;
    }
    boolean bool = WXHardCoderJNI.hcGifEnable;
    int j = WXHardCoderJNI.hcGifDelay;
    int k = WXHardCoderJNI.hcGifCPU;
    int m = WXHardCoderJNI.hcGifIO;
    if (WXHardCoderJNI.hcGifThr) {
      i = Process.myTid();
    }
    this.fsu = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, "MicroMsg.GIF.MMGIFDrawable");
    this.txi = MMGIFJNI.openByByteArray(paramArrayOfByte, this.txk);
    init();
    AppMethodBeat.o(104625);
  }
  
  public d(byte[] paramArrayOfByte, String paramString)
  {
    this(paramArrayOfByte);
    AppMethodBeat.i(104624);
    paramArrayOfByte = com.tencent.mm.emoji.loader.a.b.fPi;
    if (com.tencent.mm.emoji.loader.a.b.te(paramString) != null)
    {
      paramArrayOfByte = com.tencent.mm.emoji.loader.a.b.fPi;
      this.txp = com.tencent.mm.emoji.loader.a.b.te(paramString);
    }
    AppMethodBeat.o(104624);
  }
  
  private void init()
  {
    AppMethodBeat.i(104626);
    ac.i("MicroMsg.GIF.MMGIFDrawable", "gif info pointer:%d", new Object[] { Long.valueOf(this.txi) });
    this.txr = this.txk[2];
    this.txz = com.tencent.mm.cc.a.au(ai.getContext(), 2131166264);
    if ((!this.txF) && ((this.txk[0] > 1024) || (this.txk[1] > 1024)))
    {
      ac.w("MicroMsg.GIF.MMGIFDrawable", "emoji width or height over size. Width:%d Height:%d", new Object[] { Integer.valueOf(this.txk[0]), Integer.valueOf(this.txk[1]) });
      this.txo = new int[this.txz * this.txz];
      this.txA = true;
      h.wUl.idkeyStat(401L, 2L, 1L, false);
      AppMethodBeat.o(104626);
      return;
    }
    this.txo = new int[this.txk[0] * this.txk[1]];
    AppMethodBeat.o(104626);
  }
  
  private void l(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(104619);
    this.txy = (SystemClock.uptimeMillis() + paramLong);
    if (this.gqT != null) {
      this.gqT.postAtTime(paramRunnable, this.txy);
    }
    AppMethodBeat.o(104619);
  }
  
  public final int cRS()
  {
    return this.txk[0];
  }
  
  public final int cRT()
  {
    return this.txk[1];
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(104631);
    if (this.txn)
    {
      this.Iw.set(getBounds());
      this.txl = (this.Iw.width() / this.txk[0]);
      this.txm = (this.Iw.height() / this.txk[1]);
      this.txn = false;
    }
    if (this.mPaint.getShader() == null)
    {
      if (this.txw == 0L) {
        this.txw = System.currentTimeMillis();
      }
      int[] arrayOfInt = this.txo;
      if (arrayOfInt != null) {
        if ((!this.txq) && (this.txp != null))
        {
          paramCanvas.scale(this.Iw.width() / this.txp.getWidth(), this.Iw.width() / this.txp.getHeight());
          paramCanvas.drawBitmap(this.txp, 0.0F, 0.0F, this.mPaint);
        }
      }
      for (;;)
      {
        this.txx = (System.currentTimeMillis() - this.txw);
        if ((this.txA) || (this.txk[2] <= 0)) {
          break label426;
        }
        if (this.txk[4] < 0) {
          ac.i("MicroMsg.GIF.MMGIFDrawable", "current index error. start first frame");
        }
        if ((this.txB == 0) || (this.txC <= this.txB - 1)) {
          break;
        }
        l(this.txG, 0L);
        AppMethodBeat.o(104631);
        return;
        if (arrayOfInt.length == this.txk[0] * this.txk[1])
        {
          paramCanvas.scale(this.txl, this.txm);
          paramCanvas.drawBitmap(arrayOfInt, 0, this.txk[0], 0.0F, 0.0F, this.txk[0], this.txk[1], true, this.mPaint);
        }
        else
        {
          paramCanvas.scale(this.txl, this.txm);
          paramCanvas.drawRGB(230, 230, 230);
          ac.w("MicroMsg.GIF.MMGIFDrawable", "colors is not equal width*height. length:%d width:%d height:%d", new Object[] { Integer.valueOf(arrayOfInt.length), Integer.valueOf(this.txk[0]), Integer.valueOf(this.txk[1]) });
          continue;
          ac.e("MicroMsg.GIF.MMGIFDrawable", "colors is null.");
        }
      }
      if (this.txE)
      {
        com.tencent.mm.au.a.g(this.txL, 0L);
        this.txE = false;
        AppMethodBeat.o(104631);
        return;
        label426:
        ac.e("MicroMsg.GIF.MMGIFDrawable", "framecount:%d errorcode:%d no post and oversize:%b", new Object[] { Integer.valueOf(this.txk[2]), Integer.valueOf(this.txk[4]), Boolean.valueOf(this.txA) });
      }
      AppMethodBeat.o(104631);
      return;
    }
    ac.i("MicroMsg.GIF.MMGIFDrawable", "colors drawRect ");
    paramCanvas.drawRect(this.Iw, this.mPaint);
    AppMethodBeat.o(104631);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(104639);
    try
    {
      recycle();
      AppMethodBeat.o(104639);
      return;
    }
    catch (Throwable localThrowable)
    {
      super.finalize();
      AppMethodBeat.o(104639);
    }
  }
  
  public final float getEmojiDensityScale()
  {
    AppMethodBeat.i(104627);
    if (this.mDensity == 0.0F)
    {
      this.mDensity = (com.tencent.mm.cc.a.getDensity(ai.getContext()) / 2.0F);
      if (this.mDensity >= 1.0F) {
        break label54;
      }
      this.mDensity = 1.0F;
    }
    for (;;)
    {
      float f = this.mDensity;
      AppMethodBeat.o(104627);
      return f;
      label54:
      if (this.mDensity > 2.0F) {
        this.mDensity = 2.0F;
      }
    }
  }
  
  public final int getIntrinsicHeight()
  {
    AppMethodBeat.i(104629);
    int i = (int)(this.txk[1] * getEmojiDensityScale());
    AppMethodBeat.o(104629);
    return i;
  }
  
  public final int getIntrinsicWidth()
  {
    AppMethodBeat.i(104628);
    int i = (int)(this.txk[0] * getEmojiDensityScale());
    AppMethodBeat.o(104628);
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
    AppMethodBeat.i(104630);
    super.onBoundsChange(paramRect);
    this.txn = true;
    AppMethodBeat.o(104630);
  }
  
  public final void pause()
  {
    this.mIsRunning = false;
  }
  
  public final void recycle()
  {
    AppMethodBeat.i(104638);
    ac.d("MicroMsg.GIF.MMGIFDrawable", "recycle");
    this.txh = true;
    this.mIsRunning = false;
    long l = this.txi;
    this.txi = 0L;
    MMGIFJNI.recycle(l);
    this.txo = null;
    if (this.txj != null) {
      try
      {
        this.txj.close();
        AppMethodBeat.o(104638);
        return;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(104638);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(104637);
    this.txh = false;
    this.mIsRunning = true;
    com.tencent.mm.au.a.g(this.txJ, 0L);
    AppMethodBeat.o(104637);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(104636);
    if (!this.txh)
    {
      this.mIsRunning = true;
      l(this.txH, 0L);
    }
    AppMethodBeat.o(104636);
  }
  
  public final void setAlpha(int paramInt)
  {
    AppMethodBeat.i(104632);
    this.mPaint.setAlpha(paramInt);
    AppMethodBeat.o(104632);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(104633);
    this.mPaint.setColorFilter(paramColorFilter);
    AppMethodBeat.o(104633);
  }
  
  public final void start()
  {
    AppMethodBeat.i(104634);
    this.mIsRunning = true;
    com.tencent.mm.au.a.g(this.txI, 0L);
    AppMethodBeat.o(104634);
  }
  
  public final void stop()
  {
    boolean bool2 = true;
    AppMethodBeat.i(104635);
    ac.d("MicroMsg.GIF.MMGIFDrawable", "stop");
    this.mIsRunning = false;
    if (this.fsu != 0)
    {
      ac.i("MicroMsg.GIF.MMGIFDrawable", "summerhardcoder stopPerformance startPerformance:%x ", new Object[] { Integer.valueOf(this.fsu) });
      bool1 = bool2;
      if (!WXHardCoderJNI.hcGifEnable) {
        if (!WXHardCoderJNI.hcGifFrameEnable) {
          break label98;
        }
      }
    }
    label98:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      WXHardCoderJNI.stopPerformance(bool1, this.fsu);
      this.fsu = 0;
      com.tencent.mm.au.a.g(this.txK, 300L);
      AppMethodBeat.o(104635);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.d
 * JD-Core Version:    0.7.0.1
 */