package com.tencent.mm.plugin.appbrand.jsapi.video.e.c;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Size;
import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.e.b.a;
import com.google.android.exoplayer2.f.a;
import com.google.android.exoplayer2.f.c;
import com.google.android.exoplayer2.h.g.a;
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
import com.tencent.mm.plugin.appbrand.jsapi.video.e.i.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class j
  extends com.tencent.mm.plugin.appbrand.jsapi.video.e.a
{
  private static volatile boolean sGt = false;
  protected int dhq;
  protected float dhu;
  protected Context mAppContext;
  private HandlerThread mHandlerThread;
  public boolean mIsLooping;
  private Handler mMainHandler;
  private Surface mSurface;
  private int mVideoHeight;
  private int mVideoWidth;
  private final AtomicBoolean qKN;
  private volatile boolean sEv;
  protected com.google.android.exoplayer2.f sFY;
  private boolean sFZ;
  private f sGa;
  private com.google.android.exoplayer2.source.k sGb;
  private List<com.google.android.exoplayer2.r> sGc;
  private f.a sGd;
  private c sGe;
  private g sGf;
  private com.tencent.mm.plugin.appbrand.jsapi.video.e.i sGg;
  private int sGh;
  private boolean sGi;
  private final AtomicBoolean sGj;
  protected int sGk;
  protected int sGl;
  protected int sGm;
  protected int sGn;
  protected int sGo;
  protected int sGp;
  private int sGq;
  private com.google.android.exoplayer2.b.d sGr;
  private com.google.android.exoplayer2.b.d sGs;
  private volatile boolean sGu;
  private volatile boolean sGv;
  
  public j()
  {
    this(null);
  }
  
  public j(int paramInt1, float paramFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this(null, paramInt1, paramFloat, paramInt2, paramInt3, paramInt4, paramInt5, 2500);
  }
  
  public j(Handler paramHandler)
  {
    this(paramHandler, 0, 0.75F, 10000, 25000, 15000, 30000, 2500);
  }
  
  public j(Handler paramHandler, int paramInt1, float paramFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this(paramHandler, paramInt1, paramFloat, paramInt2, paramInt3, paramInt4, paramInt5, 2500);
  }
  
  private j(Handler paramHandler, int paramInt1, float paramFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(328750);
    this.qKN = new AtomicBoolean();
    this.sGj = new AtomicBoolean(false);
    this.dhq = 0;
    this.dhu = 0.75F;
    this.sGk = 10000;
    this.sGl = 25000;
    this.sGm = 15000;
    this.sGn = 30000;
    this.sGo = 2500;
    this.sGp = 5000;
    this.sGq = 0;
    this.sGr = null;
    this.sGs = null;
    this.sGu = false;
    this.sGv = false;
    Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "ExoMediaPlayer, handler = %s, maxInitBitrate = %s, bandFraction = %s, minDur = %s, maxDur = %s, minBuffer = %s, maxBuffer = %s, bufferForPlaybackMs:%s, bufferForPlaybackAfterRebufferMs:%s", new Object[] { paramHandler, Integer.valueOf(paramInt1), Float.valueOf(paramFloat), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(5000) });
    this.dhq = 0;
    this.dhu = paramFloat;
    this.sGk = paramInt2;
    this.sGl = paramInt3;
    this.sGm = paramInt4;
    this.sGn = paramInt5;
    this.sGo = paramInt6;
    this.sGp = 5000;
    e(paramHandler);
    AppMethodBeat.o(328750);
  }
  
  public j(Handler paramHandler, int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramHandler, 0, 0.75F, 10000, 25000, paramInt1, paramInt2, paramInt3);
  }
  
  private com.google.android.exoplayer2.source.k a(Uri paramUri, String paramString1, String paramString2)
  {
    AppMethodBeat.i(328793);
    int i = j(paramUri);
    paramString1 = com.tencent.mm.plugin.appbrand.jsapi.y.d.abw(paramString1);
    switch (i)
    {
    default: 
      Log.e("MicroMsg.SameLayer.ExoMediaPlayer", "buildMediaSource, unsupported type:" + i + ", url:" + paramUri);
      AppMethodBeat.o(328793);
      return null;
    case 2: 
      Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "buildMediaSource, type:HLS, url:%s", new Object[] { paramUri });
      paramUri = new com.google.android.exoplayer2.source.b.h(paramUri, k.b(this.mAppContext, paramString1), this.mMainHandler, this.sGe);
      AppMethodBeat.o(328793);
      return paramUri;
    }
    Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "buildMediaSource, type:other, url:%s", new Object[] { paramUri });
    if ((paramString2 != null) && (paramString2.length() > 0))
    {
      Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "[TRACE_VIDEO_PRELOAD] buildMediaSource with cutomkey = %s", new Object[] { paramString2 });
      paramUri = new com.google.android.exoplayer2.source.h(paramUri, V(paramString1), cwN(), this.mMainHandler, this.sGe, paramString2);
      AppMethodBeat.o(328793);
      return paramUri;
    }
    paramUri = new com.google.android.exoplayer2.source.h(paramUri, V(paramString1), cwN(), this.mMainHandler, this.sGe);
    AppMethodBeat.o(328793);
    return paramUri;
  }
  
  private void a(int paramInt1, int paramInt2, Object paramObject, boolean paramBoolean)
  {
    AppMethodBeat.i(328847);
    if (this.sGc.isEmpty())
    {
      AppMethodBeat.o(328847);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.sGc.iterator();
    while (localIterator.hasNext())
    {
      com.google.android.exoplayer2.r localr = (com.google.android.exoplayer2.r)localIterator.next();
      if (localr.getTrackType() == paramInt1) {
        localArrayList.add(new f.c(localr, paramInt2, paramObject));
      }
    }
    if (paramBoolean)
    {
      this.sFY.b((f.c[])localArrayList.toArray(new f.c[localArrayList.size()]));
      AppMethodBeat.o(328847);
      return;
    }
    this.sFY.a((f.c[])localArrayList.toArray(new f.c[localArrayList.size()]));
    AppMethodBeat.o(328847);
  }
  
  private boolean available()
  {
    return this.sFY != null;
  }
  
  private void cwJ()
  {
    AppMethodBeat.i(328774);
    Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "iniMediaPlayer");
    com.google.android.exoplayer2.g.c localc = new com.google.android.exoplayer2.g.c(new c.b(k.cwV(), this.dhq, this.sGk, this.sGl, this.dhu));
    this.sGf = new g(localc);
    com.google.android.exoplayer2.c localc1 = new com.google.android.exoplayer2.c(new com.google.android.exoplayer2.h.k(), this.sGm, this.sGn, this.sGo, this.sGp);
    this.sFY = com.google.android.exoplayer2.g.a((com.google.android.exoplayer2.r[])this.sGc.toArray(new com.google.android.exoplayer2.r[this.sGc.size()]), localc, localc1);
    this.sFY.a(this.sGd);
    AppMethodBeat.o(328774);
  }
  
  private void cwT()
  {
    for (;;)
    {
      int j;
      try
      {
        AppMethodBeat.i(328831);
        if ((this.sFY == null) || (this.sEv))
        {
          AppMethodBeat.o(328831);
          return;
        }
        int i = this.sFY.QC();
        boolean bool = this.sFY.QD();
        j = f.s(bool, i);
        if (j == this.sGa.sGB[3]) {
          break label542;
        }
        Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "reportPlayerState, set new recent state [" + bool + "," + i + "]");
        this.sGa.r(bool, i);
        if (j == 3)
        {
          jQ(true);
          if (j != f.s(true, 4)) {
            break label271;
          }
          Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "reportPlayerState, isSeeking: %b, loopingPlaySeek: %b", new Object[] { Boolean.valueOf(this.sGj.get()), Boolean.valueOf(this.sGi) });
          if ((this.sGj.getAndSet(false)) && (!this.sGi)) {
            cww();
          }
          if (!this.mIsLooping) {
            break label252;
          }
          Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "looping play start");
          this.sGi = true;
          seekTo(0L);
          AppMethodBeat.o(328831);
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
        jQ(false);
        continue;
        label252:
        this.sEu = 6;
        cwv();
        AppMethodBeat.o(328831);
        continue;
        label271:
        if (this.sGa.b(new int[] { f.s(false, 1), f.s(false, 2), f.s(false, 3) }, false))
        {
          this.sEu = 2;
          cwu();
          this.sGu = false;
          AppMethodBeat.o(328831);
        }
        else
        {
          if ((this.sGa.b(new int[] { 100, 2, 3 }, true) | this.sGa.b(new int[] { 2, 100, 3 }, true) | this.sGa.b(new int[] { 100, 3, 2, 3 }, true)))
          {
            if (!this.sGi) {
              cww();
            }
            for (;;)
            {
              this.sGj.set(false);
              AppMethodBeat.o(328831);
              break;
              this.sGi = false;
            }
          }
          if (this.sGa.b(new int[] { f.s(true, 3), f.s(true, 2) }, false))
          {
            fC(701, getBufferedPercentage());
            AppMethodBeat.o(328831);
          }
          else
          {
            if (this.sGa.b(new int[] { f.s(true, 2), f.s(true, 3) }, false)) {
              fC(702, getBufferedPercentage());
            }
            label542:
            AppMethodBeat.o(328831);
          }
        }
      }
    }
  }
  
  private void e(Handler paramHandler)
  {
    AppMethodBeat.i(328762);
    this.mAppContext = MMApplicationContext.getContext();
    this.sGa = new f((byte)0);
    if (paramHandler != null) {}
    for (this.mMainHandler = paramHandler;; this.mMainHandler = new Handler(this.mHandlerThread.getLooper()))
    {
      this.sGd = new d((byte)0);
      this.sGe = new c((byte)0);
      this.sGg = new com.tencent.mm.plugin.appbrand.jsapi.video.e.i(this.mMainHandler);
      this.sGg.sFa = 1000;
      this.sGg.sFc = new a((byte)0);
      e locale = new e((byte)0);
      this.sGc = new f(this.mAppContext, this.mMainHandler, locale, locale, locale, locale).cwH();
      if ((paramHandler == null) || (paramHandler.getLooper() != Looper.myLooper())) {
        break;
      }
      cwJ();
      AppMethodBeat.o(328762);
      return;
      this.mHandlerThread = com.tencent.threadpool.c.d.jw("ExoMediaPlayer_HandlerThread", 5);
      this.mHandlerThread.start();
    }
    this.mMainHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(328661);
        synchronized (j.this)
        {
          j.a(j.this);
          j.this.notifyAll();
          AppMethodBeat.o(328661);
          return;
        }
      }
    });
    try
    {
      for (;;)
      {
        paramHandler = this.sFY;
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
      AppMethodBeat.o(328762);
    }
    AppMethodBeat.o(328762);
  }
  
  private void ef(Object paramObject)
  {
    AppMethodBeat.i(328837);
    a(1, 2, paramObject, false);
    AppMethodBeat.o(328837);
  }
  
  private int getBufferedPercentage()
  {
    AppMethodBeat.i(328802);
    if (available())
    {
      int i = this.sFY.getBufferedPercentage();
      AppMethodBeat.o(328802);
      return i;
    }
    AppMethodBeat.o(328802);
    return 0;
  }
  
  private void jQ(boolean paramBoolean)
  {
    AppMethodBeat.i(328810);
    Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "setBufferRepeaterStarted ".concat(String.valueOf(paramBoolean)));
    if ((paramBoolean) && (this.sEB != null))
    {
      this.sGg.start();
      AppMethodBeat.o(328810);
      return;
    }
    this.sGg.sEZ = false;
    AppMethodBeat.o(328810);
  }
  
  public static void jR(boolean paramBoolean)
  {
    AppMethodBeat.i(328817);
    Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "enableFixVideoSize, fixVideoSize: ".concat(String.valueOf(paramBoolean)));
    sGt = paramBoolean;
    AppMethodBeat.o(328817);
  }
  
  protected g.a V(Map<String, String> paramMap)
  {
    AppMethodBeat.i(329020);
    if ((paramMap == null) && (!com.tencent.mm.plugin.appbrand.jsapi.video.i.cvD().sAx))
    {
      g.a locala = null;
      com.tencent.mm.plugin.appbrand.jsapi.video.f localf = cwO();
      if (localf != null) {
        locala = localf.cvB();
      }
      if (locala != null)
      {
        Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "getDataSourceFactory, return customized data source factory");
        AppMethodBeat.o(329020);
        return locala;
      }
    }
    Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "getDataSourceFactory, return default data source factory");
    paramMap = k.b(this.mAppContext, paramMap);
    AppMethodBeat.o(329020);
    return paramMap;
  }
  
  public final <PlayerImpl extends com.tencent.mm.plugin.appbrand.jsapi.video.e.g> PlayerImpl aU(Class<PlayerImpl> paramClass)
  {
    AppMethodBeat.i(328968);
    if (j.class.isAssignableFrom(paramClass)) {}
    for (j localj = this;; localj = null)
    {
      Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "castTo, playerClass: %s, playerImpl: %s", new Object[] { paramClass, localj });
      AppMethodBeat.o(328968);
      return localj;
    }
  }
  
  public final boolean bN(float paramFloat)
  {
    AppMethodBeat.i(329045);
    if (available())
    {
      p localp = new p(paramFloat, 1.0F);
      this.sFY.a(localp);
      AppMethodBeat.o(329045);
      return true;
    }
    AppMethodBeat.o(329045);
    return false;
  }
  
  public final void cM(String paramString, int paramInt)
  {
    AppMethodBeat.i(328985);
    ey(paramString, null);
    AppMethodBeat.o(328985);
  }
  
  public final int cwK()
  {
    return this.sGm;
  }
  
  public final int cwL()
  {
    return this.sGn;
  }
  
  public final int cwM()
  {
    return this.sGo;
  }
  
  protected com.google.android.exoplayer2.c.h cwN()
  {
    AppMethodBeat.i(329010);
    i locali = new i();
    AppMethodBeat.o(329010);
    return locali;
  }
  
  protected com.tencent.mm.plugin.appbrand.jsapi.video.f cwO()
  {
    AppMethodBeat.i(329028);
    com.tencent.mm.plugin.appbrand.jsapi.video.f localf = (com.tencent.mm.plugin.appbrand.jsapi.video.f)com.tencent.luggage.a.e.T(com.tencent.mm.plugin.appbrand.jsapi.video.f.class);
    AppMethodBeat.o(329028);
    return localf;
  }
  
  public final com.google.android.exoplayer2.b.d cwP()
  {
    if (this.sGr == null) {
      return k.sGD;
    }
    return this.sGr;
  }
  
  public final com.google.android.exoplayer2.b.d cwQ()
  {
    if (this.sGs == null) {
      return k.sGD;
    }
    return this.sGs;
  }
  
  protected void cwR() {}
  
  protected void cwS() {}
  
  public final j.b cwU()
  {
    AppMethodBeat.i(329129);
    boolean bool1;
    boolean bool2;
    if (this.sGu) {
      if (this.sGq > 0)
      {
        bool1 = false;
        bool2 = true;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "statErrorPlayerNotFound, hasLoadError: %b, hasOtherError: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      j.b localb = new j.b(bool2, bool1);
      AppMethodBeat.o(329129);
      return localb;
      if (!this.sGv)
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
  
  public final void ey(String paramString1, String paramString2)
  {
    AppMethodBeat.i(328991);
    this.sGb = a(Uri.parse(paramString1), paramString2, "");
    this.sGq = 0;
    this.sEu = 1;
    AppMethodBeat.o(328991);
  }
  
  public final void ez(String paramString1, String paramString2)
  {
    AppMethodBeat.i(328995);
    this.sGb = a(Uri.parse(paramString1), null, paramString2);
    this.sGq = 0;
    this.sEu = 1;
    AppMethodBeat.o(328995);
  }
  
  public boolean fB(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(329124);
    boolean bool = super.fB(paramInt1, paramInt2);
    this.sGv = true;
    this.sGq = 0;
    AppMethodBeat.o(329124);
    return bool;
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(329074);
    if (available())
    {
      int i = (int)this.sFY.getCurrentPosition();
      AppMethodBeat.o(329074);
      return i;
    }
    AppMethodBeat.o(329074);
    return 0;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(329070);
    if (available())
    {
      int i = (int)this.sFY.getDuration();
      AppMethodBeat.o(329070);
      return i;
    }
    AppMethodBeat.o(329070);
    return 0;
  }
  
  public final int getPlayerType()
  {
    return 2;
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
    AppMethodBeat.i(328975);
    if (available())
    {
      switch (this.sFY.QC())
      {
      }
      do
      {
        AppMethodBeat.o(328975);
        return false;
        boolean bool = this.sFY.QD();
        AppMethodBeat.o(328975);
        return bool;
      } while (!this.mIsLooping);
      AppMethodBeat.o(328975);
      return true;
    }
    AppMethodBeat.o(328975);
    return false;
  }
  
  protected int j(Uri paramUri)
  {
    AppMethodBeat.i(329002);
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
    AppMethodBeat.o(329002);
    return i;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(329091);
    if (available())
    {
      this.sFY.bv(false);
      this.sEu = 3;
    }
    AppMethodBeat.o(329091);
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(329082);
    if (this.sGb == null)
    {
      Log.w("MicroMsg.SameLayer.ExoMediaPlayer", "prepareAsync, media source is null");
      AppMethodBeat.o(329082);
      return;
    }
    if (available())
    {
      this.sFY.bv(false);
      this.sFY.a(this.sGb);
      this.sGu = true;
    }
    AppMethodBeat.o(329082);
  }
  
  public final void q(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(329101);
    if (available())
    {
      this.sFY.seekTo(paramLong);
      this.sGa.r(paramBoolean, 100);
    }
    AppMethodBeat.o(329101);
  }
  
  public final void release()
  {
    AppMethodBeat.i(329117);
    this.sEv = true;
    if (available())
    {
      jQ(false);
      if (available())
      {
        this.sFY.release();
        this.sFY.b(this.sGd);
        this.sFY = null;
      }
      this.mVideoWidth = 0;
      this.mVideoHeight = 0;
      this.sGh = 0;
    }
    if (this.mHandlerThread != null)
    {
      this.mHandlerThread.quit();
      this.mHandlerThread = null;
    }
    if (this.mSurface != null)
    {
      if (this.sFZ) {
        this.mSurface.release();
      }
      this.mSurface = null;
    }
    this.sEw = null;
    this.sEx = null;
    this.sEy = null;
    this.sEz = null;
    this.sEA = null;
    this.sEB = null;
    this.sEC = null;
    this.sEu = -2;
    super.release();
    AppMethodBeat.o(329117);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(329108);
    if (available())
    {
      jQ(false);
      if (available())
      {
        this.sFY.bv(false);
        this.sFY.stop();
      }
      this.mIsLooping = false;
      this.sGh = 0;
      this.sGa.sGB = new int[] { 1, 1, 1, 1 };
      this.sEu = 0;
    }
    AppMethodBeat.o(329108);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(329094);
    f localf;
    if (available())
    {
      this.sFY.seekTo(paramLong);
      localf = this.sGa;
      if ((this.sGa.sGB[3] & 0xF0000000) == 0) {
        break label70;
      }
    }
    label70:
    for (boolean bool = true;; bool = false)
    {
      localf.r(bool, 100);
      this.sGj.set(true);
      AppMethodBeat.o(329094);
      return;
    }
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(328979);
    ey(paramString, null);
    AppMethodBeat.o(328979);
  }
  
  public final void setLooping(boolean paramBoolean)
  {
    this.mIsLooping = paramBoolean;
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(329053);
    if (available())
    {
      if (paramBoolean)
      {
        setVolume(0.0F, 0.0F);
        AppMethodBeat.o(329053);
        return;
      }
      setVolume(1.0F, 1.0F);
    }
    AppMethodBeat.o(329053);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(329037);
    if ((available()) && (available()))
    {
      if ((this.mSurface == null) || (this.mSurface == paramSurface) || (paramSurface == null)) {
        break label116;
      }
      if (this.sFZ) {
        this.mSurface.release();
      }
      a(2, 1, paramSurface, true);
      final long l = this.sFY.getCurrentPosition();
      if (x.SDK_INT < 23) {
        this.mMainHandler.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(328678);
            if (j.b(j.this)) {
              j.this.sFY.seekTo(l);
            }
            AppMethodBeat.o(328678);
          }
        }, 200L);
      }
    }
    for (;;)
    {
      this.mSurface = paramSurface;
      this.sFZ = false;
      AppMethodBeat.o(329037);
      return;
      label116:
      a(2, 1, paramSurface, false);
    }
  }
  
  public final void setVolume(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(329058);
    ef(Float.valueOf(paramFloat1));
    AppMethodBeat.o(329058);
  }
  
  public final void start()
  {
    AppMethodBeat.i(329086);
    if (available())
    {
      if (this.sFY.QC() == 4) {
        this.sFY.seekTo(0L);
      }
      this.sFY.bv(true);
      this.sEu = 3;
      this.qKN.set(false);
    }
    AppMethodBeat.o(329086);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(329104);
    if ((available()) && (!this.qKN.getAndSet(true)))
    {
      this.sFY.bv(false);
      this.sFY.stop();
      this.sEu = 5;
    }
    AppMethodBeat.o(329104);
  }
  
  final class a
    implements i.b
  {
    private a() {}
    
    public final void cwC()
    {
      AppMethodBeat.i(328796);
      for (;;)
      {
        synchronized (j.this)
        {
          if (j.c(j.this))
          {
            AppMethodBeat.o(328796);
            return;
          }
          if (j.b(j.this)) {}
          switch (j.this.sFY.QC())
          {
          case 1: 
            AppMethodBeat.o(328796);
            return;
          case 4: 
            j.a(j.this, false);
          }
        }
        int i = j.d(j.this);
        if (i != j.e(j.this))
        {
          j.a(j.this, i);
          j.b(j.this, i);
        }
      }
    }
  }
  
  final class c
    implements b, h.a
  {
    private c() {}
    
    public final void SM()
    {
      AppMethodBeat.i(328825);
      j.f(j.this).SM();
      AppMethodBeat.o(328825);
    }
    
    public final void a(int paramInt, Format paramFormat, long paramLong)
    {
      AppMethodBeat.i(328820);
      Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "[TRACE_ADAPTIVE] onDownstreamFormatChanged, trackType:%s, trackFormat:%s, mediaTimeMs:%s", new Object[] { Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong) });
      j.a(j.this, paramFormat.id);
      AppMethodBeat.o(328820);
    }
    
    public final void a(com.google.android.exoplayer2.h.j paramj, int paramInt1, int paramInt2, Format paramFormat, int paramInt3, Object paramObject, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, IOException paramIOException, boolean paramBoolean)
    {
      AppMethodBeat.i(328812);
      j.f(j.this).a(paramj, paramInt1, paramInt2, paramFormat, paramInt3, paramObject, paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramIOException, paramBoolean);
      Log.printErrStackTrace("MicroMsg.SameLayer.ExoMediaPlayer", paramIOException, "onLoadError1, IOException, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s, loadDurationMs:%s, bytesLoaded:%s, wasCanceled:%s", new Object[] { paramj, Integer.valueOf(paramInt2), paramFormat, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(paramLong4), Long.valueOf(paramLong5), Boolean.valueOf(paramBoolean) });
      j.g(j.this);
      j.this.cwR();
      AppMethodBeat.o(328812);
    }
    
    public final void a(com.google.android.exoplayer2.h.j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(328786);
      Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "onLoadStarted, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s", new Object[] { paramj, Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
      AppMethodBeat.o(328786);
    }
    
    public final void b(com.google.android.exoplayer2.h.j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(328794);
      Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "onLoadCompleted, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s", new Object[] { paramj, Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
      AppMethodBeat.o(328794);
    }
    
    public final void c(com.google.android.exoplayer2.h.j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(328804);
      Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "onLoadCanceled, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s", new Object[] { paramj, Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
      AppMethodBeat.o(328804);
    }
    
    public final void onLoadError(IOException paramIOException)
    {
      AppMethodBeat.i(328832);
      j.f(j.this).onLoadError(paramIOException);
      j.g(j.this);
      j.this.cwS();
      AppMethodBeat.o(328832);
    }
  }
  
  final class d
    implements f.a
  {
    private d() {}
    
    public final void onLoadingChanged(boolean paramBoolean)
    {
      AppMethodBeat.i(328819);
      j.f(j.this).onLoadingChanged(paramBoolean);
      if (paramBoolean) {
        j.a(j.this, true);
      }
      AppMethodBeat.o(328819);
    }
    
    public final void onPlaybackParametersChanged(p paramp)
    {
      AppMethodBeat.i(328806);
      j.f(j.this).onPlaybackParametersChanged(paramp);
      AppMethodBeat.o(328806);
    }
    
    public final void onPlayerError(com.google.android.exoplayer2.e parame)
    {
      int i = -4000;
      AppMethodBeat.i(328838);
      j.f(j.this).onPlayerError(parame);
      if (j.b(j.this)) {
        j.a(j.this, false);
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
              boolean bool = k.isNetworkAvailable(j.this.mAppContext);
              Log.printErrStackTrace("MicroMsg.SameLayer.ExoMediaPlayer", localThrowable, "ExoPlaybackException hasNetwork=".concat(String.valueOf(bool)), new Object[0]);
              if (!bool)
              {
                j.this.fB(-4000, -2);
                AppMethodBeat.o(328838);
                return;
              }
              j.this.fB(-4000, -3);
              AppMethodBeat.o(328838);
              return;
            }
            if (!(localThrowable instanceof s.e)) {
              break label468;
            }
            parame = localThrowable.toString();
            if (parame.contains("403"))
            {
              j.this.fB(-4000, -10);
              AppMethodBeat.o(328838);
              return;
            }
            if (parame.contains("404"))
            {
              j.this.fB(-4000, -11);
              AppMethodBeat.o(328838);
              return;
            }
            if (parame.contains("500"))
            {
              j.this.fB(-4000, -12);
              AppMethodBeat.o(328838);
              return;
            }
            if (parame.contains("502"))
            {
              j.this.fB(-4000, -13);
              AppMethodBeat.o(328838);
              return;
            }
            j.this.fB(-4000, -30);
            AppMethodBeat.o(328838);
            return;
          }
          if ((localThrowable instanceof s))
          {
            k.b(new androidx.a.a.c.a() {});
            j.this.fB(-4001, -1);
            AppMethodBeat.o(328838);
            return;
          }
          if ((localThrowable instanceof IllegalStateException))
          {
            k.b(new androidx.a.a.c.a() {});
            j.this.fB(-4002, -1);
            AppMethodBeat.o(328838);
            return;
          }
          if ((localThrowable instanceof b.a))
          {
            Log.w("MicroMsg.SameLayer.ExoMediaPlayer", "onPlayError, error: " + k.t(parame));
            k.b(new androidx.a.a.c.a() {});
            j.this.fB(-4003, -1);
            AppMethodBeat.o(328838);
            return;
          }
          if ((localThrowable instanceof t.f))
          {
            k.b(new androidx.a.a.c.a() {});
            j.this.fB(-4004, -1);
            AppMethodBeat.o(328838);
            return;
          }
        }
        i = -4999;
        label468:
        if (1 == parame.type)
        {
          k.b(new androidx.a.a.c.a() {});
          j.this.fB(-4005, -1);
          AppMethodBeat.o(328838);
        }
      }
      else
      {
        i = -4999;
      }
      k.a(30, new androidx.a.a.c.a() {});
      j.this.fB(i, -1);
      AppMethodBeat.o(328838);
    }
    
    public final void onPlayerStateChanged(boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(328824);
      j.f(j.this).onPlayerStateChanged(paramBoolean, paramInt);
      j.h(j.this);
      AppMethodBeat.o(328824);
    }
    
    public final void onPositionDiscontinuity()
    {
      AppMethodBeat.i(328791);
      j.f(j.this).onPositionDiscontinuity();
      AppMethodBeat.o(328791);
    }
    
    public final void onRepeatModeChanged(int paramInt)
    {
      AppMethodBeat.i(328811);
      j.f(j.this).onRepeatModeChanged(paramInt);
      AppMethodBeat.o(328811);
    }
    
    public final void onTimelineChanged(w paramw, Object paramObject)
    {
      AppMethodBeat.i(328781);
      j.f(j.this).onTimelineChanged(paramw, paramObject);
      AppMethodBeat.o(328781);
    }
    
    public final void onTracksChanged(com.google.android.exoplayer2.source.r paramr, com.google.android.exoplayer2.g.g paramg)
    {
      AppMethodBeat.i(328799);
      j.f(j.this).onTracksChanged(paramr, paramg);
      AppMethodBeat.o(328799);
    }
  }
  
  final class e
    implements com.google.android.exoplayer2.a.e, com.google.android.exoplayer2.f.j.a, e.a, com.google.android.exoplayer2.video.e
  {
    private e() {}
    
    public final void a(com.google.android.exoplayer2.b.d paramd)
    {
      AppMethodBeat.i(328860);
      j.f(j.this).a(paramd);
      j.b(j.this, paramd);
      AppMethodBeat.o(328860);
    }
    
    public final void ag(List<com.google.android.exoplayer2.f.a> paramList)
    {
      AppMethodBeat.i(328854);
      Log.d("MicroMsg.SameLayer.ExoMediaPlayer", "onCues");
      AppMethodBeat.o(328854);
    }
    
    public final void b(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
    {
      AppMethodBeat.i(328887);
      j.f(j.this).b(paramInt1, paramInt2, paramInt3, paramFloat);
      Size localSize = j.f(paramInt1, paramInt2, paramFloat);
      paramInt1 = localSize.getWidth();
      paramInt2 = localSize.getHeight();
      j.c(j.this, paramInt1);
      j.d(j.this, paramInt2);
      j.a(j.this, paramInt1, paramInt2);
      AppMethodBeat.o(328887);
    }
    
    public final void b(com.google.android.exoplayer2.b.d paramd)
    {
      AppMethodBeat.i(328866);
      j.f(j.this).b(paramd);
      j.b(j.this, null);
      AppMethodBeat.o(328866);
    }
    
    public final void b(Metadata paramMetadata)
    {
      AppMethodBeat.i(328848);
      j.f(j.this).b(paramMetadata);
      AppMethodBeat.o(328848);
    }
    
    public final void b(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(328870);
      j.f(j.this).b(paramString, paramLong1, paramLong2);
      AppMethodBeat.o(328870);
    }
    
    public final void c(Format paramFormat)
    {
      AppMethodBeat.i(328876);
      j.f(j.this).c(paramFormat);
      AppMethodBeat.o(328876);
    }
    
    public final void c(com.google.android.exoplayer2.b.d paramd)
    {
      AppMethodBeat.i(328808);
      j.f(j.this).c(paramd);
      j.a(j.this, paramd);
      AppMethodBeat.o(328808);
    }
    
    public final void c(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(328826);
      j.f(j.this).c(paramString, paramLong1, paramLong2);
      AppMethodBeat.o(328826);
    }
    
    public final void d(int paramInt, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(328841);
      j.f(j.this).d(paramInt, paramLong1, paramLong2);
      AppMethodBeat.o(328841);
    }
    
    public final void d(Format paramFormat)
    {
      AppMethodBeat.i(328835);
      j.f(j.this).d(paramFormat);
      AppMethodBeat.o(328835);
    }
    
    public final void d(com.google.android.exoplayer2.b.d paramd)
    {
      AppMethodBeat.i(328815);
      j.f(j.this).d(paramd);
      j.a(j.this, null);
      AppMethodBeat.o(328815);
    }
    
    public final void f(Surface paramSurface)
    {
      AppMethodBeat.i(328884);
      j.f(j.this).f(paramSurface);
      j.i(j.this);
      AppMethodBeat.o(328884);
    }
    
    public final void h(int paramInt, long paramLong)
    {
      AppMethodBeat.i(328879);
      j.f(j.this).h(paramInt, paramLong);
      AppMethodBeat.o(328879);
    }
    
    public final void hl(int paramInt)
    {
      AppMethodBeat.i(328821);
      j.f(j.this).hl(paramInt);
      AppMethodBeat.o(328821);
    }
  }
  
  static final class f
  {
    int[] sGB;
    
    private f()
    {
      AppMethodBeat.i(328785);
      this.sGB = new int[] { 1, 1, 1, 1 };
      AppMethodBeat.o(328785);
    }
    
    static int s(boolean paramBoolean, int paramInt)
    {
      if (paramBoolean) {}
      for (int i = -268435456;; i = 0) {
        return i | paramInt;
      }
    }
    
    final boolean b(int[] paramArrayOfInt, boolean paramBoolean)
    {
      int i;
      int j;
      if (paramBoolean)
      {
        i = 268435455;
        int k = this.sGB.length - paramArrayOfInt.length;
        j = k;
        paramBoolean = true;
        label23:
        if (j >= this.sGB.length) {
          return paramBoolean;
        }
        if ((this.sGB[j] & i) != (paramArrayOfInt[(j - k)] & i)) {
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
    
    final void r(boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(328809);
      int i = s(paramBoolean, paramInt);
      Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "request setMostRecentState [" + paramBoolean + "," + paramInt + "], lastState=" + this.sGB[3] + ", newState=" + i);
      if (this.sGB[3] == i)
      {
        AppMethodBeat.o(328809);
        return;
      }
      this.sGB[0] = this.sGB[1];
      this.sGB[1] = this.sGB[2];
      this.sGB[2] = this.sGB[3];
      this.sGB[3] = i;
      Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "new MostRecentState [" + this.sGB[0] + "," + this.sGB[1] + "," + this.sGB[2] + "," + this.sGB[3] + "]");
      AppMethodBeat.o(328809);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.c.j
 * JD-Core Version:    0.7.0.1
 */