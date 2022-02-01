package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import com.tencent.luggage.xweb_ext.extendplugin.a.a;
import com.tencent.luggage.xweb_ext.extendplugin.component.j;
import com.tencent.luggage.xweb_ext.extendplugin.component.k;
import com.tencent.luggage.xweb_ext.extendplugin.component.l;
import com.tencent.luggage.xweb_ext.extendplugin.component.m;
import com.tencent.luggage.xweb_ext.extendplugin.component.n;
import com.tencent.luggage.xweb_ext.extendplugin.component.r;
import com.tencent.luggage.xweb_ext.extendplugin.component.s;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.b.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e.h;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e.i;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e.j;
import com.tencent.mm.plugin.appbrand.jsapi.y;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.v;
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
import org.json.JSONObject;

public class c
  extends com.tencent.luggage.xweb_ext.extendplugin.a.a
  implements com.tencent.luggage.xweb_ext.extendplugin.component.i
{
  private y cEs;
  private com.tencent.luggage.xweb_ext.extendplugin.component.a cFA;
  private com.tencent.luggage.xweb_ext.extendplugin.component.b<e> cFB;
  public s cFD;
  private boolean cFH;
  public boolean cFI;
  private com.tencent.luggage.xweb_ext.extendplugin.component.i cFJ;
  public AtomicBoolean cFK;
  volatile String cFL;
  private volatile com.tencent.luggage.xweb_ext.extendplugin.component.g cFM;
  volatile Bitmap cFN;
  com.tencent.luggage.xweb_ext.extendplugin.a cFj;
  private a.a cFk;
  private int cFl;
  private int cFm;
  private int cFn;
  private int cFo;
  private boolean cFp;
  boolean cFq;
  boolean cFr;
  final com.tencent.mm.plugin.appbrand.jsapi.video.a.a cFs;
  private com.tencent.mm.plugin.appbrand.jsapi.v.c cFt;
  private String cFu;
  boolean cFx;
  AtomicBoolean cFz;
  public com.tencent.luggage.xweb_ext.extendplugin.component.video.b.d cJA;
  private com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a cJB;
  private com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c cJC;
  public com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e cJD;
  private f cJE;
  com.tencent.luggage.xweb_ext.extendplugin.component.video.b.b cJF;
  private volatile com.tencent.mm.plugin.appbrand.jsapi.ai.e.b cJG;
  private boolean cJH;
  private boolean cJI;
  private boolean cJJ;
  private boolean cJK;
  private long cJL;
  private boolean cJM;
  public boolean cJN;
  private volatile boolean cJO;
  private boolean cJP;
  private boolean cJQ;
  private int cJR;
  private int cJS;
  private String cJT;
  private String cJU;
  private boolean cJV;
  boolean cJW;
  private boolean cJX;
  private final ConcurrentLinkedQueue<Runnable> cJY;
  private Handler cJZ;
  public com.tencent.mm.plugin.appbrand.jsapi.video.e.e cJz;
  private HandlerThread cKa;
  private volatile com.tencent.luggage.xweb_ext.extendplugin.a cKb;
  private Surface cKc;
  public a cKd;
  private boolean cKe;
  public b cKf;
  public a cKg;
  public float cKh;
  public float cKi;
  public Surface mSurface;
  public SurfaceTexture mSurfaceTexture;
  volatile String mTitle;
  private int mVideoHeight;
  private int mVideoWidth;
  
  public c()
  {
    AppMethodBeat.i(138972);
    this.cJP = false;
    this.cJQ = false;
    this.cFn = 0;
    this.cFo = 0;
    this.cJX = false;
    this.cFx = false;
    this.cFz = null;
    this.cFs = new com.tencent.mm.plugin.appbrand.jsapi.video.a.a();
    this.cJY = new ConcurrentLinkedQueue();
    this.cKb = null;
    this.cFt = null;
    this.cFu = null;
    this.cKc = null;
    this.cKd = null;
    this.cKe = false;
    this.cEs = new c.35(this);
    this.cFA = new com.tencent.luggage.xweb_ext.extendplugin.component.a(this, this.cEs)
    {
      public final boolean SV()
      {
        return !c.this.cJW;
      }
      
      public final void a(String paramAnonymousString, com.tencent.luggage.xweb_ext.extendplugin.a paramAnonymousa)
      {
        AppMethodBeat.i(223045);
        a(paramAnonymousa);
        paramAnonymousa = paramAnonymousa.SR();
        if ((paramAnonymousString.contains("insert")) || (paramAnonymousString.contains("update")))
        {
          if (paramAnonymousa.has("autoplay")) {
            this.cEt = paramAnonymousa.optBoolean("autoplay");
          }
          paramAnonymousString = ab.O(paramAnonymousa);
          if (paramAnonymousString != null) {
            this.cEu = paramAnonymousString.booleanValue();
          }
        }
        for (;;)
        {
          Log.d(c.this.getLogTag(), "mAutoRotationPluginHandlerCommons.handleJsApi, mIsNeedNotify: " + this.cEt + ", mIsAutoRotationEnabled: " + this.cEu);
          AppMethodBeat.o(223045);
          return;
          if (paramAnonymousString.contains("operate"))
          {
            paramAnonymousString = paramAnonymousa.optString("type");
            if ((!Util.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equalsIgnoreCase("play"))) {
              this.cEt = true;
            }
          }
          else if (paramAnonymousString.contains("remove"))
          {
            this.cEt = false;
          }
        }
      }
    };
    this.cFB = new com.tencent.luggage.xweb_ext.extendplugin.component.b()
    {
      private e cKp = null;
      
      public final int getId()
      {
        AppMethodBeat.i(225527);
        int i = c.this.getId();
        AppMethodBeat.o(225527);
        return i;
      }
      
      public final String getKey()
      {
        AppMethodBeat.i(225528);
        String str = c.this.getKey();
        AppMethodBeat.o(225528);
        return str;
      }
      
      public final String getLogTag()
      {
        AppMethodBeat.i(225525);
        String str = c.this.getLogTag();
        AppMethodBeat.o(225525);
        return str;
      }
    };
    this.cKf = null;
    this.cKg = null;
    this.cFD = null;
    this.cKh = 1.0F;
    this.cKi = 1.0F;
    this.cFH = false;
    this.cFI = false;
    this.cFJ = new r();
    this.cFK = new AtomicBoolean(false);
    this.mTitle = null;
    this.cFL = null;
    this.cFM = null;
    this.cFN = null;
    this.cKa = com.tencent.e.c.d.ik(String.format("VideoThread_%s", new Object[] { Long.valueOf(System.currentTimeMillis()) }), 5);
    this.cKa.start();
    this.cJZ = new Handler(this.cKa.getLooper());
    AppMethodBeat.o(138972);
  }
  
  private void TR()
  {
    AppMethodBeat.i(138975);
    synchronized (this.cJY)
    {
      if (this.cJY.isEmpty()) {
        break label102;
      }
      Log.i(getLogTag(), "flushPendingTasks, size:%d", new Object[] { Integer.valueOf(this.cJY.size()) });
      Iterator localIterator = this.cJY.iterator();
      if (localIterator.hasNext()) {
        ((Runnable)localIterator.next()).run();
      }
    }
    this.cJY.clear();
    label102:
    AppMethodBeat.o(138975);
  }
  
  private void TS()
  {
    AppMethodBeat.i(138979);
    if ((this.cJz != null) && (this.mSurfaceTexture != null))
    {
      int i = this.cJz.getVideoWidth();
      int j = this.cJz.getVideoHeight();
      if ((i == 0) && (j == 0))
      {
        Log.w(getLogTag(), "VideoCanvas, registerMediaPlayer, width or height is 0");
        AppMethodBeat.o(138979);
        return;
      }
      if (!this.cJX)
      {
        this.cJX = true;
        com.tencent.mm.plugin.appbrand.i.a.bNU().a(getId(), this, this.mSurfaceTexture, i, j, this.cFj.getAppId());
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
  
  private boolean TT()
  {
    AppMethodBeat.i(178849);
    Object localObject;
    if ((this.cFj instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      localObject = this.cFj.QK();
      if ((localObject instanceof ad)) {
        localObject = (ad)localObject;
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        localObject = ((ad)localObject).getRuntime();
        Log.i(getLogTag(), "cancelResumePlayingWhenRelaunch:%s", new Object[] { Boolean.valueOf(((AppBrandRuntime)localObject).ntW) });
        boolean bool = ((AppBrandRuntime)localObject).ntW;
        AppMethodBeat.o(178849);
        return bool;
        if ((localObject instanceof v)) {
          localObject = ((v)localObject).getCurrentPageView();
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
  
  private boolean TV()
  {
    AppMethodBeat.i(138987);
    if (this.cJz != null)
    {
      if (this.cJF != null) {
        this.cJF.a(this.cFj, this.cJz);
      }
      if (!this.cJN)
      {
        Log.i(getLogTag(), "video stop, video not prepared yet, stop video when prepared");
        this.cJK = false;
        AppMethodBeat.o(138987);
        return true;
      }
      Log.i(getLogTag(), "video stop");
      Log.d(getLogTag(), "video stop, mWebViewInBackground: %b, isRuntimeInBackground: %b", new Object[] { Boolean.valueOf(this.cJW), Boolean.valueOf(this.cFx) });
      com.tencent.e.h.ZvG.bc(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(224393);
          Log.i(c.this.getLogTag(), "video stop, abandonFocus");
          c.this.cFs.bVs();
          AppMethodBeat.o(224393);
        }
      });
      this.cJz.stop();
      if (Tt()) {
        this.cJA.cw(true);
      }
      AppMethodBeat.o(138987);
      return true;
    }
    AppMethodBeat.o(138987);
    return false;
  }
  
  private void TW()
  {
    AppMethodBeat.i(138996);
    if (this.cJz != null)
    {
      Log.i(getLogTag(), "releaseMediaPlayer");
      this.cJz.a(null);
      this.cJz.a(null);
      this.cJz.a(null);
      this.cJz.a(null);
      this.cJz.a(null);
      this.cJz.a(null);
      this.cJz.stop();
      this.cJz.reset();
      this.cJz.release();
    }
    this.cJz = null;
    this.cJO = false;
    AppMethodBeat.o(138996);
  }
  
  private void TX()
  {
    AppMethodBeat.i(221686);
    if ((this.cJz != null) && ((this.cJz instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g)))
    {
      g.b localb = ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g)this.cJz).bWF();
      if (this.cJF != null) {
        this.cJF.a(localb);
      }
    }
    AppMethodBeat.o(221686);
  }
  
  private void TY()
  {
    boolean bool1 = true;
    AppMethodBeat.i(138998);
    boolean bool2;
    String str;
    boolean bool3;
    if (this.cJz != null)
    {
      this.cJz.setMute(this.cJQ);
      if (this.mSurface != null)
      {
        bool2 = this.cFK.get();
        if ((!this.cJW) && (!bool2))
        {
          Log.i(getLogTag(), "applyMediaPlayerParams, setSurface");
          this.cJz.setSurface(this.mSurface);
          AppMethodBeat.o(138998);
          return;
        }
        str = getLogTag();
        bool3 = this.cJW;
        if (this.cKc == null) {
          break label169;
        }
      }
    }
    for (;;)
    {
      Log.i(str, "applyMediaPlayerParams, setSurface, WebViewInBackground: %b, JustPlayAudio: %b, SurfacePipSet exist: %b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if ((this.cJW) && (this.cKc != null)) {
        this.cJz.setSurface(this.cKc);
      }
      AppMethodBeat.o(138998);
      return;
      label169:
      bool1 = false;
    }
  }
  
  private void TZ()
  {
    AppMethodBeat.i(138999);
    if (this.mSurface != null)
    {
      this.mSurface.release();
      this.mSurface = null;
    }
    AppMethodBeat.o(138999);
  }
  
  private boolean Tw()
  {
    AppMethodBeat.i(221730);
    if (this.cFj == null)
    {
      Log.w(getLogTag(), "amIBackgroundAudioPlayer, mInsertInvokeContext is null");
      AppMethodBeat.o(221730);
      return false;
    }
    com.tencent.mm.plugin.appbrand.jsapi.ai.a locala = com.tencent.luggage.xweb_ext.extendplugin.component.e.f(this.cFj);
    if (locala == null)
    {
      Log.w(getLogTag(), "amIBackgroundAudioPlayer, audioOfVideoBackgroundPlayManager is null");
      AppMethodBeat.o(221730);
      return false;
    }
    boolean bool = locala.a(this);
    AppMethodBeat.o(221730);
    return bool;
  }
  
  private void Ug()
  {
    AppMethodBeat.i(221746);
    if ((Uf()) && (this.mSurfaceTexture != null))
    {
      Log.i(getLogTag(), "setSurfaceSizeInternal, setDefaultBufferSize, width: %d, height: %d", new Object[] { Integer.valueOf(this.cFl), Integer.valueOf(this.cFm) });
      this.mSurfaceTexture.setDefaultBufferSize(this.cFl, this.cFm);
    }
    AppMethodBeat.o(221746);
  }
  
  private String b(com.tencent.luggage.xweb_ext.extendplugin.a parama, String paramString)
  {
    AppMethodBeat.i(138982);
    String str = paramString;
    if (this.cJF != null) {
      str = this.cJF.b(parama, paramString);
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
    this.cJG.pLD = bool;
    AppMethodBeat.o(138981);
  }
  
  private void cq(boolean paramBoolean)
  {
    AppMethodBeat.i(221604);
    if (!Util.isNullOrNil(this.cJU))
    {
      if ((Uq() != null) && (this.cJE != null))
      {
        float f1 = this.cKh;
        float f2 = this.cKi;
        if (this.cJE.a(this.cJU, this.cFl, this.cFm, this.mVideoWidth, this.mVideoHeight))
        {
          this.cKh = this.cJE.Uo();
          this.cKi = this.cJE.Up();
          Log.i(getLogTag(), "adjust objectFit:%s, scale:[%s, %s]", new Object[] { this.cJU, Float.valueOf(this.cKh), Float.valueOf(this.cKi) });
          if ((!this.cJW) || (this.cKc == null)) {
            break label218;
          }
          this.cKe = true;
          Log.i(getLogTag(), "adjust objectFit, TextureScale sticky");
        }
        for (;;)
        {
          if (((this.cKh != f1) || (this.cKi != f2)) && (this.cKd != null)) {
            this.cKd.a(paramBoolean, this.cKh, this.cKi);
          }
          AppMethodBeat.o(221604);
          return;
          label218:
          com.tencent.luggage.xweb_ext.extendplugin.d.a(Uq(), this.type, getId(), this.cKh, this.cKi);
          this.cKe = false;
        }
      }
      Log.i(getLogTag(), "adjust objectFit, video not prepared");
      AppMethodBeat.o(221604);
      return;
    }
    Log.i(getLogTag(), "adjust objectFit, no video objectFit");
    AppMethodBeat.o(221604);
  }
  
  private void cr(boolean paramBoolean)
  {
    AppMethodBeat.i(221607);
    if (this.cJz != null)
    {
      Log.i(getLogTag(), "video prepare async");
      if ((paramBoolean) && (Tt())) {
        this.cJA.onVideoWaiting();
      }
      this.cJN = false;
      this.cJK = false;
      if (this.cJF != null) {
        this.cJF.c(this.cJz);
      }
      this.cJz.prepareAsync();
    }
    AppMethodBeat.o(221607);
  }
  
  private int getDuration()
  {
    AppMethodBeat.i(138991);
    if (this.cJz != null)
    {
      int i = this.cJz.getDuration();
      AppMethodBeat.o(138991);
      return i;
    }
    AppMethodBeat.o(138991);
    return 0;
  }
  
  private boolean isPlaying()
  {
    AppMethodBeat.i(138989);
    if (this.cJz != null)
    {
      boolean bool = this.cJz.isPlaying();
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
    if ((this.cJF != null) && (this.cJF.j(parama)))
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
    if ((this.cJF != null) && (this.cJF.k(parama)))
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
    if (this.cJz != null)
    {
      if (!this.cJN)
      {
        Log.i(getLogTag(), "video pause, video not prepared yet, pause video when prepared");
        this.cJK = false;
        AppMethodBeat.o(138986);
        return true;
      }
      if (!this.cJz.isPlaying())
      {
        Log.i(getLogTag(), "video pause, video is not playing");
        AppMethodBeat.o(138986);
        return true;
      }
      Log.i(getLogTag(), "video pause");
      Log.d(getLogTag(), "video pause, mWebViewInBackground: %b, isRuntimeInBackground: %b", new Object[] { Boolean.valueOf(this.cJW), Boolean.valueOf(this.cFx) });
      com.tencent.e.h.ZvG.bc(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(223886);
          Log.i(c.this.getLogTag(), "video pause, abandonFocus");
          c.this.cFs.bVs();
          AppMethodBeat.o(223886);
        }
      });
      this.cJz.pause();
      if (Tt()) {
        this.cJA.cw(false);
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
    if (this.cJG != null)
    {
      AppMethodBeat.o(138978);
      return;
    }
    this.cJG = this.cJF.a(this.cJB, parama);
    AppMethodBeat.o(138978);
  }
  
  private void r(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(138995);
    TW();
    s(parama);
    TY();
    AppMethodBeat.o(138995);
  }
  
  private void release()
  {
    AppMethodBeat.i(221658);
    Log.i(getLogTag(), "video release");
    if (this.cJF != null) {
      this.cJF.x(this.cFj);
    }
    TV();
    TX();
    TW();
    if (this.cJA != null)
    {
      this.cJA.destroy();
      this.cJA = null;
      this.cJB = null;
    }
    if (this.cJG != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.ai.e.b localb = this.cJG;
      localb.bYy().destroy();
      localb.pLE = false;
      localb.iP(false);
      localb.bYy().bYI();
      this.cJG = null;
    }
    TZ();
    if (this.cFj != null)
    {
      this.cFj.ST();
      this.cFk = null;
    }
    Log.i(getLogTag(), "video release handler thread");
    if (this.cJZ != null) {
      this.cJZ.removeCallbacksAndMessages(null);
    }
    if (this.cKa != null) {
      this.cKa.quitSafely();
    }
    AppMethodBeat.o(221658);
  }
  
  private void s(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(138997);
    Log.i(getLogTag(), "createMediaPlayer");
    if (this.cJF != null) {
      this.cJz = this.cJF.a(parama, this.cJZ);
    }
    if (this.cJz == null)
    {
      Log.e(getLogTag(), "createMediaPlayer, create media player fail");
      AppMethodBeat.o(138997);
      return;
    }
    this.cJO = true;
    this.cJz.a(new e.g()
    {
      public final boolean ct(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(223457);
        c localc = c.this;
        boolean bool = localc.k(new c.5(localc, paramAnonymousInt1, paramAnonymousInt2));
        AppMethodBeat.o(223457);
        return bool;
      }
    });
    this.cJz.a(new e.e()
    {
      public final boolean cu(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(223454);
        c localc = c.this;
        boolean bool = localc.k(new c.4(localc, paramAnonymousInt1, paramAnonymousInt2));
        AppMethodBeat.o(223454);
        return bool;
      }
    });
    this.cJz.a(new e.h()
    {
      public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.e paramAnonymouse)
      {
        AppMethodBeat.i(223200);
        paramAnonymouse = c.this;
        paramAnonymouse.k(new c.3(paramAnonymouse));
        AppMethodBeat.o(223200);
      }
    });
    this.cJz.a(new e.b()
    {
      public final void Uh()
      {
        AppMethodBeat.i(225132);
        c localc = c.this;
        localc.k(new c.47(localc));
        AppMethodBeat.o(225132);
      }
    });
    this.cJz.a(new e.i()
    {
      public final void b(com.tencent.mm.plugin.appbrand.jsapi.video.e.e paramAnonymouse)
      {
        AppMethodBeat.i(222739);
        paramAnonymouse = c.this;
        paramAnonymouse.k(new c.46(paramAnonymouse));
        AppMethodBeat.o(222739);
      }
    });
    this.cJz.a(new e.j()
    {
      public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.e paramAnonymouse, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(225273);
        paramAnonymouse = c.this;
        paramAnonymouse.k(new c.45(paramAnonymouse, paramAnonymousInt1, paramAnonymousInt2));
        AppMethodBeat.o(225273);
      }
    });
    this.cJz.a(new e.a()
    {
      public final void jg(int paramAnonymousInt)
      {
        AppMethodBeat.i(222415);
        c localc = c.this;
        localc.k(new c.44(localc, paramAnonymousInt));
        AppMethodBeat.o(222415);
      }
    });
    if (this.cKf != null) {
      this.cKf.cs(this.cJN);
    }
    AppMethodBeat.o(138997);
  }
  
  private void seek(long paramLong)
  {
    AppMethodBeat.i(138992);
    if ((this.cJN) && (this.cJz != null))
    {
      if (Tt()) {
        this.cJA.onVideoWaiting();
      }
      if (this.cJz != null)
      {
        this.cJI = isPlaying();
        paramLong = Math.min(getDuration(), Math.max(0L, paramLong));
        Log.i(getLogTag(), "seek, position:%s, isPlaying:%s, videoEndPlaying:%s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(this.cJI), Boolean.valueOf(this.cJV) });
        this.cJV = false;
        this.cJz.seekTo(paramLong);
        AppMethodBeat.o(138992);
      }
    }
    else
    {
      this.cJL = paramLong;
    }
    AppMethodBeat.o(138992);
  }
  
  private boolean t(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(221734);
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
      this.cFK.set(false);
      Log.d(getLogTag(), "disableBackgroundPlayAudio, webViewInBackground: %b", new Object[] { Boolean.valueOf(this.cJW) });
      if ((this.cJz != null) && (!this.cJW)) {
        this.cJz.setSurface(this.mSurface);
      }
      this.cFI = false;
      if (this.cJA != null) {
        this.cJA.cx(false);
      }
      AppMethodBeat.o(221734);
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
    AppMethodBeat.o(221734);
    return false;
  }
  
  private void takeScreenshot()
  {
    AppMethodBeat.i(221676);
    Log.i(getLogTag(), "takeScreenshot");
    com.tencent.luggage.xweb_ext.extendplugin.d.a(Uq(), this.type, getId());
    AppMethodBeat.o(221676);
  }
  
  public final boolean TQ()
  {
    AppMethodBeat.i(177165);
    if ((this.cFz != null) && (this.cFz.get()))
    {
      AppMethodBeat.o(177165);
      return true;
    }
    AppMethodBeat.o(177165);
    return false;
  }
  
  public final void TU()
  {
    AppMethodBeat.i(221634);
    k(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(222298);
        c.h(c.this);
        AppMethodBeat.o(222298);
      }
    });
    AppMethodBeat.o(221634);
  }
  
  public final void Tr()
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
  final boolean Tt()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 779	com/tencent/luggage/xweb_ext/extendplugin/component/video/c:cFp	Z
    //   6: ifeq +18 -> 24
    //   9: aload_0
    //   10: getfield 526	com/tencent/luggage/xweb_ext/extendplugin/component/video/c:cJA	Lcom/tencent/luggage/xweb_ext/extendplugin/component/video/b/d;
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
  
  final boolean Tu()
  {
    AppMethodBeat.i(221701);
    boolean bool = this.cFB.d(this.cFj);
    AppMethodBeat.o(221701);
    return bool;
  }
  
  public final void Tv()
  {
    AppMethodBeat.i(221609);
    k(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(222963);
        if ((c.this.cJz != null) && (!c.this.cJz.isPlaying())) {
          c.this.l(false, true);
        }
        AppMethodBeat.o(222963);
      }
    });
    AppMethodBeat.o(221609);
  }
  
  public final Integer Ua()
  {
    AppMethodBeat.i(221711);
    Object localObject = this.cFj;
    if (localObject == null)
    {
      Log.w(getLogTag(), "getOriginPageViewId, invokeContext is null");
      AppMethodBeat.o(221711);
      return null;
    }
    localObject = com.tencent.luggage.xweb_ext.extendplugin.component.b.e((com.tencent.luggage.xweb_ext.extendplugin.a)localObject);
    if (localObject == null)
    {
      Log.w(getLogTag(), "getOriginPageViewId, pageView is null");
      AppMethodBeat.o(221711);
      return null;
    }
    int i = localObject.hashCode();
    AppMethodBeat.o(221711);
    return Integer.valueOf(i);
  }
  
  public final int Ub()
  {
    AppMethodBeat.i(221713);
    int i = (int)(this.cKh * this.cFl);
    Log.d(getLogTag(), "getVideoContainerWidth, videoContainerWidth: ".concat(String.valueOf(i)));
    AppMethodBeat.o(221713);
    return i;
  }
  
  public final int Uc()
  {
    AppMethodBeat.i(221717);
    int i = (int)(this.cKi * this.cFm);
    Log.d(getLogTag(), "getVideoContainerHeight, videoContainerHeight: ".concat(String.valueOf(i)));
    AppMethodBeat.o(221717);
    return i;
  }
  
  public final int Ud()
  {
    AppMethodBeat.i(177169);
    int i = (int)(this.cFn + (1.0F - this.cKh) * this.cFl / 2.0F);
    Log.d(getLogTag(), "getVideoPositionX, videoPosX: ".concat(String.valueOf(i)));
    AppMethodBeat.o(177169);
    return i;
  }
  
  public final int Ue()
  {
    AppMethodBeat.i(177170);
    int i = (int)(this.cFo + (1.0F - this.cKi) * this.cFm / 2.0F);
    Log.d(getLogTag(), "getVideoPositionY, videoPosY: ".concat(String.valueOf(i)));
    AppMethodBeat.o(177170);
    return i;
  }
  
  protected boolean Uf()
  {
    return false;
  }
  
  public final <AddOn extends j> AddOn X(Class<AddOn> paramClass)
  {
    AppMethodBeat.i(221740);
    Log.i(getLogTag(), "getAddOn for " + paramClass.getSimpleName());
    paramClass = this.cFJ.X(paramClass);
    AppMethodBeat.o(221740);
    return paramClass;
  }
  
  public final void a(com.tencent.luggage.xweb_ext.extendplugin.component.video.b.b paramb)
  {
    AppMethodBeat.i(221590);
    this.cJF = paramb;
    if (this.cJF != null)
    {
      this.cJF.m(this);
      this.cJE = this.cJF.Uj();
      this.cJD = this.cJF.Uk();
      this.cJB = this.cJF.Un();
      this.cJA = this.cJF.Um();
      this.cJA.m(this);
      this.cJA.a(this.cKg);
      this.cJA.a(this.cFD);
      this.cJC = this.cJF.Ul();
      this.cJC.a(new com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c.a()
      {
        public final void i(String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(138967);
          Log.w(c.this.getLogTag(), "send video error event, what:%d, extra:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          if (c.this.Tt()) {
            c.this.cJA.i(paramAnonymousString, paramAnonymousInt1, paramAnonymousInt2);
          }
          if (c.this.cJF != null) {
            c.this.cJF.a(c.this.cJz, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString);
          }
          if (c.this.cJD != null)
          {
            if (!(c.this.cJz instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.i)) {
              break label182;
            }
            if (paramAnonymousInt1 != -1024) {
              break label164;
            }
            c.this.cJD.be(-paramAnonymousInt2);
            c.this.cJD.be(0L);
          }
          for (;;)
          {
            c.b(c.this);
            AppMethodBeat.o(138967);
            return;
            label164:
            c.this.cJD.be(41L);
            continue;
            label182:
            c.this.cJD.be(42L);
          }
        }
      });
    }
    AppMethodBeat.o(221590);
  }
  
  public final <AddOn extends j> void a(Class<AddOn> paramClass, AddOn paramAddOn)
  {
    AppMethodBeat.i(221739);
    Log.i(getLogTag(), "setAddOn for " + paramClass.getSimpleName());
    this.cFJ.a(paramClass, paramAddOn);
    AppMethodBeat.o(221739);
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
  
  public final boolean f(Surface paramSurface)
  {
    AppMethodBeat.i(221705);
    if (this.cJz != null)
    {
      if (!this.cFK.get())
      {
        this.cJz.setSurface(paramSurface);
        if (this.mSurface != paramSurface) {
          break label99;
        }
        this.cKc = null;
        label46:
        paramSurface = getLogTag();
        if (this.cKc == null) {
          break label107;
        }
      }
      label99:
      label107:
      for (boolean bool = true;; bool = false)
      {
        Log.i(paramSurface, "setSurface, SurfacePipSet exist: %b", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(221705);
        return true;
        Log.i(getLogTag(), "setSurface, JustPlayAudio");
        break;
        this.cKc = paramSurface;
        break label46;
      }
    }
    Log.w(getLogTag(), "setSurface, MediaPlayer is null");
    AppMethodBeat.o(221705);
    return false;
  }
  
  public final boolean g(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    return true;
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(138990);
    if (this.cJz != null)
    {
      int i = this.cJz.getCurrentPosition();
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
    AppMethodBeat.i(221736);
    String str = getKey();
    AppMethodBeat.o(221736);
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
        c.a(c.this, parama);
        AppMethodBeat.o(138966);
      }
    });
    AppMethodBeat.o(138977);
    return null;
  }
  
  public final boolean k(Runnable paramRunnable)
  {
    AppMethodBeat.i(138980);
    if (this.cJZ != null)
    {
      if (this.cJZ.getLooper() == Looper.myLooper()) {
        paramRunnable.run();
      }
      for (;;)
      {
        AppMethodBeat.o(138980);
        return true;
        this.cJZ.post(paramRunnable);
      }
    }
    AppMethodBeat.o(138980);
    return false;
  }
  
  final boolean l(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(177166);
    if (this.cJz != null)
    {
      if ((this.cJN) && (this.cJz.isPlaying()))
      {
        Log.i(getLogTag(), "video play, video is playing");
        if (Tt()) {
          this.cJA.cv(paramBoolean1);
        }
        AppMethodBeat.o(177166);
        return true;
      }
      if ((this.cJz != null) && (!this.cJN))
      {
        Log.i(getLogTag(), "video play, video not prepared yet, start until prepared");
        this.cJK = true;
        AppMethodBeat.o(177166);
        return true;
      }
      if ((this.cJz != null) && (this.cJz.getState() == 5))
      {
        if (!paramBoolean2)
        {
          Log.i(getLogTag(), "video has ended playing, do not restart");
          AppMethodBeat.o(177166);
          return false;
        }
        Log.i(getLogTag(), "video play, video has stopped now, try prepare and start when prepared");
        cr(true);
        this.cJK = true;
        AppMethodBeat.o(177166);
        return true;
      }
      if (this.cJV)
      {
        if (!paramBoolean2)
        {
          Log.i(getLogTag(), "video has ended playing, do not restart");
          AppMethodBeat.o(177166);
          return false;
        }
        Log.i(getLogTag(), "video play, video has ended playing, clear surface and start again");
        this.cJV = false;
        try
        {
          if ((this.mSurfaceTexture != null) && (this.cJN))
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
            TX();
            this.cJz.ef(this.cJT, this.cFu);
          }
        }
        r(this.cFj);
        if (this.cJz != null)
        {
          this.cJM = true;
          localObject1 = b(this.cFj, this.cJT);
          if (!Util.isNullOrNil((String)localObject1))
          {
            TX();
            this.cJz.ef((String)localObject1, this.cFu);
            Log.i(getLogTag(), "video play, media player state:%s", new Object[] { Integer.valueOf(this.cJz.getState()) });
            cr(false);
            this.cJK = true;
          }
        }
        else
        {
          AppMethodBeat.o(177166);
          return true;
        }
      }
      Log.i(getLogTag(), "video play");
      if (this.cJz != null)
      {
        if (Tt()) {
          this.cJA.cv(paramBoolean1);
        }
        Log.i(getLogTag(), "applyPluginTextureScaleIfNeed");
        if (this.cKe) {
          break label834;
        }
        Log.i(getLogTag(), "applyPluginTextureScaleIfNeed, TextureScale is not sticky");
      }
      for (;;)
      {
        Log.d(getLogTag(), "video play, mWebViewInBackground: %b, isRuntimeInBackground: %b", new Object[] { Boolean.valueOf(this.cJW), Boolean.valueOf(this.cFx) });
        if ((!this.cJW) && (!this.cFx) && (!this.cJQ)) {
          com.tencent.e.h.ZvG.bc(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(223188);
              Log.i(c.this.getLogTag(), "video play, requestFocus");
              c.this.cFs.bVr();
              AppMethodBeat.o(223188);
            }
          });
        }
        this.cJz.start();
        AppMethodBeat.o(177166);
        return true;
        label834:
        if ((this.cJW) && (this.cKc != null)) {
          Log.i(getLogTag(), "applyPluginTextureScaleIfNeed, in PIP mode");
        } else {
          com.tencent.luggage.xweb_ext.extendplugin.d.a(Uq(), this.type, getId(), this.cKh, this.cKi);
        }
      }
    }
    AppMethodBeat.o(177166);
    return false;
  }
  
  public final void n(Bitmap paramBitmap)
  {
    AppMethodBeat.i(178848);
    super.n(paramBitmap);
    Log.i(getLogTag(), "*** handler(%s) handlePluginScreenshotTaken", new Object[] { key() });
    Object localObject = this.cKb;
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
        localObject = this.cFM;
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
          if ((this.cFl == 0) || (this.cFm == 0)) {
            break label265;
          }
        }
      }
    }
    label265:
    for (Bitmap localBitmap = Bitmap.createScaledBitmap(paramBitmap, (int)(this.cKh * this.cFl), (int)(this.cKi * this.cFm), false);; localBitmap = paramBitmap)
    {
      this.cJF.a((com.tencent.luggage.xweb_ext.extendplugin.a)localObject, localBitmap);
      this.cKb = null;
      i = 1;
      break;
      if (paramBitmap == null)
      {
        Log.w(getLogTag(), "handlePluginScreenshotTaken4NativeCall, bitmap is null");
        ((com.tencent.luggage.xweb_ext.extendplugin.component.g)localObject).k(null);
        AppMethodBeat.o(178848);
        return;
      }
      localBitmap = paramBitmap;
      if (this.cFl != 0)
      {
        localBitmap = paramBitmap;
        if (this.cFm != 0) {
          localBitmap = Bitmap.createScaledBitmap(paramBitmap, (int)(this.cKh * this.cFl), (int)(this.cKi * this.cFm), false);
        }
      }
      ((com.tencent.luggage.xweb_ext.extendplugin.component.g)localObject).k(localBitmap);
      this.cFM = null;
      AppMethodBeat.o(178848);
      return;
    }
  }
  
  public final void t(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(221721);
    this.cFn = com.tencent.mm.plugin.appbrand.ac.g.Di(paramJSONObject.optInt("x", this.cFn));
    this.cFo = com.tencent.mm.plugin.appbrand.ac.g.Di(paramJSONObject.optInt("y", this.cFo));
    Log.d(getLogTag(), "updateVideoPosition, mPosX: %d, mPosY: %d", new Object[] { Integer.valueOf(this.cFn), Integer.valueOf(this.cFo) });
    AppMethodBeat.o(221721);
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, float paramFloat1, float paramFloat2);
  }
  
  public static abstract interface b
  {
    public abstract void cs(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.c
 * JD-Core Version:    0.7.0.1
 */