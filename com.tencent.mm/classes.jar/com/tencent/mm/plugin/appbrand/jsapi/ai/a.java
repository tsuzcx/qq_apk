package com.tencent.mm.plugin.appbrand.jsapi.ai;

import android.util.ArrayMap;
import com.tencent.e.h;
import com.tencent.luggage.xweb_ext.extendplugin.component.l;
import com.tencent.luggage.xweb_ext.extendplugin.component.m;
import com.tencent.luggage.xweb_ext.extendplugin.component.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class a
  extends com.tencent.mm.plugin.appbrand.backgroundrunning.i
{
  private final String mAppId;
  private final AppBrandRuntime nxs;
  private volatile boolean pJA;
  private volatile com.tencent.luggage.xweb_ext.extendplugin.component.i pJB;
  private final Object pJC;
  private final Map<com.tencent.luggage.xweb_ext.extendplugin.component.i, Boolean> pJD;
  private final List<com.tencent.luggage.xweb_ext.extendplugin.component.i> pJE;
  private final List<com.tencent.luggage.xweb_ext.extendplugin.component.i> pJF;
  private final LinkedList<com.tencent.luggage.xweb_ext.extendplugin.component.i> pJG;
  public AtomicBoolean pJH;
  public AtomicBoolean pJI;
  public final c pJx;
  private volatile boolean pJy;
  public volatile a pJz;
  
  public a(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(227987);
    this.pJz = null;
    this.pJA = true;
    this.pJB = null;
    this.pJC = new Object();
    this.pJD = new ArrayMap();
    this.pJE = new ArrayList();
    this.pJF = new ArrayList();
    this.pJG = new LinkedList();
    this.pJH = new AtomicBoolean(false);
    this.pJI = new AtomicBoolean(false);
    this.nxs = paramAppBrandRuntime;
    this.mAppId = paramAppBrandRuntime.mAppId;
    this.pJx = new c(this);
    if (!paramAppBrandRuntime.mResumed) {}
    for (;;)
    {
      this.pJy = bool;
      k.a(this.mAppId, new k.c()
      {
        public final void a(k.d paramAnonymousd)
        {
          AppMethodBeat.i(227555);
          super.a(paramAnonymousd);
          Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onPause, type: ".concat(String.valueOf(paramAnonymousd)));
          a.this.c(paramAnonymousd);
          AppMethodBeat.o(227555);
        }
        
        public final void onCreate()
        {
          AppMethodBeat.i(227553);
          super.onCreate();
          Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onCreate");
          a.a(a.this);
          AppMethodBeat.o(227553);
        }
        
        public final void onDestroy()
        {
          AppMethodBeat.i(227557);
          super.onDestroy();
          Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onDestroy");
          a.this.bYo();
          AppMethodBeat.o(227557);
        }
        
        public final void onResume()
        {
          AppMethodBeat.i(227554);
          super.onResume();
          Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onResume");
          a.b(a.this);
          AppMethodBeat.o(227554);
        }
      });
      AppMethodBeat.o(227987);
      return;
      bool = false;
    }
  }
  
  private void bYn()
  {
    AppMethodBeat.i(228079);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "enableAppBrandBackgroundRun");
    com.tencent.mm.plugin.appbrand.jsapi.ai.c.a locala = new com.tencent.mm.plugin.appbrand.jsapi.ai.c.a();
    locala.pKz.appId = this.mAppId;
    locala.pKz.aOm = 8;
    locala.pKz.fvK = 1;
    EventCenter.instance.publish(locala);
    AppMethodBeat.o(228079);
  }
  
  private String bYp()
  {
    AppMethodBeat.i(228090);
    Object localObject = (com.tencent.mm.plugin.appbrand.jsapi.ai.c.b.c)this.nxs.av(com.tencent.mm.plugin.appbrand.jsapi.ai.c.b.c.class);
    if (localObject == null)
    {
      Log.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getBanBackgroundRunHint, helper is null");
      AppMethodBeat.o(228090);
      return null;
    }
    localObject = ((com.tencent.mm.plugin.appbrand.jsapi.ai.c.b.c)localObject).cp(this.nxs.mAppId, this.nxs.ntz.cBI);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getBanBackgroundRunHint, banHint: ", new Object[] { localObject });
    AppMethodBeat.o(228090);
    return localObject;
  }
  
  private void g(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    AppMethodBeat.i(228058);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "playAudio, videoPlayer:" + parami.getName());
    m localm = (m)parami.X(m.class);
    if (localm == null)
    {
      Log.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "playAudio, videoPlayerAddOnPlayAudio is null");
      AppMethodBeat.o(228058);
      return;
    }
    localm.playAudio();
    d(parami);
    AppMethodBeat.o(228058);
  }
  
  private void h(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    AppMethodBeat.i(228061);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "playVideo, videoPlayer:" + parami.getName());
    m localm = (m)parami.X(m.class);
    if (localm == null)
    {
      Log.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "playVideo, videoPlayerAddOnPlayAudio is null");
      AppMethodBeat.o(228061);
      return;
    }
    localm.Tf();
    d(parami);
    AppMethodBeat.o(228061);
  }
  
  private static boolean i(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    AppMethodBeat.i(228065);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "startPlay, videoPlayer:" + parami.getName());
    parami = (n)parami.X(n.class);
    if (parami == null)
    {
      Log.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "startPlay, playerAddOnVideoController is null");
      AppMethodBeat.o(228065);
      return false;
    }
    parami.start();
    AppMethodBeat.o(228065);
    return true;
  }
  
  private static boolean j(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    AppMethodBeat.i(228072);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "pausePlay, videoPlayer:" + parami.getName());
    parami = (n)parami.X(n.class);
    if (parami == null)
    {
      Log.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "pausePlay, playerAddOnVideoController is null");
      AppMethodBeat.o(228072);
      return false;
    }
    parami.pause();
    AppMethodBeat.o(228072);
    return true;
  }
  
  private static String k(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    AppMethodBeat.i(228074);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getTitle, videoPlayer:" + parami.getName());
    parami = (l)parami.X(l.class);
    if (parami == null)
    {
      Log.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getTitle, playerAddOnInfo is null");
      AppMethodBeat.o(228074);
      return null;
    }
    parami = parami.getTitle();
    AppMethodBeat.o(228074);
    return parami;
  }
  
  private static String l(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    AppMethodBeat.i(228076);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getPosterPath, videoPlayer:" + parami.getName());
    parami = (l)parami.X(l.class);
    if (parami == null)
    {
      Log.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getPosterPath, playerAddOnInfo is null");
      AppMethodBeat.o(228076);
      return null;
    }
    parami = parami.Te();
    AppMethodBeat.o(228076);
    return parami;
  }
  
  private boolean m(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    AppMethodBeat.i(228086);
    synchronized (this.pJC)
    {
      parami = (Boolean)this.pJD.get(parami);
      if ((parami != null) && (parami.booleanValue()))
      {
        AppMethodBeat.o(228086);
        return true;
      }
    }
    AppMethodBeat.o(228086);
    return false;
  }
  
  public final boolean a(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    boolean bool2 = false;
    AppMethodBeat.i(228001);
    ??? = k.abM(this.mAppId);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "amIBackgroundAudioPlayer, videoPlayer: " + parami.getName() + ", pauseType: " + ???);
    for (;;)
    {
      synchronized (this.pJC)
      {
        boolean bool1;
        if ((!this.pJG.isEmpty()) && (parami == this.pJG.getFirst()))
        {
          bool1 = true;
          if ((bool1) && (this.pJI.getAndSet(false)))
          {
            Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "amIBackgroundAudioPlayer, ignore");
            bool1 = bool2;
            Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "amIBackgroundAudioPlayer, amIBackgroundAudioPlayer: ".concat(String.valueOf(bool1)));
            AppMethodBeat.o(228001);
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
    AppMethodBeat.i(228019);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "enableBackgroundPlayAudio, videoPlayer: %s, playAudioImmediate: %b", new Object[] { parami.getName(), Boolean.TRUE });
    if (this.pJy)
    {
      Log.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "enableBackgroundPlayAudio, current is in background");
      AppMethodBeat.o(228019);
      return false;
    }
    synchronized (this.pJC)
    {
      this.pJD.put(parami, Boolean.TRUE);
      if (this.pJF.contains(parami))
      {
        this.pJF.remove(parami);
        this.pJG.remove(parami);
        this.pJG.addFirst(parami);
        i = 1;
        if (i != 0) {
          g(parami);
        }
        AppMethodBeat.o(228019);
        return true;
      }
      this.pJE.remove(parami);
      this.pJE.add(parami);
    }
  }
  
  public final boolean bKr()
  {
    AppMethodBeat.i(227991);
    synchronized (this.pJC)
    {
      if (!this.pJG.isEmpty())
      {
        bool = true;
        AppMethodBeat.o(227991);
        return bool;
      }
      boolean bool = false;
    }
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.i bYg()
  {
    AppMethodBeat.i(228003);
    com.tencent.luggage.xweb_ext.extendplugin.component.i locali2 = this.pJB;
    com.tencent.luggage.xweb_ext.extendplugin.component.i locali1 = locali2;
    if (locali2 != null)
    {
      locali1 = locali2;
      if (this.pJI.get())
      {
        Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getBackgroundAudioPlayer, ignore");
        locali1 = null;
      }
    }
    AppMethodBeat.o(228003);
    return locali1;
  }
  
  public final String bYh()
  {
    AppMethodBeat.i(228005);
    Object localObject = bYg();
    if (localObject == null)
    {
      AppMethodBeat.o(228005);
      return null;
    }
    localObject = k((com.tencent.luggage.xweb_ext.extendplugin.component.i)localObject);
    AppMethodBeat.o(228005);
    return localObject;
  }
  
  public final String bYi()
  {
    AppMethodBeat.i(228010);
    Object localObject = bYg();
    if (localObject == null)
    {
      AppMethodBeat.o(228010);
      return null;
    }
    localObject = l((com.tencent.luggage.xweb_ext.extendplugin.component.i)localObject);
    AppMethodBeat.o(228010);
    return localObject;
  }
  
  public final boolean bYj()
  {
    AppMethodBeat.i(228012);
    Log.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "isBackgroundAudioPlayPaused: " + this.pJA);
    boolean bool = this.pJA;
    AppMethodBeat.o(228012);
    return bool;
  }
  
  public final void bYk()
  {
    AppMethodBeat.i(228043);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "startBackgroundAudioPlay");
    Object localObject = bYg();
    if (localObject == null)
    {
      Log.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "startBackgroundAudioPlay, backgroundAudioPlayer is null");
      AppMethodBeat.o(228043);
      return;
    }
    if (i((com.tencent.luggage.xweb_ext.extendplugin.component.i)localObject))
    {
      this.pJA = false;
      this.pJx.avy();
      localObject = this.pJz;
      if (localObject != null) {
        ((a)localObject).bKk();
      }
    }
    AppMethodBeat.o(228043);
  }
  
  public final void bYl()
  {
    AppMethodBeat.i(228047);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "pauseBackgroundAudioPlay");
    Object localObject = bYg();
    if (localObject == null)
    {
      Log.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "pauseBackgroundAudioPlay, mBackgroundAudioPlayer is null");
      AppMethodBeat.o(228047);
      return;
    }
    if (j((com.tencent.luggage.xweb_ext.extendplugin.component.i)localObject))
    {
      this.pJA = true;
      localObject = this.pJz;
      if (localObject != null) {
        ((a)localObject).bKl();
      }
    }
    AppMethodBeat.o(228047);
  }
  
  public final void bYm()
  {
    AppMethodBeat.i(228050);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "stopBackgroundAudioPlay");
    com.tencent.luggage.xweb_ext.extendplugin.component.i locali = bYg();
    if (locali == null)
    {
      Log.w("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "stopBackgroundAudioPlay, backgroundAudioPlayer is null");
      AppMethodBeat.o(228050);
      return;
    }
    if (j(locali))
    {
      this.pJA = false;
      this.pJx.bYq();
    }
    AppMethodBeat.o(228050);
  }
  
  public final void bYo()
  {
    AppMethodBeat.i(228083);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "disableAppBrandBackgroundRun");
    com.tencent.mm.plugin.appbrand.jsapi.ai.c.a locala = new com.tencent.mm.plugin.appbrand.jsapi.ai.c.a();
    locala.pKz.appId = this.mAppId;
    locala.pKz.aOm = 8;
    locala.pKz.fvK = 2;
    EventCenter.instance.publish(locala);
    AppMethodBeat.o(228083);
  }
  
  public final void c(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    AppMethodBeat.i(228026);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "disableBackgroundPlayAudio, videoPlayer:" + parami.getName());
    synchronized (this.pJC)
    {
      this.pJD.remove(parami);
      com.tencent.luggage.xweb_ext.extendplugin.component.i locali = bYg();
      if ((this.pJG.contains(parami)) || (locali == parami))
      {
        this.pJG.remove(parami);
        if (locali == parami) {
          i = 0;
        }
        for (j = 1;; j = 0)
        {
          if (j != 0)
          {
            bYm();
            bYo();
            this.pJx.bYq();
            this.pJB = null;
          }
          if (i != 0) {
            h(parami);
          }
          AppMethodBeat.o(228026);
          return;
          i = 1;
        }
      }
      this.pJE.remove(parami);
      int i = 0;
      int j = 0;
    }
  }
  
  public final void c(k.d arg1)
  {
    AppMethodBeat.i(228054);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onRuntimeBackground, pauseType: ".concat(String.valueOf(???)));
    this.pJy = true;
    ??? = bYg();
    if (??? != null)
    {
      Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onRuntimeBackground, backgroundAudioPlayer: " + ???.getName());
      AppMethodBeat.o(228054);
      return;
    }
    synchronized (this.pJC)
    {
      com.tencent.luggage.xweb_ext.extendplugin.component.i locali1;
      if (!this.pJG.isEmpty())
      {
        locali1 = (com.tencent.luggage.xweb_ext.extendplugin.component.i)this.pJG.getFirst();
        if (locali1 != null) {}
      }
      else
      {
        Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onRuntimeBackground, backgroundAudioPlayer is null");
        AppMethodBeat.o(228054);
        return;
      }
      this.pJB = locali1;
      ??? = bYp();
      if (!Util.isNullOrNil(???))
      {
        Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onRuntimeBackground, ban");
        bYm();
        h.ZvG.bc(new a.2(this, ???));
        AppMethodBeat.o(228054);
        return;
      }
    }
    this.pJx.avy();
    this.pJA = false;
    g(locali2);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onRuntimeBackground, enableAppBrandBackgroundRun");
    bYn();
    AppMethodBeat.o(228054);
  }
  
  public final void d(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    AppMethodBeat.i(228033);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "markVideoPlayStart, videoPlayer:" + parami.getName());
    int i = 0;
    synchronized (this.pJC)
    {
      if (this.pJE.contains(parami))
      {
        this.pJE.remove(parami);
        i = 1;
        this.pJG.remove(parami);
        this.pJG.addFirst(parami);
        if ((i != 0) && (m(parami))) {
          g(parami);
        }
        if ((this.pJy) && (bYg() != null)) {
          bYn();
        }
        AppMethodBeat.o(228033);
        return;
      }
      this.pJF.remove(parami);
      this.pJF.add(parami);
    }
  }
  
  public final void e(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    AppMethodBeat.i(228035);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "markVideoPlayPauseOrStop, videoPlayer:" + parami.getName());
    synchronized (this.pJC)
    {
      if (this.pJG.contains(parami))
      {
        this.pJG.remove(parami);
        this.pJE.add(parami);
        if (bYg() == parami)
        {
          Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "markVideoPlayPauseOrStop, disableAppBrandBackgroundRun");
          bYo();
          if (!this.pJA)
          {
            this.pJx.bYq();
            this.pJB = null;
          }
        }
        AppMethodBeat.o(228035);
        return;
      }
      this.pJF.remove(parami);
    }
  }
  
  public final void f(com.tencent.luggage.xweb_ext.extendplugin.component.i parami)
  {
    AppMethodBeat.i(228038);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "markVideoPlayerRelease, videoPlayer:" + parami.getName());
    synchronized (this.pJC)
    {
      this.pJE.remove(parami);
      this.pJF.remove(parami);
      this.pJG.remove(parami);
      if (bYg() == parami)
      {
        Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "markVideoPlayerRelease, disableAppBrandBackgroundRun");
        bYo();
        if (!this.pJA)
        {
          this.pJx.bYq();
          this.pJB = null;
        }
      }
      AppMethodBeat.o(228038);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void bKk();
    
    public abstract void bKl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ai.a
 * JD-Core Version:    0.7.0.1
 */