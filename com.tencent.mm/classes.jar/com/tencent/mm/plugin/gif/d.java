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
  private boolean DmX;
  private volatile long DmY;
  private AssetFileDescriptor DmZ;
  private final Runnable DnA;
  private final Runnable DnB;
  private final int[] Dna;
  private float Dnb;
  private float Dnc;
  private boolean Dnd;
  private int[] Dne;
  private Bitmap Dnf;
  private boolean Dng;
  private int Dnh;
  private int Dni;
  private long Dnj;
  private long Dnk;
  private long Dnl;
  private long Dnm;
  private long Dnn;
  private long Dno;
  private int Dnp;
  private boolean Dnq;
  public int Dnr;
  private int Dns;
  j Dnt;
  private boolean Dnu;
  private boolean Dnv;
  private final Runnable Dnw;
  private final Runnable Dnx;
  private final Runnable Dny;
  private final Runnable Dnz;
  private final Rect KV;
  private MMHandler cyl;
  private int iWt;
  private float mDensity;
  private boolean mIsRunning;
  private final Paint mPaint;
  
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
    this.DmX = false;
    this.DmZ = null;
    this.Dna = new int[6];
    this.Dnb = 1.0F;
    this.Dnc = 1.0F;
    this.KV = new Rect();
    this.mPaint = new Paint(6);
    this.Dng = false;
    this.Dnh = 0;
    this.Dni = -1;
    this.Dnj = 0L;
    this.Dnk = 0L;
    this.Dnl = 0L;
    this.Dnm = 0L;
    this.Dno = 0L;
    this.Dnq = false;
    this.Dnr = 0;
    this.Dns = 0;
    this.cyl = new MMHandler(Looper.getMainLooper());
    this.Dnu = true;
    this.Dnv = false;
    this.Dnw = new Runnable()
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
    this.Dnx = new Runnable()
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
    this.Dny = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104615);
        MMGIFJNI.restoreRemainder(d.e(d.this));
        d.a(d.this, d.f(d.this), d.g(d.this));
        AppMethodBeat.o(104615);
      }
    };
    this.Dnz = new Runnable()
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
    this.DnA = new d.5(this);
    this.DnB = new Runnable()
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
            h.IzE.idkeyStat(401L, 0L, 1L, false);
            h.IzE.idkeyStat(401L, 1L, Math.abs(d.g(d.this)), false);
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
    this.iWt = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, "MicroMsg.GIF.MMGIFDrawable");
    this.DmY = MMGIFJNI.openByInputStrem(paramInputStream, this.Dna);
    init();
    AppMethodBeat.o(104623);
  }
  
  public d(String paramString)
  {
    AppMethodBeat.i(104622);
    this.mIsRunning = true;
    this.DmX = false;
    this.DmZ = null;
    this.Dna = new int[6];
    this.Dnb = 1.0F;
    this.Dnc = 1.0F;
    this.KV = new Rect();
    this.mPaint = new Paint(6);
    this.Dng = false;
    this.Dnh = 0;
    this.Dni = -1;
    this.Dnj = 0L;
    this.Dnk = 0L;
    this.Dnl = 0L;
    this.Dnm = 0L;
    this.Dno = 0L;
    this.Dnq = false;
    this.Dnr = 0;
    this.Dns = 0;
    this.cyl = new MMHandler(Looper.getMainLooper());
    this.Dnu = true;
    this.Dnv = false;
    this.Dnw = new Runnable()
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
    this.Dnx = new Runnable()
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
    this.Dny = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104615);
        MMGIFJNI.restoreRemainder(d.e(d.this));
        d.a(d.this, d.f(d.this), d.g(d.this));
        AppMethodBeat.o(104615);
      }
    };
    this.Dnz = new Runnable()
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
    this.DnA = new d.5(this);
    this.DnB = new Runnable()
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
            h.IzE.idkeyStat(401L, 0L, 1L, false);
            h.IzE.idkeyStat(401L, 1L, Math.abs(d.g(d.this)), false);
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
      this.iWt = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, "MicroMsg.GIF.MMGIFDrawable");
      this.DmY = MMGIFJNI.openByFilePath(q.n(paramString, false), this.Dna);
      init();
      AppMethodBeat.o(104622);
      return;
    }
  }
  
  public d(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(104621);
    this.mIsRunning = true;
    this.DmX = false;
    this.DmZ = null;
    this.Dna = new int[6];
    this.Dnb = 1.0F;
    this.Dnc = 1.0F;
    this.KV = new Rect();
    this.mPaint = new Paint(6);
    this.Dng = false;
    this.Dnh = 0;
    this.Dni = -1;
    this.Dnj = 0L;
    this.Dnk = 0L;
    this.Dnl = 0L;
    this.Dnm = 0L;
    this.Dno = 0L;
    this.Dnq = false;
    this.Dnr = 0;
    this.Dns = 0;
    this.cyl = new MMHandler(Looper.getMainLooper());
    this.Dnu = true;
    this.Dnv = false;
    this.Dnw = new Runnable()
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
    this.Dnx = new Runnable()
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
    this.Dny = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104615);
        MMGIFJNI.restoreRemainder(d.e(d.this));
        d.a(d.this, d.f(d.this), d.g(d.this));
        AppMethodBeat.o(104615);
      }
    };
    this.Dnz = new Runnable()
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
    this.DnA = new d.5(this);
    this.DnB = new Runnable()
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
            h.IzE.idkeyStat(401L, 0L, 1L, false);
            h.IzE.idkeyStat(401L, 1L, Math.abs(d.g(d.this)), false);
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
    this.Dnv = paramBoolean;
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
    this.iWt = WXHardCoderJNI.startPerformance(paramBoolean, j, k, m, i, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, "MicroMsg.GIF.MMGIFDrawable");
    this.DmY = MMGIFJNI.openByFilePath(paramString, this.Dna);
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
    paramArrayOfByte = com.tencent.mm.emoji.loader.a.b.jGQ;
    if (com.tencent.mm.emoji.loader.a.b.LI(paramString) != null)
    {
      paramArrayOfByte = com.tencent.mm.emoji.loader.a.b.jGQ;
      this.Dnf = com.tencent.mm.emoji.loader.a.b.LI(paramString);
    }
    AppMethodBeat.o(104624);
  }
  
  public d(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(225240);
    this.mIsRunning = true;
    this.DmX = false;
    this.DmZ = null;
    this.Dna = new int[6];
    this.Dnb = 1.0F;
    this.Dnc = 1.0F;
    this.KV = new Rect();
    this.mPaint = new Paint(6);
    this.Dng = false;
    this.Dnh = 0;
    this.Dni = -1;
    this.Dnj = 0L;
    this.Dnk = 0L;
    this.Dnl = 0L;
    this.Dnm = 0L;
    this.Dno = 0L;
    this.Dnq = false;
    this.Dnr = 0;
    this.Dns = 0;
    this.cyl = new MMHandler(Looper.getMainLooper());
    this.Dnu = true;
    this.Dnv = false;
    this.Dnw = new Runnable()
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
    this.Dnx = new Runnable()
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
    this.Dny = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104615);
        MMGIFJNI.restoreRemainder(d.e(d.this));
        d.a(d.this, d.f(d.this), d.g(d.this));
        AppMethodBeat.o(104615);
      }
    };
    this.Dnz = new Runnable()
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
    this.DnA = new d.5(this);
    this.DnB = new Runnable()
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
            h.IzE.idkeyStat(401L, 0L, 1L, false);
            h.IzE.idkeyStat(401L, 1L, Math.abs(d.g(d.this)), false);
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
    this.Dnv = paramBoolean;
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = new NullPointerException("bytes is null.");
      AppMethodBeat.o(225240);
      throw paramArrayOfByte;
    }
    paramBoolean = WXHardCoderJNI.hcGifEnable;
    int j = WXHardCoderJNI.hcGifDelay;
    int k = WXHardCoderJNI.hcGifCPU;
    int m = WXHardCoderJNI.hcGifIO;
    if (WXHardCoderJNI.hcGifThr) {
      i = Process.myTid();
    }
    this.iWt = WXHardCoderJNI.startPerformance(paramBoolean, j, k, m, i, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, "MicroMsg.GIF.MMGIFDrawable");
    this.DmY = MMGIFJNI.openByByteArray(paramArrayOfByte, this.Dna);
    init();
    AppMethodBeat.o(225240);
  }
  
  private void init()
  {
    AppMethodBeat.i(104626);
    Log.i("MicroMsg.GIF.MMGIFDrawable", "gif info pointer:%d", new Object[] { Long.valueOf(this.DmY) });
    this.Dnh = this.Dna[2];
    this.Dnp = com.tencent.mm.ci.a.aY(MMApplicationContext.getContext(), a.e.emoji_view_image_size);
    if ((!this.Dnv) && ((this.Dna[0] > 1024) || (this.Dna[1] > 1024)))
    {
      Log.w("MicroMsg.GIF.MMGIFDrawable", "emoji width or height over size. Width:%d Height:%d", new Object[] { Integer.valueOf(this.Dna[0]), Integer.valueOf(this.Dna[1]) });
      this.Dne = new int[this.Dnp * this.Dnp];
      this.Dnq = true;
      h.IzE.idkeyStat(401L, 2L, 1L, false);
      AppMethodBeat.o(104626);
      return;
    }
    this.Dne = new int[this.Dna[0] * this.Dna[1]];
    AppMethodBeat.o(104626);
  }
  
  private void k(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(104619);
    this.Dno = (SystemClock.uptimeMillis() + paramLong);
    if (this.cyl != null) {
      this.cyl.postAtTime(paramRunnable, this.Dno);
    }
    AppMethodBeat.o(104619);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(104631);
    if (this.Dnd)
    {
      this.KV.set(getBounds());
      this.Dnb = (this.KV.width() / this.Dna[0]);
      this.Dnc = (this.KV.height() / this.Dna[1]);
      this.Dnd = false;
    }
    if (this.mPaint.getShader() == null)
    {
      if (this.Dnm == 0L) {
        this.Dnm = System.currentTimeMillis();
      }
      int[] arrayOfInt = this.Dne;
      if (arrayOfInt != null) {
        if ((!this.Dng) && (this.Dnf != null))
        {
          paramCanvas.scale(this.KV.width() / this.Dnf.getWidth(), this.KV.width() / this.Dnf.getHeight());
          paramCanvas.drawBitmap(this.Dnf, 0.0F, 0.0F, this.mPaint);
        }
      }
      for (;;)
      {
        this.Dnn = (System.currentTimeMillis() - this.Dnm);
        if ((this.Dnq) || (this.Dna[2] <= 0)) {
          break label426;
        }
        if (this.Dna[4] < 0) {
          Log.i("MicroMsg.GIF.MMGIFDrawable", "current index error. start first frame");
        }
        if ((this.Dnr == 0) || (this.Dns <= this.Dnr - 1)) {
          break;
        }
        k(this.Dnw, 0L);
        AppMethodBeat.o(104631);
        return;
        if (arrayOfInt.length == this.Dna[0] * this.Dna[1])
        {
          paramCanvas.scale(this.Dnb, this.Dnc);
          paramCanvas.drawBitmap(arrayOfInt, 0, this.Dna[0], 0.0F, 0.0F, this.Dna[0], this.Dna[1], true, this.mPaint);
        }
        else
        {
          paramCanvas.scale(this.Dnb, this.Dnc);
          paramCanvas.drawRGB(230, 230, 230);
          Log.w("MicroMsg.GIF.MMGIFDrawable", "colors is not equal width*height. length:%d width:%d height:%d", new Object[] { Integer.valueOf(arrayOfInt.length), Integer.valueOf(this.Dna[0]), Integer.valueOf(this.Dna[1]) });
          continue;
          Log.e("MicroMsg.GIF.MMGIFDrawable", "colors is null.");
        }
      }
      if (this.Dnu)
      {
        com.tencent.mm.ax.a.f(this.DnB, 0L);
        this.Dnu = false;
        AppMethodBeat.o(104631);
        return;
        label426:
        Log.e("MicroMsg.GIF.MMGIFDrawable", "framecount:%d errorcode:%d no post and oversize:%b", new Object[] { Integer.valueOf(this.Dna[2]), Integer.valueOf(this.Dna[4]), Boolean.valueOf(this.Dnq) });
      }
      AppMethodBeat.o(104631);
      return;
    }
    Log.i("MicroMsg.GIF.MMGIFDrawable", "colors drawRect ");
    paramCanvas.drawRect(this.KV, this.mPaint);
    AppMethodBeat.o(104631);
  }
  
  public final int eAW()
  {
    return this.Dna[0];
  }
  
  public final int eAX()
  {
    return this.Dna[1];
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
      this.mDensity = (com.tencent.mm.ci.a.getDensity(MMApplicationContext.getContext()) / 2.0F);
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
    int i = (int)(this.Dna[1] * getEmojiDensityScale());
    AppMethodBeat.o(104629);
    return i;
  }
  
  public final int getIntrinsicWidth()
  {
    AppMethodBeat.i(104628);
    int i = (int)(this.Dna[0] * getEmojiDensityScale());
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
    this.Dnd = true;
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
    this.DmX = true;
    this.mIsRunning = false;
    long l = this.DmY;
    this.DmY = 0L;
    MMGIFJNI.recycle(l);
    this.Dne = null;
    if (this.DmZ != null) {
      try
      {
        this.DmZ.close();
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
    this.DmX = false;
    this.mIsRunning = true;
    com.tencent.mm.ax.a.f(this.Dnz, 0L);
    AppMethodBeat.o(104637);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(104636);
    if (!this.DmX)
    {
      this.mIsRunning = true;
      k(this.Dnx, 0L);
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
    com.tencent.mm.ax.a.f(this.Dny, 0L);
    AppMethodBeat.o(104634);
  }
  
  public final void stop()
  {
    boolean bool2 = true;
    AppMethodBeat.i(104635);
    Log.d("MicroMsg.GIF.MMGIFDrawable", "stop");
    this.mIsRunning = false;
    if (this.iWt != 0)
    {
      Log.i("MicroMsg.GIF.MMGIFDrawable", "summerhardcoder stopPerformance startPerformance:%x ", new Object[] { Integer.valueOf(this.iWt) });
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
      WXHardCoderJNI.stopPerformance(bool1, this.iWt);
      this.iWt = 0;
      com.tencent.mm.ax.a.f(this.DnA, 300L);
      AppMethodBeat.o(104635);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.d
 * JD-Core Version:    0.7.0.1
 */