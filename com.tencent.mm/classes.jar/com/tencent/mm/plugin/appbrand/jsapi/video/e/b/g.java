package com.tencent.mm.plugin.appbrand.jsapi.video.e.b;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.e.b.a;
import com.google.android.exoplayer2.f.a;
import com.google.android.exoplayer2.f.c;
import com.google.android.exoplayer2.f.j.a;
import com.google.android.exoplayer2.h.j;
import com.google.android.exoplayer2.h.s.c;
import com.google.android.exoplayer2.h.s.e;
import com.google.android.exoplayer2.h.t.f;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.e.a;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.source.b;
import com.google.android.exoplayer2.source.h.a;
import com.google.android.exoplayer2.source.s;
import com.google.android.exoplayer2.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.h.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class g
  extends com.tencent.mm.plugin.appbrand.jsapi.video.e.a
{
  protected int bnv;
  protected float bnz;
  protected Context mAppContext;
  private HandlerThread mHandlerThread;
  private boolean mIsLooping;
  private Handler mMainHandler;
  private Surface mSurface;
  int mVideoHeight;
  int mVideoWidth;
  private final AtomicBoolean nLe;
  private int pAC;
  protected com.google.android.exoplayer2.f pAZ;
  private boolean pBa;
  private g.f pBb;
  private com.google.android.exoplayer2.source.k pBc;
  private List<com.google.android.exoplayer2.r> pBd;
  private f.a pBe;
  private c pBf;
  e pBg;
  private com.tencent.mm.plugin.appbrand.jsapi.video.e.h pBh;
  int pBi;
  private boolean pBj;
  private final AtomicBoolean pBk;
  protected int pBl;
  protected int pBm;
  protected int pBn;
  protected int pBo;
  protected int pBp;
  protected int pBq;
  com.google.android.exoplayer2.b.d pBr;
  com.google.android.exoplayer2.b.d pBs;
  private volatile boolean pBt;
  private volatile boolean pBu;
  volatile boolean pzq;
  
  public g()
  {
    this(null);
  }
  
  public g(int paramInt1, float paramFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this(null, paramInt1, paramFloat, paramInt2, paramInt3, paramInt4, paramInt5, 2500);
  }
  
  public g(Handler paramHandler)
  {
    this(paramHandler, 0, 0.75F, 10000, 25000, 15000, 30000, 2500);
  }
  
  public g(Handler paramHandler, int paramInt1, float paramFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this(paramHandler, paramInt1, paramFloat, paramInt2, paramInt3, paramInt4, paramInt5, 2500);
  }
  
  private g(Handler paramHandler, int paramInt1, float paramFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(230211);
    this.nLe = new AtomicBoolean();
    this.pBk = new AtomicBoolean(false);
    this.bnv = 0;
    this.bnz = 0.75F;
    this.pBl = 10000;
    this.pBm = 25000;
    this.pBn = 15000;
    this.pBo = 30000;
    this.pBp = 2500;
    this.pBq = 5000;
    this.pAC = 0;
    this.pBr = null;
    this.pBs = null;
    this.pBt = false;
    this.pBu = false;
    Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "ExoMediaPlayer, handler = %s, maxInitBitrate = %s, bandFraction = %s, minDur = %s, maxDur = %s, minBuffer = %s, maxBuffer = %s, bufferForPlaybackMs:%s, bufferForPlaybackAfterRebufferMs:%s", new Object[] { paramHandler, Integer.valueOf(paramInt1), Float.valueOf(paramFloat), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(5000) });
    this.bnv = 0;
    this.bnz = paramFloat;
    this.pBl = paramInt2;
    this.pBm = paramInt3;
    this.pBn = paramInt4;
    this.pBo = paramInt5;
    this.pBp = paramInt6;
    this.pBq = 5000;
    c(paramHandler);
    AppMethodBeat.o(230211);
  }
  
  public g(Handler paramHandler, int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramHandler, 0, 0.75F, 10000, 25000, paramInt1, paramInt2, paramInt3);
  }
  
  private com.google.android.exoplayer2.source.k a(Uri paramUri, String paramString1, String paramString2)
  {
    AppMethodBeat.i(230235);
    int i = h(paramUri);
    paramString1 = com.tencent.mm.plugin.appbrand.jsapi.v.d.aiy(paramString1);
    switch (i)
    {
    default: 
      Log.e("MicroMsg.SameLayer.ExoMediaPlayer", "buildMediaSource, unsupported type:" + i + ", url:" + paramUri);
      AppMethodBeat.o(230235);
      return null;
    case 2: 
      Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "buildMediaSource, type:HLS, url:%s", new Object[] { paramUri });
      paramUri = new com.google.android.exoplayer2.source.b.h(paramUri, h.b(this.mAppContext, paramString1), this.mMainHandler, this.pBf);
      AppMethodBeat.o(230235);
      return paramUri;
    }
    Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "buildMediaSource, type:other, url:%s", new Object[] { paramUri });
    if ((paramString2 != null) && (paramString2.length() > 0))
    {
      Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "[TRACE_VIDEO_PRELOAD] buildMediaSource with cutomkey = %s", new Object[] { paramString2 });
      paramUri = new com.google.android.exoplayer2.source.h(paramUri, O(paramString1), bWB(), this.mMainHandler, this.pBf, paramString2);
      AppMethodBeat.o(230235);
      return paramUri;
    }
    paramUri = new com.google.android.exoplayer2.source.h(paramUri, O(paramString1), bWB(), this.mMainHandler, this.pBf);
    AppMethodBeat.o(230235);
    return paramUri;
  }
  
  private void a(int paramInt1, int paramInt2, Object paramObject, boolean paramBoolean)
  {
    AppMethodBeat.i(230311);
    if (this.pBd.isEmpty())
    {
      AppMethodBeat.o(230311);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.pBd.iterator();
    while (localIterator.hasNext())
    {
      com.google.android.exoplayer2.r localr = (com.google.android.exoplayer2.r)localIterator.next();
      if (localr.getTrackType() == paramInt1) {
        localArrayList.add(new f.c(localr, paramInt2, paramObject));
      }
    }
    if (paramBoolean)
    {
      this.pAZ.b((f.c[])localArrayList.toArray(new f.c[localArrayList.size()]));
      AppMethodBeat.o(230311);
      return;
    }
    this.pAZ.a((f.c[])localArrayList.toArray(new f.c[localArrayList.size()]));
    AppMethodBeat.o(230311);
  }
  
  private boolean available()
  {
    return this.pAZ != null;
  }
  
  private void bWx()
  {
    AppMethodBeat.i(230216);
    Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "iniMediaPlayer");
    com.google.android.exoplayer2.g.c localc = new com.google.android.exoplayer2.g.c(new c.b(h.bWH(), this.bnv, this.pBl, this.pBm, this.bnz));
    this.pBg = new e(localc);
    com.google.android.exoplayer2.c localc1 = new com.google.android.exoplayer2.c(new com.google.android.exoplayer2.h.k(), this.pBn, this.pBo, this.pBp, this.pBq);
    this.pAZ = com.google.android.exoplayer2.g.a((com.google.android.exoplayer2.r[])this.pBd.toArray(new com.google.android.exoplayer2.r[this.pBd.size()]), localc, localc1);
    this.pAZ.a(this.pBe);
    AppMethodBeat.o(230216);
  }
  
  private void c(Handler paramHandler)
  {
    AppMethodBeat.i(230214);
    this.mAppContext = MMApplicationContext.getContext();
    this.pBb = new g.f((byte)0);
    if (paramHandler != null) {}
    for (this.mMainHandler = paramHandler;; this.mMainHandler = new Handler(this.mHandlerThread.getLooper()))
    {
      this.pBe = new d((byte)0);
      this.pBf = new c((byte)0);
      this.pBh = new com.tencent.mm.plugin.appbrand.jsapi.video.e.h(this.mMainHandler);
      this.pBh.pzS = 1000;
      this.pBh.pzU = new a((byte)0);
      e locale = new e((byte)0);
      this.pBd = new d(this.mAppContext, this.mMainHandler, locale, locale, locale, locale).bWv();
      if ((paramHandler == null) || (paramHandler.getLooper() != Looper.myLooper())) {
        break;
      }
      bWx();
      AppMethodBeat.o(230214);
      return;
      this.mHandlerThread = com.tencent.e.c.d.ik("ExoMediaPlayer_HandlerThread", 5);
      this.mHandlerThread.start();
    }
    this.mMainHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(228700);
        synchronized (g.this)
        {
          g.a(g.this);
          g.this.notifyAll();
          AppMethodBeat.o(228700);
          return;
        }
      }
    });
    try
    {
      for (;;)
      {
        paramHandler = this.pAZ;
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
      AppMethodBeat.o(230214);
    }
    AppMethodBeat.o(230214);
  }
  
  private void cK(Object paramObject)
  {
    AppMethodBeat.i(230308);
    a(1, 2, paramObject, false);
    AppMethodBeat.o(230308);
  }
  
  private int getBufferedPercentage()
  {
    AppMethodBeat.i(230295);
    if (available())
    {
      int i = this.pAZ.getBufferedPercentage();
      AppMethodBeat.o(230295);
      return i;
    }
    AppMethodBeat.o(230295);
    return 0;
  }
  
  private void iM(boolean paramBoolean)
  {
    AppMethodBeat.i(230297);
    Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "setBufferRepeaterStarted ".concat(String.valueOf(paramBoolean)));
    if ((paramBoolean) && (this.pzw != null))
    {
      this.pBh.start();
      AppMethodBeat.o(230297);
      return;
    }
    this.pBh.pzR = false;
    AppMethodBeat.o(230297);
  }
  
  protected com.google.android.exoplayer2.h.g.a O(Map<String, String> paramMap)
  {
    AppMethodBeat.i(230241);
    if ((paramMap == null) && (!i.bVn().pvr))
    {
      com.google.android.exoplayer2.h.g.a locala = null;
      com.tencent.mm.plugin.appbrand.jsapi.video.f localf = bWq();
      if (localf != null) {
        locala = localf.bVl();
      }
      if (locala != null)
      {
        Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "getDataSourceFactory, return customized data source factory");
        AppMethodBeat.o(230241);
        return locala;
      }
    }
    Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "getDataSourceFactory, return default data source factory");
    paramMap = h.b(this.mAppContext, paramMap);
    AppMethodBeat.o(230241);
    return paramMap;
  }
  
  public final boolean aP(float paramFloat)
  {
    AppMethodBeat.i(230249);
    if (available())
    {
      p localp = new p(paramFloat, 1.0F);
      this.pAZ.a(localp);
      AppMethodBeat.o(230249);
      return true;
    }
    AppMethodBeat.o(230249);
    return false;
  }
  
  public final int bWA()
  {
    return this.pBp;
  }
  
  protected com.google.android.exoplayer2.c.h bWB()
  {
    AppMethodBeat.i(230239);
    f localf = new f();
    AppMethodBeat.o(230239);
    return localf;
  }
  
  public final com.google.android.exoplayer2.b.d bWC()
  {
    if (this.pBr == null) {
      return h.pBB;
    }
    return this.pBr;
  }
  
  public final com.google.android.exoplayer2.b.d bWD()
  {
    if (this.pBs == null) {
      return h.pBB;
    }
    return this.pBs;
  }
  
  final void bWE()
  {
    for (;;)
    {
      int j;
      try
      {
        AppMethodBeat.i(230305);
        if ((this.pAZ == null) || (this.pzq))
        {
          AppMethodBeat.o(230305);
          return;
        }
        int i = this.pAZ.ra();
        boolean bool = this.pAZ.rb();
        j = g.f.u(bool, i);
        if (j == this.pBb.pBz[3]) {
          break label542;
        }
        Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "reportPlayerState, set new recent state [" + bool + "," + i + "]");
        this.pBb.t(bool, i);
        if (j == 3)
        {
          iM(true);
          if (j != g.f.u(true, 4)) {
            break label271;
          }
          Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "reportPlayerState, isSeeking: %b, loopingPlaySeek: %b", new Object[] { Boolean.valueOf(this.pBk.get()), Boolean.valueOf(this.pBj) });
          if ((this.pBk.getAndSet(false)) && (!this.pBj)) {
            bWk();
          }
          if (!this.mIsLooping) {
            break label252;
          }
          Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "looping play start");
          this.pBj = true;
          seekTo(0L);
          AppMethodBeat.o(230305);
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
        iM(false);
        continue;
        label252:
        this.pzp = 6;
        bWj();
        AppMethodBeat.o(230305);
        continue;
        label271:
        if (this.pBb.a(new int[] { g.f.u(false, 1), g.f.u(false, 2), g.f.u(false, 3) }, false))
        {
          this.pzp = 2;
          bWi();
          this.pBt = false;
          AppMethodBeat.o(230305);
        }
        else
        {
          if ((this.pBb.a(new int[] { 100, 2, 3 }, true) | this.pBb.a(new int[] { 2, 100, 3 }, true) | this.pBb.a(new int[] { 100, 3, 2, 3 }, true)))
          {
            if (!this.pBj) {
              bWk();
            }
            for (;;)
            {
              this.pBk.set(false);
              AppMethodBeat.o(230305);
              break;
              this.pBj = false;
            }
          }
          if (this.pBb.a(new int[] { g.f.u(true, 3), g.f.u(true, 2) }, false))
          {
            eI(701, getBufferedPercentage());
            AppMethodBeat.o(230305);
          }
          else
          {
            if (this.pBb.a(new int[] { g.f.u(true, 2), g.f.u(true, 3) }, false)) {
              eI(702, getBufferedPercentage());
            }
            label542:
            AppMethodBeat.o(230305);
          }
        }
      }
    }
  }
  
  public final g.b bWF()
  {
    AppMethodBeat.i(230313);
    boolean bool1;
    boolean bool2;
    if (this.pBt) {
      if (this.pAC > 0)
      {
        bool1 = false;
        bool2 = true;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "statErrorPlayerNotFound, hasLoadError: %b, hasOtherError: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      g.b localb = new g.b(bool2, bool1);
      AppMethodBeat.o(230313);
      return localb;
      if (!this.pBu)
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
  
  protected com.tencent.mm.plugin.appbrand.jsapi.video.f bWq()
  {
    AppMethodBeat.i(230243);
    com.tencent.mm.plugin.appbrand.jsapi.video.f localf = (com.tencent.mm.plugin.appbrand.jsapi.video.f)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.video.f.class);
    AppMethodBeat.o(230243);
    return localf;
  }
  
  protected void bWr() {}
  
  protected void bWs() {}
  
  public final int bWy()
  {
    return this.pBn;
  }
  
  public final int bWz()
  {
    return this.pBo;
  }
  
  public boolean eH(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(230299);
    boolean bool = super.eH(paramInt1, paramInt2);
    this.pBu = true;
    this.pAC = 0;
    AppMethodBeat.o(230299);
    return bool;
  }
  
  public final void ef(String paramString1, String paramString2)
  {
    AppMethodBeat.i(230227);
    this.pBc = a(Uri.parse(paramString1), paramString2, "");
    this.pAC = 0;
    this.pzp = 1;
    AppMethodBeat.o(230227);
  }
  
  public final void eg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(230229);
    this.pBc = a(Uri.parse(paramString1), null, paramString2);
    this.pAC = 0;
    this.pzp = 1;
    AppMethodBeat.o(230229);
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(230261);
    if (available())
    {
      int i = (int)this.pAZ.getCurrentPosition();
      AppMethodBeat.o(230261);
      return i;
    }
    AppMethodBeat.o(230261);
    return 0;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(230258);
    if (available())
    {
      int i = (int)this.pAZ.getDuration();
      AppMethodBeat.o(230258);
      return i;
    }
    AppMethodBeat.o(230258);
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
  
  protected int h(Uri paramUri)
  {
    AppMethodBeat.i(230237);
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
    AppMethodBeat.o(230237);
    return i;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(230223);
    if (available())
    {
      switch (this.pAZ.ra())
      {
      }
      do
      {
        AppMethodBeat.o(230223);
        return false;
        boolean bool = this.pAZ.rb();
        AppMethodBeat.o(230223);
        return bool;
      } while (!this.mIsLooping);
      AppMethodBeat.o(230223);
      return true;
    }
    AppMethodBeat.o(230223);
    return false;
  }
  
  public final void k(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(230277);
    if (available())
    {
      this.pAZ.seekTo(paramLong);
      this.pBb.t(paramBoolean, 100);
    }
    AppMethodBeat.o(230277);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(230272);
    if (available())
    {
      this.pAZ.aM(false);
      this.pzp = 3;
    }
    AppMethodBeat.o(230272);
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(230268);
    if (this.pBc == null)
    {
      Log.w("MicroMsg.SameLayer.ExoMediaPlayer", "prepareAsync, media source is null");
      AppMethodBeat.o(230268);
      return;
    }
    if (available())
    {
      this.pAZ.aM(false);
      this.pAZ.a(this.pBc);
      this.pBt = true;
    }
    AppMethodBeat.o(230268);
  }
  
  public final void release()
  {
    AppMethodBeat.i(230290);
    this.pzq = true;
    if (available())
    {
      iM(false);
      if (available())
      {
        this.pAZ.release();
        this.pAZ.b(this.pBe);
        this.pAZ = null;
      }
      this.mVideoWidth = 0;
      this.mVideoHeight = 0;
      this.pBi = 0;
    }
    if (this.mHandlerThread != null)
    {
      this.mHandlerThread.quit();
      this.mHandlerThread = null;
    }
    if (this.mSurface != null)
    {
      if (this.pBa) {
        this.mSurface.release();
      }
      this.mSurface = null;
    }
    this.pzr = null;
    this.pzs = null;
    this.pzt = null;
    this.pzu = null;
    this.pzv = null;
    this.pzw = null;
    this.pzx = null;
    this.pzp = -2;
    super.release();
    AppMethodBeat.o(230290);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(230285);
    if (available())
    {
      iM(false);
      if (available())
      {
        this.pAZ.aM(false);
        this.pAZ.stop();
      }
      this.mIsLooping = false;
      this.pBi = 0;
      this.pBb.pBz = new int[] { 1, 1, 1, 1 };
      this.pzp = 0;
    }
    AppMethodBeat.o(230285);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(230274);
    g.f localf;
    if (available())
    {
      this.pAZ.seekTo(paramLong);
      localf = this.pBb;
      if ((this.pBb.pBz[3] & 0xF0000000) == 0) {
        break label70;
      }
    }
    label70:
    for (boolean bool = true;; bool = false)
    {
      localf.t(bool, 100);
      this.pBk.set(true);
      AppMethodBeat.o(230274);
      return;
    }
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(230225);
    ef(paramString, null);
    AppMethodBeat.o(230225);
  }
  
  public final void setLooping(boolean paramBoolean)
  {
    this.mIsLooping = paramBoolean;
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(230252);
    if (available())
    {
      if (paramBoolean)
      {
        setVolume(0.0F, 0.0F);
        AppMethodBeat.o(230252);
        return;
      }
      setVolume(1.0F, 1.0F);
    }
    AppMethodBeat.o(230252);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(230246);
    if ((available()) && (available()))
    {
      if ((this.mSurface == null) || (this.mSurface == paramSurface) || (paramSurface == null)) {
        break label116;
      }
      if (this.pBa) {
        this.mSurface.release();
      }
      a(2, 1, paramSurface, true);
      final long l = this.pAZ.getCurrentPosition();
      if (x.SDK_INT < 23) {
        this.mMainHandler.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(228378);
            if (g.b(g.this)) {
              g.this.pAZ.seekTo(l);
            }
            AppMethodBeat.o(228378);
          }
        }, 200L);
      }
    }
    for (;;)
    {
      this.mSurface = paramSurface;
      this.pBa = false;
      AppMethodBeat.o(230246);
      return;
      label116:
      a(2, 1, paramSurface, false);
    }
  }
  
  public final void setVolume(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(230255);
    cK(Float.valueOf(paramFloat1));
    AppMethodBeat.o(230255);
  }
  
  public final void start()
  {
    AppMethodBeat.i(230270);
    if (available())
    {
      if (this.pAZ.ra() == 4) {
        this.pAZ.seekTo(0L);
      }
      this.pAZ.aM(true);
      this.pzp = 3;
      this.nLe.set(false);
    }
    AppMethodBeat.o(230270);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(230281);
    if ((available()) && (!this.nLe.getAndSet(true)))
    {
      this.pAZ.aM(false);
      this.pAZ.stop();
      this.pzp = 5;
    }
    AppMethodBeat.o(230281);
  }
  
  final class a
    implements h.b
  {
    private a() {}
    
    public final void bWp()
    {
      AppMethodBeat.i(226868);
      for (;;)
      {
        synchronized (g.this)
        {
          if (g.this.pzq)
          {
            AppMethodBeat.o(226868);
            return;
          }
          if (g.b(g.this)) {}
          switch (g.this.pAZ.ra())
          {
          case 1: 
            AppMethodBeat.o(226868);
            return;
          case 4: 
            g.a(g.this, false);
          }
        }
        int i = g.c(g.this);
        if (i != g.this.pBi)
        {
          g.this.Bc(i);
          g.this.pBi = i;
        }
      }
    }
  }
  
  final class c
    implements b, h.a
  {
    private c() {}
    
    public final void a(int paramInt, Format paramFormat, long paramLong)
    {
      AppMethodBeat.i(229887);
      Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "[TRACE_ADAPTIVE] onDownstreamFormatChanged, trackType:%s, trackFormat:%s, mediaTimeMs:%s", new Object[] { Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong) });
      g.this.ajn(paramFormat.id);
      AppMethodBeat.o(229887);
    }
    
    public final void a(j paramj, int paramInt1, int paramInt2, Format paramFormat, int paramInt3, Object paramObject, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, IOException paramIOException, boolean paramBoolean)
    {
      AppMethodBeat.i(229885);
      g.this.pBg.a(paramj, paramInt1, paramInt2, paramFormat, paramInt3, paramObject, paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramIOException, paramBoolean);
      Log.printErrStackTrace("MicroMsg.SameLayer.ExoMediaPlayer", paramIOException, "onLoadError1, IOException, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s, loadDurationMs:%s, bytesLoaded:%s, wasCanceled:%s", new Object[] { paramj, Integer.valueOf(paramInt2), paramFormat, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(paramLong4), Long.valueOf(paramLong5), Boolean.valueOf(paramBoolean) });
      g.d(g.this);
      g.this.bWr();
      AppMethodBeat.o(229885);
    }
    
    public final void a(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(229875);
      Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "onLoadStarted, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s", new Object[] { paramj, Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
      AppMethodBeat.o(229875);
    }
    
    public final void b(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(229879);
      Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "onLoadCompleted, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s", new Object[] { paramj, Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
      AppMethodBeat.o(229879);
    }
    
    public final void c(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(229881);
      Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "onLoadCanceled, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s", new Object[] { paramj, Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
      AppMethodBeat.o(229881);
    }
    
    public final void onLoadError(IOException paramIOException)
    {
      AppMethodBeat.i(229890);
      g.this.pBg.onLoadError(paramIOException);
      g.d(g.this);
      g.this.bWs();
      AppMethodBeat.o(229890);
    }
    
    public final void tj()
    {
      AppMethodBeat.i(229889);
      g.this.pBg.tj();
      AppMethodBeat.o(229889);
    }
  }
  
  final class d
    implements f.a
  {
    private d() {}
    
    public final void I(int paramInt)
    {
      AppMethodBeat.i(230390);
      g.this.pBg.I(paramInt);
      AppMethodBeat.o(230390);
    }
    
    public final void a(com.google.android.exoplayer2.e parame)
    {
      int i = -4000;
      AppMethodBeat.i(230393);
      g.this.pBg.a(parame);
      if (g.b(g.this)) {
        g.a(g.this, false);
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
              boolean bool = h.isNetworkAvailable(g.this.mAppContext);
              Log.printErrStackTrace("MicroMsg.SameLayer.ExoMediaPlayer", localThrowable, "ExoPlaybackException hasNetwork=".concat(String.valueOf(bool)), new Object[0]);
              if (!bool)
              {
                g.this.eH(-4000, -2);
                AppMethodBeat.o(230393);
                return;
              }
              g.this.eH(-4000, -3);
              AppMethodBeat.o(230393);
              return;
            }
            if (!(localThrowable instanceof s.e)) {
              break label456;
            }
            parame = localThrowable.toString();
            if (parame.contains("403"))
            {
              g.this.eH(-4000, -10);
              AppMethodBeat.o(230393);
              return;
            }
            if (parame.contains("404"))
            {
              g.this.eH(-4000, -11);
              AppMethodBeat.o(230393);
              return;
            }
            if (parame.contains("500"))
            {
              g.this.eH(-4000, -12);
              AppMethodBeat.o(230393);
              return;
            }
            if (parame.contains("502"))
            {
              g.this.eH(-4000, -13);
              AppMethodBeat.o(230393);
              return;
            }
            g.this.eH(-4000, -30);
            AppMethodBeat.o(230393);
            return;
          }
          if ((localThrowable instanceof s))
          {
            Log.e("MicroMsg.SameLayer.ExoMediaPlayer", h.bWG());
            g.this.eH(-4001, -1);
            AppMethodBeat.o(230393);
            return;
          }
          if ((localThrowable instanceof IllegalStateException))
          {
            Log.e("MicroMsg.SameLayer.ExoMediaPlayer", h.bWG());
            g.this.eH(-4002, -1);
            AppMethodBeat.o(230393);
            return;
          }
          if ((localThrowable instanceof b.a))
          {
            Log.w("MicroMsg.SameLayer.ExoMediaPlayer", "onPlayError, error: " + h.j(parame));
            Log.e("MicroMsg.SameLayer.ExoMediaPlayer", h.bWG());
            g.this.eH(-4003, -1);
            AppMethodBeat.o(230393);
            return;
          }
          if ((localThrowable instanceof t.f))
          {
            Log.e("MicroMsg.SameLayer.ExoMediaPlayer", h.bWG());
            g.this.eH(-4004, -1);
            AppMethodBeat.o(230393);
            return;
          }
        }
        i = -4999;
        label456:
        if (1 == parame.type)
        {
          Log.e("MicroMsg.SameLayer.ExoMediaPlayer", h.bWG());
          g.this.eH(-4005, -1);
          AppMethodBeat.o(230393);
        }
      }
      else
      {
        i = -4999;
      }
      Log.e("MicroMsg.SameLayer.ExoMediaPlayer", h.Bf(30));
      g.this.eH(i, -1);
      AppMethodBeat.o(230393);
    }
    
    public final void a(com.google.android.exoplayer2.source.r paramr, com.google.android.exoplayer2.g.g paramg)
    {
      AppMethodBeat.i(230387);
      g.this.pBg.a(paramr, paramg);
      AppMethodBeat.o(230387);
    }
    
    public final void aP(boolean paramBoolean)
    {
      AppMethodBeat.i(230391);
      g.this.pBg.aP(paramBoolean);
      if (paramBoolean) {
        g.a(g.this, true);
      }
      AppMethodBeat.o(230391);
    }
    
    public final void b(p paramp)
    {
      AppMethodBeat.i(230388);
      g.this.pBg.b(paramp);
      AppMethodBeat.o(230388);
    }
    
    public final void b(w paramw, Object paramObject)
    {
      AppMethodBeat.i(230382);
      g.this.pBg.b(paramw, paramObject);
      AppMethodBeat.o(230382);
    }
    
    public final void e(boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(230392);
      g.this.pBg.e(paramBoolean, paramInt);
      g.this.bWE();
      AppMethodBeat.o(230392);
    }
    
    public final void rs()
    {
      AppMethodBeat.i(230383);
      Log.d("MicroMsg.Video.Exo.EventLogger", "positionDiscontinuity");
      AppMethodBeat.o(230383);
    }
  }
  
  final class e
    implements com.google.android.exoplayer2.a.e, j.a, e.a, com.google.android.exoplayer2.video.e
  {
    private e() {}
    
    public final void a(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
    {
      AppMethodBeat.i(227138);
      g.this.pBg.a(paramInt1, paramInt2, paramInt3, paramFloat);
      g.this.mVideoWidth = paramInt1;
      g.this.mVideoHeight = paramInt2;
      g.this.eG(paramInt1, paramInt2);
      AppMethodBeat.o(227138);
    }
    
    public final void a(com.google.android.exoplayer2.b.d paramd)
    {
      AppMethodBeat.i(227127);
      g.this.pBg.a(paramd);
      g.this.pBr = paramd;
      AppMethodBeat.o(227127);
    }
    
    public final void b(com.google.android.exoplayer2.b.d paramd)
    {
      AppMethodBeat.i(227130);
      g.this.pBg.b(paramd);
      g.this.pBr = null;
      AppMethodBeat.o(227130);
    }
    
    public final void b(Metadata paramMetadata)
    {
      AppMethodBeat.i(227121);
      g.this.pBg.b(paramMetadata);
      AppMethodBeat.o(227121);
    }
    
    public final void b(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(227132);
      g.this.pBg.b(paramString, paramLong1, paramLong2);
      AppMethodBeat.o(227132);
    }
    
    public final void c(Surface paramSurface)
    {
      AppMethodBeat.i(227137);
      g.this.pBg.c(paramSurface);
      g.this.eI(3, 0);
      AppMethodBeat.o(227137);
    }
    
    public final void c(Format paramFormat)
    {
      AppMethodBeat.i(227134);
      g.this.pBg.c(paramFormat);
      AppMethodBeat.o(227134);
    }
    
    public final void c(com.google.android.exoplayer2.b.d paramd)
    {
      AppMethodBeat.i(227098);
      g.this.pBg.c(paramd);
      g.this.pBs = paramd;
      AppMethodBeat.o(227098);
    }
    
    public final void c(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(227111);
      g.this.pBg.c(paramString, paramLong1, paramLong2);
      AppMethodBeat.o(227111);
    }
    
    public final void d(int paramInt, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(227119);
      g.this.pBg.d(paramInt, paramLong1, paramLong2);
      AppMethodBeat.o(227119);
    }
    
    public final void d(Format paramFormat)
    {
      AppMethodBeat.i(227115);
      g.this.pBg.d(paramFormat);
      AppMethodBeat.o(227115);
    }
    
    public final void d(com.google.android.exoplayer2.b.d paramd)
    {
      AppMethodBeat.i(227101);
      g.this.pBg.d(paramd);
      g.this.pBs = null;
      AppMethodBeat.o(227101);
    }
    
    public final void dU(int paramInt)
    {
      AppMethodBeat.i(227104);
      g.this.pBg.dU(paramInt);
      AppMethodBeat.o(227104);
    }
    
    public final void h(int paramInt, long paramLong)
    {
      AppMethodBeat.i(227135);
      g.this.pBg.h(paramInt, paramLong);
      AppMethodBeat.o(227135);
    }
    
    public final void n(List<com.google.android.exoplayer2.f.a> paramList)
    {
      AppMethodBeat.i(227124);
      Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "onCues");
      AppMethodBeat.o(227124);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g
 * JD-Core Version:    0.7.0.1
 */