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
import com.tencent.luggage.k.a.a.i;
import com.tencent.luggage.k.a.a.p;
import com.tencent.luggage.k.a.a.r;
import com.tencent.luggage.k.a.a.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.h.b.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.u;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g;
import com.tencent.mm.plugin.appbrand.jsapi.w;
import com.tencent.mm.plugin.appbrand.jsapi.z;
import com.tencent.mm.plugin.appbrand.jsapi.z.e.a.h.p;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
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
  implements p
{
  private w cgA;
  boolean chA;
  boolean chB;
  com.tencent.mm.plugin.appbrand.jsapi.p.c chC;
  String chD;
  boolean chG;
  AtomicBoolean chI;
  private p chK;
  com.tencent.luggage.k.a.a.a chM;
  com.tencent.luggage.k.a.a.b<d> chN;
  public com.tencent.luggage.k.a.a.n chP;
  boolean chT;
  public boolean chU;
  public AtomicBoolean chW;
  volatile String chX;
  volatile com.tencent.luggage.k.a.a.g chY;
  volatile Bitmap chZ;
  public com.tencent.luggage.k.a.a cht;
  a.a chu;
  public int chv;
  public int chw;
  public int chx;
  public int chy;
  boolean chz;
  public com.tencent.mm.plugin.appbrand.jsapi.video.e.b cjU;
  public com.tencent.luggage.k.a.a.b.b.d cjV;
  public com.tencent.luggage.k.a.a.b.b.a cjW;
  public com.tencent.luggage.k.a.a.b.b.c cjX;
  public com.tencent.luggage.k.a.a.b.b.e cjY;
  public f cjZ;
  public float ckA;
  public com.tencent.luggage.k.a.a.b.b.b cka;
  volatile com.tencent.mm.plugin.appbrand.jsapi.z.e.b ckb;
  boolean ckc;
  boolean ckd;
  boolean cke;
  boolean ckf;
  long ckg;
  boolean ckh;
  public boolean cki;
  volatile boolean ckj;
  boolean ckk;
  boolean ckl;
  int ckm;
  int ckn;
  String cko;
  String ckp;
  boolean ckq;
  boolean ckr;
  private boolean cks;
  private final ConcurrentLinkedQueue<Runnable> ckt;
  Handler cku;
  private HandlerThread ckv;
  volatile com.tencent.luggage.k.a.a ckw;
  public a ckx;
  public a cky;
  public float ckz;
  public Surface mSurface;
  public SurfaceTexture mSurfaceTexture;
  volatile String mTitle;
  int mVideoHeight;
  int mVideoWidth;
  
  public b()
  {
    AppMethodBeat.i(138972);
    this.ckk = false;
    this.ckl = false;
    this.chx = 0;
    this.chy = 0;
    this.cks = false;
    this.chG = false;
    this.chI = null;
    this.ckt = new ConcurrentLinkedQueue();
    this.ckw = null;
    this.chC = null;
    this.chD = null;
    this.cgA = new w()
    {
      private u cih;
      
      public final u EK()
      {
        return this.cih;
      }
    };
    this.chM = new com.tencent.luggage.k.a.a.a(this, this.cgA)
    {
      public final void a(String paramAnonymousString, com.tencent.luggage.k.a.a paramAnonymousa)
      {
        AppMethodBeat.i(178843);
        a(paramAnonymousa);
        paramAnonymousa = paramAnonymousa.Ee();
        if ((paramAnonymousString.contains("insert")) || (paramAnonymousString.contains("update")))
        {
          if (paramAnonymousa.has("autoplay")) {
            this.cgB = paramAnonymousa.optBoolean("autoplay");
          }
          paramAnonymousString = z.D(paramAnonymousa);
          if (paramAnonymousString != null) {
            this.cgC = paramAnonymousString.booleanValue();
          }
        }
        for (;;)
        {
          ac.d(b.this.getLogTag(), "mAutoRotationPluginHandlerCommons.handleJsApi, mIsNeedNotify: " + this.cgB + ", mIsAutoRotationEnabled: " + this.cgC);
          AppMethodBeat.o(178843);
          return;
          if (paramAnonymousString.contains("operate"))
          {
            paramAnonymousString = paramAnonymousa.optString("type");
            if ((!bs.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equalsIgnoreCase("play"))) {
              this.cgB = true;
            }
          }
          else if (paramAnonymousString.contains("remove"))
          {
            this.cgB = false;
          }
        }
      }
    };
    this.chN = new com.tencent.luggage.k.a.a.b()
    {
      private d ckE = null;
      
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
      
      public final String getLogTag()
      {
        AppMethodBeat.i(178844);
        String str = b.this.getLogTag();
        AppMethodBeat.o(178844);
        return str;
      }
    };
    this.ckx = null;
    this.cky = null;
    this.chP = null;
    this.ckz = 1.0F;
    this.ckA = 1.0F;
    this.chT = false;
    this.chU = false;
    this.chK = new s();
    this.chW = new AtomicBoolean(false);
    this.mTitle = null;
    this.chX = null;
    this.chY = null;
    this.chZ = null;
    this.ckv = com.tencent.e.c.d.gz(String.format("VideoThread_%s", new Object[] { Long.valueOf(System.currentTimeMillis()) }), 5);
    this.ckv.start();
    this.cku = new Handler(this.ckv.getLooper());
    AppMethodBeat.o(138972);
  }
  
  private void EW()
  {
    AppMethodBeat.i(138975);
    synchronized (this.ckt)
    {
      if (this.ckt.isEmpty()) {
        break label102;
      }
      ac.i(getLogTag(), "flushPendingTasks, size:%d", new Object[] { Integer.valueOf(this.ckt.size()) });
      Iterator localIterator = this.ckt.iterator();
      if (localIterator.hasNext()) {
        ((Runnable)localIterator.next()).run();
      }
    }
    this.ckt.clear();
    label102:
    AppMethodBeat.o(138975);
  }
  
  private void Fc()
  {
    AppMethodBeat.i(138996);
    if (this.cjU != null)
    {
      ac.i(getLogTag(), "releaseMediaPlayer");
      this.cjU.a(null);
      this.cjU.a(null);
      this.cjU.a(null);
      this.cjU.a(null);
      this.cjU.a(null);
      this.cjU.a(null);
      this.cjU.stop();
      this.cjU.reset();
      this.cjU.release();
    }
    this.cjU = null;
    this.ckj = false;
    AppMethodBeat.o(138996);
  }
  
  private void Fd()
  {
    AppMethodBeat.i(138998);
    if (this.cjU != null)
    {
      this.cjU.setMute(this.ckl);
      if (this.mSurface != null)
      {
        boolean bool = this.chW.get();
        if ((!this.ckr) && (!bool))
        {
          ac.i(getLogTag(), "applyMediaPlayerParams, setSurface");
          this.cjU.setSurface(this.mSurface);
          AppMethodBeat.o(138998);
          return;
        }
        ac.i(getLogTag(), "applyMediaPlayerParams, setSurface, WebViewInBackground: %b, JustPlayAudio: %b", new Object[] { Boolean.valueOf(this.ckr), Boolean.valueOf(bool) });
      }
    }
    AppMethodBeat.o(138998);
  }
  
  private void Fe()
  {
    AppMethodBeat.i(138999);
    if (this.mSurface != null)
    {
      this.mSurface.release();
      this.mSurface = null;
    }
    AppMethodBeat.o(138999);
  }
  
  public final void EC()
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
  final boolean EE()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 480	com/tencent/luggage/k/a/a/b/b:chz	Z
    //   6: ifeq +18 -> 24
    //   9: aload_0
    //   10: getfield 482	com/tencent/luggage/k/a/a/b/b:cjV	Lcom/tencent/luggage/k/a/a/b/b/d;
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
  
  public final void EH()
  {
    AppMethodBeat.i(206631);
    k(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(177151);
        if ((b.this.cjU != null) && (!b.this.cjU.isPlaying())) {
          b.this.i(false, true);
        }
        AppMethodBeat.o(177151);
      }
    });
    AppMethodBeat.o(206631);
  }
  
  final boolean EI()
  {
    AppMethodBeat.i(206638);
    if (this.cht == null)
    {
      ac.w(getLogTag(), "amIBackgroundAudioPlayer, mInsertInvokeContext is null");
      AppMethodBeat.o(206638);
      return false;
    }
    com.tencent.mm.plugin.appbrand.jsapi.z.a locala = com.tencent.luggage.k.a.a.e.f(this.cht);
    if (locala == null)
    {
      ac.w(getLogTag(), "amIBackgroundAudioPlayer, audioOfVideoBackgroundPlayManager is null");
      AppMethodBeat.o(206638);
      return false;
    }
    boolean bool = locala.a(this);
    AppMethodBeat.o(206638);
    return bool;
  }
  
  public final boolean EV()
  {
    AppMethodBeat.i(177165);
    if ((this.chI != null) && (this.chI.get()))
    {
      AppMethodBeat.o(177165);
      return true;
    }
    AppMethodBeat.o(177165);
    return false;
  }
  
  final void EX()
  {
    AppMethodBeat.i(138979);
    if ((this.cjU != null) && (this.mSurfaceTexture != null))
    {
      int i = this.cjU.getVideoWidth();
      int j = this.cjU.getVideoHeight();
      if ((i == 0) && (j == 0))
      {
        ac.w(getLogTag(), "VideoCanvas, registerMediaPlayer, width or height is 0");
        AppMethodBeat.o(138979);
        return;
      }
      if (!this.cks)
      {
        this.cks = true;
        com.tencent.mm.plugin.appbrand.j.a.bcU().a(getId(), this, this.mSurfaceTexture, i, j, this.cht.getAppId());
        AppMethodBeat.o(138979);
        return;
      }
      ac.w(getLogTag(), "VideoCanvas, registerMediaPlayer, already registered");
      AppMethodBeat.o(138979);
      return;
    }
    ac.w(getLogTag(), "VideoCanvas, registerMediaPlayer, media player or surface texture is null");
    AppMethodBeat.o(138979);
  }
  
  final boolean EY()
  {
    AppMethodBeat.i(178849);
    Object localObject;
    if ((this.cht instanceof com.tencent.mm.plugin.appbrand.i.b))
    {
      localObject = this.cht.CM();
      if ((localObject instanceof aa)) {
        localObject = (aa)localObject;
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        localObject = ((aa)localObject).getRuntime();
        ac.i(getLogTag(), "cancelResumePlayingWhenRelaunch:%s", new Object[] { Boolean.valueOf(((AppBrandRuntime)localObject).jdN) });
        boolean bool = ((AppBrandRuntime)localObject).jdN;
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
  
  final void EZ()
  {
    AppMethodBeat.i(138983);
    if (!bs.isNullOrNil(this.ckp))
    {
      if ((Fq() != null) && (this.cjZ != null))
      {
        if (this.cjZ.a(this.ckp, this.chv, this.chw, this.mVideoWidth, this.mVideoHeight))
        {
          this.ckz = this.cjZ.Fo();
          this.ckA = this.cjZ.Fp();
          ac.i(getLogTag(), "adjust objectFit:%s, scale:[%s, %s]", new Object[] { this.ckp, Float.valueOf(this.ckz), Float.valueOf(this.ckA) });
          com.tencent.luggage.k.a.d.a(Fq(), this.type, getId(), this.ckz, this.ckA);
          AppMethodBeat.o(138983);
        }
      }
      else
      {
        ac.i(getLogTag(), "adjust objectFit, video not prepared");
        AppMethodBeat.o(138983);
      }
    }
    else {
      ac.i(getLogTag(), "adjust objectFit, no video objectFit");
    }
    AppMethodBeat.o(138983);
  }
  
  public final void Fa()
  {
    AppMethodBeat.i(206632);
    k(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(177152);
        b.this.pause();
        AppMethodBeat.o(177152);
      }
    });
    AppMethodBeat.o(206632);
  }
  
  final boolean Fb()
  {
    AppMethodBeat.i(138987);
    if (this.cjU != null)
    {
      if (this.cka != null) {
        this.cka.a(this.cht, this.cjU);
      }
      if (!this.cki)
      {
        ac.i(getLogTag(), "video stop, video not prepared yet, stop video when prepared");
        this.ckf = false;
        AppMethodBeat.o(138987);
        return true;
      }
      ac.i(getLogTag(), "video stop");
      this.cjU.stop();
      if (EE()) {
        this.cjV.bK(true);
      }
      AppMethodBeat.o(138987);
      return true;
    }
    AppMethodBeat.o(138987);
    return false;
  }
  
  public final int Ff()
  {
    AppMethodBeat.i(177169);
    int i = (int)(this.chx + (1.0F - this.ckz) * this.chv / 2.0F);
    ac.d(getLogTag(), "getVideoPositionX, videoPosX: ".concat(String.valueOf(i)));
    AppMethodBeat.o(177169);
    return i;
  }
  
  public final int Fg()
  {
    AppMethodBeat.i(177170);
    int i = (int)(this.chy + (1.0F - this.ckA) * this.chw / 2.0F);
    ac.d(getLogTag(), "getVideoPositionY, videoPosY: ".concat(String.valueOf(i)));
    AppMethodBeat.o(177170);
    return i;
  }
  
  public final <AddOn extends com.tencent.luggage.k.a.a.q> AddOn U(Class<AddOn> paramClass)
  {
    AppMethodBeat.i(210442);
    ac.i(getLogTag(), "getAddOn for " + paramClass.getSimpleName());
    paramClass = this.chK.U(paramClass);
    AppMethodBeat.o(210442);
    return paramClass;
  }
  
  public final <AddOn extends com.tencent.luggage.k.a.a.q> void a(Class<AddOn> paramClass, AddOn paramAddOn)
  {
    AppMethodBeat.i(210441);
    ac.i(getLogTag(), "setAddOn for " + paramClass.getSimpleName());
    this.chK.a(paramClass, paramAddOn);
    AppMethodBeat.o(210441);
  }
  
  final String b(com.tencent.luggage.k.a.a parama, String paramString)
  {
    AppMethodBeat.i(138982);
    String str = paramString;
    if (this.cka != null) {
      str = this.cka.b(parama, paramString);
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
    ac.d(getLogTag(), "isEnableVideoCast = ".concat(String.valueOf(bool)));
    p(parama);
    this.ckb.lbF = bool;
    AppMethodBeat.o(138981);
  }
  
  final void bE(boolean paramBoolean)
  {
    AppMethodBeat.i(206630);
    if (this.cjU != null)
    {
      ac.i(getLogTag(), "video prepare async");
      if ((paramBoolean) && (EE())) {
        this.cjV.onVideoWaiting();
      }
      this.cki = false;
      this.ckf = false;
      if (this.cka != null) {
        this.cka.c(this.cjU);
      }
      this.cjU.prepareAsync();
    }
    AppMethodBeat.o(206630);
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
  
  public final boolean e(Surface paramSurface)
  {
    AppMethodBeat.i(206637);
    if (this.cjU != null)
    {
      if (!this.chW.get()) {
        this.cjU.setSurface(paramSurface);
      }
      for (;;)
      {
        AppMethodBeat.o(206637);
        return true;
        ac.i(getLogTag(), "setSurface, JustPlayAudio");
      }
    }
    ac.w(getLogTag(), "setSurface, MediaPlayer is null");
    AppMethodBeat.o(206637);
    return false;
  }
  
  public final boolean g(com.tencent.luggage.k.a.a parama)
  {
    return true;
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(138990);
    if (this.cjU != null)
    {
      int i = this.cjU.getCurrentPosition();
      AppMethodBeat.o(138990);
      return i;
    }
    AppMethodBeat.o(138990);
    return 0;
  }
  
  final int getDuration()
  {
    AppMethodBeat.i(138991);
    if (this.cjU != null)
    {
      int i = this.cjU.getDuration();
      AppMethodBeat.o(138991);
      return i;
    }
    AppMethodBeat.o(138991);
    return 0;
  }
  
  public final String getKey()
  {
    AppMethodBeat.i(177168);
    String str = Ap() + "@" + hashCode();
    AppMethodBeat.o(177168);
    return str;
  }
  
  public final String getLogTag()
  {
    AppMethodBeat.i(138973);
    String str = String.format("%s(%s)", new Object[] { "MicroMsg.SameLayer.VideoPluginHandler", Ap() });
    AppMethodBeat.o(138973);
    return str;
  }
  
  public final String getName()
  {
    AppMethodBeat.i(206640);
    String str = getKey();
    AppMethodBeat.o(206640);
    return str;
  }
  
  public final String h(final com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(138977);
    k(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(138966);
        b localb = b.this;
        com.tencent.luggage.k.a.a locala = parama;
        String str = locala.Ef();
        Object localObject2;
        if (!bs.isNullOrNil(str))
        {
          localObject1 = locala.Ee();
          ac.i(localb.getLogTag(), "*** handler(%s) handleJsApi(%s), data:%s", new Object[] { localb.Ap(), str, ((JSONObject)localObject1).toString() });
          if (!str.contains("insert")) {
            break label974;
          }
          localb.cht = locala;
          if (localb.cjU == null)
          {
            ac.w(localb.getLogTag(), "insert, media player is null");
            localb.r(localb.cht);
          }
          localb.chu = new b.5(localb);
          locala.a(localb.chu);
          if (localb.cka != null) {
            localb.cka.v(locala);
          }
          if ((localb.mSurface != null) && (localb.cjU != null))
          {
            ac.i(localb.getLogTag(), "insert, setSurface");
            localb.cjU.setSurface(localb.mSurface);
          }
          localObject1 = locala.Ee();
          localb.ckh = ((JSONObject)localObject1).optBoolean("autoplay", false);
          localb.ckg = ((((JSONObject)localObject1).optDouble("initialTime", 0.0D) * 1000.0D));
          localb.ckk = ((JSONObject)localObject1).optBoolean("loop", false);
          localb.ckl = ((JSONObject)localObject1).optBoolean("muted", false);
          localb.cjU.setMute(localb.ckl);
          localb.chA = ((JSONObject)localObject1).optBoolean("autoPauseIfNavigate", true);
          localb.chB = ((JSONObject)localObject1).optBoolean("autoPauseIfOpenNative", true);
          localb.chz = ((JSONObject)localObject1).optBoolean("needEvent", false);
          if ((localb.chz) && (localb.cjV != null))
          {
            localb.cjV.m(locala);
            localObject2 = ((JSONObject)localObject1).optString("data", "");
            localb.cjV.cx((String)localObject2);
            if (localb.cjW != null)
            {
              localb.cjW.m(locala);
              localb.cjW.cx((String)localObject2);
            }
          }
          if (((JSONObject)localObject1).has("position"))
          {
            localObject2 = ((JSONObject)localObject1).optJSONObject("position");
            if (localObject2 != null)
            {
              localb.chv = com.tencent.mm.plugin.appbrand.z.g.ve(((JSONObject)localObject2).optInt("width", 0));
              localb.chw = com.tencent.mm.plugin.appbrand.z.g.ve(((JSONObject)localObject2).optInt("height", 0));
              ac.i(localb.getLogTag(), "insert, size:[%d, %d]", new Object[] { Integer.valueOf(localb.chv), Integer.valueOf(localb.chw) });
            }
          }
          localb.ckp = ((JSONObject)localObject1).optString("objectFit", "contain");
          if (bs.isNullOrNil(localb.ckp)) {
            localb.ckp = "contain";
          }
          localb.EZ();
          localObject2 = locala.CM();
          if (localObject2 != null) {
            break label804;
          }
          ac.w(localb.getLogTag(), "updateReferrers, component is null");
          localb.cko = ((JSONObject)localObject1).optString("filePath");
          if (!bs.isNullOrNil(localb.cko))
          {
            if (localb.cka != null) {
              localb.cka.a(localb.cjU, localb.cko);
            }
            localObject2 = localb.b(locala, localb.cko);
            ac.i(localb.getLogTag(), "insert, path:%s, proxy:%s", new Object[] { localb.cko, localObject2 });
            if (!bs.isNullOrNil((String)localObject2))
            {
              localb.cjU.dB((String)localObject2, localb.chD);
              ac.i(localb.getLogTag(), "insert, media player prepare async");
              localb.bE(true);
            }
          }
          localb.mTitle = ((JSONObject)localObject1).optString("title", localb.mTitle);
          localb.chX = ((JSONObject)localObject1).optString("backgroundPoster", localb.chX);
          localb.b(locala, (JSONObject)localObject1);
          locala.cs("ok");
        }
        label786:
        label804:
        Object localObject3;
        Object localObject4;
        for (;;)
        {
          localb.chM.a(str, locala);
          if (localb.cko == null) {
            break label3990;
          }
          localObject1 = localb.cko;
          localb.chN.a(locala, (String)localObject1);
          AppMethodBeat.o(138966);
          return;
          localObject3 = (com.tencent.mm.plugin.appbrand.jsapi.p.a)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.p.a.class);
          if (localObject3 == null)
          {
            ac.w(localb.getLogTag(), "updateReferrers, referrerHelper is null");
            break;
          }
          if (localb.chC == null) {
            localb.chC = ((com.tencent.mm.plugin.appbrand.jsapi.p.a)localObject3).biC();
          }
          localObject4 = ((com.tencent.mm.plugin.appbrand.jsapi.p.a)localObject3).a((JSONObject)localObject1, (com.tencent.mm.plugin.appbrand.jsapi.c)localObject2);
          if (localObject4 != null) {
            localb.chC = ((com.tencent.mm.plugin.appbrand.jsapi.p.c)localObject4);
          }
          ac.i(localb.getLogTag(), "updateReferrers, mReferrerPolicy: " + localb.chC);
          if (com.tencent.mm.plugin.appbrand.jsapi.p.c.kIJ == localb.chC)
          {
            localb.chD = null;
            break;
          }
          localb.chD = ((com.tencent.mm.plugin.appbrand.jsapi.p.a)localObject3).y((com.tencent.mm.plugin.appbrand.jsapi.c)localObject2);
          ac.i(localb.getLogTag(), "updateReferrers, mReferrer: " + localb.chD);
          break;
          label974:
          if (!str.contains("update")) {
            break label2034;
          }
          if (localb.cjU != null) {
            break label1018;
          }
          ac.w(localb.getLogTag(), "update, media player is null");
          locala.cs("fail");
        }
        label1018:
        Object localObject1 = locala.Ee();
        if (((JSONObject)localObject1).has("filePath"))
        {
          localObject2 = ((JSONObject)localObject1).optString("filePath");
          if ((!bs.isNullOrNil((String)localObject2)) && (!((String)localObject2).equalsIgnoreCase(localb.cko)))
          {
            localb.cko = ((String)localObject2);
            localObject2 = localb.b(locala, localb.cko);
            ac.i(localb.getLogTag(), "update, path:%s, proxy:%s", new Object[] { localb.cko, localObject2 });
            if ((localb.cjU == null) || (!bs.isNullOrNil((String)localObject2)))
            {
              localb.ckq = false;
              localb.Fb();
              localb.q(locala);
            }
            if (localb.cka != null) {
              localb.cka.a(localb.cjU, localb.cko);
            }
            localb.cjU.dB((String)localObject2, localb.chD);
          }
        }
        for (int j = 1;; j = 0)
        {
          boolean bool1;
          if ((localb.mSurface != null) && (localb.cjU != null))
          {
            bool1 = localb.chW.get();
            if ((!localb.ckr) && (!bool1))
            {
              ac.i(localb.getLogTag(), "update, setSurface");
              localb.cjU.setSurface(localb.mSurface);
            }
          }
          else
          {
            label1266:
            if (((JSONObject)localObject1).has("autoplay")) {
              localb.ckh = ((JSONObject)localObject1).optBoolean("autoplay", localb.ckh);
            }
            if (((JSONObject)localObject1).has("initialTime")) {
              localb.ckg = ((((JSONObject)localObject1).optDouble("initialTime", 0.0D) * 1000.0D));
            }
            if (((JSONObject)localObject1).has("loop")) {
              localb.ckk = ((JSONObject)localObject1).optBoolean("loop", localb.ckk);
            }
            if (((JSONObject)localObject1).has("muted"))
            {
              localb.ckl = ((JSONObject)localObject1).optBoolean("muted", localb.ckl);
              localb.cjU.setMute(localb.ckl);
            }
            if (((JSONObject)localObject1).has("autoPauseIfNavigate")) {
              localb.chA = ((JSONObject)localObject1).optBoolean("autoPauseIfNavigate", localb.chA);
            }
            if (((JSONObject)localObject1).has("autoPauseIfOpenNative")) {
              localb.chB = ((JSONObject)localObject1).optBoolean("autoPauseIfOpenNative", localb.chB);
            }
            if (((JSONObject)localObject1).has("needEvent")) {
              localb.chz = ((JSONObject)localObject1).optBoolean("needEvent", localb.chz);
            }
            if ((localb.chz) && (localb.cjV != null))
            {
              localb.cjV.m(locala);
              localObject2 = ((JSONObject)localObject1).optString("data", "");
              if (((JSONObject)localObject1).has("data")) {
                localb.cjV.cx((String)localObject2);
              }
              if (localb.cjW != null)
              {
                if (((JSONObject)localObject1).has("data")) {
                  localb.cjW.cx((String)localObject2);
                }
                localb.cjW.m(locala);
              }
            }
            int i = 0;
            if (((JSONObject)localObject1).has("position"))
            {
              localObject2 = ((JSONObject)localObject1).optJSONObject("position");
              if (localObject2 != null)
              {
                localb.chv = com.tencent.mm.plugin.appbrand.z.g.ve(((JSONObject)localObject2).optInt("width", localb.chv));
                localb.chw = com.tencent.mm.plugin.appbrand.z.g.ve(((JSONObject)localObject2).optInt("height", localb.chw));
                ac.i(localb.getLogTag(), "update, size:[%d, %d]", new Object[] { Integer.valueOf(localb.chv), Integer.valueOf(localb.chw) });
              }
              i = 1;
            }
            if (((JSONObject)localObject1).has("objectFit"))
            {
              localb.ckp = ((JSONObject)localObject1).optString("objectFit", localb.ckp);
              if (bs.isNullOrNil(localb.ckp)) {
                localb.ckp = "contain";
              }
              i = 1;
            }
            if (i != 0) {
              localb.EZ();
            }
            localb.b(locala, (JSONObject)localObject1);
            localObject2 = ((JSONObject)localObject1).optString("filePath");
            if ((localb.ckb != null) && (localb.ckb.bmb()))
            {
              localObject3 = localb.ckb;
              k.h(localObject2, "updateVideoPath");
              ac.i("MicroMsg.VideoCast.AppBrandVideoCastHandler", "updateVideoPath: [" + (String)localObject2 + ']');
              if (!d.n.n.aD((CharSequence)d.n.n.trim((CharSequence)localObject2).toString()))
              {
                ((com.tencent.mm.plugin.appbrand.jsapi.z.e.b)localObject3).bmc().bml();
                if (!k.g(localObject2, ((com.tencent.mm.plugin.appbrand.jsapi.z.e.b)localObject3).videoPath))
                {
                  ((com.tencent.mm.plugin.appbrand.jsapi.z.e.b)localObject3).setVideoPath((String)localObject2);
                  ((com.tencent.mm.plugin.appbrand.jsapi.z.e.b)localObject3).gP(true);
                  ((com.tencent.mm.plugin.appbrand.jsapi.z.e.b)localObject3).bmc().r((d.g.a.b)new com.tencent.mm.plugin.appbrand.jsapi.z.e.b.f((com.tencent.mm.plugin.appbrand.jsapi.z.e.b)localObject3));
                  if (((com.tencent.mm.plugin.appbrand.jsapi.z.e.b)localObject3).bmc().dtw != -1) {
                    break label2022;
                  }
                  ((com.tencent.mm.plugin.appbrand.jsapi.z.e.b)localObject3).bmc().dtw = 8;
                }
              }
            }
          }
          for (;;)
          {
            localb.mTitle = ((JSONObject)localObject1).optString("title", localb.mTitle);
            localb.chX = ((JSONObject)localObject1).optString("backgroundPoster", localb.chX);
            if (j != 0)
            {
              ac.i(localb.getLogTag(), "update, media player prepare async");
              localb.bE(true);
            }
            locala.cs("ok");
            break;
            ac.i(localb.getLogTag(), "update, setSurface, WebViewInBackground: %b, JustPlayAudio: %b", new Object[] { Boolean.valueOf(localb.ckr), Boolean.valueOf(bool1) });
            break label1266;
            label2022:
            ac.i("MicroMsg.VideoCast.AppBrandVideoCastHandler", "discard a updateVideoPath report event");
          }
          label2034:
          boolean bool2;
          if ((str.contains("operate")) && (str.contains("Background")))
          {
            if (localb.cjU == null)
            {
              ac.w(localb.getLogTag(), "operateBackground, media player is null");
              locala.cs("fail");
              break;
            }
            localObject1 = locala.Ee();
            bool1 = false;
            localObject1 = ((JSONObject)localObject1).optString("type");
            if (bs.isNullOrNil((String)localObject1)) {
              break;
            }
            ac.i(localb.getLogTag(), "operateBackground, type:%s", new Object[] { localObject1 });
            if (((String)localObject1).equalsIgnoreCase("stop"))
            {
              bool2 = localb.s(locala);
              bool1 = bool2;
              if (bool2)
              {
                bool1 = bool2;
                if (localb.chG)
                {
                  ac.i(localb.getLogTag(), "operateBackground, isRuntimeInBackground, setPlayingWhenEnterBackground false");
                  localb.chI = new AtomicBoolean(false);
                  bool1 = bool2;
                }
              }
            }
            if (bool1) {}
            for (localObject1 = "ok";; localObject1 = "fail")
            {
              locala.cs((String)localObject1);
              break;
            }
          }
          if (str.contains("operate"))
          {
            if (localb.cjU == null)
            {
              ac.w(localb.getLogTag(), "operate, media player is null");
              locala.cs("fail");
              break;
            }
            localObject3 = locala.Ee();
            bool2 = false;
            localObject2 = ((JSONObject)localObject3).optString("type");
            if (bs.isNullOrNil((String)localObject2)) {
              break;
            }
            ac.i(localb.getLogTag(), "operate, type:%s", new Object[] { localObject2 });
            if (((String)localObject2).equalsIgnoreCase("startCasting"))
            {
              bool1 = true;
              label2347:
              if (!bool1) {
                break label3061;
              }
              ac.i(localb.getLogTag(), "video cast operate, type:%s", new Object[] { localObject2 });
              if (localb.ckb == null) {
                localb.p(locala);
              }
              localb.ckb.setVideoPath(localb.cko);
              localb.ckb.lbA = localb.getCurrentPosition();
              if (!((String)localObject2).equalsIgnoreCase("requestFullScreen")) {
                break label2536;
              }
              bool1 = localb.j(locala);
              label2433:
              if (!((String)localObject2).equalsIgnoreCase("snapshot")) {
                break label3919;
              }
              ac.i(localb.getLogTag(), "getSnapshotCached");
              if (localb.cka != null) {
                break label3904;
              }
              locala.cs("fail:snapshot error");
            }
            for (;;)
            {
              label2474:
              if ((!((String)localObject2).equalsIgnoreCase("pause")) && (!((String)localObject2).equalsIgnoreCase("stop"))) {
                break label3940;
              }
              localb.chN.b(locala);
              break;
              if (localb.ckb == null)
              {
                bool1 = false;
                break label2347;
              }
              bool1 = localb.ckb.bmb();
              break label2347;
              label2536:
              if (((String)localObject2).equalsIgnoreCase("exitFullScreen"))
              {
                bool1 = localb.k(locala);
                break label2433;
              }
              localObject1 = localb.ckb;
              k.h(localObject3, "data");
              k.h(locala, "invokeContext");
              localObject4 = ((JSONObject)localObject3).optString("type");
              ac.i("MicroMsg.VideoCast.AppBrandVideoCastHandler", "handleOperate: type = ".concat(String.valueOf(localObject4)));
              if (localObject4 == null)
              {
                bool1 = true;
                break label2433;
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
                          com.tencent.mm.plugin.appbrand.jsapi.z.e.a.h.b(((com.tencent.mm.plugin.appbrand.jsapi.z.e.b)localObject1).bmc());
                          bool1 = true;
                          break;
                          if (((String)localObject4).equals("reconnectCasting"))
                          {
                            localObject3 = ((com.tencent.mm.plugin.appbrand.jsapi.z.e.b)localObject1).lbD;
                            if (localObject3 != null) {
                              ((com.tencent.mm.plugin.appbrand.jsapi.z.e.a.c)localObject3).tn(5);
                            }
                            localObject1 = ((com.tencent.mm.plugin.appbrand.jsapi.z.e.b)localObject1).bmc();
                            if (((com.tencent.mm.plugin.appbrand.jsapi.z.e.a.h)localObject1).lcP.bmm().bbK() != e.a.jIZ) {
                              break label3035;
                            }
                            ((com.tencent.mm.plugin.appbrand.jsapi.z.e.a.h)localObject1).ldp.bH(true);
                            bool1 = true;
                            break;
                            if (((String)localObject4).equals("exitCasting"))
                            {
                              localObject3 = ((com.tencent.mm.plugin.appbrand.jsapi.z.e.b)localObject1).lbD;
                              if (localObject3 != null) {
                                ((com.tencent.mm.plugin.appbrand.jsapi.z.e.a.c)localObject3).tn(6);
                              }
                              com.tencent.mm.plugin.appbrand.jsapi.z.e.a.h.d(((com.tencent.mm.plugin.appbrand.jsapi.z.e.b)localObject1).bmc());
                              ((com.tencent.mm.plugin.appbrand.jsapi.z.e.b)localObject1).bmc().destroy();
                              ((com.tencent.mm.plugin.appbrand.jsapi.z.e.b)localObject1).lbG = false;
                              ((com.tencent.mm.plugin.appbrand.jsapi.z.e.b)localObject1).gP(false);
                            }
                          }
                        }
                      }
                    } while (!((String)localObject4).equals("startCasting"));
                    ((com.tencent.mm.plugin.appbrand.jsapi.z.e.b)localObject1).bmc().ldg = ((d.g.a.a)new com.tencent.mm.plugin.appbrand.jsapi.z.e.b.e((com.tencent.mm.plugin.appbrand.jsapi.z.e.b)localObject1));
                    com.tencent.mm.plugin.appbrand.jsapi.z.e.a.h.a(((com.tencent.mm.plugin.appbrand.jsapi.z.e.b)localObject1).bmc());
                    bool1 = true;
                    break;
                  } while (!((String)localObject4).equals("switchCasting"));
                  localObject3 = ((com.tencent.mm.plugin.appbrand.jsapi.z.e.b)localObject1).lbD;
                  if (localObject3 != null) {
                    ((com.tencent.mm.plugin.appbrand.jsapi.z.e.a.c)localObject3).tn(4);
                  }
                  ((com.tencent.mm.plugin.appbrand.jsapi.z.e.b)localObject1).bmc().x(false, true);
                  bool1 = true;
                  break;
                } while (!((String)localObject4).equals("seek"));
                long l = com.tencent.mm.plugin.appbrand.jsapi.z.e.b.W((JSONObject)localObject3);
                if (l <= 0L) {
                  break label3020;
                }
                ((com.tencent.mm.plugin.appbrand.jsapi.z.e.b)localObject1).bmc().Oc(com.tencent.mm.plugin.appbrand.jsapi.z.e.b.c.tm((int)l));
                bool1 = true;
                break;
              } while (!((String)localObject4).equals("pause"));
              com.tencent.mm.plugin.appbrand.jsapi.z.e.a.h.c(((com.tencent.mm.plugin.appbrand.jsapi.z.e.b)localObject1).bmc());
              bool1 = true;
              break label2433;
              label3020:
              ac.i("MicroMsg.VideoCast.AppBrandVideoCastHandler", "invalid seek position");
              bool1 = false;
              break label2433;
              label3035:
              ((com.tencent.mm.plugin.appbrand.jsapi.z.e.a.h)localObject1).lcP.t((d.g.a.b)new h.p((com.tencent.mm.plugin.appbrand.jsapi.z.e.a.h)localObject1));
              bool1 = true;
              break label2433;
              label3061:
              if (((String)localObject2).equalsIgnoreCase("play"))
              {
                bool1 = localb.i(false, true);
                break label2433;
              }
              if (((String)localObject2).equalsIgnoreCase("pause"))
              {
                bool1 = localb.pause();
                break label2433;
              }
              if (((String)localObject2).equalsIgnoreCase("stop"))
              {
                bool2 = localb.Fb();
                bool1 = bool2;
                if (!bool2) {
                  break label2433;
                }
                bool1 = bool2;
                if (!localb.chG) {
                  break label2433;
                }
                ac.i(localb.getLogTag(), "stop, isRuntimeInBackground, setPlayingWhenEnterBackground false");
                localb.chI = new AtomicBoolean(false);
                bool1 = bool2;
                break label2433;
              }
              label3248:
              double d;
              if (((String)localObject2).equalsIgnoreCase("seek"))
              {
                if ((localb.cjU != null) && (localObject3 != null) && (((JSONObject)localObject3).has("data")))
                {
                  localObject1 = ((JSONObject)localObject3).optJSONArray("data");
                  if ((localObject1 != null) && (((JSONArray)localObject1).length() != 0)) {
                    break label3248;
                  }
                  ac.w(localb.getLogTag(), "seek, data array is null");
                }
                for (;;)
                {
                  bool1 = false;
                  break;
                  d = ((JSONArray)localObject1).optDouble(0, -1.0D);
                  if (d >= 0.0D) {
                    break label3289;
                  }
                  ac.w(localb.getLogTag(), "seek, invalid position:%s", new Object[] { Double.valueOf(d) });
                }
                label3289:
                localb.seek((d * 1000.0D));
                bool1 = true;
                break label2433;
              }
              if (((String)localObject2).equalsIgnoreCase("playbackRate"))
              {
                if ((localb.cjU != null) && (localObject3 != null) && (((JSONObject)localObject3).has("data")))
                {
                  localObject1 = ((JSONObject)localObject3).optJSONArray("data");
                  if ((localObject1 != null) && (((JSONArray)localObject1).length() != 0)) {
                    break label3379;
                  }
                  ac.w(localb.getLogTag(), "speed, data array is null");
                }
                for (;;)
                {
                  bool1 = false;
                  break;
                  label3379:
                  d = ((JSONArray)localObject1).optDouble(0, -1.0D);
                  if (d >= 0.0D) {
                    break label3420;
                  }
                  ac.w(localb.getLogTag(), "speed, invalid rate:%s", new Object[] { Double.valueOf(d) });
                }
                label3420:
                ac.i(localb.getLogTag(), "speed, speed:%s", new Object[] { Double.valueOf(d) });
                bool1 = localb.cjU.aC((float)d);
                break label2433;
              }
              if (((String)localObject2).equalsIgnoreCase("requestFullScreen"))
              {
                bool1 = localb.j(locala);
                break label2433;
              }
              if (((String)localObject2).equalsIgnoreCase("exitFullScreen"))
              {
                bool1 = localb.k(locala);
                break label2433;
              }
              if (((String)localObject2).equalsIgnoreCase("setScreenBrightness"))
              {
                ac.i(localb.getLogTag(), "setScreenBrightness");
                if ((localb.cka != null) && (localb.cka.t(locala)))
                {
                  bool1 = true;
                  break label2433;
                }
                bool1 = false;
                break label2433;
              }
              if (((String)localObject2).equalsIgnoreCase("exitPictureInPicture"))
              {
                bool1 = localb.chN.c(locala);
                break label2433;
              }
              if (((String)localObject2).equalsIgnoreCase("requestBackgroundPlayback"))
              {
                ac.d(localb.getLogTag(), "enableBackgroundPlayAudio");
                if (!localb.chT)
                {
                  ac.d(localb.getLogTag(), "registerAddOnPlayAudio");
                  localb.a(com.tencent.luggage.k.a.a.j.class, new b.28(localb));
                  ac.d(localb.getLogTag(), "registerAddOnVideoController");
                  localb.a(r.class, new b.29(localb));
                  ac.d(localb.getLogTag(), "registerAddOnInfo");
                  localb.a(i.class, new b.30(localb));
                  ac.d(localb.getLogTag(), "registerAddOnGetSnapshot");
                  localb.a(com.tencent.luggage.k.a.a.h.class, new b.32(localb));
                  localb.chT = true;
                }
                ac.d(localb.getLogTag(), "enableBackgroundPlayAudioInternal");
                if (locala == null)
                {
                  ac.w(localb.getLogTag(), "enableBackgroundPlayAudioInternal, invokeContext is null");
                  bool1 = false;
                }
                for (;;)
                {
                  if (!bool1) {
                    break label3871;
                  }
                  localb.chW.set(true);
                  if (localb.cjU != null) {
                    localb.cjU.setSurface(null);
                  }
                  localb.chU = true;
                  if (localb.cjV != null) {
                    localb.cjV.bL(true);
                  }
                  bool1 = true;
                  break;
                  localObject1 = com.tencent.luggage.k.a.a.e.f(locala);
                  if (localObject1 == null)
                  {
                    ac.w(localb.getLogTag(), "enableBackgroundPlayAudioInternal, audioOfVideoBackgroundPlayManager is null");
                    bool1 = false;
                  }
                  else
                  {
                    bool1 = ((com.tencent.mm.plugin.appbrand.jsapi.z.a)localObject1).b(localb);
                  }
                }
                label3871:
                bool1 = false;
                break label2433;
              }
              bool1 = bool2;
              if (!((String)localObject2).equalsIgnoreCase("exitBackgroundPlayback")) {
                break label2433;
              }
              bool1 = localb.s(locala);
              break label2433;
              label3904:
              localb.ckw = locala;
              localb.takeScreenshot();
            }
            label3919:
            if (bool1) {}
            for (localObject1 = "ok";; localObject1 = "fail")
            {
              locala.cs((String)localObject1);
              break label2474;
              label3940:
              break;
            }
          }
          if (!str.contains("remove")) {
            break;
          }
          localb.release();
          locala.cs("ok");
          localb.chN.b(locala);
          break;
          label3990:
          localObject1 = "";
          break label786;
        }
      }
    });
    AppMethodBeat.o(138977);
    return null;
  }
  
  final boolean i(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(177166);
    if (this.cjU != null)
    {
      if ((this.cki) && (this.cjU.isPlaying()))
      {
        ac.i(getLogTag(), "video play, video is playing");
        if (EE()) {
          this.cjV.bJ(paramBoolean1);
        }
        AppMethodBeat.o(177166);
        return true;
      }
      if ((this.cjU != null) && (!this.cki))
      {
        ac.i(getLogTag(), "video play, video not prepared yet, start until prepared");
        this.ckf = true;
        AppMethodBeat.o(177166);
        return true;
      }
      if ((this.cjU != null) && (this.cjU.getState() == 5))
      {
        if (!paramBoolean2)
        {
          ac.i(getLogTag(), "video has ended playing, do not restart");
          AppMethodBeat.o(177166);
          return false;
        }
        ac.i(getLogTag(), "video play, video has stopped now, try prepare and start when prepared");
        bE(true);
        this.ckf = true;
        AppMethodBeat.o(177166);
        return true;
      }
      if (this.ckq)
      {
        if (!paramBoolean2)
        {
          ac.i(getLogTag(), "video has ended playing, do not restart");
          AppMethodBeat.o(177166);
          return false;
        }
        ac.i(getLogTag(), "video play, video has ended playing, clear surface and start again");
        this.ckq = false;
        try
        {
          if ((this.mSurfaceTexture != null) && (this.cki))
          {
            ac.i(getLogTag(), "clearSurfaceTexture");
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
            ac.printErrStackTrace(getLogTag(), localException, "clearSurfaceTexture error", new Object[0]);
            continue;
            this.cjU.dB(this.cko, this.chD);
          }
        }
        q(this.cht);
        if (this.cjU != null)
        {
          this.ckh = true;
          localObject1 = b(this.cht, this.cko);
          if (!bs.isNullOrNil((String)localObject1))
          {
            this.cjU.dB((String)localObject1, this.chD);
            ac.i(getLogTag(), "video play, media player state:%s", new Object[] { Integer.valueOf(this.cjU.getState()) });
            bE(false);
            this.ckf = true;
          }
        }
        else
        {
          AppMethodBeat.o(177166);
          return true;
        }
      }
      ac.i(getLogTag(), "video play");
      if (this.cjU != null)
      {
        if (EE()) {
          this.cjV.bJ(paramBoolean1);
        }
        this.cjU.start();
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
    if (this.cjU != null)
    {
      boolean bool = this.cjU.isPlaying();
      AppMethodBeat.o(138989);
      return bool;
    }
    AppMethodBeat.o(138989);
    return false;
  }
  
  final boolean j(com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(138993);
    ac.i(getLogTag(), "requestFullscreen");
    if ((this.cka != null) && (this.cka.j(parama)))
    {
      AppMethodBeat.o(138993);
      return true;
    }
    AppMethodBeat.o(138993);
    return false;
  }
  
  final boolean k(com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(138994);
    ac.i(getLogTag(), "exitFullscreen");
    if ((this.cka != null) && (this.cka.k(parama)))
    {
      AppMethodBeat.o(138994);
      return true;
    }
    AppMethodBeat.o(138994);
    return false;
  }
  
  public final boolean k(Runnable paramRunnable)
  {
    AppMethodBeat.i(138980);
    if (this.cku != null)
    {
      if (this.cku.getLooper() == Looper.myLooper()) {
        paramRunnable.run();
      }
      for (;;)
      {
        AppMethodBeat.o(138980);
        return true;
        this.cku.post(paramRunnable);
      }
    }
    AppMethodBeat.o(138980);
    return false;
  }
  
  final void p(com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(138978);
    if (this.ckb != null)
    {
      AppMethodBeat.o(138978);
      return;
    }
    this.ckb = this.cka.a(this.cjW, parama);
    AppMethodBeat.o(138978);
  }
  
  final boolean pause()
  {
    AppMethodBeat.i(210440);
    if (this.cjU != null)
    {
      if (!this.cki)
      {
        ac.i(getLogTag(), "video pause, video not prepared yet, pause video when prepared");
        this.ckf = false;
        AppMethodBeat.o(210440);
        return true;
      }
      if (!this.cjU.isPlaying())
      {
        ac.i(getLogTag(), "video pause, video is not playing");
        AppMethodBeat.o(210440);
        return true;
      }
      ac.i(getLogTag(), "video pause");
      this.cjU.pause();
      if (EE()) {
        this.cjV.bK(false);
      }
      AppMethodBeat.o(210440);
      return true;
    }
    AppMethodBeat.o(210440);
    return false;
  }
  
  final void q(com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(138995);
    Fc();
    r(parama);
    Fd();
    AppMethodBeat.o(138995);
  }
  
  public final void r(Bitmap paramBitmap)
  {
    AppMethodBeat.i(178848);
    super.r(paramBitmap);
    ac.i(getLogTag(), "*** handler(%s) handlePluginScreenshotTaken", new Object[] { Ap() });
    Object localObject = this.ckw;
    int i;
    if (localObject == null)
    {
      ac.w(getLogTag(), "handlePluginScreenshotTaken4JsApiCall, invokeContext is null");
      i = 0;
    }
    for (;;)
    {
      if (i == 0)
      {
        localObject = this.chY;
        if (localObject == null)
        {
          ac.w(getLogTag(), "handlePluginScreenshotTaken4NativeCall, getSnapshotCallback is null");
          AppMethodBeat.o(178848);
          return;
          if (paramBitmap == null)
          {
            ac.w(getLogTag(), "handlePluginScreenshotTaken4JsApiCall, bitmap is null");
            i = 0;
            continue;
          }
          if ((this.chv == 0) || (this.chw == 0)) {
            break label265;
          }
        }
      }
    }
    label265:
    for (Bitmap localBitmap = Bitmap.createScaledBitmap(paramBitmap, (int)(this.ckz * this.chv), (int)(this.ckA * this.chw), false);; localBitmap = paramBitmap)
    {
      this.cka.a((com.tencent.luggage.k.a.a)localObject, localBitmap);
      this.ckw = null;
      i = 1;
      break;
      if (paramBitmap == null)
      {
        ac.w(getLogTag(), "handlePluginScreenshotTaken4NativeCall, bitmap is null");
        ((com.tencent.luggage.k.a.a.g)localObject).o(null);
        AppMethodBeat.o(178848);
        return;
      }
      localBitmap = paramBitmap;
      if (this.chv != 0)
      {
        localBitmap = paramBitmap;
        if (this.chw != 0) {
          localBitmap = Bitmap.createScaledBitmap(paramBitmap, (int)(this.ckz * this.chv), (int)(this.ckA * this.chw), false);
        }
      }
      ((com.tencent.luggage.k.a.a.g)localObject).o(localBitmap);
      this.chY = null;
      AppMethodBeat.o(178848);
      return;
    }
  }
  
  final void r(com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(138997);
    ac.i(getLogTag(), "createMediaPlayer");
    if (this.cka != null) {
      this.cjU = this.cka.a(parama, this.cku);
    }
    if (this.cjU == null)
    {
      ac.e(getLogTag(), "createMediaPlayer, create media player fail");
      AppMethodBeat.o(138997);
      return;
    }
    this.ckj = true;
    this.cjU.a(new b.d()
    {
      public final boolean bY(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(210423);
        b localb = b.this;
        boolean bool = localb.k(new b.4(localb, paramAnonymousInt1, paramAnonymousInt2));
        AppMethodBeat.o(210423);
        return bool;
      }
    });
    this.cjU.a(new com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c()
    {
      public final boolean bZ(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(210424);
        b localb = b.this;
        boolean bool = localb.k(new b.3(localb, paramAnonymousInt1, paramAnonymousInt2));
        AppMethodBeat.o(210424);
        return bool;
      }
    });
    this.cjU.a(new com.tencent.mm.plugin.appbrand.jsapi.video.e.b.e()
    {
      public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramAnonymousb)
      {
        AppMethodBeat.i(210425);
        paramAnonymousb = b.this;
        paramAnonymousb.k(new b.2(paramAnonymousb));
        AppMethodBeat.o(210425);
      }
    });
    this.cjU.a(new b.b()
    {
      public final void Fh()
      {
        AppMethodBeat.i(210426);
        b localb = b.this;
        localb.k(new b.39(localb));
        AppMethodBeat.o(210426);
      }
    });
    this.cjU.a(new com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f()
    {
      public final void b(com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramAnonymousb)
      {
        AppMethodBeat.i(210427);
        paramAnonymousb = b.this;
        paramAnonymousb.k(new b.38(paramAnonymousb));
        AppMethodBeat.o(210427);
      }
    });
    this.cjU.a(new b.g()
    {
      public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramAnonymousb, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(210428);
        paramAnonymousb = b.this;
        paramAnonymousb.k(new b.37(paramAnonymousb, paramAnonymousInt1, paramAnonymousInt2));
        AppMethodBeat.o(210428);
      }
    });
    this.cjU.a(new com.tencent.mm.plugin.appbrand.jsapi.video.e.b.a()
    {
      public final void gH(int paramAnonymousInt)
      {
        AppMethodBeat.i(210429);
        b localb = b.this;
        localb.k(new b.36(localb, paramAnonymousInt));
        AppMethodBeat.o(210429);
      }
    });
    if (this.ckx != null) {
      this.ckx.bG(this.cki);
    }
    AppMethodBeat.o(138997);
  }
  
  final void release()
  {
    AppMethodBeat.i(206634);
    ac.i(getLogTag(), "video release");
    if (this.cka != null) {
      this.cka.w(this.cht);
    }
    Fb();
    Fc();
    if (this.cjV != null)
    {
      this.cjV.destroy();
      this.cjV = null;
      this.cjW = null;
    }
    if (this.ckb != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.z.e.b localb = this.ckb;
      localb.bmc().destroy();
      localb.lbG = false;
      localb.gP(false);
      localb.bmc().bml();
      this.ckb = null;
    }
    Fe();
    if (this.cht != null)
    {
      this.cht.Eg();
      this.chu = null;
    }
    ac.i(getLogTag(), "video release handler thread");
    if (this.cku != null) {
      this.cku.removeCallbacksAndMessages(null);
    }
    if (this.ckv != null) {
      this.ckv.quitSafely();
    }
    AppMethodBeat.o(206634);
  }
  
  final boolean s(com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(206639);
    ac.d(getLogTag(), "disableBackgroundPlayAudio");
    ac.d(getLogTag(), "disableBackgroundPlayAudioInternal");
    int i;
    if (parama == null)
    {
      ac.w(getLogTag(), "disableBackgroundPlayAudioInternal, invokeContext is null");
      i = 0;
    }
    while (i != 0)
    {
      this.chW.set(false);
      if (this.cjU != null) {
        this.cjU.setSurface(this.mSurface);
      }
      this.chU = false;
      if (this.cjV != null) {
        this.cjV.bL(false);
      }
      AppMethodBeat.o(206639);
      return true;
      parama = com.tencent.luggage.k.a.a.e.f(parama);
      if (parama == null)
      {
        ac.w(getLogTag(), "disableBackgroundPlayAudio, audioOfVideoBackgroundPlayManager is null");
        i = 0;
      }
      else
      {
        parama.c(this);
        i = 1;
      }
    }
    AppMethodBeat.o(206639);
    return false;
  }
  
  final void seek(long paramLong)
  {
    AppMethodBeat.i(138992);
    if ((this.cki) && (this.cjU != null))
    {
      if (EE()) {
        this.cjV.onVideoWaiting();
      }
      if (this.cjU != null)
      {
        this.ckd = isPlaying();
        paramLong = Math.min(getDuration(), Math.max(0L, paramLong));
        ac.i(getLogTag(), "seek, position:%s, isPlaying:%s, videoEndPlaying:%s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(this.ckd), Boolean.valueOf(this.ckq) });
        this.ckq = false;
        this.cjU.seekTo(paramLong);
        AppMethodBeat.o(138992);
      }
    }
    else
    {
      this.ckg = paramLong;
    }
    AppMethodBeat.o(138992);
  }
  
  final void takeScreenshot()
  {
    AppMethodBeat.i(206635);
    ac.i(getLogTag(), "takeScreenshot");
    com.tencent.luggage.k.a.d.a(Fq(), this.type, getId());
    AppMethodBeat.o(206635);
  }
  
  public static abstract interface a
  {
    public abstract void bG(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.k.a.a.b.b
 * JD-Core Version:    0.7.0.1
 */