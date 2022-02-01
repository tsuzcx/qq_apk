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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
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
  private final AtomicBoolean jOp;
  volatile boolean lus;
  protected int lvA;
  protected int lvB;
  protected int lvC;
  protected int lvD;
  protected int lvE;
  private int lvF;
  com.google.android.exoplayer2.f lvn;
  private boolean lvo;
  private e lvp;
  private i lvq;
  private List<r> lvr;
  private f.a lvs;
  private b lvt;
  private f lvu;
  int lvv;
  private boolean lvw;
  private boolean lvx;
  private final AtomicBoolean lvy;
  protected int lvz;
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
    AppMethodBeat.i(211332);
    this.jOp = new AtomicBoolean();
    this.lvy = new AtomicBoolean(false);
    this.bDT = 0;
    this.bDX = 0.75F;
    this.lvz = 10000;
    this.lvA = 25000;
    this.lvB = 15000;
    this.lvC = 30000;
    this.lvD = 2500;
    this.lvE = 5000;
    this.lvF = 0;
    ae.i("MicroMsg.SameLayer.ExoMediaPlayer", "ExoMediaPlayer, handler = %s, maxInitBitrate = %s, bandFraction = %s, minDur = %s, maxDur = %s, minBuffer = %s, maxBuffer = %s, bufferForPlaybackMs:%s, bufferForPlaybackAfterRebufferMs:%s", new Object[] { paramHandler, Integer.valueOf(paramInt1), Float.valueOf(paramFloat), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(5000) });
    this.bDT = 0;
    this.bDX = paramFloat;
    this.lvz = paramInt2;
    this.lvA = paramInt3;
    this.lvB = paramInt4;
    this.lvC = paramInt5;
    this.lvD = paramInt6;
    this.lvE = 5000;
    c(paramHandler);
    AppMethodBeat.o(211332);
  }
  
  public c(Handler paramHandler, int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramHandler, 0, 0.75F, 10000, 25000, paramInt1, paramInt2, paramInt3);
  }
  
  private com.google.android.exoplayer2.h.g.a S(Map<String, String> paramMap)
  {
    AppMethodBeat.i(211341);
    if ((paramMap == null) && (!com.tencent.mm.plugin.appbrand.jsapi.video.j.bob().lqs))
    {
      com.google.android.exoplayer2.h.g.a locala = null;
      if (com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.video.g.class) != null) {
        locala = ((com.tencent.mm.plugin.appbrand.jsapi.video.g)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.video.g.class)).bnO();
      }
      if (locala != null)
      {
        ae.i("MicroMsg.SameLayer.ExoMediaPlayer", "getDataSourceFactory, return customized data source factory");
        AppMethodBeat.o(211341);
        return locala;
      }
    }
    ae.i("MicroMsg.SameLayer.ExoMediaPlayer", "getDataSourceFactory, return default data source factory");
    paramMap = d.a(this.IR, paramMap);
    AppMethodBeat.o(211341);
    return paramMap;
  }
  
  private void a(int paramInt1, int paramInt2, Object paramObject, boolean paramBoolean)
  {
    AppMethodBeat.i(211361);
    if (this.lvr.isEmpty())
    {
      AppMethodBeat.o(211361);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.lvr.iterator();
    while (localIterator.hasNext())
    {
      r localr = (r)localIterator.next();
      if (localr.getTrackType() == paramInt1) {
        localArrayList.add(new f.c(localr, paramInt2, paramObject));
      }
    }
    if (paramBoolean)
    {
      this.lvn.b((f.c[])localArrayList.toArray(new f.c[localArrayList.size()]));
      AppMethodBeat.o(211361);
      return;
    }
    this.lvn.a((f.c[])localArrayList.toArray(new f.c[localArrayList.size()]));
    AppMethodBeat.o(211361);
  }
  
  private i b(Uri paramUri, String paramString)
  {
    AppMethodBeat.i(211338);
    int i = q(paramUri);
    paramString = com.tencent.mm.plugin.appbrand.jsapi.s.d.Re(paramString);
    switch (i)
    {
    default: 
      ae.e("MicroMsg.SameLayer.ExoMediaPlayer", "buildMediaSource, unsupported type:" + i + ", url:" + paramUri);
      AppMethodBeat.o(211338);
      return null;
    case 2: 
      ae.i("MicroMsg.SameLayer.ExoMediaPlayer", "buildMediaSource, type:HLS, url:%s", new Object[] { paramUri });
      paramUri = new com.google.android.exoplayer2.source.b.h(paramUri, d.a(this.IR, paramString), this.mMainHandler, this.lvt);
      AppMethodBeat.o(211338);
      return paramUri;
    }
    ae.i("MicroMsg.SameLayer.ExoMediaPlayer", "buildMediaSource, type:other, url:%s", new Object[] { paramUri });
    paramUri = new com.google.android.exoplayer2.source.g(paramUri, S(paramString), bpc(), this.mMainHandler, this.lvt);
    AppMethodBeat.o(211338);
    return paramUri;
  }
  
  private void boY()
  {
    AppMethodBeat.i(211334);
    ae.i("MicroMsg.SameLayer.ExoMediaPlayer", "iniMediaPlayer");
    com.google.android.exoplayer2.g.c localc = new com.google.android.exoplayer2.g.c(new com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c.b(d.bpf(), this.bDT, this.lvz, this.lvA, this.bDX));
    com.google.android.exoplayer2.c localc1 = new com.google.android.exoplayer2.c(new k(), this.lvB, this.lvC, this.lvD, this.lvE);
    this.lvn = com.google.android.exoplayer2.g.a((r[])this.lvr.toArray(new r[this.lvr.size()]), localc, localc1);
    this.lvn.a(this.lvs);
    AppMethodBeat.o(211334);
  }
  
  private void c(Handler paramHandler)
  {
    AppMethodBeat.i(211333);
    this.IR = ak.getContext();
    this.lvp = new e((byte)0);
    if (paramHandler != null) {}
    for (this.mMainHandler = paramHandler;; this.mMainHandler = new Handler(this.mHandlerThread.getLooper()))
    {
      this.lvs = new c((byte)0);
      this.lvt = new b((byte)0);
      this.lvu = new f(this.mMainHandler);
      this.lvu.lvL = 1000;
      this.lvu.lvN = new a((byte)0);
      d locald = new d((byte)0);
      this.lvr = new a(this.IR, this.mMainHandler, locald, locald, locald, locald).boX();
      if ((paramHandler == null) || (paramHandler.getLooper() != Looper.myLooper())) {
        break;
      }
      boY();
      AppMethodBeat.o(211333);
      return;
      this.mHandlerThread = com.tencent.e.c.d.hg("ExoMediaPlayer_HandlerThread", 5);
      this.mHandlerThread.start();
    }
    this.mMainHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(211297);
        synchronized (c.this)
        {
          c.a(c.this);
          c.this.notifyAll();
          AppMethodBeat.o(211297);
          return;
        }
      }
    });
    try
    {
      for (;;)
      {
        paramHandler = this.lvn;
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
      AppMethodBeat.o(211333);
    }
    AppMethodBeat.o(211333);
  }
  
  private void cA(Object paramObject)
  {
    AppMethodBeat.i(211360);
    a(1, 2, paramObject, false);
    AppMethodBeat.o(211360);
  }
  
  private void gT(boolean paramBoolean)
  {
    AppMethodBeat.i(211357);
    ae.d("MicroMsg.SameLayer.ExoMediaPlayer", "setBufferRepeaterStarted ".concat(String.valueOf(paramBoolean)));
    if ((paramBoolean) && (this.luz != null))
    {
      this.lvu.start();
      AppMethodBeat.o(211357);
      return;
    }
    this.lvu.lvK = false;
    AppMethodBeat.o(211357);
  }
  
  private static int q(Uri paramUri)
  {
    AppMethodBeat.i(211339);
    if ((paramUri != null) && (com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.RH(paramUri.toString())))
    {
      AppMethodBeat.o(211339);
      return 2;
    }
    AppMethodBeat.o(211339);
    return 3;
  }
  
  public final boolean aF(float paramFloat)
  {
    AppMethodBeat.i(211343);
    if (available())
    {
      p localp = new p(paramFloat, 1.0F);
      this.lvn.a(localp);
      AppMethodBeat.o(211343);
      return true;
    }
    AppMethodBeat.o(211343);
    return false;
  }
  
  final boolean available()
  {
    return this.lvn != null;
  }
  
  public final int boZ()
  {
    return this.lvB;
  }
  
  public final int bpa()
  {
    return this.lvC;
  }
  
  public final int bpb()
  {
    return this.lvD;
  }
  
  protected com.google.android.exoplayer2.c.h bpc()
  {
    AppMethodBeat.i(211340);
    b localb = new b();
    AppMethodBeat.o(211340);
    return localb;
  }
  
  final void bpd()
  {
    for (;;)
    {
      int j;
      try
      {
        AppMethodBeat.i(211359);
        if ((this.lvn == null) || (this.lus))
        {
          AppMethodBeat.o(211359);
          return;
        }
        int i = this.lvn.td();
        boolean bool = this.lvn.te();
        j = e.s(bool, i);
        if (j == this.lvp.lvI[3]) {
          break label537;
        }
        ae.i("MicroMsg.SameLayer.ExoMediaPlayer", "reportPlayerState, set new recent state [" + bool + "," + i + "]");
        this.lvp.r(bool, i);
        if (j == 3)
        {
          gT(true);
          if (j != e.s(true, 4)) {
            break label271;
          }
          ae.i("MicroMsg.SameLayer.ExoMediaPlayer", "reportPlayerState, isSeeking: %b, loopingPlaySeek: %b", new Object[] { Boolean.valueOf(this.lvy.get()), Boolean.valueOf(this.lvx) });
          if ((this.lvy.getAndSet(false)) && (!this.lvx)) {
            boW();
          }
          if (!this.lvw) {
            break label252;
          }
          ae.i("MicroMsg.SameLayer.ExoMediaPlayer", "looping play start");
          this.lvx = true;
          seekTo(0L);
          AppMethodBeat.o(211359);
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
        gT(false);
        continue;
        label252:
        this.lur = 6;
        boV();
        AppMethodBeat.o(211359);
        continue;
        label271:
        if (this.lvp.a(new int[] { e.s(false, 1), e.s(false, 2), e.s(false, 3) }, false))
        {
          this.lur = 2;
          boU();
          AppMethodBeat.o(211359);
        }
        else
        {
          if ((this.lvp.a(new int[] { 100, 2, 3 }, true) | this.lvp.a(new int[] { 2, 100, 3 }, true) | this.lvp.a(new int[] { 100, 3, 2, 3 }, true)))
          {
            if (!this.lvx) {
              boW();
            }
            for (;;)
            {
              this.lvy.set(false);
              AppMethodBeat.o(211359);
              break;
              this.lvx = false;
            }
          }
          if (this.lvp.a(new int[] { e.s(true, 3), e.s(true, 2) }, false))
          {
            dY(701, getBufferedPercentage());
            AppMethodBeat.o(211359);
          }
          else
          {
            if (this.lvp.a(new int[] { e.s(true, 2), e.s(true, 3) }, false)) {
              dY(702, getBufferedPercentage());
            }
            label537:
            AppMethodBeat.o(211359);
          }
        }
      }
    }
  }
  
  public final void dF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(211337);
    this.lvq = b(Uri.parse(paramString1), paramString2);
    this.lvF = 0;
    this.lur = 1;
    AppMethodBeat.o(211337);
  }
  
  public final boolean dX(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(211358);
    boolean bool = super.dX(paramInt1, paramInt2);
    this.lvF = 0;
    AppMethodBeat.o(211358);
    return bool;
  }
  
  final int getBufferedPercentage()
  {
    AppMethodBeat.i(211356);
    if (available())
    {
      int i = this.lvn.getBufferedPercentage();
      AppMethodBeat.o(211356);
      return i;
    }
    AppMethodBeat.o(211356);
    return 0;
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(211347);
    if (available())
    {
      int i = (int)this.lvn.getCurrentPosition();
      AppMethodBeat.o(211347);
      return i;
    }
    AppMethodBeat.o(211347);
    return 0;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(211346);
    if (available())
    {
      int i = (int)this.lvn.getDuration();
      AppMethodBeat.o(211346);
      return i;
    }
    AppMethodBeat.o(211346);
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
    AppMethodBeat.i(211335);
    if (available())
    {
      switch (this.lvn.td())
      {
      }
      do
      {
        AppMethodBeat.o(211335);
        return false;
        boolean bool = this.lvn.te();
        AppMethodBeat.o(211335);
        return bool;
      } while (!this.lvw);
      AppMethodBeat.o(211335);
      return true;
    }
    AppMethodBeat.o(211335);
    return false;
  }
  
  public final void k(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(211352);
    if (available())
    {
      this.lvn.seekTo(paramLong);
      this.lvp.r(paramBoolean, 100);
    }
    AppMethodBeat.o(211352);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(211350);
    if (available())
    {
      this.lvn.aP(false);
      this.lur = 3;
    }
    AppMethodBeat.o(211350);
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(211348);
    if (this.lvq == null)
    {
      ae.w("MicroMsg.SameLayer.ExoMediaPlayer", "prepareAsync, media source is null");
      AppMethodBeat.o(211348);
      return;
    }
    if (available())
    {
      this.lvn.aP(false);
      this.lvn.a(this.lvq);
    }
    AppMethodBeat.o(211348);
  }
  
  public final void release()
  {
    AppMethodBeat.i(211355);
    this.lus = true;
    if (available())
    {
      gT(false);
      if (available())
      {
        this.lvn.release();
        this.lvn.b(this.lvs);
        this.lvn = null;
      }
      this.mVideoWidth = 0;
      this.mVideoHeight = 0;
      this.lvv = 0;
    }
    if (this.mHandlerThread != null)
    {
      this.mHandlerThread.quit();
      this.mHandlerThread = null;
    }
    if (this.mSurface != null)
    {
      if (this.lvo) {
        this.mSurface.release();
      }
      this.mSurface = null;
    }
    this.lut = null;
    this.luu = null;
    this.luv = null;
    this.luw = null;
    this.luy = null;
    this.luz = null;
    this.luA = null;
    this.lur = -2;
    super.release();
    AppMethodBeat.o(211355);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(211354);
    if (available())
    {
      gT(false);
      if (available())
      {
        this.lvn.aP(false);
        this.lvn.stop();
      }
      this.lvw = false;
      this.lvv = 0;
      this.lvp.lvI = new int[] { 1, 1, 1, 1 };
      this.lur = 0;
    }
    AppMethodBeat.o(211354);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(211351);
    e locale;
    if (available())
    {
      this.lvn.seekTo(paramLong);
      locale = this.lvp;
      if ((this.lvp.lvI[3] & 0xF0000000) == 0) {
        break label70;
      }
    }
    label70:
    for (boolean bool = true;; bool = false)
    {
      locale.r(bool, 100);
      this.lvy.set(true);
      AppMethodBeat.o(211351);
      return;
    }
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(211336);
    dF(paramString, null);
    AppMethodBeat.o(211336);
  }
  
  public final void setLooping(boolean paramBoolean)
  {
    this.lvw = paramBoolean;
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(211344);
    if (available())
    {
      if (paramBoolean)
      {
        setVolume(0.0F, 0.0F);
        AppMethodBeat.o(211344);
        return;
      }
      setVolume(1.0F, 1.0F);
    }
    AppMethodBeat.o(211344);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(211342);
    if ((available()) && (available()))
    {
      if ((this.mSurface == null) || (this.mSurface == paramSurface) || (paramSurface == null)) {
        break label116;
      }
      if (this.lvo) {
        this.mSurface.release();
      }
      a(2, 1, paramSurface, true);
      final long l = this.lvn.getCurrentPosition();
      if (x.SDK_INT < 23) {
        this.mMainHandler.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(211298);
            if (c.this.available()) {
              c.this.lvn.seekTo(l);
            }
            AppMethodBeat.o(211298);
          }
        }, 200L);
      }
    }
    for (;;)
    {
      this.mSurface = paramSurface;
      this.lvo = false;
      AppMethodBeat.o(211342);
      return;
      label116:
      a(2, 1, paramSurface, false);
    }
  }
  
  public final void setVolume(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(211345);
    cA(Float.valueOf(paramFloat1));
    AppMethodBeat.o(211345);
  }
  
  public final void start()
  {
    AppMethodBeat.i(211349);
    if (available())
    {
      if (this.lvn.td() == 4) {
        this.lvn.seekTo(0L);
      }
      this.lvn.aP(true);
      this.lur = 3;
      this.jOp.set(false);
    }
    AppMethodBeat.o(211349);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(211353);
    if ((available()) && (!this.jOp.getAndSet(true)))
    {
      this.lvn.aP(false);
      this.lvn.stop();
      this.lur = 5;
    }
    AppMethodBeat.o(211353);
  }
  
  final class a
    implements f.b
  {
    private a() {}
    
    public final void agz()
    {
      AppMethodBeat.i(211299);
      for (;;)
      {
        synchronized (c.this)
        {
          if (c.this.lus)
          {
            AppMethodBeat.o(211299);
            return;
          }
          if (c.this.available()) {}
          switch (c.this.lvn.td())
          {
          case 1: 
            AppMethodBeat.o(211299);
            return;
          case 4: 
            c.a(c.this, false);
          }
        }
        int i = c.this.getBufferedPercentage();
        if (i != c.this.lvv)
        {
          c.this.tH(i);
          c.this.lvv = i;
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
      AppMethodBeat.i(211304);
      ae.i("MicroMsg.SameLayer.ExoMediaPlayer", "[TRACE_ADAPTIVE] onDownstreamFormatChanged, trackType:%s, trackFormat:%s, mediaTimeMs:%s", new Object[] { Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong) });
      c.this.RO(paramFormat.id);
      AppMethodBeat.o(211304);
    }
    
    public final void a(com.google.android.exoplayer2.h.j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(211300);
      ae.d("MicroMsg.SameLayer.ExoMediaPlayer", "onLoadStarted, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s", new Object[] { paramj, Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
      AppMethodBeat.o(211300);
    }
    
    public final void a(com.google.android.exoplayer2.h.j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, IOException paramIOException, boolean paramBoolean)
    {
      AppMethodBeat.i(211303);
      ae.printErrStackTrace("MicroMsg.SameLayer.ExoMediaPlayer", paramIOException, "onLoadError1, IOException, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s, loadDurationMs:%s, bytesLoaded:%s, wasCanceled:%s", new Object[] { paramj, Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(paramLong4), Long.valueOf(paramLong5), Boolean.valueOf(paramBoolean) });
      c.b(c.this);
      AppMethodBeat.o(211303);
    }
    
    public final void b(com.google.android.exoplayer2.h.j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(211301);
      ae.d("MicroMsg.SameLayer.ExoMediaPlayer", "onLoadCompleted, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s", new Object[] { paramj, Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
      AppMethodBeat.o(211301);
    }
    
    public final void c(com.google.android.exoplayer2.h.j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(211302);
      ae.d("MicroMsg.SameLayer.ExoMediaPlayer", "onLoadCanceled, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s", new Object[] { paramj, Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
      AppMethodBeat.o(211302);
    }
    
    public final void onLoadError(IOException paramIOException)
    {
      AppMethodBeat.i(211306);
      ae.printErrStackTrace("MicroMsg.SameLayer.ExoMediaPlayer", paramIOException, "onLoadError2, IOException", new Object[0]);
      c.b(c.this);
      AppMethodBeat.o(211306);
    }
    
    public final void vf()
    {
      AppMethodBeat.i(211305);
      ae.d("MicroMsg.SameLayer.ExoMediaPlayer", "onHasEndTag");
      AppMethodBeat.o(211305);
    }
  }
  
  final class c
    implements f.a
  {
    private c() {}
    
    public final void a(com.google.android.exoplayer2.e parame)
    {
      int i = -4000;
      AppMethodBeat.i(211314);
      ae.printErrStackTrace("MicroMsg.SameLayer.ExoMediaPlayer", parame, "onPlayError, ExoPlaybackException", new Object[0]);
      if (c.this.available()) {
        c.a(c.this, false);
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
              boolean bool = d.isNetworkAvailable(c.this.IR);
              ae.printErrStackTrace("MicroMsg.SameLayer.ExoMediaPlayer", localThrowable, "ExoPlaybackException hasNetwork=".concat(String.valueOf(bool)), new Object[0]);
              if (!bool)
              {
                c.this.dX(-4000, -2);
                AppMethodBeat.o(211314);
                return;
              }
              c.this.dX(-4000, -3);
              AppMethodBeat.o(211314);
              return;
            }
            if (!(localThrowable instanceof s.e)) {
              break label457;
            }
            parame = localThrowable.toString();
            if (parame.contains("403"))
            {
              c.this.dX(-4000, -10);
              AppMethodBeat.o(211314);
              return;
            }
            if (parame.contains("404"))
            {
              c.this.dX(-4000, -11);
              AppMethodBeat.o(211314);
              return;
            }
            if (parame.contains("500"))
            {
              c.this.dX(-4000, -12);
              AppMethodBeat.o(211314);
              return;
            }
            if (parame.contains("502"))
            {
              c.this.dX(-4000, -13);
              AppMethodBeat.o(211314);
              return;
            }
            c.this.dX(-4000, -30);
            AppMethodBeat.o(211314);
            return;
          }
          if ((localThrowable instanceof q))
          {
            ae.e("MicroMsg.SameLayer.ExoMediaPlayer", d.bpe());
            c.this.dX(-4001, -1);
            AppMethodBeat.o(211314);
            return;
          }
          if ((localThrowable instanceof IllegalStateException))
          {
            ae.e("MicroMsg.SameLayer.ExoMediaPlayer", d.bpe());
            c.this.dX(-4002, -1);
            AppMethodBeat.o(211314);
            return;
          }
          if ((localThrowable instanceof b.a))
          {
            ae.w("MicroMsg.SameLayer.ExoMediaPlayer", "onPlayError, error: " + d.V(parame));
            ae.e("MicroMsg.SameLayer.ExoMediaPlayer", d.bpe());
            c.this.dX(-4003, -1);
            AppMethodBeat.o(211314);
            return;
          }
          if ((localThrowable instanceof t.f))
          {
            ae.e("MicroMsg.SameLayer.ExoMediaPlayer", d.bpe());
            c.this.dX(-4004, -1);
            AppMethodBeat.o(211314);
            return;
          }
        }
      }
      i = -4999;
      label457:
      ae.e("MicroMsg.SameLayer.ExoMediaPlayer", d.tJ(30));
      c.this.dX(i, -1);
      AppMethodBeat.o(211314);
    }
    
    public final void aA(int paramInt)
    {
      AppMethodBeat.i(211311);
      ae.d("MicroMsg.SameLayer.ExoMediaPlayer", "onRepeatModeChanged, repeatMode=".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(211311);
    }
    
    public final void aS(boolean paramBoolean)
    {
      AppMethodBeat.i(211312);
      ae.d("MicroMsg.SameLayer.ExoMediaPlayer", "onLoadingChanged, isLoading=".concat(String.valueOf(paramBoolean)));
      if (paramBoolean) {
        c.a(c.this, true);
      }
      AppMethodBeat.o(211312);
    }
    
    public final void b(p paramp)
    {
      AppMethodBeat.i(211310);
      ae.d("MicroMsg.SameLayer.ExoMediaPlayer", "onPlaybackParametersChanged, params=[" + paramp.bdQ + ", " + paramp.pitch + "]");
      AppMethodBeat.o(211310);
    }
    
    public final void e(boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(211313);
      ae.i("MicroMsg.SameLayer.ExoMediaPlayer", "onPlayerStateChanged, playWhenReady=" + paramBoolean + ", playbackState=" + paramInt);
      c.this.bpd();
      AppMethodBeat.o(211313);
    }
    
    public final void tt()
    {
      AppMethodBeat.i(211307);
      ae.d("MicroMsg.SameLayer.ExoMediaPlayer", "onTimelineChanged");
      AppMethodBeat.o(211307);
    }
    
    public final void tu()
    {
      AppMethodBeat.i(211309);
      ae.d("MicroMsg.SameLayer.ExoMediaPlayer", "onTracksChanged");
      AppMethodBeat.o(211309);
    }
    
    public final void tv()
    {
      AppMethodBeat.i(211308);
      ae.d("MicroMsg.SameLayer.ExoMediaPlayer", "onPositionDiscontinuity");
      AppMethodBeat.o(211308);
    }
  }
  
  final class d
    implements com.google.android.exoplayer2.a.e, j.a, e.a, com.google.android.exoplayer2.video.e
  {
    private d() {}
    
    public final void a(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
    {
      AppMethodBeat.i(211329);
      ae.i("MicroMsg.SameLayer.ExoMediaPlayer", "onVideoSizeChanged, width:%d, height:%d, rotationDegrees:%d, ratio:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Float.valueOf(paramFloat) });
      c.this.mVideoWidth = paramInt1;
      c.this.mVideoHeight = paramInt2;
      c.this.dW(paramInt1, paramInt2);
      AppMethodBeat.o(211329);
    }
    
    public final void a(com.google.android.exoplayer2.b.d paramd)
    {
      AppMethodBeat.i(211323);
      ae.d("MicroMsg.SameLayer.ExoMediaPlayer", "onVideoEnabled");
      AppMethodBeat.o(211323);
    }
    
    public final void b(com.google.android.exoplayer2.b.d paramd)
    {
      AppMethodBeat.i(211324);
      ae.d("MicroMsg.SameLayer.ExoMediaPlayer", "onVideoDisabled");
      AppMethodBeat.o(211324);
    }
    
    public final void b(Metadata paramMetadata)
    {
      AppMethodBeat.i(211321);
      ae.d("MicroMsg.SameLayer.ExoMediaPlayer", "onMetadata");
      AppMethodBeat.o(211321);
    }
    
    public final void b(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(211325);
      ae.d("MicroMsg.SameLayer.ExoMediaPlayer", "onVideoDecoderInitialized");
      AppMethodBeat.o(211325);
    }
    
    public final void c(int paramInt, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(211319);
      ae.d("MicroMsg.SameLayer.ExoMediaPlayer", "onAudioTrackUnderrun");
      AppMethodBeat.o(211319);
    }
    
    public final void c(Surface paramSurface)
    {
      AppMethodBeat.i(211328);
      ae.i("MicroMsg.SameLayer.ExoMediaPlayer", "onRenderedFirstFrame");
      c.this.dY(3, 0);
      AppMethodBeat.o(211328);
    }
    
    public final void c(Format paramFormat)
    {
      AppMethodBeat.i(211326);
      ae.d("MicroMsg.SameLayer.ExoMediaPlayer", "onVideoInputFormatChanged");
      AppMethodBeat.o(211326);
    }
    
    public final void c(com.google.android.exoplayer2.b.d paramd)
    {
      AppMethodBeat.i(211315);
      ae.d("MicroMsg.SameLayer.ExoMediaPlayer", "onAudioEnabled");
      AppMethodBeat.o(211315);
    }
    
    public final void c(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(211317);
      ae.d("MicroMsg.SameLayer.ExoMediaPlayer", "onAudioDecoderInitialized");
      AppMethodBeat.o(211317);
    }
    
    public final void d(Format paramFormat)
    {
      AppMethodBeat.i(211318);
      ae.d("MicroMsg.SameLayer.ExoMediaPlayer", "onAudioInputFormatChanged");
      AppMethodBeat.o(211318);
    }
    
    public final void d(com.google.android.exoplayer2.b.d paramd)
    {
      AppMethodBeat.i(211320);
      ae.d("MicroMsg.SameLayer.ExoMediaPlayer", "onAudioDisabled");
      AppMethodBeat.o(211320);
    }
    
    public final void dL(int paramInt)
    {
      AppMethodBeat.i(211316);
      ae.d("MicroMsg.SameLayer.ExoMediaPlayer", "onAudioSessionId");
      AppMethodBeat.o(211316);
    }
    
    public final void h(int paramInt, long paramLong)
    {
      AppMethodBeat.i(211327);
      ae.d("MicroMsg.SameLayer.ExoMediaPlayer", "onDroppedFrames");
      AppMethodBeat.o(211327);
    }
    
    public final void s(List<com.google.android.exoplayer2.f.a> paramList)
    {
      AppMethodBeat.i(211322);
      ae.d("MicroMsg.SameLayer.ExoMediaPlayer", "onCues");
      AppMethodBeat.o(211322);
    }
  }
  
  static final class e
  {
    int[] lvI;
    
    private e()
    {
      AppMethodBeat.i(211330);
      this.lvI = new int[] { 1, 1, 1, 1 };
      AppMethodBeat.o(211330);
    }
    
    static int s(boolean paramBoolean, int paramInt)
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
        int k = this.lvI.length - paramArrayOfInt.length;
        j = k;
        paramBoolean = true;
        label23:
        if (j >= this.lvI.length) {
          return paramBoolean;
        }
        if ((this.lvI[j] & i) != (paramArrayOfInt[(j - k)] & i)) {
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
      AppMethodBeat.i(211331);
      int i = s(paramBoolean, paramInt);
      ae.i("MicroMsg.SameLayer.ExoMediaPlayer", "request setMostRecentState [" + paramBoolean + "," + paramInt + "], lastState=" + this.lvI[3] + ", newState=" + i);
      if (this.lvI[3] == i)
      {
        AppMethodBeat.o(211331);
        return;
      }
      this.lvI[0] = this.lvI[1];
      this.lvI[1] = this.lvI[2];
      this.lvI[2] = this.lvI[3];
      this.lvI[3] = i;
      ae.i("MicroMsg.SameLayer.ExoMediaPlayer", "new MostRecentState [" + this.lvI[0] + "," + this.lvI[1] + "," + this.lvI[2] + "," + this.lvI[3] + "]");
      AppMethodBeat.o(211331);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c
 * JD-Core Version:    0.7.0.1
 */