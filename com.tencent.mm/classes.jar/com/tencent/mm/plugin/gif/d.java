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
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import java.io.InputStream;

public final class d
  extends b
{
  private final Rect Ko;
  private int fKU;
  private ap gKD;
  private float mDensity;
  private boolean mIsRunning;
  private final Paint mPaint;
  private boolean uAa;
  private int uAb;
  private int uAc;
  private long uAd;
  private long uAe;
  private long uAf;
  private long uAg;
  private long uAh;
  private long uAi;
  private int uAj;
  private boolean uAk;
  public int uAl;
  private int uAm;
  k uAn;
  private boolean uAo;
  private boolean uAp;
  private final Runnable uAq;
  private final Runnable uAr;
  private final Runnable uAs;
  private final Runnable uAt;
  private final Runnable uAu;
  private final Runnable uAv;
  private boolean uzR;
  private volatile long uzS;
  private AssetFileDescriptor uzT;
  private final int[] uzU;
  private float uzV;
  private float uzW;
  private boolean uzX;
  private int[] uzY;
  private Bitmap uzZ;
  
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
    this.uzR = false;
    this.uzT = null;
    this.uzU = new int[6];
    this.uzV = 1.0F;
    this.uzW = 1.0F;
    this.Ko = new Rect();
    this.mPaint = new Paint(6);
    this.uAa = false;
    this.uAb = 0;
    this.uAc = -1;
    this.uAd = 0L;
    this.uAe = 0L;
    this.uAf = 0L;
    this.uAg = 0L;
    this.uAi = 0L;
    this.uAk = false;
    this.uAl = 0;
    this.uAm = 0;
    this.gKD = new ap(Looper.getMainLooper());
    this.uAo = true;
    this.uAp = false;
    this.uAq = new Runnable()
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
    this.uAr = new Runnable()
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
    this.uAs = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104615);
        MMGIFJNI.restoreRemainder(d.e(d.this));
        d.a(d.this, d.f(d.this), d.g(d.this));
        AppMethodBeat.o(104615);
      }
    };
    this.uAt = new Runnable()
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
    this.uAu = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104617);
        MMGIFJNI.saveRemainder(d.e(d.this));
        AppMethodBeat.o(104617);
      }
    };
    this.uAv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104618);
        if (d.h(d.this))
        {
          ad.i("MicroMsg.GIF.MMGIFDrawable", "This gif had been recycle.");
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
            ad.d("MicroMsg.GIF.MMGIFDrawable", "Render time:%d InvalidateUseTime:%d NextRealInvalidateTime:%d mNextFrameDuration:%d mCurrentFrameIndex:%d", new Object[] { Long.valueOf(d.o(d.this)), Long.valueOf(d.p(d.this)), Long.valueOf(d.g(d.this)), Long.valueOf(d.n(d.this)), Integer.valueOf(d.k(d.this)[5]) });
            g.yhR.idkeyStat(401L, 0L, 1L, false);
            g.yhR.idkeyStat(401L, 1L, Math.abs(d.g(d.this)), false);
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
    this.fKU = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, "MicroMsg.GIF.MMGIFDrawable");
    this.uzS = MMGIFJNI.openByInputStrem(paramInputStream, this.uzU);
    init();
    AppMethodBeat.o(104623);
  }
  
  public d(String paramString)
  {
    AppMethodBeat.i(104622);
    this.mIsRunning = true;
    this.uzR = false;
    this.uzT = null;
    this.uzU = new int[6];
    this.uzV = 1.0F;
    this.uzW = 1.0F;
    this.Ko = new Rect();
    this.mPaint = new Paint(6);
    this.uAa = false;
    this.uAb = 0;
    this.uAc = -1;
    this.uAd = 0L;
    this.uAe = 0L;
    this.uAf = 0L;
    this.uAg = 0L;
    this.uAi = 0L;
    this.uAk = false;
    this.uAl = 0;
    this.uAm = 0;
    this.gKD = new ap(Looper.getMainLooper());
    this.uAo = true;
    this.uAp = false;
    this.uAq = new Runnable()
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
    this.uAr = new Runnable()
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
    this.uAs = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104615);
        MMGIFJNI.restoreRemainder(d.e(d.this));
        d.a(d.this, d.f(d.this), d.g(d.this));
        AppMethodBeat.o(104615);
      }
    };
    this.uAt = new Runnable()
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
    this.uAu = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104617);
        MMGIFJNI.saveRemainder(d.e(d.this));
        AppMethodBeat.o(104617);
      }
    };
    this.uAv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104618);
        if (d.h(d.this))
        {
          ad.i("MicroMsg.GIF.MMGIFDrawable", "This gif had been recycle.");
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
            ad.d("MicroMsg.GIF.MMGIFDrawable", "Render time:%d InvalidateUseTime:%d NextRealInvalidateTime:%d mNextFrameDuration:%d mCurrentFrameIndex:%d", new Object[] { Long.valueOf(d.o(d.this)), Long.valueOf(d.p(d.this)), Long.valueOf(d.g(d.this)), Long.valueOf(d.n(d.this)), Integer.valueOf(d.k(d.this)[5]) });
            g.yhR.idkeyStat(401L, 0L, 1L, false);
            g.yhR.idkeyStat(401L, 1L, Math.abs(d.g(d.this)), false);
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
      this.fKU = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, "MicroMsg.GIF.MMGIFDrawable");
      this.uzS = MMGIFJNI.openByFilePath(q.k(paramString, false), this.uzU);
      init();
      AppMethodBeat.o(104622);
      return;
    }
  }
  
  public d(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(104621);
    this.mIsRunning = true;
    this.uzR = false;
    this.uzT = null;
    this.uzU = new int[6];
    this.uzV = 1.0F;
    this.uzW = 1.0F;
    this.Ko = new Rect();
    this.mPaint = new Paint(6);
    this.uAa = false;
    this.uAb = 0;
    this.uAc = -1;
    this.uAd = 0L;
    this.uAe = 0L;
    this.uAf = 0L;
    this.uAg = 0L;
    this.uAi = 0L;
    this.uAk = false;
    this.uAl = 0;
    this.uAm = 0;
    this.gKD = new ap(Looper.getMainLooper());
    this.uAo = true;
    this.uAp = false;
    this.uAq = new Runnable()
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
    this.uAr = new Runnable()
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
    this.uAs = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104615);
        MMGIFJNI.restoreRemainder(d.e(d.this));
        d.a(d.this, d.f(d.this), d.g(d.this));
        AppMethodBeat.o(104615);
      }
    };
    this.uAt = new Runnable()
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
    this.uAu = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104617);
        MMGIFJNI.saveRemainder(d.e(d.this));
        AppMethodBeat.o(104617);
      }
    };
    this.uAv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104618);
        if (d.h(d.this))
        {
          ad.i("MicroMsg.GIF.MMGIFDrawable", "This gif had been recycle.");
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
            ad.d("MicroMsg.GIF.MMGIFDrawable", "Render time:%d InvalidateUseTime:%d NextRealInvalidateTime:%d mNextFrameDuration:%d mCurrentFrameIndex:%d", new Object[] { Long.valueOf(d.o(d.this)), Long.valueOf(d.p(d.this)), Long.valueOf(d.g(d.this)), Long.valueOf(d.n(d.this)), Integer.valueOf(d.k(d.this)[5]) });
            g.yhR.idkeyStat(401L, 0L, 1L, false);
            g.yhR.idkeyStat(401L, 1L, Math.abs(d.g(d.this)), false);
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
    this.uAp = paramBoolean;
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
    this.fKU = WXHardCoderJNI.startPerformance(paramBoolean, j, k, m, i, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, "MicroMsg.GIF.MMGIFDrawable");
    this.uzS = MMGIFJNI.openByFilePath(paramString, this.uzU);
    init();
    AppMethodBeat.o(104621);
  }
  
  public d(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(104625);
    this.mIsRunning = true;
    this.uzR = false;
    this.uzT = null;
    this.uzU = new int[6];
    this.uzV = 1.0F;
    this.uzW = 1.0F;
    this.Ko = new Rect();
    this.mPaint = new Paint(6);
    this.uAa = false;
    this.uAb = 0;
    this.uAc = -1;
    this.uAd = 0L;
    this.uAe = 0L;
    this.uAf = 0L;
    this.uAg = 0L;
    this.uAi = 0L;
    this.uAk = false;
    this.uAl = 0;
    this.uAm = 0;
    this.gKD = new ap(Looper.getMainLooper());
    this.uAo = true;
    this.uAp = false;
    this.uAq = new Runnable()
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
    this.uAr = new Runnable()
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
    this.uAs = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104615);
        MMGIFJNI.restoreRemainder(d.e(d.this));
        d.a(d.this, d.f(d.this), d.g(d.this));
        AppMethodBeat.o(104615);
      }
    };
    this.uAt = new Runnable()
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
    this.uAu = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104617);
        MMGIFJNI.saveRemainder(d.e(d.this));
        AppMethodBeat.o(104617);
      }
    };
    this.uAv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104618);
        if (d.h(d.this))
        {
          ad.i("MicroMsg.GIF.MMGIFDrawable", "This gif had been recycle.");
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
            ad.d("MicroMsg.GIF.MMGIFDrawable", "Render time:%d InvalidateUseTime:%d NextRealInvalidateTime:%d mNextFrameDuration:%d mCurrentFrameIndex:%d", new Object[] { Long.valueOf(d.o(d.this)), Long.valueOf(d.p(d.this)), Long.valueOf(d.g(d.this)), Long.valueOf(d.n(d.this)), Integer.valueOf(d.k(d.this)[5]) });
            g.yhR.idkeyStat(401L, 0L, 1L, false);
            g.yhR.idkeyStat(401L, 1L, Math.abs(d.g(d.this)), false);
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
    this.fKU = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, "MicroMsg.GIF.MMGIFDrawable");
    this.uzS = MMGIFJNI.openByByteArray(paramArrayOfByte, this.uzU);
    init();
    AppMethodBeat.o(104625);
  }
  
  public d(byte[] paramArrayOfByte, String paramString)
  {
    this(paramArrayOfByte);
    AppMethodBeat.i(104624);
    paramArrayOfByte = com.tencent.mm.emoji.loader.a.b.giI;
    if (com.tencent.mm.emoji.loader.a.b.vT(paramString) != null)
    {
      paramArrayOfByte = com.tencent.mm.emoji.loader.a.b.giI;
      this.uzZ = com.tencent.mm.emoji.loader.a.b.vT(paramString);
    }
    AppMethodBeat.o(104624);
  }
  
  private void init()
  {
    AppMethodBeat.i(104626);
    ad.i("MicroMsg.GIF.MMGIFDrawable", "gif info pointer:%d", new Object[] { Long.valueOf(this.uzS) });
    this.uAb = this.uzU[2];
    this.uAj = com.tencent.mm.cc.a.ax(aj.getContext(), 2131166264);
    if ((!this.uAp) && ((this.uzU[0] > 1024) || (this.uzU[1] > 1024)))
    {
      ad.w("MicroMsg.GIF.MMGIFDrawable", "emoji width or height over size. Width:%d Height:%d", new Object[] { Integer.valueOf(this.uzU[0]), Integer.valueOf(this.uzU[1]) });
      this.uzY = new int[this.uAj * this.uAj];
      this.uAk = true;
      g.yhR.idkeyStat(401L, 2L, 1L, false);
      AppMethodBeat.o(104626);
      return;
    }
    this.uzY = new int[this.uzU[0] * this.uzU[1]];
    AppMethodBeat.o(104626);
  }
  
  private void m(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(104619);
    this.uAi = (SystemClock.uptimeMillis() + paramLong);
    if (this.gKD != null) {
      this.gKD.postAtTime(paramRunnable, this.uAi);
    }
    AppMethodBeat.o(104619);
  }
  
  public final int daY()
  {
    return this.uzU[0];
  }
  
  public final int daZ()
  {
    return this.uzU[1];
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(104631);
    if (this.uzX)
    {
      this.Ko.set(getBounds());
      this.uzV = (this.Ko.width() / this.uzU[0]);
      this.uzW = (this.Ko.height() / this.uzU[1]);
      this.uzX = false;
    }
    if (this.mPaint.getShader() == null)
    {
      if (this.uAg == 0L) {
        this.uAg = System.currentTimeMillis();
      }
      int[] arrayOfInt = this.uzY;
      if (arrayOfInt != null) {
        if ((!this.uAa) && (this.uzZ != null))
        {
          paramCanvas.scale(this.Ko.width() / this.uzZ.getWidth(), this.Ko.width() / this.uzZ.getHeight());
          paramCanvas.drawBitmap(this.uzZ, 0.0F, 0.0F, this.mPaint);
        }
      }
      for (;;)
      {
        this.uAh = (System.currentTimeMillis() - this.uAg);
        if ((this.uAk) || (this.uzU[2] <= 0)) {
          break label426;
        }
        if (this.uzU[4] < 0) {
          ad.i("MicroMsg.GIF.MMGIFDrawable", "current index error. start first frame");
        }
        if ((this.uAl == 0) || (this.uAm <= this.uAl - 1)) {
          break;
        }
        m(this.uAq, 0L);
        AppMethodBeat.o(104631);
        return;
        if (arrayOfInt.length == this.uzU[0] * this.uzU[1])
        {
          paramCanvas.scale(this.uzV, this.uzW);
          paramCanvas.drawBitmap(arrayOfInt, 0, this.uzU[0], 0.0F, 0.0F, this.uzU[0], this.uzU[1], true, this.mPaint);
        }
        else
        {
          paramCanvas.scale(this.uzV, this.uzW);
          paramCanvas.drawRGB(230, 230, 230);
          ad.w("MicroMsg.GIF.MMGIFDrawable", "colors is not equal width*height. length:%d width:%d height:%d", new Object[] { Integer.valueOf(arrayOfInt.length), Integer.valueOf(this.uzU[0]), Integer.valueOf(this.uzU[1]) });
          continue;
          ad.e("MicroMsg.GIF.MMGIFDrawable", "colors is null.");
        }
      }
      if (this.uAo)
      {
        com.tencent.mm.av.a.h(this.uAv, 0L);
        this.uAo = false;
        AppMethodBeat.o(104631);
        return;
        label426:
        ad.e("MicroMsg.GIF.MMGIFDrawable", "framecount:%d errorcode:%d no post and oversize:%b", new Object[] { Integer.valueOf(this.uzU[2]), Integer.valueOf(this.uzU[4]), Boolean.valueOf(this.uAk) });
      }
      AppMethodBeat.o(104631);
      return;
    }
    ad.i("MicroMsg.GIF.MMGIFDrawable", "colors drawRect ");
    paramCanvas.drawRect(this.Ko, this.mPaint);
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
      this.mDensity = (com.tencent.mm.cc.a.getDensity(aj.getContext()) / 2.0F);
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
    int i = (int)(this.uzU[1] * getEmojiDensityScale());
    AppMethodBeat.o(104629);
    return i;
  }
  
  public final int getIntrinsicWidth()
  {
    AppMethodBeat.i(104628);
    int i = (int)(this.uzU[0] * getEmojiDensityScale());
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
    this.uzX = true;
    AppMethodBeat.o(104630);
  }
  
  public final void pause()
  {
    this.mIsRunning = false;
  }
  
  public final void recycle()
  {
    AppMethodBeat.i(104638);
    ad.d("MicroMsg.GIF.MMGIFDrawable", "recycle");
    this.uzR = true;
    this.mIsRunning = false;
    long l = this.uzS;
    this.uzS = 0L;
    MMGIFJNI.recycle(l);
    this.uzY = null;
    if (this.uzT != null) {
      try
      {
        this.uzT.close();
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
    this.uzR = false;
    this.mIsRunning = true;
    com.tencent.mm.av.a.h(this.uAt, 0L);
    AppMethodBeat.o(104637);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(104636);
    if (!this.uzR)
    {
      this.mIsRunning = true;
      m(this.uAr, 0L);
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
    com.tencent.mm.av.a.h(this.uAs, 0L);
    AppMethodBeat.o(104634);
  }
  
  public final void stop()
  {
    boolean bool2 = true;
    AppMethodBeat.i(104635);
    ad.d("MicroMsg.GIF.MMGIFDrawable", "stop");
    this.mIsRunning = false;
    if (this.fKU != 0)
    {
      ad.i("MicroMsg.GIF.MMGIFDrawable", "summerhardcoder stopPerformance startPerformance:%x ", new Object[] { Integer.valueOf(this.fKU) });
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
      WXHardCoderJNI.stopPerformance(bool1, this.fKU);
      this.fKU = 0;
      com.tencent.mm.av.a.h(this.uAu, 300L);
      AppMethodBeat.o(104635);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.d
 * JD-Core Version:    0.7.0.1
 */