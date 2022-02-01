package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import com.tencent.luggage.xweb_ext.extendplugin.a.a;
import com.tencent.luggage.xweb_ext.extendplugin.component.l;
import com.tencent.luggage.xweb_ext.extendplugin.component.m;
import com.tencent.luggage.xweb_ext.extendplugin.component.n;
import com.tencent.luggage.xweb_ext.extendplugin.component.r;
import com.tencent.luggage.xweb_ext.extendplugin.component.s;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.b.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c.j.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.g.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.g.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.g.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.g.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.g.h;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.g.i;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.g.j;
import com.tencent.mm.plugin.appbrand.jsapi.z;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import org.json.JSONObject;

public final class c
  extends com.tencent.luggage.xweb_ext.extendplugin.a.a
  implements com.tencent.luggage.xweb_ext.extendplugin.component.i
{
  protected final HandlerThread JV;
  private int eDA;
  private int eDB;
  private String eDC;
  private String eDD;
  private boolean eDE;
  boolean eDF;
  private boolean eDG;
  private boolean eDH;
  private String eDI;
  private String eDJ;
  private final ConcurrentLinkedQueue<Runnable> eDK;
  private final Handler eDL;
  private volatile com.tencent.luggage.xweb_ext.extendplugin.a eDM;
  private Surface eDN;
  public a eDO;
  private boolean eDP;
  public b eDQ;
  public a eDR;
  public float eDS;
  public float eDT;
  public com.tencent.mm.plugin.appbrand.jsapi.video.e.g eDi;
  public com.tencent.luggage.xweb_ext.extendplugin.component.video.b.d eDj;
  private com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a eDk;
  private com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c eDl;
  public com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e eDm;
  private f eDn;
  com.tencent.luggage.xweb_ext.extendplugin.component.video.b.b eDo;
  private volatile com.tencent.mm.plugin.appbrand.jsapi.al.e.b eDp;
  private boolean eDq;
  private boolean eDr;
  private boolean eDs;
  private boolean eDt;
  private long eDu;
  private boolean eDv;
  public boolean eDw;
  private volatile boolean eDx;
  private boolean eDy;
  private boolean eDz;
  private z exD;
  private int eyA;
  private int eyB;
  private int eyC;
  private boolean eyD;
  boolean eyE;
  boolean eyF;
  final com.tencent.mm.plugin.appbrand.jsapi.video.a.a eyG;
  private com.tencent.mm.plugin.appbrand.jsapi.y.c eyH;
  private String eyI;
  boolean eyL;
  AtomicBoolean eyN;
  private com.tencent.luggage.xweb_ext.extendplugin.component.a eyO;
  private com.tencent.luggage.xweb_ext.extendplugin.component.b<e> eyP;
  public s eyR;
  private boolean eyV;
  public boolean eyW;
  private com.tencent.luggage.xweb_ext.extendplugin.component.i eyX;
  public AtomicBoolean eyY;
  volatile String eyZ;
  private volatile int eyr;
  private volatile int eys;
  com.tencent.luggage.xweb_ext.extendplugin.a eyx;
  private a.a eyy;
  private int eyz;
  private volatile com.tencent.luggage.xweb_ext.extendplugin.component.g eza;
  volatile Bitmap ezb;
  public Surface mSurface;
  public volatile SurfaceTexture mSurfaceTexture;
  volatile String mTitle;
  private int mVideoHeight;
  private int mVideoWidth;
  
  public c()
  {
    AppMethodBeat.i(138972);
    this.eyr = -1;
    this.eys = -1;
    this.eDy = false;
    this.eDz = false;
    this.eyB = 0;
    this.eyC = 0;
    this.eDG = false;
    this.eyL = false;
    this.eyN = null;
    this.eDH = false;
    this.eDI = "";
    this.eDJ = "";
    this.eyG = new com.tencent.mm.plugin.appbrand.jsapi.video.a.a();
    this.eDK = new ConcurrentLinkedQueue();
    this.eDM = null;
    this.eyH = null;
    this.eyI = null;
    this.eDN = null;
    this.eDO = null;
    this.eDP = false;
    this.exD = new c.35(this);
    this.eyO = new com.tencent.luggage.xweb_ext.extendplugin.component.a(this, this.exD)
    {
      public final void a(String paramAnonymousString, com.tencent.luggage.xweb_ext.extendplugin.a paramAnonymousa)
      {
        AppMethodBeat.i(220894);
        a(paramAnonymousa);
        paramAnonymousa = paramAnonymousa.atw();
        if ((paramAnonymousString.contains("insert")) || (paramAnonymousString.contains("update")))
        {
          if (paramAnonymousa.has("autoplay")) {
            this.exE = paramAnonymousa.optBoolean("autoplay");
          }
          paramAnonymousString = ac.Z(paramAnonymousa);
          if (paramAnonymousString != null) {
            this.exF = paramAnonymousString.booleanValue();
          }
        }
        for (;;)
        {
          Log.d(c.this.getLogTag(), "mAutoRotationPluginHandlerCommons.handleJsApi, mIsNeedNotify: " + this.exE + ", mIsAutoRotationEnabled: " + this.exF);
          AppMethodBeat.o(220894);
          return;
          if (paramAnonymousString.contains("operate"))
          {
            paramAnonymousString = paramAnonymousa.optString("type");
            if ((!Util.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equalsIgnoreCase("play"))) {
              this.exE = true;
            }
          }
          else if (paramAnonymousString.contains("remove"))
          {
            this.exE = false;
          }
        }
      }
      
      public final boolean atA()
      {
        return !c.this.eDF;
      }
    };
    this.eyP = new com.tencent.luggage.xweb_ext.extendplugin.component.b()
    {
      private e eEa = null;
      
      public final int getId()
      {
        AppMethodBeat.i(220895);
        int i = c.this.getId();
        AppMethodBeat.o(220895);
        return i;
      }
      
      public final String getKey()
      {
        AppMethodBeat.i(220906);
        String str = c.this.getKey();
        AppMethodBeat.o(220906);
        return str;
      }
      
      public final String getLogTag()
      {
        AppMethodBeat.i(220887);
        String str = c.this.getLogTag();
        AppMethodBeat.o(220887);
        return str;
      }
    };
    this.eDQ = null;
    this.eDR = null;
    this.eyR = null;
    this.eDS = 1.0F;
    this.eDT = 1.0F;
    this.eyV = false;
    this.eyW = false;
    this.eyX = new r();
    this.eyY = new AtomicBoolean(false);
    this.mTitle = null;
    this.eyZ = null;
    this.eza = null;
    this.ezb = null;
    this.JV = com.tencent.threadpool.c.d.jw(String.format("VideoThread_%s", new Object[] { Long.valueOf(System.currentTimeMillis()) }), 5);
    this.JV.start();
    this.eDL = new Handler(this.JV.getLooper());
    AppMethodBeat.o(138972);
  }
  
  private boolean auA()
  {
    AppMethodBeat.i(178849);
    Object localObject;
    if ((this.eyx instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      localObject = this.eyx.aqX();
      if ((localObject instanceof ad)) {
        localObject = (ad)localObject;
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        localObject = ((ad)localObject).getRuntime();
        Log.i(getLogTag(), "cancelResumePlayingWhenRelaunch:%s", new Object[] { Boolean.valueOf(((AppBrandRuntime)localObject).qsG) });
        boolean bool = ((AppBrandRuntime)localObject).qsG;
        AppMethodBeat.o(178849);
        return bool;
        if ((localObject instanceof y)) {
          localObject = ((y)localObject).getCurrentPageView();
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
  
  private void auC()
  {
    AppMethodBeat.i(138996);
    if (this.eDi != null)
    {
      Log.i(getLogTag(), "releaseMediaPlayer");
      this.eDi.a(null);
      this.eDi.a(null);
      this.eDi.a(null);
      this.eDi.a(null);
      this.eDi.a(null);
      this.eDi.a(null);
      this.eDi.stop();
      this.eDi.reset();
      this.eDi.release();
    }
    this.eDi = null;
    this.eDx = false;
    AppMethodBeat.o(138996);
  }
  
  private void auD()
  {
    AppMethodBeat.i(221028);
    if (this.eDi == null)
    {
      AppMethodBeat.o(221028);
      return;
    }
    Object localObject = (com.tencent.mm.plugin.appbrand.jsapi.video.e.c.j)this.eDi.aU(com.tencent.mm.plugin.appbrand.jsapi.video.e.c.j.class);
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.appbrand.jsapi.video.e.c.j)localObject).cwU();
      if (this.eDo != null) {
        this.eDo.a((j.b)localObject);
      }
    }
    AppMethodBeat.o(221028);
  }
  
  private void auE()
  {
    boolean bool1 = true;
    AppMethodBeat.i(138998);
    boolean bool2;
    String str;
    boolean bool3;
    if (this.eDi != null)
    {
      this.eDi.setMute(this.eDz);
      if (this.mSurface != null)
      {
        bool2 = this.eyY.get();
        if ((!this.eDF) && (!bool2))
        {
          Log.i(getLogTag(), "applyMediaPlayerParams, setSurface");
          this.eDi.setSurface(this.mSurface);
          AppMethodBeat.o(138998);
          return;
        }
        str = getLogTag();
        bool3 = this.eDF;
        if (this.eDN == null) {
          break label169;
        }
      }
    }
    for (;;)
    {
      Log.i(str, "applyMediaPlayerParams, setSurface, WebViewInBackground: %b, JustPlayAudio: %b, SurfacePipSet exist: %b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if ((this.eDF) && (this.eDN != null)) {
        this.eDi.setSurface(this.eDN);
      }
      AppMethodBeat.o(138998);
      return;
      label169:
      bool1 = false;
    }
  }
  
  private void auF()
  {
    AppMethodBeat.i(138999);
    if (this.mSurface != null)
    {
      this.mSurface.release();
      this.mSurface = null;
    }
    AppMethodBeat.o(138999);
  }
  
  private boolean aub()
  {
    AppMethodBeat.i(221031);
    if (this.eyx == null)
    {
      Log.w(getLogTag(), "amIBackgroundAudioPlayer, mInsertInvokeContext is null");
      AppMethodBeat.o(221031);
      return false;
    }
    com.tencent.mm.plugin.appbrand.jsapi.al.a locala = com.tencent.luggage.xweb_ext.extendplugin.component.e.f(this.eyx);
    if (locala == null)
    {
      Log.w(getLogTag(), "amIBackgroundAudioPlayer, audioOfVideoBackgroundPlayManager is null");
      AppMethodBeat.o(221031);
      return false;
    }
    boolean bool = locala.a(this);
    AppMethodBeat.o(221031);
    return bool;
  }
  
  private void auz()
  {
    AppMethodBeat.i(138979);
    if ((this.eDi != null) && (this.mSurface != null))
    {
      int i = this.eDi.getVideoWidth();
      int j = this.eDi.getVideoHeight();
      if ((i == 0) && (j == 0))
      {
        Log.w(getLogTag(), "VideoCanvas, registerMediaPlayer, width or height is 0");
        AppMethodBeat.o(138979);
        return;
      }
      if (!this.eDG)
      {
        this.eDG = true;
        com.tencent.mm.plugin.appbrand.i.a.coh().a(getId(), this, this.mSurface, i, j, this.eyx.getAppId());
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
  
  private String b(com.tencent.luggage.xweb_ext.extendplugin.a parama, String paramString)
  {
    AppMethodBeat.i(138982);
    String str = paramString;
    if (this.eDo != null) {
      str = this.eDo.b(parama, paramString);
    }
    AppMethodBeat.o(138982);
    return str;
  }
  
  private void c(com.tencent.luggage.xweb_ext.extendplugin.a parama, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(138981);
    if (!paramJSONObject.has("enableCasting"))
    {
      AppMethodBeat.o(138981);
      return;
    }
    boolean bool = paramJSONObject.optBoolean("enableCasting");
    Log.d(getLogTag(), "isEnableVideoCast = ".concat(String.valueOf(bool)));
    q(parama);
    this.eDp.sQy = bool;
    AppMethodBeat.o(138981);
  }
  
  private void cW(boolean paramBoolean)
  {
    AppMethodBeat.i(221017);
    if (!Util.isNullOrNil(this.eDD))
    {
      if ((auT() != null) && (this.eDn != null))
      {
        float f1 = this.eDS;
        float f2 = this.eDT;
        if (this.eDn.a(this.eDD, this.eyz, this.eyA, this.mVideoWidth, this.mVideoHeight))
        {
          this.eDS = this.eDn.auR();
          this.eDT = this.eDn.auS();
          Log.i(getLogTag(), "adjust objectFit:%s, scale:[%s, %s]", new Object[] { this.eDD, Float.valueOf(this.eDS), Float.valueOf(this.eDT) });
          if ((!this.eDF) || (this.eDN == null)) {
            break label218;
          }
          this.eDP = true;
          Log.i(getLogTag(), "adjust objectFit, TextureScale sticky");
        }
        for (;;)
        {
          if (((this.eDS != f1) || (this.eDT != f2)) && (this.eDO != null)) {
            this.eDO.a(paramBoolean, this.eDS, this.eDT);
          }
          AppMethodBeat.o(221017);
          return;
          label218:
          com.tencent.luggage.xweb_ext.extendplugin.d.a(auT(), this.type, getId(), this.eDS, this.eDT);
          this.eDP = false;
        }
      }
      Log.i(getLogTag(), "adjust objectFit, video not prepared");
      AppMethodBeat.o(221017);
      return;
    }
    Log.i(getLogTag(), "adjust objectFit, no video objectFit");
    AppMethodBeat.o(221017);
  }
  
  private void cX(boolean paramBoolean)
  {
    AppMethodBeat.i(221019);
    if (this.eDi != null)
    {
      Log.i(getLogTag(), "video prepare async");
      if ((paramBoolean) && (atY())) {
        this.eDj.onVideoWaiting();
      }
      this.eDw = false;
      this.eDt = false;
      if (this.eDo != null) {
        this.eDo.a(this.eDi);
      }
      this.eDi.prepareAsync();
    }
    AppMethodBeat.o(221019);
  }
  
  private int getDuration()
  {
    AppMethodBeat.i(138991);
    if (this.eDi != null)
    {
      int i = this.eDi.getDuration();
      AppMethodBeat.o(138991);
      return i;
    }
    AppMethodBeat.o(138991);
    return 0;
  }
  
  private boolean isPlaying()
  {
    AppMethodBeat.i(138989);
    if (this.eDi != null)
    {
      boolean bool = this.eDi.isPlaying();
      AppMethodBeat.o(138989);
      return bool;
    }
    AppMethodBeat.o(138989);
    return false;
  }
  
  private boolean j(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(138993);
    Log.i(getLogTag(), "requestFullscreen");
    if ((this.eDo != null) && (this.eDo.j(parama)))
    {
      AppMethodBeat.o(138993);
      return true;
    }
    AppMethodBeat.o(138993);
    return false;
  }
  
  private boolean k(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(138994);
    Log.i(getLogTag(), "exitFullscreen");
    if ((this.eDo != null) && (this.eDo.k(parama)))
    {
      AppMethodBeat.o(138994);
      return true;
    }
    AppMethodBeat.o(138994);
    return false;
  }
  
  private boolean pause()
  {
    AppMethodBeat.i(138986);
    if (this.eDi != null)
    {
      if (!this.eDw)
      {
        Log.i(getLogTag(), "video pause, video not prepared yet, pause video when prepared");
        this.eDt = false;
        AppMethodBeat.o(138986);
        return true;
      }
      if (!this.eDi.isPlaying())
      {
        Log.i(getLogTag(), "video pause, video is not playing");
        AppMethodBeat.o(138986);
        return true;
      }
      Log.i(getLogTag(), "video pause");
      Log.d(getLogTag(), "video pause, mWebViewInBackground: %b, isRuntimeInBackground: %b", new Object[] { Boolean.valueOf(this.eDF), Boolean.valueOf(this.eyL) });
      com.tencent.threadpool.h.ahAA.bk(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(220965);
          Log.i(c.this.getLogTag(), "video pause, abandonFocus");
          c.this.eyG.cvG();
          AppMethodBeat.o(220965);
        }
      });
      this.eDi.pause();
      if (atY()) {
        this.eDj.dc(false);
      }
      AppMethodBeat.o(138986);
      return true;
    }
    AppMethodBeat.o(138986);
    return false;
  }
  
  private void q(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(138978);
    if (this.eDp != null)
    {
      AppMethodBeat.o(138978);
      return;
    }
    this.eDp = this.eDo.a(this.eDk, parama);
    AppMethodBeat.o(138978);
  }
  
  private void r(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(138995);
    auC();
    s(parama);
    auE();
    AppMethodBeat.o(138995);
  }
  
  private void release()
  {
    AppMethodBeat.i(221022);
    Log.i(getLogTag(), "video release");
    if (this.eDo != null) {
      this.eDo.x(this.eyx);
    }
    stop();
    auD();
    auC();
    if (this.eDj != null)
    {
      this.eDj.destroy();
      this.eDj = null;
      this.eDk = null;
    }
    if (this.eDp != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.al.e.b localb = this.eDp;
      localb.cyO().destroy();
      localb.sQz = false;
      localb.jV(false);
      localb.cyO().cyZ();
      this.eDp = null;
    }
    auF();
    if (this.eyx != null)
    {
      this.eyx.aty();
      this.eyy = null;
    }
    Log.i(getLogTag(), "video release handler thread");
    this.eDL.removeCallbacksAndMessages(null);
    this.JV.quitSafely();
    AppMethodBeat.o(221022);
  }
  
  private void s(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(138997);
    Log.i(getLogTag(), "createMediaPlayer");
    if (this.eDo != null) {
      this.eDi = this.eDo.a(parama, this.eDL);
    }
    if (this.eDi == null)
    {
      Log.e(getLogTag(), "createMediaPlayer, create media player fail");
      AppMethodBeat.o(138997);
      return;
    }
    this.eDx = true;
    this.eDi.a(new g.g()
    {
      public final boolean onInfo(com.tencent.mm.plugin.appbrand.jsapi.video.e.g paramAnonymousg, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(220947);
        paramAnonymousg = c.this;
        boolean bool = paramAnonymousg.o(new c.5(paramAnonymousg, paramAnonymousInt1, paramAnonymousInt2));
        AppMethodBeat.o(220947);
        return bool;
      }
    });
    this.eDi.a(new g.e()
    {
      public final boolean onError(com.tencent.mm.plugin.appbrand.jsapi.video.e.g paramAnonymousg, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(220945);
        paramAnonymousg = c.this;
        boolean bool = paramAnonymousg.o(new c.4(paramAnonymousg, paramAnonymousInt1, paramAnonymousInt2));
        AppMethodBeat.o(220945);
        return bool;
      }
    });
    this.eDi.a(new g.h()
    {
      public final void onPrepared(com.tencent.mm.plugin.appbrand.jsapi.video.e.g paramAnonymousg)
      {
        AppMethodBeat.i(220946);
        paramAnonymousg = c.this;
        paramAnonymousg.o(new c.3(paramAnonymousg));
        AppMethodBeat.o(220946);
      }
    });
    this.eDi.a(new g.b()
    {
      public final void onCompletion(com.tencent.mm.plugin.appbrand.jsapi.video.e.g paramAnonymousg)
      {
        AppMethodBeat.i(220938);
        paramAnonymousg = c.this;
        paramAnonymousg.o(new c.47(paramAnonymousg));
        AppMethodBeat.o(220938);
      }
    });
    this.eDi.a(new g.i()
    {
      public final void onSeekComplete(com.tencent.mm.plugin.appbrand.jsapi.video.e.g paramAnonymousg)
      {
        AppMethodBeat.i(220937);
        paramAnonymousg = c.this;
        paramAnonymousg.o(new c.46(paramAnonymousg));
        AppMethodBeat.o(220937);
      }
    });
    this.eDi.a(new g.j()
    {
      public final void onVideoSizeChanged(com.tencent.mm.plugin.appbrand.jsapi.video.e.g paramAnonymousg, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(220915);
        paramAnonymousg = c.this;
        paramAnonymousg.o(new c.45(paramAnonymousg, paramAnonymousInt1, paramAnonymousInt2));
        AppMethodBeat.o(220915);
      }
    });
    this.eDi.a(new g.a()
    {
      public final void onBufferingUpdate(com.tencent.mm.plugin.appbrand.jsapi.video.e.g paramAnonymousg, int paramAnonymousInt)
      {
        AppMethodBeat.i(220918);
        paramAnonymousg = c.this;
        paramAnonymousg.o(new c.44(paramAnonymousg, paramAnonymousInt));
        AppMethodBeat.o(220918);
      }
    });
    if (this.eDQ != null) {
      this.eDQ.cY(this.eDw);
    }
    AppMethodBeat.o(138997);
  }
  
  private void seek(long paramLong)
  {
    AppMethodBeat.i(138992);
    if ((this.eDw) && (this.eDi != null))
    {
      if (atY()) {
        this.eDj.onVideoWaiting();
      }
      if (this.eDi != null)
      {
        this.eDr = isPlaying();
        paramLong = Math.min(getDuration(), Math.max(0L, paramLong));
        Log.i(getLogTag(), "seek, position:%s, isPlaying:%s, videoEndPlaying:%s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(this.eDr), Boolean.valueOf(this.eDE) });
        this.eDE = false;
        this.eDi.seekTo(paramLong);
        AppMethodBeat.o(138992);
      }
    }
    else
    {
      this.eDu = paramLong;
    }
    AppMethodBeat.o(138992);
  }
  
  private boolean stop()
  {
    AppMethodBeat.i(138987);
    if (this.eDi != null)
    {
      if (this.eDo != null) {
        this.eDo.a(this.eyx, this.eDi);
      }
      if (!this.eDw)
      {
        Log.i(getLogTag(), "video stop, video not prepared yet, stop video when prepared");
        this.eDt = false;
        AppMethodBeat.o(138987);
        return true;
      }
      Log.i(getLogTag(), "video stop");
      Log.d(getLogTag(), "video stop, mWebViewInBackground: %b, isRuntimeInBackground: %b", new Object[] { Boolean.valueOf(this.eDF), Boolean.valueOf(this.eyL) });
      com.tencent.threadpool.h.ahAA.bk(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(220969);
          Log.i(c.this.getLogTag(), "video stop, abandonFocus");
          c.this.eyG.cvG();
          AppMethodBeat.o(220969);
        }
      });
      this.eDi.stop();
      if (atY()) {
        this.eDj.dc(true);
      }
      AppMethodBeat.o(138987);
      return true;
    }
    AppMethodBeat.o(138987);
    return false;
  }
  
  private boolean t(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(221033);
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
      this.eyY.set(false);
      Log.d(getLogTag(), "disableBackgroundPlayAudio, webViewInBackground: %b", new Object[] { Boolean.valueOf(this.eDF) });
      if ((this.eDi != null) && (!this.eDF)) {
        this.eDi.setSurface(this.mSurface);
      }
      this.eyW = false;
      if (this.eDj != null) {
        this.eDj.dd(false);
      }
      AppMethodBeat.o(221033);
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
    AppMethodBeat.o(221033);
    return false;
  }
  
  private void takeScreenshot()
  {
    AppMethodBeat.i(221025);
    Log.i(getLogTag(), "takeScreenshot");
    com.tencent.luggage.xweb_ext.extendplugin.d.a(auT(), this.type, getId());
    AppMethodBeat.o(221025);
  }
  
  public final void B(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(221075);
    this.eyB = com.tencent.mm.plugin.appbrand.af.i.DC(paramJSONObject.optInt("x", this.eyB));
    this.eyC = com.tencent.mm.plugin.appbrand.af.i.DC(paramJSONObject.optInt("y", this.eyC));
    Log.d(getLogTag(), "updateVideoPosition, mPosX: %d, mPosY: %d", new Object[] { Integer.valueOf(this.eyB), Integer.valueOf(this.eyC) });
    AppMethodBeat.o(221075);
  }
  
  public final void a(com.tencent.luggage.xweb_ext.extendplugin.component.video.b.b paramb)
  {
    AppMethodBeat.i(221067);
    this.eDo = paramb;
    if (this.eDo != null)
    {
      this.eDo.m(this);
      this.eDn = this.eDo.auM();
      this.eDm = this.eDo.auN();
      this.eDk = this.eDo.auQ();
      this.eDj = this.eDo.auP();
      this.eDj.m(this);
      this.eDj.a(this.eDR);
      this.eDj.a(this.eyR);
      this.eDl = this.eDo.auO();
      this.eDl.a(new com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c.a()
      {
        public final void onVideoError(String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(138967);
          Log.w(c.this.getLogTag(), "send video error event, what:%d, extra:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          if (c.this.atY()) {
            c.this.eDj.onVideoError(paramAnonymousString, paramAnonymousInt1, paramAnonymousInt2);
          }
          if (c.this.eDo != null) {
            c.this.eDo.a(c.this.eDi, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString);
          }
          if (c.this.eDm != null)
          {
            if (!com.tencent.mm.plugin.appbrand.jsapi.video.k.d(c.this.eDi)) {
              break label182;
            }
            if (paramAnonymousInt1 != -1024) {
              break label164;
            }
            c.this.eDm.dw(-paramAnonymousInt2);
            c.this.eDm.dw(0L);
          }
          for (;;)
          {
            c.b(c.this);
            AppMethodBeat.o(138967);
            return;
            label164:
            c.this.eDm.dw(41L);
            continue;
            label182:
            c.this.eDm.dw(42L);
          }
        }
      });
    }
    AppMethodBeat.o(221067);
  }
  
  public final <AddOn extends com.tencent.luggage.xweb_ext.extendplugin.component.j> void a(Class<AddOn> paramClass, AddOn paramAddOn)
  {
    AppMethodBeat.i(221077);
    Log.i(getLogTag(), "setAddOn for " + paramClass.getSimpleName());
    this.eyX.a(paramClass, paramAddOn);
    AppMethodBeat.o(221077);
  }
  
  public final <AddOn extends com.tencent.luggage.xweb_ext.extendplugin.component.j> AddOn ah(Class<AddOn> paramClass)
  {
    AppMethodBeat.i(221078);
    Log.i(getLogTag(), "getAddOn for " + paramClass.getSimpleName());
    paramClass = this.eyX.ah(paramClass);
    AppMethodBeat.o(221078);
    return paramClass;
  }
  
  public final void atW()
  {
    AppMethodBeat.i(138976);
    this.mSurfaceTexture = null;
    o(new Runnable()
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
  final boolean atY()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 584	com/tencent/luggage/xweb_ext/extendplugin/component/video/c:eyD	Z
    //   6: ifeq +18 -> 24
    //   9: aload_0
    //   10: getfield 404	com/tencent/luggage/xweb_ext/extendplugin/component/video/c:eDj	Lcom/tencent/luggage/xweb_ext/extendplugin/component/video/b/d;
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
  
  final boolean atZ()
  {
    AppMethodBeat.i(221070);
    boolean bool = this.eyP.d(this.eyx);
    AppMethodBeat.o(221070);
    return bool;
  }
  
  public final void auB()
  {
    AppMethodBeat.i(221069);
    o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(220975);
        c.h(c.this);
        AppMethodBeat.o(220975);
      }
    });
    AppMethodBeat.o(221069);
  }
  
  public final Integer auG()
  {
    AppMethodBeat.i(221072);
    Object localObject = this.eyx;
    if (localObject == null)
    {
      Log.w(getLogTag(), "getOriginPageViewId, invokeContext is null");
      AppMethodBeat.o(221072);
      return null;
    }
    localObject = com.tencent.luggage.xweb_ext.extendplugin.component.b.e((com.tencent.luggage.xweb_ext.extendplugin.a)localObject);
    if (localObject == null)
    {
      Log.w(getLogTag(), "getOriginPageViewId, pageView is null");
      AppMethodBeat.o(221072);
      return null;
    }
    int i = localObject.hashCode();
    AppMethodBeat.o(221072);
    return Integer.valueOf(i);
  }
  
  public final int auH()
  {
    AppMethodBeat.i(221073);
    int i = (int)(this.eDS * this.eyz);
    Log.d(getLogTag(), "getVideoContainerWidth, videoContainerWidth: ".concat(String.valueOf(i)));
    AppMethodBeat.o(221073);
    return i;
  }
  
  public final int auI()
  {
    AppMethodBeat.i(221074);
    int i = (int)(this.eDT * this.eyA);
    Log.d(getLogTag(), "getVideoContainerHeight, videoContainerHeight: ".concat(String.valueOf(i)));
    AppMethodBeat.o(221074);
    return i;
  }
  
  public final int auJ()
  {
    AppMethodBeat.i(177169);
    int i = (int)(this.eyB + (1.0F - this.eDS) * this.eyz / 2.0F);
    Log.d(getLogTag(), "getVideoPositionX, videoPosX: ".concat(String.valueOf(i)));
    AppMethodBeat.o(177169);
    return i;
  }
  
  public final int auK()
  {
    AppMethodBeat.i(177170);
    int i = (int)(this.eyC + (1.0F - this.eDT) * this.eyA / 2.0F);
    Log.d(getLogTag(), "getVideoPositionY, videoPosY: ".concat(String.valueOf(i)));
    AppMethodBeat.o(177170);
    return i;
  }
  
  public final void aua()
  {
    AppMethodBeat.i(221068);
    o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(220971);
        if ((c.this.eDi != null) && (!c.this.eDi.isPlaying())) {
          c.this.n(false, true);
        }
        AppMethodBeat.o(220971);
      }
    });
    AppMethodBeat.o(221068);
  }
  
  public final boolean auy()
  {
    AppMethodBeat.i(177165);
    if ((this.eyN != null) && (this.eyN.get()))
    {
      AppMethodBeat.o(177165);
      return true;
    }
    AppMethodBeat.o(177165);
    return false;
  }
  
  public final void e(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(138974);
    i(new Surface(paramSurfaceTexture));
    AppMethodBeat.o(138974);
  }
  
  public final boolean g(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    return true;
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(138990);
    if (this.eDi != null)
    {
      int i = this.eDi.getCurrentPosition();
      AppMethodBeat.o(138990);
      return i;
    }
    AppMethodBeat.o(138990);
    return 0;
  }
  
  public final String getKey()
  {
    AppMethodBeat.i(177168);
    String str = key() + "@" + hashCode();
    AppMethodBeat.o(177168);
    return str;
  }
  
  protected final String getLogTag()
  {
    AppMethodBeat.i(138973);
    String str = String.format("%s(%s)", new Object[] { "MicroMsg.SameLayer.VideoPluginHandler", key() });
    AppMethodBeat.o(138973);
    return str;
  }
  
  public final String getName()
  {
    AppMethodBeat.i(221076);
    String str = getKey();
    AppMethodBeat.o(221076);
    return str;
  }
  
  public final String h(final com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(138977);
    o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(138966);
        c.a(c.this, parama);
        AppMethodBeat.o(138966);
      }
    });
    AppMethodBeat.o(138977);
    return null;
  }
  
  public final void i(final Surface paramSurface)
  {
    AppMethodBeat.i(221066);
    super.i(paramSurface);
    o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(138945);
        c.a(c.this, paramSurface);
        AppMethodBeat.o(138945);
      }
    });
    AppMethodBeat.o(221066);
  }
  
  public final boolean j(Surface paramSurface)
  {
    AppMethodBeat.i(221071);
    if (this.eDi != null)
    {
      if (!this.eyY.get())
      {
        this.eDi.setSurface(paramSurface);
        if (this.mSurface != paramSurface) {
          break label99;
        }
        this.eDN = null;
        label46:
        paramSurface = getLogTag();
        if (this.eDN == null) {
          break label107;
        }
      }
      label99:
      label107:
      for (boolean bool = true;; bool = false)
      {
        Log.i(paramSurface, "setSurface, SurfacePipSet exist: %b", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(221071);
        return true;
        Log.i(getLogTag(), "setSurface, JustPlayAudio");
        break;
        this.eDN = paramSurface;
        break label46;
      }
    }
    Log.w(getLogTag(), "setSurface, MediaPlayer is null");
    AppMethodBeat.o(221071);
    return false;
  }
  
  final boolean n(boolean paramBoolean1, boolean paramBoolean2)
  {
    String str2 = null;
    AppMethodBeat.i(177166);
    if (this.eDi != null)
    {
      if ((this.eDw) && (this.eDi.isPlaying()))
      {
        Log.i(getLogTag(), "video play, video is playing");
        if (atY()) {
          this.eDj.db(paramBoolean1);
        }
        AppMethodBeat.o(177166);
        return true;
      }
      if ((this.eDi != null) && (!this.eDw))
      {
        Log.i(getLogTag(), "video play, video not prepared yet, start until prepared");
        this.eDt = true;
        AppMethodBeat.o(177166);
        return true;
      }
      if ((this.eDi != null) && (this.eDi.getState() == 5))
      {
        if (!paramBoolean2)
        {
          Log.i(getLogTag(), "video has ended playing, do not restart");
          AppMethodBeat.o(177166);
          return false;
        }
        Log.i(getLogTag(), "video play, video has stopped now, try prepare and start when prepared");
        cX(true);
        this.eDt = true;
        AppMethodBeat.o(177166);
        return true;
      }
      if (this.eDE)
      {
        if (!paramBoolean2)
        {
          Log.i(getLogTag(), "video has ended playing, do not restart");
          AppMethodBeat.o(177166);
          return false;
        }
        Log.i(getLogTag(), "video play, video has ended playing, clear surface and start again");
        this.eDE = false;
        try
        {
          if ((this.mSurface != null) && (this.eDw))
          {
            Log.i(getLogTag(), "clearSurfaceFrame");
            Object localObject2 = this.mSurface;
            localEGL10 = (EGL10)EGLContext.getEGL();
            localObject1 = localEGL10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            localEGL10.eglInitialize((EGLDisplay)localObject1, null);
            Object localObject3 = new EGLConfig[1];
            int[] arrayOfInt = new int[1];
            localEGL10.eglChooseConfig((EGLDisplay)localObject1, new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344, 0, 12344 }, (EGLConfig[])localObject3, 1, arrayOfInt);
            arrayOfInt = localObject3[0];
            localObject3 = localEGL10.eglCreateContext((EGLDisplay)localObject1, arrayOfInt, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
            localObject2 = localEGL10.eglCreateWindowSurface((EGLDisplay)localObject1, arrayOfInt, localObject2, new int[] { 12344 });
            localEGL10.eglMakeCurrent((EGLDisplay)localObject1, (EGLSurface)localObject2, (EGLSurface)localObject2, (EGLContext)localObject3);
            GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
            GLES20.glClear(16384);
            localEGL10.eglSwapBuffers((EGLDisplay)localObject1, (EGLSurface)localObject2);
            localEGL10.eglDestroySurface((EGLDisplay)localObject1, (EGLSurface)localObject2);
            localObject2 = EGL10.EGL_NO_SURFACE;
            localEGL10.eglMakeCurrent((EGLDisplay)localObject1, (EGLSurface)localObject2, (EGLSurface)localObject2, EGL10.EGL_NO_CONTEXT);
            localEGL10.eglDestroyContext((EGLDisplay)localObject1, (EGLContext)localObject3);
            localEGL10.eglTerminate((EGLDisplay)localObject1);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            EGL10 localEGL10;
            Object localObject1;
            Log.printErrStackTrace(getLogTag(), localException, "clearSurfaceFrame error", new Object[0]);
            continue;
            String str1 = this.eDI;
            continue;
            str2 = this.eDJ;
            continue;
            this.eDi.ey((String)localObject1, this.eyI);
            continue;
            if (this.eDH) {
              this.eDi.M(this.eDC, str1, str2);
            } else {
              this.eDi.ey(this.eDC, this.eyI);
            }
          }
        }
        r(this.eyx);
        if (this.eDi != null)
        {
          localObject1 = b(this.eyx, this.eDC);
          auD();
          if (Util.isNullOrNil(this.eDI))
          {
            localEGL10 = null;
            if (!Util.isNullOrNil(this.eDJ)) {
              break label720;
            }
            Log.i(getLogTag(), "play, isDrm, provisionUrl:%s, licenseUrl:%s", new Object[] { localEGL10, str2 });
            if (Util.isNullOrNil((String)localObject1)) {
              break label747;
            }
            if (!this.eDH) {
              break label729;
            }
            this.eDi.M((String)localObject1, localEGL10, str2);
            Log.i(getLogTag(), "video play, media player state:%s", new Object[] { Integer.valueOf(this.eDi.getState()) });
            cX(false);
            this.eDt = true;
          }
        }
        else
        {
          AppMethodBeat.o(177166);
          return true;
        }
      }
      label720:
      label729:
      label747:
      Log.i(getLogTag(), "video play");
      if (this.eDi != null)
      {
        if (atY()) {
          this.eDj.db(paramBoolean1);
        }
        Log.i(getLogTag(), "applyPluginTextureScaleIfNeed");
        if (this.eDP) {
          break label943;
        }
        Log.i(getLogTag(), "applyPluginTextureScaleIfNeed, TextureScale is not sticky");
      }
      for (;;)
      {
        Log.d(getLogTag(), "video play, mWebViewInBackground: %b, isRuntimeInBackground: %b", new Object[] { Boolean.valueOf(this.eDF), Boolean.valueOf(this.eyL) });
        if ((!this.eDF) && (!this.eyL) && (!this.eDz)) {
          com.tencent.threadpool.h.ahAA.bk(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(220977);
              Log.i(c.this.getLogTag(), "video play, requestFocus");
              c.this.eyG.cvF();
              AppMethodBeat.o(220977);
            }
          });
        }
        this.eDi.start();
        AppMethodBeat.o(177166);
        return true;
        label943:
        if ((this.eDF) && (this.eDN != null)) {
          Log.i(getLogTag(), "applyPluginTextureScaleIfNeed, in PIP mode");
        } else {
          com.tencent.luggage.xweb_ext.extendplugin.d.a(auT(), this.type, getId(), this.eDS, this.eDT);
        }
      }
    }
    AppMethodBeat.o(177166);
    return false;
  }
  
  public final boolean o(Runnable paramRunnable)
  {
    AppMethodBeat.i(138980);
    if (this.eDL.getLooper() == Looper.myLooper()) {
      paramRunnable.run();
    }
    for (;;)
    {
      AppMethodBeat.o(138980);
      return true;
      this.eDL.post(paramRunnable);
    }
  }
  
  public final void y(Bitmap paramBitmap)
  {
    AppMethodBeat.i(178848);
    super.y(paramBitmap);
    Log.i(getLogTag(), "*** handler(%s) handlePluginScreenshotTaken", new Object[] { key() });
    Object localObject = this.eDM;
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
        localObject = this.eza;
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
          if ((this.eyz == 0) || (this.eyA == 0)) {
            break label265;
          }
        }
      }
    }
    label265:
    for (Bitmap localBitmap = Bitmap.createScaledBitmap(paramBitmap, (int)(this.eDS * this.eyz), (int)(this.eDT * this.eyA), false);; localBitmap = paramBitmap)
    {
      this.eDo.a((com.tencent.luggage.xweb_ext.extendplugin.a)localObject, localBitmap);
      this.eDM = null;
      i = 1;
      break;
      if (paramBitmap == null)
      {
        Log.w(getLogTag(), "handlePluginScreenshotTaken4NativeCall, bitmap is null");
        ((com.tencent.luggage.xweb_ext.extendplugin.component.g)localObject).v(null);
        AppMethodBeat.o(178848);
        return;
      }
      localBitmap = paramBitmap;
      if (this.eyz != 0)
      {
        localBitmap = paramBitmap;
        if (this.eyA != 0) {
          localBitmap = Bitmap.createScaledBitmap(paramBitmap, (int)(this.eDS * this.eyz), (int)(this.eDT * this.eyA), false);
        }
      }
      ((com.tencent.luggage.xweb_ext.extendplugin.component.g)localObject).v(localBitmap);
      this.eza = null;
      AppMethodBeat.o(178848);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, float paramFloat1, float paramFloat2);
  }
  
  public static abstract interface b
  {
    public abstract void cY(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.c
 * JD-Core Version:    0.7.0.1
 */