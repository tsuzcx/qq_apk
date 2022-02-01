package com.tencent.mm.plugin.appbrand.jsapi.video.e.b;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.e.b.a;
import com.google.android.exoplayer2.f.j.a;
import com.google.android.exoplayer2.h.g.a;
import com.google.android.exoplayer2.h.s.c;
import com.google.android.exoplayer2.h.s.e;
import com.google.android.exoplayer2.h.t.f;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.e.a;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.r;
import com.google.android.exoplayer2.source.b;
import com.google.android.exoplayer2.source.h.a;
import com.google.android.exoplayer2.source.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class f
  extends com.tencent.mm.plugin.appbrand.jsapi.video.e.a
{
  protected int bDU;
  protected float bDY;
  private final AtomicBoolean kQW;
  volatile boolean mAU;
  Context mAppContext;
  com.google.android.exoplayer2.f mCc;
  private boolean mCd;
  private f mCe;
  private com.google.android.exoplayer2.source.k mCf;
  private List<r> mCg;
  private com.google.android.exoplayer2.f.a mCh;
  private c mCi;
  private k mCj;
  int mCk;
  private boolean mCl;
  private final AtomicBoolean mCm;
  protected int mCn;
  protected int mCo;
  protected int mCp;
  protected int mCq;
  protected int mCr;
  protected int mCs;
  private int mCt;
  private volatile boolean mCu;
  private volatile boolean mCv;
  private HandlerThread mHandlerThread;
  private boolean mIsLooping;
  private Handler mMainHandler;
  private Surface mSurface;
  int mVideoHeight;
  int mVideoWidth;
  
  public f()
  {
    this(null);
  }
  
  public f(int paramInt1, float paramFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this(null, paramInt1, paramFloat, paramInt2, paramInt3, paramInt4, paramInt5, 2500);
  }
  
  public f(Handler paramHandler)
  {
    this(paramHandler, 0, 0.75F, 10000, 25000, 15000, 30000, 2500);
  }
  
  public f(Handler paramHandler, int paramInt1, float paramFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this(paramHandler, paramInt1, paramFloat, paramInt2, paramInt3, paramInt4, paramInt5, 2500);
  }
  
  private f(Handler paramHandler, int paramInt1, float paramFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(235006);
    this.kQW = new AtomicBoolean();
    this.mCm = new AtomicBoolean(false);
    this.bDU = 0;
    this.bDY = 0.75F;
    this.mCn = 10000;
    this.mCo = 25000;
    this.mCp = 15000;
    this.mCq = 30000;
    this.mCr = 2500;
    this.mCs = 5000;
    this.mCt = 0;
    this.mCu = false;
    this.mCv = false;
    Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "ExoMediaPlayer, handler = %s, maxInitBitrate = %s, bandFraction = %s, minDur = %s, maxDur = %s, minBuffer = %s, maxBuffer = %s, bufferForPlaybackMs:%s, bufferForPlaybackAfterRebufferMs:%s", new Object[] { paramHandler, Integer.valueOf(paramInt1), Float.valueOf(paramFloat), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(5000) });
    this.bDU = 0;
    this.bDY = paramFloat;
    this.mCn = paramInt2;
    this.mCo = paramInt3;
    this.mCp = paramInt4;
    this.mCq = paramInt5;
    this.mCr = paramInt6;
    this.mCs = 5000;
    d(paramHandler);
    AppMethodBeat.o(235006);
  }
  
  public f(Handler paramHandler, int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramHandler, 0, 0.75F, 10000, 25000, paramInt1, paramInt2, paramInt3);
  }
  
  private g.a V(Map<String, String> paramMap)
  {
    AppMethodBeat.i(235016);
    if ((paramMap == null) && (!com.tencent.mm.plugin.appbrand.jsapi.video.j.bJE().mwX))
    {
      g.a locala = null;
      if (com.tencent.luggage.a.e.M(com.tencent.mm.plugin.appbrand.jsapi.video.g.class) != null) {
        locala = ((com.tencent.mm.plugin.appbrand.jsapi.video.g)com.tencent.luggage.a.e.M(com.tencent.mm.plugin.appbrand.jsapi.video.g.class)).bJs();
      }
      if (locala != null)
      {
        Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "getDataSourceFactory, return customized data source factory");
        AppMethodBeat.o(235016);
        return locala;
      }
    }
    Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "getDataSourceFactory, return default data source factory");
    paramMap = g.a(this.mAppContext, paramMap);
    AppMethodBeat.o(235016);
    return paramMap;
  }
  
  private com.google.android.exoplayer2.source.k a(Uri paramUri, String paramString1, String paramString2)
  {
    AppMethodBeat.i(235013);
    int i = q(paramUri);
    paramString1 = com.tencent.mm.plugin.appbrand.jsapi.u.d.aaG(paramString1);
    switch (i)
    {
    default: 
      Log.e("MicroMsg.SameLayer.ExoMediaPlayer", "buildMediaSource, unsupported type:" + i + ", url:" + paramUri);
      AppMethodBeat.o(235013);
      return null;
    case 2: 
      Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "buildMediaSource, type:HLS, url:%s", new Object[] { paramUri });
      paramUri = new com.google.android.exoplayer2.source.b.h(paramUri, g.a(this.mAppContext, paramString1), this.mMainHandler, this.mCi);
      AppMethodBeat.o(235013);
      return paramUri;
    }
    Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "buildMediaSource, type:other, url:%s", new Object[] { paramUri });
    if ((paramString2 != null) && (paramString2.length() > 0))
    {
      Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "[TRACE_VIDEO_PRELOAD] buildMediaSource with cutomkey = %s", new Object[] { paramString2 });
      paramUri = new com.google.android.exoplayer2.source.h(paramUri, V(paramString1), bKG(), this.mMainHandler, this.mCi, paramString2);
      AppMethodBeat.o(235013);
      return paramUri;
    }
    paramUri = new com.google.android.exoplayer2.source.h(paramUri, V(paramString1), bKG(), this.mMainHandler, this.mCi);
    AppMethodBeat.o(235013);
    return paramUri;
  }
  
  private void a(int paramInt1, int paramInt2, Object paramObject, boolean paramBoolean)
  {
    AppMethodBeat.i(235036);
    if (this.mCg.isEmpty())
    {
      AppMethodBeat.o(235036);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mCg.iterator();
    while (localIterator.hasNext())
    {
      r localr = (r)localIterator.next();
      if (localr.getTrackType() == paramInt1) {
        localArrayList.add(new com.google.android.exoplayer2.f.c(localr, paramInt2, paramObject));
      }
    }
    if (paramBoolean)
    {
      this.mCc.b((com.google.android.exoplayer2.f.c[])localArrayList.toArray(new com.google.android.exoplayer2.f.c[localArrayList.size()]));
      AppMethodBeat.o(235036);
      return;
    }
    this.mCc.a((com.google.android.exoplayer2.f.c[])localArrayList.toArray(new com.google.android.exoplayer2.f.c[localArrayList.size()]));
    AppMethodBeat.o(235036);
  }
  
  private void bKC()
  {
    AppMethodBeat.i(235008);
    Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "iniMediaPlayer");
    com.google.android.exoplayer2.g.c localc = new com.google.android.exoplayer2.g.c(new c.b(g.bKK(), this.bDU, this.mCn, this.mCo, this.bDY));
    com.google.android.exoplayer2.c localc1 = new com.google.android.exoplayer2.c(new com.google.android.exoplayer2.h.k(), this.mCp, this.mCq, this.mCr, this.mCs);
    this.mCc = com.google.android.exoplayer2.g.a((r[])this.mCg.toArray(new r[this.mCg.size()]), localc, localc1);
    this.mCc.a(this.mCh);
    AppMethodBeat.o(235008);
  }
  
  private void cJ(Object paramObject)
  {
    AppMethodBeat.i(235035);
    a(1, 2, paramObject, false);
    AppMethodBeat.o(235035);
  }
  
  private void d(Handler paramHandler)
  {
    AppMethodBeat.i(235007);
    this.mAppContext = MMApplicationContext.getContext();
    this.mCe = new f((byte)0);
    if (paramHandler != null) {}
    for (this.mMainHandler = paramHandler;; this.mMainHandler = new Handler(this.mHandlerThread.getLooper()))
    {
      this.mCh = new d((byte)0);
      this.mCi = new c((byte)0);
      this.mCj = new k(this.mMainHandler);
      this.mCj.mCF = 1000;
      this.mCj.mCH = new a((byte)0);
      e locale = new e((byte)0);
      this.mCg = new d(this.mAppContext, this.mMainHandler, locale, locale, locale, locale).bKB();
      if ((paramHandler == null) || (paramHandler.getLooper() != Looper.myLooper())) {
        break;
      }
      bKC();
      AppMethodBeat.o(235007);
      return;
      this.mHandlerThread = com.tencent.f.c.d.hA("ExoMediaPlayer_HandlerThread", 5);
      this.mHandlerThread.start();
    }
    this.mMainHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(234971);
        synchronized (f.this)
        {
          f.a(f.this);
          f.this.notifyAll();
          AppMethodBeat.o(234971);
          return;
        }
      }
    });
    try
    {
      for (;;)
      {
        paramHandler = this.mCc;
        if (paramHandler != null) {
          break;
        }
        try
        {
          wait();
        }
        catch (InterruptedException paramHandler)
        {
          Thread.currentThread().interrupt();
        }
      }
    }
    finally
    {
      AppMethodBeat.o(235007);
    }
    AppMethodBeat.o(235007);
  }
  
  private void hR(boolean paramBoolean)
  {
    AppMethodBeat.i(235032);
    Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "setBufferRepeaterStarted ".concat(String.valueOf(paramBoolean)));
    if ((paramBoolean) && (this.mBa != null))
    {
      this.mCj.start();
      AppMethodBeat.o(235032);
      return;
    }
    this.mCj.mCE = false;
    AppMethodBeat.o(235032);
  }
  
  public final boolean aP(float paramFloat)
  {
    AppMethodBeat.i(235018);
    if (available())
    {
      p localp = new p(paramFloat, 1.0F);
      this.mCc.a(localp);
      AppMethodBeat.o(235018);
      return true;
    }
    AppMethodBeat.o(235018);
    return false;
  }
  
  final boolean available()
  {
    return this.mCc != null;
  }
  
  public final int bKD()
  {
    return this.mCp;
  }
  
  public final int bKE()
  {
    return this.mCq;
  }
  
  public final int bKF()
  {
    return this.mCr;
  }
  
  protected com.google.android.exoplayer2.c.h bKG()
  {
    AppMethodBeat.i(235015);
    e locale = new e();
    AppMethodBeat.o(235015);
    return locale;
  }
  
  final void bKH()
  {
    for (;;)
    {
      int j;
      try
      {
        AppMethodBeat.i(235034);
        if ((this.mCc == null) || (this.mAU))
        {
          AppMethodBeat.o(235034);
          return;
        }
        int i = this.mCc.ti();
        boolean bool = this.mCc.tj();
        j = f.r(bool, i);
        if (j == this.mCe.mCA[3]) {
          break label542;
        }
        Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "reportPlayerState, set new recent state [" + bool + "," + i + "]");
        this.mCe.q(bool, i);
        if (j == 3)
        {
          hR(true);
          if (j != f.r(true, 4)) {
            break label271;
          }
          Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "reportPlayerState, isSeeking: %b, loopingPlaySeek: %b", new Object[] { Boolean.valueOf(this.mCm.get()), Boolean.valueOf(this.mCl) });
          if ((this.mCm.getAndSet(false)) && (!this.mCl)) {
            bKz();
          }
          if (!this.mIsLooping) {
            break label252;
          }
          Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "looping play start");
          this.mCl = true;
          seekTo(0L);
          AppMethodBeat.o(235034);
          continue;
        }
        if (j == 1) {
          break label244;
        }
      }
      finally {}
      if (j == 4)
      {
        label244:
        hR(false);
        continue;
        label252:
        this.mAT = 6;
        bKy();
        AppMethodBeat.o(235034);
        continue;
        label271:
        if (this.mCe.a(new int[] { f.r(false, 1), f.r(false, 2), f.r(false, 3) }, false))
        {
          this.mAT = 2;
          bKx();
          this.mCu = false;
          AppMethodBeat.o(235034);
        }
        else
        {
          if ((this.mCe.a(new int[] { 100, 2, 3 }, true) | this.mCe.a(new int[] { 2, 100, 3 }, true) | this.mCe.a(new int[] { 100, 3, 2, 3 }, true)))
          {
            if (!this.mCl) {
              bKz();
            }
            for (;;)
            {
              this.mCm.set(false);
              AppMethodBeat.o(235034);
              break;
              this.mCl = false;
            }
          }
          if (this.mCe.a(new int[] { f.r(true, 3), f.r(true, 2) }, false))
          {
            ek(701, getBufferedPercentage());
            AppMethodBeat.o(235034);
          }
          else
          {
            if (this.mCe.a(new int[] { f.r(true, 2), f.r(true, 3) }, false)) {
              ek(702, getBufferedPercentage());
            }
            label542:
            AppMethodBeat.o(235034);
          }
        }
      }
    }
  }
  
  public final b bKI()
  {
    AppMethodBeat.i(235037);
    boolean bool1;
    boolean bool2;
    if (this.mCu) {
      if (this.mCt > 0)
      {
        bool1 = false;
        bool2 = true;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "statErrorPlayerNotFound, hasLoadError: %b, hasOtherError: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      b localb = new b(bool2, bool1);
      AppMethodBeat.o(235037);
      return localb;
      if (!this.mCv)
      {
        bool1 = true;
        bool2 = false;
      }
      else
      {
        bool1 = false;
        bool2 = false;
      }
    }
  }
  
  public final void dU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(235011);
    this.mCf = a(Uri.parse(paramString1), paramString2, "");
    this.mCt = 0;
    this.mAT = 1;
    AppMethodBeat.o(235011);
  }
  
  public final void dV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(235012);
    this.mCf = a(Uri.parse(paramString1), null, paramString2);
    this.mCt = 0;
    this.mAT = 1;
    AppMethodBeat.o(235012);
  }
  
  public final boolean ej(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(235033);
    boolean bool = super.ej(paramInt1, paramInt2);
    this.mCv = true;
    this.mCt = 0;
    AppMethodBeat.o(235033);
    return bool;
  }
  
  final int getBufferedPercentage()
  {
    AppMethodBeat.i(235031);
    if (available())
    {
      int i = this.mCc.getBufferedPercentage();
      AppMethodBeat.o(235031);
      return i;
    }
    AppMethodBeat.o(235031);
    return 0;
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(235022);
    if (available())
    {
      int i = (int)this.mCc.getCurrentPosition();
      AppMethodBeat.o(235022);
      return i;
    }
    AppMethodBeat.o(235022);
    return 0;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(235021);
    if (available())
    {
      int i = (int)this.mCc.getDuration();
      AppMethodBeat.o(235021);
      return i;
    }
    AppMethodBeat.o(235021);
    return 0;
  }
  
  public final int getVideoHeight()
  {
    return this.mVideoHeight;
  }
  
  public final int getVideoWidth()
  {
    return this.mVideoWidth;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(235009);
    if (available())
    {
      switch (this.mCc.ti())
      {
      }
      do
      {
        AppMethodBeat.o(235009);
        return false;
        boolean bool = this.mCc.tj();
        AppMethodBeat.o(235009);
        return bool;
      } while (!this.mIsLooping);
      AppMethodBeat.o(235009);
      return true;
    }
    AppMethodBeat.o(235009);
    return false;
  }
  
  public final void k(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(235027);
    if (available())
    {
      this.mCc.seekTo(paramLong);
      this.mCe.q(paramBoolean, 100);
    }
    AppMethodBeat.o(235027);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(235025);
    if (available())
    {
      this.mCc.aO(false);
      this.mAT = 3;
    }
    AppMethodBeat.o(235025);
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(235023);
    if (this.mCf == null)
    {
      Log.w("MicroMsg.SameLayer.ExoMediaPlayer", "prepareAsync, media source is null");
      AppMethodBeat.o(235023);
      return;
    }
    if (available())
    {
      this.mCc.aO(false);
      this.mCc.a(this.mCf);
      this.mCu = true;
    }
    AppMethodBeat.o(235023);
  }
  
  protected int q(Uri paramUri)
  {
    AppMethodBeat.i(235014);
    int j = 3;
    int i = j;
    if (paramUri != null)
    {
      paramUri = paramUri.toString();
      if (!paramUri.contains(".m3u8"))
      {
        i = j;
        if (!paramUri.contains(".m3u")) {}
      }
      else
      {
        i = 2;
      }
    }
    AppMethodBeat.o(235014);
    return i;
  }
  
  public final void release()
  {
    AppMethodBeat.i(235030);
    this.mAU = true;
    if (available())
    {
      hR(false);
      if (available())
      {
        this.mCc.release();
        this.mCc.b(this.mCh);
        this.mCc = null;
      }
      this.mVideoWidth = 0;
      this.mVideoHeight = 0;
      this.mCk = 0;
    }
    if (this.mHandlerThread != null)
    {
      this.mHandlerThread.quit();
      this.mHandlerThread = null;
    }
    if (this.mSurface != null)
    {
      if (this.mCd) {
        this.mSurface.release();
      }
      this.mSurface = null;
    }
    this.mAV = null;
    this.mAW = null;
    this.mAX = null;
    this.mAY = null;
    this.mAZ = null;
    this.mBa = null;
    this.mBb = null;
    this.mAT = -2;
    super.release();
    AppMethodBeat.o(235030);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(235029);
    if (available())
    {
      hR(false);
      if (available())
      {
        this.mCc.aO(false);
        this.mCc.stop();
      }
      this.mIsLooping = false;
      this.mCk = 0;
      this.mCe.mCA = new int[] { 1, 1, 1, 1 };
      this.mAT = 0;
    }
    AppMethodBeat.o(235029);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(235026);
    f localf;
    if (available())
    {
      this.mCc.seekTo(paramLong);
      localf = this.mCe;
      if ((this.mCe.mCA[3] & 0xF0000000) == 0) {
        break label70;
      }
    }
    label70:
    for (boolean bool = true;; bool = false)
    {
      localf.q(bool, 100);
      this.mCm.set(true);
      AppMethodBeat.o(235026);
      return;
    }
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(235010);
    dU(paramString, null);
    AppMethodBeat.o(235010);
  }
  
  public final void setLooping(boolean paramBoolean)
  {
    this.mIsLooping = paramBoolean;
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(235019);
    if (available())
    {
      if (paramBoolean)
      {
        setVolume(0.0F, 0.0F);
        AppMethodBeat.o(235019);
        return;
      }
      setVolume(1.0F, 1.0F);
    }
    AppMethodBeat.o(235019);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(235017);
    if ((available()) && (available()))
    {
      if ((this.mSurface == null) || (this.mSurface == paramSurface) || (paramSurface == null)) {
        break label116;
      }
      if (this.mCd) {
        this.mSurface.release();
      }
      a(2, 1, paramSurface, true);
      final long l = this.mCc.getCurrentPosition();
      if (x.SDK_INT < 23) {
        this.mMainHandler.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(234972);
            if (f.this.available()) {
              f.this.mCc.seekTo(l);
            }
            AppMethodBeat.o(234972);
          }
        }, 200L);
      }
    }
    for (;;)
    {
      this.mSurface = paramSurface;
      this.mCd = false;
      AppMethodBeat.o(235017);
      return;
      label116:
      a(2, 1, paramSurface, false);
    }
  }
  
  public final void setVolume(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(235020);
    cJ(Float.valueOf(paramFloat1));
    AppMethodBeat.o(235020);
  }
  
  public final void start()
  {
    AppMethodBeat.i(235024);
    if (available())
    {
      if (this.mCc.ti() == 4) {
        this.mCc.seekTo(0L);
      }
      this.mCc.aO(true);
      this.mAT = 3;
      this.kQW.set(false);
    }
    AppMethodBeat.o(235024);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(235028);
    if ((available()) && (!this.kQW.getAndSet(true)))
    {
      this.mCc.aO(false);
      this.mCc.stop();
      this.mAT = 5;
    }
    AppMethodBeat.o(235028);
  }
  
  final class a
    implements k.b
  {
    private a() {}
    
    public final void awp()
    {
      AppMethodBeat.i(234973);
      for (;;)
      {
        synchronized (f.this)
        {
          if (f.this.mAU)
          {
            AppMethodBeat.o(234973);
            return;
          }
          if (f.this.available()) {}
          switch (f.this.mCc.ti())
          {
          case 1: 
            AppMethodBeat.o(234973);
            return;
          case 4: 
            f.a(f.this, false);
          }
        }
        int i = f.this.getBufferedPercentage();
        if (i != f.this.mCk)
        {
          f.this.xF(i);
          f.this.mCk = i;
        }
      }
    }
  }
  
  public static final class b
  {
    public final boolean mCy;
    public final boolean mCz;
    
    public b(boolean paramBoolean1, boolean paramBoolean2)
    {
      this.mCy = paramBoolean1;
      this.mCz = paramBoolean2;
    }
  }
  
  final class c
    implements b, h.a
  {
    private c() {}
    
    public final void a(int paramInt, Format paramFormat, long paramLong)
    {
      AppMethodBeat.i(234978);
      Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "[TRACE_ADAPTIVE] onDownstreamFormatChanged, trackType:%s, trackFormat:%s, mediaTimeMs:%s", new Object[] { Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong) });
      f.this.abt(paramFormat.id);
      AppMethodBeat.o(234978);
    }
    
    public final void a(com.google.android.exoplayer2.h.j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(234974);
      Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "onLoadStarted, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s", new Object[] { paramj, Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
      AppMethodBeat.o(234974);
    }
    
    public final void a(com.google.android.exoplayer2.h.j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, IOException paramIOException, boolean paramBoolean)
    {
      AppMethodBeat.i(234977);
      Log.printErrStackTrace("MicroMsg.SameLayer.ExoMediaPlayer", paramIOException, "onLoadError1, IOException, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s, loadDurationMs:%s, bytesLoaded:%s, wasCanceled:%s", new Object[] { paramj, Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(paramLong4), Long.valueOf(paramLong5), Boolean.valueOf(paramBoolean) });
      f.b(f.this);
      AppMethodBeat.o(234977);
    }
    
    public final void b(com.google.android.exoplayer2.h.j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(234975);
      Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "onLoadCompleted, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s", new Object[] { paramj, Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
      AppMethodBeat.o(234975);
    }
    
    public final void c(com.google.android.exoplayer2.h.j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(234976);
      Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "onLoadCanceled, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s", new Object[] { paramj, Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
      AppMethodBeat.o(234976);
    }
    
    public final void onLoadError(IOException paramIOException)
    {
      AppMethodBeat.i(234980);
      Log.printErrStackTrace("MicroMsg.SameLayer.ExoMediaPlayer", paramIOException, "onLoadError2, IOException", new Object[0]);
      f.b(f.this);
      AppMethodBeat.o(234980);
    }
    
    public final void vl()
    {
      AppMethodBeat.i(234979);
      Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "onHasEndTag");
      AppMethodBeat.o(234979);
    }
  }
  
  final class d
    implements com.google.android.exoplayer2.f.a
  {
    private d() {}
    
    public final void a(com.google.android.exoplayer2.e parame)
    {
      int i = -4000;
      AppMethodBeat.i(234988);
      Log.printErrStackTrace("MicroMsg.SameLayer.ExoMediaPlayer", parame, "onPlayError, ExoPlaybackException", new Object[0]);
      if (f.this.available()) {
        f.a(f.this, false);
      }
      if (parame != null)
      {
        Throwable localThrowable = parame.getCause();
        if (localThrowable != null)
        {
          if ((localThrowable instanceof s.c))
          {
            if (localThrowable.toString().contains("Unable to connect"))
            {
              boolean bool = g.isNetworkAvailable(f.this.mAppContext);
              Log.printErrStackTrace("MicroMsg.SameLayer.ExoMediaPlayer", localThrowable, "ExoPlaybackException hasNetwork=".concat(String.valueOf(bool)), new Object[0]);
              if (!bool)
              {
                f.this.ej(-4000, -2);
                AppMethodBeat.o(234988);
                return;
              }
              f.this.ej(-4000, -3);
              AppMethodBeat.o(234988);
              return;
            }
            if (!(localThrowable instanceof s.e)) {
              break label457;
            }
            parame = localThrowable.toString();
            if (parame.contains("403"))
            {
              f.this.ej(-4000, -10);
              AppMethodBeat.o(234988);
              return;
            }
            if (parame.contains("404"))
            {
              f.this.ej(-4000, -11);
              AppMethodBeat.o(234988);
              return;
            }
            if (parame.contains("500"))
            {
              f.this.ej(-4000, -12);
              AppMethodBeat.o(234988);
              return;
            }
            if (parame.contains("502"))
            {
              f.this.ej(-4000, -13);
              AppMethodBeat.o(234988);
              return;
            }
            f.this.ej(-4000, -30);
            AppMethodBeat.o(234988);
            return;
          }
          if ((localThrowable instanceof s))
          {
            Log.e("MicroMsg.SameLayer.ExoMediaPlayer", g.bKJ());
            f.this.ej(-4001, -1);
            AppMethodBeat.o(234988);
            return;
          }
          if ((localThrowable instanceof IllegalStateException))
          {
            Log.e("MicroMsg.SameLayer.ExoMediaPlayer", g.bKJ());
            f.this.ej(-4002, -1);
            AppMethodBeat.o(234988);
            return;
          }
          if ((localThrowable instanceof b.a))
          {
            Log.w("MicroMsg.SameLayer.ExoMediaPlayer", "onPlayError, error: " + g.j(parame));
            Log.e("MicroMsg.SameLayer.ExoMediaPlayer", g.bKJ());
            f.this.ej(-4003, -1);
            AppMethodBeat.o(234988);
            return;
          }
          if ((localThrowable instanceof t.f))
          {
            Log.e("MicroMsg.SameLayer.ExoMediaPlayer", g.bKJ());
            f.this.ej(-4004, -1);
            AppMethodBeat.o(234988);
            return;
          }
        }
        i = -4999;
        label457:
        if (1 == parame.type)
        {
          Log.e("MicroMsg.SameLayer.ExoMediaPlayer", g.bKJ());
          f.this.ej(-4005, -1);
          AppMethodBeat.o(234988);
        }
      }
      else
      {
        i = -4999;
      }
      Log.e("MicroMsg.SameLayer.ExoMediaPlayer", g.xH(30));
      f.this.ej(i, -1);
      AppMethodBeat.o(234988);
    }
    
    public final void aA(int paramInt)
    {
      AppMethodBeat.i(234985);
      Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "onRepeatModeChanged, repeatMode=".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(234985);
    }
    
    public final void aR(boolean paramBoolean)
    {
      AppMethodBeat.i(234986);
      Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "onLoadingChanged, isLoading=".concat(String.valueOf(paramBoolean)));
      if (paramBoolean) {
        f.a(f.this, true);
      }
      AppMethodBeat.o(234986);
    }
    
    public final void b(p paramp)
    {
      AppMethodBeat.i(234984);
      Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "onPlaybackParametersChanged, params=[" + paramp.bdN + ", " + paramp.pitch + "]");
      AppMethodBeat.o(234984);
    }
    
    public final void c(boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(234987);
      Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "onPlayerStateChanged, playWhenReady=" + paramBoolean + ", playbackState=" + paramInt);
      f.this.bKH();
      AppMethodBeat.o(234987);
    }
    
    public final void tA()
    {
      AppMethodBeat.i(234982);
      Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "onPositionDiscontinuity");
      AppMethodBeat.o(234982);
    }
    
    public final void ty()
    {
      AppMethodBeat.i(234981);
      Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "onTimelineChanged");
      AppMethodBeat.o(234981);
    }
    
    public final void tz()
    {
      AppMethodBeat.i(234983);
      Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "onTracksChanged");
      AppMethodBeat.o(234983);
    }
  }
  
  final class e
    implements com.google.android.exoplayer2.a.e, j.a, e.a, com.google.android.exoplayer2.video.e
  {
    private e() {}
    
    public final void a(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
    {
      AppMethodBeat.i(235003);
      Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "onVideoSizeChanged, width:%d, height:%d, rotationDegrees:%d, ratio:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Float.valueOf(paramFloat) });
      f.this.mVideoWidth = paramInt1;
      f.this.mVideoHeight = paramInt2;
      f.this.ei(paramInt1, paramInt2);
      AppMethodBeat.o(235003);
    }
    
    public final void a(com.google.android.exoplayer2.b.d paramd)
    {
      AppMethodBeat.i(234997);
      Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "onVideoEnabled");
      AppMethodBeat.o(234997);
    }
    
    public final void b(com.google.android.exoplayer2.b.d paramd)
    {
      AppMethodBeat.i(234998);
      Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "onVideoDisabled");
      AppMethodBeat.o(234998);
    }
    
    public final void b(Metadata paramMetadata)
    {
      AppMethodBeat.i(234995);
      Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "onMetadata");
      AppMethodBeat.o(234995);
    }
    
    public final void b(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(234999);
      Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "onVideoDecoderInitialized");
      AppMethodBeat.o(234999);
    }
    
    public final void c(Surface paramSurface)
    {
      AppMethodBeat.i(235002);
      Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "onRenderedFirstFrame");
      f.this.ek(3, 0);
      AppMethodBeat.o(235002);
    }
    
    public final void c(Format paramFormat)
    {
      AppMethodBeat.i(235000);
      Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "onVideoInputFormatChanged");
      AppMethodBeat.o(235000);
    }
    
    public final void c(com.google.android.exoplayer2.b.d paramd)
    {
      AppMethodBeat.i(234989);
      Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "onAudioEnabled");
      AppMethodBeat.o(234989);
    }
    
    public final void c(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(234991);
      Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "onAudioDecoderInitialized");
      AppMethodBeat.o(234991);
    }
    
    public final void d(int paramInt, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(234993);
      Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "onAudioTrackUnderrun");
      AppMethodBeat.o(234993);
    }
    
    public final void d(Format paramFormat)
    {
      AppMethodBeat.i(234992);
      Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "onAudioInputFormatChanged");
      AppMethodBeat.o(234992);
    }
    
    public final void d(com.google.android.exoplayer2.b.d paramd)
    {
      AppMethodBeat.i(234994);
      Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "onAudioDisabled");
      AppMethodBeat.o(234994);
    }
    
    public final void dG(int paramInt)
    {
      AppMethodBeat.i(234990);
      Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "onAudioSessionId");
      AppMethodBeat.o(234990);
    }
    
    public final void h(int paramInt, long paramLong)
    {
      AppMethodBeat.i(235001);
      Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "onDroppedFrames");
      AppMethodBeat.o(235001);
    }
    
    public final void s(List<com.google.android.exoplayer2.f.a> paramList)
    {
      AppMethodBeat.i(234996);
      Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "onCues");
      AppMethodBeat.o(234996);
    }
  }
  
  static final class f
  {
    int[] mCA;
    
    private f()
    {
      AppMethodBeat.i(235004);
      this.mCA = new int[] { 1, 1, 1, 1 };
      AppMethodBeat.o(235004);
    }
    
    static int r(boolean paramBoolean, int paramInt)
    {
      if (paramBoolean) {}
      for (int i = -268435456;; i = 0) {
        return i | paramInt;
      }
    }
    
    final boolean a(int[] paramArrayOfInt, boolean paramBoolean)
    {
      int i;
      int j;
      if (paramBoolean)
      {
        i = 268435455;
        int k = this.mCA.length - paramArrayOfInt.length;
        j = k;
        paramBoolean = true;
        label23:
        if (j >= this.mCA.length) {
          return paramBoolean;
        }
        if ((this.mCA[j] & i) != (paramArrayOfInt[(j - k)] & i)) {
          break label76;
        }
      }
      label76:
      for (boolean bool = true;; bool = false)
      {
        paramBoolean &= bool;
        j += 1;
        break label23;
        i = -1;
        break;
      }
      return paramBoolean;
    }
    
    final void q(boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(235005);
      int i = r(paramBoolean, paramInt);
      Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "request setMostRecentState [" + paramBoolean + "," + paramInt + "], lastState=" + this.mCA[3] + ", newState=" + i);
      if (this.mCA[3] == i)
      {
        AppMethodBeat.o(235005);
        return;
      }
      this.mCA[0] = this.mCA[1];
      this.mCA[1] = this.mCA[2];
      this.mCA[2] = this.mCA[3];
      this.mCA[3] = i;
      Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "new MostRecentState [" + this.mCA[0] + "," + this.mCA[1] + "," + this.mCA[2] + "," + this.mCA[3] + "]");
      AppMethodBeat.o(235005);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f
 * JD-Core Version:    0.7.0.1
 */