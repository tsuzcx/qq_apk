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
import com.google.android.exoplayer2.h.j;
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
import com.tencent.mm.plugin.appbrand.jsapi.video.n;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class c
  extends com.tencent.mm.plugin.appbrand.jsapi.video.e.a
{
  Context GX;
  protected int btD;
  protected float btH;
  private final AtomicBoolean jrj;
  com.google.android.exoplayer2.f kTS;
  private boolean kTT;
  private e kTU;
  private i kTV;
  private List<r> kTW;
  private f.a kTX;
  private b kTY;
  private f kTZ;
  volatile boolean kTs;
  int kUa;
  private boolean kUb;
  private boolean kUc;
  protected int kUd;
  protected int kUe;
  protected int kUf;
  protected int kUg;
  protected int kUh;
  protected int kUi;
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
    AppMethodBeat.i(194492);
    this.jrj = new AtomicBoolean();
    this.btD = 800000;
    this.btH = 0.75F;
    this.kUd = 10000;
    this.kUe = 25000;
    this.kUf = 15000;
    this.kUg = 30000;
    this.kUh = 2500;
    this.kUi = 5000;
    ac.i("MicroMsg.SameLayer.ExoMediaPlayer", "ExoMediaPlayer, handler = %s, maxInitBitrate = %s, bandFraction = %s, minDur = %s, maxDur = %s, minBuffer = %s, maxBuffer = %s, bufferForPlaybackMs:%s, bufferForPlaybackAfterRebufferMs:%s", new Object[] { paramHandler, Integer.valueOf(paramInt1), Float.valueOf(paramFloat), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(5000) });
    this.btD = paramInt1;
    this.btH = paramFloat;
    this.kUd = paramInt2;
    this.kUe = paramInt3;
    this.kUf = paramInt4;
    this.kUg = paramInt5;
    this.kUh = paramInt6;
    this.kUi = 5000;
    c(paramHandler);
    AppMethodBeat.o(194492);
  }
  
  public c(Handler paramHandler, int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramHandler, 800000, 0.75F, 25000, 25000, paramInt1, paramInt2, paramInt3);
  }
  
  private com.google.android.exoplayer2.h.g.a L(Map<String, String> paramMap)
  {
    AppMethodBeat.i(194501);
    if ((paramMap == null) && (!n.bjG().kPp))
    {
      com.google.android.exoplayer2.h.g.a locala = null;
      if (com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.video.g.class) != null) {
        locala = ((com.tencent.mm.plugin.appbrand.jsapi.video.g)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.video.g.class)).bjs();
      }
      if (locala != null)
      {
        ac.i("MicroMsg.SameLayer.ExoMediaPlayer", "getDataSourceFactory, return customized data source factory");
        AppMethodBeat.o(194501);
        return locala;
      }
    }
    ac.i("MicroMsg.SameLayer.ExoMediaPlayer", "getDataSourceFactory, return default data source factory");
    paramMap = d.a(this.GX, paramMap);
    AppMethodBeat.o(194501);
    return paramMap;
  }
  
  private void a(int paramInt1, int paramInt2, Object paramObject, boolean paramBoolean)
  {
    AppMethodBeat.i(194520);
    if (this.kTW.isEmpty())
    {
      AppMethodBeat.o(194520);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.kTW.iterator();
    while (localIterator.hasNext())
    {
      r localr = (r)localIterator.next();
      if (localr.getTrackType() == paramInt1) {
        localArrayList.add(new f.c(localr, paramInt2, paramObject));
      }
    }
    if (paramBoolean)
    {
      this.kTS.b((f.c[])localArrayList.toArray(new f.c[localArrayList.size()]));
      AppMethodBeat.o(194520);
      return;
    }
    this.kTS.a((f.c[])localArrayList.toArray(new f.c[localArrayList.size()]));
    AppMethodBeat.o(194520);
  }
  
  private i b(Uri paramUri, String paramString)
  {
    AppMethodBeat.i(194498);
    int i = q(paramUri);
    paramString = com.tencent.mm.plugin.appbrand.jsapi.p.d.MY(paramString);
    switch (i)
    {
    default: 
      ac.e("MicroMsg.SameLayer.ExoMediaPlayer", "buildMediaSource, unsupported type:" + i + ", url:" + paramUri);
      AppMethodBeat.o(194498);
      return null;
    case 2: 
      ac.i("MicroMsg.SameLayer.ExoMediaPlayer", "buildMediaSource, type:HLS, url:%s", new Object[] { paramUri });
      paramUri = new com.google.android.exoplayer2.source.b.h(paramUri, d.a(this.GX, paramString), this.mMainHandler, this.kTY);
      AppMethodBeat.o(194498);
      return paramUri;
    }
    ac.i("MicroMsg.SameLayer.ExoMediaPlayer", "buildMediaSource, type:other, url:%s", new Object[] { paramUri });
    paramUri = new com.google.android.exoplayer2.source.g(paramUri, L(paramString), bkH(), this.mMainHandler, this.kTY);
    AppMethodBeat.o(194498);
    return paramUri;
  }
  
  private void bkD()
  {
    AppMethodBeat.i(194494);
    ac.i("MicroMsg.SameLayer.ExoMediaPlayer", "iniMediaPlayer");
    com.google.android.exoplayer2.g.c localc = new com.google.android.exoplayer2.g.c(new a.a(d.bkK(), this.btD, this.kUd, this.kUe, this.btH));
    com.google.android.exoplayer2.c localc1 = new com.google.android.exoplayer2.c(new k(), this.kUf, this.kUg, this.kUh, this.kUi);
    this.kTS = com.google.android.exoplayer2.g.a((r[])this.kTW.toArray(new r[this.kTW.size()]), localc, localc1);
    this.kTS.a(this.kTX);
    AppMethodBeat.o(194494);
  }
  
  private void c(Handler paramHandler)
  {
    AppMethodBeat.i(194493);
    this.GX = ai.getContext();
    this.kTU = new e((byte)0);
    if (paramHandler != null) {}
    for (this.mMainHandler = paramHandler;; this.mMainHandler = new Handler(this.mHandlerThread.getLooper()))
    {
      this.kTX = new c((byte)0);
      this.kTY = new b((byte)0);
      this.kTZ = new f(this.mMainHandler);
      this.kTZ.kUn = 1000;
      this.kTZ.kUp = new a((byte)0);
      d locald = new d((byte)0);
      this.kTW = new a(this.GX, this.mMainHandler, locald, locald, locald, locald).bkC();
      if ((paramHandler == null) || (paramHandler.getLooper() != Looper.myLooper())) {
        break;
      }
      bkD();
      AppMethodBeat.o(194493);
      return;
      this.mHandlerThread = com.tencent.e.c.d.gz("ExoMediaPlayer_HandlerThread", 5);
      this.mHandlerThread.start();
    }
    this.mMainHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(194457);
        synchronized (c.this)
        {
          c.a(c.this);
          c.this.notifyAll();
          AppMethodBeat.o(194457);
          return;
        }
      }
    });
    try
    {
      for (;;)
      {
        paramHandler = this.kTS;
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
      AppMethodBeat.o(194493);
    }
    AppMethodBeat.o(194493);
  }
  
  private void cx(Object paramObject)
  {
    AppMethodBeat.i(194519);
    a(1, 2, paramObject, false);
    AppMethodBeat.o(194519);
  }
  
  private void gM(boolean paramBoolean)
  {
    AppMethodBeat.i(194517);
    ac.d("MicroMsg.SameLayer.ExoMediaPlayer", "setBufferRepeaterStarted ".concat(String.valueOf(paramBoolean)));
    if ((paramBoolean) && (this.kTy != null))
    {
      this.kTZ.start();
      AppMethodBeat.o(194517);
      return;
    }
    this.kTZ.kUm = false;
    AppMethodBeat.o(194517);
  }
  
  private static int q(Uri paramUri)
  {
    AppMethodBeat.i(194499);
    if ((paramUri != null) && (com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.NB(paramUri.toString())))
    {
      AppMethodBeat.o(194499);
      return 2;
    }
    AppMethodBeat.o(194499);
    return 3;
  }
  
  public final boolean aC(float paramFloat)
  {
    AppMethodBeat.i(194503);
    if (available())
    {
      p localp = new p(paramFloat, 1.0F);
      this.kTS.a(localp);
      AppMethodBeat.o(194503);
      return true;
    }
    AppMethodBeat.o(194503);
    return false;
  }
  
  final boolean available()
  {
    return this.kTS != null;
  }
  
  public final int bkE()
  {
    return this.kUf;
  }
  
  public final int bkF()
  {
    return this.kUg;
  }
  
  public final int bkG()
  {
    return this.kUh;
  }
  
  protected com.google.android.exoplayer2.c.h bkH()
  {
    AppMethodBeat.i(194500);
    b localb = new b();
    AppMethodBeat.o(194500);
    return localb;
  }
  
  final void bkI()
  {
    for (;;)
    {
      int j;
      try
      {
        AppMethodBeat.i(194518);
        if ((this.kTS == null) || (this.kTs))
        {
          AppMethodBeat.o(194518);
          return;
        }
        int i = this.kTS.rE();
        boolean bool = this.kTS.rF();
        j = e.s(bool, i);
        if (j == this.kTU.kUl[3]) {
          break label478;
        }
        ac.i("MicroMsg.SameLayer.ExoMediaPlayer", "reportPlayerState, set new recent state [" + bool + "," + i + "]");
        this.kTU.r(bool, i);
        if (j == 3)
        {
          gM(true);
          if (j != e.s(true, 4)) {
            break label214;
          }
          if (!this.kUb) {
            break label195;
          }
          ac.i("MicroMsg.SameLayer.ExoMediaPlayer", "looping play start");
          this.kUc = true;
          seekTo(0L);
          AppMethodBeat.o(194518);
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
        gM(false);
        continue;
        label195:
        this.kTr = 6;
        bkA();
        AppMethodBeat.o(194518);
        continue;
        label214:
        if (this.kTU.a(new int[] { e.s(false, 1), e.s(false, 2), e.s(false, 3) }, false))
        {
          this.kTr = 2;
          bkz();
          AppMethodBeat.o(194518);
        }
        else if ((this.kTU.a(new int[] { 100, 2, 3 }, true) | this.kTU.a(new int[] { 2, 100, 3 }, true) | this.kTU.a(new int[] { 100, 3, 2, 3 }, true)))
        {
          if (!this.kUc)
          {
            bkB();
            AppMethodBeat.o(194518);
          }
          else
          {
            this.kUc = false;
            AppMethodBeat.o(194518);
          }
        }
        else if (this.kTU.a(new int[] { e.s(true, 3), e.s(true, 2) }, false))
        {
          dW(701, getBufferedPercentage());
          AppMethodBeat.o(194518);
        }
        else
        {
          if (this.kTU.a(new int[] { e.s(true, 2), e.s(true, 3) }, false)) {
            dW(702, getBufferedPercentage());
          }
          label478:
          AppMethodBeat.o(194518);
        }
      }
    }
  }
  
  public final void dB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(194497);
    this.kTV = b(Uri.parse(paramString1), paramString2);
    this.kTr = 1;
    AppMethodBeat.o(194497);
  }
  
  final int getBufferedPercentage()
  {
    AppMethodBeat.i(194516);
    if (available())
    {
      int i = this.kTS.getBufferedPercentage();
      AppMethodBeat.o(194516);
      return i;
    }
    AppMethodBeat.o(194516);
    return 0;
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(194507);
    if (available())
    {
      int i = (int)this.kTS.getCurrentPosition();
      AppMethodBeat.o(194507);
      return i;
    }
    AppMethodBeat.o(194507);
    return 0;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(194506);
    if (available())
    {
      int i = (int)this.kTS.getDuration();
      AppMethodBeat.o(194506);
      return i;
    }
    AppMethodBeat.o(194506);
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
    AppMethodBeat.i(194495);
    if (available())
    {
      switch (this.kTS.rE())
      {
      }
      do
      {
        AppMethodBeat.o(194495);
        return false;
        boolean bool = this.kTS.rF();
        AppMethodBeat.o(194495);
        return bool;
      } while (!this.kUb);
      AppMethodBeat.o(194495);
      return true;
    }
    AppMethodBeat.o(194495);
    return false;
  }
  
  public final void k(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(194512);
    if (available())
    {
      this.kTS.seekTo(paramLong);
      this.kTU.r(paramBoolean, 100);
    }
    AppMethodBeat.o(194512);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(194510);
    if (available())
    {
      this.kTS.aO(false);
      this.kTr = 3;
    }
    AppMethodBeat.o(194510);
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(194508);
    if (this.kTV == null)
    {
      ac.w("MicroMsg.SameLayer.ExoMediaPlayer", "prepareAsync, media source is null");
      AppMethodBeat.o(194508);
      return;
    }
    if (available())
    {
      this.kTS.aO(false);
      this.kTS.a(this.kTV);
    }
    AppMethodBeat.o(194508);
  }
  
  public final void release()
  {
    AppMethodBeat.i(194515);
    this.kTs = true;
    if (available())
    {
      gM(false);
      if (available())
      {
        this.kTS.release();
        this.kTS.b(this.kTX);
        this.kTS = null;
      }
      this.mVideoWidth = 0;
      this.mVideoHeight = 0;
      this.kUa = 0;
    }
    if (this.mHandlerThread != null)
    {
      this.mHandlerThread.quit();
      this.mHandlerThread = null;
    }
    if (this.mSurface != null)
    {
      if (this.kTT) {
        this.mSurface.release();
      }
      this.mSurface = null;
    }
    this.kTt = null;
    this.kTu = null;
    this.kTv = null;
    this.kTw = null;
    this.kTx = null;
    this.kTy = null;
    this.kTz = null;
    this.kTr = -2;
    super.release();
    AppMethodBeat.o(194515);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(194514);
    if (available())
    {
      gM(false);
      if (available())
      {
        this.kTS.aO(false);
        this.kTS.stop();
      }
      this.kUb = false;
      this.kUa = 0;
      this.kTU.kUl = new int[] { 1, 1, 1, 1 };
      this.kTr = 0;
    }
    AppMethodBeat.o(194514);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(194511);
    e locale;
    if (available())
    {
      this.kTS.seekTo(paramLong);
      locale = this.kTU;
      if ((this.kTU.kUl[3] & 0xF0000000) == 0) {
        break label62;
      }
    }
    label62:
    for (boolean bool = true;; bool = false)
    {
      locale.r(bool, 100);
      AppMethodBeat.o(194511);
      return;
    }
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(194496);
    dB(paramString, null);
    AppMethodBeat.o(194496);
  }
  
  public final void setLooping(boolean paramBoolean)
  {
    this.kUb = paramBoolean;
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(194504);
    if (available())
    {
      if (paramBoolean)
      {
        setVolume(0.0F, 0.0F);
        AppMethodBeat.o(194504);
        return;
      }
      setVolume(1.0F, 1.0F);
    }
    AppMethodBeat.o(194504);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(194502);
    if ((available()) && (available()))
    {
      if ((this.mSurface == null) || (this.mSurface == paramSurface) || (paramSurface == null)) {
        break label116;
      }
      if (this.kTT) {
        this.mSurface.release();
      }
      a(2, 1, paramSurface, true);
      final long l = this.kTS.getCurrentPosition();
      if (x.SDK_INT < 23) {
        this.mMainHandler.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(194458);
            if (c.this.available()) {
              c.this.kTS.seekTo(l);
            }
            AppMethodBeat.o(194458);
          }
        }, 200L);
      }
    }
    for (;;)
    {
      this.mSurface = paramSurface;
      this.kTT = false;
      AppMethodBeat.o(194502);
      return;
      label116:
      a(2, 1, paramSurface, false);
    }
  }
  
  public final void setVolume(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(194505);
    cx(Float.valueOf(paramFloat1));
    AppMethodBeat.o(194505);
  }
  
  public final void start()
  {
    AppMethodBeat.i(194509);
    if (available())
    {
      if (this.kTS.rE() == 4) {
        this.kTS.seekTo(0L);
      }
      this.kTS.aO(true);
      this.kTr = 3;
      this.jrj.set(false);
    }
    AppMethodBeat.o(194509);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(194513);
    if ((available()) && (!this.jrj.getAndSet(true)))
    {
      this.kTS.aO(false);
      this.kTS.stop();
      this.kTr = 5;
    }
    AppMethodBeat.o(194513);
  }
  
  final class a
    implements f.b
  {
    private a() {}
    
    public final void adF()
    {
      AppMethodBeat.i(194459);
      for (;;)
      {
        synchronized (c.this)
        {
          if (c.this.kTs)
          {
            AppMethodBeat.o(194459);
            return;
          }
          if (c.this.available()) {}
          switch (c.this.kTS.rE())
          {
          case 1: 
            AppMethodBeat.o(194459);
            return;
          case 4: 
            c.a(c.this, false);
          }
        }
        int i = c.this.getBufferedPercentage();
        if (i != c.this.kUa)
        {
          c.this.sZ(i);
          c.this.kUa = i;
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
      AppMethodBeat.i(194464);
      ac.d("MicroMsg.SameLayer.ExoMediaPlayer", "onDownstreamFormatChanged, trackType:%s, trackFormat:%s, mediaTimeMs:%s", new Object[] { Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong) });
      AppMethodBeat.o(194464);
    }
    
    public final void a(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(194460);
      ac.d("MicroMsg.SameLayer.ExoMediaPlayer", "onLoadStarted, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s", new Object[] { paramj, Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
      AppMethodBeat.o(194460);
    }
    
    public final void a(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, IOException paramIOException, boolean paramBoolean)
    {
      AppMethodBeat.i(194463);
      ac.printErrStackTrace("MicroMsg.SameLayer.ExoMediaPlayer", paramIOException, "onLoadError1, IOException, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s, loadDurationMs:%s, bytesLoaded:%s, wasCanceled:%s", new Object[] { paramj, Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(paramLong4), Long.valueOf(paramLong5), Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(194463);
    }
    
    public final void b(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(194461);
      ac.d("MicroMsg.SameLayer.ExoMediaPlayer", "onLoadCompleted, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s", new Object[] { paramj, Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
      AppMethodBeat.o(194461);
    }
    
    public final void c(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(194462);
      ac.d("MicroMsg.SameLayer.ExoMediaPlayer", "onLoadCanceled, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s", new Object[] { paramj, Integer.valueOf(paramInt), paramFormat, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
      AppMethodBeat.o(194462);
    }
    
    public final void onLoadError(IOException paramIOException)
    {
      AppMethodBeat.i(194466);
      ac.printErrStackTrace("MicroMsg.SameLayer.ExoMediaPlayer", paramIOException, "onLoadError2, IOException", new Object[0]);
      AppMethodBeat.o(194466);
    }
    
    public final void tG()
    {
      AppMethodBeat.i(194465);
      ac.d("MicroMsg.SameLayer.ExoMediaPlayer", "onHasEndTag");
      AppMethodBeat.o(194465);
    }
  }
  
  final class c
    implements f.a
  {
    private c() {}
    
    public final void a(com.google.android.exoplayer2.e parame)
    {
      int i = -4000;
      AppMethodBeat.i(194474);
      ac.printErrStackTrace("MicroMsg.SameLayer.ExoMediaPlayer", parame, "onPlayError, ExoPlaybackException", new Object[0]);
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
              boolean bool = d.isNetworkAvailable(c.this.GX);
              ac.printErrStackTrace("MicroMsg.SameLayer.ExoMediaPlayer", parame, "ExoPlaybackException hasNetwork=".concat(String.valueOf(bool)), new Object[0]);
              if (!bool)
              {
                c.this.dV(-4000, -2);
                AppMethodBeat.o(194474);
                return;
              }
              c.this.dV(-4000, -3);
              AppMethodBeat.o(194474);
              return;
            }
            if (!(parame instanceof s.e)) {
              break label422;
            }
            parame = parame.toString();
            if (parame.contains("403"))
            {
              c.this.dV(-4000, -10);
              AppMethodBeat.o(194474);
              return;
            }
            if (parame.contains("404"))
            {
              c.this.dV(-4000, -11);
              AppMethodBeat.o(194474);
              return;
            }
            if (parame.contains("500"))
            {
              c.this.dV(-4000, -12);
              AppMethodBeat.o(194474);
              return;
            }
            if (parame.contains("502"))
            {
              c.this.dV(-4000, -13);
              AppMethodBeat.o(194474);
              return;
            }
            c.this.dV(-4000, -30);
            AppMethodBeat.o(194474);
            return;
          }
          if ((parame instanceof q))
          {
            ac.e("MicroMsg.SameLayer.ExoMediaPlayer", d.bkJ());
            c.this.dV(-4001, -1);
            AppMethodBeat.o(194474);
            return;
          }
          if ((parame instanceof IllegalStateException))
          {
            ac.e("MicroMsg.SameLayer.ExoMediaPlayer", d.bkJ());
            c.this.dV(-4002, -1);
            AppMethodBeat.o(194474);
            return;
          }
          if ((parame instanceof b.a))
          {
            ac.e("MicroMsg.SameLayer.ExoMediaPlayer", d.bkJ());
            c.this.dV(-4003, -1);
            AppMethodBeat.o(194474);
            return;
          }
          if ((parame instanceof t.f))
          {
            ac.e("MicroMsg.SameLayer.ExoMediaPlayer", d.bkJ());
            c.this.dV(-4004, -1);
            AppMethodBeat.o(194474);
            return;
          }
        }
      }
      i = -4999;
      label422:
      ac.e("MicroMsg.SameLayer.ExoMediaPlayer", d.tb(30));
      c.this.dV(i, -1);
      AppMethodBeat.o(194474);
    }
    
    public final void aA(int paramInt)
    {
      AppMethodBeat.i(194471);
      ac.d("MicroMsg.SameLayer.ExoMediaPlayer", "onRepeatModeChanged, repeatMode=".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(194471);
    }
    
    public final void aR(boolean paramBoolean)
    {
      AppMethodBeat.i(194472);
      ac.d("MicroMsg.SameLayer.ExoMediaPlayer", "onLoadingChanged, isLoading=".concat(String.valueOf(paramBoolean)));
      if (paramBoolean) {
        c.a(c.this, true);
      }
      AppMethodBeat.o(194472);
    }
    
    public final void b(p paramp)
    {
      AppMethodBeat.i(194470);
      ac.d("MicroMsg.SameLayer.ExoMediaPlayer", "onPlaybackParametersChanged, params=[" + paramp.aTw + ", " + paramp.pitch + "]");
      AppMethodBeat.o(194470);
    }
    
    public final void e(boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(194473);
      ac.i("MicroMsg.SameLayer.ExoMediaPlayer", "onPlayerStateChanged, playWhenReady=" + paramBoolean + ", playbackState=" + paramInt);
      c.this.bkI();
      AppMethodBeat.o(194473);
    }
    
    public final void rU()
    {
      AppMethodBeat.i(194467);
      ac.d("MicroMsg.SameLayer.ExoMediaPlayer", "onTimelineChanged");
      AppMethodBeat.o(194467);
    }
    
    public final void rV()
    {
      AppMethodBeat.i(194469);
      ac.d("MicroMsg.SameLayer.ExoMediaPlayer", "onTracksChanged");
      AppMethodBeat.o(194469);
    }
    
    public final void rW()
    {
      AppMethodBeat.i(194468);
      ac.d("MicroMsg.SameLayer.ExoMediaPlayer", "onPositionDiscontinuity");
      AppMethodBeat.o(194468);
    }
  }
  
  final class d
    implements com.google.android.exoplayer2.a.e, j.a, e.a, com.google.android.exoplayer2.video.e
  {
    private d() {}
    
    public final void a(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
    {
      AppMethodBeat.i(194489);
      ac.i("MicroMsg.SameLayer.ExoMediaPlayer", "onVideoSizeChanged, width:%d, height:%d, rotationDegrees:%d, ratio:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Float.valueOf(paramFloat) });
      c.this.mVideoWidth = paramInt1;
      c.this.mVideoHeight = paramInt2;
      c.this.dU(paramInt1, paramInt2);
      AppMethodBeat.o(194489);
    }
    
    public final void a(com.google.android.exoplayer2.b.d paramd)
    {
      AppMethodBeat.i(194483);
      ac.d("MicroMsg.SameLayer.ExoMediaPlayer", "onVideoEnabled");
      AppMethodBeat.o(194483);
    }
    
    public final void b(com.google.android.exoplayer2.b.d paramd)
    {
      AppMethodBeat.i(194484);
      ac.d("MicroMsg.SameLayer.ExoMediaPlayer", "onVideoDisabled");
      AppMethodBeat.o(194484);
    }
    
    public final void b(Metadata paramMetadata)
    {
      AppMethodBeat.i(194481);
      ac.d("MicroMsg.SameLayer.ExoMediaPlayer", "onMetadata");
      AppMethodBeat.o(194481);
    }
    
    public final void b(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(194485);
      ac.d("MicroMsg.SameLayer.ExoMediaPlayer", "onVideoDecoderInitialized");
      AppMethodBeat.o(194485);
    }
    
    public final void c(int paramInt, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(194479);
      ac.d("MicroMsg.SameLayer.ExoMediaPlayer", "onAudioTrackUnderrun");
      AppMethodBeat.o(194479);
    }
    
    public final void c(Surface paramSurface)
    {
      AppMethodBeat.i(194488);
      ac.i("MicroMsg.SameLayer.ExoMediaPlayer", "onRenderedFirstFrame");
      c.this.dW(3, 0);
      AppMethodBeat.o(194488);
    }
    
    public final void c(Format paramFormat)
    {
      AppMethodBeat.i(194486);
      ac.d("MicroMsg.SameLayer.ExoMediaPlayer", "onVideoInputFormatChanged");
      AppMethodBeat.o(194486);
    }
    
    public final void c(com.google.android.exoplayer2.b.d paramd)
    {
      AppMethodBeat.i(194475);
      ac.d("MicroMsg.SameLayer.ExoMediaPlayer", "onAudioEnabled");
      AppMethodBeat.o(194475);
    }
    
    public final void c(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(194477);
      ac.d("MicroMsg.SameLayer.ExoMediaPlayer", "onAudioDecoderInitialized");
      AppMethodBeat.o(194477);
    }
    
    public final void d(Format paramFormat)
    {
      AppMethodBeat.i(194478);
      ac.d("MicroMsg.SameLayer.ExoMediaPlayer", "onAudioInputFormatChanged");
      AppMethodBeat.o(194478);
    }
    
    public final void d(com.google.android.exoplayer2.b.d paramd)
    {
      AppMethodBeat.i(194480);
      ac.d("MicroMsg.SameLayer.ExoMediaPlayer", "onAudioDisabled");
      AppMethodBeat.o(194480);
    }
    
    public final void dH(int paramInt)
    {
      AppMethodBeat.i(194476);
      ac.d("MicroMsg.SameLayer.ExoMediaPlayer", "onAudioSessionId");
      AppMethodBeat.o(194476);
    }
    
    public final void h(int paramInt, long paramLong)
    {
      AppMethodBeat.i(194487);
      ac.d("MicroMsg.SameLayer.ExoMediaPlayer", "onDroppedFrames");
      AppMethodBeat.o(194487);
    }
    
    public final void s(List<com.google.android.exoplayer2.f.a> paramList)
    {
      AppMethodBeat.i(194482);
      ac.d("MicroMsg.SameLayer.ExoMediaPlayer", "onCues");
      AppMethodBeat.o(194482);
    }
  }
  
  static final class e
  {
    int[] kUl;
    
    private e()
    {
      AppMethodBeat.i(194490);
      this.kUl = new int[] { 1, 1, 1, 1 };
      AppMethodBeat.o(194490);
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
        int k = this.kUl.length - paramArrayOfInt.length;
        j = k;
        paramBoolean = true;
        label23:
        if (j >= this.kUl.length) {
          return paramBoolean;
        }
        if ((this.kUl[j] & i) != (paramArrayOfInt[(j - k)] & i)) {
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
      AppMethodBeat.i(194491);
      int i = s(paramBoolean, paramInt);
      ac.i("MicroMsg.SameLayer.ExoMediaPlayer", "request setMostRecentState [" + paramBoolean + "," + paramInt + "], lastState=" + this.kUl[3] + ", newState=" + i);
      if (this.kUl[3] == i)
      {
        AppMethodBeat.o(194491);
        return;
      }
      this.kUl[0] = this.kUl[1];
      this.kUl[1] = this.kUl[2];
      this.kUl[2] = this.kUl[3];
      this.kUl[3] = i;
      ac.i("MicroMsg.SameLayer.ExoMediaPlayer", "new MostRecentState [" + this.kUl[0] + "," + this.kUl[1] + "," + this.kUl[2] + "," + this.kUl[3] + "]");
      AppMethodBeat.o(194491);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c
 * JD-Core Version:    0.7.0.1
 */