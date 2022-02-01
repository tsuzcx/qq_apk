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
import com.tencent.mm.plugin.m.a.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.io.InputStream;

public final class d
  extends b
{
  private boolean JgH;
  private volatile long JgI;
  private AssetFileDescriptor JgJ;
  public final int[] JgK;
  private float JgL;
  private float JgM;
  private boolean JgN;
  private int[] JgO;
  private Bitmap JgP;
  private boolean JgQ;
  private int JgR;
  private int JgS;
  private long JgT;
  private long JgU;
  private long JgV;
  private long JgW;
  private long JgX;
  private long JgY;
  private int JgZ;
  private boolean Jha;
  public int Jhb;
  private int Jhc;
  j Jhd;
  private boolean Jhe;
  private boolean Jhf;
  private final Runnable Jhg;
  private final Runnable Jhh;
  private final Runnable Jhi;
  private final Runnable Jhj;
  private final Runnable Jhk;
  private final Runnable Jhl;
  private final Rect bre;
  private MMHandler eqE;
  private int lyw;
  private float mDensity;
  private boolean mIsRunning;
  private final Paint mPaint;
  
  public d(Resources paramResources, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(260501);
    this.mIsRunning = true;
    this.JgH = false;
    this.JgJ = null;
    this.JgK = new int[6];
    this.JgL = 1.0F;
    this.JgM = 1.0F;
    this.bre = new Rect();
    this.mPaint = new Paint(6);
    this.JgQ = false;
    this.JgR = 0;
    this.JgS = -1;
    this.JgT = 0L;
    this.JgU = 0L;
    this.JgV = 0L;
    this.JgW = 0L;
    this.JgY = 0L;
    this.Jha = false;
    this.Jhb = 0;
    this.Jhc = 0;
    this.eqE = new MMHandler(Looper.getMainLooper());
    this.Jhe = true;
    this.Jhf = false;
    this.Jhg = new Runnable()
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
    this.Jhh = new Runnable()
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
    this.Jhi = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104615);
        MMGIFJNI.restoreRemainder(d.e(d.this));
        d.a(d.this, d.f(d.this), d.g(d.this));
        AppMethodBeat.o(104615);
      }
    };
    this.Jhj = new Runnable()
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
    this.Jhk = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104617);
        MMGIFJNI.saveRemainder(d.e(d.this));
        AppMethodBeat.o(104617);
      }
    };
    this.Jhl = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104618);
        if (d.h(d.this))
        {
          Log.i("MicroMsg.GIF.MMGIFDrawable", "This gif had been recycle.");
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
            Log.d("MicroMsg.GIF.MMGIFDrawable", "Render time:%d InvalidateUseTime:%d NextRealInvalidateTime:%d mNextFrameDuration:%d mCurrentFrameIndex:%d", new Object[] { Long.valueOf(d.o(d.this)), Long.valueOf(d.p(d.this)), Long.valueOf(d.g(d.this)), Long.valueOf(d.n(d.this)), Integer.valueOf(d.k(d.this)[5]) });
            h.OAn.idkeyStat(401L, 0L, 1L, false);
            h.OAn.idkeyStat(401L, 1L, Math.abs(d.g(d.this)), false);
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
    this.Jhf = paramBoolean;
    paramResources = paramResources.openRawResource(paramInt);
    if (paramResources == null)
    {
      paramResources = new NullPointerException("input stream is null.");
      AppMethodBeat.o(260501);
      throw paramResources;
    }
    paramBoolean = WXHardCoderJNI.hcGifEnable;
    int j = WXHardCoderJNI.hcGifDelay;
    int k = WXHardCoderJNI.hcGifCPU;
    int m = WXHardCoderJNI.hcGifIO;
    paramInt = i;
    if (WXHardCoderJNI.hcGifThr) {
      paramInt = Process.myTid();
    }
    this.lyw = WXHardCoderJNI.startPerformance(paramBoolean, j, k, m, paramInt, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, "MicroMsg.GIF.MMGIFDrawable");
    this.JgI = MMGIFJNI.openByInputStrem(paramResources, this.JgK);
    init();
    AppMethodBeat.o(260501);
  }
  
  public d(InputStream paramInputStream)
  {
    AppMethodBeat.i(104623);
    this.mIsRunning = true;
    this.JgH = false;
    this.JgJ = null;
    this.JgK = new int[6];
    this.JgL = 1.0F;
    this.JgM = 1.0F;
    this.bre = new Rect();
    this.mPaint = new Paint(6);
    this.JgQ = false;
    this.JgR = 0;
    this.JgS = -1;
    this.JgT = 0L;
    this.JgU = 0L;
    this.JgV = 0L;
    this.JgW = 0L;
    this.JgY = 0L;
    this.Jha = false;
    this.Jhb = 0;
    this.Jhc = 0;
    this.eqE = new MMHandler(Looper.getMainLooper());
    this.Jhe = true;
    this.Jhf = false;
    this.Jhg = new Runnable()
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
    this.Jhh = new Runnable()
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
    this.Jhi = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104615);
        MMGIFJNI.restoreRemainder(d.e(d.this));
        d.a(d.this, d.f(d.this), d.g(d.this));
        AppMethodBeat.o(104615);
      }
    };
    this.Jhj = new Runnable()
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
    this.Jhk = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104617);
        MMGIFJNI.saveRemainder(d.e(d.this));
        AppMethodBeat.o(104617);
      }
    };
    this.Jhl = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104618);
        if (d.h(d.this))
        {
          Log.i("MicroMsg.GIF.MMGIFDrawable", "This gif had been recycle.");
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
            Log.d("MicroMsg.GIF.MMGIFDrawable", "Render time:%d InvalidateUseTime:%d NextRealInvalidateTime:%d mNextFrameDuration:%d mCurrentFrameIndex:%d", new Object[] { Long.valueOf(d.o(d.this)), Long.valueOf(d.p(d.this)), Long.valueOf(d.g(d.this)), Long.valueOf(d.n(d.this)), Integer.valueOf(d.k(d.this)[5]) });
            h.OAn.idkeyStat(401L, 0L, 1L, false);
            h.OAn.idkeyStat(401L, 1L, Math.abs(d.g(d.this)), false);
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
    this.lyw = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, "MicroMsg.GIF.MMGIFDrawable");
    this.JgI = MMGIFJNI.openByInputStrem(paramInputStream, this.JgK);
    init();
    AppMethodBeat.o(104623);
  }
  
  public d(String paramString)
  {
    AppMethodBeat.i(104622);
    this.mIsRunning = true;
    this.JgH = false;
    this.JgJ = null;
    this.JgK = new int[6];
    this.JgL = 1.0F;
    this.JgM = 1.0F;
    this.bre = new Rect();
    this.mPaint = new Paint(6);
    this.JgQ = false;
    this.JgR = 0;
    this.JgS = -1;
    this.JgT = 0L;
    this.JgU = 0L;
    this.JgV = 0L;
    this.JgW = 0L;
    this.JgY = 0L;
    this.Jha = false;
    this.Jhb = 0;
    this.Jhc = 0;
    this.eqE = new MMHandler(Looper.getMainLooper());
    this.Jhe = true;
    this.Jhf = false;
    this.Jhg = new Runnable()
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
    this.Jhh = new Runnable()
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
    this.Jhi = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104615);
        MMGIFJNI.restoreRemainder(d.e(d.this));
        d.a(d.this, d.f(d.this), d.g(d.this));
        AppMethodBeat.o(104615);
      }
    };
    this.Jhj = new Runnable()
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
    this.Jhk = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104617);
        MMGIFJNI.saveRemainder(d.e(d.this));
        AppMethodBeat.o(104617);
      }
    };
    this.Jhl = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104618);
        if (d.h(d.this))
        {
          Log.i("MicroMsg.GIF.MMGIFDrawable", "This gif had been recycle.");
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
            Log.d("MicroMsg.GIF.MMGIFDrawable", "Render time:%d InvalidateUseTime:%d NextRealInvalidateTime:%d mNextFrameDuration:%d mCurrentFrameIndex:%d", new Object[] { Long.valueOf(d.o(d.this)), Long.valueOf(d.p(d.this)), Long.valueOf(d.g(d.this)), Long.valueOf(d.n(d.this)), Integer.valueOf(d.k(d.this)[5]) });
            h.OAn.idkeyStat(401L, 0L, 1L, false);
            h.OAn.idkeyStat(401L, 1L, Math.abs(d.g(d.this)), false);
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
      this.lyw = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, "MicroMsg.GIF.MMGIFDrawable");
      this.JgI = MMGIFJNI.openByFilePath(q.n(paramString, false), this.JgK);
      init();
      AppMethodBeat.o(104622);
      return;
    }
  }
  
  public d(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(104621);
    this.mIsRunning = true;
    this.JgH = false;
    this.JgJ = null;
    this.JgK = new int[6];
    this.JgL = 1.0F;
    this.JgM = 1.0F;
    this.bre = new Rect();
    this.mPaint = new Paint(6);
    this.JgQ = false;
    this.JgR = 0;
    this.JgS = -1;
    this.JgT = 0L;
    this.JgU = 0L;
    this.JgV = 0L;
    this.JgW = 0L;
    this.JgY = 0L;
    this.Jha = false;
    this.Jhb = 0;
    this.Jhc = 0;
    this.eqE = new MMHandler(Looper.getMainLooper());
    this.Jhe = true;
    this.Jhf = false;
    this.Jhg = new Runnable()
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
    this.Jhh = new Runnable()
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
    this.Jhi = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104615);
        MMGIFJNI.restoreRemainder(d.e(d.this));
        d.a(d.this, d.f(d.this), d.g(d.this));
        AppMethodBeat.o(104615);
      }
    };
    this.Jhj = new Runnable()
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
    this.Jhk = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104617);
        MMGIFJNI.saveRemainder(d.e(d.this));
        AppMethodBeat.o(104617);
      }
    };
    this.Jhl = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104618);
        if (d.h(d.this))
        {
          Log.i("MicroMsg.GIF.MMGIFDrawable", "This gif had been recycle.");
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
            Log.d("MicroMsg.GIF.MMGIFDrawable", "Render time:%d InvalidateUseTime:%d NextRealInvalidateTime:%d mNextFrameDuration:%d mCurrentFrameIndex:%d", new Object[] { Long.valueOf(d.o(d.this)), Long.valueOf(d.p(d.this)), Long.valueOf(d.g(d.this)), Long.valueOf(d.n(d.this)), Integer.valueOf(d.k(d.this)[5]) });
            h.OAn.idkeyStat(401L, 0L, 1L, false);
            h.OAn.idkeyStat(401L, 1L, Math.abs(d.g(d.this)), false);
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
    this.Jhf = paramBoolean;
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
    this.lyw = WXHardCoderJNI.startPerformance(paramBoolean, j, k, m, i, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, "MicroMsg.GIF.MMGIFDrawable");
    this.JgI = MMGIFJNI.openByFilePath(paramString, this.JgK);
    init();
    AppMethodBeat.o(104621);
  }
  
  public d(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, false);
    AppMethodBeat.i(104625);
    AppMethodBeat.o(104625);
  }
  
  public d(byte[] paramArrayOfByte, String paramString)
  {
    this(paramArrayOfByte);
    AppMethodBeat.i(104624);
    paramArrayOfByte = com.tencent.mm.emoji.b.a.b.mgs;
    if (com.tencent.mm.emoji.b.a.b.Eo(paramString) != null)
    {
      paramArrayOfByte = com.tencent.mm.emoji.b.a.b.mgs;
      this.JgP = com.tencent.mm.emoji.b.a.b.Eo(paramString);
    }
    AppMethodBeat.o(104624);
  }
  
  public d(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(260521);
    this.mIsRunning = true;
    this.JgH = false;
    this.JgJ = null;
    this.JgK = new int[6];
    this.JgL = 1.0F;
    this.JgM = 1.0F;
    this.bre = new Rect();
    this.mPaint = new Paint(6);
    this.JgQ = false;
    this.JgR = 0;
    this.JgS = -1;
    this.JgT = 0L;
    this.JgU = 0L;
    this.JgV = 0L;
    this.JgW = 0L;
    this.JgY = 0L;
    this.Jha = false;
    this.Jhb = 0;
    this.Jhc = 0;
    this.eqE = new MMHandler(Looper.getMainLooper());
    this.Jhe = true;
    this.Jhf = false;
    this.Jhg = new Runnable()
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
    this.Jhh = new Runnable()
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
    this.Jhi = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104615);
        MMGIFJNI.restoreRemainder(d.e(d.this));
        d.a(d.this, d.f(d.this), d.g(d.this));
        AppMethodBeat.o(104615);
      }
    };
    this.Jhj = new Runnable()
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
    this.Jhk = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104617);
        MMGIFJNI.saveRemainder(d.e(d.this));
        AppMethodBeat.o(104617);
      }
    };
    this.Jhl = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104618);
        if (d.h(d.this))
        {
          Log.i("MicroMsg.GIF.MMGIFDrawable", "This gif had been recycle.");
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
            Log.d("MicroMsg.GIF.MMGIFDrawable", "Render time:%d InvalidateUseTime:%d NextRealInvalidateTime:%d mNextFrameDuration:%d mCurrentFrameIndex:%d", new Object[] { Long.valueOf(d.o(d.this)), Long.valueOf(d.p(d.this)), Long.valueOf(d.g(d.this)), Long.valueOf(d.n(d.this)), Integer.valueOf(d.k(d.this)[5]) });
            h.OAn.idkeyStat(401L, 0L, 1L, false);
            h.OAn.idkeyStat(401L, 1L, Math.abs(d.g(d.this)), false);
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
    this.Jhf = paramBoolean;
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = new NullPointerException("bytes is null.");
      AppMethodBeat.o(260521);
      throw paramArrayOfByte;
    }
    paramBoolean = WXHardCoderJNI.hcGifEnable;
    int j = WXHardCoderJNI.hcGifDelay;
    int k = WXHardCoderJNI.hcGifCPU;
    int m = WXHardCoderJNI.hcGifIO;
    if (WXHardCoderJNI.hcGifThr) {
      i = Process.myTid();
    }
    this.lyw = WXHardCoderJNI.startPerformance(paramBoolean, j, k, m, i, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, "MicroMsg.GIF.MMGIFDrawable");
    this.JgI = MMGIFJNI.openByByteArray(paramArrayOfByte, this.JgK);
    init();
    AppMethodBeat.o(260521);
  }
  
  private void init()
  {
    AppMethodBeat.i(104626);
    Log.i("MicroMsg.GIF.MMGIFDrawable", "gif info pointer:%d", new Object[] { Long.valueOf(this.JgI) });
    this.JgR = this.JgK[2];
    this.JgZ = com.tencent.mm.cd.a.br(MMApplicationContext.getContext(), a.e.emoji_view_image_size);
    if ((!this.Jhf) && ((this.JgK[0] > 1024) || (this.JgK[1] > 1024)))
    {
      Log.w("MicroMsg.GIF.MMGIFDrawable", "emoji width or height over size. Width:%d Height:%d", new Object[] { Integer.valueOf(this.JgK[0]), Integer.valueOf(this.JgK[1]) });
      this.JgO = new int[this.JgZ * this.JgZ];
      this.Jha = true;
      h.OAn.idkeyStat(401L, 2L, 1L, false);
      AppMethodBeat.o(104626);
      return;
    }
    this.JgO = new int[this.JgK[0] * this.JgK[1]];
    AppMethodBeat.o(104626);
  }
  
  private void l(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(104619);
    this.JgY = (SystemClock.uptimeMillis() + paramLong);
    if (this.eqE != null) {
      this.eqE.postAtTime(paramRunnable, this.JgY);
    }
    AppMethodBeat.o(104619);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(104631);
    if (this.JgN)
    {
      this.bre.set(getBounds());
      this.JgL = (this.bre.width() / this.JgK[0]);
      this.JgM = (this.bre.height() / this.JgK[1]);
      this.JgN = false;
    }
    if (this.mPaint.getShader() == null)
    {
      if (this.JgW == 0L) {
        this.JgW = System.currentTimeMillis();
      }
      int[] arrayOfInt = this.JgO;
      if (arrayOfInt != null) {
        if ((!this.JgQ) && (this.JgP != null))
        {
          paramCanvas.scale(this.bre.width() / this.JgP.getWidth(), this.bre.width() / this.JgP.getHeight());
          paramCanvas.drawBitmap(this.JgP, 0.0F, 0.0F, this.mPaint);
        }
      }
      for (;;)
      {
        this.JgX = (System.currentTimeMillis() - this.JgW);
        if ((this.Jha) || (this.JgK[2] <= 0)) {
          break label426;
        }
        if (this.JgK[4] < 0) {
          Log.i("MicroMsg.GIF.MMGIFDrawable", "current index error. start first frame");
        }
        if ((this.Jhb == 0) || (this.Jhc <= this.Jhb - 1)) {
          break;
        }
        l(this.Jhg, 0L);
        AppMethodBeat.o(104631);
        return;
        if (arrayOfInt.length == this.JgK[0] * this.JgK[1])
        {
          paramCanvas.scale(this.JgL, this.JgM);
          paramCanvas.drawBitmap(arrayOfInt, 0, this.JgK[0], 0.0F, 0.0F, this.JgK[0], this.JgK[1], true, this.mPaint);
        }
        else
        {
          paramCanvas.scale(this.JgL, this.JgM);
          paramCanvas.drawRGB(230, 230, 230);
          Log.w("MicroMsg.GIF.MMGIFDrawable", "colors is not equal width*height. length:%d width:%d height:%d", new Object[] { Integer.valueOf(arrayOfInt.length), Integer.valueOf(this.JgK[0]), Integer.valueOf(this.JgK[1]) });
          continue;
          Log.e("MicroMsg.GIF.MMGIFDrawable", "colors is null.");
        }
      }
      if (this.Jhe)
      {
        com.tencent.mm.at.a.g(this.Jhl, 0L);
        this.Jhe = false;
        AppMethodBeat.o(104631);
        return;
        label426:
        Log.e("MicroMsg.GIF.MMGIFDrawable", "framecount:%d errorcode:%d no post and oversize:%b", new Object[] { Integer.valueOf(this.JgK[2]), Integer.valueOf(this.JgK[4]), Boolean.valueOf(this.Jha) });
      }
      AppMethodBeat.o(104631);
      return;
    }
    Log.i("MicroMsg.GIF.MMGIFDrawable", "colors drawRect ");
    paramCanvas.drawRect(this.bre, this.mPaint);
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
    finally
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
      this.mDensity = (com.tencent.mm.cd.a.getDensity(MMApplicationContext.getContext()) / 2.0F);
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
    int i = (int)(this.JgK[1] * getEmojiDensityScale());
    AppMethodBeat.o(104629);
    return i;
  }
  
  public final int getIntrinsicWidth()
  {
    AppMethodBeat.i(104628);
    int i = (int)(this.JgK[0] * getEmojiDensityScale());
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
    this.JgN = true;
    AppMethodBeat.o(104630);
  }
  
  public final void pause()
  {
    this.mIsRunning = false;
  }
  
  public final void recycle()
  {
    AppMethodBeat.i(104638);
    Log.d("MicroMsg.GIF.MMGIFDrawable", "recycle");
    this.JgH = true;
    this.mIsRunning = false;
    long l = this.JgI;
    this.JgI = 0L;
    MMGIFJNI.recycle(l);
    this.JgO = null;
    if (this.JgJ != null) {
      try
      {
        this.JgJ.close();
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
    this.JgH = false;
    this.mIsRunning = true;
    com.tencent.mm.at.a.g(this.Jhj, 0L);
    AppMethodBeat.o(104637);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(104636);
    if (!this.JgH)
    {
      this.mIsRunning = true;
      l(this.Jhh, 0L);
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
    com.tencent.mm.at.a.g(this.Jhi, 0L);
    AppMethodBeat.o(104634);
  }
  
  public final void stop()
  {
    boolean bool2 = true;
    AppMethodBeat.i(104635);
    Log.d("MicroMsg.GIF.MMGIFDrawable", "stop");
    this.mIsRunning = false;
    if (this.lyw != 0)
    {
      Log.i("MicroMsg.GIF.MMGIFDrawable", "summerhardcoder stopPerformance startPerformance:%x ", new Object[] { Integer.valueOf(this.lyw) });
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
      WXHardCoderJNI.stopPerformance(bool1, this.lyw);
      this.lyw = 0;
      com.tencent.mm.at.a.g(this.Jhk, 300L);
      AppMethodBeat.o(104635);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.d
 * JD-Core Version:    0.7.0.1
 */