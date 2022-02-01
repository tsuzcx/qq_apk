package com.tencent.luggage.k.a.a.b;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import com.tencent.luggage.k.a.a.a;
import com.tencent.luggage.k.a.a.b.b.c.a;
import com.tencent.luggage.k.a.a.b.b.f;
import com.tencent.luggage.k.a.a.l;
import com.tencent.luggage.k.a.a.m;
import com.tencent.luggage.k.a.a.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.h.b.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.aa.e.a.h.p;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g;
import com.tencent.mm.plugin.appbrand.jsapi.w;
import com.tencent.mm.plugin.appbrand.jsapi.z;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.n.n;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
  extends com.tencent.luggage.k.a.b.a
  implements com.tencent.luggage.k.a.a.h
{
  private w cjE;
  boolean ckA;
  boolean ckB;
  boolean ckC;
  com.tencent.mm.plugin.appbrand.jsapi.q.c ckD;
  String ckE;
  boolean ckH;
  AtomicBoolean ckJ;
  com.tencent.luggage.k.a.a.a ckK;
  com.tencent.luggage.k.a.a.b<d> ckL;
  public r ckN;
  boolean ckR;
  public boolean ckS;
  private com.tencent.luggage.k.a.a.h ckT;
  public AtomicBoolean ckU;
  volatile String ckV;
  volatile com.tencent.luggage.k.a.a.g ckW;
  volatile Bitmap ckX;
  public com.tencent.luggage.k.a.a cku;
  a.a ckv;
  public int ckw;
  public int ckx;
  public int cky;
  public int ckz;
  public com.tencent.mm.plugin.appbrand.jsapi.video.e.b cmS;
  public com.tencent.luggage.k.a.a.b.b.d cmT;
  public com.tencent.luggage.k.a.a.b.b.a cmU;
  public com.tencent.luggage.k.a.a.b.b.c cmV;
  public com.tencent.luggage.k.a.a.b.b.e cmW;
  public f cmX;
  public com.tencent.luggage.k.a.a.b.b.b cmY;
  volatile com.tencent.mm.plugin.appbrand.jsapi.aa.e.b cmZ;
  boolean cna;
  boolean cnb;
  boolean cnc;
  boolean cnd;
  long cne;
  boolean cnf;
  public boolean cng;
  volatile boolean cnh;
  boolean cni;
  boolean cnj;
  int cnk;
  int cnl;
  String cnm;
  String cnn;
  boolean cno;
  boolean cnp;
  private boolean cnq;
  private final ConcurrentLinkedQueue<Runnable> cnr;
  Handler cns;
  private HandlerThread cnt;
  volatile com.tencent.luggage.k.a.a cnu;
  public a cnv;
  public a cnw;
  public float cnx;
  public float cny;
  public Surface mSurface;
  public SurfaceTexture mSurfaceTexture;
  volatile String mTitle;
  int mVideoHeight;
  int mVideoWidth;
  
  public b()
  {
    AppMethodBeat.i(138972);
    this.cni = false;
    this.cnj = false;
    this.cky = 0;
    this.ckz = 0;
    this.cnq = false;
    this.ckH = false;
    this.ckJ = null;
    this.cnr = new ConcurrentLinkedQueue();
    this.cnu = null;
    this.ckD = null;
    this.ckE = null;
    this.cjE = new b.25(this);
    this.ckK = new com.tencent.luggage.k.a.a.a(this, this.cjE)
    {
      public final void a(String paramAnonymousString, com.tencent.luggage.k.a.a paramAnonymousa)
      {
        AppMethodBeat.i(178843);
        a(paramAnonymousa);
        paramAnonymousa = paramAnonymousa.EB();
        if ((paramAnonymousString.contains("insert")) || (paramAnonymousString.contains("update")))
        {
          if (paramAnonymousa.has("autoplay")) {
            this.cjF = paramAnonymousa.optBoolean("autoplay");
          }
          paramAnonymousString = z.D(paramAnonymousa);
          if (paramAnonymousString != null) {
            this.cjG = paramAnonymousString.booleanValue();
          }
        }
        for (;;)
        {
          ad.d(b.this.EE(), "mAutoRotationPluginHandlerCommons.handleJsApi, mIsNeedNotify: " + this.cjF + ", mIsAutoRotationEnabled: " + this.cjG);
          AppMethodBeat.o(178843);
          return;
          if (paramAnonymousString.contains("operate"))
          {
            paramAnonymousString = paramAnonymousa.optString("type");
            if ((!bt.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equalsIgnoreCase("play"))) {
              this.cjF = true;
            }
          }
          else if (paramAnonymousString.contains("remove"))
          {
            this.cjF = false;
          }
        }
      }
    };
    this.ckL = new com.tencent.luggage.k.a.a.b()
    {
      private d cnF = null;
      
      public final String EE()
      {
        AppMethodBeat.i(178844);
        String str = b.this.EE();
        AppMethodBeat.o(178844);
        return str;
      }
      
      public final int getId()
      {
        AppMethodBeat.i(178845);
        int i = b.this.getId();
        AppMethodBeat.o(178845);
        return i;
      }
      
      public final String getKey()
      {
        AppMethodBeat.i(178846);
        String str = b.this.getKey();
        AppMethodBeat.o(178846);
        return str;
      }
    };
    this.cnv = null;
    this.cnw = null;
    this.ckN = null;
    this.cnx = 1.0F;
    this.cny = 1.0F;
    this.ckR = false;
    this.ckS = false;
    this.ckT = new com.tencent.luggage.k.a.a.q();
    this.ckU = new AtomicBoolean(false);
    this.mTitle = null;
    this.ckV = null;
    this.ckW = null;
    this.ckX = null;
    this.cnt = com.tencent.e.c.d.gv(String.format("VideoThread_%s", new Object[] { Long.valueOf(System.currentTimeMillis()) }), 5);
    this.cnt.start();
    this.cns = new Handler(this.cnt.getLooper());
    AppMethodBeat.o(138972);
  }
  
  private void Fo()
  {
    AppMethodBeat.i(138975);
    synchronized (this.cnr)
    {
      if (this.cnr.isEmpty()) {
        break label102;
      }
      ad.i(EE(), "flushPendingTasks, size:%d", new Object[] { Integer.valueOf(this.cnr.size()) });
      Iterator localIterator = this.cnr.iterator();
      if (localIterator.hasNext()) {
        ((Runnable)localIterator.next()).run();
      }
    }
    this.cnr.clear();
    label102:
    AppMethodBeat.o(138975);
  }
  
  private void Fu()
  {
    AppMethodBeat.i(138996);
    if (this.cmS != null)
    {
      ad.i(EE(), "releaseMediaPlayer");
      this.cmS.a(null);
      this.cmS.a(null);
      this.cmS.a(null);
      this.cmS.a(null);
      this.cmS.a(null);
      this.cmS.a(null);
      this.cmS.stop();
      this.cmS.reset();
      this.cmS.release();
    }
    this.cmS = null;
    this.cnh = false;
    AppMethodBeat.o(138996);
  }
  
  private void Fv()
  {
    AppMethodBeat.i(138998);
    if (this.cmS != null)
    {
      this.cmS.setMute(this.cnj);
      if (this.mSurface != null)
      {
        boolean bool = this.ckU.get();
        if ((!this.cnp) && (!bool))
        {
          ad.i(EE(), "applyMediaPlayerParams, setSurface");
          this.cmS.setSurface(this.mSurface);
          AppMethodBeat.o(138998);
          return;
        }
        ad.i(EE(), "applyMediaPlayerParams, setSurface, WebViewInBackground: %b, JustPlayAudio: %b", new Object[] { Boolean.valueOf(this.cnp), Boolean.valueOf(bool) });
      }
    }
    AppMethodBeat.o(138998);
  }
  
  private void Fw()
  {
    AppMethodBeat.i(138999);
    if (this.mSurface != null)
    {
      this.mSurface.release();
      this.mSurface = null;
    }
    AppMethodBeat.o(138999);
  }
  
  public final String EE()
  {
    AppMethodBeat.i(138973);
    String str = String.format("%s(%s)", new Object[] { "MicroMsg.SameLayer.VideoPluginHandler", AL() });
    AppMethodBeat.o(138973);
    return str;
  }
  
  public final void EY()
  {
    AppMethodBeat.i(138976);
    k(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(138965);
        b.a(b.this);
        AppMethodBeat.o(138965);
      }
    });
    AppMethodBeat.o(138976);
  }
  
  /* Error */
  final boolean Fa()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 491	com/tencent/luggage/k/a/a/b/b:ckA	Z
    //   6: ifeq +18 -> 24
    //   9: aload_0
    //   10: getfield 493	com/tencent/luggage/k/a/a/b/b:cmT	Lcom/tencent/luggage/k/a/a/b/b/d;
    //   13: astore_2
    //   14: aload_2
    //   15: ifnull +9 -> 24
    //   18: iconst_1
    //   19: istore_1
    //   20: aload_0
    //   21: monitorexit
    //   22: iload_1
    //   23: ireturn
    //   24: iconst_0
    //   25: istore_1
    //   26: goto -6 -> 20
    //   29: astore_2
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_2
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	b
    //   19	7	1	bool	boolean
    //   13	2	2	locald	com.tencent.luggage.k.a.a.b.b.d
    //   29	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	29	finally
  }
  
  public final void Fc()
  {
    AppMethodBeat.i(195010);
    k(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(177151);
        if ((b.this.cmS != null) && (!b.this.cmS.isPlaying())) {
          b.this.i(false, true);
        }
        AppMethodBeat.o(177151);
      }
    });
    AppMethodBeat.o(195010);
  }
  
  final boolean Fd()
  {
    AppMethodBeat.i(195014);
    if (this.cku == null)
    {
      ad.w(EE(), "amIBackgroundAudioPlayer, mInsertInvokeContext is null");
      AppMethodBeat.o(195014);
      return false;
    }
    com.tencent.mm.plugin.appbrand.jsapi.aa.a locala = com.tencent.luggage.k.a.a.e.g(this.cku);
    if (locala == null)
    {
      ad.w(EE(), "amIBackgroundAudioPlayer, audioOfVideoBackgroundPlayManager is null");
      AppMethodBeat.o(195014);
      return false;
    }
    boolean bool = locala.a(this);
    AppMethodBeat.o(195014);
    return bool;
  }
  
  public final boolean Fn()
  {
    AppMethodBeat.i(177165);
    if ((this.ckJ != null) && (this.ckJ.get()))
    {
      AppMethodBeat.o(177165);
      return true;
    }
    AppMethodBeat.o(177165);
    return false;
  }
  
  final void Fp()
  {
    AppMethodBeat.i(138979);
    if ((this.cmS != null) && (this.mSurfaceTexture != null))
    {
      int i = this.cmS.getVideoWidth();
      int j = this.cmS.getVideoHeight();
      if ((i == 0) && (j == 0))
      {
        ad.w(EE(), "VideoCanvas, registerMediaPlayer, width or height is 0");
        AppMethodBeat.o(138979);
        return;
      }
      if (!this.cnq)
      {
        this.cnq = true;
        com.tencent.mm.plugin.appbrand.j.a.aVW().a(getId(), this, this.mSurfaceTexture, i, j, this.cku.getAppId());
        AppMethodBeat.o(138979);
        return;
      }
      ad.w(EE(), "VideoCanvas, registerMediaPlayer, already registered");
      AppMethodBeat.o(138979);
      return;
    }
    ad.w(EE(), "VideoCanvas, registerMediaPlayer, media player or surface texture is null");
    AppMethodBeat.o(138979);
  }
  
  final boolean Fq()
  {
    AppMethodBeat.i(178849);
    Object localObject;
    if ((this.cku instanceof com.tencent.mm.plugin.appbrand.i.b))
    {
      localObject = this.cku.Dj();
      if ((localObject instanceof aa)) {
        localObject = (aa)localObject;
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        localObject = ((aa)localObject).getRuntime();
        ad.i(EE(), "cancelResumePlayingWhenRelaunch:%s", new Object[] { Boolean.valueOf(((AppBrandRuntime)localObject).iDN) });
        boolean bool = ((AppBrandRuntime)localObject).iDN;
        AppMethodBeat.o(178849);
        return bool;
        if ((localObject instanceof com.tencent.mm.plugin.appbrand.q)) {
          localObject = ((com.tencent.mm.plugin.appbrand.q)localObject).getCurrentPageView();
        }
      }
      else
      {
        AppMethodBeat.o(178849);
        return false;
      }
      localObject = null;
    }
  }
  
  final void Fr()
  {
    AppMethodBeat.i(138983);
    if (!bt.isNullOrNil(this.cnn))
    {
      if ((this.cng) && (FI() != null) && (this.cmX != null))
      {
        if (this.cmX.a(this.cnn, this.ckw, this.ckx, this.mVideoWidth, this.mVideoHeight))
        {
          this.cnx = this.cmX.FG();
          this.cny = this.cmX.FH();
          ad.i(EE(), "adjust objectFit:%s, scale:[%s, %s]", new Object[] { this.cnn, Float.valueOf(this.cnx), Float.valueOf(this.cny) });
          com.tencent.luggage.k.a.d.a(FI(), this.type, getId(), this.cnx, this.cny);
          AppMethodBeat.o(138983);
        }
      }
      else
      {
        ad.i(EE(), "adjust objectFit, video not prepared");
        AppMethodBeat.o(138983);
      }
    }
    else {
      ad.i(EE(), "adjust objectFit, no video objectFit");
    }
    AppMethodBeat.o(138983);
  }
  
  public final void Fs()
  {
    AppMethodBeat.i(195011);
    k(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(177152);
        b.this.pause();
        AppMethodBeat.o(177152);
      }
    });
    AppMethodBeat.o(195011);
  }
  
  final boolean Ft()
  {
    AppMethodBeat.i(138987);
    if (this.cmS != null)
    {
      if (this.cmY != null) {
        this.cmY.a(this.cku, this.cmS);
      }
      if (!this.cng)
      {
        ad.i(EE(), "video stop, video not prepared yet, stop video when prepared");
        this.cnd = false;
        AppMethodBeat.o(138987);
        return true;
      }
      ad.i(EE(), "video stop");
      this.cmS.stop();
      if (Fa()) {
        this.cmT.bK(true);
      }
      AppMethodBeat.o(138987);
      return true;
    }
    AppMethodBeat.o(138987);
    return false;
  }
  
  public final int Fx()
  {
    AppMethodBeat.i(177169);
    int i = (int)(this.cky + (1.0F - this.cnx) * this.ckw / 2.0F);
    ad.d(EE(), "getVideoPositionX, videoPosX: ".concat(String.valueOf(i)));
    AppMethodBeat.o(177169);
    return i;
  }
  
  public final int Fy()
  {
    AppMethodBeat.i(177170);
    int i = (int)(this.ckz + (1.0F - this.cny) * this.ckx / 2.0F);
    ad.d(EE(), "getVideoPositionY, videoPosY: ".concat(String.valueOf(i)));
    AppMethodBeat.o(177170);
    return i;
  }
  
  public final <AddOn extends com.tencent.luggage.k.a.a.i> AddOn U(Class<AddOn> paramClass)
  {
    AppMethodBeat.i(195018);
    ad.i(EE(), "getAddOn for " + paramClass.getSimpleName());
    paramClass = this.ckT.U(paramClass);
    AppMethodBeat.o(195018);
    return paramClass;
  }
  
  final void a(com.tencent.mm.plugin.appbrand.jsapi.o.b.a parama)
  {
    AppMethodBeat.i(177167);
    ad.i(EE(), "video release");
    if (this.cmY != null) {
      this.cmY.x(this.cku);
    }
    if ((com.tencent.mm.plugin.appbrand.jsapi.o.b.a.kgZ != parama) && (com.tencent.mm.plugin.appbrand.jsapi.o.b.a.kha != parama))
    {
      Ft();
      Fu();
    }
    if (this.cmT != null)
    {
      this.cmT.destroy();
      this.cmT = null;
      this.cmU = null;
    }
    if (this.cmZ != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.aa.e.b localb = this.cmZ;
      localb.bfi().destroy();
      localb.kAo = false;
      localb.gt(false);
      localb.bfi().bfr();
      this.cmZ = null;
    }
    Fw();
    if (this.cku != null)
    {
      this.cku.ED();
      this.ckv = null;
    }
    if ((com.tencent.mm.plugin.appbrand.jsapi.o.b.a.kgZ != parama) && (com.tencent.mm.plugin.appbrand.jsapi.o.b.a.kha != parama))
    {
      ad.i(EE(), "video release handler thread");
      if (this.cns != null) {
        this.cns.removeCallbacksAndMessages(null);
      }
      if (this.cnt != null) {
        this.cnt.quitSafely();
      }
    }
    AppMethodBeat.o(177167);
  }
  
  public final <AddOn extends com.tencent.luggage.k.a.a.i> void a(Class<AddOn> paramClass, AddOn paramAddOn)
  {
    AppMethodBeat.i(195017);
    ad.i(EE(), "setAddOn for " + paramClass.getSimpleName());
    this.ckT.a(paramClass, paramAddOn);
    AppMethodBeat.o(195017);
  }
  
  final String b(com.tencent.luggage.k.a.a parama, String paramString)
  {
    AppMethodBeat.i(138982);
    String str = paramString;
    if (this.cmY != null) {
      str = this.cmY.b(parama, paramString);
    }
    AppMethodBeat.o(138982);
    return str;
  }
  
  final void b(com.tencent.luggage.k.a.a parama, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(138981);
    if (!paramJSONObject.has("enableCasting"))
    {
      AppMethodBeat.o(138981);
      return;
    }
    boolean bool = paramJSONObject.optBoolean("enableCasting");
    ad.d(EE(), "isEnableVideoCast = ".concat(String.valueOf(bool)));
    q(parama);
    this.cmZ.kAn = bool;
    AppMethodBeat.o(138981);
  }
  
  final void bF(boolean paramBoolean)
  {
    AppMethodBeat.i(195009);
    if (this.cmS != null)
    {
      ad.i(EE(), "video prepare async");
      if ((paramBoolean) && (Fa())) {
        this.cmT.onVideoWaiting();
      }
      this.cng = false;
      this.cnd = false;
      if (this.cmY != null) {
        this.cmY.c(this.cmS);
      }
      this.cmS.prepareAsync();
    }
    AppMethodBeat.o(195009);
  }
  
  public final void e(final SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(138974);
    k(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(138945);
        b.a(b.this, paramSurfaceTexture);
        AppMethodBeat.o(138945);
      }
    });
    AppMethodBeat.o(138974);
  }
  
  public final boolean f(Surface paramSurface)
  {
    AppMethodBeat.i(195013);
    if (this.cmS != null)
    {
      if (!this.ckU.get()) {
        this.cmS.setSurface(paramSurface);
      }
      for (;;)
      {
        AppMethodBeat.o(195013);
        return true;
        ad.i(EE(), "setSurface, JustPlayAudio");
      }
    }
    ad.w(EE(), "setSurface, MediaPlayer is null");
    AppMethodBeat.o(195013);
    return false;
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(138990);
    if (this.cmS != null)
    {
      int i = this.cmS.getCurrentPosition();
      AppMethodBeat.o(138990);
      return i;
    }
    AppMethodBeat.o(138990);
    return 0;
  }
  
  final int getDuration()
  {
    AppMethodBeat.i(138991);
    if (this.cmS != null)
    {
      int i = this.cmS.getDuration();
      AppMethodBeat.o(138991);
      return i;
    }
    AppMethodBeat.o(138991);
    return 0;
  }
  
  public final String getKey()
  {
    AppMethodBeat.i(177168);
    String str = AL() + "@" + hashCode();
    AppMethodBeat.o(177168);
    return str;
  }
  
  public final String getName()
  {
    AppMethodBeat.i(195016);
    String str = getKey();
    AppMethodBeat.o(195016);
    return str;
  }
  
  public final boolean h(com.tencent.luggage.k.a.a parama)
  {
    return true;
  }
  
  public final String i(final com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(138977);
    k(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(138966);
        b localb = b.this;
        com.tencent.luggage.k.a.a locala = parama;
        String str = locala.EC();
        if (!bt.isNullOrNil(str))
        {
          localObject1 = locala.EB();
          ad.i(localb.EE(), "*** handler(%s) handleJsApi(%s), data:%s", new Object[] { localb.AL(), str, ((JSONObject)localObject1).toString() });
          if (!str.contains("insert")) {
            break label1027;
          }
          localb.cku = locala;
          if (localb.cmS == null)
          {
            ad.w(localb.EE(), "insert, media player is null");
            localb.s(localb.cku);
          }
          localObject1 = null;
        }
        try
        {
          localObject2 = com.tencent.mm.plugin.appbrand.jsapi.o.c.a(new com.tencent.mm.ac.i(locala.EB().toString()));
          localObject1 = localObject2;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Object localObject2;
            continue;
            int j = 0;
          }
        }
        localb.ckv = new b.5(localb, (com.tencent.mm.plugin.appbrand.jsapi.o.b.a)localObject1);
        locala.a(localb.ckv);
        if (localb.cmY != null) {
          localb.cmY.w(locala);
        }
        if ((localb.mSurface != null) && (localb.cmS != null))
        {
          ad.i(localb.EE(), "insert, setSurface");
          localb.cmS.setSurface(localb.mSurface);
        }
        Object localObject1 = locala.EB();
        localb.cnf = ((JSONObject)localObject1).optBoolean("autoplay", false);
        if (localb.cnf) {
          localb.ckL.b(locala);
        }
        localb.cne = ((((JSONObject)localObject1).optDouble("initialTime", 0.0D) * 1000.0D));
        localb.cni = ((JSONObject)localObject1).optBoolean("loop", false);
        localb.cnj = ((JSONObject)localObject1).optBoolean("muted", false);
        localb.cmS.setMute(localb.cnj);
        localb.ckB = ((JSONObject)localObject1).optBoolean("autoPauseIfNavigate", true);
        localb.ckC = ((JSONObject)localObject1).optBoolean("autoPauseIfOpenNative", true);
        localb.ckA = ((JSONObject)localObject1).optBoolean("needEvent", false);
        if ((localb.ckA) && (localb.cmT != null))
        {
          localb.cmT.n(locala);
          localObject2 = ((JSONObject)localObject1).optString("data", "");
          localb.cmT.cI((String)localObject2);
          if (localb.cmU != null)
          {
            localb.cmU.n(locala);
            localb.cmU.cI((String)localObject2);
          }
        }
        if (((JSONObject)localObject1).has("position"))
        {
          localObject2 = ((JSONObject)localObject1).optJSONObject("position");
          if (localObject2 != null)
          {
            localb.ckw = com.tencent.mm.plugin.appbrand.aa.g.um(((JSONObject)localObject2).optInt("width", 0));
            localb.ckx = com.tencent.mm.plugin.appbrand.aa.g.um(((JSONObject)localObject2).optInt("height", 0));
            ad.i(localb.EE(), "insert, size:[%d, %d]", new Object[] { Integer.valueOf(localb.ckw), Integer.valueOf(localb.ckx) });
          }
        }
        localb.cnn = ((JSONObject)localObject1).optString("objectFit", "contain");
        if (bt.isNullOrNil(localb.cnn)) {
          localb.cnn = "contain";
        }
        localb.Fr();
        localObject2 = locala.Dj();
        if (localObject2 == null)
        {
          ad.w(localb.EE(), "updateReferrers, component is null");
          localb.cnm = ((JSONObject)localObject1).optString("filePath");
          if (!bt.isNullOrNil(localb.cnm))
          {
            if (localb.cmY != null) {
              localb.cmY.a(localb.cmS, localb.cnm);
            }
            localObject2 = localb.b(locala, localb.cnm);
            ad.i(localb.EE(), "insert, path:%s, proxy:%s", new Object[] { localb.cnm, localObject2 });
            if (!bt.isNullOrNil((String)localObject2))
            {
              localb.cmS.dp((String)localObject2, localb.ckE);
              ad.i(localb.EE(), "insert, media player prepare async");
              localb.bF(true);
            }
          }
          localb.mTitle = ((JSONObject)localObject1).optString("title", localb.mTitle);
          localb.ckV = ((JSONObject)localObject1).optString("backgroundPoster", localb.ckV);
          localb.b(locala, (JSONObject)localObject1);
          locala.cD("ok");
          label812:
          localb.ckK.a(str, locala);
          if (localb.cnm == null) {
            break label4099;
          }
        }
        label4099:
        for (localObject1 = localb.cnm;; localObject1 = "")
        {
          localb.ckL.a(locala, (String)localObject1);
          AppMethodBeat.o(138966);
          return;
          Object localObject3 = (com.tencent.mm.plugin.appbrand.jsapi.q.a)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.q.a.class);
          if (localObject3 == null)
          {
            ad.w(localb.EE(), "updateReferrers, referrerHelper is null");
            break;
          }
          if (localb.ckD == null) {
            localb.ckD = ((com.tencent.mm.plugin.appbrand.jsapi.q.a)localObject3).bbJ();
          }
          Object localObject4 = ((com.tencent.mm.plugin.appbrand.jsapi.q.a)localObject3).a((JSONObject)localObject1, (com.tencent.mm.plugin.appbrand.jsapi.c)localObject2);
          if (localObject4 != null) {
            localb.ckD = ((com.tencent.mm.plugin.appbrand.jsapi.q.c)localObject4);
          }
          ad.i(localb.EE(), "updateReferrers, mReferrerPolicy: " + localb.ckD);
          if (com.tencent.mm.plugin.appbrand.jsapi.q.c.khR == localb.ckD)
          {
            localb.ckE = null;
            break;
          }
          localb.ckE = ((com.tencent.mm.plugin.appbrand.jsapi.q.a)localObject3).y((com.tencent.mm.plugin.appbrand.jsapi.c)localObject2);
          ad.i(localb.EE(), "updateReferrers, mReferrer: " + localb.ckE);
          break;
          label1027:
          boolean bool1;
          if (str.contains("update"))
          {
            if (localb.cmS == null)
            {
              ad.w(localb.EE(), "update, media player is null");
              locala.cD("fail");
              break label812;
            }
            localObject1 = locala.EB();
            if (!((JSONObject)localObject1).has("filePath")) {
              break label4111;
            }
            localObject2 = ((JSONObject)localObject1).optString("filePath");
            if ((bt.isNullOrNil((String)localObject2)) || (((String)localObject2).equalsIgnoreCase(localb.cnm))) {
              break label4111;
            }
            localb.cnm = ((String)localObject2);
            localObject2 = localb.b(locala, localb.cnm);
            ad.i(localb.EE(), "update, path:%s, proxy:%s", new Object[] { localb.cnm, localObject2 });
            if ((localb.cmS == null) || (!bt.isNullOrNil((String)localObject2)))
            {
              localb.cno = false;
              localb.Ft();
              localb.r(locala);
            }
            if (localb.cmY != null) {
              localb.cmY.a(localb.cmS, localb.cnm);
            }
            localb.cmS.dp((String)localObject2, localb.ckE);
            j = 1;
            if ((localb.mSurface != null) && (localb.cmS != null))
            {
              bool1 = localb.ckU.get();
              if ((!localb.cnp) && (!bool1))
              {
                ad.i(localb.EE(), "update, setSurface");
                localb.cmS.setSurface(localb.mSurface);
              }
            }
            else
            {
              label1319:
              if (((JSONObject)localObject1).has("autoplay"))
              {
                localb.cnf = ((JSONObject)localObject1).optBoolean("autoplay", localb.cnf);
                if (localb.cnf) {
                  localb.ckL.b(locala);
                }
              }
              if (((JSONObject)localObject1).has("initialTime")) {
                localb.cne = ((((JSONObject)localObject1).optDouble("initialTime", 0.0D) * 1000.0D));
              }
              if (((JSONObject)localObject1).has("loop")) {
                localb.cni = ((JSONObject)localObject1).optBoolean("loop", localb.cni);
              }
              if (((JSONObject)localObject1).has("muted"))
              {
                localb.cnj = ((JSONObject)localObject1).optBoolean("muted", localb.cnj);
                localb.cmS.setMute(localb.cnj);
              }
              if (((JSONObject)localObject1).has("autoPauseIfNavigate")) {
                localb.ckB = ((JSONObject)localObject1).optBoolean("autoPauseIfNavigate", localb.ckB);
              }
              if (((JSONObject)localObject1).has("autoPauseIfOpenNative")) {
                localb.ckC = ((JSONObject)localObject1).optBoolean("autoPauseIfOpenNative", localb.ckC);
              }
              if (((JSONObject)localObject1).has("needEvent")) {
                localb.ckA = ((JSONObject)localObject1).optBoolean("needEvent", localb.ckA);
              }
              if ((localb.ckA) && (localb.cmT != null))
              {
                localb.cmT.n(locala);
                localObject2 = ((JSONObject)localObject1).optString("data", "");
                if (((JSONObject)localObject1).has("data")) {
                  localb.cmT.cI((String)localObject2);
                }
                if (localb.cmU != null)
                {
                  if (((JSONObject)localObject1).has("data")) {
                    localb.cmU.cI((String)localObject2);
                  }
                  localb.cmU.n(locala);
                }
              }
              int i = 0;
              if (((JSONObject)localObject1).has("position"))
              {
                localObject2 = ((JSONObject)localObject1).optJSONObject("position");
                if (localObject2 != null)
                {
                  localb.ckw = com.tencent.mm.plugin.appbrand.aa.g.um(((JSONObject)localObject2).optInt("width", localb.ckw));
                  localb.ckx = com.tencent.mm.plugin.appbrand.aa.g.um(((JSONObject)localObject2).optInt("height", localb.ckx));
                  ad.i(localb.EE(), "update, size:[%d, %d]", new Object[] { Integer.valueOf(localb.ckw), Integer.valueOf(localb.ckx) });
                }
                i = 1;
              }
              if (((JSONObject)localObject1).has("objectFit"))
              {
                localb.cnn = ((JSONObject)localObject1).optString("objectFit", localb.cnn);
                if (bt.isNullOrNil(localb.cnn)) {
                  localb.cnn = "contain";
                }
                i = 1;
              }
              if (i != 0) {
                localb.Fr();
              }
              localb.b(locala, (JSONObject)localObject1);
              localObject2 = ((JSONObject)localObject1).optString("filePath");
              if ((localb.cmZ != null) && (localb.cmZ.bfh()))
              {
                localObject3 = localb.cmZ;
                d.g.b.k.h(localObject2, "updateVideoPath");
                ad.i("MicroMsg.VideoCast.AppBrandVideoCastHandler", "updateVideoPath: [" + (String)localObject2 + ']');
                if (!n.aC((CharSequence)n.trim((CharSequence)localObject2).toString()))
                {
                  ((com.tencent.mm.plugin.appbrand.jsapi.aa.e.b)localObject3).bfi().bfr();
                  if (!d.g.b.k.g(localObject2, ((com.tencent.mm.plugin.appbrand.jsapi.aa.e.b)localObject3).videoPath))
                  {
                    ((com.tencent.mm.plugin.appbrand.jsapi.aa.e.b)localObject3).setVideoPath((String)localObject2);
                    ((com.tencent.mm.plugin.appbrand.jsapi.aa.e.b)localObject3).gt(true);
                    ((com.tencent.mm.plugin.appbrand.jsapi.aa.e.b)localObject3).bfi().n((d.g.a.b)new com.tencent.mm.plugin.appbrand.jsapi.aa.e.b.f((com.tencent.mm.plugin.appbrand.jsapi.aa.e.b)localObject3));
                    if (((com.tencent.mm.plugin.appbrand.jsapi.aa.e.b)localObject3).bfi().dvJ != -1) {
                      break label2096;
                    }
                    ((com.tencent.mm.plugin.appbrand.jsapi.aa.e.b)localObject3).bfi().dvJ = 8;
                  }
                }
              }
            }
            for (;;)
            {
              localb.mTitle = ((JSONObject)localObject1).optString("title", localb.mTitle);
              localb.ckV = ((JSONObject)localObject1).optString("backgroundPoster", localb.ckV);
              if (j != 0)
              {
                ad.i(localb.EE(), "update, media player prepare async");
                localb.bF(true);
              }
              locala.cD("ok");
              break;
              ad.i(localb.EE(), "update, setSurface, WebViewInBackground: %b, JustPlayAudio: %b", new Object[] { Boolean.valueOf(localb.cnp), Boolean.valueOf(bool1) });
              break label1319;
              label2096:
              ad.i("MicroMsg.VideoCast.AppBrandVideoCastHandler", "discard a updateVideoPath report event");
            }
          }
          boolean bool2;
          if ((str.contains("operate")) && (str.contains("Background")))
          {
            if (localb.cmS == null)
            {
              ad.w(localb.EE(), "operateBackground, media player is null");
              locala.cD("fail");
              break label812;
            }
            localObject1 = locala.EB();
            bool1 = false;
            localObject1 = ((JSONObject)localObject1).optString("type");
            if (bt.isNullOrNil((String)localObject1)) {
              break label812;
            }
            ad.i(localb.EE(), "operateBackground, type:%s", new Object[] { localObject1 });
            if (((String)localObject1).equalsIgnoreCase("stop"))
            {
              bool2 = localb.t(locala);
              bool1 = bool2;
              if (bool2)
              {
                bool1 = bool2;
                if (localb.ckH)
                {
                  ad.i(localb.EE(), "operateBackground, isRuntimeInBackground, setPlayingWhenEnterBackground false");
                  localb.ckJ = new AtomicBoolean(false);
                  bool1 = bool2;
                }
              }
            }
            if (bool1) {}
            for (localObject1 = "ok";; localObject1 = "fail")
            {
              locala.cD((String)localObject1);
              break;
            }
          }
          if (str.contains("operate"))
          {
            if (localb.cmS == null)
            {
              ad.w(localb.EE(), "operate, media player is null");
              locala.cD("fail");
              break label812;
            }
            localObject3 = locala.EB();
            bool2 = false;
            localObject2 = ((JSONObject)localObject3).optString("type");
            if (bt.isNullOrNil((String)localObject2)) {
              break label812;
            }
            ad.i(localb.EE(), "operate, type:%s", new Object[] { localObject2 });
            if (((String)localObject2).equalsIgnoreCase("startCasting"))
            {
              bool1 = true;
              label2421:
              if (!bool1) {
                break label3145;
              }
              ad.i(localb.EE(), "video cast operate, type:%s", new Object[] { localObject2 });
              if (localb.cmZ == null) {
                localb.q(locala);
              }
              localb.cmZ.setVideoPath(localb.cnm);
              localb.cmZ.kAi = localb.getCurrentPosition();
              if (!((String)localObject2).equalsIgnoreCase("requestFullScreen")) {
                break label2621;
              }
              bool1 = localb.k(locala);
              label2507:
              if (!((String)localObject2).equalsIgnoreCase("snapshot")) {
                break label4003;
              }
              ad.i(localb.EE(), "getSnapshotCached");
              if (localb.cmY != null) {
                break label3988;
              }
              locala.cD("fail:snapshot error");
            }
            for (;;)
            {
              if ((!((String)localObject2).equalsIgnoreCase("startCasting")) && (!((String)localObject2).equalsIgnoreCase("pause")) && (!((String)localObject2).equalsIgnoreCase("stop"))) {
                break label4034;
              }
              localb.ckL.c(locala);
              break;
              if (localb.cmZ == null)
              {
                bool1 = false;
                break label2421;
              }
              bool1 = localb.cmZ.bfh();
              break label2421;
              label2621:
              if (((String)localObject2).equalsIgnoreCase("exitFullScreen"))
              {
                bool1 = localb.l(locala);
                break label2507;
              }
              localObject1 = localb.cmZ;
              d.g.b.k.h(localObject3, "data");
              d.g.b.k.h(locala, "invokeContext");
              localObject4 = ((JSONObject)localObject3).optString("type");
              ad.i("MicroMsg.VideoCast.AppBrandVideoCastHandler", "handleOperate: type = ".concat(String.valueOf(localObject4)));
              if (localObject4 == null)
              {
                bool1 = true;
                break label2507;
              }
              switch (((String)localObject4).hashCode())
              {
              }
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      for (;;)
                      {
                        bool1 = true;
                        break;
                        if (((String)localObject4).equals("play"))
                        {
                          com.tencent.mm.plugin.appbrand.jsapi.aa.e.a.h.b(((com.tencent.mm.plugin.appbrand.jsapi.aa.e.b)localObject1).bfi());
                          bool1 = true;
                          break;
                          if (((String)localObject4).equals("reconnectCasting"))
                          {
                            localObject3 = ((com.tencent.mm.plugin.appbrand.jsapi.aa.e.b)localObject1).kAl;
                            if (localObject3 != null) {
                              ((com.tencent.mm.plugin.appbrand.jsapi.aa.e.a.c)localObject3).sw(5);
                            }
                            localObject1 = ((com.tencent.mm.plugin.appbrand.jsapi.aa.e.b)localObject1).bfi();
                            if (((com.tencent.mm.plugin.appbrand.jsapi.aa.e.a.h)localObject1).kBx.bfs().aUM() != e.a.jiM) {
                              break label3119;
                            }
                            ((com.tencent.mm.plugin.appbrand.jsapi.aa.e.a.h)localObject1).kBX.bH(true);
                            bool1 = true;
                            break;
                            if (((String)localObject4).equals("exitCasting"))
                            {
                              localObject3 = ((com.tencent.mm.plugin.appbrand.jsapi.aa.e.b)localObject1).kAl;
                              if (localObject3 != null) {
                                ((com.tencent.mm.plugin.appbrand.jsapi.aa.e.a.c)localObject3).sw(6);
                              }
                              com.tencent.mm.plugin.appbrand.jsapi.aa.e.a.h.d(((com.tencent.mm.plugin.appbrand.jsapi.aa.e.b)localObject1).bfi());
                              ((com.tencent.mm.plugin.appbrand.jsapi.aa.e.b)localObject1).bfi().destroy();
                              ((com.tencent.mm.plugin.appbrand.jsapi.aa.e.b)localObject1).kAo = false;
                              ((com.tencent.mm.plugin.appbrand.jsapi.aa.e.b)localObject1).gt(false);
                            }
                          }
                        }
                      }
                    } while (!((String)localObject4).equals("startCasting"));
                    ((com.tencent.mm.plugin.appbrand.jsapi.aa.e.b)localObject1).bfi().kBO = ((d.g.a.a)new com.tencent.mm.plugin.appbrand.jsapi.aa.e.b.e((com.tencent.mm.plugin.appbrand.jsapi.aa.e.b)localObject1));
                    com.tencent.mm.plugin.appbrand.jsapi.aa.e.a.h.a(((com.tencent.mm.plugin.appbrand.jsapi.aa.e.b)localObject1).bfi());
                    bool1 = true;
                    break;
                  } while (!((String)localObject4).equals("switchCasting"));
                  localObject3 = ((com.tencent.mm.plugin.appbrand.jsapi.aa.e.b)localObject1).kAl;
                  if (localObject3 != null) {
                    ((com.tencent.mm.plugin.appbrand.jsapi.aa.e.a.c)localObject3).sw(4);
                  }
                  ((com.tencent.mm.plugin.appbrand.jsapi.aa.e.b)localObject1).bfi().w(false, true);
                  bool1 = true;
                  break;
                } while (!((String)localObject4).equals("seek"));
                long l = com.tencent.mm.plugin.appbrand.jsapi.aa.e.b.W((JSONObject)localObject3);
                if (l <= 0L) {
                  break label3104;
                }
                ((com.tencent.mm.plugin.appbrand.jsapi.aa.e.b)localObject1).bfi().JV(com.tencent.mm.plugin.appbrand.jsapi.aa.e.b.c.sv((int)l));
                bool1 = true;
                break;
              } while (!((String)localObject4).equals("pause"));
              com.tencent.mm.plugin.appbrand.jsapi.aa.e.a.h.c(((com.tencent.mm.plugin.appbrand.jsapi.aa.e.b)localObject1).bfi());
              bool1 = true;
              break label2507;
              label3104:
              ad.i("MicroMsg.VideoCast.AppBrandVideoCastHandler", "invalid seek position");
              bool1 = false;
              break label2507;
              label3119:
              ((com.tencent.mm.plugin.appbrand.jsapi.aa.e.a.h)localObject1).kBx.p((d.g.a.b)new h.p((com.tencent.mm.plugin.appbrand.jsapi.aa.e.a.h)localObject1));
              bool1 = true;
              break label2507;
              label3145:
              if (((String)localObject2).equalsIgnoreCase("play"))
              {
                bool1 = localb.i(false, true);
                break label2507;
              }
              if (((String)localObject2).equalsIgnoreCase("pause"))
              {
                bool1 = localb.pause();
                break label2507;
              }
              if (((String)localObject2).equalsIgnoreCase("stop"))
              {
                bool2 = localb.Ft();
                bool1 = bool2;
                if (!bool2) {
                  break label2507;
                }
                bool1 = bool2;
                if (!localb.ckH) {
                  break label2507;
                }
                ad.i(localb.EE(), "stop, isRuntimeInBackground, setPlayingWhenEnterBackground false");
                localb.ckJ = new AtomicBoolean(false);
                bool1 = bool2;
                break label2507;
              }
              label3332:
              double d;
              if (((String)localObject2).equalsIgnoreCase("seek"))
              {
                if ((localb.cmS != null) && (localObject3 != null) && (((JSONObject)localObject3).has("data")))
                {
                  localObject1 = ((JSONObject)localObject3).optJSONArray("data");
                  if ((localObject1 != null) && (((JSONArray)localObject1).length() != 0)) {
                    break label3332;
                  }
                  ad.w(localb.EE(), "seek, data array is null");
                }
                for (;;)
                {
                  bool1 = false;
                  break;
                  d = ((JSONArray)localObject1).optDouble(0, -1.0D);
                  if (d >= 0.0D) {
                    break label3373;
                  }
                  ad.w(localb.EE(), "seek, invalid position:%s", new Object[] { Double.valueOf(d) });
                }
                label3373:
                localb.seek((d * 1000.0D));
                bool1 = true;
                break label2507;
              }
              if (((String)localObject2).equalsIgnoreCase("playbackRate"))
              {
                if ((localb.cmS != null) && (localObject3 != null) && (((JSONObject)localObject3).has("data")))
                {
                  localObject1 = ((JSONObject)localObject3).optJSONArray("data");
                  if ((localObject1 != null) && (((JSONArray)localObject1).length() != 0)) {
                    break label3463;
                  }
                  ad.w(localb.EE(), "speed, data array is null");
                }
                for (;;)
                {
                  bool1 = false;
                  break;
                  label3463:
                  d = ((JSONArray)localObject1).optDouble(0, -1.0D);
                  if (d >= 0.0D) {
                    break label3504;
                  }
                  ad.w(localb.EE(), "speed, invalid rate:%s", new Object[] { Double.valueOf(d) });
                }
                label3504:
                ad.i(localb.EE(), "speed, speed:%s", new Object[] { Double.valueOf(d) });
                bool1 = localb.cmS.ay((float)d);
                break label2507;
              }
              if (((String)localObject2).equalsIgnoreCase("requestFullScreen"))
              {
                bool1 = localb.k(locala);
                break label2507;
              }
              if (((String)localObject2).equalsIgnoreCase("exitFullScreen"))
              {
                bool1 = localb.l(locala);
                break label2507;
              }
              if (((String)localObject2).equalsIgnoreCase("setScreenBrightness"))
              {
                ad.i(localb.EE(), "setScreenBrightness");
                if ((localb.cmY != null) && (localb.cmY.u(locala)))
                {
                  bool1 = true;
                  break label2507;
                }
                bool1 = false;
                break label2507;
              }
              if (((String)localObject2).equalsIgnoreCase("exitPictureInPicture"))
              {
                bool1 = localb.ckL.d(locala);
                break label2507;
              }
              if (((String)localObject2).equalsIgnoreCase("requestBackgroundPlayback"))
              {
                ad.d(localb.EE(), "enableBackgroundPlayAudio");
                if (!localb.ckR)
                {
                  ad.d(localb.EE(), "registerAddOnPlayAudio");
                  localb.a(l.class, new b.28(localb));
                  ad.d(localb.EE(), "registerAddOnVideoController");
                  localb.a(m.class, new b.29(localb));
                  ad.d(localb.EE(), "registerAddOnInfo");
                  localb.a(com.tencent.luggage.k.a.a.k.class, new b.30(localb));
                  ad.d(localb.EE(), "registerAddOnGetSnapshot");
                  localb.a(com.tencent.luggage.k.a.a.j.class, new b.32(localb));
                  localb.ckR = true;
                }
                ad.d(localb.EE(), "enableBackgroundPlayAudioInternal");
                if (locala == null)
                {
                  ad.w(localb.EE(), "enableBackgroundPlayAudioInternal, invokeContext is null");
                  bool1 = false;
                }
                for (;;)
                {
                  if (!bool1) {
                    break label3955;
                  }
                  localb.ckU.set(true);
                  if (localb.cmS != null) {
                    localb.cmS.setSurface(null);
                  }
                  localb.ckS = true;
                  if (localb.cmT != null) {
                    localb.cmT.bL(true);
                  }
                  bool1 = true;
                  break;
                  localObject1 = com.tencent.luggage.k.a.a.e.g(locala);
                  if (localObject1 == null)
                  {
                    ad.w(localb.EE(), "enableBackgroundPlayAudioInternal, audioOfVideoBackgroundPlayManager is null");
                    bool1 = false;
                  }
                  else
                  {
                    bool1 = ((com.tencent.mm.plugin.appbrand.jsapi.aa.a)localObject1).b(localb);
                  }
                }
                label3955:
                bool1 = false;
                break label2507;
              }
              bool1 = bool2;
              if (!((String)localObject2).equalsIgnoreCase("exitBackgroundPlayback")) {
                break label2507;
              }
              bool1 = localb.t(locala);
              break label2507;
              label3988:
              localb.cnu = locala;
              localb.takeScreenshot();
            }
            label4003:
            if (bool1) {}
            for (localObject1 = "ok";; localObject1 = "fail")
            {
              locala.cD((String)localObject1);
              break;
            }
            label4034:
            if (!((String)localObject2).equalsIgnoreCase("play")) {
              break label812;
            }
            localb.ckL.b(locala);
            break label812;
          }
          if (!str.contains("remove")) {
            break label812;
          }
          localb.a(null);
          locala.cD("ok");
          localb.ckL.c(locala);
          break label812;
        }
      }
    });
    AppMethodBeat.o(138977);
    return null;
  }
  
  final boolean i(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(177166);
    if (this.cmS != null)
    {
      if ((this.cng) && (this.cmS.isPlaying()))
      {
        ad.i(EE(), "video play, video is playing");
        if (Fa()) {
          this.cmT.bJ(paramBoolean1);
        }
        AppMethodBeat.o(177166);
        return true;
      }
      if ((this.cmS != null) && (!this.cng))
      {
        ad.i(EE(), "video play, video not prepared yet, start until prepared");
        this.cnd = true;
        AppMethodBeat.o(177166);
        return true;
      }
      if ((this.cmS != null) && (this.cmS.getState() == 5))
      {
        if (!paramBoolean2)
        {
          ad.i(EE(), "video has ended playing, do not restart");
          AppMethodBeat.o(177166);
          return false;
        }
        ad.i(EE(), "video play, video has stopped now, try prepare and start when prepared");
        bF(true);
        this.cnd = true;
        AppMethodBeat.o(177166);
        return true;
      }
      if (this.cno)
      {
        if (!paramBoolean2)
        {
          ad.i(EE(), "video has ended playing, do not restart");
          AppMethodBeat.o(177166);
          return false;
        }
        ad.i(EE(), "video play, video has ended playing, clear surface and start again");
        this.cno = false;
        try
        {
          if ((this.mSurfaceTexture != null) && (this.cng))
          {
            ad.i(EE(), "clearSurfaceTexture");
            Object localObject2 = this.mSurfaceTexture;
            localObject1 = (EGL10)EGLContext.getEGL();
            EGLDisplay localEGLDisplay = ((EGL10)localObject1).eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            ((EGL10)localObject1).eglInitialize(localEGLDisplay, null);
            Object localObject3 = new EGLConfig[1];
            int[] arrayOfInt = new int[1];
            ((EGL10)localObject1).eglChooseConfig(localEGLDisplay, new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344, 0, 12344 }, (EGLConfig[])localObject3, 1, arrayOfInt);
            arrayOfInt = localObject3[0];
            localObject3 = ((EGL10)localObject1).eglCreateContext(localEGLDisplay, arrayOfInt, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
            localObject2 = ((EGL10)localObject1).eglCreateWindowSurface(localEGLDisplay, arrayOfInt, localObject2, new int[] { 12344 });
            ((EGL10)localObject1).eglMakeCurrent(localEGLDisplay, (EGLSurface)localObject2, (EGLSurface)localObject2, (EGLContext)localObject3);
            GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
            GLES20.glClear(16384);
            ((EGL10)localObject1).eglSwapBuffers(localEGLDisplay, (EGLSurface)localObject2);
            ((EGL10)localObject1).eglDestroySurface(localEGLDisplay, (EGLSurface)localObject2);
            localObject2 = EGL10.EGL_NO_SURFACE;
            ((EGL10)localObject1).eglMakeCurrent(localEGLDisplay, (EGLSurface)localObject2, (EGLSurface)localObject2, EGL10.EGL_NO_CONTEXT);
            ((EGL10)localObject1).eglDestroyContext(localEGLDisplay, (EGLContext)localObject3);
            ((EGL10)localObject1).eglTerminate(localEGLDisplay);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Object localObject1;
            ad.printErrStackTrace(EE(), localException, "clearSurfaceTexture error", new Object[0]);
            continue;
            this.cmS.dp(this.cnm, this.ckE);
          }
        }
        r(this.cku);
        if (this.cmS != null)
        {
          this.cnf = true;
          localObject1 = b(this.cku, this.cnm);
          if (!bt.isNullOrNil((String)localObject1))
          {
            this.cmS.dp((String)localObject1, this.ckE);
            ad.i(EE(), "video play, media player state:%s", new Object[] { Integer.valueOf(this.cmS.getState()) });
            bF(false);
            this.cnd = true;
          }
        }
        else
        {
          AppMethodBeat.o(177166);
          return true;
        }
      }
      ad.i(EE(), "video play");
      if (this.cmS != null)
      {
        if (Fa()) {
          this.cmT.bJ(paramBoolean1);
        }
        this.cmS.start();
      }
      AppMethodBeat.o(177166);
      return true;
    }
    AppMethodBeat.o(177166);
    return false;
  }
  
  final boolean isPlaying()
  {
    AppMethodBeat.i(138989);
    if (this.cmS != null)
    {
      boolean bool = this.cmS.isPlaying();
      AppMethodBeat.o(138989);
      return bool;
    }
    AppMethodBeat.o(138989);
    return false;
  }
  
  final boolean k(com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(138993);
    ad.i(EE(), "requestFullscreen");
    if ((this.cmY != null) && (this.cmY.k(parama)))
    {
      AppMethodBeat.o(138993);
      return true;
    }
    AppMethodBeat.o(138993);
    return false;
  }
  
  public final boolean k(Runnable paramRunnable)
  {
    AppMethodBeat.i(138980);
    if (this.cns != null)
    {
      if (this.cns.getLooper() == Looper.myLooper()) {
        paramRunnable.run();
      }
      for (;;)
      {
        AppMethodBeat.o(138980);
        return true;
        this.cns.post(paramRunnable);
      }
    }
    AppMethodBeat.o(138980);
    return false;
  }
  
  final boolean l(com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(138994);
    ad.i(EE(), "exitFullscreen");
    if ((this.cmY != null) && (this.cmY.l(parama)))
    {
      AppMethodBeat.o(138994);
      return true;
    }
    AppMethodBeat.o(138994);
    return false;
  }
  
  final boolean pause()
  {
    AppMethodBeat.i(138986);
    if (this.cmS != null)
    {
      if (!this.cng)
      {
        ad.i(EE(), "video pause, video not prepared yet, pause video when prepared");
        this.cnd = false;
        AppMethodBeat.o(138986);
        return true;
      }
      if (!this.cmS.isPlaying())
      {
        ad.i(EE(), "video pause, video is not playing");
        AppMethodBeat.o(138986);
        return true;
      }
      ad.i(EE(), "video pause");
      this.cmS.pause();
      if (Fa()) {
        this.cmT.bK(false);
      }
      AppMethodBeat.o(138986);
      return true;
    }
    AppMethodBeat.o(138986);
    return false;
  }
  
  final void q(com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(138978);
    if (this.cmZ != null)
    {
      AppMethodBeat.o(138978);
      return;
    }
    this.cmZ = this.cmY.a(this.cmU, parama);
    AppMethodBeat.o(138978);
  }
  
  public final void r(Bitmap paramBitmap)
  {
    AppMethodBeat.i(178848);
    super.r(paramBitmap);
    ad.i(EE(), "*** handler(%s) handlePluginScreenshotTaken", new Object[] { AL() });
    Object localObject = this.cnu;
    int i;
    if (localObject == null)
    {
      ad.w(EE(), "handlePluginScreenshotTaken4JsApiCall, invokeContext is null");
      i = 0;
    }
    for (;;)
    {
      if (i == 0)
      {
        localObject = this.ckW;
        if (localObject == null)
        {
          ad.w(EE(), "handlePluginScreenshotTaken4NativeCall, getSnapshotCallback is null");
          AppMethodBeat.o(178848);
          return;
          if (paramBitmap == null)
          {
            ad.w(EE(), "handlePluginScreenshotTaken4JsApiCall, bitmap is null");
            i = 0;
            continue;
          }
          if ((this.ckw == 0) || (this.ckx == 0)) {
            break label265;
          }
        }
      }
    }
    label265:
    for (Bitmap localBitmap = Bitmap.createScaledBitmap(paramBitmap, (int)(this.cnx * this.ckw), (int)(this.cny * this.ckx), false);; localBitmap = paramBitmap)
    {
      this.cmY.a((com.tencent.luggage.k.a.a)localObject, localBitmap);
      this.cnu = null;
      i = 1;
      break;
      if (paramBitmap == null)
      {
        ad.w(EE(), "handlePluginScreenshotTaken4NativeCall, bitmap is null");
        ((com.tencent.luggage.k.a.a.g)localObject).o(null);
        AppMethodBeat.o(178848);
        return;
      }
      localBitmap = paramBitmap;
      if (this.ckw != 0)
      {
        localBitmap = paramBitmap;
        if (this.ckx != 0) {
          localBitmap = Bitmap.createScaledBitmap(paramBitmap, (int)(this.cnx * this.ckw), (int)(this.cny * this.ckx), false);
        }
      }
      ((com.tencent.luggage.k.a.a.g)localObject).o(localBitmap);
      this.ckW = null;
      AppMethodBeat.o(178848);
      return;
    }
  }
  
  final void r(com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(138995);
    Fu();
    s(parama);
    Fv();
    AppMethodBeat.o(138995);
  }
  
  final void s(com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(138997);
    ad.i(EE(), "createMediaPlayer");
    if (this.cmY != null) {
      this.cmS = this.cmY.a(parama, this.cns);
    }
    if (this.cmS == null)
    {
      ad.e(EE(), "createMediaPlayer, create media player fail");
      AppMethodBeat.o(138997);
      return;
    }
    this.cnh = true;
    this.cmS.a(new b.d()
    {
      public final boolean cb(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(194992);
        b localb = b.this;
        boolean bool = localb.k(new b.4(localb, paramAnonymousInt1, paramAnonymousInt2));
        AppMethodBeat.o(194992);
        return bool;
      }
    });
    this.cmS.a(new com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c()
    {
      public final boolean cc(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(194993);
        b localb = b.this;
        boolean bool = localb.k(new b.3(localb, paramAnonymousInt1, paramAnonymousInt2));
        AppMethodBeat.o(194993);
        return bool;
      }
    });
    this.cmS.a(new com.tencent.mm.plugin.appbrand.jsapi.video.e.b.e()
    {
      public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramAnonymousb)
      {
        AppMethodBeat.i(194994);
        paramAnonymousb = b.this;
        paramAnonymousb.k(new b.2(paramAnonymousb));
        AppMethodBeat.o(194994);
      }
    });
    this.cmS.a(new b.b()
    {
      public final void Fz()
      {
        AppMethodBeat.i(194995);
        b localb = b.this;
        localb.k(new b.38(localb));
        AppMethodBeat.o(194995);
      }
    });
    this.cmS.a(new com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f()
    {
      public final void b(com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramAnonymousb)
      {
        AppMethodBeat.i(194996);
        paramAnonymousb = b.this;
        paramAnonymousb.k(new b.37(paramAnonymousb));
        AppMethodBeat.o(194996);
      }
    });
    this.cmS.a(new b.g()
    {
      public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramAnonymousb, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(194997);
        paramAnonymousb = b.this;
        paramAnonymousb.k(new b.36(paramAnonymousb, paramAnonymousInt1, paramAnonymousInt2));
        AppMethodBeat.o(194997);
      }
    });
    this.cmS.a(new com.tencent.mm.plugin.appbrand.jsapi.video.e.b.a()
    {
      public final void gX(int paramAnonymousInt)
      {
        AppMethodBeat.i(194998);
        b localb = b.this;
        localb.k(new b.35(localb, paramAnonymousInt));
        AppMethodBeat.o(194998);
      }
    });
    if (this.cnv != null) {
      this.cnv.bG(this.cng);
    }
    AppMethodBeat.o(138997);
  }
  
  final void seek(long paramLong)
  {
    AppMethodBeat.i(138992);
    if ((this.cng) && (this.cmS != null))
    {
      if (Fa()) {
        this.cmT.onVideoWaiting();
      }
      if (this.cmS != null)
      {
        this.cnb = isPlaying();
        paramLong = Math.min(getDuration(), Math.max(0L, paramLong));
        ad.i(EE(), "seek, position:%s, isPlaying:%s, videoEndPlaying:%s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(this.cnb), Boolean.valueOf(this.cno) });
        this.cno = false;
        this.cmS.seekTo(paramLong);
        AppMethodBeat.o(138992);
      }
    }
    else
    {
      this.cne = paramLong;
    }
    AppMethodBeat.o(138992);
  }
  
  final boolean t(com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(195015);
    ad.d(EE(), "disableBackgroundPlayAudio");
    ad.d(EE(), "disableBackgroundPlayAudioInternal");
    int i;
    if (parama == null)
    {
      ad.w(EE(), "disableBackgroundPlayAudioInternal, invokeContext is null");
      i = 0;
    }
    while (i != 0)
    {
      this.ckU.set(false);
      if (this.cmS != null) {
        this.cmS.setSurface(this.mSurface);
      }
      this.ckS = false;
      if (this.cmT != null) {
        this.cmT.bL(false);
      }
      AppMethodBeat.o(195015);
      return true;
      parama = com.tencent.luggage.k.a.a.e.g(parama);
      if (parama == null)
      {
        ad.w(EE(), "disableBackgroundPlayAudio, audioOfVideoBackgroundPlayManager is null");
        i = 0;
      }
      else
      {
        parama.c(this);
        i = 1;
      }
    }
    AppMethodBeat.o(195015);
    return false;
  }
  
  final void takeScreenshot()
  {
    AppMethodBeat.i(195012);
    ad.i(EE(), "takeScreenshot");
    com.tencent.luggage.k.a.c.c localc = FI();
    String str = this.type;
    int i = getId();
    if ((localc != null) && (localc.FJ() != null))
    {
      ad.i("MicroMsg.SameLayer.WebViewExtendPluginUtil", "applyPluginScreenshot, %s#%d", new Object[] { str, Integer.valueOf(i) });
      localc.FJ().takePluginScreenshot(str, i);
    }
    AppMethodBeat.o(195012);
  }
  
  public static abstract interface a
  {
    public abstract void bG(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.k.a.a.b.b
 * JD-Core Version:    0.7.0.1
 */