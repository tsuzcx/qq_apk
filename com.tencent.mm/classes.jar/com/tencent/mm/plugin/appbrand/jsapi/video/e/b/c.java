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
import com.google.android.exoplayer2.h.k;
import com.google.android.exoplayer2.h.s.c;
import com.google.android.exoplayer2.h.s.e;
import com.google.android.exoplayer2.h.t.f;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.e.a;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.r;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.source.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class c
  extends com.tencent.mm.plugin.appbrand.jsapi.video.e.a
{
  Context IR;
  protected int bDT;
  protected float bDX;
  private final AtomicBoolean jLd;
  volatile boolean lpV;
  com.google.android.exoplayer2.f lqP;
  private boolean lqQ;
  private e lqR;
  private i lqS;
  private List<r> lqT;
  private f.a lqU;
  private b lqV;
  private f lqW;
  int lqX;
  private boolean lqY;
  private boolean lqZ;
  protected int lra;
  protected int lrb;
  protected int lrc;
  protected int lrd;
  protected int lre;
  protected int lrf;
  private HandlerThread mHandlerThread;
  private Handler mMainHandler;
  private Surface mSurface;
  int mVideoHeight;
  int mVideoWidth;
  
  public c()
  {
    this(null);
  }
  
  public c(int paramInt1, float paramFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this(null, paramInt1, paramFloat, paramInt2, paramInt3, paramInt4, paramInt5, 2500);
  }
  
  public c(Handler paramHandler)
  {
    this(paramHandler, 0, 0.75F, 10000, 25000, 15000, 30000, 2500);
  }
  
  public c(Handler paramHandler, int paramInt1, float paramFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this(paramHandler, paramInt1, paramFloat, paramInt2, paramInt3, paramInt4, paramInt5, 2500);
  }
  
  private c(Handler paramHandler, int paramInt1, float paramFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(206304);
    this.jLd = new AtomicBoolean();
    this.bDT = 0;
    this.bDX = 0.75F;
    this.lra = 10000;
    this.lrb = 25000;
    this.lrc = 15000;
    this.lrd = 30000;
    this.lre = 2500;
    this.lrf = 5000;
    ad.i("MicroMsg.SameLayer.ExoMediaPlayer", "ExoMediaPlayer, handler = %s, maxInitBitrate = %s, bandFraction = %s, minDur = %s, maxDur = %s, minBuffer = %s, maxBuffer = %s, bufferForPlaybackMs:%s, bufferForPlaybackAfterRebufferMs:%s", new Object[] { paramHandler, Integer.valueOf(paramInt1), Float.valueOf(paramFloat), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(5000) });
    this.bDT = 0;
    this.bDX = paramFloat;
    this.lra = paramInt2;
    this.lrb = paramInt3;
    this.lrc = paramInt4;
    this.lrd = paramInt5;
    this.lre = paramInt6;
    this.lrf = 5000;
    c(paramHandler);
    AppMethodBeat.o(206304);
  }
  
  public c(Handler paramHandler, int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramHandler, 0, 0.75F, 10000, 25000, paramInt1, paramInt2, paramInt3);
  }
  
  private com.google.android.exoplayer2.h.g.a L(Map<String, String> paramMap)
  {
    AppMethodBeat.i(206313);
    if ((paramMap == null) && (!com.tencent.mm.plugin.appbrand.jsapi.video.j.bnr().llS))
    {
      com.google.android.exoplayer2.h.g.a locala = null;
      if (com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.video.g.class) != null) {
        locala = ((com.tencent.mm.plugin.appbrand.jsapi.video.g)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.video.g.class)).bne();
      }
      if (locala != null)
      {
        ad.i("MicroMsg.SameLayer.ExoMediaPlayer", "getDataSourceFactory, return customized data source factory");
        AppMethodBeat.o(206313);
        return locala;
      }
    }
    ad.i("MicroMsg.SameLayer.ExoMediaPlayer", "getDataSourceFactory, return default data source factory");
    paramMap = d.a(this.IR, paramMap);
    AppMethodBeat.o(206313);
    return paramMap;
  }
  
  private void a(int paramInt1, int paramInt2, Object paramObject, boolean paramBoolean)
  {
    AppMethodBeat.i(206332);
    if (this.lqT.isEmpty())
    {
      AppMethodBeat.o(206332);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.lqT.iterator();
    while (localIterator.hasNext())
    {
      r localr = (r)localIterator.next();
      if (localr.getTrackType() == paramInt1) {
        localArrayList.add(new f.c(localr, paramInt2, paramObject));
      }
    }
    if (paramBoolean)
    {
      this.lqP.b((f.c[])localArrayList.toArray(new f.c[localArrayList.size()]));
      AppMethodBeat.o(206332);
      return;
    }
    this.lqP.a((f.c[])localArrayList.toArray(new f.c[localArrayList.size()]));
    AppMethodBeat.o(206332);
  }
  
  private i b(Uri paramUri, String paramString)
  {
    AppMethodBeat.i(206310);
    int i = q(paramUri);
    paramString = com.tencent.mm.plugin.appbrand.jsapi.s.d.Qv(paramString);
    switch (i)
    {
    default: 
      ad.e("MicroMsg.SameLayer.ExoMediaPlayer", "buildMediaSource, unsupported type:" + i + ", url:" + paramUri);
      AppMethodBeat.o(206310);
      return null;
    case 2: 
      ad.i("MicroMsg.SameLayer.ExoMediaPlayer", "buildMediaSource, type:HLS, url:%s", new Object[] { paramUri });
      paramUri = new com.google.android.exoplayer2.source.b.h(paramUri, d.a(this.IR, paramString), this.mMainHandler, this.lqV);
      AppMethodBeat.o(206310);
      return paramUri;
    }
    ad.i("MicroMsg.SameLayer.ExoMediaPlayer", "buildMediaSource, type:other, url:%s", new Object[] { paramUri });
    paramUri = new com.google.android.exoplayer2.source.g(paramUri, L(paramString), bos(), this.mMainHandler, this.lqV);
    AppMethodBeat.o(206310);
    return paramUri;
  }
  
  private void boo()
  {
    AppMethodBeat.i(206306);
    ad.i("MicroMsg.SameLayer.ExoMediaPlayer", "iniMediaPlayer");
    com.google.android.exoplayer2.g.c localc = new com.google.android.exoplayer2.g.c(new com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c.b(d.bov(), this.bDT, this.lra, this.lrb, this.bDX));
    com.google.android.exoplayer2.c localc1 = new com.google.android.exoplayer2.c(new k(), this.lrc, this.lrd, this.lre, this.lrf);
    this.lqP = com.google.android.exoplayer2.g.a((r[])this.lqT.toArray(new r[this.lqT.size()]), localc, localc1);
    this.lqP.a(this.lqU);
    AppMethodBeat.o(206306);
  }
  
  private void c(Handler paramHandler)
  {
    AppMethodBeat.i(206305);
    this.IR = aj.getContext();
    this.lqR = new e((byte)0);
    if (paramHandler != null) {}
    for (this.mMainHandler = paramHandler;; this.mMainHandler = new Handler(this.mHandlerThread.getLooper()))
    {
      this.lqU = new c((byte)0);
      this.lqV = new b((byte)0);
      this.lqW = new f(this.mMainHandler);
      this.lqW.lrl = 1000;
      this.lqW.lrn = new a((byte)0);
      d locald = new d((byte)0);
      this.lqT = new a(this.IR, this.mMainHandler, locald, locald, locald, locald).bon();
      if ((paramHandler == null) || (paramHandler.getLooper() != Looper.myLooper())) {
        break;
      }
      boo();
      AppMethodBeat.o(206305);
      return;
      this.mHandlerThread = com.tencent.e.c.d.gX("ExoMediaPlayer_HandlerThread", 5);
      this.mHandlerThread.start();
    }
    this.mMainHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(206269);
        synchronized (c.this)
        {
          c.a(c.this);
          c.this.notifyAll();
          AppMethodBeat.o(206269);
          return;
        }
      }
    });
    try
    {
      for (;;)
      {
        paramHandler = this.lqP;
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
      AppMethodBeat.o(206305);
    }
    AppMethodBeat.o(206305);
  }
  
  private void cz(Object paramObject)
  {
    AppMethodBeat.i(206331);
    a(1, 2, paramObject, false);
    AppMethodBeat.o(206331);
  }
  
  private void gT(boolean paramBoolean)
  {
    AppMethodBeat.i(206329);
    ad.d("MicroMsg.SameLayer.ExoMediaPlayer", "setBufferRepeaterStarted ".concat(String.valueOf(paramBoolean)));
    if ((paramBoolean) && (this.lqb != null))
    {
      this.lqW.start();
      AppMethodBeat.o(206329);
      return;
    }
    this.lqW.lrk = false;
    AppMethodBeat.o(206329);
  }
  
  private static int q(Uri paramUri)
  {
    AppMethodBeat.i(206311);
    if ((paramUri != null) && (com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.QY(paramUri.toString())))
    {
      AppMethodBeat.o(206311);
      return 2;
    }
    AppMethodBeat.o(206311);
    return 3;
  }
  
  public final boolean aF(float paramFloat)
  {
    AppMethodBeat.i(206315);
    if (available())
    {
      p localp = new p(paramFloat, 1.0F);
      this.lqP.a(localp);
      AppMethodBeat.o(206315);
      return true;
    }
    AppMethodBeat.o(206315);
    return false;
  }
  
  final boolean available()
  {
    return this.lqP != null;
  }
  
  public final int bop()
  {
    return this.lrc;
  }
  
  public final int boq()
  {
    return this.lrd;
  }
  
  public final int bor()
  {
    return this.lre;
  }
  
  protected com.google.android.exoplayer2.c.h bos()
  {
    AppMethodBeat.i(206312);
    b localb = new b();
    AppMethodBeat.o(206312);
    return localb;
  }
  
  final void bot()
  {
    for (;;)
    {
      int j;
      try
      {
        AppMethodBeat.i(206330);
        if ((this.lqP == null) || (this.lpV))
        {
          AppMethodBeat.o(206330);
          return;
        }
        int i = this.lqP.td();
        boolean bool = this.lqP.te();
        j = e.r(bool, i);
        if (j == this.lqR.lri[3]) {
          break label478;
        }
        ad.i("MicroMsg.SameLayer.ExoMediaPlayer", "reportPlayerState, set new recent state [" + bool + "," + i + "]");
        this.lqR.q(bool, i);
        if (j == 3)
        {
          gT(true);
          if (j != e.r(true, 4)) {
            break label214;
          }
          if (!this.lqY) {
            break label195;
          }
          ad.i("MicroMsg.SameLayer.ExoMediaPlayer", "looping play start");
          this.lqZ = true;
          seekTo(0L);
          AppMethodBeat.o(206330);
          continue;
        }
        if (j == 1) {
          break label187;
        }
      }
      finally {}
      if (j == 4)
      {
        label187:
        gT(false);
        continue;
        label195:
        this.lpU = 6;
        bol();
        AppMethodBeat.o(206330);
        continue;
        label214:
        if (this.lqR.a(new int[] { e.r(false, 1), e.r(false, 2), e.r(false, 3) }, false))
        {
          this.lpU = 2;
          bok();
          AppMethodBeat.o(206330);
        }
        else if ((this.lqR.a(new int[] { 100, 2, 3 }, true) | this.lqR.a(new int[] { 2, 100, 3 }, true) | this.lqR.a(new int[] { 100, 3, 2, 3 }, true)))
        {
          if (!this.lqZ)
          {
            bom();
            AppMethodBeat.o(206330);
          }
          else
          {
            this.lqZ = false;
            AppMethodBeat.o(206330);
          }
        }
        else if (this.lqR.a(new int[] { e.r(true, 3), e.r(true, 2) }, false))
        {
          dY(701, getBufferedPercentage());
          AppMethodBeat.o(206330);
        }
        else
        {
          if (this.lqR.a(new int[] { e.r(true, 2), e.r(true, 3) }, false)) {
            dY(702, getBufferedPercentage());
          }
          label478:
          AppMethodBeat.o(206330);
        }
      }
    }
  }
  
  public final void dD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(206309);
    this.lqS = b(Uri.parse(paramString1), paramString2);
    this.lpU = 1;
    AppMethodBeat.o(206309);
  }
  
  final int getBufferedPercentage()
  {
    AppMethodBeat.i(206328);
    if (available())
    {
      int i = this.lqP.getBufferedPercentage();
      AppMethodBeat.o(206328);
      return i;
    }
    AppMethodBeat.o(206328);
    return 0;
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(206319);
    if (available())
    {
      int i = (int)this.lqP.getCurrentPosition();
      AppMethodBeat.o(206319);
      return i;
    }
    AppMethodBeat.o(206319);
    return 0;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(206318);
    if (available())
    {
      int i = (int)this.lqP.getDuration();
      AppMethodBeat.o(206318);
      return i;
    }
    AppMethodBeat.o(206318);
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
    AppMethodBeat.i(206307);
    if (available())
    {
      switch (this.lqP.td())
      {
      }
      do
      {
        AppMethodBeat.o(206307);
        return false;
        boolean bool = this.lqP.te();
        AppMethodBeat.o(206307);
        return bool;
      } while (!this.lqY);
      AppMethodBeat.o(206307);
      return true;
    }
    AppMethodBeat.o(206307);
    return false;
  }
  
  public final void k(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(206324);
    if (available())
    {
      this.lqP.seekTo(paramLong);
      this.lqR.q(paramBoolean, 100);
    }
    AppMethodBeat.o(206324);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(206322);
    if (available())
    {
      this.lqP.aP(false);
      this.lpU = 3;
    }
    AppMethodBeat.o(206322);
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(206320);
    if (this.lqS == null)
    {
      ad.w("MicroMsg.SameLayer.ExoMediaPlayer", "prepareAsync, media source is null");
      AppMethodBeat.o(206320);
      return;
    }
    if (available())
    {
      this.lqP.aP(false);
      this.lqP.a(this.lqS);
    }
    AppMethodBeat.o(206320);
  }
  
  public final void release()
  {
    AppMethodBeat.i(206327);
    this.lpV = true;
    if (available())
    {
      gT(false);
      if (available())
      {
        this.lqP.release();
        this.lqP.b(this.lqU);
        this.lqP = null;
      }
      this.mVideoWidth = 0;
      this.mVideoHeight = 0;
      this.lqX = 0;
    }
    if (this.mHandlerThread != null)
    {
      this.mHandlerThread.quit();
      this.mHandlerThread = null;
    }
    if (this.mSurface != null)
    {
      if (this.lqQ) {
        this.mSurface.release();
      }
      this.mSurface = null;
    }
    this.lpW = null;
    this.lpX = null;
    this.lpY = null;
    this.lpZ = null;
    this.lqa = null;
    this.lqb = null;
    this.lqc = null;
    this.lpU = -2;
    super.release();
    AppMethodBeat.o(206327);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(206326);
    if (available())
    {
      gT(false);
      if (available())
      {
        this.lqP.aP(false);
        this.lqP.stop();
      }
      this.lqY = false;
      this.lqX = 0;
      this.lqR.lri = new int[] { 1, 1, 1, 1 };
      this.lpU = 0;
    }
    AppMethodBeat.o(206326);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(206323);
    e locale;
    if (available())
    {
      this.lqP.seekTo(paramLong);
      locale = this.lqR;
      if ((this.lqR.lri[3] & 0xF0000000) == 0) {
        break label62;
      }
    }
    label62:
    for (boolean bool = true;; bool = false)
    {
      locale.q(bool, 100);
      AppMethodBeat.o(206323);
      return;
    }
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(206308);
    dD(paramString, null);
    AppMethodBeat.o(206308);
  }
  
  public final void setLooping(boolean paramBoolean)
  {
    this.lqY = paramBoolean;
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(206316);
    if (available())
    {
      if (paramBoolean)
      {
        setVolume(0.0F, 0.0F);
        AppMethodBeat.o(206316);
        return;
      }
      setVolume(1.0F, 1.0F);
    }
    AppMethodBeat.o(206316);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(206314);
    if ((available()) && (available()))
    {
      if ((this.mSurface == null) || (this.mSurface == paramSurface) || (paramSurface == null)) {
        break label116;
      }
      if (this.lqQ) {
        this.mSurface.release();
      }
      a(2, 1, paramSurface, true);
      final long l = this.lqP.getCurrentPosition();
      if (x.SDK_INT < 23) {
        this.mMainHandler.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(206270);
            if (c.this.available()) {
              c.this.lqP.seekTo(l);
            }
            AppMethodBeat.o(206270);
          }
        }, 200L);
      }
    }
    for (;;)
    {
      this.mSurface = paramSurface;
      this.lqQ = false;
      AppMethodBeat.o(206314);
      return;
      label116:
      a(2, 1, paramSurface, false);
    }
  }
  
  public final void setVolume(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(206317);
    cz(Float.valueOf(paramFloat1));
    AppMethodBeat.o(206317);
  }
  
  public final void start()
  {
    AppMethodBeat.i(206321);
    if (available())
    {
      if (this.lqP.td() == 4) {
        this.lqP.seekTo(0L);
      }
      this.lqP.aP(true);
      this.lpU = 3;
      this.jLd.set(false);
    }
    AppMethodBeat.o(206321);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(206325);
    if ((available()) && (!this.jLd.getAndSet(true)))
    {
      this.lqP.aP(false);
      this.lqP.stop();
      this.lpU = 5;
    }
    AppMethodBeat.o(206325);
  }
  
  final class a
    implements f.b
  {
    private a() {}
    
    public final void agl()
    {
      AppMethodBeat.i(206271);
      for (;;)
      {
        synchronized (c.this)
        {
          if (c.this.lpV)
          {
            AppMethodBeat.o(206271);
            return;
          }
          if (c.this.available()) {}
          switch (c.this.lqP.td())
          {
          case 1: 
            AppMethodBeat.o(206271);
            return;
          case 4: 
            c.a(c.this, false);
          }
        }
        int i = c.this.getBufferedPercentage();
        if (i != c.this.lqX)
        {
          c.this.tC(i);
          c.this.lqX = i;
        }
      }
    }
  }
  
  final class b
    implements com.google.android.exoplayer2.source.a, com.google.android.exoplayer2.source.g.a
  {
    private b() {}
    
    public final void a(int paramInt, Format paramFormat, long paramLong)
    {
      AppMethodBeat.i(206276);
      ad.i("MicroMsg.SameLayer.ExoMediaPlayer", "[TRACE_ADAPTIVE] onDownstreamFormatChanged, trackType:%s, trackFormat:%s, mediaTimeMs:%s", new Object[] { Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong) });
      c.this.Rf(paramFormat.id);
      AppMethodBeat.o(206276);
    }
    
    public final void a(com.google.android.exoplayer2.h.j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(206272);
      ad.d("MicroMsg.SameLayer.ExoMediaPlayer", "onLoadStarted, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s", new Object[] { paramj, Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
      AppMethodBeat.o(206272);
    }
    
    public final void a(com.google.android.exoplayer2.h.j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, IOException paramIOException, boolean paramBoolean)
    {
      AppMethodBeat.i(206275);
      ad.printErrStackTrace("MicroMsg.SameLayer.ExoMediaPlayer", paramIOException, "onLoadError1, IOException, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s, loadDurationMs:%s, bytesLoaded:%s, wasCanceled:%s", new Object[] { paramj, Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(paramLong4), Long.valueOf(paramLong5), Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(206275);
    }
    
    public final void b(com.google.android.exoplayer2.h.j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(206273);
      ad.d("MicroMsg.SameLayer.ExoMediaPlayer", "onLoadCompleted, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s", new Object[] { paramj, Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
      AppMethodBeat.o(206273);
    }
    
    public final void c(com.google.android.exoplayer2.h.j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(206274);
      ad.d("MicroMsg.SameLayer.ExoMediaPlayer", "onLoadCanceled, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s", new Object[] { paramj, Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
      AppMethodBeat.o(206274);
    }
    
    public final void onLoadError(IOException paramIOException)
    {
      AppMethodBeat.i(206278);
      ad.printErrStackTrace("MicroMsg.SameLayer.ExoMediaPlayer", paramIOException, "onLoadError2, IOException", new Object[0]);
      AppMethodBeat.o(206278);
    }
    
    public final void vf()
    {
      AppMethodBeat.i(206277);
      ad.d("MicroMsg.SameLayer.ExoMediaPlayer", "onHasEndTag");
      AppMethodBeat.o(206277);
    }
  }
  
  final class c
    implements f.a
  {
    private c() {}
    
    public final void a(com.google.android.exoplayer2.e parame)
    {
      int i = -4000;
      AppMethodBeat.i(206286);
      ad.printErrStackTrace("MicroMsg.SameLayer.ExoMediaPlayer", parame, "onPlayError, ExoPlaybackException", new Object[0]);
      if (c.this.available()) {
        c.a(c.this, false);
      }
      if (parame != null)
      {
        parame = parame.getCause();
        if (parame != null)
        {
          if ((parame instanceof s.c))
          {
            if (parame.toString().contains("Unable to connect"))
            {
              boolean bool = d.isNetworkAvailable(c.this.IR);
              ad.printErrStackTrace("MicroMsg.SameLayer.ExoMediaPlayer", parame, "ExoPlaybackException hasNetwork=".concat(String.valueOf(bool)), new Object[0]);
              if (!bool)
              {
                c.this.dX(-4000, -2);
                AppMethodBeat.o(206286);
                return;
              }
              c.this.dX(-4000, -3);
              AppMethodBeat.o(206286);
              return;
            }
            if (!(parame instanceof s.e)) {
              break label422;
            }
            parame = parame.toString();
            if (parame.contains("403"))
            {
              c.this.dX(-4000, -10);
              AppMethodBeat.o(206286);
              return;
            }
            if (parame.contains("404"))
            {
              c.this.dX(-4000, -11);
              AppMethodBeat.o(206286);
              return;
            }
            if (parame.contains("500"))
            {
              c.this.dX(-4000, -12);
              AppMethodBeat.o(206286);
              return;
            }
            if (parame.contains("502"))
            {
              c.this.dX(-4000, -13);
              AppMethodBeat.o(206286);
              return;
            }
            c.this.dX(-4000, -30);
            AppMethodBeat.o(206286);
            return;
          }
          if ((parame instanceof q))
          {
            ad.e("MicroMsg.SameLayer.ExoMediaPlayer", d.bou());
            c.this.dX(-4001, -1);
            AppMethodBeat.o(206286);
            return;
          }
          if ((parame instanceof IllegalStateException))
          {
            ad.e("MicroMsg.SameLayer.ExoMediaPlayer", d.bou());
            c.this.dX(-4002, -1);
            AppMethodBeat.o(206286);
            return;
          }
          if ((parame instanceof b.a))
          {
            ad.e("MicroMsg.SameLayer.ExoMediaPlayer", d.bou());
            c.this.dX(-4003, -1);
            AppMethodBeat.o(206286);
            return;
          }
          if ((parame instanceof t.f))
          {
            ad.e("MicroMsg.SameLayer.ExoMediaPlayer", d.bou());
            c.this.dX(-4004, -1);
            AppMethodBeat.o(206286);
            return;
          }
        }
      }
      i = -4999;
      label422:
      ad.e("MicroMsg.SameLayer.ExoMediaPlayer", d.tE(30));
      c.this.dX(i, -1);
      AppMethodBeat.o(206286);
    }
    
    public final void aA(int paramInt)
    {
      AppMethodBeat.i(206283);
      ad.d("MicroMsg.SameLayer.ExoMediaPlayer", "onRepeatModeChanged, repeatMode=".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(206283);
    }
    
    public final void aS(boolean paramBoolean)
    {
      AppMethodBeat.i(206284);
      ad.d("MicroMsg.SameLayer.ExoMediaPlayer", "onLoadingChanged, isLoading=".concat(String.valueOf(paramBoolean)));
      if (paramBoolean) {
        c.a(c.this, true);
      }
      AppMethodBeat.o(206284);
    }
    
    public final void b(p paramp)
    {
      AppMethodBeat.i(206282);
      ad.d("MicroMsg.SameLayer.ExoMediaPlayer", "onPlaybackParametersChanged, params=[" + paramp.bdQ + ", " + paramp.pitch + "]");
      AppMethodBeat.o(206282);
    }
    
    public final void e(boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(206285);
      ad.i("MicroMsg.SameLayer.ExoMediaPlayer", "onPlayerStateChanged, playWhenReady=" + paramBoolean + ", playbackState=" + paramInt);
      c.this.bot();
      AppMethodBeat.o(206285);
    }
    
    public final void tt()
    {
      AppMethodBeat.i(206279);
      ad.d("MicroMsg.SameLayer.ExoMediaPlayer", "onTimelineChanged");
      AppMethodBeat.o(206279);
    }
    
    public final void tu()
    {
      AppMethodBeat.i(206281);
      ad.d("MicroMsg.SameLayer.ExoMediaPlayer", "onTracksChanged");
      AppMethodBeat.o(206281);
    }
    
    public final void tv()
    {
      AppMethodBeat.i(206280);
      ad.d("MicroMsg.SameLayer.ExoMediaPlayer", "onPositionDiscontinuity");
      AppMethodBeat.o(206280);
    }
  }
  
  final class d
    implements com.google.android.exoplayer2.a.e, j.a, e.a, com.google.android.exoplayer2.video.e
  {
    private d() {}
    
    public final void a(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
    {
      AppMethodBeat.i(206301);
      ad.i("MicroMsg.SameLayer.ExoMediaPlayer", "onVideoSizeChanged, width:%d, height:%d, rotationDegrees:%d, ratio:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Float.valueOf(paramFloat) });
      c.this.mVideoWidth = paramInt1;
      c.this.mVideoHeight = paramInt2;
      c.this.dW(paramInt1, paramInt2);
      AppMethodBeat.o(206301);
    }
    
    public final void a(com.google.android.exoplayer2.b.d paramd)
    {
      AppMethodBeat.i(206295);
      ad.d("MicroMsg.SameLayer.ExoMediaPlayer", "onVideoEnabled");
      AppMethodBeat.o(206295);
    }
    
    public final void b(com.google.android.exoplayer2.b.d paramd)
    {
      AppMethodBeat.i(206296);
      ad.d("MicroMsg.SameLayer.ExoMediaPlayer", "onVideoDisabled");
      AppMethodBeat.o(206296);
    }
    
    public final void b(Metadata paramMetadata)
    {
      AppMethodBeat.i(206293);
      ad.d("MicroMsg.SameLayer.ExoMediaPlayer", "onMetadata");
      AppMethodBeat.o(206293);
    }
    
    public final void b(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(206297);
      ad.d("MicroMsg.SameLayer.ExoMediaPlayer", "onVideoDecoderInitialized");
      AppMethodBeat.o(206297);
    }
    
    public final void c(int paramInt, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(206291);
      ad.d("MicroMsg.SameLayer.ExoMediaPlayer", "onAudioTrackUnderrun");
      AppMethodBeat.o(206291);
    }
    
    public final void c(Surface paramSurface)
    {
      AppMethodBeat.i(206300);
      ad.i("MicroMsg.SameLayer.ExoMediaPlayer", "onRenderedFirstFrame");
      c.this.dY(3, 0);
      AppMethodBeat.o(206300);
    }
    
    public final void c(Format paramFormat)
    {
      AppMethodBeat.i(206298);
      ad.d("MicroMsg.SameLayer.ExoMediaPlayer", "onVideoInputFormatChanged");
      AppMethodBeat.o(206298);
    }
    
    public final void c(com.google.android.exoplayer2.b.d paramd)
    {
      AppMethodBeat.i(206287);
      ad.d("MicroMsg.SameLayer.ExoMediaPlayer", "onAudioEnabled");
      AppMethodBeat.o(206287);
    }
    
    public final void c(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(206289);
      ad.d("MicroMsg.SameLayer.ExoMediaPlayer", "onAudioDecoderInitialized");
      AppMethodBeat.o(206289);
    }
    
    public final void d(Format paramFormat)
    {
      AppMethodBeat.i(206290);
      ad.d("MicroMsg.SameLayer.ExoMediaPlayer", "onAudioInputFormatChanged");
      AppMethodBeat.o(206290);
    }
    
    public final void d(com.google.android.exoplayer2.b.d paramd)
    {
      AppMethodBeat.i(206292);
      ad.d("MicroMsg.SameLayer.ExoMediaPlayer", "onAudioDisabled");
      AppMethodBeat.o(206292);
    }
    
    public final void dL(int paramInt)
    {
      AppMethodBeat.i(206288);
      ad.d("MicroMsg.SameLayer.ExoMediaPlayer", "onAudioSessionId");
      AppMethodBeat.o(206288);
    }
    
    public final void h(int paramInt, long paramLong)
    {
      AppMethodBeat.i(206299);
      ad.d("MicroMsg.SameLayer.ExoMediaPlayer", "onDroppedFrames");
      AppMethodBeat.o(206299);
    }
    
    public final void s(List<com.google.android.exoplayer2.f.a> paramList)
    {
      AppMethodBeat.i(206294);
      ad.d("MicroMsg.SameLayer.ExoMediaPlayer", "onCues");
      AppMethodBeat.o(206294);
    }
  }
  
  static final class e
  {
    int[] lri;
    
    private e()
    {
      AppMethodBeat.i(206302);
      this.lri = new int[] { 1, 1, 1, 1 };
      AppMethodBeat.o(206302);
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
        int k = this.lri.length - paramArrayOfInt.length;
        j = k;
        paramBoolean = true;
        label23:
        if (j >= this.lri.length) {
          return paramBoolean;
        }
        if ((this.lri[j] & i) != (paramArrayOfInt[(j - k)] & i)) {
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
      AppMethodBeat.i(206303);
      int i = r(paramBoolean, paramInt);
      ad.i("MicroMsg.SameLayer.ExoMediaPlayer", "request setMostRecentState [" + paramBoolean + "," + paramInt + "], lastState=" + this.lri[3] + ", newState=" + i);
      if (this.lri[3] == i)
      {
        AppMethodBeat.o(206303);
        return;
      }
      this.lri[0] = this.lri[1];
      this.lri[1] = this.lri[2];
      this.lri[2] = this.lri[3];
      this.lri[3] = i;
      ad.i("MicroMsg.SameLayer.ExoMediaPlayer", "new MostRecentState [" + this.lri[0] + "," + this.lri[1] + "," + this.lri[2] + "," + this.lri[3] + "]");
      AppMethodBeat.o(206303);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c
 * JD-Core Version:    0.7.0.1
 */