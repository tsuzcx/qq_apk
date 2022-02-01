package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import com.tencent.luggage.xweb_ext.extendplugin.a.a;
import com.tencent.luggage.xweb_ext.extendplugin.component.k;
import com.tencent.luggage.xweb_ext.extendplugin.component.l;
import com.tencent.luggage.xweb_ext.extendplugin.component.m;
import com.tencent.luggage.xweb_ext.extendplugin.component.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.g.b.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h.p;
import com.tencent.mm.plugin.appbrand.jsapi.ag.e.b.c;
import com.tencent.mm.plugin.appbrand.jsapi.ag.e.b.e;
import com.tencent.mm.plugin.appbrand.jsapi.ag.e.b.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c.h;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c.i;
import com.tencent.mm.plugin.appbrand.jsapi.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import kotlin.g.b.p;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c
  extends com.tencent.luggage.xweb_ext.extendplugin.a.a
  implements com.tencent.luggage.xweb_ext.extendplugin.component.i
{
  private z cDL;
  public com.tencent.luggage.xweb_ext.extendplugin.a cED;
  a.a cEE;
  public int cEF;
  public int cEG;
  public int cEH;
  public int cEI;
  boolean cEJ;
  boolean cEK;
  boolean cEL;
  final com.tencent.mm.plugin.appbrand.jsapi.video.a.a cEM;
  com.tencent.mm.plugin.appbrand.jsapi.u.c cEN;
  String cEO;
  boolean cER;
  AtomicBoolean cET;
  com.tencent.luggage.xweb_ext.extendplugin.component.a cEU;
  com.tencent.luggage.xweb_ext.extendplugin.component.b<e> cEV;
  public com.tencent.luggage.xweb_ext.extendplugin.component.s cEX;
  boolean cFb;
  public boolean cFc;
  private com.tencent.luggage.xweb_ext.extendplugin.component.i cFd;
  public AtomicBoolean cFe;
  volatile String cFf;
  volatile com.tencent.luggage.xweb_ext.extendplugin.component.g cFg;
  volatile Bitmap cFh;
  public com.tencent.mm.plugin.appbrand.jsapi.video.e.c cIV;
  public com.tencent.luggage.xweb_ext.extendplugin.component.video.b.d cIW;
  public com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a cIX;
  public com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c cIY;
  public com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e cIZ;
  private boolean cJA;
  public b cJB;
  public a cJC;
  public float cJD;
  public float cJE;
  public com.tencent.luggage.xweb_ext.extendplugin.component.video.b.f cJa;
  public com.tencent.luggage.xweb_ext.extendplugin.component.video.b.b cJb;
  volatile com.tencent.mm.plugin.appbrand.jsapi.ag.e.b cJc;
  boolean cJd;
  boolean cJe;
  boolean cJf;
  boolean cJg;
  long cJh;
  boolean cJi;
  public boolean cJj;
  volatile boolean cJk;
  boolean cJl;
  boolean cJm;
  int cJn;
  int cJo;
  String cJp;
  String cJq;
  boolean cJr;
  boolean cJs;
  private boolean cJt;
  private final ConcurrentLinkedQueue<Runnable> cJu;
  Handler cJv;
  private HandlerThread cJw;
  volatile com.tencent.luggage.xweb_ext.extendplugin.a cJx;
  Surface cJy;
  public c.a cJz;
  public Surface mSurface;
  public SurfaceTexture mSurfaceTexture;
  volatile String mTitle;
  int mVideoHeight;
  int mVideoWidth;
  
  public c()
  {
    AppMethodBeat.i(138972);
    this.cJl = false;
    this.cJm = false;
    this.cEH = 0;
    this.cEI = 0;
    this.cJt = false;
    this.cER = false;
    this.cET = null;
    this.cEM = new com.tencent.mm.plugin.appbrand.jsapi.video.a.a();
    this.cJu = new ConcurrentLinkedQueue();
    this.cJx = null;
    this.cEN = null;
    this.cEO = null;
    this.cJy = null;
    this.cJz = null;
    this.cJA = false;
    this.cDL = new c.36(this);
    this.cEU = new com.tencent.luggage.xweb_ext.extendplugin.component.a(this, this.cDL)
    {
      public final boolean Pv()
      {
        return !c.this.cJs;
      }
      
      public final void a(String paramAnonymousString, com.tencent.luggage.xweb_ext.extendplugin.a paramAnonymousa)
      {
        AppMethodBeat.i(215701);
        a(paramAnonymousa);
        paramAnonymousa = paramAnonymousa.Ps();
        if ((paramAnonymousString.contains("insert")) || (paramAnonymousString.contains("update")))
        {
          if (paramAnonymousa.has("autoplay")) {
            this.cDM = paramAnonymousa.optBoolean("autoplay");
          }
          paramAnonymousString = com.tencent.mm.plugin.appbrand.jsapi.ac.K(paramAnonymousa);
          if (paramAnonymousString != null) {
            this.cDN = paramAnonymousString.booleanValue();
          }
        }
        for (;;)
        {
          Log.d(c.this.getLogTag(), "mAutoRotationPluginHandlerCommons.handleJsApi, mIsNeedNotify: " + this.cDM + ", mIsAutoRotationEnabled: " + this.cDN);
          AppMethodBeat.o(215701);
          return;
          if (paramAnonymousString.contains("operate"))
          {
            paramAnonymousString = paramAnonymousa.optString("type");
            if ((!Util.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equalsIgnoreCase("play"))) {
              this.cDM = true;
            }
          }
          else if (paramAnonymousString.contains("remove"))
          {
            this.cDM = false;
          }
        }
      }
    };
    this.cEV = new com.tencent.luggage.xweb_ext.extendplugin.component.b()
    {
      private e cJM = null;
      
      public final int getId()
      {
        AppMethodBeat.i(215703);
        int i = c.this.getId();
        AppMethodBeat.o(215703);
        return i;
      }
      
      public final String getKey()
      {
        AppMethodBeat.i(215704);
        String str = c.this.getKey();
        AppMethodBeat.o(215704);
        return str;
      }
      
      public final String getLogTag()
      {
        AppMethodBeat.i(215702);
        String str = c.this.getLogTag();
        AppMethodBeat.o(215702);
        return str;
      }
    };
    this.cJB = null;
    this.cJC = null;
    this.cEX = null;
    this.cJD = 1.0F;
    this.cJE = 1.0F;
    this.cFb = false;
    this.cFc = false;
    this.cFd = new r();
    this.cFe = new AtomicBoolean(false);
    this.mTitle = null;
    this.cFf = null;
    this.cFg = null;
    this.cFh = null;
    this.cJw = com.tencent.f.c.d.hA(String.format("VideoThread_%s", new Object[] { Long.valueOf(System.currentTimeMillis()) }), 5);
    this.cJw.start();
    this.cJv = new Handler(this.cJw.getLooper());
    AppMethodBeat.o(138972);
  }
  
  private void Qp()
  {
    AppMethodBeat.i(138975);
    synchronized (this.cJu)
    {
      if (this.cJu.isEmpty()) {
        break label102;
      }
      Log.i(getLogTag(), "flushPendingTasks, size:%d", new Object[] { Integer.valueOf(this.cJu.size()) });
      Iterator localIterator = this.cJu.iterator();
      if (localIterator.hasNext()) {
        ((Runnable)localIterator.next()).run();
      }
    }
    this.cJu.clear();
    label102:
    AppMethodBeat.o(138975);
  }
  
  private void Qu()
  {
    AppMethodBeat.i(138996);
    if (this.cIV != null)
    {
      Log.i(getLogTag(), "releaseMediaPlayer");
      this.cIV.a(null);
      this.cIV.a(null);
      this.cIV.a(null);
      this.cIV.a(null);
      this.cIV.a(null);
      this.cIV.a(null);
      this.cIV.stop();
      this.cIV.reset();
      this.cIV.release();
    }
    this.cIV = null;
    this.cJk = false;
    AppMethodBeat.o(138996);
  }
  
  private void Qw()
  {
    boolean bool1 = true;
    AppMethodBeat.i(138998);
    boolean bool2;
    String str;
    boolean bool3;
    if (this.cIV != null)
    {
      this.cIV.setMute(this.cJm);
      if (this.mSurface != null)
      {
        bool2 = this.cFe.get();
        if ((!this.cJs) && (!bool2))
        {
          Log.i(getLogTag(), "applyMediaPlayerParams, setSurface");
          this.cIV.setSurface(this.mSurface);
          AppMethodBeat.o(138998);
          return;
        }
        str = getLogTag();
        bool3 = this.cJs;
        if (this.cJy == null) {
          break label169;
        }
      }
    }
    for (;;)
    {
      Log.i(str, "applyMediaPlayerParams, setSurface, WebViewInBackground: %b, JustPlayAudio: %b, SurfacePipSet exist: %b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if ((this.cJs) && (this.cJy != null)) {
        this.cIV.setSurface(this.cJy);
      }
      AppMethodBeat.o(138998);
      return;
      label169:
      bool1 = false;
    }
  }
  
  private void Qx()
  {
    AppMethodBeat.i(138999);
    if (this.mSurface != null)
    {
      this.mSurface.release();
      this.mSurface = null;
    }
    AppMethodBeat.o(138999);
  }
  
  public final void PQ()
  {
    AppMethodBeat.i(138976);
    k(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(138965);
        c.a(c.this);
        AppMethodBeat.o(138965);
      }
    });
    AppMethodBeat.o(138976);
  }
  
  /* Error */
  final boolean PS()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 478	com/tencent/luggage/xweb_ext/extendplugin/component/video/c:cEJ	Z
    //   6: ifeq +18 -> 24
    //   9: aload_0
    //   10: getfield 480	com/tencent/luggage/xweb_ext/extendplugin/component/video/c:cIW	Lcom/tencent/luggage/xweb_ext/extendplugin/component/video/b/d;
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
    //   0	34	0	this	c
    //   19	7	1	bool	boolean
    //   13	2	2	locald	com.tencent.luggage.xweb_ext.extendplugin.component.video.b.d
    //   29	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	29	finally
  }
  
  final boolean PT()
  {
    AppMethodBeat.i(215725);
    boolean bool = this.cEV.d(this.cED);
    AppMethodBeat.o(215725);
    return bool;
  }
  
  public final void PU()
  {
    AppMethodBeat.i(215719);
    k(new c.20(this));
    AppMethodBeat.o(215719);
  }
  
  final boolean PV()
  {
    AppMethodBeat.i(215727);
    if (this.cED == null)
    {
      Log.w(getLogTag(), "amIBackgroundAudioPlayer, mInsertInvokeContext is null");
      AppMethodBeat.o(215727);
      return false;
    }
    com.tencent.mm.plugin.appbrand.jsapi.ag.a locala = com.tencent.luggage.xweb_ext.extendplugin.component.e.f(this.cED);
    if (locala == null)
    {
      Log.w(getLogTag(), "amIBackgroundAudioPlayer, audioOfVideoBackgroundPlayManager is null");
      AppMethodBeat.o(215727);
      return false;
    }
    boolean bool = locala.a(this);
    AppMethodBeat.o(215727);
    return bool;
  }
  
  public final boolean Qo()
  {
    AppMethodBeat.i(177165);
    if ((this.cET != null) && (this.cET.get()))
    {
      AppMethodBeat.o(177165);
      return true;
    }
    AppMethodBeat.o(177165);
    return false;
  }
  
  final void Qq()
  {
    AppMethodBeat.i(138979);
    if ((this.cIV != null) && (this.mSurfaceTexture != null))
    {
      int i = this.cIV.getVideoWidth();
      int j = this.cIV.getVideoHeight();
      if ((i == 0) && (j == 0))
      {
        Log.w(getLogTag(), "VideoCanvas, registerMediaPlayer, width or height is 0");
        AppMethodBeat.o(138979);
        return;
      }
      if (!this.cJt)
      {
        this.cJt = true;
        com.tencent.mm.plugin.appbrand.i.a.bCz().a(getId(), this, this.mSurfaceTexture, i, j, this.cED.getAppId());
        AppMethodBeat.o(138979);
        return;
      }
      Log.w(getLogTag(), "VideoCanvas, registerMediaPlayer, already registered");
      AppMethodBeat.o(138979);
      return;
    }
    Log.w(getLogTag(), "VideoCanvas, registerMediaPlayer, media player or surface texture is null");
    AppMethodBeat.o(138979);
  }
  
  final boolean Qr()
  {
    AppMethodBeat.i(178849);
    Object localObject;
    if ((this.cED instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      localObject = this.cED.NN();
      if ((localObject instanceof com.tencent.mm.plugin.appbrand.page.ac)) {
        localObject = (com.tencent.mm.plugin.appbrand.page.ac)localObject;
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.appbrand.page.ac)localObject).getRuntime();
        Log.i(getLogTag(), "cancelResumePlayingWhenRelaunch:%s", new Object[] { Boolean.valueOf(((AppBrandRuntime)localObject).kAK) });
        boolean bool = ((AppBrandRuntime)localObject).kAK;
        AppMethodBeat.o(178849);
        return bool;
        if ((localObject instanceof com.tencent.mm.plugin.appbrand.s)) {
          localObject = ((com.tencent.mm.plugin.appbrand.s)localObject).getCurrentPageView();
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
  
  public final void Qs()
  {
    AppMethodBeat.i(215720);
    k(new c.22(this));
    AppMethodBeat.o(215720);
  }
  
  final boolean Qt()
  {
    AppMethodBeat.i(138987);
    if (this.cIV != null)
    {
      if (this.cJb != null) {
        this.cJb.a(this.cED, this.cIV);
      }
      if (!this.cJj)
      {
        Log.i(getLogTag(), "video stop, video not prepared yet, stop video when prepared");
        this.cJg = false;
        AppMethodBeat.o(138987);
        return true;
      }
      Log.i(getLogTag(), "video stop");
      Log.d(getLogTag(), "video stop, mWebViewInBackground: %b, isRuntimeInBackground: %b", new Object[] { Boolean.valueOf(this.cJs), Boolean.valueOf(this.cER) });
      com.tencent.f.h.RTc.aV(new c.25(this));
      this.cIV.stop();
      if (PS()) {
        this.cIW.cj(true);
      }
      AppMethodBeat.o(138987);
      return true;
    }
    AppMethodBeat.o(138987);
    return false;
  }
  
  final void Qv()
  {
    AppMethodBeat.i(215723);
    if ((this.cIV != null) && ((this.cIV instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f)))
    {
      f.b localb = ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f)this.cIV).bKI();
      if (this.cJb != null) {
        this.cJb.a(localb);
      }
    }
    AppMethodBeat.o(215723);
  }
  
  public final int Qy()
  {
    AppMethodBeat.i(177169);
    int i = (int)(this.cEH + (1.0F - this.cJD) * this.cEF / 2.0F);
    Log.d(getLogTag(), "getVideoPositionX, videoPosX: ".concat(String.valueOf(i)));
    AppMethodBeat.o(177169);
    return i;
  }
  
  public final int Qz()
  {
    AppMethodBeat.i(177170);
    int i = (int)(this.cEI + (1.0F - this.cJE) * this.cEG / 2.0F);
    Log.d(getLogTag(), "getVideoPositionY, videoPosY: ".concat(String.valueOf(i)));
    AppMethodBeat.o(177170);
    return i;
  }
  
  public final <AddOn extends com.tencent.luggage.xweb_ext.extendplugin.component.j> AddOn X(Class<AddOn> paramClass)
  {
    AppMethodBeat.i(215731);
    Log.i(getLogTag(), "getAddOn for " + paramClass.getSimpleName());
    paramClass = this.cFd.X(paramClass);
    AppMethodBeat.o(215731);
    return paramClass;
  }
  
  public final <AddOn extends com.tencent.luggage.xweb_ext.extendplugin.component.j> void a(Class<AddOn> paramClass, AddOn paramAddOn)
  {
    AppMethodBeat.i(215730);
    Log.i(getLogTag(), "setAddOn for " + paramClass.getSimpleName());
    this.cFd.a(paramClass, paramAddOn);
    AppMethodBeat.o(215730);
  }
  
  final String b(com.tencent.luggage.xweb_ext.extendplugin.a parama, String paramString)
  {
    AppMethodBeat.i(138982);
    String str = paramString;
    if (this.cJb != null) {
      str = this.cJb.b(parama, paramString);
    }
    AppMethodBeat.o(138982);
    return str;
  }
  
  final void c(com.tencent.luggage.xweb_ext.extendplugin.a parama, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(138981);
    if (!paramJSONObject.has("enableCasting"))
    {
      AppMethodBeat.o(138981);
      return;
    }
    boolean bool = paramJSONObject.optBoolean("enableCasting");
    Log.d(getLogTag(), "isEnableVideoCast = ".concat(String.valueOf(bool)));
    p(parama);
    this.cJc.mKL = bool;
    AppMethodBeat.o(138981);
  }
  
  final boolean ca(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(215716);
    boolean bool = k(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(138948);
        c localc = c.this;
        int i = paramInt1;
        int j = paramInt2;
        if (!localc.cJk)
        {
          Log.i(localc.getLogTag(), "onMediaPlayerError, mp released");
          AppMethodBeat.o(138948);
          return;
        }
        Log.i(localc.getLogTag(), "onError, what:%d, extra:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        if (localc.cIY != null) {
          localc.cIY.cd(i, j);
        }
        AppMethodBeat.o(138948);
      }
    });
    AppMethodBeat.o(215716);
    return bool;
  }
  
  final void cd(boolean paramBoolean)
  {
    AppMethodBeat.i(215717);
    if (!Util.isNullOrNil(this.cJq))
    {
      if ((QJ() != null) && (this.cJa != null))
      {
        float f1 = this.cJD;
        float f2 = this.cJE;
        if (this.cJa.a(this.cJq, this.cEF, this.cEG, this.mVideoWidth, this.mVideoHeight))
        {
          this.cJD = this.cJa.QH();
          this.cJE = this.cJa.QI();
          Log.i(getLogTag(), "adjust objectFit:%s, scale:[%s, %s]", new Object[] { this.cJq, Float.valueOf(this.cJD), Float.valueOf(this.cJE) });
          if ((!this.cJs) || (this.cJy == null)) {
            break label218;
          }
          this.cJA = true;
          Log.i(getLogTag(), "adjust objectFit, TextureScale sticky");
        }
        for (;;)
        {
          if (((this.cJD != f1) || (this.cJE != f2)) && (this.cJz != null)) {
            this.cJz.a(paramBoolean, this.cJD, this.cJE);
          }
          AppMethodBeat.o(215717);
          return;
          label218:
          com.tencent.luggage.xweb_ext.extendplugin.d.a(QJ(), this.type, getId(), this.cJD, this.cJE);
          this.cJA = false;
        }
      }
      Log.i(getLogTag(), "adjust objectFit, video not prepared");
      AppMethodBeat.o(215717);
      return;
    }
    Log.i(getLogTag(), "adjust objectFit, no video objectFit");
    AppMethodBeat.o(215717);
  }
  
  final void ce(boolean paramBoolean)
  {
    AppMethodBeat.i(215718);
    if (this.cIV != null)
    {
      Log.i(getLogTag(), "video prepare async");
      if ((paramBoolean) && (PS())) {
        this.cIW.onVideoWaiting();
      }
      this.cJj = false;
      this.cJg = false;
      if (this.cJb != null) {
        this.cJb.c(this.cIV);
      }
      this.cIV.prepareAsync();
    }
    AppMethodBeat.o(215718);
  }
  
  final void dT(String paramString)
  {
    AppMethodBeat.i(215724);
    Log.i(getLogTag(), "doCheckVideoUrl, videoPath: ".concat(String.valueOf(paramString)));
    com.tencent.f.h.RTc.aX(new c.35(this, paramString));
    AppMethodBeat.o(215724);
  }
  
  public final void e(final SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(138974);
    k(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(138945);
        c.a(c.this, paramSurfaceTexture);
        AppMethodBeat.o(138945);
      }
    });
    AppMethodBeat.o(138974);
  }
  
  public final boolean e(Surface paramSurface)
  {
    AppMethodBeat.i(215726);
    if (this.cIV != null)
    {
      if (!this.cFe.get())
      {
        this.cIV.setSurface(paramSurface);
        if (this.mSurface != paramSurface) {
          break label99;
        }
        this.cJy = null;
        label46:
        paramSurface = getLogTag();
        if (this.cJy == null) {
          break label107;
        }
      }
      label99:
      label107:
      for (boolean bool = true;; bool = false)
      {
        Log.i(paramSurface, "setSurface, SurfacePipSet exist: %b", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(215726);
        return true;
        Log.i(getLogTag(), "setSurface, JustPlayAudio");
        break;
        this.cJy = paramSurface;
        break label46;
      }
    }
    Log.w(getLogTag(), "setSurface, MediaPlayer is null");
    AppMethodBeat.o(215726);
    return false;
  }
  
  public final boolean g(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    return true;
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(138990);
    if (this.cIV != null)
    {
      int i = this.cIV.getCurrentPosition();
      AppMethodBeat.o(138990);
      return i;
    }
    AppMethodBeat.o(138990);
    return 0;
  }
  
  final int getDuration()
  {
    AppMethodBeat.i(138991);
    if (this.cIV != null)
    {
      int i = this.cIV.getDuration();
      AppMethodBeat.o(138991);
      return i;
    }
    AppMethodBeat.o(138991);
    return 0;
  }
  
  public final String getKey()
  {
    AppMethodBeat.i(177168);
    String str = Lb() + "@" + hashCode();
    AppMethodBeat.o(177168);
    return str;
  }
  
  public final String getLogTag()
  {
    AppMethodBeat.i(138973);
    String str = String.format("%s(%s)", new Object[] { "MicroMsg.SameLayer.VideoPluginHandler", Lb() });
    AppMethodBeat.o(138973);
    return str;
  }
  
  public final String getName()
  {
    AppMethodBeat.i(215729);
    String str = getKey();
    AppMethodBeat.o(215729);
    return str;
  }
  
  public final String h(final com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(138977);
    k(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(138966);
        c localc = c.this;
        com.tencent.luggage.xweb_ext.extendplugin.a locala = parama;
        String str = locala.Pt();
        Object localObject2;
        if (!Util.isNullOrNil(str))
        {
          localObject1 = locala.Ps();
          Log.i(localc.getLogTag(), "*** handler(%s) handleJsApi(%s), data:%s", new Object[] { localc.Lb(), str, ((JSONObject)localObject1).toString() });
          if (!str.contains("insert")) {
            break label992;
          }
          localc.cED = locala;
          if (localc.cIV == null)
          {
            Log.w(localc.getLogTag(), "insert, media player is null");
            localc.r(localc.cED);
          }
          Log.i(localc.getLogTag(), "registerLifecycleListener");
          localc.cEE = new c.6(localc);
          locala.a(localc.cEE);
          if (localc.cJb != null) {
            localc.cJb.v(locala);
          }
          if ((localc.mSurface != null) && (localc.cIV != null))
          {
            Log.i(localc.getLogTag(), "insert, setSurface");
            localc.cIV.setSurface(localc.mSurface);
          }
          localObject1 = locala.Ps();
          localc.cJi = ((JSONObject)localObject1).optBoolean("autoplay", false);
          localc.cJh = ((((JSONObject)localObject1).optDouble("initialTime", 0.0D) * 1000.0D));
          localc.cJl = ((JSONObject)localObject1).optBoolean("loop", false);
          localc.cJm = ((JSONObject)localObject1).optBoolean("muted", false);
          localc.cIV.setMute(localc.cJm);
          localc.cEK = ((JSONObject)localObject1).optBoolean("autoPauseIfNavigate", true);
          localc.cEL = ((JSONObject)localObject1).optBoolean("autoPauseIfOpenNative", true);
          localc.cEJ = ((JSONObject)localObject1).optBoolean("needEvent", false);
          if ((localc.cEJ) && (localc.cIW != null))
          {
            localc.cIW.m(locala);
            localObject2 = ((JSONObject)localObject1).optString("data", "");
            localc.cIW.dV((String)localObject2);
            if (localc.cIX != null)
            {
              localc.cIX.m(locala);
              localc.cIX.dV((String)localObject2);
            }
          }
          if (((JSONObject)localObject1).has("position"))
          {
            localObject2 = ((JSONObject)localObject1).optJSONObject("position");
            if (localObject2 != null)
            {
              localc.cEF = com.tencent.mm.plugin.appbrand.ac.g.zD(((JSONObject)localObject2).optInt("width", 0));
              localc.cEG = com.tencent.mm.plugin.appbrand.ac.g.zD(((JSONObject)localObject2).optInt("height", 0));
              Log.i(localc.getLogTag(), "insert, size:[%d, %d]", new Object[] { Integer.valueOf(localc.cEF), Integer.valueOf(localc.cEG) });
            }
          }
          localc.cJq = ((JSONObject)localObject1).optString("objectFit", "contain");
          if (Util.isNullOrNil(localc.cJq)) {
            localc.cJq = "contain";
          }
          localc.cd(true);
          localObject2 = locala.NN();
          if (localObject2 != null) {
            break label822;
          }
          Log.w(localc.getLogTag(), "updateReferrers, component is null");
          localc.cJp = ((JSONObject)localObject1).optString("filePath");
          if (!Util.isNullOrNil(localc.cJp))
          {
            if (localc.cJb != null) {
              localc.cJb.a(localc.cIV, localc.cJp);
            }
            localObject2 = localc.b(locala, localc.cJp);
            Log.i(localc.getLogTag(), "insert, path:%s, proxy:%s", new Object[] { localc.cJp, localObject2 });
            if (!Util.isNullOrNil((String)localObject2))
            {
              localc.cIV.dU((String)localObject2, localc.cEO);
              localc.dT((String)localObject2);
              Log.i(localc.getLogTag(), "insert, media player prepare async");
              localc.ce(true);
            }
          }
          localc.mTitle = ((JSONObject)localObject1).optString("title", localc.mTitle);
          localc.cFf = ((JSONObject)localObject1).optString("backgroundPoster", localc.cFf);
          localc.c(locala, (JSONObject)localObject1);
          locala.dP("ok");
        }
        label804:
        label822:
        Object localObject3;
        Object localObject4;
        for (;;)
        {
          localc.cEU.a(str, locala);
          if (localc.cJp == null) {
            break label4222;
          }
          localObject1 = localc.cJp;
          localc.cEV.a(locala, (String)localObject1);
          AppMethodBeat.o(138966);
          return;
          localObject3 = (com.tencent.mm.plugin.appbrand.jsapi.u.a)com.tencent.luggage.a.e.M(com.tencent.mm.plugin.appbrand.jsapi.u.a.class);
          if (localObject3 == null)
          {
            Log.w(localc.getLogTag(), "updateReferrers, referrerHelper is null");
            break;
          }
          if (localc.cEN == null) {
            localc.cEN = ((com.tencent.mm.plugin.appbrand.jsapi.u.a)localObject3).bIw();
          }
          localObject4 = ((com.tencent.mm.plugin.appbrand.jsapi.u.a)localObject3).a((JSONObject)localObject1, (com.tencent.mm.plugin.appbrand.jsapi.f)localObject2);
          if (localObject4 != null) {
            localc.cEN = ((com.tencent.mm.plugin.appbrand.jsapi.u.c)localObject4);
          }
          Log.i(localc.getLogTag(), "updateReferrers, mReferrerPolicy: " + localc.cEN);
          if (com.tencent.mm.plugin.appbrand.jsapi.u.c.mou == localc.cEN)
          {
            localc.cEO = null;
            break;
          }
          localc.cEO = ((com.tencent.mm.plugin.appbrand.jsapi.u.a)localObject3).y((com.tencent.mm.plugin.appbrand.jsapi.f)localObject2);
          Log.i(localc.getLogTag(), "updateReferrers, mReferrer: " + localc.cEO);
          break;
          label992:
          if (!str.contains("update")) {
            break label2268;
          }
          if (localc.cIV != null) {
            break label1036;
          }
          Log.w(localc.getLogTag(), "update, media player is null");
          locala.dP("fail");
        }
        label1036:
        Object localObject1 = locala.Ps();
        if (((JSONObject)localObject1).has("filePath"))
        {
          localObject2 = ((JSONObject)localObject1).optString("filePath");
          if ((!Util.isNullOrNil((String)localObject2)) && (!((String)localObject2).equalsIgnoreCase(localc.cJp)))
          {
            localc.cJp = ((String)localObject2);
            localObject2 = localc.b(locala, localc.cJp);
            Log.i(localc.getLogTag(), "update, path:%s, proxy:%s", new Object[] { localc.cJp, localObject2 });
            if ((localc.cIV == null) || (!Util.isNullOrNil((String)localObject2)))
            {
              localc.cJr = false;
              localc.Qt();
              localc.q(locala);
            }
            if (localc.cJb != null) {
              localc.cJb.a(localc.cIV, localc.cJp);
            }
            localc.Qv();
            localc.cIV.dU((String)localObject2, localc.cEO);
            localc.dT((String)localObject2);
          }
        }
        for (int j = 1;; j = 0)
        {
          boolean bool2;
          boolean bool1;
          if ((localc.mSurface != null) && (localc.cIV != null))
          {
            bool2 = localc.cFe.get();
            if ((!localc.cJs) && (!bool2))
            {
              Log.i(localc.getLogTag(), "update, setSurface");
              localc.cIV.setSurface(localc.mSurface);
            }
          }
          else
          {
            if (((JSONObject)localObject1).has("autoplay")) {
              localc.cJi = ((JSONObject)localObject1).optBoolean("autoplay", localc.cJi);
            }
            if (((JSONObject)localObject1).has("initialTime")) {
              localc.cJh = ((((JSONObject)localObject1).optDouble("initialTime", 0.0D) * 1000.0D));
            }
            if (((JSONObject)localObject1).has("loop")) {
              localc.cJl = ((JSONObject)localObject1).optBoolean("loop", localc.cJl);
            }
            if (((JSONObject)localObject1).has("muted"))
            {
              bool1 = localc.cJm;
              localc.cJm = ((JSONObject)localObject1).optBoolean("muted", localc.cJm);
              localc.cIV.setMute(localc.cJm);
              if ((localc.cJm != bool1) && (localc.isPlaying()) && (!localc.cJs) && (!localc.cER))
              {
                bool1 = localc.cJm;
                com.tencent.f.h.RTc.aV(new c.19(localc, bool1));
              }
            }
            if (((JSONObject)localObject1).has("autoPauseIfNavigate")) {
              localc.cEK = ((JSONObject)localObject1).optBoolean("autoPauseIfNavigate", localc.cEK);
            }
            if (((JSONObject)localObject1).has("autoPauseIfOpenNative")) {
              localc.cEL = ((JSONObject)localObject1).optBoolean("autoPauseIfOpenNative", localc.cEL);
            }
            if (((JSONObject)localObject1).has("needEvent")) {
              localc.cEJ = ((JSONObject)localObject1).optBoolean("needEvent", localc.cEJ);
            }
            if ((localc.cEJ) && (localc.cIW != null))
            {
              localc.cIW.m(locala);
              localObject2 = ((JSONObject)localObject1).optString("data", "");
              if (((JSONObject)localObject1).has("data")) {
                localc.cIW.dV((String)localObject2);
              }
              if (localc.cIX != null)
              {
                if (((JSONObject)localObject1).has("data")) {
                  localc.cIX.dV((String)localObject2);
                }
                localc.cIX.m(locala);
              }
            }
            int i = 0;
            bool1 = false;
            bool2 = false;
            if (((JSONObject)localObject1).has("position"))
            {
              localObject2 = ((JSONObject)localObject1).optJSONObject("position");
              bool1 = bool2;
              if (localObject2 != null)
              {
                i = localc.cEF;
                int k = localc.cEG;
                localc.cEF = com.tencent.mm.plugin.appbrand.ac.g.zD(((JSONObject)localObject2).optInt("width", i));
                localc.cEG = com.tencent.mm.plugin.appbrand.ac.g.zD(((JSONObject)localObject2).optInt("height", k));
                Log.i(localc.getLogTag(), "update, size:[%d, %d]", new Object[] { Integer.valueOf(localc.cEF), Integer.valueOf(localc.cEG) });
                if (localc.cEF == i)
                {
                  bool1 = bool2;
                  if (localc.cEG == k) {}
                }
                else
                {
                  bool1 = true;
                }
              }
              i = 1;
            }
            bool2 = bool1;
            if (((JSONObject)localObject1).has("objectFit"))
            {
              localObject2 = localc.cJq;
              localc.cJq = ((JSONObject)localObject1).optString("objectFit", (String)localObject2);
              if (Util.isNullOrNil(localc.cJq)) {
                localc.cJq = "contain";
              }
              if (!localc.cJq.equals(localObject2)) {
                bool1 = false;
              }
              i = 1;
              bool2 = bool1;
            }
            if (i != 0) {
              localc.cd(bool2);
            }
            localc.c(locala, (JSONObject)localObject1);
            localObject2 = ((JSONObject)localObject1).optString("filePath");
            if ((localc.cJc != null) && (localc.cJc.bMh()))
            {
              localObject3 = localc.cJc;
              p.h(localObject2, "updateVideoPath");
              Log.i("MicroMsg.VideoCast.AppBrandVideoCastHandler", "updateVideoPath: [" + (String)localObject2 + ']');
              if (!kotlin.n.n.aL((CharSequence)kotlin.n.n.trim((CharSequence)localObject2).toString()))
              {
                ((com.tencent.mm.plugin.appbrand.jsapi.ag.e.b)localObject3).bMi().bMr();
                if (!p.j(localObject2, ((com.tencent.mm.plugin.appbrand.jsapi.ag.e.b)localObject3).videoPath))
                {
                  ((com.tencent.mm.plugin.appbrand.jsapi.ag.e.b)localObject3).setVideoPath((String)localObject2);
                  ((com.tencent.mm.plugin.appbrand.jsapi.ag.e.b)localObject3).hV(true);
                  ((com.tencent.mm.plugin.appbrand.jsapi.ag.e.b)localObject3).bMi().t((kotlin.g.a.b)new b.f((com.tencent.mm.plugin.appbrand.jsapi.ag.e.b)localObject3));
                  if (((com.tencent.mm.plugin.appbrand.jsapi.ag.e.b)localObject3).bMi().dYn != -1) {
                    break label2256;
                  }
                  ((com.tencent.mm.plugin.appbrand.jsapi.ag.e.b)localObject3).bMi().dYn = 8;
                }
              }
            }
          }
          for (;;)
          {
            localc.mTitle = ((JSONObject)localObject1).optString("title", localc.mTitle);
            localc.cFf = ((JSONObject)localObject1).optString("backgroundPoster", localc.cFf);
            if (j != 0)
            {
              Log.i(localc.getLogTag(), "update, media player prepare async");
              localc.ce(true);
            }
            locala.dP("ok");
            break;
            localObject2 = localc.getLogTag();
            boolean bool3 = localc.cJs;
            if (localc.cJy != null) {}
            for (bool1 = true;; bool1 = false)
            {
              Log.i((String)localObject2, "update, setSurface, WebViewInBackground: %b, JustPlayAudio: %b, SurfacePipSet exist: %b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
              if ((!localc.cJs) || (localc.cJy == null)) {
                break;
              }
              localc.cIV.setSurface(localc.cJy);
              break;
            }
            label2256:
            Log.i("MicroMsg.VideoCast.AppBrandVideoCastHandler", "discard a updateVideoPath report event");
          }
          label2268:
          if ((str.contains("operate")) && (str.contains("Background")))
          {
            if (localc.cIV == null)
            {
              Log.w(localc.getLogTag(), "operateBackground, media player is null");
              locala.dP("fail");
              break;
            }
            localObject1 = locala.Ps();
            bool1 = false;
            localObject1 = ((JSONObject)localObject1).optString("type");
            if (Util.isNullOrNil((String)localObject1)) {
              break;
            }
            Log.i(localc.getLogTag(), "operateBackground, type:%s", new Object[] { localObject1 });
            if (((String)localObject1).equalsIgnoreCase("stop"))
            {
              bool2 = localc.s(locala);
              bool1 = bool2;
              if (bool2)
              {
                bool1 = bool2;
                if (localc.cER)
                {
                  Log.i(localc.getLogTag(), "operateBackground, isRuntimeInBackground, setPlayingWhenEnterBackground false");
                  localc.cET = new AtomicBoolean(false);
                  bool1 = bool2;
                }
              }
            }
            if (bool1) {}
            for (localObject1 = "ok";; localObject1 = "fail")
            {
              locala.dP((String)localObject1);
              break;
            }
          }
          if (str.contains("operate"))
          {
            if (localc.cIV == null)
            {
              Log.w(localc.getLogTag(), "operate, media player is null");
              locala.dP("fail");
              break;
            }
            localObject3 = locala.Ps();
            bool2 = false;
            localObject2 = ((JSONObject)localObject3).optString("type");
            if (Util.isNullOrNil((String)localObject2)) {
              break;
            }
            Log.i(localc.getLogTag(), "operate, type:%s", new Object[] { localObject2 });
            if (((String)localObject2).equalsIgnoreCase("startCasting"))
            {
              bool1 = true;
              label2581:
              if (!bool1) {
                break label3293;
              }
              Log.i(localc.getLogTag(), "video cast operate, type:%s", new Object[] { localObject2 });
              if (localc.cJc == null) {
                localc.p(locala);
              }
              localc.cJc.setVideoPath(localc.cJp);
              localc.cJc.mKG = localc.getCurrentPosition();
              if (!((String)localObject2).equalsIgnoreCase("requestFullScreen")) {
                break label2770;
              }
              bool1 = localc.j(locala);
              label2667:
              if (!((String)localObject2).equalsIgnoreCase("snapshot")) {
                break label4151;
              }
              Log.i(localc.getLogTag(), "getSnapshotCached");
              if (localc.cJb != null) {
                break label4136;
              }
              locala.dP("fail:snapshot error");
            }
            for (;;)
            {
              label2708:
              if ((!((String)localObject2).equalsIgnoreCase("pause")) && (!((String)localObject2).equalsIgnoreCase("stop"))) {
                break label4172;
              }
              localc.cEV.b(locala);
              break;
              if (localc.cJc == null)
              {
                bool1 = false;
                break label2581;
              }
              bool1 = localc.cJc.bMh();
              break label2581;
              label2770:
              if (((String)localObject2).equalsIgnoreCase("exitFullScreen"))
              {
                bool1 = localc.k(locala);
                break label2667;
              }
              localObject1 = localc.cJc;
              p.h(localObject3, "data");
              p.h(locala, "invokeContext");
              localObject4 = ((JSONObject)localObject3).optString("type");
              Log.i("MicroMsg.VideoCast.AppBrandVideoCastHandler", "handleOperate: type = ".concat(String.valueOf(localObject4)));
              if (localObject4 == null)
              {
                bool1 = true;
                break label2667;
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
                          com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h.b(((com.tencent.mm.plugin.appbrand.jsapi.ag.e.b)localObject1).bMi());
                          bool1 = true;
                          break;
                          if (((String)localObject4).equals("reconnectCasting"))
                          {
                            localObject3 = ((com.tencent.mm.plugin.appbrand.jsapi.ag.e.b)localObject1).mKJ;
                            if (localObject3 != null) {
                              ((com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.c)localObject3).xV(5);
                            }
                            localObject1 = ((com.tencent.mm.plugin.appbrand.jsapi.ag.e.b)localObject1).bMi();
                            if (((com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h)localObject1).mLW.bMs().bBp() != e.a.lkl) {
                              break label3267;
                            }
                            ((com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h)localObject1).mMw.cg(true);
                            bool1 = true;
                            break;
                            if (((String)localObject4).equals("exitCasting"))
                            {
                              localObject3 = ((com.tencent.mm.plugin.appbrand.jsapi.ag.e.b)localObject1).mKJ;
                              if (localObject3 != null) {
                                ((com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.c)localObject3).xV(6);
                              }
                              com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h.d(((com.tencent.mm.plugin.appbrand.jsapi.ag.e.b)localObject1).bMi());
                              ((com.tencent.mm.plugin.appbrand.jsapi.ag.e.b)localObject1).bMi().destroy();
                              ((com.tencent.mm.plugin.appbrand.jsapi.ag.e.b)localObject1).mKM = false;
                              ((com.tencent.mm.plugin.appbrand.jsapi.ag.e.b)localObject1).hV(false);
                            }
                          }
                        }
                      }
                    } while (!((String)localObject4).equals("startCasting"));
                    ((com.tencent.mm.plugin.appbrand.jsapi.ag.e.b)localObject1).bMi().mMn = ((kotlin.g.a.a)new b.e((com.tencent.mm.plugin.appbrand.jsapi.ag.e.b)localObject1));
                    com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h.a(((com.tencent.mm.plugin.appbrand.jsapi.ag.e.b)localObject1).bMi());
                    bool1 = true;
                    break;
                  } while (!((String)localObject4).equals("switchCasting"));
                  localObject3 = ((com.tencent.mm.plugin.appbrand.jsapi.ag.e.b)localObject1).mKJ;
                  if (localObject3 != null) {
                    ((com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.c)localObject3).xV(4);
                  }
                  ((com.tencent.mm.plugin.appbrand.jsapi.ag.e.b)localObject1).bMi().x(false, true);
                  bool1 = true;
                  break;
                } while (!((String)localObject4).equals("seek"));
                long l = com.tencent.mm.plugin.appbrand.jsapi.ag.e.b.al((JSONObject)localObject3);
                if (l <= 0L) {
                  break label3252;
                }
                ((com.tencent.mm.plugin.appbrand.jsapi.ag.e.b)localObject1).bMi().abP(b.c.xU((int)l));
                bool1 = true;
                break;
              } while (!((String)localObject4).equals("pause"));
              com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h.c(((com.tencent.mm.plugin.appbrand.jsapi.ag.e.b)localObject1).bMi());
              bool1 = true;
              break label2667;
              label3252:
              Log.i("MicroMsg.VideoCast.AppBrandVideoCastHandler", "invalid seek position");
              bool1 = false;
              break label2667;
              label3267:
              ((com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h)localObject1).mLW.v((kotlin.g.a.b)new h.p((com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h)localObject1));
              bool1 = true;
              break label2667;
              label3293:
              if (((String)localObject2).equalsIgnoreCase("play"))
              {
                bool1 = localc.i(false, true);
                break label2667;
              }
              if (((String)localObject2).equalsIgnoreCase("pause"))
              {
                bool1 = localc.pause();
                break label2667;
              }
              if (((String)localObject2).equalsIgnoreCase("stop"))
              {
                bool2 = localc.Qt();
                bool1 = bool2;
                if (!bool2) {
                  break label2667;
                }
                bool1 = bool2;
                if (!localc.cER) {
                  break label2667;
                }
                Log.i(localc.getLogTag(), "stop, isRuntimeInBackground, setPlayingWhenEnterBackground false");
                localc.cET = new AtomicBoolean(false);
                bool1 = bool2;
                break label2667;
              }
              label3480:
              double d;
              if (((String)localObject2).equalsIgnoreCase("seek"))
              {
                if ((localc.cIV != null) && (localObject3 != null) && (((JSONObject)localObject3).has("data")))
                {
                  localObject1 = ((JSONObject)localObject3).optJSONArray("data");
                  if ((localObject1 != null) && (((JSONArray)localObject1).length() != 0)) {
                    break label3480;
                  }
                  Log.w(localc.getLogTag(), "seek, data array is null");
                }
                for (;;)
                {
                  bool1 = false;
                  break;
                  d = ((JSONArray)localObject1).optDouble(0, -1.0D);
                  if (d >= 0.0D) {
                    break label3521;
                  }
                  Log.w(localc.getLogTag(), "seek, invalid position:%s", new Object[] { Double.valueOf(d) });
                }
                label3521:
                localc.seek((d * 1000.0D));
                bool1 = true;
                break label2667;
              }
              if (((String)localObject2).equalsIgnoreCase("playbackRate"))
              {
                if ((localc.cIV != null) && (localObject3 != null) && (((JSONObject)localObject3).has("data")))
                {
                  localObject1 = ((JSONObject)localObject3).optJSONArray("data");
                  if ((localObject1 != null) && (((JSONArray)localObject1).length() != 0)) {
                    break label3611;
                  }
                  Log.w(localc.getLogTag(), "speed, data array is null");
                }
                for (;;)
                {
                  bool1 = false;
                  break;
                  label3611:
                  d = ((JSONArray)localObject1).optDouble(0, -1.0D);
                  if (d >= 0.0D) {
                    break label3652;
                  }
                  Log.w(localc.getLogTag(), "speed, invalid rate:%s", new Object[] { Double.valueOf(d) });
                }
                label3652:
                Log.i(localc.getLogTag(), "speed, speed:%s", new Object[] { Double.valueOf(d) });
                bool1 = localc.cIV.aP((float)d);
                break label2667;
              }
              if (((String)localObject2).equalsIgnoreCase("requestFullScreen"))
              {
                bool1 = localc.j(locala);
                break label2667;
              }
              if (((String)localObject2).equalsIgnoreCase("exitFullScreen"))
              {
                bool1 = localc.k(locala);
                break label2667;
              }
              if (((String)localObject2).equalsIgnoreCase("setScreenBrightness"))
              {
                Log.i(localc.getLogTag(), "setScreenBrightness");
                if ((localc.cJb != null) && (localc.cJb.t(locala)))
                {
                  bool1 = true;
                  break label2667;
                }
                bool1 = false;
                break label2667;
              }
              if (((String)localObject2).equalsIgnoreCase("exitPictureInPicture"))
              {
                bool1 = localc.cEV.c(locala);
                break label2667;
              }
              if (((String)localObject2).equalsIgnoreCase("requestBackgroundPlayback"))
              {
                Log.d(localc.getLogTag(), "enableBackgroundPlayAudio");
                if (!localc.cFb)
                {
                  Log.d(localc.getLogTag(), "registerAddOnPlayAudio");
                  localc.a(m.class, new c.39(localc));
                  Log.d(localc.getLogTag(), "registerAddOnVideoController");
                  localc.a(com.tencent.luggage.xweb_ext.extendplugin.component.n.class, new c.40(localc));
                  Log.d(localc.getLogTag(), "registerAddOnInfo");
                  localc.a(l.class, new c.41(localc));
                  Log.d(localc.getLogTag(), "registerAddOnGetSnapshot");
                  localc.a(k.class, new c.43(localc));
                  localc.cFb = true;
                }
                Log.d(localc.getLogTag(), "enableBackgroundPlayAudioInternal");
                if (locala == null)
                {
                  Log.w(localc.getLogTag(), "enableBackgroundPlayAudioInternal, invokeContext is null");
                  bool1 = false;
                }
                for (;;)
                {
                  if (!bool1) {
                    break label4103;
                  }
                  localc.cFe.set(true);
                  if (localc.cIV != null) {
                    localc.cIV.setSurface(null);
                  }
                  localc.cFc = true;
                  if (localc.cIW != null) {
                    localc.cIW.ck(true);
                  }
                  bool1 = true;
                  break;
                  localObject1 = com.tencent.luggage.xweb_ext.extendplugin.component.e.f(locala);
                  if (localObject1 == null)
                  {
                    Log.w(localc.getLogTag(), "enableBackgroundPlayAudioInternal, audioOfVideoBackgroundPlayManager is null");
                    bool1 = false;
                  }
                  else
                  {
                    bool1 = ((com.tencent.mm.plugin.appbrand.jsapi.ag.a)localObject1).b(localc);
                  }
                }
                label4103:
                bool1 = false;
                break label2667;
              }
              bool1 = bool2;
              if (!((String)localObject2).equalsIgnoreCase("exitBackgroundPlayback")) {
                break label2667;
              }
              bool1 = localc.s(locala);
              break label2667;
              label4136:
              localc.cJx = locala;
              localc.takeScreenshot();
            }
            label4151:
            if (bool1) {}
            for (localObject1 = "ok";; localObject1 = "fail")
            {
              locala.dP((String)localObject1);
              break label2708;
              label4172:
              break;
            }
          }
          if (!str.contains("remove")) {
            break;
          }
          localc.release();
          locala.dP("ok");
          localc.cEV.b(locala);
          break;
          label4222:
          localObject1 = "";
          break label804;
        }
      }
    });
    AppMethodBeat.o(138977);
    return null;
  }
  
  final boolean i(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(177166);
    if (this.cIV != null)
    {
      if ((this.cJj) && (this.cIV.isPlaying()))
      {
        Log.i(getLogTag(), "video play, video is playing");
        if (PS()) {
          this.cIW.ci(paramBoolean1);
        }
        AppMethodBeat.o(177166);
        return true;
      }
      if ((this.cIV != null) && (!this.cJj))
      {
        Log.i(getLogTag(), "video play, video not prepared yet, start until prepared");
        this.cJg = true;
        AppMethodBeat.o(177166);
        return true;
      }
      if ((this.cIV != null) && (this.cIV.getState() == 5))
      {
        if (!paramBoolean2)
        {
          Log.i(getLogTag(), "video has ended playing, do not restart");
          AppMethodBeat.o(177166);
          return false;
        }
        Log.i(getLogTag(), "video play, video has stopped now, try prepare and start when prepared");
        ce(true);
        this.cJg = true;
        AppMethodBeat.o(177166);
        return true;
      }
      if (this.cJr)
      {
        if (!paramBoolean2)
        {
          Log.i(getLogTag(), "video has ended playing, do not restart");
          AppMethodBeat.o(177166);
          return false;
        }
        Log.i(getLogTag(), "video play, video has ended playing, clear surface and start again");
        this.cJr = false;
        try
        {
          if ((this.mSurfaceTexture != null) && (this.cJj))
          {
            Log.i(getLogTag(), "clearSurfaceTexture");
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
            Log.printErrStackTrace(getLogTag(), localException, "clearSurfaceTexture error", new Object[0]);
            continue;
            Qv();
            this.cIV.dU(this.cJp, this.cEO);
            dT(this.cJp);
          }
        }
        q(this.cED);
        if (this.cIV != null)
        {
          this.cJi = true;
          localObject1 = b(this.cED, this.cJp);
          if (!Util.isNullOrNil((String)localObject1))
          {
            Qv();
            this.cIV.dU((String)localObject1, this.cEO);
            dT((String)localObject1);
            Log.i(getLogTag(), "video play, media player state:%s", new Object[] { Integer.valueOf(this.cIV.getState()) });
            ce(false);
            this.cJg = true;
          }
        }
        else
        {
          AppMethodBeat.o(177166);
          return true;
        }
      }
      Log.i(getLogTag(), "video play");
      if (this.cIV != null)
      {
        if (PS()) {
          this.cIW.ci(paramBoolean1);
        }
        Log.i(getLogTag(), "applyPluginTextureScaleIfNeed");
        if (this.cJA) {
          break label847;
        }
        Log.i(getLogTag(), "applyPluginTextureScaleIfNeed, TextureScale is not sticky");
      }
      for (;;)
      {
        Log.d(getLogTag(), "video play, mWebViewInBackground: %b, isRuntimeInBackground: %b", new Object[] { Boolean.valueOf(this.cJs), Boolean.valueOf(this.cER) });
        if ((!this.cJs) && (!this.cER) && (!this.cJm)) {
          com.tencent.f.h.RTc.aV(new c.21(this));
        }
        this.cIV.start();
        AppMethodBeat.o(177166);
        return true;
        label847:
        if ((this.cJs) && (this.cJy != null)) {
          Log.i(getLogTag(), "applyPluginTextureScaleIfNeed, in PIP mode");
        } else {
          com.tencent.luggage.xweb_ext.extendplugin.d.a(QJ(), this.type, getId(), this.cJD, this.cJE);
        }
      }
    }
    AppMethodBeat.o(177166);
    return false;
  }
  
  final boolean isPlaying()
  {
    AppMethodBeat.i(138989);
    if (this.cIV != null)
    {
      boolean bool = this.cIV.isPlaying();
      AppMethodBeat.o(138989);
      return bool;
    }
    AppMethodBeat.o(138989);
    return false;
  }
  
  final boolean j(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(138993);
    Log.i(getLogTag(), "requestFullscreen");
    if ((this.cJb != null) && (this.cJb.j(parama)))
    {
      AppMethodBeat.o(138993);
      return true;
    }
    AppMethodBeat.o(138993);
    return false;
  }
  
  final boolean k(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(138994);
    Log.i(getLogTag(), "exitFullscreen");
    if ((this.cJb != null) && (this.cJb.k(parama)))
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
    if (this.cJv != null)
    {
      if (this.cJv.getLooper() == Looper.myLooper()) {
        paramRunnable.run();
      }
      for (;;)
      {
        AppMethodBeat.o(138980);
        return true;
        this.cJv.post(paramRunnable);
      }
    }
    AppMethodBeat.o(138980);
    return false;
  }
  
  final void p(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(138978);
    if (this.cJc != null)
    {
      AppMethodBeat.o(138978);
      return;
    }
    this.cJc = this.cJb.a(this.cIX, parama);
    AppMethodBeat.o(138978);
  }
  
  final boolean pause()
  {
    AppMethodBeat.i(138986);
    if (this.cIV != null)
    {
      if (!this.cJj)
      {
        Log.i(getLogTag(), "video pause, video not prepared yet, pause video when prepared");
        this.cJg = false;
        AppMethodBeat.o(138986);
        return true;
      }
      if (!this.cIV.isPlaying())
      {
        Log.i(getLogTag(), "video pause, video is not playing");
        AppMethodBeat.o(138986);
        return true;
      }
      Log.i(getLogTag(), "video pause");
      Log.d(getLogTag(), "video pause, mWebViewInBackground: %b, isRuntimeInBackground: %b", new Object[] { Boolean.valueOf(this.cJs), Boolean.valueOf(this.cER) });
      com.tencent.f.h.RTc.aV(new c.24(this));
      this.cIV.pause();
      if (PS()) {
        this.cIW.cj(false);
      }
      AppMethodBeat.o(138986);
      return true;
    }
    AppMethodBeat.o(138986);
    return false;
  }
  
  final void q(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(138995);
    Qu();
    r(parama);
    Qw();
    AppMethodBeat.o(138995);
  }
  
  final void r(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(138997);
    Log.i(getLogTag(), "createMediaPlayer");
    if (this.cJb != null) {
      this.cIV = this.cJb.a(parama, this.cJv);
    }
    if (this.cIV == null)
    {
      Log.e(getLogTag(), "createMediaPlayer, create media player fail");
      AppMethodBeat.o(138997);
      return;
    }
    this.cJk = true;
    this.cIV.a(new c.f()
    {
      public final boolean cb(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(215692);
        c localc = c.this;
        boolean bool = localc.k(new c.5(localc, paramAnonymousInt1, paramAnonymousInt2));
        AppMethodBeat.o(215692);
        return bool;
      }
    });
    this.cIV.a(new c.e()
    {
      public final boolean cc(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(215693);
        boolean bool = c.this.ca(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(215693);
        return bool;
      }
    });
    this.cIV.a(new c.g()
    {
      public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.c paramAnonymousc)
      {
        AppMethodBeat.i(215694);
        paramAnonymousc = c.this;
        paramAnonymousc.k(new c.3(paramAnonymousc));
        AppMethodBeat.o(215694);
      }
    });
    this.cIV.a(new com.tencent.mm.plugin.appbrand.jsapi.video.e.c.b()
    {
      public final void QA()
      {
        AppMethodBeat.i(215695);
        c localc = c.this;
        localc.k(new c.48(localc));
        AppMethodBeat.o(215695);
      }
    });
    this.cIV.a(new c.h()
    {
      public final void b(com.tencent.mm.plugin.appbrand.jsapi.video.e.c paramAnonymousc)
      {
        AppMethodBeat.i(215696);
        paramAnonymousc = c.this;
        paramAnonymousc.k(new c.47(paramAnonymousc));
        AppMethodBeat.o(215696);
      }
    });
    this.cIV.a(new c.i()
    {
      public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.c paramAnonymousc, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(215697);
        paramAnonymousc = c.this;
        paramAnonymousc.k(new c.46(paramAnonymousc, paramAnonymousInt1, paramAnonymousInt2));
        AppMethodBeat.o(215697);
      }
    });
    this.cIV.a(new com.tencent.mm.plugin.appbrand.jsapi.video.e.c.a()
    {
      public final void id(int paramAnonymousInt)
      {
        AppMethodBeat.i(215698);
        c localc = c.this;
        localc.k(new c.45(localc, paramAnonymousInt));
        AppMethodBeat.o(215698);
      }
    });
    if (this.cJB != null) {
      this.cJB.cf(this.cJj);
    }
    AppMethodBeat.o(138997);
  }
  
  final void release()
  {
    AppMethodBeat.i(215721);
    Log.i(getLogTag(), "video release");
    if (this.cJb != null) {
      this.cJb.w(this.cED);
    }
    Qt();
    Qv();
    Qu();
    if (this.cIW != null)
    {
      this.cIW.destroy();
      this.cIW = null;
      this.cIX = null;
    }
    if (this.cJc != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.ag.e.b localb = this.cJc;
      localb.bMi().destroy();
      localb.mKM = false;
      localb.hV(false);
      localb.bMi().bMr();
      this.cJc = null;
    }
    Qx();
    if (this.cED != null)
    {
      this.cED.Pu();
      this.cEE = null;
    }
    Log.i(getLogTag(), "video release handler thread");
    if (this.cJv != null) {
      this.cJv.removeCallbacksAndMessages(null);
    }
    if (this.cJw != null) {
      this.cJw.quitSafely();
    }
    AppMethodBeat.o(215721);
  }
  
  public final void s(Bitmap paramBitmap)
  {
    AppMethodBeat.i(178848);
    super.s(paramBitmap);
    Log.i(getLogTag(), "*** handler(%s) handlePluginScreenshotTaken", new Object[] { Lb() });
    Object localObject = this.cJx;
    int i;
    if (localObject == null)
    {
      Log.w(getLogTag(), "handlePluginScreenshotTaken4JsApiCall, invokeContext is null");
      i = 0;
    }
    for (;;)
    {
      if (i == 0)
      {
        localObject = this.cFg;
        if (localObject == null)
        {
          Log.w(getLogTag(), "handlePluginScreenshotTaken4NativeCall, getSnapshotCallback is null");
          AppMethodBeat.o(178848);
          return;
          if (paramBitmap == null)
          {
            Log.w(getLogTag(), "handlePluginScreenshotTaken4JsApiCall, bitmap is null");
            i = 0;
            continue;
          }
          if ((this.cEF == 0) || (this.cEG == 0)) {
            break label265;
          }
        }
      }
    }
    label265:
    for (Bitmap localBitmap = Bitmap.createScaledBitmap(paramBitmap, (int)(this.cJD * this.cEF), (int)(this.cJE * this.cEG), false);; localBitmap = paramBitmap)
    {
      this.cJb.a((com.tencent.luggage.xweb_ext.extendplugin.a)localObject, localBitmap);
      this.cJx = null;
      i = 1;
      break;
      if (paramBitmap == null)
      {
        Log.w(getLogTag(), "handlePluginScreenshotTaken4NativeCall, bitmap is null");
        ((com.tencent.luggage.xweb_ext.extendplugin.component.g)localObject).p(null);
        AppMethodBeat.o(178848);
        return;
      }
      localBitmap = paramBitmap;
      if (this.cEF != 0)
      {
        localBitmap = paramBitmap;
        if (this.cEG != 0) {
          localBitmap = Bitmap.createScaledBitmap(paramBitmap, (int)(this.cJD * this.cEF), (int)(this.cJE * this.cEG), false);
        }
      }
      ((com.tencent.luggage.xweb_ext.extendplugin.component.g)localObject).p(localBitmap);
      this.cFg = null;
      AppMethodBeat.o(178848);
      return;
    }
  }
  
  final boolean s(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(215728);
    Log.d(getLogTag(), "disableBackgroundPlayAudio");
    Log.d(getLogTag(), "disableBackgroundPlayAudioInternal");
    int i;
    if (parama == null)
    {
      Log.w(getLogTag(), "disableBackgroundPlayAudioInternal, invokeContext is null");
      i = 0;
    }
    while (i != 0)
    {
      this.cFe.set(false);
      Log.d(getLogTag(), "disableBackgroundPlayAudio, webViewInBackground: %b", new Object[] { Boolean.valueOf(this.cJs) });
      if ((this.cIV != null) && (!this.cJs)) {
        this.cIV.setSurface(this.mSurface);
      }
      this.cFc = false;
      if (this.cIW != null) {
        this.cIW.ck(false);
      }
      AppMethodBeat.o(215728);
      return true;
      parama = com.tencent.luggage.xweb_ext.extendplugin.component.e.f(parama);
      if (parama == null)
      {
        Log.w(getLogTag(), "disableBackgroundPlayAudio, audioOfVideoBackgroundPlayManager is null");
        i = 0;
      }
      else
      {
        parama.c(this);
        i = 1;
      }
    }
    AppMethodBeat.o(215728);
    return false;
  }
  
  final void seek(long paramLong)
  {
    AppMethodBeat.i(138992);
    if ((this.cJj) && (this.cIV != null))
    {
      if (PS()) {
        this.cIW.onVideoWaiting();
      }
      if (this.cIV != null)
      {
        this.cJe = isPlaying();
        paramLong = Math.min(getDuration(), Math.max(0L, paramLong));
        Log.i(getLogTag(), "seek, position:%s, isPlaying:%s, videoEndPlaying:%s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(this.cJe), Boolean.valueOf(this.cJr) });
        this.cJr = false;
        this.cIV.seekTo(paramLong);
        AppMethodBeat.o(138992);
      }
    }
    else
    {
      this.cJh = paramLong;
    }
    AppMethodBeat.o(138992);
  }
  
  final void takeScreenshot()
  {
    AppMethodBeat.i(215722);
    Log.i(getLogTag(), "takeScreenshot");
    com.tencent.luggage.xweb_ext.extendplugin.d.a(QJ(), this.type, getId());
    AppMethodBeat.o(215722);
  }
  
  public static abstract interface b
  {
    public abstract void cf(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.c
 * JD-Core Version:    0.7.0.1
 */