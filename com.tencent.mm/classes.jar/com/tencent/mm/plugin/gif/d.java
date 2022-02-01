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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import java.io.InputStream;

public final class d
  extends b
{
  private final Rect Hy;
  private int foV;
  private float mDensity;
  private boolean mIsRunning;
  private final Paint mPaint;
  private ap oFl;
  private long spA;
  private long spB;
  private long spC;
  private long spD;
  private long spE;
  private long spF;
  private int spG;
  private boolean spH;
  int spI;
  private int spJ;
  k spK;
  private boolean spL;
  private boolean spM;
  private final Runnable spN;
  private final Runnable spO;
  private final Runnable spP;
  private final Runnable spQ;
  private final Runnable spR;
  private final Runnable spS;
  private boolean spo;
  private volatile long spp;
  private AssetFileDescriptor spq;
  private final int[] spr;
  private float sps;
  private float spt;
  private boolean spu;
  private int[] spv;
  private Bitmap spw;
  private boolean spx;
  private int spy;
  private int spz;
  
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
    this.spo = false;
    this.spq = null;
    this.spr = new int[6];
    this.sps = 1.0F;
    this.spt = 1.0F;
    this.Hy = new Rect();
    this.mPaint = new Paint(6);
    this.spx = false;
    this.spy = 0;
    this.spz = -1;
    this.spA = 0L;
    this.spB = 0L;
    this.spC = 0L;
    this.spD = 0L;
    this.spF = 0L;
    this.spH = false;
    this.spI = 0;
    this.spJ = 0;
    this.oFl = new ap(Looper.getMainLooper());
    this.spL = true;
    this.spM = false;
    this.spN = new Runnable()
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
    this.spO = new Runnable()
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
    this.spP = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104615);
        MMGIFJNI.restoreRemainder(d.e(d.this));
        d.a(d.this, d.f(d.this), d.g(d.this));
        AppMethodBeat.o(104615);
      }
    };
    this.spQ = new Runnable()
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
    this.spR = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104617);
        MMGIFJNI.saveRemainder(d.e(d.this));
        AppMethodBeat.o(104617);
      }
    };
    this.spS = new Runnable()
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
            h.vKh.idkeyStat(401L, 0L, 1L, false);
            h.vKh.idkeyStat(401L, 1L, Math.abs(d.g(d.this)), false);
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
    this.foV = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, "MicroMsg.GIF.MMGIFDrawable");
    this.spp = MMGIFJNI.openByInputStrem(paramInputStream, this.spr);
    init();
    AppMethodBeat.o(104623);
  }
  
  public d(String paramString)
  {
    AppMethodBeat.i(104622);
    this.mIsRunning = true;
    this.spo = false;
    this.spq = null;
    this.spr = new int[6];
    this.sps = 1.0F;
    this.spt = 1.0F;
    this.Hy = new Rect();
    this.mPaint = new Paint(6);
    this.spx = false;
    this.spy = 0;
    this.spz = -1;
    this.spA = 0L;
    this.spB = 0L;
    this.spC = 0L;
    this.spD = 0L;
    this.spF = 0L;
    this.spH = false;
    this.spI = 0;
    this.spJ = 0;
    this.oFl = new ap(Looper.getMainLooper());
    this.spL = true;
    this.spM = false;
    this.spN = new Runnable()
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
    this.spO = new Runnable()
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
    this.spP = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104615);
        MMGIFJNI.restoreRemainder(d.e(d.this));
        d.a(d.this, d.f(d.this), d.g(d.this));
        AppMethodBeat.o(104615);
      }
    };
    this.spQ = new Runnable()
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
    this.spR = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104617);
        MMGIFJNI.saveRemainder(d.e(d.this));
        AppMethodBeat.o(104617);
      }
    };
    this.spS = new Runnable()
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
            h.vKh.idkeyStat(401L, 0L, 1L, false);
            h.vKh.idkeyStat(401L, 1L, Math.abs(d.g(d.this)), false);
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
      this.foV = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, "MicroMsg.GIF.MMGIFDrawable");
      this.spp = MMGIFJNI.openByFilePath(q.k(paramString, false), this.spr);
      init();
      AppMethodBeat.o(104622);
      return;
    }
  }
  
  public d(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(104621);
    this.mIsRunning = true;
    this.spo = false;
    this.spq = null;
    this.spr = new int[6];
    this.sps = 1.0F;
    this.spt = 1.0F;
    this.Hy = new Rect();
    this.mPaint = new Paint(6);
    this.spx = false;
    this.spy = 0;
    this.spz = -1;
    this.spA = 0L;
    this.spB = 0L;
    this.spC = 0L;
    this.spD = 0L;
    this.spF = 0L;
    this.spH = false;
    this.spI = 0;
    this.spJ = 0;
    this.oFl = new ap(Looper.getMainLooper());
    this.spL = true;
    this.spM = false;
    this.spN = new Runnable()
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
    this.spO = new Runnable()
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
    this.spP = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104615);
        MMGIFJNI.restoreRemainder(d.e(d.this));
        d.a(d.this, d.f(d.this), d.g(d.this));
        AppMethodBeat.o(104615);
      }
    };
    this.spQ = new Runnable()
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
    this.spR = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104617);
        MMGIFJNI.saveRemainder(d.e(d.this));
        AppMethodBeat.o(104617);
      }
    };
    this.spS = new Runnable()
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
            h.vKh.idkeyStat(401L, 0L, 1L, false);
            h.vKh.idkeyStat(401L, 1L, Math.abs(d.g(d.this)), false);
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
    this.spM = paramBoolean;
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
    this.foV = WXHardCoderJNI.startPerformance(paramBoolean, j, k, m, i, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, "MicroMsg.GIF.MMGIFDrawable");
    this.spp = MMGIFJNI.openByFilePath(paramString, this.spr);
    init();
    AppMethodBeat.o(104621);
  }
  
  public d(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(104625);
    this.mIsRunning = true;
    this.spo = false;
    this.spq = null;
    this.spr = new int[6];
    this.sps = 1.0F;
    this.spt = 1.0F;
    this.Hy = new Rect();
    this.mPaint = new Paint(6);
    this.spx = false;
    this.spy = 0;
    this.spz = -1;
    this.spA = 0L;
    this.spB = 0L;
    this.spC = 0L;
    this.spD = 0L;
    this.spF = 0L;
    this.spH = false;
    this.spI = 0;
    this.spJ = 0;
    this.oFl = new ap(Looper.getMainLooper());
    this.spL = true;
    this.spM = false;
    this.spN = new Runnable()
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
    this.spO = new Runnable()
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
    this.spP = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104615);
        MMGIFJNI.restoreRemainder(d.e(d.this));
        d.a(d.this, d.f(d.this), d.g(d.this));
        AppMethodBeat.o(104615);
      }
    };
    this.spQ = new Runnable()
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
    this.spR = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104617);
        MMGIFJNI.saveRemainder(d.e(d.this));
        AppMethodBeat.o(104617);
      }
    };
    this.spS = new Runnable()
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
            h.vKh.idkeyStat(401L, 0L, 1L, false);
            h.vKh.idkeyStat(401L, 1L, Math.abs(d.g(d.this)), false);
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
    this.foV = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, "MicroMsg.GIF.MMGIFDrawable");
    this.spp = MMGIFJNI.openByByteArray(paramArrayOfByte, this.spr);
    init();
    AppMethodBeat.o(104625);
  }
  
  public d(byte[] paramArrayOfByte, String paramString)
  {
    this(paramArrayOfByte);
    AppMethodBeat.i(104624);
    paramArrayOfByte = com.tencent.mm.emoji.loader.a.b.fLw;
    if (com.tencent.mm.emoji.loader.a.b.pT(paramString) != null)
    {
      paramArrayOfByte = com.tencent.mm.emoji.loader.a.b.fLw;
      this.spw = com.tencent.mm.emoji.loader.a.b.pT(paramString);
    }
    AppMethodBeat.o(104624);
  }
  
  private void init()
  {
    AppMethodBeat.i(104626);
    ad.i("MicroMsg.GIF.MMGIFDrawable", "gif info pointer:%d", new Object[] { Long.valueOf(this.spp) });
    this.spy = this.spr[2];
    this.spG = com.tencent.mm.cd.a.ao(aj.getContext(), 2131166264);
    if ((!this.spM) && ((this.spr[0] > 1024) || (this.spr[1] > 1024)))
    {
      ad.w("MicroMsg.GIF.MMGIFDrawable", "emoji width or height over size. Width:%d Height:%d", new Object[] { Integer.valueOf(this.spr[0]), Integer.valueOf(this.spr[1]) });
      this.spv = new int[this.spG * this.spG];
      this.spH = true;
      h.vKh.idkeyStat(401L, 2L, 1L, false);
      AppMethodBeat.o(104626);
      return;
    }
    this.spv = new int[this.spr[0] * this.spr[1]];
    AppMethodBeat.o(104626);
  }
  
  private void l(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(104619);
    this.spF = (SystemClock.uptimeMillis() + paramLong);
    if (this.oFl != null) {
      this.oFl.postAtTime(paramRunnable, this.spF);
    }
    AppMethodBeat.o(104619);
  }
  
  public final int cEI()
  {
    return this.spr[0];
  }
  
  public final int cEJ()
  {
    return this.spr[1];
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(104631);
    if (this.spu)
    {
      this.Hy.set(getBounds());
      this.sps = (this.Hy.width() / this.spr[0]);
      this.spt = (this.Hy.height() / this.spr[1]);
      this.spu = false;
    }
    if (this.mPaint.getShader() == null)
    {
      if (this.spD == 0L) {
        this.spD = System.currentTimeMillis();
      }
      int[] arrayOfInt = this.spv;
      if (arrayOfInt != null) {
        if ((!this.spx) && (this.spw != null))
        {
          paramCanvas.scale(this.Hy.width() / this.spw.getWidth(), this.Hy.width() / this.spw.getHeight());
          paramCanvas.drawBitmap(this.spw, 0.0F, 0.0F, this.mPaint);
        }
      }
      for (;;)
      {
        this.spE = (System.currentTimeMillis() - this.spD);
        if ((this.spH) || (this.spr[2] <= 0)) {
          break label426;
        }
        if (this.spr[4] < 0) {
          ad.i("MicroMsg.GIF.MMGIFDrawable", "current index error. start first frame");
        }
        if ((this.spI == 0) || (this.spJ <= this.spI - 1)) {
          break;
        }
        l(this.spN, 0L);
        AppMethodBeat.o(104631);
        return;
        if (arrayOfInt.length == this.spr[0] * this.spr[1])
        {
          paramCanvas.scale(this.sps, this.spt);
          paramCanvas.drawBitmap(arrayOfInt, 0, this.spr[0], 0.0F, 0.0F, this.spr[0], this.spr[1], true, this.mPaint);
        }
        else
        {
          paramCanvas.scale(this.sps, this.spt);
          paramCanvas.drawRGB(230, 230, 230);
          ad.w("MicroMsg.GIF.MMGIFDrawable", "colors is not equal width*height. length:%d width:%d height:%d", new Object[] { Integer.valueOf(arrayOfInt.length), Integer.valueOf(this.spr[0]), Integer.valueOf(this.spr[1]) });
          continue;
          ad.e("MicroMsg.GIF.MMGIFDrawable", "colors is null.");
        }
      }
      if (this.spL)
      {
        com.tencent.mm.av.a.g(this.spS, 0L);
        this.spL = false;
        AppMethodBeat.o(104631);
        return;
        label426:
        ad.e("MicroMsg.GIF.MMGIFDrawable", "framecount:%d errorcode:%d no post and oversize:%b", new Object[] { Integer.valueOf(this.spr[2]), Integer.valueOf(this.spr[4]), Boolean.valueOf(this.spH) });
      }
      AppMethodBeat.o(104631);
      return;
    }
    ad.i("MicroMsg.GIF.MMGIFDrawable", "colors drawRect ");
    paramCanvas.drawRect(this.Hy, this.mPaint);
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
      this.mDensity = (com.tencent.mm.cd.a.getDensity(aj.getContext()) / 2.0F);
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
    int i = (int)(this.spr[1] * getEmojiDensityScale());
    AppMethodBeat.o(104629);
    return i;
  }
  
  public final int getIntrinsicWidth()
  {
    AppMethodBeat.i(104628);
    int i = (int)(this.spr[0] * getEmojiDensityScale());
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
    this.spu = true;
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
    this.spo = true;
    this.mIsRunning = false;
    long l = this.spp;
    this.spp = 0L;
    MMGIFJNI.recycle(l);
    this.spv = null;
    if (this.spq != null) {
      try
      {
        this.spq.close();
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
    this.spo = false;
    this.mIsRunning = true;
    com.tencent.mm.av.a.g(this.spQ, 0L);
    AppMethodBeat.o(104637);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(104636);
    if (!this.spo)
    {
      this.mIsRunning = true;
      l(this.spO, 0L);
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
    com.tencent.mm.av.a.g(this.spP, 0L);
    AppMethodBeat.o(104634);
  }
  
  public final void stop()
  {
    boolean bool2 = true;
    AppMethodBeat.i(104635);
    ad.d("MicroMsg.GIF.MMGIFDrawable", "stop");
    this.mIsRunning = false;
    if (this.foV != 0)
    {
      ad.i("MicroMsg.GIF.MMGIFDrawable", "summerhardcoder stopPerformance startPerformance:%x ", new Object[] { Integer.valueOf(this.foV) });
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
      WXHardCoderJNI.stopPerformance(bool1, this.foV);
      this.foV = 0;
      com.tencent.mm.av.a.g(this.spR, 300L);
      AppMethodBeat.o(104635);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.d
 * JD-Core Version:    0.7.0.1
 */