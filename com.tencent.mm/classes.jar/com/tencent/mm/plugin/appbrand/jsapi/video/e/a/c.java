package com.tencent.mm.plugin.appbrand.jsapi.video.e.a;

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
import com.google.android.exoplayer2.g.a.a;
import com.google.android.exoplayer2.h.g.a;
import com.google.android.exoplayer2.h.k;
import com.google.android.exoplayer2.h.s.c;
import com.google.android.exoplayer2.h.s.e;
import com.google.android.exoplayer2.h.t.f;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.e.a;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.source.h.a;
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
  Context FZ;
  protected int bvE;
  protected float bvI;
  private final AtomicBoolean iQZ;
  com.google.android.exoplayer2.f ksC;
  private boolean ksD;
  private e ksE;
  private com.google.android.exoplayer2.source.j ksF;
  private List<com.google.android.exoplayer2.r> ksG;
  private f.a ksH;
  private b ksI;
  private f ksJ;
  int ksK;
  private boolean ksL;
  private boolean ksM;
  protected int ksN;
  protected int ksO;
  protected int ksP;
  protected int ksQ;
  protected int ksR;
  protected int ksS;
  volatile boolean ksc;
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
    this(paramHandler, 800000, 0.75F, 25000, 25000, 15000, 30000, 2500);
  }
  
  public c(Handler paramHandler, int paramInt1, float paramFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this(paramHandler, paramInt1, paramFloat, paramInt2, paramInt3, paramInt4, paramInt5, 2500);
  }
  
  private c(Handler paramHandler, int paramInt1, float paramFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(194147);
    this.iQZ = new AtomicBoolean();
    this.bvE = 800000;
    this.bvI = 0.75F;
    this.ksN = 10000;
    this.ksO = 25000;
    this.ksP = 15000;
    this.ksQ = 30000;
    this.ksR = 2500;
    this.ksS = 5000;
    ad.i("MicroMsg.SameLayer.ExoMediaPlayer", "ExoMediaPlayer, handler = %s, maxInitBitrate = %s, bandFraction = %s, minDur = %s, maxDur = %s, minBuffer = %s, maxBuffer = %s, bufferForPlaybackMs:%s, bufferForPlaybackAfterRebufferMs:%s", new Object[] { paramHandler, Integer.valueOf(paramInt1), Float.valueOf(paramFloat), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(5000) });
    this.bvE = paramInt1;
    this.bvI = paramFloat;
    this.ksN = paramInt2;
    this.ksO = paramInt3;
    this.ksP = paramInt4;
    this.ksQ = paramInt5;
    this.ksR = paramInt6;
    this.ksS = 5000;
    c(paramHandler);
    AppMethodBeat.o(194147);
  }
  
  public c(Handler paramHandler, int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramHandler, 800000, 0.75F, 25000, 25000, paramInt1, paramInt2, paramInt3);
  }
  
  private g.a L(Map<String, String> paramMap)
  {
    AppMethodBeat.i(194156);
    if ((paramMap == null) && (!com.tencent.mm.plugin.appbrand.jsapi.video.j.bcK().knV))
    {
      g.a locala = null;
      if (com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.video.g.class) != null) {
        locala = ((com.tencent.mm.plugin.appbrand.jsapi.video.g)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.video.g.class)).bcx();
      }
      if (locala != null)
      {
        ad.i("MicroMsg.SameLayer.ExoMediaPlayer", "getDataSourceFactory, return customized data source factory");
        AppMethodBeat.o(194156);
        return locala;
      }
    }
    ad.i("MicroMsg.SameLayer.ExoMediaPlayer", "getDataSourceFactory, return default data source factory");
    paramMap = d.a(this.FZ, paramMap);
    AppMethodBeat.o(194156);
    return paramMap;
  }
  
  private void a(int paramInt1, int paramInt2, Object paramObject, boolean paramBoolean)
  {
    AppMethodBeat.i(194175);
    if (this.ksG.isEmpty())
    {
      AppMethodBeat.o(194175);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.ksG.iterator();
    while (localIterator.hasNext())
    {
      com.google.android.exoplayer2.r localr = (com.google.android.exoplayer2.r)localIterator.next();
      if (localr.getTrackType() == paramInt1) {
        localArrayList.add(new f.c(localr, paramInt2, paramObject));
      }
    }
    if (paramBoolean)
    {
      this.ksC.b((f.c[])localArrayList.toArray(new f.c[localArrayList.size()]));
      AppMethodBeat.o(194175);
      return;
    }
    this.ksC.a((f.c[])localArrayList.toArray(new f.c[localArrayList.size()]));
    AppMethodBeat.o(194175);
  }
  
  private com.google.android.exoplayer2.source.j b(Uri paramUri, String paramString)
  {
    AppMethodBeat.i(194153);
    int i = q(paramUri);
    paramString = com.tencent.mm.plugin.appbrand.jsapi.q.d.IV(paramString);
    switch (i)
    {
    default: 
      ad.e("MicroMsg.SameLayer.ExoMediaPlayer", "buildMediaSource, unsupported type:" + i + ", url:" + paramUri);
      AppMethodBeat.o(194153);
      return null;
    case 2: 
      ad.i("MicroMsg.SameLayer.ExoMediaPlayer", "buildMediaSource, type:HLS, url:%s", new Object[] { paramUri });
      paramUri = new com.google.android.exoplayer2.source.b.h(paramUri, d.a(this.FZ, paramString), this.mMainHandler, this.ksI);
      AppMethodBeat.o(194153);
      return paramUri;
    }
    ad.i("MicroMsg.SameLayer.ExoMediaPlayer", "buildMediaSource, type:other, url:%s", new Object[] { paramUri });
    paramUri = new com.google.android.exoplayer2.source.h(paramUri, L(paramString), bdN(), this.mMainHandler, this.ksI);
    AppMethodBeat.o(194153);
    return paramUri;
  }
  
  private void bdJ()
  {
    AppMethodBeat.i(194149);
    ad.i("MicroMsg.SameLayer.ExoMediaPlayer", "iniMediaPlayer");
    com.google.android.exoplayer2.g.c localc = new com.google.android.exoplayer2.g.c(new a.a(d.bdQ(), this.bvE, this.ksN, this.ksO, this.bvI));
    com.google.android.exoplayer2.c localc1 = new com.google.android.exoplayer2.c(new k(), this.ksP, this.ksQ, this.ksR, this.ksS);
    this.ksC = com.google.android.exoplayer2.g.a((com.google.android.exoplayer2.r[])this.ksG.toArray(new com.google.android.exoplayer2.r[this.ksG.size()]), localc, localc1);
    this.ksC.a(this.ksH);
    AppMethodBeat.o(194149);
  }
  
  private void c(Handler paramHandler)
  {
    AppMethodBeat.i(194148);
    this.FZ = aj.getContext();
    this.ksE = new e((byte)0);
    if (paramHandler != null) {}
    for (this.mMainHandler = paramHandler;; this.mMainHandler = new Handler(this.mHandlerThread.getLooper()))
    {
      this.ksH = new c((byte)0);
      this.ksI = new b((byte)0);
      this.ksJ = new f(this.mMainHandler);
      this.ksJ.ksY = 1000;
      this.ksJ.kta = new a((byte)0);
      d locald = new d((byte)0);
      this.ksG = new a(this.FZ, this.mMainHandler, locald, locald, locald, locald).bdI();
      if ((paramHandler == null) || (paramHandler.getLooper() != Looper.myLooper())) {
        break;
      }
      bdJ();
      AppMethodBeat.o(194148);
      return;
      this.mHandlerThread = com.tencent.e.c.d.gv("ExoMediaPlayer_HandlerThread", 5);
      this.mHandlerThread.start();
    }
    this.mMainHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(194112);
        synchronized (c.this)
        {
          c.a(c.this);
          c.this.notifyAll();
          AppMethodBeat.o(194112);
          return;
        }
      }
    });
    try
    {
      for (;;)
      {
        paramHandler = this.ksC;
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
      AppMethodBeat.o(194148);
    }
    AppMethodBeat.o(194148);
  }
  
  private void cz(Object paramObject)
  {
    AppMethodBeat.i(194174);
    a(1, 2, paramObject, false);
    AppMethodBeat.o(194174);
  }
  
  private void gq(boolean paramBoolean)
  {
    AppMethodBeat.i(194172);
    ad.d("MicroMsg.SameLayer.ExoMediaPlayer", "setBufferRepeaterStarted ".concat(String.valueOf(paramBoolean)));
    if ((paramBoolean) && (this.ksi != null))
    {
      this.ksJ.start();
      AppMethodBeat.o(194172);
      return;
    }
    this.ksJ.ksX = false;
    AppMethodBeat.o(194172);
  }
  
  private static int q(Uri paramUri)
  {
    AppMethodBeat.i(194154);
    if ((paramUri != null) && (com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.Jx(paramUri.toString())))
    {
      AppMethodBeat.o(194154);
      return 2;
    }
    AppMethodBeat.o(194154);
    return 3;
  }
  
  final boolean available()
  {
    return this.ksC != null;
  }
  
  public final boolean ay(float paramFloat)
  {
    AppMethodBeat.i(194158);
    if (available())
    {
      p localp = new p(paramFloat, 1.0F);
      this.ksC.a(localp);
      AppMethodBeat.o(194158);
      return true;
    }
    AppMethodBeat.o(194158);
    return false;
  }
  
  public final int bdK()
  {
    return this.ksP;
  }
  
  public final int bdL()
  {
    return this.ksQ;
  }
  
  public final int bdM()
  {
    return this.ksR;
  }
  
  protected com.google.android.exoplayer2.c.h bdN()
  {
    AppMethodBeat.i(194155);
    b localb = new b();
    AppMethodBeat.o(194155);
    return localb;
  }
  
  final void bdO()
  {
    for (;;)
    {
      int j;
      try
      {
        AppMethodBeat.i(194173);
        if ((this.ksC == null) || (this.ksc))
        {
          AppMethodBeat.o(194173);
          return;
        }
        int i = this.ksC.rt();
        boolean bool = this.ksC.ru();
        j = e.r(bool, i);
        if (j == this.ksE.ksV[3]) {
          break label478;
        }
        ad.i("MicroMsg.SameLayer.ExoMediaPlayer", "reportPlayerState, set new recent state [" + bool + "," + i + "]");
        this.ksE.q(bool, i);
        if (j == 3)
        {
          gq(true);
          if (j != e.r(true, 4)) {
            break label214;
          }
          if (!this.ksL) {
            break label195;
          }
          ad.i("MicroMsg.SameLayer.ExoMediaPlayer", "looping play start");
          this.ksM = true;
          seekTo(0L);
          AppMethodBeat.o(194173);
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
        gq(false);
        continue;
        label195:
        this.ksb = 6;
        bdG();
        AppMethodBeat.o(194173);
        continue;
        label214:
        if (this.ksE.a(new int[] { e.r(false, 1), e.r(false, 2), e.r(false, 3) }, false))
        {
          this.ksb = 2;
          bdF();
          AppMethodBeat.o(194173);
        }
        else if ((this.ksE.a(new int[] { 100, 2, 3 }, true) | this.ksE.a(new int[] { 2, 100, 3 }, true) | this.ksE.a(new int[] { 100, 3, 2, 3 }, true)))
        {
          if (!this.ksM)
          {
            bdH();
            AppMethodBeat.o(194173);
          }
          else
          {
            this.ksM = false;
            AppMethodBeat.o(194173);
          }
        }
        else if (this.ksE.a(new int[] { e.r(true, 3), e.r(true, 2) }, false))
        {
          dV(701, getBufferedPercentage());
          AppMethodBeat.o(194173);
        }
        else
        {
          if (this.ksE.a(new int[] { e.r(true, 2), e.r(true, 3) }, false)) {
            dV(702, getBufferedPercentage());
          }
          label478:
          AppMethodBeat.o(194173);
        }
      }
    }
  }
  
  public final void dp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(194152);
    this.ksF = b(Uri.parse(paramString1), paramString2);
    this.ksb = 1;
    AppMethodBeat.o(194152);
  }
  
  final int getBufferedPercentage()
  {
    AppMethodBeat.i(194171);
    if (available())
    {
      int i = this.ksC.getBufferedPercentage();
      AppMethodBeat.o(194171);
      return i;
    }
    AppMethodBeat.o(194171);
    return 0;
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(194162);
    if (available())
    {
      int i = (int)this.ksC.getCurrentPosition();
      AppMethodBeat.o(194162);
      return i;
    }
    AppMethodBeat.o(194162);
    return 0;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(194161);
    if (available())
    {
      int i = (int)this.ksC.getDuration();
      AppMethodBeat.o(194161);
      return i;
    }
    AppMethodBeat.o(194161);
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
    AppMethodBeat.i(194150);
    if (available())
    {
      switch (this.ksC.rt())
      {
      }
      do
      {
        AppMethodBeat.o(194150);
        return false;
        boolean bool = this.ksC.ru();
        AppMethodBeat.o(194150);
        return bool;
      } while (!this.ksL);
      AppMethodBeat.o(194150);
      return true;
    }
    AppMethodBeat.o(194150);
    return false;
  }
  
  public final void j(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(194167);
    if (available())
    {
      this.ksC.seekTo(paramLong);
      this.ksE.q(paramBoolean, 100);
    }
    AppMethodBeat.o(194167);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(194165);
    if (available())
    {
      this.ksC.aO(false);
      this.ksb = 3;
    }
    AppMethodBeat.o(194165);
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(194163);
    if (this.ksF == null)
    {
      ad.w("MicroMsg.SameLayer.ExoMediaPlayer", "prepareAsync, media source is null");
      AppMethodBeat.o(194163);
      return;
    }
    if (available())
    {
      this.ksC.aO(false);
      this.ksC.a(this.ksF);
    }
    AppMethodBeat.o(194163);
  }
  
  public final void release()
  {
    AppMethodBeat.i(194170);
    this.ksc = true;
    if (available())
    {
      gq(false);
      if (available())
      {
        this.ksC.release();
        this.ksC.b(this.ksH);
        this.ksC = null;
      }
      this.mVideoWidth = 0;
      this.mVideoHeight = 0;
      this.ksK = 0;
    }
    if (this.mHandlerThread != null)
    {
      this.mHandlerThread.quit();
      this.mHandlerThread = null;
    }
    if (this.mSurface != null)
    {
      if (this.ksD) {
        this.mSurface.release();
      }
      this.mSurface = null;
    }
    this.ksd = null;
    this.kse = null;
    this.ksf = null;
    this.ksg = null;
    this.ksh = null;
    this.ksi = null;
    this.ksj = null;
    this.ksb = -2;
    super.release();
    AppMethodBeat.o(194170);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(194169);
    if (available())
    {
      gq(false);
      if (available())
      {
        this.ksC.aO(false);
        this.ksC.stop();
      }
      this.ksL = false;
      this.ksK = 0;
      this.ksE.ksV = new int[] { 1, 1, 1, 1 };
      this.ksb = 0;
    }
    AppMethodBeat.o(194169);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(194166);
    e locale;
    if (available())
    {
      this.ksC.seekTo(paramLong);
      locale = this.ksE;
      if ((this.ksE.ksV[3] & 0xF0000000) == 0) {
        break label62;
      }
    }
    label62:
    for (boolean bool = true;; bool = false)
    {
      locale.q(bool, 100);
      AppMethodBeat.o(194166);
      return;
    }
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(194151);
    dp(paramString, null);
    AppMethodBeat.o(194151);
  }
  
  public final void setLooping(boolean paramBoolean)
  {
    this.ksL = paramBoolean;
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(194159);
    if (available())
    {
      if (paramBoolean)
      {
        setVolume(0.0F, 0.0F);
        AppMethodBeat.o(194159);
        return;
      }
      setVolume(1.0F, 1.0F);
    }
    AppMethodBeat.o(194159);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(194157);
    if ((available()) && (available()))
    {
      if ((this.mSurface == null) || (this.mSurface == paramSurface) || (paramSurface == null)) {
        break label116;
      }
      if (this.ksD) {
        this.mSurface.release();
      }
      a(2, 1, paramSurface, true);
      final long l = this.ksC.getCurrentPosition();
      if (x.SDK_INT < 23) {
        this.mMainHandler.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(194113);
            if (c.this.available()) {
              c.this.ksC.seekTo(l);
            }
            AppMethodBeat.o(194113);
          }
        }, 200L);
      }
    }
    for (;;)
    {
      this.mSurface = paramSurface;
      this.ksD = false;
      AppMethodBeat.o(194157);
      return;
      label116:
      a(2, 1, paramSurface, false);
    }
  }
  
  public final void setVolume(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(194160);
    cz(Float.valueOf(paramFloat1));
    AppMethodBeat.o(194160);
  }
  
  public final void start()
  {
    AppMethodBeat.i(194164);
    if (available())
    {
      if (this.ksC.rt() == 4) {
        this.ksC.seekTo(0L);
      }
      this.ksC.aO(true);
      this.ksb = 3;
      this.iQZ.set(false);
    }
    AppMethodBeat.o(194164);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(194168);
    if ((available()) && (!this.iQZ.getAndSet(true)))
    {
      this.ksC.aO(false);
      this.ksC.stop();
      this.ksb = 5;
    }
    AppMethodBeat.o(194168);
  }
  
  final class a
    implements f.b
  {
    private a() {}
    
    public final void acz()
    {
      AppMethodBeat.i(194114);
      for (;;)
      {
        synchronized (c.this)
        {
          if (c.this.ksc)
          {
            AppMethodBeat.o(194114);
            return;
          }
          if (c.this.available()) {}
          switch (c.this.ksC.rt())
          {
          case 1: 
            AppMethodBeat.o(194114);
            return;
          case 4: 
            c.a(c.this, false);
          }
        }
        int i = c.this.getBufferedPercentage();
        if (i != c.this.ksK)
        {
          c.this.sj(i);
          c.this.ksK = i;
        }
      }
    }
  }
  
  final class b
    implements com.google.android.exoplayer2.source.a, h.a
  {
    private b() {}
    
    public final void a(int paramInt, Format paramFormat, long paramLong)
    {
      AppMethodBeat.i(194119);
      ad.d("MicroMsg.SameLayer.ExoMediaPlayer", "onDownstreamFormatChanged, trackType:%s, trackFormat:%s, mediaTimeMs:%s", new Object[] { Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong) });
      AppMethodBeat.o(194119);
    }
    
    public final void a(com.google.android.exoplayer2.h.j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(194115);
      ad.d("MicroMsg.SameLayer.ExoMediaPlayer", "onLoadStarted, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s", new Object[] { paramj, Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
      AppMethodBeat.o(194115);
    }
    
    public final void a(com.google.android.exoplayer2.h.j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, IOException paramIOException, boolean paramBoolean)
    {
      AppMethodBeat.i(194118);
      ad.printErrStackTrace("MicroMsg.SameLayer.ExoMediaPlayer", paramIOException, "onLoadError1, IOException, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s, loadDurationMs:%s, bytesLoaded:%s, wasCanceled:%s", new Object[] { paramj, Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(paramLong4), Long.valueOf(paramLong5), Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(194118);
    }
    
    public final void b(com.google.android.exoplayer2.h.j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(194116);
      ad.d("MicroMsg.SameLayer.ExoMediaPlayer", "onLoadCompleted, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s", new Object[] { paramj, Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
      AppMethodBeat.o(194116);
    }
    
    public final void c(com.google.android.exoplayer2.h.j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(194117);
      ad.d("MicroMsg.SameLayer.ExoMediaPlayer", "onLoadCanceled, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s", new Object[] { paramj, Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
      AppMethodBeat.o(194117);
    }
    
    public final void onLoadError(IOException paramIOException)
    {
      AppMethodBeat.i(194121);
      ad.printErrStackTrace("MicroMsg.SameLayer.ExoMediaPlayer", paramIOException, "onLoadError2, IOException", new Object[0]);
      AppMethodBeat.o(194121);
    }
    
    public final void ty()
    {
      AppMethodBeat.i(194120);
      ad.d("MicroMsg.SameLayer.ExoMediaPlayer", "onHasEndTag");
      AppMethodBeat.o(194120);
    }
  }
  
  final class c
    implements f.a
  {
    private c() {}
    
    public final void a(com.google.android.exoplayer2.e parame)
    {
      int i = -4000;
      AppMethodBeat.i(194129);
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
              boolean bool = d.isNetworkAvailable(c.this.FZ);
              ad.printErrStackTrace("MicroMsg.SameLayer.ExoMediaPlayer", parame, "ExoPlaybackException hasNetwork=".concat(String.valueOf(bool)), new Object[0]);
              if (!bool)
              {
                c.this.dU(-4000, -2);
                AppMethodBeat.o(194129);
                return;
              }
              c.this.dU(-4000, -3);
              AppMethodBeat.o(194129);
              return;
            }
            if (!(parame instanceof s.e)) {
              break label422;
            }
            parame = parame.toString();
            if (parame.contains("403"))
            {
              c.this.dU(-4000, -10);
              AppMethodBeat.o(194129);
              return;
            }
            if (parame.contains("404"))
            {
              c.this.dU(-4000, -11);
              AppMethodBeat.o(194129);
              return;
            }
            if (parame.contains("500"))
            {
              c.this.dU(-4000, -12);
              AppMethodBeat.o(194129);
              return;
            }
            if (parame.contains("502"))
            {
              c.this.dU(-4000, -13);
              AppMethodBeat.o(194129);
              return;
            }
            c.this.dU(-4000, -30);
            AppMethodBeat.o(194129);
            return;
          }
          if ((parame instanceof com.google.android.exoplayer2.source.r))
          {
            ad.e("MicroMsg.SameLayer.ExoMediaPlayer", d.bdP());
            c.this.dU(-4001, -1);
            AppMethodBeat.o(194129);
            return;
          }
          if ((parame instanceof IllegalStateException))
          {
            ad.e("MicroMsg.SameLayer.ExoMediaPlayer", d.bdP());
            c.this.dU(-4002, -1);
            AppMethodBeat.o(194129);
            return;
          }
          if ((parame instanceof b.a))
          {
            ad.e("MicroMsg.SameLayer.ExoMediaPlayer", d.bdP());
            c.this.dU(-4003, -1);
            AppMethodBeat.o(194129);
            return;
          }
          if ((parame instanceof t.f))
          {
            ad.e("MicroMsg.SameLayer.ExoMediaPlayer", d.bdP());
            c.this.dU(-4004, -1);
            AppMethodBeat.o(194129);
            return;
          }
        }
      }
      i = -4999;
      label422:
      ad.e("MicroMsg.SameLayer.ExoMediaPlayer", d.sl(30));
      c.this.dU(i, -1);
      AppMethodBeat.o(194129);
    }
    
    public final void aA(int paramInt)
    {
      AppMethodBeat.i(194126);
      ad.d("MicroMsg.SameLayer.ExoMediaPlayer", "onRepeatModeChanged, repeatMode=".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(194126);
    }
    
    public final void aR(boolean paramBoolean)
    {
      AppMethodBeat.i(194127);
      ad.d("MicroMsg.SameLayer.ExoMediaPlayer", "onLoadingChanged, isLoading=".concat(String.valueOf(paramBoolean)));
      if (paramBoolean) {
        c.a(c.this, true);
      }
      AppMethodBeat.o(194127);
    }
    
    public final void b(p paramp)
    {
      AppMethodBeat.i(194125);
      ad.d("MicroMsg.SameLayer.ExoMediaPlayer", "onPlaybackParametersChanged, params=[" + paramp.aSD + ", " + paramp.pitch + "]");
      AppMethodBeat.o(194125);
    }
    
    public final void e(boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(194128);
      ad.i("MicroMsg.SameLayer.ExoMediaPlayer", "onPlayerStateChanged, playWhenReady=" + paramBoolean + ", playbackState=" + paramInt);
      c.this.bdO();
      AppMethodBeat.o(194128);
    }
    
    public final void rJ()
    {
      AppMethodBeat.i(194122);
      ad.d("MicroMsg.SameLayer.ExoMediaPlayer", "onTimelineChanged");
      AppMethodBeat.o(194122);
    }
    
    public final void rK()
    {
      AppMethodBeat.i(194124);
      ad.d("MicroMsg.SameLayer.ExoMediaPlayer", "onTracksChanged");
      AppMethodBeat.o(194124);
    }
    
    public final void rL()
    {
      AppMethodBeat.i(194123);
      ad.d("MicroMsg.SameLayer.ExoMediaPlayer", "onPositionDiscontinuity");
      AppMethodBeat.o(194123);
    }
  }
  
  final class d
    implements com.google.android.exoplayer2.a.e, j.a, e.a, com.google.android.exoplayer2.video.e
  {
    private d() {}
    
    public final void a(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
    {
      AppMethodBeat.i(194144);
      ad.i("MicroMsg.SameLayer.ExoMediaPlayer", "onVideoSizeChanged, width:%d, height:%d, rotationDegrees:%d, ratio:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Float.valueOf(paramFloat) });
      c.this.mVideoWidth = paramInt1;
      c.this.mVideoHeight = paramInt2;
      c.this.dT(paramInt1, paramInt2);
      AppMethodBeat.o(194144);
    }
    
    public final void a(com.google.android.exoplayer2.b.d paramd)
    {
      AppMethodBeat.i(194138);
      ad.d("MicroMsg.SameLayer.ExoMediaPlayer", "onVideoEnabled");
      AppMethodBeat.o(194138);
    }
    
    public final void b(com.google.android.exoplayer2.b.d paramd)
    {
      AppMethodBeat.i(194139);
      ad.d("MicroMsg.SameLayer.ExoMediaPlayer", "onVideoDisabled");
      AppMethodBeat.o(194139);
    }
    
    public final void b(Metadata paramMetadata)
    {
      AppMethodBeat.i(194136);
      ad.d("MicroMsg.SameLayer.ExoMediaPlayer", "onMetadata");
      AppMethodBeat.o(194136);
    }
    
    public final void b(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(194140);
      ad.d("MicroMsg.SameLayer.ExoMediaPlayer", "onVideoDecoderInitialized");
      AppMethodBeat.o(194140);
    }
    
    public final void c(int paramInt, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(194134);
      ad.d("MicroMsg.SameLayer.ExoMediaPlayer", "onAudioTrackUnderrun");
      AppMethodBeat.o(194134);
    }
    
    public final void c(Format paramFormat)
    {
      AppMethodBeat.i(194141);
      ad.d("MicroMsg.SameLayer.ExoMediaPlayer", "onVideoInputFormatChanged");
      AppMethodBeat.o(194141);
    }
    
    public final void c(com.google.android.exoplayer2.b.d paramd)
    {
      AppMethodBeat.i(194130);
      ad.d("MicroMsg.SameLayer.ExoMediaPlayer", "onAudioEnabled");
      AppMethodBeat.o(194130);
    }
    
    public final void c(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(194132);
      ad.d("MicroMsg.SameLayer.ExoMediaPlayer", "onAudioDecoderInitialized");
      AppMethodBeat.o(194132);
    }
    
    public final void d(Surface paramSurface)
    {
      AppMethodBeat.i(194143);
      ad.i("MicroMsg.SameLayer.ExoMediaPlayer", "onRenderedFirstFrame");
      c.this.dV(3, 0);
      AppMethodBeat.o(194143);
    }
    
    public final void d(Format paramFormat)
    {
      AppMethodBeat.i(194133);
      ad.d("MicroMsg.SameLayer.ExoMediaPlayer", "onAudioInputFormatChanged");
      AppMethodBeat.o(194133);
    }
    
    public final void d(com.google.android.exoplayer2.b.d paramd)
    {
      AppMethodBeat.i(194135);
      ad.d("MicroMsg.SameLayer.ExoMediaPlayer", "onAudioDisabled");
      AppMethodBeat.o(194135);
    }
    
    public final void dI(int paramInt)
    {
      AppMethodBeat.i(194131);
      ad.d("MicroMsg.SameLayer.ExoMediaPlayer", "onAudioSessionId");
      AppMethodBeat.o(194131);
    }
    
    public final void h(int paramInt, long paramLong)
    {
      AppMethodBeat.i(194142);
      ad.d("MicroMsg.SameLayer.ExoMediaPlayer", "onDroppedFrames");
      AppMethodBeat.o(194142);
    }
    
    public final void t(List<com.google.android.exoplayer2.f.a> paramList)
    {
      AppMethodBeat.i(194137);
      ad.d("MicroMsg.SameLayer.ExoMediaPlayer", "onCues");
      AppMethodBeat.o(194137);
    }
  }
  
  static final class e
  {
    int[] ksV;
    
    private e()
    {
      AppMethodBeat.i(194145);
      this.ksV = new int[] { 1, 1, 1, 1 };
      AppMethodBeat.o(194145);
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
        int k = this.ksV.length - paramArrayOfInt.length;
        j = k;
        paramBoolean = true;
        label23:
        if (j >= this.ksV.length) {
          return paramBoolean;
        }
        if ((this.ksV[j] & i) != (paramArrayOfInt[(j - k)] & i)) {
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
      AppMethodBeat.i(194146);
      int i = r(paramBoolean, paramInt);
      ad.i("MicroMsg.SameLayer.ExoMediaPlayer", "request setMostRecentState [" + paramBoolean + "," + paramInt + "], lastState=" + this.ksV[3] + ", newState=" + i);
      if (this.ksV[3] == i)
      {
        AppMethodBeat.o(194146);
        return;
      }
      this.ksV[0] = this.ksV[1];
      this.ksV[1] = this.ksV[2];
      this.ksV[2] = this.ksV[3];
      this.ksV[3] = i;
      ad.i("MicroMsg.SameLayer.ExoMediaPlayer", "new MostRecentState [" + this.ksV[0] + "," + this.ksV[1] + "," + this.ksV[2] + "," + this.ksV[3] + "]");
      AppMethodBeat.o(194146);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c
 * JD-Core Version:    0.7.0.1
 */