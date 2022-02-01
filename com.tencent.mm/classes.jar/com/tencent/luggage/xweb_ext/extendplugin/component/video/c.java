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
import com.tencent.luggage.xweb_ext.extendplugin.component.s;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.b.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.g.b.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.ad.e.a.h.p;
import com.tencent.mm.plugin.appbrand.jsapi.ad.e.b.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.h;
import com.tencent.mm.plugin.appbrand.jsapi.w;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
  implements com.tencent.luggage.xweb_ext.extendplugin.component.i
{
  private w crv;
  boolean csB;
  AtomicBoolean csD;
  com.tencent.luggage.xweb_ext.extendplugin.component.a csE;
  com.tencent.luggage.xweb_ext.extendplugin.component.b<e> csF;
  public s csH;
  boolean csL;
  public boolean csM;
  private com.tencent.luggage.xweb_ext.extendplugin.component.i csN;
  public AtomicBoolean csO;
  volatile String csP;
  volatile com.tencent.luggage.xweb_ext.extendplugin.component.g csQ;
  volatile Bitmap csR;
  public com.tencent.luggage.xweb_ext.extendplugin.a cso;
  a.a csp;
  public int csq;
  public int csr;
  public int css;
  public int cst;
  boolean csu;
  boolean csv;
  boolean csw;
  com.tencent.mm.plugin.appbrand.jsapi.s.c csx;
  String csy;
  public com.tencent.mm.plugin.appbrand.jsapi.video.e.b cuX;
  public com.tencent.luggage.xweb_ext.extendplugin.component.video.b.d cuY;
  public com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a cuZ;
  Surface cvA;
  public c.a cvB;
  private boolean cvC;
  public b cvD;
  public a cvE;
  public float cvF;
  public float cvG;
  public com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c cva;
  public com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e cvb;
  public f cvc;
  public com.tencent.luggage.xweb_ext.extendplugin.component.video.b.b cvd;
  volatile com.tencent.mm.plugin.appbrand.jsapi.ad.e.b cve;
  boolean cvf;
  boolean cvg;
  boolean cvh;
  boolean cvi;
  long cvj;
  boolean cvk;
  public boolean cvl;
  volatile boolean cvm;
  boolean cvn;
  boolean cvo;
  int cvp;
  int cvq;
  String cvr;
  String cvs;
  boolean cvt;
  boolean cvu;
  private boolean cvv;
  private final ConcurrentLinkedQueue<Runnable> cvw;
  Handler cvx;
  private HandlerThread cvy;
  volatile com.tencent.luggage.xweb_ext.extendplugin.a cvz;
  public Surface mSurface;
  public SurfaceTexture mSurfaceTexture;
  volatile String mTitle;
  int mVideoHeight;
  int mVideoWidth;
  
  public c()
  {
    AppMethodBeat.i(138972);
    this.cvn = false;
    this.cvo = false;
    this.css = 0;
    this.cst = 0;
    this.cvv = false;
    this.csB = false;
    this.csD = null;
    this.cvw = new ConcurrentLinkedQueue();
    this.cvz = null;
    this.csx = null;
    this.csy = null;
    this.cvA = null;
    this.cvB = null;
    this.cvC = false;
    this.crv = new c.26(this);
    this.csE = new com.tencent.luggage.xweb_ext.extendplugin.component.a(this, this.crv)
    {
      public final boolean FM()
      {
        return !c.this.cvu;
      }
      
      public final void a(String paramAnonymousString, com.tencent.luggage.xweb_ext.extendplugin.a paramAnonymousa)
      {
        AppMethodBeat.i(220496);
        a(paramAnonymousa);
        paramAnonymousa = paramAnonymousa.FJ();
        if ((paramAnonymousString.contains("insert")) || (paramAnonymousString.contains("update")))
        {
          if (paramAnonymousa.has("autoplay")) {
            this.crw = paramAnonymousa.optBoolean("autoplay");
          }
          paramAnonymousString = com.tencent.mm.plugin.appbrand.jsapi.z.D(paramAnonymousa);
          if (paramAnonymousString != null) {
            this.crx = paramAnonymousString.booleanValue();
          }
        }
        for (;;)
        {
          ae.d(c.this.getLogTag(), "mAutoRotationPluginHandlerCommons.handleJsApi, mIsNeedNotify: " + this.crw + ", mIsAutoRotationEnabled: " + this.crx);
          AppMethodBeat.o(220496);
          return;
          if (paramAnonymousString.contains("operate"))
          {
            paramAnonymousString = paramAnonymousa.optString("type");
            if ((!bu.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equalsIgnoreCase("play"))) {
              this.crw = true;
            }
          }
          else if (paramAnonymousString.contains("remove"))
          {
            this.crw = false;
          }
        }
      }
    };
    this.csF = new com.tencent.luggage.xweb_ext.extendplugin.component.b()
    {
      private e cvN = null;
      
      public final int getId()
      {
        AppMethodBeat.i(220498);
        int i = c.this.getId();
        AppMethodBeat.o(220498);
        return i;
      }
      
      public final String getKey()
      {
        AppMethodBeat.i(220499);
        String str = c.this.getKey();
        AppMethodBeat.o(220499);
        return str;
      }
      
      public final String getLogTag()
      {
        AppMethodBeat.i(220497);
        String str = c.this.getLogTag();
        AppMethodBeat.o(220497);
        return str;
      }
    };
    this.cvD = null;
    this.cvE = null;
    this.csH = null;
    this.cvF = 1.0F;
    this.cvG = 1.0F;
    this.csL = false;
    this.csM = false;
    this.csN = new com.tencent.luggage.xweb_ext.extendplugin.component.r();
    this.csO = new AtomicBoolean(false);
    this.mTitle = null;
    this.csP = null;
    this.csQ = null;
    this.csR = null;
    this.cvy = com.tencent.e.c.d.hg(String.format("VideoThread_%s", new Object[] { Long.valueOf(System.currentTimeMillis()) }), 5);
    this.cvy.start();
    this.cvx = new Handler(this.cvy.getLooper());
    AppMethodBeat.o(138972);
  }
  
  private void GC()
  {
    AppMethodBeat.i(138996);
    if (this.cuX != null)
    {
      ae.i(getLogTag(), "releaseMediaPlayer");
      this.cuX.a(null);
      this.cuX.a(null);
      this.cuX.a(null);
      this.cuX.a(null);
      this.cuX.a(null);
      this.cuX.a(null);
      this.cuX.stop();
      this.cuX.reset();
      this.cuX.release();
    }
    this.cuX = null;
    this.cvm = false;
    AppMethodBeat.o(138996);
  }
  
  private void GD()
  {
    boolean bool1 = true;
    AppMethodBeat.i(138998);
    boolean bool2;
    String str;
    boolean bool3;
    if (this.cuX != null)
    {
      this.cuX.setMute(this.cvo);
      if (this.mSurface != null)
      {
        bool2 = this.csO.get();
        if ((!this.cvu) && (!bool2))
        {
          ae.i(getLogTag(), "applyMediaPlayerParams, setSurface");
          this.cuX.setSurface(this.mSurface);
          AppMethodBeat.o(138998);
          return;
        }
        str = getLogTag();
        bool3 = this.cvu;
        if (this.cvA == null) {
          break label169;
        }
      }
    }
    for (;;)
    {
      ae.i(str, "applyMediaPlayerParams, setSurface, WebViewInBackground: %b, JustPlayAudio: %b, SurfacePipSet exist: %b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if ((this.cvu) && (this.cvA != null)) {
        this.cuX.setSurface(this.cvA);
      }
      AppMethodBeat.o(138998);
      return;
      label169:
      bool1 = false;
    }
  }
  
  private void GE()
  {
    AppMethodBeat.i(138999);
    if (this.mSurface != null)
    {
      this.mSurface.release();
      this.mSurface = null;
    }
    AppMethodBeat.o(138999);
  }
  
  private void Gx()
  {
    AppMethodBeat.i(138975);
    synchronized (this.cvw)
    {
      if (this.cvw.isEmpty()) {
        break label102;
      }
      ae.i(getLogTag(), "flushPendingTasks, size:%d", new Object[] { Integer.valueOf(this.cvw.size()) });
      Iterator localIterator = this.cvw.iterator();
      if (localIterator.hasNext()) {
        ((Runnable)localIterator.next()).run();
      }
    }
    this.cvw.clear();
    label102:
    AppMethodBeat.o(138975);
  }
  
  public final void GA()
  {
    AppMethodBeat.i(220515);
    k(new c.15(this));
    AppMethodBeat.o(220515);
  }
  
  final boolean GB()
  {
    AppMethodBeat.i(138987);
    if (this.cuX != null)
    {
      if (this.cvd != null) {
        this.cvd.a(this.cso, this.cuX);
      }
      if (!this.cvl)
      {
        ae.i(getLogTag(), "video stop, video not prepared yet, stop video when prepared");
        this.cvi = false;
        AppMethodBeat.o(138987);
        return true;
      }
      ae.i(getLogTag(), "video stop");
      this.cuX.stop();
      if (Gj()) {
        this.cuY.bK(true);
      }
      AppMethodBeat.o(138987);
      return true;
    }
    AppMethodBeat.o(138987);
    return false;
  }
  
  public final int GF()
  {
    AppMethodBeat.i(177169);
    int i = (int)(this.css + (1.0F - this.cvF) * this.csq / 2.0F);
    ae.d(getLogTag(), "getVideoPositionX, videoPosX: ".concat(String.valueOf(i)));
    AppMethodBeat.o(177169);
    return i;
  }
  
  public final int GG()
  {
    AppMethodBeat.i(177170);
    int i = (int)(this.cst + (1.0F - this.cvG) * this.csr / 2.0F);
    ae.d(getLogTag(), "getVideoPositionY, videoPosY: ".concat(String.valueOf(i)));
    AppMethodBeat.o(177170);
    return i;
  }
  
  public final void Gh()
  {
    AppMethodBeat.i(138976);
    k(new c.23(this));
    AppMethodBeat.o(138976);
  }
  
  /* Error */
  final boolean Gj()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 527	com/tencent/luggage/xweb_ext/extendplugin/component/video/c:csu	Z
    //   6: ifeq +18 -> 24
    //   9: aload_0
    //   10: getfield 494	com/tencent/luggage/xweb_ext/extendplugin/component/video/c:cuY	Lcom/tencent/luggage/xweb_ext/extendplugin/component/video/b/d;
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
  
  final boolean Gk()
  {
    AppMethodBeat.i(220519);
    boolean bool = this.csF.d(this.cso);
    AppMethodBeat.o(220519);
    return bool;
  }
  
  public final void Gl()
  {
    AppMethodBeat.i(220514);
    k(new c.14(this));
    AppMethodBeat.o(220514);
  }
  
  final boolean Gm()
  {
    AppMethodBeat.i(220521);
    if (this.cso == null)
    {
      ae.w(getLogTag(), "amIBackgroundAudioPlayer, mInsertInvokeContext is null");
      AppMethodBeat.o(220521);
      return false;
    }
    com.tencent.mm.plugin.appbrand.jsapi.ad.a locala = com.tencent.luggage.xweb_ext.extendplugin.component.e.f(this.cso);
    if (locala == null)
    {
      ae.w(getLogTag(), "amIBackgroundAudioPlayer, audioOfVideoBackgroundPlayManager is null");
      AppMethodBeat.o(220521);
      return false;
    }
    boolean bool = locala.a(this);
    AppMethodBeat.o(220521);
    return bool;
  }
  
  public final boolean Gw()
  {
    AppMethodBeat.i(177165);
    if ((this.csD != null) && (this.csD.get()))
    {
      AppMethodBeat.o(177165);
      return true;
    }
    AppMethodBeat.o(177165);
    return false;
  }
  
  final void Gy()
  {
    AppMethodBeat.i(138979);
    if ((this.cuX != null) && (this.mSurfaceTexture != null))
    {
      int i = this.cuX.getVideoWidth();
      int j = this.cuX.getVideoHeight();
      if ((i == 0) && (j == 0))
      {
        ae.w(getLogTag(), "VideoCanvas, registerMediaPlayer, width or height is 0");
        AppMethodBeat.o(138979);
        return;
      }
      if (!this.cvv)
      {
        this.cvv = true;
        com.tencent.mm.plugin.appbrand.i.a.bhg().a(getId(), this, this.mSurfaceTexture, i, j, this.cso.getAppId());
        AppMethodBeat.o(138979);
        return;
      }
      ae.w(getLogTag(), "VideoCanvas, registerMediaPlayer, already registered");
      AppMethodBeat.o(138979);
      return;
    }
    ae.w(getLogTag(), "VideoCanvas, registerMediaPlayer, media player or surface texture is null");
    AppMethodBeat.o(138979);
  }
  
  final boolean Gz()
  {
    AppMethodBeat.i(178849);
    Object localObject;
    if ((this.cso instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      localObject = this.cso.Eo();
      if ((localObject instanceof com.tencent.mm.plugin.appbrand.page.z)) {
        localObject = (com.tencent.mm.plugin.appbrand.page.z)localObject;
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.appbrand.page.z)localObject).getRuntime();
        ae.i(getLogTag(), "cancelResumePlayingWhenRelaunch:%s", new Object[] { Boolean.valueOf(((AppBrandRuntime)localObject).jzT) });
        boolean bool = ((AppBrandRuntime)localObject).jzT;
        AppMethodBeat.o(178849);
        return bool;
        if ((localObject instanceof com.tencent.mm.plugin.appbrand.r)) {
          localObject = ((com.tencent.mm.plugin.appbrand.r)localObject).getCurrentPageView();
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
  
  public final <AddOn extends com.tencent.luggage.xweb_ext.extendplugin.component.j> AddOn U(Class<AddOn> paramClass)
  {
    AppMethodBeat.i(220525);
    ae.i(getLogTag(), "getAddOn for " + paramClass.getSimpleName());
    paramClass = this.csN.U(paramClass);
    AppMethodBeat.o(220525);
    return paramClass;
  }
  
  public final <AddOn extends com.tencent.luggage.xweb_ext.extendplugin.component.j> void a(Class<AddOn> paramClass, AddOn paramAddOn)
  {
    AppMethodBeat.i(220524);
    ae.i(getLogTag(), "setAddOn for " + paramClass.getSimpleName());
    this.csN.a(paramClass, paramAddOn);
    AppMethodBeat.o(220524);
  }
  
  final String b(com.tencent.luggage.xweb_ext.extendplugin.a parama, String paramString)
  {
    AppMethodBeat.i(138982);
    String str = paramString;
    if (this.cvd != null) {
      str = this.cvd.b(parama, paramString);
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
    ae.d(getLogTag(), "isEnableVideoCast = ".concat(String.valueOf(bool)));
    p(parama);
    this.cve.lDd = bool;
    AppMethodBeat.o(138981);
  }
  
  final void bE(boolean paramBoolean)
  {
    AppMethodBeat.i(220512);
    if (!bu.isNullOrNil(this.cvs))
    {
      if ((GQ() != null) && (this.cvc != null))
      {
        float f1 = this.cvF;
        float f2 = this.cvG;
        if (this.cvc.a(this.cvs, this.csq, this.csr, this.mVideoWidth, this.mVideoHeight))
        {
          this.cvF = this.cvc.GO();
          this.cvG = this.cvc.GP();
          ae.i(getLogTag(), "adjust objectFit:%s, scale:[%s, %s]", new Object[] { this.cvs, Float.valueOf(this.cvF), Float.valueOf(this.cvG) });
          if ((!this.cvu) || (this.cvA == null)) {
            break label218;
          }
          this.cvC = true;
          ae.i(getLogTag(), "adjust objectFit, TextureScale sticky");
        }
        for (;;)
        {
          if (((this.cvF != f1) || (this.cvG != f2)) && (this.cvB != null)) {
            this.cvB.a(paramBoolean, this.cvF, this.cvG);
          }
          AppMethodBeat.o(220512);
          return;
          label218:
          com.tencent.luggage.xweb_ext.extendplugin.d.a(GQ(), this.type, getId(), this.cvF, this.cvG);
          this.cvC = false;
        }
      }
      ae.i(getLogTag(), "adjust objectFit, video not prepared");
      AppMethodBeat.o(220512);
      return;
    }
    ae.i(getLogTag(), "adjust objectFit, no video objectFit");
    AppMethodBeat.o(220512);
  }
  
  final void bF(boolean paramBoolean)
  {
    AppMethodBeat.i(220513);
    if (this.cuX != null)
    {
      ae.i(getLogTag(), "video prepare async");
      if ((paramBoolean) && (Gj())) {
        this.cuY.onVideoWaiting();
      }
      this.cvl = false;
      this.cvi = false;
      if (this.cvd != null) {
        this.cvd.c(this.cuX);
      }
      this.cuX.prepareAsync();
    }
    AppMethodBeat.o(220513);
  }
  
  final boolean ca(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(220511);
    boolean bool = k(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(138947);
        c localc = c.this;
        int i = paramInt1;
        int j = paramInt2;
        if (!localc.cvm)
        {
          ae.i(localc.getLogTag(), "onMediaPlayerError, mp released");
          AppMethodBeat.o(138947);
          return;
        }
        ae.i(localc.getLogTag(), "onError, what:%d, extra:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        if (localc.cva != null) {
          localc.cva.cd(i, j);
        }
        AppMethodBeat.o(138947);
      }
    });
    AppMethodBeat.o(220511);
    return bool;
  }
  
  final void dA(final String paramString)
  {
    AppMethodBeat.i(220518);
    ae.i(getLogTag(), "doCheckVideoUrl, videoPath: ".concat(String.valueOf(paramString)));
    com.tencent.e.h.MqF.aO(new com.tencent.e.i.h()
    {
      public final String getKey()
      {
        AppMethodBeat.i(177163);
        AppMethodBeat.o(177163);
        return "VideoPluginHandler_checkVideoUrl";
      }
      
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: ldc 43
        //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aload_0
        //   6: getfield 19	com/tencent/luggage/xweb_ext/extendplugin/component/video/c$25:cvH	Lcom/tencent/luggage/xweb_ext/extendplugin/component/video/c;
        //   9: astore 6
        //   11: aload_0
        //   12: getfield 21	com/tencent/luggage/xweb_ext/extendplugin/component/video/c$25:cvL	Ljava/lang/String;
        //   15: astore_3
        //   16: aload_3
        //   17: invokestatic 49	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
        //   20: ifne +152 -> 172
        //   23: aload_3
        //   24: ldc 51
        //   26: invokevirtual 56	java/lang/String:startsWith	(Ljava/lang/String;)Z
        //   29: ifeq +143 -> 172
        //   32: aconst_null
        //   33: astore_2
        //   34: aconst_null
        //   35: astore 5
        //   37: new 58	java/net/URL
        //   40: dup
        //   41: aload_3
        //   42: invokespecial 60	java/net/URL:<init>	(Ljava/lang/String;)V
        //   45: invokevirtual 64	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   48: checkcast 66	java/net/HttpURLConnection
        //   51: astore_3
        //   52: aload_3
        //   53: invokevirtual 69	java/net/HttpURLConnection:connect	()V
        //   56: aload_3
        //   57: invokevirtual 73	java/net/HttpURLConnection:getResponseCode	()I
        //   60: istore_1
        //   61: aload 6
        //   63: invokevirtual 76	com/tencent/luggage/xweb_ext/extendplugin/component/video/c:getLogTag	()Ljava/lang/String;
        //   66: ldc 78
        //   68: iconst_1
        //   69: anewarray 4	java/lang/Object
        //   72: dup
        //   73: iconst_0
        //   74: iload_1
        //   75: invokestatic 84	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   78: aastore
        //   79: invokestatic 89	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   82: iload_1
        //   83: sipush 400
        //   86: if_icmplt +11 -> 97
        //   89: aload 6
        //   91: iconst_m1
        //   92: iload_1
        //   93: invokevirtual 93	com/tencent/luggage/xweb_ext/extendplugin/component/video/c:ca	(II)Z
        //   96: pop
        //   97: aload_3
        //   98: ifnull +74 -> 172
        //   101: aload_3
        //   102: invokevirtual 96	java/net/HttpURLConnection:disconnect	()V
        //   105: ldc 43
        //   107: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   110: return
        //   111: astore 4
        //   113: aload 5
        //   115: astore_3
        //   116: aload_3
        //   117: astore_2
        //   118: aload 6
        //   120: invokevirtual 76	com/tencent/luggage/xweb_ext/extendplugin/component/video/c:getLogTag	()Ljava/lang/String;
        //   123: aload 4
        //   125: ldc 98
        //   127: iconst_1
        //   128: anewarray 4	java/lang/Object
        //   131: dup
        //   132: iconst_0
        //   133: aload 4
        //   135: invokevirtual 101	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   138: aastore
        //   139: invokestatic 105	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   142: aload_3
        //   143: ifnull +29 -> 172
        //   146: aload_3
        //   147: invokevirtual 96	java/net/HttpURLConnection:disconnect	()V
        //   150: ldc 43
        //   152: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   155: return
        //   156: astore_3
        //   157: aload_2
        //   158: ifnull +7 -> 165
        //   161: aload_2
        //   162: invokevirtual 96	java/net/HttpURLConnection:disconnect	()V
        //   165: ldc 43
        //   167: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   170: aload_3
        //   171: athrow
        //   172: ldc 43
        //   174: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   177: return
        //   178: astore 4
        //   180: aload_3
        //   181: astore_2
        //   182: aload 4
        //   184: astore_3
        //   185: goto -28 -> 157
        //   188: astore 4
        //   190: goto -74 -> 116
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	193	0	this	25
        //   60	33	1	i	int
        //   33	149	2	localObject1	Object
        //   15	132	3	localObject2	Object
        //   156	25	3	localObject3	Object
        //   184	1	3	localObject4	Object
        //   111	23	4	localException1	Exception
        //   178	5	4	localObject5	Object
        //   188	1	4	localException2	Exception
        //   35	79	5	localObject6	Object
        //   9	110	6	localc	c
        // Exception table:
        //   from	to	target	type
        //   37	52	111	java/lang/Exception
        //   37	52	156	finally
        //   118	142	156	finally
        //   52	82	178	finally
        //   89	97	178	finally
        //   52	82	188	java/lang/Exception
        //   89	97	188	java/lang/Exception
      }
    });
    AppMethodBeat.o(220518);
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
    AppMethodBeat.i(220520);
    if (this.cuX != null)
    {
      if (!this.csO.get())
      {
        this.cuX.setSurface(paramSurface);
        if (this.mSurface != paramSurface) {
          break label99;
        }
        this.cvA = null;
        label46:
        paramSurface = getLogTag();
        if (this.cvA == null) {
          break label107;
        }
      }
      label99:
      label107:
      for (boolean bool = true;; bool = false)
      {
        ae.i(paramSurface, "setSurface, SurfacePipSet exist: %b", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(220520);
        return true;
        ae.i(getLogTag(), "setSurface, JustPlayAudio");
        break;
        this.cvA = paramSurface;
        break label46;
      }
    }
    ae.w(getLogTag(), "setSurface, MediaPlayer is null");
    AppMethodBeat.o(220520);
    return false;
  }
  
  public final boolean g(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    return true;
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(138990);
    if (this.cuX != null)
    {
      int i = this.cuX.getCurrentPosition();
      AppMethodBeat.o(138990);
      return i;
    }
    AppMethodBeat.o(138990);
    return 0;
  }
  
  final int getDuration()
  {
    AppMethodBeat.i(138991);
    if (this.cuX != null)
    {
      int i = this.cuX.getDuration();
      AppMethodBeat.o(138991);
      return i;
    }
    AppMethodBeat.o(138991);
    return 0;
  }
  
  public final String getKey()
  {
    AppMethodBeat.i(177168);
    String str = BN() + "@" + hashCode();
    AppMethodBeat.o(177168);
    return str;
  }
  
  public final String getLogTag()
  {
    AppMethodBeat.i(138973);
    String str = String.format("%s(%s)", new Object[] { "MicroMsg.SameLayer.VideoPluginHandler", BN() });
    AppMethodBeat.o(138973);
    return str;
  }
  
  public final String getName()
  {
    AppMethodBeat.i(220523);
    String str = getKey();
    AppMethodBeat.o(220523);
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
        String str = locala.FK();
        Object localObject2;
        if (!bu.isNullOrNil(str))
        {
          localObject1 = locala.FJ();
          ae.i(localc.getLogTag(), "*** handler(%s) handleJsApi(%s), data:%s", new Object[] { localc.BN(), str, ((JSONObject)localObject1).toString() });
          if (!str.contains("insert")) {
            break label992;
          }
          localc.cso = locala;
          if (localc.cuX == null)
          {
            ae.w(localc.getLogTag(), "insert, media player is null");
            localc.r(localc.cso);
          }
          ae.i(localc.getLogTag(), "registerLifecycleListener");
          localc.csp = new c.5(localc);
          locala.a(localc.csp);
          if (localc.cvd != null) {
            localc.cvd.v(locala);
          }
          if ((localc.mSurface != null) && (localc.cuX != null))
          {
            ae.i(localc.getLogTag(), "insert, setSurface");
            localc.cuX.setSurface(localc.mSurface);
          }
          localObject1 = locala.FJ();
          localc.cvk = ((JSONObject)localObject1).optBoolean("autoplay", false);
          localc.cvj = ((((JSONObject)localObject1).optDouble("initialTime", 0.0D) * 1000.0D));
          localc.cvn = ((JSONObject)localObject1).optBoolean("loop", false);
          localc.cvo = ((JSONObject)localObject1).optBoolean("muted", false);
          localc.cuX.setMute(localc.cvo);
          localc.csv = ((JSONObject)localObject1).optBoolean("autoPauseIfNavigate", true);
          localc.csw = ((JSONObject)localObject1).optBoolean("autoPauseIfOpenNative", true);
          localc.csu = ((JSONObject)localObject1).optBoolean("needEvent", false);
          if ((localc.csu) && (localc.cuY != null))
          {
            localc.cuY.m(locala);
            localObject2 = ((JSONObject)localObject1).optString("data", "");
            localc.cuY.dC((String)localObject2);
            if (localc.cuZ != null)
            {
              localc.cuZ.m(locala);
              localc.cuZ.dC((String)localObject2);
            }
          }
          if (((JSONObject)localObject1).has("position"))
          {
            localObject2 = ((JSONObject)localObject1).optJSONObject("position");
            if (localObject2 != null)
            {
              localc.csq = com.tencent.mm.plugin.appbrand.y.g.vO(((JSONObject)localObject2).optInt("width", 0));
              localc.csr = com.tencent.mm.plugin.appbrand.y.g.vO(((JSONObject)localObject2).optInt("height", 0));
              ae.i(localc.getLogTag(), "insert, size:[%d, %d]", new Object[] { Integer.valueOf(localc.csq), Integer.valueOf(localc.csr) });
            }
          }
          localc.cvs = ((JSONObject)localObject1).optString("objectFit", "contain");
          if (bu.isNullOrNil(localc.cvs)) {
            localc.cvs = "contain";
          }
          localc.bE(true);
          localObject2 = locala.Eo();
          if (localObject2 != null) {
            break label822;
          }
          ae.w(localc.getLogTag(), "updateReferrers, component is null");
          localc.cvr = ((JSONObject)localObject1).optString("filePath");
          if (!bu.isNullOrNil(localc.cvr))
          {
            if (localc.cvd != null) {
              localc.cvd.a(localc.cuX, localc.cvr);
            }
            localObject2 = localc.b(locala, localc.cvr);
            ae.i(localc.getLogTag(), "insert, path:%s, proxy:%s", new Object[] { localc.cvr, localObject2 });
            if (!bu.isNullOrNil((String)localObject2))
            {
              localc.cuX.dF((String)localObject2, localc.csy);
              localc.dA((String)localObject2);
              ae.i(localc.getLogTag(), "insert, media player prepare async");
              localc.bF(true);
            }
          }
          localc.mTitle = ((JSONObject)localObject1).optString("title", localc.mTitle);
          localc.csP = ((JSONObject)localObject1).optString("backgroundPoster", localc.csP);
          localc.b(locala, (JSONObject)localObject1);
          locala.dw("ok");
        }
        label804:
        label822:
        Object localObject3;
        Object localObject4;
        for (;;)
        {
          localc.csE.a(str, locala);
          if (localc.cvr == null) {
            break label4150;
          }
          localObject1 = localc.cvr;
          localc.csF.a(locala, (String)localObject1);
          AppMethodBeat.o(138966);
          return;
          localObject3 = (com.tencent.mm.plugin.appbrand.jsapi.s.a)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.s.a.class);
          if (localObject3 == null)
          {
            ae.w(localc.getLogTag(), "updateReferrers, referrerHelper is null");
            break;
          }
          if (localc.csx == null) {
            localc.csx = ((com.tencent.mm.plugin.appbrand.jsapi.s.a)localObject3).bmX();
          }
          localObject4 = ((com.tencent.mm.plugin.appbrand.jsapi.s.a)localObject3).a((JSONObject)localObject1, (com.tencent.mm.plugin.appbrand.jsapi.c)localObject2);
          if (localObject4 != null) {
            localc.csx = ((com.tencent.mm.plugin.appbrand.jsapi.s.c)localObject4);
          }
          ae.i(localc.getLogTag(), "updateReferrers, mReferrerPolicy: " + localc.csx);
          if (com.tencent.mm.plugin.appbrand.jsapi.s.c.liO == localc.csx)
          {
            localc.csy = null;
            break;
          }
          localc.csy = ((com.tencent.mm.plugin.appbrand.jsapi.s.a)localObject3).y((com.tencent.mm.plugin.appbrand.jsapi.c)localObject2);
          ae.i(localc.getLogTag(), "updateReferrers, mReferrer: " + localc.csy);
          break;
          label992:
          if (!str.contains("update")) {
            break label2195;
          }
          if (localc.cuX != null) {
            break label1036;
          }
          ae.w(localc.getLogTag(), "update, media player is null");
          locala.dw("fail");
        }
        label1036:
        Object localObject1 = locala.FJ();
        if (((JSONObject)localObject1).has("filePath"))
        {
          localObject2 = ((JSONObject)localObject1).optString("filePath");
          if ((!bu.isNullOrNil((String)localObject2)) && (!((String)localObject2).equalsIgnoreCase(localc.cvr)))
          {
            localc.cvr = ((String)localObject2);
            localObject2 = localc.b(locala, localc.cvr);
            ae.i(localc.getLogTag(), "update, path:%s, proxy:%s", new Object[] { localc.cvr, localObject2 });
            if ((localc.cuX == null) || (!bu.isNullOrNil((String)localObject2)))
            {
              localc.cvt = false;
              localc.GB();
              localc.q(locala);
            }
            if (localc.cvd != null) {
              localc.cvd.a(localc.cuX, localc.cvr);
            }
            localc.cuX.dF((String)localObject2, localc.csy);
            localc.dA((String)localObject2);
          }
        }
        for (int j = 1;; j = 0)
        {
          boolean bool2;
          boolean bool1;
          if ((localc.mSurface != null) && (localc.cuX != null))
          {
            bool2 = localc.csO.get();
            if ((!localc.cvu) && (!bool2))
            {
              ae.i(localc.getLogTag(), "update, setSurface");
              localc.cuX.setSurface(localc.mSurface);
            }
          }
          else
          {
            if (((JSONObject)localObject1).has("autoplay")) {
              localc.cvk = ((JSONObject)localObject1).optBoolean("autoplay", localc.cvk);
            }
            if (((JSONObject)localObject1).has("initialTime")) {
              localc.cvj = ((((JSONObject)localObject1).optDouble("initialTime", 0.0D) * 1000.0D));
            }
            if (((JSONObject)localObject1).has("loop")) {
              localc.cvn = ((JSONObject)localObject1).optBoolean("loop", localc.cvn);
            }
            if (((JSONObject)localObject1).has("muted"))
            {
              localc.cvo = ((JSONObject)localObject1).optBoolean("muted", localc.cvo);
              localc.cuX.setMute(localc.cvo);
            }
            if (((JSONObject)localObject1).has("autoPauseIfNavigate")) {
              localc.csv = ((JSONObject)localObject1).optBoolean("autoPauseIfNavigate", localc.csv);
            }
            if (((JSONObject)localObject1).has("autoPauseIfOpenNative")) {
              localc.csw = ((JSONObject)localObject1).optBoolean("autoPauseIfOpenNative", localc.csw);
            }
            if (((JSONObject)localObject1).has("needEvent")) {
              localc.csu = ((JSONObject)localObject1).optBoolean("needEvent", localc.csu);
            }
            if ((localc.csu) && (localc.cuY != null))
            {
              localc.cuY.m(locala);
              localObject2 = ((JSONObject)localObject1).optString("data", "");
              if (((JSONObject)localObject1).has("data")) {
                localc.cuY.dC((String)localObject2);
              }
              if (localc.cuZ != null)
              {
                if (((JSONObject)localObject1).has("data")) {
                  localc.cuZ.dC((String)localObject2);
                }
                localc.cuZ.m(locala);
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
                i = localc.csq;
                int k = localc.csr;
                localc.csq = com.tencent.mm.plugin.appbrand.y.g.vO(((JSONObject)localObject2).optInt("width", i));
                localc.csr = com.tencent.mm.plugin.appbrand.y.g.vO(((JSONObject)localObject2).optInt("height", k));
                ae.i(localc.getLogTag(), "update, size:[%d, %d]", new Object[] { Integer.valueOf(localc.csq), Integer.valueOf(localc.csr) });
                if (localc.csq == i)
                {
                  bool1 = bool2;
                  if (localc.csr == k) {}
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
              localObject2 = localc.cvs;
              localc.cvs = ((JSONObject)localObject1).optString("objectFit", (String)localObject2);
              if (bu.isNullOrNil(localc.cvs)) {
                localc.cvs = "contain";
              }
              if (!localc.cvs.equals(localObject2)) {
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
            if ((localc.cve != null) && (localc.cve.bqw()))
            {
              localObject3 = localc.cve;
              p.h(localObject2, "updateVideoPath");
              ae.i("MicroMsg.VideoCast.AppBrandVideoCastHandler", "updateVideoPath: [" + (String)localObject2 + ']');
              if (!d.n.n.aD((CharSequence)d.n.n.trim((CharSequence)localObject2).toString()))
              {
                ((com.tencent.mm.plugin.appbrand.jsapi.ad.e.b)localObject3).bqx().bqG();
                if (!p.i(localObject2, ((com.tencent.mm.plugin.appbrand.jsapi.ad.e.b)localObject3).videoPath))
                {
                  ((com.tencent.mm.plugin.appbrand.jsapi.ad.e.b)localObject3).setVideoPath((String)localObject2);
                  ((com.tencent.mm.plugin.appbrand.jsapi.ad.e.b)localObject3).gW(true);
                  ((com.tencent.mm.plugin.appbrand.jsapi.ad.e.b)localObject3).bqx().s((d.g.a.b)new com.tencent.mm.plugin.appbrand.jsapi.ad.e.b.f((com.tencent.mm.plugin.appbrand.jsapi.ad.e.b)localObject3));
                  if (((com.tencent.mm.plugin.appbrand.jsapi.ad.e.b)localObject3).bqx().dGC != -1) {
                    break label2183;
                  }
                  ((com.tencent.mm.plugin.appbrand.jsapi.ad.e.b)localObject3).bqx().dGC = 8;
                }
              }
            }
          }
          for (;;)
          {
            localc.mTitle = ((JSONObject)localObject1).optString("title", localc.mTitle);
            localc.csP = ((JSONObject)localObject1).optString("backgroundPoster", localc.csP);
            if (j != 0)
            {
              ae.i(localc.getLogTag(), "update, media player prepare async");
              localc.bF(true);
            }
            locala.dw("ok");
            break;
            localObject2 = localc.getLogTag();
            boolean bool3 = localc.cvu;
            if (localc.cvA != null) {}
            for (bool1 = true;; bool1 = false)
            {
              ae.i((String)localObject2, "update, setSurface, WebViewInBackground: %b, JustPlayAudio: %b, SurfacePipSet exist: %b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
              if ((!localc.cvu) || (localc.cvA == null)) {
                break;
              }
              localc.cuX.setSurface(localc.cvA);
              break;
            }
            label2183:
            ae.i("MicroMsg.VideoCast.AppBrandVideoCastHandler", "discard a updateVideoPath report event");
          }
          label2195:
          if ((str.contains("operate")) && (str.contains("Background")))
          {
            if (localc.cuX == null)
            {
              ae.w(localc.getLogTag(), "operateBackground, media player is null");
              locala.dw("fail");
              break;
            }
            localObject1 = locala.FJ();
            bool1 = false;
            localObject1 = ((JSONObject)localObject1).optString("type");
            if (bu.isNullOrNil((String)localObject1)) {
              break;
            }
            ae.i(localc.getLogTag(), "operateBackground, type:%s", new Object[] { localObject1 });
            if (((String)localObject1).equalsIgnoreCase("stop"))
            {
              bool2 = localc.s(locala);
              bool1 = bool2;
              if (bool2)
              {
                bool1 = bool2;
                if (localc.csB)
                {
                  ae.i(localc.getLogTag(), "operateBackground, isRuntimeInBackground, setPlayingWhenEnterBackground false");
                  localc.csD = new AtomicBoolean(false);
                  bool1 = bool2;
                }
              }
            }
            if (bool1) {}
            for (localObject1 = "ok";; localObject1 = "fail")
            {
              locala.dw((String)localObject1);
              break;
            }
          }
          if (str.contains("operate"))
          {
            if (localc.cuX == null)
            {
              ae.w(localc.getLogTag(), "operate, media player is null");
              locala.dw("fail");
              break;
            }
            localObject3 = locala.FJ();
            bool2 = false;
            localObject2 = ((JSONObject)localObject3).optString("type");
            if (bu.isNullOrNil((String)localObject2)) {
              break;
            }
            ae.i(localc.getLogTag(), "operate, type:%s", new Object[] { localObject2 });
            if (((String)localObject2).equalsIgnoreCase("startCasting"))
            {
              bool1 = true;
              label2508:
              if (!bool1) {
                break label3221;
              }
              ae.i(localc.getLogTag(), "video cast operate, type:%s", new Object[] { localObject2 });
              if (localc.cve == null) {
                localc.p(locala);
              }
              localc.cve.setVideoPath(localc.cvr);
              localc.cve.lCY = localc.getCurrentPosition();
              if (!((String)localObject2).equalsIgnoreCase("requestFullScreen")) {
                break label2697;
              }
              bool1 = localc.j(locala);
              label2594:
              if (!((String)localObject2).equalsIgnoreCase("snapshot")) {
                break label4079;
              }
              ae.i(localc.getLogTag(), "getSnapshotCached");
              if (localc.cvd != null) {
                break label4064;
              }
              locala.dw("fail:snapshot error");
            }
            for (;;)
            {
              label2635:
              if ((!((String)localObject2).equalsIgnoreCase("pause")) && (!((String)localObject2).equalsIgnoreCase("stop"))) {
                break label4100;
              }
              localc.csF.b(locala);
              break;
              if (localc.cve == null)
              {
                bool1 = false;
                break label2508;
              }
              bool1 = localc.cve.bqw();
              break label2508;
              label2697:
              if (((String)localObject2).equalsIgnoreCase("exitFullScreen"))
              {
                bool1 = localc.k(locala);
                break label2594;
              }
              localObject1 = localc.cve;
              p.h(localObject3, "data");
              p.h(locala, "invokeContext");
              localObject4 = ((JSONObject)localObject3).optString("type");
              ae.i("MicroMsg.VideoCast.AppBrandVideoCastHandler", "handleOperate: type = ".concat(String.valueOf(localObject4)));
              if (localObject4 == null)
              {
                bool1 = true;
                break label2594;
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
                          com.tencent.mm.plugin.appbrand.jsapi.ad.e.a.h.b(((com.tencent.mm.plugin.appbrand.jsapi.ad.e.b)localObject1).bqx());
                          bool1 = true;
                          break;
                          if (((String)localObject4).equals("reconnectCasting"))
                          {
                            localObject3 = ((com.tencent.mm.plugin.appbrand.jsapi.ad.e.b)localObject1).lDb;
                            if (localObject3 != null) {
                              ((com.tencent.mm.plugin.appbrand.jsapi.ad.e.a.c)localObject3).tW(5);
                            }
                            localObject1 = ((com.tencent.mm.plugin.appbrand.jsapi.ad.e.b)localObject1).bqx();
                            if (((com.tencent.mm.plugin.appbrand.jsapi.ad.e.a.h)localObject1).lEn.bqH().bfW() != e.a.kgC) {
                              break label3195;
                            }
                            ((com.tencent.mm.plugin.appbrand.jsapi.ad.e.a.h)localObject1).lEN.bH(true);
                            bool1 = true;
                            break;
                            if (((String)localObject4).equals("exitCasting"))
                            {
                              localObject3 = ((com.tencent.mm.plugin.appbrand.jsapi.ad.e.b)localObject1).lDb;
                              if (localObject3 != null) {
                                ((com.tencent.mm.plugin.appbrand.jsapi.ad.e.a.c)localObject3).tW(6);
                              }
                              com.tencent.mm.plugin.appbrand.jsapi.ad.e.a.h.d(((com.tencent.mm.plugin.appbrand.jsapi.ad.e.b)localObject1).bqx());
                              ((com.tencent.mm.plugin.appbrand.jsapi.ad.e.b)localObject1).bqx().destroy();
                              ((com.tencent.mm.plugin.appbrand.jsapi.ad.e.b)localObject1).lDe = false;
                              ((com.tencent.mm.plugin.appbrand.jsapi.ad.e.b)localObject1).gW(false);
                            }
                          }
                        }
                      }
                    } while (!((String)localObject4).equals("startCasting"));
                    ((com.tencent.mm.plugin.appbrand.jsapi.ad.e.b)localObject1).bqx().lEE = ((d.g.a.a)new com.tencent.mm.plugin.appbrand.jsapi.ad.e.b.e((com.tencent.mm.plugin.appbrand.jsapi.ad.e.b)localObject1));
                    com.tencent.mm.plugin.appbrand.jsapi.ad.e.a.h.a(((com.tencent.mm.plugin.appbrand.jsapi.ad.e.b)localObject1).bqx());
                    bool1 = true;
                    break;
                  } while (!((String)localObject4).equals("switchCasting"));
                  localObject3 = ((com.tencent.mm.plugin.appbrand.jsapi.ad.e.b)localObject1).lDb;
                  if (localObject3 != null) {
                    ((com.tencent.mm.plugin.appbrand.jsapi.ad.e.a.c)localObject3).tW(4);
                  }
                  ((com.tencent.mm.plugin.appbrand.jsapi.ad.e.b)localObject1).bqx().x(false, true);
                  bool1 = true;
                  break;
                } while (!((String)localObject4).equals("seek"));
                long l = com.tencent.mm.plugin.appbrand.jsapi.ad.e.b.Y((JSONObject)localObject3);
                if (l <= 0L) {
                  break label3180;
                }
                ((com.tencent.mm.plugin.appbrand.jsapi.ad.e.b)localObject1).bqx().Sj(b.c.tV((int)l));
                bool1 = true;
                break;
              } while (!((String)localObject4).equals("pause"));
              com.tencent.mm.plugin.appbrand.jsapi.ad.e.a.h.c(((com.tencent.mm.plugin.appbrand.jsapi.ad.e.b)localObject1).bqx());
              bool1 = true;
              break label2594;
              label3180:
              ae.i("MicroMsg.VideoCast.AppBrandVideoCastHandler", "invalid seek position");
              bool1 = false;
              break label2594;
              label3195:
              ((com.tencent.mm.plugin.appbrand.jsapi.ad.e.a.h)localObject1).lEn.u((d.g.a.b)new h.p((com.tencent.mm.plugin.appbrand.jsapi.ad.e.a.h)localObject1));
              bool1 = true;
              break label2594;
              label3221:
              if (((String)localObject2).equalsIgnoreCase("play"))
              {
                bool1 = localc.i(false, true);
                break label2594;
              }
              if (((String)localObject2).equalsIgnoreCase("pause"))
              {
                bool1 = localc.pause();
                break label2594;
              }
              if (((String)localObject2).equalsIgnoreCase("stop"))
              {
                bool2 = localc.GB();
                bool1 = bool2;
                if (!bool2) {
                  break label2594;
                }
                bool1 = bool2;
                if (!localc.csB) {
                  break label2594;
                }
                ae.i(localc.getLogTag(), "stop, isRuntimeInBackground, setPlayingWhenEnterBackground false");
                localc.csD = new AtomicBoolean(false);
                bool1 = bool2;
                break label2594;
              }
              label3408:
              double d;
              if (((String)localObject2).equalsIgnoreCase("seek"))
              {
                if ((localc.cuX != null) && (localObject3 != null) && (((JSONObject)localObject3).has("data")))
                {
                  localObject1 = ((JSONObject)localObject3).optJSONArray("data");
                  if ((localObject1 != null) && (((JSONArray)localObject1).length() != 0)) {
                    break label3408;
                  }
                  ae.w(localc.getLogTag(), "seek, data array is null");
                }
                for (;;)
                {
                  bool1 = false;
                  break;
                  d = ((JSONArray)localObject1).optDouble(0, -1.0D);
                  if (d >= 0.0D) {
                    break label3449;
                  }
                  ae.w(localc.getLogTag(), "seek, invalid position:%s", new Object[] { Double.valueOf(d) });
                }
                label3449:
                localc.seek((d * 1000.0D));
                bool1 = true;
                break label2594;
              }
              if (((String)localObject2).equalsIgnoreCase("playbackRate"))
              {
                if ((localc.cuX != null) && (localObject3 != null) && (((JSONObject)localObject3).has("data")))
                {
                  localObject1 = ((JSONObject)localObject3).optJSONArray("data");
                  if ((localObject1 != null) && (((JSONArray)localObject1).length() != 0)) {
                    break label3539;
                  }
                  ae.w(localc.getLogTag(), "speed, data array is null");
                }
                for (;;)
                {
                  bool1 = false;
                  break;
                  label3539:
                  d = ((JSONArray)localObject1).optDouble(0, -1.0D);
                  if (d >= 0.0D) {
                    break label3580;
                  }
                  ae.w(localc.getLogTag(), "speed, invalid rate:%s", new Object[] { Double.valueOf(d) });
                }
                label3580:
                ae.i(localc.getLogTag(), "speed, speed:%s", new Object[] { Double.valueOf(d) });
                bool1 = localc.cuX.aF((float)d);
                break label2594;
              }
              if (((String)localObject2).equalsIgnoreCase("requestFullScreen"))
              {
                bool1 = localc.j(locala);
                break label2594;
              }
              if (((String)localObject2).equalsIgnoreCase("exitFullScreen"))
              {
                bool1 = localc.k(locala);
                break label2594;
              }
              if (((String)localObject2).equalsIgnoreCase("setScreenBrightness"))
              {
                ae.i(localc.getLogTag(), "setScreenBrightness");
                if ((localc.cvd != null) && (localc.cvd.t(locala)))
                {
                  bool1 = true;
                  break label2594;
                }
                bool1 = false;
                break label2594;
              }
              if (((String)localObject2).equalsIgnoreCase("exitPictureInPicture"))
              {
                bool1 = localc.csF.c(locala);
                break label2594;
              }
              if (((String)localObject2).equalsIgnoreCase("requestBackgroundPlayback"))
              {
                ae.d(localc.getLogTag(), "enableBackgroundPlayAudio");
                if (!localc.csL)
                {
                  ae.d(localc.getLogTag(), "registerAddOnPlayAudio");
                  localc.a(m.class, new c.29(localc));
                  ae.d(localc.getLogTag(), "registerAddOnVideoController");
                  localc.a(com.tencent.luggage.xweb_ext.extendplugin.component.n.class, new c.30(localc));
                  ae.d(localc.getLogTag(), "registerAddOnInfo");
                  localc.a(l.class, new c.31(localc));
                  ae.d(localc.getLogTag(), "registerAddOnGetSnapshot");
                  localc.a(k.class, new c.33(localc));
                  localc.csL = true;
                }
                ae.d(localc.getLogTag(), "enableBackgroundPlayAudioInternal");
                if (locala == null)
                {
                  ae.w(localc.getLogTag(), "enableBackgroundPlayAudioInternal, invokeContext is null");
                  bool1 = false;
                }
                for (;;)
                {
                  if (!bool1) {
                    break label4031;
                  }
                  localc.csO.set(true);
                  if (localc.cuX != null) {
                    localc.cuX.setSurface(null);
                  }
                  localc.csM = true;
                  if (localc.cuY != null) {
                    localc.cuY.bL(true);
                  }
                  bool1 = true;
                  break;
                  localObject1 = com.tencent.luggage.xweb_ext.extendplugin.component.e.f(locala);
                  if (localObject1 == null)
                  {
                    ae.w(localc.getLogTag(), "enableBackgroundPlayAudioInternal, audioOfVideoBackgroundPlayManager is null");
                    bool1 = false;
                  }
                  else
                  {
                    bool1 = ((com.tencent.mm.plugin.appbrand.jsapi.ad.a)localObject1).b(localc);
                  }
                }
                label4031:
                bool1 = false;
                break label2594;
              }
              bool1 = bool2;
              if (!((String)localObject2).equalsIgnoreCase("exitBackgroundPlayback")) {
                break label2594;
              }
              bool1 = localc.s(locala);
              break label2594;
              label4064:
              localc.cvz = locala;
              localc.takeScreenshot();
            }
            label4079:
            if (bool1) {}
            for (localObject1 = "ok";; localObject1 = "fail")
            {
              locala.dw((String)localObject1);
              break label2635;
              label4100:
              break;
            }
          }
          if (!str.contains("remove")) {
            break;
          }
          localc.release();
          locala.dw("ok");
          localc.csF.b(locala);
          break;
          label4150:
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
    if (this.cuX != null)
    {
      if ((this.cvl) && (this.cuX.isPlaying()))
      {
        ae.i(getLogTag(), "video play, video is playing");
        if (Gj()) {
          this.cuY.bJ(paramBoolean1);
        }
        AppMethodBeat.o(177166);
        return true;
      }
      if ((this.cuX != null) && (!this.cvl))
      {
        ae.i(getLogTag(), "video play, video not prepared yet, start until prepared");
        this.cvi = true;
        AppMethodBeat.o(177166);
        return true;
      }
      if ((this.cuX != null) && (this.cuX.getState() == 5))
      {
        if (!paramBoolean2)
        {
          ae.i(getLogTag(), "video has ended playing, do not restart");
          AppMethodBeat.o(177166);
          return false;
        }
        ae.i(getLogTag(), "video play, video has stopped now, try prepare and start when prepared");
        bF(true);
        this.cvi = true;
        AppMethodBeat.o(177166);
        return true;
      }
      if (this.cvt)
      {
        if (!paramBoolean2)
        {
          ae.i(getLogTag(), "video has ended playing, do not restart");
          AppMethodBeat.o(177166);
          return false;
        }
        ae.i(getLogTag(), "video play, video has ended playing, clear surface and start again");
        this.cvt = false;
        try
        {
          if ((this.mSurfaceTexture != null) && (this.cvl))
          {
            ae.i(getLogTag(), "clearSurfaceTexture");
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
            ae.printErrStackTrace(getLogTag(), localException, "clearSurfaceTexture error", new Object[0]);
            continue;
            this.cuX.dF(this.cvr, this.csy);
            dA(this.cvr);
          }
        }
        q(this.cso);
        if (this.cuX != null)
        {
          this.cvk = true;
          localObject1 = b(this.cso, this.cvr);
          if (!bu.isNullOrNil((String)localObject1))
          {
            this.cuX.dF((String)localObject1, this.csy);
            dA((String)localObject1);
            ae.i(getLogTag(), "video play, media player state:%s", new Object[] { Integer.valueOf(this.cuX.getState()) });
            bF(false);
            this.cvi = true;
          }
        }
        else
        {
          AppMethodBeat.o(177166);
          return true;
        }
      }
      ae.i(getLogTag(), "video play");
      if (this.cuX != null)
      {
        if (Gj()) {
          this.cuY.bJ(paramBoolean1);
        }
        ae.i(getLogTag(), "applyPluginTextureScaleIfNeed");
        if (this.cvC) {
          break label767;
        }
        ae.i(getLogTag(), "applyPluginTextureScaleIfNeed, TextureScale is not sticky");
      }
      for (;;)
      {
        this.cuX.start();
        AppMethodBeat.o(177166);
        return true;
        label767:
        if ((this.cvu) && (this.cvA != null)) {
          ae.i(getLogTag(), "applyPluginTextureScaleIfNeed, in PIP mode");
        } else {
          com.tencent.luggage.xweb_ext.extendplugin.d.a(GQ(), this.type, getId(), this.cvF, this.cvG);
        }
      }
    }
    AppMethodBeat.o(177166);
    return false;
  }
  
  final boolean isPlaying()
  {
    AppMethodBeat.i(138989);
    if (this.cuX != null)
    {
      boolean bool = this.cuX.isPlaying();
      AppMethodBeat.o(138989);
      return bool;
    }
    AppMethodBeat.o(138989);
    return false;
  }
  
  final boolean j(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(138993);
    ae.i(getLogTag(), "requestFullscreen");
    if ((this.cvd != null) && (this.cvd.j(parama)))
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
    ae.i(getLogTag(), "exitFullscreen");
    if ((this.cvd != null) && (this.cvd.k(parama)))
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
    if (this.cvx != null)
    {
      if (this.cvx.getLooper() == Looper.myLooper()) {
        paramRunnable.run();
      }
      for (;;)
      {
        AppMethodBeat.o(138980);
        return true;
        this.cvx.post(paramRunnable);
      }
    }
    AppMethodBeat.o(138980);
    return false;
  }
  
  final void p(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(138978);
    if (this.cve != null)
    {
      AppMethodBeat.o(138978);
      return;
    }
    this.cve = this.cvd.a(this.cuZ, parama);
    AppMethodBeat.o(138978);
  }
  
  final boolean pause()
  {
    AppMethodBeat.i(138986);
    if (this.cuX != null)
    {
      if (!this.cvl)
      {
        ae.i(getLogTag(), "video pause, video not prepared yet, pause video when prepared");
        this.cvi = false;
        AppMethodBeat.o(138986);
        return true;
      }
      if (!this.cuX.isPlaying())
      {
        ae.i(getLogTag(), "video pause, video is not playing");
        AppMethodBeat.o(138986);
        return true;
      }
      ae.i(getLogTag(), "video pause");
      this.cuX.pause();
      if (Gj()) {
        this.cuY.bK(false);
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
    GC();
    r(parama);
    GD();
    AppMethodBeat.o(138995);
  }
  
  final void r(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(138997);
    ae.i(getLogTag(), "createMediaPlayer");
    if (this.cvd != null) {
      this.cuX = this.cvd.a(parama, this.cvx);
    }
    if (this.cuX == null)
    {
      ae.e(getLogTag(), "createMediaPlayer, create media player fail");
      AppMethodBeat.o(138997);
      return;
    }
    this.cvm = true;
    this.cuX.a(new com.tencent.mm.plugin.appbrand.jsapi.video.e.b.e()
    {
      public final boolean cb(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(220487);
        c localc = c.this;
        boolean bool = localc.k(new c.4(localc, paramAnonymousInt1, paramAnonymousInt2));
        AppMethodBeat.o(220487);
        return bool;
      }
    });
    this.cuX.a(new b.d()
    {
      public final boolean cc(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(220488);
        boolean bool = c.this.ca(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(220488);
        return bool;
      }
    });
    this.cuX.a(new com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f()
    {
      public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramAnonymousb)
      {
        AppMethodBeat.i(220489);
        paramAnonymousb = c.this;
        paramAnonymousb.k(new c.2(paramAnonymousb));
        AppMethodBeat.o(220489);
      }
    });
    this.cuX.a(new b.b()
    {
      public final void GH()
      {
        AppMethodBeat.i(220490);
        c localc = c.this;
        localc.k(new c.39(localc));
        AppMethodBeat.o(220490);
      }
    });
    this.cuX.a(new b.g()
    {
      public final void b(com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramAnonymousb)
      {
        AppMethodBeat.i(220491);
        paramAnonymousb = c.this;
        paramAnonymousb.k(new c.38(paramAnonymousb));
        AppMethodBeat.o(220491);
      }
    });
    this.cuX.a(new b.h()
    {
      public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramAnonymousb, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(220492);
        paramAnonymousb = c.this;
        paramAnonymousb.k(new c.37(paramAnonymousb, paramAnonymousInt1, paramAnonymousInt2));
        AppMethodBeat.o(220492);
      }
    });
    this.cuX.a(new b.a()
    {
      public final void gN(int paramAnonymousInt)
      {
        AppMethodBeat.i(220493);
        c localc = c.this;
        localc.k(new c.36(localc, paramAnonymousInt));
        AppMethodBeat.o(220493);
      }
    });
    if (this.cvD != null) {
      this.cvD.bG(this.cvl);
    }
    AppMethodBeat.o(138997);
  }
  
  final void release()
  {
    AppMethodBeat.i(220516);
    ae.i(getLogTag(), "video release");
    if (this.cvd != null) {
      this.cvd.w(this.cso);
    }
    GB();
    GC();
    if (this.cuY != null)
    {
      this.cuY.destroy();
      this.cuY = null;
      this.cuZ = null;
    }
    if (this.cve != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.ad.e.b localb = this.cve;
      localb.bqx().destroy();
      localb.lDe = false;
      localb.gW(false);
      localb.bqx().bqG();
      this.cve = null;
    }
    GE();
    if (this.cso != null)
    {
      this.cso.FL();
      this.csp = null;
    }
    ae.i(getLogTag(), "video release handler thread");
    if (this.cvx != null) {
      this.cvx.removeCallbacksAndMessages(null);
    }
    if (this.cvy != null) {
      this.cvy.quitSafely();
    }
    AppMethodBeat.o(220516);
  }
  
  public final void s(Bitmap paramBitmap)
  {
    AppMethodBeat.i(178848);
    super.s(paramBitmap);
    ae.i(getLogTag(), "*** handler(%s) handlePluginScreenshotTaken", new Object[] { BN() });
    Object localObject = this.cvz;
    int i;
    if (localObject == null)
    {
      ae.w(getLogTag(), "handlePluginScreenshotTaken4JsApiCall, invokeContext is null");
      i = 0;
    }
    for (;;)
    {
      if (i == 0)
      {
        localObject = this.csQ;
        if (localObject == null)
        {
          ae.w(getLogTag(), "handlePluginScreenshotTaken4NativeCall, getSnapshotCallback is null");
          AppMethodBeat.o(178848);
          return;
          if (paramBitmap == null)
          {
            ae.w(getLogTag(), "handlePluginScreenshotTaken4JsApiCall, bitmap is null");
            i = 0;
            continue;
          }
          if ((this.csq == 0) || (this.csr == 0)) {
            break label265;
          }
        }
      }
    }
    label265:
    for (Bitmap localBitmap = Bitmap.createScaledBitmap(paramBitmap, (int)(this.cvF * this.csq), (int)(this.cvG * this.csr), false);; localBitmap = paramBitmap)
    {
      this.cvd.a((com.tencent.luggage.xweb_ext.extendplugin.a)localObject, localBitmap);
      this.cvz = null;
      i = 1;
      break;
      if (paramBitmap == null)
      {
        ae.w(getLogTag(), "handlePluginScreenshotTaken4NativeCall, bitmap is null");
        ((com.tencent.luggage.xweb_ext.extendplugin.component.g)localObject).p(null);
        AppMethodBeat.o(178848);
        return;
      }
      localBitmap = paramBitmap;
      if (this.csq != 0)
      {
        localBitmap = paramBitmap;
        if (this.csr != 0) {
          localBitmap = Bitmap.createScaledBitmap(paramBitmap, (int)(this.cvF * this.csq), (int)(this.cvG * this.csr), false);
        }
      }
      ((com.tencent.luggage.xweb_ext.extendplugin.component.g)localObject).p(localBitmap);
      this.csQ = null;
      AppMethodBeat.o(178848);
      return;
    }
  }
  
  final boolean s(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(220522);
    ae.d(getLogTag(), "disableBackgroundPlayAudio");
    ae.d(getLogTag(), "disableBackgroundPlayAudioInternal");
    int i;
    if (parama == null)
    {
      ae.w(getLogTag(), "disableBackgroundPlayAudioInternal, invokeContext is null");
      i = 0;
    }
    while (i != 0)
    {
      this.csO.set(false);
      ae.d(getLogTag(), "disableBackgroundPlayAudio, hasEndedPlaying: %b, videoLooping: %b", new Object[] { Boolean.valueOf(this.cvt), Boolean.valueOf(this.cvn) });
      if ((this.cuX != null) && ((!this.cvt) || (this.cvn))) {
        this.cuX.setSurface(this.mSurface);
      }
      this.csM = false;
      if (this.cuY != null) {
        this.cuY.bL(false);
      }
      AppMethodBeat.o(220522);
      return true;
      parama = com.tencent.luggage.xweb_ext.extendplugin.component.e.f(parama);
      if (parama == null)
      {
        ae.w(getLogTag(), "disableBackgroundPlayAudio, audioOfVideoBackgroundPlayManager is null");
        i = 0;
      }
      else
      {
        parama.c(this);
        i = 1;
      }
    }
    AppMethodBeat.o(220522);
    return false;
  }
  
  final void seek(long paramLong)
  {
    AppMethodBeat.i(138992);
    if ((this.cvl) && (this.cuX != null))
    {
      if (Gj()) {
        this.cuY.onVideoWaiting();
      }
      if (this.cuX != null)
      {
        this.cvg = isPlaying();
        paramLong = Math.min(getDuration(), Math.max(0L, paramLong));
        ae.i(getLogTag(), "seek, position:%s, isPlaying:%s, videoEndPlaying:%s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(this.cvg), Boolean.valueOf(this.cvt) });
        this.cvt = false;
        this.cuX.seekTo(paramLong);
        AppMethodBeat.o(138992);
      }
    }
    else
    {
      this.cvj = paramLong;
    }
    AppMethodBeat.o(138992);
  }
  
  final void takeScreenshot()
  {
    AppMethodBeat.i(220517);
    ae.i(getLogTag(), "takeScreenshot");
    com.tencent.luggage.xweb_ext.extendplugin.d.a(GQ(), this.type, getId());
    AppMethodBeat.o(220517);
  }
  
  public static abstract interface b
  {
    public abstract void bG(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.c
 * JD-Core Version:    0.7.0.1
 */