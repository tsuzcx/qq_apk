package com.tencent.mm.plugin.appbrand.jsapi.al;

import android.util.ArrayMap;
import com.tencent.luggage.xweb_ext.extendplugin.component.l;
import com.tencent.luggage.xweb_ext.extendplugin.component.m;
import com.tencent.luggage.xweb_ext.extendplugin.component.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.h;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class a
  extends com.tencent.mm.plugin.appbrand.backgroundrunning.i
{
  private final String mAppId;
  private final AppBrandRuntime qwG;
  public AtomicBoolean sOA;
  public final c sOp;
  private volatile boolean sOq;
  public volatile a sOr;
  private volatile boolean sOs;
  private volatile com.tencent.luggage.xweb_ext.extendplugin.component.i sOt;
  private final Object sOu;
  private final Map<com.tencent.luggage.xweb_ext.extendplugin.component.i, Boolean> sOv;
  private final List<com.tencent.luggage.xweb_ext.extendplugin.component.i> sOw;
  private final List<com.tencent.luggage.xweb_ext.extendplugin.component.i> sOx;
  private final LinkedList<com.tencent.luggage.xweb_ext.extendplugin.component.i> sOy;
  public AtomicBoolean sOz;
  
  public a(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(326997);
    this.sOr = null;
    this.sOs = true;
    this.sOt = null;
    this.sOu = new Object();
    this.sOv = new ArrayMap();
    this.sOw = new ArrayList();
    this.sOx = new ArrayList();
    this.sOy = new LinkedList();
    this.sOz = new AtomicBoolean(false);
    this.sOA = new AtomicBoolean(false);
    this.qwG = paramAppBrandRuntime;
    this.mAppId = paramAppBrandRuntime.mAppId;
    this.sOp = new c(this);
    if (!paramAppBrandRuntime.mResumed) {}
    for (;;)
    {
      this.sOq = bool;
      k.a(this.mAppId, new k.c()
      {
        public final void a(k.d paramAnonymousd)
        {
          AppMethodBeat.i(326996);
          super.a(paramAnonymousd);
          Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onPause, type: ".concat(String.valueOf(paramAnonymousd)));
          a.this.c(paramAnonymousd);
          AppMethodBeat.o(326996);
        }
        
        public final void onCreate()
        {
          AppMethodBeat.i(326986);
          super.onCreate();
          Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onCreate");
          a.a(a.this);
          AppMethodBeat.o(326986);
        }
        
        public final void onDestroy()
        {
          AppMethodBeat.i(326999);
          super.onDestroy();
          Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onDestroy");
          a.this.cyE();
          AppMethodBeat.o(326999);
        }
        
        public final void onResume()
        {
          AppMethodBeat.i(326993);
          super.onResume();
          Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onResume");
          a.b(a.this);
          AppMethodBeat.o(326993);
        }
      });
      AppMethodBeat.o(326997);
      return;
      bool = false;
    }
  }
  
  private void cyD()
  {
    AppMethodBeat.i(327019);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "enableAppBrandBackgroundRun");
    com.tencent.mm.plugin.appbrand.jsapi.al.c.a locala = new com.tencent.mm.plugin.appbrand.jsapi.al.c.a();
    locala.sPs.appId = this.mAppId;
    locala.sPs.cIi = 8;
    locala.sPs.hAf = 1;
    locala.publish();
    AppMethodBeat.o(327019);
  }
  
  private String cyF()
  {
    AppMethodBeat.i(327030);
    Object localObject = (com.tencent.mm.plugin.appbrand.jsapi.al.c.b.c)this.qwG.aO(com.tencent.mm.plugin.appbrand.jsapi.al.c.b.c.class);
    if (localObject == null)
    {
      Log.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getBanBackgroundRunHint, helper is null");
      AppMethodBeat.o(327030);
      return null;
    }
    localObject = ((com.tencent.mm.plugin.appbrand.jsapi.al.c.b.c)localObject).cP(this.qwG.mAppId, this.qwG.qsh.eul);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getBanBackgroundRunHint, banHint: ", new Object[] { localObject });
    AppMethodBeat.o(327030);
    return localObject;
  }
  
  private void g(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    AppMethodBeat.i(327002);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "playAudio, videoPlayer:" + parami.getName());
    m localm = (m)parami.ah(m.class);
    if (localm == null)
    {
      Log.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "playAudio, videoPlayerAddOnPlayAudio is null");
      AppMethodBeat.o(327002);
      return;
    }
    localm.playAudio();
    d(parami);
    AppMethodBeat.o(327002);
  }
  
  private void h(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    AppMethodBeat.i(327006);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "playVideo, videoPlayer:" + parami.getName());
    m localm = (m)parami.ah(m.class);
    if (localm == null)
    {
      Log.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "playVideo, videoPlayerAddOnPlayAudio is null");
      AppMethodBeat.o(327006);
      return;
    }
    localm.atK();
    d(parami);
    AppMethodBeat.o(327006);
  }
  
  private static boolean i(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    AppMethodBeat.i(327009);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "startPlay, videoPlayer:" + parami.getName());
    parami = (n)parami.ah(n.class);
    if (parami == null)
    {
      Log.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "startPlay, playerAddOnVideoController is null");
      AppMethodBeat.o(327009);
      return false;
    }
    parami.start();
    AppMethodBeat.o(327009);
    return true;
  }
  
  private static boolean j(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    AppMethodBeat.i(327011);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "pausePlay, videoPlayer:" + parami.getName());
    parami = (n)parami.ah(n.class);
    if (parami == null)
    {
      Log.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "pausePlay, playerAddOnVideoController is null");
      AppMethodBeat.o(327011);
      return false;
    }
    parami.pause();
    AppMethodBeat.o(327011);
    return true;
  }
  
  private static String k(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    AppMethodBeat.i(327013);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getTitle, videoPlayer:" + parami.getName());
    parami = (l)parami.ah(l.class);
    if (parami == null)
    {
      Log.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getTitle, playerAddOnInfo is null");
      AppMethodBeat.o(327013);
      return null;
    }
    parami = parami.getTitle();
    AppMethodBeat.o(327013);
    return parami;
  }
  
  private static String l(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    AppMethodBeat.i(327015);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getPosterPath, videoPlayer:" + parami.getName());
    parami = (l)parami.ah(l.class);
    if (parami == null)
    {
      Log.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getPosterPath, playerAddOnInfo is null");
      AppMethodBeat.o(327015);
      return null;
    }
    parami = parami.atJ();
    AppMethodBeat.o(327015);
    return parami;
  }
  
  private boolean m(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    AppMethodBeat.i(327025);
    synchronized (this.sOu)
    {
      parami = (Boolean)this.sOv.get(parami);
      if ((parami != null) && (parami.booleanValue()))
      {
        AppMethodBeat.o(327025);
        return true;
      }
    }
    AppMethodBeat.o(327025);
    return false;
  }
  
  public final boolean a(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    boolean bool2 = false;
    AppMethodBeat.i(327057);
    ??? = k.Uo(this.mAppId);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "amIBackgroundAudioPlayer, videoPlayer: " + parami.getName() + ", pauseType: " + ???);
    for (;;)
    {
      synchronized (this.sOu)
      {
        boolean bool1;
        if ((!this.sOy.isEmpty()) && (parami == this.sOy.getFirst()))
        {
          bool1 = true;
          if ((bool1) && (this.sOA.getAndSet(false)))
          {
            Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "amIBackgroundAudioPlayer, ignore");
            bool1 = bool2;
            Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "amIBackgroundAudioPlayer, amIBackgroundAudioPlayer: ".concat(String.valueOf(bool1)));
            AppMethodBeat.o(327057);
            return bool1;
          }
        }
        else
        {
          bool1 = false;
        }
      }
    }
  }
  
  public final boolean b(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    int i = 0;
    AppMethodBeat.i(327074);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "enableBackgroundPlayAudio, videoPlayer: %s, playAudioImmediate: %b", new Object[] { parami.getName(), Boolean.TRUE });
    if (this.sOq)
    {
      Log.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "enableBackgroundPlayAudio, current is in background");
      AppMethodBeat.o(327074);
      return false;
    }
    synchronized (this.sOu)
    {
      this.sOv.put(parami, Boolean.TRUE);
      if (this.sOx.contains(parami))
      {
        this.sOx.remove(parami);
        this.sOy.remove(parami);
        this.sOy.addFirst(parami);
        i = 1;
        if (i != 0) {
          g(parami);
        }
        AppMethodBeat.o(327074);
        return true;
      }
      this.sOw.remove(parami);
      this.sOw.add(parami);
    }
  }
  
  public final void c(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    AppMethodBeat.i(327077);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "disableBackgroundPlayAudio, videoPlayer:" + parami.getName());
    synchronized (this.sOu)
    {
      this.sOv.remove(parami);
      com.tencent.luggage.xweb_ext.extendplugin.component.i locali = cyw();
      if ((this.sOy.contains(parami)) || (locali == parami))
      {
        this.sOy.remove(parami);
        if (locali == parami) {
          i = 0;
        }
        for (j = 1;; j = 0)
        {
          if (j != 0)
          {
            cyC();
            cyE();
            this.sOp.cyG();
            this.sOt = null;
          }
          if (i != 0) {
            h(parami);
          }
          AppMethodBeat.o(327077);
          return;
          i = 1;
        }
      }
      this.sOw.remove(parami);
      int i = 0;
      int j = 0;
    }
  }
  
  public final void c(k.d arg1)
  {
    AppMethodBeat.i(327104);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onRuntimeBackground, pauseType: ".concat(String.valueOf(???)));
    this.sOq = true;
    ??? = cyw();
    if (??? != null)
    {
      Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onRuntimeBackground, backgroundAudioPlayer: " + ???.getName());
      AppMethodBeat.o(327104);
      return;
    }
    synchronized (this.sOu)
    {
      com.tencent.luggage.xweb_ext.extendplugin.component.i locali1;
      if (!this.sOy.isEmpty())
      {
        locali1 = (com.tencent.luggage.xweb_ext.extendplugin.component.i)this.sOy.getFirst();
        if (locali1 != null) {}
      }
      else
      {
        Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onRuntimeBackground, backgroundAudioPlayer is null");
        AppMethodBeat.o(327104);
        return;
      }
      this.sOt = locali1;
      ??? = cyF();
      if (!Util.isNullOrNil(???))
      {
        Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onRuntimeBackground, ban");
        cyC();
        h.ahAA.bk(new a.2(this, ???));
        AppMethodBeat.o(327104);
        return;
      }
    }
    this.sOp.requestFocus();
    this.sOs = false;
    g(locali2);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onRuntimeBackground, enableAppBrandBackgroundRun");
    cyD();
    AppMethodBeat.o(327104);
  }
  
  public final boolean cjR()
  {
    AppMethodBeat.i(327052);
    synchronized (this.sOu)
    {
      if (!this.sOy.isEmpty())
      {
        bool = true;
        AppMethodBeat.o(327052);
        return bool;
      }
      boolean bool = false;
    }
  }
  
  public final void cyA()
  {
    AppMethodBeat.i(327088);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "startBackgroundAudioPlay");
    Object localObject = cyw();
    if (localObject == null)
    {
      Log.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "startBackgroundAudioPlay, backgroundAudioPlayer is null");
      AppMethodBeat.o(327088);
      return;
    }
    if (i((com.tencent.luggage.xweb_ext.extendplugin.component.i)localObject))
    {
      this.sOs = false;
      this.sOp.requestFocus();
      localObject = this.sOr;
      if (localObject != null) {
        ((a)localObject).cjK();
      }
    }
    AppMethodBeat.o(327088);
  }
  
  public final void cyB()
  {
    AppMethodBeat.i(327091);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "pauseBackgroundAudioPlay");
    Object localObject = cyw();
    if (localObject == null)
    {
      Log.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "pauseBackgroundAudioPlay, mBackgroundAudioPlayer is null");
      AppMethodBeat.o(327091);
      return;
    }
    if (j((com.tencent.luggage.xweb_ext.extendplugin.component.i)localObject))
    {
      this.sOs = true;
      localObject = this.sOr;
      if (localObject != null) {
        ((a)localObject).cjL();
      }
    }
    AppMethodBeat.o(327091);
  }
  
  public final void cyC()
  {
    AppMethodBeat.i(327097);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "stopBackgroundAudioPlay");
    com.tencent.luggage.xweb_ext.extendplugin.component.i locali = cyw();
    if (locali == null)
    {
      Log.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "stopBackgroundAudioPlay, backgroundAudioPlayer is null");
      AppMethodBeat.o(327097);
      return;
    }
    if (j(locali))
    {
      this.sOs = false;
      this.sOp.cyG();
    }
    AppMethodBeat.o(327097);
  }
  
  public final void cyE()
  {
    AppMethodBeat.i(327110);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "disableAppBrandBackgroundRun");
    com.tencent.mm.plugin.appbrand.jsapi.al.c.a locala = new com.tencent.mm.plugin.appbrand.jsapi.al.c.a();
    locala.sPs.appId = this.mAppId;
    locala.sPs.cIi = 8;
    locala.sPs.hAf = 2;
    locala.publish();
    AppMethodBeat.o(327110);
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.i cyw()
  {
    AppMethodBeat.i(327060);
    com.tencent.luggage.xweb_ext.extendplugin.component.i locali2 = this.sOt;
    com.tencent.luggage.xweb_ext.extendplugin.component.i locali1 = locali2;
    if (locali2 != null)
    {
      locali1 = locali2;
      if (this.sOA.get())
      {
        Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getBackgroundAudioPlayer, ignore");
        locali1 = null;
      }
    }
    AppMethodBeat.o(327060);
    return locali1;
  }
  
  public final String cyx()
  {
    AppMethodBeat.i(327065);
    Object localObject = cyw();
    if (localObject == null)
    {
      AppMethodBeat.o(327065);
      return null;
    }
    localObject = k((com.tencent.luggage.xweb_ext.extendplugin.component.i)localObject);
    AppMethodBeat.o(327065);
    return localObject;
  }
  
  public final String cyy()
  {
    AppMethodBeat.i(327068);
    Object localObject = cyw();
    if (localObject == null)
    {
      AppMethodBeat.o(327068);
      return null;
    }
    localObject = l((com.tencent.luggage.xweb_ext.extendplugin.component.i)localObject);
    AppMethodBeat.o(327068);
    return localObject;
  }
  
  public final boolean cyz()
  {
    AppMethodBeat.i(327070);
    Log.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "isBackgroundAudioPlayPaused: " + this.sOs);
    boolean bool = this.sOs;
    AppMethodBeat.o(327070);
    return bool;
  }
  
  public final void d(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    AppMethodBeat.i(327080);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "markVideoPlayStart, videoPlayer:" + parami.getName());
    int i = 0;
    synchronized (this.sOu)
    {
      if (this.sOw.contains(parami))
      {
        this.sOw.remove(parami);
        i = 1;
        this.sOy.remove(parami);
        this.sOy.addFirst(parami);
        if ((i != 0) && (m(parami))) {
          g(parami);
        }
        if ((this.sOq) && (cyw() != null)) {
          cyD();
        }
        AppMethodBeat.o(327080);
        return;
      }
      this.sOx.remove(parami);
      this.sOx.add(parami);
    }
  }
  
  public final void e(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    AppMethodBeat.i(327083);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "markVideoPlayPauseOrStop, videoPlayer:" + parami.getName());
    synchronized (this.sOu)
    {
      if (this.sOy.contains(parami))
      {
        this.sOy.remove(parami);
        this.sOw.add(parami);
        if (cyw() == parami)
        {
          Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "markVideoPlayPauseOrStop, disableAppBrandBackgroundRun");
          cyE();
          if (!this.sOs)
          {
            this.sOp.cyG();
            this.sOt = null;
          }
        }
        AppMethodBeat.o(327083);
        return;
      }
      this.sOx.remove(parami);
    }
  }
  
  public final void f(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    AppMethodBeat.i(327087);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "markVideoPlayerRelease, videoPlayer:" + parami.getName());
    synchronized (this.sOu)
    {
      this.sOw.remove(parami);
      this.sOx.remove(parami);
      this.sOy.remove(parami);
      if (cyw() == parami)
      {
        Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "markVideoPlayerRelease, disableAppBrandBackgroundRun");
        cyE();
        if (!this.sOs)
        {
          this.sOp.cyG();
          this.sOt = null;
        }
      }
      AppMethodBeat.o(327087);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void cjK();
    
    public abstract void cjL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al.a
 * JD-Core Version:    0.7.0.1
 */