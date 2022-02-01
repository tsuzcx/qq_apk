package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import com.tencent.luggage.xweb_ext.extendplugin.a.a;
import com.tencent.luggage.xweb_ext.extendplugin.component.i;
import com.tencent.luggage.xweb_ext.extendplugin.component.k;
import com.tencent.luggage.xweb_ext.extendplugin.component.l;
import com.tencent.luggage.xweb_ext.extendplugin.component.m;
import com.tencent.luggage.xweb_ext.extendplugin.component.r;
import com.tencent.luggage.xweb_ext.extendplugin.component.s;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.b.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.g.b.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e.a.h;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e.a.h.p;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e.b.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.h;
import com.tencent.mm.plugin.appbrand.jsapi.w;
import com.tencent.mm.plugin.appbrand.jsapi.z;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
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

public final class c
  extends com.tencent.luggage.xweb_ext.extendplugin.a.a
  implements i
{
  private w cqR;
  public com.tencent.luggage.xweb_ext.extendplugin.a crL;
  a.a crM;
  public int crN;
  public int crO;
  public int crP;
  public int crQ;
  boolean crR;
  boolean crS;
  boolean crT;
  com.tencent.mm.plugin.appbrand.jsapi.s.c crU;
  String crV;
  boolean crY;
  AtomicBoolean csa;
  com.tencent.luggage.xweb_ext.extendplugin.component.a csb;
  com.tencent.luggage.xweb_ext.extendplugin.component.b<e> csc;
  public s cse;
  boolean csi;
  public boolean csj;
  private i csk;
  public AtomicBoolean csl;
  volatile String csm;
  volatile com.tencent.luggage.xweb_ext.extendplugin.component.g csn;
  volatile Bitmap cso;
  public com.tencent.luggage.xweb_ext.extendplugin.component.video.b.b cuA;
  volatile com.tencent.mm.plugin.appbrand.jsapi.ac.e.b cuB;
  boolean cuC;
  boolean cuD;
  boolean cuE;
  boolean cuF;
  long cuG;
  boolean cuH;
  public boolean cuI;
  volatile boolean cuJ;
  boolean cuK;
  boolean cuL;
  int cuM;
  int cuN;
  String cuO;
  String cuP;
  boolean cuQ;
  boolean cuR;
  private boolean cuS;
  private final ConcurrentLinkedQueue<Runnable> cuT;
  Handler cuU;
  private HandlerThread cuV;
  volatile com.tencent.luggage.xweb_ext.extendplugin.a cuW;
  Surface cuX;
  public a cuY;
  private boolean cuZ;
  public com.tencent.mm.plugin.appbrand.jsapi.video.e.b cuu;
  public com.tencent.luggage.xweb_ext.extendplugin.component.video.b.d cuv;
  public com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a cuw;
  public com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c cux;
  public com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e cuy;
  public f cuz;
  public b cva;
  public a cvb;
  public float cvc;
  public float cvd;
  public Surface mSurface;
  public SurfaceTexture mSurfaceTexture;
  volatile String mTitle;
  int mVideoHeight;
  int mVideoWidth;
  
  public c()
  {
    AppMethodBeat.i(138972);
    this.cuK = false;
    this.cuL = false;
    this.crP = 0;
    this.crQ = 0;
    this.cuS = false;
    this.crY = false;
    this.csa = null;
    this.cuT = new ConcurrentLinkedQueue();
    this.cuW = null;
    this.crU = null;
    this.crV = null;
    this.cuX = null;
    this.cuY = null;
    this.cuZ = false;
    this.cqR = new c.25(this);
    this.csb = new com.tencent.luggage.xweb_ext.extendplugin.component.a(this, this.cqR)
    {
      public final boolean FG()
      {
        return !c.this.cuR;
      }
      
      public final void a(String paramAnonymousString, com.tencent.luggage.xweb_ext.extendplugin.a paramAnonymousa)
      {
        AppMethodBeat.i(178843);
        a(paramAnonymousa);
        paramAnonymousa = paramAnonymousa.FD();
        if ((paramAnonymousString.contains("insert")) || (paramAnonymousString.contains("update")))
        {
          if (paramAnonymousa.has("autoplay")) {
            this.cqS = paramAnonymousa.optBoolean("autoplay");
          }
          paramAnonymousString = z.D(paramAnonymousa);
          if (paramAnonymousString != null) {
            this.cqT = paramAnonymousString.booleanValue();
          }
        }
        for (;;)
        {
          ad.d(c.this.getLogTag(), "mAutoRotationPluginHandlerCommons.handleJsApi, mIsNeedNotify: " + this.cqS + ", mIsAutoRotationEnabled: " + this.cqT);
          AppMethodBeat.o(178843);
          return;
          if (paramAnonymousString.contains("operate"))
          {
            paramAnonymousString = paramAnonymousa.optString("type");
            if ((!bt.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equalsIgnoreCase("play"))) {
              this.cqS = true;
            }
          }
          else if (paramAnonymousString.contains("remove"))
          {
            this.cqS = false;
          }
        }
      }
    };
    this.csc = new com.tencent.luggage.xweb_ext.extendplugin.component.b()
    {
      private e cvj = null;
      
      public final int getId()
      {
        AppMethodBeat.i(178845);
        int i = c.this.getId();
        AppMethodBeat.o(178845);
        return i;
      }
      
      public final String getKey()
      {
        AppMethodBeat.i(178846);
        String str = c.this.getKey();
        AppMethodBeat.o(178846);
        return str;
      }
      
      public final String getLogTag()
      {
        AppMethodBeat.i(178844);
        String str = c.this.getLogTag();
        AppMethodBeat.o(178844);
        return str;
      }
    };
    this.cva = null;
    this.cvb = null;
    this.cse = null;
    this.cvc = 1.0F;
    this.cvd = 1.0F;
    this.csi = false;
    this.csj = false;
    this.csk = new r();
    this.csl = new AtomicBoolean(false);
    this.mTitle = null;
    this.csm = null;
    this.csn = null;
    this.cso = null;
    this.cuV = com.tencent.e.c.d.gX(String.format("VideoThread_%s", new Object[] { Long.valueOf(System.currentTimeMillis()) }), 5);
    this.cuV.start();
    this.cuU = new Handler(this.cuV.getLooper());
    AppMethodBeat.o(138972);
  }
  
  private void Gr()
  {
    AppMethodBeat.i(138975);
    synchronized (this.cuT)
    {
      if (this.cuT.isEmpty()) {
        break label102;
      }
      ad.i(getLogTag(), "flushPendingTasks, size:%d", new Object[] { Integer.valueOf(this.cuT.size()) });
      Iterator localIterator = this.cuT.iterator();
      if (localIterator.hasNext()) {
        ((Runnable)localIterator.next()).run();
      }
    }
    this.cuT.clear();
    label102:
    AppMethodBeat.o(138975);
  }
  
  private void Gw()
  {
    AppMethodBeat.i(138996);
    if (this.cuu != null)
    {
      ad.i(getLogTag(), "releaseMediaPlayer");
      this.cuu.a(null);
      this.cuu.a(null);
      this.cuu.a(null);
      this.cuu.a(null);
      this.cuu.a(null);
      this.cuu.a(null);
      this.cuu.stop();
      this.cuu.reset();
      this.cuu.release();
    }
    this.cuu = null;
    this.cuJ = false;
    AppMethodBeat.o(138996);
  }
  
  private void Gx()
  {
    boolean bool1 = true;
    AppMethodBeat.i(138998);
    boolean bool2;
    String str;
    boolean bool3;
    if (this.cuu != null)
    {
      this.cuu.setMute(this.cuL);
      if (this.mSurface != null)
      {
        bool2 = this.csl.get();
        if ((!this.cuR) && (!bool2))
        {
          ad.i(getLogTag(), "applyMediaPlayerParams, setSurface");
          this.cuu.setSurface(this.mSurface);
          AppMethodBeat.o(138998);
          return;
        }
        str = getLogTag();
        bool3 = this.cuR;
        if (this.cuX == null) {
          break label169;
        }
      }
    }
    for (;;)
    {
      ad.i(str, "applyMediaPlayerParams, setSurface, WebViewInBackground: %b, JustPlayAudio: %b, SurfacePipSet exist: %b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if ((this.cuR) && (this.cuX != null)) {
        this.cuu.setSurface(this.cuX);
      }
      AppMethodBeat.o(138998);
      return;
      label169:
      bool1 = false;
    }
  }
  
  private void Gy()
  {
    AppMethodBeat.i(138999);
    if (this.mSurface != null)
    {
      this.mSurface.release();
      this.mSurface = null;
    }
    AppMethodBeat.o(138999);
  }
  
  public final int GA()
  {
    AppMethodBeat.i(177170);
    int i = (int)(this.crQ + (1.0F - this.cvd) * this.crO / 2.0F);
    ad.d(getLogTag(), "getVideoPositionY, videoPosY: ".concat(String.valueOf(i)));
    AppMethodBeat.o(177170);
    return i;
  }
  
  public final void Gb()
  {
    AppMethodBeat.i(138976);
    k(new c.23(this));
    AppMethodBeat.o(138976);
  }
  
  /* Error */
  final boolean Gd()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 515	com/tencent/luggage/xweb_ext/extendplugin/component/video/c:crR	Z
    //   6: ifeq +18 -> 24
    //   9: aload_0
    //   10: getfield 517	com/tencent/luggage/xweb_ext/extendplugin/component/video/c:cuv	Lcom/tencent/luggage/xweb_ext/extendplugin/component/video/b/d;
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
  
  final boolean Ge()
  {
    AppMethodBeat.i(186827);
    boolean bool = this.csc.d(this.crL);
    AppMethodBeat.o(186827);
    return bool;
  }
  
  public final void Gf()
  {
    AppMethodBeat.i(186823);
    k(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(177151);
        if ((c.this.cuu != null) && (!c.this.cuu.isPlaying())) {
          c.this.i(false, true);
        }
        AppMethodBeat.o(177151);
      }
    });
    AppMethodBeat.o(186823);
  }
  
  final boolean Gg()
  {
    AppMethodBeat.i(186829);
    if (this.crL == null)
    {
      ad.w(getLogTag(), "amIBackgroundAudioPlayer, mInsertInvokeContext is null");
      AppMethodBeat.o(186829);
      return false;
    }
    com.tencent.mm.plugin.appbrand.jsapi.ac.a locala = com.tencent.luggage.xweb_ext.extendplugin.component.e.f(this.crL);
    if (locala == null)
    {
      ad.w(getLogTag(), "amIBackgroundAudioPlayer, audioOfVideoBackgroundPlayManager is null");
      AppMethodBeat.o(186829);
      return false;
    }
    boolean bool = locala.a(this);
    AppMethodBeat.o(186829);
    return bool;
  }
  
  public final boolean Gq()
  {
    AppMethodBeat.i(177165);
    if ((this.csa != null) && (this.csa.get()))
    {
      AppMethodBeat.o(177165);
      return true;
    }
    AppMethodBeat.o(177165);
    return false;
  }
  
  final void Gs()
  {
    AppMethodBeat.i(138979);
    if ((this.cuu != null) && (this.mSurfaceTexture != null))
    {
      int i = this.cuu.getVideoWidth();
      int j = this.cuu.getVideoHeight();
      if ((i == 0) && (j == 0))
      {
        ad.w(getLogTag(), "VideoCanvas, registerMediaPlayer, width or height is 0");
        AppMethodBeat.o(138979);
        return;
      }
      if (!this.cuS)
      {
        this.cuS = true;
        com.tencent.mm.plugin.appbrand.i.a.bgy().a(getId(), this, this.mSurfaceTexture, i, j, this.crL.getAppId());
        AppMethodBeat.o(138979);
        return;
      }
      ad.w(getLogTag(), "VideoCanvas, registerMediaPlayer, already registered");
      AppMethodBeat.o(138979);
      return;
    }
    ad.w(getLogTag(), "VideoCanvas, registerMediaPlayer, media player or surface texture is null");
    AppMethodBeat.o(138979);
  }
  
  final boolean Gt()
  {
    AppMethodBeat.i(178849);
    Object localObject;
    if ((this.crL instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      localObject = this.crL.El();
      if ((localObject instanceof aa)) {
        localObject = (aa)localObject;
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        localObject = ((aa)localObject).getRuntime();
        ad.i(getLogTag(), "cancelResumePlayingWhenRelaunch:%s", new Object[] { Boolean.valueOf(((AppBrandRuntime)localObject).jwV) });
        boolean bool = ((AppBrandRuntime)localObject).jwV;
        AppMethodBeat.o(178849);
        return bool;
        if ((localObject instanceof q)) {
          localObject = ((q)localObject).getCurrentPageView();
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
  
  public final void Gu()
  {
    AppMethodBeat.i(186824);
    k(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(177152);
        c.this.pause();
        AppMethodBeat.o(177152);
      }
    });
    AppMethodBeat.o(186824);
  }
  
  final boolean Gv()
  {
    AppMethodBeat.i(138987);
    if (this.cuu != null)
    {
      if (this.cuA != null) {
        this.cuA.a(this.crL, this.cuu);
      }
      if (!this.cuI)
      {
        ad.i(getLogTag(), "video stop, video not prepared yet, stop video when prepared");
        this.cuF = false;
        AppMethodBeat.o(138987);
        return true;
      }
      ad.i(getLogTag(), "video stop");
      this.cuu.stop();
      if (Gd()) {
        this.cuv.bK(true);
      }
      AppMethodBeat.o(138987);
      return true;
    }
    AppMethodBeat.o(138987);
    return false;
  }
  
  public final int Gz()
  {
    AppMethodBeat.i(177169);
    int i = (int)(this.crP + (1.0F - this.cvc) * this.crN / 2.0F);
    ad.d(getLogTag(), "getVideoPositionX, videoPosX: ".concat(String.valueOf(i)));
    AppMethodBeat.o(177169);
    return i;
  }
  
  public final <AddOn extends com.tencent.luggage.xweb_ext.extendplugin.component.j> AddOn U(Class<AddOn> paramClass)
  {
    AppMethodBeat.i(186833);
    ad.i(getLogTag(), "getAddOn for " + paramClass.getSimpleName());
    paramClass = this.csk.U(paramClass);
    AppMethodBeat.o(186833);
    return paramClass;
  }
  
  public final <AddOn extends com.tencent.luggage.xweb_ext.extendplugin.component.j> void a(Class<AddOn> paramClass, AddOn paramAddOn)
  {
    AppMethodBeat.i(186832);
    ad.i(getLogTag(), "setAddOn for " + paramClass.getSimpleName());
    this.csk.a(paramClass, paramAddOn);
    AppMethodBeat.o(186832);
  }
  
  final String b(com.tencent.luggage.xweb_ext.extendplugin.a parama, String paramString)
  {
    AppMethodBeat.i(138982);
    String str = paramString;
    if (this.cuA != null) {
      str = this.cuA.b(parama, paramString);
    }
    AppMethodBeat.o(138982);
    return str;
  }
  
  final void b(com.tencent.luggage.xweb_ext.extendplugin.a parama, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(138981);
    if (!paramJSONObject.has("enableCasting"))
    {
      AppMethodBeat.o(138981);
      return;
    }
    boolean bool = paramJSONObject.optBoolean("enableCasting");
    ad.d(getLogTag(), "isEnableVideoCast = ".concat(String.valueOf(bool)));
    p(parama);
    this.cuB.lyF = bool;
    AppMethodBeat.o(138981);
  }
  
  final void bE(boolean paramBoolean)
  {
    AppMethodBeat.i(186821);
    if (!bt.isNullOrNil(this.cuP))
    {
      if ((GK() != null) && (this.cuz != null))
      {
        float f1 = this.cvc;
        float f2 = this.cvd;
        if (this.cuz.a(this.cuP, this.crN, this.crO, this.mVideoWidth, this.mVideoHeight))
        {
          this.cvc = this.cuz.GI();
          this.cvd = this.cuz.GJ();
          ad.i(getLogTag(), "adjust objectFit:%s, scale:[%s, %s]", new Object[] { this.cuP, Float.valueOf(this.cvc), Float.valueOf(this.cvd) });
          if ((!this.cuR) || (this.cuX == null)) {
            break label218;
          }
          this.cuZ = true;
          ad.i(getLogTag(), "adjust objectFit, TextureScale sticky");
        }
        for (;;)
        {
          if (((this.cvc != f1) || (this.cvd != f2)) && (this.cuY != null)) {
            this.cuY.a(paramBoolean, this.cvc, this.cvd);
          }
          AppMethodBeat.o(186821);
          return;
          label218:
          com.tencent.luggage.xweb_ext.extendplugin.d.a(GK(), this.type, getId(), this.cvc, this.cvd);
          this.cuZ = false;
        }
      }
      ad.i(getLogTag(), "adjust objectFit, video not prepared");
      AppMethodBeat.o(186821);
      return;
    }
    ad.i(getLogTag(), "adjust objectFit, no video objectFit");
    AppMethodBeat.o(186821);
  }
  
  final void bF(boolean paramBoolean)
  {
    AppMethodBeat.i(186822);
    if (this.cuu != null)
    {
      ad.i(getLogTag(), "video prepare async");
      if ((paramBoolean) && (Gd())) {
        this.cuv.onVideoWaiting();
      }
      this.cuI = false;
      this.cuF = false;
      if (this.cuA != null) {
        this.cuA.c(this.cuu);
      }
      this.cuu.prepareAsync();
    }
    AppMethodBeat.o(186822);
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
    AppMethodBeat.i(186828);
    if (this.cuu != null)
    {
      if (!this.csl.get())
      {
        this.cuu.setSurface(paramSurface);
        if (this.mSurface != paramSurface) {
          break label99;
        }
        this.cuX = null;
        label46:
        paramSurface = getLogTag();
        if (this.cuX == null) {
          break label107;
        }
      }
      label99:
      label107:
      for (boolean bool = true;; bool = false)
      {
        ad.i(paramSurface, "setSurface, SurfacePipSet exist: %b", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(186828);
        return true;
        ad.i(getLogTag(), "setSurface, JustPlayAudio");
        break;
        this.cuX = paramSurface;
        break label46;
      }
    }
    ad.w(getLogTag(), "setSurface, MediaPlayer is null");
    AppMethodBeat.o(186828);
    return false;
  }
  
  public final boolean g(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    return true;
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(138990);
    if (this.cuu != null)
    {
      int i = this.cuu.getCurrentPosition();
      AppMethodBeat.o(138990);
      return i;
    }
    AppMethodBeat.o(138990);
    return 0;
  }
  
  final int getDuration()
  {
    AppMethodBeat.i(138991);
    if (this.cuu != null)
    {
      int i = this.cuu.getDuration();
      AppMethodBeat.o(138991);
      return i;
    }
    AppMethodBeat.o(138991);
    return 0;
  }
  
  public final String getKey()
  {
    AppMethodBeat.i(177168);
    String str = BM() + "@" + hashCode();
    AppMethodBeat.o(177168);
    return str;
  }
  
  public final String getLogTag()
  {
    AppMethodBeat.i(138973);
    String str = String.format("%s(%s)", new Object[] { "MicroMsg.SameLayer.VideoPluginHandler", BM() });
    AppMethodBeat.o(138973);
    return str;
  }
  
  public final String getName()
  {
    AppMethodBeat.i(186831);
    String str = getKey();
    AppMethodBeat.o(186831);
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
        String str = locala.FE();
        Object localObject2;
        if (!bt.isNullOrNil(str))
        {
          localObject1 = locala.FD();
          ad.i(localc.getLogTag(), "*** handler(%s) handleJsApi(%s), data:%s", new Object[] { localc.BM(), str, ((JSONObject)localObject1).toString() });
          if (!str.contains("insert")) {
            break label975;
          }
          localc.crL = locala;
          if (localc.cuu == null)
          {
            ad.w(localc.getLogTag(), "insert, media player is null");
            localc.r(localc.crL);
          }
          localc.crM = new c.5(localc);
          locala.a(localc.crM);
          if (localc.cuA != null) {
            localc.cuA.v(locala);
          }
          if ((localc.mSurface != null) && (localc.cuu != null))
          {
            ad.i(localc.getLogTag(), "insert, setSurface");
            localc.cuu.setSurface(localc.mSurface);
          }
          localObject1 = locala.FD();
          localc.cuH = ((JSONObject)localObject1).optBoolean("autoplay", false);
          localc.cuG = ((((JSONObject)localObject1).optDouble("initialTime", 0.0D) * 1000.0D));
          localc.cuK = ((JSONObject)localObject1).optBoolean("loop", false);
          localc.cuL = ((JSONObject)localObject1).optBoolean("muted", false);
          localc.cuu.setMute(localc.cuL);
          localc.crS = ((JSONObject)localObject1).optBoolean("autoPauseIfNavigate", true);
          localc.crT = ((JSONObject)localObject1).optBoolean("autoPauseIfOpenNative", true);
          localc.crR = ((JSONObject)localObject1).optBoolean("needEvent", false);
          if ((localc.crR) && (localc.cuv != null))
          {
            localc.cuv.m(locala);
            localObject2 = ((JSONObject)localObject1).optString("data", "");
            localc.cuv.dz((String)localObject2);
            if (localc.cuw != null)
            {
              localc.cuw.m(locala);
              localc.cuw.dz((String)localObject2);
            }
          }
          if (((JSONObject)localObject1).has("position"))
          {
            localObject2 = ((JSONObject)localObject1).optJSONObject("position");
            if (localObject2 != null)
            {
              localc.crN = com.tencent.mm.plugin.appbrand.z.g.vJ(((JSONObject)localObject2).optInt("width", 0));
              localc.crO = com.tencent.mm.plugin.appbrand.z.g.vJ(((JSONObject)localObject2).optInt("height", 0));
              ad.i(localc.getLogTag(), "insert, size:[%d, %d]", new Object[] { Integer.valueOf(localc.crN), Integer.valueOf(localc.crO) });
            }
          }
          localc.cuP = ((JSONObject)localObject1).optString("objectFit", "contain");
          if (bt.isNullOrNil(localc.cuP)) {
            localc.cuP = "contain";
          }
          localc.bE(true);
          localObject2 = locala.El();
          if (localObject2 != null) {
            break label805;
          }
          ad.w(localc.getLogTag(), "updateReferrers, component is null");
          localc.cuO = ((JSONObject)localObject1).optString("filePath");
          if (!bt.isNullOrNil(localc.cuO))
          {
            if (localc.cuA != null) {
              localc.cuA.a(localc.cuu, localc.cuO);
            }
            localObject2 = localc.b(locala, localc.cuO);
            ad.i(localc.getLogTag(), "insert, path:%s, proxy:%s", new Object[] { localc.cuO, localObject2 });
            if (!bt.isNullOrNil((String)localObject2))
            {
              localc.cuu.dD((String)localObject2, localc.crV);
              ad.i(localc.getLogTag(), "insert, media player prepare async");
              localc.bF(true);
            }
          }
          localc.mTitle = ((JSONObject)localObject1).optString("title", localc.mTitle);
          localc.csm = ((JSONObject)localObject1).optString("backgroundPoster", localc.csm);
          localc.b(locala, (JSONObject)localObject1);
          locala.du("ok");
        }
        label787:
        label805:
        Object localObject3;
        Object localObject4;
        for (;;)
        {
          localc.csb.a(str, locala);
          if (localc.cuO == null) {
            break label4126;
          }
          localObject1 = localc.cuO;
          localc.csc.a(locala, (String)localObject1);
          AppMethodBeat.o(138966);
          return;
          localObject3 = (com.tencent.mm.plugin.appbrand.jsapi.s.a)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.s.a.class);
          if (localObject3 == null)
          {
            ad.w(localc.getLogTag(), "updateReferrers, referrerHelper is null");
            break;
          }
          if (localc.crU == null) {
            localc.crU = ((com.tencent.mm.plugin.appbrand.jsapi.s.a)localObject3).bmo();
          }
          localObject4 = ((com.tencent.mm.plugin.appbrand.jsapi.s.a)localObject3).a((JSONObject)localObject1, (com.tencent.mm.plugin.appbrand.jsapi.c)localObject2);
          if (localObject4 != null) {
            localc.crU = ((com.tencent.mm.plugin.appbrand.jsapi.s.c)localObject4);
          }
          ad.i(localc.getLogTag(), "updateReferrers, mReferrerPolicy: " + localc.crU);
          if (com.tencent.mm.plugin.appbrand.jsapi.s.c.lfc == localc.crU)
          {
            localc.crV = null;
            break;
          }
          localc.crV = ((com.tencent.mm.plugin.appbrand.jsapi.s.a)localObject3).y((com.tencent.mm.plugin.appbrand.jsapi.c)localObject2);
          ad.i(localc.getLogTag(), "updateReferrers, mReferrer: " + localc.crV);
          break;
          label975:
          if (!str.contains("update")) {
            break label2171;
          }
          if (localc.cuu != null) {
            break label1019;
          }
          ad.w(localc.getLogTag(), "update, media player is null");
          locala.du("fail");
        }
        label1019:
        Object localObject1 = locala.FD();
        if (((JSONObject)localObject1).has("filePath"))
        {
          localObject2 = ((JSONObject)localObject1).optString("filePath");
          if ((!bt.isNullOrNil((String)localObject2)) && (!((String)localObject2).equalsIgnoreCase(localc.cuO)))
          {
            localc.cuO = ((String)localObject2);
            localObject2 = localc.b(locala, localc.cuO);
            ad.i(localc.getLogTag(), "update, path:%s, proxy:%s", new Object[] { localc.cuO, localObject2 });
            if ((localc.cuu == null) || (!bt.isNullOrNil((String)localObject2)))
            {
              localc.cuQ = false;
              localc.Gv();
              localc.q(locala);
            }
            if (localc.cuA != null) {
              localc.cuA.a(localc.cuu, localc.cuO);
            }
            localc.cuu.dD((String)localObject2, localc.crV);
          }
        }
        for (int j = 1;; j = 0)
        {
          boolean bool2;
          boolean bool1;
          if ((localc.mSurface != null) && (localc.cuu != null))
          {
            bool2 = localc.csl.get();
            if ((!localc.cuR) && (!bool2))
            {
              ad.i(localc.getLogTag(), "update, setSurface");
              localc.cuu.setSurface(localc.mSurface);
            }
          }
          else
          {
            if (((JSONObject)localObject1).has("autoplay")) {
              localc.cuH = ((JSONObject)localObject1).optBoolean("autoplay", localc.cuH);
            }
            if (((JSONObject)localObject1).has("initialTime")) {
              localc.cuG = ((((JSONObject)localObject1).optDouble("initialTime", 0.0D) * 1000.0D));
            }
            if (((JSONObject)localObject1).has("loop")) {
              localc.cuK = ((JSONObject)localObject1).optBoolean("loop", localc.cuK);
            }
            if (((JSONObject)localObject1).has("muted"))
            {
              localc.cuL = ((JSONObject)localObject1).optBoolean("muted", localc.cuL);
              localc.cuu.setMute(localc.cuL);
            }
            if (((JSONObject)localObject1).has("autoPauseIfNavigate")) {
              localc.crS = ((JSONObject)localObject1).optBoolean("autoPauseIfNavigate", localc.crS);
            }
            if (((JSONObject)localObject1).has("autoPauseIfOpenNative")) {
              localc.crT = ((JSONObject)localObject1).optBoolean("autoPauseIfOpenNative", localc.crT);
            }
            if (((JSONObject)localObject1).has("needEvent")) {
              localc.crR = ((JSONObject)localObject1).optBoolean("needEvent", localc.crR);
            }
            if ((localc.crR) && (localc.cuv != null))
            {
              localc.cuv.m(locala);
              localObject2 = ((JSONObject)localObject1).optString("data", "");
              if (((JSONObject)localObject1).has("data")) {
                localc.cuv.dz((String)localObject2);
              }
              if (localc.cuw != null)
              {
                if (((JSONObject)localObject1).has("data")) {
                  localc.cuw.dz((String)localObject2);
                }
                localc.cuw.m(locala);
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
                i = localc.crN;
                int k = localc.crO;
                localc.crN = com.tencent.mm.plugin.appbrand.z.g.vJ(((JSONObject)localObject2).optInt("width", i));
                localc.crO = com.tencent.mm.plugin.appbrand.z.g.vJ(((JSONObject)localObject2).optInt("height", k));
                ad.i(localc.getLogTag(), "update, size:[%d, %d]", new Object[] { Integer.valueOf(localc.crN), Integer.valueOf(localc.crO) });
                if (localc.crN == i)
                {
                  bool1 = bool2;
                  if (localc.crO == k) {}
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
              localObject2 = localc.cuP;
              localc.cuP = ((JSONObject)localObject1).optString("objectFit", (String)localObject2);
              if (bt.isNullOrNil(localc.cuP)) {
                localc.cuP = "contain";
              }
              if (!localc.cuP.equals(localObject2)) {
                bool1 = false;
              }
              i = 1;
              bool2 = bool1;
            }
            if (i != 0) {
              localc.bE(bool2);
            }
            localc.b(locala, (JSONObject)localObject1);
            localObject2 = ((JSONObject)localObject1).optString("filePath");
            if ((localc.cuB != null) && (localc.cuB.bpM()))
            {
              localObject3 = localc.cuB;
              p.h(localObject2, "updateVideoPath");
              ad.i("MicroMsg.VideoCast.AppBrandVideoCastHandler", "updateVideoPath: [" + (String)localObject2 + ']');
              if (!d.n.n.aE((CharSequence)d.n.n.trim((CharSequence)localObject2).toString()))
              {
                ((com.tencent.mm.plugin.appbrand.jsapi.ac.e.b)localObject3).bpN().bpW();
                if (!p.i(localObject2, ((com.tencent.mm.plugin.appbrand.jsapi.ac.e.b)localObject3).videoPath))
                {
                  ((com.tencent.mm.plugin.appbrand.jsapi.ac.e.b)localObject3).setVideoPath((String)localObject2);
                  ((com.tencent.mm.plugin.appbrand.jsapi.ac.e.b)localObject3).gW(true);
                  ((com.tencent.mm.plugin.appbrand.jsapi.ac.e.b)localObject3).bpN().s((d.g.a.b)new com.tencent.mm.plugin.appbrand.jsapi.ac.e.b.f((com.tencent.mm.plugin.appbrand.jsapi.ac.e.b)localObject3));
                  if (((com.tencent.mm.plugin.appbrand.jsapi.ac.e.b)localObject3).bpN().dFx != -1) {
                    break label2159;
                  }
                  ((com.tencent.mm.plugin.appbrand.jsapi.ac.e.b)localObject3).bpN().dFx = 8;
                }
              }
            }
          }
          for (;;)
          {
            localc.mTitle = ((JSONObject)localObject1).optString("title", localc.mTitle);
            localc.csm = ((JSONObject)localObject1).optString("backgroundPoster", localc.csm);
            if (j != 0)
            {
              ad.i(localc.getLogTag(), "update, media player prepare async");
              localc.bF(true);
            }
            locala.du("ok");
            break;
            localObject2 = localc.getLogTag();
            boolean bool3 = localc.cuR;
            if (localc.cuX != null) {}
            for (bool1 = true;; bool1 = false)
            {
              ad.i((String)localObject2, "update, setSurface, WebViewInBackground: %b, JustPlayAudio: %b, SurfacePipSet exist: %b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
              if ((!localc.cuR) || (localc.cuX == null)) {
                break;
              }
              localc.cuu.setSurface(localc.cuX);
              break;
            }
            label2159:
            ad.i("MicroMsg.VideoCast.AppBrandVideoCastHandler", "discard a updateVideoPath report event");
          }
          label2171:
          if ((str.contains("operate")) && (str.contains("Background")))
          {
            if (localc.cuu == null)
            {
              ad.w(localc.getLogTag(), "operateBackground, media player is null");
              locala.du("fail");
              break;
            }
            localObject1 = locala.FD();
            bool1 = false;
            localObject1 = ((JSONObject)localObject1).optString("type");
            if (bt.isNullOrNil((String)localObject1)) {
              break;
            }
            ad.i(localc.getLogTag(), "operateBackground, type:%s", new Object[] { localObject1 });
            if (((String)localObject1).equalsIgnoreCase("stop"))
            {
              bool2 = localc.s(locala);
              bool1 = bool2;
              if (bool2)
              {
                bool1 = bool2;
                if (localc.crY)
                {
                  ad.i(localc.getLogTag(), "operateBackground, isRuntimeInBackground, setPlayingWhenEnterBackground false");
                  localc.csa = new AtomicBoolean(false);
                  bool1 = bool2;
                }
              }
            }
            if (bool1) {}
            for (localObject1 = "ok";; localObject1 = "fail")
            {
              locala.du((String)localObject1);
              break;
            }
          }
          if (str.contains("operate"))
          {
            if (localc.cuu == null)
            {
              ad.w(localc.getLogTag(), "operate, media player is null");
              locala.du("fail");
              break;
            }
            localObject3 = locala.FD();
            bool2 = false;
            localObject2 = ((JSONObject)localObject3).optString("type");
            if (bt.isNullOrNil((String)localObject2)) {
              break;
            }
            ad.i(localc.getLogTag(), "operate, type:%s", new Object[] { localObject2 });
            if (((String)localObject2).equalsIgnoreCase("startCasting"))
            {
              bool1 = true;
              label2484:
              if (!bool1) {
                break label3197;
              }
              ad.i(localc.getLogTag(), "video cast operate, type:%s", new Object[] { localObject2 });
              if (localc.cuB == null) {
                localc.p(locala);
              }
              localc.cuB.setVideoPath(localc.cuO);
              localc.cuB.lyA = localc.getCurrentPosition();
              if (!((String)localObject2).equalsIgnoreCase("requestFullScreen")) {
                break label2673;
              }
              bool1 = localc.j(locala);
              label2570:
              if (!((String)localObject2).equalsIgnoreCase("snapshot")) {
                break label4055;
              }
              ad.i(localc.getLogTag(), "getSnapshotCached");
              if (localc.cuA != null) {
                break label4040;
              }
              locala.du("fail:snapshot error");
            }
            for (;;)
            {
              label2611:
              if ((!((String)localObject2).equalsIgnoreCase("pause")) && (!((String)localObject2).equalsIgnoreCase("stop"))) {
                break label4076;
              }
              localc.csc.b(locala);
              break;
              if (localc.cuB == null)
              {
                bool1 = false;
                break label2484;
              }
              bool1 = localc.cuB.bpM();
              break label2484;
              label2673:
              if (((String)localObject2).equalsIgnoreCase("exitFullScreen"))
              {
                bool1 = localc.k(locala);
                break label2570;
              }
              localObject1 = localc.cuB;
              p.h(localObject3, "data");
              p.h(locala, "invokeContext");
              localObject4 = ((JSONObject)localObject3).optString("type");
              ad.i("MicroMsg.VideoCast.AppBrandVideoCastHandler", "handleOperate: type = ".concat(String.valueOf(localObject4)));
              if (localObject4 == null)
              {
                bool1 = true;
                break label2570;
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
                          h.b(((com.tencent.mm.plugin.appbrand.jsapi.ac.e.b)localObject1).bpN());
                          bool1 = true;
                          break;
                          if (((String)localObject4).equals("reconnectCasting"))
                          {
                            localObject3 = ((com.tencent.mm.plugin.appbrand.jsapi.ac.e.b)localObject1).lyD;
                            if (localObject3 != null) {
                              ((com.tencent.mm.plugin.appbrand.jsapi.ac.e.a.c)localObject3).tQ(5);
                            }
                            localObject1 = ((com.tencent.mm.plugin.appbrand.jsapi.ac.e.b)localObject1).bpN();
                            if (((h)localObject1).lzP.bpX().bfo() != e.a.kdl) {
                              break label3171;
                            }
                            ((h)localObject1).lAp.bH(true);
                            bool1 = true;
                            break;
                            if (((String)localObject4).equals("exitCasting"))
                            {
                              localObject3 = ((com.tencent.mm.plugin.appbrand.jsapi.ac.e.b)localObject1).lyD;
                              if (localObject3 != null) {
                                ((com.tencent.mm.plugin.appbrand.jsapi.ac.e.a.c)localObject3).tQ(6);
                              }
                              h.d(((com.tencent.mm.plugin.appbrand.jsapi.ac.e.b)localObject1).bpN());
                              ((com.tencent.mm.plugin.appbrand.jsapi.ac.e.b)localObject1).bpN().destroy();
                              ((com.tencent.mm.plugin.appbrand.jsapi.ac.e.b)localObject1).lyG = false;
                              ((com.tencent.mm.plugin.appbrand.jsapi.ac.e.b)localObject1).gW(false);
                            }
                          }
                        }
                      }
                    } while (!((String)localObject4).equals("startCasting"));
                    ((com.tencent.mm.plugin.appbrand.jsapi.ac.e.b)localObject1).bpN().lAg = ((d.g.a.a)new com.tencent.mm.plugin.appbrand.jsapi.ac.e.b.e((com.tencent.mm.plugin.appbrand.jsapi.ac.e.b)localObject1));
                    h.a(((com.tencent.mm.plugin.appbrand.jsapi.ac.e.b)localObject1).bpN());
                    bool1 = true;
                    break;
                  } while (!((String)localObject4).equals("switchCasting"));
                  localObject3 = ((com.tencent.mm.plugin.appbrand.jsapi.ac.e.b)localObject1).lyD;
                  if (localObject3 != null) {
                    ((com.tencent.mm.plugin.appbrand.jsapi.ac.e.a.c)localObject3).tQ(4);
                  }
                  ((com.tencent.mm.plugin.appbrand.jsapi.ac.e.b)localObject1).bpN().x(false, true);
                  bool1 = true;
                  break;
                } while (!((String)localObject4).equals("seek"));
                long l = com.tencent.mm.plugin.appbrand.jsapi.ac.e.b.Y((JSONObject)localObject3);
                if (l <= 0L) {
                  break label3156;
                }
                ((com.tencent.mm.plugin.appbrand.jsapi.ac.e.b)localObject1).bpN().RA(b.c.tP((int)l));
                bool1 = true;
                break;
              } while (!((String)localObject4).equals("pause"));
              h.c(((com.tencent.mm.plugin.appbrand.jsapi.ac.e.b)localObject1).bpN());
              bool1 = true;
              break label2570;
              label3156:
              ad.i("MicroMsg.VideoCast.AppBrandVideoCastHandler", "invalid seek position");
              bool1 = false;
              break label2570;
              label3171:
              ((h)localObject1).lzP.u((d.g.a.b)new h.p((h)localObject1));
              bool1 = true;
              break label2570;
              label3197:
              if (((String)localObject2).equalsIgnoreCase("play"))
              {
                bool1 = localc.i(false, true);
                break label2570;
              }
              if (((String)localObject2).equalsIgnoreCase("pause"))
              {
                bool1 = localc.pause();
                break label2570;
              }
              if (((String)localObject2).equalsIgnoreCase("stop"))
              {
                bool2 = localc.Gv();
                bool1 = bool2;
                if (!bool2) {
                  break label2570;
                }
                bool1 = bool2;
                if (!localc.crY) {
                  break label2570;
                }
                ad.i(localc.getLogTag(), "stop, isRuntimeInBackground, setPlayingWhenEnterBackground false");
                localc.csa = new AtomicBoolean(false);
                bool1 = bool2;
                break label2570;
              }
              label3384:
              double d;
              if (((String)localObject2).equalsIgnoreCase("seek"))
              {
                if ((localc.cuu != null) && (localObject3 != null) && (((JSONObject)localObject3).has("data")))
                {
                  localObject1 = ((JSONObject)localObject3).optJSONArray("data");
                  if ((localObject1 != null) && (((JSONArray)localObject1).length() != 0)) {
                    break label3384;
                  }
                  ad.w(localc.getLogTag(), "seek, data array is null");
                }
                for (;;)
                {
                  bool1 = false;
                  break;
                  d = ((JSONArray)localObject1).optDouble(0, -1.0D);
                  if (d >= 0.0D) {
                    break label3425;
                  }
                  ad.w(localc.getLogTag(), "seek, invalid position:%s", new Object[] { Double.valueOf(d) });
                }
                label3425:
                localc.seek((d * 1000.0D));
                bool1 = true;
                break label2570;
              }
              if (((String)localObject2).equalsIgnoreCase("playbackRate"))
              {
                if ((localc.cuu != null) && (localObject3 != null) && (((JSONObject)localObject3).has("data")))
                {
                  localObject1 = ((JSONObject)localObject3).optJSONArray("data");
                  if ((localObject1 != null) && (((JSONArray)localObject1).length() != 0)) {
                    break label3515;
                  }
                  ad.w(localc.getLogTag(), "speed, data array is null");
                }
                for (;;)
                {
                  bool1 = false;
                  break;
                  label3515:
                  d = ((JSONArray)localObject1).optDouble(0, -1.0D);
                  if (d >= 0.0D) {
                    break label3556;
                  }
                  ad.w(localc.getLogTag(), "speed, invalid rate:%s", new Object[] { Double.valueOf(d) });
                }
                label3556:
                ad.i(localc.getLogTag(), "speed, speed:%s", new Object[] { Double.valueOf(d) });
                bool1 = localc.cuu.aF((float)d);
                break label2570;
              }
              if (((String)localObject2).equalsIgnoreCase("requestFullScreen"))
              {
                bool1 = localc.j(locala);
                break label2570;
              }
              if (((String)localObject2).equalsIgnoreCase("exitFullScreen"))
              {
                bool1 = localc.k(locala);
                break label2570;
              }
              if (((String)localObject2).equalsIgnoreCase("setScreenBrightness"))
              {
                ad.i(localc.getLogTag(), "setScreenBrightness");
                if ((localc.cuA != null) && (localc.cuA.t(locala)))
                {
                  bool1 = true;
                  break label2570;
                }
                bool1 = false;
                break label2570;
              }
              if (((String)localObject2).equalsIgnoreCase("exitPictureInPicture"))
              {
                bool1 = localc.csc.c(locala);
                break label2570;
              }
              if (((String)localObject2).equalsIgnoreCase("requestBackgroundPlayback"))
              {
                ad.d(localc.getLogTag(), "enableBackgroundPlayAudio");
                if (!localc.csi)
                {
                  ad.d(localc.getLogTag(), "registerAddOnPlayAudio");
                  localc.a(m.class, new c.28(localc));
                  ad.d(localc.getLogTag(), "registerAddOnVideoController");
                  localc.a(com.tencent.luggage.xweb_ext.extendplugin.component.n.class, new c.29(localc));
                  ad.d(localc.getLogTag(), "registerAddOnInfo");
                  localc.a(l.class, new c.30(localc));
                  ad.d(localc.getLogTag(), "registerAddOnGetSnapshot");
                  localc.a(k.class, new c.32(localc));
                  localc.csi = true;
                }
                ad.d(localc.getLogTag(), "enableBackgroundPlayAudioInternal");
                if (locala == null)
                {
                  ad.w(localc.getLogTag(), "enableBackgroundPlayAudioInternal, invokeContext is null");
                  bool1 = false;
                }
                for (;;)
                {
                  if (!bool1) {
                    break label4007;
                  }
                  localc.csl.set(true);
                  if (localc.cuu != null) {
                    localc.cuu.setSurface(null);
                  }
                  localc.csj = true;
                  if (localc.cuv != null) {
                    localc.cuv.bL(true);
                  }
                  bool1 = true;
                  break;
                  localObject1 = com.tencent.luggage.xweb_ext.extendplugin.component.e.f(locala);
                  if (localObject1 == null)
                  {
                    ad.w(localc.getLogTag(), "enableBackgroundPlayAudioInternal, audioOfVideoBackgroundPlayManager is null");
                    bool1 = false;
                  }
                  else
                  {
                    bool1 = ((com.tencent.mm.plugin.appbrand.jsapi.ac.a)localObject1).b(localc);
                  }
                }
                label4007:
                bool1 = false;
                break label2570;
              }
              bool1 = bool2;
              if (!((String)localObject2).equalsIgnoreCase("exitBackgroundPlayback")) {
                break label2570;
              }
              bool1 = localc.s(locala);
              break label2570;
              label4040:
              localc.cuW = locala;
              localc.takeScreenshot();
            }
            label4055:
            if (bool1) {}
            for (localObject1 = "ok";; localObject1 = "fail")
            {
              locala.du((String)localObject1);
              break label2611;
              label4076:
              break;
            }
          }
          if (!str.contains("remove")) {
            break;
          }
          localc.release();
          locala.du("ok");
          localc.csc.b(locala);
          break;
          label4126:
          localObject1 = "";
          break label787;
        }
      }
    });
    AppMethodBeat.o(138977);
    return null;
  }
  
  final boolean i(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(177166);
    if (this.cuu != null)
    {
      if ((this.cuI) && (this.cuu.isPlaying()))
      {
        ad.i(getLogTag(), "video play, video is playing");
        if (Gd()) {
          this.cuv.bJ(paramBoolean1);
        }
        AppMethodBeat.o(177166);
        return true;
      }
      if ((this.cuu != null) && (!this.cuI))
      {
        ad.i(getLogTag(), "video play, video not prepared yet, start until prepared");
        this.cuF = true;
        AppMethodBeat.o(177166);
        return true;
      }
      if ((this.cuu != null) && (this.cuu.getState() == 5))
      {
        if (!paramBoolean2)
        {
          ad.i(getLogTag(), "video has ended playing, do not restart");
          AppMethodBeat.o(177166);
          return false;
        }
        ad.i(getLogTag(), "video play, video has stopped now, try prepare and start when prepared");
        bF(true);
        this.cuF = true;
        AppMethodBeat.o(177166);
        return true;
      }
      if (this.cuQ)
      {
        if (!paramBoolean2)
        {
          ad.i(getLogTag(), "video has ended playing, do not restart");
          AppMethodBeat.o(177166);
          return false;
        }
        ad.i(getLogTag(), "video play, video has ended playing, clear surface and start again");
        this.cuQ = false;
        try
        {
          if ((this.mSurfaceTexture != null) && (this.cuI))
          {
            ad.i(getLogTag(), "clearSurfaceTexture");
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
            ad.printErrStackTrace(getLogTag(), localException, "clearSurfaceTexture error", new Object[0]);
            continue;
            this.cuu.dD(this.cuO, this.crV);
          }
        }
        q(this.crL);
        if (this.cuu != null)
        {
          this.cuH = true;
          localObject1 = b(this.crL, this.cuO);
          if (!bt.isNullOrNil((String)localObject1))
          {
            this.cuu.dD((String)localObject1, this.crV);
            ad.i(getLogTag(), "video play, media player state:%s", new Object[] { Integer.valueOf(this.cuu.getState()) });
            bF(false);
            this.cuF = true;
          }
        }
        else
        {
          AppMethodBeat.o(177166);
          return true;
        }
      }
      ad.i(getLogTag(), "video play");
      if (this.cuu != null)
      {
        if (Gd()) {
          this.cuv.bJ(paramBoolean1);
        }
        ad.i(getLogTag(), "applyPluginTextureScaleIfNeed");
        if (this.cuZ) {
          break label754;
        }
        ad.i(getLogTag(), "applyPluginTextureScaleIfNeed, TextureScale is not sticky");
      }
      for (;;)
      {
        this.cuu.start();
        AppMethodBeat.o(177166);
        return true;
        label754:
        if ((this.cuR) && (this.cuX != null)) {
          ad.i(getLogTag(), "applyPluginTextureScaleIfNeed, in PIP mode");
        } else {
          com.tencent.luggage.xweb_ext.extendplugin.d.a(GK(), this.type, getId(), this.cvc, this.cvd);
        }
      }
    }
    AppMethodBeat.o(177166);
    return false;
  }
  
  final boolean isPlaying()
  {
    AppMethodBeat.i(138989);
    if (this.cuu != null)
    {
      boolean bool = this.cuu.isPlaying();
      AppMethodBeat.o(138989);
      return bool;
    }
    AppMethodBeat.o(138989);
    return false;
  }
  
  final boolean j(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(138993);
    ad.i(getLogTag(), "requestFullscreen");
    if ((this.cuA != null) && (this.cuA.j(parama)))
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
    ad.i(getLogTag(), "exitFullscreen");
    if ((this.cuA != null) && (this.cuA.k(parama)))
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
    if (this.cuU != null)
    {
      if (this.cuU.getLooper() == Looper.myLooper()) {
        paramRunnable.run();
      }
      for (;;)
      {
        AppMethodBeat.o(138980);
        return true;
        this.cuU.post(paramRunnable);
      }
    }
    AppMethodBeat.o(138980);
    return false;
  }
  
  final void p(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(138978);
    if (this.cuB != null)
    {
      AppMethodBeat.o(138978);
      return;
    }
    this.cuB = this.cuA.a(this.cuw, parama);
    AppMethodBeat.o(138978);
  }
  
  final boolean pause()
  {
    AppMethodBeat.i(138986);
    if (this.cuu != null)
    {
      if (!this.cuI)
      {
        ad.i(getLogTag(), "video pause, video not prepared yet, pause video when prepared");
        this.cuF = false;
        AppMethodBeat.o(138986);
        return true;
      }
      if (!this.cuu.isPlaying())
      {
        ad.i(getLogTag(), "video pause, video is not playing");
        AppMethodBeat.o(138986);
        return true;
      }
      ad.i(getLogTag(), "video pause");
      this.cuu.pause();
      if (Gd()) {
        this.cuv.bK(false);
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
    Gw();
    r(parama);
    Gx();
    AppMethodBeat.o(138995);
  }
  
  public final void r(Bitmap paramBitmap)
  {
    AppMethodBeat.i(178848);
    super.r(paramBitmap);
    ad.i(getLogTag(), "*** handler(%s) handlePluginScreenshotTaken", new Object[] { BM() });
    Object localObject = this.cuW;
    int i;
    if (localObject == null)
    {
      ad.w(getLogTag(), "handlePluginScreenshotTaken4JsApiCall, invokeContext is null");
      i = 0;
    }
    for (;;)
    {
      if (i == 0)
      {
        localObject = this.csn;
        if (localObject == null)
        {
          ad.w(getLogTag(), "handlePluginScreenshotTaken4NativeCall, getSnapshotCallback is null");
          AppMethodBeat.o(178848);
          return;
          if (paramBitmap == null)
          {
            ad.w(getLogTag(), "handlePluginScreenshotTaken4JsApiCall, bitmap is null");
            i = 0;
            continue;
          }
          if ((this.crN == 0) || (this.crO == 0)) {
            break label265;
          }
        }
      }
    }
    label265:
    for (Bitmap localBitmap = Bitmap.createScaledBitmap(paramBitmap, (int)(this.cvc * this.crN), (int)(this.cvd * this.crO), false);; localBitmap = paramBitmap)
    {
      this.cuA.a((com.tencent.luggage.xweb_ext.extendplugin.a)localObject, localBitmap);
      this.cuW = null;
      i = 1;
      break;
      if (paramBitmap == null)
      {
        ad.w(getLogTag(), "handlePluginScreenshotTaken4NativeCall, bitmap is null");
        ((com.tencent.luggage.xweb_ext.extendplugin.component.g)localObject).o(null);
        AppMethodBeat.o(178848);
        return;
      }
      localBitmap = paramBitmap;
      if (this.crN != 0)
      {
        localBitmap = paramBitmap;
        if (this.crO != 0) {
          localBitmap = Bitmap.createScaledBitmap(paramBitmap, (int)(this.cvc * this.crN), (int)(this.cvd * this.crO), false);
        }
      }
      ((com.tencent.luggage.xweb_ext.extendplugin.component.g)localObject).o(localBitmap);
      this.csn = null;
      AppMethodBeat.o(178848);
      return;
    }
  }
  
  final void r(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(138997);
    ad.i(getLogTag(), "createMediaPlayer");
    if (this.cuA != null) {
      this.cuu = this.cuA.a(parama, this.cuU);
    }
    if (this.cuu == null)
    {
      ad.e(getLogTag(), "createMediaPlayer, create media player fail");
      AppMethodBeat.o(138997);
      return;
    }
    this.cuJ = true;
    this.cuu.a(new com.tencent.mm.plugin.appbrand.jsapi.video.e.b.e()
    {
      public final boolean ca(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(186804);
        c localc = c.this;
        boolean bool = localc.k(new c.4(localc, paramAnonymousInt1, paramAnonymousInt2));
        AppMethodBeat.o(186804);
        return bool;
      }
    });
    this.cuu.a(new b.d()
    {
      public final boolean cb(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(186805);
        c localc = c.this;
        boolean bool = localc.k(new c.3(localc, paramAnonymousInt1, paramAnonymousInt2));
        AppMethodBeat.o(186805);
        return bool;
      }
    });
    this.cuu.a(new com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f()
    {
      public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramAnonymousb)
      {
        AppMethodBeat.i(186806);
        paramAnonymousb = c.this;
        paramAnonymousb.k(new c.2(paramAnonymousb));
        AppMethodBeat.o(186806);
      }
    });
    this.cuu.a(new b.b()
    {
      public final void GB()
      {
        AppMethodBeat.i(186807);
        c localc = c.this;
        localc.k(new c.38(localc));
        AppMethodBeat.o(186807);
      }
    });
    this.cuu.a(new b.g()
    {
      public final void b(com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramAnonymousb)
      {
        AppMethodBeat.i(186808);
        paramAnonymousb = c.this;
        paramAnonymousb.k(new c.37(paramAnonymousb));
        AppMethodBeat.o(186808);
      }
    });
    this.cuu.a(new b.h()
    {
      public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramAnonymousb, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(186809);
        paramAnonymousb = c.this;
        paramAnonymousb.k(new c.36(paramAnonymousb, paramAnonymousInt1, paramAnonymousInt2));
        AppMethodBeat.o(186809);
      }
    });
    this.cuu.a(new b.a()
    {
      public final void gM(int paramAnonymousInt)
      {
        AppMethodBeat.i(186810);
        c localc = c.this;
        localc.k(new c.35(localc, paramAnonymousInt));
        AppMethodBeat.o(186810);
      }
    });
    if (this.cva != null) {
      this.cva.bG(this.cuI);
    }
    AppMethodBeat.o(138997);
  }
  
  final void release()
  {
    AppMethodBeat.i(186825);
    ad.i(getLogTag(), "video release");
    if (this.cuA != null) {
      this.cuA.w(this.crL);
    }
    Gv();
    Gw();
    if (this.cuv != null)
    {
      this.cuv.destroy();
      this.cuv = null;
      this.cuw = null;
    }
    if (this.cuB != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.ac.e.b localb = this.cuB;
      localb.bpN().destroy();
      localb.lyG = false;
      localb.gW(false);
      localb.bpN().bpW();
      this.cuB = null;
    }
    Gy();
    if (this.crL != null)
    {
      this.crL.FF();
      this.crM = null;
    }
    ad.i(getLogTag(), "video release handler thread");
    if (this.cuU != null) {
      this.cuU.removeCallbacksAndMessages(null);
    }
    if (this.cuV != null) {
      this.cuV.quitSafely();
    }
    AppMethodBeat.o(186825);
  }
  
  final boolean s(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(186830);
    ad.d(getLogTag(), "disableBackgroundPlayAudio");
    ad.d(getLogTag(), "disableBackgroundPlayAudioInternal");
    int i;
    if (parama == null)
    {
      ad.w(getLogTag(), "disableBackgroundPlayAudioInternal, invokeContext is null");
      i = 0;
    }
    while (i != 0)
    {
      this.csl.set(false);
      ad.d(getLogTag(), "disableBackgroundPlayAudio, hasEndedPlaying: %b, videoLooping: %b", new Object[] { Boolean.valueOf(this.cuQ), Boolean.valueOf(this.cuK) });
      if ((this.cuu != null) && ((!this.cuQ) || (this.cuK))) {
        this.cuu.setSurface(this.mSurface);
      }
      this.csj = false;
      if (this.cuv != null) {
        this.cuv.bL(false);
      }
      AppMethodBeat.o(186830);
      return true;
      parama = com.tencent.luggage.xweb_ext.extendplugin.component.e.f(parama);
      if (parama == null)
      {
        ad.w(getLogTag(), "disableBackgroundPlayAudio, audioOfVideoBackgroundPlayManager is null");
        i = 0;
      }
      else
      {
        parama.c(this);
        i = 1;
      }
    }
    AppMethodBeat.o(186830);
    return false;
  }
  
  final void seek(long paramLong)
  {
    AppMethodBeat.i(138992);
    if ((this.cuI) && (this.cuu != null))
    {
      if (Gd()) {
        this.cuv.onVideoWaiting();
      }
      if (this.cuu != null)
      {
        this.cuD = isPlaying();
        paramLong = Math.min(getDuration(), Math.max(0L, paramLong));
        ad.i(getLogTag(), "seek, position:%s, isPlaying:%s, videoEndPlaying:%s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(this.cuD), Boolean.valueOf(this.cuQ) });
        this.cuQ = false;
        this.cuu.seekTo(paramLong);
        AppMethodBeat.o(138992);
      }
    }
    else
    {
      this.cuG = paramLong;
    }
    AppMethodBeat.o(138992);
  }
  
  final void takeScreenshot()
  {
    AppMethodBeat.i(186826);
    ad.i(getLogTag(), "takeScreenshot");
    com.tencent.luggage.xweb_ext.extendplugin.d.a(GK(), this.type, getId());
    AppMethodBeat.o(186826);
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, float paramFloat1, float paramFloat2);
  }
  
  public static abstract interface b
  {
    public abstract void bG(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.c
 * JD-Core Version:    0.7.0.1
 */